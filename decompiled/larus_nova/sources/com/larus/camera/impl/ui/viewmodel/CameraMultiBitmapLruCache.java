package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class CameraMultiBitmapLruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CameraMultiBitmapLruCache$cache$1 f322602a;

    public CameraMultiBitmapLruCache() {
        this(10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.camera.impl.ui.viewmodel.CameraMultiBitmapLruCache$cache$1] */
    public CameraMultiBitmapLruCache(final int r100) {
        this.f322602a = new CameraMultiBitmapLruCache$cache$1(r100);
    }

    public final Bitmap a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return get(r100);
    }

    public final Bitmap b(String r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        return put(r100, r101);
    }
}
