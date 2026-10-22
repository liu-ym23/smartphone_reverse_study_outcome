package com.bytedance.gkfs;

import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f245127c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f245128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245129b;

    public static final class a {
        public static c a() {
            return c.f245127c;
        }
    }

    static {
        f245127c = new c();
    }

    public c() {
        this.f245128a = new AtomicInteger(-1);
        this.f245129b = hashCode();
    }

    public final String d(String r100, String r101, int r102) {
        StringBuilder r103 = new StringBuilder("[");
        r103.append(this.f245129b);
        r103.append("][");
        r103.append(r100);
        r103.append("][");
        r103.append(r102);
        r103.append(']');
        if (UtilsKt.d() == false) goto L5;
        String r104 = "[" + ThreadMethodProxy.currentThread().getName() + ']';
    L6:
        r103.append(r104);
        r103.append(r101);
        return r103.toString();
    L5:
        r104 = "";
        goto L6
    }

    public final void a(String r100, String r101, int r102, boolean r103) {
        String r104 = d(r100, r101, r102);
        if (r103 == false) goto L5;
        GeckoLogger.d("gkfs-debug-tag", r104);
        return;
    L5:
        UtilsKt.d();
    }

    public static /* synthetic */ void b(c r100, String r101, String r102, int r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = r100.f245128a.get();
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = false;
    L8:
        r100.a(r101, r102, r103, r104);
    }

    public static void c(c r100, String r101, String r102, Throwable r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L5;
        int r106 = r100.f245128a.get();
    L7:
        if ((r105 & 8) == 0) goto L10;
        r103 = null;
    L10:
        if ((r105 & 16) == 0) goto L12;
        r104 = true;
    L12:
        String r107 = r100.d(r101, r102, r106);
        if (r104 == false) goto L15;
        GeckoLogger.e("gkfs-debug-tag", r107, r103);
        return;
    L15:
        UtilsKt.d();
        return;
    L5:
        r106 = 0;
        goto L7
    }

    public static void e(c r100, String r101, String r102, int r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = r100.f245128a.get();
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = true;
    L8:
        String r106 = r100.d(r101, r102, r103);
        if (r104 == false) goto L11;
        GeckoLogger.w("gkfs-debug-tag", r106, null);
        return;
    L11:
        UtilsKt.d();
    }
}
