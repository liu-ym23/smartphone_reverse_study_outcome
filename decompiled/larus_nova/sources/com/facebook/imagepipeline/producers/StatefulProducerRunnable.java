package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
    private final Consumer<T> mConsumer;
    private final ProducerListener mProducerListener;
    private final String mProducerName;
    private final String mRequestId;

    @Override // com.facebook.common.executors.StatefulRunnable
    public abstract void disposeResult(T r100);

    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    public Map<String, String> getExtraMapOnFailure(Exception r100) {
        return null;
    }

    public Map<String, String> getExtraMapOnSuccess(T r100) {
        return null;
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        ProducerListener r100 = this.mProducerListener;
        String r101 = this.mRequestId;
        String r102 = this.mProducerName;
        if (r100.requiresExtraMap(r101) == false) goto L5;
        Map<String, String> r103 = getExtraMapOnCancellation();
    L6:
        r100.onProducerFinishWithCancellation(r101, r102, r103);
        this.mConsumer.onCancellation();
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception r100) {
        ProducerListener r101 = this.mProducerListener;
        String r102 = this.mRequestId;
        String r103 = this.mProducerName;
        if (r101.requiresExtraMap(r102) == false) goto L5;
        Map<String, String> r104 = getExtraMapOnFailure(r100);
    L6:
        r101.onProducerFinishWithFailure(r102, r103, r100, r104);
        this.mConsumer.onFailure(r100);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T r100) {
        ProducerListener r101 = this.mProducerListener;
        String r102 = this.mRequestId;
        String r103 = this.mProducerName;
        if (r101.requiresExtraMap(r102) == false) goto L5;
        Map<String, String> r104 = getExtraMapOnSuccess(r100);
    L6:
        r101.onProducerFinishWithSuccess(r102, r103, r104);
        this.mConsumer.onNewResult(r100, 1);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public StatefulProducerRunnable(Consumer<T> r100, ProducerListener r101, String r102, String r103) {
        this.mConsumer = r100;
        this.mProducerListener = r101;
        this.mProducerName = r102;
        this.mRequestId = r103;
        r101.onProducerStart(r103, r102);
    }
}
