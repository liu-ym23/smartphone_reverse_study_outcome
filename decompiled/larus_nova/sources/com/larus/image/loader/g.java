package com.larus.image.loader;

import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRequest.CacheChoice f350969b;

    public g() {
        this("", ImageRequest.CacheChoice.DEFAULT);
    }

    public g(String r100, ImageRequest.CacheChoice r101) {
        Intrinsics.checkNotNullParameter(r100, "customCacheName");
        Intrinsics.checkNotNullParameter(r101, "cacheChoice");
        this.f350968a = r100;
        this.f350969b = r101;
    }
}
