package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.bduploader.smartserver.SmartSpeedTest;
import java.io.File;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDNetworkSpeedTest extends BDAbstractUpload implements Handler.Callback {
    public static final int AuthTypeSTS2 = 0;
    public static final int AuthTypeServerAuth = 1;
    public static final int BDNetworkRoutModeDomain = 0;
    public static final int BDNetworkRoutModeTopNHost = 1;
    public static final int DataTransportProtocolGQuic = 2;
    public static final int DataTransportProtocolHttpVersion1 = 0;
    public static final int DataTransportProtocolHttpVersion2 = 1;
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
    public static final int KeyIsDisableUploadInfo = 301;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableExternNet = 26;
    public static final int KeyIsEnableFileTryHttps = 25;
    public static final int KeyIsEnableHeaderXStorageMode = 83;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableIntelligentSpeedTest = 431;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnableMutiTask = 29;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsEnableQuic = 28;
    public static final int KeyIsExternFileReader = 200;
    public static final int KeyIsExternNetLoader = 27;
    public static final int KeyIsExternNetParameter = 41;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetTosKey = 300;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsIntelligentTestResult = 432;
    public static final int KeyIsIsUseServerHost = 17;
    public static final int KeyIsIsUseUpHost = 18;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMediaInfo = 68;
    public static final int KeyIsNewHttpProxyLoader = 40;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsOpenResume = 70;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetEvStateEnable = 79;
    public static final int KeyIsSetLinkTurboEnable = 82;
    public static final int KeyIsSetMinSize = 77;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessActionType = 65;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetResponeTimeOut = 76;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetUserRefrence = 62;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceTimeout = 7;
    public static final int KeyIsSocketNum = 9;
    public static final int KeyIsSourceMd5 = 57;
    public static final int KeyIsTcpOpenTimeOutMilliSec = 24;
    public static final int KeyIsTopAccessKey = 42;
    public static final int KeyIsTopSecretKey = 43;
    public static final int KeyIsTopSessionToken = 44;
    public static final int KeyIsUploadCookie = 4;
    public static final int KeyIsUserName = 1;
    public static final int KeyIsVideoUploadDomain = 3;
    public static final int MessageIsCallBackError = 101;
    public static final int MessageIsCallBackHeader = 102;
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsCallBackStageEvent = 104;
    public static final int MessageIsNetRoutError = 112;
    public static final int MessageIsNetRoutVidInfoFirst = 110;
    public static final int MessageIsSpeedTestError = 106;
    public static final int MessageIsSpeedTestSuccess = 105;
    public static final int MessageIsSpeedTestUseless = 108;
    public static final int MessageIsnetRoutVidInfoAll = 111;
    public static final int MsgIsCallBackLog = 100;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetStateIsClose = -1;
    public static final int NetStateIsNotReachable = 0;
    public static final int NetStateIsReachable = 1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int keyIsConfigString = 56;
    private boolean hasInit;
    private int mEnableIntelligentSpeedTest;
    private long mEndTime;
    private long mHandle;
    private Handler mHandler;
    private String mIntelligentModelURL;
    private BDNetworkSpeedTestListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private SmartSpeedTest mSmartSpeedTest;
    private long mStartTime;
    private int mState;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    private static native void _close(long r100);

    private final native long _create();

    private static native void _setIntValue(long r100, int r101, int r102);

    private static native void _setStringValue(long r100, int r101, String r102);

    private static native void _start(long r100);

    private static native void _stop(long r100);

    public void onLogInfo(int r100, int r101, String r102) {
    }

    private void preloadModel() {
        SmartSpeedTest r100 = this.mSmartSpeedTest;
        if (r100 == null) goto L6;
        r100.preloadEnv();
        return;
    }

    public void close() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        _close(r100);     // Catch: Throwable -> L8
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
        this.mReadLock.lock();
        String r100 = BDUploadUtil.sdkConfigDir;
        if (r100 != null) goto L5;
    L15:
    L12:
        th = move-exception;
        this.mReadLock.unlock();
        throw th;
    L8:
        if (this.mHandle == 0) goto L10;
        this.mState = 1;     // Catch: Throwable -> L12
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        _start(this.mHandle);     // Catch: Throwable -> L12
    L10:
        this.mReadLock.unlock();
        return;
    L5:
        if (r100.length() <= 0) goto L15;
        setContextDir(BDUploadUtil.sdkConfigDir);
        goto L15
    }

    public void stop() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        _stop(r100);     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public BDNetworkSpeedTest() throws Exception {
        this.mState = -1;
        this.mIntelligentModelURL = "";
        this.mEnableIntelligentSpeedTest = 0;
        this.hasInit = false;
        this.mHandler = null;
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r100;
        this.mListener = null;
        if (Looper.myLooper() == null) goto L5;
        this.mHandler = new Handler(this);
    L6:
        this.mReadLock = r100.readLock();
        this.mWriteLock = r100.writeLock();
        this.mHandle = _create();     // Catch: Throwable -> L9
    L10:
        long r101 = this.mHandle;
        if (r101 == 0) goto L15;
        _setIntValue(r101, 421, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
        return;
    L15:
        throw new Exception("create native speed tester fail");
    L9:
        this.mHandle = 0;
        goto L10
    L5:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L6
    }

    private void checkAndInit(String r100) {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        SmartSpeedTest r101 = new SmartSpeedTest();
        this.mSmartSpeedTest = r101;
        r101.init();
        this.mSmartSpeedTest.setUrl(r100);
        this.mSmartSpeedTest.configServer();
    }

    private float predictIntelligentSpeed(JSONObject r100) {
        SmartSpeedTest r101 = this.mSmartSpeedTest;
        if (r101 != null) goto L7;
        return -1.0f;
    L7:
        return r101.predictSpeedSync(r100);
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        BDNetworkSpeedTestListener r101 = this.mListener;
        if (r101 == null) goto L9;
        Object r102 = r100.obj;
        if ((r102 instanceof BDNetworkSpeedTestInfo) == false) goto L10;
        BDNetworkSpeedTestInfo r103 = (BDNetworkSpeedTestInfo) r102;
        r101.onSpeedTestContext(r103.mContextType, r103.mSpeed, r103.mContext);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public void setAuthType(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 416, r100);
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

    public void setDataTransportProtocol(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 411, r100);
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

    public void setEnableHttps(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        _setIntValue(r101, 19, r100);
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

    public void setListener(BDNetworkSpeedTestListener r100) {
        this.mListener = r100;
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

    public void setProcessActionType(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 65, r100);
    }

    public void setQueryAuth(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _setStringValue(r101, 15, r100);
        return;
    L9:
        return;
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

    public void setRegionName(String r100) {
        setStringValue(47, r100);
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

    public void setServerParameter(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        _setStringValue(r101, 16, r100);
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
        setStringValue(46, r100);
    }

    public int checkNet(int r100, int r101) {
        BDNetworkSpeedTestListener r102 = this.mListener;
        if (r102 != null) goto L5;
        return 1;
    L5:
        return r102.speedTestCheckNetState(r100, r101);
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String intelligentInterface(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == 3) goto L8;
        if (r100 == 5) goto L8;
    L22:
        if (r102 != null) goto L24;
        return "";
    L24:
        r102.toString();
        return r102.toString();
    L8:
        if (r100 != 3) goto L10;
        int r103 = 1;
    L11:
        SmartSpeedTest r104 = this.mSmartSpeedTest;
        if (r104 != null) goto L14;
        return "";
    L14:
        r104.setSpeedTestUseVCN(r103);
        JSONObject r105 = new JSONObject(r101);     // Catch: Exception -> L21
        if (this.mEnableIntelligentSpeedTest != 1) goto L22;
        float r106 = predictIntelligentSpeed(r105);     // Catch: Exception -> L21
        if (r106 <= 0.0f) goto L22;
        r102.put("intelligentTestResult", r106);     // Catch: Exception -> L21
    L21:
        r102 = null;
        goto L22
    L10:
        r103 = 0;
        goto L11
    }

    public void setIntelligentSpeedTestInfo(int r100, String r101) {
        if (this.mHandle == 0) goto L11;
        if (r101 == null) goto L12;
        this.mEnableIntelligentSpeedTest = r100;
        this.mIntelligentModelURL = r101;
        if (r100 != 1) goto L9;
        checkAndInit(r101);
        preloadModel();
    L9:
        _setIntValue(this.mHandle, 431, r100);
        return;
    L12:
        return;
    }

    public void setNetworkType(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setIntValue(r102, r100, r101);
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

    public void onNotify(int r100, long r101, int r102, String r103) {
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r103), "upload_log");     // Catch: Exception -> L4
    L5:
        UploadEventManager.instance.addEvent(r104);
        BDNetworkSpeedTestInfo r105 = new BDNetworkSpeedTestInfo(r103, r100, (int) r101);
        Handler r106 = this.mHandler;
        if (r106 == null) goto L11;
        Message r107 = r106.obtainMessage();
        r107.what = r100;
        r107.obj = r105;
        r107.sendToTarget();
        return;
    L11:
        return;
    L4:
        r104 = null;
        goto L5
    }
}
