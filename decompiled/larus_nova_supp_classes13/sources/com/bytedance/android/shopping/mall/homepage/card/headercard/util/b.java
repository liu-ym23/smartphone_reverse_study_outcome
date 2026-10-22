package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final String b(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "componentId");
        boolean r0 = false;
        if (r12 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        String r3 = "c9627.d153041";
        if (r2 == true) goto L31;
        List r4 = StringsKt.split$default(r12, new String[]{"."}, false, 0, 6, null);
        String r5 = (String) CollectionsKt.firstOrNull(r4);
        String r6 = (String) CollectionsKt.getOrNull(r4, 1);
        if (r5 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L25;
        if (r6 != null) goto L22;
    L23:
        r0 = true;
    L24:
        if (r0 == true) goto L25;
    L27:
        if ((!Intrinsics.areEqual(r5, "c9627")) == false) goto L29;
        r3 = "c9627." + r6;
        goto L31
    L29:
        r3 = r12;
        goto L31
    L22:
        if (r6.length() != 0) goto L24;
    L25:
        r12 = "c9627.d153041";
        goto L27
    L15:
        if (r5.length() == 0) goto L18;
        r7 = false;
    L31:
        return r3 + "_i" + r10 + "_w" + r11;
    L5:
        if (r12.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r22v3, types: [com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm] */
    public static BtmPositionResult a(BtmData r19, boolean r20, int r21, int r22, String r23, int r24) {
        boolean r2 = false;
        if ((r24 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = "0";
    L18:
        Intrinsics.checkNotNullParameter(r5, "componentID");
        Intrinsics.checkNotNullParameter(r5, "componentID");
        Object r9 = null;
        if (r19 != null) goto L164;
        List<String> r10 = null;
    L24:
        List<String> r11 = r10;     // Catch: Exception -> L21
        if (r11 != null) goto L27;
    L30:
        boolean r12 = true;
    L32:
        if (r12 == true) goto L67;
        List<String> r13 = r19.getBtmCodeList();     // Catch: Exception -> L21
        if (r13 == null) goto L36;
        String r14 = (String) CollectionsKt.getOrNull(r13, 0);     // Catch: Exception -> L21
    L37:
        if (r14 == null) goto L39;
        List r15 = StringsKt.split$default(r14, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L21
    L40:
        if (r15 == null) goto L42;
        String r16 = (String) CollectionsKt.firstOrNull(r15);     // Catch: Exception -> L21
    L43:
        if (r15 == null) goto L49;
        String r17 = (String) CollectionsKt.lastOrNull(r15);     // Catch: Exception -> L21
        if (r17 == null) goto L49;
        List r18 = StringsKt.split$default(r17, new String[]{"_"}, false, 0, 6, null);     // Catch: Exception -> L21
        if (r18 == null) goto L49;
        String r110 = (String) CollectionsKt.firstOrNull(r18);     // Catch: Exception -> L21
    L50:
        String r8 = "w" + r5;     // Catch: Exception -> L21
        if (r16 != null) goto L53;
    L56:
        boolean r111 = true;
    L57:
        if (r111 == true) goto L114;
        if (r110 != null) goto L60;
    L63:
        boolean r112 = true;
    L64:
        if (r112 == true) goto L114;
        BtmInfo r113 = new BtmInfo(r16, r110, r8, r19);     // Catch: Exception -> L21
    L115:
        if (r113 != null) goto L118;
        return null;
    L118:
        if (r1 == false) goto L124;
        String r0 = r113.getC() + '.' + r113.getD();
        BtmData r6 = r113.getBtmInfo();
        if (r6 == null) goto L122;
        r9 = r6.getBcm();
    L122:
        BtmPositionResult r7 = new BtmPositionResult(r0, null, r9, 2, null);
    L165:
        return r7;
    L124:
        String r25 = r113.getC();
        if (r25 != null) goto L127;
    L130:
        boolean r26 = true;
    L131:
        if (r26 == true) goto L166;
        String r27 = r113.getD();
        if (r27 != null) goto L135;
    L138:
        boolean r28 = true;
    L139:
        if (r28 == true) goto L167;
        String r29 = r113.getW();
        if (r29 != null) goto L143;
    L144:
        r2 = true;
    L145:
        if (r2 == false) goto L147;
        return null;
    L147:
        if (r113.getBtmInfo() != null) goto L149;
        return null;
    L149:
        if (Intrinsics.areEqual(r5, "0") == true) goto L171;
        if (r3 < 0) goto L163;
        StringBuilder r30 = new StringBuilder();
        r30.append(r113.getC());
        r30.append('.');
        r30.append(r113.getD());
        r30.append("_i");
        r30.append(r3);
        if (r4 < 0) goto L155;
        String r31 = "_i" + r4;
    L156:
        r30.append(r31);
        r30.append('_');
        r30.append(r113.getW());
        String r32 = r30.toString();
        BtmData r33 = r113.getBtmInfo();
        if (r33 == null) goto L161;
        Bcm r34 = r33.getBcm();
        if (r34 == null) goto L161;
        r9 = r34.getExtra();
    L161:
        r7 = new BtmPositionResult(r32, r9, null, 4, null);
        goto L165
    L155:
        r31 = "";
        goto L156
    L163:
        return new BtmPositionResult(r113.getC() + '.' + r113.getD(), null, null, 6, null);
    L171:
        return null;
    L143:
        if (r29.length() != 0) goto L145;
    L167:
        return null;
    L135:
        if (r27.length() == 0) goto L138;
        r28 = false;
        goto L139
    L166:
        return null;
    L127:
        if (r25.length() == 0) goto L130;
        r26 = false;
        goto L131
    L60:
        if (r110.length() == 0) goto L63;
        r112 = false;
    L114:
        r113 = null;
        goto L115
    L53:
        if (r16.length() == 0) goto L56;
        r111 = false;
    L49:
        r110 = null;
        goto L50
    L42:
        r16 = null;
        goto L43
    L39:
        r15 = null;
        goto L40
    L36:
        r14 = null;
        goto L37
    L67:
        if (r19 == null) goto L69;
        String r35 = r19.getBtm();     // Catch: Exception -> L21
    L70:
        if (r35 == null) goto L114;
        String r114 = r19.getBtm();     // Catch: Exception -> L21
        if (r114 == null) goto L74;
        List r36 = StringsKt.split$default(r114, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L21
    L75:
        if (r36 == null) goto L77;
        String r115 = (String) CollectionsKt.firstOrNull(r36);     // Catch: Exception -> L21
    L78:
        if (r36 == null) goto L82;
        String r116 = (String) CollectionsKt.lastOrNull(r36);     // Catch: Exception -> L21
        if (r116 == null) goto L82;
        List r37 = StringsKt.split$default(r116, new String[]{"_"}, false, 0, 6, null);     // Catch: Exception -> L21
    L83:
        if (r37 == null) goto L85;
        String r117 = (String) CollectionsKt.firstOrNull(r37);     // Catch: Exception -> L21
    L86:
        if (r37 == null) goto L88;
        String r38 = (String) CollectionsKt.lastOrNull(r37);     // Catch: Exception -> L21
    L89:
        if (r115 != null) goto L91;
    L94:
        boolean r118 = true;
    L95:
        if (r118 == true) goto L114;
        if (r117 != null) goto L98;
    L101:
        boolean r119 = true;
    L102:
        if (r119 == true) goto L114;
        if (r38 != null) goto L105;
    L108:
        boolean r120 = true;
    L109:
        if (r120 == true) goto L114;
        r113 = new BtmInfo(r115, r117, r38, r19);     // Catch: Exception -> L21
        goto L115
    L105:
        if (r38.length() == 0) goto L108;
        r120 = false;
        goto L109
    L98:
        if (r117.length() == 0) goto L101;
        r119 = false;
        goto L102
    L91:
        if (r115.length() == 0) goto L94;
        r118 = false;
        goto L95
    L88:
        r38 = null;
        goto L89
    L85:
        r117 = null;
    L82:
        r37 = null;
        goto L83
    L77:
        r115 = null;
        goto L78
    L74:
        r36 = null;
        goto L75
    L69:
        r35 = null;
        goto L70
    L27:
        if (r11.isEmpty() == true) goto L30;
        r12 = false;
        goto L32
    L164:
        r10 = r19.getBtmCodeList();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        b0.l("getBtm", e);
        goto L114
    L17:
        r5 = r23;
        goto L18
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
