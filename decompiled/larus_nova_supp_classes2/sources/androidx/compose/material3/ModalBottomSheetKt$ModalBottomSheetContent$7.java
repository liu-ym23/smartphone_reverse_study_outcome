package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
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
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheetContent$7 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, WindowInsets> $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ SheetState $sheetState;

    /* JADX WARN: Multi-variable type inference failed */
    public ModalBottomSheetKt$ModalBottomSheetContent$7(Function2<? super Composer, ? super Integer, ? extends WindowInsets> r1, Animatable<Float, AnimationVector1D> r2, SheetState r3, Function2<? super Composer, ? super Integer, Unit> r4, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r5, Function0<Unit> r6, CoroutineScope r7, boolean r8) {
        this.$contentWindowInsets = r1;
        this.$predictiveBackProgress = r2;
        this.$sheetState = r3;
        this.$dragHandle = r4;
        this.$content = r5;
        this.$animateToDismiss = r6;
        this.$scope = r7;
        this.$sheetGesturesEnabled = r8;
    }

    public static /* synthetic */ Unit a(Animatable r0, GraphicsLayerScope r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(Animatable r2, GraphicsLayerScope r3) {
        float r4 = ((Number) r2.getValue()).floatValue();
        float r0 = ModalBottomSheetKt.access$calculatePredictiveBackScaleX(r3, r4);
        float r5 = ModalBottomSheetKt.access$calculatePredictiveBackScaleY(r3, r4);
        if (r5 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        float r6 = r0 / r5;
    L9:
        r3.setScaleY(r6);
        r3.setTransformOrigin-__ExYCQ(ModalBottomSheetKt.access$getPredictiveBackChildTransformOrigin$p());
        return Unit.INSTANCE;
    L8:
        r6 = 1.0f;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public final void invoke(Composer r17, int r18) {
        if ((r18 & 3) == 2) goto L5;
        boolean r3 = true;
    L7:
        if (r17.shouldExecute(r3, r18 & 1) == true) goto L9;
        r17.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(728743275, r18, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:359)");
    L11:
        Modifier r2 = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null), (WindowInsets) this.$contentWindowInsets.invoke(r17, 0));
        boolean r4 = r17.changedInstance(this.$predictiveBackProgress);
        final Animatable<Float, AnimationVector1D> r5 = this.$predictiveBackProgress;
        Object r7 = r17.rememberedValue();
        if (r4 == false) goto L14;
    L15:
        r7 = new te(r5);
        r17.updateRememberedValue(r7);
    L16:
        Modifier r6 = BottomSheetScaffoldKt.verticalScaleDown(GraphicsLayerModifierKt.graphicsLayer(r2, (Function1) r7), this.$sheetState);
        Function2<Composer, Integer, Unit> r15 = this.$dragHandle;
        Function3<ColumnScope, Composer, Integer, Unit> r8 = this.$content;
        SheetState r9 = this.$sheetState;
        Function0<Unit> r10 = this.$animateToDismiss;
        CoroutineScope r11 = this.$scope;
        boolean r12 = this.$sheetGesturesEnabled;
        MeasurePolicy r13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r17, 0);
        int r14 = ComposablesKt.getCurrentCompositeKeyHash(r17, 0);
        CompositionLocalMap r16 = r17.getCurrentCompositionLocalMap();
        Modifier r19 = ComposedModifierKt.materializeModifier(r17, r6);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r17.getApplier() instanceof Applier) == true) goto L19;
        ComposablesKt.invalidApplier();
    L19:
        r17.startReusableNode();
        if (r17.getInserting() == false) goto L22;
        r17.createNode(r111);
    L23:
        Composer r20 = Updater.constructor-impl(r17);
        Updater.set-impl(r20, r13, r110.getSetMeasurePolicy());
        Updater.set-impl(r20, r16, r110.getSetResolvedCompositionLocals());
        Function2 r21 = r110.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L26;
    L27:
        r20.updateRememberedValue(Integer.valueOf(r14));
        r20.apply(Integer.valueOf(r14), r21);
    L28:
        Updater.set-impl(r20, r19, r110.getSetModifier());
        ColumnScopeInstance r22 = ColumnScopeInstance.INSTANCE;
        if (r15 == null) goto L31;
        r17.startReplaceGroup(1352934765);
        String r112 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911713), r17, 0);
        SheetDefaultsKt.DragHandleWithTooltip(r22, ComposableLambdaKt.rememberComposableLambda(2000500644, true, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1(r9, r10, r11, r12, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911714), r17, 0), Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911716), r17, 0), r112, r15), r17, 54), r17, 54);
        r17.endReplaceGroup();
    L32:
        r8.invoke(r22, r17, 6);
        r17.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        return;
    L37:
        return;
    L31:
        r17.startReplaceGroup(1356009965);
        r17.endReplaceGroup();
        goto L32
    L26:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r14)) == true) goto L28;
    L22:
        r17.useNode();
        goto L23
    L14:
        if (r7 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
