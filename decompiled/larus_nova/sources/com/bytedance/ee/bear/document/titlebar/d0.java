package com.bytedance.ee.bear.document.titlebar;

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
import androidx.core.view.GravityCompat;
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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class d0 implements TitleBar {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Range<Float> f222206q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f222207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y3 f222208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppBarLayout f222209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f222210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f222211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f222212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.document.titlebar.titleview.a f222213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<MenuItem> f222214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<TitleBar.a> f222215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TitleBar.b f222216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<MenuItem> f222217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<MenuItem> f222218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f222219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.browser.plugin.d f222220n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.browser.plugin.d f222221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f222222p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222223a = null;

        static {
            int[] r100 = new int[TitleBar.TitleGravity.values().length];
            f222223a = r100;
            r100[TitleBar.TitleGravity.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f222223a[TitleBar.TitleGravity.Center.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface b {
        ot4.e a(MenuItem r100);
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
        this.f222213g.setExternalTagEnabled(false);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRiskFlag(boolean r100) {
    }

    static {
        f222206q = new Range(Float.valueOf(0.0f), Float.valueOf(1.0f));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void clearMenus() {
        this.f222211e.f();
        this.f222211e.g();
        this.f222211e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void f() {
        com.bytedance.ee.bear.document.titlebar.titleview.a r100 = this.f222213g;
        if (r100 == null) goto L6;
        r100.setSpaceTagTitleBarEnabled(false);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final com.bytedance.ee.bear.browser.plugin.d getDeviceInfo() {
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f222220n;
        if (r100.f216618a != 0) goto L6;
        r100.f216618a = com.bytedance.ee.util.ui.n.E(com.bytedance.ee.util.ui.k.e(this.f222209c.getContext()));
        com.bytedance.ee.bear.browser.plugin.d r101 = this.f222220n;
        r101.f216620c = ((Float) f222206q.getUpper()).floatValue();
    L6:
        return this.f222220n;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void invalidate() {
        this.f222211e.invalidate();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean isLeftIconVisible() {
        return this.f222211e.getLeftIconVisibility();
    }

    public final void n() {
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f222220n;
        r100.f216620c = ((Float) f222206q.clamp(Float.valueOf(r100.f216620c))).floatValue();
        if (this.f222220n.equals(this.f222221o) == true) goto L8;
        this.f222221o = new com.bytedance.ee.bear.browser.plugin.d(this.f222220n);
        Iterator r101 = ((CopyOnWriteArrayList) this.f222215i).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((TitleBar.a) r101.next()).onTitleBarStateChanged(this.f222220n);
        goto L6
    L10:
        return;
    }

    public final void q() {
        if (this.f222209c.getHeight() != 0) goto L6;
        this.f222220n.f216620c = ((Float) f222206q.getLower()).floatValue();
        return;
    L6:
        int[] r100 = new int[2];
        this.f222209c.getLocationOnScreen(r100);
        int r101 = r100[1] + com.bytedance.ee.util.ui.n.d(this.f222220n.f216619b);
        int r102 = com.bytedance.ee.util.ui.k.e(this.f222209c.getContext());
        int r103 = r101 - r102;
        this.f222220n.f216618a = com.bytedance.ee.util.ui.n.E(r102);
        com.bytedance.ee.bear.browser.plugin.d r104 = this.f222220n;
        r104.f216620c = com.bytedance.ee.util.ui.n.E(r103) / r104.f216619b;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void d() {
        this.f222213g.setTitleTextColor(R.color.text_title);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final BaseTitleBar getTitleBarLayout() {
        return this.f222211e;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void b(TitleBar.TitleGravity r100) {
        int r101 = a.f222223a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f222213g.setGravity(GravityCompat.START);
        this.f222211e.setIsCenterAlways(false);
    L9:
        this.f222211e.b();
        return;
    L5:
        if (r101 != 2) goto L9;
        this.f222213g.setGravity(17);
        this.f222211e.setIsCenterAlways(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void c(TitleBar.a r100) {
        ((CopyOnWriteArrayList) this.f222215i).remove(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void enableTitleBarAlwaysShowing(boolean r100) {
        this.f222222p = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final View findMenuView(String r100) {
        return this.f222211e.d(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void g(TitleBar.a r100) {
        if (((CopyOnWriteArrayList) this.f222215i).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f222215i).add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void hide(boolean r100) {
        if (this.f222222p == false) goto L5;
        return;
    L5:
        tt5.a.h("SimpleTitleBar", "hide animation:" + r100);
        this.f222219m = false;
        if (r100 == false) goto L8;
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
    public final List<MenuItem> i(TitleBar.MenuType r100) {
        if (r100 != TitleBar.MenuType.Left) goto L6;
        return this.f222217k;
    L6:
        return this.f222218l;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void k(TitleBar.b r100) {
        this.f222216j = r100;
    }

    public final ColorStateList l(List<String> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() == 4) goto L7;
        return null;
    L7:
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{-16842910}, new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{ColorProtector.parseColor((String) ListProtector.get(r100, 1)), ColorProtector.parseColor((String) ListProtector.get(r100, 2)), ColorProtector.parseColor((String) ListProtector.get(r100, 3)), ColorProtector.parseColor((String) ListProtector.get(r100, 0))});
    }

    public final List<MenuItem> m(List<MenuItem> r100) {
        ArrayList r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<MenuItem> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        MenuItem r103 = r102.next();
        if (r103 == null) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    }

    public final void o(boolean r100) {
        ValueAnimator r101 = this.f222210d;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f222210d = null;
    L5:
        this.f222220n.f216622e = r100;
        if (r100 == false) goto L8;
        int r102 = this.f222212f;
    L9:
        ValueAnimator r103 = ObjectAnimator.ofInt(new int[]{this.f222211e.getHeight(), r102});
        this.f222210d = r103;
        r103.setDuration(200);
        this.f222210d.addUpdateListener(new m(this));
        this.f222210d.start();
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public final void p(boolean r100) {
        ValueAnimator r101 = this.f222210d;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f222210d = null;
    L5:
        this.f222220n.f216622e = r100;
        if (r100 == false) goto L8;
        int r102 = this.f222212f;
    L9:
        this.f222211e.getLayoutParams().height = r102;
        this.f222211e.requestLayout();
        FragmentActivity r103 = this.f222207a.getActivity();
        View r104 = this.f222207a.getRootView();
        ViewGroup r105 = this.f222207a.a();
        tt5.a.b("TitleViewUtil", "updateWebContentHeight...");
        if (r103 == null) goto L33;
        if (r105 != null) goto L15;
        return;
    L15:
        if ((r105.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L18;
        return;
    L18:
        if ((((CoordinatorLayout.LayoutParams) r105.getLayoutParams()).getBehavior() instanceof OfficeImmersiveWebContainerBehavior) == true) goto L36;
        if (r100 == false) goto L30;
        View r106 = r103.findViewById(R.id.doc_appbar_layout);
        if (r106 != null) goto L25;
        if (r104 == null) goto L25;
        r106 = r104.findViewById(R.id.doc_appbar_layout);
    L25:
        if (r106 == null) goto L37;
        int r107 = r106.getHeight();
        if (r107 > 0) goto L31;
        r107 = Math.round(r103.getResources().getDimension(R.dimen.doc_titlebar_height));
    L31:
        r105.setPadding(0, r107, 0, 0);
        return;
    L37:
        return;
    L30:
        r107 = 0;
        goto L31
    L36:
        return;
    L33:
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setBackground(int r100) {
        this.f222211e.setBackgroundColor(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setHiddenMenus(List<MenuItem> r100) {
        this.f222214h = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftClickListener(View.OnClickListener r100) {
        BaseTitleBar r101 = this.f222211e;
        if (r101 == null) goto L6;
        r101.setLeftClickListener(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftIconVisibility(boolean r100) {
        this.f222211e.setLeftIconVisibility(r100);
        this.f222211e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftVisible(boolean r100) {
        this.f222211e.setLeftVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setMenuIconTint(int r100) {
        this.f222211e.setActionIconTint(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRightVisible(boolean r100) {
        this.f222211e.setRightVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setSubTitle(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f222211e.setSubTitle(r100.toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitle(CharSequence r100) {
        this.f222208b.setTitle(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleSize(int r100) {
        this.f222213g.setTitleTextSize(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleVisibility(boolean r100) {
        if (r100 == false) goto L9;
        y3 r101 = this.f222208b;
        if (r101 == null) goto L9;
        if (r101.isDocumentType(sbb.e.f541297h) == false) goto L9;
        tt5.a.k("SimpleTitleBar", "sheet title need to hide in mobile!");
        return;
    L9:
        this.f222213g.setTitleVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTransparent(boolean r100) {
        BaseTitleBar r101 = this.f222211e;
        if (r100 == false) goto L5;
        float r102 = 0.0f;
    L6:
        r101.setAlpha(r102);
        return;
    L5:
        r102 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void show(boolean r100) {
        tt5.a.h("SimpleTitleBar", "show animation:" + r100);
        this.f222219m = true;
        if (r100 == false) goto L5;
        o(true);
        return;
    L5:
        p(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View$OnLayoutChangeListener, com.bytedance.ee.bear.document.titlebar.w] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.bytedance.ee.bear.document.titlebar.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public d0(c r100, DocViewModel r101) {
        this.f222215i = new CopyOnWriteArrayList();
        this.f222217k = new ArrayList();
        this.f222218l = new ArrayList();
        this.f222219m = true;
        com.bytedance.ee.bear.browser.plugin.d r102 = new com.bytedance.ee.bear.browser.plugin.d();
        this.f222220n = r102;
        this.f222221o = new com.bytedance.ee.bear.browser.plugin.d();
        this.f222207a = r100;
        this.f222208b = r101;
        this.f222209c = r100.getTitleBarLayout();
        if (r101.isCommonTemplatePreview() == false) goto L5;
    L10:
        boolean r103 = true;
    L11:
        this.f222212f = Math.round(this.f222209c.getResources().getDimension(R.dimen.doc_titlebar_height));
        BaseTitleBar r104 = (BaseTitleBar) this.f222209c.findViewById(R.id.doc_main_title);
        this.f222211e = r104;
        r104.setSkipCenterMarginWhenLeftAligned(r101.isDocumentType(sbb.e.f541302m));
        KeyEvent.Callback r105 = this.f222211e.getCustomTitleView();
        if ((r105 instanceof com.bytedance.ee.bear.document.titlebar.titleview.a) == false) goto L14;
        this.f222213g = (com.bytedance.ee.bear.document.titlebar.titleview.a) r105;
    L15:
        this.f222213g.setTitleVisible(r103);
        this.f222213g.setTitle("");
        ViewGroup.LayoutParams r106 = this.f222211e.getLayoutParams();
        r106.height = this.f222212f;
        this.f222211e.requestLayout();
        this.f222211e.setVisibility(0);
        r102.f216622e = true;
        this.f222211e.setDividerVisible(false);
        this.f222211e.setTitle("");
        this.f222211e.g();
        this.f222211e.h(6.0f);
        this.f222211e.setLeftClickListener(new u(this));
        this.f222211e.setSupportAutoRemoveBadgePoint(true);
        final GestureDetector r107 = new GestureDetector(this.f222211e.getContext(), new b0(this), new Handler(Looper.getMainLooper()));
        this.f222211e.setOnTouchListener(new v(r107));
        ?? r108 = new w(this);
        this.f222209c.addOnLayoutChangeListener(r108);
        ?? r109 = new n(this);
        this.f222209c.getViewTreeObserver().addOnPreDrawListener(r109);
        this.f222209c.addOnAttachStateChangeListener(new c0(this, r108, r109));
        this.f222211e.b();
        LifecycleOwner r110 = r100.getTitleBarLifecycleOwner();
        r101.getTitleInfo().observe(r110, new o(this));
        LiveData<CharSequence> r111 = r101.getTitle();
        final com.bytedance.ee.bear.document.titlebar.titleview.a r112 = this.f222213g;
        Objects.requireNonNull(r112);
        r111.observe(r110, new p(r112));
        r101.getShowingIconInfo().observe(r110, new q(this));
        r101.getExternalInfo().observe(r110, new r(this));
        r101.getOpenSource();
        DocsOpenSource r113 = DocsOpenSource.f216966vc;
        r101.getOpenSource();
        r101.getOpenSource();
        return;
    L14:
        DocumentOfficeTitleView r114 = new DocumentOfficeTitleView(this.f222211e.getContext());
        r114.setGravity(17);
        r114.setTitleTextSize(R.dimen.core_doc_title_bar_text_size);
        r114.setTitleTextColor(R.color.text_title);
        r114.setTitleTextBold(true);
        r114.setExternalVisible(false);
        this.f222213g = r114;
        this.f222211e.setCustomTitleView(r114.getView());
        goto L15
    L5:
        if (r101.isDocumentType(sbb.e.f541297h) == false) goto L7;
    L9:
        r103 = false;
        goto L11
    L7:
        if (r101.isDocumentType(sbb.e.f541298i) == true) goto L9;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean e(String r100, Drawable r101) {
        return this.f222211e.k(r100, r101);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void j(List<MenuItem> r100, TitleBar.MenuType r101) {
        if (r101 != TitleBar.MenuType.Left) goto L5;
        this.f222211e.f();
        this.f222217k = m(r100);
    L6:
        if (r100 == null) goto L60;
        Iterator<MenuItem> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L60;
        MenuItem r103 = r102.next();
        if (r103 == null) goto L9;
        List<MenuItem> r104 = this.f222214h;
        if (r104 != null) goto L15;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == true) goto L9;
        if (r103.getText() != null) goto L28;
        CharSequence r106 = r103.getSpannableText();
    L30:
        if (r103.getIcon() == null) goto L37;
        ColorStateList r107 = l(r103.getCustomColor());
        if (r107 == null) goto L34;
        BaseTitleBar.c r108 = new x(r103.getIcon(), r107, r103);
    L35:
        r108.f240057j = r103.isUseOriginImageRendering();
        BaseTitleBar.b r109 = r108;
    L43:
        c r110 = this.f222207a;
        BaseTitleBar.b r111 = r109;
        if (r110 == null) goto L50;
        r111 = r109;
        if (r110.getActionProvider() == null) goto L50;
        ot4.e r112 = this.f222207a.getActionProvider().a(r103);
        r111 = r109;
        if (r112 == null) goto L50;
        tt5.a.h("SimpleTitleBar", "get action from provider");
        r111 = r112;
    L50:
        if (r111 == null) goto L51;
        r111.f240048a = r103.getId();
        r111.f240051d = r103.isEnable();
        r111.f240052e = r103.isSelected();
        r111.f240049b = r103.getBadgeStyle();
        r111.f240050c = r103.getBadgeNum();
        if ("MESSAGE".equals(r103.getId()) == false) goto L56;
        tt5.a.h("SimpleTitleBar", "badgeNum = " + r103.getBadgeNum());
    L56:
        if (r101 != TitleBar.MenuType.Left) goto L58;
        View r113 = this.f222211e.a(r111, false);
    L59:
        r103.onShow(r113);
        goto L9
    L58:
        r113 = this.f222211e.a(r111, true);
        goto L59
    L51:
        tt5.a.d("SimpleTitleBar", "Bad menu:" + r103);
        goto L9
    L34:
        r108 = new y(r103.getIcon(), r103.getText(), r103);
        goto L35
    L37:
        if (r103.getLottieRawRes() == (-1)) goto L40;
        r109 = new z(r103.getIcon(), r103.getLottieRawRes(), r103.getText(), r103);
        goto L43
    L40:
        if (TextUtils.isEmpty(r106) == true) goto L42;
        r109 = new a0(r106, l(r103.getCustomColor()), r103);
        goto L43
    L42:
        r109 = null;
        goto L43
    L28:
        r106 = r103.getText();
        goto L30
    L15:
        if (r104.isEmpty() == true) goto L23;
        Iterator<MenuItem> r114 = this.f222214h.iterator();
    L19:
        if (r114.hasNext() == false) goto L23;
        if (TextUtils.equals(r114.next().getId(), r103.getId()) == false) goto L19;
        r105 = true;
    L60:
        this.f222211e.b();
        return;
    L5:
        this.f222211e.g();
        this.f222218l = m(r100);
        goto L6
    }
}
