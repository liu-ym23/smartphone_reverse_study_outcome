package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\b\u001a\u00020\u0003*\u00020\u0003H\u0080\u0002\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"rememberWideNavigationRailState", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailState;", "isExpanded", "", "(Landroidx/compose/material3/WideNavigationRailValue;)Z", "not", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailStateKt {
    public static /* synthetic */ WideNavigationRailState a(WideNavigationRailValue r0, FiniteAnimationSpec r1) {
        return rememberWideNavigationRailState$lambda$1$lambda$0(r0, r1);
    }

    public static final boolean isExpanded(WideNavigationRailValue r1) {
        if (r1 != WideNavigationRailValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    public static final WideNavigationRailValue not(WideNavigationRailValue r1) {
        WideNavigationRailValue r0 = WideNavigationRailValue.Collapsed;
        if (r1 == r0) goto L5;
        return r0;
    L5:
        return WideNavigationRailValue.Expanded;
    }

    private static final WideNavigationRailState rememberWideNavigationRailState$lambda$1$lambda$0(WideNavigationRailValue r1, FiniteAnimationSpec r2) {
        return new WideNavigationRailStateImpl(r1, r2);
    }

    public static final WideNavigationRailState rememberWideNavigationRailState(final WideNavigationRailValue r7, Composer r8, int r9, int r10) {
        boolean r0 = true;
        if ((r10 & 1) == 0) goto L6;
        r7 = WideNavigationRailValue.Collapsed;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1595273472, r9, -1, "androidx.compose.material3.rememberWideNavigationRailState (WideNavigationRailState.kt:86)");
    L8:
        final FiniteAnimationSpec r11 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r8, 6);
        Object[] r3 = new Object[0];
        Saver<WideNavigationRailState, WideNavigationRailValue> r4 = WideNavigationRailStateImpl.Companion.Saver(r11);
        if (((r9 & 14) ^ 6) <= 4) goto L13;
        if (r8.changed(r7.ordinal()) == false) goto L13;
    L16:
        boolean r12 = r8.changedInstance(r11) | r0;
        Object r1 = r8.rememberedValue();
        if (r12 == false) goto L19;
    L20:
        r1 = new sy(r7, r11);
        r8.updateRememberedValue(r1);
    L21:
        WideNavigationRailState r13 = (WideNavigationRailState) RememberSaveableKt.rememberSaveable(r3, r4, (Function0) r1, r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r13;
    L19:
        if (r1 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r9 & 6) == 4) goto L16;
        r0 = false;
        goto L16
    }
}
