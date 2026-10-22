package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectPanelModel;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/PanelInfoModelTemplate;", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "kPanelModel", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;)V", "value", "Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "categoryEffectModel", "getCategoryEffectModel", "()Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;", "setCategoryEffectModel", "(Lcom/ss/android/ugc/effectmanager/effect/model/CategoryEffectModel;)V", "", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "categoryList", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "getKPanelModel", "()Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "getPanel", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "getRecID", "setPanel", "", "panel", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class PanelInfoModelTemplate extends PanelInfoModel {
    private CategoryEffectModel categoryEffectModel;
    private List<EffectCategoryModel> categoryList;
    private final transient PanelInfoModel kPanelModel;
    private List<String> urlPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelInfoModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CategoryEffectModel getCategoryEffectModel() {
        PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L7;
    L9:
        return new CategoryEffectModel(r101);
    L7:
        r101 = super.getCategory_effects();
        goto L9
    }

    public EffectPanelModel getPanel() {
        PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = r100.getEffect_panel();
        if (r101 == null) goto L7;
    L9:
        return new EffectPanelModel(r101);
    L7:
        r101 = super.getEffect_panel();
        goto L9
    }

    public List<EffectCategoryModel> getCategoryList() {
        PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L7;
        List r101 = r100.getCategory_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof EffectCategoryModel) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new EffectCategoryModel((com.ss.ugc.effectplatform.model.EffectCategoryModel) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setCategory_list(r104);
    L22:
        super.setCategory_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getCategory_list();
        goto L9
    }

    public String getRecID() {
        PanelInfoModel.Extra r100 = getExtra();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRec_id();
    }

    public List<String> getUrlPrefix() {
        PanelInfoModel r100 = getKPanelModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    public PanelInfoModel getKPanelModel() {
        return this.kPanelModel;
    }

    public PanelInfoModelTemplate(PanelInfoModel r110) {
        super(null, null, null, null, null, null, null, null, 255, null);
        this.kPanelModel = r110;
        this.categoryList = new ArrayList();
        this.urlPrefix = new ArrayList();
    }

    public void setCategoryEffectModel(CategoryEffectModel r100) {
        this.categoryEffectModel = r100;
        PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setCategory_effects(r100);
    L5:
        super.setCategory_effects(r100);
    }

    public void setCategoryList(List<EffectCategoryModel> r100) {
        this.categoryList = r100;
        PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setCategory_list(r100);
    L5:
        super.setCategory_list(r100);
    }

    public void setPanel(EffectPanelModel r100) {
        PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setEffect_panel(r100);
    L5:
        super.setEffect_panel(r100);
    }

    public void setUrlPrefix(List<String> r100) {
        this.urlPrefix = r100;
        PanelInfoModel r101 = getKPanelModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ PanelInfoModelTemplate(PanelInfoModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
