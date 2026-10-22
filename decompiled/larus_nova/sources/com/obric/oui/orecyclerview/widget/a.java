package com.obric.oui.orecyclerview.widget;

import androidx.core.util.Pools;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pools.SimplePool f401772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f401773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f401774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC4675a f401775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f401776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f401777f;

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC4675a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f401780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401781d;

        public final int hashCode() {
            return (((this.f401778a * 31) + this.f401779b) * 31) + this.f401781d;
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append(Integer.toHexString(System.identityHashCode(this)));
            r100.append("[");
            int r101 = this.f401778a;
            if (r101 != 1) goto L5;
            String r102 = "add";
        L15:
            r100.append(r102);
            r100.append(",s:");
            r100.append(this.f401779b);
            r100.append("c:");
            r100.append(this.f401781d);
            r100.append(",p:");
            r100.append(this.f401780c);
            r100.append("]");
            return r100.toString();
        L5:
            if (r101 != 2) goto L7;
            r102 = "rm";
            goto L15
        L7:
            if (r101 != 4) goto L9;
            r102 = "up";
            goto L15
        L9:
            if (r101 == 8) goto L11;
            r102 = "??";
            goto L15
        L11:
            r102 = KtvSubElement.MV;
            goto L15
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            int r102 = this.f401778a;
            if (r102 == r101.f401778a) goto L12;
            return false;
        L12:
            if (r102 != 8) goto L21;
            if (Math.abs(this.f401781d - this.f401779b) != 1) goto L21;
            if (this.f401781d != r101.f401779b) goto L21;
            if (this.f401779b != r101.f401781d) goto L21;
            return true;
        L21:
            if (this.f401781d == r101.f401781d) goto L24;
            return false;
        L24:
            if (this.f401779b == r101.f401779b) goto L26;
            return false;
        L26:
            Object r103 = this.f401780c;
            if (r103 == null) goto L32;
            if (r103.equals(r101.f401780c) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r101.f401780c == null) goto L34;
            return false;
        }

        public b(int r100, int r101, int r102, Object r103) {
            this.f401778a = r100;
            this.f401779b = r101;
            this.f401781d = r102;
            this.f401780c = r103;
        }
    }

    public final void b() {
        int r100 = this.f401774c.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        InterfaceC4675a r102 = this.f401775d;
        e0 r103 = (e0) r102;
        r103.a((b) ListProtector.get(this.f401774c, r101));
        r101 = r101 + 1;
        goto L3
    L5:
        k(this.f401774c);
        this.f401777f = 0;
    }

    public final boolean g() {
        if (this.f401773b.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        z r100 = this.f401776e;
        ArrayList<b> r101 = this.f401773b;
        r100.getClass();
    L3:
        int r102 = r101.size() - 1;
        boolean r103 = false;
    L5:
        if (r102 < 0) goto L12;
        if (((b) ListProtector.get(r101, r102)).f401778a != 8) goto L10;
        if (r103 == false) goto L11;
    L14:
        if (r102 == (-1)) goto L120;
        int r104 = r102 + 1;
        b r110 = (b) ListProtector.get(r101, r102);
        b r111 = (b) ListProtector.get(r101, r104);
        int r112 = r111.f401778a;
        if (r112 != 1) goto L17;
        int r105 = r110.f401781d;
        int r106 = r111.f401779b;
        if (r105 >= r106) goto L110;
        int r107 = -1;
    L111:
        int r108 = r110.f401779b;
        if (r108 >= r106) goto L114;
        r107 = r107 + 1;
    L114:
        if (r106 > r108) goto L116;
        r110.f401779b = r108 + r111.f401781d;
    L116:
        int r109 = r111.f401779b;
        if (r109 > r105) goto L119;
        r110.f401781d = r105 + r111.f401781d;
    L119:
        r111.f401779b = r109 + r107;
        ListProtector.set(r101, r102, r111);
        ListProtector.set(r101, r104, r110);
        goto L3
    L110:
        r107 = 0;
        goto L111
    L17:
        if (r112 != 2) goto L18;
        int r113 = r110.f401779b;
        int r114 = r110.f401781d;
        if (r113 >= r114) goto L51;
        if (r111.f401779b == r113) goto L47;
    L49:
        boolean r115 = false;
        boolean r116 = false;
    L57:
        int r117 = r111.f401779b;
        if (r114 < r117) goto L59;
        int r118 = r111.f401781d;
        if (r114 >= (r117 + r118)) goto L65;
        r111.f401781d = r118 - 1;
        r110.f401778a = 2;
        r110.f401781d = 1;
        if (r111.f401781d != 0) goto L3;
        ListProtector.remove(r101, r104);
        a r119 = (a) r100.f401969a;
        r119.getClass();
        r111.f401780c = null;
        r119.f401772a.release(r111);
    L65:
        int r120 = r110.f401779b;
        int r121 = r111.f401779b;
        if (r120 > r121) goto L68;
        r111.f401779b = r121 + 1;
    L71:
        b r122 = null;
    L72:
        if (r115 == true) goto L73;
        if (r116 == false) goto L88;
        if (r122 == null) goto L82;
        int r123 = r110.f401779b;
        if (r123 <= r122.f401779b) goto L79;
        r110.f401779b = r123 - r122.f401781d;
    L79:
        int r124 = r110.f401781d;
        if (r124 <= r122.f401779b) goto L82;
        r110.f401781d = r124 - r122.f401781d;
    L82:
        int r125 = r110.f401779b;
        if (r125 <= r111.f401779b) goto L85;
        r110.f401779b = r125 - r111.f401781d;
    L85:
        int r126 = r110.f401781d;
        if (r126 <= r111.f401779b) goto L101;
        r110.f401781d = r126 - r111.f401781d;
    L101:
        ListProtector.set(r101, r102, r111);
        if (r110.f401779b == r110.f401781d) goto L104;
        ListProtector.set(r101, r104, r110);
    L105:
        if (r122 == null) goto L3;
        ListProtector.add(r101, r102, r122);
        goto L3
    L104:
        ListProtector.remove(r101, r104);
        goto L105
    L88:
        if (r122 == null) goto L95;
        int r127 = r110.f401779b;
        if (r127 < r122.f401779b) goto L92;
        r110.f401779b = r127 - r122.f401781d;
    L92:
        int r128 = r110.f401781d;
        if (r128 < r122.f401779b) goto L95;
        r110.f401781d = r128 - r122.f401781d;
    L95:
        int r129 = r110.f401779b;
        if (r129 < r111.f401779b) goto L98;
        r110.f401779b = r129 - r111.f401781d;
    L98:
        int r130 = r110.f401781d;
        if (r130 < r111.f401779b) goto L101;
        r110.f401781d = r130 - r111.f401781d;
        goto L101
    L73:
        ListProtector.set(r101, r102, r111);
        ListProtector.remove(r101, r104);
        a r131 = (a) r100.f401969a;
        r131.getClass();
        r110.f401780c = null;
        r131.f401772a.release(r110);
        goto L3
    L68:
        int r132 = r121 + r111.f401781d;
        if (r120 >= r132) goto L71;
        a r133 = (a) r100.f401969a;
        r122 = r133.h(2, r120 + 1, r132 - r120, null);
        r111.f401781d = r110.f401779b - r111.f401779b;
        goto L72
    L59:
        r111.f401779b = r117 - 1;
        goto L65
    L47:
        if (r111.f401781d != (r114 - r113)) goto L49;
        boolean r134 = false;
    L55:
        r116 = r134;
        r115 = true;
        goto L57
    L51:
        if (r111.f401779b == (r114 + 1)) goto L53;
    L56:
        r115 = false;
        r116 = true;
        goto L57
    L53:
        if (r111.f401781d != (r113 - r114)) goto L56;
        r134 = true;
        goto L55
    L18:
        if (r112 != 4) goto L3;
        int r135 = r110.f401781d;
        int r136 = r111.f401779b;
        if (r135 >= r136) goto L23;
        r111.f401779b = r136 - 1;
    L26:
        b r137 = null;
    L27:
        int r138 = r110.f401779b;
        int r139 = r111.f401779b;
        if (r138 > r139) goto L30;
        r111.f401779b = r139 + 1;
    L33:
        b r140 = null;
    L34:
        ListProtector.set(r101, r104, r110);
        if (r111.f401781d <= 0) goto L37;
        ListProtector.set(r101, r102, r111);
    L38:
        if (r137 == null) goto L40;
        ListProtector.add(r101, r102, r137);
    L40:
        if (r140 == null) goto L3;
        ListProtector.add(r101, r102, r140);
        goto L3
    L37:
        ListProtector.remove(r101, r102);
        a r141 = (a) r100.f401969a;
        r141.getClass();
        r111.f401780c = null;
        r141.f401772a.release(r111);
        goto L38
    L30:
        int r142 = r139 + r111.f401781d;
        if (r138 >= r142) goto L33;
        int r143 = r142 - r138;
        r140 = ((a) r100.f401969a).h(4, r138 + 1, r143, r111.f401780c);
        r111.f401781d -= r143;
        goto L34
    L23:
        int r144 = r111.f401781d;
        if (r135 >= (r136 + r144)) goto L26;
        r111.f401781d = r144 - 1;
        r137 = ((a) r100.f401969a).h(4, r110.f401779b, 1, r111.f401780c);
        goto L27
    L120:
        int r145 = this.f401773b.size();
        int r146 = 0;
    L121:
        if (r146 >= r145) goto L176;
        b r147 = (b) ListProtector.get(this.f401773b, r146);
        int r148 = r147.f401778a;
        if (r148 == 1) goto L174;
        if (r148 == 2) goto L149;
        if (r148 == 4) goto L129;
        if (r148 != 8) goto L175;
        i(r147);
    L175:
        r146 = r146 + 1;
        goto L121
    L129:
        int r149 = r147.f401779b;
        int r150 = r147.f401781d + r149;
        int r151 = r149;
        int r152 = 0;
        byte r153 = -1;
    L130:
        if (r149 >= r150) goto L144;
        if (((e0) this.f401775d).b(r149) == null) goto L134;
    L139:
        if (r153 != 0) goto L141;
        d(h(4, r151, r152, r147.f401780c));
        r151 = r149;
        r152 = 0;
    L141:
        r153 = 1;
    L142:
        r152 = r152 + 1;
        r149 = r149 + 1;
        goto L130
    L134:
        if (a(r149) == true) goto L139;
        if (r153 != 1) goto L138;
        i(h(4, r151, r152, r147.f401780c));
        r151 = r149;
        r152 = 0;
    L138:
        r153 = 0;
        goto L142
    L144:
        if (r152 == r147.f401781d) goto L146;
        Object r154 = r147.f401780c;
        r147.f401780c = null;
        this.f401772a.release(r147);
        r147 = h(4, r151, r152, r154);
    L146:
        if (r153 != 0) goto L148;
        d(r147);
        goto L175
    L148:
        i(r147);
        goto L175
    L149:
        int r155 = r147.f401779b;
        int r156 = r147.f401781d + r155;
        int r157 = r155;
        int r158 = 0;
        byte r159 = -1;
    L150:
        if (r157 >= r156) goto L169;
        if (((e0) this.f401775d).b(r157) == null) goto L154;
    L160:
        if (r159 != 0) goto L162;
        d(h(2, r155, r158, null));
        boolean r160 = true;
    L163:
        byte r161 = 1;
    L164:
        if (r160 == false) goto L166;
        r157 = r157 - r158;
        r156 = r156 - r158;
        r158 = 1;
    L167:
        r157 = r157 + 1;
        r159 = r161;
        goto L150
    L166:
        r158 = r158 + 1;
        goto L167
    L162:
        r160 = false;
        goto L163
    L154:
        if (a(r157) == true) goto L160;
        if (r159 != 1) goto L158;
        i(h(2, r155, r158, null));
        r160 = true;
    L159:
        r161 = 0;
        goto L164
    L158:
        r160 = false;
        goto L159
    L169:
        if (r158 == r147.f401781d) goto L171;
        r147.f401780c = null;
        this.f401772a.release(r147);
        r147 = h(2, r155, r158, null);
    L171:
        if (r159 != 0) goto L173;
        d(r147);
        goto L175
    L173:
        i(r147);
        goto L175
    L174:
        i(r147);
        goto L175
    L176:
        this.f401773b.clear();
        return;
    L11:
        r102 = r102 - 1;
        goto L5
    L10:
        r103 = true;
        goto L11
    L12:
        r102 = -1;
        goto L14
    }

    public final void c() {
        b();
        int r100 = this.f401773b.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L18;
        b r102 = (b) ListProtector.get(this.f401773b, r101);
        int r103 = r102.f401778a;
        if (r103 != 1) goto L7;
        ((e0) this.f401775d).a(r102);
        ((e0) this.f401775d).d(r102.f401779b, r102.f401781d);
    L17:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        ((e0) this.f401775d).a(r102);
        InterfaceC4675a r104 = this.f401775d;
        int r105 = r102.f401779b;
        int r106 = r102.f401781d;
        e0 r107 = (e0) r104;
        r107.f401809a.J(r105, r106, true);
        RecyclerView r108 = r107.f401809a;
        r108.f401604b1 = true;
        r108.L0.f401708c += r106;
        goto L17
    L9:
        if (r103 != 4) goto L11;
        ((e0) this.f401775d).a(r102);
        ((e0) this.f401775d).c(r102.f401779b, r102.f401781d, r102.f401780c);
        goto L17
    L11:
        if (r103 != 8) goto L17;
        ((e0) this.f401775d).a(r102);
        ((e0) this.f401775d).e(r102.f401779b, r102.f401781d);
        goto L17
    L18:
        k(this.f401773b);
        this.f401777f = 0;
    }

    public a(e0 r100) {
        this.f401772a = new Pools.SimplePool(30);
        this.f401773b = new ArrayList();
        this.f401774c = new ArrayList();
        this.f401777f = 0;
        this.f401775d = r100;
        this.f401776e = new z(this);
    }

    public final boolean a(int r100) {
        int r101 = this.f401774c.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L17;
        b r103 = (b) ListProtector.get(this.f401774c, r102);
        int r104 = r103.f401778a;
        if (r104 == 8) goto L7;
        if (r104 != 1) goto L16;
        int r105 = r103.f401779b;
        int r106 = r103.f401781d + r105;
    L11:
        if (r105 >= r106) goto L16;
        if (f(r105, r102 + 1) == r100) goto L14;
        r105 = r105 + 1;
        goto L11
    L14:
        return true;
    L16:
        r102 = r102 + 1;
        goto L3
    L7:
        if (f(r103.f401781d, r102 + 1) != r100) goto L16;
        return true;
    L17:
        return false;
    }

    public final void d(b r110) {
        int r100 = r110.f401778a;
        if (r100 == 1) goto L38;
        if (r100 == 8) goto L38;
        int r101 = l(r110.f401779b, r100);
        int r102 = r110.f401779b;
        int r103 = r110.f401778a;
        if (r103 == 2) goto L12;
        if (r103 != 4) goto L11;
        int r104 = 1;
    L13:
        int r105 = 1;
        int r106 = 1;
    L15:
        if (r105 >= r110.f401781d) goto L33;
        int r107 = l(r110.f401779b + (r104 * r105), r110.f401778a);
        int r111 = r110.f401778a;
        if (r111 == 2) goto L23;
        if (r111 == 4) goto L21;
    L25:
        boolean r112 = false;
    L26:
        if (r112 == false) goto L28;
        r106 = r106 + 1;
    L32:
        r105 = r105 + 1;
        goto L15
    L28:
        b r108 = h(r111, r101, r106, r110.f401780c);
        e(r108, r102);
        r108.f401780c = null;
        this.f401772a.release(r108);
        if (r110.f401778a != 4) goto L31;
        r102 = r102 + r106;
    L31:
        r101 = r107;
        r106 = 1;
        goto L32
    L21:
        if (r107 != (r101 + 1)) goto L25;
    L24:
        r112 = true;
        goto L26
    L23:
        if (r107 != r101) goto L25;
    L33:
        Object r109 = r110.f401780c;
        r110.f401780c = null;
        this.f401772a.release(r110);
        if (r106 <= 0) goto L42;
        b r113 = h(r110.f401778a, r101, r106, r109);
        e(r113, r102);
        r113.f401780c = null;
        this.f401772a.release(r113);
        return;
    L42:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r110);
    L12:
        r104 = 0;
    L38:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public final void i(b r100) {
        this.f401774c.add(r100);
        int r101 = r100.f401778a;
        if (r101 != 1) goto L5;
        ((e0) this.f401775d).d(r100.f401779b, r100.f401781d);
        return;
    L5:
        if (r101 != 2) goto L7;
        InterfaceC4675a r102 = this.f401775d;
        e0 r103 = (e0) r102;
        r103.f401809a.J(r100.f401779b, r100.f401781d, false);
        r103.f401809a.f401604b1 = true;
        return;
    L7:
        if (r101 != 4) goto L9;
        ((e0) this.f401775d).c(r100.f401779b, r100.f401781d, r100.f401780c);
        return;
    L9:
        if (r101 != 8) goto L12;
        ((e0) this.f401775d).e(r100.f401779b, r100.f401781d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r100);
    }

    public final void k(List<b> r100) {
        ArrayList r101 = (ArrayList) r100;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        b r104 = (b) ListProtector.get(r101, r103);
        r104.f401780c = null;
        this.f401772a.release(r104);
        r103 = r103 + 1;
        goto L3
    L5:
        r101.clear();
    }

    public final void e(b r100, int r101) {
        ((e0) this.f401775d).a(r100);
        int r102 = r100.f401778a;
        if (r102 != 2) goto L5;
        InterfaceC4675a r103 = this.f401775d;
        int r104 = r100.f401781d;
        e0 r105 = (e0) r103;
        r105.f401809a.J(r101, r104, true);
        RecyclerView r106 = r105.f401809a;
        r106.f401604b1 = true;
        r106.L0.f401708c += r104;
        return;
    L5:
        if (r102 != 4) goto L8;
        ((e0) this.f401775d).c(r101, r100.f401781d, r100.f401780c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public final int f(int r100, int r101) {
        int r102 = this.f401774c.size();
    L3:
        if (r101 >= r102) goto L27;
        b r103 = (b) ListProtector.get(this.f401774c, r101);
        int r104 = r103.f401778a;
        if (r104 != 8) goto L14;
        int r105 = r103.f401779b;
        if (r105 != r100) goto L9;
        r100 = r103.f401781d;
    L26:
        r101 = r101 + 1;
        goto L3
    L9:
        if (r105 >= r100) goto L12;
        r100 = r100 - 1;
    L12:
        if (r103.f401781d > r100) goto L26;
        r100 = r100 + 1;
        goto L26
    L14:
        int r106 = r103.f401779b;
        if (r106 > r100) goto L26;
        if (r104 != 2) goto L24;
        int r107 = r103.f401781d;
        if (r100 < (r106 + r107)) goto L20;
        r100 = r100 - r107;
        goto L26
    L20:
        return -1;
    L24:
        if (r104 != 1) goto L26;
        r100 = r100 + r103.f401781d;
        goto L26
    L27:
        return r100;
    }

    public final int l(int r100, int r110) {
        int r101 = this.f401774c.size() - 1;
    L4:
        if (r101 < 0) goto L40;
        b r102 = (b) ListProtector.get(this.f401774c, r101);
        int r103 = r102.f401778a;
        if (r103 != 8) goto L29;
        int r104 = r102.f401779b;
        int r105 = r102.f401781d;
        if (r104 >= r105) goto L10;
        int r106 = r104;
        int r107 = r105;
    L11:
        if (r100 < r106) goto L24;
        if (r100 > r107) goto L24;
        if (r106 != r104) goto L19;
        if (r110 != 1) goto L16;
        r102.f401781d = r105 + 1;
    L18:
        r100 = r100 + 1;
    L39:
        r101 = r101 - 1;
        goto L4
    L16:
        if (r110 != 2) goto L18;
        r102.f401781d = r105 - 1;
        goto L18
    L19:
        if (r110 != 1) goto L21;
        r102.f401779b = r104 + 1;
    L23:
        r100 = r100 - 1;
        goto L39
    L21:
        if (r110 != 2) goto L23;
        r102.f401779b = r104 - 1;
    L24:
        if (r100 >= r104) goto L39;
        if (r110 != 1) goto L27;
        r102.f401779b = r104 + 1;
        r102.f401781d = r105 + 1;
        goto L39
    L27:
        if (r110 != 2) goto L39;
        r102.f401779b = r104 - 1;
        r102.f401781d = r105 - 1;
        goto L39
    L10:
        r107 = r104;
        r106 = r105;
        goto L11
    L29:
        int r108 = r102.f401779b;
        if (r108 > r100) goto L35;
        if (r103 != 1) goto L33;
        r100 = r100 - r102.f401781d;
        goto L39
    L33:
        if (r103 != 2) goto L39;
        r100 = r100 + r102.f401781d;
        goto L39
    L35:
        if (r110 != 1) goto L37;
        r102.f401779b = r108 + 1;
        goto L39
    L37:
        if (r110 != 2) goto L39;
        r102.f401779b = r108 - 1;
        goto L39
    L40:
        int r111 = this.f401774c.size() - 1;
    L41:
        if (r111 < 0) goto L52;
        b r109 = (b) ListProtector.get(this.f401774c, r111);
        if (r109.f401778a != 8) goto L49;
        int r112 = r109.f401781d;
        if (r112 == r109.f401779b) goto L47;
        if (r112 < 0) goto L47;
    L51:
        r111 = r111 - 1;
    L47:
        ListProtector.remove(this.f401774c, r111);
        r109.f401780c = null;
        this.f401772a.release(r109);
        goto L51
    L49:
        if (r109.f401781d > 0) goto L51;
        ListProtector.remove(this.f401774c, r111);
        r109.f401780c = null;
        this.f401772a.release(r109);
        goto L51
    L52:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b h(int r100, int r101, int r102, Object r103) {
        b r104 = (b) this.f401772a.acquire();
        if (r104 == null) goto L7;
        r104.f401778a = r100;
        r104.f401779b = r101;
        r104.f401781d = r102;
        r104.f401780c = r103;
        return r104;
    L7:
        return new b(r100, r101, r102, r103);
    }
}
