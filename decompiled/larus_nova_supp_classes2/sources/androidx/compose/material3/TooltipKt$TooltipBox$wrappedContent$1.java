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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TooltipKt$TooltipBox$wrappedContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorBounds;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    public TooltipKt$TooltipBox$wrappedContent$1(MutableState<LayoutCoordinates> r1, Function2<? super Composer, ? super Integer, Unit> r2) {
        this.$anchorBounds = r1;
        this.$content = r2;
    }

    public static /* synthetic */ Unit a(MutableState r0, LayoutCoordinates r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(MutableState r0, LayoutCoordinates r1) {
        r0.setValue(r1);
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
        ComposerKt.traceEventStart(-23901870, r10, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:316)");
    L11:
        Modifier.Companion r11 = Modifier.Companion;
        final MutableState<LayoutCoordinates> r1 = this.$anchorBounds;
        Object r2 = r9.rememberedValue();
        if (r2 != Composer.Companion.getEmpty()) goto L14;
        r2 = new ex(r1);
        r9.updateRememberedValue(r2);
    L14:
        Modifier r12 = OnGloballyPositionedModifierKt.onGloballyPositioned(r11, (Function1) r2);
        Function2<Composer, Integer, Unit> r3 = this.$content;
        MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r5 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
        CompositionLocalMap r6 = r9.getCurrentCompositionLocalMap();
        Modifier r13 = ComposedModifierKt.materializeModifier(r9, r12);
        ComposeUiNode.Companion r7 = ComposeUiNode.Companion;
        Function0 r8 = r7.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L17;
        ComposablesKt.invalidApplier();
    L17:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L20;
        r9.createNode(r8);
    L21:
        Composer r14 = Updater.constructor-impl(r9);
        Updater.set-impl(r14, r4, r7.getSetMeasurePolicy());
        Updater.set-impl(r14, r6, r7.getSetResolvedCompositionLocals());
        Function2 r15 = r7.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L24;
    L25:
        r14.updateRememberedValue(Integer.valueOf(r5));
        r14.apply(Integer.valueOf(r5), r15);
    L26:
        Updater.set-impl(r14, r13, r7.getSetModifier());
        BoxScopeInstance r16 = BoxScopeInstance.INSTANCE;
        r3.invoke(r9, 0);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L31;
        ComposerKt.traceEventEnd();
        return;
    L31:
        return;
    L24:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r5)) == true) goto L26;
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
