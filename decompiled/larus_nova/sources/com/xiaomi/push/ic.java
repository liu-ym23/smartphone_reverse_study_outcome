package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f464107a = Integer.MAX_VALUE;

    public static void a(hz r100, byte r101) {
        a(r100, r101, f464107a);
    }

    public static void a(hz r100, byte r101, int r102) {
        if (r102 <= 0) goto L37;
        int r103 = 0;
        switch(r101) {
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            case 5: goto L56;
            case 6: goto L31;
            case 7: goto L56;
            case 8: goto L30;
            case 9: goto L56;
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L21;
            case 13: goto L16;
            case 14: goto L11;
            case 15: goto L6;
            default: goto L56;
        };
    L6:
        hx r104 = r100.mo9272a();
    L8:
        if (r103 >= r104.f952a) goto L10;
        a(r100, r104.f464096a, r102 - 1);
        r103 = r103 + 1;
        goto L8
    L10:
        r100.i();
        return;
    L11:
        id r105 = r100.mo9274a();
    L13:
        if (r103 >= r105.f957a) goto L15;
        a(r100, r105.f464108a, r102 - 1);
        r103 = r103 + 1;
        goto L13
    L15:
        r100.j();
        return;
    L16:
        hy r106 = r100.mo9273a();
    L18:
        if (r103 >= r106.f953a) goto L20;
        int r107 = r102 - 1;
        a(r100, r106.f464097a, r107);
        a(r100, r106.f464098b, r107);
        r103 = r103 + 1;
        goto L18
    L20:
        r100.h();
        return;
    L21:
        r100.mo9275a();
    L22:
        byte r108 = r100.mo9271a().f464095a;
        if (r108 == 0) goto L24;
        a(r100, r108, r102 - 1);     // Catch: Throwable -> L38
        r100.g();
    L38:
        th = move-exception;
        throw th;
    L24:
        r100.f();
        return;
    L28:
        r100.mo9277a();
        return;
    L29:
        r100.mo9270a();
        return;
    L30:
        r100.mo9269a();
        return;
    L31:
        r100.mo9278a();
        return;
    L32:
        r100.mo9268a();
        return;
    L33:
        r100.a();
        return;
    L34:
        r100.mo9281a();
        return;
    L56:
        return;
    L37:
        throw new ht("Maximum skip depth exceeded");
    }
}
