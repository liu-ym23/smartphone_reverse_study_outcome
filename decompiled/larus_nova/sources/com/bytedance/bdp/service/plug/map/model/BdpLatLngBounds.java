package com.bytedance.bdp.service.plug.map.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;", "", "southWest", "Lcom/bytedance/bdp/service/plug/map/model/BdpLatLng;", "northEast", "(Lcom/bytedance/bdp/service/plug/map/model/BdpLatLng;Lcom/bytedance/bdp/service/plug/map/model/BdpLatLng;)V", "getNorthEast", "()Lcom/bytedance/bdp/service/plug/map/model/BdpLatLng;", "getSouthWest", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class BdpLatLngBounds {
    private final BdpLatLng northEast;
    private final BdpLatLng southWest;

    public static /* synthetic */ BdpLatLngBounds copy$default(BdpLatLngBounds r100, BdpLatLng r101, BdpLatLng r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.southWest;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.northEast;
    L9:
        return r100.copy(r101, r102);
    }

    public final BdpLatLng component1() {
        return this.southWest;
    }

    public final BdpLatLng component2() {
        return this.northEast;
    }

    public final BdpLatLngBounds copy(BdpLatLng r100, BdpLatLng r101) {
        return new BdpLatLngBounds(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BdpLatLngBounds) == false) goto L10;
        BdpLatLngBounds r101 = (BdpLatLngBounds) r100;
        if (Intrinsics.areEqual(this.southWest, r101.southWest) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.northEast, r101.northEast) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        BdpLatLng r100 = this.southWest;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BdpLatLng r104 = this.northEast;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BdpLatLngBounds(southWest=" + this.southWest + ", northEast=" + this.northEast + ")";
    }

    public final BdpLatLng getNorthEast() {
        return this.northEast;
    }

    public final BdpLatLng getSouthWest() {
        return this.southWest;
    }

    public BdpLatLngBounds(BdpLatLng r100, BdpLatLng r101) {
        this.southWest = r100;
        this.northEast = r101;
    }
}
