package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectPanelModel;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\u00162\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectChannelModelTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "kChannelModel", "(Lcom/ss/ugc/effectplatform/model/EffectChannelModel;)V", "getKChannelModel", "()Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "value", "", "", "urlPrefix", "getUrlPrefix", "()Ljava/util/List;", "setUrlPrefix", "(Ljava/util/List;)V", "getCategory", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "getCollection", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "getEffects", "getPanel", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "setCategory", "", "setCollection", "setEffects", "setPanel", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelModelTemplate extends EffectChannelModel {
    private final transient EffectChannelModel kChannelModel;
    private List<String> urlPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectChannelModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public EffectPanelModel getPanel() {
        EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = r100.getPanel_model();
        if (r101 == null) goto L7;
    L9:
        return new EffectPanelModel(r101);
    L7:
        r101 = super.getPanel_model();
        goto L9
    }

    public List<EffectCategoryModel> getCategory() {
        EffectChannelModel r100 = getKChannelModel();
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

    public List<Effect> getCollection() {
        EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L7;
        List r101 = r100.getCollection_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setCollection_list(r104);
    L22:
        super.setCollection_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getCollection_list();
        goto L9
    }

    public List<Effect> getEffects() {
        EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L7;
        List r101 = r100.getEffect_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setEffect_list(r104);
    L22:
        super.setEffect_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getEffect_list();
        goto L9
    }

    public List<String> getUrlPrefix() {
        EffectChannelModel r100 = getKChannelModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    public EffectChannelModel getKChannelModel() {
        return this.kChannelModel;
    }

    public EffectChannelModelTemplate(EffectChannelModel r110) {
        super(null, null, null, null, null, null, null, null, 255, null);
        this.kChannelModel = r110;
        this.urlPrefix = new ArrayList();
    }

    public void setCategory(List<EffectCategoryModel> r100) {
        EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setCategory_list(r100);
    L5:
        super.setCategory_list(r100);
    }

    public void setCollection(List<? extends Effect> r100) {
        EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setCollection_list(r100);
    L5:
        super.setCollection_list(r100);
    }

    public void setEffects(List<? extends Effect> r100) {
        EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setEffect_list(r100);
    L5:
        super.setEffect_list(r100);
    }

    public void setPanel(EffectPanelModel r100) {
        EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setPanel_model(r100);
    L5:
        super.setPanel_model(r100);
    }

    public void setUrlPrefix(List<String> r100) {
        this.urlPrefix = r100;
        EffectChannelModel r101 = getKChannelModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ EffectChannelModelTemplate(EffectChannelModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
