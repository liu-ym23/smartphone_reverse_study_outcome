package com.bytedance.bdinstall;

import android.content.Context;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f199593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f199594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f199595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f199596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f199597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i0.d.a f199598g;

    /* JADX INFO: loaded from: classes8.dex */
    public @interface Error {
        public static final int ERR_NETWORK = 1;
        public static final int ERR_REQUEST_FAILED = 3;
        public static final int ERR_RETRY_LIMIT_FAILED = 4;
        public static final int ERR_TIME_NOT_READY = 2;
        public static final int UNKNOWN = 0;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f199599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f199600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f199601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f199602d;

        public a() {
            this.f199599a = false;
            this.f199600b = 0;
            this.f199601c = 0;
            this.f199602d = 0;
        }
    }

    public abstract void a();

    public abstract boolean b() throws JSONException;

    public abstract String c();

    public abstract long[] d();

    public abstract void e();

    public abstract void f();

    public abstract long g();

    public abstract void h(boolean r100);

    public abstract void i(int r100);

    public final a j() {
        f();
        int r100 = 1;
        boolean r101 = false;
        if (i84.j.a(this.f199592a) == false) goto L5;
        boolean r102 = true;
    L6:
        a r103 = new a();
        if (r102 == true) goto L9;
        t.b("network not ready. delay 60000 ms do " + c());
        long r104 = 60000;
    L26:
        r103.f199600b = r100;
        r103.f199599a = r101;
        r103.f199601c = r104;
        return r103;
    L9:
        long r105 = this.f199595d + g();
        long r106 = System.currentTimeMillis();
        if (r105 <= (1000 + r106)) goto L28;
        r104 = r105 - r106;
        t.a(c() + "time not ready. need " + r104);
        r100 = 2;
        goto L26
    L28:
        boolean r107 = b();     // Catch: Exception -> L13
    L15:
        if (r107 == false) goto L17;
        r103.f199602d = this.f199594c;
        this.f199594c = 0;
        this.f199595d = System.currentTimeMillis();
        r104 = g();
        r100 = 0;
        r101 = true;
    L22:
        String r108 = c() + " worked:" + r107 + " " + r104;
        f0 r109 = t.f199791b;
        if (r109 == null) goto L26;
        r109.i("bdinstall# " + r108, null);
        goto L26
    L17:
        long[] r110 = d();
        int r111 = this.f199594c;
        int r112 = r111 + 1;
        this.f199594c = r112;
        int r113 = r111 % r110.length;
        long r114 = r110[r113];
        if (r113 != (r110.length - 1)) goto L20;
        r103.f199602d = r112;
        r100 = 4;
    L21:
        r104 = r114;
        goto L22
    L20:
        r100 = 3;
    L13:
        e = move-exception;
        e.printStackTrace();
        t.c("worer", e);
        r107 = false;
        goto L15
    L5:
        r102 = false;
        goto L6
    }

    public BaseWorker(Context r100, o0 r101) {
        this.f199594c = 0;
        this.f199592a = r100;
        this.f199593b = r101;
        this.f199596e = k.k(String.valueOf(r101.f199728a));
    }

    public BaseWorker(Context r100, o0 r101, long r102) {
        this.f199594c = 0;
        this.f199592a = r100;
        this.f199593b = r101;
        this.f199595d = r102;
        this.f199596e = k.k(String.valueOf(r101.f199728a));
    }
}
