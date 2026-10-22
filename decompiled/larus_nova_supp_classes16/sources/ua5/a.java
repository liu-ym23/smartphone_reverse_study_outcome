package ua5;

import android.text.TextUtils;
import rbb.b;
import rbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends b {
    public static int h(String r6) {
        if (r6 == null) goto L4;
        r6 = r6.toLowerCase();
    L4:
        String[] r0 = e.a;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L10;
        if (TextUtils.equals(r0[r3], r6) == true) goto L139;
        r3 = r3 + 1;
        goto L5
    L139:
        return kac.a.b(2131254643);
    L10:
        String[] r4 = e.b;
        int r5 = r4.length;
        int r7 = 0;
    L11:
        if (r7 >= r5) goto L16;
        if (TextUtils.equals(r4[r7], r6) == true) goto L140;
        r7 = r7 + 1;
        goto L11
    L140:
        return kac.a.b(2131254687);
    L16:
        String[] r8 = e.c;
        int r9 = r8.length;
        int r10 = 0;
    L17:
        if (r10 >= r9) goto L23;
        if (TextUtils.equals(r8[r10], r6) == true) goto L141;
        r10 = r10 + 1;
        goto L17
    L141:
        return kac.a.b(2131254619);
    L23:
        if (TextUtils.equals("pdf", r6) == true) goto L142;
        String[] r11 = e.d;
        int r12 = r11.length;
        int r13 = 0;
    L26:
        if (r13 >= r12) goto L31;
        if (TextUtils.equals(r11[r13], r6) == true) goto L143;
        r13 = r13 + 1;
        goto L26
    L143:
        return kac.a.b(2131254680);
    L31:
        String[] r14 = e.e;
        int r16 = r14.length;
        int r17 = 0;
    L33:
        if (r17 >= r16) goto L38;
        if (TextUtils.equals(r14[r17], r6) == true) goto L144;
        r17 = r17 + 1;
        goto L33
    L144:
        return kac.a.b(2131254626);
    L38:
        String[] r18 = e.f;
        int r19 = r18.length;
        int r20 = 0;
    L39:
        if (r20 >= r19) goto L44;
        if (TextUtils.equals(r18[r20], r6) == true) goto L145;
        r20 = r20 + 1;
        goto L39
    L145:
        return kac.a.b(2131254689);
    L44:
        String[] r21 = e.g;
        int r22 = r21.length;
        int r23 = 0;
    L45:
        if (r23 >= r22) goto L50;
        if (TextUtils.equals(r21[r23], r6) == true) goto L146;
        r23 = r23 + 1;
        goto L45
    L146:
        return kac.a.b(2131254635);
    L50:
        String[] r24 = e.h;
        int r26 = r24.length;
        int r27 = 0;
    L51:
        if (r27 >= r26) goto L57;
        if (TextUtils.equals(r24[r27], r6) == true) goto L147;
        r27 = r27 + 1;
        goto L51
    L147:
        return kac.a.b(2131254667);
    L57:
        if (TextUtils.equals("pages", r6) == false) goto L60;
        return kac.a.b(2131254663);
    L60:
        if (TextUtils.equals("numbers", r6) == true) goto L149;
        String[] r28 = e.i;
        int r29 = r28.length;
        int r30 = 0;
    L63:
        if (r30 >= r29) goto L68;
        if (TextUtils.equals(r28[r30], r6) == true) goto L150;
        r30 = r30 + 1;
        goto L63
    L150:
        return kac.a.b(2131254647);
    L68:
        String[] r31 = e.j;
        int r32 = r31.length;
        int r33 = 0;
    L69:
        if (r33 >= r32) goto L74;
        if (TextUtils.equals(r31[r33], r6) == true) goto L151;
        r33 = r33 + 1;
        goto L69
    L151:
        return kac.a.b(2131254691);
    L74:
        String[] r34 = e.k;
        int r36 = r34.length;
        int r37 = 0;
    L75:
        if (r37 >= r36) goto L83;
        if (TextUtils.equals(r34[r37], r6) == true) goto L79;
        r37 = r37 + 1;
        goto L75
    L79:
        if (kac.a.a() == false) goto L81;
        return 2131254654;
    L81:
        return 2131254626;
    L83:
        String[] r38 = e.l;
        int r39 = r38.length;
    L84:
        if (r2 >= r39) goto L90;
        if (TextUtils.equals(r38[r2], r6) == true) goto L154;
        r2 = r2 + 1;
        goto L84
    L154:
        return kac.a.b(2131254669);
    L90:
        if (TextUtils.equals("ipa", r6) == false) goto L93;
        return kac.a.b(2131254645);
    L93:
        if (TextUtils.equals("apk", r6) == false) goto L96;
        return kac.a.b(2131254617);
    L96:
        if (TextUtils.equals("aep", r6) == false) goto L99;
        return kac.a.b(2131254613);
    L99:
        if (TextUtils.equals("ai", r6) == false) goto L102;
        return kac.a.b(2131254615);
    L102:
        if (TextUtils.equals("sketch", r6) == false) goto L105;
        return kac.a.b(2131254676);
    L105:
        if (TextUtils.equals("csv", r6) == false) goto L108;
        return kac.a.b(2131254628);
    L108:
        if (TextUtils.equals("eml", r6) == false) goto L111;
        return kac.a.b(2131254633);
    L111:
        if (TextUtils.equals("msg", r6) == false) goto L114;
        return kac.a.b(2131254657);
    L114:
        return kac.a.b(2131256242);
    L149:
        return kac.a.b(2131254661);
    L142:
        return kac.a.b(2131254665);
    }

    public static int i(int r1) {
        if (r1 != sbb.e.g.b) goto L6;
        return kac.a.b(2131254630);
    L6:
        if (r1 != sbb.e.h.b) goto L9;
        return kac.a.b(2131254674);
    L9:
        if (r1 != sbb.e.i.b) goto L12;
        return kac.a.b(2131254622);
    L12:
        if (r1 != sbb.e.k.b) goto L15;
        return kac.a.b(2131254655);
    L15:
        if (r1 != sbb.e.m.b) goto L18;
        return kac.a.b(2131256260);
    L18:
        if (r1 != sbb.e.o.b) goto L21;
        return kac.a.b(2131254632);
    L21:
        if (r1 != sbb.e.f.b) goto L24;
        return kac.a.b(2131254455);
    L24:
        if (r1 != sbb.e.y.b) goto L27;
        return kac.a.b(2131255874);
    L27:
        if (r1 == sbb.e.t.b) goto L33;
        if (r1 == sbb.e.u.b) goto L33;
        return kac.a.b(2131254682);
    L33:
        return kac.a.b(2131254557);
    }

    public static int j(int r1, String r2) {
        String r3 = va5.a.a(r2);
        if (r1 != sbb.e.l.b) goto L7;
        return h(com.bytedance.ee.util.io.a.c(r3));
    L7:
        return i(r1);
    }

    public static int k(int r1, String r2) {
        if (r1 != sbb.e.l.b) goto L7;
        return h(com.bytedance.ee.util.io.a.c(r2));
    L7:
        return i(r1);
    }

    public static int l(int r1, String r2) {
        String r3 = va5.a.a(r2);
        if (r1 != sbb.e.l.b) goto L7;
        return b.e(com.bytedance.ee.util.io.a.c(r3));
    L7:
        return b.c(r1, null);
    }
}
