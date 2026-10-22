package com.bytedance.locallife.biz.collect.guide;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/biz/collect/guide/CollectGuideFrequencyInfo;", "", "Lcom/bytedance/locallife/biz/collect/guide/SortRuleGuide;", "component1", "sortRuleGuide", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/locallife/biz/collect/guide/SortRuleGuide;", "getSortRuleGuide", "()Lcom/bytedance/locallife/biz/collect/guide/SortRuleGuide;", "<init>", "(Lcom/bytedance/locallife/biz/collect/guide/SortRuleGuide;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class CollectGuideFrequencyInfo {
    public static final a Companion = null;
    public static final int alwaysShow = -1;

    @SerializedName("sort_rule_guide")
    private final SortRuleGuide sortRuleGuide;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectGuideFrequencyInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CollectGuideFrequencyInfo copy$default(CollectGuideFrequencyInfo r100, SortRuleGuide r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.sortRuleGuide;
    L6:
        return r100.copy(r101);
    }

    public final SortRuleGuide component1() {
        return this.sortRuleGuide;
    }

    public final CollectGuideFrequencyInfo copy(SortRuleGuide r100) {
        return new CollectGuideFrequencyInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectGuideFrequencyInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.sortRuleGuide, ((CollectGuideFrequencyInfo) r100).sortRuleGuide) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        SortRuleGuide r100 = this.sortRuleGuide;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "CollectGuideFrequencyInfo(sortRuleGuide=" + this.sortRuleGuide + ')';
    }

    public final SortRuleGuide getSortRuleGuide() {
        return this.sortRuleGuide;
    }

    public CollectGuideFrequencyInfo(SortRuleGuide r100) {
        this.sortRuleGuide = r100;
    }

    public /* synthetic */ CollectGuideFrequencyInfo(SortRuleGuide r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
