package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.bduploader.net.BDUploadDNSParser;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDVideoUploaderBase extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
    public static final int ExternalReaderModeSequence = 1;
    public static final int ExternalReaderModeSkipHeader = 0;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int KeIsAuthorization = 15;
    public static final int KeIsGetRedirectLocation = 14;
    public static final int KeyIsAliveMaxFailTime = 22;
    public static final int KeyIsAuthType = 416;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsDynamicSliceForceConfig = 447;
    public static final int KeyIsDynamicSliceHighSize = 450;
    public static final int KeyIsDynamicSliceLowSize = 448;
    public static final int KeyIsDynamicSliceNormalSize = 449;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableLogicalPart = 86;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExternalReaderMode = 412;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetUploadErrorMessage = 415;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMaxUploadSpeedThresh = 413;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsPrivateVideo = 414;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSkipCode2ndFileSize = 446;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsTosEncStorageMode = 451;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoMetaData = 445;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MAX_HEADER_SIZE = 20;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackSingleEventLog = 107;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsDiskResumeInfoError = 120;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsReadSliceUserCancel = 121;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsAllVideosComplete = 10;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsFlushComplete = 50;
    public static final int MsgIsSingleVideoComplete = 8;
    public static final int MsgIsSingleVideoFail = 9;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int VideoUploadFunctionTypeEncryption = 1;
    public static final int VideoUploadFunctionTypeNoProcess = 0;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    int headerIndex;
    protected BDVideoUploaderAbstractListener mAbstractListener;
    private boolean mEnableVideoPatch;
    private long mEndTime;
    private boolean mFinish;
    protected long mHandle;
    private Handler mHandler;
    private String[] mHeaders;
    private Lock mHeadersLock;
    private JSONObject mJsonInfo;
    protected BDVideoUploaderListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mStartTime;
    private int mState;
    protected final ReentrantReadWriteLock.WriteLock mWriteLock;

    public static class LogInfo {
        private int code;
        private String info;

        public int getCode() {
            return this.code;
        }

        public String getInfo() {
            return this.info;
        }

        public LogInfo(int r100, String r101) {
            this.code = r100;
            this.info = r101;
        }
    }

    public static native void _cancelUpload(long r100);

    private static native void _close(long r100);

    private final native long _create();

    private static native long _getLongValue(long r100, int r101);

    private static native String _getStrByKeyAndIndex(long r100, int r101, int r102);

    private static native String _getStringValue(long r100, int r101);

    public static native void _mergeUpload(long r100);

    private static native void _setAIGCMeta(long r100, int r101, String[] r102, String[] r103, String[] r104);

    public static native void _setContext(long r100, String r101);

    private static native void _setFilePaths(long r100, int r101, String[] r102);

    public static native void _setInt64Value(long r100, int r101, long r102);

    public static native void _setIntValue(long r100, int r101, int r102);

    public static native void _setObject(long r100, int r101, Object r102);

    private static native void _setPoster(long r100, float r101);

    private static native void _setPosterMeta(long r100, int r101, String[] r102);

    private static native void _setSpecifiedContentType(long r100, int r101, String[] r102);

    public static native void _setStringValue(long r100, int r101, String r102);

    private static native void _start(long r100);

    private static native void _stop(long r100);

    private void setEnableBatch() {
        this.mEnableVideoPatch = true;
        _setIntValue(this.mHandle, 304, 1);
    }

    private void parseLog() {
        if (this.mFinish == false) goto L5;
        return;
    L5:
        this.mFinish = true;
        addLogToManager(_getStringValue(this.mHandle, 100));
    }

    public void allowMergeUpload() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        _mergeUpload(r100);
    }

    public void close() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        _stop(r100);     // Catch: Throwable -> L8
        parseLog();     // Catch: Throwable -> L8
        _close(this.mHandle);     // Catch: Throwable -> L8
        this.mHandle = 0;     // Catch: Throwable -> L8
        this.mState = 5;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public void start() {
        this.mWriteLock.lock();
        String r100 = BDUploadUtil.sdkConfigDir;
        if (r100 != null) goto L5;
    L15:
    L12:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L8:
        if (this.mHandle == 0) goto L10;
        this.mFinish = false;     // Catch: Throwable -> L12
        this.mState = 1;     // Catch: Throwable -> L12
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        _start(this.mHandle);     // Catch: Throwable -> L12
    L10:
        this.mWriteLock.unlock();
        return;
    L5:
        if (r100.length() <= 0) goto L15;
        setContextDir(BDUploadUtil.sdkConfigDir);
        setDiskResumeDir(BDUploadUtil.sdkConfigDir);
        setRetryStatesDir(BDUploadUtil.sdkConfigDir);
        goto L15
    }

    public void stop() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L13
        if (r100 == 0) goto L11;
        _stop(r100);     // Catch: Throwable -> L13
        String r101 = getDNSIP();     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
    L10:
        parseLog();     // Catch: Throwable -> L13
        this.mState = 4;     // Catch: Throwable -> L13
        goto L11
    L8:
        if (r101.isEmpty() == true) goto L10;
        setStringValue(75, r101);     // Catch: Throwable -> L13
    L11:
        this.mWriteLock.unlock();
        return;
    L13:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public BDVideoUploaderBase() throws Exception {
        this.mState = -1;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mHeadersLock = new ReentrantLock();
        this.mFinish = false;
        this.mEnableVideoPatch = false;
        this.mHandle = _create();     // Catch: Throwable -> L5
    L7:
        long r100 = this.mHandle;
        if (r100 == 0) goto L19;
        _setIntValue(r100, 421, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
        if (Looper.myLooper() == null) goto L12;
        this.mHandler = new Handler(this);
    L13:
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        this.mHeaders = new String[20];
        int r101 = 0;
    L14:
        if (r101 >= 20) goto L16;
        this.mHeaders[r101] = null;
        r101 = r101 + 1;
        goto L14
    L16:
        this.headerIndex = 0;
        setTraceId(UUID.randomUUID().toString());
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsXQuicLibAvailable, BDUploadUtil.xquicAvalilable() ? 1 : 0);
        setBatchVideoId();
        return;
    L12:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L13
    L19:
        throw new Exception("create native uploader fail:" + BDAbstractUpload.mErrorMsg);
    L5:
        th = move-exception;
        this.mHandle = 0;
        th.toString();
        goto L7
    }

    private void setBatchVideoId() {
        String r100 = UUID.randomUUID().toString();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length() <= 0) goto L9;
        _setStringValue(this.mHandle, 420, r100);
        return;
    }

    public String getDNSIP() {
        return BDUploadUtil.getDNSServerIP();
    }

    public static boolean isError() {
        return BDAbstractUpload.IsErrored;
    }

    private void setContextDir(String r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        String r101 = r100 + File.separator + BDUploadUtil.SpeedTestcontextDir;
        BDUploadUtil.createDir(r101);
        _setStringValue(this.mHandle, 418, r101);
        return;
    L9:
        return;
    }

    private void setDiskResumeDir(String r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        String r101 = r100 + File.separator + BDUploadUtil.DiskResumeConfigDir;
        BDUploadUtil.createDir(r101);
        _setStringValue(this.mHandle, 303, r101);
        return;
    L9:
        return;
    }

    private void setRetryStatesDir(String r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        String r101 = r100 + File.separator + BDUploadUtil.RetryStatesInfoDir;
        BDUploadUtil.createDir(r101);
        _setStringValue(this.mHandle, BDAbstractUpload.KeyIsRetryStatesDir, r101);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject addLogToManager(String r110) {
        String r100 = UUID.randomUUID().toString();
        int r101 = 0;
        JSONArray r102 = null;
        JSONObject r103 = new JSONObject(r110);     // Catch: Exception -> L23
        r103.put("dns_version", BDUploadResolver.mDNSVersion);     // Catch: Exception -> L23
        r103.put("main_dns_type", BDUploadDNSParser.mGlobalMainType);     // Catch: Exception -> L23
        r103.put("main_back_type", BDUploadDNSParser.mGlobalBackType);     // Catch: Exception -> L23
        r103.put("back_delayed_time", BDUploadDNSParser.mGlobalBackUpDelayedTime);     // Catch: Exception -> L23
        r103.put("expired_time", BDUploadDNSParser.mGlobalDefaultExpiredTime);     // Catch: Exception -> L23
        JSONObject r111 = this.mJsonInfo;     // Catch: Exception -> L23
        if (r111 == null) goto L9;
        Iterator<String> r112 = r111.keys();     // Catch: Exception -> L23
    L7:
        if (r112.hasNext() == false) goto L9;
        String r104 = r112.next();     // Catch: Exception -> L23
        r103.put(r104, this.mJsonInfo.get(r104));     // Catch: Exception -> L23
    L9:
        String r113 = "";
        this.mHeadersLock.lock();     // Catch: Throwable -> L20
        int r105 = 0;
    L12:
        if (r105 >= 20) goto L17;
        if (TextUtils.isEmpty(this.mHeaders[r105]) == true) goto L16;
        r113 = r113 + "#" + this.mHeaders[r105];     // Catch: Throwable -> L20
    L16:
        r105 = r105 + 1;
        goto L12
    L17:
        this.mHeadersLock.unlock();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r113) == true) goto L24;
        r103.put("cdn_headers", r113);     // Catch: Exception -> L23
    L24:
        if (r103 != null) goto L46;
    L43:
        UploadEventManager.instance.addEvent(r103);
        return r103;
    L46:
        Object r114 = r103.get("video_array");     // Catch: Exception -> L41
        if ((r114 instanceof JSONArray) == false) goto L28;
        r102 = (JSONArray) r114;     // Catch: Exception -> L41
        r103.remove("video_array");     // Catch: Exception -> L41
    L28:
        int r115 = JSONObjectProtectorUtils.getInt(r103, "file_num");     // Catch: Exception -> L41
    L29:
        if (r101 >= r115) goto L40;
        JSONObject r106 = new JSONObject(r103.toString());     // Catch: Exception -> L41
        r106.remove("event");     // Catch: Exception -> L41
        r106.put("event", "bd_video_upload");     // Catch: Exception -> L41
        if (r102 != null) goto L33;
    L38:
        r106.put(ST.UUID_DEVICE, r100);     // Catch: Exception -> L41
        UploadEventManager.instance.addEvent(r106);     // Catch: Exception -> L41
        r101 = r101 + 1;
        goto L29
    L33:
        if (r102.length() <= r101) goto L38;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r102, r101);     // Catch: Exception -> L41
        Iterator<String> r108 = r107.keys();     // Catch: Exception -> L41
    L36:
        if (r108.hasNext() == false) goto L38;
        String r109 = r108.next();     // Catch: Exception -> L41
        r106.put(r109, r107.get(r109));     // Catch: Exception -> L41
        goto L36
    L40:
        return r103;
    L41:
        e = move-exception;
        e.toString();
    L20:
        th = move-exception;
        this.mHeadersLock.unlock();     // Catch: Exception -> L23
        throw th;     // Catch: Exception -> L23
    L23:
        r103 = null;
        goto L24
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int r100) {
        if (r100 != 0) goto L4;
        BDVideoUploaderListener r101 = this.mListener;
        if (r101 != null) goto L13;
    L10:
        return null;
    L13:
        return r101.getStringFromExtern(r100);
    L4:
        if (r100 != 1) goto L10;
        return UUID.randomUUID().toString();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        int r101 = r100.what;
        Object r102 = r100.obj;
        if ((r102 instanceof LogInfo) == false) goto L6;
        LogInfo r103 = (LogInfo) r102;
        onLogInfoSync(r101, r103.getCode(), r103.getInfo());
        return true;
    L6:
        BDVideoUploaderListener r104 = this.mListener;
        if (r104 != null) goto L9;
        return true;
    L9:
        BDVideoInfo r105 = (BDVideoInfo) r102;
        if (r105 == null) goto L12;
        long r106 = r105.mProgress;
    L13:
        r104.onNotify(r101, r106, r105);
        return true;
    L12:
        r106 = 0;
        goto L13
    }

    public void setAIGCMeta(BDVideoInfo.AIGCMeta r100) {
        setAIGCMetaForBatch(1, new BDVideoInfo.AIGCMeta[]{r100});
    }

    public void setAbstractListener(BDVideoUploaderAbstractListener r100) {
        this.mAbstractListener = r100;
    }

    public void setAliveMaxFailTime(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 22, r100);
        return;
    L9:
        return;
    }

    public void setCustomHttpHeaders(TreeMap<String, Object> r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 == null) goto L12;
        String r101 = BDUploadUtil.mapToString(r100);
        if (r101 == null) goto L11;
        setStringValue(430, r101);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setDiskResumeOption(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 302, r100);
    }

    public void setDiskResumeUniqueKey(String r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 301, r100);
        return;
    L12:
        return;
    }

    public void setEnableBigFile(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 83, r100);
        return;
    L9:
        return;
    }

    public void setEnableExternDNS(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L10;
        if (r100 != 0) goto L6;
    L8:
        _setIntValue(r101, 21, r100);
        return;
    L6:
        if (r100 == 1) goto L8;
        return;
    }

    public void setEnableFiletryHttps(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L10;
        if (r100 != 0) goto L6;
    L8:
        _setIntValue(r101, 25, r100);
        return;
    L6:
        if (r100 == 1) goto L8;
        return;
    }

    public void setEnableHttps(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 19, r100);
        return;
    L9:
        return;
    }

    public void setEnableKeepAlive(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L10;
        if (r100 != 0) goto L6;
    L8:
        _setIntValue(r101, 20, r100);
        return;
    L6:
        if (r100 == 1) goto L8;
        return;
    }

    public void setEnableLogCallBack(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        _setIntValue(r101, 78, 1);
        return;
    L8:
        _setIntValue(r101, 78, 0);
    }

    public void setEnableLogicalPart(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 86, r100);
        return;
    L9:
        return;
    }

    public void setFileRetryCount(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 6, r100);
        return;
    L9:
        return;
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public void setListener(BDVideoUploaderListener r100) {
        this.mListener = r100;
    }

    public void setMaxConcurrentFileNum(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 400, r100);
        return;
    L9:
        return;
    }

    public void setMaxFailTime(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 13, r100);
        return;
    L9:
        return;
    }

    public void setMaxUploadSpeedThresh(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 413, r100);
    }

    public void setMediaDataReader(BDMediaDataReader r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _setIntValue(r101, 81, 2);
        _setObject(this.mHandle, 201, r100);
        return;
    L9:
        return;
    }

    public void setObjectType(String r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.equals("") == true) goto L12;
        setStringValue(54, r100);
        return;
    L12:
        return;
    }

    public void setOpenBoe(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        _setIntValue(r101, 67, 1);
        return;
    L8:
        _setIntValue(r101, 67, 0);
    }

    public void setPathName(String r100) {
        setStringValue(0, r100);
    }

    public void setPoster(float r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        if (r100 < 0.0f) goto L10;
        _setPoster(r101, r100);
        return;
    }

    public void setPosterMeta(String r100) {
        setPosterMetaForBatch(1, new String[]{r100});
    }

    public void setPreUploadEncryptionMode(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 74, r100);
    }

    public void setRWTimeout(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 7, r100);
        return;
    L9:
        return;
    }

    public void setResponseTimeOut(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 76, r100);
        return;
    L9:
        return;
    }

    public void setSDKConfigDir(String r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        BDUploadUtil.createDir(r100);
        _setStringValue(this.mHandle, 417, r100);
        setContextDir(r100);
        return;
    L9:
        return;
    }

    public void setSDKMaxRetryCount(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 426, r100);
    }

    public void setSDKMaxRetryTimeout(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, BDAbstractUpload.KeyIsSDKMaxRetryTimeout, r100);
    }

    public void setScenesTag(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _setStringValue(r101, 85, r100);
        return;
    L9:
        return;
    }

    public void setServerParameter(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _setStringValue(r101, 16, r100);
        return;
    L9:
        return;
    }

    public void setSliceReTryCount(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 5, r100);
        return;
    L9:
        return;
    }

    public void setSliceSize(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 <= 0) goto L9;
        _setIntValue(r101, 8, r100);
        return;
    L9:
        return;
    }

    public void setSocketNum(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 9, r100);
        return;
    L9:
        return;
    }

    public void setSpaceName(String r100) {
        setStringValue(45, r100);
    }

    public void setTcpOpenTimeOutMilliSec(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 24, r100);
        return;
    L9:
        return;
    }

    public void setTopAccessKey(String r100) {
        setStringValue(42, r100);
    }

    public void setTopSecretKey(String r100) {
        setStringValue(43, r100);
    }

    public void setTopSessionToken(String r100) {
        setStringValue(44, r100);
    }

    public void setTosEncStorageMode(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 451, r100);
    }

    public void setTraceId(String r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L12;
        _setStringValue(this.mHandle, 69, r100);
        return;
    L12:
        return;
    }

    public void setTranTimeOutUnit(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 <= 0) goto L9;
        _setIntValue(r101, 64, r100);
        return;
    L9:
        return;
    }

    public void setUploadDomain(String r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        setStringValue(46, r100);
        return;
    L9:
        return;
    }

    public int checkNet(int r100, int r101) {
        BDVideoUploaderListener r102 = this.mListener;
        if (r102 != null) goto L7;
        return 1;
    L7:
        return r102.videoUploadCheckNetState(r100, r101);
    }

    public void setAIGCMetaForBatch(int r100, BDVideoInfo.AIGCMeta[] r101) {
        if (this.mHandle == 0) goto L18;
        if (r101 == null) goto L19;
        if (r100 <= 0) goto L20;
        int r102 = Math.min(r100, r101.length);
        String[] r103 = new String[r102];
        String[] r104 = new String[r102];
        String[] r105 = new String[r102];
        int r106 = 0;
    L8:
        if (r106 >= r102) goto L13;
        BDVideoInfo.AIGCMeta r107 = r101[r106];
        if (r107 == null) goto L12;
        r103[r106] = r107.Label;
        r104[r106] = r101[r106].ContentProducer;
        r105[r106] = r101[r106].ContentPropagator;
    L12:
        r106 = r106 + 1;
        goto L8
    L13:
        _setAIGCMeta(this.mHandle, r102, r103, r104, r105);
        return;
    L20:
        return;
    L19:
        return;
    }

    public void setExternFileReader(BDMultiExternalFileReader r100, int r101) {
        if (this.mHandle == 0) goto L9;
        if (r100 == null) goto L10;
        if (r101 <= 0) goto L11;
        setEnableBatch();
        _setIntValue(this.mHandle, 71, r101);
        _setIntValue(this.mHandle, 81, 1);
        _setObject(this.mHandle, 200, r100);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFilePath(int r100, String[] r101) {
        if (this.mHandle == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        setEnableBatch();
        _setFilePaths(this.mHandle, r100, r101);
        _setIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setNetworkType(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setIntValue(r102, r100, r101);
    }

    public void setPosterMetaForBatch(int r100, String[] r101) {
        if (this.mHandle == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        int r102 = Math.min(r100, r101.length);
        _setPosterMeta(this.mHandle, r102, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSpecifiedContentType(int r100, String[] r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        _setSpecifiedContentType(r102, r100, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setStringValue(int r100, String r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L8;
        if (r101 == null) goto L9;
        _setStringValue(r102, r100, r101);
        return;
    L9:
        return;
    }

    public void onLogInfo(int r100, int r101, String r102) {
        if (this.mState == 1) goto L5;
        return;
    L5:
        LogInfo r103 = new LogInfo(r101, r102);
        Message r104 = this.mHandler.obtainMessage();
        r104.what = r100;
        r104.obj = r103;
        r104.sendToTarget();
    }

    public void onLogInfoSync(int r100, int r101, String r102) {
        if (r100 != 102) goto L15;
        if (TextUtils.isEmpty(r102) == true) goto L15;
        this.mHeadersLock.lock();     // Catch: Throwable -> L11
        if (this.headerIndex < 20) goto L9;
        this.headerIndex = 0;     // Catch: Throwable -> L11
    L9:
        String[] r103 = this.mHeaders;     // Catch: Throwable -> L11
        int r104 = this.headerIndex;     // Catch: Throwable -> L11
        r103[r104] = r102;     // Catch: Throwable -> L11
        this.headerIndex = r104 + 1;     // Catch: Throwable -> L11
        this.mHeadersLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mHeadersLock.unlock();
        throw th;
    L15:
        if (r100 != 104) goto L30;
        if (this.mAbstractListener == null) goto L54;
        new HashMap(20);
        JSONObject r105 = new JSONObject(r102);     // Catch: JSONException -> L27
        JSONObject r106 = this.mJsonInfo;     // Catch: JSONException -> L27
        if (r106 == null) goto L25;
        Iterator<String> r107 = r106.keys();     // Catch: JSONException -> L27
    L23:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();     // Catch: JSONException -> L27
        r105.put(r108, this.mJsonInfo.get(r108));     // Catch: JSONException -> L27
    L25:
        BDUploadUtil.jsonToHashMap(r105);     // Catch: JSONException -> L27
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        return;
    L54:
        return;
    L30:
        if (r100 != 103) goto L35;
        long r109 = new Date().getTime() / 1000;
        BDVideoUploaderListener r110 = this.mListener;
        if (r110 == null) goto L35;
        r110.onUploadVideoStage(r101, r109);
    L35:
        if (r100 == 107) goto L48;
    L42:
        BDVideoUploaderListener r111 = this.mListener;
        if (r111 == null) goto L56;
        r111.onLog(r100, r101, r102);
        return;
    L56:
        return;
    L48:
        JSONObject r112 = new JSONObject(r102);     // Catch: Exception -> L38
    L39:
        UploadEventManager.instance.addEvent(r112);
        BDVideoUploaderAbstractListener r113 = this.mAbstractListener;
        if (r113 == null) goto L42;
        r113.onEventLog();
    L38:
        r112 = null;
        goto L39
    }

    public void setDynamicSliceParams(int r100, int r101, int r102) {
        long r103 = this.mHandle;
        if (r103 == 0) goto L10;
        if (r100 <= 0) goto L11;
        if (r101 <= 0) goto L12;
        if (r102 <= 0) goto L13;
        _setIntValue(r103, KeyIsDynamicSliceForceConfig, 1);
        _setIntValue(this.mHandle, KeyIsDynamicSliceLowSize, r100);
        _setIntValue(this.mHandle, KeyIsDynamicSliceNormalSize, r101);
        _setIntValue(this.mHandle, 450, r102);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onNotify(int r310, long r311, int r312, String r313) {
        if (this.mState == 1) goto L6;
        return;
    L6:
        if (r310 == 0) goto L41;
        if (r310 == 1) goto L38;
        if (r310 == 2) goto L31;
        if (r310 != 3) goto L12;
        parseLog();
        BDVideoInfo r100 = new BDVideoInfo(null, null, r311, null, _getStringValue(this.mHandle, 14), null, null);
    L47:
        Message r101 = this.mHandler.obtainMessage();
        r101.what = r310;
        r101.obj = r100;
        r101.sendToTarget();
        return;
    L12:
        if (r310 == 50) goto L41;
        if (r310 == 120) goto L38;
        if (r310 == 121) goto L22;
        switch(r310) {
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L18;
        };
    L18:
        r100 = null;
        goto L47
    L19:
        parseLog();
        r100 = new BDVideoInfo(null, null, r311, null, null, null, null);
        this.mState = 3;
        goto L47
    L20:
        r100 = new BDVideoInfo(null, null, r311, r312, r313, null, null, null, null);
        goto L47
    L21:
        int r102 = (int) r311;
        String r103 = _getStrByKeyAndIndex(this.mHandle, 10, r102);
        String r104 = _getStrByKeyAndIndex(this.mHandle, 12, r102);
        String r110 = _getStrByKeyAndIndex(this.mHandle, 300, r102);
        String r111 = _getStrByKeyAndIndex(this.mHandle, 407, r102);
        String r112 = _getStrByKeyAndIndex(this.mHandle, 1002, r102);
        r100 = new BDVideoInfo(r103, r104, r311, r312, null, r110, _getStrByKeyAndIndex(this.mHandle, 68, r102), r111, r112);
        goto L47
    L22:
        String r105 = getDNSIP();
        if (r105 != null) goto L25;
    L27:
        String r106 = _getStringValue(this.mHandle, 14);
        r100 = new BDVideoInfo(null, null, r311, _getStringValue(this.mHandle, 415), r106, null, null);
        parseLog();
        this.mState = 2;
        goto L47
    L25:
        if (r105.isEmpty() == true) goto L27;
        setStringValue(75, r105);
        goto L27
    L31:
        String r107 = getDNSIP();
        if (r107 != null) goto L34;
    L36:
        String r108 = _getStringValue(this.mHandle, 14);
        r100 = new BDVideoInfo(null, null, r311, _getStringValue(this.mHandle, 415), r108, null, null);
        parseLog();
        this.mState = 2;
        goto L47
    L34:
        if (r107.isEmpty() == true) goto L36;
        setStringValue(75, r107);
    L38:
        if (this.mEnableVideoPatch == false) goto L40;
        r100 = new BDVideoInfo(null, null, r311, r312, null, null, null, null, null);
        goto L47
    L40:
        r100 = new BDVideoInfo(null, null, r311, null, null, null, null);
    L41:
        this.mEndTime = System.currentTimeMillis();
        String r113 = _getStringValue(this.mHandle, 10);
        String r109 = _getStringValue(this.mHandle, 1017);
        String r114 = _getStringValue(this.mHandle, 12);
        String r115 = _getStringValue(this.mHandle, 300);
        String r116 = _getStringValue(this.mHandle, 407);
        String r210 = _getStringValue(this.mHandle, 1002);
        r100 = new BDVideoInfo(r113, r114, r311, null, r115, _getStringValue(this.mHandle, 68), r116, r210);
        r100.mMid = r109;
        String r117 = getDNSIP();
        if (r117 != null) goto L44;
    L46:
        parseLog();
        this.mState = 3;
        goto L47
    L44:
        if (r117.isEmpty() == true) goto L46;
        setStringValue(75, r117);
        goto L46
    }
}
