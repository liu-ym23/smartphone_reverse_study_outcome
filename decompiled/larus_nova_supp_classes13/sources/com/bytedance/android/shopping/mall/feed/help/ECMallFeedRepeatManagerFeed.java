package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECItemCardTag;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedRepeatManagerFeed implements g, e93.e {
    public static final Lazy h = null;
    public final ECMallFeed.f a;
    public final CoroutineScope b;
    public final ECHybridRecyclerView c;
    public final ECHybridListEngine d;
    public final Lazy e;
    public final Lazy f;
    public final a.C0082a g;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.ECMallFeedRepeatManagerFeed$a$a, reason: collision with other inner class name */
        public static final class C0082a {
            public final ECMallFeed.f a;
            public final String b;
            public final CoroutineScope c;
            public final ECHybridRecyclerView d;
            public final ECHybridListEngine e;
            public final String f;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0082a) == false) goto L18;
                C0082a r4 = (C0082a) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
                if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public final int hashCode() {
                ECMallFeed.f r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.b;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                CoroutineScope r7 = this.c;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                ECHybridRecyclerView r10 = this.d;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                ECHybridListEngine r13 = this.e;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.f;
                if (r16 == null) goto L26;
                r1 = r16.hashCode();
            L26:
                return r15 + r1;
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Config(containerAbility=" + this.a + ", hostPageName=" + this.b + ", coroutineScope=" + this.c + ", recyclerView=" + this.d + ", listEngine=" + this.e + ", pageName=" + this.f + ")";
            }

            public C0082a(ECMallFeed.f r2, String r3, CoroutineScope r4, ECHybridRecyclerView r5, ECHybridListEngine r6, String r7) {
                Intrinsics.checkNotNullParameter(r2, "containerAbility");
                Intrinsics.checkNotNullParameter(r3, "hostPageName");
                Intrinsics.checkNotNullParameter(r4, "coroutineScope");
                Intrinsics.checkNotNullParameter(r5, "recyclerView");
                Intrinsics.checkNotNullParameter(r6, "listEngine");
                Intrinsics.checkNotNullParameter(r7, "pageName");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }
        }
    }

    public final n a() {
        return (n) this.e.getValue();
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void k(boolean r1) {
    }

    @Override // e93.e
    public final void onBackMall() {
    }

    @Override // e93.e
    public final void onDestroy() {
    }

    @Override // e93.e
    public final void onEnterBackGround(boolean r1) {
    }

    @Override // e93.e
    public final void onGylRefreshStart() {
    }

    @Override // e93.e
    public final void onLeaveMall() {
    }

    @Override // e93.e
    public final void onStartLoadFeed() {
    }

    static {
        h = LazyKt.lazy(ECMallFeedRepeatManagerFeed$Companion$gulExposureTime$2.INSTANCE);
    }

    public final void b() {
        if (a() != null) goto L5;
        return;
    L5:
        Integer r1 = this.d.j();
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        List r3 = this.d.c.j();
        if (r3 == null) goto L221;
        n r10 = a();
        if (r10 == null) goto L242;
        Intrinsics.checkNotNullParameter(r3, "checkList");
        if (r10.u == true) goto L243;
        int r4 = RangesKt.coerceAtMost(r2 + 1, ((ArrayList) r3).size());
        int r12 = RangesKt.coerceAtMost(r10.a, r10.b);
        int r5 = r10.a;
        if (r5 >= r4) goto L166;
        int r14 = r5;
    L19:
        if (r14 >= r4) goto L165;
        if (r14 < 4) goto L91;
        int r6 = r14 - 4;
        ECHybridListItemVO r7 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r6);
        if (r7 == null) goto L91;
        if (n.c(r7) != true) goto L91;
        ECHybridListItemVO r8 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r6);
        if (r8 == null) goto L91;
        if (r6 <= r10.p) goto L91;
        r10.p = r6;
        ECNAMallCardExtra r9 = r8.c();
        if (r9 == null) goto L36;
        ECItemCardTag r11 = r9.getCardTag();
        if (r11 == null) goto L36;
        String[] r13 = r11.getPid();
    L37:
        if (r13 == null) goto L41;
        int r15 = r13.length;
        int r16 = 0;
    L39:
        if (r16 >= r15) goto L41;
        n.d(r10.d, r13[r16]);
        r16 = r16 + 1;
    L41:
        ECNAMallCardExtra r17 = r8.c();
        if (r17 == null) goto L46;
        ECItemCardTag r18 = r17.getCardTag();
        if (r18 == null) goto L46;
        String[] r19 = r18.getVcTagClusterId();
    L47:
        if (r19 == null) goto L51;
        int r20 = r19.length;
        int r21 = 0;
    L49:
        if (r21 >= r20) goto L51;
        n.d(r10.e, r19[r21]);
        r21 = r21 + 1;
    L51:
        ECNAMallCardExtra r22 = r8.c();
        if (r22 == null) goto L56;
        ECItemCardTag r23 = r22.getCardTag();
        if (r23 == null) goto L56;
        String[] r24 = r23.getPredictCategory();
    L57:
        if (r24 == null) goto L61;
        int r25 = r24.length;
        int r26 = 0;
    L59:
        if (r26 >= r25) goto L61;
        n.d(r10.f, r24[r26]);
        r26 = r26 + 1;
    L61:
        ECNAMallCardExtra r27 = r8.c();
        if (r27 == null) goto L66;
        ECItemCardTag r28 = r27.getCardTag();
        if (r28 == null) goto L66;
        String[] r29 = r28.getLeafCategory();
    L67:
        if (r29 == null) goto L71;
        int r30 = r29.length;
        int r31 = 0;
    L69:
        if (r31 >= r30) goto L71;
        n.d(r10.g, r29[r31]);
        r31 = r31 + 1;
    L71:
        ECNAMallCardExtra r32 = r8.c();
        if (r32 == null) goto L76;
        ECItemCardTag r33 = r32.getCardTag();
        if (r33 == null) goto L76;
        String[] r34 = r33.getSpuSimId();
    L77:
        if (r34 == null) goto L81;
        int r35 = r34.length;
        int r36 = 0;
    L79:
        if (r36 >= r35) goto L81;
        n.d(r10.h, r34[r36]);
        r36 = r36 + 1;
    L81:
        ECNAMallCardExtra r37 = r8.c();
        if (r37 == null) goto L86;
        ECItemCardTag r38 = r37.getCardTag();
        if (r38 == null) goto L86;
        String[] r39 = r38.getPicSimId();
    L87:
        if (r39 == null) goto L91;
        int r40 = r39.length;
        int r41 = 0;
    L89:
        if (r41 >= r40) goto L91;
        n.d(r10.i, r39[r41]);
        r41 = r41 + 1;
    L86:
        r39 = null;
    L76:
        r34 = null;
    L66:
        r29 = null;
    L56:
        r24 = null;
    L46:
        r19 = null;
    L36:
        r13 = null;
    L91:
        ECHybridListItemVO r42 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r14);
        if (r42 == null) goto L164;
        if (n.c(r42) != true) goto L164;
        ECHybridListItemVO r110 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r14);
        if (r110 == null) goto L161;
        ECNAMallCardExtra r43 = r110.c();
        if (r43 == null) goto L104;
        ECItemCardTag r44 = r43.getCardTag();
        if (r44 == null) goto L104;
        String[] r45 = r44.getPid();
    L105:
        if (r45 == null) goto L110;
        if (r10.a(r110, r10.d, r45, r10.j, "same_pid") == false) goto L110;
    L160:
        boolean r46 = true;
    L162:
        if (r46 == false) goto L164;
        r10.e(r14);
    L110:
        if ((!Intrinsics.areEqual(r10.v, "product_detail")) == false) goto L161;
        ECNAMallCardExtra r47 = r110.c();
        if (r47 == null) goto L116;
        ECItemCardTag r48 = r47.getCardTag();
        if (r48 == null) goto L116;
        String[] r49 = r48.getSpuSimId();
    L117:
        if (r49 != null) goto L119;
    L121:
        ECNAMallCardExtra r50 = r110.c();
        if (r50 == null) goto L126;
        ECItemCardTag r51 = r50.getCardTag();
        if (r51 == null) goto L126;
        String[] r52 = r51.getPicSimId();
    L127:
        if (r52 != null) goto L129;
    L131:
        ECNAMallCardExtra r53 = r110.c();
        if (r53 == null) goto L136;
        ECItemCardTag r54 = r53.getCardTag();
        if (r54 == null) goto L136;
        String[] r55 = r54.getVcTagClusterId();
    L137:
        if (r55 != null) goto L139;
    L141:
        ECNAMallCardExtra r56 = r110.c();
        if (r56 == null) goto L146;
        ECItemCardTag r57 = r56.getCardTag();
        if (r57 == null) goto L146;
        String[] r58 = r57.getPredictCategory();
    L147:
        if (r58 != null) goto L149;
    L151:
        ECNAMallCardExtra r59 = r110.c();
        if (r59 == null) goto L156;
        ECItemCardTag r60 = r59.getCardTag();
        if (r60 == null) goto L156;
        String[] r61 = r60.getLeafCategory();
    L157:
        if (r61 == null) goto L161;
        if (r10.a(r110, r10.g, r61, r10.m, "same_category") == false) goto L161;
    L156:
        r61 = null;
        goto L157
    L149:
        if (r10.a(r110, r10.f, r58, r10.l, "same_category") == false) goto L151;
    L146:
        r58 = null;
        goto L147
    L139:
        if (r10.a(r110, r10.e, r55, r10.k, "same_category") == false) goto L141;
    L136:
        r55 = null;
        goto L137
    L129:
        if (r10.a(r110, r10.i, r52, r10.o, "same_picture") == false) goto L131;
    L126:
        r52 = null;
        goto L127
    L119:
        if (r10.a(r110, r10.h, r49, r10.n, "same_picture") == false) goto L121;
    L116:
        r49 = null;
    L104:
        r45 = null;
    L161:
        r46 = false;
    L164:
        r14 = r14 + 1;
        goto L19
    L165:
        r10.a = r4;
    L166:
        int r62 = r10.b;
        if (r62 >= r4) goto L215;
        int r111 = r62;
    L169:
        if (r111 >= r4) goto L214;
        ECHybridListItemVO r63 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r111);
        if (r63 == null) goto L213;
        if (r111 < 4) goto L189;
        int r64 = r111 - 4;
        ECHybridListItemVO r65 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r64);
        if (r65 == null) goto L189;
        if (n.b(r65) != true) goto L189;
        ECHybridListItemVO r66 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r64);
        if (r66 == null) goto L189;
        if (r64 <= r10.q) goto L189;
        r10.q = r64;
        String[] r67 = n.f(r66);
        if (r67 == null) goto L189;
        ((ArrayList) r10.r).remove(r66);
        int r68 = r67.length;
        int r69 = 0;
    L186:
        if (r69 >= r68) goto L189;
        n.d(r10.s, r67[r69]);
        r69 = r69 + 1;
    L189:
        if (n.b(r63) == false) goto L213;
        if (n.f(r63) != null) goto L194;
    L202:
        String[] r70 = n.f(r63);
        if (r70 != null) goto L205;
    L207:
        boolean r71 = false;
    L208:
        if (r71 == false) goto L213;
        if (r111 <= r10.q) goto L212;
        r10.q = r111;
    L212:
        ((LinkedHashMap) r10.s).clear();
        goto L213
    L205:
        if (r10.a(r63, r10.s, r70, r10.t, "same_rid") == false) goto L207;
        r71 = true;
        goto L208
    L194:
        if (((ArrayList) r10.r).size() < 3) goto L201;
        ECHybridListItemVO r72 = (ECHybridListItemVO) CollectionsKt.firstOrNull(r10.r);
        if (r72 == null) goto L200;
        Map r73 = (Map) ((LinkedHashMap) r10.c).get(r72.Q);
        if (r73 == null) goto L200;
        ThreadPoolHelper.c().submit(new m(r73, "continue_live"));
    L200:
        ((ArrayList) r10.r).clear();
        goto L202
    L201:
        ((ArrayList) r10.r).add(r63);
    L213:
        r111 = r111 + 1;
        goto L169
    L214:
        r10.b = r4;
    L215:
        int r74 = RangesKt.coerceAtMost(RangesKt.coerceAtMost(r10.a, r10.b), r4) - 3;
    L216:
        if (r12 >= r74) goto L244;
        ECHybridListItemVO r75 = (ECHybridListItemVO) CollectionsKt.getOrNull(r3, r12);
        if (r75 == null) goto L220;
        Map<String, Object> r76 = r10.c.remove(r75.Q);
    L220:
        r12 = r12 + 1;
        goto L216
    L244:
        return;
    L243:
        return;
    L242:
        return;
    L221:
        return;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // e93.e
    public final void onFirstScreen() {
        b();
    }

    @Override // e93.e
    public final void onPause() {
        b();
    }

    @Override // e93.e
    public final void onRefreshEnd() {
        b();
    }

    public ECMallFeedRepeatManagerFeed(a.C0082a r2) {
        this.g = r2;
        this.a = r2.a;
        this.b = r2.c;
        this.c = r2.d;
        this.d = r2.e;
        this.e = LazyKt.lazy(new ECMallFeedRepeatManagerFeed$cardRepeatCheck$2(this));
        this.f = LazyKt.lazy(new ECMallFeedRepeatManagerFeed$exposureTime$2(this));
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void j(boolean r2) {
        EventExposureTime r0 = (EventExposureTime) this.f.getValue();
        if (r0 == null) goto L6;
        r0.j(r2);
        return;
    }

    @Override // e93.e
    public final void onTabChange(Integer r2) {
        if (r2 != null) goto L4;
    L9:
        n r3 = a();
        if (r3 == null) goto L15;
        r3.u = false;
        return;
    L15:
        return;
    L4:
        if (r2.intValue() == 0) goto L9;
        n r4 = a();
        if (r4 == null) goto L13;
        r4.u = true;
        return;
    }

    @Override // e93.e
    public final void initOrRefresh(boolean r7, Integer r8) {
        EventExposureTime r0 = (EventExposureTime) this.f.getValue();
        if (r0 == null) goto L8;
        r0.p();
        r0.a.clear();
        ((LinkedHashMap) r0.j).clear();
        r0.k.clear();
        r0.l = false;
        r0.d = -1;
        r0.e = -1;
        if (r7 == true) goto L7;
        r0.l(r0.b, System.currentTimeMillis());
        r0.b = 0;
        r0.c = 0;
    L7:
        r0.h = 0;
        r0.g = 0;
        r0.f = 0;
        r0.i = "";
    L8:
        if (r8 != null) goto L10;
    L11:
        n r9 = a();
        if (r9 == null) goto L19;
        r9.a = 0;
        r9.b = 0;
        r9.p = 0;
        r9.q = 0;
        ((LinkedHashMap) r9.c).clear();
        r9.e(0);
        if (r9.q >= 0) goto L16;
        r9.q = 0;
    L16:
        ((LinkedHashMap) r9.s).clear();
        ((ArrayList) r9.r).clear();
        return;
    L19:
        return;
    L10:
        if (r8.intValue() == 0) goto L11;
    }
}
