package com.ss.android.ugc.effectmanager.effect.model;

import com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000103H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R(\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R0\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001e0\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R0\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001e0\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R$\u0010/\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#¨\u00068"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/PanelInfoModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/PanelInfoModelTemplate;", "Ljava/io/Serializable;", "kPanelModel", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;)V", "value", "Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "categoryEffectModel", "getCategoryEffectModel", "()Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "setCategoryEffectModel", "(Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;)V", "", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "categoryList", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "category_effects", "getCategory_effects", "()Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "setCategory_effects", "(Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;)V", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "category_list", "getCategory_list", "setCategory_list", "", "front_effect_id", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "getKPanelModel", "()Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "rear_effect_id", "getRear_effect_id", "setRear_effect_id", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "url_prefix", "getUrl_prefix", "setUrl_prefix", "version", "getVersion", "setVersion", "getPanel", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "getRecID", "setPanel", "", "panel", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class PanelInfoModel extends PanelInfoModelTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.PanelInfoModel kPanelModel;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelInfoModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public CategoryEffectModel getCategoryEffectModel() {
        return super.getCategoryEffectModel();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public List<EffectCategoryModel> getCategoryList() {
        return super.getCategoryList();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public com.ss.ugc.effectplatform.model.CategoryEffectModel getCategory_effects() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_effects();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public List<com.ss.ugc.effectplatform.model.EffectCategoryModel> getCategory_list() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.EffectCategoryModel> r101 = r100.getCategory_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getCategory_list();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public String getFront_effect_id() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getFront_effect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFront_effect_id();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public EffectPanelModel getPanel() {
        return super.getPanel();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public String getRear_effect_id() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getRear_effect_id();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getRear_effect_id();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public String getRecID() {
        return super.getRecID();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public String getVersion() {
        com.ss.ugc.effectplatform.model.PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public com.ss.ugc.effectplatform.model.PanelInfoModel getKPanelModel() {
        return this.kPanelModel;
    }

    public PanelInfoModel(com.ss.ugc.effectplatform.model.PanelInfoModel r100) {
        super(r100);
        this.kPanelModel = r100;
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L29;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r102 = r101.getCategory_effects();
        if (r102 == null) goto L7;
        super.setCategory_effects(r102);
    L7:
        List<com.ss.ugc.effectplatform.model.EffectCategoryModel> r103 = r101.getCategory_list();
        if (r103 == null) goto L10;
        super.setCategory_list(r103);
    L10:
        com.ss.ugc.effectplatform.model.EffectPanelModel r104 = r101.getEffect_panel();
        if (r104 == null) goto L13;
        super.setEffect_panel(r104);
    L13:
        com.ss.ugc.effectplatform.model.PanelInfoModel.Extra r105 = r101.getExtra();
        if (r105 == null) goto L16;
        super.setExtra(r105);
    L16:
        String r106 = r101.getFront_effect_id();
        if (r106 == null) goto L19;
        super.setFront_effect_id(r106);
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

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public void setCategoryEffectModel(CategoryEffectModel r100) {
        super.setCategoryEffectModel(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public void setCategoryList(List<EffectCategoryModel> r100) {
        super.setCategoryList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setCategory_effects(com.ss.ugc.effectplatform.model.CategoryEffectModel r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setCategory_effects(r100);
    L5:
        super.setCategory_effects(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setCategory_list(List<? extends com.ss.ugc.effectplatform.model.EffectCategoryModel> r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setCategory_list(r100);
    L5:
        super.setCategory_list(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setFront_effect_id(String r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setFront_effect_id(r100);
    L5:
        super.setFront_effect_id(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public void setPanel(EffectPanelModel r100) {
        super.setPanel(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setRear_effect_id(String r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setRear_effect_id(r100);
    L5:
        super.setRear_effect_id(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.PanelInfoModelTemplate
    public void setUrlPrefix(List<String> r100) {
        super.setUrlPrefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.PanelInfoModel
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ PanelInfoModel(com.ss.ugc.effectplatform.model.PanelInfoModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
