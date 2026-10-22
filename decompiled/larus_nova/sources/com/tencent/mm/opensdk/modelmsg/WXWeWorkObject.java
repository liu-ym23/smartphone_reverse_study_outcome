package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public class WXWeWorkObject implements WXMediaMessage.IMediaObject {
    public static final int SUB_TYPE_MSG_RECORD = 1;
    private static final String TAG = "MicroMsg.SDK.WXWeWorkObject";
    public byte[] data;
    public String extInfo;
    public int subType;

    public WXWeWorkObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putByteArray("_wxenterprise_object_data", this.data);
        r100.putString("_wxenterprise_object_extinfo", this.extInfo);
        r100.putInt("_wxenterprise_object_subType", this.subType);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 49;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.data = r100.getByteArray("_wxenterprise_object_data");
        this.extInfo = r100.getString("_wxenterprise_object_extinfo");
        this.subType = r100.getInt("_wxenterprise_object_subType");
    }
}
