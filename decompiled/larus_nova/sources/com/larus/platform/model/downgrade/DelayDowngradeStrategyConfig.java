package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u0083\u0001\u0010\u0019\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR.\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/downgrade/DelayDowngradeStrategyConfig;", "", "extraMatchers", "", "", "", "bodyMatchers", "queryMatchers", "baseDelayMs", "", "jitterMs", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJ)V", "getExtraMatchers", "()Ljava/util/Map;", "getBodyMatchers", "getQueryMatchers", "getBaseDelayMs", "()J", "getJitterMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DelayDowngradeStrategyConfig {

    @SerializedName("base_delay_ms")
    private final long baseDelayMs;

    @SerializedName("body_matchers")
    private final Map<String, List<String>> bodyMatchers;

    @SerializedName("extra_matchers")
    private final Map<String, List<String>> extraMatchers;

    @SerializedName("jitter_ms")
    private final long jitterMs;

    @SerializedName("query_matchers")
    private final Map<String, List<String>> queryMatchers;

    public DelayDowngradeStrategyConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DelayDowngradeStrategyConfig copy$default(DelayDowngradeStrategyConfig r100, Map r101, Map r102, Map r103, long r104, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.extraMatchers;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.bodyMatchers;
    L8:
        Map r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.queryMatchers;
    L11:
        Map r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.baseDelayMs;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.jitterMs;
    L17:
        Map r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final Map<String, List<String>> component1() {
        return this.extraMatchers;
    }

    public final Map<String, List<String>> component2() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> component3() {
        return this.queryMatchers;
    }

    public final long component4() {
        return this.baseDelayMs;
    }

    public final long component5() {
        return this.jitterMs;
    }

    public final DelayDowngradeStrategyConfig copy(Map<String, ? extends List<String>> r110, Map<String, ? extends List<String>> r111, Map<String, ? extends List<String>> r112, long r113, long r114) {
        return new DelayDowngradeStrategyConfig(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DelayDowngradeStrategyConfig) == true) goto L8;
        return false;
    L8:
        DelayDowngradeStrategyConfig r101 = (DelayDowngradeStrategyConfig) r100;
        if (Intrinsics.areEqual(this.extraMatchers, r101.extraMatchers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bodyMatchers, r101.bodyMatchers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMatchers, r101.queryMatchers) == true) goto L18;
        return false;
    L18:
        if (this.baseDelayMs == r101.baseDelayMs) goto L21;
        return false;
    L21:
        if (this.jitterMs == r101.jitterMs) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Map<String, List<String>> r100 = this.extraMatchers;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.bodyMatchers;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, List<String>> r107 = this.queryMatchers;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.baseDelayMs;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.jitterMs;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DelayDowngradeStrategyConfig(extraMatchers=" + this.extraMatchers + ", bodyMatchers=" + this.bodyMatchers + ", queryMatchers=" + this.queryMatchers + ", baseDelayMs=" + this.baseDelayMs + ", jitterMs=" + this.jitterMs + ')';
    }

    public final long getBaseDelayMs() {
        return this.baseDelayMs;
    }

    public final Map<String, List<String>> getBodyMatchers() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> getExtraMatchers() {
        return this.extraMatchers;
    }

    public final long getJitterMs() {
        return this.jitterMs;
    }

    public final Map<String, List<String>> getQueryMatchers() {
        return this.queryMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelayDowngradeStrategyConfig(Map<String, ? extends List<String>> r100, Map<String, ? extends List<String>> r101, Map<String, ? extends List<String>> r102, long r103, long r104) {
        this.extraMatchers = r100;
        this.bodyMatchers = r101;
        this.queryMatchers = r102;
        this.baseDelayMs = r103;
        this.jitterMs = r104;
    }

    public /* synthetic */ DelayDowngradeStrategyConfig(Map r100, Map r101, Map r102, long r103, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        Map r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        Map r104 = r102;
        long r105 = 0;
        if ((r111 & 8) == 0) goto L14;
        long r106 = 0;
    L16:
        if ((r111 & 16) != 0) goto L19;
        r105 = r110;
    L19:
        this(r100, r113, r104, r106, r105);
        return;
    L14:
        r106 = r103;
        goto L16
    }
}
