package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"detectDragGesturesAfterLongPressWithObserver", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "observer", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDownAndDragGesturesWithObserver", "detectPreDragGesturesWithObserver", "detectDragGesturesWithObserver", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongPressTextDragObserverKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$1", f = "LongPressTextDragObserver.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            public AnonymousClass1(PointerInputScope r1, TextDragObserver r2, Continuation<? super AnonymousClass1> r3) {
                this.$this_detectDownAndDragGesturesWithObserver = r1;
                this.$observer = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                PointerInputScope r5 = this.$this_detectDownAndDragGesturesWithObserver;
                TextDragObserver r2 = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.access$detectPreDragGesturesWithObserver(r5, r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2$2", f = "LongPressTextDragObserver.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TextDragObserver $observer;
            final /* synthetic */ PointerInputScope $this_detectDownAndDragGesturesWithObserver;
            int label;

            public C00332(PointerInputScope r1, TextDragObserver r2, Continuation<? super C00332> r3) {
                this.$this_detectDownAndDragGesturesWithObserver = r1;
                this.$observer = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00332(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                PointerInputScope r5 = this.$this_detectDownAndDragGesturesWithObserver;
                TextDragObserver r2 = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.access$detectDragGesturesWithObserver(r5, r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass2(PointerInputScope r1, TextDragObserver r2, Continuation<? super AnonymousClass2> r3) {
            this.$this_detectDownAndDragGesturesWithObserver = r1;
            this.$observer = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Job> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            CoroutineStart r6 = CoroutineStart.UNDISPATCHED;
            BuildersKt.launch$default(r10, null, r6, new AnonymousClass1(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 1, null);
            return BuildersKt.launch$default(r10, null, r6, new C00332(this.$this_detectDownAndDragGesturesWithObserver, this.$observer, null), 1, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.LongPressTextDragObserverKt$detectPreDragGesturesWithObserver$2", f = "LongPressTextDragObserver.kt", i = {0, 1, 1}, l = {87, 91}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
    public static final class C02112 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public C02112(TextDragObserver r1, Continuation<? super C02112> r2) {
            this.$observer = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02112 r0 = new C02112(this.$observer, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0064 -> B:17:0x0067). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r17) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            PointerInputChange r1 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r17);
            Object r3 = r17;
            C02112 r4 = this;
        L17:
            List r5 = ((PointerEvent) r3).getChanges();
            int r6 = r5.size();
            boolean r8 = false;
            int r10 = 0;
        L18:
            if (r10 >= r6) goto L28;
            PointerInputChange r11 = (PointerInputChange) ListProtector.get(r5, r10);
            if (PointerId.equals-impl0(r11.getId-J3iCeTQ(), r1.getId-J3iCeTQ()) == true) goto L22;
        L24:
            boolean r12 = false;
        L25:
            if (r12 == true) goto L26;
            r10 = r10 + 1;
            goto L18
        L26:
            r8 = true;
            goto L28
        L22:
            if (r11.getPressed() == false) goto L24;
            r12 = true;
        L28:
            if (r8 == false) goto L29;
        L14:
            r4.L$0 = r2;
            r4.L$1 = r1;
            r4.label = 2;
            r3 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r2, null, r4, 1, null);
            if (r3 != r7) goto L17;
            return r7;
        L29:
            r4.$observer.onUp();
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AwaitPointerEventScope r9 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r17);
            AwaitPointerEventScope r13 = r9;
            Object r14 = r17;
        L13:
            r1 = (PointerInputChange) r14;
            this.$observer.mo1449onDownk4lQ0M(r1.getPosition-F1C5BW0());
            r4 = this;
            r2 = r13;
            goto L14
        L10:
            ResultKt.throwOnFailure(r17);
            r13 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r13;
            this.label = 1;
            r14 = TapGestureDetectorKt.awaitFirstDown$default(r13, false, null, this, 2, null);
            if (r14 != r7) goto L13;
            return r7;
        }
    }

    public static /* synthetic */ Unit a(TextDragObserver r0) {
        return detectDragGesturesAfterLongPressWithObserver$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(TextDragObserver r0, Offset r1) {
        return detectDragGesturesAfterLongPressWithObserver$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit c(TextDragObserver r0, PointerInputChange r1, Offset r2) {
        return detectDragGesturesAfterLongPressWithObserver$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(TextDragObserver r0) {
        return detectDragGesturesAfterLongPressWithObserver$lambda$2(r0);
    }

    public static /* synthetic */ Unit e(TextDragObserver r0, PointerInputChange r1, Offset r2) {
        return detectDragGesturesWithObserver$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(TextDragObserver r0, Offset r1) {
        return detectDragGesturesWithObserver$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit g(TextDragObserver r0) {
        return detectDragGesturesWithObserver$lambda$6(r0);
    }

    public static /* synthetic */ Unit h(TextDragObserver r0) {
        return detectDragGesturesWithObserver$lambda$5(r0);
    }

    private static final Unit detectDragGesturesAfterLongPressWithObserver$lambda$1(TextDragObserver r0) {
        r0.onStop();
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPressWithObserver$lambda$2(TextDragObserver r0) {
        r0.onCancel();
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesWithObserver$lambda$5(TextDragObserver r0) {
        r0.onStop();
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesWithObserver$lambda$6(TextDragObserver r0) {
        r0.onCancel();
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPressWithObserver$lambda$0(TextDragObserver r2, Offset r3) {
        r2.mo1451onStartk4lQ0M(r3.unbox-impl());
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesWithObserver$lambda$4(TextDragObserver r2, Offset r3) {
        r2.mo1451onStartk4lQ0M(r3.unbox-impl());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$detectDragGesturesWithObserver(PointerInputScope r0, TextDragObserver r1, Continuation r2) {
        return detectDragGesturesWithObserver(r0, r1, r2);
    }

    public static final /* synthetic */ Object access$detectPreDragGesturesWithObserver(PointerInputScope r0, TextDragObserver r1, Continuation r2) {
        return detectPreDragGesturesWithObserver(r0, r1, r2);
    }

    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope r2, TextDragObserver r3, Continuation<? super Unit> r4) {
        Object r5 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(r2, r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPressWithObserver(PointerInputScope r6, final TextDragObserver r7, Continuation<? super Unit> r8) {
        Object r9 = DragGestureDetectorKt.detectDragGesturesAfterLongPress(r6, new b3(r7), new c3(r7), new d3(r7), new e3(r7), r8);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesAfterLongPressWithObserver$lambda$3(TextDragObserver r0, PointerInputChange r1, Offset r2) {
        r0.mo1450onDragk4lQ0M(r2.unbox-impl());
        return Unit.INSTANCE;
    }

    private static final Object detectDragGesturesWithObserver(PointerInputScope r6, final TextDragObserver r7, Continuation<? super Unit> r8) {
        Object r9 = DragGestureDetectorKt.detectDragGestures(r6, new x2(r7), new y2(r7), new z2(r7), new a3(r7), r8);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit detectDragGesturesWithObserver$lambda$7(TextDragObserver r0, PointerInputChange r1, Offset r2) {
        r0.mo1450onDragk4lQ0M(r2.unbox-impl());
        return Unit.INSTANCE;
    }

    private static final Object detectPreDragGesturesWithObserver(PointerInputScope r2, TextDragObserver r3, Continuation<? super Unit> r4) {
        Object r5 = ForEachGestureKt.awaitEachGesture(r2, new C02112(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
