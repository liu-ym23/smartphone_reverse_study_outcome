package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    public FloatingActionButtonKt$ExtendedFloatingActionButton$3$1$1(Function2<? super Composer, ? super Integer, Unit> r1) {
        this.$text = r1;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope r9, Composer r10, int r11) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-660008666, r11, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:424)");
    L5:
        Modifier.Companion r12 = Modifier.Companion;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L8;
        r13 = new qb();
        r10.updateRememberedValue(r13);
    L8:
        Modifier r14 = SemanticsModifierKt.clearAndSetSemantics(r12, (Function1) r13);
        Function2<Composer, Integer, Unit> r0 = this.$text;
        MeasurePolicy r1 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), r10, 0);
        int r2 = ComposablesKt.getCurrentCompositeKeyHash(r10, 0);
        CompositionLocalMap r4 = r10.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r10, r14);
        ComposeUiNode.Companion r5 = ComposeUiNode.Companion;
        Function0 r6 = r5.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L11;
        ComposablesKt.invalidApplier();
    L11:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L14;
        r10.createNode(r6);
    L15:
        Composer r7 = Updater.constructor-impl(r10);
        Updater.set-impl(r7, r1, r5.getSetMeasurePolicy());
        Updater.set-impl(r7, r4, r5.getSetResolvedCompositionLocals());
        Function2 r3 = r5.getSetCompositeKeyHash();
        if (r7.getInserting() == false) goto L18;
    L19:
        r7.updateRememberedValue(Integer.valueOf(r2));
        r7.apply(Integer.valueOf(r2), r3);
    L20:
        Updater.set-impl(r7, r15, r5.getSetModifier());
        RowScopeInstance r16 = RowScopeInstance.INSTANCE;
        SpacerKt.Spacer(SizeKt.m1019width3ABfNKs(r12, FloatingActionButtonKt.access$getExtendedFabEndIconPadding$p()), r10, 6);
        r0.invoke(r10, 0);
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
        return;
    L24:
        return;
    L18:
        if (Intrinsics.areEqual(r7.rememberedValue(), Integer.valueOf(r2)) == true) goto L20;
    L14:
        r10.useNode();
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((AnimatedVisibilityScope) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
