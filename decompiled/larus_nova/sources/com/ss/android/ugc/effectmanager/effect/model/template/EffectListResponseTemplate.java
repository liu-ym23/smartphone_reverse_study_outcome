package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0016\u001a\u00020\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/EffectListResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "kEffectList", "(Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;)V", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "bindEffects", "getBindEffects", "()Ljava/util/List;", "setBindEffects", "(Ljava/util/List;)V", "getKEffectList", "()Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "getCollection", "getData", "setCollection", "", "setData", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class EffectListResponseTemplate extends EffectListResponse {
    private List<? extends Effect> bindEffects;
    private final transient EffectListResponse kEffectList;
    private List<String> urlPrefix;

    /* JADX WARN: Multi-variable type inference failed */
    public EffectListResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getBindEffects() {
        EffectListResponse r100 = getKEffectList();
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
        EffectListResponse r100 = getKEffectList();
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

    public List<Effect> getData() {
        EffectListResponse r100 = getKEffectList();
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
        EffectListResponse r100 = getKEffectList();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    public EffectListResponse getKEffectList() {
        return this.kEffectList;
    }

    public EffectListResponseTemplate(EffectListResponse r110) {
        super(null, null, null, 0, null, null, 63, null);
        this.kEffectList = r110;
        this.bindEffects = new ArrayList();
        this.urlPrefix = new ArrayList();
    }

    public void setBindEffects(List<? extends Effect> r100) {
        this.bindEffects = r100;
        EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setBind_effects(r100);
    L5:
        super.setBind_effects(r100);
    }

    public void setCollection(List<? extends Effect> r100) {
        EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setCollection_list(r100);
    L5:
        super.setCollection_list(r100);
    }

    public void setData(List<? extends Effect> r100) {
        EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setEffect_list(r100);
    L5:
        super.setEffect_list(r100);
    }

    public void setUrlPrefix(List<String> r100) {
        this.urlPrefix = r100;
        EffectListResponse r101 = getKEffectList();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ EffectListResponseTemplate(EffectListResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
