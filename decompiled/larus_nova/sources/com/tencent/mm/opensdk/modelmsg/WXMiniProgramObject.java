package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public int disableforward;
    private HashMap<String, String> extraInfoMap;
    public boolean isSecretMessage;
    public boolean isUpdatableMessage;
    public int miniprogramType;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public WXMiniProgramObject() {
        this.miniprogramType = 0;
        this.disableforward = 0;
        this.isUpdatableMessage = false;
        this.isSecretMessage = false;
        this.extraInfoMap = null;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
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
        r100.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        r100.putString("_wxminiprogram_username", this.userName);
        r100.putString("_wxminiprogram_path", this.path);
        r100.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        r100.putInt("_wxminiprogram_type", this.miniprogramType);
        r100.putInt("_wxminiprogram_disableforward", this.disableforward);
        r100.putBoolean("_wxminiprogram_isupdatablemsg", this.isUpdatableMessage);
        r100.putBoolean("_wxminiprogram_issecretmsg", this.isSecretMessage);
        HashMap<String, String> r101 = this.extraInfoMap;
        if (r101 == null) goto L6;
        r100.putSerializable("_wxminiprogram_extrainfo", r101);
        return;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 36;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.webpageUrl = r100.getString("_wxminiprogram_webpageurl");
        this.userName = r100.getString("_wxminiprogram_username");
        this.path = r100.getString("_wxminiprogram_path");
        this.withShareTicket = r100.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = r100.getInt("_wxminiprogram_type");
        this.disableforward = r100.getInt("_wxminiprogram_disableforward");
        this.isUpdatableMessage = r100.getBoolean("_wxminiprogram_isupdatablemsg");
        this.isSecretMessage = r100.getBoolean("_wxminiprogram_issecretmsg");
        this.extraInfoMap = (HashMap) r100.getSerializable("_wxminiprogram_extrainfo");
    }
}
