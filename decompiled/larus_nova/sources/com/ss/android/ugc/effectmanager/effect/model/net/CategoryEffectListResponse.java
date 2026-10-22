package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;

/* JADX INFO: loaded from: classes40.dex */
public class CategoryEffectListResponse extends BaseNetResponse {
    private CategoryPageModel data;

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        CategoryPageModel r100 = this.data;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getCategoryEffects() == null) goto L7;
        return true;
    }

    public String getRecId() {
        CategoryPageModel r100 = this.data;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getRecId();
    }

    public CategoryEffectListResponse() {
    }

    public CategoryPageModel getData() {
        return this.data;
    }

    public void setData(CategoryPageModel r100) {
        this.data = r100;
    }
}
