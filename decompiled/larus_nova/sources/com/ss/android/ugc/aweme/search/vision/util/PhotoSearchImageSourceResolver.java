package com.ss.android.ugc.aweme.search.vision.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.ss.android.ugc.aweme.search.utils.BitmapUtil;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoSearchBitmapHolder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/util/PhotoSearchImageSourceResolver;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchImageSourceResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PhotoSearchImageSourceResolver f454045a = null;

    private PhotoSearchImageSourceResolver() {
    }

    static {
        f454045a = new PhotoSearchImageSourceResolver();
    }

    public static void a(PhotoEnterModel r100) {
        if ((!TextUtils.isEmpty(r100.getSearchImageUrl())) == false) goto L5;
        return;
    L5:
        if ((!TextUtils.isEmpty(r100.getLocalFilePath())) == false) goto L8;
        return;
    L8:
        if (r100.getEnableImageMemoryStorage() != 1) goto L14;
        int r101 = PhotoSearchBitmapHolder.f453599a;
        return;
    }

    public static byte[] b(PhotoEnterModel r100) {
        if (r100 == null) goto L14;
        Bitmap r101 = r100.getSearchBitmap();
        if (r101 == null) goto L14;
        if ((!r101.isRecycled()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L14;
        return BitmapUtil.a(BitmapUtil.f453398a, r101);
    L14:
        return null;
    }

    public static boolean c(PhotoEnterModel r100) {
        if (r100 == null) goto L8;
        Bitmap r101 = r100.getSearchBitmap();
        if (r101 == null) goto L8;
        if (r101.isRecycled() == true) goto L8;
        return true;
    L8:
        return false;
    }
}
