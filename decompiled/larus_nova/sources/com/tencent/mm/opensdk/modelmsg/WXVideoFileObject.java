package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXVideoFileObject implements WXMediaMessage.IMediaObject {
    public static final int FILE_SIZE_LIMIT = 1073741824;
    private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public String filePath;
    public int shareScene;
    public String shareTicket;

    public WXVideoFileObject() {
        this.shareScene = 0;
        this.filePath = null;
    }

    public WXVideoFileObject(String r100) {
        this.shareScene = 0;
        this.filePath = r100;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.filePath;
        if (r100 != null) goto L5;
    L14:
        String r101 = "checkArgs fail, filePath is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() == 0) goto L14;
        if (getFileSize(this.filePath) <= 1073741824) goto L12;
        r101 = "checkArgs fail, video file size is too large";
        goto L10
    L12:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxvideofileobject_filePath", this.filePath);
        r100.putInt("_wxvideofileobject_shareScene", this.shareScene);
        r100.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 38;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.filePath = r100.getString("_wxvideofileobject_filePath");
        this.shareScene = r100.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = r100.getString("_wxvideofileobject_shareTicketh");
    }
}
