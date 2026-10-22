package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.SearchEffectModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/SearchEffectModelTemplate;", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "kSearchEffectModel", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "collectionList", "getCollectionList", "setCollectionList", "effectList", "getEffectList", "setEffectList", "getKSearchEffectModel", "()Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class SearchEffectModelTemplate extends SearchEffectModel {
    private List<? extends Effect> bindEffects;
    private List<? extends Effect> collectionList;
    private List<? extends Effect> effectList;
    private final transient SearchEffectModel kSearchEffectModel;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchEffectModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getBindEffects() {
        SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L7;
        List r101 = r100.getBind_effects();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L30;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L22;
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L22:
        List r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L24
    L26:
        if (r100 == null) goto L28;
        r100.setBind_effects(r106);
    L28:
        super.setBind_effects(r106);
        return r106;
    L30:
        return new ArrayList();
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = super.getBind_effects();
        goto L8
    }

    public List<Effect> getCollectionList() {
        SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L7;
        List r101 = r100.getCollection();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L30;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L22;
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L22:
        List r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L24
    L26:
        if (r100 == null) goto L28;
        r100.setCollection(r106);
    L28:
        super.setCollection(r106);
        return r106;
    L30:
        return new ArrayList();
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = super.getCollection();
        goto L8
    }

    public List<Effect> getEffectList() {
        SearchEffectModel r100 = getKSearchEffectModel();
        if (r100 == null) goto L7;
        List r101 = r100.getEffects();
        List r102 = r101;
        if (r101 == null) goto L7;
    L8:
        List r103 = r102;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L30;
        if ((ListProtector.get(r102, 0) instanceof Effect) == false) goto L22;
        if (r102 == null) goto L21;
        return r102;
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.Effect>");
    L22:
        List r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        r106.add(new Effect((com.ss.ugc.effectplatform.model.Effect) r107.next()));
        goto L24
    L26:
        if (r100 == null) goto L28;
        r100.setEffects(r106);
    L28:
        super.setEffects(r106);
        return r106;
    L30:
        return new ArrayList();
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r102 = super.getEffects();
        goto L8
    }

    public SearchEffectModel getKSearchEffectModel() {
        return this.kSearchEffectModel;
    }

    public SearchEffectModelTemplate(SearchEffectModel r110) {
        super(false, 0, null, null, null, null, null, null, 255, null);
        this.kSearchEffectModel = r110;
        this.effectList = new ArrayList();
        this.collectionList = new ArrayList();
        this.bindEffects = new ArrayList();
    }

    public void setBindEffects(List<? extends Effect> r100) {
        this.bindEffects = r100;
        SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    public void setCollectionList(List<? extends Effect> r100) {
        this.collectionList = r100;
        SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setCollection(r100);
    L5:
        super.setCollection(r100);
    }

    public void setEffectList(List<? extends Effect> r100) {
        this.effectList = r100;
        SearchEffectModel r101 = getKSearchEffectModel();
        if (r101 == null) goto L5;
        r101.setEffects(r100);
    L5:
        super.setEffects(r100);
    }

    public /* synthetic */ SearchEffectModelTemplate(SearchEffectModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
