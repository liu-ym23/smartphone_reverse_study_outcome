package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015¢\u0006\u0002\b\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010#R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultScrollable2DState;", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "onDelta", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "isScrollingState", "Landroidx/compose/runtime/MutableState;", "", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "dispatchRawDelta-MK-Hz9U", "(J)J", "isScrollInProgress", "()Z", "canScroll", "offset", "canScroll-k-4lQ0M", "(J)Z", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultScrollable2DState implements Scrollable2DState {
    private final MutableState<Boolean> isScrollingState;
    private final Function1<Offset, Offset> onDelta;
    private final MutatorMutex scrollMutex;
    private final Scroll2DScope scrollScope;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultScrollable2DState$scroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollable2DState$scroll$2", f = "Scrollable2DState.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Scroll2DScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MutatePriority $scrollPriority;
        int label;
        final /* synthetic */ DefaultScrollable2DState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultScrollable2DState$scroll$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollable2DState$scroll$2$1", f = "Scrollable2DState.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<Scroll2DScope, Continuation<? super Unit>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DefaultScrollable2DState this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(DefaultScrollable2DState r1, Function2<? super Scroll2DScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass1> r3) {
                this.this$0 = r1;
                this.$block = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$block, r5);
                r0.L$0 = r4;
                return r0;
            }

            public final Object invoke(Scroll2DScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Scroll2DScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
            L15:
                DefaultScrollable2DState.access$isScrollingState$p(this.this$0).setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r6);
                Scroll2DScope r7 = (Scroll2DScope) this.L$0;
                DefaultScrollable2DState.access$isScrollingState$p(this.this$0).setValue(Boxing.boxBoolean(true));
                Function2<Scroll2DScope, Continuation<? super Unit>, Object> r2 = this.$block;     // Catch: Throwable -> L7
                this.label = 1;     // Catch: Throwable -> L7
                if (r2.invoke(r7, this) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                DefaultScrollable2DState.access$isScrollingState$p(this.this$0).setValue(Boxing.boxBoolean(false));
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DefaultScrollable2DState r1, MutatePriority r2, Function2<? super Scroll2DScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$scrollPriority = r2;
            this.$block = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$scrollPriority, this.$block, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            MutatorMutex r10 = DefaultScrollable2DState.access$getScrollMutex$p(this.this$0);
            Scroll2DScope r2 = DefaultScrollable2DState.access$getScrollScope$p(this.this$0);
            MutatePriority r3 = this.$scrollPriority;
            AnonymousClass1 r4 = new AnonymousClass1(this.this$0, this.$block, null);
            this.label = 1;
            if (r10.mutateWith(r2, r3, r4, this) != r0) goto L12;
            return r0;
        }
    }

    @Override // androidx.compose.foundation.gestures.Scrollable2DState
    /* JADX INFO: renamed from: canScroll-k-4lQ0M, reason: not valid java name */
    public boolean mo561canScrollk4lQ0M(long r1) {
        return true;
    }

    @Override // androidx.compose.foundation.gestures.Scrollable2DState
    public boolean isScrollInProgress() {
        return ((Boolean) this.isScrollingState.getValue()).booleanValue();
    }

    public final Function1<Offset, Offset> getOnDelta() {
        return this.onDelta;
    }

    public DefaultScrollable2DState(Function1<? super Offset, Offset> r3) {
        this.onDelta = r3;
        this.scrollScope = new DefaultScrollable2DState$scrollScope$1(this);
        this.scrollMutex = new MutatorMutex();
        this.isScrollingState = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    public static final /* synthetic */ MutatorMutex access$getScrollMutex$p(DefaultScrollable2DState r0) {
        return r0.scrollMutex;
    }

    public static final /* synthetic */ Scroll2DScope access$getScrollScope$p(DefaultScrollable2DState r0) {
        return r0.scrollScope;
    }

    public static final /* synthetic */ MutableState access$isScrollingState$p(DefaultScrollable2DState r0) {
        return r0.isScrollingState;
    }

    @Override // androidx.compose.foundation.gestures.Scrollable2DState
    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    public long mo562dispatchRawDeltaMKHz9U(long r2) {
        return ((Offset) this.onDelta.invoke(Offset.box-impl(r2))).unbox-impl();
    }

    @Override // androidx.compose.foundation.gestures.Scrollable2DState
    public Object scroll(MutatePriority r3, Function2<? super Scroll2DScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        Object r6 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
