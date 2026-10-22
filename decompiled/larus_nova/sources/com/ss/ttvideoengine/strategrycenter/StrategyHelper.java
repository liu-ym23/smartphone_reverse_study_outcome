package com.ss.ttvideoengine.strategrycenter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.vcloud.strategy.IAppService;
import com.bytedance.vcloud.strategy.ILogCallback;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTNetworkStateCallback;
import com.ss.ttvideoengine.dasp.DaspSignal;
import com.ss.ttvideoengine.database.IKVStorage;
import com.ss.ttvideoengine.database.IKVStorageProvider;
import com.ss.ttvideoengine.database.KVDBManager;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import com.ss.ttvideoengine.preload.PreloadScene;
import com.ss.ttvideoengine.selector.strategy.GearStrategyContext;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class StrategyHelper {
    public static final String LOG_KEY_PRECISE_CACHE_CONTROL = "st_play_task_op";
    static final String TAG = "VCStrategy";
    private int mAppID;
    private com.bytedance.vcloud.strategy.StrategyCenter mCenter;
    private boolean mCheckPlayerVer;
    private Context mContext;
    private DBHelper mDBHelper;
    private boolean mDidSetAppInfo;
    private int mEnableSpeedInfoUpdate;
    private IStrategyEventListener mEventListener;
    private long mIOManager;
    private long mIOManagerVersion;
    private StrategyEvent mInnerEvent;
    private Map<Integer, String> mJsonStringMap;
    private float mLastBandwidth;
    private final ReentrantLock mLock;
    private int mLogLevel;
    private Map<Integer, Integer> mModuleSwitchMap;
    private TTNetworkStateCallback mNetWorkChangeCb;
    private WeakReference<TTNetworkStateCallback> mNetWorkChangeCbr;
    private boolean mPlayerIsMatch;
    private IPortraitService mPortraitService;
    private Map<Integer, Integer> mSettingMap;
    private boolean mSpeedInfoUpdate;
    private ReentrantLock mSpeedLock;
    private IKVStorageProvider mStorageProvider;
    private IStrategyStateSupplier mSupplier;

    public final class DBHelper {
        private static final String dataBaseName = "TTVideoEngine_vod_strategy_database_v01";
        private static final String dataIndex = "data_index";
        Context mContext;
        private final ArrayList<String> mIndexArray;
        IKVStorage mKVStorage;
        final int mMaxCacheNum;
        WeakReference<StrategyHelper> mSHelper;
        final /* synthetic */ StrategyHelper this$0;

        private boolean _create() {
            if (this.mKVStorage != null) goto L10;
            if (StrategyHelper.access$1000(this.this$0) == null) goto L7;
            this.mKVStorage = StrategyHelper.access$1000(this.this$0).getKVStorage(dataBaseName);
            TTVideoEngineLog.d(StrategyHelper.TAG, "use kv storage provider");
            goto L10
        L7:
            this.mKVStorage = new KVDBManager(this.mContext, dataBaseName);
            TTVideoEngineLog.d(StrategyHelper.TAG, "use KVDBManager");
            return ((KVDBManager) this.mKVStorage).isCreateDBSuccess();
        L10:
            if (this.mKVStorage == null) goto L12;
            return true;
        L12:
            return false;
        }

        private void _loadData() {
            StrategyHelper r100 = this.mSHelper.get();
            if (r100 != null) goto L5;
            return;
        L5:
            ArrayList<String> r101 = stringToStringArray(this.mKVStorage.getString(dataIndex));
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.isEmpty() == true) goto L23;
            this.mIndexArray.addAll(r101);
            Iterator<String> r102 = r101.iterator();
        L12:
            if (r102.hasNext() == false) goto L24;
            String r103 = r102.next();
            String r104 = this.mKVStorage.getString(r103);
            if (TextUtils.isEmpty(r104) == true) goto L12;
            r100.getCenter().h(31210, r104);
            goto L12
        L24:
            return;
        }

        private void _saveDataIndexes() {
            String r100 = indexToString(this.mIndexArray);
            this.mKVStorage.putString(dataIndex, r100);
        }

        public void clear() {
            this.mKVStorage.clear();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "clear fail. " + th.toString());
        }

        public void loadDB() {
        L8:
            th = move-exception;
            TTVideoEngineLog.d(th);
            return;
        L3:
            if (_create() == true) goto L6;
            TTVideoEngineLog.e(StrategyHelper.TAG, "create db fail.");     // Catch: Throwable -> L8
            return;
        L6:
            _loadData();     // Catch: Throwable -> L8
        }

        private String indexToString(ArrayList<String> r100) {
            if (r100 == null) goto L12;
            StringBuilder r101 = new StringBuilder(r100.size());
            int r102 = 0;
        L5:
            if (r102 >= r100.size()) goto L11;
            r101.append((String) ListProtector.get(r100, r102));
            if (r102 >= (r100.size() - 1)) goto L9;
            r101.append(",");
        L9:
            r102 = r102 + 1;
            goto L5
        L11:
            return r101.toString();
        L12:
            return null;
        }

        private ArrayList<String> stringToStringArray(String r100) {
            ArrayList<String> r101 = null;
            if (TextUtils.isEmpty(r100) == false) goto L24;
            return null;
        L24:
            String[] r102 = r100.split(",");     // Catch: Throwable -> L19
            if (r102 != null) goto L8;
            return null;
        L8:
            if (r102.length <= 0) goto L30;
            ArrayList<String> r103 = new ArrayList();     // Catch: Throwable -> L19
            int r104 = r102.length;     // Catch: Throwable -> L17
            int r105 = 0;
        L11:
            if (r105 >= r104) goto L31;
            String r106 = r102[r105];     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r106) == true) goto L15;
            r103.add(r106);     // Catch: Throwable -> L17
        L15:
            r105 = r105 + 1;
            goto L11
        L31:
            return r103;
        L17:
            th = th;
            r101 = r103;
        L20:
            TTVideoEngineLog.d(th);
            return r101;
        L30:
            return null;
        L19:
            th = th;
            goto L20
        }

        public void loadKeyValue(String r100) {
        L12:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "load key value fail. " + th.toString());
            return;
        L4:
            if (_create() == true) goto L7;
            TTVideoEngineLog.e(StrategyHelper.TAG, "create db fail.");     // Catch: Throwable -> L12
            return;
        L7:
            StrategyHelper r101 = this.mSHelper.get();     // Catch: Throwable -> L12
            if (r101 != null) goto L10;
            return;
        L10:
            r101.getCenter().h(31212, this.mKVStorage.getString(r100));     // Catch: Throwable -> L12
        }

        public void removeData(String r100) {
            this.mIndexArray.remove(r100);     // Catch: Throwable -> L4
            this.mKVStorage.removeString(r100);     // Catch: Throwable -> L4
            _saveDataIndexes();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "remove data fail. " + th.toString());
        }

        public void saveData(String r100, String r101) {
            this.mIndexArray.add(r100);     // Catch: Throwable -> L7
            if (this.mIndexArray.size() <= 2000) goto L5;
            this.mKVStorage.removeString((String) ListProtector.remove(this.mIndexArray, 0));     // Catch: Throwable -> L7
        L5:
            _saveDataIndexes();     // Catch: Throwable -> L7
            this.mKVStorage.putString(r100, r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "save data fail. " + th.toString());
        }

        public void saveKeyValue(String r100, String r101) {
            this.mKVStorage.putString(r100, r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            TTVideoEngineLog.e(StrategyHelper.TAG, "save key value fail. " + th.toString());
        }

        public DBHelper(StrategyHelper r100, Context r101, StrategyHelper r102) {
            this.this$0 = r100;
            this.mIndexArray = new ArrayList();
            this.mKVStorage = null;
            this.mSHelper = null;
            this.mMaxCacheNum = 2000;
            this.mContext = r101;
            this.mSHelper = new WeakReference(r102);
        }

        public void event(int r100, String r101, String r102) {
            switch(r100) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                case 6: goto L4;
                default: goto L16;
            };
        L4:
            clear();
            return;
        L5:
            loadKeyValue(r101);
            return;
        L6:
            saveKeyValue(r101, r102);
            return;
        L7:
            removeData(r101);
            return;
        L8:
            saveData(r101, r102);
            return;
        L9:
            loadDB();
            return;
        }
    }

    public static class MyALogCallBak implements ILogCallback {
        public MyALogCallBak() {
        }

        public void log(String r100) {
            TTVideoEngineLog.i(StrategyHelper.TAG, r100);
        }
    }

    public class MyAppServer implements IAppService {
        private WeakReference<StrategyHelper> mHelper;
        final /* synthetic */ StrategyHelper this$0;

        public MyAppServer(StrategyHelper r100, StrategyHelper r101) {
            this.this$0 = r100;
            this.mHelper = null;
            this.mHelper = new WeakReference(r101);
        }

        public String getPortrait(String r100, String r101) {
            StrategyHelper r102 = this.mHelper.get();
            if (r102 != null) goto L5;
            return null;
        L5:
            if (StrategyHelper.access$900(r102) == null) goto L18;
            HashMap r103 = new HashMap();
            r103.put("type", IPortraitService.TYPE_ONE_PORTRAIT);
            r103.put("from", r100);
            r103.put("name", r101);
            Map<String, String> r104 = StrategyHelper.access$900(r102).getPortraits(r103);
            if (r104 != null) goto L10;
            return "";
        L10:
            if (r104.containsKey(r101) == true) goto L12;
            return "";
        L12:
            return r104.get(r101);
        L18:
            return null;
        }

        public String getPortraits(String r100, String r101) {
            StrategyHelper r102 = this.mHelper.get();
            if (r102 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r102) == null) goto L11;
            HashMap r103 = new HashMap();
            r103.put("type", "group");
            r103.put("name", r101);
            r103.put("from", r100);
            Map<String, String> r104 = StrategyHelper.access$900(r102).getPortraits(r103);
            if (r104 == null) goto L11;
            return new JSONObject(r104).toString();
        }

        public void addGroupConfig(String r100, String r101, String r102) {
            StrategyHelper r103 = this.mHelper.get();
            if (r103 != null) goto L5;
            return;
        L5:
            if (StrategyHelper.access$900(r103) == null) goto L20;
            ArrayList r104 = new ArrayList();
            JSONArray r105 = new JSONArray(r102);     // Catch: Throwable -> L15
            int r106 = 0;
        L10:
            if (r106 >= r105.length()) goto L13;
            r104.add(JSONArrayProtectorUtils.getString(r105, r106));     // Catch: Throwable -> L15
            r106 = r106 + 1;
        L13:
            HashMap r107 = new HashMap();
            r107.put("from", r100);
            r107.put("name", r101);
            StrategyHelper.access$900(r103).addGroupConfig(r107, r104);
            return;
        }

        public String getMediaPortrait(String r100, String r101, String r102) {
            StrategyHelper r103 = this.mHelper.get();
            if (r103 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r103) == null) goto L11;
            HashMap r104 = new HashMap();
            r104.put("type", IPortraitService.TYPE_ONE_PORTRAIT);
            r104.put("name", r102);
            r104.put("video_id", r101);
            r104.put("from", r100);
            Map<String, String> r105 = StrategyHelper.access$900(r103).getPortraits(r104);
            if (r105 == null) goto L11;
            return new JSONObject(r105).toString();
        }

        public String getMediaPortraits(String r100, String r101, String r102) {
            StrategyHelper r103 = this.mHelper.get();
            if (r103 != null) goto L5;
        L11:
            return null;
        L5:
            if (StrategyHelper.access$900(r103) == null) goto L11;
            HashMap r104 = new HashMap();
            r104.put("type", "group");
            r104.put("name", r102);
            r104.put("video_id", r101);
            r104.put("from", r100);
            Map<String, String> r105 = StrategyHelper.access$900(r103).getPortraits(r104);
            if (r105 == null) goto L11;
            return new JSONObject(r105).toString();
        }
    }

    public class MyIStrategyEventListener implements com.bytedance.vcloud.strategy.IStrategyEventListener {
        private WeakReference<StrategyHelper> mHelper;
        final /* synthetic */ StrategyHelper this$0;

        public /* bridge */ /* synthetic */ void strategyConfigGlobalOption(int r100, int r101, Object r102) {
            com.bytedance.vcloud.strategy.IStrategyEventListener.CC.$default$strategyConfigGlobalOption(this, r100, r101, r102);
        }

        public MyIStrategyEventListener(StrategyHelper r100, StrategyHelper r101) {
            this.this$0 = r100;
            this.mHelper = null;
            this.mHelper = new WeakReference(r101);
        }

        public void onEventLog(String r100, String r101) {
            TTVideoEngineLog.d(StrategyHelper.TAG, "eventName: " + r100 + ", logInfo: " + r101);
            if (TextUtils.isEmpty(r101) == true) goto L11;
            VideoEventManager.instance.addEventV2(true, new JSONObject(r101), r100);     // Catch: JSONException -> L6
            return;
        L6:
            e = move-exception;
            TTVideoEngineLog.d(e);
            return;
        }

        public void onEvent(String r100, int r101, int r102, String r103) {
            TTVideoEngineLog.i(StrategyHelper.TAG, "on event, videoID = " + r100 + ", key = " + r101 + ", value = " + r102 + ", info = " + r103);
            if (r101 != 2019) goto L10;
            StrategyHelper r104 = this.mHelper.get();
            if (r104 != null) goto L7;
            return;
        L7:
            if (StrategyHelper.access$500(r104) == null) goto L20;
            StrategyHelper.access$500(r104).event(r102, r100, r103);
            return;
        L20:
            return;
        L10:
            StrategyHelper.access$600(this.this$0).event(r100, r101, r102, r103);
            StrategyHelper.access$700(this.this$0).lock();
            if (StrategyHelper.access$800(this.this$0) == null) goto L17;
            StrategyHelper.access$700(this.this$0).unlock();
            if (r101 != 2012) goto L15;
        L16:
            StrategyHelper.access$800(this.this$0).onEvent(r100, r101, r102, r103);
            return;
        L15:
            if (r101 >= 2500) goto L16;
            return;
        L17:
            StrategyHelper.access$700(this.this$0).unlock();
        }
    }

    public static class StrategyHelperHolder {
        private static final StrategyHelper Instance = null;

        private StrategyHelperHolder() {
        }

        static {
            Instance = new StrategyHelper();
        }

        public static /* synthetic */ StrategyHelper access$000() {
            return Instance;
        }
    }

    private static final int _netState(int r100) {
        if (r100 != (-1)) goto L5;
        return 0;
    L5:
        if (r100 != 0) goto L8;
        return 20;
    L8:
        if (r100 != 2) goto L10;
    L15:
        return 10;
    L10:
        if (r100 == 3) goto L15;
        if (r100 == 1) goto L15;
        if (r100 == 4) goto L15;
        return -1;
    }

    private void _configParams() {
        this.mDBHelper = new DBHelper(this, this.mContext, this);
        getCenter().F(10000, this.mLogLevel);
        getCenter().F(801, StrategyKeys.mInteractionBlockDurationPreloaded);
        getCenter().F(802, StrategyKeys.mInteractionBlockDurationNonPreloaded);
        Iterator<Map.Entry<Integer, String>> r100 = this.mJsonStringMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<Integer, String> r101 = r100.next();
        getCenter().B(r101.getKey().intValue(), r101.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Integer>> r102 = this.mSettingMap.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<Integer, Integer> r103 = r102.next();
        getCenter().F(r103.getKey().intValue(), r103.getValue().intValue());
        goto L8
    }

    private void _netStateListener() {
        if (this.mNetWorkChangeCb == null) goto L5;
        return;
    L5:
        this.mNetWorkChangeCb = new AnonymousClass3(this);
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 16) == true) goto L9;
        this.mNetWorkChangeCbr = new WeakReference(this.mNetWorkChangeCb);
        TTNetWorkListener.getInstance().startListen(this.mNetWorkChangeCbr);
        return;
    }

    public com.bytedance.vcloud.strategy.StrategyCenter getCenter() {
        if (this.mCenter != null) goto L13;
        this.mLock.lock();
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L6:
        if (this.mCenter != null) goto L8;
        this.mCenter = new com.bytedance.vcloud.strategy.StrategyCenter(new MyIStrategyEventListener(this, this));     // Catch: Throwable -> L9
    L8:
        this.mLock.unlock();
    L13:
        return this.mCenter;
    }

    public float getNetworkSpeed() {
        if (this.mEnableSpeedInfoUpdate == 0) goto L5;
        this.mSpeedLock.lock();
    L21:
        th = move-exception;
        this.mSpeedLock.unlock();
        throw th;
    L9:
        if (this.mSpeedInfoUpdate == false) goto L11;
    L15:
        float r100 = helper().getCenter().n();     // Catch: Throwable -> L21
        if (r100 <= 0.0f) goto L18;
        TTVideoEngineLog.d(TAG, "speed update success, result: " + r100);     // Catch: Throwable -> L21
        this.mLastBandwidth = r100;     // Catch: Throwable -> L21
        this.mSpeedInfoUpdate = false;     // Catch: Throwable -> L21
    L18:
        float r101 = this.mLastBandwidth;     // Catch: Throwable -> L21
        this.mSpeedLock.unlock();
        return r101;
    L11:
        if (this.mLastBandwidth <= 0.0f) goto L15;
        TTVideoEngineLog.d(TAG, "speed doesnt need to be updated, update: " + this.mSpeedInfoUpdate + ", last: " + this.mLastBandwidth);     // Catch: Throwable -> L21
        float r102 = this.mLastBandwidth;     // Catch: Throwable -> L21
        this.mSpeedLock.unlock();
        return r102;
    L5:
        return helper().getCenter().n();
    }

    public boolean needCheckPlayerVersion() {
        return !this.mCheckPlayerVer;
    }

    public void speedInfoUpdate() {
        this.mSpeedLock.lock();
        TTVideoEngineLog.d(TAG, "speed info update");     // Catch: Throwable -> L6
        this.mSpeedInfoUpdate = true;     // Catch: Throwable -> L6
        this.mSpeedLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mSpeedLock.unlock();
        throw th;
    }

    public StrategyHelper() {
        this.mCenter = null;
        this.mSupplier = null;
        this.mPortraitService = null;
        this.mDidSetAppInfo = false;
        this.mIOManager = 0;
        this.mIOManagerVersion = 0;
        this.mContext = null;
        this.mLogLevel = 5;
        this.mAppID = 0;
        this.mCheckPlayerVer = false;
        this.mPlayerIsMatch = false;
        this.mNetWorkChangeCb = null;
        this.mNetWorkChangeCbr = null;
        this.mLock = new ReentrantLock();
        this.mDBHelper = null;
        this.mModuleSwitchMap = new ConcurrentHashMap(5);
        this.mInnerEvent = new StrategyEvent();
        this.mSettingMap = new ConcurrentHashMap();
        this.mJsonStringMap = new ConcurrentHashMap();
        this.mStorageProvider = null;
        this.mEnableSpeedInfoUpdate = 0;
        this.mSpeedInfoUpdate = true;
        this.mLastBandwidth = -1.0f;
        this.mSpeedLock = new ReentrantLock();
    }

    public static StrategyHelper helper() {
        return StrategyHelperHolder.access$000();
    }

    public boolean isRunning() {
        return getCenter().f272480b;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public IStrategyStateSupplier getSupplier() {
        return this.mSupplier;
    }

    public boolean playerIsMatch() {
        return this.mPlayerIsMatch;
    }

    private String _mapToString(Map<String, String> r100) {
        if (r100 != null) goto L17;
        return null;
    L17:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L16
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Exception -> L16
        String r104 = r103.getKey();     // Catch: Exception -> L16
        String r105 = r103.getValue();     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r104) == true) goto L7;
        if (TextUtils.isEmpty(r105) == true) goto L7;
        r101.put(r104, r105);     // Catch: Exception -> L16
        goto L7
    L14:
        return r101.toString();
    L16:
        return null;
    }

    private String _objectMapToString(Map<String, Object> r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L15
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();     // Catch: Exception -> L15
    L7:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, Object> r103 = r102.next();     // Catch: Exception -> L15
        String r104 = r103.getKey();     // Catch: Exception -> L15
        Object r105 = r103.getValue();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r104) == true) goto L7;
        if (r105 == null) goto L7;
        r101.put(r104, r105);     // Catch: Exception -> L15
        goto L7
    L13:
        return r101.toString();
    L15:
        return null;
    }

    private Map<String, Integer> _stringToIntValueMap(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() < 2) goto L26;
        HashMap r101 = new HashMap();
        String[] r102 = r100.split(",");
        int r103 = 0;
    L20:
    L14:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L19
        goto L16
    L8:
        if (r103 >= r102.length) goto L13;
        String[] r104 = r102[r103].split(":");     // Catch: NumberFormatException -> L14 Throwable -> L19
        if (r104.length != 2) goto L12;
        r101.put(r104[0], Integer.valueOf(Integer.parseInt(r104[1])));     // Catch: NumberFormatException -> L14 Throwable -> L19
    L12:
        r103 = r103 + 1;
        goto L20
    L13:
        return r101;
    L16:
        return r101;
    L26:
        return null;
    }

    public static /* synthetic */ IStrategyStateSupplier access$100(StrategyHelper r100) {
        return r100.mSupplier;
    }

    public static /* synthetic */ IKVStorageProvider access$1000(StrategyHelper r100) {
        return r100.mStorageProvider;
    }

    public static /* synthetic */ int access$200(int r100) {
        return _netState(r100);
    }

    public static /* synthetic */ DBHelper access$500(StrategyHelper r100) {
        return r100.mDBHelper;
    }

    public static /* synthetic */ StrategyEvent access$600(StrategyHelper r100) {
        return r100.mInnerEvent;
    }

    public static /* synthetic */ ReentrantLock access$700(StrategyHelper r100) {
        return r100.mLock;
    }

    public static /* synthetic */ IStrategyEventListener access$800(StrategyHelper r100) {
        return r100.mEventListener;
    }

    public static /* synthetic */ IPortraitService access$900(StrategyHelper r100) {
        return r100.mPortraitService;
    }

    private void internalStart(boolean r100) {
        TTVideoEngineLog.i(TAG, "internalStart needLoadLibrary=" + r100);
        getCenter().i(r100);
        if (getCenter().s() == true) goto L6;
        TTVideoEngineLog.i(TAG, "internalStart isLoadLibrarySucceed false");
        return;
    L6:
        _configParams();
        _netStateListener();
        if (this.mJsonStringMap.get(31001) == null) goto L9;
    L13:
        getCenter().E(this.mIOManager, this.mIOManagerVersion);
        if (getCenter().r() == true) goto L17;
        TTVideoEngineLog.i(TAG, "io manager interface not match, start fail.");
        return;
    L17:
        getCenter().G(new MyALogCallBak());
        if (this.mPortraitService == null) goto L20;
        getCenter().D(new MyAppServer(this, this));
    L20:
        JSONObject r101 = SettingsHelper.helper().getJsonObject(SettingsHelper.MODULE_VOD);
        if (r101 == null) goto L23;
        getCenter().I(SettingsHelper.MODULE_VOD, r101.toString());
    L23:
        PreloadScene r102 = new PreloadScene("engine_default");
        r102.mSceneId = "engine_default";
        r102.mBriefSceneId = "engine_brief_default";
        r102.mAutoPlay = 1;
        r102.mMute = 0;
        r102.mMaxVisibleCardCnt = 1;
        r102.setAlgorithmName("engine_default");
        helper().getCenter().k(r102.toJsonString());
        getCenter().J(new AnonymousClass1(this));
        getCenter().L(r100);
        helper().getCenter().M("engine_default");
        Map<String, Object> r103 = PortraitEngine.getInstance().getAllLabels();
        if (r103 != null) goto L29;
    L26:
        PortraitEngine.getInstance().addPortraitListener(new AnonymousClass2(this));
        return;
    L29:
        getCenter().h(31214, new JSONObject(r103).toString());     // Catch: Exception -> L28
        goto L26
    L9:
        if (this.mAppID != 32) goto L11;
        String r104 = "{\"strategy_center_v1\":{\"feed\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"fullscreen_immersive\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}},\"story\":{\"preload_strategy\":{\"name\":\"adaptive\",\"low_buf\":5,\"high_buf\":20,\"tasks\":[{\"count\":5,\"size\":800,\"offset\":0}]}}}}";
    L12:
        setAlgorithmJson(31001, r104);
        goto L13
    L11:
        r104 = "{\"strategy_center_v1\":{\"engine_default\":{\"preload_strategy\":{\"name\":\"default\",\"tasks\":[{\"download_progress\":100,\"count\":5,\"offset\":0,\"size\":800}]}},\"video_range_request\":{\"enable_concurrent_download\":0,\"allowed_segment_download\":0,\"fixed_size\":3000,\"fixed_duration\":10}}}";
        goto L12
    }

    public boolean checkPlayerVersion(int r100) {
        if (r100 == (-1)) goto L12;
        if (getCenter().s() == false) goto L12;
        boolean r101 = true;
        this.mCheckPlayerVer = true;
        if (getCenter().q() == r100) goto L10;
        r101 = false;
    L10:
        this.mPlayerIsMatch = r101;
    L12:
        return this.mPlayerIsMatch;
    }

    public void enableSpeedInfoUpdate(int r100) {
        this.mEnableSpeedInfoUpdate = r100;
    }

    public Map<String, Object> getLogData(String r100) {
        return this.mInnerEvent.getLogData(r100);
    }

    public boolean loadPluginLibrary(LibraryLoaderProxy r100) {
        this.mLock.lock();
        boolean r101 = r100.loadLibrary("preload");     // Catch: Throwable -> L5
        this.mLock.unlock();
        return r101;
    L5:
        th = move-exception;
        TTVideoEngineLog.i(TAG, th.toString());     // Catch: Throwable -> L9
        this.mLock.unlock();
        return false;
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public int moduleSwitch(int r100) {
        if (r100 >= 803) goto L5;
    L6:
        TTVideoEngineLog.i(TAG, "get module switch key is wrong" + r100);
    L8:
        if (this.mModuleSwitchMap.containsKey(Integer.valueOf(r100)) == true) goto L14;
        if (getCenter().f272480b == false) goto L12;
        this.mModuleSwitchMap.put(Integer.valueOf(r100), Integer.valueOf(getCenter().o(r100)));
        goto L14
    L12:
        return 0;
    L14:
        return ((Integer) TTHelper.nonNullElse(this.mModuleSwitchMap.get(Integer.valueOf(r100)), 0)).intValue();
    L5:
        if (r100 <= 807) goto L8;
        goto L6
    }

    public Map<String, Object> popOneEventLog(String r100) {
        return this.mInnerEvent.popLogData(1, r100);
    }

    public Map<String, Object> popOnePlayLog(String r100) {
        return this.mInnerEvent.popLogData(0, r100);
    }

    public void removeLogData(String r100) {
        this.mInnerEvent.removeLogData(r100);
    }

    public void setContext(Context r100) {
        this.mContext = r100;
    }

    public void setEventListener(IStrategyEventListener r100) {
        this.mLock.lock();
        this.mEventListener = r100;     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setKVStorageProvider(IKVStorageProvider r100) {
        this.mStorageProvider = r100;
    }

    public void setLogLevel(int r100) {
        getCenter().F(10000, r100);
        this.mLogLevel = r100;
    }

    public void setPortraitService(IPortraitService r100) {
        this.mLock.lock();
    L10:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L4:
        if (this.mPortraitService != null) goto L7;
        if (r100 == null) goto L7;
        getCenter().D(new MyAppServer(this, this));     // Catch: Throwable -> L10
    L7:
        this.mPortraitService = r100;     // Catch: Throwable -> L10
        this.mLock.unlock();
    }

    public void setSupplier(IStrategyStateSupplier r100) {
        this.mSupplier = r100;
    }

    public void start(boolean r100) {
        getCenter();
        this.mLock.lock();
        internalStart(r100);     // Catch: Throwable -> L5
    L4:
        this.mLock.unlock();
        return;
    L5:
        th = move-exception;
        TTVideoEngineLog.i(TAG, th.toString());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private Map<String, String> _stringToMap(String r100, Map<String, String> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (r101 == null) goto L32;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L20
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L20
    L8:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();     // Catch: Exception -> L20
        String r105 = JSONObjectProtectorUtils.getString(r102, r104);     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r104) == true) goto L8;
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r101.put(r104, r105);     // Catch: Exception -> L20
    L17:
        return r101;
    L32:
        return null;
    L18:
        return null;
    }

    public static /* synthetic */ String access$400(StrategyHelper r100, Map r101) {
        return r100._mapToString(r101);
    }

    public void configAppInfo(String r100, Map r101) {
        if (this.mDidSetAppInfo == false) goto L5;
    L7:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.containsKey("appid") == false) goto L13;
        this.mAppID = TTHelper.parseInt(r101.get("appid"));
        return;
    L13:
        return;
    L5:
        if (getCenter().s() == false) goto L7;
        getCenter().C(r100);
        this.mDidSetAppInfo = true;
        goto L7
    }

    public Map<String, Object> getLogData(String r100, String r101) {
        return this.mInnerEvent.getLogData(r100, r101);
    }

    public void setAlgorithmJson(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        TTVideoEngineLog.i(TAG, "[preload] Algorithm json " + r101);
        return;
    L7:
        if (getCenter().s() == false) goto L9;
        getCenter().B(r100, r101);
        return;
    L9:
        this.mJsonStringMap.put(Integer.valueOf(r100), r101);
    }

    public void setDaspNonPlaySignal(int r100, List<DaspSignal> r101) {
        _setDaspSignal(r100, r101, null);
    }

    public void setDaspPlaySignal(String r100, List<DaspSignal> r101) {
        _setDaspSignal(31224, r101, r100);
    }

    public void setIOManager(long r100, long r101) {
        this.mLock.lock();
        this.mIOManager = r100;     // Catch: Throwable -> L6
        this.mIOManagerVersion = r101;     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void setIntValue(int r100, int r101) {
        if (r100 > 50000) goto L5;
        return;
    L5:
        if (r100 < 60000) goto L8;
        return;
    L8:
        if (r100 < 58000) goto L15;
        if (r100 > 58999) goto L15;
        if (r100 != 58001) goto L15;
        enableSpeedInfoUpdate(r101);
    L15:
        if (getCenter().s() == false) goto L17;
        getCenter().F(r100, r101);
        return;
    L17:
        this.mSettingMap.put(Integer.valueOf(r100), Integer.valueOf(r101));
    }

    public void setStringValue(int r100, String r101) {
        if (r100 > 50000) goto L5;
        return;
    L5:
        if (r100 < 60000) goto L8;
        return;
    L8:
        if (getCenter().s() == false) goto L10;
        getCenter().K(r100, r101);
        return;
    L10:
        this.mJsonStringMap.put(Integer.valueOf(r100), r101);
    }

    private void _setDaspSignal(int r100, List<DaspSignal> r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L21
        Iterator<DaspSignal> r104 = r101.iterator();     // Catch: JSONException -> L21
    L5:
        if (r104.hasNext() == false) goto L17;
        DaspSignal r105 = r104.next();     // Catch: JSONException -> L21
        if (r105 == null) goto L5;
        if (r105.name == null) goto L5;
        if (r105.value == null) goto L5;
        TTVideoEngineLog.d("DaspSignal", "name: " + r105.name + ", value: " + r105.value);     // Catch: JSONException -> L21
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L21
        r106.put("value", r105.value);     // Catch: JSONException -> L21
        if (r102 == null) goto L16;
        r106.put("traceId", r102);     // Catch: JSONException -> L21
    L16:
        r103.put(r105.name, r106);     // Catch: JSONException -> L21
        goto L5
    L17:
        String r107 = r103.toString();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r107) == true) goto L36;
        TTVideoEngineLog.d("DaspSignal", "key: " + r100 + ", traceId: " + r102 + ", signalJson: " + r107);     // Catch: JSONException -> L21
        getCenter().h(r100, r107);     // Catch: JSONException -> L21
        return;
    L36:
        return;
    L21:
        e = move-exception;
        TTVideoEngineLog.e("DaspSignal", "Failed to create Dasp signal JSON: " + e);
    }

    public static /* synthetic */ Map access$300(StrategyHelper r100, String r101, Map r102) {
        return r100._stringToMap(r101, r102);
    }

    public static void buildMaskInfo(Map r100, String r101, String r102) {
    L12:
        th = move-exception;
        TTVideoEngineLog.e(TAG, th.toString());
        return;
    L4:
        if (r100.containsKey("infos") == false) goto L6;
        List r103 = (List) r100.get("infos");     // Catch: Throwable -> L12
    L7:
        HashMap r104 = new HashMap();     // Catch: Throwable -> L12
        r104.put(BarrageMaskInfo.KEY_MASK_FILE_HASH, r102);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == true) goto L10;
        r104.put("urls", new String[]{r101});     // Catch: Throwable -> L12
    L10:
        r104.put(a.KEY_MEDIA_TYPE, BuyNowCloseMethod.MASK);     // Catch: Throwable -> L12
        r103.add(r104);     // Catch: Throwable -> L12
        r100.put("infos", r103);     // Catch: Throwable -> L12
        return;
    L6:
        r103 = new ArrayList();     // Catch: Throwable -> L12
        goto L7
    }

    public Map<String, String> selectResolutionStringMapV2(IVideoModel r100, int r101, Map<String, Object> r102) {
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy called");
        String r103 = getCenter().A(r100.getMediaInfo(), r101, _objectMapToString(r102), null);
        if (TextUtils.isEmpty(r103) == false) goto L6;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r103);
        return null;
    L6:
        HashMap r104 = new HashMap();
        _stringToMap(r103, r104);
        return r104;
    }

    public static void buildMediaInfo(Map r100, String r101, String r102, String[] r103) {
    L12:
        th = move-exception;
        TTVideoEngineLog.e(TAG, th.toString());
        return;
    L4:
        if (r100.containsKey("infos") == false) goto L6;
        List r104 = (List) r100.get("infos");     // Catch: Throwable -> L12
    L7:
        HashMap r105 = new HashMap();     // Catch: Throwable -> L12
        r105.put("urls", r103);     // Catch: Throwable -> L12
        r105.put(BarrageMaskInfo.KEY_MASK_FILE_HASH, r102);     // Catch: Throwable -> L12
        r104.add(r105);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = r102;
    L10:
        r100.put("vid", r101);     // Catch: Throwable -> L12
        r100.put("infos", r104);     // Catch: Throwable -> L12
        return;
    L6:
        r104 = new ArrayList();     // Catch: Throwable -> L12
        goto L7
    }

    public Map<String, Integer> selectResolution(IVideoModel r100, int r101, Map<String, String> r102, GearStrategyContext r103) {
        String r104 = getCenter().y(r100.toMediaInfoJsonString(), r101, _mapToString(r102), r103);
        if (TextUtils.isEmpty(r104) == false) goto L7;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r104);
        return null;
    L7:
        return _stringToIntValueMap(r104);
    }

    public Map<String, Integer> selectResolutionStringMap(IVideoModel r100, int r101, Map<String, String> r102, GearStrategyContext r103) {
        TTVideoEngineLog.i(TAG, "[GearStrategy]GearStrategy called");
        if (EngineGlobalConfig.getInstance().getEnableSelectUseObject() != 1) goto L5;
        String r104 = getCenter().A(r100.getMediaInfo(), r101, _mapToString(r102), r103);
    L7:
        if (TextUtils.isEmpty(r104) == false) goto L10;
        TTVideoEngineLog.d(TAG, "[GearStrategy]StrategyHelper.selectResolution result invalid retString=" + r104);
        return null;
    L10:
        HashMap r105 = new HashMap();
        _stringToMap(r104, r105);
        if (r102 == null) goto L13;
        r102.putAll(r105);
    L13:
        HashMap r106 = new HashMap();
        if (r105.containsKey("video") == false) goto L19;
        String r107 = (String) r105.get("video");
        if (r107 == null) goto L19;
        r106.put("video", Integer.valueOf(CastIntegerProtector.parseInt(r107)));
    L19:
        if (r105.containsKey("audio") == false) goto L23;
        String r108 = (String) r105.get("audio");
        if (r108 == null) goto L23;
        r106.put("audio", Integer.valueOf(CastIntegerProtector.parseInt(r108)));
    L23:
        return r106;
    L5:
        r104 = getCenter().z(r100.toMediaInfoJsonString(), r101, _mapToString(r102), r103);
        goto L7
    }
}
