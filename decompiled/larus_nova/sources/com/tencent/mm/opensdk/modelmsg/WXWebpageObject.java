package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
    public String canvasPageXml;
    public String extInfo;
    public HashMap<String, String> extraInfoMap;
    public boolean isSecretMessage;
    public String webpageUrl;

    public WXWebpageObject() {
        this.isSecretMessage = false;
        this.extraInfoMap = null;
    }

    public WXWebpageObject(String r100) {
        this.isSecretMessage = false;
        this.extraInfoMap = null;
        this.webpageUrl = r100;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.webpageUrl;
        if (r100 != null) goto L5;
    L11:
        Log.e(TAG, "checkArgs fail, webpageUrl is invalid");
        return false;
    L5:
        if (r100.length() == 0) goto L11;
        if (this.webpageUrl.length() > 10240) goto L11;
        return true;
    }

    public String getExtra(String r100, String r101) {
        HashMap<String, String> r102 = this.extraInfoMap;
        if (r102 == null) goto L8;
        String r103 = r102.get(r100);
        if (r103 != null) goto L7;
        return r101;
    L7:
        return r103;
    L8:
        return null;
    }

    public void putExtra(String r100, String r101) {
        if (this.extraInfoMap != null) goto L6;
        this.extraInfoMap = new HashMap();
    L6:
        if (b.b(r100) == true) goto L9;
        this.extraInfoMap.put(r100, r101);
        return;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxwebpageobject_extInfo", this.extInfo);
        r100.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
        r100.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
        r100.putBoolean("_wxwebpageobject_issecretmsg", this.isSecretMessage);
        HashMap<String, String> r101 = this.extraInfoMap;
        if (r101 == null) goto L6;
        r100.putSerializable("_wxwebpageobject_extrainfo", r101);
        return;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.extInfo = r100.getString("_wxwebpageobject_extInfo");
        this.webpageUrl = r100.getString("_wxwebpageobject_webpageUrl");
        this.canvasPageXml = r100.getString("_wxwebpageobject_canvaspagexml");
        this.isSecretMessage = r100.getBoolean("_wxwebpageobject_issecretmsg");
        Serializable r101 = r100.getSerializable("_wxwebpageobject_extrainfo");
        if (r101 == null) goto L6;
        this.extraInfoMap = (HashMap) r101;
        return;
    }
}
