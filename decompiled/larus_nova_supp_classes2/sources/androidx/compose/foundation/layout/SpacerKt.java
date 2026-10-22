package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SpacerKt {
    public static final void Spacer(Modifier r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-72882467, r7, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:37)");
    L5:
        SpacerMeasurePolicy r8 = SpacerMeasurePolicy.INSTANCE;
        long r0 = ComposablesKt.getCurrentCompositeKeyHashCode(r6, 0);
        int r1 = (int) (r0 ^ (r0 >>> 32));
        Modifier r9 = ComposedModifierKt.materializeModifier(r6, r5);
        CompositionLocalMap r2 = r6.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion r3 = ComposeUiNode.Companion;
        Function0 r4 = r3.getConstructor();
        if ((r6.getApplier() instanceof Applier) == true) goto L8;
        ComposablesKt.invalidApplier();
    L8:
        r6.startReusableNode();
        if (r6.getInserting() == false) goto L11;
        r6.createNode(r4);
    L12:
        Composer r10 = Updater.constructor-impl(r6);
        Updater.set-impl(r10, r8, r3.getSetMeasurePolicy());
        Updater.set-impl(r10, r2, r3.getSetResolvedCompositionLocals());
        Updater.set-impl(r10, r9, r3.getSetModifier());
        Function2 r11 = r3.getSetCompositeKeyHash();
        if (r10.getInserting() == false) goto L15;
    L16:
        r10.updateRememberedValue(Integer.valueOf(r1));
        r10.apply(Integer.valueOf(r1), r11);
    L17:
        r6.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
        return;
    L21:
        return;
    L15:
        if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r1)) == true) goto L17;
    L11:
        r6.useNode();
        goto L12
    }
}
