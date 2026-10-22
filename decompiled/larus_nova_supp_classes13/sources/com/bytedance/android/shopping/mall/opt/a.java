package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/a;", "", "", "defaultCount", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "defaultDispersed", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "defaultDispersedInterval", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "defaultOffset", "d", "", "", "Lcom/bytedance/android/shopping/mall/opt/b;", "pageConfigMap", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("default_count")
    private final Integer defaultCount;

    @SerializedName("default_dispersed")
    private final Boolean defaultDispersed;

    @SerializedName("default_dispersed_interval")
    private final Long defaultDispersedInterval;

    @SerializedName("default_offset")
    private final Integer defaultOffset;

    @SerializedName("page_config_map")
    private final Map<String, b> pageConfigMap;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.defaultCount, r4.defaultCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultDispersed, r4.defaultDispersed) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultDispersedInterval, r4.defaultDispersedInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultOffset, r4.defaultOffset) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pageConfigMap, r4.pageConfigMap) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.defaultCount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.defaultDispersed;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.defaultDispersedInterval;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.defaultOffset;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, b> r13 = this.pageConfigMap;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedPreBindOnLoadMoreSuccessConfig(defaultCount=" + this.defaultCount + ", defaultDispersed=" + this.defaultDispersed + ", defaultDispersedInterval=" + this.defaultDispersedInterval + ", defaultOffset=" + this.defaultOffset + ", pageConfigMap=" + this.pageConfigMap + ")";
    }

    public a() {
        this.defaultCount = null;
        this.defaultDispersed = null;
        this.defaultDispersedInterval = null;
        this.defaultOffset = null;
        this.pageConfigMap = null;
    }

    public final Integer a() {
        return this.defaultCount;
    }

    public final Boolean b() {
        return this.defaultDispersed;
    }

    public final Long c() {
        return this.defaultDispersedInterval;
    }

    public final Integer d() {
        return this.defaultOffset;
    }

    public final Map<String, b> e() {
        return this.pageConfigMap;
    }
}
