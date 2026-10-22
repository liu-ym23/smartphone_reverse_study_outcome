package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXEmojiPageSharedObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXEmojiSharedObject";
    public String desc;
    public String iconUrl;
    public int pageType;
    public String secondUrl;
    public int tid;
    public String title;
    public int type;
    public String url;

    public WXEmojiPageSharedObject() {
    }

    public WXEmojiPageSharedObject(int r100, int r101, String r102, String r103, String r104, String r105, int r106, String r107) {
        this.tid = r101;
        this.title = r102;
        this.desc = r103;
        this.iconUrl = r104;
        this.secondUrl = r105;
        this.pageType = r106;
        this.url = r107;
        this.type = r100;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (b.b(this.title) == false) goto L5;
    L9:
        Log.e(TAG, "checkArgs fail, title or iconUrl is invalid");
        return false;
    L5:
        if (b.b(this.iconUrl) == true) goto L9;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putInt("_wxemojisharedobject_tid", this.tid);
        r100.putString("_wxemojisharedobject_title", this.title);
        r100.putString("_wxemojisharedobject_desc", this.desc);
        r100.putString("_wxemojisharedobject_iconurl", this.iconUrl);
        r100.putString("_wxemojisharedobject_secondurl", this.secondUrl);
        r100.putInt("_wxemojisharedobject_pagetype", this.pageType);
        r100.putString("_wxwebpageobject_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return this.type;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.tid = r100.getInt("_wxemojisharedobject_tid");
        this.title = r100.getString("_wxemojisharedobject_title");
        this.desc = r100.getString("_wxemojisharedobject_desc");
        this.iconUrl = r100.getString("_wxemojisharedobject_iconurl");
        this.secondUrl = r100.getString("_wxemojisharedobject_secondurl");
        this.pageType = r100.getInt("_wxemojisharedobject_pagetype");
        this.url = r100.getString("_wxwebpageobject_url");
    }
}
