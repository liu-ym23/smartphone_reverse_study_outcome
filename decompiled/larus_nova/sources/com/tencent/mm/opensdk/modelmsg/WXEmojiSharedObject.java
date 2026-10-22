package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXEmojiSharedObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject() {
    }

    public WXEmojiSharedObject(String r100, int r101, String r102, String r103) {
        this.thumburl = r100;
        this.packageflag = r101;
        this.packageid = r102;
        this.url = r103;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (TextUtils.isEmpty(this.packageid) == false) goto L5;
    L13:
        Log.e(TAG, "checkArgs fail, packageid or thumburl is invalid");
        return false;
    L5:
        if (TextUtils.isEmpty(this.thumburl) == true) goto L13;
        if (TextUtils.isEmpty(this.url) == true) goto L13;
        if (this.packageflag == (-1)) goto L13;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxemojisharedobject_thumburl", this.thumburl);
        r100.putInt("_wxemojisharedobject_packageflag", this.packageflag);
        r100.putString("_wxemojisharedobject_packageid", this.packageid);
        r100.putString("_wxemojisharedobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 15;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.thumburl = r100.getString("_wxwebpageobject_thumburl");
        this.packageflag = r100.getInt("_wxwebpageobject_packageflag");
        this.packageid = r100.getString("_wxwebpageobject_packageid");
        this.url = r100.getString("_wxwebpageobject_url");
    }
}
