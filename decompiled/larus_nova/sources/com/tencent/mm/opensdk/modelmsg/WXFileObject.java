package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXFileObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 1920991232;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
    }

    public WXFileObject(String r100) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = r100;
    }

    public WXFileObject(byte[] r100) {
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = r100;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        byte[] r100 = this.fileData;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.filePath;
        if (r101 != null) goto L9;
    L25:
        String r102 = "checkArgs fail, both arguments is null";
    L16:
        Log.e(TAG, r102);
        return false;
    L9:
        if (r101.length() == 0) goto L25;
    L11:
        byte[] r103 = this.fileData;
        if (r103 != null) goto L14;
    L18:
        String r104 = this.filePath;
        if (r104 != null) goto L21;
        return true;
    L21:
        if (getFileSize(r104) <= this.contentLengthLimit) goto L26;
        r102 = "checkArgs fail, fileSize is too large";
        goto L16
    L26:
        return true;
    L14:
        if (r103.length <= this.contentLengthLimit) goto L18;
        r102 = "checkArgs fail, fileData is too large";
        goto L16
    L5:
        if (r100.length != 0) goto L11;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putByteArray("_wxfileobject_fileData", this.fileData);
        r100.putString("_wxfileobject_filePath", this.filePath);
    }

    public void setContentLengthLimit(int r100) {
        this.contentLengthLimit = r100;
    }

    public void setFileData(byte[] r100) {
        this.fileData = r100;
    }

    public void setFilePath(String r100) {
        this.filePath = r100;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.fileData = r100.getByteArray("_wxfileobject_fileData");
        this.filePath = r100.getString("_wxfileobject_filePath");
    }
}
