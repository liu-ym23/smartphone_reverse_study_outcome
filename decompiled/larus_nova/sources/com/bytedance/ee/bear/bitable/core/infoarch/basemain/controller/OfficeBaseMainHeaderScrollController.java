package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainInfoArchViewHolder;
import com.bytedance.ee.bear.bitable.core.infoarch.basemain.view.OfficeBaseMainTopLayout;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.view.NestedScrollWebViewV2;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeBaseMainHeaderScrollController {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f210317y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OfficeBaseMainInfoArchViewHolder f210318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f210319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f210320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TitleBar f210321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f210322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f210323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f210324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f210325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f210326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f210327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f210328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f210329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f210330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f210331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f210332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f210333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f210334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f210335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f210336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f210337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f210338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f210339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function1<Integer, Unit> f210340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f210341x;

    public final class Binding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeBaseMainScrollContentType f210342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f210343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<RecyclerView> f210344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<WebView, t> f210345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<NestedScrollWebViewV2> f210346e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<wr4.c> f210347f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<View, Runnable> f210348g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f210349h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f210350i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f210351j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ReleaseDirection f210352k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ReleaseDirection f210353l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f210354m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f210355n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f210356o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f210357p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ReleaseDirection f210358q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f210359r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f210360s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f210361t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public RecyclerView f210362u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final OfficeBaseMainHeaderScrollController$Binding$recyclerTouchListener$1 f210363v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final OfficeBaseMainHeaderScrollController$Binding$recyclerScrollListener$1 f210364w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210365x;

        public final void b() {
            this.f210352k = null;
            this.f210353l = null;
            this.f210354m = 0.0f;
            this.f210355n = 0;
            this.f210358q = null;
            this.f210359r = false;
            this.f210360s = false;
        }

        public static boolean e(RecyclerView r100) {
            RecyclerView.LayoutManager r101 = r100.getLayoutManager();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.canScrollVertically() != true) goto L7;
            return true;
        }

        public final void f(boolean r100) {
            this.f210361t = r100;
            Iterator<T> r101 = this.f210347f.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((wr4.c) r101.next()).c(r100);
            goto L4
        }

        public static void c(View r100, Function1 r101) {
            if ((r100 instanceof RecyclerView) == false) goto L5;
        L6:
            r101.invoke(r100);
        L8:
            if ((r100 instanceof ViewGroup) == true) goto L10;
            return;
        L10:
            ViewGroup r102 = (ViewGroup) r100;
            int r103 = r102.getChildCount();
            int r104 = 0;
        L11:
            if (r104 >= r103) goto L13;
            c(r102.getChildAt(r104), r101);
            r104 = r104 + 1;
            goto L11
        L13:
            return;
        L5:
            if ((r100 instanceof WebView) == false) goto L8;
            goto L6
        }

        public final void d(MotionEvent r100, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.getActionMasked();
            boolean r102 = false;
            boolean r103 = true;
            if (r101 != 0) goto L5;
            this.f210349h = r100.getRawX();
            this.f210350i = r100.getRawY();
            this.f210351j = r100.getRawY();
            b();
            this.f210357p = true;
            this.f210356o = false;
            OfficeBaseMainHeaderScrollController r104 = this.f210365x;
            String r111 = "Touch DOWN type:" + this.f210342a + " isAtTop:" + r110;
            int r105 = OfficeBaseMainHeaderScrollController.f210317y;
            r104.getClass();
            OfficeBaseMainHeaderScrollController.j(r111);
            return;
        L5:
            if (r101 != 1) goto L7;
        L44:
            this.f210357p = false;
            ReleaseDirection r106 = this.f210352k;
            if (r106 != null) goto L49;
            r106 = this.f210358q;
            if (r106 != null) goto L49;
            r106 = this.f210353l;
        L49:
            OfficeBaseMainHeaderScrollController r107 = this.f210365x;
            String r108 = "Touch RELEASE type:" + this.f210342a + " action:" + r100.getActionMasked() + " direction:" + r106 + " lastTouch:" + this.f210352k + " pendingIdle:" + this.f210358q + " lastScroll:" + this.f210353l + " touchMoved:" + this.f210356o + " isAtTop:" + r110 + " pendingReleaseAtTop:" + this.f210359r + " lastKnownAtTop:" + this.f210361t + " pendingTopReached:" + this.f210360s;
            int r109 = OfficeBaseMainHeaderScrollController.f210317y;
            r107.getClass();
            OfficeBaseMainHeaderScrollController.j(r108);
            if (r106 == null) goto L69;
            if (this.f210356o == false) goto L54;
        L57:
            OfficeBaseMainHeaderScrollController r112 = this.f210365x;
            OfficeBaseMainScrollContentType r113 = this.f210342a;
            if (r110 == false) goto L60;
        L67:
            r112.e(r106, r113, r103);
        L71:
            b();
            this.f210356o = false;
            this.f210362u = null;
            return;
        L60:
            if (this.f210359r == true) goto L67;
            if (this.f210361t == true) goto L67;
            if (this.f210360s == true) goto L67;
            r103 = false;
            goto L67
        L54:
            if (this.f210358q != null) goto L57;
            if (this.f210353l != null) goto L57;
        L69:
            if (this.f210360s == false) goto L71;
            OfficeBaseMainHeaderScrollController.a(this.f210365x, this.f210342a);
            goto L71
        L7:
            if (r101 != 2) goto L9;
            float r114 = r100.getRawY() - this.f210351j;
            if (Math.abs(r114) <= 0.0f) goto L38;
            float r115 = this.f210354m;
            if (r115 != 0.0f) goto L16;
            boolean r116 = true;
        L17:
            if (r116 == false) goto L19;
        L26:
            r114 = r114 + r115;
        L27:
            this.f210354m = r114;
            if (Math.abs(r114) < this.f210365x.f210320c) goto L38;
            if (this.f210354m >= 0.0f) goto L33;
            ReleaseDirection r117 = ReleaseDirection.COLLAPSE;
        L35:
            if (r117 == this.f210352k) goto L37;
            OfficeBaseMainHeaderScrollController.j("Touch direction type:" + this.f210342a + " dy:" + this.f210354m + " direction:" + r117);
        L37:
            this.f210352k = r117;
            this.f210354m = 0.0f;
            goto L38
        L33:
            r117 = ReleaseDirection.EXPAND;
            goto L35
        L19:
            if (r115 <= 0.0f) goto L21;
            boolean r118 = true;
        L23:
            if (r114 <= 0.0f) goto L25;
            r102 = true;
        L25:
            if (r118 != r102) goto L27;
        L21:
            r118 = false;
            goto L23
        L16:
            r116 = false;
        L38:
            float r119 = r100.getRawX() - this.f210349h;
            float r120 = r100.getRawY() - this.f210350i;
            if (Math.abs(r120) > this.f210365x.f210320c) goto L41;
        L43:
            this.f210351j = r100.getRawY();
            return;
        L41:
            if (Math.abs(r120) <= Math.abs(r119)) goto L43;
            this.f210356o = true;
            goto L43
        L9:
            if (r101 == 3) goto L44;
        }

        public final void g(int r100, String r101) {
            int r102 = this.f210355n;
            if (r102 == 0) goto L12;
            boolean r103 = true;
            if (r102 <= 0) goto L7;
            boolean r104 = true;
        L8:
            if (r100 > 0) goto L11;
            r103 = false;
        L11:
            if (r104 == r103) goto L12;
        L13:
            this.f210355n = r100;
            if (Math.abs(r100) >= this.f210365x.f210320c) goto L17;
            return;
        L17:
            if (this.f210355n <= 0) goto L19;
            ReleaseDirection r105 = ReleaseDirection.COLLAPSE;
        L21:
            if (r105 == this.f210353l) goto L23;
            OfficeBaseMainHeaderScrollController.j(r101 + " scrollDirection type:" + this.f210342a + " dy:" + this.f210355n + " direction:" + r105);
        L23:
            this.f210353l = r105;
            this.f210355n = 0;
            return;
        L19:
            r105 = ReleaseDirection.EXPAND;
            goto L21
        L7:
            r104 = false;
        L12:
            r100 = r100 + r102;
            goto L13
        }

        /* JADX WARN: Type inference failed for: r3v7, types: [com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.OfficeBaseMainHeaderScrollController$Binding$recyclerTouchListener$1] */
        /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller.OfficeBaseMainHeaderScrollController$Binding$recyclerScrollListener$1] */
        public Binding(final OfficeBaseMainHeaderScrollController r100, OfficeBaseMainScrollContentType r101, View r102) {
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, RootDescription.ROOT_ELEMENT);
            this.f210365x = r100;
            this.f210342a = r101;
            this.f210343b = r102;
            this.f210344c = new LinkedHashSet();
            this.f210345d = new LinkedHashMap();
            this.f210346e = new LinkedHashSet();
            this.f210347f = new ArrayList();
            this.f210348g = new LinkedHashMap();
            this.f210361t = true;
            this.f210363v = new OfficeBaseMainHeaderScrollController$Binding$recyclerTouchListener$1(this);
            this.f210364w = new OfficeBaseMainHeaderScrollController$Binding$recyclerScrollListener$1(this, r100);
        }

        public static final void a(Binding r100, RecyclerView r101, MotionEvent r102) {
            r100.getClass();
            if (e(r101) == true) goto L6;
            return;
        L6:
            if (r102.getActionMasked() != 0) goto L9;
            r100.f210362u = r101;
        L9:
            if (r100.f210362u != r101) goto L12;
            r100.d(r102, !r101.canScrollVertically(-1));
            return;
        }
    }

    public final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeBaseMainScrollContentType f210369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210370b;

        public a(OfficeBaseMainHeaderScrollController r100, OfficeBaseMainScrollContentType r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f210370b = r100;
            this.f210369a = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r101, "event");
            c r102 = this.f210370b.f210336s;
            OfficeBaseMainScrollContentType r103 = this.f210369a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "type");
            Intrinsics.checkNotNullParameter(r101, "event");
            Binding r104 = (Binding) ((LinkedHashMap) r102.f210371a).get(r103);
            if (r104 == null) goto L7;
            r104.d(r101, r104.f210361t);
            return false;
        L7:
            return false;
        }
    }

    public static final class b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<OfficeBaseMainScrollContentType, Binding> f210371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210372b;

        public final void b() {
            Iterator r100 = ((LinkedHashMap) this.f210371a).values().iterator();
        L4:
            if (r100.hasNext() == false) goto L10;
            Binding r101 = (Binding) r100.next();
            Iterator r102 = ((LinkedHashMap) r101.f210348g).entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            Map.Entry r103 = (Map.Entry) r102.next();
            ((View) r103.getKey()).removeCallbacks((Runnable) r103.getValue());
            goto L7
        L9:
            ((LinkedHashMap) r101.f210348g).clear();
            r101.b();
            r101.f210357p = false;
            r101.f210356o = false;
            r101.f210362u = null;
            goto L4
        }

        public c(OfficeBaseMainHeaderScrollController r100) {
            this.f210372b = r100;
            this.f210371a = new LinkedHashMap();
        }

        public final void c(OfficeBaseMainScrollContentType r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Binding r101 = this.f210371a.remove(r100);
            if (r101 == null) goto L42;
            Iterator<T> r102 = r101.f210344c.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            RecyclerView r103 = (RecyclerView) r102.next();
            r103.removeOnScrollListener(r101.f210364w);
            r103.removeOnItemTouchListener(r101.f210363v);
            goto L6
        L8:
            r101.f210344c.clear();
            r101.f210362u = null;
            Iterator r104 = ((LinkedHashMap) r101.f210345d).values().iterator();
        L10:
            if (r104.hasNext() == false) goto L20;
            t r105 = (t) r104.next();
            ViewTreeObserver r106 = r105.f210501e;
            if (r106 == null) goto L19;
            if (r106.isAlive() == true) goto L17;
            r106 = null;
        L17:
            if (r106 == null) goto L19;
            r106.removeOnScrollChangedListener(r105.f210502f);
        L19:
            r105.f210501e = null;
            goto L10
        L20:
            ((LinkedHashMap) r101.f210345d).clear();
            Iterator r107 = ((LinkedHashMap) r101.f210348g).entrySet().iterator();
        L22:
            if (r107.hasNext() == false) goto L24;
            Map.Entry r108 = (Map.Entry) r107.next();
            ((View) r108.getKey()).removeCallbacks((Runnable) r108.getValue());
            goto L22
        L24:
            ((LinkedHashMap) r101.f210348g).clear();
            Iterator r109 = ((ArrayList) r101.f210347f).iterator();
        L26:
            if (r109.hasNext() == false) goto L28;
            ((wr4.c) r109.next()).b(false);
            goto L26
        L28:
            ((ArrayList) r101.f210347f).clear();
            Iterator<T> r110 = r101.f210346e.iterator();
        L30:
            if (r110.hasNext() == false) goto L32;
            ((NestedScrollWebViewV2) r110.next()).setNestedScrollStrategy(null);
            goto L30
        L32:
            r101.f210346e.clear();
            return;
        }

        public final void a(OfficeBaseMainScrollContentType r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            c(r100);
            if (r101 != null) goto L5;
            return;
        L5:
            Map<OfficeBaseMainScrollContentType, Binding> r102 = this.f210371a;
            final Binding r103 = new Binding(this.f210372b, r100, r101);
            View r104 = r103.f210343b;
            final OfficeBaseMainHeaderScrollController r105 = r103.f210365x;
            Binding.c(r104, new OfficeBaseMainHeaderScrollController$Binding$attach$1(r103, r105));
            r102.put(r100, r103);
        }
    }

    public final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f210373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f210374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f210375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ReleaseDirection f210376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f210377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f210378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210379g;

        public d(OfficeBaseMainHeaderScrollController r100) {
            this.f210379g = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            int r101 = r110.getActionMasked();
            if (r101 != 0) goto L5;
            this.f210373a = r110.getRawX();
            this.f210374b = r110.getRawY();
            this.f210375c = r110.getRawY();
            this.f210376d = null;
            this.f210377e = 0.0f;
            this.f210378f = false;
            this.f210379g.getClass();
            OfficeBaseMainHeaderScrollController.j("TopTouch DOWN");
        L50:
            return false;
        L5:
            if (r101 != 1) goto L7;
        L44:
            ReleaseDirection r102 = this.f210376d;
            OfficeBaseMainHeaderScrollController r103 = this.f210379g;
            String r111 = "TopTouch RELEASE action:" + r110.getActionMasked() + " direction:" + r102 + " touchMoved:" + this.f210378f;
            r103.getClass();
            OfficeBaseMainHeaderScrollController.j(r111);
            if (this.f210378f == false) goto L48;
            if (r102 == null) goto L48;
            this.f210379g.e(r102, OfficeBaseMainScrollContentType.MAIN_WEB, true);
        L48:
            this.f210376d = null;
            this.f210377e = 0.0f;
            this.f210378f = false;
            goto L50
        L7:
            if (r101 != 2) goto L9;
            float r104 = r110.getRawY() - this.f210375c;
            if (Math.abs(r104) <= 0.0f) goto L38;
            float r105 = this.f210377e;
            if (r105 != 0.0f) goto L16;
            boolean r106 = true;
        L17:
            if (r106 == false) goto L19;
        L27:
            r104 = r104 + r105;
        L28:
            this.f210377e = r104;
            if (Math.abs(r104) < this.f210379g.f210320c) goto L38;
            if (this.f210377e >= 0.0f) goto L33;
            ReleaseDirection r107 = ReleaseDirection.COLLAPSE;
        L35:
            if (r107 == this.f210376d) goto L37;
            OfficeBaseMainHeaderScrollController.j("TopTouch direction dy:" + this.f210377e + " direction:" + r107);
        L37:
            this.f210376d = r107;
            this.f210377e = 0.0f;
            goto L38
        L33:
            r107 = ReleaseDirection.EXPAND;
            goto L35
        L19:
            if (r105 <= 0.0f) goto L21;
            boolean r108 = true;
        L23:
            if (r104 <= 0.0f) goto L25;
            boolean r109 = true;
        L26:
            if (r108 != r109) goto L28;
        L25:
            r109 = false;
            goto L26
        L21:
            r108 = false;
            goto L23
        L16:
            r106 = false;
        L38:
            float r112 = r110.getRawX() - this.f210373a;
            float r113 = r110.getRawY() - this.f210374b;
            if (Math.abs(r113) > this.f210379g.f210320c) goto L41;
        L43:
            this.f210375c = r110.getRawY();
            goto L50
        L41:
            if (Math.abs(r113) <= Math.abs(r112)) goto L43;
            this.f210378f = true;
            goto L43
        L9:
            if (r101 == 3) goto L44;
            goto L44
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f210380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210381b;

        public e(int r100, OfficeBaseMainHeaderScrollController r101) {
            this.f210380a = r100;
            this.f210381b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
            int r102 = ((Integer) r101).intValue();
            float r103 = r102 / this.f210380a;
            ViewGroup.LayoutParams r104 = this.f210381b.f210318a.f210515l.getLayoutParams();
            r104.height = r102;
            this.f210381b.f210318a.f210515l.setLayoutParams(r104);
            this.f210381b.f210318a.f210515l.setAlpha(RangesKt.coerceIn(r103, 0.0f, 1.0f));
            int r105 = this.f210380a - RangesKt.coerceAtLeast(this.f210381b.f210318a.f210515l.getHeight(), 0);
            OfficeBaseMainHeaderScrollController r106 = this.f210381b;
            OfficeBaseMainTopLayout r107 = r106.f210318a.f210513j;
            r107.f210536c.b(r106.h() + r105, this.f210381b.h());
        }
    }

    public static final class f extends com.bytedance.ee.bear.bitable.common.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f210382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f210384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f210385d;

        @Override // com.bytedance.ee.bear.bitable.common.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f210382a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            r100.removeListener(this);
            OfficeBaseMainHeaderScrollController r101 = this.f210383b;
            if (r101.f210326i != r100) goto L6;
            r101.f210326i = null;
        L6:
            if (this.f210382a == false) goto L8;
            return;
        L8:
            ViewGroup.LayoutParams r102 = r101.f210318a.f210515l.getLayoutParams();
            if (this.f210384c == false) goto L11;
            r102.height = 0;
            this.f210383b.f210318a.f210515l.setLayoutParams(r102);
            this.f210383b.f210318a.f210515l.setAlpha(0.0f);
        L12:
            int r103 = this.f210385d - RangesKt.coerceAtLeast(this.f210383b.f210318a.f210515l.getHeight(), 0);
            OfficeBaseMainHeaderScrollController r104 = this.f210383b;
            OfficeBaseMainTopLayout r105 = r104.f210318a.f210513j;
            int r106 = r104.h() + r103;
            int r107 = this.f210383b.h();
            r105.f210536c.b(r106, r107);
            if (Intrinsics.areEqual(this.f210383b.f210332o, Boolean.valueOf(this.f210384c)) == false) goto L16;
            OfficeBaseMainHeaderScrollController r108 = this.f210383b;
            r108.f210331n = this.f210384c;
            return;
        L16:
            return;
        L11:
            r102.height = -2;
            this.f210383b.f210318a.f210515l.setLayoutParams(r102);
            this.f210383b.f210318a.f210515l.setAlpha(1.0f);
            goto L12
        }

        public f(OfficeBaseMainHeaderScrollController r100, boolean r101, int r102) {
            this.f210383b = r100;
            this.f210384c = r101;
            this.f210385d = r102;
        }
    }

    public static final class g implements AppBarLayout.OnOffsetChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseMainHeaderScrollController f210386a;

        public g(OfficeBaseMainHeaderScrollController r100) {
            this.f210386a = r100;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout r100, int r101) {
            OfficeBaseMainHeaderScrollController.b(this.f210386a, r101);
        }
    }

    static {
    }

    public final void d() {
        int r100 = OfficeBaseMainHeaderAppBarBehavior.f210312e;
        OfficeBaseMainHeaderAppBarBehavior r101 = OfficeBaseMainHeaderAppBarBehavior.a.a(this.f210318a.f210505b);
        if (r101 == null) goto L9;
        ValueAnimator r102 = r101.f210315c;
        if (r102 == null) goto L7;
        r102.cancel();
    L7:
        r101.f210315c = null;
        return;
    }

    public final int h() {
        if (this.f210328k > 0) goto L6;
        this.f210328k = Math.max(this.f210318a.f210508e.getMeasuredHeight(), this.f210318a.f210508e.getHeight());
    L6:
        return this.f210328k;
    }

    public final int i() {
        if (this.f210329l > 0) goto L6;
        this.f210329l = Math.max(this.f210318a.f210515l.getMeasuredHeight(), this.f210318a.f210515l.getHeight());
    L6:
        return this.f210329l;
    }

    public final void m() {
        d();
        ViewGroup.LayoutParams r100 = this.f210318a.f210508e.getLayoutParams();
        r100.height = -2;
        this.f210318a.f210508e.setLayoutParams(r100);
        this.f210318a.f210508e.setAlpha(1.0f);
        this.f210318a.f210508e.setTranslationY(0.0f);
        this.f210318a.f210509f.setTranslationY(0.0f);
        this.f210318a.f210509f.setClipBounds(null);
        n(false, false);
        this.f210330m = false;
        p(false);
        g(false);
        this.f210319b.invoke(0);
    }

    public static void j(String r100) {
        tt5.a.h("OfficeBaseMainHeaderScrollController", "[release] " + r100);
    }

    public final void f(boolean r100) {
        if (this.f210333p == false) goto L7;
        j("expand skipped in top scrim mode");
        return;
    L7:
        if (this.f210330m == false) goto L9;
    L12:
        int r101 = h();
        if (r101 > 0) goto L16;
        j("expand fallback restore headerHeight:" + r101);
        m();
        return;
    L16:
        j("expand start animate:" + r100 + " headerHeight:" + r101 + " appBarTop:" + this.f210318a.f210505b.getTop());
        d();
        n(false, r100);
        if (r100 == true) goto L20;
        this.f210330m = false;
        p(false);
        g(false);
        this.f210319b.invoke(0);
        return;
    L20:
        return;
    L9:
        if (this.f210318a.f210505b.getTop() != 0) goto L12;
        j("expand skipped collapsed:" + this.f210330m + " appBarTop:" + this.f210318a.f210505b.getTop());
    }

    public final void g(boolean r100) {
        if (this.f210333p == false) goto L6;
        j("expandToolbar skipped in top scrim mode");
        return;
    L6:
        Boolean r101 = this.f210332o;
        Boolean r102 = Boolean.FALSE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L9;
    L31:
        j("expandToolbar skipped target:" + this.f210332o + " toolbarCollapsed:" + this.f210331n + " alpha:" + this.f210318a.f210515l.getAlpha());
        return;
    L9:
        if (this.f210331n == false) goto L11;
    L16:
        int r103 = i();
        if (r103 > 0) goto L19;
    L29:
        j("expandToolbar skipped height:" + r103 + " visibility:" + this.f210318a.f210515l.getVisibility());
        return;
    L19:
        if (this.f210318a.f210515l.getVisibility() != 0) goto L29;
        j("expandToolbar start animate:" + r100 + " height:" + r103);
        this.f210332o = r102;
        if (r100 == false) goto L24;
        c(RangesKt.coerceAtLeast(this.f210318a.f210515l.getHeight(), 0), r103, false);
        return;
    L24:
        ValueAnimator r104 = this.f210326i;
        if (r104 == null) goto L27;
        r104.cancel();
    L27:
        this.f210326i = null;
        ViewGroup.LayoutParams r105 = this.f210318a.f210515l.getLayoutParams();
        r105.height = -2;
        this.f210318a.f210515l.setLayoutParams(r105);
        this.f210318a.f210515l.setAlpha(1.0f);
        this.f210331n = false;
        this.f210332o = r102;
        OfficeBaseMainTopLayout r106 = this.f210318a.f210513j;
        r106.f210536c.b(0, h());
        return;
    L11:
        if (this.f210318a.f210515l.getAlpha() != 1.0f) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
    L13:
        r107 = false;
        goto L14
    }

    public final void l(boolean r100) {
        this.f210335r = r100;
        Iterator r101 = ((LinkedHashMap) this.f210336s.f210371a).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Binding) r101.next()).f(r100);
        goto L4
    }

    public final void o(boolean r100) {
        ValueAnimator r101 = this.f210326i;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f210326i = null;
        ViewGroup.LayoutParams r102 = this.f210318a.f210515l.getLayoutParams();
        int r103 = 0;
        if (r100 == false) goto L8;
        i();
        r102.height = 0;
        this.f210318a.f210515l.setAlpha(0.0f);
    L9:
        this.f210318a.f210515l.setLayoutParams(r102);
        this.f210331n = r100;
        this.f210332o = Boolean.valueOf(r100);
        if (r100 == false) goto L12;
        r103 = i();
    L12:
        OfficeBaseMainTopLayout r104 = this.f210318a.f210513j;
        int r105 = h() + r103;
        int r106 = h();
        r104.f210536c.b(r105, r106);
        return;
    L8:
        r102.height = -2;
        this.f210318a.f210515l.setAlpha(1.0f);
        goto L9
    }

    public final void p(boolean r100) {
        if (this.f210323f == r100) goto L5;
    L7:
        this.f210323f = r100;
        this.f210324g = Boolean.valueOf(r100);
        View r101 = null;
        if (r100 == false) goto L18;
        TitleBar r102 = this.f210321d;
        if (r102 == null) goto L12;
        View r103 = r102.findMenuView("base_drawer");
    L13:
        if (r103 == null) goto L15;
        TextView r104 = (TextView) r103.findViewById(R.id.widgetTitleMenuText);
    L16:
        if (r104 == null) goto L18;
        r104.setText(this.f210322e);
        goto L18
    L15:
        r104 = null;
        goto L16
    L12:
        r103 = null;
    L18:
        TitleBar r105 = this.f210321d;
        if (r105 == null) goto L21;
        r101 = r105.findMenuView("base_drawer");
    L21:
        if (r101 == null) goto L40;
        ObjectAnimator r106 = this.f210325h;
        if (r106 == null) goto L26;
        r106.cancel();
    L26:
        float r107 = com.bytedance.ee.util.ui.n.c(36.0f);
        if (r100 == false) goto L29;
        float r108 = 0.0f;
    L31:
        if (r100 == false) goto L37;
        if (r101.getVisibility() == 0) goto L35;
        r101.setTranslationY(r107);
    L35:
        r101.setVisibility(0);
    L39:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r101.getTranslationY(), r108});
        r109.setDuration(100);
        r109.setInterpolator(new DecelerateInterpolator());
        r109.addListener(new i(this, r101));
        r109.start();
        this.f210325h = r109;
        goto L40
    L37:
        if (r101.getVisibility() == 0) goto L39;
        r101.setTranslationY(r107);
        goto L40
    L29:
        r108 = r107;
    L40:
        tt5.a.h("OfficeBaseMainHeaderScrollController", "updateDrawerEntry visible:" + r100);
        return;
    L5:
        if (Intrinsics.areEqual(this.f210324g, Boolean.valueOf(r100)) == false) goto L7;
    }

    public static final void a(OfficeBaseMainHeaderScrollController r100, OfficeBaseMainScrollContentType r101) {
        if (r100.f210333p == false) goto L5;
        j("dispatchTopReached skipped in top scrim mode type:" + r101);
        return;
    L5:
        j("dispatchTopReached type:" + r101);
        r100.l(true);
        r100.e(ReleaseDirection.EXPAND, r101, true);
    }

    public static final void b(OfficeBaseMainHeaderScrollController r100, int r101) {
        int r102 = r100.h();
        if (r102 > 0) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r100.f210330m == r103) goto L11;
        r100.f210330m = r103;
        r100.p(r103);
    L11:
        r100.f210319b.invoke(Integer.valueOf(r101));
        return;
    L5:
        if (Math.abs(r101) < r102) goto L7;
        r103 = true;
        goto L9
    }

    public final void k(OfficeBaseMainScrollContentType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        j("onOverlayContentReleased type:" + r100 + " scrollUp:" + r101 + " webContentTop:" + this.f210335r);
        boolean r102 = this.f210335r;
        Intrinsics.checkNotNullParameter(r100, "type");
        j("onContentReleased type:" + r100 + " scrollUp:" + r101 + " isAtTop:" + r102 + " webContentTop:" + this.f210335r);
        if (r101 == false) goto L5;
        ReleaseDirection r103 = ReleaseDirection.COLLAPSE;
    L6:
        e(r103, r100, r102);
        return;
    L5:
        r103 = ReleaseDirection.EXPAND;
        goto L6
    }

    public final void n(boolean r100, boolean r101) {
        int r102 = OfficeBaseMainHeaderAppBarBehavior.f210312e;
        OfficeBaseMainHeaderAppBarBehavior r103 = OfficeBaseMainHeaderAppBarBehavior.a.a(this.f210318a.f210505b);
        if (r103 == null) goto L5;
        r103.c(this.f210318a.f210505b, r100, r101);
        return;
    L5:
        this.f210318a.f210505b.setExpanded(!r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeBaseMainHeaderScrollController(Context r100, OfficeBaseMainInfoArchViewHolder r101, Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, "onOffsetChanged");
        this.f210318a = r101;
        this.f210319b = r102;
        this.f210320c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f210327j = true;
        this.f210335r = true;
        this.f210336s = new c(this);
        this.f210337t = new d(this);
        this.f210338u = new a(this, OfficeBaseMainScrollContentType.NATIVE_VIEW);
        this.f210339v = new a(this, OfficeBaseMainScrollContentType.MAIN_WEB);
        this.f210340w = new OfficeBaseMainHeaderScrollController$headerOnlyOffsetChangedListener$1(this);
        this.f210341x = new g(this);
    }

    public final void c(int r100, int r101, boolean r102) {
        int r103 = Math.max(i(), Math.max(r100, r101));
        ValueAnimator r104 = this.f210326i;
        if (r104 == null) goto L5;
        r104.cancel();
    L5:
        this.f210326i = null;
        if (r103 > 0) goto L8;
        return;
    L8:
        ValueAnimator r105 = ValueAnimator.ofInt(new int[]{r100, r101});
        r105.setDuration(250);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new e(r103, this));
        r105.addListener(new f(this, r102, r103));
        r105.start();
        this.f210326i = r105;
    }

    public final void e(ReleaseDirection r100, OfficeBaseMainScrollContentType r101, boolean r102) {
        if (this.f210333p == false) goto L6;
        j("dispatchRelease skipped in top scrim mode type:" + r101 + " direction:" + r100);
        return;
    L6:
        j("dispatchRelease direction:" + r100 + " type:" + r101 + " isAtTop:" + r102 + " collapsed:" + this.f210330m + " toolbarCollapsed:" + this.f210331n + " toolbarTargetCollapsed:" + this.f210332o + " headerEnabled:" + this.f210327j);
        if (r100 == ReleaseDirection.COLLAPSE) goto L9;
        g(true);
        if (r102 == false) goto L36;
    L39:
        f(true);
        return;
    L36:
        if (r101 == OfficeBaseMainScrollContentType.MAIN_WEB) goto L38;
        return;
    L38:
        if (this.f210335r == true) goto L39;
        return;
    L9:
        if (this.f210327j == true) goto L11;
    L19:
        j("collapse skipped headerEnabled:" + this.f210327j + " collapsed:" + this.f210330m + " appBarVisibility:" + this.f210318a.f210505b.getVisibility());
    L20:
        Boolean r103 = this.f210332o;
        Boolean r104 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L23;
    L32:
        j("collapseToolbar skipped target:" + this.f210332o + " visibility:" + this.f210318a.f210515l.getVisibility());
        return;
    L23:
        if (this.f210318a.f210515l.getVisibility() != 0) goto L32;
        int r105 = i();
        if (r105 > 0) goto L28;
        j("collapseToolbar skipped height:" + r105);
        return;
    L28:
        j("collapseToolbar start animate:true height:" + r105);
        this.f210332o = r104;
        if (this.f210318a.f210515l.getHeight() <= 0) goto L31;
        r105 = this.f210318a.f210515l.getHeight();
    L31:
        c(r105, 0, true);
        return;
    L11:
        if (this.f210330m == true) goto L19;
        if (this.f210318a.f210505b.getVisibility() != 0) goto L19;
        int r106 = h();
        if (r106 > 0) goto L18;
        j("collapse skipped headerHeight:" + r106);
        goto L20
    L18:
        j("collapse start headerHeight:" + r106);
        n(true, true);
        goto L20
    }
}
