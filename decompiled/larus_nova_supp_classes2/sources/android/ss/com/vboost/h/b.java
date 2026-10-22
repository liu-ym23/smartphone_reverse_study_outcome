package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f70a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f71b;

    public b() {
    }

    @Override // android.ss.com.vboost.h.c
    public void a() {
        LogUtil.debug(f70a, "release");
    }

    @Override // android.ss.com.vboost.h.c
    public void a(long r4) {
        if (f71b == null) goto L6;
        LogUtil.debug(f70a, "try boost timeout " + r4);
        f71b.a(r4);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public boolean a(Context r2) {
        if (f71b != null) goto L6;
        f71b = new a(r2);
    L6:
        if (f71b.a() == false) goto L9;
        LogUtil.info(f70a, "CHRYPerfInterface init.");
        return true;
    L9:
        return false;
    }

    @Override // android.ss.com.vboost.h.c
    public void b() {
        if (f71b == null) goto L6;
        LogUtil.debug(f70a, "try boost");
        f71b.a(30000);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void b(long r4) {
        if (f71b == null) goto L6;
        LogUtil.debug(f70a, "try boost gpu with timeout " + r4);
        f71b.a(r4);
        return;
    }

    @Override // android.ss.com.vboost.h.c
    public void c(long r4) {
        if (f71b == null) goto L6;
        LogUtil.debug(f70a, "try boost storage with timeout " + r4);
        f71b.a(r4);
        return;
    }
}
