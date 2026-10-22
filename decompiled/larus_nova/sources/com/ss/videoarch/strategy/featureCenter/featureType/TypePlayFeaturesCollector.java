package com.ss.videoarch.strategy.featureCenter.featureType;

import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.BaseTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.ConfigTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.ConfigCacheInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import com.ss.videoarch.strategy.strategy.smartStrategy.PredictFirstPlayTime;
import com.ss.videoarch.strategy.strategy.smartStrategy.PredictShortTimeLeave;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TypePlayFeaturesCollector extends BaseTypeFeaturesCollector {
    static final String TAG = "PlayFeaturesCollector";
    private static volatile TypePlayFeaturesCollector sInstance;
    private final int AUDIO;
    private final String KEY_FEATURES_BUNDLE;
    private final int VIDEO;
    private JSONObject mCurCallerInfo;
    public JSONObject mDownloadSpeedInfo;
    private JSONObject mHistoryDuration;
    private JSONObject mHistoryFirstStartTime;
    public String mLastSessionId;
    private ReentrantLock mLock;
    private ReentrantReadWriteLock mReadWriteLock;
    public final Map<String, SessionCacheInfos> mSessionInfoMap;
    private JSONArray mTimerSerialFeaturesList;

    public void setPlaySessionInfo(JSONObject r100) {
    }

    public static TypePlayFeaturesCollector inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TypePlayFeaturesCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TypePlayFeaturesCollector();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TypePlayFeaturesCollector.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TypePlayFeaturesCollector() {
        this.mSessionInfoMap = new AnonymousClass1(this);
        this.mLastSessionId = "";
        this.mDownloadSpeedInfo = new JSONObject();
        this.mCurCallerInfo = null;
        this.mLock = new ReentrantLock();
        this.VIDEO = 0;
        this.AUDIO = 1;
        this.KEY_FEATURES_BUNDLE = "bundle";
        this.mReadWriteLock = new ReentrantReadWriteLock(false);
        this.mTimerSerialFeaturesList = new JSONArray();
        this.mHistoryFirstStartTime = new JSONObject();
        this.mHistoryDuration = null;
        this.mTypeKey = "TypePlayFeature";
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L5;
        r100.mFeatureTypeName = "TypePlayFeature";
    L5:
        this.mTimerSerialFeaturesList.put("PLAY-VideoBuffer").put("PLAY-AudioBuffer");
    }

    public void getTimerSerialInfo() {
        Iterator<Map.Entry<String, IAppInfoBundle>> r100 = LiveStrategyManager.inst().mListenerMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        Map.Entry<String, IAppInfoBundle> r101 = r100.next();
        String r102 = r101.getKey();
        IAppInfoBundle r103 = r101.getValue();
        if (r103 == null) goto L4;
        JSONObject r104 = new JSONObject();
        r103.getAppInfoForKey("bundle", new JSONObject().put("featuresBundleList", this.mTimerSerialFeaturesList).put("featuresData", r104));     // Catch: JSONException -> L11
        r104.put("PLAY-SessionID", r102);     // Catch: JSONException -> L11
    L13:
        setTimerSerialInfo(r104);
        r104.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public long harmonicMean(List<Long> r110) {
        if (r110 != null) goto L5;
        return 0;
    L5:
        if (r110.isEmpty() == true) goto L24;
        Iterator<Long> r100 = r110.iterator();
        long r101 = 0;
    L9:
        if (r100.hasNext() == false) goto L14;
        long r102 = r100.next().longValue();
        if (r102 == 0) goto L9;
        r101 = r101 + (1 / r102);
        goto L9
    L14:
        if (r101 > 0) goto L16;
        return 0;
    L16:
        return ((long) r110.size()) / r101;
    L24:
        return 0;
    }

    public void setCurCallerInfo(JSONObject r100) {
        this.mLock.lock();
        this.mCurCallerInfo = r100;
        this.mLock.unlock();
    }

    public void setTimerSerialInfo(JSONObject r100) {
        if (r100 == null) goto L46;
        String r101 = r100.optString("PLAY-SessionID", "");     // Catch: Exception -> L38
        if (r101.length() != 0) goto L6;
        return;
    L6:
        Map<String, SessionCacheInfos> r102 = this.mSessionInfoMap;     // Catch: Exception -> L38
        monitor-enter(r102);     // Catch: Exception -> L38
    L35:
        th = move-exception;
        throw th;     // Catch: Exception -> L38
    L9:
        if (this.mSessionInfoMap.containsKey(r101) == false) goto L11;
        SessionCacheInfos r103 = this.mSessionInfoMap.get(r101);     // Catch: Throwable -> L35
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L35
    L14:
        r103.isValid = true;     // Catch: Exception -> L38
        long r104 = -1;
        if (r100.has("PLAY-VideoBuffer") == false) goto L17;
        long r105 = r100.optLong("PLAY-VideoBuffer");     // Catch: Exception -> L38
    L19:
        if (r100.has("PLAY-AudioBuffer") == false) goto L21;
        r104 = r100.optLong("PLAY-AudioBuffer");     // Catch: Exception -> L38
    L21:
        r103.mVideoBuffer = r105;     // Catch: Exception -> L38
        r103.mAudioBuffer = r104;     // Catch: Exception -> L38
        r103.mVideoBufferList.add(Long.valueOf(r105));     // Catch: Exception -> L38
        if (r103.mVideoBufferList.size() <= 200) goto L24;
        r103.mVideoBufferList.remove();     // Catch: Exception -> L38
    L24:
        r103.mAudioBufferList.add(Long.valueOf(r104));     // Catch: Exception -> L38
        if (r103.mAudioBufferList.size() <= 200) goto L27;
        r103.mAudioBufferList.remove();     // Catch: Exception -> L38
    L27:
        Map<String, SessionCacheInfos> r106 = this.mSessionInfoMap;     // Catch: Exception -> L38
        monitor-enter(r106);     // Catch: Exception -> L38
        this.mSessionInfoMap.put(r101, r103);     // Catch: Throwable -> L32
        monitor-exit(r106);     // Catch: Throwable -> L32
    L47:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L38
    L17:
        r105 = -1;
        goto L19
    L11:
        r103 = new SessionCacheInfos();     // Catch: Throwable -> L35
        r103.mSessionId = r101;     // Catch: Throwable -> L35
    L38:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public <T> T getCallerInfo(String r100, T r101) {
        this.mLock.lock();
        if (this.mCurCallerInfo == null) goto L49;
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -818786127: goto L20;
            case 855771538: goto L16;
            case 970568508: goto L12;
            case 1182125491: goto L8;
            default: goto L23;
        };
    L23:
        switch(r102) {
            case 0: goto L44;
            case 1: goto L38;
            case 2: goto L26;
            case 3: goto L32;
            default: goto L49;
        };
    L26:
        if (r101.getClass() != String.class) goto L32;
        if (this.mCurCallerInfo.has("neptuneName") == false) goto L32;
        T r103 = (T) this.mCurCallerInfo.optString("neptuneName");
        this.mLock.unlock();
        return r103;
    L32:
        if (r101.getClass() != Integer.class) goto L38;
        if (this.mCurCallerInfo.has(VrBgLogData.KEY_IS_PREVIEW) == false) goto L38;
        int r104 = this.mCurCallerInfo.optInt(VrBgLogData.KEY_IS_PREVIEW);
        this.mLock.unlock();
        return (T) Integer.valueOf(r104);
    L38:
        if (r101.getClass() != String.class) goto L44;
        if (this.mCurCallerInfo.has("stream_session_vv_id") == false) goto L44;
        T r105 = (T) this.mCurCallerInfo.optString("stream_session_vv_id");
        this.mLock.unlock();
        return r105;
    L44:
        if (r101.getClass() != String.class) goto L49;
        if (this.mCurCallerInfo.has("enter_from") == false) goto L49;
        T r106 = (T) this.mCurCallerInfo.optString("enter_from");
        this.mLock.unlock();
        return r106;
    L8:
        if (r100.equals(VrBgLogData.KEY_IS_PREVIEW) == false) goto L23;
        r102 = 3;
        goto L23
    L12:
        if (r100.equals("neptuneName") == false) goto L23;
        r102 = 2;
        goto L23
    L16:
        if (r100.equals("stream_session_vv_id") == false) goto L23;
        r102 = 1;
        goto L23
    L20:
        if (r100.equals("enter_from") == false) goto L23;
        r102 = 0;
    L49:
        this.mLock.unlock();
        return r101;
    }

    public void setEventCallBackInfo(int r110, JSONObject r111) {
        String r100 = r111.optString("PLAY-SessionID", "");
        if (r100.length() != 0) goto L5;
        return;
    L5:
        Map<String, SessionCacheInfos> r101 = this.mSessionInfoMap;
        monitor-enter(r101);
    L107:
        th = move-exception;
        throw th;
    L8:
        if (this.mSessionInfoMap.containsKey(r100) == true) goto L10;
        SessionCacheInfos r102 = new SessionCacheInfos();     // Catch: Throwable -> L107
        r102.mSessionId = r100;     // Catch: Throwable -> L107
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L107
        switch(r110) {
            case 60: goto L88;
            case 61: goto L87;
            case 62: goto L66;
            case 63: goto L20;
            default: goto L14;
        };
    L14:
        if (r102 != null) goto L16;
    L95:
        if (r102 != null) goto L97;
        return;
    L97:
        if (r102.isValid == false) goto L122;
        Map<String, SessionCacheInfos> r112 = this.mSessionInfoMap;
        monitor-enter(r112);
        this.mSessionInfoMap.put(r100, r102);     // Catch: Throwable -> L103
        monitor-exit(r112);     // Catch: Throwable -> L103
        return;
    L103:
        th = move-exception;
        throw th;
    L122:
        return;
    L16:
        if (r102.isValid == true) goto L95;
        Map<String, SessionCacheInfos> r113 = this.mSessionInfoMap;
        monitor-enter(r113);
        this.mSessionInfoMap.remove(r100);     // Catch: Throwable -> L92
        monitor-exit(r113);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        throw th;
    L20:
        r102.isValid = true;
        long r103 = System.currentTimeMillis();
        long r104 = r103 - r102.mStartTs;
        r102.mEndTs = System.currentTimeMillis();
        LiveStrategyManager.inst().mLastEndTS = r103;
        r102.mDuration = r103 - r102.mStartTs;
        PredictShortTimeLeave.inst().saveData(r104);
        if (this.mHistoryDuration == null) goto L29;
        int r114 = 9;
    L23:
        if (r114 <= 0) goto L25;
        this.mHistoryDuration.put(String.valueOf(r114), this.mHistoryDuration.optLong(String.valueOf(r114 - 1), -1));     // Catch: JSONException -> L27
        r114 = r114 - 1;     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L25:
        this.mHistoryDuration.put(String.valueOf(0), r104);     // Catch: JSONException -> L27
    L29:
        this.mLastSessionId = r100;
        String r115 = r111.optString("domain");
        r102.mRetryTotalCount = r111.optInt("retryTotalCount");
        r102.mDomain = r115;
        r102.mStopTimestamp = System.currentTimeMillis();
        int r105 = getNetWorkType(r111.optString("nqeInfo"));
        long r106 = r111.optLong("firstFrameDownloadSpeed");
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L42;
        if (LSSettings.inst().mPersistenceConfigInfo.mHisTableEnable != 1) goto L42;
        r102.mPlayTime = r111.optLong("playTime");
        r102.mNetwork = String.valueOf(r105);
        r102.mDownloadSpeed = r106;
        r102.mUpdate = BaseTableOperate.getCurrentTimeFormat();
        HistoryTableOperate.mSessionCacheInfosMap.put(r100, r102);
        if (HistoryTableOperate.mSessionCacheInfosMap.size() != LSSettings.inst().mPersistenceConfigInfo.mHisTableUpdateLimit) goto L40;
        ArrayList r116 = new ArrayList();
        Iterator<Map.Entry<String, SessionCacheInfos>> r107 = HistoryTableOperate.mSessionCacheInfosMap.entrySet().iterator();
    L37:
        if (r107.hasNext() == false) goto L39;
        r116.add(r107.next().getValue());
        goto L37
    L39:
        HistoryTableOperate.replaceAllRecord(r116);
        HistoryTableOperate.clearCacheData();
        TopNHostStrategy.inst().clearMDBHostCacheInfos();
        goto L42
    L40:
        HistoryTableOperate.addSPData(r102);
        TopNHostStrategy.inst().addDomainUsedCount(r115, 1);
    L42:
        if (LSSettings.inst().mEnableDataWarehouse != 1) goto L47;
        if (LSSettings.inst().mEnableMgrTopN != 1) goto L47;
        TopNHostStrategy.inst().addDomainUsedCount(r115, 1);
    L47:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableBandWidthAvg != 1) goto L53;
        JSONObject r117 = this.mDownloadSpeedInfo;
        if (r117 != null) goto L51;
    L116:
        JSONObject r118 = this.mDownloadSpeedInfo;     // Catch: JSONException -> L64
        if (r118 == null) goto L95;
        r118.put(String.valueOf(r105), r106);     // Catch: JSONException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
        goto L95
    L51:
        if (r117.has(String.valueOf(r105)) == false) goto L116;
        r106 = (this.mDownloadSpeedInfo.optLong(String.valueOf(r105)) + r106) / 2;
        goto L116
    L53:
        JSONObject r119 = this.mDownloadSpeedInfo;
        if (r119 == null) goto L116;
        if (r119.has(String.valueOf(r105)) == false) goto L116;
        if (this.mDownloadSpeedInfo.optLong(String.valueOf(r105)) < r106) goto L116;
        return;
    L66:
        r102.isValid = true;
        String r120 = r111.optString(LiveCommonConstants.LOG_PARAM_EVENT_KEY);
        if (r120.equals("stall") == false) goto L77;
        long r121 = r111.optLong("PLAY-StallTime");
        r102.mStallTime = r121;
        r102.mStallTotalTime += r121;
        r102.mStallTotalCount++;
        r102.mStallSeries.add(Long.valueOf(r121));
        int r122 = r102.mDoubleBufferDataSeconds;
        if (r122 <= 0) goto L74;
        if (r122 >= 1500) goto L74;
        r102.mDoubleBufferDataSeconds = r122 * 2;
    L74:
        if (r102.mStallSeries.size() <= 200) goto L95;
        r102.mStallSeries.remove();
        goto L95
    L77:
        if (r120.equals("render_stall") == false) goto L95;
        int r123 = r111.optInt("PLAY-StallType");
        r102.mStallType = r123;
        long r108 = r111.optLong("PLAY-StallTime");
        if (r123 != 0) goto L83;
        r102.mRenderVideoSeries.add(Long.valueOf(r108));
        if (r102.mRenderVideoSeries.size() <= 200) goto L95;
        r102.mRenderVideoSeries.remove();
        goto L95
    L83:
        if (r123 != 1) goto L95;
        r102.mRenderAudioSeries.add(Long.valueOf(r108));
        if (r102.mRenderAudioSeries.size() <= 200) goto L95;
        r102.mRenderAudioSeries.remove();
        goto L95
    L87:
        r102.isValid = true;
        r102.mFirstFrameVideoBuffer = r111.optInt("PLAY-FirstFrameVideoBuffer");
        r102.mFirstFrameAudioBuffer = r111.optInt("PLAY-FirstFrameAudioBuffer");
        r102.mFirstFrameDownloadSpeed = r111.optInt("PLAY-FirstFrameDownloadSpeed");
        r102.mProtocol = r111.optString("PLAY-Protocol");
        r102.mFirstFrame = r111.optInt("PLAY-FirstFrame");
        r102.mSuccess = r111.optInt("PLAY-Success");
        r102.m302 = r111.optInt("PLAY-302");
        r102.mConnectCost = r111.optInt("PLAY-ConnectCost");
        r102.mEnterMethod = r111.optString("PLAY-EnterMethod");
        r102.mEnterAction = r111.optString("PLAY-EnterAction");
        r102.mStreamSuffix = r111.optString("PLAY-StreamSuffix");
        r102.mNeptuneName = r111.optString("PLAY-NeptuneName");
        r102.mIsPreview = r111.optInt("PLAY-IsPreview");
        r102.mFPS = (float) r111.optDouble("PLAY-FPS");
        r102.mBufferDataSeconds = r111.optInt("PLAY-BufferDataSeconds");
        r102.mDoubleBufferDataSeconds = r111.optInt("PLAY-BufferDataSeconds");
        goto L95
    L88:
        r102.isValid = true;
        r102.mStartTs = System.currentTimeMillis();
        goto L95
    L10:
        r102 = this.mSessionInfoMap.get(r100);     // Catch: Throwable -> L107
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v27, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputFeatures(JSONObject r210, JSONArray r211, String r212, String r213, JSONObject r214) {
        String r100 = "";
        this.mReadWriteLock.readLock().lock();
        JSONObject r101 = this.mCurCallerInfo;
        this.mReadWriteLock.readLock().unlock();
        if (r101 == null) goto L5;
        r100 = r101.optString("stream_session_vv_id", "");
    L5:
        Map<String, SessionCacheInfos> r102 = this.mSessionInfoMap;
        monitor-enter(r102);
        Object r103 = null;
        if (r100.length() == 0) goto L10;
        SessionCacheInfos r104 = this.mSessionInfoMap.get(r100);     // Catch: Throwable -> L282
    L12:
        if (this.mLastSessionId.length() == 0) goto L14;
        SessionCacheInfos r105 = this.mSessionInfoMap.get(this.mLastSessionId);     // Catch: Throwable -> L282
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L282
        ?? r106 = 0;
        int r107 = 0;
    L18:
        if (r107 >= r211.length()) goto L281;
        String r108 = r211.optString(r107);
        if (r108 != null) goto L23;
    L21:
        SessionCacheInfos r215 = r105;
    L280:
        r107 = r107 + 1;
        r105 = r215;
        r103 = null;
        r106 = r106;
        goto L18
    L23:
        if (r108.contains("-Last") == false) goto L25;
        int r110 = r108.indexOf("-Last") + 5;
        SessionCacheInfos r111 = r105;
    L26:
        String r112 = r108.substring(r110);
        int r113 = -1;
        switch(r112.hashCode()) {
            case -2074248664: goto L130;
            case -1927368268: goto L127;
            case -1656530148: goto L124;
            case -1348421033: goto L121;
            case -1266030831: goto L118;
            case -1231353099: goto L115;
            case -903626825: goto L112;
            case -787991670: goto L109;
            case -747805892: goto L106;
            case -709528236: goto L103;
            case -589160937: goto L100;
            case -583022197: goto L97;
            case -304489875: goto L94;
            case -304474406: goto L91;
            case -232532383: goto L88;
            case -220125539: goto L85;
            case -202516509: goto L82;
            case 50549: goto L79;
            case 69833: goto L76;
            case 67098778: goto L73;
            case 84113122: goto L70;
            case 278230227: goto L67;
            case 568537785: goto L64;
            case 578971497: goto L61;
            case 888094667: goto L58;
            case 1106004766: goto L55;
            case 1169152926: goto L52;
            case 1193711374: goto L49;
            case 1539107257: goto L46;
            case 1809510589: goto L43;
            case 1830263953: goto L40;
            case 2003127059: goto L37;
            case 2131714852: goto L34;
            case 2139694009: goto L31;
            default: goto L132;
        };     // Catch: JSONException -> L277
    L132:
        byte r114 = -1;
    L133:
        switch(r114) {
            case 0: goto L269;
            case 1: goto L269;
            case 2: goto L269;
            case 3: goto L269;
            case 4: goto L269;
            case 5: goto L269;
            case 6: goto L269;
            case 7: goto L269;
            case 8: goto L269;
            case 9: goto L260;
            case 10: goto L260;
            case 11: goto L260;
            case 12: goto L260;
            case 13: goto L260;
            case 14: goto L260;
            case 15: goto L260;
            case 16: goto L260;
            case 17: goto L247;
            case 18: goto L239;
            case 19: goto L239;
            case 20: goto L239;
            case 21: goto L239;
            case 22: goto L230;
            case 23: goto L215;
            case 24: goto L215;
            case 25: goto L215;
            case 26: goto L215;
            case 27: goto L215;
            case 28: goto L198;
            case 29: goto L190;
            case 30: goto L178;
            case 31: goto L145;
            case 32: goto L317;
            case 33: goto L317;
            default: goto L21;
        };
    L178:
        r215 = r105;
        if (LSSettings.inst().mPersistenceConfigInfo.mConfigTableEnable != 1) goto L303;
        ConfigCacheInfo r109 = ConfigTableOperate.getSettingsConfigFromDB(PredictFirstPlayTime.inst().mStrategyName + "_data");     // Catch: JSONException -> L188
        if (r109 == null) goto L303;
        this.mHistoryFirstStartTime = new JSONObject(r109.mSettingsValue);     // Catch: JSONException -> L288
    L303:
        r210.put(r108, this.mHistoryFirstStartTime);     // Catch: Exception -> L185
    L206:
        r106 = 0;
        goto L280
    L185:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L188
    L188:
        e = e;
        r106 = 0;
    L279:
        e.printStackTrace();
        goto L280
    L190:
        r215 = r105;
        if (r111 != null) goto L305;
        r106 = 0;
        r210.put(r108, 0);     // Catch: JSONException -> L228
    L228:
        e = e;
        goto L279
    L305:
        r106 = r111.getValue("EstimatedBandwidth", 0);     // Catch: Exception -> L194
        r210.put(r108, r106);     // Catch: Exception -> L194
    L194:
        r106 = 0;
        r210.put(r108, 0);     // Catch: JSONException -> L228
        goto L280
    L198:
        r215 = r105;
        if (r214 == null) goto L202;
        int r115 = r214.optInt("net_effective_connection_type");     // Catch: JSONException -> L188
    L319:
        JSONObject r116 = this.mDownloadSpeedInfo;     // Catch: Exception -> L212
        if (r116 == null) goto L207;
        r210.put(r108, r116.optLong(String.valueOf(r115), 0));     // Catch: Exception -> L212
        goto L206
    L207:
        r106 = 0;
        r106 = 0;
        r210.put(r108, 0);     // Catch: Exception -> L210
    L210:
        e = e;
    L214:
        e.printStackTrace();     // Catch: JSONException -> L228
    L212:
        e = e;
        r106 = 0;
        goto L214
    L202:
        r115 = 0;
        goto L319
    L215:
        r215 = r105;
        JSONArray r117 = new JSONArray();     // Catch: JSONException -> L228
        if (r111 == null) goto L309;
        Iterator r118 = ((Queue) r111.getValue(r112, new ConcurrentLinkedQueue())).iterator();     // Catch: JSONException -> L228
    L219:
        if (r118.hasNext() == false) goto L309;
        r117.put(((Long) r118.next()).longValue());     // Catch: JSONException -> L228
    L309:
        r210.put(r108, r117);     // Catch: Exception -> L224
    L224:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L230:
        r215 = r105;
        if (r111 != null) goto L307;
        r210.put(r108, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Exception -> L236
        goto L280
    L307:
        r210.put(r108, r111.getValue(r112, Float.valueOf(0.0f)));     // Catch: Exception -> L236
    L236:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L239:
        r215 = r105;
        if (r111 != null) goto L311;
        r210.put(r108, "none");     // Catch: Exception -> L244
        goto L280
    L311:
        r210.put(r108, r111.getValue(r112, "none"));     // Catch: Exception -> L244
    L244:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L247:
        r215 = r105;
        if (r101 != null) goto L295;
    L254:
        if (r111 == null) goto L256;
        r210.put(r108, r111.getValue(r112, -1));     // Catch: Exception -> L252
        goto L280
    L256:
        r210.put(r108, -1);     // Catch: Exception -> L252
        goto L280
    L295:
        if (r101.has("PLAY-IsPreview") == false) goto L254;
        r210.put(r108, r101.optInt("PLAY-IsPreview"));     // Catch: Exception -> L252
        goto L280
    L252:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L260:
        r215 = r105;
        if (r111 != null) goto L315;
        r210.put(r108, -1);     // Catch: Exception -> L266
        goto L280
    L315:
        r210.put(r108, r111.getValue(r112, -1));     // Catch: Exception -> L266
    L266:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L269:
        r215 = r105;
        if (r111 != null) goto L321;
        r210.put(r108, -1);     // Catch: Exception -> L274
        goto L280
    L321:
        r210.put(r108, r111.getValue(r112, -1L));     // Catch: Exception -> L274
    L274:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L228
        goto L280
    L317:
        String r119 = "PLAY-" + r112;     // Catch: Exception -> L142
        if (r101 != null) goto L138;
    L140:
        r210.put(r108, r103);     // Catch: Exception -> L142
        goto L21
    L138:
        if (r101.has(r119) == false) goto L140;
        r210.put(r108, r101.optJSONObject(r119));     // Catch: Exception -> L142
        goto L21
    L142:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L277
        goto L21
    L145:
        if (this.mHistoryDuration != null) goto L173;
        this.mHistoryDuration = new JSONObject();     // Catch: JSONException -> L277
        long r216 = System.currentTimeMillis();     // Catch: JSONException -> L277
        String r120 = "select play_time from " + HistoryTableOperate.TABLE_NAME_HISTORY + " order by update_time desc limit 10";     // Catch: JSONException -> L277
        ?? r121 = BaseTableOperate.querySQL(HistoryTableOperate.TABLE_NAME_HISTORY, r120);     // Catch: JSONException -> L277
        int r122 = -1;
        int r123 = 0;
    L148:
        if (r121 == 0) goto L158;
        if (r121.moveToNext() == false) goto L158;
        r215 = r105;
        if (r122 != r113) goto L329;
        r122 = 0;
    L329:
        this.mHistoryDuration.put(String.valueOf(r123), r121.getLong(r106));     // Catch: Throwable -> L162 Exception -> L286
        r123 = r123 + 1;     // Catch: Throwable -> L162 Exception -> L286
        r105 = r215;
        r106 = 0;
        r113 = -1;
    L162:
        th = th;
    L163:
        if (r121 != 0) goto L291;
    L165:
        throw th;     // Catch: JSONException -> L188
    L291:
        r121.close();     // Catch: Exception -> L285
    L166:
        if (r121 != 0) goto L301;
    L297:
        HistoryTableOperate.mHisTableMonitor.updateMonitorLogInfo(HistoryTableOperate.TABLE_NAME_HISTORY, BaseStrategyMonitor.MONITOR_QUERY_OPERATE, TAG, r122, r216, r120);     // Catch: JSONException -> L188
        HistoryTableOperate.mHisTableMonitor.uploadMonitorLog();     // Catch: JSONException -> L188
    L299:
        r210.put(r108, this.mHistoryDuration);     // Catch: Exception -> L176
    L176:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L188
    L301:
        r121.close();     // Catch: Exception -> L287
        goto L297
    L157:
        r215 = r105;
    L155:
        th = th;
        r215 = r105;
    L158:
        r215 = r105;
        int r124 = r123;
    L159:
        if (r124 >= 10) goto L169;
        this.mHistoryDuration.put(String.valueOf(r124), -1);     // Catch: Throwable -> L162 Exception -> L286
        r124 = r124 + 1;
        goto L159
    L169:
        if (r121 == 0) goto L297;
    L173:
        r215 = r105;
        goto L299
    L31:
        if (r112.equals("VideoBufferList") == false) goto L132;
        r114 = 24;
        goto L133
    L34:
        if (r112.equals("DoubleBufferDataSeconds") == false) goto L132;
        r114 = 16;
        goto L133
    L37:
        if (r112.equals("HistoryFirstStartTime") == false) goto L132;
        r114 = 30;
        goto L133
    L40:
        if (r112.equals("StallTotalTime") == false) goto L132;
        r114 = 2;
        goto L133
    L43:
        if (r112.equals("FirstFrame") == false) goto L132;
        r114 = 8;
        goto L133
    L46:
        if (r112.equals("EnterMethod") == false) goto L132;
        r114 = 18;
        goto L133
    L49:
        if (r112.equals("EnterAction") == false) goto L132;
        r114 = 19;
        goto L133
    L52:
        if (r112.equals("FirstFrameVideoBuffer") == false) goto L132;
        r114 = 5;
        goto L133
    L55:
        if (r112.equals("IsPreview") == false) goto L132;
        r114 = 17;
        goto L133
    L58:
        if (r112.equals("StallTotalCount") == false) goto L132;
        r114 = HTTP.CR;
        goto L133
    L61:
        if (r112.equals("HistoryEstimatedBandwidth") == false) goto L132;
        r114 = 29;
        goto L133
    L64:
        if (r112.equals("FirstFrameAudioBuffer") == false) goto L132;
        r114 = 6;
        goto L133
    L67:
        if (r112.equals("RetryTotalCount") == false) goto L132;
        r114 = 14;
        goto L133
    L70:
        if (r112.equals("FirstFrameDownloadSpeed") == false) goto L132;
        r114 = 7;
        goto L133
    L73:
        if (r112.equals("EndTs") == false) goto L132;
        r114 = 3;
        goto L133
    L76:
        if (r112.equals("FPS") == false) goto L132;
        r114 = 22;
        goto L133
    L79:
        if (r112.equals("302") == false) goto L132;
        r114 = 10;
        goto L133
    L82:
        if (r112.equals("Success") == false) goto L132;
        r114 = 9;
        goto L133
    L85:
        if (r112.equals("HistoryBandwidth") == false) goto L132;
        r114 = 28;
        goto L133
    L88:
        if (r112.equals("StartTs") == false) goto L132;
        r114 = 0;
        goto L133
    L91:
        if (r112.equals("StallType") == false) goto L132;
        r114 = 12;
        goto L133
    L94:
        if (r112.equals("StallTime") == false) goto L132;
        r114 = 1;
        goto L133
    L97:
        if (r112.equals("BitrateList") == false) goto L132;
        r114 = 33;
        goto L133
    L100:
        if (r112.equals("StallSeries") == false) goto L132;
        r114 = 23;
        goto L133
    L103:
        if (r112.equals("AudioBufferList") == false) goto L132;
        r114 = 25;
        goto L133
    L106:
        if (r112.equals("RenderVideoSeries") == false) goto L132;
        r114 = 26;
        goto L133
    L109:
        if (r112.equals("ResolutionList") == false) goto L132;
        r114 = 32;
        goto L133
    L112:
        if (r112.equals("ConnectCost") == false) goto L132;
        r114 = 11;
        goto L133
    L115:
        if (r112.equals("BufferDataSeconds") == false) goto L132;
        r114 = 15;
        goto L133
    L118:
        if (r112.equals("StreamSuffix") == false) goto L132;
        r114 = 21;
        goto L133
    L121:
        if (r112.equals("RenderAudioSeries") == false) goto L132;
        r114 = 27;
        goto L133
    L124:
        if (r112.equals("NeptuneName") == false) goto L132;
        r114 = 20;
        goto L133
    L127:
        if (r112.equals("Duration") == false) goto L132;
        r114 = 4;
        goto L133
    L130:
        if (r112.equals("HistoryDuration") == false) goto L132;
        r114 = 31;
    L277:
        e = e;
        r215 = r105;
        goto L279
    L25:
        r110 = r108.indexOf("-") + 1;
        r111 = r104;
        goto L26
    L281:
        return r210;
    L14:
        r105 = null;
        goto L15
    L10:
        r104 = null;
    L282:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputRTFeatures(JSONObject r100, JSONArray r101, String r102, String r103, JSONObject r104) {
        JSONObject r105 = this.mCurCallerInfo;
        if (r105 == null) goto L12;
        String r106 = r105.optString("stream_session_vv_id", "");
        if (r106.length() == 0) goto L12;
        JSONObject r107 = new JSONObject().put("featuresBundleList", r101).put("featuresData", r100);     // Catch: JSONException -> L10
        IAppInfoBundle r108 = LiveStrategyManager.inst().mListenerMap.get(r106);     // Catch: JSONException -> L10
        if (r108 == null) goto L12;
        r108.getAppInfoForKey("bundle", r107);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r100;
    }
}
