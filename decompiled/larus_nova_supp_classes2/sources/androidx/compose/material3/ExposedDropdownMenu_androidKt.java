package androidx.compose.material3;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0003¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material3/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "popupPropertiesForAnchorType", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "alwaysFocusable", "", "popupPropertiesForAnchorType-BTG8-q0", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "material3", "a11yServicesEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    private static final Unit OnPlatformWindowBoundsChange$lambda$1(Function0 r0, int r1, Composer r2, int r3) {
        OnPlatformWindowBoundsChange(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SoftKeyboardListener$lambda$6(View r0, Density r1, Function0 r2, int r3, Composer r4, int r5) {
        SoftKeyboardListener(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(View r0, Density r1, Function0 r2, int r3, Composer r4, int r5) {
        return SoftKeyboardListener$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(Function0 r0, int r1, Composer r2, int r3) {
        return OnPlatformWindowBoundsChange$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ DisposableEffectResult c(View r0, Function0 r1, DisposableEffectScope r2) {
        return SoftKeyboardListener$lambda$5$lambda$4(r0, r1, r2);
    }

    public static final /* synthetic */ IntRect access$getWindowBounds(View r0) {
        return getWindowBounds(r0);
    }

    private static final IntRect getWindowBounds(View r1) {
        Rect r0 = new Rect();
        r1.getWindowVisibleDisplayFrame(r0);
        return RectHelper_androidKt.toComposeIntRect(r0);
    }

    private static final boolean popupPropertiesForAnchorType_BTG8_q0$lambda$2(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(703324275, r4, -1, "androidx.compose.material3.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:40)");
    L5:
        Configuration r5 = (Configuration) r3.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        View r0 = (View) r3.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r6 = r3.changed(r5) | r3.changed(r0);
        Object r1 = r3.rememberedValue();
        if (r6 == false) goto L8;
    L9:
        r1 = new WindowBoundsCalculator(r0);
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

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> r4, Composer r5, final int r6) {
        Composer r7 = r5.startRestartGroup(-1646555525);
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
        r8.updateScope(new fb(r4, r6));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1646555525, r1, -1, "androidx.compose.material3.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:47)");
    L19:
        SoftKeyboardListener((View) r7.consume(AndroidCompositionLocals_androidKt.getLocalView()), (Density) r7.consume(CompositionLocalsKt.getLocalDensity()), r4, r7, (r1 << 6) & 896);
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

    private static final DisposableEffectResult SoftKeyboardListener$lambda$5$lambda$4(View r0, Function0 r1, DisposableEffectScope r2) {
        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 r3 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(r0, r1);
        return new ExposedDropdownMenu_androidKt$SoftKeyboardListener$lambda$5$lambda$4$$inlined$onDispose$1(r3);
    }

    /* JADX INFO: renamed from: popupPropertiesForAnchorType-BTG8-q0, reason: not valid java name */
    public static final PopupProperties m2699popupPropertiesForAnchorTypeBTG8q0(String r9, boolean r10, Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(895018515, r12, -1, "androidx.compose.material3.popupPropertiesForAnchorType (ExposedDropdownMenu.android.kt:57)");
    L5:
        State r13 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, r11, 0, 7);
        if (popupPropertiesForAnchorType_BTG8_q0$lambda$2(r13) == true) goto L8;
        int r14 = 393248;
    L9:
        ExposedDropdownMenuAnchorType.Companion r0 = ExposedDropdownMenuAnchorType.Companion;
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r9, r0.m2675getPrimaryEditableoYjWRB4()) == false) goto L12;
    L17:
        boolean r15 = true;
    L18:
        if (r15 == false) goto L21;
        if (r10 == true) goto L21;
        r14 = r14 | 8;
    L21:
        PopupProperties r16 = new PopupProperties(r14, false, false, false, false, false, 62, null);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r16;
    L12:
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r9, r0.m2677getSecondaryEditableoYjWRB4()) == true) goto L14;
    L16:
        r15 = false;
        goto L18
    L14:
        if (popupPropertiesForAnchorType_BTG8_q0$lambda$2(r13) == true) goto L16;
    L8:
        r14 = 393216;
        goto L9
    }

    private static final void SoftKeyboardListener(final View r7, final Density r8, final Function0<Unit> r9, Composer r10, final int r11) {
        Composer r12 = r10.startRestartGroup(-1319522472);
        if ((r11 & 6) == 0) goto L5;
        int r1 = r11;
    L11:
        if ((r11 & 48) != 0) goto L18;
        if (r12.changed(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r11 & 384) == 0) goto L20;
    L24:
        boolean r5 = false;
        if ((r1 & 147) == 146) goto L27;
        boolean r3 = true;
    L29:
        if (r12.shouldExecute(r3, r1 & 1) == true) goto L31;
        r12.skipToGroupEnd();
    L45:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L49;
        r13.updateScope(new hb(r7, r8, r9, r11));
        return;
    L49:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1319522472, r1, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:85)");
    L33:
        boolean r0 = r12.changedInstance(r7);
        if ((r1 & 896) != 256) goto L36;
        r5 = true;
    L36:
        boolean r4 = r0 | r5;
        Object r6 = r12.rememberedValue();
        if (r4 == false) goto L39;
    L40:
        r6 = new gb(r7, r9);
        r12.updateRememberedValue(r6);
    L41:
        EffectsKt.DisposableEffect(r7, r8, (Function1) r6, r12, (r1 & 14) | (r1 & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
        goto L45
    L39:
        if (r6 != Composer.Companion.getEmpty()) goto L41;
    L27:
        r3 = false;
        goto L29
    L20:
        if (r12.changedInstance(r9) == false) goto L22;
        int r14 = 256;
    L23:
        r1 = r1 | r14;
        goto L24
    L22:
        r14 = 128;
        goto L23
    L5:
        if (r12.changedInstance(r7) == false) goto L7;
        int r15 = 4;
    L8:
        r1 = r15 | r11;
        goto L11
    L7:
        r15 = 2;
        goto L8
    }
}
