package com.ss.android.ugc.effectmanager.effect.model.template;

import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/CategoryPageModelTemplate;", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "kCategoryPageModel", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;)V", "value", "Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "categoryEffects", "getCategoryEffects", "()Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "setCategoryEffects", "(Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;)V", "getKCategoryPageModel", "()Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "getRecId", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class CategoryPageModelTemplate extends CategoryPageModel {
    private CategoryEffectModel categoryEffects;
    private final transient CategoryPageModel kCategoryPageModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryPageModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CategoryEffectModel getCategoryEffects() {
        CategoryPageModel r100 = getKCategoryPageModel();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L7;
    L9:
        return new CategoryEffectModel(r101);
    L7:
        r101 = super.getCategory_effects();
        goto L9
    }

    public String getRecId() {
        CategoryPageModel.Extra r100 = getExtra();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRec_id();
    }

    public CategoryPageModel getKCategoryPageModel() {
        return this.kCategoryPageModel;
    }

    public CategoryPageModelTemplate(CategoryPageModel r100) {
        super(null, null, null, 7, null);
        this.kCategoryPageModel = r100;
    }

    public void setCategoryEffects(CategoryEffectModel r100) {
        this.categoryEffects = r100;
        CategoryPageModel r101 = getKCategoryPageModel();
        if (r101 == null) goto L5;
        r101.setCategory_effects(r100);
    L5:
        super.setCategory_effects(r100);
    }

    public /* synthetic */ CategoryPageModelTemplate(CategoryPageModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
