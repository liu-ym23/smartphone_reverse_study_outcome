package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.android.window.shop.repository.tab.datasource.impl.a<mq3.a, com.bytedance.android.window.shop.repository.tab.datasource.b> {
    public int f;

    public static final class a {
    }

    static {
    }

    public h() {
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r0 = com.bytedance.android.window.shop.c.b;
        super(com.bytedance.android.window.shop.c.e, new com.bytedance.android.window.shop.repository.tab.datasource.b());
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.impl.a
    public final void b(WindowTabDataListResponseDTODeprecated r12, List<com.bytedance.android.window.shop.repository.tab.entity.f> r13, com.bytedance.android.window.shop.repository.tab.datasource.c r14) {
        Intrinsics.checkNotNullParameter(r12, "dto");
        Intrinsics.checkNotNullParameter(r13, "voList");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Iterator<com.bytedance.android.window.shop.repository.tab.entity.f> r0 = r13.iterator();
        int r2 = 0;
    L3:
        int r4 = -1;
        if (r0.hasNext() == false) goto L12;
        if (r0.next().i != 2506) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        Iterator<com.bytedance.android.window.shop.repository.tab.entity.f> r1 = r13.iterator();
        int r5 = 0;
    L15:
        if (r1.hasNext() == false) goto L23;
        if (r1.next().i != 303) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L25;
        r5 = r5 + 1;
    L25:
        if (r2 >= 0) goto L27;
    L34:
        if (r5 < 0) goto L41;
        Object r7 = ListProtector.get(r13, r5);
        if ((r7 instanceof sq3.b) == true) goto L38;
        r7 = null;
    L38:
        sq3.b r8 = (sq3.b) r7;
        if (r8 == null) goto L41;
        r8.k = true;
    L41:
        ListIterator<com.bytedance.android.window.shop.repository.tab.entity.f> r9 = r13.listIterator(r13.size());
    L43:
        if (r9.hasPrevious() == false) goto L50;
        com.bytedance.android.window.shop.repository.tab.entity.f r10 = r9.previous();
        if (r10.i != 303) goto L47;
        boolean r11 = true;
    L48:
        if (r11 == false) goto L43;
    L52:
        if ((r10 instanceof sq3.b) == true) goto L54;
        r10 = null;
    L54:
        sq3.b r15 = (sq3.b) r10;
        if (r15 == null) goto L57;
        r15.l = true;
    L57:
        Iterator<com.bytedance.android.window.shop.repository.tab.entity.f> r16 = r13.iterator();
        int r17 = 0;
    L59:
        if (r16.hasNext() == false) goto L64;
        if ((r16.next() instanceof sq3.i) == true) goto L62;
        r17 = r17 + 1;
        goto L59
    L62:
        r4 = r17;
    L64:
        if (r4 <= 0) goto L74;
        int r18 = r4 + 1;
        if (r13.size() <= r18) goto L74;
        if ((ListProtector.get(r13, r18) instanceof sq3.f) == false) goto L74;
        Object r19 = ListProtector.get(r13, r4);
        if (r19 == null) goto L73;
        sq3.i r20 = (sq3.i) r19;
        r20.j = 20;
        r20.k = 8;
        goto L74
    L73:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.hotsale.WindowLiveHotSaleTitleVO");
    L74:
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r21 = r13;
        Iterator r22 = r21.iterator();
        int r23 = 1;
    L76:
        if (r22.hasNext() == false) goto L89;
        com.bytedance.android.window.shop.repository.tab.entity.f r24 = (com.bytedance.android.window.shop.repository.tab.entity.f) r22.next();
        if ((r24 instanceof sq3.f) == false) goto L76;
        sq3.f r25 = (sq3.f) r24;
        sq3.h r26 = r25.j;
        if (r26 == null) goto L76;
        fo.b r27 = ((WindowV2ProductItemVO) r26).C;
        if (r27 == null) goto L76;
        int r28 = r23 + 1;
        r27.b(wn.a.A, Integer.valueOf(r23));
        fo.a r29 = wn.a.B;
        if (r25.j.U == null) goto L87;
        boolean r30 = true;
    L88:
        r27.b(r29, Boolean.valueOf(r30));
        r23 = r28;
        goto L76
    L87:
        r30 = false;
        goto L88
    L89:
        Iterator r31 = r21.iterator();
        int r32 = 1;
    L91:
        if (r31.hasNext() == false) goto L99;
        com.bytedance.android.window.shop.repository.tab.entity.f r33 = (com.bytedance.android.window.shop.repository.tab.entity.f) r31.next();
        if ((r33 instanceof sq3.b) == false) goto L91;
        sq3.b r34 = (sq3.b) r33;
        fo.b r35 = ((WindowV2ProductItemVO) r34.m).C;
        int r36 = r32 + 1;
        r35.b(wn.a.A, Integer.valueOf(r32));
        fo.a r37 = wn.a.B;
        if (r34.m.U == null) goto L97;
        boolean r38 = true;
    L98:
        r35.b(r37, Boolean.valueOf(r38));
        r32 = r36;
        goto L91
    L97:
        r38 = false;
        goto L98
    L99:
        boolean r39 = r21 instanceof Collection;
        if (r39 == true) goto L102;
    L104:
        Iterator r40 = r21.iterator();
    L106:
        if (r40.hasNext() == false) goto L110;
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r40.next()) instanceof sq3.a) == false) goto L106;
        boolean r41 = false;
    L111:
        if (r41 == true) goto L193;
        Iterator r42 = r21.iterator();
    L115:
        if (r42.hasNext() == false) goto L119;
        Object r43 = r42.next();
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r43) instanceof sq3.a) == false) goto L115;
    L121:
        if ((r43 instanceof sq3.a) == true) goto L123;
        r43 = null;
    L123:
        sq3.a r44 = (sq3.a) r43;
        if (r44 != null) goto L126;
    L128:
        if (r39 == true) goto L130;
    L132:
        Iterator r45 = r21.iterator();
    L134:
        if (r45.hasNext() == false) goto L153;
        com.bytedance.android.window.shop.repository.tab.entity.f r46 = (com.bytedance.android.window.shop.repository.tab.entity.f) r45.next();
        if ((r46 instanceof sq3.a) == false) goto L138;
    L141:
        boolean r47 = true;
    L142:
        if (r47 == false) goto L144;
    L150:
        boolean r48 = true;
    L151:
        if (r48 == true) goto L134;
        boolean r49 = false;
    L155:
        if (this.b.a == true) goto L158;
        if (r49 == true) goto L193;
    L158:
        ArrayList r50 = new ArrayList();
        Iterator r51 = r21.iterator();
        int r52 = 0;
    L160:
        if (r51.hasNext() == false) goto L172;
        Object r53 = r51.next();
        int r54 = r52 + 1;
        if (r52 >= 0) goto L165;
        CollectionsKt.throwIndexOverflow();
    L165:
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r53) instanceof sq3.a) == false) goto L167;
        Integer r55 = Integer.valueOf(r52);
    L168:
        if (r55 == null) goto L170;
        r50.add(r55);
    L170:
        r52 = r54;
        goto L160
    L167:
        r55 = null;
        goto L168
    L172:
        if (r50.size() <= 3) goto L193;
        ArrayList r56 = new ArrayList();
        Iterator r57 = r50.iterator();
        int r58 = 0;
    L176:
        if (r57.hasNext() == false) goto L191;
        Object r59 = r57.next();
        int r110 = r58 + 1;
        if (r58 >= 0) goto L180;
        CollectionsKt.throwIndexOverflow();
    L180:
        int r60 = ((Number) r59).intValue();
        if (r58 >= 3) goto L183;
        sq3.a r61 = null;
    L186:
        if (r61 == null) goto L188;
        r56.add(r61);
    L188:
        r58 = r110;
        goto L176
    L183:
        Object r62 = ListProtector.get(r13, r60);
        if (r62 == null) goto L190;
        r61 = (sq3.a) r62;
        goto L186
    L190:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.hotsale.ShopWindowLiveHotSaleExpandableProductVO");
    L191:
        r13.removeAll(r56);
        ListProtector.add(r13, ((Number) ListProtector.get(r50, 2)).intValue() + 1, new sq3.e(r56, r56.size() + 3));
        goto L193
    L144:
        if (r46.i != 301) goto L146;
        boolean r63 = true;
    L147:
        if (r63 == true) goto L150;
        r48 = false;
        goto L151
    L146:
        r63 = false;
        goto L147
    L138:
        if ((r46 instanceof sq3.d) == true) goto L141;
        r47 = false;
    L153:
        r49 = true;
        goto L155
    L130:
        if (r21.isEmpty() == false) goto L132;
    L126:
        if (r44.o == true) goto L128;
    L119:
        r43 = null;
    L193:
        if (((com.bytedance.android.window.shop.repository.tab.datasource.b) this.e).b().getPageNum() != 0) goto L195;
        this.f = 0;
    L195:
        ArrayList r64 = new ArrayList();
        Iterator r65 = r21.iterator();
    L197:
        if (r65.hasNext() == false) goto L201;
        Object r66 = r65.next();
        if ((r66 instanceof sq3.f) == false) goto L197;
        r64.add(r66);
        goto L197
    L201:
        Iterator r67 = r64.iterator();
    L203:
        if (r67.hasNext() == false) goto L212;
        sq3.f r68 = (sq3.f) r67.next();
        int r69 = this.f + 1;
        this.f = r69;
        sq3.h r70 = r68.j;
        if (r70 == null) goto L203;
        fo.b r71 = ((WindowV2ProductItemVO) r70).C;
        if (r71 == null) goto L203;
        fo.a r72 = wn.a.C;
        Integer r73 = r68.b;
        if (r73 == null) goto L211;
        r69 = r73.intValue();
    L211:
        Integer r74 = (Integer) r71.b(r72, Integer.valueOf(r69));
        goto L203
    L212:
        super.b(r12, r13, r14);
        return;
    L110:
        r41 = true;
        goto L111
    L102:
        if (r21.isEmpty() == false) goto L104;
    L47:
        r11 = false;
        goto L48
    L50:
        r10 = null;
        goto L52
    L27:
        if (r5 != (r2 + 1)) goto L34;
        Object r75 = ListProtector.get(r13, r5);
        if ((r75 instanceof sq3.b) == true) goto L31;
        r75 = null;
    L31:
        sq3.b r76 = (sq3.b) r75;
        if (r76 == null) goto L34;
        r76.j = true;
        goto L34
    L19:
        r6 = false;
        goto L20
    L23:
        r5 = -1;
        goto L25
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }
}
