package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR(\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0006\u001a\u0004\u0018\u00010,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0002022\u0006\u0010\u0006\u001a\u0002028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0002082\u0006\u0010\u0006\u001a\u0002088V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R(\u0010A\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R0\u0010D\u001a\b\u0012\u0004\u0012\u00020,0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020,0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR0\u0010G\u001a\b\u0012\u0004\u0012\u00020,0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020,0\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR(\u0010J\u001a\u0004\u0018\u00010,2\b\u0010\u0006\u001a\u0004\u0018\u00010,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010/\"\u0004\bL\u00101¨\u0006M"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectChannelResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectChannelResponseTemplate;", "Ljava/io/Serializable;", "kChannelResponse", "Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "(Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "allCategoryEffects", "getAllCategoryEffects", "()Ljava/util/List;", "setAllCategoryEffects", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/Effect;", "all_category_effects", "getAll_category_effects", "setAll_category_effects", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryResponse;", "categoryResponseList", "getCategoryResponseList", "setCategoryResponseList", "Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "category_responses", "getCategory_responses", "setCategory_responses", "collection_list", "getCollection_list", "setCollection_list", "collections", "getCollections", "setCollections", "frontEffect", "getFrontEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setFrontEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "front_effect", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getKChannelResponse", "()Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "", "panel", "getPanel", "()Ljava/lang/String;", "setPanel", "(Ljava/lang/String;)V", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "panelModel", "getPanelModel", "()Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "setPanelModel", "(Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;)V", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "panel_model", "getPanel_model", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setPanel_model", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "rearEffect", "getRearEffect", "setRearEffect", "rear_effect", "getRear_effect", "setRear_effect", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "url_prefix", "getUrl_prefix", "setUrl_prefix", "version", "getVersion", "setVersion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectChannelResponse extends EffectChannelResponseTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.EffectChannelResponse kChannelResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectChannelResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public List<Effect> getAllCategoryEffects() {
        return super.getAllCategoryEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getAll_category_effects() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getAll_category_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getAll_category_effects();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public List<EffectCategoryResponse> getCategoryResponseList() {
        return super.getCategoryResponseList();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public List<com.ss.ugc.effectplatform.model.EffectCategoryResponse> getCategory_responses() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.EffectCategoryResponse> r101 = r100.getCategory_responses();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_responses();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public List<com.ss.ugc.effectplatform.model.Effect> getCollection_list() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCollection_list();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public List<Effect> getCollections() {
        return super.getCollections();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public Effect getFrontEffect() {
        return super.getFrontEffect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public com.ss.ugc.effectplatform.model.Effect getFront_effect() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getFront_effect();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFront_effect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public String getPanel() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getPanel();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getPanel();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public EffectPanelModel getPanelModel() {
        return super.getPanelModel();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public com.ss.ugc.effectplatform.model.EffectPanelModel getPanel_model() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = r100.getPanel_model();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getPanel_model();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public Effect getRearEffect() {
        return super.getRearEffect();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public com.ss.ugc.effectplatform.model.Effect getRear_effect() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getRear_effect();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRear_effect();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public String getVersion() {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public com.ss.ugc.effectplatform.model.EffectChannelResponse getKChannelResponse() {
        return this.kChannelResponse;
    }

    public EffectChannelResponse(com.ss.ugc.effectplatform.model.EffectChannelResponse r100) {
        super(r100);
        this.kChannelResponse = r100;
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L32;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101.getAll_category_effects();
        if (r102 == null) goto L7;
        super.setAll_category_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.EffectCategoryResponse> r103 = r101.getCategory_responses();
        if (r103 == null) goto L10;
        super.setCategory_responses(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getCollection_list();
        if (r104 == null) goto L13;
        super.setCollection_list(r104);
    L13:
        com.ss.ugc.effectplatform.model.Effect r105 = r101.getFront_effect();
        if (r105 == null) goto L16;
        super.setFront_effect(r105);
    L16:
        String r106 = r101.getPanel();
        if (r106 == null) goto L19;
        super.setPanel(r106);
    L19:
        com.ss.ugc.effectplatform.model.EffectPanelModel r107 = r101.getPanel_model();
        if (r107 == null) goto L22;
        super.setPanel_model(r107);
    L22:
        com.ss.ugc.effectplatform.model.Effect r108 = r101.getRear_effect();
        if (r108 == null) goto L25;
        super.setRear_effect(r108);
    L25:
        List<String> r109 = r101.getUrl_prefix();
        if (r109 == null) goto L28;
        super.setUrl_prefix(r109);
    L28:
        String r110 = r101.getVersion();
        if (r110 == null) goto L33;
        super.setVersion(r110);
        return;
    L33:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setAllCategoryEffects(List<? extends Effect> r100) {
        super.setAllCategoryEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setAll_category_effects(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setAll_category_effects(r100);
    L5:
        super.setAll_category_effects(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setCategoryResponseList(List<EffectCategoryResponse> r100) {
        super.setCategoryResponseList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setCategory_responses(List<? extends com.ss.ugc.effectplatform.model.EffectCategoryResponse> r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setCategory_responses(r100);
    L5:
        super.setCategory_responses(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setCollection_list(List<? extends com.ss.ugc.effectplatform.model.Effect> r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setCollection_list(r100);
    L5:
        super.setCollection_list(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setCollections(List<? extends Effect> r100) {
        super.setCollections(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setFrontEffect(Effect r100) {
        super.setFrontEffect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setFront_effect(com.ss.ugc.effectplatform.model.Effect r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setFront_effect(r100);
    L5:
        super.setFront_effect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setPanel(String r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setPanel(r100);
    L5:
        super.setPanel(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setPanelModel(EffectPanelModel r100) {
        super.setPanelModel(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setPanel_model(com.ss.ugc.effectplatform.model.EffectPanelModel r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setPanel_model(r100);
    L5:
        super.setPanel_model(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setRearEffect(Effect r100) {
        super.setRearEffect(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setRear_effect(com.ss.ugc.effectplatform.model.Effect r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setRear_effect(r100);
    L5:
        super.setRear_effect(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelResponseTemplate
    public void setUrlPrefix(List<String> r100) {
        super.setUrlPrefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelResponse
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ EffectChannelResponse(com.ss.ugc.effectplatform.model.EffectChannelResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
