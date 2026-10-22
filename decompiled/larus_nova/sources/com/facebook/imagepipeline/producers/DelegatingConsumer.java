package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes23.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {
    private final Consumer<O> mConsumer;

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onCancellationImpl() {
        this.mConsumer.onCancellation();
    }

    public Consumer<O> getConsumer() {
        return this.mConsumer;
    }

    public DelegatingConsumer(Consumer<O> r100) {
        this.mConsumer = r100;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onFailureImpl(Throwable r100) {
        this.mConsumer.onFailure(r100);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onProgressUpdateImpl(float r100) {
        this.mConsumer.onProgressUpdate(r100);
    }
}
