package z37;

import android.content.Context;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import es3.m;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: z37.a$a, reason: collision with other inner class name */
    public static class C8413a implements Comparator<m> {
        public C8413a() {
        }

        @Override // java.util.Comparator
        public final int compare(m r100, m r101) {
            m r102 = r100;
            m r103 = r101;
            return Integer.compare((r103.f473765d + 1) * r103.f473763b, (r102.f473765d + 1) * r102.f473763b);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f569875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f569876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedList<b> f569877c;

        public b(m r100, b r101) {
            this.f569877c = new LinkedList();
            this.f569875a = r100;
            this.f569876b = r101;
        }
    }

    public static int b(long r100) {
        return (int) ((r100 >> 43) & 1048575);
    }

    public static boolean d(long r100) {
        if (((r100 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(LinkedList r100, m r101) {
        if (d.j() == false) goto L6;
        Objects.toString(r101);
    L6:
        if (r100.isEmpty() == true) goto L8;
        m r102 = (m) r100.peek();
    L9:
        if (r102 != null) goto L11;
    L20:
        r100.push(r101);
        return;
    L11:
        if (r102.f473762a != r101.f473762a) goto L20;
        int r103 = r102.f473765d;
        int r104 = r101.f473765d;
        if (r103 != r104) goto L20;
        if (r104 == 0) goto L20;
        int r105 = r101.f473763b;
        if (r105 != 5000) goto L18;
        r105 = r102.f473763b;
    L18:
        r101.f473763b = r105;
        r102.f473766e++;
        r102.f473763b = (int) (r102.f473763b + ((long) r105));
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static String c(List<m> r100, long r101) {
        StringBuilder r102 = new StringBuilder();
        long r103 = (long) (r101 * 0.3f);
        LinkedList r104 = new LinkedList();
        Iterator<m> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        m r106 = r105.next();
        if (r106.f473763b < r103) goto L4;
        r104.add(r106);
        goto L4
    L8:
        Collections.sort(r104, new C8413a());
        if (r104.isEmpty() == false) goto L14;
        if (r100.isEmpty() == true) goto L14;
        r104.add((m) ListProtector.get(r100, 0));
    L18:
        Iterator r107 = r104.iterator();
        if (r107.hasNext() == false) goto L22;
        r102.append(((m) r107.next()).f473762a + "\n");
    L22:
        return r102.toString();
    L14:
        if (r104.size() <= 1) goto L18;
        if (((m) r104.peek()).f473762a != 1048574) goto L18;
        r104.removeFirst();
        goto L18
    }

    public static long e(LinkedList<m> r100, StringBuilder r101) {
        Iterator<m> r102 = r100.iterator();
        long r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L8;
        m r104 = r102.next();
        r101.append(r104.toString());
        r101.append('\n');
        long r105 = r104.f473763b;
        if (r103 >= r105) goto L4;
        r103 = r105;
        goto L4
    L8:
        return r103;
    }

    public static void g(List r110, a47.b r111) {
        LinkedList r112 = (LinkedList) r110;
        int r100 = r112.size();
        int r101 = 1;
    L4:
        if (r100 <= 30) goto L18;
        ListIterator r102 = r112.listIterator(r112.size());
    L7:
        if (r102.hasPrevious() == false) goto L16;
        if (((m) r102.previous()).f473763b >= (r101 * 5)) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L7;
        r102.remove();
        r100 = r100 - 1;
        if (r100 > 30) goto L7;
        return;
    L11:
        r103 = false;
        goto L12
    L16:
        r100 = r112.size();
        r101 = r101 + 1;
        if (60 >= r101) goto L4;
    L18:
        int r104 = r112.size();
        if (r104 > 30) goto L21;
        return;
    L21:
        if (d.j() == false) goto L23;
        ps3.d.c("[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r104), 30, r110});
    L23:
        ListIterator r113 = r112.listIterator(Math.min(r104, 30));
    L25:
        if (r113.hasNext() == false) goto L38;
        r113.next();
        r113.remove();
        goto L25
    }

    public static void f(long[] r210, LinkedList r211, long r212) {
        if (r210 != null) goto L5;
        return;
    L5:
        if (r210.length == 0) goto L169;
        long r100 = 0;
        if (r210[r210.length - 1] == 0) goto L10;
        long r101 = r210[r210.length - 1] & 8796093022207L;
    L11:
        int r110 = 0;
    L13:
        if (r110 >= r210.length) goto L18;
        if ((r210[r110] & 8796093022207L) < r101) goto L18;
        r110 = r110 + 1;
    L18:
        LinkedList r102 = new LinkedList();
        int r103 = 0;
        boolean r111 = false;
    L20:
        if (r110 >= r210.length) goto L68;
        long r112 = r210[r110];
        if (r100 != r112) goto L25;
        long r113 = r100;
    L67:
        r110 = r110 + 1;
        r100 = r113;
        goto L20
    L25:
        if (d(r112) == true) goto L27;
    L29:
        if (r111 == true) goto L34;
        if (b(r112) <= 1048000) goto L39;
        ps3.d.b("s2 pass this method[%s], isIn [%b] ", new Object[]{Integer.valueOf(b(r112)), Boolean.valueOf(d(r112))});
    L39:
        r113 = 0;
        goto L67
    L34:
        if (d(r112) == true) goto L36;
        int r104 = b(r112);
        if (r102.isEmpty() == true) goto L64;
        long r114 = ((Long) r102.pop()).longValue();
        r103 = r103 - 1;
        LinkedList r115 = new LinkedList();
        r115.push(Long.valueOf(r114));
    L43:
        int r105 = b(r114);
        if (r105 == r104) goto L51;
        if (r102.isEmpty() == true) goto L51;
        if (d.j() == false) goto L50;
        ps3.d.c("pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r105), Integer.valueOf(r104)});
    L50:
        r114 = ((Long) r102.pop()).longValue();
        r103 = r103 - 1;
        r115.push(Long.valueOf(r114));
    L51:
        if (r105 == r104) goto L54;
        if (r105 != 1048574) goto L54;
        Context r106 = d.f190513a;
        r102.addAll(r115);
        r103 = r103 + r102.size();
    L54:
        long r116 = (r112 & 8796093022207L) + MethodCollector.getDiffTime();
    L56:
        if (r115.size() == 0) goto L39;
        long r213 = (((Long) r115.pop()).longValue() & 8796093022207L) + MethodCollector.getDiffTime();
        long r107 = r116 - r213;
        if (r107 < 0) goto L60;
        a(r211, new m(r104, (int) r107, r213, r103));
        goto L56
    L60:
        if (d.j() == false) goto L62;
        ps3.d.a("[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r107)});
    L62:
        r102.clear();
        r211.clear();
        return;
    L64:
        r113 = 0;
        if (d.j() == false) goto L67;
        ps3.d.c("[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r104)});
        goto L67
    L36:
        if (b(r112) != MethodCollector.METHOD_ID_DISPATCH) goto L38;
        r102.clear();
        r103 = 0;
    L38:
        r103 = r103 + 1;
        r102.push(Long.valueOf(r112));
        goto L39
    L27:
        if (1048574 != b(r112)) goto L29;
        r111 = true;
        goto L29
    L68:
        ps3.d.b("structuredDataToStack inner, result.size: " + r211.size() + ", " + r102.size(), new Object[0]);
    L70:
        if (r102.isEmpty() == true) goto L79;
        long r108 = ((Long) r102.pop()).longValue();
        int r109 = b(r108);
        boolean r117 = d(r108);
        long r118 = (r108 & 8796093022207L) + MethodCollector.getDiffTime();
        if (d.j() == false) goto L74;
        ps3.d.c("[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r109), Boolean.valueOf(r117), Long.valueOf(r118), Long.valueOf(r212), Integer.valueOf(r102.size())});
    L74:
        if (r117 == false) goto L76;
        a(r211, new m(r109, (int) (r212 - r118), r118, r102.size()));
        goto L70
    L76:
        if (d.j() == false) goto L70;
        ps3.d.a("[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r109)});
        goto L70
    L79:
        b r119 = null;
        b r120 = new b(null, null);
        ListIterator r121 = r211.listIterator(0);
        int r122 = 0;
    L81:
        if (r121.hasNext() == false) goto L119;
        b r123 = new b((m) r121.next(), r119);
        r122 = r122 + 1;
        if (r119 != null) goto L92;
        m r124 = r123.f569875a;
        if (r124 != null) goto L87;
        int r125 = 0;
    L88:
        if (r125 == 0) goto L92;
        if (d.j() == false) goto L120;
        ps3.d.a("[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L120:
        r211.clear();
        LinkedList r126 = new LinkedList();
    L121:
        if (r120 == null) goto L170;
        m r127 = r120.f569875a;
        if (r127 == null) goto L125;
        r211.add(r127);
    L125:
        LinkedList<b> r128 = r120.f569877c;
        if (r128.isEmpty() == true) goto L131;
        int r129 = r128.size();
    L128:
        r129 = r129 - 1;
        if (r129 < 0) goto L131;
        r126.add(r128.get(r129));
    L131:
        r120 = (b) r126.pollLast();
        goto L121
    L170:
        return;
    L87:
        r125 = r124.f473765d;
    L92:
        m r130 = r123.f569875a;
        if (r130 != null) goto L95;
        int r131 = 0;
    L96:
        if (r119 == null) goto L117;
        if (r131 == 0) goto L117;
        m r132 = r119.f569875a;
        if (r132 != null) goto L102;
        int r133 = 0;
    L103:
        if (r133 < r131) goto L116;
    L104:
        if (r119 == null) goto L111;
        m r134 = r119.f569875a;
        if (r134 != null) goto L108;
        int r135 = 0;
    L109:
        if (r135 <= r131) goto L111;
        r119 = r119.f569876b;
        goto L104
    L108:
        r135 = r134.f473765d;
    L111:
        if (r119 == null) goto L81;
        b r136 = r119.f569876b;
        if (r136 == null) goto L118;
        r123.f569876b = r136;
        r119.f569876b.f569877c.addFirst(r123);
    L118:
        r119 = r123;
        goto L81
    L116:
        r119.f569877c.addFirst(r123);
        goto L118
    L102:
        r133 = r132.f473765d;
    L117:
        r120.f569877c.addFirst(r123);
        goto L118
    L95:
        r131 = r130.f473765d;
        goto L96
    L119:
        ps3.d.b("[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r122)});
        goto L120
    L10:
        r101 = Long.MAX_VALUE;
        goto L11
    }
}
