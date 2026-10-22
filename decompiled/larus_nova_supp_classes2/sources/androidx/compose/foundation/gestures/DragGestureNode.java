package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJM\u0010\u001f\u001a\u00020 2=\u0010!\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020 0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"H¦@¢\u0006\u0002\u0010)J\u0017\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u001dH&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H&¢\u0006\u0004\b1\u0010-J\b\u00102\u001a\u00020\u0006H&J\b\u00103\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0016J'\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u000205H\u0002J\b\u0010A\u001a\u00020 H\u0016J\u0016\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020DH\u0082@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020 2\u0006\u0010C\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\u000e\u0010I\u001a\u00020 H\u0082@¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020 JH\u0010L\u001a\u00020 2\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010M\u001a\u00020\u0006R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "value", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "nodeOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "startDragImmediately", "startListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "initializePointerInputNode", "onCancelPointerInput", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disposeInteractionSource", "update", "shouldResetPointerInputHandling", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode {
    public static final int $stable = 8;
    private final Function1<PointerInputChange, Boolean> _canDrag;
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private long nodeOffset;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements PointerInputEventHandler {
        final /* synthetic */ DragGestureNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {543}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
        public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
            final /* synthetic */ Function0<Unit> $onDragCancel;
            final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
            final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
            final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
            final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            public C00181(PointerInputScope r1, DragGestureNode r2, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> r3, Function1<? super PointerInputChange, Unit> r4, Function0<Unit> r5, Function0<Boolean> r6, Function2<? super PointerInputChange, ? super Offset, Unit> r7, Continuation<? super C00181> r8) {
                this.$this_SuspendingPointerInputModifierNode = r1;
                this.this$0 = r2;
                this.$onDragStart = r3;
                this.$onDragEnd = r4;
                this.$onDragCancel = r5;
                this.$shouldAwaitTouchSlop = r6;
                this.$onDrag = r7;
                super(2, r8);
            }

            public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
                C00181 r9 = new C00181(this.$this_SuspendingPointerInputModifierNode, this.this$0, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, r12);
                r9.L$0 = r11;
                return r9;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r13) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L12;
                if (r1 != 1) goto L11;
                CoroutineScope r2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(r13);     // Catch: CancellationException -> L8
            L24:
                return Unit.INSTANCE;
            L8:
                CancellationException e = e;
            L18:
                Channel r3 = DragGestureNode.access$getChannel$p(this.this$0);
                if (r3 == null) goto L22;
                r3.trySend-JP2dKIU(DragEvent.DragCancelled.INSTANCE);
            L22:
                if (CoroutineScopeKt.isActive(r2) == true) goto L24;
                throw e;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r13);
                CoroutineScope r14 = (CoroutineScope) this.L$0;
                PointerInputScope r4 = this.$this_SuspendingPointerInputModifierNode;     // Catch: CancellationException -> L16
                Orientation r5 = DragGestureNode.access$getOrientationLock$p(this.this$0);     // Catch: CancellationException -> L16
                Function3<PointerInputChange, PointerInputChange, Offset, Unit> r6 = this.$onDragStart;     // Catch: CancellationException -> L16
                Function1<PointerInputChange, Unit> r7 = this.$onDragEnd;     // Catch: CancellationException -> L16
                Function0<Unit> r8 = this.$onDragCancel;     // Catch: CancellationException -> L16
                Function0<Boolean> r9 = this.$shouldAwaitTouchSlop;     // Catch: CancellationException -> L16
                Function2<PointerInputChange, Offset, Unit> r10 = this.$onDrag;     // Catch: CancellationException -> L16
                this.L$0 = r14;     // Catch: CancellationException -> L16
                this.label = 1;     // Catch: CancellationException -> L16
                if (DragGestureDetectorKt.detectDragGestures(r4, r5, r6, r7, r8, r9, r10, this) != r0) goto L24;
                return r0;
            L16:
                e = move-exception;
                r2 = r14;
                e = e;
                goto L18
            }
        }

        public AnonymousClass1(DragGestureNode r1) {
            this.this$0 = r1;
        }

        public static /* synthetic */ Unit a(DragGestureNode r0) {
            return invoke$lambda$2(r0);
        }

        public static /* synthetic */ Unit b(DragGestureNode r0, VelocityTracker r1, PointerInputChange r2, PointerInputChange r3, Offset r4) {
            return invoke$lambda$0(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ boolean c(DragGestureNode r0) {
            return invoke$lambda$3(r0);
        }

        public static /* synthetic */ Unit d(DragGestureNode r0, Ref.LongRef r1, VelocityTracker r2, PointerInputChange r3, Offset r4) {
            return invoke$lambda$4(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Unit e(VelocityTracker r0, PointerInputScope r1, DragGestureNode r2, PointerInputChange r3) {
            return invoke$lambda$1(r0, r1, r2, r3);
        }

        private static final Unit invoke$lambda$2(DragGestureNode r1) {
            Channel r2 = DragGestureNode.access$getChannel$p(r1);
            if (r2 == null) goto L6;
            r2.trySend-JP2dKIU(DragEvent.DragCancelled.INSTANCE);
        L6:
            return Unit.INSTANCE;
        }

        private static final boolean invoke$lambda$3(DragGestureNode r0) {
            return !r0.startDragImmediately();
        }

        public final Object invoke(final PointerInputScope r14, Continuation<? super Unit> r15) {
            final VelocityTracker r0 = new VelocityTracker();
            final Ref.LongRef r1 = new Ref.LongRef();
            if (ComposeFoundationFlags.isAdjustPointerInputChangeOffsetForVelocityTrackerEnabled == false) goto L5;
            long r2 = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.this$0));
        L6:
            r1.element = r2;
            final DragGestureNode r6 = this.this$0;
            Object r16 = CoroutineScopeKt.coroutineScope(new C00181(r14, r6, new f1(r6, r0), new g1(r0, r14, r6), new h1(r6), new i1(r6), new j1(r6, r1, r0), null), r15);
            if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
            return r16;
        L10:
            return Unit.INSTANCE;
        L5:
            r2 = Offset.Companion.getZero-F1C5BW0();
            goto L6
        }

        private static final Unit invoke$lambda$1(VelocityTracker r2, PointerInputScope r3, DragGestureNode r4, PointerInputChange r5) {
            VelocityTrackerKt.addPointerInputChange(r2, r5);
            float r6 = r3.getViewConfiguration().getMaximumFlingVelocity();
            long r0 = r2.calculateVelocity-AH228Gc(VelocityKt.Velocity(r6, r6));
            r2.resetTracking();
            Channel r7 = DragGestureNode.access$getChannel$p(r4);
            if (r7 == null) goto L6;
            r7.trySend-JP2dKIU(new DragEvent.DragStopped(DraggableKt.m596access$toValidVelocityTH1AsA0(r0), null));
        L6:
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$0(DragGestureNode r3, VelocityTracker r4, PointerInputChange r5, PointerInputChange r6, Offset r7) {
            DragGestureNode.access$setNodeOffset$p(r3, Offset.Companion.getZero-F1C5BW0());
            if (((Boolean) r3.getCanDrag().invoke(r5)).booleanValue() == false) goto L14;
            if (DragGestureNode.access$isListeningForEvents$p(r3) == false) goto L7;
        L10:
            VelocityTrackerKt.addPointerInputChange(r4, r5);
            long r8 = Offset.minus-MK-Hz9U(r6.getPosition-F1C5BW0(), r7.unbox-impl());
            Channel r9 = DragGestureNode.access$getChannel$p(r3);
            if (r9 == null) goto L14;
            r9.trySend-JP2dKIU(new DragEvent.DragStarted(r8, null));
            goto L14
        L7:
            if (DragGestureNode.access$getChannel$p(r3) != null) goto L9;
            DragGestureNode.access$setChannel$p(r3, ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null));
        L9:
            DragGestureNode.access$startListeningForEvents(r3);
        L14:
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$4(DragGestureNode r6, Ref.LongRef r7, VelocityTracker r8, PointerInputChange r9, Offset r10) {
            if (ComposeFoundationFlags.isAdjustPointerInputChangeOffsetForVelocityTrackerEnabled == false) goto L8;
            long r0 = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(r6));
            if (Offset.equals-impl0(r0, r7.element) == true) goto L7;
            long r2 = Offset.minus-MK-Hz9U(r0, r7.element);
            DragGestureNode.access$setNodeOffset$p(r6, Offset.plus-MK-Hz9U(DragGestureNode.access$getNodeOffset$p(r6), r2));
        L7:
            r7.element = r0;
        L8:
            VelocityTrackerKt.addPointerInputChange-0AR0LA0(r8, r9, DragGestureNode.access$getNodeOffset$p(r6));
            Channel r11 = DragGestureNode.access$getChannel$p(r6);
            if (r11 == null) goto L12;
            r11.trySend-JP2dKIU(new DragEvent.DragDelta(r10.unbox-impl(), null));
        L12:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {}, l = {583}, m = "processDragCancel", n = {}, s = {})
    public static final class C01371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DragGestureNode this$0;

        public C01371(DragGestureNode r1, Continuation<? super C01371> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return DragGestureNode.access$processDragCancel(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 1, 1}, l = {565, 568}, m = "processDragStart", n = {"event", "event", "interaction"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DragGestureNode this$0;

        public C01381(DragGestureNode r1, Continuation<? super C01381> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return DragGestureNode.access$processDragStart(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {575}, m = "processDragStop", n = {"event"}, s = {"L$0"})
    public static final class C01391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DragGestureNode this$0;

        public C01391(DragGestureNode r1, Continuation<? super C01391> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return DragGestureNode.access$processDragStop(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {436, 438, 440, 447, 449, 452}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch", "event", "$this$launch", "event", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
    public static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {443}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"})
        public static final class C00191 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            public C00191(Ref.ObjectRef<DragEvent> r1, DragGestureNode r2, Continuation<? super C00191> r3) {
                this.$event = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                C00191 r0 = new C00191(this.$event, this.this$0, r5);
                r0.L$0 = r4;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Function1) r1, (Continuation) r2);
            }

            public final Object invoke(Function1<? super DragEvent.DragDelta, Unit> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:26:0x006a). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0063). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                Ref.ObjectRef<DragEvent> r2 = (Ref.ObjectRef) this.L$1;
                Function1 r3 = (Function1) this.L$0;
                ResultKt.throwOnFailure(r8);
                Function1 r4 = r3;
                Ref.ObjectRef<DragEvent> r5 = r2;
                Object r6 = r0;
                C00191 r7 = this;
            L25:
                DragEvent r9 = (DragEvent) r8;
                C00191 r10 = r7;
                r0 = r6;
                Ref.ObjectRef<DragEvent> r11 = r5;
                Function1 r12 = r4;
            L26:
                r11.element = r9;
            L9:
                Object r13 = r10.$event.element;
                if ((r13 instanceof DragEvent.DragStopped) == true) goto L28;
                if ((r13 instanceof DragEvent.DragCancelled) == true) goto L28;
                r9 = null;
                if ((r13 instanceof DragEvent.DragDelta) == false) goto L16;
                DragEvent.DragDelta r14 = (DragEvent.DragDelta) r13;
            L17:
                if (r14 == null) goto L19;
                r12.invoke(r14);
            L19:
                r11 = r10.$event;
                Channel r15 = DragGestureNode.access$getChannel$p(r10.this$0);
                if (r15 == null) goto L26;
                r10.L$0 = r12;
                r10.L$1 = r11;
                r10.label = 1;
                Object r16 = r15.receive(r10);
                if (r16 != r0) goto L24;
                return r0;
            L24:
                Object r17 = r0;
                r7 = r10;
                r8 = r16;
                r4 = r12;
                r5 = r11;
                r6 = r17;
                goto L25
            L16:
                r14 = null;
            L28:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r8);
                r12 = (Function1) this.L$0;
                r10 = this;
                goto L9
            }
        }

        public C01401(DragGestureNode r1, Continuation<? super C01401> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01401 r0 = new C01401(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f4 -> B:22:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00f9 -> B:22:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0108 -> B:22:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0121 -> B:22:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0125 -> B:22:0x0071). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L13;
                case 4: goto L10;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            CoroutineScope r1 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L11:
            C01401 r9 = this;
            CoroutineScope r4 = r1;
        L23:
            if (CoroutineScopeKt.isActive(r4) == false) goto L60;
            Ref.ObjectRef r2 = new Ref.ObjectRef();
            Channel r3 = DragGestureNode.access$getChannel$p(r9.this$0);
            if (r3 == null) goto L31;
            r9.L$0 = r4;
            r9.L$1 = r2;
            r9.L$2 = r2;
            r9.label = 1;
            Object r5 = r3.receive(r9);
            if (r5 != r0) goto L29;
            return r0;
        L29:
            CoroutineScope r6 = r4;
            Ref.ObjectRef r7 = r2;
            r0 = r0;
            C01401 r10 = r9;
            r8 = r5;
            Ref.ObjectRef r11 = r7;
        L30:
            DragEvent r12 = (DragEvent) r8;
        L32:
            r11.element = r12;
            Object r13 = r7.element;
            if ((r13 instanceof DragEvent.DragStarted) == false) goto L58;
            r10.L$0 = r6;
            r10.L$1 = r7;
            r10.L$2 = null;
            r10.label = 2;
            if (DragGestureNode.access$processDragStart(r10.this$0, (DragEvent.DragStarted) r13, r10) != r0) goto L37;
            return r0;
        L37:
            CoroutineScope r14 = r6;
        L61:
            DragGestureNode r15 = r10.this$0;     // Catch: CancellationException -> L53
            C00191 r16 = new C00191(r7, r15, null);     // Catch: CancellationException -> L53
            r10.L$0 = r14;     // Catch: CancellationException -> L53
            r10.L$1 = r7;     // Catch: CancellationException -> L53
            r10.label = 3;     // Catch: CancellationException -> L53
            if (r15.drag(r16, r10) != r0) goto L41;
            return r0;
        L41:
            r9 = r10;
            r0 = r0;
            Ref.ObjectRef r17 = r7;
        L16:
            r4 = r14;
            Object r18 = r17.element;     // Catch: CancellationException -> L52
            if ((r18 instanceof DragEvent.DragStopped) == false) goto L48;
            DragGestureNode r19 = r9.this$0;     // Catch: CancellationException -> L52
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");     // Catch: CancellationException -> L52
            r9.L$0 = r4;     // Catch: CancellationException -> L52
            r9.L$1 = null;     // Catch: CancellationException -> L52
            r9.label = 4;     // Catch: CancellationException -> L52
            if (DragGestureNode.access$processDragStop(r19, (DragEvent.DragStopped) r18, r9) != r0) goto L23;
            return r0;
        L48:
            if ((r18 instanceof DragEvent.DragCancelled) == false) goto L23;
            DragGestureNode r20 = r9.this$0;     // Catch: CancellationException -> L52
            r9.L$0 = r4;     // Catch: CancellationException -> L52
            r9.L$1 = null;     // Catch: CancellationException -> L52
            r9.label = 5;     // Catch: CancellationException -> L52
            if (DragGestureNode.access$processDragCancel(r20, r9) != r0) goto L23;
            return r0;
        L52:
            r0 = r0;
            r10 = r9;
        L54:
            DragGestureNode r21 = r10.this$0;
            r10.L$0 = r4;
            r10.L$1 = null;
            r10.label = 6;
            if (DragGestureNode.access$processDragCancel(r21, r10) != r0) goto L57;
            return r0;
        L57:
            r9 = r10;
            r0 = r0;
        L53:
            r4 = r14;
            goto L54
        L58:
            r9 = r10;
            r0 = r0;
            r4 = r6;
            goto L23
        L31:
            r11 = r2;
            r6 = r4;
            r0 = r0;
            r7 = r11;
            r10 = r9;
            r12 = null;
            goto L32
        L60:
            return Unit.INSTANCE;
        L7:
            r1 = (CoroutineScope) this.L$0;
        L67:
            ResultKt.throwOnFailure(r8);     // Catch: CancellationException -> L12
        L12:
            r4 = r1;
        L18:
            r10 = this;
            goto L54
        L10:
            r1 = (CoroutineScope) this.L$0;
            goto L67
        L13:
            r17 = (Ref.ObjectRef) this.L$1;
            r14 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);     // Catch: CancellationException -> L17
            r9 = this;
        L17:
            r4 = r14;
            goto L18
        L19:
            Ref.ObjectRef r22 = (Ref.ObjectRef) this.L$1;
            r14 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            r7 = r22;
            r0 = r0;
            r10 = this;
            goto L61
        L20:
            Ref.ObjectRef r23 = (Ref.ObjectRef) this.L$2;
            Ref.ObjectRef r24 = (Ref.ObjectRef) this.L$1;
            CoroutineScope r25 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            r6 = r25;
            r7 = r24;
            r11 = r23;
            r0 = r0;
            r10 = this;
            goto L30
        L21:
            ResultKt.throwOnFailure(r8);
            r4 = (CoroutineScope) this.L$0;
            r9 = this;
            goto L23
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ boolean a(DragGestureNode r0, PointerInputChange r1) {
        return _canDrag$lambda$0(r0, r1);
    }

    private final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C01401(this, null), 3, null);
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super Unit> r2);

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m589getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo543onDragStartedk4lQ0M(long r1);

    /* JADX INFO: renamed from: onDragStopped-TH1AsA0 */
    public abstract void mo544onDragStoppedTH1AsA0(long r1);

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    public abstract boolean startDragImmediately();

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(this));
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start r0 = this.dragInteraction;
        if (r0 == null) goto L9;
        MutableInteractionSource r1 = this.interactionSource;
        if (r1 == null) goto L7;
        r1.tryEmit(new DragInteraction.Cancel(r0));
    L7:
        this.dragInteraction = null;
        return;
    }

    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode r0 = this.pointerInputNode;
        if (r0 == null) goto L6;
        r0.onCancelPointerInput();
        return;
    }

    public final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public static final /* synthetic */ Channel access$getChannel$p(DragGestureNode r0) {
        return r0.channel;
    }

    public static final /* synthetic */ long access$getNodeOffset$p(DragGestureNode r2) {
        return r2.nodeOffset;
    }

    public static final /* synthetic */ Orientation access$getOrientationLock$p(DragGestureNode r0) {
        return r0.orientationLock;
    }

    public static final /* synthetic */ boolean access$isListeningForEvents$p(DragGestureNode r0) {
        return r0.isListeningForEvents;
    }

    public static final /* synthetic */ void access$startListeningForEvents(DragGestureNode r0) {
        r0.startListeningForEvents();
    }

    private final Object processDragCancel(Continuation<? super Unit> r6) {
        if ((r6 instanceof C01371) == false) goto L7;
        C01371 r0 = (C01371) r6;
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
    L21:
        this.dragInteraction = null;
    L22:
        mo544onDragStoppedTH1AsA0(Velocity.Companion.getZero-9UxMQ8M());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        DragInteraction.Start r8 = this.dragInteraction;
        if (r8 == null) goto L22;
        MutableInteractionSource r4 = this.interactionSource;
        if (r4 == null) goto L21;
        DragInteraction.Cancel r5 = new DragInteraction.Cancel(r8);
        r0.label = 1;
        if (r4.emit(r5, r0) != r2) goto L21;
        return r2;
    L7:
        r0 = new C01371(this, r6);
        goto L8
    }

    private static final boolean _canDrag$lambda$0(DragGestureNode r0, PointerInputChange r1) {
        return ((Boolean) r0.canDrag.invoke(r1)).booleanValue();
    }

    public static final /* synthetic */ Object access$processDragCancel(DragGestureNode r0, Continuation r1) {
        return r0.processDragCancel(r1);
    }

    public static final /* synthetic */ void access$setChannel$p(DragGestureNode r0, Channel r1) {
        r0.channel = r1;
    }

    public static final /* synthetic */ void access$setNodeOffset$p(DragGestureNode r0, long r1) {
        r0.nodeOffset = r1;
    }

    private final Object processDragStart(DragEvent.DragStarted r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C01381) == false) goto L7;
        C01381 r0 = (C01381) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        DragInteraction.Start r10 = (DragInteraction.Start) r0.L$1;
        DragEvent.DragStarted r4 = (DragEvent.DragStarted) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        DragInteraction.Start r11 = r10;
        r7 = r4;
    L30:
        this.dragInteraction = r11;
        mo543onDragStartedk4lQ0M(r7.m566getStartPointF1C5BW0());
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (DragEvent.DragStarted) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L23:
        r11 = new DragInteraction.Start();
        MutableInteractionSource r5 = this.interactionSource;
        if (r5 == null) goto L30;
        r0.L$0 = r7;
        r0.L$1 = r11;
        r0.label = 2;
        if (r5.emit(r11, r0) != r2) goto L28;
        return r2;
    L28:
        r4 = r7;
        r10 = r11;
        goto L29
    L16:
        ResultKt.throwOnFailure(r9);
        DragInteraction.Start r12 = this.dragInteraction;
        if (r12 == null) goto L23;
        MutableInteractionSource r6 = this.interactionSource;
        if (r6 == null) goto L23;
        DragInteraction.Cancel r13 = new DragInteraction.Cancel(r12);
        r0.L$0 = r7;
        r0.label = 1;
        if (r6.emit(r13, r0) != r2) goto L23;
        return r2;
    L7:
        r0 = new C01381(this, r8);
        goto L8
    }

    private final Object processDragStop(DragEvent.DragStopped r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C01391) == false) goto L7;
        C01391 r0 = (C01391) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (DragEvent.DragStopped) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        this.dragInteraction = null;
    L22:
        mo544onDragStoppedTH1AsA0(r6.m567getVelocity9UxMQ8M());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        DragInteraction.Start r9 = this.dragInteraction;
        if (r9 == null) goto L22;
        MutableInteractionSource r4 = this.interactionSource;
        if (r4 == null) goto L21;
        DragInteraction.Stop r5 = new DragInteraction.Stop(r9);
        r0.L$0 = r6;
        r0.label = 1;
        if (r4.emit(r5, r0) != r2) goto L21;
        return r2;
    L7:
        r0 = new C01391(this, r7);
        goto L8
    }

    public static final /* synthetic */ Object access$processDragStart(DragGestureNode r0, DragEvent.DragStarted r1, Continuation r2) {
        return r0.processDragStart(r1, r2);
    }

    public static final /* synthetic */ Object access$processDragStop(DragGestureNode r0, DragEvent.DragStopped r1, Continuation r2) {
        return r0.processDragStop(r1, r2);
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo590onPointerEventH0pRuoY(PointerEvent r2, PointerEventPass r3, long r4) {
        if (this.enabled == true) goto L5;
    L7:
        SuspendingPointerInputModifierNode r0 = this.pointerInputNode;
        if (r0 == null) goto L11;
        r0.onPointerEvent-H0pRuoY(r2, r3, r4);
        return;
    L11:
        return;
    L5:
        if (this.pointerInputNode != null) goto L7;
        this.pointerInputNode = delegate(initializePointerInputNode());
        goto L7
    }

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> r1, boolean r2, MutableInteractionSource r3, Orientation r4) {
        this.orientationLock = r4;
        this.canDrag = r1;
        this.enabled = r2;
        this.interactionSource = r3;
        this._canDrag = new e1(this);
        this.nodeOffset = Offset.Companion.getZero-F1C5BW0();
    }

    public final void update(Function1<? super PointerInputChange, Boolean> r2, boolean r3, MutableInteractionSource r4, Orientation r5, boolean r6) {
        this.canDrag = r2;
        boolean r0 = true;
        if (this.enabled == r3) goto L12;
        this.enabled = r3;
        if (r3 == true) goto L10;
        disposeInteractionSource();
        SuspendingPointerInputModifierNode r7 = this.pointerInputNode;
        if (r7 == null) goto L9;
        undelegate(r7);
    L9:
        this.pointerInputNode = null;
    L10:
        r6 = true;
    L12:
        if (Intrinsics.areEqual(this.interactionSource, r4) == true) goto L15;
        disposeInteractionSource();
        this.interactionSource = r4;
    L15:
        if (this.orientationLock == r5) goto L17;
        this.orientationLock = r5;
    L18:
        if (r0 == false) goto L23;
        SuspendingPointerInputModifierNode r8 = this.pointerInputNode;
        if (r8 == null) goto L24;
        r8.resetPointerInputHandler();
        return;
    L24:
        return;
    L23:
        return;
    L17:
        r0 = r6;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void update$default(DragGestureNode r3, Function1 r4, boolean r5, MutableInteractionSource r6, Orientation r7, boolean r8, int r9, Object r10) {
        if (r10 != null) goto L22;
        if ((r9 & 1) == 0) goto L7;
        r4 = r3.canDrag;
    L7:
        if ((r9 & 2) == 0) goto L9;
        r5 = r3.enabled;
    L9:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L12;
        r6 = r3.interactionSource;
    L12:
        MutableInteractionSource r0 = r6;
        if ((r9 & 8) == 0) goto L15;
        r7 = r3.orientationLock;
    L15:
        Orientation r1 = r7;
        if ((r9 & 16) == 0) goto L18;
        boolean r2 = false;
    L19:
        r3.update(r4, r11, r0, r1, r2);
        return;
    L18:
        r2 = r8;
        goto L19
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
    }
}
