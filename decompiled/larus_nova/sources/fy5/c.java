package fy5;

import android.content.Context;
import by5.n;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static av3.a f479288a;

    public static class a implements av3.a {
        public a() {
        }

        @Override // av3.a
        public final void a() {
            Context r100 = n.f21458a;
        }

        @Override // av3.a
        public final void b() {
            Context r100 = n.f21458a;
        }

        @Override // av3.a
        public final void d() {
            Context r100 = n.f21458a;
        }

        @Override // av3.a
        public final void i() {
            Context r100 = n.f21458a;
        }

        @Override // av3.a
        public void e(String r100, String r101) {
            Context r102 = n.f21458a;
        }

        @Override // av3.a
        public void e(String r100, String r101, Throwable r102) {
            Context r103 = n.f21458a;
        }
    }

    static {
        f479288a = new a();
    }

    public static void a(String r100) {
        av3.a r101 = f479288a;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }

    public static void b(String r100, String r101) {
        av3.a r102 = f479288a;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public static void c(String r100, Throwable r101) {
        av3.a r102 = f479288a;
        if (r102 == null) goto L6;
        r102.e("APM-SDK", r100, r101);
        return;
    }

    public static void d(String r100, String r101) {
        av3.a r102 = f479288a;
        if (r102 == null) goto L6;
        r102.i();
        return;
    }
}
