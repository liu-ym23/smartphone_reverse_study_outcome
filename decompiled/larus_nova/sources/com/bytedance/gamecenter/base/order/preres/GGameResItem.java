package com.bytedance.gamecenter.base.order.preres;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GGameResItem;", "", "shelvedTime", "", "resourceInfo", "Lcom/bytedance/gamecenter/base/order/preres/GResourceInfo;", "useRes", "", "(JLcom/bytedance/gamecenter/base/order/preres/GResourceInfo;Z)V", "getResourceInfo", "()Lcom/bytedance/gamecenter/base/order/preres/GResourceInfo;", "setResourceInfo", "(Lcom/bytedance/gamecenter/base/order/preres/GResourceInfo;)V", "getShelvedTime", "()J", "setShelvedTime", "(J)V", "getUseRes", "()Z", "setUseRes", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final class GGameResItem {

    @SerializedName("resource_info")
    private GResourceInfo resourceInfo;

    @SerializedName("shelved_time")
    private long shelvedTime;

    @SerializedName("use_res")
    private boolean useRes;

    public GGameResItem() {
        this(0, null, false, 7, null);
    }

    public static /* synthetic */ GGameResItem copy$default(GGameResItem r100, long r101, GResourceInfo r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.shelvedTime;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.resourceInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.useRes;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.shelvedTime;
    }

    public final GResourceInfo component2() {
        return this.resourceInfo;
    }

    public final boolean component3() {
        return this.useRes;
    }

    public final GGameResItem copy(long r100, GResourceInfo r101, boolean r102) {
        return new GGameResItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GGameResItem) == false) goto L12;
        GGameResItem r101 = (GGameResItem) r100;
        if (this.shelvedTime == r101.shelvedTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resourceInfo, r101.resourceInfo) == true) goto L10;
        return false;
    L10:
        if (this.useRes == r101.useRes) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        long r100 = this.shelvedTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        GResourceInfo r102 = this.resourceInfo;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        int r104 = (r101 + r103) * 31;
        boolean r105 = this.useRes;
        ?? r106 = r105;
        if (r105 == false) goto L10;
        r106 = 1;
    L10:
        return r104 + r106;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "GGameResItem(shelvedTime=" + this.shelvedTime + ", resourceInfo=" + this.resourceInfo + ", useRes=" + this.useRes + ")";
    }

    public final GResourceInfo getResourceInfo() {
        return this.resourceInfo;
    }

    public final long getShelvedTime() {
        return this.shelvedTime;
    }

    public final boolean getUseRes() {
        return this.useRes;
    }

    public final void setResourceInfo(GResourceInfo r100) {
        this.resourceInfo = r100;
    }

    public final void setShelvedTime(long r100) {
        this.shelvedTime = r100;
    }

    public final void setUseRes(boolean r100) {
        this.useRes = r100;
    }

    public GGameResItem(long r100, GResourceInfo r101, boolean r102) {
        this.shelvedTime = r100;
        this.resourceInfo = r101;
        this.useRes = r102;
    }

    public /* synthetic */ GGameResItem(long r100, GResourceInfo r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
