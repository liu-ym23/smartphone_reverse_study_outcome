package com.bytedance.lighten.loader;

import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.BaseImageTraceListener;
import com.optimize.statistics.ImageTraceSampler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class v extends BaseImageTraceListener implements ImageTraceSampler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hf6.k f254782a;

    public v(hf6.k r100) {
        this.f254782a = r100;
    }

    @Override // com.optimize.statistics.ImageTraceListener
    public final void onImageLoaded(boolean r100, String r101, JSONObject r102) {
        this.f254782a.onImageLoaded();
    }

    @Override // com.optimize.statistics.ImageTraceSampler
    public final Boolean shouldSampleImageLoaded(ImageRequest r100, Object r101, String r102) {
        return this.f254782a.a();
    }
}
