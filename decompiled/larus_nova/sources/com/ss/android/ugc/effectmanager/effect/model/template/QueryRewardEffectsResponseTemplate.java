package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/QueryRewardEffectsResponseTemplate;", "Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "kQueryRewardEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;)V", "getKQueryRewardEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "value", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "rewardEffects", "getRewardEffects", "()Ljava/util/List;", "setRewardEffects", "(Ljava/util/List;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class QueryRewardEffectsResponseTemplate extends QueryRewardEffectsResponse {
    private final transient QueryRewardEffectsResponse kQueryRewardEffectsResponse;
    private List<? extends Effect> rewardEffects;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryRewardEffectsResponseTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<Effect> getRewardEffects() {
        QueryRewardEffectsResponse r100 = getKQueryRewardEffectsResponse();
        if (r100 == null) goto L7;
        List r101 = r100.getReward_effects();
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
        r100.setReward_effects(r104);
    L22:
        super.setReward_effects(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getReward_effects();
        goto L9
    }

    public QueryRewardEffectsResponse getKQueryRewardEffectsResponse() {
        return this.kQueryRewardEffectsResponse;
    }

    public QueryRewardEffectsResponseTemplate(QueryRewardEffectsResponse r110) {
        super(null, 0, null, false, 0, null, 63, null);
        this.kQueryRewardEffectsResponse = r110;
        this.rewardEffects = new ArrayList();
    }

    public void setRewardEffects(List<? extends Effect> r100) {
        this.rewardEffects = r100;
        QueryRewardEffectsResponse r101 = getKQueryRewardEffectsResponse();
        if (r101 == null) goto L5;
        r101.setReward_effects(r100);
    L5:
        super.setReward_effects(r100);
    }

    public /* synthetic */ QueryRewardEffectsResponseTemplate(QueryRewardEffectsResponse r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
