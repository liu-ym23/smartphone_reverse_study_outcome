package n4a;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class s1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile s1 f517662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f517663g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f517664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f517665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u2 f517666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o1 f517667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u2 f517668e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u2 f517669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<v2> f517670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f517671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f517672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f517673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f517674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f517675g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f517676h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<dv> f517677i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f517678j;

        public a() {
        }
    }

    static {
        f517663g = new Object();
    }

    public s1() {
        this.f517668e = new u2();
        this.f517664a = new r1();
        this.f517665b = new u1();
        this.f517667d = new o1();
    }

    public final v1 a(a r210) {
        long r100 = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        u2 r101 = this.f517666c;
        if (r101 != null) goto L5;
    L8:
        r1 r102 = this.f517664a;
        u2 r103 = r210.f517669a;
        boolean r104 = r210.f517678j;
        byte r105 = r210.f517675g;
        String r106 = r210.f517676h;
        List<dv> r110 = r210.f517677i;
        if (r104 == false) goto L11;
        r102.f517639d.a();
    L69:
        r1.a r107 = null;
    L70:
        u1 r108 = this.f517665b;
        u2 r109 = r210.f517669a;
        List<v2> r111 = r210.f517670b;
        boolean r112 = r210.f517673e;
        long r113 = r210.f517672d;
        r108.getClass();
        if (r112 == true) goto L74;
    L72:
        u1 r114 = r108;
        boolean r115 = false;
    L127:
        if (r115 == false) goto L141;
        u1 r116 = r114;
        ArrayList<v2> r117 = r116.f517770c;
        r117.clear();
        if (r111 == null) goto L140;
        ArrayList r118 = new ArrayList();
        HashMap r119 = new HashMap();
        int r120 = 0;
    L132:
        if (r120 >= ((ArrayList) r111).size()) goto L134;
        v2 r121 = (v2) ListProtector.get(r111, r120);
        r119.put(Integer.valueOf(r121.f517821c), r121);
        r120 = r120 + 1;
        goto L132
    L134:
        r118.addAll(r119.values());
        Collections.sort(r118, new t1());
        int r122 = r118.size();
        if (r122 <= 40) goto L137;
        r122 = 40;
    L137:
        int r123 = 0;
    L138:
        if (r123 >= r122) goto L140;
        r117.add((v2) ListProtector.get(r118, r123));
        r123 = r123 + 1;
    L140:
        ((ArrayList) r116.f517768a).clear();
        ((ArrayList) r116.f517768a).addAll(r111);
        r116.f517769b = r109;
        ArrayList<v2> r124 = r116.f517770c;
    L142:
        if (r107 != null) goto L146;
        if (r124 != null) goto L146;
        v1 r125 = null;
    L168:
        this.f517666c = r210.f517669a;
        return r125;
    L146:
        u2 r126 = this.f517668e;
        u2 r127 = r210.f517669a;
        r126.f517771h = r210.f517674f;
        r126.f517747a = r100;
        r126.f517749c = r127.f517749c;
        r126.f517748b = r127.f517748b;
        r126.f517750d = r127.f517750d;
        r126.f517753g = r127.f517753g;
        r126.f517751e = r127.f517751e;
        r126.f517752f = r127.f517752f;
        o1 r128 = this.f517667d;
        long r129 = r210.f517671c;
        r128.f517554a.j(r128.f517555b);
        int r130 = r128.c(r126);     // Catch: Throwable -> L166
        int r131 = -1;
        if (r107 == null) goto L154;
        List<dv> r132 = r107.f517646f;     // Catch: Throwable -> L166
        if (r132 == null) goto L154;
        if (((ArrayList) r132).size() <= 0) goto L154;
        int r133 = r128.b(r107);     // Catch: Throwable -> L166
    L155:
        if (r124 != null) goto L157;
    L159:
        p1 r134 = r128.f517554a;     // Catch: Throwable -> L166
        int r135 = y1.f517959a;     // Catch: Throwable -> L166
        r134.l(3);     // Catch: Throwable -> L166
        r128.f517554a.m(0, r130);     // Catch: Throwable -> L166
        if (r133 <= 0) goto L162;
        r128.f517554a.m(2, r133);     // Catch: Throwable -> L166
    L162:
        if (r131 <= 0) goto L164;
        r128.f517554a.m(1, r131);     // Catch: Throwable -> L166
    L164:
        r128.f517554a.o(r128.f517554a.k());     // Catch: Throwable -> L166
        byte[] r136 = r128.f517554a.q();     // Catch: Throwable -> L166
        int r137 = 0;
    L167:
        r125 = new v1(r137, r136);
        goto L168
    L157:
        if (r124.size() <= 0) goto L159;
        r131 = r128.a(r129, r124);     // Catch: Throwable -> L166
    L154:
        r133 = -1;
    L166:
        r137 = 0;
        r136 = null;
        goto L167
    L141:
        r124 = null;
        goto L142
    L74:
        if (r109.f517751e < 10.0f) goto L76;
        int r138 = 2000;
    L78:
        if (r113 > 0) goto L80;
    L82:
        boolean r139 = false;
    L83:
        if (r139 == false) goto L72;
        if (r111 == null) goto L72;
        ArrayList r140 = (ArrayList) r111;
        if (r140.size() <= 0) goto L72;
        u2 r141 = r108.f517769b;
        if (r141 == null) goto L125;
        float r142 = r109.f517751e;
        if (r142 <= 10.0f) goto L93;
        float r143 = 200.0f;
    L97:
        if (r109.a(r141) <= r143) goto L99;
        boolean r144 = true;
    L100:
        if (r144 == true) goto L124;
        List<v2> r145 = r108.f517768a;
        if (r145 != null) goto L104;
        r114 = r108;
    L122:
        boolean r146 = false;
    L123:
        r115 = !r146;
        goto L127
    L104:
        int r147 = r140.size();
        int r148 = ((ArrayList) r145).size();
        int r149 = r147 + r148;
        if (r147 <= r148) goto L107;
        List<v2> r150 = r145;
        r145 = r111;
    L108:
        HashMap r151 = new HashMap(r145.size());
        Iterator<v2> r152 = r145.iterator();
    L110:
        if (r152.hasNext() == false) goto L112;
        r151.put(Long.valueOf(r152.next().f517819a), 1);
        r152 = r152;
        goto L110
    L112:
        Iterator<v2> r153 = r150.iterator();
        int r154 = 0;
    L114:
        if (r153.hasNext() == false) goto L119;
        u1 r155 = r108;
        if (((Integer) r151.get(Long.valueOf(r153.next().f517819a))) == null) goto L118;
        r154 = r154 + 1;
    L118:
        r108 = r155;
        goto L114
    L119:
        r114 = r108;
        if ((((double) r154) * 2.0d) < (((double) r149) * 0.5d)) goto L122;
        r146 = true;
        goto L123
    L107:
        r150 = r111;
        goto L108
    L124:
        r114 = r108;
        r115 = r144;
        goto L127
    L99:
        r144 = false;
        goto L100
    L93:
        if (r142 <= 2.0f) goto L95;
        r143 = 50.0f;
        goto L97
    L95:
        r143 = 10.0f;
        goto L97
    L125:
        r114 = r108;
        r115 = true;
        goto L127
    L80:
        if ((r100 - r113) >= r138) goto L82;
        r139 = true;
        goto L83
    L76:
        r138 = 3500;
        goto L78
    L11:
        r1.a r156 = r102.f517639d;
        r156.a();
        r156.f517641a = r105;
        r156.f517642b = r106;
        if (r110 == null) goto L25;
        ((ArrayList) r156.f517646f).addAll(r110);
        Iterator r157 = ((ArrayList) r156.f517646f).iterator();
    L15:
        if (r157.hasNext() == false) goto L25;
        dv r158 = (dv) r157.next();
        boolean r159 = r158.f380016i;
        if (r159 == true) goto L21;
        if (r158.f380015h == false) goto L21;
        r156.f517644d = r158;
    L21:
        if (r159 == false) goto L15;
        if (r158.f380015h == false) goto L15;
        r156.f517645e = r158;
    L25:
        dv r160 = r156.f517644d;
        if (r160 != null) goto L28;
        r160 = r156.f517645e;
    L28:
        r156.f517643c = r160;
        if (r102.f517639d.f517643c == null) goto L69;
        u2 r161 = r102.f517638c;
        if (r161 == null) goto L51;
        float r162 = r103.f517751e;
        if (r162 <= 10.0f) goto L37;
        float r163 = 2000.0f;
    L41:
        if (r103.a(r161) <= r163) goto L43;
        boolean r164 = true;
    L44:
        if (r164 == true) goto L51;
        if (r1.a.b(r102.f517639d.f517644d, r102.f517636a) == false) goto L51;
        if (r1.a.b(r102.f517639d.f517645e, r102.f517637b) == false) goto L51;
        boolean r165 = false;
    L52:
        if (r165 == false) goto L69;
        r1.a r166 = r102.f517639d;
        r102.f517636a = r166.f517644d;
        r102.f517637b = r166.f517645e;
        r102.f517638c = r103;
        p2.a(r166.f517646f);
        r1.a r167 = r102.f517639d;
        List<dv> r168 = r102.f517640e;
        monitor-enter(r168);
        Iterator r169 = ((ArrayList) r167.f517646f).iterator();     // Catch: Throwable -> L66
    L57:
        if (r169.hasNext() == false) goto L63;
        dv r170 = (dv) r169.next();     // Catch: Throwable -> L66
        if (r170 == null) goto L57;
        if (r170.f380015h == false) goto L57;
        dv r171 = r170.a();     // Catch: Throwable -> L66
        r171.f380012e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L66
        r102.a(r171);     // Catch: Throwable -> L66
        goto L57
    L63:
        ((ArrayList) r102.f517639d.f517647g).clear();     // Catch: Throwable -> L66
        ((ArrayList) r102.f517639d.f517647g).addAll(r102.f517640e);     // Catch: Throwable -> L66
        monitor-exit(r168);     // Catch: Throwable -> L66
        r107 = r102.f517639d;
    L66:
        th = move-exception;
        throw th;
    L43:
        r164 = false;
        goto L44
    L37:
        if (r162 <= 2.0f) goto L39;
        r163 = 500.0f;
        goto L41
    L39:
        r163 = 100.0f;
    L51:
        r165 = true;
        goto L52
    L5:
        if (r210.f517669a.a(r101) >= 10.0d) goto L8;
        return null;
    }
}
