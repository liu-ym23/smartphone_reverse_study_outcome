package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0019\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001b\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectZoomByCtrlMouseScroll", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstCtrlMouseScroll", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCtrlMouseScrollOrNull", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0}, l = {312}, m = "awaitCtrlMouseScrollOrNull", n = {"$this$awaitCtrlMouseScrollOrNull", "scrollConfig"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TransformableKt.access$awaitCtrlMouseScrollOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0}, l = {299}, m = "awaitFirstCtrlMouseScroll", n = {"$this$awaitFirstCtrlMouseScroll", "scrollConfig"}, s = {"L$0", "L$1"})
    public static final class C01621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C01621(Continuation<? super C01621> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TransformableKt.access$awaitFirstCtrlMouseScroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {337, 339, 385}, m = "detectZoom", n = {"$this$detectZoom", "channel", "canPan", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "event", "panZoomLock", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"})
    public static final class C01631 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C01631(Continuation<? super C01631> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return TransformableKt.access$detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", i = {0, 1}, l = {272, 284}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ ScrollConfig $scrollConfig;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(CoroutineContext r1, ScrollConfig r2, Channel<TransformEvent> r3, Continuation<? super AnonymousClass2> r4) {
            this.$currentContext = r1;
            this.$scrollConfig = r2;
            this.$channel = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$currentContext, this.$scrollConfig, this.$channel, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a4 -> B:33:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ac -> B:17:0x003a). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 != 0) goto L47;
            ResultKt.throwOnFailure(r14);
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            AnonymousClass2 r15 = this;
        L18:
            if (JobKt.isActive(r15.$currentContext) == false) goto L42;
            ScrollConfig r4 = r15.$scrollConfig;     // Catch: Throwable -> L37
            r15.L$0 = r2;     // Catch: Throwable -> L37
            r15.label = 1;     // Catch: Throwable -> L37
            Object r5 = TransformableKt.access$awaitFirstCtrlMouseScroll(r2, r4, r15);     // Catch: Throwable -> L37
            if (r5 != r0) goto L22;
            return r0;
        L22:
            Object r12 = r0;
            AnonymousClass2 r3 = r15;
            r14 = r5;
            AwaitPointerEventScope r6 = r2;
            Object r7 = r12;
        L23:
            long r8 = ((Offset) r14).unbox-impl();     // Catch: Throwable -> L35
            r3.$channel.trySend-JP2dKIU(TransformEvent.TransformStarted.INSTANCE);     // Catch: Throwable -> L35
        L33:
            AnonymousClass2 r16 = r3;
            Object r9 = r7;
            AwaitPointerEventScope r10 = r6;
            r16.$channel.trySend-JP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0f, Float.intBitsToFloat((int) (r8 & 4294967295L)) / 545.0f), Offset.Companion.getZero-F1C5BW0(), MenuKt.ClosedAlphaTarget, null));     // Catch: Throwable -> L37
            ScrollConfig r11 = r16.$scrollConfig;     // Catch: Throwable -> L37
            r16.L$0 = r10;     // Catch: Throwable -> L37
            r16.label = 2;     // Catch: Throwable -> L37
            Object r13 = TransformableKt.access$awaitCtrlMouseScrollOrNull(r10, r11, r16);     // Catch: Throwable -> L37
            if (r13 != r9) goto L29;
            return r9;
        L29:
            r3 = r16;
            r14 = r13;
            r6 = r10;
            r7 = r9;
        L43:
            Offset r17 = (Offset) r14;     // Catch: Throwable -> L35
            if (r17 == null) goto L34;
            r8 = r17.unbox-impl();     // Catch: Throwable -> L35
            goto L33
        L34:
            r3.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
            r15 = r3;
            r0 = r7;
            r2 = r6;
        L35:
            th = th;
        L39:
            r3.$channel.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
            throw th;
        L37:
            th = move-exception;
            r3 = r16;
            th = th;
            goto L39
        L42:
            return Unit.INSTANCE;
        L47:
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            AwaitPointerEventScope r18 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
            r6 = r18;
            r7 = r0;
            r3 = this;
            goto L43
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            AwaitPointerEventScope r19 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
            r6 = r19;
            r7 = r0;
            r3 = this;
        L14:
            th = th;
            r3 = this;
            goto L39
        }
    }

    public static /* synthetic */ boolean a(Offset r0) {
        return transformable$lambda$0(r0);
    }

    private static final boolean transformable$lambda$0(Offset r0) {
        return true;
    }

    public static final /* synthetic */ Object access$awaitCtrlMouseScrollOrNull(AwaitPointerEventScope r0, ScrollConfig r1, Continuation r2) {
        return awaitCtrlMouseScrollOrNull(r0, r1, r2);
    }

    public static final /* synthetic */ Object access$awaitFirstCtrlMouseScroll(AwaitPointerEventScope r0, ScrollConfig r1, Continuation r2) {
        return awaitFirstCtrlMouseScroll(r0, r1, r2);
    }

    private static final Object awaitCtrlMouseScrollOrNull(AwaitPointerEventScope r5, ScrollConfig r6, Continuation<? super Offset> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (ScrollConfig) r0.L$1;
        r5 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        PointerEvent r9 = (PointerEvent) r8;
        if (PointerEvent_androidKt.isCtrlPressed-5xRPYO0(r9.getKeyboardModifiers-k7X9c1A()) == true) goto L20;
    L30:
        return null;
    L20:
        if (PointerEventType.equals-impl0(r9.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk()) == false) goto L30;
        long r10 = r6.mo546calculateMouseWheelScroll8xgXZGE(r5, r9, r5.getSize-YbymL2g());
        if (Offset.equals-impl0(r10, Offset.Companion.getZero-F1C5BW0()) == false) goto L25;
        return null;
    L25:
        List r11 = r9.getChanges();
        int r4 = r11.size();
        int r12 = 0;
    L26:
        if (r12 >= r4) goto L29;
        ((PointerInputChange) ListProtector.get(r11, r12)).consume();
        r12 = r12 + 1;
        goto L26
    L29:
        return Offset.box-impl(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r5, null, r0, 1, null);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
    private static final Object awaitFirstCtrlMouseScroll(AwaitPointerEventScope r5, ScrollConfig r6, Continuation<? super Offset> r7) {
        if ((r7 instanceof C01621) == false) goto L7;
        C01621 r0 = (C01621) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ScrollConfig r9 = (ScrollConfig) r0.L$1;
        AwaitPointerEventScope r10 = (AwaitPointerEventScope) r0.L$0;
        ResultKt.throwOnFailure(r8);
        r6 = r9;
        r5 = r10;
    L18:
        Offset r11 = (Offset) r8;
        if (r11 != null) goto L20;
    L15:
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = awaitCtrlMouseScrollOrNull(r5, r6, r0);
        if (r8 != r2) goto L18;
        return r2;
    L20:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
    L7:
        r0 = new C01621(r7);
        goto L8
    }

    public static final /* synthetic */ Object access$detectZoomByCtrlMouseScroll(PointerInputScope r0, Channel r1, ScrollConfig r2, Continuation r3) {
        return detectZoomByCtrlMouseScroll(r0, r1, r2, r3);
    }

    private static final Object detectZoomByCtrlMouseScroll(PointerInputScope r3, Channel<TransformEvent> r4, ScrollConfig r5, Continuation<? super Unit> r6) {
        Object r7 = r3.awaitPointerEventScope(new AnonymousClass2(r6.getContext(), r5, r4, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public static final Modifier transformable(Modifier r1, TransformableState r2, boolean r3, boolean r4) {
        return transformable(r1, r2, new n2(), r3, r4);
    }

    public static final /* synthetic */ Object access$detectZoom(AwaitPointerEventScope r0, boolean r1, Channel r2, Function1 r3, Continuation r4) {
        return detectZoom(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0287 -> B:88:0x0299). Please report as a decompilation issue!!! */
    private static final Object detectZoom(AwaitPointerEventScope r30, boolean r31, Channel<TransformEvent> r32, Function1<? super Offset, Boolean> r33, Continuation<? super Unit> r34) {
        if ((r34 instanceof C01631) == false) goto L7;
        C01631 r1 = (C01631) r34;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r0 = r1.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        int r4 = r1.I$2;
        int r5 = r1.I$1;
        float r6 = r1.F$2;
        int r7 = r1.I$0;
        long r9 = r1.J$0;
        float r15 = r1.F$1;
        float r10 = r1.F$0;
        boolean r11 = r1.Z$0;
        PointerEvent r14 = (PointerEvent) r1.L$3;
        Function1<? super Offset, Boolean> r13 = (Function1) r1.L$2;
        Channel<TransformEvent> r12 = (Channel) r1.L$1;
        AwaitPointerEventScope r16 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r19 = r11;
        Object r17 = r8;
        float r18 = r15;
        int r110 = r4;
        Object r20 = r0;
        Channel<TransformEvent> r111 = r12;
        AwaitPointerEventScope r112 = r16;
    L88:
        List r21 = ((PointerEvent) r20).getChanges();
        int r22 = r21.size();
        C01631 r35 = r1;
        int r23 = 0;
    L89:
        if (r23 >= r22) goto L94;
        if (((PointerInputChange) ListProtector.get(r21, r23)).isConsumed() == true) goto L92;
        r23 = r23 + 1;
        goto L89
    L92:
        boolean r24 = true;
    L95:
        if (r24 == false) goto L98;
        if (r7 != 0) goto L98;
        boolean r25 = true;
    L99:
        if (r110 != 0) goto L112;
        if (r25 == true) goto L112;
        List r26 = r14.getChanges();
        int r27 = r26.size();
        int r28 = 0;
    L102:
        if (r28 >= r27) goto L107;
        if (((PointerInputChange) ListProtector.get(r26, r28)).getPressed() == true) goto L105;
        r28 = r28 + 1;
        goto L102
    L105:
        boolean r29 = true;
    L108:
        if (r29 == false) goto L112;
        r1 = r35;
        int r36 = r5;
        float r37 = r6;
        int r38 = r7;
        long r39 = r9;
        float r40 = r18;
        r8 = r17;
        float r41 = r10;
        boolean r113 = r19;
    L22:
        r1.L$0 = r112;
        r1.L$1 = r111;
        r1.L$2 = r13;
        r1.L$3 = null;
        r1.Z$0 = r113;
        r1.F$0 = r41;
        r1.F$1 = r40;
        r1.J$0 = r39;
        r1.I$0 = r38;
        r1.F$2 = r37;
        r1.I$1 = r36;
        r1.label = 2;
        r0 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r112, null, r1, 1, null);
        if (r0 != r8) goto L25;
        return r8;
    L25:
        Function1<? super Offset, Boolean> r210 = r13;
        AwaitPointerEventScope r114 = r112;
        Function1<? super Offset, Boolean> r115 = r210;
    L26:
        PointerEvent r42 = (PointerEvent) r0;
        List r116 = r42.getChanges();
        int r117 = r116.size();
        int r310 = r36;
        int r43 = 0;
    L27:
        if (r43 >= r117) goto L32;
        if (((PointerInputChange) ListProtector.get(r116, r43)).isConsumed() == true) goto L30;
        r43 = r43 + 1;
        goto L27
    L30:
        int r44 = 1;
    L33:
        if (r44 != 0) goto L83;
        float r211 = TransformGestureDetectorKt.calculateZoom(r42);
        float r118 = TransformGestureDetectorKt.calculateRotation(r42);
        long r45 = TransformGestureDetectorKt.calculatePan(r42);
        if (r38 != 0) goto L52;
        r40 = r40 * r211;
        r41 = r41 + r118;
        r39 = Offset.plus-MK-Hz9U(r39, r45);
        int r311 = r38;
        float r119 = TransformGestureDetectorKt.calculateCentroidSize(r42, false);
        float r120 = r118;
        float r121 = Math.abs(1 - r40) * r119;
        float r122 = Math.abs(((3.1415927f * r41) * r119) / 180.0f);
        float r212 = Offset.getDistance-impl(r39);
        if (r121 <= r37) goto L39;
    L46:
        if (r113 == true) goto L48;
    L50:
        int r123 = 0;
    L51:
        r111.trySend-JP2dKIU(TransformEvent.TransformStarted.INSTANCE);
        r38 = 1;
    L53:
        if (r38 == 0) goto L81;
        if (r123 == 0) goto L56;
        float r124 = MenuKt.ClosedAlphaTarget;
        float r213 = MenuKt.ClosedAlphaTarget;
    L58:
        if (r213 != r124) goto L60;
        boolean r125 = true;
    L61:
        if (r125 == true) goto L63;
        int r312 = r38;
        long r214 = r39;
    L74:
        r111.trySend-JP2dKIU(new TransformEvent.TransformDelta(r211, r45, r213, null));
    L75:
        List r46 = r42.getChanges();
        int r47 = r46.size();
        int r48 = 0;
    L76:
        if (r48 >= r47) goto L82;
        PointerInputChange r49 = (PointerInputChange) ListProtector.get(r46, r48);
        if (PointerEventKt.positionChanged(r49) == false) goto L80;
        r49.consume();
    L80:
        r48 = r48 + 1;
    L82:
        r7 = r312;
        float r50 = r40;
        r9 = r214;
    L84:
        PointerEventPass r51 = PointerEventPass.Final;
        C01631 r52 = r1;
        r52.L$0 = r114;
        r52.L$1 = r111;
        r52.L$2 = r115;
        r52.L$3 = r42;
        r52.Z$0 = r113;
        r52.F$0 = r41;
        r52.F$1 = r50;
        r52.J$0 = r9;
        r52.I$0 = r7;
        r52.F$2 = r37;
        r52.I$1 = r123;
        r110 = r44;
        r52.I$2 = r110;
        r52.label = 3;
        r20 = r114.awaitPointerEvent(r51, r52);
        if (r20 != r8) goto L87;
        return r8;
    L87:
        r19 = r113;
        r14 = r42;
        Object r215 = r8;
        r18 = r50;
        r1 = r52;
        r6 = r37;
        r5 = r123;
        r10 = r41;
        r17 = r215;
        AwaitPointerEventScope r216 = r114;
        r13 = r115;
        r112 = r216;
        goto L88
    L63:
        if (r211 != 1.0f) goto L65;
        boolean r126 = true;
    L66:
        if (r126 == false) goto L72;
        r312 = r38;
        r214 = r39;
        if (Offset.equals-impl0(r45, Offset.Companion.getZero-F1C5BW0()) == true) goto L75;
        if (((Boolean) r115.invoke(Offset.box-impl(r45))).booleanValue() == false) goto L75;
    L72:
        r312 = r38;
        r214 = r39;
        goto L74
    L65:
        r126 = false;
        goto L66
    L60:
        r125 = false;
        goto L61
    L56:
        r213 = r120;
        r124 = MenuKt.ClosedAlphaTarget;
        goto L58
    L81:
        r312 = r38;
        r214 = r39;
        goto L82
    L48:
        if (r122 >= r37) goto L50;
        r123 = 1;
        goto L51
    L39:
        if (r122 > r37) goto L46;
        if (r212 > r37) goto L43;
    L45:
        r123 = r310;
        r38 = r311;
        goto L53
    L43:
        if (((Boolean) r115.invoke(Offset.box-impl(r45))).booleanValue() == false) goto L45;
    L52:
        r120 = r118;
        r123 = r310;
        goto L53
    L83:
        r111.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE);
        r123 = r310;
        r50 = r40;
        r9 = r39;
        r7 = r38;
        goto L84
    L32:
        r44 = 0;
        goto L33
    L107:
        r29 = false;
    L112:
        return Unit.INSTANCE;
    L98:
        r25 = false;
        goto L99
    L94:
        r24 = false;
        goto L95
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r36 = r1.I$1;
        r37 = r1.F$2;
        r38 = r1.I$0;
        r39 = r1.J$0;
        r40 = r1.F$1;
        r41 = r1.F$0;
        boolean r127 = r1.Z$0;
        r115 = (Function1) r1.L$2;
        r111 = (Channel) r1.L$1;
        r114 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r113 = r127;
        goto L26
    L17:
        r36 = r1.I$1;
        r37 = r1.F$2;
        r38 = r1.I$0;
        r39 = r1.J$0;
        r40 = r1.F$1;
        r41 = r1.F$0;
        boolean r128 = r1.Z$0;
        Function1<? super Offset, Boolean> r129 = (Function1) r1.L$2;
        r111 = (Channel) r1.L$1;
        AwaitPointerEventScope r130 = (AwaitPointerEventScope) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r113 = r128;
        r13 = r129;
        r112 = r130;
        goto L22
    L18:
        ResultKt.throwOnFailure(r0);
        long r53 = Offset.Companion.getZero-F1C5BW0();
        float r54 = r30.getViewConfiguration().getTouchSlop();
        r112 = r30;
        r1.L$0 = r112;
        r111 = r32;
        r1.L$1 = r111;
        r13 = r33;
        r1.L$2 = r13;
        r113 = r31;
        r1.Z$0 = r113;
        r1.F$0 = MenuKt.ClosedAlphaTarget;
        r1.F$1 = 1.0f;
        r1.J$0 = r53;
        r1.I$0 = 0;
        r1.F$2 = r54;
        r1.I$1 = 0;
        r1.label = 1;
        if (TapGestureDetectorKt.awaitFirstDown$default(r30, false, null, r1, 2, null) != r8) goto L21;
        return r8;
    L21:
        r37 = r54;
        r39 = r53;
        r36 = 0;
        r38 = 0;
        r40 = 1.0f;
        r41 = MenuKt.ClosedAlphaTarget;
    L7:
        r1 = new C01631(r34);
        goto L8
    }

    public static final Modifier transformable(Modifier r1, TransformableState r2, Function1<? super Offset, Boolean> r3, boolean r4, boolean r5) {
        return r1.then(new TransformableElement(r2, r3, r4, r5));
    }

    public static /* synthetic */ Modifier transformable$default(Modifier r0, TransformableState r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
    L9:
        return transformable(r0, r1, r2, r3);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier r0, TransformableState r1, Function1 r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = true;
    L9:
        return transformable(r0, r1, r2, r3, r4);
    }
}
