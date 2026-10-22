package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.ProviderEffectModel;

/* JADX INFO: loaded from: classes40.dex */
public class ProviderEffectListResponse extends BaseNetResponse {
    private ProviderEffectModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ProviderEffectListResponse() {
    }

    public ProviderEffectModel getData() {
        return this.data;
    }

    public void setData(ProviderEffectModel r100) {
        this.data = r100;
    }
}
