package com.larus.platform.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/larus/platform/model/SubInfo;", "Ljava/io/Serializable;", "skuInfo", "Lcom/larus/platform/model/SKUInfo;", DyPayConstant.KEY_START_TIME, "", "endTime", "tradePlatform", "", "<init>", "(Lcom/larus/platform/model/SKUInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getSkuInfo", "()Lcom/larus/platform/model/SKUInfo;", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getTradePlatform", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/platform/model/SKUInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/model/SubInfo;", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubInfo implements Serializable {

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("sku_info")
    private final SKUInfo skuInfo;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    @SerializedName("trade_platform")
    private final Integer tradePlatform;

    public SubInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SubInfo copy$default(SubInfo r100, SKUInfo r101, Long r102, Long r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.skuInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.startTime;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.endTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.tradePlatform;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final SKUInfo component1() {
        return this.skuInfo;
    }

    public final Long component2() {
        return this.startTime;
    }

    public final Long component3() {
        return this.endTime;
    }

    public final Integer component4() {
        return this.tradePlatform;
    }

    public final SubInfo copy(SKUInfo r100, Long r101, Long r102, Integer r103) {
        return new SubInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubInfo) == true) goto L8;
        return false;
    L8:
        SubInfo r101 = (SubInfo) r100;
        if (Intrinsics.areEqual(this.skuInfo, r101.skuInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tradePlatform, r101.tradePlatform) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        SKUInfo r100 = this.skuInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.startTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.endTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.tradePlatform;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SubInfo(skuInfo=" + this.skuInfo + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", tradePlatform=" + this.tradePlatform + ')';
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final SKUInfo getSkuInfo() {
        return this.skuInfo;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getTradePlatform() {
        return this.tradePlatform;
    }

    public SubInfo(SKUInfo r100, Long r101, Long r102, Integer r103) {
        this.skuInfo = r100;
        this.startTime = r101;
        this.endTime = r102;
        this.tradePlatform = r103;
    }

    public /* synthetic */ SubInfo(SKUInfo r100, Long r101, Long r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
