package com.optimize.statistics.sampling;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface IFrescoMonitorSamplingDecider {
    boolean shouldSampleFinalImageSet(ImageRequest r100, Map r101);

    boolean shouldSampleRequestSuccess(ImageRequest r100, String r101, Object r102);
}
