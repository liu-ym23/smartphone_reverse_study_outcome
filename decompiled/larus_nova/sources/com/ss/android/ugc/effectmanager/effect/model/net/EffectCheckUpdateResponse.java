package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;

/* JADX INFO: loaded from: classes40.dex */
public class EffectCheckUpdateResponse extends BaseNetResponse {
    private boolean updated;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        return super.checkValue();
    }

    public EffectCheckUpdateResponse() {
    }

    public boolean isUpdated() {
        return this.updated;
    }

    public void setUpdated(boolean r100) {
        this.updated = r100;
    }
}
