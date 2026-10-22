package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXDynamicVideoMiniProgramObject extends WXMiniProgramObject {
    private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
    public String appThumbUrl;
    public String videoSource;

    public WXDynamicVideoMiniProgramObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (b.b(this.webpageUrl) == false) goto L8;
        String r100 = "webPageUrl is null";
    L5:
        Log.e(TAG, r100);
        return false;
    L8:
        if (b.b(this.userName) == false) goto L10;
        r100 = "userName is null";
        goto L5
    L10:
        int r101 = this.miniprogramType;
        if (r101 >= 0) goto L13;
    L17:
        r100 = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
        goto L5
    L13:
        if (r101 > 2) goto L17;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        r100.putString("_wxminiprogram_username", this.userName);
        r100.putString("_wxminiprogram_path", this.path);
        r100.putString("_wxminiprogram_videoSource", this.videoSource);
        r100.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
        r100.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        r100.putInt("_wxminiprogram_type", this.miniprogramType);
        r100.putInt("_wxminiprogram_disableforward", this.disableforward);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 46;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.webpageUrl = r100.getString("_wxminiprogram_webpageurl");
        this.userName = r100.getString("_wxminiprogram_username");
        this.path = r100.getString("_wxminiprogram_path");
        this.videoSource = r100.getString("_wxminiprogram_videoSource");
        this.appThumbUrl = r100.getString("_wxminiprogram_appThumbUrl");
        this.withShareTicket = r100.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = r100.getInt("_wxminiprogram_type");
        this.disableforward = r100.getInt("_wxminiprogram_disableforward");
    }
}
