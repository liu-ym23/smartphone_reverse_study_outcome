package x76;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements SpanWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f562827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f562828b;

    public d() {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
        if (Intrinsics.areEqual(r101, Selection.SELECTION_END) == false) goto L18;
        if (this.f562828b == r104) goto L18;
        this.f562828b = r104;
        if (r100 == null) goto L18;
        b[] r106 = (b[]) r100.getSpans(r104, r105, b.class);
        if (r106 == null) goto L18;
        b r107 = (b) ArraysKt.firstOrNull(r106);
        if (r107 == null) goto L18;
        int r108 = r100.getSpanStart(r107);
        int r109 = r100.getSpanEnd(r107);
        if (Math.abs(this.f562828b - r109) > Math.abs(this.f562828b - r108)) goto L16;
        r108 = r109;
    L16:
        Selection.setSelection(r100, Selection.getSelectionStart(r100), r108);
    L18:
        if (r101 == Selection.SELECTION_START) goto L20;
        return;
    L20:
        if (this.f562827a == r104) goto L34;
        this.f562827a = r104;
        if (r100 == null) goto L35;
        b[] r110 = (b[]) r100.getSpans(r104, r105, b.class);
        if (r110 == null) goto L36;
        b r111 = (b) ArraysKt.firstOrNull(r110);
        if (r111 == null) goto L37;
        int r112 = r100.getSpanStart(r111);
        int r113 = r100.getSpanEnd(r111);
        if (Math.abs(this.f562827a - r113) > Math.abs(this.f562827a - r112)) goto L31;
        r112 = r113;
    L31:
        Selection.setSelection(r100, r112, Selection.getSelectionEnd(r100));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }
}
