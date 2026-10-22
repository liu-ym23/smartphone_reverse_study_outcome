package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008b\u0001\u0010\t\u001a\u00020\u0005*\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0005*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017\u001a[\u0010\u0018\u001a\u00020\u0005*\u00020\n2/\b\u0002\u0010\u000e\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001a\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 \u001a&\u0010!\u001a\u00020\u0015*\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010 \u001a\u001e\u0010\"\u001a\u00020\u001c*\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010$\u001a\u00020\u001cH\u0000\u001a\u0014\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u0012H\u0087@¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(*\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0080@¢\u0006\u0002\u0010&\u001aL\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u0002072\b\b\u0002\u0010:\u001a\u0002022'\u0010;\u001a#\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060<¢\u0006\u0002\b\u0007H\u0002¢\u0006\u0002\u0010=\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"*\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\"\u001a\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u00105¨\u0006>"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "detectTapGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDoubleTap", "Lkotlin/Function1;", "onLongPress", "onPress", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstDown", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPrimaryFirstDown", "isChangedToDown", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onlyPrimaryMouseButton", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForLongPress", "Landroidx/compose/foundation/gestures/LongPressResult;", "value", "DetectTapGesturesEnableNewDispatchingBehavior", "getDetectTapGesturesEnableNewDispatchingBehavior$annotations", "()V", "getDetectTapGesturesEnableNewDispatchingBehavior", "()Z", "setDetectTapGesturesEnableNewDispatchingBehavior", "(Z)V", "coroutineStartForCurrentDispatchBehavior", "Lkotlinx/coroutines/CoroutineStart;", "getCoroutineStartForCurrentDispatchBehavior$annotations", "getCoroutineStartForCurrentDispatchBehavior", "()Lkotlinx/coroutines/CoroutineStart;", "launchAwaitingReset", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "resetJob", "start", "block", "Lkotlin/Function2;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TapGestureDetectorKt {
    private static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = null;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {291}, m = "awaitFirstDown", n = {"$this$awaitFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TapGestureDetectorKt.awaitFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {304}, m = "awaitPrimaryFirstDown", n = {"$this$awaitPrimaryFirstDown", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TapGestureDetectorKt.awaitPrimaryFirstDown(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"})
    public static final class C01542 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
        final /* synthetic */ PointerInputChange $firstUp;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public C01542(PointerInputChange r1, Continuation<? super C01542> r2) {
            this.$firstUp = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01542 r0 = new C01542(this.$firstUp, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super PointerInputChange> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:13:0x0052). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r3 = this.J$0;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            long r9 = r3;
            AwaitPointerEventScope r4 = r2;
            Object r5 = r0;
            C01542 r6 = this;
        L13:
            PointerInputChange r14 = (PointerInputChange) r13;
            if (r14.getUptimeMillis() < r9) goto L16;
            return r14;
        L16:
            C01542 r15 = r6;
            r0 = r5;
            AwaitPointerEventScope r7 = r4;
        L9:
            r15.L$0 = r7;
            r15.J$0 = r9;
            r15.label = 1;
            Object r8 = TapGestureDetectorKt.awaitFirstDown$default(r7, false, null, r15, 3, null);
            if (r8 != r0) goto L12;
            return r0;
        L12:
            Object r11 = r0;
            r6 = r15;
            r13 = r8;
            r4 = r7;
            r5 = r11;
            goto L13
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            AwaitPointerEventScope r16 = (AwaitPointerEventScope) this.L$0;
            long r10 = this.$firstUp.getUptimeMillis() + r16.getViewConfiguration().getDoubleTapMinTimeMillis();
            r7 = r16;
            r9 = r10;
            r15 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {209}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"})
    public static final class C01551 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01551(Continuation<? super C01551> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TapGestureDetectorKt.access$consumeUntilUp(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ PointerInputScope $this_detectTapAndPress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {0, 0, 1}, l = {251, 257}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "resetJob", "resetJob"}, s = {"L$0", "L$1", "L$0"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C00201(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r1, PressGestureScopeImpl r2, PointerInputChange r3, Continuation<? super C00201> r4) {
                    this.$onPress = r1;
                    this.$pressScope = r2;
                    this.$down = r3;
                    super(2, r4);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    return new C00201(this.$onPress, this.$pressScope, this.$down, r5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
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
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r7 = this.$onPress;
                    PressGestureScopeImpl r2 = this.$pressScope;
                    Offset r3 = Offset.box-impl(this.$down.getPosition-F1C5BW0());
                    this.label = 1;
                    if (r7.invoke(r2, r3, this) != r0) goto L12;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public C00212(PressGestureScopeImpl r1, Continuation<? super C00212> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new C00212(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass3(PressGestureScopeImpl r1, Continuation<? super AnonymousClass3> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass3(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineScope r1, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r2, Function1<? super Offset, Unit> r3, PressGestureScopeImpl r4, Continuation<? super AnonymousClass1> r5) {
                this.$$this$coroutineScope = r1;
                this.$onPress = r2;
                this.$onTap = r3;
                this.$pressScope = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                AnonymousClass1 r6 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onTap, this.$pressScope, r9);
                r6.L$0 = r8;
                return r6;
            }

            public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r13) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                Job r2 = (Job) this.L$0;
                ResultKt.throwOnFailure(r13);
                Job r6 = r2;
            L21:
                PointerInputChange r14 = (PointerInputChange) r13;
                if (r14 != null) goto L24;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r6, null, new C00212(this.$pressScope, null), 2, null);
            L28:
                return Unit.INSTANCE;
            L24:
                r14.consume();
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r6, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                Function1<Offset, Unit> r3 = this.$onTap;
                if (r3 == null) goto L28;
                r3.invoke(Offset.box-impl(r14.getPosition-F1C5BW0()));
                goto L28
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                Job r4 = (Job) this.L$1;
                AwaitPointerEventScope r5 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r13);
                AwaitPointerEventScope r11 = r5;
            L14:
                PointerInputChange r15 = (PointerInputChange) r13;
                r15.consume();
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L17;
                CoroutineScope r7 = this.$$this$coroutineScope;
                C00201 r8 = new C00201(this.$onPress, this.$pressScope, r15, null);
                TapGestureDetectorKt.launchAwaitingReset$default(r7, r4, null, r8, 2, null);
            L17:
                this.L$0 = r4;
                this.L$1 = null;
                this.label = 2;
                r13 = TapGestureDetectorKt.waitForUpOrCancellation$default(r11, null, this, 1, null);
                if (r13 != r0) goto L20;
                return r0;
            L20:
                r6 = r4;
                goto L21
            L10:
                ResultKt.throwOnFailure(r13);
                AwaitPointerEventScope r16 = (AwaitPointerEventScope) this.L$0;
                r4 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapAndPress$2$1$resetJob$1(this.$pressScope, null), 1, null);
                this.L$0 = r16;
                this.L$1 = r4;
                this.label = 1;
                Object r9 = TapGestureDetectorKt.awaitFirstDown$default(r16, false, null, this, 3, null);
                if (r9 != r0) goto L13;
                return r0;
            L13:
                r11 = r16;
                r13 = r9;
                goto L14
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01562(PointerInputScope r1, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r2, Function1<? super Offset, Unit> r3, PressGestureScopeImpl r4, Continuation<? super C01562> r5) {
            this.$this_detectTapAndPress = r1;
            this.$onPress = r2;
            this.$onTap = r3;
            this.$pressScope = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01562 r6 = new C01562(this.$this_detectTapAndPress, this.$onPress, this.$onTap, this.$pressScope, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            PointerInputScope r11 = this.$this_detectTapAndPress;
            AnonymousClass1 r2 = new AnonymousClass1(r4, this.$onPress, this.$onTap, this.$pressScope, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(r11, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PointerInputScope $this_detectTapGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7}, l = {105, 116, 119, 122, 149, 167, 169, 180}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "resetJob", "$this$awaitEachGesture", "down", "resetJob", "resetJob", "$this$awaitEachGesture", "upOrCancel", "cancelOrReleaseJob", "resetJob", "upOrCancel", "$this$awaitEachGesture", "resetJob", "upOrCancel", "secondDown", "resetJob"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onLongPress;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputChange $down;
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C00221(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r1, PressGestureScopeImpl r2, PointerInputChange r3, Continuation<? super C00221> r4) {
                    this.$onPress = r1;
                    this.$pressScope = r2;
                    this.$down = r3;
                    super(2, r4);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    return new C00221(this.$onPress, this.$pressScope, this.$down, r5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
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
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r7 = this.$onPress;
                    PressGestureScopeImpl r2 = this.$pressScope;
                    Offset r3 = Offset.box-impl(this.$down.getPosition-F1C5BW0());
                    this.label = 1;
                    if (r7.invoke(r2, r3, this) != r0) goto L12;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00232 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public C00232(PressGestureScopeImpl r1, Continuation<? super C00232> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new C00232(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass3(PressGestureScopeImpl r1, Continuation<? super AnonymousClass3> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass3(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass4(PressGestureScopeImpl r1, Continuation<? super AnonymousClass4> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass4(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", i = {}, l = {157, 158}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Job $cancelOrReleaseJob;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass5(Job r1, PressGestureScopeImpl r2, Continuation<? super AnonymousClass5> r3) {
                    this.$cancelOrReleaseJob = r1;
                    this.$pressScope = r2;
                    super(2, r3);
                }

                public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                    return new AnonymousClass5(this.$cancelOrReleaseJob, this.$pressScope, r4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r5) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L10;
                    if (r1 == 1) goto L9;
                    if (r1 != 2) goto L8;
                    ResultKt.throwOnFailure(r5);
                L17:
                    return Unit.INSTANCE;
                L8:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    ResultKt.throwOnFailure(r5);
                L13:
                    PressGestureScopeImpl r6 = this.$pressScope;
                    this.label = 2;
                    if (r6.reset(this) != r0) goto L17;
                    return r0;
                L10:
                    ResultKt.throwOnFailure(r5);
                    Job r7 = this.$cancelOrReleaseJob;
                    this.label = 1;
                    if (r7.join(this) != r0) goto L13;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                final /* synthetic */ PointerInputChange $secondDown;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass6(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r1, PressGestureScopeImpl r2, PointerInputChange r3, Continuation<? super AnonymousClass6> r4) {
                    this.$onPress = r1;
                    this.$pressScope = r2;
                    this.$secondDown = r3;
                    super(2, r4);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    return new AnonymousClass6(this.$onPress, this.$pressScope, this.$secondDown, r5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
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
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> r7 = this.$onPress;
                    PressGestureScopeImpl r2 = this.$pressScope;
                    Offset r3 = Offset.box-impl(this.$secondDown.getPosition-F1C5BW0());
                    this.label = 1;
                    if (r7.invoke(r2, r3, this) != r0) goto L12;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass7(PressGestureScopeImpl r1, Continuation<? super AnonymousClass7> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass7(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                public AnonymousClass8(PressGestureScopeImpl r1, Continuation<? super AnonymousClass8> r2) {
                    this.$pressScope = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new AnonymousClass8(this.$pressScope, r3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r2) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) goto L7;
                    ResultKt.throwOnFailure(r2);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineScope r1, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r2, Function1<? super Offset, Unit> r3, Function1<? super Offset, Unit> r4, Function1<? super Offset, Unit> r5, PressGestureScopeImpl r6, Continuation<? super AnonymousClass1> r7) {
                this.$$this$coroutineScope = r1;
                this.$onPress = r2;
                this.$onLongPress = r3;
                this.$onDoubleTap = r4;
                this.$onTap = r5;
                this.$pressScope = r6;
                super(2, r7);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                AnonymousClass1 r8 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, r11);
                r8.L$0 = r10;
                return r8;
            }

            public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r24) {
                Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: goto L15;
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    case 8: goto L6;
                    default: goto L5;
                };
            L6:
                Job r0 = (Job) this.L$0;
                ResultKt.throwOnFailure(r24);
                Job r11 = r0;
            L82:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r11, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                return Unit.INSTANCE;
            L7:
                PointerInputChange r1 = (PointerInputChange) this.L$3;
                PointerInputChange r2 = (PointerInputChange) this.L$2;
                Job r3 = (Job) this.L$1;
                AwaitPointerEventScope r4 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r24);
                Object r5 = r24;
            L76:
                LongPressResult r6 = (LongPressResult) r5;
                if (Intrinsics.areEqual(r6, LongPressResult.Success.INSTANCE) == false) goto L85;
                this.$onLongPress.invoke(Offset.box-impl(r1.getPosition-F1C5BW0()));
                this.L$0 = r3;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 8;
                if (TapGestureDetectorKt.access$consumeUntilUp(r4, this) != r7) goto L81;
                return r7;
            L81:
                r11 = r3;
                goto L82
            L85:
                if ((r6 instanceof LongPressResult.Released) == false) goto L88;
                Job r12 = r3;
                PointerInputChange r8 = ((LongPressResult.Released) r6).getFinalUpChange();
                PointerInputChange r9 = r2;
            L90:
                if (r8 == null) goto L92;
                r8.consume();
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r12, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                this.$onDoubleTap.invoke(Offset.box-impl(r8.getPosition-F1C5BW0()));
            L98:
                return Unit.INSTANCE;
            L92:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r12, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                Function1<Offset, Unit> r10 = this.$onTap;
                if (r10 == null) goto L98;
                r10.invoke(Offset.box-impl(r9.getPosition-F1C5BW0()));
                goto L98
            L88:
                if ((r6 instanceof LongPressResult.Canceled) == false) goto L96;
                r9 = r2;
                r12 = r3;
                r8 = null;
                goto L90
            L96:
                throw new NoWhenBranchMatchedException();
            L8:
                r9 = (PointerInputChange) this.L$1;
                Job r13 = (Job) this.L$0;
                ResultKt.throwOnFailure(r24);
                Object r14 = r24;
            L71:
                r8 = (PointerInputChange) r14;
                r12 = r13;
                goto L90
            L9:
                Job r15 = (Job) this.L$2;
                r2 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope r16 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r24);
                Object r17 = r24;
            L57:
                PointerInputChange r18 = (PointerInputChange) r17;
                if (r18 != null) goto L62;
                Function1<Offset, Unit> r19 = this.$onTap;
                if (r19 == null) goto L98;
                r19.invoke(Offset.box-impl(r2.getPosition-F1C5BW0()));
                goto L98
            L62:
                Job r20 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new AnonymousClass5(r15, this.$pressScope, null), 1, null);
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L66;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r20, null, new AnonymousClass6(this.$onPress, this.$pressScope, r18, null), 2, null);
            L66:
                if (this.$onLongPress != null) goto L72;
                this.L$0 = r20;
                this.L$1 = r2;
                this.L$2 = null;
                this.label = 6;
                r14 = TapGestureDetectorKt.waitForUpOrCancellation$default(r16, null, this, 1, null);
                if (r14 != r7) goto L70;
                return r7;
            L70:
                PointerInputChange r22 = r2;
                r13 = r20;
                r9 = r22;
                goto L71
            L72:
                this.L$0 = r16;
                this.L$1 = r20;
                this.L$2 = r2;
                this.L$3 = r18;
                this.label = 7;
                r5 = TapGestureDetectorKt.waitForLongPress$default(r16, null, this, 1, null);
                if (r5 != r7) goto L75;
                return r7;
            L75:
                AwaitPointerEventScope r23 = r16;
                r3 = r20;
                r1 = r18;
                r4 = r23;
                goto L76
            L10:
                Job r21 = (Job) this.L$0;
                ResultKt.throwOnFailure(r24);
            L37:
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r21, null, new C00232(this.$pressScope, null), 2, null);
                return Unit.INSTANCE;
            L12:
                r21 = (Job) this.L$2;
                PointerInputChange r25 = (PointerInputChange) this.L$1;
                r16 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r24);
                Object r26 = r24;
            L32:
                LongPressResult r27 = (LongPressResult) r26;
                if (Intrinsics.areEqual(r27, LongPressResult.Success.INSTANCE) == false) goto L40;
                this.$onLongPress.invoke(Offset.box-impl(r25.getPosition-F1C5BW0()));
                this.L$0 = r21;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 4;
                if (TapGestureDetectorKt.access$consumeUntilUp(r16, this) != r7) goto L37;
                return r7;
            L40:
                if ((r27 instanceof LongPressResult.Released) == false) goto L43;
                r2 = ((LongPressResult.Released) r27).getFinalUpChange();
            L28:
                Job r110 = r21;
                if (r2 != null) goto L47;
                r15 = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r110, null, new AnonymousClass3(this.$pressScope, null), 2, null);
            L48:
                if (r2 == null) goto L98;
                if (this.$onDoubleTap != null) goto L54;
                Function1<Offset, Unit> r28 = this.$onTap;
                if (r28 == null) goto L98;
                r28.invoke(Offset.box-impl(r2.getPosition-F1C5BW0()));
                goto L98
            L54:
                this.L$0 = r16;
                this.L$1 = r2;
                this.L$2 = r15;
                this.label = 5;
                r17 = TapGestureDetectorKt.access$awaitSecondDown(r16, r2, this);
                if (r17 != r7) goto L57;
                return r7;
            L47:
                r2.consume();
                r15 = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r110, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                goto L48
            L43:
                if ((r27 instanceof LongPressResult.Canceled) == false) goto L100;
                r2 = null;
                goto L28
            L100:
                throw new NoWhenBranchMatchedException();
            L13:
                r21 = (Job) this.L$1;
                AwaitPointerEventScope r29 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r24);
                r16 = r29;
                Object r30 = r24;
            L27:
                r2 = (PointerInputChange) r30;
                goto L28
            L14:
                AwaitPointerEventScope r31 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(r24);
                r16 = r31;
                Object r32 = r24;
            L19:
                r25 = (PointerInputChange) r32;
                r25.consume();
                r21 = BuildersKt.launch$default(this.$$this$coroutineScope, null, TapGestureDetectorKt.access$getCoroutineStartForCurrentDispatchBehavior(), new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, null);
                if (this.$onPress == TapGestureDetectorKt.access$getNoPressGesture$p()) goto L23;
                TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, r21, null, new C00221(this.$onPress, this.$pressScope, r25, null), 2, null);
            L23:
                if (this.$onLongPress != null) goto L29;
                this.L$0 = r16;
                this.L$1 = r21;
                this.label = 2;
                r30 = TapGestureDetectorKt.waitForUpOrCancellation$default(r16, null, this, 1, null);
                if (r30 != r7) goto L27;
                return r7;
            L29:
                this.L$0 = r16;
                this.L$1 = r25;
                this.L$2 = r21;
                this.label = 3;
                r26 = TapGestureDetectorKt.waitForLongPress$default(r16, null, this, 1, null);
                if (r26 != r7) goto L32;
                return r7;
            L15:
                ResultKt.throwOnFailure(r24);
                AwaitPointerEventScope r111 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = r111;
                this.label = 1;
                r32 = TapGestureDetectorKt.awaitFirstDown$default(r111, false, null, this, 3, null);
                if (r32 != r7) goto L18;
                return r7;
            L18:
                r16 = r111;
                goto L19
            L5:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01572(PointerInputScope r1, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r2, Function1<? super Offset, Unit> r3, Function1<? super Offset, Unit> r4, Function1<? super Offset, Unit> r5, Continuation<? super C01572> r6) {
            this.$this_detectTapGestures = r1;
            this.$onPress = r2;
            this.$onLongPress = r3;
            this.$onDoubleTap = r4;
            this.$onTap = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C01572 r7 = new C01572(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            PressGestureScopeImpl r9 = new PressGestureScopeImpl(this.$this_detectTapGestures);
            PointerInputScope r13 = this.$this_detectTapGestures;
            AnonymousClass1 r2 = new AnonymousClass1(r4, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, r9, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(r13, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$launchAwaitingReset$1", f = "TapGestureDetector.kt", i = {0}, l = {498, 500}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C01581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Job $resetJob;
        private /* synthetic */ Object L$0;
        int label;

        public C01581(Job r1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C01581> r3) {
            this.$resetJob = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01581 r0 = new C01581(this.$resetJob, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r5);
        L15:
            Function2<CoroutineScope, Continuation<? super Unit>, Object> r6 = this.$block;
            this.L$0 = null;
            this.label = 2;
            if (r6.invoke(r2, this) != r0) goto L19;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            r2 = (CoroutineScope) this.L$0;
            if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled == false) goto L15;
            Job r7 = this.$resetJob;
            this.L$0 = r2;
            this.label = 1;
            if (r7.join(this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {384}, m = "waitForLongPress", n = {"result"}, s = {"L$0"})
    public static final class C01591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01591(Continuation<? super C01591> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TapGestureDetectorKt.waitForLongPress(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {386, 409}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"})
    public static final class C01602 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerEventPass $pass;
        final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
        private /* synthetic */ Object L$0;
        int label;

        public C01602(PointerEventPass r1, Ref.ObjectRef<LongPressResult> r2, Continuation<? super C01602> r3) {
            this.$pass = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01602 r0 = new C01602(this.$pass, this.$result, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d4 -> B:46:0x00d7). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r15);
            C01602 r5 = this;
        L46:
            List r16 = ((PointerEvent) r15).getChanges();
            int r6 = r16.size();
            int r7 = 0;
        L47:
            if (r7 >= r6) goto L52;
            if (((PointerInputChange) ListProtector.get(r16, r7)).isConsumed() == true) goto L50;
            r7 = r7 + 1;
            goto L47
        L50:
            boolean r17 = true;
        L53:
            if (r17 == false) goto L57;
            Ref.ObjectRef<LongPressResult> r18 = r5.$result;
            r18.element = LongPressResult.Canceled.INSTANCE;
        L56:
            return Unit.INSTANCE;
        L57:
            AwaitPointerEventScope r19 = r2;
            C01602 r3 = r5;
        L11:
            PointerEventPass r8 = r3.$pass;
            r3.L$0 = r19;
            r3.label = 1;
            Object r9 = r19.awaitPointerEvent(r8, r3);
            if (r9 != r0) goto L14;
            return r0;
        L14:
            AwaitPointerEventScope r10 = r19;
            r15 = r9;
        L15:
            PointerEvent r110 = (PointerEvent) r15;
            List r11 = r110.getChanges();
            int r12 = r11.size();
            int r13 = 0;
        L16:
            if (r13 >= r12) goto L21;
            if (PointerEventKt.changedToUp((PointerInputChange) ListProtector.get(r11, r13)) == false) goto L19;
            r13 = r13 + 1;
            goto L16
        L19:
            boolean r14 = false;
        L22:
            if (r14 == false) goto L25;
            Ref.ObjectRef<LongPressResult> r4 = r3.$result;
            r4.element = new LongPressResult.Released((PointerInputChange) ListProtector.get(r110.getChanges(), 0));
            goto L56
        L25:
            if (TapGestureDetector_androidKt.isDeepPress(r110) == false) goto L27;
            Ref.ObjectRef<LongPressResult> r111 = r3.$result;
            r111.element = LongPressResult.Success.INSTANCE;
            goto L56
        L27:
            List r112 = r110.getChanges();
            int r20 = r112.size();
            int r21 = 0;
        L28:
            if (r21 >= r20) goto L39;
            PointerInputChange r22 = (PointerInputChange) ListProtector.get(r112, r21);
            if (r22.isConsumed() == false) goto L32;
        L35:
            boolean r23 = true;
        L36:
            if (r23 == true) goto L37;
            r21 = r21 + 1;
            goto L28
        L37:
            boolean r113 = true;
        L40:
            if (r113 == false) goto L42;
            Ref.ObjectRef<LongPressResult> r114 = r3.$result;
            r114.element = LongPressResult.Canceled.INSTANCE;
            goto L56
        L42:
            PointerEventPass r115 = PointerEventPass.Final;
            r3.L$0 = r10;
            r3.label = 2;
            r15 = r10.awaitPointerEvent(r115, r3);
            if (r15 != r0) goto L45;
            return r0;
        L45:
            AwaitPointerEventScope r116 = r10;
            r5 = r3;
            r2 = r116;
            goto L46
        L32:
            if (PointerEventKt.isOutOfBounds-jwHxaWs(r22, r10.getSize-YbymL2g(), r10.getExtendedTouchPadding-NH-jbRc()) == true) goto L35;
            r23 = false;
            goto L36
        L39:
            r113 = false;
            goto L40
        L21:
            r14 = true;
            goto L22
        L52:
            r17 = false;
            goto L53
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AwaitPointerEventScope r24 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r15);
            r10 = r24;
            r3 = this;
            goto L15
        L10:
            ResultKt.throwOnFailure(r15);
            r19 = (AwaitPointerEventScope) this.L$0;
            r3 = this;
            goto L11
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 1, 1}, l = {352, 366}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C01612 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01612(Continuation<? super C01612> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TapGestureDetectorKt.waitForUpOrCancellation(null, null, this);
        }
    }

    private static /* synthetic */ void getCoroutineStartForCurrentDispatchBehavior$annotations() {
    }

    @Deprecated(message = "This flag has been moved to ComposeFoundationFlags and renamed to isDetectTapGesturesImmediateCoroutineDispatchEnabled. For compatibility,  DetectTapGesturesEnableNewDispatchingBehavior controls the new flag (isDetectTapGesturesImmediateCoroutineDispatchEnabled). Please use  isDetectTapGesturesImmediateCoroutineDispatchEnabled instead.", replaceWith = @ReplaceWith(expression = "isDetectTapGesturesImmediateCoroutineDispatchEnabled", imports = {"androidx.compose.foundation.ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled"}))
    public static /* synthetic */ void getDetectTapGesturesEnableNewDispatchingBehavior$annotations() {
    }

    static {
        NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);
    }

    private static final CoroutineStart getCoroutineStartForCurrentDispatchBehavior() {
        if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled == false) goto L6;
        return CoroutineStart.UNDISPATCHED;
    L6:
        return CoroutineStart.DEFAULT;
    }

    public static final /* synthetic */ CoroutineStart access$getCoroutineStartForCurrentDispatchBehavior() {
        return getCoroutineStartForCurrentDispatchBehavior();
    }

    public static final /* synthetic */ Function3 access$getNoPressGesture$p() {
        return NoPressGesture;
    }

    public static final boolean getDetectTapGesturesEnableNewDispatchingBehavior() {
        return ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled;
    }

    public static final void setDetectTapGesturesEnableNewDispatchingBehavior(boolean r0) {
        ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled = r0;
    }

    public static final /* synthetic */ Object access$consumeUntilUp(AwaitPointerEventScope r0, Continuation r1) {
        return consumeUntilUp(r0, r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    private static final Object consumeUntilUp(AwaitPointerEventScope r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof C01551) == false) goto L7;
        C01551 r0 = (C01551) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        PointerEvent r11 = (PointerEvent) r10;
        List r4 = r11.getChanges();
        int r5 = r4.size();
        boolean r6 = false;
        int r7 = 0;
    L19:
        if (r7 >= r5) goto L21;
        ((PointerInputChange) ListProtector.get(r4, r7)).consume();
        r7 = r7 + 1;
        goto L19
    L21:
        List r12 = r11.getChanges();
        int r13 = r12.size();
        int r14 = 0;
    L22:
        if (r14 >= r13) goto L27;
        if (((PointerInputChange) ListProtector.get(r12, r14)).getPressed() == true) goto L25;
        r14 = r14 + 1;
        goto L22
    L25:
        r6 = true;
    L27:
        if (r6 == false) goto L29;
    L15:
        r0.L$0 = r8;
        r0.label = 1;
        r10 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r8, null, r0, 1, null);
        if (r10 != r2) goto L18;
        return r2;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
    L7:
        r0 = new C01551(r9);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object waitForUpOrCancellation(AwaitPointerEventScope r1, Continuation r2) {
        return waitForUpOrCancellation(r1, PointerEventPass.Main, r2);
    }

    public static final /* synthetic */ Object access$awaitSecondDown(AwaitPointerEventScope r0, PointerInputChange r1, Continuation r2) {
        return awaitSecondDown(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with PointerEventPass instead.")
    public static final /* synthetic */ Object awaitFirstDown(AwaitPointerEventScope r1, boolean r2, Continuation r3) {
        return awaitFirstDown(r1, r2, PointerEventPass.Main, r3);
    }

    private static final Object awaitSecondDown(AwaitPointerEventScope r4, PointerInputChange r5, Continuation<? super PointerInputChange> r6) {
        return r4.withTimeoutOrNull(r4.getViewConfiguration().getDoubleTapTimeoutMillis(), new C01542(r5, null), r6);
    }

    public static final boolean isChangedToDown(PointerEvent r6, boolean r7, boolean r8) {
        if (r8 == false) goto L13;
        List r9 = r6.getChanges();
        int r2 = r9.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        if (PointerType.equals-impl0(((PointerInputChange) ListProtector.get(r9, r3)).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA()) == false) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        boolean r10 = false;
    L11:
        if (r10 == false) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
    L18:
        List r12 = r6.getChanges();
        int r13 = r12.size();
        int r4 = 0;
    L19:
        if (r4 >= r13) goto L32;
        PointerInputChange r5 = (PointerInputChange) ListProtector.get(r12, r4);
        if (r7 == false) goto L23;
        boolean r14 = PointerEventKt.changedToDown(r5);
    L24:
        if (r14 == false) goto L25;
        r4 = r4 + 1;
        goto L19
    L25:
        return false;
    L23:
        r14 = PointerEventKt.changedToDownIgnoreConsumed(r5);
        goto L24
    L32:
        return true;
    L16:
        if (PointerEvent_androidKt.isPrimaryPressed-aHzCx-E(r6.getButtons-ry648PA()) == true) goto L18;
        return false;
    L10:
        r10 = true;
    L13:
        r11 = false;
        goto L14
    }

    public static final Object waitForLongPress(AwaitPointerEventScope r7, PointerEventPass r8, Continuation<? super LongPressResult> r9) {
        if ((r9 instanceof C01591) == false) goto L7;
        C01591 r0 = (C01591) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        Ref.ObjectRef r11 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: PointerEventTimeoutCancellationException -> L23
    L21:
        return r11.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = LongPressResult.Canceled.INSTANCE;
        long r4 = r7.getViewConfiguration().getLongPressTimeoutMillis();     // Catch: PointerEventTimeoutCancellationException -> L23
        C01602 r5 = new C01602(r8, r12, null);     // Catch: PointerEventTimeoutCancellationException -> L23
        r0.L$0 = r12;     // Catch: PointerEventTimeoutCancellationException -> L23
        r0.label = 1;     // Catch: PointerEventTimeoutCancellationException -> L23
        if (r7.withTimeout(r4, r5, r0) != r2) goto L20;
        return r2;
    L20:
        r11 = r12;
    L24:
        return LongPressResult.Success.INSTANCE;
    L7:
        r0 = new C01591(r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e4 -> B:13:0x0037). Please report as a decompilation issue!!! */
    public static final Object waitForUpOrCancellation(AwaitPointerEventScope r18, PointerEventPass r19, Continuation<? super PointerInputChange> r20) {
        if ((r20 instanceof C01612) == false) goto L7;
        C01612 r1 = (C01612) r20;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L16;
        if (r4 != 2) goto L15;
        PointerEventPass r5 = (PointerEventPass) r1.L$1;
        AwaitPointerEventScope r8 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L13:
        Object r16 = r3;
        C01612 r6 = r1;
        PointerEventPass r7 = r5;
        Object r9 = r16;
        List r10 = ((PointerEvent) r0).getChanges();
        int r11 = r10.size();
        int r12 = 0;
    L51:
        if (r12 >= r11) goto L56;
        if (((PointerInputChange) ListProtector.get(r10, r12)).isConsumed() == true) goto L54;
        r12 = r12 + 1;
        goto L51
    L54:
        boolean r13 = true;
    L57:
        if (r13 == false) goto L59;
        return null;
    L59:
        AwaitPointerEventScope r14 = r8;
    L18:
        r6.L$0 = r14;
        r6.L$1 = r7;
        r6.label = 1;
        Object r15 = r14.awaitPointerEvent(r7, r6);
        if (r15 != r9) goto L21;
        return r9;
    L21:
        r8 = r14;
        r0 = r15;
        Object r17 = r9;
        r5 = r7;
        r1 = r6;
        r3 = r17;
    L22:
        PointerEvent r21 = (PointerEvent) r0;
        List r22 = r21.getChanges();
        int r110 = r22.size();
        int r111 = 0;
    L23:
        if (r111 >= r110) goto L28;
        if (PointerEventKt.changedToUp((PointerInputChange) ListProtector.get(r22, r111)) == false) goto L26;
        r111 = r111 + 1;
        goto L23
    L26:
        boolean r23 = false;
    L29:
        if (r23 == true) goto L31;
        List r24 = r21.getChanges();
        int r25 = r24.size();
        int r112 = 0;
    L33:
        if (r112 >= r25) goto L44;
        PointerInputChange r113 = (PointerInputChange) ListProtector.get(r24, r112);
        if (r113.isConsumed() == false) goto L37;
    L40:
        boolean r114 = true;
    L41:
        if (r114 == true) goto L42;
        r112 = r112 + 1;
        goto L33
    L42:
        boolean r26 = true;
    L45:
        if (r26 == false) goto L47;
        return null;
    L47:
        PointerEventPass r27 = PointerEventPass.Final;
        r1.L$0 = r8;
        r1.L$1 = r5;
        r1.label = 2;
        r0 = r8.awaitPointerEvent(r27, r1);
        if (r0 != r3) goto L13;
        return r3;
    L37:
        if (PointerEventKt.isOutOfBounds-jwHxaWs(r113, r8.getSize-YbymL2g(), r8.getExtendedTouchPadding-NH-jbRc()) == true) goto L40;
        r114 = false;
        goto L41
    L44:
        r26 = false;
        goto L45
    L31:
        return ListProtector.get(r21.getChanges(), 0);
    L28:
        r23 = true;
        goto L29
    L56:
        r13 = false;
        goto L57
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r5 = (PointerEventPass) r1.L$1;
        r8 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L22
    L17:
        ResultKt.throwOnFailure(r0);
        r14 = r18;
        r9 = r3;
        r6 = r1;
        r7 = r19;
    L7:
        r1 = new C01612(r20);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    public static final Object awaitFirstDown(AwaitPointerEventScope r7, boolean r8, PointerEventPass r9, Continuation<? super PointerInputChange> r10) {
        if ((r10 instanceof AnonymousClass2) == false) goto L7;
        AnonymousClass2 r0 = (AnonymousClass2) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r12 = r0.Z$0;
        PointerEventPass r13 = (PointerEventPass) r0.L$1;
        AwaitPointerEventScope r14 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r8 = r12;
        r7 = r14;
        r9 = r13;
    L18:
        PointerEvent r15 = (PointerEvent) r11;
        if (isChangedToDown$default(r15, r8, false, 2, null) == true) goto L21;
    L15:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.Z$0 = r8;
        r0.label = 1;
        r11 = r7.awaitPointerEvent(r9, r0);
        if (r11 != r2) goto L18;
        return r2;
    L21:
        return ListProtector.get(r15.getChanges(), 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
    L7:
        r0 = new AnonymousClass2(r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    public static final Object awaitPrimaryFirstDown(AwaitPointerEventScope r5, boolean r6, PointerEventPass r7, Continuation<? super PointerInputChange> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r10 = r0.Z$0;
        PointerEventPass r11 = (PointerEventPass) r0.L$1;
        AwaitPointerEventScope r12 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r9);
        r6 = r10;
        r5 = r12;
        r7 = r11;
    L18:
        PointerEvent r13 = (PointerEvent) r9;
        if (isChangedToDown(r13, r6, true) == true) goto L21;
    L15:
        r0.L$0 = r5;
        r0.L$1 = r7;
        r0.Z$0 = r6;
        r0.label = 1;
        r9 = r5.awaitPointerEvent(r7, r0);
        if (r9 != r2) goto L18;
        return r2;
    L21:
        return ListProtector.get(r13.getChanges(), 0);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
    L7:
        r0 = new AnonymousClass1(r8);
        goto L8
    }

    public static final Object detectTapAndPress(PointerInputScope r7, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r8, Function1<? super Offset, Unit> r9, Continuation<? super Unit> r10) {
        Object r11 = CoroutineScopeKt.coroutineScope(new C01562(r7, r8, r9, new PressGestureScopeImpl(r7), null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private static final Job launchAwaitingReset(CoroutineScope r6, Job r7, CoroutineStart r8, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r9) {
        return BuildersKt.launch$default(r6, null, r8, new C01581(r7, r9, null), 1, null);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope r0, boolean r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return awaitFirstDown(r0, r1, r2);
    }

    public static /* synthetic */ boolean isChangedToDown$default(PointerEvent r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = TapGestureDetector_androidKt.firstDownRefersToPrimaryMouseButtonOnly();
    L6:
        return isChangedToDown(r0, r1, r2);
    }

    public static /* synthetic */ Object waitForLongPress$default(AwaitPointerEventScope r0, PointerEventPass r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = PointerEventPass.Main;
    L6:
        return waitForLongPress(r0, r1, r2);
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope r0, PointerEventPass r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = PointerEventPass.Main;
    L6:
        return waitForUpOrCancellation(r0, r1, r2);
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope r0, boolean r1, PointerEventPass r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = PointerEventPass.Main;
    L9:
        return awaitFirstDown(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object awaitPrimaryFirstDown$default(AwaitPointerEventScope r0, boolean r1, PointerEventPass r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = PointerEventPass.Main;
    L9:
        return awaitPrimaryFirstDown(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope r0, Function3 r1, Function1 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = NoPressGesture;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return detectTapAndPress(r0, r1, r2, r3);
    }

    public static final Object detectTapGestures(PointerInputScope r8, Function1<? super Offset, Unit> r9, Function1<? super Offset, Unit> r10, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r11, Function1<? super Offset, Unit> r12, Continuation<? super Unit> r13) {
        Object r14 = CoroutineScopeKt.coroutineScope(new C01572(r8, r11, r10, r9, r12, null), r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Job launchAwaitingReset$default(CoroutineScope r0, Job r1, CoroutineStart r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = getCoroutineStartForCurrentDispatchBehavior();
    L6:
        return launchAwaitingReset(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope r7, Function1 r8, Function1 r9, Function3 r10, Function1 r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        Function1 r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        Function1 r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        r10 = NoPressGesture;
    L13:
        Function3 r4 = r10;
        if ((r13 & 8) == 0) goto L16;
        Function1 r5 = null;
    L18:
        return detectTapGestures(r7, r2, r3, r4, r5, r12);
    L16:
        r5 = r11;
        goto L18
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
