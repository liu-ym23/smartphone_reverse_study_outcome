package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ContentLongClickListener implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LKUILightTextView f414042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f414043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f414044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.widget.select.m f414045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<Integer, Integer> f414046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f414047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f414048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScrollView f414049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f414050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f414051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f414052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f414053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f414054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f414055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f414056o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f414057p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f414058q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f414059r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a f414060s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PopupWindow f414061t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f414062u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LKUILightTextView f414063v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f414064w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f414065x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentLongClickListener f414066a;

        public b(ContentLongClickListener r100) {
            this.f414066a = r100;
        }

        public final void a() {
            ContentLongClickListener r100 = this.f414066a;
            if (r100.f414048g == false) goto L27;
            boolean r101 = false;
            r100.f414048g = false;
            com.ss.android.lark.widget.select.m r102 = r100.f414045d;
            if (r102 != null) goto L7;
            return;
        L7:
            com.ss.android.lark.widget.select.g r103 = r102.c();
            if (r103 != null) goto L10;
            return;
        L10:
            Rect r104 = new Rect();
            this.f414066a.f414042a.getGlobalVisibleRect(r104);
            int r105 = r103.f448426b;
            int r106 = r104.top;
            if (r105 >= r106) goto L13;
        L16:
            boolean r107 = true;
        L17:
            int r108 = r103.f448427c;
            if (r108 >= r106) goto L20;
        L21:
            r101 = true;
        L22:
            com.ss.android.lark.widget.select.m r109 = this.f414066a.f414045d;
            if (r109 == null) goto L25;
            r109.m(!r107, !r101);
        L25:
            ContentLongClickListener r110 = this.f414066a;
            LKUILightTextView r111 = r110.f414042a;
            PopupWindow r112 = r110.f414061t;
            ((Number) ((Pair) r110.f414062u.getValue()).getFirst()).intValue();
            ((Number) ((Pair) this.f414066a.f414062u.getValue()).getSecond()).intValue();
            ContentLongClickListener.a(r110, r103, r111, r112);
            return;
        L20:
            if (r108 <= r104.bottom) goto L22;
        L13:
            if (r105 > r104.bottom) goto L16;
            r107 = false;
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    public final void b() {
        this.f414053l = true;
        c(this.f414061t);
        com.ss.android.lark.widget.select.m r100 = this.f414045d;
        if (r100 == null) goto L5;
        r100.h();
    L5:
        this.f414045d = null;
        this.f414061t = null;
    }

    public final void d() {
        com.ss.android.lark.widget.select.m r100 = this.f414045d;
        if (r100 == null) goto L6;
        UICallbackExecutor.post(new f(r100, this));
    L6:
        c(this.f414061t);
    }

    public static void c(PopupWindow r100) {
        if (r100 == null) goto L6;
        boolean r101 = true;
        if (r100.isShowing() != true) goto L6;
    L7:
        if (r101 == false) goto L10;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        return;
    L10:
        return;
    L6:
        r101 = false;
        goto L7
    }

    public final void e(ActionContextCreator r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContextCreator");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a r101 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a();
        f4b.d r102 = r100.a(this.f414042a);
        if (r102 != null) goto L5;
        Log.e("FullActionPanelManager", "setup actionManager failed, actionContext is null");
    L6:
        r101.f414109b = new ContentLongClickListener$updatePanelContext$1$1(this);
        this.f414060s = r101;
        return;
    L5:
        r101.f414108a = r102;
        goto L6
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r110) {
        com.ss.android.lark.widget.select.m r111 = this.f414045d;
        if (r111 == null) goto L5;
        r111.a();
    L5:
        LKUILightTextView r112 = this.f414063v;
        com.ss.android.lark.widget.select.c r100 = null;
        if (r112 == null) goto L8;
        SelectableView.State r113 = r112.getState();
    L10:
        if (r113 != SelectableView.State.SELECTED) goto L12;
        this.f414044c.invoke();
    L12:
        int r114 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.f413962a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.messenger.selection.scrolling") == false) goto L19;
        final ScrollView r115 = this.f414049h;
        if (r115 == null) goto L19;
        r100 = new com.ss.android.lark.widget.select.c(this.f414043b.getContext(), r115, new ContentLongClickListener$createAutoScrollStrategy$1(r115, this), new ContentLongClickListener$createAutoScrollStrategy$2(this));
    L19:
        com.ss.android.lark.widget.select.m.a r116 = new com.ss.android.lark.widget.select.m.a(new com.ss.android.lark.widget.select.b(this.f414042a), ContextsKt.requireActivity(this.f414042a));
        r116.f448458c = UIUtils.getColor(this.f414043b.getContext(), R.color.primary_fill_default);
        r116.f448459d = ((Number) this.f414065x.getValue()).intValue();
        if (r100 == null) goto L22;
        r116.f448460e = r100;
    L22:
        com.ss.android.lark.widget.select.m r101 = new com.ss.android.lark.widget.select.m(r116);
        r101.f448450m = new j(this);
        r101.f448451n = new k(this, r100, r101);
        r101.b();
        LKUILightTextView r117 = this.f414042a;
        int r102 = this.f414046e.getFirst().intValue();
        int r103 = this.f414046e.getSecond().intValue();
        if ((r103 - r102) < 2) goto L25;
        Pair r118 = TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103));
    L55:
        r101.l(((Number) r118.component1()).intValue(), ((Number) r118.component2()).intValue());
        this.f414045d = r101;
        return true;
    L25:
        Layout r119 = r117.getLayout();
        if (r119 != null) goto L29;
        r118 = TuplesKt.to(-1, -1);
        goto L55
    L29:
        if (r102 == r103) goto L31;
    L39:
        int r104 = r119.getLineForOffset(r102);
        if (r119.getLineForOffset(r102) != (r119.getLineForOffset(r102 - 1) + 1)) goto L42;
        boolean r105 = true;
    L43:
        if (r105 == false) goto L45;
        r104 = Math.max(r104 - 1, 0);
    L45:
        int r106 = r102 + 2;
        int r107 = r119.getLineEnd(r104);
        if (r105 == false) goto L49;
        r118 = TuplesKt.to(Integer.valueOf(r107 - 1), Integer.valueOf(Math.min(r106 - 1, r119.getText().length())));
        goto L55
    L49:
        if (r106 < r119.getText().length()) goto L52;
        r118 = TuplesKt.to(Integer.valueOf(r119.getText().length() - 2), Integer.valueOf(r119.getText().length()));
        goto L55
    L52:
        if (r104 == r119.getLineForOffset(r106)) goto L54;
        r118 = TuplesKt.to(Integer.valueOf(r107 - 2), Integer.valueOf(r107));
        goto L55
    L54:
        r118 = TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r106));
        goto L55
    L42:
        r105 = false;
        goto L43
    L31:
        if ((r119.getText() instanceof Spanned) == false) goto L39;
        CharSequence r108 = r119.getText();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r109 = (Spanned) r108;
        Object[] r120 = r109.getSpans(0, r109.length(), ReplacementSpan.class);
        int r121 = r120.length;
        int r122 = 0;
    L33:
        if (r122 >= r121) goto L39;
        ReplacementSpan r123 = (ReplacementSpan) r120[r122];
        int r124 = r109.getSpanStart(r123);
        int r125 = r109.getSpanEnd(r123);
        if (r124 > r102) goto L38;
        if (r125 < r103) goto L38;
        r118 = TuplesKt.to(Integer.valueOf(r124), Integer.valueOf(r125));
    L38:
        r122 = r122 + 1;
        goto L33
    L8:
        r113 = null;
        goto L10
    }

    public /* synthetic */ ContentLongClickListener(LKUILightTextView r100, c r101, ActionContextCreator r102) {
        this(r100, r101, r102, AnonymousClass1.INSTANCE);
    }

    public ContentLongClickListener(LKUILightTextView r100, c r101, ActionContextCreator r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "contentTv");
        Intrinsics.checkNotNullParameter(r101, "clickContext");
        Intrinsics.checkNotNullParameter(r103, "dismissCoordinator");
        this.f414042a = r100;
        this.f414043b = r101;
        this.f414044c = r103;
        this.f414046e = TuplesKt.to(Integer.MAX_VALUE, Integer.MIN_VALUE);
        this.f414047f = new Handler(Looper.getMainLooper());
        this.f414051j = true;
        this.f414054m = LazyKt.lazy(ContentLongClickListener$partialSelectBottomOffset$2.INSTANCE);
        this.f414055n = LazyKt.lazy(ContentLongClickListener$partialSelectTopOffset$2.INSTANCE);
        this.f414056o = LazyKt.lazy(ContentLongClickListener$partialSelectTopShadowSize$2.INSTANCE);
        this.f414057p = LazyKt.lazy(ContentLongClickListener$partialSelectBottomShadowSize$2.INSTANCE);
        this.f414058q = LazyKt.lazy(ContentLongClickListener$menuShowMarginHorizontal$2.INSTANCE);
        this.f414059r = new Rect();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a r104 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a();
        LKUILightTextView r105 = null;
        if (r102 == null) goto L5;
        f4b.d r106 = r102.a(r100);
    L6:
        if (r106 != null) goto L8;
        Log.e("FullActionPanelManager", "setup actionManager failed, actionContext is null");
    L9:
        r104.f414109b = new ContentLongClickListener$panelManager$1$1(this);
        this.f414060s = r104;
        LazyThreadSafetyMode r107 = LazyThreadSafetyMode.NONE;
        this.f414062u = LazyKt.lazy(r107, new ContentLongClickListener$menuShowMargins$2(this));
        this.f414064w = new b(this);
        this.f414065x = LazyKt.lazy(r107, new ContentLongClickListener$cursorHandleSize$2(this));
        ViewParent r108 = r100.getParent().getParent();
        if ((r108 instanceof ScrollView) == false) goto L12;
        ScrollView r109 = (ScrollView) r108;
    L13:
        this.f414049h = r109;
        if (r109 == null) goto L16;
        LKUILightTextView r110 = (LKUILightTextView) r109.findViewById(R.id.tv_translate_content);
    L17:
        if (r109 == null) goto L20;
        r105 = (LKUILightTextView) r109.findViewById(R.id.tv_content);
    L20:
        if (Intrinsics.areEqual(r105, r100) == true) goto L23;
        r110 = r105;
    L23:
        this.f414063v = r110;
        r100.setOnTouchListener(new g(this, new GestureDetector(r101.getContext(), new i(this))));
        if (r109 == null) goto L29;
        ViewTreeObserver r111 = r109.getViewTreeObserver();
        if (r111 == null) goto L30;
        r111.addOnScrollChangedListener(new h(this));
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r110 = null;
        goto L17
    L12:
        r109 = null;
        goto L13
    L8:
        r104.f414108a = r106;
        goto L9
    L5:
        r106 = null;
        goto L6
    }

    public static final void a(ContentLongClickListener r110, com.ss.android.lark.widget.select.g r111, LKUILightTextView r112, PopupWindow r113) {
        ScrollView r100 = r110.f414049h;
        if (r100 == null) goto L37;
        if (r113 == null) goto L38;
        c(r113);
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        View r102 = r113.getContentView();
        r102.measure(0, 0);
        Pair r103 = TuplesKt.to(Integer.valueOf(r102.getMeasuredWidth()), Integer.valueOf(r102.getMeasuredHeight()));
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        int[] r106 = new int[2];
        r112.getLocationOnScreen(r106);
        if (r111.f448430f == false) goto L10;
        int r107 = r106[0] + ((r111.f448429e + r111.f448428d) / 2);
        int r108 = r104 / 2;
    L11:
        int r109 = r107 - r108;
        int r114 = Math.min(Math.max(r101.left + ((Number) r110.f414058q.getValue()).intValue(), r109), (r101.right - r104) - ((Number) r110.f414058q.getValue()).intValue());
        if (r111.f448427c >= (r100.getHeight() - r105)) goto L14;
        int r115 = r111.f448427c + ((Number) r110.f414054m.getValue()).intValue();
        int r116 = ((Number) r110.f414056o.getValue()).intValue();
    L23:
        int r117 = r115 - r116;
    L26:
        if (PopupWindowLancet.hasSubWindowToken(r112) == false) goto L29;
        return;
    L29:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r113) == false) goto L31;
        r113.showAtLocation(r112, 8388659, r114, r117);
        return;
    L31:
        OverlaySource r118 = PopupWindowLancet.resolveSource(r112);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r113, r112, r118, 8388659, r114, r117) == true) goto L40;
        r113.showAtLocation(r112, 8388659, r114, r117);
        PopupWindowLancet.trackAfterShow(r113, r118, r112);
        return;
    L40:
        return;
    L14:
        int r119 = r111.f448426b;
        if (r119 <= r105) goto L18;
        r117 = ((r119 - r105) + ((Number) r110.f414057p.getValue()).intValue()) - ((Number) r110.f414055n.getValue()).intValue();
        goto L26
    L18:
        if (r111.f448427c >= r100.getHeight()) goto L20;
        r115 = (r111.f448427c - r105) + ((Number) r110.f414057p.getValue()).intValue();
        r116 = ((Number) r110.f414055n.getValue()).intValue();
        goto L23
    L20:
        int r120 = r111.f448426b;
        if (r120 <= 0) goto L24;
        r115 = r120 + ((Number) r110.f414054m.getValue()).intValue();
        r116 = ((Number) r110.f414056o.getValue()).intValue();
        goto L23
    L24:
        r117 = (r100.getHeight() / 2) - (r105 / 2);
        goto L26
    L10:
        r107 = r101.centerX();
        r108 = r104 / 2;
        goto L11
    L38:
        return;
    }
}
