package n4a;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes32.dex */
public final class o1 extends n1 {
    public o1() {
        super(2048);
    }

    public final int b(r1.a r210) {
        List<dv> r100 = r210.f517646f;
        if (r100 == null) goto L30;
        ArrayList r101 = (ArrayList) r100;
        if (r101.size() == 0) goto L30;
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L30;
        dv r103 = (dv) r102.next();
        if ((r103 instanceof dx) == true) goto L12;
        if ((r103 instanceof dy) == true) goto L15;
        if ((r103 instanceof dz) == true) goto L18;
        if ((r103 instanceof dw) == false) goto L9;
        dw r104 = (dw) r103;
        int r105 = r104.f380018k;
        int r106 = r104.f380019l;
    L22:
        long r107 = (BodyPartID.bodyIdMax & ((long) r106)) | ((((long) r105) & BodyPartID.bodyIdMax) << 32);
        monitor-enter(p2.class);
        short r108 = o2.b(o2.a().f517567a, r107);     // Catch: Throwable -> L27
        monitor-exit(p2.class);
        r103.f380014g = r108;
    L27:
        th = move-exception;
        throw th;
    L18:
        dz r109 = (dz) r103;
        r105 = r109.f380033j;
        r106 = r109.f380034k;
        goto L22
    L15:
        dy r110 = (dy) r103;
        r105 = r110.f380028j;
        r106 = r110.f380029k;
        goto L22
    L12:
        dx r111 = (dx) r103;
        r105 = r111.f380022j;
        r106 = r111.f380023k;
    L30:
        int r112 = ((ArrayList) r210.f517646f).size();
        int[] r113 = new int[r112];
        int r114 = 0;
    L32:
        if (r114 >= r112) goto L59;
        dv r115 = (dv) ListProtector.get(r210.f517646f, r114);
        if ((r115 instanceof dx) == false) goto L40;
        dx r116 = (dx) r115;
        if (r116.f380016i == true) goto L38;
        p1 r117 = this.f517554a;
        int r118 = r116.f380022j;
        int r119 = r116.f380023k;
        int r120 = r116.f380010c;
        int r121 = r116.f380024l;
        int r122 = g2.f517295a;
        r117.l(9);
        r117.f(4, r120);
        r117.f(3, r119);
        r117.f(2, r118);
        r117.f(8, r121);
        int r123 = r117.k();
    L39:
        byte r124 = 1;
    L55:
        if (r123 == (-1)) goto L57;
        byte r125 = r115.f380015h ? 1 : 0;
        byte r126 = r115.f380016i ? 1 : 0;
        p1 r127 = this.f517554a;
        short r128 = (short) r115.f380014g;
        int r129 = d2.f517222a;
        r127.l(5);
        r127.m(4, r123);
        r127.i(2, r128);
        r127.e(3, r124);
        r127.e(1, r126);
        r127.e(0, r125);
        r113[r114] = r127.k();
        r114 = r114 + 1;
        r112 = r112;
        goto L32
    L57:
        return -1;
    L38:
        p1 r130 = this.f517554a;
        int r131 = r116.b();
        int r132 = r116.c();
        int r133 = r116.f380022j;
        int r134 = r116.f380023k;
        int r135 = r116.f380010c;
        int r136 = r116.f380025m;
        int r137 = r116.f380026n;
        int r138 = r116.f380011d;
        int r139 = r116.f380024l;
        int r140 = g2.f517295a;
        r130.l(9);
        r130.f(8, r139);
        r130.f(7, r138);
        r130.f(6, r137);
        r130.f(5, r136);
        r130.f(4, r135);
        r130.f(3, r134);
        r130.f(2, r133);
        r130.f(1, r132);
        r130.f(0, r131);
        r123 = r130.k();
        goto L39
    L40:
        r112 = r112;
        if ((r115 instanceof dy) == false) goto L44;
        dy r141 = (dy) r115;
        p1 r142 = this.f517554a;
        int r143 = r141.b();
        int r144 = r141.c();
        int r145 = r141.f380028j;
        int r146 = r141.f380029k;
        int r147 = r141.f380030l;
        int r148 = r141.f380010c;
        int r149 = r141.f380031m;
        int r150 = r141.f380011d;
        int r151 = h2.f517340a;
        r142.l(8);
        r142.f(7, r150);
        r142.f(6, r149);
        r142.f(5, r148);
        r142.f(4, r147);
        r142.f(3, r146);
        r142.f(2, r145);
        r142.f(1, r144);
        r142.f(0, r143);
        r123 = r142.k();
        r124 = 3;
        goto L55
    L44:
        if ((r115 instanceof dw) == false) goto L51;
        dw r152 = (dw) r115;
        if (r152.f380016i == true) goto L48;
        p1 r153 = this.f517554a;
        int r154 = r152.f380017j;
        int r155 = r152.f380018k;
        int r156 = r152.f380019l;
        int r157 = r152.f380020m;
        int r158 = r152.f380021n;
        int r159 = r152.f380010c;
        int r160 = a2.f517132a;
        r153.l(7);
        r153.f(5, r159);
        r153.f(4, r158);
        r153.f(3, r157);
        r153.f(2, r156);
        r153.f(1, r155);
        r153.f(0, r154);
        r123 = r153.k();
    L49:
        r124 = 2;
        goto L55
    L48:
        p1 r161 = this.f517554a;
        int r162 = r152.f380017j;
        int r163 = r152.f380018k;
        int r164 = r152.f380019l;
        int r165 = r152.f380020m;
        int r166 = r152.f380021n;
        int r167 = r152.f380010c;
        int r168 = r152.f380011d;
        int r169 = a2.f517132a;
        r161.l(7);
        r161.f(6, r168);
        r161.f(5, r167);
        r161.f(4, r166);
        r161.f(3, r165);
        r161.f(2, r164);
        r161.f(1, r163);
        r161.f(0, r162);
        r123 = r161.k();
        goto L49
    L51:
        if ((r115 instanceof dz) == false) goto L53;
        dz r170 = (dz) r115;
        p1 r171 = this.f517554a;
        int r172 = r170.b();
        int r173 = r170.c();
        int r174 = r170.f380033j;
        int r175 = r170.f380034k;
        int r176 = r170.f380035l;
        int r177 = r170.f380010c;
        int r178 = r170.f380036m;
        int r179 = r170.f380011d;
        int r180 = k2.f517431a;
        r171.l(8);
        r171.f(7, r179);
        r171.f(6, r178);
        r171.f(5, r177);
        r171.f(4, r176);
        r171.f(3, r175);
        r171.f(2, r174);
        r171.f(1, r173);
        r171.f(0, r172);
        r123 = r171.k();
        r124 = 4;
        goto L55
    L53:
        r123 = -1;
        r124 = 0;
        goto L55
    L59:
        int r181 = r112;
        int r182 = this.f517554a.b(r210.f517642b);
        p1 r183 = this.f517554a;
        int r184 = b2.f517165a;
        r183.g(4, r181, 4);
        int r185 = r181 - 1;
    L60:
        if (r185 < 0) goto L62;
        r183.d(r113[r185]);
        r185 = r185 - 1;
        goto L60
    L62:
        int r186 = r183.a();
        int r187 = ((ArrayList) r210.f517647g).size();
        int[] r188 = new int[r187];
        int r189 = 0;
    L63:
        if (r189 >= r187) goto L84;
        dv r190 = (dv) ListProtector.get(r210.f517647g, r189);
        long r191 = (SystemClock.elapsedRealtime() - r190.f380012e) / 1000;
        if (r191 <= 32767) goto L67;
    L68:
        r191 = 32767;
    L70:
        if ((r190 instanceof dx) == false) goto L73;
        dx r192 = (dx) r190;
        p1 r193 = this.f517554a;
        int r194 = r192.f380022j;
        int r195 = r192.f380023k;
    L75:
        int r196 = j2.a(r193, r194, r195, (short) r191);
        int r197 = 1;
    L83:
        p1 r198 = this.f517554a;
        int r199 = c2.f517204a;
        r198.l(2);
        r198.m(1, r196);
        r198.e(0, (byte) r197);
        r188[r189] = r198.k();
        r189 = r189 + 1;
        goto L63
    L73:
        if ((r190 instanceof dy) == false) goto L77;
        dy r200 = (dy) r190;
        r193 = this.f517554a;
        r194 = r200.f380028j;
        r195 = r200.f380029k;
        goto L75
    L77:
        if ((r190 instanceof dw) == false) goto L80;
        dw r201 = (dw) r190;
        p1 r1100 = this.f517554a;
        int r1101 = r201.f380017j;
        int r1102 = r201.f380018k;
        int r202 = r201.f380019l;
        int r203 = i2.f517378a;
        r1100.l(5);
        r1100.f(3, r202);
        r1100.f(2, r1102);
        r1100.f(1, r1101);
        r1100.i(4, (short) r191);
        r1100.e(0, (byte) 2);
        r196 = r1100.k();
        r197 = 2;
        goto L83
    L80:
        if ((r190 instanceof dz) == false) goto L82;
        dz r204 = (dz) r190;
        r196 = j2.a(this.f517554a, r204.f380033j, r204.f380034k, (short) r191);
        r197 = 1;
        goto L83
    L82:
        r197 = 0;
        r196 = 0;
        goto L83
    L67:
        if (r191 >= 0) goto L70;
    L84:
        p1 r205 = this.f517554a;
        r205.g(4, r187, 4);
        int r206 = r187 - 1;
    L85:
        if (r206 < 0) goto L87;
        r205.d(r188[r206]);
        r206 = r206 - 1;
        goto L85
    L87:
        int r207 = r205.a();
        p1 r208 = this.f517554a;
        byte r209 = r210.f517641a;
        r208.l(4);
        r208.m(3, r207);
        r208.m(2, r186);
        r208.m(0, r182);
        r208.e(1, r209);
        return r208.k();
    }

