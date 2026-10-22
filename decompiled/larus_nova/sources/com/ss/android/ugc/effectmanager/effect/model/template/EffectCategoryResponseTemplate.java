package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R*\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R2\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000b¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectCategoryResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "kCategoryResponse", "(Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "collectionEffect", "getCollectionEffect", "()Ljava/util/List;", "setCollectionEffect", "(Ljava/util/List;)V", "frontEffect", "getFrontEffect", "()Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "setFrontEffect", "(Lcom/ss/android/ugc/effectmanager/effect/model/Effect;)V", "", "isDefault", "()Z", "setDefault", "(Z)V", "getKCategoryResponse", "()Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "rearEffect", "getRearEffect", "setRearEffect", "", "tagsUpdateTime", "getTagsUpdateTime", "()Ljava/lang/String;", "setTagsUpdateTime", "(Ljava/lang/String;)V", "totalEffects", "getTotalEffects", "setTotalEffects", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectCategoryResponseTemplate extends EffectCategoryResponse {
    private List<? extends Effect> collectionEffect;
    private Effect frontEffect;
    private boolean isDefault;
    private final transient EffectCategoryResponse kCategoryResponse;
    private Effect rearEffect;
    private String tagsUpdateTime;
    private List<? extends Effect> totalEffects;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectCategoryResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Effect getFrontEffect() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getFront_effect();
        if (r101 == null) goto L7;
    L9:
        return new Effect(r101);
    L7:
        r101 = super.getFront_effect();
        goto L9
    }

    public Effect getRearEffect() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.Effect r101 = r100.getRear_effect();
        if (r101 == null) goto L7;
    L9:
        return new Effect(r101);
    L7:
        r101 = super.getRear_effect();
        goto L9
    }

    public List<Effect> getCollectionEffect() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getCollection_effect();
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
        r100.setCollection_effect(r104);
    L22:
        super.setCollection_effect(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getCollection_effect();
        goto L9
    }

    public String getTagsUpdateTime() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L8;
        String r101 = r100.getTags_update_time();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getTags_update_time();
    }

    public List<Effect> getTotalEffects() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getTotal_effects();
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
        r100.setTotal_effects(r104);
    L22:
        super.setTotal_effects(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getTotal_effects();
        goto L9
    }

    public boolean isDefault() {
        EffectCategoryResponse r100 = getKCategoryResponse();
        if (r100 == null) goto L6;
        return r100.is_default();
    L6:
        return super.is_default();
    }

    public EffectCategoryResponse getKCategoryResponse() {
        return this.kCategoryResponse;
    }

    public EffectCategoryResponseTemplate(EffectCategoryResponse r110) {
        super(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
        this.kCategoryResponse = r110;
        this.totalEffects = new ArrayList();
        this.collectionEffect = new ArrayList();
    }

    public void setCollectionEffect(List<? extends Effect> r100) {
        this.collectionEffect = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setCollection_effect(r100);
    L5:
        super.setCollection_effect(r100);
    }

    public void setDefault(boolean r100) {
        this.isDefault = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.set_default(r100);
    L5:
        super.set_default(r100);
    }

    public void setFrontEffect(Effect r100) {
        this.frontEffect = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setFront_effect(r100);
    L5:
        super.setFront_effect(r100);
    }

    public void setRearEffect(Effect r100) {
        this.rearEffect = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setRear_effect(r100);
    L5:
        super.setRear_effect(r100);
    }

    public void setTagsUpdateTime(String r100) {
        this.tagsUpdateTime = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setTags_update_time(r100);
    L5:
        super.setTags_update_time(r100);
    }

    public void setTotalEffects(List<? extends Effect> r100) {
        this.totalEffects = r100;
        EffectCategoryResponse r101 = getKCategoryResponse();
        if (r101 == null) goto L5;
        r101.setTotal_effects(r100);
    L5:
        super.setTotal_effects(r100);
    }

    public /* synthetic */ EffectCategoryResponseTemplate(EffectCategoryResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
