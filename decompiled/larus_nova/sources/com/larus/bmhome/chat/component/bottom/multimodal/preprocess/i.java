package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.graphics.Bitmap;
import android.os.Build;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f299947a = null;

        static {
            int[] r100 = new int[Bitmap.CompressFormat.values().length];
            r100[Bitmap.CompressFormat.JPEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[Bitmap.CompressFormat.PNG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[Bitmap.CompressFormat.WEBP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Bitmap.CompressFormat.WEBP_LOSSLESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[Bitmap.CompressFormat.WEBP_LOSSY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f299947a = r100;
        }
    }

    public static final String a(Bitmap.CompressFormat r110) {
        int r100 = -1;
        if (Build.VERSION.SDK_INT < 30) goto L15;
        if (r110 == null) goto L7;
        r100 = a.f299947a[r110.ordinal()];
    L7:
        if (r100 == 1) goto L25;
        if (r100 == 2) goto L27;
        if (r100 == 3) goto L26;
        if (r100 == 4) goto L26;
        if (r100 == 5) goto L26;
        return LoadParams.ImageFormat.JPEG;
    L26:
        return "webp";
    L27:
        return LoadParams.ImageFormat.PNG;
    L25:
        return "jpg";
    L15:
        if (r110 == null) goto L18;
        r100 = a.f299947a[r110.ordinal()];
    L18:
        if (r100 == 1) goto L25;
        if (r100 == 2) goto L27;
        if (r100 == 3) goto L26;
        return LoadParams.ImageFormat.JPEG;
    }

    public static final int b(Bitmap.CompressFormat r100, int r101, boolean r102) {
        int r103 = RangesKt.coerceIn(r101, 0, 100);
        if (Build.VERSION.SDK_INT < 30) goto L5;
    L10:
        return r103;
    L5:
        if (Intrinsics.areEqual(a(r100), "webp") == false) goto L10;
        if (r103 != 100) goto L10;
        if (r102 == true) goto L10;
        return 99;
    }
}
