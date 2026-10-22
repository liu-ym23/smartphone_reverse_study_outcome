package com.ss.android.lark.image.impl.video;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.VideoImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class VideoImageLoader implements d<VideoImage, InputStream> {

    public static class Factory implements e<VideoImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<VideoImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new VideoImageLoader();
        }
    }

    public VideoImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(VideoImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(VideoImage r100, int r101, int r102) {
        return new VideoImageDataFetcher(r100);
    }
}
