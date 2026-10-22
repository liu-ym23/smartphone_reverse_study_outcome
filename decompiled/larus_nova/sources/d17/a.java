package d17;

import com.obric.sva.sdk.data.ISmModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c17.a f466389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e17.b f466390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short[] f466391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final short[] f466392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final short[] f466393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final short[] f466394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final short[] f466395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final short[] f466396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e17.a[] f466397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final short[] f466398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e17.a f466399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C5615a f466400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C5615a f466401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f466402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f466403o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f466404p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f466405q;

    /* JADX INFO: renamed from: d17.a$a, reason: collision with other inner class name */
    public class C5615a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f466406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e17.a[] f466407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e17.a[] f466408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e17.a f466409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f466410e;

        public final void c() {
            e17.b.b(this.f466406a);
            int r100 = 0;
        L4:
            if (r100 >= this.f466410e) goto L6;
            e17.b.b(this.f466407b[r100].f470704a);
            e17.b.b(this.f466408c[r100].f470704a);
            r100 = r100 + 1;
            goto L4
        L6:
            e17.b.b(this.f466409d.f470704a);
        }

        public C5615a() {
            this.f466406a = new short[2];
            this.f466407b = new e17.a[16];
            this.f466408c = new e17.a[16];
            this.f466409d = new e17.a(8);
            this.f466410e = 0;
        }

        public final void a(int r100) {
        L2:
            int r101 = this.f466410e;
            if (r101 >= r100) goto L5;
            this.f466407b[r101] = new e17.a(3);
            this.f466408c[this.f466410e] = new e17.a(3);
            this.f466410e++;
            goto L2
        }

        public final int b(e17.b r100, int r101) throws IOException {
            if (r100.a(this.f466406a, 0) != 0) goto L7;
            return this.f466407b[r101].a(r100);
        L7:
            if (r100.a(this.f466406a, 1) != 0) goto L9;
            int r102 = this.f466408c[r101].a(r100);
        L11:
            return r102 + 8;
        L9:
            r102 = this.f466409d.a(r100) + 8;
            goto L11
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C5616a[] f466411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f466412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f466413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f466414d;

        /* JADX INFO: renamed from: d17.a$b$a, reason: collision with other inner class name */
        public class C5616a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final short[] f466415a;

            public C5616a() {
                this.f466415a = new short[ISmModel.VERSION_0300];
            }
        }

        public b() {
        }
    }

    public a() {
        this.f466389a = new c17.a();
        this.f466390b = new e17.b();
        this.f466391c = new short[192];
        this.f466392d = new short[12];
        this.f466393e = new short[12];
        this.f466394f = new short[12];
        this.f466395g = new short[12];
        this.f466396h = new short[192];
        this.f466397i = new e17.a[4];
        this.f466398j = new short[114];
        this.f466399k = new e17.a(4);
        this.f466400l = new C5615a();
        this.f466401m = new C5615a();
        this.f466402n = new b();
        this.f466403o = -1;
        this.f466404p = -1;
        int r100 = 0;
    L3:
        if (r100 >= 4) goto L5;
        this.f466397i[r100] = new e17.a(6);
        r100 = r100 + 1;
        goto L3
    }

    public final boolean b(byte[] r100) {
        if (r100.length >= 5) goto L5;
        return false;
    L5:
        int r101 = r100[0] & 255;
        int r102 = r101 % 9;
        int r103 = r101 / 9;
        int r104 = r103 % 5;
        int r105 = r103 / 5;
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r106 >= 4) goto L10;
        int r108 = r106 + 1;
        r107 = r107 + ((r100[r108] & UByte.MAX_VALUE) << (r106 * 8));
        r106 = r108;
        goto L7
    L10:
        if (r102 > 8) goto L25;
        if (r104 > 4) goto L25;
        if (r105 > 4) goto L25;
        b r109 = this.f466402n;
        if (r109.f466411a != null) goto L17;
    L21:
        r109.f466413c = r104;
        r109.f466414d = (1 << r104) - 1;
        r109.f466412b = r102;
        int r110 = 1 << (r102 + r104);
        r109.f466411a = new b.C5616a[r110];
        int r111 = 0;
    L22:
        if (r111 >= r110) goto L24;
        r109.f466411a[r111] = new b.C5616a();
        r111 = r111 + 1;
    L24:
        int r112 = 1 << r105;
        this.f466400l.a(r112);
        this.f466401m.a(r112);
        this.f466405q = r112 - 1;
        boolean r113 = true;
    L26:
        if (r113 == true) goto L28;
        return false;
    L28:
        if (r107 >= 0) goto L31;
        return false;
    L31:
        if (this.f466403o == r107) goto L38;
        this.f466403o = r107;
        int r114 = Math.max(r107, 1);
        this.f466404p = r114;
        c17.a r115 = this.f466389a;
        int r116 = Math.max(r114, 4096);
        if (r115.f22067a != null) goto L35;
    L36:
        r115.f22067a = new byte[r116];
    L37:
        r115.f22069c = r116;
        r115.f22068b = 0;
        r115.f22070d = 0;
        goto L38
    L35:
        if (r115.f22069c == r116) goto L37;
    L38:
        return true;
    L17:
        if (r109.f466412b != r102) goto L21;
        if (r109.f466413c != r104) goto L21;
    L25:
        r113 = false;
        goto L26
    }

    public final boolean a(InputStream r210, OutputStream r211, long r212) throws IOException {
        this.f466390b.f470708c = r210;
        c17.a r100 = this.f466389a;
        r100.a();
        r100.f22071e = r211;
        c17.a r101 = this.f466389a;
        r101.f22070d = 0;
        r101.f22068b = 0;
        e17.b.b(this.f466391c);
        e17.b.b(this.f466396h);
        e17.b.b(this.f466392d);
        e17.b.b(this.f466393e);
        e17.b.b(this.f466394f);
        e17.b.b(this.f466395g);
        e17.b.b(this.f466398j);
        b r102 = this.f466402n;
        int r103 = 1 << (r102.f466412b + r102.f466413c);
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        e17.b.b(r102.f466411a[r104].f466415a);
        r104 = r104 + 1;
        goto L3
    L5:
        int r105 = 0;
    L7:
        if (r105 >= 4) goto L9;
        e17.b.b(this.f466397i[r105].f470704a);
        r105 = r105 + 1;
        goto L7
    L9:
        this.f466400l.c();
        this.f466401m.c();
        e17.b.b(this.f466399k.f470704a);
        e17.b r106 = this.f466390b;
        r106.f470707b = 0;
        int r107 = -1;
        r106.f470706a = -1;
        int r108 = 0;
    L11:
        if (r108 >= 5) goto L13;
        r106.f470707b = (r106.f470707b << 8) | r106.f470708c.read();
        r108 = r108 + 1;
        goto L11
    L13:
        long r109 = 0;
        long r110 = 0;
        int r111 = 0;
        byte r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
    L15:
        if (r212 >= r109) goto L17;
    L18:
        int r117 = (int) r110;
        int r118 = this.f466405q & r117;
        int r119 = (r111 << 4) + r118;
        int r120 = 7;
        if (this.f466390b.a(this.f466391c, r119) != 0) goto L53;
        b r121 = this.f466402n;
        b.C5616a[] r122 = r121.f466411a;
        int r123 = r117 & r121.f466414d;
        int r124 = r121.f466412b;
        b.C5616a r125 = r122[(r123 << r124) + ((r112 & UByte.MAX_VALUE) >>> (8 - r124))];
        if (r111 >= 7) goto L23;
        boolean r126 = true;
    L25:
        if (r126 == true) goto L37;
        e17.b r127 = this.f466390b;
        c17.a r128 = this.f466389a;
        int r129 = (r128.f22068b - r113) + r107;
        if (r129 >= 0) goto L29;
        r129 = r129 + r128.f22069c;
    L29:
        byte r130 = r128.f22067a[r129];
        int r131 = 1;
    L30:
        int r132 = (r130 >> 7) & 1;
        r130 = (byte) (r130 << 1);
        int r133 = r127.a(r125.f466415a, ((r132 + 1) << 8) + r131);
        r131 = (r131 << 1) | r133;
        if (r132 != r133) goto L32;
        if (r131 < 256) goto L30;
    L35:
        byte r134 = (byte) r131;
    L41:
        c17.a r135 = this.f466389a;
        byte[] r136 = r135.f22067a;
        int r137 = r135.f22068b;
        int r138 = r137 + 1;
        r135.f22068b = r138;
        r136[r137] = r134;
        if (r138 < r135.f22069c) goto L45;
        r135.a();
    L45:
        if (r111 >= 4) goto L48;
        r111 = 0;
    L51:
        r110 = r110 + 1;
        r112 = r134;
    L136:
        r107 = -1;
        r109 = 0;
        goto L15
    L48:
        if (r111 >= 10) goto L50;
        r111 = r111 - 3;
        goto L51
    L50:
        r111 = r111 - 6;
    L32:
        if (r131 >= 256) goto L35;
        r131 = r127.a(r125.f466415a, r131) | (r131 << 1);
        goto L32
    L37:
        e17.b r139 = this.f466390b;
        int r140 = 1;
    L38:
        r140 = r139.a(r125.f466415a, r140) | (r140 << 1);
        if (r140 < 256) goto L38;
        r134 = (byte) r140;
        goto L41
    L23:
        r126 = false;
        goto L25
    L53:
        if (this.f466390b.a(this.f466392d, r111) != 1) goto L77;
        int r141 = 11;
        if (this.f466390b.a(this.f466393e, r111) != 0) goto L64;
        if (this.f466390b.a(this.f466396h, r119) != 0) goto L62;
        if (r111 >= 7) goto L60;
        r111 = 9;
    L61:
        int r142 = 1;
    L71:
        if (r142 != 0) goto L116;
        r142 = this.f466401m.b(this.f466390b, r118) + 2;
        if (r111 >= 7) goto L75;
        r141 = 8;
    L75:
        r111 = r141;
    L116:
        if (r113 >= r110) goto L137;
        if (r113 >= this.f466404p) goto L161;
        c17.a r143 = this.f466389a;
        int r144 = (r143.f22068b - r113) - 1;
        if (r144 >= 0) goto L123;
        r144 = r144 + r143.f22069c;
    L123:
        int r145 = r142;
    L124:
        if (r145 == 0) goto L132;
        int r146 = r143.f22069c;
        if (r144 < r146) goto L128;
        r144 = 0;
    L128:
        byte[] r147 = r143.f22067a;
        int r148 = r143.f22068b;
        int r149 = r148 + 1;
        r143.f22068b = r149;
        int r150 = r144 + 1;
        r147[r148] = r147[r144];
        if (r149 < r146) goto L131;
        r143.a();
    L131:
        r145 = r145 - 1;
        r144 = r150;
        goto L124
    L132:
        r110 = r110 + ((long) r142);
        c17.a r151 = this.f466389a;
        int r152 = (r151.f22068b - 0) - 1;
        if (r152 >= 0) goto L135;
        r152 = r152 + r151.f22069c;
    L135:
        r112 = r151.f22067a[r152];
        goto L136
    L161:
        return false;
    L137:
        return false;
    L60:
        r111 = 11;
        goto L61
    L62:
        r142 = 0;
        goto L71
    L64:
        if (this.f466390b.a(this.f466394f, r111) != 0) goto L67;
    L70:
        r142 = 0;
        int r213 = r116;
        r116 = r113;
        r113 = r213;
        goto L71
    L67:
        if (this.f466390b.a(this.f466395g, r111) != 0) goto L69;
        int r214 = r115;
        r115 = r114;
        r114 = r214;
    L69:
        int r215 = r116;
        r116 = r114;
        r114 = r115;
        r115 = r215;
        goto L70
    L77:
        r142 = this.f466400l.b(this.f466390b, r118) + 2;
        if (r111 < 7) goto L81;
        r120 = 10;
    L81:
        e17.a[] r153 = this.f466397i;
        int r154 = r142 - 2;
        if (r154 < 4) goto L85;
        r154 = 3;
    L85:
        int r155 = r153[r154].a(this.f466390b);
        if (r155 < 4) goto L114;
        int r156 = (r155 >> 1) - 1;
        int r157 = ((r155 & 1) | 2) << r156;
        if (r155 >= 14) goto L93;
        short[] r158 = this.f466398j;
        int r159 = (r157 - r155) - 1;
        e17.b r160 = this.f466390b;
        int r161 = 0;
        int r162 = 0;
        int r163 = 1;
    L90:
        if (r161 >= r156) goto L92;
        int r164 = r160.a(r158, r159 + r163);
        r163 = (r163 << 1) + r164;
        r162 = r162 | (r164 << r161);
        r161 = r161 + 1;
        goto L90
    L92:
        int r165 = r157 + r162;
    L113:
        r111 = r120;
        r114 = r115;
        r115 = r116;
        r116 = r113;
        r113 = r165;
        goto L116
    L93:
        e17.b r166 = this.f466390b;
        int r167 = r156 - 4;
        int r168 = 0;
    L94:
        if (r167 == 0) goto L100;
        int r169 = r166.f470706a >>> 1;
        r166.f470706a = r169;
        int r170 = r166.f470707b;
        int r171 = (r170 - r169) >>> 31;
        int r172 = r170 - ((r171 - 1) & r169);
        r166.f470707b = r172;
        r168 = (r168 << 1) | (1 - r171);
        if ((r169 & (-16777216)) != 0) goto L99;
        r166.f470707b = (r172 << 8) | r166.f470708c.read();
        r166.f470706a <<= 8;
    L99:
        r167 = r167 - 1;
        goto L94
    L100:
        r166.getClass();
        int r173 = r157 + (r168 << 4);
        e17.a r174 = this.f466399k;
        e17.b r175 = this.f466390b;
        int r176 = 0;
        int r177 = 0;
        int r178 = 1;
    L102:
        if (r176 >= r174.f470705b) goto L104;
        int r179 = r175.a(r174.f470704a, r178);
        r178 = (r178 << 1) + r179;
        r177 = r177 | (r179 << r176);
        r176 = r176 + 1;
        goto L102
    L104:
        r165 = r173 + r177;
        if (r165 >= 0) goto L113;
        if (r165 != (-1)) goto L110;
    L108:
        this.f466389a.a();
        c17.a r180 = this.f466389a;
        r180.a();
        r180.f22071e = null;
        this.f466390b.f470708c = null;
        return true;
    L110:
        return false;
    L114:
        r114 = r115;
        r115 = r116;
        r116 = r113;
        r113 = r155;
        r111 = r120;
        goto L116
    L17:
        if (r110 >= r212) goto L108;
        goto L18
    }
}
