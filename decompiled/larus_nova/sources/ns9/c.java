package ns9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f520362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f520363b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f520362a, r101.f520362a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520363b, r101.f520363b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f520362a.hashCode() * 31) + this.f520363b.hashCode();
    }

    public final String toString() {
        return "ReachBannerRenderContent(rootView=" + this.f520362a + ", contentView=" + this.f520363b + ')';
    }

    public c(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "contentView");
        this.f520362a = r100;
        this.f520363b = r101;
    }
}
