package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003Jo\u0010\u0011\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR.\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/downgrade/BlockDowngradeStrategyConfig;", "", "extraMatchers", "", "", "", "bodyMatchers", "queryMatchers", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getExtraMatchers", "()Ljava/util/Map;", "getBodyMatchers", "getQueryMatchers", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockDowngradeStrategyConfig {

    @SerializedName("body_matchers")
    private final Map<String, List<String>> bodyMatchers;

    @SerializedName("extra_matchers")
    private final Map<String, List<String>> extraMatchers;

    @SerializedName("query_matchers")
    private final Map<String, List<String>> queryMatchers;

    public BlockDowngradeStrategyConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BlockDowngradeStrategyConfig copy$default(BlockDowngradeStrategyConfig r100, Map r101, Map r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.extraMatchers;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bodyMatchers;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.queryMatchers;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final BlockDowngradeStrategyConfig copy(Map<String, ? extends List<String>> r100, Map<String, ? extends List<String>> r101, Map<String, ? extends List<String>> r102) {
        return new BlockDowngradeStrategyConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BlockDowngradeStrategyConfig) == true) goto L8;
        return false;
    L8:
        BlockDowngradeStrategyConfig r101 = (BlockDowngradeStrategyConfig) r100;
        if (Intrinsics.areEqual(this.extraMatchers, r101.extraMatchers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bodyMatchers, r101.bodyMatchers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMatchers, r101.queryMatchers) == true) goto L17;
        return false;
    L17:
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
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BlockDowngradeStrategyConfig(extraMatchers=" + this.extraMatchers + ", bodyMatchers=" + this.bodyMatchers + ", queryMatchers=" + this.queryMatchers + ')';
    }

    public final Map<String, List<String>> getBodyMatchers() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> getExtraMatchers() {
        return this.extraMatchers;
    }

    public final Map<String, List<String>> getQueryMatchers() {
        return this.queryMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockDowngradeStrategyConfig(Map<String, ? extends List<String>> r100, Map<String, ? extends List<String>> r101, Map<String, ? extends List<String>> r102) {
        this.extraMatchers = r100;
        this.bodyMatchers = r101;
        this.queryMatchers = r102;
    }

    public /* synthetic */ BlockDowngradeStrategyConfig(Map r100, Map r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = MapsKt.emptyMap();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        this(r100, r101, r102);
    }
}
