package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s {
    public static final si2.i s = null;
    public final com.bytedance.android.livesdk.livecommerce.oldflash.e a;
    public final k b;
    public final i c;
    public final l d;
    public final k e;
    public final k f;
    public final f g;
    public final com.bytedance.android.livesdk.livecommerce.oldflash.a h;
    public j i;
    public List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> j;
    public List<g> k;
    public boolean l;
    public k m;
    public k n;
    public xi2.a o;
    public final Context p;
    public final LiveFlashViewModel q;
    public final String r;

    public static final class a implements n {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
        public final String a(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "label");
            return th.a.g(this.a.getContext(), 2131896591);
        }
    }

    public static final class b implements n {
        public final /* synthetic */ s a;

        public b(s r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.n
        public final String a(String r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "label");
            return th.a.h(this.a.getContext(), 2131896611, new Object[]{Integer.valueOf(r4)});
        }
    }

    public static final class c implements m {
        public final /* synthetic */ l a;
        public final /* synthetic */ s b;

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
        public final boolean a() {
            String r0 = this.a.c;
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.length());
        L6:
            int r2 = com.bytedance.android.shopping.extensions.k.f(r1);
            String r3 = this.b.q.getTargetName();
            if (r3 != null) goto L10;
            r3 = "";
        L10:
            if ((r2 + s.d(r3).length()) >= d.c()) goto L18;
            int r4 = com.bytedance.android.shopping.extensions.k.g(Integer.valueOf(this.b.e().length()), 0);
            int r5 = d.d();
            int r6 = d.c();
            if (r5 > r4) goto L15;
            if (r6 < r4) goto L15;
            return false;
        L15:
            return true;
        L18:
            return false;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
        public final String b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            si2.i r1 = s.s;
            return th.a.h(r4, 2131896583, new Object[]{Integer.valueOf(d.d()), Integer.valueOf(d.c())});
        }

        public c(l r1, s r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d {
        public static int c() {
            return ((si2.i) EComABUtils.getLiveSettingValue("flash_create_config", s.s)).a();
        }

        public static int d() {
            return ((si2.i) EComABUtils.getLiveSettingValue("flash_create_config", s.s)).b();
        }

        public static String a(Context r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (r4 != 9999) goto L6;
            return th.a.g(r3, 2131896568);
        L6:
            return th.a.h(r3, 2131896560, new Object[]{Long.valueOf(r4)});
        }

        public static long b(Context r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            long r0 = 0;
            if (r4 != null) goto L6;
            return 0;
        L6:
            if (Intrinsics.areEqual(r4, th.a.g(r3, 2131896568)) == false) goto L12;
            return 9999;
        L12:
            r0 = CastLongProtector.parseLong(new Regex("[^0-9]").replace(r4, ""));     // Catch: Throwable -> L11
        L10:
            return r0;
        }

        public static int e(String r2, int r3) {
            if (r2 != null) goto L10;
        L7:
            return 0;
        L10:
            String r4 = StringsKt.trim(r2).toString();     // Catch: Exception -> L9
            if (r4 == null) goto L7;
            double r0 = CastDoubleProtector.parseDouble(r4);     // Catch: Exception -> L9
            return (int) (r0 * ((double) r3));
        }
    }

    public static final class e<T> implements Comparator<T> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((xi2.k0) r1, (xi2.k0) r2);
        }
    }

    static {
        s = new si2.i();
    }

    public final Integer c() {
        List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r0 = this.j;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r1 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) ListProtector.get(r0, 1);
    L7:
        if ((r1 instanceof k) == true) goto L9;
        r1 = null;
    L9:
        k r2 = (k) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(d.e(r2.g, 100));
    L5:
        r1 = null;
        goto L7
    }

    public final String e() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.d.c;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        String r3 = this.q.getTargetName();
        if (r3 == null) goto L8;
        r0.append(d(r3));
    L8:
        String r4 = this.d.d;
        if (r4 == null) goto L12;
        r2 = r4;
    L12:
        r0.append(r2);
        return r0.toString();
    }

    public final Context getContext() {
        return this.p;
    }

    public static String d(String r7) {
        int r0 = r7.length();
        if (r0 <= 1) goto L15;
        int r4 = 0;
        if (r0 == 2) goto L14;
        StringBuilder r3 = new StringBuilder(String.valueOf(r7.charAt(0)));
        int r5 = RangesKt.coerceAtMost(r0 - 2, 4);
    L9:
        if (r4 >= r5) goto L11;
        r3.append("*");
        r4 = r4 + 1;
        goto L9
    L11:
        r3.append(String.valueOf(r7.charAt(r0 - 1)));
        return r3.toString();
    L14:
        return String.valueOf(r7.charAt(0)) + "*";
    L15:
        return r7;
    }

    public final void f(List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L18;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r1 = (com.bytedance.android.livesdk.livecommerce.oldflash.b) r6.next();
        if ((r1 instanceof k) == false) goto L6;
        k r2 = (k) r1;
        xi2.k0 r3 = r2.f;
        if (r3 == null) goto L6;
        if (r3 == null) goto L6;
        if (r3.d() != true) goto L6;
        if (r2.n.size() > 1) goto L16;
        r0.append(r2.g);
        goto L6
    L16:
        r0.append((String) CollectionsKt.first(r2.n));
        goto L6
    L18:
        l r7 = this.d;
        r7.c = r0.toString();
    }

    public final k b(xi2.k0 r12, Map<String, ? extends List<String>> r13) {
        boolean r3 = true;
        if (r12.g() == false) goto L12;
        if (r12.h() == false) goto L8;
        String r0 = th.a.g(this.p, 2131896601);
    L15:
        String r4 = r12.getName();
        String r5 = "";
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        k r1 = new k(r4, r0, !r12.h());
        r1.a = r12.g();
        r1.f = r12;
        r1.d = Intrinsics.areEqual(th.a.g(this.p, 2131896548), r12.getName());
        r1.e = r12.f();
        if (r12.g() == false) goto L70;
        String r6 = null;
        JSONArray r7 = null;
        r6 = null;
        if (Intrinsics.areEqual(th.a.g(this.p, 2131896548), r12.getName()) == false) goto L48;
        Intrinsics.checkNotNullParameter(r12, "item");
        String r14 = r12.a();
        if (r14 == null) goto L38;
        JSONObject r15 = z1.g(r14);
        if (r15 == null) goto L38;
        JSONObject r16 = r15.optJSONObject("group");
        if (r16 == null) goto L38;
        JSONArray r17 = r16.optJSONArray("本类目已有资质品牌");
        if (r17 == null) goto L38;
        if (r17.length() > 0) goto L34;
        r3 = false;
    L34:
        if (r3 == false) goto L36;
        r7 = r17;
    L36:
        if (r7 == null) goto L38;
        int r18 = JSONArrayProtectorUtils.getInt(r7, 0);
    L39:
        if (r18 <= (-1)) goto L46;
        List<String> r19 = r12.b();
        if (r19 == null) goto L47;
        String r110 = (String) CollectionsKt.getOrNull(r19, r18);
        if (r110 == null) goto L47;
        r5 = r110;
    L47:
        r1.m = r5;
        List<String> r111 = CollectionsKt.listOf(r5);
    L71:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r1.n = r111;
        Intrinsics.checkNotNullParameter(r111, "$this$toDisplayString");
        r1.g = CollectionsKt.joinToString$default(r111, "，", null, null, 0, null, null, 62, null);
        return r1;
    L46:
        r5 = th.a.g(this.p, 2131896592);
    L38:
        r18 = -1;
        goto L39
    L48:
        if (r13 == null) goto L59;
        List<String> r112 = r13.get(r12.getName());
        if (r112 == null) goto L59;
        if ((!r112.isEmpty()) == true) goto L55;
        r112 = null;
    L55:
        if (r112 == null) goto L59;
        r111 = r112;
    L59:
        if (r12.h() == true) goto L62;
        r12 = null;
    L62:
        if (r12 == null) goto L66;
        List<String> r113 = r12.b();
        if (r113 == null) goto L66;
        r6 = (String) CollectionsKt.firstOrNull(r113);
    L66:
        if (r6 == null) goto L69;
        r5 = r6;
    L69:
        r111 = CollectionsKt.listOf(r5);
        goto L71
    L70:
        r111 = CollectionsKt.emptyList();
        goto L71
    L8:
        if (r12.d() == false) goto L10;
        r0 = th.a.h(this.p, 2131896583, new Object[]{Integer.valueOf(d.d()), Integer.valueOf(d.c())});
        goto L15
    L10:
        r0 = th.a.h(this.p, 2131896600, new Object[]{20});
        goto L15
    L12:
        if (r12.h() == false) goto L14;
        r0 = th.a.g(this.p, 2131896594);
        goto L15
    L14:
        r0 = th.a.h(this.p, 2131896593, new Object[]{20});
        goto L15
    }

    public s(Context r6, LiveFlashViewModel r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "imagePath");
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.a = new com.bytedance.android.livesdk.livecommerce.oldflash.e(r8);
        boolean r2 = true;
        k r9 = new k(th.a.g(r6, 2131896596), "0.00", true);
        r9.k = 1;
        r9.a = true;
        r9.i = 100000000;
        r9.h = new a(this);
        Unit r0 = Unit.INSTANCE;
        this.b = r9;
        i r10 = new i(th.a.g(r6, 2131896608));
        r10.k = 0;
        r10.a = true;
        r10.h = new b(this);
        r10.i = 1000000;
        this.c = r10;
        l r11 = new l(th.a.g(r6, 2131896617));
        r11.e = new c(r11, this);
        this.d = r11;
        k r12 = new k(th.a.g(r6, 2131896553), th.a.g(r6, 2131896601), false);
        r12.c = true;
        r12.a = true;
        this.e = r12;
        this.f = new k(th.a.g(r6, 2131896572), th.a.h(r6, 2131896593, new Object[]{20}), true);
        this.g = new f(0);
        com.bytedance.android.livesdk.livecommerce.oldflash.a r13 = new com.bytedance.android.livesdk.livecommerce.oldflash.a(th.a.g(r6, 2131896605), th.a.g(r6, 2131896606));
        r13.a = false;
        if (r7.getBarCodeState() == 1) goto L6;
        r2 = false;
    L6:
        r13.q = r2;
        r13.j = 4;
        r13.k = 3;
        this.h = r13;
        r7.setFlashHelper(this);
    }

    public final List<com.bytedance.android.livesdk.livecommerce.oldflash.b> a(String r20, xi2.v r21, boolean r22) {
        boolean r2 = false;
        if (r21 == null) goto L21;
        List<xi2.k0> r4 = r21.d();
        if (r4 == null) goto L21;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        xi2.k0 r8 = (xi2.k0) r7;
        if (r8.h() == false) goto L17;
        List<String> r9 = r8.b();
        if (r9 != null) goto L14;
    L16:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L8;
        r5.add(r7);
        goto L8
    L14:
        if ((!r9.isEmpty()) != true) goto L16;
    L17:
        r10 = true;
        goto L18
    L20:
        List r11 = CollectionsKt.sortedWith(r5, new e());
    L22:
        if (r21 == null) goto L24;
        int r12 = r21.h();
    L26:
        if (r21 == null) goto L36;
        Integer r13 = Integer.valueOf(r21.g());
        if (r13.intValue() <= 0) goto L30;
        boolean r14 = true;
    L31:
        if (r14 == true) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L36;
        int r15 = r13.intValue();
    L37:
        if (r21 == null) goto L39;
        final xi2.d r16 = r21.c();
    L40:
        if (r21 == null) goto L42;
        List<xi2.j0> r17 = r21.f();
    L43:
        this.e.g = r20;
        if (r22 == true) goto L46;
    L50:
        final Map<String, ? extends List<String>> r18 = null;
    L51:
        i r19 = this.c;
        r19.i = r15;
        if (r15 != 1000000) goto L54;
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "<set-?>");
        r19.o = BDLocationException.ERROR_TIMEOUT;
    L55:
        ArrayList r23 = new ArrayList();
        r23.add(this.a);
        if (r16 != null) goto L58;
    L59:
        r23.add(this.b);
    L60:
        r23.add(this.c);
        r23.add(this.e);
        if (r11 == null) goto L74;
        Iterator r110 = r11.iterator();
        boolean r111 = false;
    L64:
        if (r110.hasNext() == false) goto L75;
        xi2.k0 r112 = (xi2.k0) r110.next();
        if (r112.g() == false) goto L64;
        if (r112.d() == true) goto L73;
        if (r111 == true) goto L73;
        if (r112.c() == 1687) goto L73;
        r23.add(this.d);
        r111 = true;
    L73:
        r23.add(b(r112, r18));
    L75:
        if (r111 == true) goto L78;
        r23.add(this.d);
    L78:
        if (this.q.isNeedBarCode() == false) goto L80;
        r23.add(this.h);
    L80:
        String r113 = "default";
        if (r16 != null) goto L83;
    L100:
        this.j = null;
        if (r21 == null) goto L139;
        final xi2.c r3 = r21.b();
        if (r3 == null) goto L139;
        k r24 = new k(th.a.g(this.p, 2131896561), th.a.g(this.p, 2131896601), false);
        r24.a = true;
        r24.l = new LiveFlashHelper$createDeliveryDelayTimeRuleData$$inlined$apply$lambda$1(this, r3, r18);
        xi2.k0 r25 = new xi2.k0();
        r25.i(th.a.g(this.p, 2131896561));
        List<Long> r114 = r3.a();
        if (r114 == null) goto L111;
        List<Long> r115 = r114;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator<T> r1 = r115.iterator();
    L108:
        if (r1.hasNext() == false) goto L110;
        r116.add(d.a(this.p, ((Number) r1.next()).longValue()));
        r113 = r113;
        goto L108
    L110:
        String r26 = r113;
    L112:
        r25.l(r116);
        List<Long> r27 = r3.a();
        if (r27 == null) goto L118;
        List<Long> r28 = r27;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator<T> r29 = r28.iterator();
    L116:
        if (r29.hasNext() == false) goto L119;
        r117.add(String.valueOf(((Number) r29.next()).longValue()));
    L119:
        r25.o(r117);
        r25.m();
        r25.n();
        Unit r30 = Unit.INSTANCE;
        r24.f = r25;
        if (r18 == null) goto L126;
        List<String> r31 = r18.get(r24.b);
        if (r31 == null) goto L126;
        String r32 = (String) CollectionsKt.first(r31);
        if (r32 == null) goto L126;
        String r33 = r26;
        Intrinsics.checkNotNullParameter("", r33);
    L128:
        if (com.bytedance.android.shopping.extensions.k.c(r32) == false) goto L130;
        r24.g = r32;
    L138:
        this.m = r24;
        r23.add(r24);
    L140:
        if (r21 == null) goto L175;
        xi2.a r34 = r21.a();
        if (r34 == null) goto L175;
        this.o = r34;
        k r35 = new k(th.a.g(this.p, 2131896602), th.a.g(this.p, 2131896601), false);
        r35.a = true;
        final xi2.l0 r36 = r34.a();
        if (r36 == null) goto L173;
        r35.l = new LiveFlashHelper$createAfterSellRuleReturnData$1$1$1(r36);
        List<String> r37 = r36.b();
        if (r37 == null) goto L173;
        xi2.k0 r118 = new xi2.k0();
        r118.i(th.a.g(this.p, 2131896602));
        r118.l(r37);
        r118.m();
        r118.n();
        r118.o(r36.a());
        Unit r119 = Unit.INSTANCE;
        r35.f = r118;
        if (r18 == null) goto L154;
        List<String> r120 = r18.get(r35.b);
        if (r120 == null) goto L154;
        String r121 = (String) CollectionsKt.first(r120);
        if (r121 == null) goto L154;
        Intrinsics.checkNotNullParameter("", r33);
    L156:
        if (com.bytedance.android.shopping.extensions.k.c(r121) == true) goto L169;
        List<String> r38 = r36.a();
        if (r38 == null) goto L161;
        Integer r39 = Integer.valueOf(r38.indexOf("7-1"));
    L162:
        int r40 = com.bytedance.android.shopping.extensions.k.g(r39, 0);
        if (r37.isEmpty() == false) goto L165;
        r121 = "";
        goto L169
    L165:
        if (r40 >= 0) goto L167;
    L170:
        String r41 = (String) ListProtector.get(r37, r37.size() - 1);
    L171:
        r35.g = r41;
        goto L173
    L167:
        if (r40 >= r37.size()) goto L170;
        r121 = (String) ListProtector.get(r37, r40);
        goto L169
    L161:
        r39 = null;
    L169:
        r41 = r121;
    L154:
        r121 = null;
    L173:
        this.n = r35;
        Unit r42 = Unit.INSTANCE;
        r23.add(r35);
    L175:
        ArrayList r43 = new ArrayList();
        if (r17 == null) goto L203;
        Iterator<T> r44 = r17.iterator();
        boolean r45 = true;
    L179:
        if (r44.hasNext() == false) goto L203;
        xi2.j0 r46 = (xi2.j0) r44.next();
        String r47 = r46.c();
        String r122 = r46.b();
        if (r47 != null) goto L183;
    L186:
        boolean r123 = true;
    L187:
        if (r123 == true) goto L200;
        if (r122 != null) goto L190;
    L193:
        boolean r124 = true;
    L194:
        if (r124 == true) goto L200;
        if (r45 == false) goto L198;
        String r125 = th.a.g(this.p, 2131896597);
    L199:
        g r126 = new g(r125, r47, r122);
        r126.c = r46.a();
        r126.d = r46.f();
        r126.e = r46.e();
        r126.f = r46.d();
    L201:
        if (r126 == null) goto L179;
        r43.add(r126);
        r45 = false;
        goto L179
    L198:
        r125 = "";
        goto L199
    L190:
        if (r122.length() == 0) goto L193;
        r124 = false;
    L200:
        r126 = null;
        goto L201
    L183:
        if (r47.length() == 0) goto L186;
        r123 = false;
    L203:
        this.k = r43;
        r23.addAll(r43);
        r23.add(this.g);
        if (r11 == null) goto L211;
        Iterator r48 = r11.iterator();
    L207:
        if (r48.hasNext() == false) goto L211;
        xi2.k0 r49 = (xi2.k0) r48.next();
        if (r49.g() == true) goto L207;
        r23.add(b(r49, r18));
    L211:
        if (r12 <= 0) goto L216;
        j r50 = this.i;
        if (r50 != null) goto L215;
        r50 = new j(th.a.g(this.p, 2131896612), r12);
        this.i = r50;
        Unit r51 = Unit.INSTANCE;
    L215:
        r23.add(r50);
    L216:
        j r52 = this.i;
        if (r52 == null) goto L219;
        r52.d = r12;
    L219:
        if (r52 == null) goto L223;
        if (r12 <= 0) goto L222;
        r2 = true;
    L222:
        r52.c = r2;
    L223:
        r23.add(this.f);
        f(r23);
        return r23;
    L130:
        List<Long> r53 = r3.a();
        if (r53 == null) goto L138;
        if ((!r53.isEmpty()) == true) goto L136;
        r53 = null;
    L136:
        if (r53 == null) goto L138;
        r24.g = d.a(this.p, ((Number) CollectionsKt.last(r53)).longValue());
    L126:
        r33 = r26;
        r32 = null;
        goto L128
    L118:
        r117 = null;
        goto L119
    L111:
        r26 = "default";
        r116 = null;
    L139:
        r33 = "default";
        goto L140
    L83:
        if (r16.e() != true) goto L100;
        com.bytedance.android.livesdk.livecommerce.oldflash.b[] r127 = new com.bytedance.android.livesdk.livecommerce.oldflash.b[4];
        r127[0] = new h(th.a.g(this.p, 2131896567), th.a.g(this.p, 2131896565), th.a.g(this.p, 2131896566));
        k r54 = new k(th.a.g(this.p, 2131896563), th.a.g(this.p, 2131896562), true);
        r54.a = true;
        r54.k = 0;
        r54.i = 1000000;
        r54.h = new t(this);
        r54.j = 1;
        Unit r55 = Unit.INSTANCE;
        r127[1] = r54;
        if (r16.f() == false) goto L90;
        String r56 = r16.b();
        if (r56 != null) goto L89;
        r56 = "";
    L89:
        com.bytedance.android.livesdk.livecommerce.oldflash.d r57 = new com.bytedance.android.livesdk.livecommerce.oldflash.d(r56);
        r57.a = true;
        com.bytedance.android.livesdk.livecommerce.oldflash.b r58 = r57;
    L91:
        r127[2] = r58;
        k r59 = new k(th.a.g(this.p, 2131896561), th.a.g(this.p, 2131896601), false);
        r59.a = true;
        r59.l = new LiveFlashHelper$createDepositList$$inlined$apply$lambda$3(this, r16);
        List<Long> r60 = r16.a();
        if (r60 != null) goto L94;
    L99:
        r127[3] = r59;
        List<? extends com.bytedance.android.livesdk.livecommerce.oldflash.b> r61 = CollectionsKt.listOf(r127);
        this.j = r61;
        r23.addAll(r61);
        goto L139
    L94:
        if ((!r60.isEmpty()) == true) goto L97;
        r60 = null;
    L97:
        if (r60 == null) goto L99;
        r59.g = d.a(this.p, ((Number) CollectionsKt.last(r60)).longValue());
        goto L99
    L90:
        k r62 = new k(th.a.g(this.p, 2131896564), th.a.g(this.p, 2131896601), false);
        r62.a = true;
        r62.l = new LiveFlashHelper$createDepositList$$inlined$apply$lambda$2(this, r16);
        r62.g = d.a(this.p, r16.c());
        r58 = r62;
        goto L91
    L74:
        r111 = false;
        goto L75
    L58:
        if (r16.e() == true) goto L60;
    L54:
        String r63 = th.a.h(this.p, 2131896610, new Object[]{Integer.valueOf(r15)});
        Intrinsics.checkNotNullParameter(r63, "<set-?>");
        r19.o = r63;
        goto L55
    L46:
        if (this.l == true) goto L50;
        if (this.q.isCategoryChanged() == true) goto L50;
        r18 = this.q.getProperties();
        this.l = true;
        goto L51
    L42:
        r17 = null;
        goto L43
    L39:
        r16 = null;
        goto L40
    L30:
        r14 = false;
    L36:
        r15 = 1000000;
        goto L37
    L24:
        r12 = 0;
    L21:
        r11 = null;
        goto L22
    }
}
