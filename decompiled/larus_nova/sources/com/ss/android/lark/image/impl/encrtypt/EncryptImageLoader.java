package com.ss.android.lark.image.impl.encrtypt;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.EncryptImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class EncryptImageLoader implements d<EncryptImage, InputStream> {

    public static class Factory implements e<EncryptImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<EncryptImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new EncryptImageLoader();
        }
    }

    public EncryptImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(EncryptImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(EncryptImage r100, int r101, int r102) {
        return new EncryptImageDataFetcher(r100);
    }
}
