package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXStateJumpUrlInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    public String jumpUrl;

    public WXStateJumpUrlInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public boolean checkArgs() {
        String r100 = this.jumpUrl;
        if (r100 != null) goto L5;
    L14:
        String r101 = "checkArgs fail, jumpUrl is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() <= 0) goto L14;
        if (this.jumpUrl.length() < 10240) goto L12;
        r101 = "checkArgs fail, jumpUrl is invalid";
        goto L10
    L12:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void serialize(Bundle r100) {
        r100.putString("wx_state_jump_url", this.jumpUrl);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void unserialize(Bundle r100) {
        this.jumpUrl = r100.getString("wx_state_jump_url", "");
    }
}
