package com.ttnetuploader.uploader.api;

import com.ttnetuploader.uploader.utils.CommonTools;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class Parameters {
    public static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_IMAGE_JPEG = "image/jpeg";
    public static final String CONTENT_TYPE_IMAGE_PNG = "image/png";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_MULTIPART_FORM = "multipart/form-data";
    public static final String CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    public static final int NET_LIB_OKHTTP = 1;
    public static final int NET_LIB_TTNET = 0;
    public static final int PROTOCOL_ALIYUN = 2;
    public static final int PROTOCOL_LAN = 1;
    public static final int PROTOCOL_NORMAL = 0;
    private long mFileLength;
    private String mFileName;
    private String mFilePath;
    private Map<String, String> mHeaders;
    private boolean mIsForceWifi;
    private boolean mIsHttp;
    private boolean mIsNoProxy;
    private boolean mIsTryFallback;
    private String mMd5;
    private final Map<String, ULMultipartPart> mMultipartBody;
    private int mNetLibType;
    private int mProtocol;
    private int mServerPort;
    private long mSliceLen;
    private String mSn;
    private int mTaskRetryTimes;
    private long mUploadId;
    private String mUrl;
    private IUploadCallback mUserCallback;
    private String mUserDriveId;
    private String mUserFileId;
    private String mUserKey;
    private String mUserUploadId;
    private String mUserUploadUrl;

    public IUploadCallback getCallback() {
        return this.mUserCallback;
    }

    public long getFileLength() {
        return this.mFileLength;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public boolean getIsHttp() {
        return this.mIsHttp;
    }

    public boolean getIsTryFallback() {
        return this.mIsTryFallback;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public Map<String, ULMultipartPart> getMultipartBody() {
        return this.mMultipartBody;
    }

    public int getNetLibType() {
        return this.mNetLibType;
    }

    public int getProtocol() {
        return this.mProtocol;
    }

    public String getSN() {
        return this.mSn;
    }

    public int getServerPort() {
        return this.mServerPort;
    }

    public long getSliceLen() {
        return this.mSliceLen;
    }

    public int getTaskRetryTimes() {
        return this.mTaskRetryTimes;
    }

    public long getUploadId() {
        return this.mUploadId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getUserDriveId() {
        return this.mUserDriveId;
    }

    public String getUserFileId() {
        return this.mUserFileId;
    }

    public Map<String, String> getUserHeaders() {
        return this.mHeaders;
    }

    public String getUserKey() {
        return this.mUserKey;
    }

    public String getUserUploadId() {
        return this.mUserUploadId;
    }

    public String getUserUploadUrl() {
        return this.mUserUploadUrl;
    }

    public boolean isForceWifi() {
        return this.mIsForceWifi;
    }

    public boolean isNoProxy() {
        return this.mIsNoProxy;
    }

    public void setFileLength(long r100) {
        this.mFileLength = r100;
    }

    public void setFileName(String r100) {
        this.mFileName = CommonTools.getNonnullStringValue(r100);
    }

    public void setForceWifi(boolean r100) {
        this.mIsForceWifi = r100;
    }

    public void setIsHttp(boolean r100) {
        this.mIsHttp = r100;
    }

    public void setIsTryFallback(boolean r100) {
        this.mIsTryFallback = r100;
    }

    public void setMd5(String r100) {
        this.mMd5 = CommonTools.getNonnullStringValue(r100);
    }

    public void setNetLibType(int r100) {
        this.mNetLibType = r100;
    }

    public void setNoProxy(boolean r100) {
        this.mIsNoProxy = r100;
    }

    public void setSN(String r100) {
        this.mSn = CommonTools.getNonnullStringValue(r100);
    }

    public void setServerPort(int r100) {
        this.mServerPort = r100;
    }

    public void setSliceLen(long r100) {
        this.mSliceLen = r100;
    }

    public void setTaskRetryTimes(int r100) {
        this.mTaskRetryTimes = r100;
    }

    public void setUrl(String r100) {
        this.mUrl = CommonTools.getNonnullStringValue(r100);
    }

    public void setUserDriveId(String r100) {
        this.mUserDriveId = CommonTools.getNonnullStringValue(r100);
    }

    public void setUserFileId(String r100) {
        this.mUserFileId = CommonTools.getNonnullStringValue(r100);
    }

    public void setUserKey(String r100) {
        this.mUserKey = CommonTools.getNonnullStringValue(r100);
    }

    public void setUserUploadId(String r100) {
        this.mUserUploadId = CommonTools.getNonnullStringValue(r100);
    }

    public void setUserUploadUrl(String r100) {
        this.mUserUploadUrl = CommonTools.getNonnullStringValue(r100);
    }

    public void addMultipartTextSem(String r100, String r101, String r102) {
        Map<String, ULMultipartPart> r103 = this.mMultipartBody;
        monitor-enter(r103);
        this.mMultipartBody.put(r100, new ULMultipartPart(r101, r102));     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addMultipartFileSem(String r100, String r101, String r102, String r103) {
        Map<String, ULMultipartPart> r104 = this.mMultipartBody;
        monitor-enter(r104);
        this.mMultipartBody.put(r100, new ULMultipartPart(r101, r102, r103));     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Parameters(int r100, String r101, String r102, Map<String, String> r110, IUploadCallback r111) {
        this.mUrl = "";
        this.mFilePath = "";
        this.mFileLength = 0;
        this.mProtocol = 1;
        this.mUploadId = 0;
        this.mHeaders = null;
        this.mUserCallback = null;
        this.mMd5 = "";
        this.mIsHttp = false;
        this.mSn = "";
        this.mUserKey = "";
        this.mTaskRetryTimes = 0;
        this.mFileName = "";
        this.mIsTryFallback = true;
        this.mServerPort = CommonTools.getPort(0);
        this.mNetLibType = 0;
        this.mSliceLen = 1073741824;
        this.mUserUploadId = "";
        this.mUserDriveId = "";
        this.mUserFileId = "";
        this.mUserUploadUrl = "";
        this.mIsNoProxy = false;
        this.mMultipartBody = new HashMap();
        this.mIsForceWifi = false;
        this.mProtocol = r100;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.mUrl = r101;
        this.mFilePath = r102;
        if (r110 != null) goto L9;
        r110 = new HashMap();
    L9:
        this.mHeaders = r110;
        this.mUserCallback = r111;
        this.mUploadId = new SecureRandom().nextLong();     // Catch: Exception -> L12
    L14:
        if (this.mProtocol != 1) goto L19;
        this.mTaskRetryTimes = 3;
        return;
    L19:
        return;
    L12:
        this.mUploadId = System.currentTimeMillis() - ((long) r100);
        goto L14
    }
}
