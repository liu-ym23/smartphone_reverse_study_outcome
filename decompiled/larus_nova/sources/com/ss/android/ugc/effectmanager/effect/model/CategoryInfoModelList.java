package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.CategoryInfoModelTemplate;
import com.ss.ugc.effectplatform.model.EffectCategoryModelList;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R4\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR4\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/CategoryInfoModelList;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/CategoryInfoModelTemplate;", "Ljava/io/Serializable;", "kCategoryModel", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "categoryList", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "category_list", "getCategory_list", "setCategory_list", "getKCategoryModel", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class CategoryInfoModelList extends CategoryInfoModelTemplate implements Serializable {
    private final transient EffectCategoryModelList kCategoryModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryInfoModelList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryInfoModelTemplate
    public List<EffectCategoryModel> getCategoryList() {
        return super.getCategoryList();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModelList
    public List<com.ss.ugc.effectplatform.model.EffectCategoryModel> getCategory_list() {
        EffectCategoryModelList r100 = getKCategoryModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.EffectCategoryModel> r101 = r100.getCategory_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_list();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryInfoModelTemplate
    public EffectCategoryModelList getKCategoryModel() {
        return this.kCategoryModel;
    }

    public CategoryInfoModelList(EffectCategoryModelList r100) {
        super(r100);
        this.kCategoryModel = r100;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryInfoModelTemplate
    public void setCategoryList(List<EffectCategoryModel> r100) {
        super.setCategoryList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectCategoryModelList
    public void setCategory_list(List<? extends com.ss.ugc.effectplatform.model.EffectCategoryModel> r100) {
        EffectCategoryModelList r101 = getKCategoryModel();
        if (r101 == null) goto L5;
        r101.setCategory_list(r100);
    L5:
        super.setCategory_list(r100);
    }

    public /* synthetic */ CategoryInfoModelList(EffectCategoryModelList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
