package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.app.Activity;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiAnchorContentStruct;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiItemAnchorInfo;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiItemAnchorTag;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiTradeGoodsLifeAnchorSuffixStruct;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiTradeGoodsLifeStruct;
import com.bytedance.awemeopen.bizmodels.feed.poi.t;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LocalLifeAnchorElement extends BaseElement<p, q, tz3.a, jz3.a> {
    public static final /* synthetic */ int z = 0;
    public final Activity g;
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public r14.c n;
    public s14.d o;
    public boolean p;
    public r14.c q;
    public long r;
    public long s;
    public long t;
    public boolean u;
    public boolean v;
    public final c w;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.b x;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.c y;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final Map<String, String> k;
        public final boolean l;
        public final JSONObject m;
        public final String n;
        public final int o;
        public final String p;
        public final String q;
        public final String r;
        public final String s;
        public final boolean t;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L68;
            return false;
        L68:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r0v39, types: [int] */
        /* JADX WARN: Type inference failed for: r1v21, types: [int] */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            int r0 = ((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
            Map<String, String> r1 = this.k;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.l;
            ?? r6 = 1;
            ?? r7 = r5;
            if (r5 == false) goto L9;
            r7 = 1;
        L9:
            int r8 = (r4 + r7) * 31;
            JSONObject r9 = this.m;
            if (r9 == null) goto L13;
            r2 = r9.hashCode();
        L13:
            int r10 = (((((((((((((r8 + r2) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31;
            boolean r11 = this.t;
            if (r11 == true) goto L18;
            r6 = r11;
        L18:
            return r10 + r6;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "LifeAnchorReportParams(requestId=" + this.a + ", authorId=" + this.b + ", groupId=" + this.c + ", hostGroupId=" + this.d + ", followStatus=" + this.e + ", anchorId=" + this.f + ", logExtra=" + this.g + ", enterFrom=" + this.h + ", hostEnterFrom=" + this.i + ", pageName=" + this.j + ", poiReportParams=" + this.k + ", isCardMode=" + this.l + ", hostExtraParams=" + this.m + ", anchorType=" + this.n + ", poiType=" + this.o + ", anchorIdReal=" + this.p + ", anchorTypeReal=" + this.q + ", enterFromReal=" + this.r + ", enterMethodReal=" + this.s + ", overrideAnchorInfo=" + this.t + ')';
        }

        public b(String r17, String r18, String r19, String r20, int r21, String r22, String r23, String r24, String r25, Map r26, boolean r27, JSONObject r28, String r29, int r30, String r31, String r32, String r33, boolean r34) {
            Intrinsics.checkNotNullParameter(r17, "requestId");
            Intrinsics.checkNotNullParameter(r18, "authorId");
            Intrinsics.checkNotNullParameter(r19, "groupId");
            Intrinsics.checkNotNullParameter(r20, "hostGroupId");
            Intrinsics.checkNotNullParameter(r22, "anchorId");
            Intrinsics.checkNotNullParameter(r23, "logExtra");
            Intrinsics.checkNotNullParameter(r24, "enterFrom");
            Intrinsics.checkNotNullParameter(r25, "hostEnterFrom");
            Intrinsics.checkNotNullParameter("", "pageName");
            Intrinsics.checkNotNullParameter(r29, "anchorType");
            Intrinsics.checkNotNullParameter(r31, "anchorIdReal");
            Intrinsics.checkNotNullParameter(r32, "anchorTypeReal");
            Intrinsics.checkNotNullParameter(r33, "enterFromReal");
            Intrinsics.checkNotNullParameter("click_label", "enterMethodReal");
            this.a = r17;
            this.b = r18;
            this.c = r19;
            this.d = r20;
            this.e = r21;
            this.f = r22;
            this.g = r23;
            this.h = r24;
            this.i = r25;
            this.j = "";
            this.k = r26;
            this.l = r27;
            this.m = r28;
            this.n = r29;
            this.o = r30;
            this.p = r31;
            this.q = r32;
            this.r = r33;
            this.s = "click_label";
            this.t = r34;
        }
    }

    public static final class c implements FeedSeekBarHelper.c {
        public final /* synthetic */ LocalLifeAnchorElement a;

        public c(LocalLifeAnchorElement r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.c
        public final void a(float r9) {
            LocalLifeAnchorElement r0 = this.a;
            if (r0.m == false) goto L5;
            return;
        L5:
            if (Float.isNaN(r9) == false) goto L7;
            return;
        L7:
            if (Float.isInfinite(r9) == true) goto L75;
            r14.c r1 = r0.v(r0.n);
            if (r1 == null) goto L66;
            s14.d r2 = r1.d();
            boolean r3 = true;
            int r4 = 0;
            if (r2 == null) goto L19;
            Integer r5 = r2.getType();
            if (r5 == null) goto L19;
            if (r5.intValue() != 2) goto L19;
            boolean r6 = true;
        L21:
            if (r6 == false) goto L36;
            t r7 = r1.C();
            if (r7 == null) goto L67;
            com.bytedance.awemeopen.bizmodels.feed.poi.k r8 = r7.e();
            if (r8 == null) goto L68;
            com.bytedance.awemeopen.bizmodels.feed.poi.m r10 = r8.a();
            if (r10 == null) goto L69;
            PoiItemAnchorInfo r11 = r10.a();
            if (r11 == null) goto L70;
            Video r12 = r1.P();
            if (r12 == null) goto L34;
            r4 = r12.getDuration();
        L34:
            if (MathKt.roundToInt(r4 * (r9 * 0.01f)) < r11.getExtendTime()) goto L71;
            r0.u(r1);
            return;
        L71:
            return;
        L70:
            return;
        L69:
            return;
        L68:
            return;
        L67:
            return;
        L36:
            if (r2 == null) goto L43;
            Integer r13 = r2.getType();
            if (r13 == null) goto L43;
            if (r13.intValue() != 13010) goto L43;
            boolean r14 = true;
        L44:
            if (r14 == true) goto L54;
            if (r2 == null) goto L52;
            Integer r15 = r2.getType();
            if (r15 == null) goto L52;
            if (r15.intValue() != 13012) goto L52;
        L53:
            if (r3 == true) goto L54;
            return;
        L52:
            r3 = false;
        L54:
            PoiTradeGoodsLifeStruct r16 = r1.D();
            if (r16 == null) goto L76;
            Video r17 = r1.P();
            if (r17 == null) goto L61;
            r4 = r17.getDuration();
        L61:
            if (MathKt.roundToInt(r4 * (r9 * 0.01f)) < r16.getMinorExtendTime()) goto L74;
            r0.u(r1);
            return;
        L74:
            return;
        L76:
            return;
        L43:
            r14 = false;
        L19:
            r6 = false;
            goto L21
        L66:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.m = false;
        this.o = null;
        this.i = false;
        this.q = null;
        this.s = 0;
        this.r = 0;
        h().b.b(new q.a(0));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new p();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new q();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new m(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        this.h.removePlayDurationChangeListener(this.w);
        if (this.u == false) goto L13;
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r0 = this.h.getSlidesProgressInfo();
        if (r0 == null) goto L7;
        r0.removeObserver(this.x);
    L7:
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r1 = this.h.getSlidesProgressInfo();
        if (r1 == null) goto L11;
        r1.setValue(null);
    L11:
        this.u = false;
    L13:
        if (this.v == false) goto L22;
        MutableLiveData<Integer> r2 = this.h.getSlidesPlayCompletedPosition();
        if (r2 == null) goto L17;
        r2.removeObserver(this.y);
    L17:
        MutableLiveData<Integer> r3 = this.h.getSlidesPlayCompletedPosition();
        if (r3 == null) goto L21;
        r3.setValue(null);
    L21:
        this.v = false;
    L22:
        this.q = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        r14.c r1 = v(this.n);
        if (r1 == null) goto L7;
        b r2 = r(r1);
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = r2.a;
        String r6 = r2.b;
        String r7 = r2.c;
        String r8 = r2.d;
        int r9 = r2.e;
        String r10 = r2.f;
        String r11 = r2.g;
        String r12 = r2.h;
        String r13 = r2.i;
        String r14 = r2.j;
        Map<String, String> r15 = r2.k;
        boolean r16 = r2.l;
        JSONObject r17 = r2.m;
        t24.a.a.b(r4, r5, r6, r7, r8, r9, r10, r11, null, r12, r13, r14, r2.n, r2.o, r16, r15, r17, r2.p, r2.q, r2.r, r2.s, r2.t, 4352);
        t24.a r18 = b14.a.a(t24.a.class);
        String r19 = r2.a;
        String r20 = r2.b;
        String r21 = r2.c;
        String r22 = r2.d;
        int r23 = r2.e;
        String r24 = r2.f;
        String r110 = r2.g;
        String r111 = r2.h;
        String r112 = r2.i;
        String r113 = r2.j;
        Map<String, String> r25 = r2.k;
        boolean r26 = r2.l;
        JSONObject r27 = r2.m;
        t24.a.a.i(r18, r19, r20, r21, r22, r23, r24, r110, null, r111, r112, r113, r2.n, r2.o, r26, r25, r27, r2.p, r2.q, r2.r, r2.s, r2.t, 4352);
    L7:
        if (z() == false) goto L23;
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r28 = this.h.getSlidesProgressInfo();
        if (r28 == null) goto L12;
        r28.setValue(null);
    L12:
        MutableLiveData<Integer> r29 = this.h.getSlidesPlayCompletedPosition();
        if (r29 == null) goto L16;
        r29.setValue(null);
    L16:
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r30 = this.h.getSlidesProgressInfo();
        if (r30 == null) goto L19;
        r30.observeForever(this.x);
    L19:
        MutableLiveData<Integer> r31 = this.h.getSlidesPlayCompletedPosition();
        if (r31 == null) goto L22;
        r31.observeForever(this.y);
    L22:
        this.u = true;
        this.v = true;
        return;
    L23:
        this.h.addPlayDurationChangeListener(this.w);
    }

    public final pz3.d x() {
        return (pz3.d) this.l.getValue();
    }

    public final boolean z() {
        int r0 = com.bytedance.awemeopen.bizmodels.user.d.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.n) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!w(v(this.n)).isEmpty()) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        p r0 = g();
        Observer<Unit> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.c;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public static List w(r14.c r3) {
        if (r3 == null) goto L4;
        s14.d r0 = r3.d();
        if (r0 == null) goto L8;
        Integer r1 = r0.getType();
        if (r1 != null) goto L13;
    L23:
        if (r1 != null) goto L26;
    L28:
        if (r1 != null) goto L31;
    L33:
        boolean r2 = false;
    L34:
        if (r2 == false) goto L38;
        PoiTradeGoodsLifeStruct r4 = r3.D();
        if (r4 == null) goto L38;
        List r5 = r4.getMinorTags();
    L39:
        if (r5 == null) goto L41;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L44:
        if (r7.hasNext() == false) goto L48;
        PoiAnchorContentStruct r8 = (PoiAnchorContentStruct) r7.next();
        int r9 = MinorTag.i;
        MinorTag r10 = MinorTag.Companion.a(r8);
        if (r10 == null) goto L44;
        r6.add(r10);
        goto L44
    L48:
        return r6;
    L41:
        return CollectionsKt.emptyList();
    L38:
        r5 = null;
        goto L39
    L31:
        if (r1.intValue() != 13012) goto L33;
    L32:
        r2 = true;
        goto L34
    L26:
        if (r1.intValue() != 13010) goto L28;
    L13:
        if (r1.intValue() != 2) goto L23;
        t r11 = r3.C();
        if (r11 == null) goto L38;
        com.bytedance.awemeopen.bizmodels.feed.poi.k r12 = r11.e();
        if (r12 == null) goto L38;
        com.bytedance.awemeopen.bizmodels.feed.poi.m r13 = r12.a();
        if (r13 == null) goto L38;
        PoiItemAnchorInfo r14 = r13.a();
        if (r14 == null) goto L38;
        r5 = r14.getMinorTags();
        goto L39
    L8:
        return CollectionsKt.emptyList();
    L4:
        return CollectionsKt.emptyList();
    }

    public final void A(jz3.a r13) {
        r14.c r14 = r13.a;
        this.n = r14;
        r14.c r15 = v(r14);
        q.b r0 = null;
        if (r15 == null) goto L96;
        s14.d r1 = r15.d();
        if (r1 == null) goto L96;
        Integer r2 = r1.getType();
        boolean r5 = false;
        if (r2 != null) goto L11;
    L30:
        if (r5 == true) goto L96;
        Integer r3 = r1.getType();
        if (r3 != null) goto L36;
    L64:
        Integer r4 = r1.getType();
        if (r4 != null) goto L68;
    L69:
        Integer r6 = r1.getType();
        if (r6 == null) goto L96;
        if (r6.intValue() != 13012) goto L96;
    L74:
        PoiTradeGoodsLifeStruct r7 = r15.D();
        if (r7 == null) goto L96;
        String r8 = r15.c();
        String r9 = r1.g();
        if (r9 != null) goto L80;
        String r10 = "";
    L81:
        String r11 = r1.f();
        if (r11 != null) goto L84;
        String r12 = "";
    L85:
        PoiTradeGoodsLifeAnchorSuffixStruct r16 = r7.getAnchorSuffix();
        if (r16 == null) goto L91;
        String r17 = r16.getContent();
        if (r17 == null) goto L91;
        String r18 = r17;
    L92:
        s14.d r19 = r15.d();
        if (r19 == null) goto L95;
        r0 = r19.b();
    L95:
        Integer r110 = r1.getType();
        Intrinsics.checkNotNull(r110);
        r0 = new q.b(r8, r12, r10, r18, r0, r110.intValue());
    L91:
        r18 = "";
        goto L92
    L84:
        r12 = r11;
        goto L85
    L80:
        r10 = r9;
        goto L81
    L68:
        if (r4.intValue() == 13010) goto L74;
    L36:
        if (r3.intValue() != 2) goto L64;
        t r20 = r15.C();
        if (r20 == null) goto L64;
        com.bytedance.awemeopen.bizmodels.feed.poi.k r21 = r20.e();
        if (r21 == null) goto L64;
        com.bytedance.awemeopen.bizmodels.feed.poi.m r22 = r21.a();
        if (r22 == null) goto L64;
        PoiItemAnchorInfo r23 = r22.a();
        if (r23 == null) goto L64;
        String r24 = r15.c();
        String r111 = r20.f();
        if (r111 != null) goto L48;
        String r25 = "";
    L49:
        String r112 = r23.getPoiType();
        if (r112 != null) goto L52;
        String r26 = "";
    L53:
        PoiItemAnchorTag r113 = r23.getSuffix();
        if (r113 == null) goto L59;
        String r114 = r113.getContent();
        if (r114 == null) goto L59;
        String r27 = r114;
    L60:
        t14.a r115 = r23.getPoiIconUrl();
        if (r115 != null) goto L63;
        r115 = r20.c();
    L63:
        t14.a r116 = r115;
        Integer r117 = r1.getType();
        Intrinsics.checkNotNull(r117);
        r0 = new q.b(r24, r25, r26, r27, r116, r117.intValue());
    L59:
        r27 = "";
        goto L60
    L52:
        r26 = r112;
        goto L53
    L48:
        r25 = r111;
        goto L49
    L11:
        if (r2.intValue() != 2) goto L30;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.n == true) goto L30;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L24
        String r29 = r1.d();     // Catch: Throwable -> L24
        if (r29 != null) goto L20;
        r29 = "";
    L20:
        if (new JSONObject(r29).optInt("is_checkin_anchor") != 1) goto L22;
        r5 = true;
    L22:
        Object r30 = Result.constructor-impl(Boolean.valueOf(r5));     // Catch: Throwable -> L24
    L26:
        Boolean r31 = Boolean.FALSE;
        if (Result.isFailure-impl(r30) == false) goto L29;
        r30 = r31;
    L29:
        r5 = ((Boolean) r30).booleanValue();
    L24:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L96:
        if (r0 != null) goto L99;
        j();
        return;
    L99:
        q r118 = h();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r0, "data");
        r118.a.b(r0);
        p();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r5) {
        jz3.a r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        this.m = false;
        this.q = null;
        h().b.b(new q.a(0));
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L13;
        s14.d r2 = r6.c;
        if (r2 == null) goto L13;
        this.o = r2;
        r14.c r3 = v(r6.a);
        if (r3 == null) goto L13;
        if (r3.R() == false) goto L13;
        if (((com.bytedance.awemeopen.common.service.locallife.a) this.k.getValue()).isAvailable() == false) goto L13;
        this.i = true;
        A(r6);
        return;
    L13:
        this.o = null;
        this.i = false;
        if (r6.a.R() == true) goto L16;
    L19:
        j();
        return;
    L16:
        if (((com.bytedance.awemeopen.common.service.locallife.a) this.k.getValue()).isAvailable() == false) goto L19;
        A(r6);
    }

    public final b r(r14.c r24) {
        FeedPageConfig r1 = this.h.getPageConfig();
        String r20 = this.h.sceneId();
        a0 r4 = r24.d;
        if (r4 == null) goto L5;
        String r5 = r4.a();
    L7:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        User r7 = r24.f();
        if (r7 == null) goto L13;
        String r8 = r7.u();
        if (r8 == null) goto L13;
    L14:
        String r9 = r24.c();
        String r10 = r24.r().c;
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        User r11 = r24.f();
        if (r11 == null) goto L20;
        int r12 = r11.m();
    L21:
        t r13 = r24.C();
        if (r13 == null) goto L25;
        String r14 = r13.d();
        if (r14 == null) goto L25;
    L26:
        s14.d r15 = r24.d();
        if (r15 == null) goto L30;
        String r16 = r15.d();
        if (r16 == null) goto L30;
    L31:
        String r17 = r1.getHostEnterFrom();
        Map r18 = r24.b0();
        boolean r19 = r1.isCardMode();
        JSONObject r2 = r1.getHostExtraParams();
        s14.d r110 = r24.d();
        if (r110 == null) goto L43;
        Integer r111 = r110.getType();
        if (r111 == null) goto L43;
        int r6 = r111.intValue();
        if (r6 != 13010) goto L38;
        String r3 = "poi_product";
    L42:
        String r112 = r3;
    L44:
        s14.d r21 = r24.d();
        if (r21 == null) goto L49;
        Integer r22 = r21.getType();
        if (r22 == null) goto L49;
        int r113 = r22.intValue();
    L50:
        s14.d r23 = r24.d();
        if (r23 == null) goto L53;
        String r25 = r23.c();
    L54:
        if (r25 != null) goto L56;
        String r114 = "";
    L57:
        s14.d r26 = r24.d();
        if (r26 == null) goto L62;
        Integer r27 = r26.getType();
        if (r27 == null) goto L62;
        String r28 = r27.toString();
    L63:
        if (r28 != null) goto L65;
        String r29 = "";
    L66:
        String r30 = r8;
        String r31 = r10;
        int r32 = r12;
        String r33 = r14;
        String r115 = r16;
        int r116 = r113;
        String r117 = r114;
        String r118 = r29;
        return new b(r5, r30, r9, r31, r32, r33, r115, r20, r17, r18, r19, r2, r112, r116, r117, r118, r20, this.i);
    L65:
        r29 = r28;
    L62:
        r28 = null;
        goto L63
    L56:
        r114 = r25;
        goto L57
    L53:
        r25 = null;
    L49:
        r113 = 2;
        goto L50
    L38:
        if (r6 == 13012) goto L40;
        r3 = "poi";
        goto L42
    L40:
        r3 = "poi_combo";
    L43:
        r112 = "";
    L30:
        r16 = "";
    L25:
        r14 = "";
        goto L26
    L20:
        r12 = 0;
    L13:
        r8 = "";
        goto L14
    L5:
        r5 = null;
        goto L7
    }

    public final void u(r14.c r5) {
        if (this.m == false) goto L5;
        return;
    L5:
        List r0 = w(r5);
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        this.m = true;
        q r2 = h();
        q.a r3 = new q.a(r5.c(), true, r0);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "data");
        r2.b.b(r3);
    }

    public final r14.c v(r14.c r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (((Boolean) this.j.getValue()).booleanValue() == true) goto L8;
        return r2;
    L8:
        if (this.o == null) goto L16;
        r14.c r0 = this.q;
        if (r0 == null) goto L13;
        return r0;
    L13:
        r14.c r3 = r2.b();
        r3.e0(this.o);
        this.q = r3;
        return r3;
    L16:
        return r2;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.b] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.c] */
    public LocalLifeAnchorElement(Activity r2, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.j = LazyKt.lazy(LocalLifeAnchorElement$shouldUseExternalAnchor$2.INSTANCE);
        this.k = LazyKt.lazy(LocalLifeAnchorElement$localLifeService$2.INSTANCE);
        this.l = LazyKt.lazy(LocalLifeAnchorElement$videoScalingParams$2.INSTANCE);
        this.w = new c(this);
        this.x = new com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.b(this);
        this.y = new com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.c(this);
    }

    public final JSONObject t(r14.c r18, s14.d r19) {
        boolean r1 = true;
        if (r19 == null) goto L10;
        Integer r3 = r19.getType();
        if (r3 == null) goto L10;
        if (r3.intValue() != 13010) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L23;
        if (r19 == null) goto L19;
        Integer r5 = r19.getType();
        if (r5 == null) goto L19;
        if (r5.intValue() != 13012) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L23;
        boolean r7 = false;
    L24:
        Boolean r8 = null;
        String r9 = null;
        if (r7 == false) goto L39;
        Map r2 = r18.b0();
        if (r2 != null) goto L29;
        r2 = MapsKt.emptyMap();
    L29:
        JSONObject r10 = new JSONObject();
        q(r10, "detail_enter_page", this.h.getPageConfig().getHostEnterFrom());
        q(r10, "detail_enter_method", "click_label");
        q(r10, "group_id", r18.c());
        String r11 = (String) r2.get("author_id");
        if (r11 != null) goto L34;
        User r12 = r18.f();
        if (r12 == null) goto L35;
        r9 = r12.u();
    L35:
        q(r10, "author_id", r9);
        String r13 = (String) r2.get("sale_channel");
        if (r13 != null) goto L38;
        r13 = "online_recommend.product_anchor.default";
    L38:
        q(r10, "sale_channel", r13);
        q(r10, "recommend_log_id", (String) r2.get("recommend_log_id"));
        return r10;
    L34:
        r9 = r11;
        goto L35
    L39:
        Map r14 = r18.b0();
        if (r14 != null) goto L42;
        r14 = MapsKt.emptyMap();
    L42:
        JSONObject r15 = new JSONObject();
        String r16 = this.h.getPageConfig().getHostEnterFrom();
        String r17 = (String) r14.get("life_anchor_type");
        if (r17 != null) goto L45;
        r17 = "poi";
    L45:
        s(r15, "life_anchor_type", r17);
        String r110 = (String) r14.get("anchor_type");
        if (r110 != null) goto L48;
        r110 = "poi";
    L48:
        s(r15, "anchor_type", r110);
        s(r15, "poi_enter_page", r16);
        s(r15, "poi_enter_method", "click_label");
        s(r15, "detail_enter_page", r16);
        s(r15, "detail_enter_method", "click_label");
        s(r15, "group_id", r18.c());
        String r20 = (String) r14.get("author_id");
        if (r20 != null) goto L54;
        User r21 = r18.f();
        if (r21 == null) goto L53;
        r20 = r21.u();
        goto L54
    L53:
        r20 = null;
    L54:
        s(r15, "author_id", r20);
        String r22 = (String) r14.get("poi_id");
        if (r22 != null) goto L60;
        t r23 = r18.C();
        if (r23 == null) goto L59;
        r22 = r23.d();
        goto L60
    L59:
        r22 = null;
    L60:
        s(r15, "poi_id", r22);
        String r24 = (String) r14.get("poi_backend_type");
        if (r24 != null) goto L66;
        t r25 = r18.C();
        if (r25 == null) goto L65;
        r24 = r25.a();
        goto L66
    L65:
        r24 = null;
    L66:
        s(r15, "poi_backend_type", r24);
        s(r15, "poi_device_samecity", (String) r14.get("poi_device_samecity"));
        s(r15, "recommend_log_id", (String) r14.get("recommend_log_id"));
        String r26 = (String) r14.get("life_publish_type");
        if (r26 != null) goto L69;
        r26 = "promotion";
    L69:
        s(r15, "life_publish_type", r26);
        String r27 = (String) r14.get("sale_channel");
        if (r27 != null) goto L72;
        r27 = "online_recommend.poi_anchor.default";
    L72:
        s(r15, "sale_channel", r27);
        s(r15, "is_commerce_intention", (String) r14.get("is_commerce_intention"));
        s(r15, "has_service", (String) r14.get("has_service"));
        t r28 = r18.C();
        if (r28 == null) goto L106;
        com.bytedance.awemeopen.bizmodels.feed.poi.k r29 = r28.e();
        if (r29 == null) goto L106;
        com.bytedance.awemeopen.bizmodels.feed.poi.m r30 = r29.a();
        if (r30 == null) goto L106;
        PoiItemAnchorInfo r31 = r30.a();
        if (r31 == null) goto L106;
        CharSequence r32 = (CharSequence) r14.get("is_commerce_intention");
        if (r32 != null) goto L83;
    L86:
        boolean r33 = true;
    L87:
        if (r33 == false) goto L89;
        r8 = Boolean.valueOf(r31.isCommerceIntention());
    L89:
        if (r8 != null) goto L91;
    L93:
        CharSequence r34 = (CharSequence) r14.get("has_service");
        if (r34 != null) goto L96;
    L99:
        if (r1 == false) goto L106;
        if (r31.getHasMpSpu() == false) goto L103;
        String r35 = "true";
    L104:
        r15.put("has_service", r35);
        goto L106
    L103:
        r35 = "false";
        goto L104
    L96:
        if (StringsKt.isBlank(r34) == true) goto L99;
        r1 = false;
        goto L99
    L91:
        if (r15.has("is_commerce_intention") == true) goto L93;
        r15.put("is_commerce_intention", r8.booleanValue() ? 1 : 0);
        goto L93
    L83:
        if (StringsKt.isBlank(r32) == true) goto L86;
        r33 = false;
    L106:
        return r15;
    L19:
        r6 = false;
    L23:
        r7 = true;
    L10:
        r4 = false;
        goto L11
    }

    public static final void q(JSONObject r1, String r2, String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (r1.has(r2) == true) goto L14;
        r1.put(r2, r3);
        return;
    L14:
        return;
    L4:
        if (StringsKt.isBlank(r3) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static final void s(JSONObject r1, String r2, String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (r1.has(r2) == true) goto L14;
        r1.put(r2, r3);
        return;
    L14:
        return;
    L4:
        if (StringsKt.isBlank(r3) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static String y(Uri r3, Map r4, r14.c r5) {
        String r6 = (String) r4.get("author_id");
        if (r6 != null) goto L5;
    L9:
        r6 = UriProtector.getQueryParameter(r3, "author_id");
        if (r6 != null) goto L12;
    L14:
        r6 = null;
    L15:
        if (r6 != null) goto L31;
        String r7 = UriProtector.getQueryParameter(r3, "auth_openid");
        if (r7 != null) goto L19;
    L21:
        r7 = null;
    L22:
        if (r7 != null) goto L35;
        User r8 = r5.f();
        if (r8 == null) goto L32;
        r7 = r8.u();
        if (r7 != null) goto L28;
        return null;
    L28:
        if ((!StringsKt.isBlank(r7)) == true) goto L35;
        return null;
    L32:
        return null;
    L35:
        return r7;
    L19:
        if ((!StringsKt.isBlank(r7)) == false) goto L21;
    L31:
        return r6;
    L12:
        if ((!StringsKt.isBlank(r6)) == false) goto L14;
    L5:
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 != null) goto L31;
        goto L9
    }
}
