package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.text.Typography;
import v7b.b0;
import v7b.w;
import v7b.x;
import v7b.y;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements x7b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w7b.a f417243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<x7b.b> f417244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Character, z7b.a> f417245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f417246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Character, List<x7b.a>> f417247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x7b.e f417248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f417249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f417250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f417251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f417252j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b0> f417253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f417254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f417255c;

        public a(List<b0> r100, boolean r101, boolean r102) {
            this.f417253a = r100;
            this.f417255c = r101;
            this.f417254b = r102;
        }
    }

    public final b0 f() {
        x7b.d r100 = this.f417248f.k();
        this.f417248f.g();
    L3:
        char r101 = this.f417248f.j();
        if (r101 == 0) goto L9;
        if (this.f417246d.get(r101) == true) goto L9;
        this.f417248f.g();
    L9:
        x7b.e r102 = this.f417248f;
        w7b.g r103 = r102.c(r100, r102.k());
        String r104 = r103.a();
        int r105 = -1;
        if (r101 != '\n') goto L18;
        int r106 = r104.length() - 1;
    L12:
        if (r106 < 0) goto L17;
        if (r104.charAt(r106) != ' ') goto L15;
        r106 = r106 - 1;
        goto L12
    L15:
        r105 = r106;
    L17:
        int r107 = r105 + 1;
        this.f417250h = r104.length() - r107;
        r104 = r104.substring(0, r107);
    L27:
        b0 r108 = new b0(r104);
        r108.n(r103.b());
        return r108;
    L18:
        if (r101 != 0) goto L27;
        int r109 = r104.length() - 1;
    L20:
        if (r109 < 0) goto L26;
        char r110 = r104.charAt(r109);
        if (r110 == '\t') goto L25;
        if (r110 == ' ') goto L25;
        r105 = r109;
    L25:
        r109 = r109 - 1;
    L26:
        r104 = r104.substring(0, r105 + 1);
        goto L27
    }

    public n(m r100) {
        this.f417243a = r100;
        ArrayList r101 = new ArrayList(r100.f417240a);
        r101.add(new t7b.c.a());
        r101.add(new t7b.d.a());
        r101.add(new t7b.f.a());
        r101.add(new t7b.b.a());
        r101.add(new t7b.g.a());
        this.f417244b = r101;
        List<z7b.a> r102 = r100.f417241b;
        HashMap r103 = new HashMap();
        int r104 = 0;
        Object[] r105 = {new t7b.a(), new t7b.i()};
        ArrayList r106 = new ArrayList(2);
    L3:
        if (r104 >= 2) goto L5;
        Object r107 = r105[r104];
        Objects.requireNonNull(r107);
        r106.add(r107);
        r104 = r104 + 1;
        goto L3
    L5:
        b(Collections.unmodifiableList(r106), r103);
        b(r102, r103);
        this.f417245c = r103;
        Set r108 = r103.keySet();
        List<x7b.b> r109 = this.f417244b;
        BitSet r110 = new BitSet();
        Iterator r111 = r108.iterator();
    L7:
        if (r111.hasNext() == false) goto L9;
        r110.set(((Character) r111.next()).charValue());
        goto L7
    L9:
        Iterator r112 = ((ArrayList) r109).iterator();
    L11:
        if (r112.hasNext() == false) goto L16;
        Iterator<Character> r113 = ((x7b.b) r112.next()).a().iterator();
    L14:
        if (r113.hasNext() == false) goto L11;
        r110.set(r113.next().charValue());
        goto L14
    L16:
        r110.set(91);
        r110.set(93);
        r110.set(33);
        r110.set(10);
        this.f417246d = r110;
    }

    public static b0 i(w7b.g r100) {
        b0 r101 = new b0(r100.a());
        r101.n(r100.b());
        return r101;
    }

    public final void c(v7b.s r100) {
        v7b.s r101 = r100.f553569e;
        if (r101 != null) goto L5;
        return;
    L5:
        v7b.s r102 = r100.f553570f;
        b0 r103 = null;
        b0 r104 = null;
        int r105 = 0;
    L6:
        if (r101 == null) goto L17;
        if ((r101 instanceof b0) == false) goto L13;
        r104 = (b0) r101;
        if (r103 != null) goto L12;
        r103 = r104;
    L12:
        r105 = r105 + r104.f553548j.length();
    L14:
        if (r101 == r102) goto L17;
        r101 = r101.f553572h;
        goto L6
    L13:
        d(r103, r104, r105);
        c(r101);
        r103 = null;
        r104 = null;
        r105 = 0;
    L17:
        d(r103, r104, r105);
    }

    public final void g(f r110) {
        HashMap r100 = new HashMap();
        f r101 = this.f417251i;
    L3:
        if (r101 == null) goto L7;
        f r102 = r101.f417200f;
        if (r102 == r110) goto L7;
        r101 = r102;
    L7:
        if (r101 == null) goto L51;
        char r103 = r101.f417196b;
        Map<Character, z7b.a> r104 = this.f417245c;
        HashMap r105 = (HashMap) r104;
        z7b.a r106 = (z7b.a) r105.get(Character.valueOf(r103));
        if (r101.f417199e == false) goto L50;
        if (r106 == null) goto L50;
        char r107 = r106.c();
        f r108 = r101.f417200f;
        int r109 = 0;
        boolean r111 = false;
    L14:
        if (r108 == null) goto L27;
        if (r108 == r110) goto L27;
        if (r108 == r100.get(Character.valueOf(r103))) goto L27;
        if (r108.f417198d == false) goto L26;
        if (r108.f417196b != r107) goto L26;
        r109 = r106.d(r108, r101);
        if (r109 > 0) goto L24;
        r111 = true;
        goto L26
    L24:
        boolean r112 = true;
        r111 = true;
    L28:
        if (r112 == false) goto L29;
        int r113 = 0;
    L35:
        if (r113 >= r109) goto L37;
        List<b0> r114 = r108.f417195a;
        ((b0) ListProtector.remove(r114, r114.size() - 1)).p();
        r113 = r113 + 1;
        goto L35
    L37:
        int r115 = 0;
    L38:
        if (r115 >= r109) goto L40;
        ((b0) ListProtector.remove(r101.f417195a, 0)).p();
        r115 = r115 + 1;
        goto L38
    L40:
        f r116 = r101.f417200f;
    L41:
        if (r116 == null) goto L45;
        if (r116 == r108) goto L45;
        f r117 = r116.f417200f;
        h(r116);
        r116 = r117;
    L45:
        if (r108.c() != 0) goto L48;
        h(r108);
    L48:
        if (r101.c() != 0) goto L7;
        f r118 = r101.f417201g;
        h(r101);
        r101 = r118;
        goto L7
    L29:
        if (r111 == true) goto L33;
        r100.put(Character.valueOf(r103), r101.f417200f);
        if (r101.f417198d == true) goto L33;
        h(r101);
    L33:
        r101 = r101.f417201g;
    L26:
        r108 = r108.f417200f;
    L27:
        r112 = false;
    L50:
        r101 = r101.f417201g;
    L51:
        f r119 = this.f417251i;
        if (r119 == null) goto L55;
        if (r119 == r110) goto L84;
        h(r119);
        goto L51
    L84:
        return;
    }

    public final void h(f r100) {
        f r101 = r100.f417200f;
        if (r101 == null) goto L5;
        r101.f417201g = r100.f417201g;
    L5:
        f r102 = r100.f417201g;
        if (r102 != null) goto L8;
        this.f417251i = r101;
        return;
    L8:
        r102.f417200f = r101;
    }

    public static void b(Iterable<z7b.a> r100, Map<Character, z7b.a> r101) {
        Iterator<z7b.a> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        z7b.a r103 = r102.next();
        char r104 = r103.c();
        char r105 = r103.b();
        if (r104 == r105) goto L7;
        a(r104, r103, r101);
        a(r105, r103, r101);
        goto L4
    L7:
        HashMap r106 = (HashMap) r101;
        z7b.a r107 = (z7b.a) r106.get(Character.valueOf(r104));
        if (r107 == null) goto L16;
        if (r107.c() != r107.b()) goto L16;
        if ((r107 instanceof s) == false) goto L14;
        s r108 = (s) r107;
    L15:
        r108.e(r103);
        r106.put(Character.valueOf(r104), r108);
        goto L4
    L14:
        s r109 = new s(r104);
        r109.e(r107);
        r108 = r109;
    L16:
        a(r104, r103, r101);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(w7b.g r110, v7b.a r111) {
        this.f417248f = new x7b.e(r110.f558608a);
        this.f417249g = !((ArrayList) r110.b()).isEmpty();
        this.f417250h = 0;
        String r100 = null;
        this.f417251i = null;
        this.f417252j = null;
        HashMap r101 = new HashMap();
        Iterator r102 = ((ArrayList) this.f417244b).iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        x7b.b r103 = (x7b.b) r102.next();
        x7b.a r104 = r103.create();
        Iterator<Character> r105 = r103.a().iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        Character r106 = r105.next();
        if (r101.containsKey(r106) == true) goto L11;
        r101.put(r106, new ArrayList());
    L11:
        ((List) r101.get(r106)).add(r104);
        goto L7
    L12:
        this.f417247e = r101;
    L13:
        char r107 = this.f417248f.j();
        if (r107 == 0) goto L249;
        int r108 = 10;
        if (r107 != '\n') goto L18;
        this.f417248f.g();
        if (this.f417250h < 2) goto L247;
        Object r109 = new v7b.h();
    L248:
        Object[] r112 = {r109};
        ArrayList r113 = new ArrayList(1);
        Object r114 = r112[0];
        Objects.requireNonNull(r114);
        r113.add(r114);
        List r115 = Collections.unmodifiableList(r113);
    L250:
        if (r115 == 0) goto L251;
        r100 = null;
        Iterator r116 = r115.iterator();
    L255:
        if (r116.hasNext() == false) goto L13;
        r111.e((v7b.s) r116.next());
        goto L255
    L251:
        g(null);
        c(r111);
        return;
    L247:
        r109 = new w();
        goto L248
    L18:
        if (r107 == '!') goto L236;
        if (r107 != '[') goto L21;
        x7b.d r117 = this.f417248f.k();
        this.f417248f.g();
        x7b.d r118 = this.f417248f.k();
        b0 r119 = i(this.f417248f.c(r117, r118));
        e r120 = this.f417252j;
        e r121 = new e(r119, r117, r118, r120, this.f417251i, false);
        if (r120 == null) goto L235;
        r120.f417194h = true;
    L235:
        this.f417252j = r121;
        Object[] r122 = {r119};
        ArrayList r123 = new ArrayList(1);
        Object r124 = r122[0];
        Objects.requireNonNull(r124);
        r123.add(r124);
        r115 = Collections.unmodifiableList(r123);
        goto L250
    L21:
        if (r107 != ']') goto L23;
        x7b.d r125 = this.f417248f.k();
        this.f417248f.g();
        x7b.d r126 = this.f417248f.k();
        e r127 = this.f417252j;
        if (r127 != null) goto L145;
        v7b.s r128 = i(this.f417248f.c(r125, r126));
    L231:
        Object[] r129 = {r128};
        ArrayList r130 = new ArrayList(1);
        Object r131 = r129[0];
        Objects.requireNonNull(r131);
        r130.add(r131);
        r115 = Collections.unmodifiableList(r130);
        goto L250
    L145:
        if (r127.f417193g == true) goto L148;
        this.f417252j = r127.f417191e;
        r128 = i(this.f417248f.c(r125, r126));
        goto L231
    L148:
        if (this.f417248f.h('(') == false) goto L186;
        this.f417248f.m();
        x7b.e r132 = this.f417248f;
        char r133 = r132.j();
        x7b.d r134 = r132.k();
        if (u7b.c.b(r132) == true) goto L153;
        String r135 = r100;
    L157:
        if (r135 != null) goto L160;
        this.f417248f.l(r126);
    L187:
        if (r135 != null) goto L212;
        x7b.e r136 = this.f417248f;
        if (r136.h('[') == false) goto L199;
        x7b.d r137 = r136.k();
        if (u7b.c.c(r136) == false) goto L199;
        x7b.d r138 = r136.k();
        if (r136.h(']') == false) goto L199;
        String r139 = r136.c(r137, r138).a();
        if (r139.length() > 999) goto L199;
    L200:
        if (r139 != null) goto L202;
        this.f417248f.l(r126);
    L202:
        if (r139 == null) goto L206;
        if (r139.isEmpty() == true) goto L206;
    L208:
        if (r139 == null) goto L212;
        o r140 = ((m) this.f417243a).f417242c;
        r140.getClass();
        v7b.o r141 = (v7b.o) ((LinkedHashMap) r140.f417256a).get(u7b.a.a(r139));
        if (r141 == null) goto L212;
        r135 = r141.f553564k;
        r100 = r141.f553565l;
    L206:
        if (r127.f417194h == true) goto L208;
        r139 = this.f417248f.c(r127.f417189c, r125).a();
    L199:
        r139 = null;
    L212:
        if (r135 != null) goto L214;
        this.f417252j = this.f417252j.f417191e;
        this.f417248f.l(r126);
        r128 = i(this.f417248f.c(r125, r126));
        goto L231
    L214:
        if (r127.f417190d == false) goto L216;
        r128 = new v7b.l(r135, r100);
    L217:
        v7b.s r142 = r127.f417187a.f553572h;
    L218:
        if (r142 == null) goto L221;
        v7b.s r143 = r142.f553572h;
        r128.e(r142);
        r142 = r143;
        goto L218
    L221:
        if (this.f417249g == false) goto L223;
        x7b.e r144 = this.f417248f;
        r128.n(r144.c(r127.f417188b, r144.k()).b());
    L223:
        g(r127.f417192f);
        c(r128);
        r127.f417187a.p();
        e r145 = this.f417252j.f417191e;
        this.f417252j = r145;
        if (r127.f417190d == true) goto L231;
    L225:
        if (r145 == null) goto L231;
        if (r145.f417190d == true) goto L229;
        r145.f417193g = false;
    L229:
        r145 = r145.f417191e;
        goto L225
    L216:
        r128 = new v7b.n(r135, r100);
        goto L217
    L160:
        if (this.f417248f.m() < 1) goto L182;
        x7b.e r146 = this.f417248f;
        x7b.d r147 = r146.k();
        if (r146.d() == false) goto L176;
        char r148 = r146.j();
        char r149 = Typography.quote;
        if (r148 == '\"') goto L171;
        r149 = '\'';
        if (r148 == '\'') goto L171;
        if (r148 != '(') goto L176;
        r149 = ')';
    L171:
        r146.g();
        if (u7b.c.d(r146, r149) == false) goto L176;
        if (r146.d() == false) goto L176;
        r146.g();
        boolean r150 = true;
    L178:
        if (r150 == true) goto L180;
        r100 = null;
    L181:
        this.f417248f.m();
    L184:
        if (this.f417248f.h(')') == true) goto L187;
        this.f417248f.l(r126);
        goto L186
    L180:
        String r151 = r146.c(r147, r146.k()).a();
        r100 = u7b.a.b(r151.substring(1, r151.length() - 1));
    L176:
        r150 = false;
        goto L178
    L182:
        r100 = null;
        goto L184
    L153:
        if (r133 != '<') goto L155;
        String r152 = r132.c(r134, r132.k()).a();
        String r153 = r152.substring(1, r152.length() - 1);
    L156:
        r135 = u7b.a.b(r153);
        goto L157
    L155:
        r153 = r132.c(r134, r132.k()).a();
    L186:
        r100 = null;
        r135 = null;
        goto L187
    L23:
        if (this.f417246d.get(r107) == true) goto L25;
        Object[] r154 = {f()};
        ArrayList r155 = new ArrayList(1);
        Object r156 = r154[0];
        Objects.requireNonNull(r156);
        r155.add(r156);
        r115 = Collections.unmodifiableList(r155);
        goto L250
    L25:
        List r157 = (List) ((HashMap) this.f417247e).get(Character.valueOf(r107));
        if (r157 == null) goto L39;
        x7b.d r158 = this.f417248f.k();
        Iterator r159 = r157.iterator();
    L29:
        if (r159.hasNext() == false) goto L39;
        t7b.h r160 = ((x7b.a) r159.next()).a(this);
        if ((r160 instanceof t7b.h) == true) goto L32;
        this.f417248f.l(r158);
        goto L29
    L32:
        v7b.s r161 = r160.f544980a;
        this.f417248f.l(r160.f544981b);
        if (this.f417249g == true) goto L35;
    L37:
        Object[] r162 = {r161};
        ArrayList r163 = new ArrayList(1);
        Object r164 = r162[0];
        Objects.requireNonNull(r164);
        r163.add(r164);
        r115 = Collections.unmodifiableList(r163);
        goto L250
    L35:
        if (r161.j().isEmpty() == false) goto L37;
        x7b.e r165 = this.f417248f;
        r161.n(r165.c(r158, r165.k()).b());
    L39:
        z7b.a r166 = (z7b.a) ((HashMap) this.f417245c).get(Character.valueOf(r107));
        if (r166 == null) goto L140;
        x7b.e r167 = this.f417248f;
        int r168 = r167.f562875c;
        if (r168 <= 0) goto L50;
        int r169 = r168 - 1;
        char r170 = r167.f562876d.f558606a.charAt(r169);
        boolean r171 = Character.isLowSurrogate(r170);
        int r172 = r170;
        r172 = r170;
        if (r171 == false) goto L53;
        if (r169 <= 0) goto L53;
        char r173 = r167.f562876d.f558606a.charAt(r169 - 1);
        r172 = r170;
        if (Character.isHighSurrogate(r173) == false) goto L53;
        r172 = Character.toCodePoint(r173, r170);
    L53:
        x7b.d r174 = this.f417248f.k();
        if (this.f417248f.f(r107) >= r166.a()) goto L56;
        this.f417248f.l(r174);
        a r175 = r100;
    L133:
        if (r175 != 0) goto L135;
        r115 = r100;
    L138:
        if (r115 == 0) goto L140;
    L135:
        List<b0> r176 = r175.f417253a;
        f r177 = new f(r176, r107, r175.f417255c, r175.f417254b, this.f417251i);
        this.f417251i = r177;
        f r178 = r177.f417200f;
        r115 = r176;
        if (r178 == null) goto L138;
        r178.f417201g = r177;
        r115 = r176;
        goto L138
    L56:
        ArrayList r179 = new ArrayList();
        this.f417248f.l(r174);
    L58:
        if (this.f417248f.h(r107) == false) goto L60;
        x7b.e r180 = this.f417248f;
        r179.add(i(r180.c(r174, r180.k())));
        r174 = this.f417248f.k();
        goto L58
    L60:
        x7b.e r181 = this.f417248f;
        int r182 = r181.f562875c;
        if (r182 >= r181.f562877e) goto L70;
        char r183 = r181.f562876d.f558606a.charAt(r182);
        boolean r184 = Character.isHighSurrogate(r183);
        r108 = r183;
        if (r184 == false) goto L73;
        int r185 = r181.f562875c + 1;
        r108 = r183;
        if (r185 >= r181.f562877e) goto L73;
        char r186 = r181.f562876d.f558606a.charAt(r185);
        r108 = r183;
        if (Character.isLowSurrogate(r186) == false) goto L73;
        r108 = Character.toCodePoint(r183, r186);
    L73:
        if (r172 != 0) goto L75;
    L78:
        boolean r187 = true;
    L79:
        if (r172 != 0) goto L81;
    L84:
        boolean r188 = true;
    L85:
        if (r108 != 0) goto L87;
    L90:
        boolean r189 = true;
    L91:
        if (r108 != 0) goto L93;
    L96:
        boolean r190 = true;
    L97:
        if (r190 == true) goto L102;
        if (r189 == false) goto L101;
        if (r188 == true) goto L101;
        if (r187 == false) goto L102;
    L101:
        boolean r191 = true;
    L103:
        if (r188 == true) goto L108;
        if (r187 == false) goto L107;
        if (r190 == true) goto L107;
        if (r189 == false) goto L108;
    L107:
        boolean r192 = true;
    L110:
        if (r107 != '_') goto L121;
        if (r191 == false) goto L115;
        if (r192 == false) goto L114;
        if (r187 == false) goto L115;
    L114:
        boolean r193 = true;
    L116:
        if (r192 == false) goto L120;
        if (r191 == false) goto L119;
        if (r189 == false) goto L120;
    L119:
        boolean r194 = true;
    L132:
        r175 = new a(r179, r193, r194);
    L120:
        r194 = false;
    L115:
        r193 = false;
        goto L116
    L121:
        if (r191 == true) goto L123;
    L125:
        boolean r195 = false;
    L126:
        if (r192 == true) goto L128;
    L130:
        r194 = false;
    L131:
        r193 = r195;
        goto L132
    L128:
        if (r107 != r166.b()) goto L130;
        r194 = true;
        goto L131
    L123:
        if (r107 != r166.c()) goto L125;
        r195 = true;
    L108:
        r192 = false;
    L102:
        r191 = false;
        goto L103
    L93:
        if (a8b.b.b(r108) == true) goto L96;
        r190 = false;
        goto L97
    L87:
        if (a8b.b.a(r108) == true) goto L90;
        r189 = false;
        goto L91
    L81:
        if (a8b.b.b(r172) == true) goto L84;
        r188 = false;
        goto L85
    L75:
        if (a8b.b.a(r172) == true) goto L78;
        r187 = false;
        goto L79
    L70:
        if (r181.f562874b < (r181.f562873a.size() - 1)) goto L73;
        r108 = 0;
        goto L73
    L50:
        if (r167.f562874b <= 0) goto L52;
        r172 = 10;
        goto L53
    L52:
        r172 = 0;
    L140:
        Object[] r196 = {f()};
        ArrayList r197 = new ArrayList(1);
        Object r198 = r196[0];
        Objects.requireNonNull(r198);
        r197.add(r198);
        r115 = Collections.unmodifiableList(r197);
        goto L250
    L236:
        x7b.d r199 = this.f417248f.k();
        this.f417248f.g();
        if (this.f417248f.h('[') == false) goto L242;
        x7b.d r1100 = this.f417248f.k();
        b0 r200 = i(this.f417248f.c(r199, r1100));
        e r201 = this.f417252j;
        e r202 = new e(r200, r199, r1100, r201, this.f417251i, true);
        if (r201 == null) goto L241;
        r201.f417194h = true;
    L241:
        this.f417252j = r202;
    L243:
        Object[] r203 = {r200};
        ArrayList r204 = new ArrayList(1);
        Object r205 = r203[0];
        Objects.requireNonNull(r205);
        r204.add(r205);
        r115 = Collections.unmodifiableList(r204);
        goto L250
    L242:
        x7b.e r206 = this.f417248f;
        r200 = i(r206.c(r199, r206.k()));
        goto L243
    L249:
        r115 = 0;
        goto L250
    }

    public static void a(char r100, z7b.a r101, Map<Character, z7b.a> r102) {
        if (((z7b.a) ((HashMap) r102).put(Character.valueOf(r100), r101)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + r100 + "'");
    }

    public final void d(b0 r100, b0 r101, int r102) {
        if (r100 == null) goto L26;
        if (r101 == null) goto L27;
        if (r100 == r101) goto L28;
        StringBuilder r103 = new StringBuilder(r102);
        r103.append(r100.f553548j);
        if (this.f417249g == false) goto L8;
        y r104 = new y();
        r104.a(r100.j());
    L9:
        v7b.s r105 = r100.f553572h;
        v7b.s r106 = r101.f553572h;
    L10:
        if (r105 == r106) goto L15;
        r103.append(((b0) r105).f553548j);
        if (r104 == null) goto L14;
        r104.a(r105.j());
    L14:
        v7b.s r107 = r105.f553572h;
        r105.p();
        r105 = r107;
        goto L10
    L15:
        r100.f553548j = r103.toString();
        if (r104 == null) goto L29;
        List<x> r108 = r104.f553581a;
        if (r108 != null) goto L21;
        r108 = Collections.emptyList();
    L21:
        r100.n(r108);
        return;
    L29:
        return;
    L8:
        r104 = null;
        goto L9
    L28:
        return;
    L27:
        return;
    }
}