    public final int c(u2 r110) {
        long r100 = r110.f517771h;
        long r101 = r110.f517747a;
        int r102 = (int) (r110.f517749c * 1000000.0d);
        int r103 = (int) (r110.f517748b * 1000000.0d);
        int r104 = (int) r110.f517750d;
        int r105 = (int) r110.f517753g;
        int r106 = (int) r110.f517751e;
        short r107 = (short) r110.f517752f;
        byte r111 = r110.f517772i;
        p1 r112 = this.f517554a;
        int r113 = f2.f517277a;
        r112.l(10);
        r112.h(1, r100);
        r112.h(0, r101);
        r112.f(6, r106);
        r112.f(5, r105);
        r112.f(4, r104);
        r112.f(3, r103);
        r112.f(2, r102);
        r112.i(7, r107);
        r112.e(8, r111);
        return r112.k();
    }

    public final int a(long r110, List<v2> r210) {
        Iterator<v2> r100 = r210.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        v2 r101 = r100.next();
        long r102 = r101.f517819a;
        monitor-enter(p2.class);
        short r103 = o2.b(o2.a().f517569c, r102);     // Catch: Throwable -> L10
        monitor-exit(p2.class);
        r101.f517825g = r103;
    L10:
        th = move-exception;
        throw th;
    L13:
        int r104 = r210.size();
        if (r104 <= 0) goto L33;
        int[] r105 = new int[r104];
        int r106 = 0;
    L17:
        if (r106 >= r104) goto L28;
        v2 r107 = (v2) ListProtector.get(r210, r106);
        int r111 = this.f517554a.b(r107.f517820b);
        long r112 = r107.f517819a;
        if (r112 == r110) goto L21;
    L23:
        int r113 = 0;
    L24:
        p1 r114 = this.f517554a;
        short r115 = (short) r107.f517821c;
        short r108 = r107.f517825g;
        short r109 = (short) r107.f517822d;
        int r116 = m2.f517520a;
        r114.l(6);
        r114.h(1, r112);
        r114.m(3, r111);
        r114.i(5, r109);
        r114.i(4, r108);
        r114.i(2, r115);
        if (r113 == 0) goto L27;
        r114.p(1, 0);
        ByteBuffer r117 = r114.f517529a;
        int r118 = r114.f517530b - 1;
        r114.f517530b = r118;
        r117.put(r118, (byte) r113);
        r114.s(0);
    L27:
        r105[r106] = r114.k();
        r106 = r106 + 1;
        goto L17
    L21:
        if (r112 == (-1)) goto L23;
        r113 = 1;
        goto L24
    L28:
        p1 r119 = this.f517554a;
        int r120 = l2.f517459a;
        r119.g(4, r104, 4);
        int r121 = r104 - 1;
    L29:
        if (r121 < 0) goto L31;
        r119.d(r105[r121]);
        r121 = r121 - 1;
        goto L29
    L31:
        int r122 = r119.a();
        p1 r123 = this.f517554a;
        r123.l(1);
        r123.m(0, r122);
        return r123.k();
    L33:
        return -1;
    }
}
