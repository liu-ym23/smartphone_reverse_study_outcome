package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0082\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042*\b\n\u0010\u0005\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2&\u0010\r\u001a\"\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\tH\u0087\b¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "label", "", "targetValueByState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransitionKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateColor-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ State m236animateColorRIQooxk(InfiniteTransition r14, long r15, long r17, InfiniteRepeatableSpec r19, Composer r20, int r21) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1400583834, r21, -1, "androidx.compose.animation.animateColor (Transition.kt:112)");
    L5:
        State<Color> r0 = m235animateColorDTcfvLk(r14, r15, r17, r19, "ColorAnimation", r20, (((((InfiniteTransition.$stable | 24576) | (r21 & 14)) | (r21 & 112)) | (r21 & 896)) | (InfiniteRepeatableSpec.$stable << 9)) | (r21 & 7168), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r0;
    }

    public static final <S> State<Color> animateColor(final Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Color> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> r2 = AnonymousClass1.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "ColorAnimation";
    L10:
        ColorSpace r3 = Color.getColorSpace-impl(((Color) r19.invoke(r16.getTargetState(), r20, Integer.valueOf((r21 >> 6) & 112))).unbox-impl());
        boolean r4 = r20.changed(r3);
        Object r5 = r20.rememberedValue();
        if (r4 == false) goto L13;
    L14:
        r5 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r3);
        r20.updateRememberedValue(r5);
    L15:
        TwoWayConverter r7 = (TwoWayConverter) r5;
        int r8 = r21 << 3;
        int r9 = (((r21 & 14) | (r8 & 896)) | (r8 & 7168)) | (r8 & 57344);
        if (r16.isSeeking() == true) goto L40;
        r20.startReplaceGroup(1666599280);
        if (((r9 & 14) ^ 6) <= 4) goto L22;
        if (r20.changed(r16) == false) goto L22;
    L23:
        boolean r10 = true;
    L25:
        Object r12 = r20.rememberedValue();
        if (r10 == false) goto L28;
    L29:
        Snapshot.Companion r11 = Snapshot.Companion;
        Snapshot r13 = r11.getCurrentThreadSnapshot();
        if (r13 == null) goto L32;
        Function1 r14 = r13.getReadObserver();
    L33:
        Snapshot r15 = r11.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L37
        InlineMarker.finallyStart(1);
        r11.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L36:
        r20.endReplaceGroup();
    L41:
        int r23 = (r9 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r23));
        int r112 = r9 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L46;
        if (r20.changed(r16) == false) goto L46;
    L47:
        boolean r114 = true;
    L49:
        Object r24 = r20.rememberedValue();
        if (r114 == false) goto L52;
    L53:
        r24 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateColor$$inlined$animateValue$1(r16));
        r20.updateRememberedValue(r24);
    L54:
        Object r25 = r19.invoke(((State) r24).getValue(), r20, Integer.valueOf(r23));
        if (r113 <= 4) goto L59;
        if (r20.changed(r16) == false) goto L59;
    L60:
        boolean r26 = true;
    L62:
        Object r1 = r20.rememberedValue();
        if (r26 == false) goto L65;
    L66:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateColor$$inlined$animateValue$2(r16));
        r20.updateRememberedValue(r1);
    L68:
        return androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r16, r111, r25, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r9 >> 3) & 112)), r7, r6, r20, (((r9 << 9) & 57344) | r112) | (458752 & (r9 << 6)));
    L65:
        if (r1 != Composer.Companion.getEmpty()) goto L68;
    L59:
        if ((r9 & 6) == 4) goto L60;
        r26 = false;
        goto L62
    L52:
        if (r24 != Composer.Companion.getEmpty()) goto L54;
    L46:
        if ((r9 & 6) == 4) goto L47;
        r114 = false;
    L37:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r11.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L32:
        r14 = null;
        goto L33
    L28:
        if (r12 != Composer.Companion.getEmpty()) goto L36;
    L22:
        if ((r9 & 6) == 4) goto L23;
        r10 = false;
        goto L25
    L40:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L41
    L13:
        if (r5 != Composer.Companion.getEmpty()) goto L15;
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    /* JADX INFO: renamed from: animateColor-DTcfvLk, reason: not valid java name */
    public static final State<Color> m235animateColorDTcfvLk(InfiniteTransition r11, long r12, long r14, InfiniteRepeatableSpec<Color> r16, String r17, Composer r18, int r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        String r7 = "ColorAnimation";
    L7:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(1901963533, r19, -1, "androidx.compose.animation.animateColor (Transition.kt:97)");
    L9:
        Object r1 = r18.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L13;
        r1 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(r14));
        r18.updateRememberedValue(r1);
    L13:
        Color r3 = Color.box-impl(r12);
        Color r4 = Color.box-impl(r14);
        int r0 = r19 << 3;
        State<Color> r2 = InfiniteTransitionKt.animateValue(r11, r3, r4, (TwoWayConverter) r1, r16, r7, r18, (((((InfiniteTransition.$stable | (r19 & 14)) | (r19 & 112)) | (r19 & 896)) | (InfiniteRepeatableSpec.$stable << 12)) | (57344 & r0)) | (r0 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r2;
    L5:
        r7 = r17;
        goto L7
    }
}
