package com.larus.avlink;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 {
    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.d("Hardix", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e("Hardix", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.i("Hardix", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.w("Hardix", r100 + "- " + r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        FLogger.f375446a.e("Hardix", r100 + "- " + r101, r102);
    }
}
