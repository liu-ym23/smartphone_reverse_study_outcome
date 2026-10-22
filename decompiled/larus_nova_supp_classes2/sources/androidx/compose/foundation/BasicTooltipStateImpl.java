package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/BasicTooltipStateImpl;", "Landroidx/compose/foundation/BasicTooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<init>", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "<set-?>", "isVisible", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BasicTooltipStateImpl implements BasicTooltipState {
    private final boolean isPersistent;
    private final MutableState isVisible$delegate;
    private kotlinx.coroutines.i<? super Unit> job;
    private final MutatorMutex mutatorMutex;

    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipStateImpl$show$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", i = {}, l = {310, 312}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
        int label;
        final /* synthetic */ BasicTooltipStateImpl this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltipStateImpl$show$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.BasicTooltipStateImpl$show$2$1", f = "BasicTooltip.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
            int label;

            public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AnonymousClass1> r2) {
                this.$cancellableShow = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.$cancellableShow, r3);
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
                Function1<Continuation<? super Unit>, Object> r5 = this.$cancellableShow;
                this.label = 1;
                if (r5.invoke(this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass2(BasicTooltipStateImpl r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$cancellableShow = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$cancellableShow, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L11
        L22:
            this.this$0.setVisible(false);
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r6);
            if (this.this$0.isPersistent() == false) goto L19;
            Function1<Continuation<? super Unit>, Object> r7 = this.$cancellableShow;     // Catch: Throwable -> L11
            this.label = 1;     // Catch: Throwable -> L11
            if (r7.invoke(this) != r0) goto L22;
            return r0;
        L19:
            AnonymousClass1 r8 = new AnonymousClass1(this.$cancellableShow, null);     // Catch: Throwable -> L11
            this.label = 2;     // Catch: Throwable -> L11
            if (TimeoutKt.b(BasicTooltipDefaults.TooltipDuration, r8, this) != r0) goto L22;
            return r0;
        L11:
            th = move-exception;
            this.this$0.setVisible(false);
            throw th;
        }
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void dismiss() {
        setVisible(false);
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public boolean isVisible() {
        return ((Boolean) this.isVisible$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void onDispose() {
        kotlinx.coroutines.i<? super Unit> r0 = this.job;
        if (r0 == null) goto L6;
        r0.cancel(null);
        return;
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public boolean isPersistent() {
        return this.isPersistent;
    }

    public void setVisible(boolean r2) {
        this.isVisible$delegate.setValue(Boolean.valueOf(r2));
    }

    public static final /* synthetic */ void access$setJob$p(BasicTooltipStateImpl r0, kotlinx.coroutines.i r1) {
        r0.job = r1;
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public Object show(MutatePriority r5, Continuation<? super Unit> r6) {
        BasicTooltipStateImpl$show$cancellableShow$1 r0 = new BasicTooltipStateImpl$show$cancellableShow$1(this, null);
        Object r7 = this.mutatorMutex.mutate(r5, new AnonymousClass2(this, r0, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public BasicTooltipStateImpl(boolean r1, boolean r2, MutatorMutex r3) {
        this.isPersistent = r2;
        this.mutatorMutex = r3;
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r1), null, 2, null);
    }
}
