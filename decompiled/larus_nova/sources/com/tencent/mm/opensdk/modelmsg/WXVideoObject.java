package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXVideoObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    public WXVideoObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.videoUrl;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.videoLowBandUrl;
        if (r101 != null) goto L9;
    L25:
        String r102 = "both arguments are null";
    L16:
        Log.e(TAG, r102);
        return false;
    L9:
        if (r101.length() == 0) goto L25;
    L11:
        String r103 = this.videoUrl;
        if (r103 != null) goto L14;
    L18:
        String r104 = this.videoLowBandUrl;
        if (r104 != null) goto L21;
        return true;
    L21:
        if (r104.length() <= 10240) goto L26;
        r102 = "checkArgs fail, videoLowBandUrl is too long";
        goto L16
    L26:
        return true;
    L14:
        if (r103.length() <= 10240) goto L18;
        r102 = "checkArgs fail, videoUrl is too long";
        goto L16
    L5:
        if (r100.length() != 0) goto L11;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxvideoobject_videoUrl", this.videoUrl);
        r100.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 4;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.videoUrl = r100.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = r100.getString("_wxvideoobject_videoLowBandUrl");
    }
}
