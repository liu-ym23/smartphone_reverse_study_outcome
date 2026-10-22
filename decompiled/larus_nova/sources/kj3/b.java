package kj3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f503699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f503700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f503701c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f503699a, r101.f503699a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f503700b, r101.f503700b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f503701c, r101.f503701c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f503699a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f503700b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f503701c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopRefreshFilterEvent(filterParams=" + this.f503699a + ", clientState=" + this.f503700b + ", tabId=" + this.f503701c + ")";
    }

    public b(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101, Integer r102) {
        this.f503699a = r100;
        this.f503700b = r101;
        this.f503701c = r102;
    }
}
