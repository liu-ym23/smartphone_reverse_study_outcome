package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class WXGameLiveObject implements WXMediaMessage.IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXGameObject";
    public HashMap<String, String> extraInfoMap;

    public WXGameLiveObject() {
        this.extraInfoMap = new HashMap();
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
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
        HashMap<String, String> r101 = this.extraInfoMap;
        if (r101 == null) goto L6;
        r100.putSerializable("_wxgame_extrainfo", r101);
        return;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 70;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.extraInfoMap = (HashMap) r100.getSerializable("_wxgame_extrainfo");
    }
}
