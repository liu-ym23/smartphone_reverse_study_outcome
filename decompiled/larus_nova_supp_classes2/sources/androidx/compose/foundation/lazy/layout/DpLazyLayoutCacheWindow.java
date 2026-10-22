package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0014\u0010\u000f\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DpLazyLayoutCacheWindow;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "ahead", "Landroidx/compose/ui/unit/Dp;", "behind", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAhead-D9Ej5fM", "()F", "F", "getBehind-D9Ej5fM", "calculateAheadWindow", "", "Landroidx/compose/ui/unit/Density;", "viewport", "calculateBehindWindow", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DpLazyLayoutCacheWindow implements LazyLayoutCacheWindow {
    private final float ahead;
    private final float behind;

    public /* synthetic */ DpLazyLayoutCacheWindow(float r1, float r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.ahead) * 31) + Dp.hashCode-impl(this.behind);
    }

    /* JADX INFO: renamed from: getAhead-D9Ej5fM, reason: not valid java name */
    public final float m1128getAheadD9Ej5fM() {
        return this.ahead;
    }

    /* JADX INFO: renamed from: getBehind-D9Ej5fM, reason: not valid java name */
    public final float m1129getBehindD9Ej5fM() {
        return this.behind;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof DpLazyLayoutCacheWindow) == false) goto L10;
        DpLazyLayoutCacheWindow r5 = (DpLazyLayoutCacheWindow) r4;
        if (Dp.equals-impl0(r5.ahead, this.ahead) == true) goto L7;
        return false;
    L7:
        if (Dp.equals-impl0(r5.behind, this.behind) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private DpLazyLayoutCacheWindow(float r1, float r2) {
        this.ahead = r1;
        this.behind = r2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public int calculateAheadWindow(Density r1, int r2) {
        return r1.roundToPx-0680j_4(this.ahead);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow
    public int calculateBehindWindow(Density r1, int r2) {
        return r1.roundToPx-0680j_4(this.behind);
    }
}
