package com.bytedance.timonbase.commoncache;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/timonbase/commoncache/CacheGroup;", "", ComplianceConstants.ComplianceRequest.MARKET_STORE, "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "intercept", "", "apiIds", "", "", "params", "", "filter", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getApiIds", "()Ljava/util/List;", "getFilter", "()Ljava/lang/String;", "getIntercept", "()Z", "getParams", "()Ljava/util/Map;", "getStore", "getStrategy", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
public final class CacheGroup {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("filter")
    private final String filter;

    @SerializedName("intercept")
    private final boolean intercept;

    @SerializedName("params")
    private final Map<String, String> params;

    @SerializedName(ComplianceConstants.ComplianceRequest.MARKET_STORE)
    private final String store;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private final String strategy;

    public CacheGroup() {
        this(null, null, false, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheGroup copy$default(CacheGroup r100, String r101, String r102, boolean r103, List r104, Map r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.store;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.strategy;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.intercept;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.apiIds;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.params;
    L17:
        Map r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.filter;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.store;
    }

    public final String component2() {
        return this.strategy;
    }

    public final boolean component3() {
        return this.intercept;
    }

    public final List<Integer> component4() {
        return this.apiIds;
    }

    public final Map<String, String> component5() {
        return this.params;
    }

    public final String component6() {
        return this.filter;
    }

    public final CacheGroup copy(String r100, String r110, boolean r111, List<Integer> r112, Map<String, String> r113, String r114) {
        return new CacheGroup(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CacheGroup) == false) goto L18;
        CacheGroup r101 = (CacheGroup) r100;
        if (Intrinsics.areEqual(this.store, r101.store) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L10;
        return false;
    L10:
        if (this.intercept == r101.intercept) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.filter, r101.filter) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        String r100 = this.store;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.strategy;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.intercept;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.apiIds;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.params;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.filter;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CacheGroup(store=" + this.store + ", strategy=" + this.strategy + ", intercept=" + this.intercept + ", apiIds=" + this.apiIds + ", params=" + this.params + ", filter=" + this.filter + ")";
    }

    public final List<Integer> getApiIds() {
        return this.apiIds;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final boolean getIntercept() {
        return this.intercept;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getStore() {
        return this.store;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public CacheGroup(String r100, String r101, boolean r102, List<Integer> r103, Map<String, String> r104, String r105) {
        this.store = r100;
        this.strategy = r101;
        this.intercept = r102;
        this.apiIds = r103;
        this.params = r104;
        this.filter = r105;
    }

    public /* synthetic */ CacheGroup(String r100, String r101, boolean r102, List r103, Map r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "empty";
    L5:
        String r105 = "";
        if ((r111 & 2) == 0) goto L8;
        String r113 = "";
    L10:
        if ((r111 & 4) == 0) goto L12;
        boolean r106 = false;
    L14:
        if ((r111 & 8) == 0) goto L16;
        r103 = CollectionsKt.emptyList();
    L16:
        List r107 = r103;
        if ((r111 & 16) == 0) goto L19;
        r104 = MapsKt.emptyMap();
    L19:
        Map r108 = r104;
        if ((r111 & 32) != 0) goto L23;
        r105 = r110;
    L23:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
