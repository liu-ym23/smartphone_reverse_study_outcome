package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.ResourceListModel;

/* JADX INFO: loaded from: classes40.dex */
public class ResourceListResponse extends BaseNetResponse {
    private ResourceListModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        ResourceListModel r100 = this.data;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getResourceList() == null) goto L7;
        return true;
    }

    public ResourceListResponse() {
    }

    public ResourceListModel getData() {
        return this.data;
    }

    public void setData(ResourceListModel r100) {
        this.data = r100;
    }
}
