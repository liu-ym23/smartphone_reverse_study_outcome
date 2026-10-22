package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Function2<Composer, Integer, Unit>> $currentContent$delegate;

    public ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> r1) {
        this.$currentContent$delegate = r1;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        SemanticsPropertiesKt.dialog(r0);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r9, int r10) {
        if ((r10 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r9.shouldExecute(r0, r10 & 1) == true) goto L9;
        r9.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1051373467, r10, -1, "androidx.compose.material3.ModalBottomSheetDialog.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:392)");
    L11:
        Modifier.Companion r11 = Modifier.Companion;
        Object r1 = r9.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L14;
        r1 = new ff();
        r9.updateRememberedValue(r1);
    L14:
        Modifier r12 = SemanticsModifierKt.semantics$default(r11, false, (Function1) r1, 1, null);
        State<Function2<Composer, Integer, Unit>> r2 = this.$currentContent$delegate;
        MeasurePolicy r3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r4 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap();
        Modifier r13 = ComposedModifierKt.materializeModifier(r9, r12);
        ComposeUiNode.Companion r6 = ComposeUiNode.Companion;
        Function0 r7 = r6.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L17;
        ComposablesKt.invalidApplier();
    L17:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L20;
        r9.createNode(r7);
    L21:
        Composer r8 = Updater.constructor-impl(r9);
        Updater.set-impl(r8, r3, r6.getSetMeasurePolicy());
        Updater.set-impl(r8, r5, r6.getSetResolvedCompositionLocals());
        Function2 r14 = r6.getSetCompositeKeyHash();
        if (r8.getInserting() == false) goto L24;
    L25:
        r8.updateRememberedValue(Integer.valueOf(r4));
        r8.apply(Integer.valueOf(r4), r14);
    L26:
        Updater.set-impl(r8, r13, r6.getSetModifier());
        BoxScopeInstance r15 = BoxScopeInstance.INSTANCE;
        ModalBottomSheet_androidKt.access$ModalBottomSheetDialog_sW7UJKQ$lambda$1(r2).invoke(r9, 0);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
        return;
    L31:
        return;
    L24:
        if (Intrinsics.areEqual(r8.rememberedValue(), Integer.valueOf(r4)) == true) goto L26;
    L20:
        r9.useNode();
        goto L21
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
