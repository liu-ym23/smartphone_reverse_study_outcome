package gtc;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e {

    public interface a {
        boolean a(g.f r100);
    }

    static {
        new b.a();
    }

    public static g.a c(g.f r100) {
        Iterator<g.c> r101 = r100.a().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        g.c r102 = r101.next();
        if (r102.d() == null) goto L4;
        return r102.d();
    L8:
        return null;
    }

    public static g.f d(g.a r100, String r101) {
        return e(r100, r101.split(HTTP.URL_DEFAULT), 0);
    }

    public static g.a h(g r100, String r101) {
        g.a r102 = r100.b(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Unexpected state, requested language is not found: ".concat(r101));
    }

    public static c b(g.a r100, String r101, g.f... r102) {
        int r103 = r102.length;
        if (r103 == 0) goto L5;
        HashMap r104 = new HashMap(r103);
        int r105 = r102.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        g.f r107 = r102[r106];
        r104.put(r107.name(), r107);
        r106 = r106 + 1;
        goto L7
    L9:
        List<g.f> r108 = r100.a();
        ArrayList r109 = new ArrayList(r108.size());
        Iterator<g.f> r110 = r108.iterator();
    L11:
        if (r110.hasNext() == false) goto L17;
        g.f r111 = r110.next();
        g.f r112 = (g.f) r104.get(r111.name());
        if (r112 != null) goto L14;
        r109.add(b.a.b(new b.a.C6066a(), r111));
        goto L11
    L14:
        r109.add(r112);
        goto L11
    L17:
        return new c(r101, r109);
    L5:
        return new c(r101, b.a.a(new b.a.C6066a(), r100).a());
    }

    public static g.f e(g.a r100, String[] r101, int r102) {
        String r103 = r101[r102];
        if (r102 != (r101.length - 1)) goto L5;
        boolean r104 = true;
    L6:
        Iterator<g.f> r105 = r100.a().iterator();
    L8:
        if (r105.hasNext() == false) goto L22;
        g.f r106 = r105.next();
        if (r103.equals(r106.name()) == false) goto L8;
        if (r104 == false) goto L13;
        return r106;
    L13:
        g.a r107 = c(r106);
        if (r107 != null) goto L16;
        return null;
    L16:
        return e(r107, r101, r102 + 1);
    L22:
        return null;
    L5:
        r104 = false;
        goto L6
    }

    public static void f(g.a r100, String r101, g.f... r102) {
        if (r102.length == 0) goto L7;
        g(r100, r101.split(HTTP.URL_DEFAULT), 0, r102);
        return;
    }

    public static c a(g.a r100, String r101, a r102, g.f... r103) {
        int r104 = r103.length;
        if (r104 != 0) goto L5;
        Map r105 = Collections.emptyMap();
    L9:
        List<g.f> r106 = r100.a();
        ArrayList r107 = new ArrayList(r106.size());
        Iterator<g.f> r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L20;
        g.f r109 = r108.next();
        if (r102.a(r109) == false) goto L11;
        g.f r110 = (g.f) r105.get(r109.name());
        if (r110 != null) goto L17;
        r107.add(b.a.b(new b.a.C6066a(), r109));
        goto L11
    L17:
        r107.add(r110);
        goto L11
    L20:
        return new c(r101, r107);
    L5:
        HashMap r111 = new HashMap(r104);
        int r112 = r103.length;
        int r113 = 0;
    L6:
        if (r113 >= r112) goto L8;
        g.f r114 = r103[r113];
        r111.put(r114.name(), r114);
        r113 = r113 + 1;
        goto L6
    L8:
        r105 = r111;
        goto L9
    }

    public static void g(g.a r100, String[] r101, int r110, g.f[] r111) {
        String r102 = r101[r110];
        int r103 = 0;
        if (r110 != (r101.length - 1)) goto L5;
        boolean r104 = true;
    L6:
        List<g.f> r105 = r100.a();
        int r106 = r105.size();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L23;
        g.f r108 = (g.f) ListProtector.get(r105, r107);
        if (r102.equals(r108.name()) == true) goto L10;
        r107 = r107 + 1;
        goto L7
    L10:
        if (r104 == false) goto L14;
        int r109 = r111.length;
    L12:
        if (r103 >= r109) goto L24;
        ListProtector.add(r105, r107 + r103, r111[r103]);
        r103 = r103 + 1;
        goto L12
    L24:
        return;
    L14:
        g.a r112 = c(r108);
        if (r112 == null) goto L18;
        g(r112, r101, r110 + 1, r111);
        return;
    L18:
        return;
    L23:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
