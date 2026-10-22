package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXLiteAppObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXLiteAppObject";
    public String path;
    public String query;
    public int source;
    public String userName;
    public String webpageUrl;

    public WXLiteAppObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (b.b(this.userName) == false) goto L6;
        Log.e(TAG, "userName is null");
        return false;
    L6:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxliteapp_webpageurl", this.webpageUrl);
        r100.putString("_wxliteapp_username", this.userName);
        r100.putString("_wxliteapp_path", this.path);
        r100.putString("_wxliteapp_query", this.query);
        r100.putInt("_wxliteapp_source", this.source);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 68;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.webpageUrl = r100.getString("_wxliteapp_webpageurl");
        this.userName = r100.getString("_wxliteapp_username");
        this.path = r100.getString("_wxliteapp_path");
        this.query = r100.getString("_wxliteapp_query");
        this.source = r100.getInt("_wxliteapp_source");
    }
}
