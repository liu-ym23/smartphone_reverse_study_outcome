package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultWideNavigationRailOverride;", "Landroidx/compose/material3/WideNavigationRailOverride;", "<init>", "()V", "WideNavigationRail", "", "Landroidx/compose/material3/WideNavigationRailOverrideScope;", "(Landroidx/compose/material3/WideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultWideNavigationRailOverride implements WideNavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultWideNavigationRailOverride INSTANCE = null;

    static {
        INSTANCE = new DefaultWideNavigationRailOverride();
    }

    private DefaultWideNavigationRailOverride() {
    }

    private static final Unit WideNavigationRail$lambda$0(DefaultWideNavigationRailOverride r0, WideNavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        r0.WideNavigationRail(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DefaultWideNavigationRailOverride r0, WideNavigationRailOverrideScope r1, int r2, Composer r3, int r4) {
        return WideNavigationRail$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.material3.WideNavigationRailOverride
    public void WideNavigationRail(final WideNavigationRailOverrideScope r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-1829525426);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L14:
        if ((r1 & 3) == 2) goto L16;
        boolean r2 = true;
    L18:
        if (r16.shouldExecute(r2, r1 & 1) == true) goto L20;
        r16.skipToGroupEnd();
    L26:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L30;
        r17.updateScope(new e9(this, r13, r15));
        return;
    L30:
        return;
    L20:
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventStart(-1829525426, r1, -1, "androidx.compose.material3.DefaultWideNavigationRailOverride.WideNavigationRail (WideNavigationRail.kt:192)");
    L22:
        WideNavigationRailKt.access$WideNavigationRailLayout(r13.getModifier(), false, WideNavigationRailStateKt.isExpanded(r13.getState().getTargetValue()), r13.getColors(), r13.getShape(), r13.getHeader(), r13.getWindowInsets(), r13.getArrangement(), r13.getContent(), r16, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
        goto L26
    L16:
        r2 = false;
        goto L18
    L5:
        if ((r15 & 8) != 0) goto L7;
        boolean r3 = r16.changed(r13);
    L8:
        if (r3 == false) goto L10;
        int r4 = 4;
    L11:
        r1 = r4 | r15;
        goto L14
    L10:
        r4 = 2;
        goto L11
    L7:
        r3 = r16.changedInstance(r13);
        goto L8
    }
}
