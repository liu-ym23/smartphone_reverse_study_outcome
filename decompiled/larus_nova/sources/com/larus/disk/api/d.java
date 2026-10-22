package com.larus.disk.api;

/* JADX INFO: loaded from: classes4.dex */
public interface d extends c {

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {
        public static boolean a(d r100, boolean r101, boolean r102) {
            if (r102 == false) goto L4;
            long r103 = r100.d();
        L6:
            if (r103 > 0) goto L8;
            return true;
        L8:
            return false;
        L4:
            r103 = r100.b(r101);
            goto L6
        }
    }

    boolean c(boolean r100, boolean r101);

    long d();

    boolean e(boolean r100);

    boolean f();

    boolean g();
}
