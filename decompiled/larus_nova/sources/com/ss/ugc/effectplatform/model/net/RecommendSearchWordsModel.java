package com.ss.ugc.effectplatform.model.net;

import com.facebook.keyframes.model.KFFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;", "", "search_tips", "", KFFeature.EFFECT_JSON_FIELD, "", "Lcom/ss/ugc/effectplatform/model/net/EffectNameModel;", "(Ljava/lang/String;Ljava/util/List;)V", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getSearch_tips", "()Ljava/lang/String;", "setSearch_tips", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class RecommendSearchWordsModel {
    private List<EffectNameModel> effects;
    private String search_tips;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendSearchWordsModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendSearchWordsModel copy$default(RecommendSearchWordsModel r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.search_tips;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.effects;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.search_tips;
    }

    public final List<EffectNameModel> component2() {
        return this.effects;
    }

    public final RecommendSearchWordsModel copy(String r100, List<EffectNameModel> r101) {
        return new RecommendSearchWordsModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RecommendSearchWordsModel) == false) goto L10;
        RecommendSearchWordsModel r101 = (RecommendSearchWordsModel) r100;
        if (Intrinsics.areEqual(this.search_tips, r101.search_tips) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.effects, r101.effects) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.search_tips;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<EffectNameModel> r104 = this.effects;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RecommendSearchWordsModel(search_tips=" + this.search_tips + ", effects=" + this.effects + ")";
    }

    public final List<EffectNameModel> getEffects() {
        return this.effects;
    }

    public final String getSearch_tips() {
        return this.search_tips;
    }

    public final void setEffects(List<EffectNameModel> r100) {
        this.effects = r100;
    }

    public final void setSearch_tips(String r100) {
        this.search_tips = r100;
    }

    public RecommendSearchWordsModel(String r100, List<EffectNameModel> r101) {
        this.search_tips = r100;
        this.effects = r101;
    }

    public /* synthetic */ RecommendSearchWordsModel(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
