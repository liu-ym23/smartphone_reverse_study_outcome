package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\n\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u00052#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\r\u001a\u008f\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u00052\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001c\u001ay\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006!"}, d2 = {"rememberSwipeToDismissBoxState", "Landroidx/compose/material3/SwipeToDismissBoxState;", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "confirmValueChange", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "SwipeToDismissBox", "", "state", "backgroundContent", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "enableDismissFromEndToStart", "gesturesEnabled", "onDismiss", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = 0.0f;

    private static final Unit SwipeToDismissBox$lambda$13(SwipeToDismissBoxState r12, Function3 r13, Modifier r14, boolean r15, boolean r16, boolean r17, Function1 r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        SwipeToDismissBox(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit SwipeToDismissBox$lambda$16(SwipeToDismissBoxState r11, Function3 r12, Modifier r13, boolean r14, boolean r15, boolean r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        SwipeToDismissBox(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ SwipeToDismissBoxState a(SwipeToDismissBoxValue r0, Function1 r1) {
        return rememberSwipeToDismissBoxState$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ boolean b(SwipeToDismissBoxValue r0) {
        return rememberSwipeToDismissBoxState$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit c(SwipeToDismissBoxValue r0) {
        return SwipeToDismissBox$lambda$15$lambda$14(r0);
    }

    public static /* synthetic */ Unit d(SwipeToDismissBoxState r0, Function3 r1, Modifier r2, boolean r3, boolean r4, boolean r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return SwipeToDismissBox$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(SwipeToDismissBoxState r0, Function3 r1, Modifier r2, boolean r3, boolean r4, boolean r5, Function1 r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return SwipeToDismissBox$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit f(SwipeToDismissBoxValue r0) {
        return SwipeToDismissBox$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ Unit g(IntSize r0, boolean r1, boolean r2, DraggableAnchorsConfig r3) {
        return SwipeToDismissBox$lambda$11$lambda$10$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Pair h(SwipeToDismissBoxState r0, boolean r1, boolean r2, IntSize r3, Constraints r4) {
        return SwipeToDismissBox$lambda$11$lambda$10$lambda$9(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SwipeToDismissBoxState i(SwipeToDismissBoxValue r0, Density r1, Function1 r2, Function1 r3) {
        return rememberSwipeToDismissBoxState$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    private static final boolean rememberSwipeToDismissBoxState$lambda$3$lambda$2(SwipeToDismissBoxValue r0) {
        return true;
    }

    static {
        DismissVelocityThreshold = Dp.constructor-impl(125);
    }

    public static final /* synthetic */ float access$getDismissVelocityThreshold$p() {
        return DismissVelocityThreshold;
    }

    private static final Unit SwipeToDismissBox$lambda$15$lambda$14(SwipeToDismissBoxValue r0) {
        return Unit.INSTANCE;
    }

    private static final Unit SwipeToDismissBox$lambda$7$lambda$6(SwipeToDismissBoxValue r0) {
        return Unit.INSTANCE;
    }

    private static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$1$lambda$0(SwipeToDismissBoxValue r1, Function1 r2) {
        return new SwipeToDismissBoxState(r1, r2);
    }

    private static final Unit SwipeToDismissBox$lambda$11$lambda$10$lambda$9$lambda$8(IntSize r2, boolean r3, boolean r4, DraggableAnchorsConfig r5) {
        float r6 = (int) (r2.unbox-impl() >> 32);
        r5.at(SwipeToDismissBoxValue.Settled, MenuKt.ClosedAlphaTarget);
        if (r3 == false) goto L5;
        r5.at(SwipeToDismissBoxValue.StartToEnd, r6);
    L5:
        if (r4 == false) goto L8;
        r5.at(SwipeToDismissBoxValue.EndToStart, -r6);
    L8:
        return Unit.INSTANCE;
    }

    private static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$5$lambda$4(SwipeToDismissBoxValue r1, Density r2, Function1 r3, Function1 r4) {
        return new SwipeToDismissBoxState(r1, r2, r3, r4);
    }

    private static final Pair SwipeToDismissBox$lambda$11$lambda$10$lambda$9(SwipeToDismissBoxState r0, final boolean r1, final boolean r2, final IntSize r3, Constraints r4) {
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new pr(r3, r1, r2)), r0.getTargetValue());
    }

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue r6, final Function1<? super Float, Float> r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r6 = SwipeToDismissBoxValue.Settled;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r7 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(r8, 6);
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-470572556, r9, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:243)");
    L11:
        Object[] r1 = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> r2 = SwipeToDismissBoxState.Companion.Saver(r7);
        boolean r4 = true;
        if ((6 ^ (r9 & 14)) <= 4) goto L16;
        if (r8.changed(r6.ordinal()) == false) goto L16;
    L17:
        boolean r0 = true;
    L20:
        if (((r9 & 112) ^ 48) <= 32) goto L24;
        if (r8.changed(r7) == false) goto L24;
    L27:
        boolean r11 = r0 | r4;
        Object r3 = r8.rememberedValue();
        if (r11 == false) goto L30;
    L31:
        r3 = new mr(r6, r7);
        r8.updateRememberedValue(r3);
    L32:
        SwipeToDismissBoxState r12 = (SwipeToDismissBoxState) RememberSaveableKt.rememberSaveable(r1, r2, (Function0) r3, r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        return r12;
    L30:
        if (r3 != Composer.Companion.getEmpty()) goto L32;
    L24:
        if ((r9 & 48) == 32) goto L27;
        r4 = false;
    L16:
        if ((r9 & 6) == 4) goto L17;
        r0 = false;
        goto L20
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberSwipeToDismissBoxState(initialValue, positionalThreshold)", imports = {}))
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue r7, final Function1<? super SwipeToDismissBoxValue, Boolean> r8, final Function1<? super Float, Float> r9, Composer r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r7 = SwipeToDismissBoxValue.Settled;
    L6:
        if ((r12 & 2) == 0) goto L12;
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L10;
        r13 = new kr();
        r10.updateRememberedValue(r13);
    L10:
        r8 = (Function1) r13;
    L12:
        if ((r12 & 4) == 0) goto L15;
        r9 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(r10, 6);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-246335487, r11, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:273)");
    L17:
        final Density r14 = (Density) r10.consume(CompositionLocalsKt.getLocalDensity());
        Object[] r3 = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> r4 = SwipeToDismissBoxState.Companion.Saver(r8, r9, r14);
        boolean r5 = true;
        if ((6 ^ (r11 & 14)) <= 4) goto L22;
        if (r10.changed(r7.ordinal()) == false) goto L22;
    L23:
        boolean r0 = true;
    L25:
        boolean r1 = r0 | r10.changed(r14);
        if (((r11 & 112) ^ 48) <= 32) goto L30;
        if (r10.changed(r8) == false) goto L30;
    L31:
        boolean r2 = true;
    L33:
        boolean r6 = r1 | r2;
        if (((r11 & 896) ^ 384) <= 256) goto L38;
        if (r10.changed(r9) == false) goto L38;
    L41:
        boolean r15 = r6 | r5;
        Object r16 = r10.rememberedValue();
        if (r15 == false) goto L44;
    L45:
        r16 = new lr(r7, r14, r8, r9);
        r10.updateRememberedValue(r16);
    L46:
        SwipeToDismissBoxState r17 = (SwipeToDismissBoxState) RememberSaveableKt.rememberSaveable(r3, r4, (Function0) r16, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        return r17;
    L44:
        if (r16 != Composer.Companion.getEmpty()) goto L46;
    L38:
        if ((r11 & 384) == 256) goto L41;
        r5 = false;
    L30:
        if ((r11 & 48) == 32) goto L31;
        r2 = false;
    L22:
        if ((r11 & 6) == 4) goto L23;
        r0 = false;
        goto L25
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use updated signature with onDismissed parameter.")
    public static final /* synthetic */ void SwipeToDismissBox(final SwipeToDismissBoxState r20, final Function3 r21, Modifier r22, boolean r23, boolean r24, boolean r25, final Function3 r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-1807005299);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r29 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r22;
    L35:
        int r7 = r29 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r9 = r23;
    L46:
        int r10 = r29 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r11 = r24;
    L57:
        int r12 = r29 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r13 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L106;
        if (r5 == 0) goto L87;
        r6 = Modifier.Companion;
    L87:
        if (r7 == 0) goto L89;
        boolean r2 = true;
    L90:
        if (r10 == 0) goto L92;
        final boolean r8 = true;
    L93:
        if (r12 == 0) goto L95;
        boolean r14 = true;
    L97:
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventStart(-1807005299, r3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:381)");
    L99:
        Object r15 = r1.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L102;
        r15 = new nr();
        r1.updateRememberedValue(r15);
    L102:
        Modifier r16 = r6;
        boolean r17 = r2;
        boolean r18 = r8;
        boolean r19 = r14;
        SwipeToDismissBox(r20, r21, r16, r17, r18, r19, (Function1) r15, r26, r1, (((((((r3 & 14) | 1572864) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | ((r3 << 3) & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventEnd();
    L105:
        r9 = r2;
        final Modifier r4 = r6;
        final boolean r30 = r14;
    L107:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L111;
        final boolean r31 = r9;
        r110.updateScope(new or(r20, r21, r4, r31, r8, r30, r26, r28, r29));
        return;
    L111:
        return;
    L95:
        r14 = r13;
        goto L97
    L92:
        r8 = r11;
        goto L93
    L89:
        r2 = r9;
        goto L90
    L106:
        r1.skipToGroupEnd();
        r4 = r6;
        r8 = r11;
        r30 = r13;
        goto L107
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r28 & 1572864) != 0) goto L80;
        if (r1.changedInstance(r26) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r28) != 0) goto L67;
        r13 = r25;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r28 & 24576) != 0) goto L56;
        r11 = r24;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r9 = r23;
        if (r1.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L46
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r6 = r22;
        if (r1.changed(r6) == false) goto L32;
        int r32 = 256;
    L33:
        r3 = r3 | r32;
        goto L35
    L32:
        r32 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L24;
        if (r1.changedInstance(r21) == false) goto L21;
        int r33 = 32;
    L22:
        r3 = r3 | r33;
        goto L24
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L14
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r34 = 4;
    L11:
        r3 = r34 | r28;
        goto L14
    L10:
        r34 = 2;
        goto L11
    }

    public static final void SwipeToDismissBox(final SwipeToDismissBoxState r31, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r32, Modifier r33, boolean r34, boolean r35, boolean r36, Function1<? super SwipeToDismissBoxValue, Unit> r37, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40, final int r41) {
        Composer r3 = r39.startRestartGroup(-741495334);
        if ((r41 & 1) == 0) goto L6;
        int r4 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r5 = r41 & 4;
        if (r5 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r6 = r33;
    L34:
        int r7 = r41 & 8;
        if (r7 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        boolean r11 = r34;
    L45:
        int r12 = r41 & 16;
        if (r12 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        boolean r13 = r35;
    L56:
        int r16 = r41 & 32;
        if (r16 == 0) goto L60;
        r4 = r4 | 196608;
    L66:
        int r17 = r41 & 64;
        if (r17 == 0) goto L70;
        r4 = r4 | 1572864;
    L77:
        if ((r41 & 128) == 0) goto L80;
        r4 = r4 | 12582912;
    L87:
        if ((4793491 & r4) == 4793490) goto L89;
        boolean r0 = true;
    L91:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L186;
        if (r5 == 0) goto L94;
        r6 = Modifier.Companion;
    L94:
        if (r7 == 0) goto L96;
        final boolean r1 = true;
    L97:
        if (r12 == 0) goto L99;
        final boolean r8 = true;
    L100:
        if (r16 == 0) goto L102;
        boolean r9 = true;
    L103:
        if (r17 == 0) goto L108;
        Object r14 = r3.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L107;
        r14 = new hr();
        r3.updateRememberedValue(r14);
    L107:
        Function1<? super SwipeToDismissBoxValue, Unit> r15 = (Function1) r14;
    L110:
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(-741495334, r4, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
    L112:
        AnchoredDraggableState<SwipeToDismissBoxValue> r22 = r31.getAnchoredDraggableState$material3();
        Orientation r18 = Orientation.Horizontal;
        if (r9 == true) goto L115;
    L117:
        boolean r24 = false;
    L119:
        if (r31.getUseFlingBehavior$material3() == false) goto L121;
        r3.startReplaceGroup(387581105);
        boolean r10 = true;
        TargetedFlingBehavior r19 = AnchoredDraggableDefaults.INSTANCE.flingBehavior(r31.getAnchoredDraggableState$material3(), r31.getPositionalThreshold$material3(), null, r3, AnchoredDraggableDefaults.$stable << 9, 4);
        r3.endReplaceGroup();
        TargetedFlingBehavior r27 = r19;
    L122:
        Modifier r110 = AnchoredDraggableKt.anchoredDraggable$default(r6, r22, r18, r24, null, null, r27, 24, null);
        Alignment.Companion r111 = Alignment.Companion;
        MeasurePolicy r112 = BoxKt.maybeCachedBoxMeasurePolicy(r111.getTopStart(), r10);
        int r113 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r114 = r3.getCurrentCompositionLocalMap();
        Modifier r115 = ComposedModifierKt.materializeModifier(r3, r110);
        ComposeUiNode.Companion r116 = ComposeUiNode.Companion;
        Function0 r20 = r116.getConstructor();
        Modifier r310 = r6;
        if ((r3.getApplier() instanceof Applier) == true) goto L125;
        ComposablesKt.invalidApplier();
    L125:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L128;
        r3.createNode(r20);
    L129:
        Composer r21 = Updater.constructor-impl(r3);
        Updater.set-impl(r21, r112, r116.getSetMeasurePolicy());
        Updater.set-impl(r21, r114, r116.getSetResolvedCompositionLocals());
        Function2 r23 = r116.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L132;
    L133:
        r21.updateRememberedValue(Integer.valueOf(r113));
        r21.apply(Integer.valueOf(r113), r23);
    L134:
        Updater.set-impl(r21, r115, r116.getSetModifier());
        BoxScopeInstance r25 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r26 = Modifier.Companion;
        Modifier r28 = r25.matchParentSize(r26);
        int r117 = (r4 << 6) & 7168;
        Arrangement r118 = Arrangement.INSTANCE;
        int r119 = r117 >> 3;
        MeasurePolicy r29 = RowKt.rowMeasurePolicy(r118.getStart(), r111.getTop(), r3, (r119 & 14) | (r119 & 112));
        int r120 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r121 = r3.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r3, r28);
        Function0 r122 = r116.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L137;
        ComposablesKt.invalidApplier();
    L137:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L140;
        r3.createNode(r122);
    L141:
        Composer r42 = Updater.constructor-impl(r3);
        Updater.set-impl(r42, r29, r116.getSetMeasurePolicy());
        Updater.set-impl(r42, r121, r116.getSetResolvedCompositionLocals());
        Function2 r43 = r116.getSetCompositeKeyHash();
        if (r42.getInserting() == false) goto L144;
    L145:
        r42.updateRememberedValue(Integer.valueOf(r120));
        r42.apply(Integer.valueOf(r120), r43);
    L146:
        Updater.set-impl(r42, r30, r116.getSetModifier());
        RowScopeInstance r44 = RowScopeInstance.INSTANCE;
        r32.invoke(r44, r3, Integer.valueOf(((r117 >> 6) & 112) | 6));
        r3.endNode();
        AnchoredDraggableState<SwipeToDismissBoxValue> r45 = r31.getAnchoredDraggableState$material3();
        if ((r4 & 7168) != 2048) goto L149;
        boolean r123 = true;
    L151:
        if ((57344 & r4) != 16384) goto L153;
        boolean r46 = true;
    L154:
        boolean r47 = (r46 | r123) | r3.changedInstance(r31);
        Object r124 = r3.rememberedValue();
        if (r47 == false) goto L157;
    L158:
        r124 = new ir(r31, r1, r8);
        r3.updateRememberedValue(r124);
    L159:
        Modifier r48 = DraggableAnchorsKt.draggableAnchorsV2(r26, r45, r18, (Function2) r124);
        int r49 = (r4 >> 12) & 7168;
        Arrangement.Horizontal r50 = r118.getStart();
        Alignment.Vertical r125 = r111.getTop();
        int r126 = r49 >> 3;
        int r127 = r126 & 14;
        MeasurePolicy r51 = RowKt.rowMeasurePolicy(r50, r125, r3, (r126 & 112) | r127);
        int r128 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r129 = r3.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r3, r48);
        Function0 r130 = r116.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L162;
        ComposablesKt.invalidApplier();
    L162:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L165;
        r3.createNode(r130);
    L166:
        Composer r131 = Updater.constructor-impl(r3);
        Updater.set-impl(r131, r51, r116.getSetMeasurePolicy());
        Updater.set-impl(r131, r129, r116.getSetResolvedCompositionLocals());
        Function2 r53 = r116.getSetCompositeKeyHash();
        if (r131.getInserting() == false) goto L169;
    L170:
        r131.updateRememberedValue(Integer.valueOf(r128));
        r131.apply(Integer.valueOf(r128), r53);
    L171:
        Updater.set-impl(r131, r52, r116.getSetModifier());
        r38.invoke(r44, r3, Integer.valueOf(((r49 >> 6) & 112) | 6));
        r3.endNode();
        r3.endNode();
        SwipeToDismissBoxValue r54 = r31.getSettledValue();
        boolean r55 = r3.changedInstance(r31);
        if ((3670016 & r4) != 1048576) goto L174;
        boolean r132 = true;
    L175:
        boolean r56 = r55 | r132;
        Object r57 = r3.rememberedValue();
        if (r56 == false) goto L178;
    L181:
        Function1<? super SwipeToDismissBoxValue, Unit> r133 = r15;
        r57 = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(r31, r133, null);
        r3.updateRememberedValue(r57);
    L182:
        EffectsKt.LaunchedEffect(r54, r133, (Function2) r57, r3, (r4 >> 15) & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventEnd();
    L185:
        boolean r58 = r9;
        r6 = r310;
        final boolean r59 = r1;
    L187:
        ScopeUpdateScope r134 = r3.endRestartGroup();
        if (r134 == null) goto L191;
        final Modifier r60 = r6;
        final boolean r61 = r58;
        final Function1<? super SwipeToDismissBoxValue, Unit> r62 = r133;
        r134.updateScope(new jr(r31, r32, r60, r59, r8, r61, r62, r38, r40, r41));
        return;
    L191:
        return;
    L178:
        if (r57 == Composer.Companion.getEmpty()) goto L181;
        r133 = r15;
        goto L182
    L174:
        r132 = false;
        goto L175
    L169:
        if (Intrinsics.areEqual(r131.rememberedValue(), Integer.valueOf(r128)) == true) goto L171;
    L165:
        r3.useNode();
        goto L166
    L157:
        if (r124 != Composer.Companion.getEmpty()) goto L159;
    L153:
        r46 = false;
        goto L154
    L149:
        r123 = false;
        goto L151
    L144:
        if (Intrinsics.areEqual(r42.rememberedValue(), Integer.valueOf(r120)) == true) goto L146;
    L140:
        r3.useNode();
        goto L141
    L132:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r113)) == true) goto L134;
    L128:
        r3.useNode();
        goto L129
    L121:
        r10 = true;
        r3.startReplaceGroup(-869685853);
        r3.endReplaceGroup();
        r27 = null;
        goto L122
    L115:
        if (r31.getSettledValue() != SwipeToDismissBoxValue.Settled) goto L117;
        r24 = true;
        goto L119
    L108:
        r15 = r37;
        goto L110
    L102:
        r9 = r36;
        goto L103
    L99:
        r8 = r13;
        goto L100
    L96:
        r1 = r11;
        goto L97
    L186:
        r3.skipToGroupEnd();
        r58 = r36;
        r59 = r11;
        r8 = r13;
        r133 = r37;
        goto L187
    L89:
        r0 = false;
        goto L91
    L80:
        if ((r40 & 12582912) != 0) goto L87;
        if (r3.changedInstance(r38) == false) goto L84;
        int r135 = 8388608;
    L85:
        r4 = r4 | r135;
        goto L87
    L84:
        r135 = 4194304;
        goto L85
    L70:
        if ((r40 & 1572864) != 0) goto L77;
        if (r3.changedInstance(r37) == false) goto L74;
        int r136 = 1048576;
    L75:
        r4 = r4 | r136;
        goto L77
    L74:
        r136 = 524288;
        goto L75
    L60:
        if ((r40 & 196608) != 0) goto L66;
        if (r3.changed(r36) == false) goto L64;
        int r137 = 131072;
    L65:
        r4 = r4 | r137;
        goto L66
    L64:
        r137 = 65536;
        goto L65
    L49:
        if ((r40 & 24576) != 0) goto L55;
        r13 = r35;
        if (r3.changed(r13) == false) goto L53;
        int r138 = 16384;
    L54:
        r4 = r4 | r138;
        goto L56
    L53:
        r138 = 8192;
        goto L54
    L38:
        if ((r40 & 3072) != 0) goto L44;
        r11 = r34;
        if (r3.changed(r11) == false) goto L42;
        int r139 = 2048;
    L43:
        r4 = r4 | r139;
        goto L45
    L42:
        r139 = 1024;
        goto L43
    L27:
        if ((r40 & 384) != 0) goto L33;
        r6 = r33;
        if (r3.changed(r6) == false) goto L31;
        int r63 = 256;
    L32:
        r4 = r4 | r63;
        goto L34
    L31:
        r63 = 128;
        goto L32
    L17:
        if ((r40 & 48) != 0) goto L23;
        if (r3.changedInstance(r32) == false) goto L21;
        int r64 = 32;
    L22:
        r4 = r4 | r64;
        goto L23
    L21:
        r64 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r4 = r40;
        goto L14
    L8:
        if (r3.changedInstance(r31) == false) goto L10;
        int r65 = 4;
    L11:
        r4 = r65 | r40;
        goto L14
    L10:
        r65 = 2;
        goto L11
    }
}
