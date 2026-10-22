package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0012H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0012H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0012H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0012H\u0016J\u0016\u0010'\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020!0\u0012H\u0016J\u0016\u0010(\u001a\u00020&2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020!0\u0012H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020$H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\f¨\u0006*"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/EffectChannelModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectChannelModelTemplate;", "Ljava/io/Serializable;", "kChannelModel", "Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "(Lcom/ss/ugc/effectplatform/model/EffectChannelModel;)V", "value", "", "front_effect_id", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "getKChannelModel", "()Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "rear_effect_id", "getRear_effect_id", "setRear_effect_id", "", "urlPrefix", "getUrlPrefix", "()Ljava/util/List;", "setUrlPrefix", "(Ljava/util/List;)V", "url_prefix", "getUrl_prefix", "setUrl_prefix", "version", "getVersion", "setVersion", "getCategory", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "getCollection", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getEffects", "getPanel", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "setCategory", "", "setCollection", "setEffects", "setPanel", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EffectChannelModel extends EffectChannelModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.EffectChannelModel kChannelModel;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectChannelModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public List<EffectCategoryModel> getCategory() {
        return super.getCategory();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public List<Effect> getCollection() {
        return super.getCollection();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public List<Effect> getEffects() {
        return super.getEffects();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public String getFront_effect_id() {
        com.ss.ugc.effectplatform.model.EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getFront_effect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFront_effect_id();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public EffectPanelModel getPanel() {
        return super.getPanel();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public String getRear_effect_id() {
        com.ss.ugc.effectplatform.model.EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getRear_effect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRear_effect_id();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public String getVersion() {
        com.ss.ugc.effectplatform.model.EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public com.ss.ugc.effectplatform.model.EffectChannelModel getKChannelModel() {
        return this.kChannelModel;
    }

    public EffectChannelModel(com.ss.ugc.effectplatform.model.EffectChannelModel r100) {
        super(r100);
        this.kChannelModel = r100;
        com.ss.ugc.effectplatform.model.EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L29;
        List<com.ss.ugc.effectplatform.model.EffectCategoryModel> r102 = r101.getCategory_list();
        if (r102 == null) goto L7;
        super.setCategory_list(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.Effect> r103 = r101.getCollection_list();
        if (r103 == null) goto L10;
        super.setCollection_list(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r104 = r101.getEffect_list();
        if (r104 == null) goto L13;
        super.setEffect_list(r104);
    L13:
        String r105 = r101.getFront_effect_id();
        if (r105 == null) goto L16;
        super.setFront_effect_id(r105);
    L16:
        com.ss.ugc.effectplatform.model.EffectPanelModel r106 = r101.getPanel_model();
        if (r106 == null) goto L19;
        super.setPanel_model(r106);
    L19:
        String r107 = r101.getRear_effect_id();
        if (r107 == null) goto L22;
        super.setRear_effect_id(r107);
    L22:
        List<String> r108 = r101.getUrl_prefix();
        if (r108 == null) goto L25;
        super.setUrl_prefix(r108);
    L25:
        String r109 = r101.getVersion();
        if (r109 == null) goto L30;
        super.setVersion(r109);
        return;
    L30:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public void setCategory(List<EffectCategoryModel> r100) {
        super.setCategory(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public void setCollection(List<? extends Effect> r100) {
        super.setCollection(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public void setEffects(List<? extends Effect> r100) {
        super.setEffects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public void setFront_effect_id(String r100) {
        com.ss.ugc.effectplatform.model.EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setFront_effect_id(r100);
    L5:
        super.setFront_effect_id(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public void setPanel(EffectPanelModel r100) {
        super.setPanel(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public void setRear_effect_id(String r100) {
        com.ss.ugc.effectplatform.model.EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setRear_effect_id(r100);
    L5:
        super.setRear_effect_id(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.EffectChannelModelTemplate
    public void setUrlPrefix(List<String> r100) {
        super.setUrlPrefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.EffectChannelModel
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ EffectChannelModel(com.ss.ugc.effectplatform.model.EffectChannelModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
