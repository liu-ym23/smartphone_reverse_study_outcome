package com.ss.android.ugc.aweme.commercialize.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/commercialize/model/QponInfo;", "Ljava/io/Serializable;", "productId", "", "qponAction", "", "qcpxCouponInfo", "Lcom/ss/android/ugc/aweme/commercialize/model/QcpxCouponInfo;", "eventParams", "", "", "(Ljava/lang/String;ILcom/ss/android/ugc/aweme/commercialize/model/QcpxCouponInfo;Ljava/util/Map;)V", "getEventParams", "()Ljava/util/Map;", "getProductId", "()Ljava/lang/String;", "getQcpxCouponInfo", "()Lcom/ss/android/ugc/aweme/commercialize/model/QcpxCouponInfo;", "getQponAction", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class QponInfo implements Serializable {

    @SerializedName("event_params")
    private final Map<String, Object> eventParams;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("qcpx_coupon_info")
    private final QcpxCouponInfo qcpxCouponInfo;

    @SerializedName("qpon_action")
    private final int qponAction;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QponInfo copy$default(QponInfo r100, String r101, int r102, QcpxCouponInfo r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.qponAction;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.qcpxCouponInfo;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.eventParams;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.productId;
    }

    public final int component2() {
        return this.qponAction;
    }

    public final QcpxCouponInfo component3() {
        return this.qcpxCouponInfo;
    }

    public final Map<String, Object> component4() {
        return this.eventParams;
    }

    public final QponInfo copy(String r100, int r101, QcpxCouponInfo r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        return new QponInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QponInfo) == true) goto L8;
        return false;
    L8:
        QponInfo r101 = (QponInfo) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L12;
        return false;
    L12:
        if (this.qponAction == r101.qponAction) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.qcpxCouponInfo, r101.qcpxCouponInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.productId.hashCode() * 31) + this.qponAction) * 31;
        QcpxCouponInfo r101 = this.qcpxCouponInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.eventParams.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "QponInfo(productId=" + this.productId + ", qponAction=" + this.qponAction + ", qcpxCouponInfo=" + this.qcpxCouponInfo + ", eventParams=" + this.eventParams + ')';
    }

    public final Map<String, Object> getEventParams() {
        return this.eventParams;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final QcpxCouponInfo getQcpxCouponInfo() {
        return this.qcpxCouponInfo;
    }

    public final int getQponAction() {
        return this.qponAction;
    }

    public QponInfo(String r100, int r101, QcpxCouponInfo r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r103, "eventParams");
        this.productId = r100;
        this.qponAction = r101;
        this.qcpxCouponInfo = r102;
        this.eventParams = r103;
    }

    public /* synthetic */ QponInfo(String r100, int r101, QcpxCouponInfo r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = MapsKt.emptyMap();
    L11:
        this(r100, r101, r102, r103);
    }
}
