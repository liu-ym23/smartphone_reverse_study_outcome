package androidx.compose.foundation.lazy.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"LazyLayoutCacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "ahead", "Landroidx/compose/ui/unit/Dp;", "behind", "LazyLayoutCacheWindow-YgX7TsA", "(FF)Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "aheadFraction", "", "behindFraction", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutCacheWindowKt {
    public static final LazyLayoutCacheWindow LazyLayoutCacheWindow(float r1, float r2) {
        return new FractionLazyLayoutCacheWindow(r1, r2);
    }

    /* JADX INFO: renamed from: LazyLayoutCacheWindow-YgX7TsA, reason: not valid java name */
    public static final LazyLayoutCacheWindow m1139LazyLayoutCacheWindowYgX7TsA(float r2, float r3) {
        return new DpLazyLayoutCacheWindow(r2, r3, null);
    }

    public static /* synthetic */ LazyLayoutCacheWindow LazyLayoutCacheWindow$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = MenuKt.ClosedAlphaTarget;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = MenuKt.ClosedAlphaTarget;
    L9:
        return LazyLayoutCacheWindow(r1, r2);
    }

    /* JADX INFO: renamed from: LazyLayoutCacheWindow-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ LazyLayoutCacheWindow m1140LazyLayoutCacheWindowYgX7TsA$default(float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.constructor-impl(0);
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.constructor-impl(0);
    L9:
        return m1139LazyLayoutCacheWindowYgX7TsA(r1, r2);
    }
}
