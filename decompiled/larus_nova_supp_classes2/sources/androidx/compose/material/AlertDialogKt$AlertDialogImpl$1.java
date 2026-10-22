package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class AlertDialogKt$AlertDialogImpl$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;

    public AlertDialogKt$AlertDialogImpl$1(Function2<? super Composer, ? super Integer, Unit> r1, Function2<? super Composer, ? super Integer, Unit> r2) {
        this.$dismissButton = r1;
        this.$confirmButton = r2;
    }

    public final void invoke(Composer r11, int r12) {
        if ((r12 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r11.shouldExecute(r0, r12 & 1) == true) goto L9;
        r11.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-309297447, r12, -1, "androidx.compose.material.AlertDialogImpl.<anonymous> (AlertDialog.kt:151)");
    L11:
        float r1 = 8;
        Modifier r13 = PaddingKt.m961paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), Dp.constructor-impl(r1), Dp.constructor-impl(2));
        final Function2<Composer, Integer, Unit> r3 = this.$dismissButton;
        final Function2<Composer, Integer, Unit> r4 = this.$confirmButton;
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r2 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r6 = r11.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r11, r13);
        ComposeUiNode.Companion r7 = ComposeUiNode.Companion;
        Function0 r8 = r7.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L17;
        r11.createNode(r8);
    L18:
        Composer r9 = Updater.constructor-impl(r11);
        Updater.set-impl(r9, r5, r7.getSetMeasurePolicy());
        Updater.set-impl(r9, r6, r7.getSetResolvedCompositionLocals());
        Function2 r10 = r7.getSetCompositeKeyHash();
        if (r9.getInserting() == false) goto L21;
    L22:
        r9.updateRememberedValue(Integer.valueOf(r2));
        r9.apply(Integer.valueOf(r2), r10);
    L23:
        Updater.set-impl(r9, r14, r7.getSetModifier());
        BoxScopeInstance r15 = BoxScopeInstance.INSTANCE;
        AlertDialogKt.m1913AlertDialogFlowRowixp7dh8(Dp.constructor-impl(r1), Dp.constructor-impl(12), ComposableLambdaKt.rememberComposableLambda(-1975681962, true, new AlertDialogKt$AlertDialogImpl$1$1$1(r3, r4), r11, 54), r11, 438);
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        return;
    L28:
        return;
    L21:
        if (Intrinsics.areEqual(r9.rememberedValue(), Integer.valueOf(r2)) == true) goto L23;
    L17:
        r11.useNode();
        goto L18
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
