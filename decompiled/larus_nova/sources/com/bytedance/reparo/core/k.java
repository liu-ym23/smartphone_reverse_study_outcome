package com.bytedance.reparo.core;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f267379a;

    public class a implements b {
        public a() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void a() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void b() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void d() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void e(String r100) {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void e(String r100, Throwable r101) {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void i() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void d(String r100) {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void c(String r100, String r101) {
        }
    }

    public interface b {
        void a();

        void b();

        void c(String r100, String r101);

        void d();

        void d(String r100);

        void e(String r100);

        void e(String r100, Throwable r101);

        void i();
    }

    public k() {
    }

    static {
        f267379a = new a();
    }

    public static void a(String r100, String r101) {
        f267379a.e(r101);
    }

    public static void c(String r100, String r101) {
        f267379a.i();
    }

    public static void d(String r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = r101[r103];
        if (r104 == null) goto L11;
        f267379a.c(r100, r104);
        r103 = r103 + 1;
        goto L3
    L11:
        return;
    }

    public static void e(String r100, String r101) {
        f267379a.a();
    }

    public static void b(String r100, String r101, Throwable r102) {
        f267379a.e(r101, r102);
    }
}
