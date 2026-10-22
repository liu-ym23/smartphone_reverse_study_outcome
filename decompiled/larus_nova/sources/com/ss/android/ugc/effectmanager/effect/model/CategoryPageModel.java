package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.CategoryPageModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/CategoryPageModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/CategoryPageModelTemplate;", "Ljava/io/Serializable;", "kCategoryPageModel", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;)V", "value", "Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "categoryEffects", "getCategoryEffects", "()Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "setCategoryEffects", "(Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;)V", "Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "category_effects", "getCategory_effects", "()Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "setCategory_effects", "(Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;)V", "getKCategoryPageModel", "()Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "", "", "url_prefix", "getUrl_prefix", "()Ljava/util/List;", "setUrl_prefix", "(Ljava/util/List;)V", "getRecId", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class CategoryPageModel extends CategoryPageModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.CategoryPageModel kCategoryPageModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryPageModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryPageModelTemplate
    public CategoryEffectModel getCategoryEffects() {
        return super.getCategoryEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryPageModel
    public com.ss.ugc.effectplatform.model.CategoryEffectModel getCategory_effects() {
        com.ss.ugc.effectplatform.model.CategoryPageModel r100 = getKCategoryPageModel();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryPageModelTemplate
    public String getRecId() {
        return super.getRecId();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryPageModel
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.CategoryPageModel r100 = getKCategoryPageModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryPageModelTemplate
    public com.ss.ugc.effectplatform.model.CategoryPageModel getKCategoryPageModel() {
        return this.kCategoryPageModel;
    }

    public CategoryPageModel(com.ss.ugc.effectplatform.model.CategoryPageModel r100) {
        super(r100);
        this.kCategoryPageModel = r100;
        com.ss.ugc.effectplatform.model.CategoryPageModel r101 = getKCategoryPageModel();
        if (r101 == null) goto L14;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r102 = r101.getCategory_effects();
        if (r102 == null) goto L7;
        super.setCategory_effects(r102);
    L7:
        com.ss.ugc.effectplatform.model.CategoryPageModel.Extra r103 = r101.getExtra();
        if (r103 == null) goto L10;
        super.setExtra(r103);
    L10:
        List<String> r104 = r101.getUrl_prefix();
        if (r104 == null) goto L15;
        super.setUrl_prefix(r104);
        return;
    L15:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryPageModelTemplate
    public void setCategoryEffects(CategoryEffectModel r100) {
        super.setCategoryEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryPageModel
    public void setCategory_effects(com.ss.ugc.effectplatform.model.CategoryEffectModel r100) {
        com.ss.ugc.effectplatform.model.CategoryPageModel r101 = getKCategoryPageModel();
        if (r101 == null) goto L5;
        r101.setCategory_effects(r100);
    L5:
        super.setCategory_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryPageModel
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.CategoryPageModel r101 = getKCategoryPageModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ CategoryPageModel(com.ss.ugc.effectplatform.model.CategoryPageModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
