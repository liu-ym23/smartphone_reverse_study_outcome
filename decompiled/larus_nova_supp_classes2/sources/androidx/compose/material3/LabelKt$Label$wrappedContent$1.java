package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class LabelKt$Label$wrappedContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef<MutableState<LayoutCoordinates>> $anchorBounds;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    public LabelKt$Label$wrappedContent$1(Ref.ObjectRef<MutableState<LayoutCoordinates>> r1, Function2<? super Composer, ? super Integer, Unit> r2) {
        this.$anchorBounds = r1;
        this.$content = r2;
    }

    public static /* synthetic */ Unit a(Ref.ObjectRef r0, LayoutCoordinates r1) {
        return invoke$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$0(Ref.ObjectRef r0, LayoutCoordinates r1) {
        ((MutableState) r0.element).setValue(r1);
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
        ComposerKt.traceEventStart(-44123786, r10, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:83)");
    L11:
        Modifier.Companion r11 = Modifier.Companion;
        final Ref.ObjectRef<MutableState<LayoutCoordinates>> r1 = this.$anchorBounds;
        Modifier r12 = OnGloballyPositionedModifierKt.onGloballyPositioned(r11, new id(r1));
        Function2<Composer, Integer, Unit> r2 = this.$content;
        MeasurePolicy r3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r4 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r5 = r9.getCurrentCompositionLocalMap();
        Modifier r13 = ComposedModifierKt.materializeModifier(r9, r12);
        ComposeUiNode.Companion r6 = ComposeUiNode.Companion;
        Function0 r7 = r6.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L17;
        r9.createNode(r7);
    L18:
        Composer r8 = Updater.constructor-impl(r9);
        Updater.set-impl(r8, r3, r6.getSetMeasurePolicy());
        Updater.set-impl(r8, r5, r6.getSetResolvedCompositionLocals());
        Function2 r14 = r6.getSetCompositeKeyHash();
        if (r8.getInserting() == false) goto L21;
    L22:
        r8.updateRememberedValue(Integer.valueOf(r4));
        r8.apply(Integer.valueOf(r4), r14);
    L23:
        Updater.set-impl(r8, r13, r6.getSetModifier());
        BoxScopeInstance r15 = BoxScopeInstance.INSTANCE;
        r2.invoke(r9, 0);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        return;
    L28:
        return;
    L21:
        if (Intrinsics.areEqual(r8.rememberedValue(), Integer.valueOf(r4)) == true) goto L23;
    L17:
        r9.useNode();
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
