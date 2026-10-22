package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 j*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001jBs\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0083\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0015J\u0006\u00109\u001a\u00020\u0006J#\u0010L\u001a\u00020M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010O\u001a\u00028\u0000¢\u0006\u0002\u0010PJ\u0016\u0010Q\u001a\u00020M2\u0006\u0010R\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010SJ%\u0010T\u001a\u00028\u00002\u0006\u00102\u001a\u00020\u00062\u0006\u0010$\u001a\u00028\u00002\u0006\u0010R\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010UJ\u001d\u0010V\u001a\u00028\u00002\u0006\u00102\u001a\u00020\u00062\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010WJ\\\u0010Z\u001a\u00020M2\b\b\u0002\u0010[\u001a\u00020\\2B\u0010]\u001a>\b\u0001\u0012\u0004\u0012\u00020Y\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0_\u0012\u0006\u0012\u0004\u0018\u00010\u00020^¢\u0006\u0002\b`H\u0086@¢\u0006\u0002\u0010aJy\u0010Z\u001a\u00020M2\u0006\u0010+\u001a\u00028\u00002\b\b\u0002\u0010[\u001a\u00020\\2W\u0010]\u001aS\b\u0001\u0012\u0004\u0012\u00020Y\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0_\u0012\u0006\u0012\u0004\u0018\u00010\u00020b¢\u0006\u0002\b`H\u0086@¢\u0006\u0002\u0010cJ\u0015\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0000¢\u0006\u0002\bfJ\u000e\u0010g\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006J\u0015\u0010h\u001a\u00020\u00102\u0006\u0010+\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010iR/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR/\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R+\u0010$\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010+\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b,\u0010&R\u001b\u0010/\u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b0\u0010&R+\u00102\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u0010:\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020\u00068GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b=\u00104R+\u0010?\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u00108\u001a\u0004\b@\u00104\"\u0004\bA\u00106R/\u0010C\u001a\u0004\u0018\u00018\u00002\b\u0010#\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010*\u001a\u0004\bD\u0010&\"\u0004\bE\u0010(R7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010*\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchors", "Landroidx/compose/material/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/material/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$material", "()Lkotlin/jvm/functions/Function1;", "getVelocityThreshold$material", "()Lkotlin/jvm/functions/Function0;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmValueChange$material", "dragMutex", "Landroidx/compose/material/InternalMutatorMutex;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material", "()Landroidx/compose/foundation/gestures/DraggableState;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "closestValue", "getClosestValue$material", "closestValue$delegate", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "()Z", "progress", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/material/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/material/DraggableAnchors;Ljava/lang/Object;)V", "settle", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "anchoredDragScope", "Landroidx/compose/material/AnchoredDragScope;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$material", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final State closestValue$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private final InternalMutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\r0\f2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/AnchoredDraggableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "velocityThreshold", "Lkotlin/Function0;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ AnchoredDraggableState a(Function1 r0, Function0 r1, AnimationSpec r2, Function1 r3, Object r4) {
            return Saver$lambda$1(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Object b(SaverScope r0, AnchoredDraggableState r1) {
            return Saver$lambda$0(r0, r1);
        }

        private static final Object Saver$lambda$0(SaverScope r0, AnchoredDraggableState r1) {
            return r1.getCurrentValue();
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> r3, final Function1<? super T, Boolean> r4, final Function1<? super Float, Float> r5, final Function0<Float> r6) {
            return SaverKt.Saver(new m(), new n(r5, r6, r3, r4));
        }

        private static final AnchoredDraggableState Saver$lambda$1(Function1 r7, Function0 r8, AnimationSpec r9, Function1 r10, Object r11) {
            return new AnchoredDraggableState(r11, r7, r8, r9, r10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {}, l = {523}, m = "anchoredDrag", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        public AnonymousClass1(AnchoredDraggableState<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.anchoredDrag(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "latestAnchors", "Landroidx/compose/material/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00502 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00502(Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r1, AnchoredDraggableState<T> r2, Continuation<? super C00502> r3) {
                this.$block = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                C00502 r0 = new C00502(this.$block, this.this$0, r5);
                r0.L$0 = r4;
                return r0;
            }

            public final Object invoke(DraggableAnchors<T> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((DraggableAnchors) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                DraggableAnchors r6 = (DraggableAnchors) this.L$0;
                Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> r2 = this.$block;
                AnchoredDragScope r3 = AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0);
                this.label = 1;
                if (r2.invoke(r3, r6, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(AnchoredDraggableState<T> r1, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$block = r2;
            super(1, r3);
        }

        public static /* synthetic */ DraggableAnchors a(AnchoredDraggableState r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final DraggableAnchors invokeSuspend$lambda$0(AnchoredDraggableState r0) {
            return r0.getAnchors();
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            final AnchoredDraggableState<T> r8 = this.this$0;
            Function0 r2 = new o(r8);
            C00502 r3 = new C00502(this.$block, r8, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {}, l = {570}, m = "anchoredDrag", n = {}, s = {})
    public static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        public AnonymousClass3(AnchoredDraggableState<T> r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", i = {}, l = {572}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "<destruct>", "Lkotlin/Pair;", "Landroidx/compose/material/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", i = {}, l = {574}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1, AnchoredDraggableState<T> r2, Continuation<? super AnonymousClass2> r3) {
                this.$block = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                AnonymousClass2 r0 = new AnonymousClass2(this.$block, this.this$0, r5);
                r0.L$0 = r4;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Pair) r1, (Continuation) r2);
            }

            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                Pair r7 = (Pair) this.L$0;
                DraggableAnchors r2 = (DraggableAnchors) r7.component1();
                Object r8 = r7.component2();
                Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> r3 = this.$block;
                AnchoredDragScope r4 = AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0);
                this.label = 1;
                if (r3.invoke(r4, r2, r8, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(AnchoredDraggableState<T> r1, T r2, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AnonymousClass4> r4) {
            this.this$0 = r1;
            this.$targetValue = r2;
            this.$block = r3;
            super(1, r4);
        }

        public static /* synthetic */ Pair a(AnchoredDraggableState r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass4(this.this$0, this.$targetValue, this.$block, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Pair invokeSuspend$lambda$0(AnchoredDraggableState r1) {
            return TuplesKt.to(r1.getAnchors(), r1.getTargetValue());
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            AnchoredDraggableState.access$setDragTarget(this.this$0, this.$targetValue);
            final AnchoredDraggableState<T> r8 = this.this$0;
            Function0 r2 = new p(r8);
            AnonymousClass2 r3 = new AnonymousClass2(this.$block, r8, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(Object r0) {
        return true;
    }

    private static final boolean _init_$lambda$1(Object r0) {
        return true;
    }

    public static /* synthetic */ boolean a(Object r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ boolean b(Object r0) {
        return _init_$lambda$1(r0);
    }

    public static /* synthetic */ Object c(AnchoredDraggableState r0) {
        return targetValue_delegate$lambda$3(r0);
    }

    public static /* synthetic */ Object d(AnchoredDraggableState r0) {
        return closestValue_delegate$lambda$5(r0);
    }

    public static /* synthetic */ Unit e(AnchoredDraggableState r0, Object r1) {
        return trySnapTo$lambda$9(r0, r1);
    }

    public static /* synthetic */ float f(AnchoredDraggableState r0) {
        return progress_delegate$lambda$7(r0);
    }

    private final T getDragTarget() {
        return (T) this.dragTarget$delegate.getValue();
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors$delegate.getValue();
    }

    public final T getClosestValue$material() {
        return (T) this.closestValue$delegate.getValue();
    }

    public final T getCurrentValue() {
        return (T) this.currentValue$delegate.getValue();
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    public final boolean isAnimationRunning() {
        if (getDragTarget() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        if ((!Float.isNaN(getOffset())) == false) goto L7;
        return getOffset();
    L7:
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$material() {
        return this.confirmValueChange;
    }

    public final DraggableState getDraggableState$material() {
        return this.draggableState;
    }

    public final Function1<Float, Float> getPositionalThreshold$material() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$material() {
        return this.velocityThreshold;
    }

    public static final /* synthetic */ AnchoredDragScope access$getAnchoredDragScope$p(AnchoredDraggableState r0) {
        return r0.anchoredDragScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object closestValue_delegate$lambda$5(AnchoredDraggableState r2) {
        Object r0 = r2.getDragTarget();
        if (r0 != null) goto L10;
        float r1 = r2.getOffset();
        if (Float.isNaN(r1) == true) goto L7;
        Object r3 = r2.computeTargetWithoutThresholds(r1, r2.getCurrentValue());
    L9:
        return r3;
    L7:
        r3 = r2.getCurrentValue();
        goto L9
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final float progress_delegate$lambda$7(AnchoredDraggableState r5) {
        float r0 = r5.getAnchors().positionOf(r5.getCurrentValue());
        float r1 = r5.getAnchors().positionOf(r5.getClosestValue$material()) - r0;
        float r2 = Math.abs(r1);
        if (Float.isNaN(r2) == false) goto L5;
        return 1.0f;
    L5:
        if (r2 <= 1.0E-6f) goto L15;
        float r6 = (r5.requireOffset() - r0) / r1;
        if (r6 >= 1.0E-6f) goto L10;
        return androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L10:
        if (r6 <= 0.999999f) goto L13;
        return 1.0f;
    L13:
        return r6;
    L15:
        return 1.0f;
    }

    private final void setAnchors(DraggableAnchors<T> r2) {
        this.anchors$delegate.setValue(r2);
    }

    private final void setCurrentValue(T r2) {
        this.currentValue$delegate.setValue(r2);
    }

    private final void setDragTarget(T r2) {
        this.dragTarget$delegate.setValue(r2);
    }

    private final void setLastVelocity(float r2) {
        this.lastVelocity$delegate.setFloatValue(r2);
    }

    private final void setOffset(float r2) {
        this.offset$delegate.setFloatValue(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object targetValue_delegate$lambda$3(AnchoredDraggableState r3) {
        Object r0 = r3.getDragTarget();
        if (r0 != null) goto L10;
        float r1 = r3.getOffset();
        if (Float.isNaN(r1) == true) goto L7;
        Object r4 = r3.computeTarget(r1, r3.getCurrentValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget);
    L9:
        return r4;
    L7:
        r4 = r3.getCurrentValue();
        goto L9
    L10:
        return r0;
    }

    private final boolean trySnapTo(final T r3) {
        return this.dragMutex.tryMutate(new i(this, r3));
    }

    public final float dispatchRawDelta(float r2) {
        float r3 = newOffsetForDelta$material(r2);
        if (Float.isNaN(getOffset()) == false) goto L5;
        float r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L6:
        setOffset(r3);
        return r3 - r0;
    L5:
        r0 = getOffset();
        goto L6
    }

    public final float newOffsetForDelta$material(float r3) {
        if (Float.isNaN(getOffset()) == false) goto L5;
        float r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L7:
        return RangesKt.coerceIn(r0 + r3, getAnchors().minAnchor(), getAnchors().maxAnchor());
    L5:
        r0 = getOffset();
        goto L7
    }

    public static final /* synthetic */ void access$setDragTarget(AnchoredDraggableState r0, Object r1) {
        r0.setDragTarget(r1);
    }

    public static final /* synthetic */ void access$setLastVelocity(AnchoredDraggableState r0, float r1) {
        r0.setLastVelocity(r1);
    }

    public static final /* synthetic */ void access$setOffset(AnchoredDraggableState r0, float r1) {
        r0.setOffset(r1);
    }

    private final T computeTargetWithoutThresholds(float r7, T r8) {
        DraggableAnchors<T> r0 = getAnchors();
        float r1 = r0.positionOf(r8);
        if (r1 != r7) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        return r8;
    L8:
        if (Float.isNaN(r1) == true) goto L20;
        if (r1 >= r7) goto L14;
        T r9 = r0.closestAnchor(r7, true);
        if (r9 != null) goto L18;
        return r8;
    L18:
        return r9;
    L14:
        r9 = r0.closestAnchor(r7, false);
        if (r9 != null) goto L18;
        return r8;
    L20:
        return r8;
    L5:
        r5 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit trySnapTo$lambda$9(AnchoredDraggableState r5, Object r6) {
        AnchoredDragScope r0 = r5.anchoredDragScope;
        float r1 = r5.getAnchors().positionOf(r6);
        if (Float.isNaN(r1) == true) goto L5;
        AnchoredDragScope.CC.dragTo$default(r0, r1, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        r5.setDragTarget(null);
    L5:
        r5.setCurrentValue(r6);
        return Unit.INSTANCE;
    }

    public final Object settle(float r4, Continuation<? super Unit> r5) {
        T r0 = getCurrentValue();
        T r1 = computeTarget(requireOffset(), r0, r4);
        if (((Boolean) this.confirmValueChange.invoke(r1)).booleanValue() == false) goto L9;
        Object r6 = AnchoredDraggableKt.animateTo(this, r1, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r6;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r7 = AnchoredDraggableKt.animateTo(this, r0, r4, r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r7;
    L13:
        return Unit.INSTANCE;
    }

    public final void updateAnchors(DraggableAnchors<T> r2, T r3) {
        if (Intrinsics.areEqual(getAnchors(), r2) == true) goto L8;
        setAnchors(r2);
        if (trySnapTo(r3) == true) goto L9;
        setDragTarget(r3);
        return;
    L9:
        return;
    }

    private final T computeTarget(float r8, T r9, float r10) {
        DraggableAnchors<T> r0 = getAnchors();
        float r1 = r0.positionOf(r9);
        float r2 = ((Number) this.velocityThreshold.invoke()).floatValue();
        if (r1 != r8) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L8;
        return r9;
    L8:
        if (Float.isNaN(r1) == true) goto L33;
        if (r1 >= r8) goto L19;
        if (r10 < r2) goto L14;
        T r11 = r0.closestAnchor(r8, true);
        Intrinsics.checkNotNull(r11);
        return r11;
    L14:
        T r12 = r0.closestAnchor(r8, true);
        Intrinsics.checkNotNull(r12);
        float r3 = Math.abs(r0.positionOf(r12) - r1);
        if (r8 >= Math.abs(r1 + Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(r3))).floatValue()))) goto L30;
        return r9;
    L30:
        return r12;
    L19:
        if (r10 > (-r2)) goto L21;
        T r13 = r0.closestAnchor(r8, false);
        Intrinsics.checkNotNull(r13);
        return r13;
    L21:
        r12 = r0.closestAnchor(r8, false);
        Intrinsics.checkNotNull(r12);
        float r4 = Math.abs(r1 - r0.positionOf(r12));
        float r5 = Math.abs(r1 - Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(r4))).floatValue()));
        if (r8 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L27;
        if (Math.abs(r8) >= r5) goto L30;
        return r9;
    L27:
        if (r8 <= r5) goto L30;
        return r9;
    L33:
        return r9;
    L5:
        r6 = false;
        goto L6
    }

    public final Object anchoredDrag(MutatePriority r7, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L21:
        T r11 = getAnchors().closestAnchor(getOffset());
        if (r11 == null) goto L29;
        if (Math.abs(getOffset() - getAnchors().positionOf(r11)) > 0.5f) goto L29;
        if (((Boolean) this.confirmValueChange.invoke(r11)).booleanValue() == false) goto L29;
        setCurrentValue(r11);
    L29:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        InternalMutatorMutex r12 = this.dragMutex;     // Catch: Throwable -> L13
        AnonymousClass2 r4 = new AnonymousClass2(this, r8, null);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        if (r12.mutate(r7, r4, r0) != r2) goto L21;
        return r2;
    L13:
        th = move-exception;
        T r13 = getAnchors().closestAnchor(getOffset());
        if (r13 != null) goto L33;
    L37:
        throw th;
    L33:
        if (Math.abs(getOffset() - getAnchors().positionOf(r13)) > 0.5f) goto L37;
        if (((Boolean) this.confirmValueChange.invoke(r13)).booleanValue() == false) goto L37;
        setCurrentValue(r13);
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    public final Object anchoredDrag(T r7, MutatePriority r8, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L13
    L22:
        setDragTarget(null);
        T r12 = getAnchors().closestAnchor(getOffset());
        if (r12 == null) goto L39;
        if (Math.abs(getOffset() - getAnchors().positionOf(r12)) > 0.5f) goto L39;
        if (((Boolean) this.confirmValueChange.invoke(r12)).booleanValue() == false) goto L39;
        setCurrentValue(r12);
    L39:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);
        if (getAnchors().hasAnchorFor(r7) == false) goto L37;
        InternalMutatorMutex r13 = this.dragMutex;     // Catch: Throwable -> L13
        AnonymousClass4 r4 = new AnonymousClass4(this, r7, r9, null);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        if (r13.mutate(r8, r4, r0) != r2) goto L22;
        return r2;
    L37:
        setCurrentValue(r7);
    L13:
        th = move-exception;
        setDragTarget(null);
        T r14 = getAnchors().closestAnchor(getOffset());
        if (r14 != null) goto L32;
    L36:
        throw th;
    L32:
        if (Math.abs(getOffset() - getAnchors().positionOf(r14)) > 0.5f) goto L36;
        if (((Boolean) this.confirmValueChange.invoke(r14)).booleanValue() == false) goto L36;
        setCurrentValue(r14);
    L7:
        r0 = new AnonymousClass3(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T r1, Function1<? super Float, Float> r2, Function0<Float> r3, AnimationSpec<Float> r4, Function1<? super T, Boolean> r5) {
        this.positionalThreshold = r2;
        this.velocityThreshold = r3;
        this.animationSpec = r4;
        this.confirmValueChange = r5;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(r1, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new j(this));
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new k(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new l(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.access$emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState r0, DraggableAnchors r1, Object r2, int r3, Object r4) {
        if ((r3 & 2) != 0) goto L5;
    L10:
        r0.updateAnchors(r1, r2);
        return;
    L5:
        if (Float.isNaN(r0.getOffset()) == true) goto L9;
        r2 = r1.closestAnchor(r0.getOffset());
        if (r2 != null) goto L10;
        r2 = r0.getTargetValue();
        goto L10
    L9:
        r2 = r0.getTargetValue();
        goto L10
    }

    public AnchoredDraggableState(T r7, DraggableAnchors<T> r8, Function1<? super Float, Float> r9, Function0<Float> r10, AnimationSpec<Float> r11, Function1<? super T, Boolean> r12) {
        this(r7, r9, r10, r11, r12);
        setAnchors(r8);
        trySnapTo(r7);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r0, MutatePriority r1, Function3 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return r0.anchoredDrag(r1, r2, r3);
    }

    public /* synthetic */ AnchoredDraggableState(Object r7, Function1 r8, Function0 r9, AnimationSpec r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = new h();
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r0, Object r1, MutatePriority r2, Function4 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = MutatePriority.Default;
    L6:
        return r0.anchoredDrag(r1, r2, r3, r4);
    }

    public /* synthetic */ AnchoredDraggableState(Object r8, DraggableAnchors r9, Function1 r10, Function0 r11, AnimationSpec r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = new g();
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }
}
