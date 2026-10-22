package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingCategoryListModel;", "", "category", "", "Lcom/ss/ugc/effectplatform/model/RankingCategoryModel;", "(Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "setCategory", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingCategoryListModel {
    private List<? extends RankingCategoryModel> category;

    /* JADX WARN: Multi-variable type inference failed */
    public RankingCategoryListModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<RankingCategoryModel> getCategory() {
        return this.category;
    }

    public RankingCategoryListModel(List<? extends RankingCategoryModel> r100) {
        this.category = r100;
    }

    public void setCategory(List<? extends RankingCategoryModel> r100) {
        this.category = r100;
    }

    public /* synthetic */ RankingCategoryListModel(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
