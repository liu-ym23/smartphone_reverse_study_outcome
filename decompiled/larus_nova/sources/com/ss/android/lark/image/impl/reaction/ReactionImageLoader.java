package com.ss.android.lark.image.impl.reaction;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.ReactionImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class ReactionImageLoader implements d<ReactionImage, InputStream> {

    public static class Factory implements e<ReactionImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<ReactionImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new ReactionImageLoader();
        }
    }

    public ReactionImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(ReactionImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(ReactionImage r100, int r101, int r102) {
        return new ReactionImageDataFetcher(r100);
    }
}
