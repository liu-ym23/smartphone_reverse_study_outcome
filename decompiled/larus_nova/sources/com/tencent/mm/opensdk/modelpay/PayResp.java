package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* JADX INFO: loaded from: classes40.dex */
public class PayResp extends BaseResp {
    public String extData;
    public String prepayId;
    public String returnKey;

    public PayResp() {
    }

    public PayResp(Bundle r100) {
        fromBundle(r100);
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public boolean checkArgs() {
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void fromBundle(Bundle r100) {
        super.fromBundle(r100);
        this.prepayId = r100.getString("_wxapi_payresp_prepayid");
        this.returnKey = r100.getString("_wxapi_payresp_returnkey");
        this.extData = r100.getString("_wxapi_payresp_extdata");
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public int getType() {
        return 5;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseResp
    public void toBundle(Bundle r100) {
        super.toBundle(r100);
        r100.putString("_wxapi_payresp_prepayid", this.prepayId);
        r100.putString("_wxapi_payresp_returnkey", this.returnKey);
        r100.putString("_wxapi_payresp_extdata", this.extData);
    }
}
