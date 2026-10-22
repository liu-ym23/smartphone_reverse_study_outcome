package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0016\u0010<\u001a\u00020=2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR$\u0010\"\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R$\u00102\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R$\u00105\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R$\u00108\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017¨\u0006>"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/CategoryEffectModelTemplate;", "Ljava/io/Serializable;", "kCategoryEffect", "Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "(Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "bind_effects", "getBind_effects", "setBind_effects", "", "categoryKey", "getCategoryKey", "()Ljava/lang/String;", "setCategoryKey", "(Ljava/lang/String;)V", "category_key", "getCategory_key", "setCategory_key", "collectEffects", "getCollectEffects", "setCollectEffects", "collection", "getCollection", "setCollection", "", EffectConfiguration.KEY_CURSOR, "getCursor", "()I", "setCursor", "(I)V", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "has_more", "getHas_more", "setHas_more", "getKCategoryEffect", "()Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "sortingPosition", "getSortingPosition", "setSortingPosition", EffectConfiguration.KEY_SORTING_POSITION, "getSorting_position", "setSorting_position", "version", "getVersion", "setVersion", "getEffects", "setEffects", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class CategoryEffectModel extends CategoryEffectModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.CategoryEffectModel kCategoryEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryEffectModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public List<Effect> getBindEffects() {
        return super.getBindEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public List<com.ss.ugc.effectplatform.model.Effect> getBind_effects() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getBind_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public String getCategoryKey() {
        return super.getCategoryKey();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public String getCategory_key() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getCategory_key();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_key();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public List<Effect> getCollectEffects() {
        return super.getCollectEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public List<com.ss.ugc.effectplatform.model.Effect> getCollection() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCollection();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public int getCursor() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L6;
        return r100.getCursor();
    L6:
        return super.getCursor();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public List<Effect> getEffects() {
        return super.getEffects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public boolean getHasMore() {
        return super.getHasMore();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public boolean getHas_more() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public int getSortingPosition() {
        return super.getSortingPosition();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public int getSorting_position() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L6;
        return r100.getSorting_position();
    L6:
        return super.getSorting_position();
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public String getVersion() {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r100 = getKCategoryEffect();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public boolean hasMore() {
        return super.hasMore();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public com.ss.ugc.effectplatform.model.CategoryEffectModel getKCategoryEffect() {
        return this.kCategoryEffect;
    }

    public CategoryEffectModel(com.ss.ugc.effectplatform.model.CategoryEffectModel r100) {
        super(r100);
        this.kCategoryEffect = r100;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L20;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getBind_effects();
        if (r102 == null) goto L7;
        super.setBind_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getCategory_effects();
        if (r103 == null) goto L10;
        super.setCategory_effects(r103);
    L10:
        String r104 = r101.getCategory_key();
        if (r104 == null) goto L13;
        super.setCategory_key(r104);
    L13:
        List<com.ss.ugc.effectplatform.model.Effect> r105 = r101.getCollection();
        if (r105 == null) goto L16;
        super.setCollection(r105);
    L16:
        super.setCursor(r101.getCursor());
        super.setHas_more(r101.getHas_more());
        super.setCache(r101.isCache());
        super.setSorting_position(r101.getSorting_position());
        String r106 = r101.getVersion();
        if (r106 == null) goto L21;
        super.setVersion(r106);
        return;
    L21:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setBindEffects(List<? extends Effect> r100) {
        super.setBindEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setBind_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setCategoryKey(String r100) {
        super.setCategoryKey(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setCategory_key(String r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setCategory_key(r100);
    L5:
        super.setCategory_key(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setCollectEffects(List<? extends Effect> r100) {
        super.setCollectEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setCollection(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setCollection(r100);
    L5:
        super.setCollection(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setCursor(int r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setCursor(r100);
    L5:
        super.setCursor(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setEffects(List<? extends Effect> r100) {
        super.setEffects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setHasMore(boolean r100) {
        super.setHasMore(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setHas_more(boolean r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.CategoryEffectModelTemplate
    public void setSortingPosition(int r100) {
        super.setSortingPosition(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setSorting_position(int r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setSorting_position(r100);
    L5:
        super.setSorting_position(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.CategoryEffectModel
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = getKCategoryEffect();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ CategoryEffectModel(com.ss.ugc.effectplatform.model.CategoryEffectModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
