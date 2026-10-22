package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectPanelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\f0\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR*\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R2\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020#0\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000b¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectChannelResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "kChannelResponse", "(Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "allCategoryEffects", "getAllCategoryEffects", "()Ljava/util/List;", "setAllCategoryEffects", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryResponse;", "categoryResponseList", "getCategoryResponseList", "setCategoryResponseList", "collections", "getCollections", "setCollections", "frontEffect", "getFrontEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setFrontEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "getKChannelResponse", "()Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "panelModel", "getPanelModel", "()Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;", "setPanelModel", "(Lcom/ss/android/ugc/effectmanager/effect/model/EffectPanelModel;)V", "rearEffect", "getRearEffect", "setRearEffect", "", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelResponseTemplate extends EffectChannelResponse {
    private List<? extends Effect> allCategoryEffects;
    private List<EffectCategoryResponse> categoryResponseList;
    private List<? extends Effect> collections;
    private Effect frontEffect;
    private final transient EffectChannelResponse kChannelResponse;
    private EffectPanelModel panelModel;
    private Effect rearEffect;
    private List<String> urlPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectChannelResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Effect getFrontEffect() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getFront_effect();
        if (r101 == null) goto L7;
    L9:
        return new Effect(r101);
    L7:
        r101 = super.getFront_effect();
        goto L9
    }

    public EffectPanelModel getPanelModel() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.EffectPanelModel r101 = r100.getPanel_model();
        if (r101 == null) goto L7;
    L9:
        return new EffectPanelModel(r101);
    L7:
        r101 = super.getPanel_model();
        goto L9
    }

    public Effect getRearEffect() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getRear_effect();
        if (r101 == null) goto L7;
    L9:
        return new Effect(r101);
    L7:
        r101 = super.getRear_effect();
        goto L9
    }

    public List<Effect> getAllCategoryEffects() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getAll_category_effects();
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
        r100.setAll_category_effects(r104);
    L22:
        super.setAll_category_effects(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getAll_category_effects();
        goto L9
    }

    public List<EffectCategoryResponse> getCategoryResponseList() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getCategory_responses();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof EffectCategoryResponse) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new EffectCategoryResponse((com.ss.ugc.effectplatform.model.EffectCategoryResponse) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setCategory_responses(r104);
    L22:
        super.setCategory_responses(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getCategory_responses();
        goto L9
    }

    public List<Effect> getCollections() {
        EffectChannelResponse r100 = getKChannelResponse();
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

    public List<String> getUrlPrefix() {
        EffectChannelResponse r100 = getKChannelResponse();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    public EffectChannelResponse getKChannelResponse() {
        return this.kChannelResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectChannelResponseTemplate(EffectChannelResponse r110) {
        super(null, null, null, null, null, null, null, null, null, 511, null);
        this.kChannelResponse = r110;
        this.allCategoryEffects = new ArrayList();
        this.categoryResponseList = new ArrayList();
        this.collections = new ArrayList();
        this.panelModel = new EffectPanelModel(null, 1, 0 == true ? 1 : 0);
        this.urlPrefix = new ArrayList();
    }

    public void setAllCategoryEffects(List<? extends Effect> r100) {
        this.allCategoryEffects = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setAll_category_effects(r100);
    L5:
        super.setAll_category_effects(r100);
    }

    public void setCategoryResponseList(List<EffectCategoryResponse> r100) {
        this.categoryResponseList = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setCategory_responses(r100);
    L5:
        super.setCategory_responses(r100);
    }

    public void setCollections(List<? extends Effect> r100) {
        this.collections = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setCollection_list(r100);
    L5:
        super.setCollection_list(r100);
    }

    public void setFrontEffect(Effect r100) {
        this.frontEffect = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setFront_effect(r100);
    L5:
        super.setFront_effect(r100);
    }

    public void setPanelModel(EffectPanelModel r100) {
        this.panelModel = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setPanel_model(r100);
    L5:
        super.setPanel_model(r100);
    }

    public void setRearEffect(Effect r100) {
        this.rearEffect = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setRear_effect(r100);
    L5:
        super.setRear_effect(r100);
    }

    public void setUrlPrefix(List<String> r100) {
        this.urlPrefix = r100;
        EffectChannelResponse r101 = getKChannelResponse();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ EffectChannelResponseTemplate(EffectChannelResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
