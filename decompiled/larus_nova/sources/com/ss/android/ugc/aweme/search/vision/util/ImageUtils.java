package com.ss.android.ugc.aweme.search.vision.util;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/util/ImageUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageUtils f454041a = null;

    private ImageUtils() {
    }

    static {
        f454041a = new ImageUtils();
    }

    public static void a(final String r100, final DownloadImageToCacheCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ThreadUtils.f454048b.getClass();
        ExecutorService r102 = ThreadUtils.a();
        if (r102 == null) goto L6;
        r102.execute(new ImageUtils$downloadImageToCache$1(r100, r101));
        return;
    }
}
