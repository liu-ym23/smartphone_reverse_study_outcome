package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheet$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, WindowInsets> $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ ModalBottomSheetProperties $properties;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX WARN: Multi-variable type inference failed */
    public ModalBottomSheetKt$ModalBottomSheet$4(long r4, Function0<Unit> r6, SheetState r7, ModalBottomSheetProperties r8, Animatable<Float, AnimationVector1D> r9, CoroutineScope r10, Function1<? super Float, Unit> r11, Modifier r12, float r13, boolean r14, Shape r15, long r16, long r18, float r20, Function2<? super Composer, ? super Integer, Unit> r21, Function2<? super Composer, ? super Integer, ? extends WindowInsets> r22, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r23) {
        this.$scrimColor = r4;
        this.$animateToDismiss = r6;
        this.$sheetState = r7;
        this.$properties = r8;
        this.$predictiveBackProgress = r9;
        this.$scope = r10;
        this.$settleToDismiss = r11;
        this.$modifier = r12;
        this.$sheetMaxWidth = r13;
        this.$sheetGesturesEnabled = r14;
        this.$shape = r15;
        this.$containerColor = r16;
        this.$contentColor = r18;
        this.$tonalElevation = r20;
        this.$dragHandle = r21;
        this.$contentWindowInsets = r22;
        this.$content = r23;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return invoke$lambda$1$lambda$0(r0);
    }

    private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setTraversalGroup(r1, true);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r30, int r31) {
        if ((r31 & 3) == 2) goto L5;
        boolean r2 = true;
    L7:
        if (r30.shouldExecute(r2, r31 & 1) == true) goto L9;
        r30.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1010026864, r31, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:185)");
    L11:
        Modifier r1 = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null));
        Object r3 = r30.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L14;
        r3 = new se();
        r30.updateRememberedValue(r3);
    L14:
        Modifier r4 = SemanticsModifierKt.semantics$default(r1, false, (Function1) r3, 1, null);
        long r5 = this.$scrimColor;
        Function0<Unit> r8 = this.$animateToDismiss;
        SheetState r9 = this.$sheetState;
        ModalBottomSheetProperties r6 = this.$properties;
        Animatable<Float, AnimationVector1D> r10 = this.$predictiveBackProgress;
        CoroutineScope r11 = this.$scope;
        Function1<Float, Unit> r12 = this.$settleToDismiss;
        Modifier r13 = this.$modifier;
        float r14 = this.$sheetMaxWidth;
        boolean r7 = this.$sheetGesturesEnabled;
        Shape r15 = this.$shape;
        long r16 = this.$containerColor;
        long r17 = this.$contentColor;
        float r18 = this.$tonalElevation;
        Function2<Composer, Integer, Unit> r19 = this.$dragHandle;
        Function2<Composer, Integer, WindowInsets> r20 = this.$contentWindowInsets;
        Function3<ColumnScope, Composer, Integer, Unit> r21 = this.$content;
        MeasurePolicy r22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r24 = ComposablesKt.getCurrentCompositeKeyHash(r30, 0);
        CompositionLocalMap r23 = r30.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r30, r4);
        ComposeUiNode.Companion r27 = ComposeUiNode.Companion;
        Function0 r0 = r27.getConstructor();
        if ((r30.getApplier() instanceof Applier) == true) goto L17;
        ComposablesKt.invalidApplier();
    L17:
        r30.startReusableNode();
        if (r30.getInserting() == false) goto L20;
        r30.createNode(r0);
    L21:
        Composer r26 = Updater.constructor-impl(r30);
        Updater.set-impl(r26, r22, r27.getSetMeasurePolicy());
        Updater.set-impl(r26, r23, r27.getSetResolvedCompositionLocals());
        Function2 r28 = r27.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L24;
    L25:
        r26.updateRememberedValue(Integer.valueOf(r24));
        r26.apply(Integer.valueOf(r24), r28);
    L26:
        Updater.set-impl(r26, r25, r27.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        if (r9.getTargetValue() == SheetValue.Hidden) goto L29;
        boolean r32 = true;
    L30:
        ModalBottomSheetKt.m2873access$ScrimKTwxG1Y(r5, r8, r32, r6.shouldDismissOnClickOutside(), r30, 0);
        ModalBottomSheetKt.m2871ModalBottomSheetContent7e2Q(r29, r10, r11, r8, r12, r13, r9, r14, r7, r15, r16, r17, r18, r19, r20, r21, r30, 6 | (Animatable.$stable << 3), 0, 0);
        r30.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
        return;
    L35:
        return;
    L29:
        r32 = false;
        goto L30
    L24:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r24)) == true) goto L26;
    L20:
        r30.useNode();
        goto L21
    L5:
        r2 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
