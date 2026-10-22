package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public class ThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "ThrottlingProducer";
    private final Executor mExecutor;
    private final Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private int mNumCurrentRequests;
    private final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.producers.ThrottlingProducer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        final /* synthetic */ ThrottlingProducer this$0;

        private void onRequestFinished() {
            ThrottlingProducer r100 = this.this$0;
            monitor-enter(r100);
            final Pair r101 = (Pair) ThrottlingProducer.access$100(this.this$0).poll();     // Catch: Throwable -> L11
            if (r101 != null) goto L7;
            ThrottlingProducer.access$210(this.this$0);     // Catch: Throwable -> L11
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L11
            if (r101 == null) goto L16;
            ThrottlingProducer.access$300(this.this$0).execute(new AnonymousClass1(this, r101));
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable r100) {
            getConsumer().onFailure(r100);
            onRequestFinished();
        }

        private ThrottlerConsumer(ThrottlingProducer r100, Consumer<T> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T r100, int r101) {
            getConsumer().onNewResult(r100, r101);
            if (BaseConsumer.isLast(r101) == false) goto L6;
            onRequestFinished();
            return;
        }

        public /* synthetic */ ThrottlerConsumer(ThrottlingProducer r100, Consumer r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static /* synthetic */ ConcurrentLinkedQueue access$100(ThrottlingProducer r100) {
        return r100.mPendingRequests;
    }

    public static /* synthetic */ int access$210(ThrottlingProducer r100) {
        int r101 = r100.mNumCurrentRequests;
        r100.mNumCurrentRequests = r101 - 1;
        return r101;
    }

    public static /* synthetic */ Executor access$300(ThrottlingProducer r100) {
        return r100.mExecutor;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> r100, ProducerContext r101) {
        r101.getListener().onProducerStart(r101.getId(), PRODUCER_NAME);
        monitor-enter(this);
        int r102 = this.mNumCurrentRequests;     // Catch: Throwable -> L12
        boolean r103 = true;
        if (r102 < this.mMaxSimultaneousRequests) goto L7;
        this.mPendingRequests.add(Pair.create(r100, r101));     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r103 == true) goto L17;
        produceResultsInternal(r100, r101);
        return;
    L17:
        return;
    L7:
        this.mNumCurrentRequests = r102 + 1;     // Catch: Throwable -> L12
        r103 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public void produceResultsInternal(Consumer<T> r100, ProducerContext r101) {
        r101.getListener().onProducerFinishWithSuccess(r101.getId(), PRODUCER_NAME, null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(this, r100, null), r101);
    }

    public ThrottlingProducer(int r100, Executor r101, Producer<T> r102) {
        this.mMaxSimultaneousRequests = r100;
        this.mExecutor = (Executor) Preconditions.checkNotNull(r101);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(r102);
        this.mPendingRequests = new ConcurrentLinkedQueue();
        this.mNumCurrentRequests = 0;
    }
}
