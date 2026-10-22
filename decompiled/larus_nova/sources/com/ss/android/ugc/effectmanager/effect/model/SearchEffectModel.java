package com.ss.android.ugc.effectmanager.effect.model;

import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR4\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR4\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR4\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR$\u0010%\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0006\u001a\u0004\u0018\u00010,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00102\u001a\u0004\u0018\u00010,2\b\u0010\u0006\u001a\u0004\u0018\u00010,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R(\u00105\u001a\u0004\u0018\u00010$2\b\u0010\u0006\u001a\u0004\u0018\u00010$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/SearchEffectModelTemplate;", "Ljava/io/Serializable;", "kSearchEffectModel", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "bind_effects", "getBind_effects", "setBind_effects", "collection", "getCollection", "setCollection", "collectionList", "getCollectionList", "setCollectionList", "", EffectConfiguration.KEY_CURSOR, "getCursor", "()I", "setCursor", "(I)V", "effectList", "getEffectList", "setEffectList", KFFeature.EFFECT_JSON_FIELD, "getEffects", "setEffects", "", "has_more", "getHas_more", "()Z", "setHas_more", "(Z)V", "getKSearchEffectModel", "()Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "", "search_id", "getSearch_id", "()Ljava/lang/String;", "setSearch_id", "(Ljava/lang/String;)V", "search_tips", "getSearch_tips", "setSearch_tips", "use_hot", "getUse_hot", "()Ljava/lang/Boolean;", "setUse_hot", "(Ljava/lang/Boolean;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class SearchEffectModel extends SearchEffectModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.net.SearchEffectModel kSearchEffectModel;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchEffectModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public List<Effect> getBindEffects() {
        return super.getBindEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public List<com.ss.ugc.effectplatform.model.Effect> getBind_effects() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getBind_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getBind_effects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public List<com.ss.ugc.effectplatform.model.Effect> getCollection() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCollection();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public List<Effect> getCollectionList() {
        return super.getCollectionList();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public int getCursor() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L6;
        return r100.getCursor();
    L6:
        return super.getCursor();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public List<Effect> getEffectList() {
        return super.getEffectList();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public List<com.ss.ugc.effectplatform.model.Effect> getEffects() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getEffects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public boolean getHas_more() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public String getSearch_id() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        String r101 = r100.getSearch_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSearch_id();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public String getSearch_tips() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        String r101 = r100.getSearch_tips();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getSearch_tips();
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public Boolean getUse_hot() {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L8;
        Boolean r101 = r100.getUse_hot();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUse_hot();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public com.ss.ugc.effectplatform.model.net.SearchEffectModel getKSearchEffectModel() {
        return this.kSearchEffectModel;
    }

    public SearchEffectModel(com.ss.ugc.effectplatform.model.net.SearchEffectModel r100) {
        super(r100);
        this.kSearchEffectModel = r100;
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L23;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getBind_effects();
        if (r102 == null) goto L7;
        super.setBind_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getCollection();
        if (r103 == null) goto L10;
        super.setCollection(r103);
    L10:
        super.setCursor(r101.getCursor());
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getEffects();
        if (r104 == null) goto L13;
        super.setEffects(r104);
    L13:
        super.setHas_more(r101.getHas_more());
        String r105 = r101.getSearch_id();
        if (r105 == null) goto L16;
        super.setSearch_id(r105);
    L16:
        String r106 = r101.getSearch_tips();
        if (r106 == null) goto L19;
        super.setSearch_tips(r106);
    L19:
        Boolean r107 = r101.getUse_hot();
        if (r107 == null) goto L24;
        super.setUse_hot(Boolean.valueOf(r107.booleanValue()));
        return;
    L24:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public void setBindEffects(List<? extends Effect> r100) {
        super.setBindEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setBind_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setCollection(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setCollection(r100);
    L5:
        super.setCollection(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public void setCollectionList(List<? extends Effect> r100) {
        super.setCollectionList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setCursor(int r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setCursor(r100);
    L5:
        super.setCursor(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.SearchEffectModelTemplate
    public void setEffectList(List<? extends Effect> r100) {
        super.setEffectList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setEffects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setEffects(r100);
    L5:
        super.setEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setHas_more(boolean r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setSearch_id(String r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setSearch_id(r100);
    L5:
        super.setSearch_id(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setSearch_tips(String r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setSearch_tips(r100);
    L5:
        super.setSearch_tips(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.net.SearchEffectModel
    public void setUse_hot(Boolean r100) {
        com.ss.ugc.effectplatform.model.net.SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setUse_hot(r100);
    L5:
        super.setUse_hot(r100);
    }

    public /* synthetic */ SearchEffectModel(com.ss.ugc.effectplatform.model.net.SearchEffectModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
