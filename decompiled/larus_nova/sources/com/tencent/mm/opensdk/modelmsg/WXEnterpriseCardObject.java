package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXEnterpriseCardObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXEnterpriseCardObject";
    public String cardInfo;
    public int msgType;

    public WXEnterpriseCardObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.cardInfo;
        if (r100 != null) goto L5;
    L9:
        Log.e(TAG, "checkArgs fail, cardInfo is invalid");
        return false;
    L5:
        if (r100.length() == 0) goto L9;
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putInt("_wxenterprisecard_msgtype", this.msgType);
        r100.putString("_wxenterprisecard_cardinfo", this.cardInfo);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 45;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.msgType = r100.getInt("_wxenterprisecard_msgtype");
        this.cardInfo = r100.getString("_wxenterprisecard_cardinfo");
    }
}
