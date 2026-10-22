package com.bytedance.ee.bear.document.titlebar;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.titlebar.titleview.DocumentOfficeTitleView;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d0 implements TitleBar {
    public static final Range<Float> q = null;
    public final c a;
    public final y3 b;
    public AppBarLayout c;
    public ValueAnimator d;
    public BaseTitleBar e;
    public int f;
    public com.bytedance.ee.bear.document.titlebar.titleview.a g;
    public List<MenuItem> h;
    public final List<TitleBar.a> i;
    public TitleBar.b j;
    public List<MenuItem> k;
    public List<MenuItem> l;
    public boolean m;
    public final com.bytedance.ee.bear.browser.plugin.d n;
    public com.bytedance.ee.bear.browser.plugin.d o;
    public boolean p;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleBar.TitleGravity.values().length];
            a = r0;
            r0[TitleBar.TitleGravity.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[TitleBar.TitleGravity.Center.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface b {
        ot4.e a(MenuItem r1);
    }

    public interface c {
        ViewGroup a();

        b getActionProvider();

        FragmentActivity getActivity();

        View getRootView();

        AppBarLayout getTitleBarLayout();

        LifecycleOwner getTitleBarLifecycleOwner();

        WebView getWebView();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ View a() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void h() {
        this.g.setExternalTagEnabled(false);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRiskFlag(boolean r1) {
    }

    static {
        q = new Range(Float.valueOf(0.0f), Float.valueOf(1.0f));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void clearMenus() {
        this.e.f();
        this.e.g();
        this.e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void f() {
        com.bytedance.ee.bear.document.titlebar.titleview.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.setSpaceTagTitleBarEnabled(false);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final com.bytedance.ee.bear.browser.plugin.d getDeviceInfo() {
        com.bytedance.ee.bear.browser.plugin.d r0 = this.n;
        if (r0.a != 0) goto L6;
        r0.a = com.bytedance.ee.util.ui.n.E(com.bytedance.ee.util.ui.k.e(this.c.getContext()));
        com.bytedance.ee.bear.browser.plugin.d r1 = this.n;
        r1.c = ((Float) q.getUpper()).floatValue();
    L6:
        return this.n;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void invalidate() {
        this.e.invalidate();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean isLeftIconVisible() {
        return this.e.getLeftIconVisibility();
    }

    public final void n() {
        com.bytedance.ee.bear.browser.plugin.d r0 = this.n;
        r0.c = ((Float) q.clamp(Float.valueOf(r0.c))).floatValue();
        if (this.n.equals(this.o) == true) goto L8;
        this.o = new com.bytedance.ee.bear.browser.plugin.d(this.n);
        Iterator r1 = ((CopyOnWriteArrayList) this.i).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((TitleBar.a) r1.next()).onTitleBarStateChanged(this.n);
        goto L6
    L10:
        return;
    }

    public final void q() {
        if (this.c.getHeight() != 0) goto L6;
        this.n.c = ((Float) q.getLower()).floatValue();
        return;
    L6:
        int[] r0 = new int[2];
        this.c.getLocationOnScreen(r0);
        int r1 = r0[1] + com.bytedance.ee.util.ui.n.d(this.n.b);
        int r2 = com.bytedance.ee.util.ui.k.e(this.c.getContext());
        int r3 = r1 - r2;
        this.n.a = com.bytedance.ee.util.ui.n.E(r2);
        com.bytedance.ee.bear.browser.plugin.d r4 = this.n;
        r4.c = com.bytedance.ee.util.ui.n.E(r3) / r4.b;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void d() {
        this.g.setTitleTextColor(2131106622);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final BaseTitleBar getTitleBarLayout() {
        return this.e;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void b(TitleBar.TitleGravity r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        this.g.setGravity(8388611);
        this.e.setIsCenterAlways(false);
    L9:
        this.e.b();
        return;
    L5:
        if (r4 != 2) goto L9;
        this.g.setGravity(17);
        this.e.setIsCenterAlways(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void c(TitleBar.a r2) {
        ((CopyOnWriteArrayList) this.i).remove(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void enableTitleBarAlwaysShowing(boolean r1) {
        this.p = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final View findMenuView(String r2) {
        return this.e.d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void g(TitleBar.a r2) {
        if (((CopyOnWriteArrayList) this.i).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.i).add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void hide(boolean r3) {
        if (this.p == false) goto L5;
        return;
    L5:
        tt5.a.h("SimpleTitleBar", "hide animation:" + r3);
        this.m = false;
        if (r3 == false) goto L8;
        o(false);
    L9:
        q();
        n();
        return;
    L8:
        p(false);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final List<MenuItem> i(TitleBar.MenuType r2) {
        if (r2 != TitleBar.MenuType.Left) goto L6;
        return this.k;
    L6:
        return this.l;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void k(TitleBar.b r1) {
        this.j = r1;
    }

    public final ColorStateList l(List<String> r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.size() == 4) goto L7;
        return null;
    L7:
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{-16842910}, new int[]{R.attr.state_selected}, new int[0]}, new int[]{ColorProtector.parseColor((String) ListProtector.get(r8, 1)), ColorProtector.parseColor((String) ListProtector.get(r8, 2)), ColorProtector.parseColor((String) ListProtector.get(r8, 3)), ColorProtector.parseColor((String) ListProtector.get(r8, 0))});
    }

    public final List<MenuItem> m(List<MenuItem> r3) {
        ArrayList r0 = new ArrayList();
        if (hu5.a.d(r3) == false) goto L5;
        return r0;
    L5:
        Iterator<MenuItem> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        MenuItem r1 = r4.next();
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    public final void o(boolean r4) {
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
        this.d = null;
    L5:
        this.n.e = r4;
        if (r4 == false) goto L8;
        int r5 = this.f;
    L9:
        ValueAnimator r6 = ObjectAnimator.ofInt(new int[]{this.e.getHeight(), r5});
        this.d = r6;
        r6.setDuration(200);
        this.d.addUpdateListener(new m(this));
        this.d.start();
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public final void p(boolean r7) {
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
        this.d = null;
    L5:
        this.n.e = r7;
        if (r7 == false) goto L8;
        int r1 = this.f;
    L9:
        this.e.getLayoutParams().height = r1;
        this.e.requestLayout();
        FragmentActivity r2 = this.a.getActivity();
        View r3 = this.a.getRootView();
        ViewGroup r4 = this.a.a();
        tt5.a.b("TitleViewUtil", "updateWebContentHeight...");
        if (r2 == null) goto L33;
        if (r4 != null) goto L15;
        return;
    L15:
        if ((r4.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L18;
        return;
    L18:
        if ((r4.getLayoutParams().getBehavior() instanceof OfficeImmersiveWebContainerBehavior) == true) goto L36;
        if (r7 == false) goto L30;
        View r5 = r2.findViewById(2131369266);
        if (r5 != null) goto L25;
        if (r3 == null) goto L25;
        r5 = r3.findViewById(2131369266);
    L25:
        if (r5 == null) goto L37;
        int r8 = r5.getHeight();
        if (r8 > 0) goto L31;
        r8 = Math.round(r2.getResources().getDimension(2131165837));
    L31:
        r4.setPadding(0, r8, 0, 0);
        return;
    L37:
        return;
    L30:
        r8 = 0;
        goto L31
    L36:
        return;
    L33:
        return;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setBackground(int r2) {
        this.e.setBackgroundColor(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setHiddenMenus(List<MenuItem> r1) {
        this.h = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftClickListener(View.OnClickListener r2) {
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L6;
        r0.setLeftClickListener(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftIconVisibility(boolean r2) {
        this.e.setLeftIconVisibility(r2);
        this.e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftVisible(boolean r2) {
        this.e.setLeftVisible(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setMenuIconTint(int r2) {
        this.e.setActionIconTint(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRightVisible(boolean r2) {
        this.e.setRightVisible(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setSubTitle(CharSequence r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.e.setSubTitle(r2.toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitle(CharSequence r2) {
        this.b.setTitle(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleSize(int r2) {
        this.g.setTitleTextSize(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleVisibility(boolean r3) {
        if (r3 == false) goto L9;
        y3 r0 = this.b;
        if (r0 == null) goto L9;
        if (r0.isDocumentType(sbb.e.h) == false) goto L9;
        tt5.a.k("SimpleTitleBar", "sheet title need to hide in mobile!");
        return;
    L9:
        this.g.setTitleVisible(r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTransparent(boolean r2) {
        BaseTitleBar r0 = this.e;
        if (r2 == false) goto L5;
        float r3 = 0.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void show(boolean r3) {
        tt5.a.h("SimpleTitleBar", "show animation:" + r3);
        this.m = true;
        if (r3 == false) goto L5;
        o(true);
        return;
    L5:
        p(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View$OnLayoutChangeListener, com.bytedance.ee.bear.document.titlebar.w] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.bytedance.ee.bear.document.titlebar.n] */
    public d0(c r7, DocViewModel r8) {
        this.i = new CopyOnWriteArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = true;
        com.bytedance.ee.bear.browser.plugin.d r1 = new com.bytedance.ee.bear.browser.plugin.d();
        this.n = r1;
        this.o = new com.bytedance.ee.bear.browser.plugin.d();
        this.a = r7;
        this.b = r8;
        this.c = r7.getTitleBarLayout();
        if (r8.isCommonTemplatePreview() == false) goto L5;
    L10:
        boolean r2 = true;
    L11:
        this.f = Math.round(this.c.getResources().getDimension(2131165837));
        BaseTitleBar r4 = this.c.findViewById(2131369338);
        this.e = r4;
        r4.setSkipCenterMarginWhenLeftAligned(r8.isDocumentType(sbb.e.m));
        KeyEvent.Callback r5 = this.e.getCustomTitleView();
        if ((r5 instanceof com.bytedance.ee.bear.document.titlebar.titleview.a) == false) goto L14;
        this.g = (com.bytedance.ee.bear.document.titlebar.titleview.a) r5;
    L15:
        this.g.setTitleVisible(r2);
        this.g.setTitle("");
        ViewGroup.LayoutParams r3 = this.e.getLayoutParams();
        r3.height = this.f;
        this.e.requestLayout();
        this.e.setVisibility(0);
        r1.e = true;
        this.e.setDividerVisible(false);
        this.e.setTitle("");
        this.e.g();
        this.e.h(6.0f);
        this.e.setLeftClickListener(new u(this));
        this.e.setSupportAutoRemoveBadgePoint(true);
        final GestureDetector r0 = new GestureDetector(this.e.getContext(), new b0(this), new Handler(Looper.getMainLooper()));
        this.e.setOnTouchListener(new v(r0));
        ?? r6 = new w(this);
        this.c.addOnLayoutChangeListener(r6);
        ?? r9 = new n(this);
        this.c.getViewTreeObserver().addOnPreDrawListener(r9);
        this.c.addOnAttachStateChangeListener(new c0(this, r6, r9));
        this.e.b();
        LifecycleOwner r10 = r7.getTitleBarLifecycleOwner();
        r8.getTitleInfo().observe(r10, new o(this));
        LiveData<CharSequence> r11 = r8.getTitle();
        final com.bytedance.ee.bear.document.titlebar.titleview.a r12 = this.g;
        Objects.requireNonNull(r12);
        r11.observe(r10, new p(r12));
        r8.getShowingIconInfo().observe(r10, new q(this));
        r8.getExternalInfo().observe(r10, new r(this));
        r8.getOpenSource();
        DocsOpenSource r13 = DocsOpenSource.vc;
        r8.getOpenSource();
        r8.getOpenSource();
        return;
    L14:
        DocumentOfficeTitleView r14 = new DocumentOfficeTitleView(this.e.getContext());
        r14.setGravity(17);
        r14.setTitleTextSize(2131165738);
        r14.setTitleTextColor(2131106622);
        r14.setTitleTextBold(true);
        r14.setExternalVisible(false);
        this.g = r14;
        this.e.setCustomTitleView(r14.getView());
        goto L15
    L5:
        if (r8.isDocumentType(sbb.e.h) == false) goto L7;
    L9:
        r2 = false;
        goto L11
    L7:
        if (r8.isDocumentType(sbb.e.i) == true) goto L9;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean e(String r2, Drawable r3) {
        return this.e.k(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void j(List<MenuItem> r8, TitleBar.MenuType r9) {
        if (r9 != TitleBar.MenuType.Left) goto L5;
        this.e.f();
        this.k = m(r8);
    L6:
        if (r8 == null) goto L60;
        Iterator<MenuItem> r10 = r8.iterator();
    L9:
        if (r10.hasNext() == false) goto L60;
        MenuItem r0 = r10.next();
        if (r0 == null) goto L9;
        List<MenuItem> r1 = this.h;
        if (r1 != null) goto L15;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L9;
        if (r0.getText() != null) goto L28;
        CharSequence r3 = r0.getSpannableText();
    L30:
        if (r0.getIcon() == null) goto L37;
        ColorStateList r4 = l(r0.getCustomColor());
        if (r4 == null) goto L34;
        BaseTitleBar.c r5 = new x(r0.getIcon(), r4, r0);
    L35:
        r5.j = r0.isUseOriginImageRendering();
    L43:
        c r6 = this.a;
        if (r6 != null) goto L46;
    L50:
        if (r5 == null) goto L51;
        ((BaseTitleBar.b) r5).a = r0.getId();
        ((BaseTitleBar.b) r5).d = r0.isEnable();
        ((BaseTitleBar.b) r5).e = r0.isSelected();
        ((BaseTitleBar.b) r5).b = r0.getBadgeStyle();
        ((BaseTitleBar.b) r5).c = r0.getBadgeNum();
        if ("MESSAGE".equals(r0.getId()) == false) goto L56;
        tt5.a.h("SimpleTitleBar", "badgeNum = " + r0.getBadgeNum());
    L56:
        if (r9 != TitleBar.MenuType.Left) goto L58;
        View r7 = this.e.a(r5, false);
    L59:
        r0.onShow(r7);
        goto L9
    L58:
        r7 = this.e.a(r5, true);
        goto L59
    L51:
        tt5.a.d("SimpleTitleBar", "Bad menu:" + r0);
        goto L9
    L46:
        if (r6.getActionProvider() == null) goto L50;
        BaseTitleBar.c r11 = this.a.getActionProvider().a(r0);
        if (r11 == null) goto L50;
        tt5.a.h("SimpleTitleBar", "get action from provider");
        r5 = r11;
        goto L50
    L34:
        r5 = new y(r0.getIcon(), r0.getText(), r0);
        goto L35
    L37:
        if (r0.getLottieRawRes() == (-1)) goto L40;
        r5 = new z(r0.getIcon(), r0.getLottieRawRes(), r0.getText(), r0);
        goto L43
    L40:
        if (TextUtils.isEmpty(r3) == true) goto L42;
        r5 = new a0(r3, l(r0.getCustomColor()), r0);
        goto L43
    L42:
        r5 = null;
        goto L43
    L28:
        r3 = r0.getText();
        goto L30
    L15:
        if (r1.isEmpty() == true) goto L23;
        Iterator<MenuItem> r12 = this.h.iterator();
    L19:
        if (r12.hasNext() == false) goto L23;
        if (TextUtils.equals(r12.next().getId(), r0.getId()) == false) goto L19;
        r2 = true;
    L60:
        this.e.b();
        return;
    L5:
        this.e.g();
        this.l = m(r8);
        goto L6
    }
}
