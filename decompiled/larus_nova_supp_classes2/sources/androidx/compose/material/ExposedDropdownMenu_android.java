package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/view/View;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_android {
    private static final Unit OnPlatformWindowBoundsChange$lambda$4(Function0 r0, int r1, Composer r2, int r3) {
        OnPlatformWindowBoundsChange(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(View r0, Function0 r1, DisposableEffectScope r2) {
        return OnPlatformWindowBoundsChange$lambda$3$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Function0 r0, int r1, Composer r2, int r3) {
        return OnPlatformWindowBoundsChange$lambda$4(r0, r1, r2, r3);
    }

    public static final /* synthetic */ IntRect access$getWindowBounds(View r0) {
        return getWindowBounds(r0);
    }

    private static final IntRect getWindowBounds(View r1) {
        Rect r0 = new Rect();
        r1.getWindowVisibleDisplayFrame(r0);
        return RectHelper_androidKt.toComposeIntRect(r0);
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1216067952, r4, -1, "androidx.compose.material.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:35)");
    L5:
        View r5 = (View) r3.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r0 = r3.changed(r5);
        Object r1 = r3.rememberedValue();
        if (r0 == false) goto L8;
    L9:
        r1 = new WindowBoundsCalculator(r5);
        r3.updateRememberedValue(r1);
    L10:
        WindowBoundsCalculator r2 = (WindowBoundsCalculator) r1;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r2;
    L8:
        if (r1 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> r7, Composer r8, final int r9) {
        Composer r10 = r8.startRestartGroup(1063434120);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L10:
        boolean r5 = true;
        if ((r1 & 3) == 2) goto L13;
        boolean r3 = true;
    L15:
        if (r10.shouldExecute(r3, r1 & 1) == true) goto L17;
        r10.skipToGroupEnd();
    L32:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L36;
        r11.updateScope(new z4(r7, r9));
        return;
    L36:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1063434120, r1, -1, "androidx.compose.material.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:41)");
    L19:
        final View r0 = (View) r10.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r4 = r10.changedInstance(r0);
        if ((r1 & 14) == 4) goto L23;
        r5 = false;
    L23:
        boolean r2 = r4 | r5;
        Object r6 = r10.rememberedValue();
        if (r2 == false) goto L26;
    L27:
        r6 = new y4(r0, r7);
        r10.updateRememberedValue(r6);
    L28:
        EffectsKt.DisposableEffect(r0, (Function1) r6, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
        goto L32
    L26:
        if (r6 != Composer.Companion.getEmpty()) goto L28;
    L13:
        r3 = false;
        goto L15
    L5:
        if (r10.changedInstance(r7) == false) goto L7;
        int r12 = 4;
    L8:
        r1 = r12 | r9;
        goto L10
    L7:
        r12 = 2;
        goto L8
    }

    private static final DisposableEffectResult OnPlatformWindowBoundsChange$lambda$3$lambda$2(View r0, Function0 r1, DisposableEffectScope r2) {
        final OnGlobalLayoutListener r3 = new OnGlobalLayoutListener(r0, r1);
        return new ExposedDropdownMenu_android$OnPlatformWindowBoundsChange$lambda$3$lambda$2$$inlined$onDispose$1(r3);
    }
}
