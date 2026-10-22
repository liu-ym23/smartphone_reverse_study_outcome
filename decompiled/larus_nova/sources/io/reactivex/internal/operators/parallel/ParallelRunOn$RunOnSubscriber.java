package io.reactivex.internal.operators.parallel;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.ele.lancet.base.annotations.Skip;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    final b<? super T> downstream;

    @Override // java.lang.Runnable
    public void run() {
        io_reactivex_internal_operators_parallel_ParallelRunOn$RunOnSubscriber_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void io_reactivex_internal_operators_parallel_ParallelRunOn$RunOnSubscriber__run$___twin___() {
        int r100 = this.consumed;
        SpscArrayQueue<T> r101 = this.queue;
        b<? super T> r102 = this.downstream;
        int r103 = this.limit;
        int r104 = 1;
    L3:
        long r105 = this.requested.get();
        long r110 = 0;
    L5:
        if (r110 == r105) goto L29;
        if (this.cancelled == true) goto L8;
        boolean r111 = this.done;
        if (r111 == false) goto L16;
        Throwable r112 = this.error;
        if (r112 == null) goto L16;
        r101.clear();
        r102.onError(r112);
        this.worker.dispose();
        return;
    L16:
        T r113 = r101.poll();
        if (r113 != null) goto L19;
        boolean r114 = true;
    L20:
        if (r111 == false) goto L24;
        if (r114 == false) goto L24;
        r102.onComplete();
        this.worker.dispose();
        return;
    L24:
        if (r114 == true) goto L29;
        r102.onNext(r113);
        r110 = r110 + 1;
        r100 = r100 + 1;
        if (r100 != r103) goto L5;
        this.upstream.request(r100);
        r100 = 0;
        goto L5
    L19:
        r114 = false;
        goto L20
    L8:
        r101.clear();
        return;
    L29:
        if (r110 != r105) goto L45;
        if (this.cancelled == true) goto L32;
        if (this.done == false) goto L45;
        Throwable r115 = this.error;
        if (r115 != null) goto L38;
        if (r101.isEmpty() == false) goto L45;
        r102.onComplete();
        this.worker.dispose();
        return;
    L38:
        r101.clear();
        r102.onError(r115);
        this.worker.dispose();
        return;
    L32:
        r101.clear();
        return;
    L45:
        if (r110 != 0) goto L47;
    L49:
        int r106 = get();
        if (r106 == r104) goto L51;
        r104 = r106;
        goto L3
    L51:
        this.consumed = r100;
        r104 = addAndGet(-r104);
        if (r104 != 0) goto L3;
        return;
    L47:
        if (r105 == Long.MAX_VALUE) goto L49;
        this.requested.addAndGet(-r110);
        goto L49
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void io_reactivex_internal_operators_parallel_ParallelRunOn$RunOnSubscriber_com_larus_apm_impl_protector_RunnableLancet_run(ParallelRunOn$RunOnSubscriber r100) {
        r100.io_reactivex_internal_operators_parallel_ParallelRunOn$RunOnSubscriber__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber, io.reactivex.g, wwc.b
    public void onSubscribe(c r100) {
        if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        r100.request(this.prefetch);
        return;
    }

    public ParallelRunOn$RunOnSubscriber(b<? super T> r100, int r101, SpscArrayQueue<T> r102, Scheduler.Worker r103) {
        super(r101, r102, r103);
        this.downstream = r100;
    }
}
