package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultBasicAlertDialogOverride;", "Landroidx/compose/material3/BasicAlertDialogOverride;", "<init>", "()V", "BasicAlertDialog", "", "Landroidx/compose/material3/BasicAlertDialogOverrideScope;", "(Landroidx/compose/material3/BasicAlertDialogOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultBasicAlertDialogOverride implements BasicAlertDialogOverride {
    public static final int $stable = 0;
    public static final DefaultBasicAlertDialogOverride INSTANCE = null;

    /* JADX INFO: renamed from: androidx.compose.material3.DefaultBasicAlertDialogOverride$BasicAlertDialog$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ BasicAlertDialogOverrideScope $this_BasicAlertDialog;

        public AnonymousClass1(BasicAlertDialogOverrideScope r1) {
            this.$this_BasicAlertDialog = r1;
        }

        public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(String r0, SemanticsPropertyReceiver r1) {
            SemanticsPropertiesKt.setPaneTitle(r1, r0);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r12, int r13) {
            if ((r13 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r12.shouldExecute(r0, r13 & 1) == true) goto L9;
            r12.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1163527043, r13, -1, "androidx.compose.material3.DefaultBasicAlertDialogOverride.BasicAlertDialog.<anonymous> (AlertDialog.kt:165)");
        L11:
            final String r14 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911749), r12, 0);
            Modifier r1 = SizeKt.m1018sizeInqDBjuR0$default(this.$this_BasicAlertDialog.getModifier(), AlertDialogKt.getDialogMinWidth(), MenuKt.ClosedAlphaTarget, AlertDialogKt.getDialogMaxWidth(), MenuKt.ClosedAlphaTarget, 10, null);
            Modifier.Companion r2 = Modifier.Companion;
            boolean r4 = r12.changed(r14);
            Object r5 = r12.rememberedValue();
            if (r4 == false) goto L14;
        L15:
            r5 = new c8(r14);
            r12.updateRememberedValue(r5);
        L16:
            Modifier r15 = r1.then(SemanticsModifierKt.semantics$default(r2, false, (Function1) r5, 1, null));
            BasicAlertDialogOverrideScope r3 = this.$this_BasicAlertDialog;
            MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            int r7 = ComposablesKt.getCurrentCompositeKeyHash(r12, 0);
            CompositionLocalMap r8 = r12.getCurrentCompositionLocalMap();
            Modifier r16 = ComposedModifierKt.materializeModifier(r12, r15);
            ComposeUiNode.Companion r9 = ComposeUiNode.Companion;
            Function0 r10 = r9.getConstructor();
            if ((r12.getApplier() instanceof Applier) == true) goto L19;
            ComposablesKt.invalidApplier();
        L19:
            r12.startReusableNode();
            if (r12.getInserting() == false) goto L22;
            r12.createNode(r10);
        L23:
            Composer r11 = Updater.constructor-impl(r12);
            Updater.set-impl(r11, r6, r9.getSetMeasurePolicy());
            Updater.set-impl(r11, r8, r9.getSetResolvedCompositionLocals());
            Function2 r17 = r9.getSetCompositeKeyHash();
            if (r11.getInserting() == false) goto L26;
        L27:
            r11.updateRememberedValue(Integer.valueOf(r7));
            r11.apply(Integer.valueOf(r7), r17);
        L28:
            Updater.set-impl(r11, r16, r9.getSetModifier());
            BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
            r3.getContent().invoke(r12, 0);
            r12.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L33;
            ComposerKt.traceEventEnd();
            return;
        L33:
            return;
        L26:
            if (Intrinsics.areEqual(r11.rememberedValue(), Integer.valueOf(r7)) == true) goto L28;
        L22:
            r12.useNode();
            goto L23
        L14:
            if (r5 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r0 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        INSTANCE = new DefaultBasicAlertDialogOverride();
    }

    private DefaultBasicAlertDialogOverride() {
    }

    private static final Unit BasicAlertDialog$lambda$0(DefaultBasicAlertDialogOverride r0, BasicAlertDialogOverrideScope r1, int r2, Composer r3, int r4) {
        r0.BasicAlertDialog(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DefaultBasicAlertDialogOverride r0, BasicAlertDialogOverrideScope r1, int r2, Composer r3, int r4) {
        return BasicAlertDialog$lambda$0(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.material3.BasicAlertDialogOverride
    public void BasicAlertDialog(final BasicAlertDialogOverrideScope r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(1565826668);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r11.shouldExecute(r2, r1 & 1) == true) goto L17;
        r11.skipToGroupEnd();
    L23:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L27;
        r12.updateScope(new b8(this, r8, r10));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1565826668, r1, -1, "androidx.compose.material3.DefaultBasicAlertDialogOverride.BasicAlertDialog (AlertDialog.kt:163)");
    L19:
        AndroidDialog_androidKt.Dialog(r8.getOnDismissRequest(), r8.getProperties(), ComposableLambdaKt.rememberComposableLambda(1163527043, true, new AnonymousClass1(r8), r11, 54), r11, 384, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r11.changed(r8) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r10;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }
}
