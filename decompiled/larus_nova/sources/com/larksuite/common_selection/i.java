package com.larksuite.common_selection;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.common_selection.selectionhandle.CursorHandle;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f282868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ly7.b.a f282869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f282870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f282871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f282872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f282873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DrawHighlightStyle f282874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<TriggerMode, n> f282875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f282876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p f282877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SelectionContainer f282878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ly7.c f282879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ly7.c f282880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SelectionHandleType f282881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p f282882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f282883p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f282884q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r f282885r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.larksuite.common_selection.b f282886s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h f282887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f282888u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f282889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ly7.b.a f282890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f282891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f282892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f282893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f282894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f282895g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final DrawHighlightStyle f282896h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Map<TriggerMode, n> f282897i;

        public a() {
            this.f282889a = new ly7.a();
            this.f282890b = ly7.b.f511317a;
            this.f282891c = t.f282928a;
            this.f282892d = Color.argb(60, 52, 152, 219);
            this.f282894f = true;
            this.f282895g = true;
            this.f282896h = DrawHighlightStyle.FOREGROUND;
            this.f282897i = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(TriggerMode.LongPress, new n(SelectionGranularity.WORD, SelectionInitiationMode.SELECT_ANYWHERE))});
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f282898a;

        public c(i r100) {
            this.f282898a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(this.f282898a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final Pair<Rect, Rect> c() {
        ly7.c r100 = this.f282879l;
        if (r100 == null) goto L17;
        View r101 = r100.getView();
        if (r101 == null) goto L17;
        ly7.c r102 = this.f282880m;
        if (r102 == null) goto L17;
        View r103 = r102.getView();
        if (r103 == null) goto L17;
        if (this.f282878k != null) goto L15;
        return null;
    L15:
        int[] r104 = new int[2];
        r101.getLocationOnScreen(r104);
        int[] r105 = new int[2];
        r103.getLocationOnScreen(r105);
        int r106 = r104[0];
        Rect r107 = new Rect(r106, r104[1], r101.getWidth() + r106, r104[1] + r101.getHeight());
        int r108 = r105[0];
        return new Pair(r107, new Rect(r108, r105[1], r103.getWidth() + r108, r105[1] + r103.getHeight()));
    L17:
        return null;
    }

    public final void d() {
        if (this.f282888u == false) goto L22;
        return;
    L22:
        this.f282888u = true;     // Catch: Throwable -> L19
        if (this.f282878k == null) goto L11;
        h r100 = this.f282887t;     // Catch: Throwable -> L19
        if (r100 == null) goto L11;
        r100.d();     // Catch: Throwable -> L19
    L11:
        this.f282882o = null;     // Catch: Throwable -> L19
        g();     // Catch: Throwable -> L19
        com.larksuite.common_selection.b r101 = this.f282886s;     // Catch: Throwable -> L19
        if (r101 == null) goto L14;
        r101.f282865a.dismiss();     // Catch: Throwable -> L19
    L14:
        this.f282886s = null;     // Catch: Throwable -> L19
        SelectionContainer r102 = this.f282878k;     // Catch: Throwable -> L19
        this.f282878k = null;     // Catch: Throwable -> L19
        Log.d("SelectionManager", "clearSelection called");     // Catch: Throwable -> L19
        this.f282877j = null;     // Catch: Throwable -> L19
        if (r102 == null) goto L17;
        r102.invalidate();     // Catch: Throwable -> L19
    L17:
        this.f282888u = false;
        return;
    L19:
        th = move-exception;
        this.f282888u = false;
        throw th;
    }

    public final List<e> f() {
        p r100 = this.f282877j;
        if (r100 == null) goto L5;
        SelectionContainer r101 = this.f282878k;
        if (r101 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r100.f282910a.f282908a != null) goto L13;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L18;
        ArrayList<View> r103 = r101.getFlatSelectableItems$common_selection_release();
        int r104 = CollectionsKt.indexOf(r103, r100.f282910a.f282908a);
        int r105 = CollectionsKt.indexOf(r103, r100.f282911b.f282908a);
        if (r104 < 0) goto L43;
        if (r105 < 0) goto L43;
        ArrayList r106 = new ArrayList((r105 - r104) + 1);
        if (r104 > r105) goto L41;
        int r107 = r104;
    L26:
        View r108 = (View) ListProtector.get(r103, r107);
        t r109 = t.f282928a;
        s r110 = t.a(r108);
        if (r110 != null) goto L29;
        r110 = t.f282930c;
    L29:
        if (r107 != r104) goto L31;
        int r111 = r100.f282910a.f282909b;
    L32:
        if (r107 != r105) goto L34;
        int r112 = r100.f282911b.f282909b;
    L35:
        if (r111 >= r112) goto L39;
        e r113 = r110.c(r108, r111, r112);
        if (r113 == null) goto L39;
        r106.add(r113);
    L39:
        if (r107 == r105) goto L41;
        r107 = r107 + 1;
        goto L26
    L34:
        r112 = r110.a(r108);
        goto L35
    L31:
        r111 = 0;
    L41:
        return r106;
    L43:
        return CollectionsKt.emptyList();
    L18:
        return CollectionsKt.emptyList();
    L13:
        if (r100.f282911b.f282908a == null) goto L15;
        r102 = true;
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }

    public final void g() {
        SelectionContainer r100 = this.f282878k;
        if (r100 == null) goto L14;
        ly7.c r101 = this.f282879l;
        if (r101 == null) goto L9;
        View r102 = r101.getView();
        if (r102 == null) goto L9;
        r100.removeView(r102);
    L9:
        ly7.c r103 = this.f282880m;
        if (r103 == null) goto L14;
        View r104 = r103.getView();
        if (r104 == null) goto L14;
        r100.removeView(r104);
    L14:
        this.f282869b.getClass();
        r r105 = this.f282885r;
        if (r105 == null) goto L20;
        View r106 = r105.f282921c.findViewById(r105.f282923e);
        if (r106 == null) goto L19;
        r105.f282921c.removeView(r106);
    L19:
        r105.f282920b.invoke();
    L20:
        this.f282885r = null;
        this.f282879l = null;
        this.f282880m = null;
        this.f282884q = false;
    }

    public final boolean h() {
        if (this.f282884q == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f282879l == null) goto L9;
        if (this.f282880m == null) goto L9;
        return true;
    }

    public final void i() {
        p r100 = this.f282877j;
        if (r100 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.f282882o) == true) goto L12;
        h r101 = this.f282887t;
        if (r101 == null) goto L10;
        r101.e(r100);
    L10:
        this.f282882o = p.a(r100);
        return;
    }

    public final void k() {
        SelectionContainer r100 = this.f282878k;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.post(new c(this));
    }

    public final void m() {
        SelectionContainer r100 = this.f282878k;
        if (r100 != null) goto L5;
        return;
    L5:
        p r101 = this.f282877j;
        if (r101 != null) goto L8;
        return;
    L8:
        Pair r102 = e(r101.f282910a, false);
        if (r102 == null) goto L13;
        Point r103 = (Point) r102.component1();
        float r104 = ((Number) r102.component2()).floatValue();
        ly7.c r105 = this.f282879l;
        if (r105 == null) goto L13;
        r105.e(r101.f282910a, this.f282870c);
        r105.k(r100, r103, r104);
    L13:
        Pair r106 = e(r101.f282911b, true);
        if (r106 == null) goto L18;
        Point r107 = (Point) r106.component1();
        float r108 = ((Number) r106.component2()).floatValue();
        ly7.c r109 = this.f282880m;
        if (r109 == null) goto L18;
        r109.e(r101.f282911b, this.f282870c);
        r109.k(r100, r107, r108);
    L18:
        this.f282869b.getClass();
    }

    public i(a r100) {
        Paint r101 = new Paint();
        this.f282876i = r101;
        this.f282883p = new AtomicBoolean(false);
        this.f282868a = r100.f282889a;
        this.f282869b = r100.f282890b;
        this.f282870c = r100.f282891c;
        this.f282871d = r100.f282893e;
        this.f282872e = r100.f282894f;
        this.f282873f = r100.f282895g;
        this.f282874g = r100.f282896h;
        this.f282875h = MapsKt.toMutableMap(r100.f282897i);
        r101.setColor(r100.f282892d);
        r101.setStyle(Paint.Style.FILL);
    }

    public static final void a(i r100) {
        SelectionContainer r101 = r100.f282878k;
        if (r101 == null) goto L13;
        Pair<Rect, Rect> r102 = r100.c();
        if (r102 == null) goto L11;
        h r103 = r100.f282887t;
        if (r103 == null) goto L12;
        r103.c(r101, r102.getFirst(), r102.getSecond());
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        h r101 = this.f282887t;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public static Pair e(o r100, boolean r101) {
        View r102 = r100.f282908a;
        if (r102 != null) goto L6;
        return null;
    L6:
        t r103 = t.f282928a;
        s r104 = t.a(r102);
        if (r104 != null) goto L10;
        r104 = t.f282930c;
    L10:
        return TuplesKt.to(r104.d(r100, r101), Float.valueOf(r104.j(r100)));
    }

    public final void l(SelectionContainer r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "point");
        if (Intrinsics.areEqual(this.f282878k, r100) == false) goto L17;
        p r102 = this.f282877j;
        o r103 = null;
        if (r102 == null) goto L7;
        o r104 = r102.f282910a;
    L9:
        if (Intrinsics.areEqual(r104, r101) == false) goto L17;
        p r105 = this.f282877j;
        if (r105 == null) goto L14;
        r103 = r105.f282911b;
    L14:
        if (Intrinsics.areEqual(r103, r101) == false) goto L17;
        return;
    L7:
        r104 = null;
    L17:
        if (this.f282878k == null) goto L19;
        d();
    L19:
        this.f282878k = r100;
        o r106 = new o(r101.f282908a, r101.f282909b);
        p r107 = new p(r106, r106);
        this.f282877j = r107;
        h r108 = this.f282887t;
        if (r108 == null) goto L22;
        r108.b(r107);
    L22:
        this.f282882o = p.a(r107);
        r100.invalidate();
        Context r109 = r100.getContext();
        if (this.f282872e == false) goto L26;
        com.larksuite.common_selection.a.a(r109);
        return;
    }

    public final void n(o r100, o r101) {
        p r102 = this.f282877j;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = r102.f282910a;
    L7:
        if (r101 != null) goto L10;
        r101 = r102.f282911b;
    L10:
        if (Intrinsics.areEqual(r100, r102.f282910a) == true) goto L12;
    L14:
        this.f282877j = new p(r100, r101);
        i();
        SelectionContainer r103 = this.f282878k;
        if (r103 == null) goto L18;
        r103.invalidate();
    L18:
        if (this.f282884q == true) goto L20;
        return;
    L20:
        if (this.f282883p.getAndSet(true) == true) goto L27;
        SelectionContainer r104 = this.f282878k;
        if (r104 == null) goto L28;
        r104.post(new k(this));
        return;
    L28:
        return;
    L27:
        return;
    L12:
        if (Intrinsics.areEqual(r101, r102.f282911b) == false) goto L14;
    }

    public static final ly7.c b(i r100, SelectionContainer r101, SelectionHandleType r102) {
        CursorHandle r103 = r100.f282868a.a(r101.getContext(), r102);
        View r104 = r103.getView();
        r104.setOnTouchListener(new j(r100, r102, r101));
        r101.addView(r104, new FrameLayout.LayoutParams(-2, -2));
        return r103;
    }
}
