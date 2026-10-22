package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;

/* JADX INFO: loaded from: classes40.dex */
public class PanelInfoResponse extends BaseNetResponse {
    private PanelInfoModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String getRecId() {
        PanelInfoModel r100 = this.data;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getRecID();
    }

    public PanelInfoResponse() {
    }

    public PanelInfoModel getData() {
        return this.data;
    }

    public void setData(PanelInfoModel r100) {
        this.data = r100;
    }
}
