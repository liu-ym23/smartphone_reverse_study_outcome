package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbsDiskWriteReadListener implements RequestListener {
    public AbsDiskWriteReadListener() {
    }

    public abstract byte[] decrypt(InputStream r100);

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String r100, String r101, String r102) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String r100, String r101, Map<String, String> r102) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String r100, String r101, Throwable r102, Map<String, String> r103) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String r100, String r101, Map<String, String> r102) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String r100, String r101) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String r100) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String r100, String r101, boolean r102) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String r100) {
        return false;
    }
}
