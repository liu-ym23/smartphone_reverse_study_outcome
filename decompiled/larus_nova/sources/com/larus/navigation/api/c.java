package com.larus.navigation.api;

import com.larus.utils.logger.FLogger;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359656a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r102 = "MapApplet_".concat(r100);
        FLogger.f375446a.d(r102, r101);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("MapApplet_" + r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("MapApplet_" + r100, r101);
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.w("MapApplet_" + r100, r101);
    }

    public static void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r102 != null) goto L6;
        b(r100, r101);
        return;
    L6:
        String r103 = "MapApplet_".concat(r100);
        FLogger.f375446a.e(r103, r101 + '\n' + ExceptionsKt.stackTraceToString(r102));
    }
}
