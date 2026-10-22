package gtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b {

    public static class a extends b {

        /* JADX INFO: renamed from: gtc.b$a$a, reason: collision with other inner class name */
        public static class C6066a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Map<Integer, Object> f482713a;

            public C6066a() {
                this.f482713a = new HashMap(3);
            }
        }

        public a() {
        }

        public static g.a a(C6066a r100, g.a r101) {
            Map<Integer, Object> r102 = r100.f482713a;
            HashMap r103 = (HashMap) r102;
            g.a r104 = (g.a) r103.get(Integer.valueOf(System.identityHashCode(r101)));
            if (r104 == null) goto L5;
            return r104;
        L5:
            List<g.f> r105 = r101.a();
            ArrayList r106 = new ArrayList(r105.size());
            c r107 = new c(r101.name(), r106);
            Map<Integer, Object> r108 = r100.f482713a;
            HashMap r109 = (HashMap) r108;
            r109.put(Integer.valueOf(System.identityHashCode(r101)), r107);
            Iterator<g.f> r110 = r105.iterator();
        L7:
            if (r110.hasNext() == false) goto L9;
            r106.add(b(r100, r110.next()));
            goto L7
        L9:
            return r107;
        }

        public static g.f b(C6066a r110, g.f r111) {
            Map<Integer, Object> r100 = r110.f482713a;
            HashMap r101 = (HashMap) r100;
            g.f r102 = (g.f) r101.get(Integer.valueOf(System.identityHashCode(r111)));
            if (r102 == null) goto L5;
            return r102;
        L5:
            List<g.c> r103 = r111.a();
            ArrayList r104 = new ArrayList(r103.size());
            k r105 = new k(r111.name(), r104);
            Map<Integer, Object> r106 = r110.f482713a;
            HashMap r107 = (HashMap) r106;
            r107.put(Integer.valueOf(System.identityHashCode(r111)), r105);
            Iterator<g.c> r112 = r103.iterator();
        L7:
            if (r112.hasNext() == false) goto L17;
            g.c r108 = r112.next();
            Map<Integer, Object> r109 = r110.f482713a;
            HashMap r113 = (HashMap) r109;
            g.c r114 = (g.c) r113.get(Integer.valueOf(System.identityHashCode(r108)));
            if (r114 != null) goto L16;
            g.a r115 = r108.d();
            Pattern r116 = r108.b();
            boolean r117 = r108.c();
            boolean r118 = r108.a();
            String r119 = r108.alias();
            if (r115 == null) goto L14;
            g.a r120 = a(r110, r115);
        L15:
            f r121 = new f(r116, r117, r118, r119, r120);
            Map<Integer, Object> r122 = r110.f482713a;
            HashMap r123 = (HashMap) r122;
            r123.put(Integer.valueOf(System.identityHashCode(r108)), r121);
            r114 = r121;
            goto L16
        L14:
            r120 = null;
        L16:
            r104.add(r114);
            goto L7
        L17:
            return r105;
        }
    }

    public b() {
    }
}
