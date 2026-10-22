package com.bytedance.lighten.loader;

import com.facebook.imagepipeline.cache.ValueDescriptor;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements ValueDescriptor<CloseableImage> {
    public a() {
    }

    @Override // com.facebook.imagepipeline.cache.ValueDescriptor
    public final int getSizeInBytes(CloseableImage r100) {
        return r100.getSizeInBytes();
    }
}
