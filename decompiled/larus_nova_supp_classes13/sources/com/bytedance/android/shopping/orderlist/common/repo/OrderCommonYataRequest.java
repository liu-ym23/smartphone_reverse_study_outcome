package com.bytedance.android.shopping.orderlist.common.repo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/repo/OrderCommonYataRequest;", "Ljava/io/Serializable;", "exParams", "", "", "", "queryParams", "yataVersion", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getExParams", "()Ljava/util/Map;", "getQueryParams", "()Ljava/lang/String;", "getYataVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataRequest implements Serializable {

    @SerializedName("ex_params")
    private final Map<String, Object> exParams;

    @SerializedName("query_params")
    private final String queryParams;

    @SerializedName("yata_version")
    private final String yataVersion;

    public OrderCommonYataRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderCommonYataRequest copy$default(OrderCommonYataRequest r0, Map r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.exParams;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.queryParams;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.yataVersion;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Map<String, Object> component1() {
        return this.exParams;
    }

    public final String component2() {
        return this.queryParams;
    }

    public final String component3() {
        return this.yataVersion;
    }

    public final OrderCommonYataRequest copy(Map<String, ? extends Object> r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "yataVersion");
        return new OrderCommonYataRequest(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OrderCommonYataRequest) == false) goto L12;
        OrderCommonYataRequest r4 = (OrderCommonYataRequest) r3;
        if (Intrinsics.areEqual(this.exParams, r4.exParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.queryParams, r4.queryParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.yataVersion, r4.yataVersion) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Map<String, Object> r0 = this.exParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.queryParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.yataVersion;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "OrderCommonYataRequest(exParams=" + this.exParams + ", queryParams=" + this.queryParams + ", yataVersion=" + this.yataVersion + ")";
    }

    public final Map<String, Object> getExParams() {
        return this.exParams;
    }

    public final String getQueryParams() {
        return this.queryParams;
    }

    public final String getYataVersion() {
        return this.yataVersion;
    }

    public OrderCommonYataRequest(Map<String, ? extends Object> r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "yataVersion");
        this.exParams = r2;
        this.queryParams = r3;
        this.yataVersion = r4;
    }

    public /* synthetic */ OrderCommonYataRequest(Map r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
