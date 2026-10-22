package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f364440a = 0;

    static {
    }

    public static Fragment a(Fragment r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "clazz");
    L3:
        if (r100 == null) goto L8;
        if (r101.isInstance(r100) == true) goto L6;
        r100 = r100.getParentFragment();
        goto L3
    L6:
        return r100;
    L8:
        return null;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.d("MediaGalleryV2_" + r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("MediaGalleryV2_" + r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("MediaGalleryV2_" + r100, r101);
    }
}
