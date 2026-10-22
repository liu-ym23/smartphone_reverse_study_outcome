package com.ss.android.lark.image.impl.album;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class AlbumSerialImageLoader implements d<AlbumSerialImage, InputStream> {

    public static class Factory implements e<AlbumSerialImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<AlbumSerialImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new AlbumSerialImageLoader();
        }
    }

    public AlbumSerialImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(AlbumSerialImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(AlbumSerialImage r100, int r101, int r102) {
        return new AlbumSerialImageDataFetcher(r100, r101, r102);
    }
}
