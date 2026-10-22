package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;

/* JADX INFO: loaded from: classes40.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    public BaseReq() {
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle r100) {
        this.transaction = a.a(r100, "_wxapi_basereq_transaction");
        this.openId = a.a(r100, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle r100) {
        r100.putInt("_wxapi_command_type", getType());
        r100.putString("_wxapi_basereq_transaction", this.transaction);
        r100.putString("_wxapi_basereq_openid", this.openId);
    }
}
