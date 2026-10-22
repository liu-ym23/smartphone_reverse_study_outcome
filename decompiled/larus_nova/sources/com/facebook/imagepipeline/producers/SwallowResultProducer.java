package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes23.dex */
public class SwallowResultProducer<T> implements Producer<Void> {
    private final Producer<T> mInputProducer;

    public SwallowResultProducer(Producer<T> r100) {
        this.mInputProducer = r100;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<Void> r100, ProducerContext r101) {
        DelegatingConsumer<T, Void> r102 = new AnonymousClass1(this, r100);
        this.mInputProducer.produceResults(r102, r101);
    }
}
