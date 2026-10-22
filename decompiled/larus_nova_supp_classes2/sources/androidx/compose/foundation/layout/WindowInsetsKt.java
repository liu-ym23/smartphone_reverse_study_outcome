package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0019\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0007¢\u0006\u0002\u0010\f\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u000bH\u0000\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a.\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u001a5\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u00162\b\b\u0002\u0010\u0014\u001a\u00020\u00162\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"union", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "exclude", "add", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "asPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "asInsets", "WindowInsets", "left", "", "top", "right", "bottom", "Landroidx/compose/ui/unit/Dp;", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "EmptyWindowInsets", "Landroidx/compose/foundation/layout/FixedIntInsets;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsKt {
    private static final FixedIntInsets EmptyWindowInsets = null;

    static {
        EmptyWindowInsets = new FixedIntInsets(0, 0, 0, 0);
    }

    public static final WindowInsets WindowInsets() {
        return EmptyWindowInsets;
    }

    public static final WindowInsets asInsets(PaddingValues r1) {
        return new PaddingValuesInsets(r1);
    }

    public static final WindowInsets add(WindowInsets r1, WindowInsets r2) {
        return new AddedInsets(r1, r2);
    }

    public static final PaddingValues asPaddingValues(WindowInsets r1, Density r2) {
        return new InsetsPaddingValues(r1, r2);
    }

    public static final WindowInsets exclude(WindowInsets r1, WindowInsets r2) {
        return new ExcludeInsets(r1, r2);
    }

    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m1046onlybOOhFvg(WindowInsets r2, int r3) {
        return new LimitInsets(r2, r3, null);
    }

    public static final WindowInsets union(WindowInsets r1, WindowInsets r2) {
        return new UnionInsets(r1, r2);
    }

    public static final PaddingValues asPaddingValues(WindowInsets r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1485016250, r5, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:220)");
    L5:
        InsetsPaddingValues r6 = new InsetsPaddingValues(r3, (Density) r4.consume(CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public static final WindowInsets WindowInsets(int r1, int r2, int r3, int r4) {
        return new FixedIntInsets(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m1044WindowInsetsa9UjIt4(float r7, float r8, float r9, float r10) {
        return new FixedDpInsets(r7, r8, r9, r10, null);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = 0;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = 0;
    L15:
        return WindowInsets(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1045WindowInsetsa9UjIt4$default(float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Dp.constructor-impl(0);
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Dp.constructor-impl(0);
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Dp.constructor-impl(0);
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.constructor-impl(0);
    L15:
        return m1044WindowInsetsa9UjIt4(r1, r2, r3, r4);
    }
}
