package n4a;

import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class q2 {
    public static byte[] c() {
        q1 r100 = q1.f517600c;
        r100.f517554a.j(r100.f517555b);
        int r101 = r100.f517554a.b(w2.f517849e);     // Catch: Exception -> L5
        int r102 = r100.f517554a.b(w2.f517846b);     // Catch: Exception -> L5
        int r103 = r100.f517554a.b(w2.f517852h);     // Catch: Exception -> L5
        int r104 = r100.f517554a.b(w2.f517851g);     // Catch: Exception -> L5
        int r110 = r100.f517554a.b(w2.f517850f);     // Catch: Exception -> L5
        int r111 = r100.f517554a.b(w2.f517853i);     // Catch: Exception -> L5
        long r112 = v2.a(w2.f517857m);     // Catch: Exception -> L5
        int r113 = r100.f517554a.b(w2.f517855k);     // Catch: Exception -> L5
        int r114 = r100.f517554a.b(w2.f517854j);     // Catch: Exception -> L5
        int r115 = r100.f517554a.b(w2.f517847c);     // Catch: Exception -> L5
        int r116 = r100.f517554a.b(w2.f517848d);     // Catch: Exception -> L5
        int r105 = x2.a(r100.f517554a, w2.f517845a, r101, r102, (byte) w2.f517856l, r103, r104, r110, r111, r112, r113, r114, r115, r116);     // Catch: Exception -> L5
        r100.f517554a.o(r105);     // Catch: Exception -> L5
        return r100.f517554a.q();
    L5:
        return null;
    }

    public static v1 a(s1.a r100) {
        if (s1.f517662f != null) goto L15;
        Object r101 = s1.f517663g;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s1.f517662f != null) goto L9;
        s1.f517662f = new s1();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return s1.f517662f.a(r100);
    }

    public static boolean b(byte[] r100) {
        if (r100 != null) goto L22;
    L17:
        return false;
    L22:
        HashMap r101 = new HashMap();     // Catch: Exception -> L19
        r101.put("Content-Type", "application/octet-stream");     // Catch: Exception -> L19
        r101.put("aps_c_src", Base64.encodeToString(("lc_" + w2.f517845a).getBytes(), 2));     // Catch: Exception -> L19
        r101.put("aps_c_key", Base64.encodeToString((w2.f517846b + "*" + w2.f517849e).getBytes(), 2));     // Catch: Exception -> L19
        String r102 = "https://".concat("cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&");     // Catch: Exception -> L19
        ((d3) r2.f517648a).getClass();     // Catch: Exception -> L19
        byte[] r103 = null;
        x3 r104 = new x3();     // Catch: Throwable -> L8
        r104.f517919k = r101;     // Catch: Throwable -> L8
        r104.f517921m = r102;     // Catch: Throwable -> L8
        r104.f517922n = r100;     // Catch: Throwable -> L8
        com.loc.c.c();     // Catch: Throwable -> L8
        l0 r105 = com.loc.c.a(r104);     // Catch: Throwable -> L8
        y2 r106 = new y2();     // Catch: Throwable -> L8
        r106.f517962c = r105.f517453a;     // Catch: Throwable -> L8
        r106.f517961b = r105.f517454b;     // Catch: Throwable -> L8
        r106.f517960a = 200;     // Catch: Throwable -> L8
    L9:
        if (r106 != null) goto L11;
    L13:
        if (r103 == null) goto L17;
        if ("true".equals(new String(r103, StandardCharsets.UTF_8)) == false) goto L17;
        return true;
    L11:
        if (r106.f517960a != 200) goto L13;
        r103 = r106.f517962c;     // Catch: Exception -> L19
    L8:
        r106 = null;
        goto L9
    }

    public static void e(List<v2> r100) {
        monitor-enter(p2.class);
        if (r100 != null) goto L19;
    L17:
        monitor-exit(p2.class);
        return;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r100.isEmpty() == true) goto L17;
        ArrayList r101 = new ArrayList(r100.size());     // Catch: Throwable -> L14
        Iterator<v2> r102 = r100.iterator();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        v2 r103 = r102.next();     // Catch: Throwable -> L14
        r101.add(new p2.b(r103.f517819a, r103.f517821c));     // Catch: Throwable -> L14
        goto L10
    L12:
        o2.a().e(r101);     // Catch: Throwable -> L14
        goto L17
    }

    public q2(String r100, String r101, z2 r102) {
        w2.f517845a = 4;
        if (r101 == null) goto L5;
        w2.f517849e = r101;
    L5:
        byte r103 = w2.f517845a;
        w2.f517846b = "6.4.8";
        if (r100 == null) goto L8;
        w2.f517848d = r100;
    L8:
        w2.f517847c = "S128DF1572465B890OE3F7A13167KLEI";
        if (r102 == null) goto L12;
        r2.f517648a = r102;
        return;
    }

    public static byte[] d(byte[] r110, byte[] r111, List<v1> r112) {
        q1 r100 = q1.f517600c;
        r100.getClass();
        int r101 = ((ArrayList) r112).size();     // Catch: Throwable -> L31
        if (r101 <= 0) goto L29;
        if (r110 == null) goto L29;
        r100.f517554a.j(r100.f517555b);     // Catch: Throwable -> L31
        p1 r102 = r100.f517554a;     // Catch: Throwable -> L31
        int r103 = z1.f517976a;     // Catch: Throwable -> L31
        r102.g(1, r110.length, 1);     // Catch: Throwable -> L31
        int r104 = r110.length - 1;     // Catch: Throwable -> L31
    L7:
        if (r104 < 0) goto L9;
        r102.c(r110[r104]);     // Catch: Throwable -> L31
        r104 = r104 - 1;     // Catch: Throwable -> L31
        goto L7
    L9:
        int r113 = r102.a();     // Catch: Throwable -> L31
        int[] r105 = new int[r101];     // Catch: Throwable -> L31
        int r106 = 0;
    L11:
        if (r106 >= r101) goto L16;
        v1 r107 = (v1) ListProtector.get(r112, r106);     // Catch: Throwable -> L31
        p1 r108 = r100.f517554a;     // Catch: Throwable -> L31
        byte[] r109 = r107.f517818b;     // Catch: Throwable -> L31
        int r114 = e2.f517252a;     // Catch: Throwable -> L31
        r108.g(1, r109.length, 1);     // Catch: Throwable -> L31
        int r115 = r109.length - 1;     // Catch: Throwable -> L31
    L13:
        if (r115 < 0) goto L15;
        r108.c(r109[r115]);     // Catch: Throwable -> L31
        r115 = r115 - 1;     // Catch: Throwable -> L31
        goto L13
    L15:
        int r116 = r108.a();     // Catch: Throwable -> L31
        p1 r117 = r100.f517554a;     // Catch: Throwable -> L31
        byte r118 = (byte) r107.f517817a;     // Catch: Throwable -> L31
        r117.l(2);     // Catch: Throwable -> L31
        r117.m(1, r116);     // Catch: Throwable -> L31
        r117.e(0, r118);     // Catch: Throwable -> L31
        r105[r106] = r117.k();     // Catch: Throwable -> L31
        r106 = r106 + 1;     // Catch: Throwable -> L31
        goto L11
    L16:
        p1 r119 = r100.f517554a;     // Catch: Throwable -> L31
        r119.g(4, r101, 4);     // Catch: Throwable -> L31
    L17:
        r101 = r101 - 1;     // Catch: Throwable -> L31
        if (r101 < 0) goto L20;
        r119.d(r105[r101]);     // Catch: Throwable -> L31
        goto L17
    L20:
        int r120 = r119.a();     // Catch: Throwable -> L31
        if (r111 == null) goto L26;
        p1 r121 = r100.f517554a;     // Catch: Throwable -> L31
        r121.g(1, r111.length, 1);     // Catch: Throwable -> L31
        int r122 = r111.length - 1;     // Catch: Throwable -> L31
    L23:
        if (r122 < 0) goto L25;
        r121.c(r111[r122]);     // Catch: Throwable -> L31
        r122 = r122 - 1;     // Catch: Throwable -> L31
        goto L23
    L25:
        int r123 = r121.a();     // Catch: Throwable -> L31
    L27:
        p1 r124 = r100.f517554a;     // Catch: Throwable -> L31
        r124.l(3);     // Catch: Throwable -> L31
        r124.m(2, r120);     // Catch: Throwable -> L31
        r124.m(1, r123);     // Catch: Throwable -> L31
        r124.m(0, r113);     // Catch: Throwable -> L31
        r100.f517554a.o(r124.k());     // Catch: Throwable -> L31
        return r100.f517554a.q();
    L26:
        r123 = 0;
    L29:
        return null;
    }
}
