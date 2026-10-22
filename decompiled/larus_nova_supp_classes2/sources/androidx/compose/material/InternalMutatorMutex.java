package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J<\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@¢\u0006\u0002\u0010\u0015JU\u0010\u0016\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u0018\u001a\u0002H\u00172\b\b\u0002\u0010\u0010\u001a\u00020\u00112'\u0010\u0012\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\b\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u001eR$\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/material/InternalMutatorMutex;", "", "<init>", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/material/InternalMutatorMutex$Mutator;", "Landroidx/compose/material/InternalAtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryMutateOrCancel", "", "mutator", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutate", "", "Lkotlin/Function0;", "Mutator", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalMutatorMutex {
    public static final int $stable = 0;
    private final AtomicReference<Mutator> currentMutator;
    private final kotlinx.coroutines.sync.a mutex;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/InternalMutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "getJob", "()Lkotlinx/coroutines/Job;", "canInterrupt", "", "other", "cancel", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mutator {
        private final Job job;
        private final MutatePriority priority;

        public final void cancel() {
            Job.DefaultImpls.cancel$default(this.job, null, 1, null);
        }

        public final Job getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }

        public final boolean canInterrupt(Mutator r2) {
            if (this.priority.compareTo(r2.priority) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public Mutator(MutatePriority r1, Job r2) {
            this.priority = r1;
            this.job = r2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.material.InternalMutatorMutex$mutate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", i = {0, 0, 1, 1}, l = {179, 103}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        public AnonymousClass2(MutatePriority r1, InternalMutatorMutex r2, Function1<? super Continuation<? super R>, ? extends Object> r3, Continuation<? super AnonymousClass2> r4) {
            this.$priority = r1;
            this.this$0 = r2;
            this.$block = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$priority, this.this$0, this.$block, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super R> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.a] */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            InternalMutatorMutex r2 = (InternalMutatorMutex) this.L$2;
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r4 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L9
        L22:
            AtomicReference r5 = InternalMutatorMutex.access$getCurrentMutator$p(r2);     // Catch: Throwable -> L39
        L24:
            if (r5.compareAndSet(r4, null) == true) goto L28;
            if (r5.get() == r4) goto L24;
        L28:
            r3.unlock(null);
            return r9;
        L9:
            Throwable th = th;
        L32:
            AtomicReference r6 = InternalMutatorMutex.access$getCurrentMutator$p(r2);     // Catch: Throwable -> L39
        L34:
            if (r6.compareAndSet(r4, null) == true) goto L38;
            if (r6.get() == r4) goto L34;
        L38:
            throw th;     // Catch: Throwable -> L39
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            InternalMutatorMutex r7 = (InternalMutatorMutex) this.L$3;
            Function1<Continuation<? super R>, Object> r8 = (Function1) this.L$2;
            kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r11 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r9);
            kotlinx.coroutines.sync.a r12 = r10;
        L45:
            this.L$0 = r11;     // Catch: Throwable -> L30
            this.L$1 = r12;     // Catch: Throwable -> L30
            this.L$2 = r7;     // Catch: Throwable -> L30
            this.L$3 = null;     // Catch: Throwable -> L30
            this.label = 2;     // Catch: Throwable -> L30
            Object r13 = r8.invoke(this);     // Catch: Throwable -> L30
            if (r13 != r0) goto L21;
            return r0;
        L21:
            r2 = r7;
            r3 = r12;
            r9 = r13;
            r4 = r11;
        L30:
            th = move-exception;
            r4 = r11;
            th = th;
            r2 = r7;
            goto L32
        L14:
            ResultKt.throwOnFailure(r9);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            MutatePriority r15 = this.$priority;
            Job r16 = r14.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(r16);
            Mutator r17 = new Mutator(r15, r16);
            InternalMutatorMutex.access$tryMutateOrCancel(this.this$0, r17);
            r12 = InternalMutatorMutex.access$getMutex$p(this.this$0);
            Function1<Continuation<? super R>, Object> r18 = this.$block;
            InternalMutatorMutex r19 = this.this$0;
            this.L$0 = r17;
            this.L$1 = r12;
            this.L$2 = r18;
            this.L$3 = r19;
            this.label = 1;
            if (r12.a(null, this) != r0) goto L17;
            return r0;
        L17:
            r8 = r18;
            r11 = r17;
            r7 = r19;
        L39:
            th = move-exception;
            r1.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.material.InternalMutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.InternalMutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", i = {0, 0, 1, 1}, l = {179, 142}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C02432<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ InternalMutatorMutex this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02432(MutatePriority r1, InternalMutatorMutex r2, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r3, T r4, Continuation<? super C02432> r5) {
            this.$priority = r1;
            this.this$0 = r2;
            this.$block = r3;
            this.$receiver = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C02432 r6 = new C02432(this.$priority, this.this$0, this.$block, this.$receiver, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super R> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.a] */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            InternalMutatorMutex r2 = (InternalMutatorMutex) this.L$2;
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r4 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
        L22:
            AtomicReference r5 = InternalMutatorMutex.access$getCurrentMutator$p(r2);     // Catch: Throwable -> L39
        L24:
            if (r5.compareAndSet(r4, null) == true) goto L28;
            if (r5.get() == r4) goto L24;
        L28:
            r3.unlock(null);
            return r10;
        L9:
            Throwable th = th;
        L32:
            AtomicReference r6 = InternalMutatorMutex.access$getCurrentMutator$p(r2);     // Catch: Throwable -> L39
        L34:
            if (r6.compareAndSet(r4, null) == true) goto L38;
            if (r6.get() == r4) goto L34;
        L38:
            throw th;     // Catch: Throwable -> L39
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            InternalMutatorMutex r7 = (InternalMutatorMutex) this.L$4;
            Object r8 = this.L$3;
            Function2 r9 = (Function2) this.L$2;
            kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) this.L$1;
            Mutator r12 = (Mutator) this.L$0;
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.sync.a r13 = r11;
        L44:
            this.L$0 = r12;     // Catch: Throwable -> L30
            this.L$1 = r13;     // Catch: Throwable -> L30
            this.L$2 = r7;     // Catch: Throwable -> L30
            this.L$3 = null;     // Catch: Throwable -> L30
            this.L$4 = null;     // Catch: Throwable -> L30
            this.label = 2;     // Catch: Throwable -> L30
            Object r14 = r9.invoke(r8, this);     // Catch: Throwable -> L30
            if (r14 != r0) goto L21;
            return r0;
        L21:
            r2 = r7;
            r3 = r13;
            r10 = r14;
            r4 = r12;
        L30:
            th = move-exception;
            r4 = r12;
            th = th;
            r2 = r7;
            goto L32
        L14:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            MutatePriority r16 = this.$priority;
            Job r17 = r15.getCoroutineContext().get(Job.Key);
            Intrinsics.checkNotNull(r17);
            Mutator r18 = new Mutator(r16, r17);
            InternalMutatorMutex.access$tryMutateOrCancel(this.this$0, r18);
            r13 = InternalMutatorMutex.access$getMutex$p(this.this$0);
            r9 = this.$block;
            Object r19 = this.$receiver;
            InternalMutatorMutex r20 = this.this$0;
            this.L$0 = r18;
            this.L$1 = r13;
            this.L$2 = r9;
            this.L$3 = r19;
            this.L$4 = r20;
            this.label = 1;
            if (r13.a(null, this) != r0) goto L17;
            return r0;
        L17:
            r8 = r19;
            r12 = r18;
            r7 = r20;
        L39:
            th = move-exception;
            r1.unlock(null);
            throw th;
        }
    }

    public InternalMutatorMutex() {
        this.currentMutator = new AtomicReference(null);
        this.mutex = kotlinx.coroutines.sync.b.a();
    }

    public static final /* synthetic */ AtomicReference access$getCurrentMutator$p(InternalMutatorMutex r0) {
        return r0.currentMutator;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(InternalMutatorMutex r0) {
        return r0.mutex;
    }

    private final void tryMutateOrCancel(Mutator r4) {
    L2:
        Mutator r0 = this.currentMutator.get();
        if (r0 != null) goto L5;
    L9:
        AtomicReference<Mutator> r1 = this.currentMutator;
    L11:
        if (r1.compareAndSet(r0, r4) == true) goto L12;
        if (r1.get() == r0) goto L11;
        boolean r2 = false;
    L16:
        if (r2 == false) goto L2;
        if (r0 == null) goto L28;
        r0.cancel();
        return;
    L28:
        return;
    L12:
        r2 = true;
        goto L16
    L5:
        if (r4.canInterrupt(r0) == true) goto L9;
        throw new CancellationException("Current mutation had a higher priority");
    }

    public final boolean tryMutate(Function0<Unit> r3) {
        boolean r0 = this.mutex.b(null);
        if (r0 == true) goto L10;
    L9:
        return r0;
    L10:
        r3.invoke();     // Catch: Throwable -> L6
        this.mutex.unlock(null);
    L6:
        th = move-exception;
        this.mutex.unlock(null);
        throw th;
    }

    public static final /* synthetic */ void access$tryMutateOrCancel(InternalMutatorMutex r0, Mutator r1) {
        r0.tryMutateOrCancel(r1);
    }

    public final <R> Object mutate(MutatePriority r3, Function1<? super Continuation<? super R>, ? extends Object> r4, Continuation<? super R> r5) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(r3, this, r4, null), r5);
    }

    public final <T, R> Object mutateWith(T r8, MutatePriority r9, Function2<? super T, ? super Continuation<? super R>, ? extends Object> r10, Continuation<? super R> r11) {
        return CoroutineScopeKt.coroutineScope(new C02432(r9, this, r10, r8, null), r11);
    }

    public static /* synthetic */ Object mutate$default(InternalMutatorMutex r0, MutatePriority r1, Function1 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return r0.mutate(r1, r2, r3);
    }

    public static /* synthetic */ Object mutateWith$default(InternalMutatorMutex r0, Object r1, MutatePriority r2, Function2 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = MutatePriority.Default;
    L6:
        return r0.mutateWith(r1, r2, r3, r4);
    }
}
