package v98;

import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f553818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PopupWindow f553821d;

    public final void a(int r100) {
        int r101 = this.f553820c + RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r100, 0) - this.f553819b, 0);
        if (this.f553818a.getPaddingBottom() != r101) goto L5;
        return;
    L5:
        RecyclerView r102 = this.f553818a;
        r102.setPadding(r102.getPaddingLeft(), this.f553818a.getPaddingTop(), this.f553818a.getPaddingRight(), r101);
    }

    public d(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f553818a = r100;
        this.f553819b = r101;
        this.f553820c = r100.getPaddingBottom();
    }
}
