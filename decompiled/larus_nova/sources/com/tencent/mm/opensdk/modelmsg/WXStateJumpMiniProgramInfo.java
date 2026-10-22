package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXStateJumpMiniProgramInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    public int miniProgramType;
    public String path;
    public String username;

    public WXStateJumpMiniProgramInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public boolean checkArgs() {
        String r100 = this.username;
        if (r100 != null) goto L5;
    L9:
        Log.e(TAG, "checkArgs fail, username is null");
        return false;
    L5:
        if (r100.length() <= 0) goto L9;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void serialize(Bundle r100) {
        r100.putString("wx_state_jump_mini_program_username", this.username);
        r100.putString("wx_state_jump_mini_program_path", this.path);
        r100.putInt("wx_state_jump_mini_program_type", this.miniProgramType);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void unserialize(Bundle r100) {
        this.username = r100.getString("wx_state_jump_mini_program_username", "");
        this.path = r100.getString("wx_state_jump_mini_program_path", "");
        this.miniProgramType = r100.getInt("wx_state_jump_mini_program_type", 0);
    }
}
