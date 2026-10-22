package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes40.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;
    public String imgDataHash;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L5
        r100.compress(Bitmap.CompressFormat.JPEG, 85, r101);     // Catch: Exception -> L5
        this.imageData = r101.toByteArray();     // Catch: Exception -> L5
        r101.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "WXImageObject <init>, exception:" + e.getMessage());
    }

    public WXImageObject(byte[] r100) {
        this.imageData = r100;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        byte[] r100 = this.imageData;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.imagePath;
        if (r101 != null) goto L9;
    L30:
        String r102 = "checkArgs fail, all arguments are null";
    L16:
        Log.e(TAG, r102);
        return false;
    L9:
        if (r101.length() == 0) goto L30;
    L11:
        byte[] r103 = this.imageData;
        if (r103 != null) goto L14;
    L18:
        String r104 = this.imagePath;
        if (r104 != null) goto L21;
    L23:
        String r105 = this.imagePath;
        if (r105 != null) goto L26;
        return true;
    L26:
        if (getFileSize(r105) <= CONTENT_LENGTH_LIMIT) goto L31;
        r102 = "checkArgs fail, image content is too large";
        goto L16
    L31:
        return true;
    L21:
        if (r104.length() <= 10240) goto L23;
        r102 = "checkArgs fail, path is invalid";
        goto L16
    L14:
        if (r103.length <= CONTENT_LENGTH_LIMIT) goto L18;
        r102 = "checkArgs fail, content is too large";
        goto L16
    L5:
        if (r100.length != 0) goto L11;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putByteArray("_wximageobject_imageData", this.imageData);
        r100.putString("_wximageobject_imagePath", this.imagePath);
        r100.putString("_wximageobject_imgDataHash", this.imgDataHash);
    }

    public void setImagePath(String r100) {
        this.imagePath = r100;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.imageData = r100.getByteArray("_wximageobject_imageData");
        this.imagePath = r100.getString("_wximageobject_imagePath");
        this.imgDataHash = r100.getString("_wximageobject_imgDataHash");
    }
}
