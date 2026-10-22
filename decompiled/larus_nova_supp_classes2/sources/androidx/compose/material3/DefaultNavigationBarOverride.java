package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultNavigationBarOverride;", "Landroidx/compose/material3/NavigationBarOverride;", "<init>", "()V", "NavigationBar", "", "Landroidx/compose/material3/NavigationBarOverrideScope;", "(Landroidx/compose/material3/NavigationBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultNavigationBarOverride implements NavigationBarOverride {
    public static final int $stable = 0;
    public static final DefaultNavigationBarOverride INSTANCE = null;

    static {
        INSTANCE = new DefaultNavigationBarOverride();
    }

    private DefaultNavigationBarOverride() {
    }

    private static final Unit NavigationBar$lambda$0(DefaultNavigationBarOverride r0, NavigationBarOverrideScope r1, int r2, Composer r3, int r4) {
        r0.NavigationBar(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DefaultNavigationBarOverride r0, NavigationBarOverrideScope r1, int r2, Composer r3, int r4) {
        return NavigationBar$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.material3.NavigationBarOverride
    public void NavigationBar(final NavigationBarOverrideScope r18, Composer r19, final int r20) {
        Composer r15 = r19.startRestartGroup(882141204);
        if ((r20 & 6) == 0) goto L5;
        int r3 = r20;
    L11:
        if ((r3 & 3) == 2) goto L13;
        boolean r4 = true;
    L15:
        if (r15.shouldExecute(r4, r3 & 1) == true) goto L17;
        Composer r2 = r15;
        r2.skipToGroupEnd();
    L23:
        ScopeUpdateScope r5 = r2.endRestartGroup();
        if (r5 == null) goto L27;
        r5.updateScope(new k8(this, r18, r20));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(882141204, r3, -1, "androidx.compose.material3.DefaultNavigationBarOverride.NavigationBar (NavigationBar.kt:139)");
    L19:
        long r7 = r18.m2899getContainerColor0d7_KjU();
        long r9 = r18.m2900getContentColor0d7_KjU();
        float r6 = r18.m2901getTonalElevationD9Ej5fM();
        r2 = r15;
        SurfaceKt.m3213SurfaceT9BRK9s(r18.getModifier(), null, r7, r9, r6, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(1991263321, true, new AnonymousClass1(r18), r15, 54), r15, 12582912, 98);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r4 = false;
        goto L15
    L5:
        if (r15.changed(r18) == false) goto L7;
        int r8 = 4;
    L8:
        r3 = r8 | r20;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }
}
