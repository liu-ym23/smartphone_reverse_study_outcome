package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public abstract class WXChannelBaseJumpInfo implements IWXChannelJumpInfo {
    private static final String TAG = "MicroMsg.SDK.WXChannelBaseJumpInfo";
    private static final int WORDING_LENGTH_LIMIT = 1024;
    public String extra;
    public String wording;

    public WXChannelBaseJumpInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public boolean checkArgs() {
        String r100 = this.wording;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length() < 1024) goto L10;
        Log.e(TAG, "checkArgs fail, wording is invalid");
        return false;
    L10:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void serialize(Bundle r100) {
        r100.putString("wx_channel_jump_base_wording", this.wording);
        r100.putString("wx_channel_jump_base_extra", this.extra);
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void unserialize(Bundle r100) {
        this.wording = r100.getString("wx_channel_jump_base_wording");
        this.extra = r100.getString("wx_channel_jump_base_extra");
    }
}
