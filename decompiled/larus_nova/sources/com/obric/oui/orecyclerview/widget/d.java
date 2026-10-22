package com.obric.oui.orecyclerview.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f401791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f401792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f401793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f401794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f401795e;

    public class a extends q.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f401796a;

        public a(d r100) {
            this.f401796a = r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.obric.oui.orecyclerview.widget.q.b
        public final boolean a(int r100, int r101) {
            Object r102 = ListProtector.get(this.f401796a.f401791a, r100);
            Object r103 = ListProtector.get(this.f401796a.f401792b, r101);
            if (r102 == null) goto L7;
            if (r103 == null) goto L7;
            return this.f401796a.f401795e.f401802b.f401784b.a((T) r102, (T) r103);
        L7:
            if (r102 != null) goto L12;
            if (r103 != null) goto L12;
            return true;
        L12:
            throw new AssertionError();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.obric.oui.orecyclerview.widget.q.b
        public final boolean b(int r100, int r101) {
            Object r102 = ListProtector.get(this.f401796a.f401791a, r100);
            Object r103 = ListProtector.get(this.f401796a.f401792b, r101);
            if (r102 == null) goto L7;
            if (r103 == null) goto L7;
            return this.f401796a.f401795e.f401802b.f401784b.b((T) r102, (T) r103);
        L7:
            if (r102 != null) goto L10;
            if (r103 != null) goto L10;
            return true;
        L10:
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.q.b
        public final void c(int r100, int r101) {
            Object r102 = ListProtector.get(this.f401796a.f401791a, r100);
            Object r103 = ListProtector.get(this.f401796a.f401792b, r101);
            if (r102 == null) goto L8;
            if (r103 == null) goto L8;
            this.f401796a.f401795e.f401802b.f401784b.getClass();
            return;
        L8:
            throw new AssertionError();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q.d f401797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f401798b;

        public final void a() {
            d r100 = this.f401798b;
            e r101 = r100.f401795e;
            if (r101.f401807g != r100.f401793c) goto L60;
            List<T> r102 = r100.f401792b;
            q.d r103 = this.f401797a;
            Runnable r104 = r100.f401794d;
            Collection r105 = r101.f401806f;
            r101.f401805e = r102;
            r101.f401806f = Collections.unmodifiableList(r102);
            x r106 = r101.f401801a;
            r103.getClass();
            if ((r106 instanceof f) == false) goto L7;
            f r107 = (f) r106;
        L8:
            int r108 = r103.f401895e;
            ArrayDeque r109 = new ArrayDeque();
            int r110 = r103.f401895e;
            int r111 = r103.f401896f;
            int r112 = r103.f401891a.size() - 1;
        L9:
            if (r112 < 0) goto L44;
            q.c r113 = (q.c) ListProtector.get(r103.f401891a, r112);
            int r114 = r113.f401888a;
            int r115 = r113.f401890c;
            int r116 = r114 + r115;
            int r117 = r113.f401889b + r115;
        L12:
            if (r110 <= r116) goto L24;
            r110 = r110 - 1;
            int r118 = r103.f401892b[r110];
            if ((r118 & 12) == 0) goto L21;
            int r119 = r118 >> 4;
            q.f r120 = q.d.a(r109, r119, false);
            if (r120 == null) goto L20;
            int r121 = r111;
            int r122 = (r108 - r120.f401899b) - 1;
            r107.onMoved(r110, r122);
            if ((r118 & 4) == 0) goto L22;
            r103.f401894d.c(r110, r119);
            r107.onChanged(r122, 1, null);
        L22:
            r111 = r121;
            goto L12
        L20:
            r121 = r111;
            r109.add(new q.f(r110, (r108 - r110) - 1, true));
            goto L22
        L21:
            r121 = r111;
            r107.onRemoved(r110, 1);
            r108 = r108 - 1;
        L24:
            if (r111 <= r117) goto L35;
            r111 = r111 - 1;
            int r123 = r103.f401893c[r111];
            if ((r123 & 12) == 0) goto L33;
            int r124 = r123 >> 4;
            q.f r125 = q.d.a(r109, r124, true);
            if (r125 != null) goto L30;
            r109.add(new q.f(r111, r108 - r110, false));
            goto L24
        L30:
            r107.onMoved((r108 - r125.f401899b) - 1, r110);
            if ((r123 & 4) == 0) goto L24;
            r103.f401894d.c(r124, r111);
            r107.onChanged(r110, 1, null);
            goto L24
        L33:
            r107.onInserted(r110, 1);
            r108 = r108 + 1;
            goto L24
        L35:
            int r126 = r113.f401888a;
            int r127 = r113.f401889b;
            int r128 = 0;
        L37:
            if (r128 >= r113.f401890c) goto L43;
            if ((r103.f401892b[r126] & 15) != 2) goto L42;
            r103.f401894d.c(r126, r127);
            r107.onChanged(r126, 1, null);
        L42:
            r126 = r126 + 1;
            r127 = r127 + 1;
            r128 = r128 + 1;
            goto L37
        L43:
            r110 = r113.f401888a;
            r111 = r113.f401889b;
            r112 = r112 - 1;
            goto L9
        L44:
            r107.a();
            r101.a(r105, r104);
            return;
        L7:
            r107 = new f(r106);
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100, q.d r101) {
            this.f401798b = r100;
            this.f401797a = r101;
        }
    }

    public final void a() {
        a r100 = new a(this);
        q.a r101 = q.f401887a;
        int r102 = this.f401791a.size();
        int r103 = this.f401792b.size();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        r105.add(new q.g(r102, r103));
        int r106 = r102 + r103;
        int r107 = 1;
        int r108 = (((r106 + 1) / 2) * 2) + 1;
        int[] r109 = new int[r108];
        int r110 = r108 / 2;
        int[] r111 = new int[r108];
        ArrayList r112 = new ArrayList();
    L4:
        if (r105.isEmpty() == true) goto L122;
        q.g r113 = (q.g) ListProtector.remove(r105, r105.size() - r107);
        int r114 = r113.f401902b;
        int r115 = r113.f401901a;
        int r116 = r114 - r115;
        if (r116 < r107) goto L95;
        int r117 = r113.f401904d - r113.f401903c;
        if (r117 < r107) goto L95;
        int r118 = ((r116 + r117) + r107) / 2;
        int r119 = r107 + r110;
        r109[r119] = r115;
        r111[r119] = r114;
        int r120 = 0;
    L11:
        if (r120 >= r118) goto L95;
        if ((Math.abs((r113.f401902b - r113.f401901a) - (r113.f401904d - r113.f401903c)) % 2) != r107) goto L15;
        boolean r121 = true;
    L16:
        int r122 = (r113.f401902b - r113.f401901a) - (r113.f401904d - r113.f401903c);
        int r123 = -r120;
        int r124 = r123;
    L17:
        if (r124 > r120) goto L52;
        if (r124 == r123) goto L25;
        if (r124 == r120) goto L23;
        int r125 = r118;
        if (r109[(r124 + 1) + r110] > r109[(r124 - 1) + r110]) goto L26;
    L24:
        int r126 = r109[(r124 - 1) + r110];
        int r127 = r126 + 1;
    L27:
        ArrayList r128 = r105;
        int r129 = (r113.f401903c + (r127 - r113.f401901a)) - r124;
        if (r120 == 0) goto L32;
        if (r127 != r126) goto L32;
        int r130 = r129 - 1;
    L33:
        ArrayList r131 = r112;
    L35:
        if (r127 >= r113.f401902b) goto L41;
        if (r129 >= r113.f401904d) goto L41;
        if (r100.b(r127, r129) == false) goto L41;
        r127 = r127 + 1;
        r129 = r129 + 1;
    L41:
        r109[r124 + r110] = r127;
        if (r121 == false) goto L50;
        int r132 = r122 - r124;
        boolean r133 = r121;
        if (r132 < (r123 + 1)) goto L51;
        if (r132 > (r120 - 1)) goto L51;
        if (r111[r132 + r110] > r127) goto L51;
        q.h r134 = new q.h();
        r134.f401905a = r126;
        r134.f401906b = r130;
        r134.f401907c = r127;
        r134.f401908d = r129;
        r134.f401909e = false;
    L53:
        if (r134 != null) goto L54;
        int r135 = (r113.f401902b - r113.f401901a) - (r113.f401904d - r113.f401903c);
        if ((r135 % 2) != 0) goto L58;
        boolean r136 = true;
    L59:
        int r137 = r123;
    L60:
        if (r137 > r120) goto L91;
        if (r137 == r123) goto L67;
        if (r137 != r120) goto L64;
    L66:
        int r138 = r111[(r137 - 1) + r110];
        int r139 = r138 - 1;
    L68:
        int r140 = r113.f401904d - ((r113.f401902b - r139) - r137);
        if (r120 == 0) goto L73;
        if (r139 != r138) goto L73;
        int r141 = r140 + 1;
    L75:
        if (r139 <= r113.f401901a) goto L81;
        if (r140 <= r113.f401903c) goto L81;
        int r142 = r139 - 1;
        q.g r143 = r113;
        int r144 = r140 - 1;
        if (r100.b(r142, r144) == false) goto L82;
        r139 = r142;
        r140 = r144;
        r113 = r143;
    L82:
        r111[r137 + r110] = r139;
        if (r136 == false) goto L90;
        int r145 = r135 - r137;
        if (r145 < r123) goto L90;
        if (r145 > r120) goto L90;
        if (r109[r145 + r110] < r139) goto L90;
        q.h r146 = new q.h();
        r146.f401905a = r139;
        r146.f401906b = r140;
        r146.f401907c = r138;
        r146.f401908d = r141;
        r146.f401909e = true;
    L92:
        if (r146 != null) goto L93;
        r120 = r120 + 1;
        r105 = r128;
        r118 = r125;
        r112 = r131;
        r113 = r143;
        r107 = 1;
        goto L11
    L93:
        q.h r147 = r146;
    L96:
        if (r147 != null) goto L98;
        ArrayList r148 = r128;
        ArrayList r149 = r131;
        r107 = 1;
        r149.add(r143);
    L121:
        ArrayList r210 = r148;
        r112 = r149;
        r105 = r210;
        goto L4
    L98:
        if (r147.a() <= 0) goto L116;
        int r150 = r147.f401908d;
        int r151 = r147.f401906b;
        int r152 = r150 - r151;
        int r153 = r147.f401907c;
        int r154 = r147.f401905a;
        int r155 = r153 - r154;
        if (r152 == r155) goto L102;
        boolean r156 = true;
    L103:
        if (r156 == true) goto L105;
        q.c r157 = new q.c(r154, r151, r155);
    L114:
        r104.add(r157);
        goto L116
    L105:
        if (r147.f401909e == false) goto L107;
        r157 = new q.c(r154, r151, r147.a());
        goto L114
    L107:
        if (r152 <= r155) goto L109;
        boolean r158 = true;
    L110:
        if (r158 == false) goto L112;
        r157 = new q.c(r154, r151 + 1, r147.a());
        goto L114
    L112:
        r157 = new q.c(r154 + 1, r151, r147.a());
        goto L114
    L109:
        r158 = false;
        goto L110
    L102:
        r156 = false;
    L116:
        if (r131.isEmpty() == false) goto L118;
        q.g r159 = new q.g();
        r149 = r131;
        r107 = 1;
    L119:
        r159.f401901a = r143.f401901a;
        r159.f401903c = r143.f401903c;
        r159.f401902b = r147.f401905a;
        r159.f401904d = r147.f401906b;
        r148 = r128;
        r148.add(r159);
        r143.f401902b = r143.f401902b;
        r143.f401904d = r143.f401904d;
        r143.f401901a = r147.f401907c;
        r143.f401903c = r147.f401908d;
        r148.add(r143);
        goto L121
    L118:
        r107 = 1;
        r149 = r131;
        r159 = (q.g) ListProtector.remove(r149, r131.size() - 1);
    L90:
        r137 = r137 + 2;
        r113 = r143;
    L81:
        r143 = r113;
    L73:
        r141 = r140;
        goto L75
    L64:
        if (r111[(r137 + 1) + r110] >= r111[(r137 - 1) + r110]) goto L66;
    L67:
        r138 = r111[(r137 + 1) + r110];
        r139 = r138;
        goto L68
    L91:
        r143 = r113;
        r146 = null;
        goto L92
    L58:
        r136 = false;
        goto L59
    L54:
        r147 = r134;
        r143 = r113;
    L51:
        r124 = r124 + 2;
        r105 = r128;
        r118 = r125;
        r112 = r131;
        r121 = r133;
        goto L17
    L50:
        r133 = r121;
    L32:
        r130 = r129;
    L26:
        r126 = r109[(r124 + 1) + r110];
        r127 = r126;
        goto L27
    L23:
        r125 = r118;
        goto L24
    L25:
        r125 = r118;
        goto L26
    L52:
        r128 = r105;
        r131 = r112;
        r125 = r118;
        r134 = null;
        goto L53
    L15:
        r121 = false;
    L95:
        r128 = r105;
        r131 = r112;
        r143 = r113;
        r147 = null;
        goto L96
    L122:
        Collections.sort(r104, q.f401887a);
        this.f401795e.f401803c.execute(new b(this, new q.d(r100, r104, r109, r111)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r100, List r101, List r102, int r103, com.larus.dora.obric.device_management.device_home.e0 r104) {
        this.f401795e = r100;
        this.f401791a = r101;
        this.f401792b = r102;
        this.f401793c = r103;
        this.f401794d = r104;
    }
}
