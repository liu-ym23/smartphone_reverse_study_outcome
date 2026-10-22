package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes23.dex */
public class OkHttpImagePipelineConfigFactory {
    public OkHttpImagePipelineConfigFactory() {
    }

    public static ImagePipelineConfig.Builder newBuilder(Context r100, OkHttpClient r101) {
        return ImagePipelineConfig.newBuilder(r100).setNetworkFetcher(new OkHttpNetworkFetcher(r101));
    }
}
