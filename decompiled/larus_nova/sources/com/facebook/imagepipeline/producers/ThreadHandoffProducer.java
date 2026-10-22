package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String EXTRA_PENDING_TIME = "pendingTime";
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final Producer<T> mInputProducer;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static /* synthetic */ Producer access$000(ThreadHandoffProducer r100) {
        return r100.mInputProducer;
    }

    public static /* synthetic */ ThreadHandoffProducerQueue access$100(ThreadHandoffProducer r100) {
        return r100.mThreadHandoffProducerQueue;
    }

    public ThreadHandoffProducer(Producer<T> r100, ThreadHandoffProducerQueue r101) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(r100);
        this.mThreadHandoffProducerQueue = r101;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<T> r110, final ProducerContext r111) {
        final ProducerListener r100 = r111.getListener();
        final String r101 = r111.getId();
        final String r102 = PRODUCER_NAME;
        final StatefulHandoffProducerRunnable<T> r112 = new AnonymousClass1(this, r110, r100, r102, r101, r100, r101, r110, r111);
        r111.addCallbacks(new AnonymousClass2(this, r112));
        this.mThreadHandoffProducerQueue.addToQueueOrExecute(r112);
    }
}
