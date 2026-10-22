package com.ss.android.lark.coremd.base.parse;

/* JADX INFO: loaded from: classes35.dex */
public interface s {

    public static final class a {
        public static /* synthetic */ void a(s r100, int r101) {
            r100.h(r101, r100.length(), 0);
        }

        public static /* synthetic */ void b(s r100, int r101) {
            r100.i(r101, r100.length());
        }

        public static /* synthetic */ void c(s r100, int r101, int r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = r100.length();
        L6:
            if ((r103 & 4) == 0) goto L8;
            int r104 = 33;
        L9:
            r100.f(r101, r102, r104);
            return;
        L8:
            r104 = 0;
            goto L9
        }
    }

    com.ss.android.lark.coremd.impl.parse.n a();

    com.ss.android.lark.coremd.impl.parse.n b();

    String c(int r100, int r101);

    com.ss.android.lark.coremd.impl.parse.n d(CharSequence r100);

    void e(CharSequence r100, com.ss.android.lark.coremdbiz.facade.plugins.t r101);

    void f(int r100, int r101, int r102);

    com.ss.android.lark.coremd.impl.parse.n g(CharSequence r100);

    void h(int r100, int r101, int r102);

    void i(int r100, int r101);

    int length();

    void setSpan(Object r100, int r101, int r102, int r103);
}
