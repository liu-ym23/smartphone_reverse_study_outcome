package fsc;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static final void a(MutableRect r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.set(r100.getLeft() - r101, r100.getTop() - r101, r100.getRight() + r101, r100.getBottom() + r101);
    }

    public static final void b(MutableRect r100, MutableRect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r100.overlaps(r101) == false) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        r100.intersect(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom());
        return;
    L5:
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static final void c(MutableRect r100, MutableRect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        r100.set(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom());
    }

    public static final void d(MutableRect r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        r100.set(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom());
    }

    public static final void e(MutableRect r100, MutableRect r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r101.getLeft() < r101.getRight()) goto L5;
        return;
    L5:
        if (r101.getTop() < r101.getBottom()) goto L8;
        return;
    L8:
        if (r100.getLeft() < r100.getRight()) goto L10;
    L12:
        c(r100, r101);
        return;
    L10:
        if (r100.getTop() >= r100.getBottom()) goto L12;
        r100.setLeft(Math.min(r100.getLeft(), r101.getLeft()));
        r100.setTop(Math.min(r100.getTop(), r101.getTop()));
        r100.setRight(Math.max(r100.getRight(), r101.getRight()));
        r100.setBottom(Math.max(r100.getBottom(), r101.getBottom()));
    }
}
