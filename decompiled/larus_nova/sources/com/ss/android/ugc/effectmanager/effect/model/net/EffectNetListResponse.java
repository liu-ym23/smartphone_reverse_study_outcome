package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelModel;

/* JADX INFO: loaded from: classes40.dex */
public class EffectNetListResponse extends BaseNetResponse {
    private EffectChannelModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        EffectChannelModel r100 = this.data;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.checkValued() == false) goto L7;
        return true;
    }

    public EffectNetListResponse() {
    }

    public EffectChannelModel getData() {
        return this.data;
    }

    public void setData(EffectChannelModel r100) {
        this.data = r100;
    }
}
