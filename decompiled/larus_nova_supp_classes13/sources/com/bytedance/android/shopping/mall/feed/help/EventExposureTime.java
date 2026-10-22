package com.bytedance.android.shopping.mall.feed.help;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.CardBusinessType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.mall.feed.holder.ECMallFeedTitleViewHolder;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class EventExposureTime implements k, l, g {
    public static final /* synthetic */ int q = 0;
    public final Set<BaseViewHolder> a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;
    public final Map<BaseViewHolder, Boolean> j;
    public final Set<BaseViewHolder> k;
    public boolean l;
    public int m;
    public final Rect n;
    public final a.C0083a o;
    public final Function0<String> p;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.help.EventExposureTime$a$a, reason: collision with other inner class name */
        public static final class C0083a {
            public final String a;
            public String b;
            public final CoroutineScope c;
            public final q d;
            public final ECHybridRecyclerView e;
            public final boolean f;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0083a) == false) goto L18;
                C0083a r4 = (C0083a) r3;
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
                if (this.f == r4.f) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public final int hashCode() {
                String r0 = this.a;
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
                q r10 = this.d;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                ECHybridRecyclerView r13 = this.e;
                if (r13 == null) goto L21;
                r1 = r13.hashCode();
            L21:
                int r14 = (r12 + r1) * 31;
                boolean r15 = this.f;
                ?? r16 = r15;
                if (r15 == false) goto L25;
                r16 = 1;
            L25:
                return r14 + r16;
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
                return "ExposureTimeContext(pageName=" + this.a + ", btm=" + this.b + ", scope=" + this.c + ", shelterHelp=" + this.d + ", recyclerView=" + this.e + ", isNestScene=" + this.f + ")";
            }

            public C0083a(String r2, String r3, CoroutineScope r4, q r5, ECHybridRecyclerView r6, boolean r7) {
                Intrinsics.checkNotNullParameter(r2, "pageName");
                Intrinsics.checkNotNullParameter(r3, "btm");
                Intrinsics.checkNotNullParameter(r4, "scope");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void k(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.l
    public final void b() {
        if (this.o.f == false) goto L5;
        h();
        return;
    L5:
        r();
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.k
    public final void d() {
        if (this.o.f == false) goto L5;
        h();
        return;
    L5:
        r();
    }

    public final void h() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ECHybridListItemVO r1 = ((BaseViewHolder) r0.next()).c;
        if (r1 == null) goto L4;
        r1.m();
        goto L4
    }

    public final void p() {
        ArrayList r0 = new ArrayList();
        if (this.o.f == false) goto L5;
        Set<BaseViewHolder> r1 = this.a;
    L6:
        r0.addAll(r1);
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(this.j);
        this.k.clear();
        Iterator<T> r3 = this.a.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        BaseViewHolder r4 = (BaseViewHolder) r3.next();
        if (this.j.containsKey(r4) == false) goto L8;
        this.j.put(r4, Boolean.FALSE);
        goto L8
    L12:
        BuildersKt.launch$default(this.o.c, Dispatchers.getDefault(), null, new EventExposureTime$reportAllCardExposure$2(this, r0, r2, null), 2, null);
        return;
    L5:
        r1 = this.k;
        goto L6
    }

    public final void r() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        BaseViewHolder r1 = (BaseViewHolder) r0.next();
        if ((r1 instanceof ECMallFeedTitleViewHolder) == true) goto L4;
        if (this.k.contains(r1) == true) goto L4;
        if (this.a.contains(r1) == false) goto L4;
        if (r1.c == null) goto L4;
        if (((RecyclerView.ViewHolder) r1).itemView.getLocalVisibleRect(this.n) == false) goto L4;
        if (this.k.isEmpty() == false) goto L22;
        this.b = System.currentTimeMillis();
    L22:
        ECHybridListItemVO r2 = r1.c;
        if (r2 == null) goto L25;
        r2.m();
    L25:
        this.k.add(r1);
        this.j.put(r1, Boolean.TRUE);
        goto L4
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.l
    public final void a() {
        p();
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.k
    public final void c() {
        p();
    }

    public static final String e(EventExposureTime r4) {
        if (r4.o.b.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        a.C0083a r1 = r4.o;
        String r2 = (String) r4.p.invoke();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.b = r2;
        return r4.o.b + "c0.d0";
    L11:
        return r4.o.b + "c0.d0";
    L5:
        r0 = false;
        goto L7
    }

    public static boolean m(ECHybridListItemVO r1) {
        ECNAMallCardExtra r2 = r1.c();
        if (r2 == null) goto L7;
        CardBusinessType r3 = r2.getCardBusinessType();
        if (r3 == null) goto L7;
        Boolean r4 = r3.isAd();
    L9:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L7:
        r4 = null;
        goto L9
    }

    public static boolean n(ECHybridListItemVO r1) {
        ECNAMallCardExtra r2 = r1.c();
        if (r2 == null) goto L7;
        CardBusinessType r3 = r2.getCardBusinessType();
        if (r3 == null) goto L7;
        Boolean r4 = r3.isLife();
    L9:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L7:
        r4 = null;
        goto L9
    }

    public static boolean o(ECHybridListItemVO r1) {
        ECNAMallCardExtra r2 = r1.c();
        if (r2 == null) goto L7;
        CardBusinessType r3 = r2.getCardBusinessType();
        if (r3 == null) goto L7;
        Boolean r4 = r3.isLive();
    L9:
        return Intrinsics.areEqual(r4, Boolean.TRUE);
    L7:
        r4 = null;
        goto L9
    }

    public final JSONObject i(BaseViewHolder r17) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L85
        if (r17.c != null) goto L7;
        return null;
    L7:
        if (r17.getLayoutPosition() < 0) goto L9;
    L11:
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L85
        ECHybridListItemVO r5 = r17.c;     // Catch: Throwable -> L85
        if (r5 != null) goto L14;
    L84:
        return r4;
    L14:
        if (r17.getAdapterPosition() <= 0) goto L16;
        int r6 = r17.getAdapterPosition();     // Catch: Throwable -> L85
    L17:
        com.bytedance.android.ec.hybrid.list.entity.n r7 = r5.o;     // Catch: Throwable -> L85
        String r11 = "";
        if (r7 == null) goto L65;
        List r8 = r7.c;     // Catch: Throwable -> L85
        if (r8 == null) goto L65;
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L85
        String r12 = "";
        String r13 = r12;
    L24:
        if (r9.hasNext() == false) goto L64;
        com.bytedance.android.ec.hybrid.list.entity.c r14 = (com.bytedance.android.ec.hybrid.list.entity.c) r9.next();     // Catch: Throwable -> L85
        if (Intrinsics.areEqual(r14.a, "show_ecom_card") == false) goto L24;
        Map r10 = r14.b;     // Catch: Throwable -> L85
        if (r10 == null) goto L30;
        Object r15 = r10.get("ecom_type");     // Catch: Throwable -> L85
    L32:
        if ((r15 instanceof String) == true) goto L34;
        r15 = null;
    L34:
        String r16 = (String) r15;     // Catch: Throwable -> L85
        if (r16 != null) goto L37;
        r13 = "";
    L38:
        Map r18 = r14.b;     // Catch: Throwable -> L85
        if (r18 == null) goto L41;
        Object r19 = r18.get("btm");     // Catch: Throwable -> L85
    L43:
        if ((r19 instanceof String) == true) goto L45;
        r19 = null;
    L45:
        String r20 = (String) r19;     // Catch: Throwable -> L85
        if (r20 != null) goto L48;
        r12 = "";
    L50:
        if (r12.length() != 0) goto L52;
        boolean r21 = true;
    L53:
        if (r21 == false) goto L24;
        Map r22 = r14.d;     // Catch: Throwable -> L85
        if (r22 == null) goto L57;
        Object r23 = r22.get("btm");     // Catch: Throwable -> L85
    L59:
        if ((r23 instanceof String) == true) goto L61;
        r23 = null;
    L61:
        r12 = (String) r23;     // Catch: Throwable -> L85
        if (r12 != null) goto L24;
        r12 = "";
        goto L24
    L57:
        r23 = null;
        goto L59
    L52:
        r21 = false;
        goto L53
    L48:
        r12 = r20;
        goto L50
    L41:
        r19 = null;
        goto L43
    L37:
        r13 = r16;
        goto L38
    L30:
        r15 = null;
        goto L32
    L64:
        r11 = r12;
    L67:
        if (this.o.b.length() != 0) goto L69;
        boolean r24 = true;
    L70:
        if (r24 == false) goto L72;
        a.C0083a r25 = this.o;     // Catch: Throwable -> L85
        String r26 = (String) this.p.invoke();     // Catch: Throwable -> L85
        r25.getClass();     // Catch: Throwable -> L85
        Intrinsics.checkNotNullParameter(r26, "<set-?>");     // Catch: Throwable -> L85
        r25.b = r26;     // Catch: Throwable -> L85
    L72:
        r4.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, this.o.a);     // Catch: Throwable -> L85
        r4.putOpt("btm", this.o.b + r11);     // Catch: Throwable -> L85
        r4.putOpt("item_type", r5.c);     // Catch: Throwable -> L85
        r4.putOpt("ecom_type", r13);     // Catch: Throwable -> L85
        r4.putOpt("index", Integer.valueOf(r6 + this.m));     // Catch: Throwable -> L85
        r4.putOpt("exposure_num", Integer.valueOf(r5.J));     // Catch: Throwable -> L85
        r4.putOpt("exposure_start", Long.valueOf(r5.M));     // Catch: Throwable -> L85
        r4.putOpt("exposure_end", Long.valueOf(r5.N));     // Catch: Throwable -> L85
        r4.putOpt("exposure_time", Long.valueOf(r5.N - r5.M));     // Catch: Throwable -> L85
        r4.putOpt("recommend_info", r5.b());     // Catch: Throwable -> L85
        ECHybridListItemVO r0 = r17.c;     // Catch: Throwable -> L85
        if (r0 == null) goto L78;
        ECNAMallCardExtra r1 = r0.c();     // Catch: Throwable -> L85
        if (r1 == null) goto L78;
        Map r2 = r1.getTrackParams();     // Catch: Throwable -> L85
        if (r2 == null) goto L78;
    L79:
        Iterator r27 = r2.keySet().iterator();     // Catch: Throwable -> L85
    L80:
        if (r27.hasNext() == false) goto L84;
        String r28 = (String) r27.next();     // Catch: Throwable -> L85
        r4.putOpt(r28, r2.get(r28));     // Catch: Throwable -> L85
    L78:
        r2 = new LinkedHashMap();     // Catch: Throwable -> L85
        goto L79
    L69:
        r24 = false;
    L65:
        r13 = "";
        goto L67
    L16:
        r6 = r17.getLayoutPosition();     // Catch: Throwable -> L85
        goto L17
    L9:
        if (r17.getAdapterPosition() >= 0) goto L11;
        return null;
    L85:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void j(boolean r5) {
        if (r5 == true) goto L4;
        p();
        l(this.b, System.currentTimeMillis());
        return;
    L4:
        if (this.o.f == false) goto L8;
        h();
        if ((!this.a.isEmpty()) == false) goto L11;
        this.b = System.currentTimeMillis();
        return;
    L11:
        return;
    L8:
        r();
    }

    public EventExposureTime(a.C0083a r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r4, "getBtm");
        this.o = r3;
        this.p = r4;
        this.a = new LinkedHashSet();
        this.d = -1;
        this.e = -1;
        this.i = "";
        this.j = new LinkedHashMap();
        this.k = new LinkedHashSet();
        this.n = new Rect();
        q r0 = r3.d;
        if (r0 == null) goto L5;
        r0.g(this);
    L5:
        q r1 = r3.d;
        if (r1 == null) goto L9;
        r1.e(this);
    L9:
        if (Intrinsics.areEqual(r3.a, MallPageName.X_TAB_MALL) == false) goto L11;
    L12:
        this.m = -1;
        return;
    L11:
        if (Intrinsics.areEqual(r3.a, "order_homepage") == true) goto L12;
    }

    public static final void f(EventExposureTime r13, BaseViewHolder r14) {
        r13.getClass();
        if ((r14 instanceof ECMallFeedTitleViewHolder) == false) goto L6;
        r13.m = -1;
        return;
    L6:
        if (r13.a.isEmpty() == false) goto L8;
        r13.b = System.currentTimeMillis();
    L8:
        r13.a.add(r14);
        r13.d = RangesKt.coerceAtLeast(r13.d, r14.getAdapterPosition());
        if (r13.o.f == false) goto L14;
        ECHybridListItemVO r0 = r14.c;
        if (r0 == null) goto L14;
        r0.m();
    L14:
        if (r14.getAdapterPosition() <= r13.e) goto L112;
        r13.e = r14.getAdapterPosition();
        ECHybridListItemVO r1 = r14.c;
        if (r1 == null) goto L108;
        String r3 = "";
        Object r5 = null;
        if (m(r1) == true) goto L57;
        if (o(r1) == true) goto L57;
        if (n(r1) == true) goto L57;
        if (r13.h <= 1) goto L27;
    L31:
        int r2 = r14.getAdapterPosition() + r13.m;
        ECHybridListItemVO r15 = r14.c;
        if (r15 == null) goto L38;
        com.bytedance.android.ec.hybrid.list.entity.n r16 = r15.o;
        if (r16 == null) goto L38;
        HashMap r17 = r16.b;
        if (r17 == null) goto L38;
        Object r18 = r17.get("request_id");
    L40:
        if ((r18 instanceof String) == false) goto L43;
        r5 = r18;
    L43:
        String r6 = (String) r5;
        if (r6 != null) goto L46;
        r6 = "";
    L46:
        int r9 = r13.h;
        if (r9 <= 1) goto L49;
        r13.q("ad", r9, r2, r13.i, r6);
    L49:
        int r10 = r13.g;
        if (r10 <= 1) goto L52;
        r13.q("life", r10, r2, r13.i, r6);
    L52:
        int r11 = r13.f;
        if (r11 <= 1) goto L55;
        r13.q("live", r11, r2, r13.i, r6);
    L55:
        r13.h = 0;
        r13.g = 0;
        r13.f = 0;
        r13.i = "";
        return;
    L38:
        r18 = null;
        goto L40
    L27:
        if (r13.g > 1) goto L31;
        if (r13.f > 1) goto L31;
        r13.h = 0;
        r13.g = 0;
        r13.f = 0;
        r13.i = "";
        return;
    L57:
        if (m(r1) == false) goto L59;
    L62:
        ECHybridListItemVO r4 = r14.c;
        if (r4 == null) goto L69;
        com.bytedance.android.ec.hybrid.list.entity.n r7 = r4.o;
        if (r7 == null) goto L69;
        HashMap r8 = r7.b;
        if (r8 == null) goto L69;
        Object r12 = r8.get("request_id");
    L71:
        if ((r12 instanceof String) == false) goto L74;
        r5 = r12;
    L74:
        String r19 = (String) r5;
        if (r19 == null) goto L78;
        r3 = r19;
    L78:
        int r110 = r14.getAdapterPosition() + r13.m;
        if (m(r1) == false) goto L82;
        r13.h++;
    L82:
        if (n(r1) == false) goto L85;
        r13.g++;
    L85:
        if (o(r1) == false) goto L88;
        r13.f++;
    L88:
        if (m(r1) == true) goto L94;
        int r20 = r13.h;
        if (r20 <= 1) goto L92;
        r13.q("ad", r20, r110, r13.i, r3);
    L92:
        r13.h = 0;
    L94:
        if (n(r1) == true) goto L100;
        int r21 = r13.g;
        if (r21 <= 1) goto L98;
        r13.q("life", r21, r110, r13.i, r3);
    L98:
        r13.g = 0;
    L100:
        if (o(r1) == true) goto L105;
        int r22 = r13.f;
        if (r22 <= 1) goto L104;
        r13.q("live", r22, r110, r13.i, r3);
    L104:
        r13.f = 0;
    L105:
        r13.i = r3;
        return;
    L69:
        r12 = null;
        goto L71
    L59:
        if (o(r1) == true) goto L62;
        if (n(r1) == true) goto L62;
        return;
    L108:
        return;
    }

    public static final void g(EventExposureTime r5, BaseViewHolder r6) {
        r5.getClass();
        if ((r6 instanceof ECMallFeedTitleViewHolder) == true) goto L44;
        r5.a.remove(r6);
        if (r6.getAdapterPosition() > r5.d) goto L8;
        r5.d = r6.getAdapterPosition() - 1;
    L8:
        r5.j.remove(r6);
        if (r5.o.f == false) goto L24;
        ECHybridListItemVO r0 = r6.c;
        if (r0 == null) goto L13;
        r0.N = System.currentTimeMillis();
    L13:
        ECHybridListItemVO r1 = r6.c;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.w == true) goto L38;
        JSONObject r7 = r5.i(r6);
        if (r7 == null) goto L21;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r7);
    L21:
        if (r5.a.isEmpty() == false) goto L39;
        r5.l(r5.b, System.currentTimeMillis());
        return;
    L39:
        return;
    L38:
        return;
    L24:
        if (r5.k.remove(r6) == false) goto L45;
        ECHybridListItemVO r2 = r6.c;
        if (r2 == null) goto L29;
        r2.N = System.currentTimeMillis();
    L29:
        ECHybridListItemVO r3 = r6.c;
        if (r3 != null) goto L32;
        return;
    L32:
        if (r3.w == true) goto L42;
        JSONObject r8 = r5.i(r6);
        if (r8 == null) goto L43;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r8);
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    }

    public final void l(long r12, long r14) {
        this.b = 0;
        if (r12 > 0) goto L5;
        return;
    L5:
        if (r14 > 0) goto L7;
        return;
    L7:
        if ((r14 - r12) < 100) goto L13;
        BuildersKt.launch$default(this.o.c, Dispatchers.getDefault(), null, new EventExposureTime$gulShowReport$1(this, r12, r14, null), 2, null);
        return;
    }

    public final void q(String r14, int r15, int r16, String r17, String r18) {
        BuildersKt.launch$default(this.o.c, Dispatchers.getDefault(), null, new EventExposureTime$reportRepeat$1(this, r15, r16, r17, r18, r14, null), 2, null);
    }
}
