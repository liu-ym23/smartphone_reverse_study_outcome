package wq9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f560761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f560762b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f560761a, r101.f560761a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560762b, r101.f560762b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f560761a.hashCode() * 31;
        View r101 = this.f560762b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowMarkerOptions(latLng=" + this.f560761a + ", view=" + this.f560762b + ')';
    }

    public b(a r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "latLng");
        this.f560761a = r100;
        this.f560762b = r101;
    }
}
