package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@LazyGridScopeMarker
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0017JB\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005H&\u0082\u0001\u0001\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "animateItem", "fadeInSpec", "", "placementSpec", "fadeOutSpec", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScopeImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyGridItemScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridItemScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Modifier $default$animateItemPlacement(LazyGridItemScope r1, Modifier r2, FiniteAnimationSpec r3) {
            return r1.animateItem(r2, null, r3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Modifier animateItemPlacement$default(LazyGridItemScope r2, Modifier r3, FiniteAnimationSpec r4, int r5, Object r6) {
            if (r6 != null) goto L9;
            if ((r5 & 1) == 0) goto L7;
            r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        L7:
            return r2.animateItemPlacement(r3, r4);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Modifier animateItem$default(LazyGridItemScope r6, Modifier r7, FiniteAnimationSpec r8, FiniteAnimationSpec r9, FiniteAnimationSpec r10, int r11, Object r12) {
            if (r12 != null) goto L15;
            if ((r11 & 1) == 0) goto L7;
            r8 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
        L7:
            if ((r11 & 2) == 0) goto L10;
            r9 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        L10:
            if ((r11 & 4) == 0) goto L13;
            r10 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, null, 5, null);
        L13:
            return r6.animateItem(r7, r8, r9, r10);
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItem");
        }
    }

    Modifier animateItem(Modifier r1, FiniteAnimationSpec<Float> r2, FiniteAnimationSpec<IntOffset> r3, FiniteAnimationSpec<Float> r4);

    Modifier animateItemPlacement(Modifier r1, FiniteAnimationSpec<IntOffset> r2);
}
