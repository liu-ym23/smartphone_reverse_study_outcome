package com.bytedance.android.shopping.orderlist.list.viewmodel;

import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.list.slice.elements.tab.g;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.init.b;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public boolean a;
    public String b;
    public Boolean c;
    public Boolean d;
    public String e;
    public boolean f;
    public OrderListParams g;
    public g h;
    public boolean i;
    public String j;
    public Integer k;
    public Integer l;
    public Integer m;
    public List<Integer> n;
    public j0 o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public e u;
    public boolean v;
    public final Map<String, j> w;
    public String x;
    public String y;
    public final String z;

    public a() {
        this(null, null, null, null, null, null, 67108863);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L58;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L40;
        return false;
    L40:
        if (this.r == r4.r) goto L42;
        return false;
    L42:
        if (this.s == r4.s) goto L44;
        return false;
    L44:
        if (this.t == r4.t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (this.v == r4.v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r4.w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.z, r4.z) == true) goto L88;
        return false;
    L88:
        return true;
    L58:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v47, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v51, types: [int] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v80 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        String r4 = this.b;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        Boolean r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.d;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.f;
        ?? r18 = r17;
        if (r17 == false) goto L24;
        r18 = 1;
    L24:
        int r19 = (r16 + r18) * 31;
        OrderListParams r20 = this.g;
        if (r20 == null) goto L27;
        int r21 = r20.hashCode();
    L28:
        int r22 = (r19 + r21) * 31;
        g r23 = this.h;
        if (r23 == null) goto L31;
        int r24 = r23.hashCode();
    L32:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.i;
        ?? r27 = r26;
        if (r26 == false) goto L35;
        r27 = 1;
    L35:
        int r28 = (r25 + r27) * 31;
        String r29 = this.j;
        if (r29 == null) goto L38;
        int r30 = r29.hashCode();
    L39:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.k;
        if (r32 == null) goto L42;
        int r33 = r32.hashCode();
    L43:
        int r34 = (r31 + r33) * 31;
        Integer r35 = this.l;
        if (r35 == null) goto L46;
        int r36 = r35.hashCode();
    L47:
        int r37 = (r34 + r36) * 31;
        Integer r38 = this.m;
        if (r38 == null) goto L50;
        int r39 = r38.hashCode();
    L51:
        int r40 = (r37 + r39) * 31;
        List<Integer> r41 = this.n;
        if (r41 == null) goto L54;
        int r42 = r41.hashCode();
    L55:
        int r43 = (r40 + r42) * 31;
        j0 r44 = this.o;
        if (r44 == null) goto L58;
        int r45 = r44.hashCode();
    L59:
        int r46 = (r43 + r45) * 31;
        String r47 = this.p;
        if (r47 == null) goto L62;
        int r48 = r47.hashCode();
    L63:
        int r49 = (r46 + r48) * 31;
        String r50 = this.q;
        if (r50 == null) goto L66;
        int r51 = r50.hashCode();
    L67:
        int r52 = (r49 + r51) * 31;
        boolean r53 = this.r;
        ?? r54 = r53;
        if (r53 == false) goto L70;
        r54 = 1;
    L70:
        int r55 = (r52 + r54) * 31;
        boolean r56 = this.s;
        ?? r57 = r56;
        if (r56 == false) goto L73;
        r57 = 1;
    L73:
        int r58 = (r55 + r57) * 31;
        boolean r59 = this.t;
        ?? r60 = r59;
        if (r59 == false) goto L76;
        r60 = 1;
    L76:
        int r61 = (r58 + r60) * 31;
        e r62 = this.u;
        if (r62 == null) goto L79;
        int r63 = r62.hashCode();
    L80:
        int r64 = (r61 + r63) * 31;
        boolean r65 = this.v;
        if (r65 == true) goto L84;
        r1 = r65;
    L84:
        int r66 = (r64 + r1) * 31;
        Map<String, j> r67 = this.w;
        if (r67 == null) goto L87;
        int r68 = r67.hashCode();
    L88:
        int r69 = (r66 + r68) * 31;
        String r70 = this.x;
        if (r70 == null) goto L91;
        int r71 = r70.hashCode();
    L92:
        int r72 = (r69 + r71) * 31;
        String r73 = this.y;
        if (r73 == null) goto L95;
        int r74 = r73.hashCode();
    L96:
        int r75 = (r72 + r74) * 31;
        String r76 = this.z;
        if (r76 == null) goto L100;
        r5 = r76.hashCode();
    L100:
        return r75 + r5;
    L95:
        r74 = 0;
        goto L96
    L91:
        r71 = 0;
        goto L92
    L87:
        r68 = 0;
        goto L88
    L79:
        r63 = 0;
        goto L80
    L66:
        r51 = 0;
        goto L67
    L62:
        r48 = 0;
        goto L63
    L58:
        r45 = 0;
        goto L59
    L54:
        r42 = 0;
        goto L55
    L50:
        r39 = 0;
        goto L51
    L46:
        r36 = 0;
        goto L47
    L42:
        r33 = 0;
        goto L43
    L38:
        r30 = 0;
        goto L39
    L31:
        r24 = 0;
        goto L32
    L27:
        r21 = 0;
        goto L28
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "OrderListStaticState(isActivityReload=" + this.a + ", sessionId=" + this.b + ", isInApplet=" + this.c + ", isInFirstAppletPage=" + this.d + ", logId=" + this.e + ", isHasNewerCoupon=" + this.f + ", orderListParams=" + this.g + ", selectedTabInfo=" + this.h + ", hasCurrentTabParams=" + this.i + ", tabMode=" + this.j + ", currentBizTabId=" + this.k + ", currentTabId=" + this.l + ", currentSubTabId=" + this.m + ", tabIdList=" + this.n + ", queryCacheInfo=" + this.o + ", btm=" + this.p + ", appTheme=" + this.q + ", hasSkinInfo=" + this.r + ", isChunkRequest=" + this.s + ", isChunkOngoing=" + this.t + ", secondChunkResponse=" + this.u + ", hasSecondChunkLoaded=" + this.v + ", selfRegisterJsSubscriber=" + this.w + ", sliceVersion=" + this.x + ", geckoVersion=" + this.y + ", yataVersion=" + this.z + ")";
    }

    public final Map<String, Object> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        Object r1 = this.k;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("biz_tab_id", r1);
        Integer r3 = this.l;
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
    L9:
        r0.put("tab_id", Integer.valueOf(r4));
        Object r5 = this.m;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r0.put("sub_tab_id", r5);
        String r6 = this.j;
        if (r6 == null) goto L16;
        r2 = r6;
    L16:
        r0.put("tab_mode", r2);
        return r0;
    L8:
        r4 = 0;
        goto L9
    }

    public a(String r5, OrderListParams r6, String r7, Integer r8, Integer r9, String r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 64) == 0) goto L9;
        r6 = null;
    L9:
        if ((r11 & 512) == 0) goto L12;
        r7 = null;
    L12:
        if ((r11 & 1024) == 0) goto L15;
        r8 = null;
    L15:
        if ((r11 & 2048) == 0) goto L18;
        r9 = null;
    L18:
        if ((r11 & 8192) == 0) goto L20;
        List<Integer> r0 = CollectionsKt.emptyList();
    L22:
        if ((32768 & r11) == 0) goto L25;
        r10 = null;
    L25:
        if ((4194304 & r11) == 0) goto L27;
        LinkedHashMap r2 = new LinkedHashMap();
    L29:
        if ((r11 & 33554432) == 0) goto L31;
        PackYataSdkConfig r12 = b.a;
        String r13 = "1.23.7";
    L32:
        Intrinsics.checkNotNullParameter(r0, "tabIdList");
        Intrinsics.checkNotNullParameter(r2, "selfRegisterJsSubscriber");
        this.a = false;
        this.b = r5;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = r6;
        this.h = null;
        this.i = false;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.m = null;
        this.n = r0;
        this.o = null;
        this.p = r10;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = null;
        this.v = false;
        this.w = r2;
        this.x = null;
        this.y = null;
        this.z = r13;
        return;
    L31:
        r13 = null;
        goto L32
    L27:
        r2 = null;
        goto L29
    L20:
        r0 = null;
        goto L22
    }
}
