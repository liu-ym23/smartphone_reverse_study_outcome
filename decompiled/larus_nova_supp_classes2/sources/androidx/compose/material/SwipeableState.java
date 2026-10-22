package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 w*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001wBD\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,H\u0000¢\u0006\u0002\b@J8\u0010A\u001a\u00020>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,H\u0080@¢\u0006\u0004\bC\u0010DJ\u0016\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010^J$\u0010_\u001a\u00020>2\u0006\u0010]\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010aJ\u0016\u0010n\u001a\u00020>2\u0006\u0010b\u001a\u00028\u0000H\u0087@¢\u0006\u0002\u0010oJ&\u0010p\u001a\u00020>2\u0006\u0010b\u001a\u00028\u00002\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020>2\u0006\u0010t\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010^J\u000e\u0010u\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060+X\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,04X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109RO\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060E2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060E8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR+\u0010L\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bM\u00107\"\u0004\bN\u00109R/\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010\u0013\u001a\u0004\u0018\u00010Q8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\u001a\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020YX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001a\u0010b\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010d\u001a\u0004\be\u0010\u0016R \u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000g8FX\u0087\u0004¢\u0006\f\u0012\u0004\bh\u0010d\u001a\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\bl\u0010d\u001a\u0004\bm\u00107¨\u0006x"}, d2 = {"Landroidx/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "getAnimationSpec$material", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmStateChange$material", "()Lkotlin/jvm/functions/Function1;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "overflow", "getOverflow", "offsetState", "Landroidx/compose/runtime/MutableFloatState;", "overflowState", "absoluteOffset", "animationTarget", "Landroidx/compose/runtime/MutableState;", "", "anchors", "getAnchors$material", "()Ljava/util/Map;", "setAnchors$material", "(Ljava/util/Map;)V", "anchors$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "minBound", "getMinBound$material", "()F", "setMinBound$material", "(F)V", "maxBound", "getMaxBound$material", "setMaxBound$material", "ensureInit", "", "newAnchors", "ensureInit$material", "processNewAnchors", "oldAnchors", "processNewAnchors$material", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "thresholds", "getThresholds$material", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material", "setVelocityThreshold$material", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/material/ResistanceConfig;", "resistance", "getResistance$material", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance$delegate", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material", "()Landroidx/compose/foundation/gestures/DraggableState;", "snapInternalToOffset", "target", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateInternalToOffset", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetValue", "getTargetValue$annotations", "()V", "getTargetValue", "progress", "Landroidx/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/compose/material/SwipeProgress;", "direction", "getDirection$annotations", "getDirection", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "velocity", "performDrag", "delta", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SwipeableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final MutableFloatState absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableFloatState velocityThreshold$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\r0\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/SwipeableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ SwipeableState a(AnimationSpec r0, Function1 r1, Object r2) {
            return Saver$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ Object b(SaverScope r0, SwipeableState r1) {
            return Saver$lambda$0(r0, r1);
        }

        private static final Object Saver$lambda$0(SaverScope r0, SwipeableState r1) {
            return r1.getCurrentValue();
        }

        public final <T> Saver<SwipeableState<T>, T> Saver(final AnimationSpec<Float> r3, final Function1<? super T, Boolean> r4) {
            return SaverKt.Saver(new pb(), new qb(r3, r4));
        }

        private static final SwipeableState Saver$lambda$1(AnimationSpec r1, Function1 r2, Object r3) {
            return new SwipeableState(r3, r1, r2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateInternalToOffset$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        public AnonymousClass2(SwipeableState<T> r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$target = r2;
            this.$spec = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(DragScope r0, Ref.FloatRef r1, Animatable r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$target, this.$spec, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(DragScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((DragScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L7
            Object r2 = r14;
        L15:
            AnimationResult r3 = (AnimationResult) r2;     // Catch: Throwable -> L7
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(null);
            SwipeableState.access$setAnimationRunning(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r14);
            final DragScope r4 = (DragScope) this.L$0;
            final Ref.FloatRef r5 = new Ref.FloatRef();
            r5.element = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(Boxing.boxFloat(this.$target));
            SwipeableState.access$setAnimationRunning(this.this$0, true);
            Animatable r6 = AnimatableKt.Animatable$default(r5.element, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);     // Catch: Throwable -> L7
            Float r7 = Boxing.boxFloat(this.$target);     // Catch: Throwable -> L7
            AnimationSpec<Float> r8 = this.$spec;     // Catch: Throwable -> L7
            Function1 r9 = new rb(r4, r5);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r2 = Animatable.animateTo$default(r6, r7, r8, null, r9, this, 4, null);     // Catch: Throwable -> L7
            if (r2 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(null);
            SwipeableState.access$setAnimationRunning(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(DragScope r2, Ref.FloatRef r3, Animatable r4) {
            r2.dragBy(((Number) r4.getValue()).floatValue() - r3.element);
            r3.element = ((Number) r4.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02482<T> implements FlowCollector {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C02482(T r1, SwipeableState<T> r2, AnimationSpec<Float> r3) {
            this.$targetValue = r1;
            this.this$0 = r2;
            this.$anim = r3;
        }

        public final Object emit(Map<Float, ? extends T> r8, Continuation<? super Unit> r9) {
            if ((r9 instanceof SwipeableState$animateTo$2$emit$1) == false) goto L7;
            SwipeableState$animateTo$2$emit$1 r0 = (SwipeableState$animateTo$2$emit$1) r9;
            int r1 = r0.label;
            if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
            r0.label = r1 - RtlSpacingHelper.UNDEFINED;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            r8 = (Map) r0.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L38
        L22:
            float r11 = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            LinkedHashMap r4 = new LinkedHashMap();
            Iterator<Map.Entry<Float, ? extends T>> r12 = r8.entrySet().iterator();
        L24:
            if (r12.hasNext() == false) goto L31;
            Map.Entry<Float, ? extends T> r5 = r12.next();
            if (Math.abs(r5.getKey().floatValue() - r11) >= 0.5f) goto L28;
            boolean r6 = true;
        L29:
            if (r6 == false) goto L24;
            r4.put(r5.getKey(), r5.getValue());
            goto L24
        L28:
            r6 = false;
            goto L29
        L31:
            Object r13 = CollectionsKt.firstOrNull(r4.values());
            if (r13 != null) goto L34;
            r13 = this.this$0.getCurrentValue();
        L34:
            SwipeableState.access$setCurrentValue(this.this$0, r13);
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r10);
            Float r14 = SwipeableKt.access$getOffset(r8, this.$targetValue);     // Catch: Throwable -> L38
            if (r14 == null) goto L37;
            SwipeableState<T> r7 = this.this$0;     // Catch: Throwable -> L38
            float r15 = r14.floatValue();     // Catch: Throwable -> L38
            AnimationSpec<Float> r16 = this.$anim;     // Catch: Throwable -> L38
            r0.L$0 = r8;     // Catch: Throwable -> L38
            r0.label = 1;     // Catch: Throwable -> L38
            if (SwipeableState.access$animateInternalToOffset(r7, r15, r16, r0) != r2) goto L22;
            return r2;
        L37:
            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            float r17 = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            LinkedHashMap r18 = new LinkedHashMap();
            Iterator<Map.Entry<Float, ? extends T>> r19 = r8.entrySet().iterator();
        L41:
            if (r19.hasNext() == false) goto L48;
            Map.Entry<Float, ? extends T> r20 = r19.next();
            if (Math.abs(r20.getKey().floatValue() - r17) >= 0.5f) goto L45;
            boolean r21 = true;
        L46:
            if (r21 == false) goto L41;
            r18.put(r20.getKey(), r20.getValue());
            goto L41
        L45:
            r21 = false;
            goto L46
        L48:
            Object r22 = CollectionsKt.firstOrNull(r18.values());
            if (r22 != null) goto L51;
            r22 = this.this$0.getCurrentValue();
        L51:
            SwipeableState.access$setCurrentValue(this.this$0, r22);
            throw th;
        L7:
            r0 = new SwipeableState$animateTo$2$emit$1(this, r9);
            goto L8
        }

        public /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return emit((Map) r1, r2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02502 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        public C02502(float r1, SwipeableState<T> r2, Continuation<? super C02502> r3) {
            this.$target = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02502 r0 = new C02502(this.$target, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(DragScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((DragScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ((DragScope) this.L$0).dragBy(this.$target - SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02512<T> implements FlowCollector {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C02512(T r1, SwipeableState<T> r2) {
            this.$targetValue = r1;
            this.this$0 = r2;
        }

        public final Object emit(Map<Float, ? extends T> r5, Continuation<? super Unit> r6) {
            if ((r6 instanceof SwipeableState$snapTo$2$emit$1) == false) goto L7;
            SwipeableState$snapTo$2$emit$1 r0 = (SwipeableState$snapTo$2$emit$1) r6;
            int r1 = r0.label;
            if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
            r0.label = r1 - RtlSpacingHelper.UNDEFINED;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L19:
            SwipeableState.access$setCurrentValue(this.this$0, this.$targetValue);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            Float r8 = SwipeableKt.access$getOffset(r5, this.$targetValue);
            if (r8 == null) goto L22;
            SwipeableState<T> r9 = this.this$0;
            float r10 = r8.floatValue();
            r0.label = 1;
            if (SwipeableState.access$snapInternalToOffset(r9, r10, r0) != r2) goto L19;
            return r2;
        L22:
            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
        L7:
            r0 = new SwipeableState$snapTo$2$emit$1(this, r6);
            goto L8
        }

        public /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return emit((Map) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(Object r0) {
        return true;
    }

    public static /* synthetic */ Map a(SwipeableState r0) {
        return latestNonEmptyAnchorsFlow$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(SwipeableState r0, float r1) {
        return draggableState$lambda$8(r0, r1);
    }

    public static /* synthetic */ float c(float r0, float r1) {
        return thresholds_delegate$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean d(Object r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ void getDirection$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    private static final float thresholds_delegate$lambda$7(float r0, float r1) {
        return androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    }

    public final Map<Float, T> getAnchors$material() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final T getCurrentValue() {
        return (T) this.currentValue$delegate.getValue();
    }

    public final ResistanceConfig getResistance$material() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue() {
        Float r0 = (Float) this.animationTarget.getValue();
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L10:
        T r2 = getAnchors$material().get(Float.valueOf(r1));
        if (r2 == null) goto L13;
        return r2;
    L13:
        return getCurrentValue();
    L5:
        float r3 = ((Number) getOffset().getValue()).floatValue();
        Float r4 = SwipeableKt.access$getOffset(getAnchors$material(), getCurrentValue());
        if (r4 == null) goto L8;
        float r5 = r4.floatValue();
    L9:
        r1 = SwipeableKt.access$computeTarget(r3, r5, getAnchors$material().keySet(), getThresholds$material(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, Float.POSITIVE_INFINITY);
        goto L10
    L8:
        r5 = ((Number) getOffset().getValue()).floatValue();
        goto L9
    }

    public final Function2<Float, Float, Float> getThresholds$material() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material() {
        return this.velocityThreshold$delegate.getFloatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float getDirection() {
        Float r0 = SwipeableKt.access$getOffset(getAnchors$material(), getCurrentValue());
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
        return Math.signum(((Number) getOffset().getValue()).floatValue() - r1);
    L5:
        return androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    }

    public final SwipeProgress<T> getProgress() {
        List r0 = SwipeableKt.access$findBounds(((Number) getOffset().getValue()).floatValue(), getAnchors$material().keySet());
        int r1 = r0.size();
        if (r1 != 0) goto L5;
        T r2 = getCurrentValue();
        Object r3 = getCurrentValue();
        Object r4 = r2;
    L13:
        float r5 = 1.0f;
    L15:
        return new SwipeProgress(r4, r3, r5);
    L5:
        if (r1 != 1) goto L7;
        Object r6 = MapsKt.getValue(getAnchors$material(), ListProtector.get(r0, 0));
        r3 = MapsKt.getValue(getAnchors$material(), ListProtector.get(r0, 0));
        r4 = r6;
        goto L13
    L7:
        if (getDirection() <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L9;
        Pair r7 = TuplesKt.to(ListProtector.get(r0, 0), ListProtector.get(r0, 1));
    L10:
        float r8 = ((Number) r7.component1()).floatValue();
        float r9 = ((Number) r7.component2()).floatValue();
        r4 = MapsKt.getValue(getAnchors$material(), Float.valueOf(r8));
        r3 = MapsKt.getValue(getAnchors$material(), Float.valueOf(r9));
        r5 = (((Number) getOffset().getValue()).floatValue() - r8) / (r9 - r8);
        goto L15
    L9:
        r7 = TuplesKt.to(ListProtector.get(r0, 1), ListProtector.get(r0, 0));
        goto L10
    }

    public final AnimationSpec<Float> getAnimationSpec$material() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$material() {
        return this.confirmStateChange;
    }

    public final DraggableState getDraggableState$material() {
        return this.draggableState;
    }

    public final float getMaxBound$material() {
        return this.maxBound;
    }

    public final float getMinBound$material() {
        return this.minBound;
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    public static final /* synthetic */ MutableFloatState access$getAbsoluteOffset$p(SwipeableState r0) {
        return r0.absoluteOffset;
    }

    public static final /* synthetic */ MutableState access$getAnimationTarget$p(SwipeableState r0) {
        return r0.animationTarget;
    }

    private static final Map latestNonEmptyAnchorsFlow$lambda$1(SwipeableState r0) {
        return r0.getAnchors$material();
    }

    private final void setAnimationRunning(boolean r2) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setCurrentValue(T r2) {
        this.currentValue$delegate.setValue(r2);
    }

    public final void ensureInit$material(Map<Float, ? extends T> r3) {
        if (getAnchors$material().isEmpty() == false) goto L9;
        Float r4 = SwipeableKt.access$getOffset(r3, getCurrentValue());
        if (r4 == null) goto L8;
        this.offsetState.setFloatValue(r4.floatValue());
        this.absoluteOffset.setFloatValue(r4.floatValue());
        return;
    L8:
        throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
    }

    public final float performDrag(float r3) {
        float r4 = RangesKt.coerceIn(this.absoluteOffset.getFloatValue() + r3, this.minBound, this.maxBound) - this.absoluteOffset.getFloatValue();
        if (Math.abs(r4) <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L5;
        this.draggableState.dispatchRawDelta(r4);
    L5:
        return r4;
    }

    public final void setAnchors$material(Map<Float, ? extends T> r2) {
        this.anchors$delegate.setValue(r2);
    }

    public final void setMaxBound$material(float r1) {
        this.maxBound = r1;
    }

    public final void setMinBound$material(float r1) {
        this.minBound = r1;
    }

    public final void setResistance$material(ResistanceConfig r2) {
        this.resistance$delegate.setValue(r2);
    }

    public final void setThresholds$material(Function2<? super Float, ? super Float, Float> r2) {
        this.thresholds$delegate.setValue(r2);
    }

    public final void setVelocityThreshold$material(float r2) {
        this.velocityThreshold$delegate.setFloatValue(r2);
    }

    public static final /* synthetic */ void access$setAnimationRunning(SwipeableState r0, boolean r1) {
        r0.setAnimationRunning(r1);
    }

    public static final /* synthetic */ void access$setCurrentValue(SwipeableState r0, Object r1) {
        r0.setCurrentValue(r1);
    }

    private static final Unit draggableState$lambda$8(SwipeableState r4, float r5) {
        float r0 = r4.absoluteOffset.getFloatValue() + r5;
        float r6 = RangesKt.coerceIn(r0, r4.minBound, r4.maxBound);
        float r1 = r0 - r6;
        ResistanceConfig r2 = r4.getResistance$material();
        if (r2 == null) goto L5;
        float r3 = r2.computeResistance(r1);
    L6:
        r4.offsetState.setFloatValue(r6 + r3);
        r4.overflowState.setFloatValue(r1);
        r4.absoluteOffset.setFloatValue(r0);
        return Unit.INSTANCE;
    L5:
        r3 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L6
    }

    private final Object snapInternalToOffset(float r7, Continuation<? super Unit> r8) {
        Object r9 = DraggableState.CC.drag$default(this.draggableState, null, new C02502(r7, this, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public final Object performFling(final float r3, Continuation<? super Unit> r4) {
        Object r5 = this.latestNonEmptyAnchorsFlow.collect(new C02492(this, r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final Object snapTo(T r3, Continuation<? super Unit> r4) {
        Object r5 = this.latestNonEmptyAnchorsFlow.collect(new C02512(r3, this), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T r3, AnimationSpec<Float> r4, Function1<? super T, Boolean> r5) {
        this.animationSpec = r4;
        this.confirmStateChange = r5;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(r3, null, 2, null);
        this.isAnimationRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        this.animationTarget = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        final Flow r0 = SnapshotStateKt.snapshotFlow(new lb(this));
        this.latestNonEmptyAnchorsFlow = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new SwipeableState$special$$inlined$filter$1(r0));
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt.mutableStateOf$default(new mb(), null, 2, null);
        this.velocityThreshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        this.resistance$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new nb(this));
    }

    public static final /* synthetic */ Object access$snapInternalToOffset(SwipeableState r0, float r1, Continuation r2) {
        return r0.snapInternalToOffset(r1, r2);
    }

    private final Object animateInternalToOffset(float r7, AnimationSpec<Float> r8, Continuation<? super Unit> r9) {
        Object r10 = DraggableState.CC.drag$default(this.draggableState, null, new AnonymousClass2(this, r7, r8, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo(T r3, AnimationSpec<Float> r4, Continuation<? super Unit> r5) {
        Object r6 = this.latestNonEmptyAnchorsFlow.collect(new C02482(r3, this, r4), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v24, types: [float] */
    /* JADX WARN: Type inference failed for: r10v65 */
    /* JADX WARN: Type inference failed for: r10v68, types: [float] */
    /* JADX WARN: Type inference failed for: r10v72 */
    /* JADX WARN: Type inference failed for: r10v73 */
    public final Object processNewAnchors$material(float r10, Map<Float, ? extends T> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof SwipeableState$processNewAnchors$1) == false) goto L7;
        SwipeableState$processNewAnchors$1 r0 = (SwipeableState$processNewAnchors$1) r12;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        r10 = (Map<Float, ? extends T>) r0.F$0;
        r11 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L21
    L77:
        setCurrentValue(MapsKt.getValue(r11, Boxing.boxFloat(r10)));
        Float r14 = CollectionsKt.minOrNull(r11.keySet());
        Intrinsics.checkNotNull(r14);
        this.minBound = r14.floatValue();
        Float r15 = CollectionsKt.maxOrNull(r11.keySet());
        Intrinsics.checkNotNull(r15);
        r10 = (Map<Float, ? extends T>) r15.floatValue();
        this.maxBound = r10;
    L84:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r16 = (Map<Float, ? extends T>) r0.F$0;
        r11 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L21 CancellationException -> L78
        r10 = r16;
    L85:
    L23:
        ResultKt.throwOnFailure(r13);
    L32:
        return Unit.INSTANCE;
    L24:
        ResultKt.throwOnFailure(r13);
        if (r10.isEmpty() == false) goto L36;
        Float r17 = CollectionsKt.minOrNull(r11.keySet());
        Intrinsics.checkNotNull(r17);
        this.minBound = r17.floatValue();
        Float r18 = CollectionsKt.maxOrNull(r11.keySet());
        Intrinsics.checkNotNull(r18);
        this.maxBound = r18.floatValue();
        Float r19 = SwipeableKt.access$getOffset(r11, getCurrentValue());
        if (r19 == null) goto L34;
        float r110 = r19.floatValue();
        r0.label = 1;
        if (snapInternalToOffset(r110, r0) != r2) goto L32;
        return r2;
    L34:
        throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
    L36:
        if (Intrinsics.areEqual(r11, r10) == true) goto L84;
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        Float r111 = (Float) this.animationTarget.getValue();
        Object r4 = null;
        if (r111 == null) goto L55;
        Float r112 = SwipeableKt.access$getOffset(r11, r10.get(r111));
        if (r112 == null) goto L42;
        float r113 = r112.floatValue();
    L74:
        AnimationSpec<Float> r114 = this.animationSpec;     // Catch: Throwable -> L21 CancellationException -> L78
        r0.L$0 = r11;     // Catch: Throwable -> L21 CancellationException -> L78
        r0.F$0 = r113;     // Catch: Throwable -> L21 CancellationException -> L78
        r0.label = 2;     // Catch: Throwable -> L21 CancellationException -> L78
        Object r115 = animateInternalToOffset(r113, r114, r0);     // Catch: Throwable -> L21 CancellationException -> L78
        r10 = r113;
        if (r115 != r2) goto L85;
        return r2;
    L42:
        Iterator<T> r5 = r11.keySet().iterator();
        if (r5.hasNext() == false) goto L54;
        r4 = r5.next();
        if (r5.hasNext() == false) goto L54;
        float r116 = Math.abs(((Number) r4).floatValue() - r111.floatValue());
    L49:
        Object r6 = r5.next();
        float r7 = Math.abs(((Number) r6).floatValue() - r111.floatValue());
        if (Float.compare(r116, r7) <= 0) goto L53;
        r4 = r6;
        r116 = r7;
    L53:
        if (r5.hasNext() == true) goto L49;
    L54:
        Intrinsics.checkNotNull(r4);
        r113 = ((Number) r4).floatValue();
        goto L74
    L55:
        Object r117 = r10.get(getOffset().getValue());
        if (Intrinsics.areEqual(r117, getCurrentValue()) == false) goto L58;
        r117 = getCurrentValue();
    L58:
        Float r118 = SwipeableKt.access$getOffset(r11, r117);
        if (r118 == null) goto L61;
        r113 = r118.floatValue();
        goto L74
    L61:
        Iterator<T> r119 = r11.keySet().iterator();
        if (r119.hasNext() == false) goto L73;
        r4 = r119.next();
        if (r119.hasNext() == false) goto L73;
        float r120 = Math.abs(((Number) r4).floatValue() - ((Number) getOffset().getValue()).floatValue());
    L68:
        Object r8 = r119.next();
        float r9 = Math.abs(((Number) r8).floatValue() - ((Number) getOffset().getValue()).floatValue());
        if (Float.compare(r120, r9) <= 0) goto L72;
        r4 = r8;
        r120 = r9;
    L72:
        if (r119.hasNext() == true) goto L68;
    L73:
        Intrinsics.checkNotNull(r4);
        r113 = ((Number) r4).floatValue();
    L78:
        r0.L$0 = r11;     // Catch: Throwable -> L21
        r0.F$0 = r10;     // Catch: Throwable -> L21
        r0.label = 3;     // Catch: Throwable -> L21
        if (snapInternalToOffset(r10, r0) != r2) goto L77;
        return r2;
    L21:
        th = move-exception;
        setCurrentValue(MapsKt.getValue(r11, Boxing.boxFloat(r10)));
        Float r121 = CollectionsKt.minOrNull(r11.keySet());
        Intrinsics.checkNotNull(r121);
        this.minBound = r121.floatValue();
        Float r122 = CollectionsKt.maxOrNull(r11.keySet());
        Intrinsics.checkNotNull(r122);
        this.maxBound = r122.floatValue();
        throw th;
    L7:
        r0 = new SwipeableState$processNewAnchors$1(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$animateInternalToOffset(SwipeableState r0, float r1, AnimationSpec r2, Continuation r3) {
        return r0.animateInternalToOffset(r1, r2, r3);
    }

    public /* synthetic */ SwipeableState(Object r1, AnimationSpec r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = new ob();
    L8:
        this(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState r0, Object r1, AnimationSpec r2, Continuation r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L7;
        r2 = r0.animationSpec;
    L7:
        return r0.animateTo(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }
}
