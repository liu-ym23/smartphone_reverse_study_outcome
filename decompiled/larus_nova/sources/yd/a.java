package yd;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f567294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f567295b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f567294a, r101.f567294a) == true) goto L8;
        return false;
    L8:
        if (this.f567295b == r101.f567295b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f567294a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f567295b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "IECExternalEntryView(view=" + this.f567294a + ", displayDuration=" + this.f567295b + ")";
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f567294a = r100;
        this.f567295b = 1000;
    }
}
