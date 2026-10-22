package com.larus.account.saas.runtime.internal.delegate;

import com.larus.init.task.accountsdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d48.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f286466a = null;

    static {
        f286466a = new a();
    }

    public a() {
    }

    public static d48.b c() {
        d48.d r100 = c48.a.f22412a;
        d48.d r101 = c48.a.f22412a;
        if (r101 == null) goto L5;
        r101.e();
        return e.f351141a;
    L5:
        return null;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r102 = c();
        if (r102 == null) goto L6;
        ((e) r102).a("FAS_" + r100, r101);
        return;
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r102 = c();
        if (r102 == null) goto L6;
        ((e) r102).c("FAS_" + r100, r101);
        return;
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r102 = c();
        if (r102 == null) goto L6;
        ((e) r102).d("FAS_" + r100, r101);
        return;
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r102 = c();
        if (r102 == null) goto L6;
        ((e) r102).e("FAS_" + r100, r101);
        return;
    }

    public final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r103 = c();
        if (r103 == null) goto L6;
        ((e) r103).b("FAS_" + r100, r101, r102);
        return;
    }

    public final void g(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d48.b r103 = c();
        if (r103 == null) goto L6;
        ((e) r103).f("FAS_" + r100, r101, r102);
        return;
    }
}
