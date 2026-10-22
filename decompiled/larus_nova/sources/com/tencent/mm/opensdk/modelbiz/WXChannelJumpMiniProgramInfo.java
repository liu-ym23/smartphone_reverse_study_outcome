package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelJumpMiniProgramInfo extends WXChannelBaseJumpInfo {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXChannelJumpMiniProgramInfo";
    public String path;
    public String username;

    public WXChannelJumpMiniProgramInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public boolean checkArgs() {
        String r100 = this.username;
        if (r100 != null) goto L5;
    L16:
        String r101 = "checkArgs fail, username is null";
    L12:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() <= 0) goto L16;
        String r102 = this.path;
        if (r102 == null) goto L15;
        if (r102.length() < 10240) goto L15;
        r101 = "checkArgs fail, path is invalid";
    L15:
        return super.checkArgs();
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void serialize(Bundle r100) {
        super.serialize(r100);
        r100.putString("wx_channel_jump_mini_program_username", this.username);
        r100.putString("wx_channel_jump_mini_program_path", this.path);
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void unserialize(Bundle r100) {
        super.unserialize(r100);
        this.username = r100.getString("wx_channel_jump_mini_program_username");
        this.path = r100.getString("wx_channel_jump_mini_program_path");
    }
}
