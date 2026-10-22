package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.PriorityRunnable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class StatefulPriorityProducerRunnable<T> extends StatefulProducerRunnable<T> implements PriorityRunnable {
    private int mPriority;

    @Override // com.facebook.common.executors.PriorityRunnable
    public int getPriority() {
        return this.mPriority;
    }

    public StatefulPriorityProducerRunnable(Consumer<T> r100, ProducerListener r101, String r102, String r103, int r104) {
        super(r100, r101, r102, r103);
        this.mPriority = r104;
    }
}
