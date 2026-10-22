package com.ss.ugc.effectplatform.model;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "", "()V", "category_list", "", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "getCategory_list", "()Ljava/util/List;", "setCategory_list", "(Ljava/util/List;)V", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryModelList {
    private List<? extends EffectCategoryModel> category_list;

    public EffectCategoryModelList() {
    }

    public List<EffectCategoryModel> getCategory_list() {
        return this.category_list;
    }

    public void setCategory_list(List<? extends EffectCategoryModel> r100) {
        this.category_list = r100;
    }
}
