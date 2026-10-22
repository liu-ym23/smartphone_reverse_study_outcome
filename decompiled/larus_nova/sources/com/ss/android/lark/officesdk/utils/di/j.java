package com.ss.android.lark.officesdk.utils.di;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437226a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        DependencyContainer r102 = DependencyContainer.f433166a;
        ntb.n r103 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r103 == null) goto L6;
        r103.d(r100, r101);
        return;
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        c(r100, r101, null);
    }

    @JvmStatic
    public static final void d(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c(r100, "", r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        DependencyContainer r102 = DependencyContainer.f433166a;
        ntb.n r103 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r103 == null) goto L6;
        r103.i(r100, r101);
        return;
    }

    @JvmStatic
    public static final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        g(r100, r101, null);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r100, "tag");
        DependencyContainer r103 = DependencyContainer.f433166a;
        ntb.n r104 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r104 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r104.g(r100, r101, r102, false);
        return;
    }

    @JvmStatic
    public static final void g(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        DependencyContainer r103 = DependencyContainer.f433166a;
        ntb.n r104 = (ntb.n) DependencyContainer.a(ntb.n.class, null);
        if (r104 == null) goto L6;
        r104.w(r100, r101, r102);
        return;
    }
}
