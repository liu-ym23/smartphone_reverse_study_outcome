package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001ac\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u0002H\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001aY\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u0002H\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "animateValue", "Landroidx/compose/runtime/State;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InfiniteTransitionKt {
    public static /* synthetic */ Unit a(Object r0, InfiniteTransition.TransitionAnimationState r1, Object r2, InfiniteRepeatableSpec r3) {
        return animateValue$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ DisposableEffectResult b(InfiniteTransition r0, InfiniteTransition.TransitionAnimationState r1, DisposableEffectScope r2) {
        return animateValue$lambda$6$lambda$5(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "rememberInfiniteTransition APIs now have a new label parameter added.")
    public static final /* synthetic */ InfiniteTransition rememberInfiniteTransition(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-840193660, r4, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:303)");
    L5:
        InfiniteTransition r5 = rememberInfiniteTransition("InfiniteTransition", r3, 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    private static final DisposableEffectResult animateValue$lambda$6$lambda$5(final InfiniteTransition r0, final InfiniteTransition.TransitionAnimationState r1, DisposableEffectScope r2) {
        r0.addAnimation$animation_core(r1);
        return new InfiniteTransitionKt$animateValue$lambda$6$lambda$5$$inlined$onDispose$1(r0, r1);
    }

    private static final Unit animateValue$lambda$3$lambda$2(Object r1, InfiniteTransition.TransitionAnimationState r2, Object r3, InfiniteRepeatableSpec r4) {
        if (Intrinsics.areEqual(r1, r2.getInitialValue$animation_core()) == true) goto L5;
    L6:
        r2.updateValues$animation_core(r1, r3, r4);
    L8:
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r3, r2.getTargetValue$animation_core()) == true) goto L8;
        goto L6
    }

    public static final InfiniteTransition rememberInfiniteTransition(String r2, Composer r3, int r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "InfiniteTransition";
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1013651573, r4, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
    L8:
        Object r6 = r3.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L11;
        r6 = new InfiniteTransition(r2);
        r3.updateRememberedValue(r6);
    L11:
        InfiniteTransition r7 = (InfiniteTransition) r6;
        r7.run$animation_core(r3, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r7;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateFloat APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloat(InfiniteTransition r12, float r13, float r14, InfiniteRepeatableSpec r15, Composer r16, int r17) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(469472752, r17, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:336)");
    L5:
        State<Float> r0 = animateFloat(r12, r13, r14, r15, "FloatAnimation", r16, ((((r17 & 14) | 24576) | (r17 & 112)) | (r17 & 896)) | (r17 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateValue APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValue(InfiniteTransition r13, Object r14, Object r15, TwoWayConverter r16, InfiniteRepeatableSpec r17, Composer r18, int r19) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1695411770, r19, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:317)");
    L5:
        int r2 = (r19 >> 3) & 8;
        State r0 = animateValue(r13, r14, r15, r16, r17, "ValueAnimation", r18, (((((((r19 & 14) | 196608) | (r2 << 3)) | (r19 & 112)) | (r2 << 6)) | (r19 & 896)) | (r19 & 7168)) | (r19 & 57344), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r0;
    }

    public static final State<Float> animateFloat(InfiniteTransition r11, float r12, float r13, InfiniteRepeatableSpec<Float> r14, String r15, Composer r16, int r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        String r7 = "FloatAnimation";
    L7:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-644770905, r17, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:296)");
    L9:
        int r0 = r17 << 3;
        State<Float> r1 = animateValue(r11, Float.valueOf(r12), Float.valueOf(r13), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), r14, r7, r16, ((((r17 & 14) | (r17 & 112)) | (r17 & 896)) | (57344 & r0)) | (r0 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r1;
    L5:
        r7 = r15;
        goto L7
    }

    public static final <T, V extends AnimationVector> State<T> animateValue(final InfiniteTransition r7, final T r8, final T r9, TwoWayConverter<T, V> r10, final InfiniteRepeatableSpec<T> r11, String r12, Composer r13, int r14, int r15) {
        if ((r15 & 16) == 0) goto L5;
        r12 = "ValueAnimation";
    L5:
        String r6 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1062847727, r14, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:245)");
    L8:
        Object r16 = r13.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r16 != r17.getEmpty()) goto L11;
        r16 = new InfiniteTransition.TransitionAnimationState(r7, r8, r9, r10, r11, r6);
        r13.updateRememberedValue(r16);
    L11:
        final InfiniteTransition.TransitionAnimationState r18 = (InfiniteTransition.TransitionAnimationState) r16;
        boolean r1 = true;
        if (((r14 & 112) ^ 48) <= 32) goto L16;
        if (r13.changedInstance(r8) == false) goto L16;
    L17:
        boolean r19 = true;
    L20:
        if (((r14 & 896) ^ 384) <= 256) goto L24;
        if (r13.changedInstance(r9) == false) goto L24;
    L25:
        boolean r0 = true;
    L27:
        boolean r110 = r19 | r0;
        if (((57344 & r14) ^ 24576) <= 16384) goto L32;
        if (r13.changedInstance(r11) == false) goto L32;
    L35:
        boolean r111 = r110 | r1;
        Object r112 = r13.rememberedValue();
        if (r111 == false) goto L38;
    L39:
        r112 = new o(r8, r18, r9, r11);
        r13.updateRememberedValue(r112);
    L40:
        EffectsKt.SideEffect((Function0) r112, r13, 0);
        boolean r20 = r13.changedInstance(r7);
        Object r21 = r13.rememberedValue();
        if (r20 == false) goto L43;
    L44:
        r21 = new p(r7, r18);
        r13.updateRememberedValue(r21);
    L45:
        EffectsKt.DisposableEffect(r18, (Function1) r21, r13, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
    L48:
        return r18;
    L43:
        if (r21 != r17.getEmpty()) goto L45;
    L38:
        if (r112 != r17.getEmpty()) goto L40;
    L32:
        if ((r14 & 24576) == 16384) goto L35;
        r1 = false;
    L24:
        if ((r14 & 384) == 256) goto L25;
        r0 = false;
    L16:
        if ((r14 & 48) == 32) goto L17;
        r19 = false;
        goto L20
    }
}
