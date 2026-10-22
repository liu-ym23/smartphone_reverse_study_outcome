package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeature;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/SearchEffectResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "kSearchEffect", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "getKSearchEffect", "()Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "getCollection", "getEffects", "setCollection", "", "setEffects", KFFeature.EFFECT_JSON_FIELD, "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class SearchEffectResponseTemplate extends SearchEffectResponse {
    private List<? extends Effect> bindEffects;
    private boolean hasMore;
    private final transient SearchEffectResponse kSearchEffect;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchEffectResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getBindEffects() {
        SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L7;
        List r101 = r100.getBind_effects();
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
        r100.setBind_effects(r104);
    L22:
        super.setBind_effects(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getBind_effects();
        goto L9
    }

    public List<Effect> getCollection() {
        SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L10;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getCollection_list();
        if (r101 == null) goto L10;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        r103.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r104.next()));
    L14:
        return r103;
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r105 = super.getCollection_list();
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r103.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r106.next()));
        goto L12
    }

    public List<Effect> getEffects() {
        SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L10;
        List<com.ss.ugc.effectplatform.model.Effect> r101 = r100.getEffect_list();
        if (r101 == null) goto L10;
        List<com.ss.ugc.effectplatform.model.Effect> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        r103.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r104.next()));
    L14:
        return r103;
    L10:
        List<com.ss.ugc.effectplatform.model.Effect> r105 = super.getEffect_list();
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r103.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r106.next()));
        goto L12
    }

    public boolean getHasMore() {
        SearchEffectResponse r100 = getKSearchEffect();
        if (r100 == null) goto L6;
        return r100.getHas_more();
    L6:
        return super.getHas_more();
    }

    public SearchEffectResponse getKSearchEffect() {
        return this.kSearchEffect;
    }

    public SearchEffectResponseTemplate(SearchEffectResponse r110) {
        super(false, 0, null, null, null, 0, null, 127, null);
        this.kSearchEffect = r110;
        this.bindEffects = new ArrayList();
    }

    public void setBindEffects(List<? extends Effect> r100) {
        this.bindEffects = r100;
        SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    public void setCollection(List<? extends Effect> r100) {
        SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setCollection_list(r100);
    L5:
        super.setCollection_list(r100);
    }

    public void setEffects(List<? extends Effect> r100) {
        SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setEffect_list(r100);
    L5:
        super.setEffect_list(r100);
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
        SearchEffectResponse r101 = getKSearchEffect();
        if (r101 == null) goto L5;
        r101.setHas_more(r100);
    L5:
        super.setHas_more(r100);
    }

    public /* synthetic */ SearchEffectResponseTemplate(SearchEffectResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
