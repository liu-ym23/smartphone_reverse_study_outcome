package androidx.compose.material3;

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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
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
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;

    public SurfaceKt$Surface$1(Modifier r1, Shape r2, long r3, float r5, BorderStroke r6, float r7, Function2<? super Composer, ? super Integer, Unit> r8) {
        this.$modifier = r1;
        this.$shape = r2;
        this.$color = r3;
        this.$absoluteElevation = r5;
        this.$border = r6;
        this.$shadowElevation = r7;
        this.$content = r8;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$2$lambda$1(r0);
    }

    private static final Unit invoke$lambda$2$lambda$1(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContainer(r1, true);
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
        ComposerKt.traceEventStart(421772006, r13, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:110)");
    L11:
        Modifier r5 = this.$modifier;
        Shape r6 = this.$shape;
        long r7 = SurfaceKt.m3218access$surfaceColorAtElevationCLU3JFs(this.$color, this.$absoluteElevation, r12, 0);
        BorderStroke r9 = this.$border;
        Object r14 = r12.consume(CompositionLocalsKt.getLocalDensity());
        Density r15 = (Density) r14;
        Modifier r16 = SurfaceKt.m3217access$surfaceXOJAsU(r5, r6, r7, r9, r15.toPx-0680j_4(this.$shadowElevation));
        Object r1 = r12.rememberedValue();
        Composer.Companion r2 = Composer.Companion;
        if (r1 != r2.getEmpty()) goto L14;
        r1 = new fr();
        r12.updateRememberedValue(r1);
    L14:
        Modifier r17 = SemanticsModifierKt.semantics(r16, false, (Function1) r1);
        Unit r3 = Unit.INSTANCE;
        Object r4 = r12.rememberedValue();
        if (r4 != r2.getEmpty()) goto L17;
        r4 = SurfaceKt$Surface$1$3$1.INSTANCE;
        r12.updateRememberedValue(r4);
    L17:
        Modifier r18 = SuspendingPointerInputFilterKt.pointerInput(r17, r3, (PointerInputEventHandler) r4);
        Function2<Composer, Integer, Unit> r8 = this.$content;
        MeasurePolicy r10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        int r11 = ComposablesKt.getCurrentCompositeKeyHash(r12, 0);
        CompositionLocalMap r19 = r12.getCurrentCompositionLocalMap();
        Modifier r110 = ComposedModifierKt.materializeModifier(r12, r18);
        ComposeUiNode.Companion r20 = ComposeUiNode.Companion;
        Function0 r21 = r20.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L20;
        ComposablesKt.invalidApplier();
    L20:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L23;
        r12.createNode(r21);
    L24:
        Composer r22 = Updater.constructor-impl(r12);
        Updater.set-impl(r22, r10, r20.getSetMeasurePolicy());
        Updater.set-impl(r22, r19, r20.getSetResolvedCompositionLocals());
        Function2 r23 = r20.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L27;
    L28:
        r22.updateRememberedValue(Integer.valueOf(r11));
        r22.apply(Integer.valueOf(r11), r23);
    L29:
        Updater.set-impl(r22, r110, r20.getSetModifier());
        BoxScopeInstance r111 = BoxScopeInstance.INSTANCE;
        r8.invoke(r12, 0);
        r12.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
        return;
    L34:
        return;
    L27:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r11)) == true) goto L29;
    L23:
        r12.useNode();
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
