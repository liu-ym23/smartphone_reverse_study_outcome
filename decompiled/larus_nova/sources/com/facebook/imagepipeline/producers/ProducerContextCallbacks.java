package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes23.dex */
public interface ProducerContextCallbacks {
    void onCancellationRequested();

    void onIsIntermediateResultExpectedChanged();

    void onIsPrefetchChanged();

    void onPriorityChanged();
}
