package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ProducerContext r110) {
        this(r110.getImageRequest(), r110.getId(), r110.getListener(), r110.getCallerContext(), r110.getLowestPermittedRequestLevel(), r110.isPrefetch(), r110.isIntermediateResultExpected(), r110.getPriority());
    }

    public void setIsIntermediateResultExpected(boolean r100) {
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(r100));
    }

    public void setIsPrefetch(boolean r100) {
        BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(r100));
    }

    public void setPriority(Priority r100) {
        BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(r100));
    }

    public SettableProducerContext(ImageRequest r110, ProducerContext r111) {
        this(r110, r111.getId(), r111.getListener(), r111.getCallerContext(), r111.getLowestPermittedRequestLevel(), r111.isPrefetch(), r111.isIntermediateResultExpected(), r111.getPriority());
    }

    public SettableProducerContext(ImageRequest r100, String r101, ProducerListener r102, Object r103, ImageRequest.RequestLevel r104, boolean r105, boolean r106, Priority r107) {
        super(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
