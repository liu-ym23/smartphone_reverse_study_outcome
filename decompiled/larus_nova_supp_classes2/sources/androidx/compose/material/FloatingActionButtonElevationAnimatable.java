package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001a\u00020\u0003*\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "updateElevation", "", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateElevation", "to", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FloatingActionButtonElevationAnimatable {
    private final Animatable<Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$animateElevation$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", f = "FloatingActionButton.kt", i = {0}, l = {384}, m = "animateElevation", n = {"to"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FloatingActionButtonElevationAnimatable this$0;

        public AnonymousClass1(FloatingActionButtonElevationAnimatable r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.animateElevation(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.FloatingActionButtonElevationAnimatable$snapElevation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.FloatingActionButtonElevationAnimatable", f = "FloatingActionButton.kt", i = {}, l = {370}, m = "snapElevation", n = {}, s = {})
    public static final class C02421 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FloatingActionButtonElevationAnimatable this$0;

        public C02421(FloatingActionButtonElevationAnimatable r1, Continuation<? super C02421> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return FloatingActionButtonElevationAnimatable.access$snapElevation(this.this$0, this);
        }
    }

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float r1, float r2, float r3, float r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public final State<Dp> asState() {
        return this.animatable.asState();
    }

    /* JADX INFO: renamed from: calculateTarget-u2uoSUM, reason: not valid java name */
    private final float m2076calculateTargetu2uoSUM(Interaction r2) {
        if ((r2 instanceof PressInteraction.Press) == false) goto L6;
        return this.pressedElevation;
    L6:
        if ((r2 instanceof HoverInteraction.Enter) == false) goto L9;
        return this.hoveredElevation;
    L9:
        if ((r2 instanceof FocusInteraction.Focus) == false) goto L12;
        return this.focusedElevation;
    L12:
        return this.defaultElevation;
    }

    private final Object snapElevation(Continuation<? super Unit> r5) {
        if ((r5 instanceof C02421) == false) goto L7;
        C02421 r0 = (C02421) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L13
    L22:
        this.lastTargetInteraction = this.targetInteraction;
    L26:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r6);
        float r7 = m2076calculateTargetu2uoSUM(this.targetInteraction);
        if (Dp.equals-impl0(this.animatable.getTargetValue().unbox-impl(), r7) == true) goto L26;
        Animatable<Dp, AnimationVector1D> r4 = this.animatable;     // Catch: Throwable -> L13
        Dp r8 = Dp.box-impl(r7);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        if (r4.snapTo(r8, r0) != r2) goto L22;
        return r2;
    L13:
        th = move-exception;
        this.lastTargetInteraction = this.targetInteraction;
        throw th;
    L7:
        r0 = new C02421(this, r5);
        goto L8
    }

    public static final /* synthetic */ Object access$snapElevation(FloatingActionButtonElevationAnimatable r0, Continuation r1) {
        return r0.snapElevation(r1);
    }

    public final Object animateElevation(Interaction r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (Interaction) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L24
    L22:
        this.lastTargetInteraction = r6;
        r6 = Unit.INSTANCE;
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        float r9 = m2076calculateTargetu2uoSUM(r6);
        this.targetInteraction = r6;
        if (Dp.equals-impl0(this.animatable.getTargetValue().unbox-impl(), r9) == true) goto L22;
        Animatable<Dp, AnimationVector1D> r4 = this.animatable;     // Catch: Throwable -> L24
        Interaction r5 = this.lastTargetInteraction;     // Catch: Throwable -> L24
        r0.L$0 = r6;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        if (ElevationKt.m2055animateElevationrAjV9yQ(r4, r9, r5, r6, r0) != r2) goto L22;
        return r2;
    L24:
        th = move-exception;
        this.lastTargetInteraction = r6;
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    private FloatingActionButtonElevationAnimatable(float r8, float r9, float r10, float r11) {
        this.defaultElevation = r8;
        this.pressedElevation = r9;
        this.hoveredElevation = r10;
        this.focusedElevation = r11;
        this.animatable = new Animatable(Dp.box-impl(r8), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
    }

    /* JADX INFO: renamed from: updateElevation-lDy3nrA, reason: not valid java name */
    public final Object m2077updateElevationlDy3nrA(float r1, float r2, float r3, float r4, Continuation<? super Unit> r5) {
        this.defaultElevation = r1;
        this.pressedElevation = r2;
        this.hoveredElevation = r3;
        this.focusedElevation = r4;
        Object r6 = snapElevation(r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
