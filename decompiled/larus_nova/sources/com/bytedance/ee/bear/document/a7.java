package com.bytedance.ee.bear.document;

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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.titlebar.ImmersiveWebContainerBehavior;
import com.bytedance.ee.bear.document.titlebar.titleview.DocumentTitleView;
import com.bytedance.ee.bear.templates.TemplateViewModel;
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
public class a7 implements TitleBar {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Range<Float> f218652q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f218653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y3 f218654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppBarLayout f218655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f218656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f218657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f218658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.document.titlebar.titleview.b f218659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<MenuItem> f218660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<TitleBar.a> f218661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TitleBar.b f218662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<MenuItem> f218663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<MenuItem> f218664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f218665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.browser.plugin.d f218666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.browser.plugin.d f218667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f218668p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218669a = null;

        static {
            int[] r100 = new int[TitleBar.TitleGravity.values().length];
            f218669a = r100;
            r100[TitleBar.TitleGravity.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f218669a[TitleBar.TitleGravity.Center.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface b {
        ot4.e a(MenuItem r100);
    }

    public interface c {
        b getActionProvider();

        FragmentActivity getActivity();

        View getRootView();

        AppBarLayout getTitleBarLayout();

        LifecycleOwner getTitleBarLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void h() {
        this.f218659g.setExternalTagEnabled(false);
    }

    public float n() {
        return 6.0f;
    }

    public int o() {
        return 50;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRiskFlag(boolean r100) {
    }

    static {
        f218652q = new Range(Float.valueOf(0.0f), Float.valueOf(1.0f));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public View a() {
        return findMenuView("MORE_OPERATE");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void clearMenus() {
        this.f218657e.f();
        this.f218657e.g();
        this.f218657e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void f() {
        com.bytedance.ee.bear.document.titlebar.titleview.b r100 = this.f218659g;
        if (r100 == null) goto L6;
        r100.setSpaceTagTitleBarEnabled(false);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final com.bytedance.ee.bear.browser.plugin.d getDeviceInfo() {
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f218666n;
        if (r100.f216618a != 0) goto L6;
        r100.f216618a = com.bytedance.ee.util.ui.n.E(com.bytedance.ee.util.ui.k.e(this.f218655c.getContext()));
        com.bytedance.ee.bear.browser.plugin.d r101 = this.f218666n;
        r101.f216620c = ((Float) f218652q.getUpper()).floatValue();
    L6:
        return this.f218666n;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void invalidate() {
        this.f218657e.invalidate();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean isLeftIconVisible() {
        return this.f218657e.getLeftIconVisibility();
    }

    public int p() {
        return Math.round(this.f218655c.getResources().getDimension(R.dimen.doc_titlebar_height));
    }

    public final void q() {
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f218666n;
        r100.f216620c = ((Float) f218652q.clamp(Float.valueOf(r100.f216620c))).floatValue();
        if (this.f218666n.equals(this.f218667o) == true) goto L8;
        this.f218667o = new com.bytedance.ee.bear.browser.plugin.d(this.f218666n);
        Iterator r101 = ((CopyOnWriteArrayList) this.f218661i).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((TitleBar.a) r101.next()).onTitleBarStateChanged(this.f218666n);
        goto L6
    L10:
        return;
    }

    public final void r() {
        if (com.bytedance.ee.util.ui.b.a(this.f218653a.getActivity()) == false) goto L6;
        tt5.a.h("SimpleTitleBar", "onBackPressed() called");
        this.f218653a.getActivity().onBackPressed();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.view.View$OnLayoutChangeListener, com.bytedance.ee.bear.document.q6] */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.view.ViewTreeObserver$OnPreDrawListener, com.bytedance.ee.bear.document.r6] */
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
    public void s() {
        this.f218655c = this.f218653a.getTitleBarLayout();
        boolean r100 = u();
        this.f218658f = p();
        BaseTitleBar r101 = (BaseTitleBar) this.f218655c.findViewById(R.id.doc_main_title);
        this.f218657e = r101;
        KeyEvent.Callback r102 = r101.getCustomTitleView();
        if ((r102 instanceof com.bytedance.ee.bear.document.titlebar.titleview.b) == false) goto L5;
        this.f218659g = (com.bytedance.ee.bear.document.titlebar.titleview.b) r102;
    L6:
        this.f218659g.setTitleVisible(r100);
        this.f218659g.setTitle("");
        ViewGroup.LayoutParams r103 = this.f218657e.getLayoutParams();
        r103.height = this.f218658f;
        this.f218657e.requestLayout();
        boolean r104 = false;
        this.f218657e.setVisibility(0);
        this.f218666n.f216622e = true;
        this.f218657e.setDividerVisible(false);
        this.f218657e.setTitle("");
        this.f218657e.g();
        this.f218657e.h(n());
        this.f218657e.setLeftClickListener(new o6(this));
        this.f218657e.setSupportAutoRemoveBadgePoint(true);
        final GestureDetector r105 = new GestureDetector(this.f218657e.getContext(), new y6(this), new Handler(Looper.getMainLooper()));
        this.f218657e.setOnTouchListener(new p6(r105));
        ?? r106 = new q6(this);
        this.f218655c.addOnLayoutChangeListener(r106);
        ?? r107 = new r6(this);
        this.f218655c.getViewTreeObserver().addOnPreDrawListener(r107);
        this.f218655c.addOnAttachStateChangeListener(new z6(this, r106, r107));
        this.f218657e.b();
        LifecycleOwner r108 = this.f218653a.getTitleBarLifecycleOwner();
        this.f218654b.getTitleInfo().observe(r108, new i6(this));
        t(r108);
        this.f218654b.getExternalInfo().observe(r108, new l6(this));
        if (this.f218654b.getOpenSource() != DocsOpenSource.template_preview) goto L9;
        boolean r109 = true;
    L11:
        if (this.f218654b.getOpenSource() != DocsOpenSource.f216966vc) goto L13;
        boolean r110 = true;
    L15:
        if (this.f218654b.getOpenSource() != DocsOpenSource.base_instruction_docx) goto L17;
        r104 = true;
    L17:
        if (r109 == true) goto L23;
        if (r110 == true) goto L24;
        if (r104 == true) goto L25;
        ((TemplateViewModel) ViewModelProviders.of(this.f218653a.getActivity()).get(TemplateViewModel.class)).getTemplateTagStatueLiveData().observe(this.f218653a.getTitleBarLifecycleOwner(), new n6(this));
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r110 = false;
        goto L15
    L9:
        r109 = false;
        goto L11
    L5:
        DocumentTitleView r111 = v05.g.a(this.f218657e.getContext());
        this.f218659g = r111;
        this.f218657e.setCustomTitleView(r111.getView());
        goto L6
    }

    public boolean u() {
        if (this.f218654b.isCommonTemplatePreview() == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f218654b.isDocumentType(sbb.e.f541297h) == false) goto L7;
    L9:
        return false;
    L7:
        if (this.f218654b.isDocumentType(sbb.e.f541298i) == true) goto L9;
        goto L9
    }

    public final void x() {
        if (this.f218655c.getHeight() != 0) goto L6;
        this.f218666n.f216620c = ((Float) f218652q.getLower()).floatValue();
        return;
    L6:
        int[] r100 = new int[2];
        this.f218655c.getLocationOnScreen(r100);
        int r101 = r100[1] + com.bytedance.ee.util.ui.n.d(this.f218666n.f216619b);
        int r102 = com.bytedance.ee.util.ui.k.e(this.f218655c.getContext());
        int r103 = r101 - r102;
        this.f218666n.f216618a = com.bytedance.ee.util.ui.n.E(r102);
        com.bytedance.ee.bear.browser.plugin.d r104 = this.f218666n;
        r104.f216620c = com.bytedance.ee.util.ui.n.E(r103) / r104.f216619b;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void d() {
        this.f218659g.setTitleTextColor(R.color.text_title);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final BaseTitleBar getTitleBarLayout() {
        return this.f218657e;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void b(TitleBar.TitleGravity r100) {
        int r101 = a.f218669a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f218659g.setGravity(GravityCompat.START);
        this.f218657e.setIsCenterAlways(false);
    L9:
        this.f218657e.b();
        return;
    L5:
        if (r101 != 2) goto L9;
        this.f218659g.setGravity(17);
        this.f218657e.setIsCenterAlways(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void c(TitleBar.a r100) {
        ((CopyOnWriteArrayList) this.f218661i).remove(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void enableTitleBarAlwaysShowing(boolean r100) {
        this.f218668p = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final View findMenuView(String r100) {
        return this.f218657e.d(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void g(TitleBar.a r100) {
        if (((CopyOnWriteArrayList) this.f218661i).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f218661i).add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void hide(boolean r100) {
        if (this.f218668p == false) goto L5;
        return;
    L5:
        tt5.a.h("SimpleTitleBar", "hide animation:" + r100);
        this.f218665m = false;
        if (r100 == false) goto L8;
        v(false);
    L9:
        x();
        q();
        return;
    L8:
        w(false);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public List<MenuItem> i(TitleBar.MenuType r100) {
        if (r100 != TitleBar.MenuType.Left) goto L6;
        return this.f218663k;
    L6:
        return this.f218664l;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void k(TitleBar.b r100) {
        this.f218662j = r100;
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

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setBackground(int r100) {
        this.f218657e.setBackgroundColor(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setHiddenMenus(List<MenuItem> r100) {
        this.f218660h = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftClickListener(View.OnClickListener r100) {
        BaseTitleBar r101 = this.f218657e;
        if (r101 == null) goto L6;
        r101.setLeftClickListener(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftIconVisibility(boolean r100) {
        this.f218657e.setLeftIconVisibility(r100);
        this.f218657e.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftVisible(boolean r100) {
        this.f218657e.setLeftVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setMenuIconTint(int r100) {
        this.f218657e.setActionIconTint(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRightVisible(boolean r100) {
        this.f218657e.setRightVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setSubTitle(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f218657e.setSubTitle(r100.toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitle(CharSequence r100) {
        this.f218654b.setTitle(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleSize(int r100) {
        this.f218659g.setTitleTextSize(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleVisibility(boolean r100) {
        if (r100 == false) goto L9;
        y3 r101 = this.f218654b;
        if (r101 == null) goto L9;
        if (r101.isDocumentType(sbb.e.f541297h) == false) goto L9;
        tt5.a.k("SimpleTitleBar", "sheet title need to hide in mobile!");
        return;
    L9:
        this.f218659g.setTitleVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTransparent(boolean r100) {
        BaseTitleBar r101 = this.f218657e;
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
        this.f218665m = true;
        if (r100 == false) goto L5;
        v(true);
        return;
    L5:
        w(true);
    }

    public void t(LifecycleOwner r100) {
        LiveData<CharSequence> r101 = this.f218654b.getTitle();
        final com.bytedance.ee.bear.document.titlebar.titleview.b r102 = this.f218659g;
        Objects.requireNonNull(r102);
        r101.observe(r100, new j6(r102));
        this.f218654b.getShowingIconInfo().observe(r100, new k6(this));
    }

    public final void v(boolean r100) {
        ValueAnimator r101 = this.f218656d;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f218656d = null;
    L5:
        this.f218666n.f216622e = r100;
        if (r100 == false) goto L8;
        int r102 = this.f218658f;
    L9:
        ValueAnimator r103 = ObjectAnimator.ofInt(new int[]{this.f218657e.getHeight(), r102});
        this.f218656d = r103;
        r103.setDuration(200);
        this.f218656d.addUpdateListener(new m6(this));
        this.f218656d.start();
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public final void w(boolean r100) {
        ValueAnimator r101 = this.f218656d;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f218656d = null;
    L5:
        this.f218666n.f216622e = r100;
        if (r100 == false) goto L8;
        int r102 = this.f218658f;
    L9:
        this.f218657e.getLayoutParams().height = r102;
        this.f218657e.requestLayout();
        FragmentActivity r103 = this.f218653a.getActivity();
        View r104 = this.f218653a.getRootView();
        tt5.a.b("DocumentViewUtil", "updateWebContentHeight...");
        if (r103 == null) goto L37;
        View r105 = r103.findViewById(R.id.contentOuterContainer);
        if (r105 != null) goto L16;
        if (r104 == null) goto L16;
        r105 = r104.findViewById(R.id.contentOuterContainer);
    L16:
        if (r105 != null) goto L19;
        return;
    L19:
        if ((r105.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == true) goto L22;
        return;
    L22:
        if ((((CoordinatorLayout.LayoutParams) r105.getLayoutParams()).getBehavior() instanceof ImmersiveWebContainerBehavior) == true) goto L40;
        if (r100 == false) goto L34;
        View r106 = r103.findViewById(R.id.doc_appbar_layout);
        if (r106 != null) goto L29;
        if (r104 == null) goto L29;
        r106 = r104.findViewById(R.id.doc_appbar_layout);
    L29:
        if (r106 == null) goto L41;
        int r107 = r106.getHeight();
        if (r107 > 0) goto L35;
        r107 = Math.round(r103.getResources().getDimension(R.dimen.doc_titlebar_height));
    L35:
        r105.setPadding(0, r107, 0, 0);
        return;
    L41:
        return;
    L34:
        r107 = 0;
        goto L35
    L40:
        return;
    L37:
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public a7(c r100, DocViewModel r101) {
        this.f218661i = new CopyOnWriteArrayList();
        this.f218663k = new ArrayList();
        this.f218664l = new ArrayList();
        this.f218665m = true;
        this.f218666n = new com.bytedance.ee.bear.browser.plugin.d();
        this.f218667o = new com.bytedance.ee.bear.browser.plugin.d();
        this.f218653a = r100;
        this.f218654b = r101;
        s();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public boolean e(String r100, Drawable r101) {
        return this.f218657e.k(r100, r101);
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
    public void j(List<MenuItem> r100, TitleBar.MenuType r101) {
        if (r101 != TitleBar.MenuType.Left) goto L5;
        this.f218657e.f();
        this.f218663k = m(r100);
    L6:
        if (r100 == null) goto L60;
        Iterator<MenuItem> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L60;
        MenuItem r103 = r102.next();
        if (r103 == null) goto L9;
        List<MenuItem> r104 = this.f218660h;
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
        BaseTitleBar.c r108 = new u6(r103.getIcon(), r107, r103);
    L35:
        r108.f240057j = r103.isUseOriginImageRendering();
        BaseTitleBar.b r109 = r108;
    L43:
        c r110 = this.f218653a;
        BaseTitleBar.b r111 = r109;
        if (r110 == null) goto L50;
        r111 = r109;
        if (r110.getActionProvider() == null) goto L50;
        ot4.e r112 = this.f218653a.getActionProvider().a(r103);
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
        View r113 = this.f218657e.a(r111, false);
    L59:
        r103.onShow(r113);
        goto L9
    L58:
        r113 = this.f218657e.a(r111, true);
        goto L59
    L51:
        tt5.a.d("SimpleTitleBar", "Bad menu:" + r103);
        goto L9
    L34:
        r108 = new v6(r103.getIcon(), r103.getText(), r103);
        goto L35
    L37:
        if (r103.getLottieRawRes() == (-1)) goto L40;
        r109 = new w6(r103.getIcon(), r103.getLottieRawRes(), r103.getText(), r103);
        goto L43
    L40:
        if (TextUtils.isEmpty(r106) == true) goto L42;
        r109 = new x6(r106, l(r103.getCustomColor()), r103);
        goto L43
    L42:
        r109 = null;
        goto L43
    L28:
        r106 = r103.getText();
        goto L30
    L15:
        if (r104.isEmpty() == true) goto L23;
        Iterator<MenuItem> r114 = this.f218660h.iterator();
    L19:
        if (r114.hasNext() == false) goto L23;
        if (TextUtils.equals(r114.next().getId(), r103.getId()) == false) goto L19;
        r105 = true;
    L60:
        this.f218657e.b();
        return;
    L5:
        this.f218657e.g();
        this.f218664l = m(r100);
        goto L6
    }
}
