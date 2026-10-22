package com.ss.android.lark.image.impl.avatar;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.image.entity.AvatarImage;
import java.io.InputStream;
import rkb.a;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: classes36.dex */
public class AvatarImageLoader implements d<AvatarImage, InputStream> {

    public static class Factory implements e<AvatarImage, InputStream> {
        public Factory() {
        }

        @Override // rkb.e
        public void teardown() {
        }

        @Override // rkb.e
        public d<AvatarImage, InputStream> build(MultiModelLoaderFactory r100) {
            return new AvatarImageLoader();
        }
    }

    public AvatarImageLoader() {
    }

    @Override // rkb.d
    public /* bridge */ /* synthetic */ a<InputStream> getResourceFetcher(AvatarImage r100, int r101, int r102) {
        return getResourceFetcher2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: getResourceFetcher, reason: avoid collision after fix types in other method */
    public a<InputStream> getResourceFetcher2(AvatarImage r100, int r101, int r102) {
        return new AvatarImageDataFetcher(r100);
    }
}
