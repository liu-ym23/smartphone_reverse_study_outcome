package pla;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {
    public static final boolean d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }

    public static final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getParent() != null) goto L5;
        return;
    L5:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L10;
        ((ViewGroup) r101).removeView(r100);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        b(r100, r101, r101, false);
    }

    public static final void h(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        f(r100);
        return;
    L5:
        e(r100);
    }

    public static final void b(final View r100, final int r101, final int r110, final boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getParent() == null) goto L9;
        ViewParent r102 = r100.getParent();
        if (r102 == null) goto L8;
        ViewGroup r103 = (ViewGroup) r102;
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        final ViewGroup r104 = r103;
        r103.post(new h(r100, r101, r110, r111, r104));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r103 = null;
        goto L10
    }

    public static final void c(final View r100, final int r101, final int r102, final View... r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "views");
        final g r103 = new g(r100);
        r100.post(new i(r110, r100, r103, r101, r102));
    }
}
