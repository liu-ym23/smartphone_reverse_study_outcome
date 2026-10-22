package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXStateJumpChannelProfileInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    private static final int USERNAME_LENGTH_LIMIT = 1024;
    public String username;

    public WXStateJumpChannelProfileInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public boolean checkArgs() {
        String r100 = this.username;
        if (r100 != null) goto L5;
    L14:
        String r101 = "checkArgs fail, username is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() <= 0) goto L14;
        if (this.username.length() < 1024) goto L12;
        r101 = "checkArgs fail, username length exceed limit";
        goto L10
    L12:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void serialize(Bundle r100) {
        r100.putString("wx_state_jump_channel_profile_username", this.username);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject.IWXStateJumpInfo
    public void unserialize(Bundle r100) {
        this.username = r100.getString("wx_state_jump_channel_profile_username", "");
    }
}
