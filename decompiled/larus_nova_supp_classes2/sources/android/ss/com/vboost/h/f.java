package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f83a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f84b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f85c = 10;
    private static int d = -1;
    private static int e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f86f = 1500000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f87g = 2000000;

    public f() {
    }

    private void c() {
        e = e.a();
        f86f = e.a(0);
        f87g = e.a(6);
    }

    private void d() {
        int r0 = d;
        if (r0 == (-1)) goto L6;
        f84b.a(r0);
        LogUtil.debug(f83a, "userDisableIfNeed  sCurPerfHandle = " + d);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        d();
        LogUtil.debug(f83a, "release");
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r19) {
        d();
        g r2 = f84b;
        if (r2 == null) goto L8;
        int r3 = r2.b();
        d = r3;
        if ((-1) == r3) goto L9;
        LogUtil.debug(f83a, "try boost timeout " + r19);
        f84b.a(d, 10, 3, -1, -1, -1);
        f84b.a(d, 1, e, -1, -1, -1);
        f84b.a(d, 4, f87g, -1, -1, -1);
        f84b.a(d, 6, f87g, f86f, -1, -1);
        f84b.a(d, 23, 1000, -1, -1, -1);
        f84b.a(d, (int) r19);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r3) {
        if (f84b != null) goto L12;
        g r0 = new g(r3);
        f84b = r0;
        if (r0.a() == false) goto L12;
        f84b.b(0);
        f85c = f84b.b(3);
        int r4 = f84b.b();
        d = r4;
        if (r4 != (-1)) goto L10;
        LogUtil.warn(f83a, "it not support PerfService!");
        return false;
    L10:
        c();
        LogUtil.info(f83a, "MTKPerfInterface init.");
        return true;
    L12:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        d();
        g r0 = f84b;
        if (r0 == null) goto L8;
        int r1 = r0.b();
        d = r1;
        if ((-1) == r1) goto L9;
        LogUtil.debug(f83a, "try boost");
        f84b.a(d, 10, 3, -1, -1, -1);
        f84b.a(d, 1, e, -1, -1, -1);
        f84b.a(d, 4, f87g, -1, -1, -1);
        f84b.a(d, 6, f87g, f86f, -1, -1);
        f84b.a(d, 23, 1000, -1, -1, -1);
        f84b.a(d, 30000);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r17) {
        d();
        g r0 = f84b;
        if (r0 == null) goto L8;
        int r1 = r0.b();
        d = r1;
        if ((-1) == r1) goto L9;
        LogUtil.debug(f83a, "try boost gpu");
        f84b.a(d, 10, 3, -1, -1, -1);
        f84b.a(d, 8, f85c, -1, -1, -1);
        f84b.a(d, (int) r17);
        return;
    L9:
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r10) {
        d();
        g r0 = f84b;
        if (r0 == null) goto L8;
        int r1 = r0.b();
        d = r1;
        if ((-1) == r1) goto L9;
        LogUtil.debug(f83a, "try boost storage");
        f84b.a(d, 10, 3, -1, -1, -1);
        f84b.a(d, (int) r10);
        return;
    L9:
        return;
    }
}
