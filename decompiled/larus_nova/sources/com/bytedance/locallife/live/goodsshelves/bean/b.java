package com.bytedance.locallife.live.goodsshelves.bean;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveGoodsShelvesCard f259586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f259587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f259588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ev6.d f259589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f259590e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f259586a, r101.f259586a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f259587b, r101.f259587b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f259588c, r101.f259588c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f259589d, r101.f259589d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f259586a.hashCode() * 31) + this.f259587b.hashCode()) * 31;
        Map<String, Object> r101 = this.f259588c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ev6.d r105 = this.f259589d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GoodsShelfCardDataWrapper(nativeShelvesCardData=" + this.f259586a + ", lynxCardData=" + this.f259587b + ", dslCardData=" + this.f259588c + ", nativeCardUIData=" + this.f259589d + ')';
    }

    public b(LiveGoodsShelvesCard r100, Map<String, Object> r101, Map<String, Object> r102, ev6.d r103) {
        Intrinsics.checkNotNullParameter(r100, "nativeShelvesCardData");
        Intrinsics.checkNotNullParameter(r101, "lynxCardData");
        this.f259586a = r100;
        this.f259587b = r101;
        this.f259588c = r102;
        this.f259589d = r103;
    }
}
