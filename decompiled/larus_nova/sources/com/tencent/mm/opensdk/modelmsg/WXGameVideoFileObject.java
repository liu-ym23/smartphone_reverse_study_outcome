package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXGameVideoFileObject implements WXMediaMessage.IMediaObject {
    private static final int FILE_SIZE_LIMIT = 104857600;
    private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String filePath;
    public String thumbUrl;
    public String videoUrl;

    public WXGameVideoFileObject() {
        this.filePath = null;
        this.videoUrl = null;
        this.thumbUrl = null;
    }

    public WXGameVideoFileObject(String r100, String r101, String r102) {
        this.filePath = r100;
        this.videoUrl = r101;
        this.thumbUrl = r102;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.filePath;
        if (r100 != null) goto L5;
    L24:
        String r101 = "checkArgs fail, filePath is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() == 0) goto L24;
        if (getFileSize(this.filePath) <= 104857600) goto L12;
        r101 = "checkArgs fail, video file size is too large";
        goto L10
    L12:
        String r102 = this.videoUrl;
        if (r102 != null) goto L15;
    L17:
        String r103 = this.thumbUrl;
        if (r103 != null) goto L20;
        return true;
    L20:
        if (r103.length() <= 10240) goto L25;
        r101 = "checkArgs fail, thumbUrl is too long";
        goto L10
    L25:
        return true;
    L15:
        if (r102.length() <= 10240) goto L17;
        r101 = "checkArgs fail, videoUrl is too long";
        goto L10
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxvideofileobject_filePath", this.filePath);
        r100.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        r100.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 39;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.filePath = r100.getString("_wxvideofileobject_filePath");
        this.videoUrl = r100.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = r100.getString("_wxvideofileobject_thumbUrl");
    }
}
