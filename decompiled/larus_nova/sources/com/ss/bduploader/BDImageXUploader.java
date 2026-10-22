package com.ss.bduploader;

import android.text.TextUtils;
import java.util.TreeMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class BDImageXUploader extends BDImageXUploaderBase {
    public void setPreUpload(boolean r100) {
    }

    public void startPreHeat() {
        setPreheatUploader(2);
        start();
    }

    public void allowContinueUpload() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        BDImageXUploaderBase._allowContinueUpload(r100);
    }

    public void allowMergeUpload() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        BDImageXUploaderBase._mergeUpload(r100);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.mWriteLock.unlock();
        return;
    L6:
        BDImageXUploaderBase._cancelUpload(r100);
        this.mWriteLock.unlock();
    }

    public BDImageXUploader() throws Exception {
    }

    public void SetExtraParams(JSONObject r100) {
        if (this.mHandle == 0) goto L8;
        if (r100 == null) goto L9;
        setStringValue(61, r100.toString());
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
        BDImageXUploaderBase._setIntValue(r101, 411, r100);
        return;
    L9:
        return;
    }

    public void setObjectType(String r100) {
        setStringValue(54, r100);
    }

    public void setPreUploadEncryptionMode(int r100) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (r100 != 2) goto L12;
        String r101 = UUID.randomUUID().toString();
        if (r101 == null) goto L12;
        if (r101.length() <= 0) goto L12;
        BDImageXUploaderBase._setStringValue(this.mHandle, 420, r101);
    L12:
        BDImageXUploaderBase._setIntValue(this.mHandle, 74, r100);
    }

    public void setPreheatUploader(int r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDImageXUploaderBase._setIntValue(r101, 419, r100);
    }

    public void setPreheatUploader(boolean r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        BDImageXUploaderBase._setIntValue(r101, 419, r100 ? 1 : 0);
    }

    public void setCustomNetworkTimeoutParams(int r100, int r101, int r102, int r103, int r110) {
        long r104 = this.mHandle;
        if (r104 != 0) goto L5;
        return;
    L5:
        BDImageXUploaderBase._setIntValue(r104, 422, r100);
        BDImageXUploaderBase._setIntValue(this.mHandle, 423, r101);
        BDImageXUploaderBase._setIntValue(this.mHandle, 424, r102);
        BDImageXUploaderBase._setIntValue(this.mHandle, 425, r103);
        BDImageXUploaderBase._setIntValue(this.mHandle, 427, r110);
    }
}
