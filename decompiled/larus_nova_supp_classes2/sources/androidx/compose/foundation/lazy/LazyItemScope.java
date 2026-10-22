package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@LazyScopeMarker
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0017JB\u0010\f\u001a\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScope;", "", "fillParentMaxSize", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxWidth", "fillParentMaxHeight", "animateItemPlacement", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "animateItem", "fadeInSpec", "placementSpec", "fadeOutSpec", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyItemScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyItemScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Modifier $default$animateItem(LazyItemScope r0, Modifier r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3, FiniteAnimationSpec r4) {
            return r1;
        }

        public static Modifier $default$animateItemPlacement(LazyItemScope r1, Modifier r2, FiniteAnimationSpec r3) {
            return r1.animateItem(r2, null, r3, null);
        }

        public static /* synthetic */ Modifier access$animateItemPlacement$jd(LazyItemScope r0, Modifier r1, FiniteAnimationSpec r2) {
            return $default$animateItemPlacement(r0, r1, r2);
        }

        public static /* synthetic */ Modifier access$animateItem$jd(LazyItemScope r0, Modifier r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3, FiniteAnimationSpec r4) {
            return $default$animateItem(r0, r1, r2, r3, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Modifier animateItemPlacement$default(LazyItemScope r2, Modifier r3, FiniteAnimationSpec r4, int r5, Object r6) {
            if (r6 != null) goto L9;
            if ((r5 & 1) == 0) goto L7;
            r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        L7:
            return r2.animateItemPlacement(r3, r4);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
        }

        public static /* synthetic */ Modifier fillParentMaxHeight$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L7;
            r2 = 1.0f;
        L7:
            return r0.fillParentMaxHeight(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
        }

        public static /* synthetic */ Modifier fillParentMaxSize$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L7;
            r2 = 1.0f;
        L7:
            return r0.fillParentMaxSize(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
        }

        public static /* synthetic */ Modifier fillParentMaxWidth$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 1) == 0) goto L7;
            r2 = 1.0f;
        L7:
            return r0.fillParentMaxWidth(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Modifier animateItem$default(LazyItemScope r6, Modifier r7, FiniteAnimationSpec r8, FiniteAnimationSpec r9, FiniteAnimationSpec r10, int r11, Object r12) {
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

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Modifier animateItemPlacement(LazyItemScope r0, Modifier r1, FiniteAnimationSpec<IntOffset> r2) {
            return CC.access$animateItemPlacement$jd(r0, r1, r2);
        }

        public static Modifier animateItem(LazyItemScope r0, Modifier r1, FiniteAnimationSpec<Float> r2, FiniteAnimationSpec<IntOffset> r3, FiniteAnimationSpec<Float> r4) {
            return CC.access$animateItem$jd(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Modifier animateItemPlacement$default(LazyItemScope r0, Modifier r1, FiniteAnimationSpec r2, int r3, Object r4) {
            return CC.animateItemPlacement$default(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Modifier fillParentMaxHeight$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            return CC.fillParentMaxHeight$default(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Modifier fillParentMaxSize$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            return CC.fillParentMaxSize$default(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Modifier fillParentMaxWidth$default(LazyItemScope r0, Modifier r1, float r2, int r3, Object r4) {
            return CC.fillParentMaxWidth$default(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Modifier animateItem$default(LazyItemScope r0, Modifier r1, FiniteAnimationSpec r2, FiniteAnimationSpec r3, FiniteAnimationSpec r4, int r5, Object r6) {
            return CC.animateItem$default(r0, r1, r2, r3, r4, r5, r6);
        }
    }

    Modifier animateItem(Modifier r1, FiniteAnimationSpec<Float> r2, FiniteAnimationSpec<IntOffset> r3, FiniteAnimationSpec<Float> r4);

    Modifier animateItemPlacement(Modifier r1, FiniteAnimationSpec<IntOffset> r2);

    Modifier fillParentMaxHeight(Modifier r1, float r2);

    Modifier fillParentMaxSize(Modifier r1, float r2);

    Modifier fillParentMaxWidth(Modifier r1, float r2);
}
