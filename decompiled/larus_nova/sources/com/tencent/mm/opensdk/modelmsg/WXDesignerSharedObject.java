package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXDesignerSharedObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public String thumburl;
    public String url;

    public WXDesignerSharedObject() {
    }

    public WXDesignerSharedObject(String r100, int r101, String r102, String r103) {
        this.url = r102;
        this.thumburl = r100;
        this.designerUIN = r101;
        this.designerName = r103;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (this.designerUIN != 0) goto L5;
    L11:
        Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    L5:
        if (TextUtils.isEmpty(this.thumburl) == true) goto L11;
        if (TextUtils.isEmpty(this.url) == true) goto L11;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxemojisharedobject_thumburl", this.thumburl);
        r100.putInt("_wxemojisharedobject_designer_uin", this.designerUIN);
        r100.putString("_wxemojisharedobject_designer_name", this.designerName);
        r100.putString("_wxemojisharedobject_designer_rediretcturl", this.designerRediretctUrl);
        r100.putString("_wxemojisharedobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 25;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.thumburl = r100.getString("_wxwebpageobject_thumburl");
        this.designerUIN = r100.getInt("_wxemojisharedobject_designer_uin");
        this.designerName = r100.getString("_wxemojisharedobject_designer_name");
        this.designerRediretctUrl = r100.getString("_wxemojisharedobject_designer_rediretcturl");
        this.url = r100.getString("_wxwebpageobject_url");
    }
}
