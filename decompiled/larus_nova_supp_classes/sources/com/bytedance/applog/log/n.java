package com.bytedance.applog.log;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class n extends c {
    public static final a d = null;

    public static class a extends b<i> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final i a(Object[] r1) {
            return new h();
        }
    }

    static {
        d = new a();
    }

    public static i w() {
        return d.b(new Object[0]);
    }

    public n() {
    }

    @Override // com.bytedance.applog.log.i
    public final void d(Object... r4) {
        p(6, null, "Failed to clean sensitive fields", r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void a(String r2, Object... r3) {
        s(null, r2, null, r3);
    }

    @Override // com.bytedance.applog.log.i
    public final void i(String r3, Object... r4) {
        f(0, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void j(String r3, Object... r4) {
        k(0, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void l(String r3, Object... r4) {
        g(0, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void n(List r3, Object... r4) {
        s(r3, "can't find ET, should compile with ET", null, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void t(String r8, Object... r9) {
        v(0, 0, null, null, r8, r9);
    }

    @Override // com.bytedance.applog.log.i
    public final void b(int r2, String r3, Object... r4) {
        k(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void c(List<String> r2, String r3, Object... r4) {
        f(0, r2, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void e(List<String> r2, String r3, Object... r4) {
        g(0, r2, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void h(List<String> r2, String r3, Object... r4) {
        k(0, r2, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void m(int r2, String r3, Object... r4) {
        f(r2, null, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void q(String r2, Throwable r3, Object... r4) {
        s(null, r2, r3, r4);
    }

    @Override // com.bytedance.applog.log.i
    public final void f(int r8, List<String> r9, String r10, Object... r11) {
        v(r8, 3, r9, null, r10, r11);
    }

    @Override // com.bytedance.applog.log.i
    public final void g(int r8, List<String> r9, String r10, Object... r11) {
        v(r8, 2, r9, null, r10, r11);
    }

    @Override // com.bytedance.applog.log.i
    public final void k(int r8, List<String> r9, String r10, Object... r11) {
        v(r8, 1, r9, null, r10, r11);
    }

    @Override // com.bytedance.applog.log.i
    public final void o(int r7, String r8, Throwable r9, Object... r10) {
        r(r7, null, r8, r9, r10);
    }

    @Override // com.bytedance.applog.log.i
    public final void p(int r7, List<String> r8, String r9, Object... r10) {
        r(r7, r8, r9, null, r10);
    }

    @Override // com.bytedance.applog.log.i
    public final void s(List<String> r7, String r8, Throwable r9, Object... r10) {
        r(0, r7, r8, r9, r10);
    }

    @Override // com.bytedance.applog.log.i
    public final void r(int r8, List<String> r9, String r10, Throwable r11, Object... r12) {
        v(r8, 4, r9, r11, r10, r12);
    }
}
