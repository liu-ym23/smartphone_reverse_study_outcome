package com.ss.android.lark.image.uploader.utils;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426438a = 0;

    static {
    }

    public c() {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.d("ImageUploader_".concat(r100), r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.i("ImageUploader_".concat(r100), r101);
    }

    public static void b(String r100, String r101, Throwable r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r102 == null) goto L5;
        Log.e("ImageUploader_".concat(r100), r101, r102, r103);
        return;
    L5:
        if (r103 == false) goto L7;
        Log.e("ImageUploader_".concat(r100), r101, new Throwable(r101), r103);
        return;
    L7:
        Log.e("ImageUploader_".concat(r100), r101);
    }
}
