package com.ss.bduploader;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.bduploader.smartserver.SmartRouting;
import java.util.Objects;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDVideoUploader extends BDVideoUploaderBase {
    public static final int RoutingQUIC = 0;
    public static final int RoutingTCP = 1;
    private boolean hasInit;
    private int mEstimatedFileSize;
    private int mEstimatedVideoDuration;
    private JSONObject mEstimatedVideoInfo;
    private int mEstimatedVideoRate;
    private SmartRouting mSmartRouting;

    private void preloadModel() {
        SmartRouting r100 = this.mSmartRouting;
        if (r100 == null) goto L6;
        r100.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void allowMergeUpload() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._mergeUpload(r100);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.mWriteLock.unlock();
        return;
    L6:
        BDVideoUploaderBase._cancelUpload(r100);
        this.mWriteLock.unlock();
    }

    public BDVideoUploader() throws Exception {
        this.hasInit = false;
        this.mEstimatedVideoRate = 0;
        this.mEstimatedVideoDuration = 0;
        this.mEstimatedFileSize = -1;
    }

    private void checkAndInit(String r100) {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        SmartRouting r101 = new SmartRouting();
        this.mSmartRouting = r101;
        r101.init();
        this.mSmartRouting.parseUrl(r100);
        this.mSmartRouting.configServer();
    }

    private String insertFileSizeInfo(String r100) {
        int r101 = this.mEstimatedVideoDuration * this.mEstimatedVideoRate;     // Catch: Exception -> L8
        if (r101 > 0) goto L6;
        r101 = this.mEstimatedFileSize;     // Catch: Exception -> L8
    L6:
        this.mEstimatedFileSize = r101;     // Catch: Exception -> L8
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L8
        r102.put("est_file_size", this.mEstimatedFileSize / 1024);     // Catch: Exception -> L8
    L9:
        if (r102 != null) goto L12;
        return r100;
    L12:
        return r102.toString();
    L8:
        r102 = null;
        goto L9
    }

    private float predictIntelligentTCPQUIC(String r100) {
        if (this.mSmartRouting != null) goto L9;
        return -1.0f;
    L9:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
        return this.mSmartRouting.predictSpeedSync(r101);
    L8:
        return -1.0f;
    }

    private JSONObject processIntelligentPrediction(float r100) {
        JSONObject r101 = new JSONObject();
        if (r100 >= 0.0f) goto L5;
    L15:
        return null;
    L5:
        if (r100 > 1.0f) goto L15;
        if (r100 < 0.5d) goto L10;
        r101.put("intelligentRoutingResult", 1);     // Catch: JSONException -> L13
    L16:
        return r101;
    L10:
        r101.put("intelligentRoutingResult", 0);     // Catch: JSONException -> L13
    L19:
        return null;
    }

    public void setAuthType(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 416, r100);
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

    public void setContext(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        BDVideoUploaderBase._setContext(r101, r100);
        return;
    L9:
        return;
    }

    public void setCustomConfig(TreeMap<String, Object> r100) {
        if (this.mHandle == 0) goto L21;
        if (r100 == null) goto L22;
        JSONObject r101 = BDUploadUtil.mapToJSON(r100);
        if (r101 != null) goto L9;
        return;
    L9:
        JSONObject r102 = new JSONObject();
        r102.put("custom_config", r101);     // Catch: Throwable -> L15
        String r103 = r102.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r103) == true) goto L20;
        setStringValue(63, r103);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public void setDataTransportProtocol(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        BDVideoUploaderBase._setIntValue(r101, 411, r100);
        return;
    L9:
        return;
    }

    public void setEstimatedVideoInfo(TreeMap<String, Object> r100) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L18;
        JSONObject r101 = BDUploadUtil.mapToJSON(r100);
        this.mEstimatedVideoInfo = r101;
        if (r101 != null) goto L10;
        return;
    L10:
        Objects.toString(r101);
        this.mEstimatedVideoDuration = JSONObjectProtectorUtils.getInt(this.mEstimatedVideoInfo, "durationMs") / 1000;     // Catch: JSONException -> L13
        this.mEstimatedVideoRate = JSONObjectProtectorUtils.getInt(this.mEstimatedVideoInfo, "bitrateKb");     // Catch: JSONException -> L13
        BDVideoUploaderBase._setStringValue(this.mHandle, UploadKeys.KeyIsEstimatedVideoInfo, this.mEstimatedVideoInfo.toString());     // Catch: JSONException -> L13
        Objects.toString(this.mEstimatedVideoInfo);     // Catch: JSONException -> L13
        return;
    L14:
        return;
    }

    public void setExternFileReader(BDExternalFileReader r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        BDVideoUploaderBase._setIntValue(r101, 71, 1);
        BDVideoUploaderBase._setObject(this.mHandle, 200, r100);
        return;
    L9:
        return;
    }

    public void setExternMinSIze(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 <= 0) goto L9;
        BDVideoUploaderBase._setIntValue(r101, 77, r100);
        return;
    L9:
        return;
    }

    public void setExternalReaderMode(int r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 < 0) goto L9;
        BDVideoUploaderBase._setIntValue(r101, 412, r100);
        return;
    L9:
        return;
    }

    public void setPolicyParams(TreeMap<String, Object> r100) {
        if (this.mHandle == 0) goto L10;
        if (r100 == null) goto L12;
        String r101 = BDUploadUtil.mapToString(r100);
        if (TextUtils.isEmpty(r101) == true) goto L11;
        setStringValue(55, r101);
        return;
    L11:
        return;
    L12:
        return;
    }

    @Override // com.ss.bduploader.BDVideoUploaderBase
    public void setPreUploadEncryptionMode(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 74, r100);
    }

    public void setPrivateVideo(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 414, r100 ? 1 : 0);
    }

    public void setProcessActionType(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 65, r100);
    }

    public void setQueryAuth(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        BDVideoUploaderBase._setStringValue(r101, 15, r100);
        return;
    L9:
        return;
    }

    public void setRetryStatesOption(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, BDAbstractUpload.KeyIsRetryStatesOption, r100);
    }

    public void setSkipCode2ndFileSize(long r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setInt64Value(r101, BDVideoUploaderBase.KeyIsSkipCode2ndFileSize, r100);
    }

    public void setSpeedTestThresh(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 406, r100);
    }

    public void setSpeedTestValue(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, 405, r100);
    }

    public void setTTNetEngineFallbackOption(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r101, UploadKeys.KeyIsTTNetEngineFallback, r100);
    }

    public void setUserReference(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        BDVideoUploaderBase._setStringValue(r101, 62, r100);
        return;
    L9:
        return;
    }

    public void setVideoMetaData(String r100) {
        long r101 = this.mHandle;
        if (r101 == 0) goto L8;
        if (r100 == null) goto L9;
        BDVideoUploaderBase._setStringValue(r101, BDVideoUploaderBase.KeyIsVideoMetaData, r100);
        return;
    L9:
        return;
    }

    @Override // com.ss.bduploader.BDAbstractUpload
    public String intelligentInterface(int r100, String r101) {
        if (r100 != 0) goto L5;
        checkAndInit(r101);
        preloadModel();
    L9:
        JSONObject r102 = null;
    L10:
        if (r102 != null) goto L13;
        return "";
    L13:
        r102.toString();
        return r102.toString();
    L5:
        if (r100 != 1) goto L9;
        r102 = processIntelligentPrediction(predictIntelligentTCPQUIC(insertFileSizeInfo(r101)));
        goto L10
    }

    public void setCustomNetworkTimeoutParams(int r100, int r101, int r102, int r103, int r110) {
        long r104 = this.mHandle;
        if (r104 != 0) goto L5;
        return;
    L5:
        BDVideoUploaderBase._setIntValue(r104, 422, r100);
        BDVideoUploaderBase._setIntValue(this.mHandle, 423, r101);
        BDVideoUploaderBase._setIntValue(this.mHandle, 424, r102);
        BDVideoUploaderBase._setIntValue(this.mHandle, 425, r103);
        BDVideoUploaderBase._setIntValue(this.mHandle, 427, r110);
    }
}
