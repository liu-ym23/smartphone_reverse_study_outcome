package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
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
public final class SurfaceKt$Surface$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ float $absoluteElevation;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $color;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;

    public SurfaceKt$Surface$1(Modifier r1, Shape r2, long r3, float r5, BorderStroke r6, float r7, Function2<? super Composer, ? super Integer, Unit> r8) {
        this.$modifier = r1;
        this.$shape = r2;
        this.$color = r3;
        this.$absoluteElevation = r5;
        this.$border = r6;
        this.$elevation = r7;
        this.$content = r8;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContainer(r1, true);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r14, int r15) {
        if ((r15 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r14.shouldExecute(r0, r15 & 1) == true) goto L9;
        r14.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-2004281689, r15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:107)");
    L11:
        Modifier r16 = SurfaceKt.m2179access$surface8ww4TTg(this.$modifier, this.$shape, SurfaceKt.m2180access$surfaceColorAtElevationcq6XJ1M(this.$color, (ElevationOverlay) r14.consume(ElevationOverlayKt.getLocalElevationOverlay()), this.$absoluteElevation, r14, 0), this.$border, this.$elevation);
        Object r1 = r14.rememberedValue();
        Composer.Companion r2 = Composer.Companion;
        if (r1 != r2.getEmpty()) goto L14;
        r1 = new ya();
        r14.updateRememberedValue(r1);
    L14:
        Modifier r17 = SemanticsModifierKt.semantics(r16, false, (Function1) r1);
        Unit r3 = Unit.INSTANCE;
        Object r4 = r14.rememberedValue();
        if (r4 != r2.getEmpty()) goto L17;
        r4 = SurfaceKt$Surface$1$2$1.INSTANCE;
        r14.updateRememberedValue(r4);
    L17:
        Modifier r18 = SuspendingPointerInputFilterKt.pointerInput(r17, r3, (PointerInputEventHandler) r4);
        Function2<Composer, Integer, Unit> r5 = this.$content;
        MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        int r7 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r8 = r14.getCurrentCompositionLocalMap();
        Modifier r19 = ComposedModifierKt.materializeModifier(r14, r18);
        ComposeUiNode.Companion r9 = ComposeUiNode.Companion;
        Function0 r10 = r9.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L20;
        ComposablesKt.invalidApplier();
    L20:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L23;
        r14.createNode(r10);
    L24:
        Composer r11 = Updater.constructor-impl(r14);
        Updater.set-impl(r11, r6, r9.getSetMeasurePolicy());
        Updater.set-impl(r11, r8, r9.getSetResolvedCompositionLocals());
        Function2 r12 = r9.getSetCompositeKeyHash();
        if (r11.getInserting() == false) goto L27;
    L28:
        r11.updateRememberedValue(Integer.valueOf(r7));
        r11.apply(Integer.valueOf(r7), r12);
    L29:
        Updater.set-impl(r11, r19, r9.getSetModifier());
        BoxScopeInstance r110 = BoxScopeInstance.INSTANCE;
        r5.invoke(r14, 0);
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
        return;
    L34:
        return;
    L27:
        if (Intrinsics.areEqual(r11.rememberedValue(), Integer.valueOf(r7)) == true) goto L29;
    L23:
        r14.useNode();
        goto L24
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
