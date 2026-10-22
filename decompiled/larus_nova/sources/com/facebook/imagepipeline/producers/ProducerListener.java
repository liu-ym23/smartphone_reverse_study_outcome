package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface ProducerListener {
    void onProducerEvent(String r100, String r101, String r102);

    void onProducerFinishWithCancellation(String r100, String r101, @Nullable Map<String, String> r102);

    void onProducerFinishWithFailure(String r100, String r101, Throwable r102, @Nullable Map<String, String> r103);

    void onProducerFinishWithSuccess(String r100, String r101, @Nullable Map<String, String> r102);

    void onProducerStart(String r100, String r101);

    void onUltimateProducerReached(String r100, String r101, boolean r102);

    boolean requiresExtraMap(String r100);
}
