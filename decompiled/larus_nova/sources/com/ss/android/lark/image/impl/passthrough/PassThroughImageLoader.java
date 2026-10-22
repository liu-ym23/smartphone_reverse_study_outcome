package com.ss.android.lark.image.impl.passthrough;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.PassThroughImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class PassThroughImageLoader implements d<PassThroughImage, InputStream> {

    public static class Factory implements e<PassThroughImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<PassThroughImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new PassThroughImageLoader();
        }
    }

    public PassThroughImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(PassThroughImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(PassThroughImage r100, int r101, int r102) {
        return new PassThroughImageDataFetcher(r100);
    }
}
