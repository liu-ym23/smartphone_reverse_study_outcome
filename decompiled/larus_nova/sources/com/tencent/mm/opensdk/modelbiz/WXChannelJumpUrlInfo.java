package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelJumpUrlInfo extends WXChannelBaseJumpInfo {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXChannelJumpUrlInfo";
    public String url;

    public WXChannelJumpUrlInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public boolean checkArgs() {
        String r100 = this.url;
        if (r100 != null) goto L5;
    L14:
        String r101 = "checkArgs fail, url is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() <= 0) goto L14;
        if (this.url.length() < 10240) goto L12;
        r101 = "checkArgs fail, url is invalid";
        goto L10
    L12:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void serialize(Bundle r100) {
        super.serialize(r100);
        r100.putString("wx_channel_jump_url", this.url);
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void unserialize(Bundle r100) {
        super.unserialize(r100);
        this.url = r100.getString("wx_channel_jump_url");
    }
}
