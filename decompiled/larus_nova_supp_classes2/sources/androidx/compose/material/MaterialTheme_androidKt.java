package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"PlatformMaterialTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialTheme_androidKt {
    private static final Unit PlatformMaterialTheme$lambda$0(Function2 r0, int r1, Composer r2, int r3) {
        PlatformMaterialTheme(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, int r1, Composer r2, int r3) {
        return PlatformMaterialTheme$lambda$0(r0, r1, r2, r3);
    }

    public static final void PlatformMaterialTheme(final Function2<? super Composer, ? super Integer, Unit> r4, Composer r5, final int r6) {
        Composer r7 = r5.startRestartGroup(-1677843913);
        if ((r6 & 6) == 0) goto L5;
        int r1 = r6;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r7.shouldExecute(r2, r1 & 1) == true) goto L17;
        r7.skipToGroupEnd();
    L23:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L27;
        r8.updateScope(new y5(r4, r6));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1677843913, r1, -1, "androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)");
    L19:
        r4.invoke(r7, Integer.valueOf(r1 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r7.changedInstance(r4) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r6;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }
}
