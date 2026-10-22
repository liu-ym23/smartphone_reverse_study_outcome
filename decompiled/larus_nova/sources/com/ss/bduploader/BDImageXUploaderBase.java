package com.ss.bduploader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.bduploader.net.BDUploadDNSParser;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDImageXUploaderBase extends BDAbstractUpload implements Handler.Callback {
    public static final int BDPreHeatModeLocalStorge = 2;
    public static final int BDPreHeatModeNone = 0;
    public static final int BDPreHeatModeReader = 1;
    public static final int BDPreHeatModeUseStorge = 3;
    public static final int BDUploadReaderTypeAndroidMedia = 2;
    public static final int BDUploadReaderTypeCallBack = 1;
    public static final int BDUploadReaderTypeFilePath = 0;
    public static final int CommitTypeCommit = 1;
    public static final int CommitTypeNoCommit = 0;
    public static final int CommitTypeNoDepend = 2;
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
    public static final int KeyIsApplyAuth = 83;
    public static final int KeyIsBackupNetworkType = 404;
    public static final int KeyIsCommitAuth = 84;
    public static final int KeyIsDataTransportProtocol = 411;
    public static final int KeyIsEnableCommitUpload = 401;
    public static final int KeyIsEnableExternDNS = 21;
    public static final int KeyIsEnableHttps = 19;
    public static final int KeyIsEnableKeepAlive = 20;
    public static final int KeyIsEnablePostMethod = 23;
    public static final int KeyIsExtra = 58;
    public static final int KeyIsFileRetryCount = 6;
    public static final int KeyIsFileUploadDomain = 2;
    public static final int KeyIsGetAlgorithm = 52;
    public static final int KeyIsGetCoverUrI = 12;
    public static final int KeyIsGetCoverUrl = 11;
    public static final int KeyIsGetDNSIp = 75;
    public static final int KeyIsGetEncryptionMeta = 407;
    public static final int KeyIsGetImageMeta = 410;
    public static final int KeyIsGetImageURI = 409;
    public static final int KeyIsGetLog = 100;
    public static final int KeyIsGetObjectId = 51;
    public static final int KeyIsGetSecretKey = 50;
    public static final int KeyIsGetUUID = 1;
    public static final int KeyIsGetVersion = 53;
    public static final int KeyIsGetVideoId = 10;
    public static final int KeyIsImageCountThreshold = 438;
    public static final int KeyIsLogCallback = 78;
    public static final int KeyIsMainNetworkType = 403;
    public static final int KeyIsMaxFailTime = 13;
    public static final int KeyIsMediaDataReader = 201;
    public static final int KeyIsMetaInfoParams = 61;
    public static final int KeyIsObjectType = 54;
    public static final int KeyIsPathName = 0;
    public static final int KeyIsPlainObjectId = 59;
    public static final int KeyIsPolicyParams = 55;
    public static final int KeyIsPreUpload = 80;
    public static final int KeyIsPreUploadApply = 419;
    public static final int KeyIsPreUploadEncryptionMode = 74;
    public static final int KeyIsRouteWeight = 408;
    public static final int KeyIsSDKConfigFileDir = 417;
    public static final int KeyIsSDKContextFileDir = 418;
    public static final int KeyIsScenesTag = 85;
    public static final int KeyIsServerParameter = 16;
    public static final int KeyIsSetApplyHost = 46;
    public static final int KeyIsSetCustomConfig = 63;
    public static final int KeyIsSetDeviceID = 66;
    public static final int KeyIsSetOpenBoe = 67;
    public static final int KeyIsSetProcessAction = 65;
    public static final int KeyIsSetReaderType = 81;
    public static final int KeyIsSetRegionName = 47;
    public static final int KeyIsSetSpaceName = 45;
    public static final int KeyIsSetSpeedTestThresh = 406;
    public static final int KeyIsSetSpeedTestValue = 405;
    public static final int KeyIsSetTraceId = 69;
    public static final int KeyIsSetTranTimeOutUnit = 64;
    public static final int KeyIsSetfileNum = 71;
    public static final int KeyIsSliceRetryCount = 5;
    public static final int KeyIsSliceSize = 8;
    public static final int KeyIsSliceThreshold = 402;
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
    public static final int MessageIsCallBackStage = 103;
    public static final int MessageIsPreHeatComplete = 123;
    public static final int MessageIsPreHeatResultUsed = 124;
    public static final int MessageIsUploadCompleteTos = 122;
    public static final int MsgIsComplete = 0;
    public static final int MsgIsFail = 2;
    public static final int MsgIsSingleImageComplete = 6;
    public static final int MsgIsSingleImageFail = 7;
    public static final int MsgIsUpdateProgress = 1;
    public static final int MsgIsUploadCancel = 3;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeTTNet = 1;
    public static final int UploadFunctionTypeEncryption = 1;
    public static final int UploadFunctionTypeGetMedia = 2;
    public static final int UploadFunctionTypeNoProcess = 0;
    public static final int UploadFunctionTypeUploadMediaLog = 2;
    public static final int keyIsConfigString = 56;
    public static final int keyIsMediaData = 0;
    private static final int mInnerUploaderType = 1;
    private BDImageXUploaderAbstractListener mAbstractListener;
    protected String mEnd2EndEncryptionAESKey;
    protected int mEnd2EndEncryptionOption;
    private long mEndTime;
    protected long mHandle;
    private Handler mHandler;
    private int mImageNum;
    private BDImageXUploaderListener mListener;
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

    public static native void _allowContinueUpload(long r100);

    public static native void _cancelUpload(long r100);

    private static native void _close(long r100);

    private final native long _create(int r100);

    private static native long _getLongValue(long r100, int r101);

    private static native String _getStrByKeyAndIndex(long r100, int r101, int r102);

    private static native String _getStringValue(long r100, int r101);

    public static native void _mergeUpload(long r100);

    private static native void _setFileData(long r100, int r101, byte[][] r102);

    private static native void _setFileName(long r100, int r101, String[] r102);

    private static native void _setFileNum(long r100, int r101);

    private static native void _setFilePaths(long r100, int r101, String[] r102);

    private static native void _setFileStoreKeys(long r100, int r101, String[] r102);

    private static native void _setInt64Value(long r100, int r101, long r102);

    public static native void _setIntValue(long r100, int r101, int r102);

    private static native void _setObject(long r100, int r101, Object r102);

    private static native void _setSpecifiedContentType(long r100, int r101, String[] r102);

    public static native void _setStringValue(long r100, int r101, String r102);

    private static native void _start(long r100);

    private static native void _stop(long r100);

    private String getEnd2EndEncryptionAESKey() {
        if (this.mEnd2EndEncryptionOption <= 0) goto L10;
        String r100 = this.mEnd2EndEncryptionAESKey;
        if (r100 != null) goto L7;
    L8:
        this.mEnd2EndEncryptionAESKey = _getStringValue(this.mHandle, 441);
        goto L10
    L7:
        if (r100.length() == 0) goto L8;
    L10:
        return this.mEnd2EndEncryptionAESKey;
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
        addLogToManager(_getStringValue(this.mHandle, 100));     // Catch: Throwable -> L8
        this.mState = 4;     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    public BDImageXUploaderBase() throws Exception {
        this.mState = -1;
        this.mImageNum = 0;
        this.mHandler = null;
        this.mReadWritedLock = new ReentrantReadWriteLock();
        this.mListener = null;
        this.mAbstractListener = null;
        this.mEnd2EndEncryptionAESKey = null;
        this.mEnd2EndEncryptionOption = 0;
        this.mHandle = _create(1);     // Catch: Throwable -> L5
    L6:
        long r100 = this.mHandle;
        if (r100 == 0) goto L15;
        _setIntValue(r100, 421, BDUploadUtil.mEnableNativeLog.booleanValue() ? 1 : 0);
        if (Looper.myLooper() == null) goto L11;
        this.mHandler = new Handler(this);
    L12:
        this.mReadLock = this.mReadWritedLock.readLock();
        this.mWriteLock = this.mReadWritedLock.writeLock();
        this.mState = 0;
        getDNSIP();
        return;
    L11:
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        goto L12
    L15:
        throw new Exception("create native uploader fail");
    L5:
        this.mHandle = 0;
        goto L6
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

    public void addLogToManager(String r110) {
        String r100 = UUID.randomUUID().toString();
        if (r100 != null) goto L5;
    L6:
        r100 = "invalid_uuid";
    L25:
        JSONObject r101 = new JSONObject(r110);     // Catch: Exception -> L9
        r101.put("dns_version", BDUploadResolver.mDNSVersion);     // Catch: Exception -> L9
        r101.put("main_dns_type", BDUploadDNSParser.mGlobalMainType);     // Catch: Exception -> L9
        r101.put("main_back_type", BDUploadDNSParser.mGlobalBackType);     // Catch: Exception -> L9
        r101.put("back_delayed_time", BDUploadDNSParser.mGlobalBackUpDelayedTime);     // Catch: Exception -> L9
        r101.put("expired_time", BDUploadDNSParser.mGlobalDefaultExpiredTime);     // Catch: Exception -> L9
        r101.put(ST.UUID_DEVICE, r100);     // Catch: Exception -> L9
        r101.remove("event");     // Catch: Exception -> L9
        r101.put("event", "bd_image_upload_all");     // Catch: Exception -> L9
    L10:
        if (r101 != null) goto L27;
    L22:
        UploadEventManager.instance.addEvent(r101);
        return;
    L27:
        JSONArray r111 = JSONObjectProtectorUtils.getJSONArray(r101, "image_array");     // Catch: Exception -> L24
        if (r111 == null) goto L22;
        r101.remove("image_array");     // Catch: Exception -> L24
        int r102 = 0;
    L14:
        if (r102 >= r111.length()) goto L22;
        JSONObject r103 = new JSONObject(r101.toString());     // Catch: Exception -> L24
        r103.remove("event");     // Catch: Exception -> L24
        r103.put("event", "bd_image_upload_single");     // Catch: Exception -> L24
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r111, r102);     // Catch: Exception -> L24
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L24
    L18:
        if (r105.hasNext() == false) goto L20;
        String r106 = r105.next();     // Catch: Exception -> L24
        r103.put(r106, r104.get(r106));     // Catch: Exception -> L24
        goto L18
    L20:
        r103.put(ST.UUID_DEVICE, r100);     // Catch: Exception -> L24
        UploadEventManager.instance.addEvent(r103);     // Catch: Exception -> L24
        r102 = r102 + 1;
    L9:
        r101 = null;
        goto L10
    L5:
        if (r100.length() > 0) goto L25;
        goto L6
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String getStringFromExtern(int r100) {
        if (r100 != 0) goto L4;
        BDImageXUploaderAbstractListener r101 = this.mAbstractListener;
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
        BDImageXUploaderListener r104 = this.mListener;
        if (r104 != null) goto L9;
        return true;
    L9:
        BDImageXInfo r105 = (BDImageXInfo) r102;
        if (r105 == null) goto L12;
        long r106 = r105.mProgress;
    L14:
        if (r101 != 124) goto L16;
        r106 = r100.arg1;
    L16:
        r104.onNotify(r101, r106, r105);
        return true;
    L12:
        r106 = 0;
        goto L14
    }

    public void setAbstractListener(BDImageXUploaderAbstractListener r100) {
        this.mAbstractListener = r100;
    }

    public void setConfig(TreeMap<String, Object> r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 == null) goto L12;
        String r101 = BDUploadUtil.mapToString(r100);
        if (r101 == null) goto L11;
        setStringValue(56, r101);
        return;
    L11:
        return;
    L12:
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

    public void setEnableCommitUpload(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 401, r100);
    }

    public void setEnableEnd2EndEncryption(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        this.mEnd2EndEncryptionOption = r100;
        _setIntValue(r101, UploadKeys.KeyIsEnd2EndEncryptionOption, r100);
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

    public void setEnableSkipMeta(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, UploadKeys.KeyIsSkipMeta, r100 ? 1 : 0);
    }

    public void setEnd2EndEncryptionAESKey(String r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        this.mEnd2EndEncryptionAESKey = r100;
        _setStringValue(r101, 441, r100);
    }

    public void setEnd2EndEncryptionPublicKey(String r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setStringValue(r101, 440, r100);
    }

    public void setFileExtension(String r100) {
        setStringValue(1010, r100);
    }

    public void setFileNum(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 <= 0) goto L9;
        this.mImageNum = r100;
        _setFileNum(r101, r100);
        return;
    L9:
        return;
    }

    public void setFilePrefix(String r100) {
        setStringValue(1011, r100);
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

    public void setListener(BDImageXUploaderListener r100) {
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

    public void setPolicyParams(TreeMap<String, Object> r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 == null) goto L12;
        String r101 = BDUploadUtil.mapToString(r100);
        if (r101 == null) goto L11;
        setStringValue(55, r101);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void setProcessActionType(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 65, r100);
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

    public void setServiceID(String r100) {
        setStringValue(45, r100);
    }

    public void setSliceRetryCount(int r100) {
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

    public void setSliceThreshold(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 402, r100);
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
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        setStringValue(46, r100);
        return;
    L9:
        return;
    }

    public void setEnableCommitUpload(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setIntValue(r101, 401, r100 ? 1 : 0);
    }

    public int checkNet(int r100, int r101) {
        BDImageXUploaderListener r102 = this.mListener;
        if (r102 != null) goto L5;
        return 1;
    L5:
        return r102.imageXUploadCheckNetState(r100, r101);
    }

    public void setFileData(int r100, byte[][] r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        _setFileData(r102, r100, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileName(int r100, String[] r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        _setFileName(r102, r100, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileNum(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L8;
        if (r100 <= 0) goto L9;
        this.mImageNum = r100;
        _setFileNum(r102, r100);
        _setIntValue(this.mHandle, 438, r101);
        return;
    L9:
        return;
    }

    public void setFilePath(int r100, String[] r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        this.mImageNum = r100;
        _setFilePaths(r102, r100, r101);
        _setIntValue(this.mHandle, 81, 0);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setFileStoreKeys(int r100, String[] r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r101 == null) goto L10;
        if (r100 <= 0) goto L11;
        _setFileStoreKeys(r102, r100, r101);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setMediaDataReader(BDMediaDataReader r100, int r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L9;
        if (r100 == null) goto L10;
        if (r101 <= 0) goto L11;
        _setIntValue(r102, 71, r101);
        _setIntValue(this.mHandle, 81, 2);
        _setObject(this.mHandle, 201, r100);
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

    private void setMediaDataReader(BDMediaDataReader r100, int r101, int r102) {
        if (this.mHandle == 0) goto L9;
        if (r100 == null) goto L10;
        if (r101 <= 0) goto L11;
        setMediaDataReader(r100, r101);
        _setIntValue(this.mHandle, 81, r102);
        return;
    L11:
        return;
    L10:
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
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (r100 != 103) goto L9;
        long r103 = new Date().getTime();
        BDImageXUploaderAbstractListener r104 = this.mAbstractListener;
        if (r104 == null) goto L9;
        r104.onUploadStage(r101, r103);
    L9:
        this.mListener.onLog(r100, r101, r102);
    }

    public void onNotify(int r110, long r111, int r112, String r113) {
        int r100 = 1;
        if (this.mState == 1) goto L5;
        return;
    L5:
        int r114 = (int) r111;
        BDImageXInfo r101 = null;
        if (r110 == 0) goto L36;
        if (r110 != 1) goto L9;
        BDImageXInfo r115 = new BDImageXInfo(null, r112, r114, null, null, null);
    L35:
        r101 = r115;
    L42:
        Message r116 = this.mHandler.obtainMessage();
        r116.what = r110;
        r116.arg1 = r114;
        r116.obj = r101;
        r116.sendToTarget();
        return;
    L9:
        if (r110 == 2) goto L28;
        if (r110 != 3) goto L12;
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L42
    L12:
        if (r110 != 6) goto L14;
        this.mEndTime = System.currentTimeMillis();
        r101 = new BDImageXInfo(_getStrByKeyAndIndex(this.mHandle, 409, r114), 0, r114, _getStrByKeyAndIndex(this.mHandle, 410, r114), _getStrByKeyAndIndex(this.mHandle, 407, r114), new BDImageXE2EEncryptionInfo(getEnd2EndEncryptionAESKey(), null, null));
        goto L42
    L14:
        if (r110 != 7) goto L16;
        r115 = new BDImageXInfo(null, r112, r114, null, null, null);
        r115.mErrorMsg = r113;
        goto L35
    L16:
        if (r110 != 123) goto L18;
        r115 = new BDImageXInfo(null, r114, r114, null, null, null);
        goto L35
    L18:
        if (r110 != 124) goto L42;
        if (r114 == 0) goto L23;
        r100 = 0;
    L23:
        r114 = r100;
        goto L42
    L28:
        String r117 = getDNSIP();
        if (r117 != null) goto L31;
    L33:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 2;
        goto L42
    L31:
        if (r117.isEmpty() == true) goto L33;
        setStringValue(75, r117);
        goto L33
    L36:
        String r118 = getDNSIP();
        if (r118 != null) goto L39;
    L41:
        addLogToManager(_getStringValue(this.mHandle, 100));
        this.mState = 3;
        goto L42
    L39:
        if (r118.isEmpty() == true) goto L41;
        setStringValue(75, r118);
        goto L41
    }
}
