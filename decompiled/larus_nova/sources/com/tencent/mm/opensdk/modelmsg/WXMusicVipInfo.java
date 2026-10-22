package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXMusicVipInfo implements SendMessageToWX.IWXMusicVipObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXMusicVipInfo";
    public String musicId;

    public WXMusicVipInfo() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public boolean checkArgs() {
        String r100 = this.musicId;
        if (r100 != null) goto L5;
    L14:
        String r101 = "checkArgs fail, musicId is null";
    L10:
        Log.e(TAG, r101);
        return false;
    L5:
        if (r100.length() <= 0) goto L14;
        if (this.musicId.length() <= 10240) goto L12;
        r101 = "checkArgs fail, musicId length is larger than 1024";
        goto L10
    L12:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public void serialize(Bundle r100) {
        r100.putString("wx_music_vip_id", this.musicId);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXMusicVipObject
    public void unserialize(Bundle r100) {
        this.musicId = r100.getString("wx_music_vip_id", "");
    }
}
