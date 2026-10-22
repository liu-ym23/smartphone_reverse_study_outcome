package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestListener extends ProducerListener {
    void onRequestCancellation(String r100);

    void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103);

    void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103);

    void onRequestSuccess(ImageRequest r100, String r101, boolean r102);
}
