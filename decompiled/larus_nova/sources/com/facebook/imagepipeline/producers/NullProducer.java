package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes23.dex */
public class NullProducer<T> implements Producer<T> {
    public NullProducer() {
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> r100, ProducerContext r101) {
        r100.onNewResult(null, 1);
    }
}
