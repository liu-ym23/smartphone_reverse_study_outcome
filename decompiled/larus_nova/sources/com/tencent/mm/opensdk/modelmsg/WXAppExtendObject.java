package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String r100, String r101) {
        this.extInfo = r100;
        this.filePath = r101;
    }

    public WXAppExtendObject(String r100, byte[] r101) {
        this.extInfo = r100;
        this.fileData = r101;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.extInfo;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.filePath;
        if (r101 != null) goto L9;
    L10:
        byte[] r102 = this.fileData;
        if (r102 != null) goto L13;
    L39:
        String r103 = "checkArgs fail, all arguments is null";
    L20:
        Log.e(TAG, r103);
        return false;
    L13:
        if (r102.length == 0) goto L39;
    L15:
        String r104 = this.extInfo;
        if (r104 != null) goto L18;
    L22:
        String r105 = this.filePath;
        if (r105 != null) goto L25;
    L27:
        String r106 = this.filePath;
        if (r106 != null) goto L30;
    L32:
        byte[] r107 = this.fileData;
        if (r107 != null) goto L35;
        return true;
    L35:
        if (r107.length <= 10485760) goto L40;
        r103 = "checkArgs fail, fileData is too large";
        goto L20
    L40:
        return true;
    L30:
        if (getFileSize(r106) <= 10485760) goto L32;
        r103 = "checkArgs fail, fileSize is too large";
        goto L20
    L25:
        if (r105.length() <= 10240) goto L27;
        r103 = "checkArgs fail, filePath is invalid";
        goto L20
    L18:
        if (r104.length() <= 2048) goto L22;
        r103 = "checkArgs fail, extInfo is invalid";
        goto L20
    L9:
        if (r101.length() != 0) goto L15;
    L5:
        if (r100.length() != 0) goto L15;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxappextendobject_extInfo", this.extInfo);
        r100.putByteArray("_wxappextendobject_fileData", this.fileData);
        r100.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.extInfo = r100.getString("_wxappextendobject_extInfo");
        this.fileData = r100.getByteArray("_wxappextendobject_fileData");
        this.filePath = r100.getString("_wxappextendobject_filePath");
    }
}
