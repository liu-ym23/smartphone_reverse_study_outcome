package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class cr {

    /* JADX INFO: renamed from: com.xiaomi.push.cr$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f463281a = null;

        static {
            int[] r100 = new int[ge.values().length];
            f463281a = r100;
            r100[ge.f463646a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f463281a[ge.f463647b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f463281a[ge.f463648c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f463281a[ge.f463649d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f463281a[ge.f463650e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f463281a[ge.f463651f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f463281a[ge.f463652g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f463281a[ge.f463653h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f463281a[ge.f463656k.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f463281a[ge.f463657l.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f463281a[ge.f463654i.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f463281a[ge.f463655j.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static int a(ge r100) {
        return dr.a(r100.a());
    }

    public static int a(hp r100, ge r101) {
        switch(AnonymousClass1.f463281a[r101.ordinal()]) {
            case 1: goto L45;
            case 2: goto L45;
            case 3: goto L45;
            case 4: goto L45;
            case 5: goto L45;
            case 6: goto L45;
            case 7: goto L45;
            case 8: goto L45;
            case 9: goto L45;
            case 10: goto L45;
            case 11: goto L24;
            case 12: goto L5;
            default: goto L51;
        };
    L5:
        int r102 = dr.a(r101.a());
        if (r100 == null) goto L49;
    L22:
        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Command type error");
        goto L49
    L8:
        if ((r100 instanceof gz) == false) goto L15;
        String r103 = ((gz) r100).b();     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r103) == true) goto L49;
        if (ec.a(r103) == (-1)) goto L49;
        r102 = ec.a(r103);     // Catch: Exception -> L22
        goto L49
    L15:
        if ((r100 instanceof gy) == false) goto L49;
        String r104 = ((gy) r100).a();     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r104) == true) goto L49;
        if (ec.a(r104) == (-1)) goto L49;
        return ec.a(r104);
    L49:
        return r102;
    L24:
        r102 = dr.a(r101.a());
        if (r100 == null) goto L49;
    L43:
        com.xiaomi.channel.commonutils.logger.b.d("PERF_ERROR : parse Notification type error");
        return r102;
    L27:
        if ((r100 instanceof gv) == false) goto L34;
        String r105 = ((gv) r100).f735d;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r105) == true) goto L49;
        if (dr.a(dr.m9024a(r105)) == (-1)) goto L49;
        r102 = dr.a(dr.m9024a(r105));     // Catch: Exception -> L43
        goto L49
    L34:
        if ((r100 instanceof hd) == false) goto L49;
        String r106 = ((hd) r100).f794d;     // Catch: Exception -> L43
        if (TextUtils.isEmpty(r106) == true) goto L49;
        if (dr.a(dr.m9024a(r106)) == (-1)) goto L41;
        r102 = dr.a(dr.m9024a(r106));     // Catch: Exception -> L43
    L41:
        if (go.B.equals(dr.m9024a(r106)) == false) goto L49;
        return -1;
    L51:
        return -1;
    L45:
        return dr.a(r101.a());
    }

    public static int a(Context r100, int r101) {
        int r102 = fy.a(r100);
        if ((-1) != r102) goto L5;
        return -1;
    L5:
        if (r102 != 0) goto L7;
        int r103 = 13;
    L9:
        return (r101 * r103) / 10;
    L7:
        r103 = 11;
        goto L9
    }

    public static void a(String r100, Context r101, byte[] r102) {
        if (r101 == null) goto L14;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L16;
        ha r103 = new ha();
        ho.a(r103, r102);     // Catch: ht -> L10
        a(r100, r101, r103, r102.length);     // Catch: ht -> L10
        return;
    L10:
        com.xiaomi.channel.commonutils.logger.b.m8718a("fail to convert bytes to container");
        return;
    L16:
        return;
    }

    public static void a(String r100, Context r101, int r102, int r110) {
        if (r102 <= 0) goto L8;
        if (r110 <= 0) goto L9;
        int r111 = a(r101, r110);
        if (r102 == dr.a(go.B)) goto L10;
        ds.a(r101.getApplicationContext()).a(r100, r102, 1, r111);
        return;
    L10:
        return;
    L9:
        return;
    }

    public static void a(String r100, Context r101, ha r102, int r103) {
        if (r101 == null) goto L15;
        if (r102 == null) goto L17;
        ge r104 = r102.a();
        if (r104 == null) goto L16;
        int r105 = a(r104);
        if (r103 > 0) goto L13;
        byte[] r106 = ho.a(r102);
        if (r106 == null) goto L12;
        r103 = r106.length;
        goto L13
    L12:
        r103 = 0;
    L13:
        a(r100, r101, r105, r103);
        return;
    L16:
        return;
    L17:
        return;
    }

    public static void a(String r100, Context r101, hp r102, ge r103, int r104) {
        a(r100, r101, a(r102, r103), r104);
    }
}
