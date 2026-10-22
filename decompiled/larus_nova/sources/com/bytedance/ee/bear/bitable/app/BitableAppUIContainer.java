package com.bytedance.ee.bear.bitable.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.app.model.AppTheme;
import com.bytedance.ee.bear.bitable.app.model.NavigationBarColor;
import com.bytedance.ee.bear.bitable.app.titlebar.BitableAppTitleBarAdapter;
import com.bytedance.ee.bear.bitable.card.view.BitableCardFragment;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.container.BitableFullTableFragment;
import com.bytedance.ee.bear.bitable.itemview.ItemViewFragment;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.r;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.WebViewFragment;
import com.bytedance.ee.bear.document.restore.DocDeletedCtrlView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableAppUIContainer extends r implements com.bytedance.ee.bear.bitable.app.chameleon.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WebViewFragment f206848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o f206849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DocViewModel f206850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BitableAppDrawerManager f206851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.utils.c.a f206852n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f206853o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f206854p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f206855q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f206856r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.infoarch.swipe.a f206857s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f206858t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Set<Class<? extends Fragment>> f206859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, WeakReference<Fragment>> f206860v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, Boolean> f206861w;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.app.BitableAppUIContainer$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(Object r100) {
            super(1, r100, BitableAppUIContainer.class, "updateTitlerBarOnDrawerStateChanged", "updateTitlerBarOnDrawerStateChanged(Z)V", 0);
        }

        public final void invoke(boolean r100) {
            BitableAppUIContainer r101 = (BitableAppUIContainer) this.receiver;
            if (r101.f216637c.getWidth() > com.bytedance.ee.util.ui.n.d(600)) goto L5;
            if (r100 == false) goto L5;
            return;
        L5:
            TitleBar r102 = r101.getTitleBar();
            if ((r102 instanceof BitableAppTitleBarAdapter) == false) goto L8;
            BitableAppTitleBarAdapter r103 = (BitableAppTitleBarAdapter) r102;
        L9:
            if (r103 == null) goto L15;
            MutableLiveData<Boolean> r104 = r103.f206959s;
            if (r104 == null) goto L16;
            r104.setValue(Boolean.valueOf(r100));
            return;
        L16:
            return;
        L15:
            return;
        L8:
            r103 = null;
            goto L9
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void Ha() {
        this.f206856r = true;
        if (h18.f.a(getContext()) == false) goto L5;
        String r100 = "#262626";
    L6:
        S2(new AppTheme("Default", r100, null, null, null, null, null, 124, null));
        jc(false);
        s();
        getTitleBar().setLeftVisible(false);
        getTitleBar().setTitleVisibility(false);
        return;
    L5:
        r100 = "#F8F9FA";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void n5() {
        this.f206856r = false;
        getTitleBar().setLeftVisible(true);
        getTitleBar().setTitleVisibility(true);
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean Y4() {
        return !this.f206860v.isEmpty();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void destroy() {
        this.f206851m.a();
        com.bytedance.ee.bear.bitable.utils.c.a r100 = this.f206852n;
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    public final void p() {
        View r100 = (View) this.f206855q.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = r();
        if (r101 == null) goto L11;
        int r102 = r101.intValue();
        if (r100.getPaddingTop() == r102) goto L12;
        r100.setPadding(r100.getPaddingLeft(), r102, r100.getPaddingRight(), r100.getPaddingBottom());
        return;
    L12:
        return;
    }

    public final void q() {
        View r100 = this.f216637c.findViewById(R.id.permission_forbid_layout);
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = r();
        if (r101 == null) goto L9;
        com.bytedance.ee.bear.bitable.m.u(r100, r101.intValue(), false);
        return;
    }

    public final void s() {
        FragmentManager r100 = this.f216638d;
        if (r100.getBackStackEntryCount() <= 0) goto L6;
        r100.popBackStack(null, 1);
    L6:
        if ((!r100.getFragments().isEmpty()) == false) goto L12;
        FragmentTransaction r101 = r100.beginTransaction();
        Iterator<Fragment> r102 = r100.getFragments().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r101.remove(r102.next());
        goto L9
    L11:
        r101.commitNowAllowingStateLoss();
    L12:
        ((HashMap) this.f216643i).clear();
        ((HashMap) this.f216642h).clear();
        ((LinkedHashMap) this.f206860v).clear();
        ((LinkedHashMap) this.f206861w).clear();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void w0() {
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r100 = this.f206857s;
        if (r100 == null) goto L6;
        r100.w0();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void y() {
        this.f206851m.y();
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void p9() {
        getTitleBar().setLeftVisible(true);
        getTitleBar().setTitleVisibility(true);
    }

    public final Integer r() {
        TitleBar r100 = getTitleBar();
        if ((r100 instanceof BitableAppTitleBarAdapter) == false) goto L5;
        BitableAppTitleBarAdapter r101 = (BitableAppTitleBarAdapter) r100;
    L6:
        if (r101 == null) goto L8;
        AppBarLayout r102 = r101.f218653a.getTitleBarLayout();
    L9:
        boolean r103 = false;
        if (r102 == null) goto L30;
        if (r102.getVisibility() != 0) goto L30;
        Integer r104 = Integer.valueOf(r102.getMeasuredHeight());
        if (r104.intValue() <= 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L21;
        r104 = null;
    L21:
        if (r104 != null) goto L28;
        Integer r106 = Integer.valueOf(r102.getHeight());
        if (r106.intValue() <= 0) goto L25;
        r103 = true;
    L25:
        if (r103 == true) goto L32;
        return null;
    L32:
        return r106;
    L28:
        return r104;
    L17:
        r105 = false;
    L30:
        return 0;
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean mo() {
        return this.f206856r;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void Hf(DocDeletedCtrlView r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if (h18.f.a(getContext()) == false) goto L5;
        String r100 = "#262626";
    L6:
        S2(new AppTheme("Default", r100, null, null, null, null, null, 124, null));
        jc(false);
        s();
        getTitleBar().setLeftVisible(false);
        getTitleBar().setTitleVisibility(false);
        ViewGroup r101 = (ViewGroup) this.f216637c.findViewById(R.id.bitable_app_content_container);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.indexOfChild(r110) == (-1)) goto L13;
        return;
    L13:
        if (r110.getParent() == null) goto L20;
        ViewParent r102 = r110.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L17;
        ViewGroup r103 = (ViewGroup) r102;
    L18:
        if (r103 == null) goto L20;
        r103.removeView(r110);
        goto L20
    L17:
        r103 = null;
    L20:
        r101.addView(r110);
        return;
    L5:
        r100 = "#F8F9FA";
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void S2(AppTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "appTheme");
        this.f206849k.a(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void d(com.bytedance.ee.bear.browser.plugin.f<?> r100) {
        Fragment r101 = l(r100);
        if (r101 != null) goto L5;
    L13:
        super.d(r100);
        return;
    L5:
        if (this.f206859u.contains(r101.getClass()) == false) goto L13;
        String r102 = r100.getClass().getName();
        this.f206860v.remove(r102);
        Boolean r103 = this.f206861w.remove(r102);
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();
    L10:
        t(r104, null);
        View r105 = this.f206848j.getView();
        if (r105 == null) goto L13;
        r105.requestApplyInsets();
        goto L13
    L9:
        r104 = this.f206854p;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void ed(NavigationBarColor r100) {
        Intrinsics.checkNotNullParameter(r100, "colorModel");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = Color.parseColor(r100.getBgColor());     // Catch: Throwable -> L5
        this.f206858t = Integer.valueOf(r102);     // Catch: Throwable -> L5
        t(this.f206853o, Integer.valueOf(r102));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        tt5.a.e("BitableAppUIContainer", "setNavigationBarColor failed", r104, false);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void gc(qo4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        IconInfo r101 = null;
        if (this.f206851m.c() == false) goto L5;
        this.f206851m.d(r100, null);
        return;
    L5:
        TitleBar r102 = getTitleBar();
        MenuItem r103 = new MenuItem(BitableAppFrameworkPlugin.MENU_ID_DRAWER, com.bytedance.ee.util.ui.l.a(getContext(), R.drawable.ud_icon_menu_outlined, R.color.facade_selector_icon_n1), null);
        r103.setClickListener(new n(this));
        Unit r104 = Unit.INSTANCE;
        r102.j(CollectionsKt.mutableListOf(new MenuItem[]{r103}), TitleBar.MenuType.Left);
        DocViewModel r105 = this.f206848j.H0();
        if (r105 == null) goto L11;
        LiveData<String> r106 = r105.getDocName();
        if (r106 == null) goto L11;
        String r107 = r106.getValue();
        if (r107 == null) goto L11;
    L12:
        DocViewModel r108 = this.f206848j.H0();
        if (r108 == null) goto L17;
        MutableLiveData<IconInfo> r109 = r108.getShowingIconInfo();
        if (r109 == null) goto L17;
        r101 = r109.getValue();
    L17:
        this.f206851m.d(r100, o(r107, r101));
        return;
    L11:
        r107 = "";
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void hl(boolean r100) {
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r101 = this.f206857s;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final boolean jc(boolean r100) {
        tt5.a.h("BitableAppUIContainer", "setFullscreen: " + r100);
        TitleBar r101 = getTitleBar();
        Integer r102 = null;
        if ((r101 instanceof BitableAppTitleBarAdapter) == false) goto L5;
        BitableAppTitleBarAdapter r103 = (BitableAppTitleBarAdapter) r101;
    L6:
        if (r103 == null) goto L8;
        AppBarLayout r104 = r103.f218653a.getTitleBarLayout();
    L10:
        if (r104 == null) goto L49;
        View r105 = this.f216637c;
        if ((r105 instanceof ViewGroup) == false) goto L14;
        ViewGroup r106 = (ViewGroup) r105;
    L16:
        if (r106 == null) goto L51;
        r106.suppressLayout(true);
    L51:
        if (r100 == true) goto L20;
        r104.setVisibility(0);     // Catch: Throwable -> L45
        this.f206858t = null;     // Catch: Throwable -> L45
        t(true, null);     // Catch: Throwable -> L45
        Integer r107 = Integer.valueOf(r104.getMeasuredHeight());     // Catch: Throwable -> L45
        if (r107.intValue() <= 0) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == false) goto L32;
        r102 = r107;
    L32:
        if (r102 == null) goto L34;
        int r109 = r102.intValue();     // Catch: Throwable -> L45
    L35:
        View r110 = (View) this.f206855q.getValue();     // Catch: Throwable -> L45
        if (r110 == null) goto L38;
        r110.setPadding(r110.getPaddingLeft(), r109, r110.getPaddingRight(), r110.getPaddingBottom());     // Catch: Throwable -> L45
    L38:
        tt5.a.h("BitableAppUIContainer", "Exit fullscreen mode, show app bar");     // Catch: Throwable -> L45
    L39:
        View r111 = this.f216637c;     // Catch: Throwable -> L45
        if (r111 == null) goto L42;
        r111.requestApplyInsets();     // Catch: Throwable -> L45
    L42:
        if (r106 == null) goto L44;
        r106.suppressLayout(false);
    L44:
        return true;
    L34:
        r109 = r104.getHeight();     // Catch: Throwable -> L45
        goto L35
    L29:
        r108 = false;
        goto L30
    L20:
        if (this.f206851m.f206808g == false) goto L22;
        y();     // Catch: Throwable -> L45
    L22:
        t(false, null);     // Catch: Throwable -> L45
        r104.setVisibility(8);     // Catch: Throwable -> L45
        View r112 = (View) this.f206855q.getValue();     // Catch: Throwable -> L45
        if (r112 == null) goto L25;
        r112.setPadding(r112.getPaddingLeft(), 0, r112.getPaddingRight(), r112.getPaddingBottom());     // Catch: Throwable -> L45
    L25:
        tt5.a.h("BitableAppUIContainer", "Enter fullscreen mode, hide app bar");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        if (r106 == null) goto L48;
        r106.suppressLayout(false);
    L48:
        throw th;
    L14:
        r106 = null;
        goto L16
    L49:
        tt5.a.d("BitableAppUIContainer", "Cannot find doc_appbar_layout");
        return false;
    L8:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void onConfigurationChanged(Configuration r100) {
        if (this.f206851m.f206808g == false) goto L6;
        y();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.app.chameleon.d
    public final void kk(FragmentActivity r100, tb5.m r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.ee.bear.bitable.infoarch.swipe.a r102 = this.f206857s;
        if (r102 == null) goto L6;
        r102.b(new com.bytedance.ee.bear.bitable.infoarch.swipe.c(r100, r101));
        return;
    }

    public final String o(String r100, IconInfo r101) {
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L13;
        if (r101 != null) goto L13;
        return null;
    L13:
        return mu5.b.e(MapsKt.mapOf(new Pair[]{TuplesKt.to("title", r100), TuplesKt.to("icon_info", r101)}));
    L5:
        if (StringsKt.isBlank(r100) != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void t(boolean r100, Integer r101) {
        u(this, r100, r101, false, 4);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void e(com.bytedance.ee.bear.browser.plugin.f<?> r100, Fragment r101, s r102) {
        super.e(r100, r101, r102);
        if (r100 == null) goto L9;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f206859u.contains(r101.getClass()) == false) goto L11;
        String r103 = r100.getClass().getName();
        Map<String, WeakReference<Fragment>> r104 = this.f206860v;
        Intrinsics.checkNotNull(r103);
        r104.put(r103, new WeakReference(r101));
        this.f206861w.put(r103, Boolean.valueOf(this.f206853o));
        t(r100.isViewImmersive(), 0);
        return;
    L11:
        return;
    }

    public BitableAppUIContainer(WebViewFragment r210, final View r211, FragmentManager r212, final TitleBar r213) {
        Intrinsics.checkNotNullParameter(r210, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r211, "contentView");
        Intrinsics.checkNotNullParameter(r212, "childFragmentManager");
        Intrinsics.checkNotNullParameter(r213, "titleBar");
        super(r210.requireContext(), r211, r212, r213);
        this.f206848j = r210;
        o r110 = new o(r211, new BitableAppUIContainer$themeController$1(r213));
        this.f206849k = r110;
        this.f206850l = r210.H0();
        Context r111 = r210.requireContext();
        Lifecycle r112 = r210.getLifecycle();
        LifecycleOwner r113 = r210.getViewLifecycleOwner();
        Function0<String> r114 = new BitableAppUIContainer$drawerManager$1(this);
        int r100 = g.f206930h;
        Intrinsics.checkNotNullParameter(r211, "contentView");
        BitableAppDrawerManager r115 = new BitableAppDrawerManager(r111, r112, r113, r114, new g(r211, (ViewGroup) r211.findViewById(R.id.touch_detect_wrapper), (FrameLayout) r211.findViewById(R.id.bitable_app_drawer_container), r211.findViewById(R.id.bitable_app_content_layout), r211.findViewById(R.id.bitable_app_content_container), r211.findViewById(R.id.doc_appbar_layout), true), r110.f206955d);
        this.f206851m = r115;
        this.f206855q = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BitableAppUIContainer$contentContainer$2(r211));
        AppBarLayout r101 = null;
        if (this.f206852n != null) goto L8;
        FragmentActivity r102 = r210.getActivity();
        if (r102 == null) goto L7;
        this.f206852n = com.bytedance.ee.bear.bitable.utils.c.b(r102, r210, false);
    L7:
        u(this, true, null, true, 2);
        i r103 = new i(this);
        Intrinsics.checkNotNullParameter(r103, "observer");
        r110.f206955d.observe(r210.getViewLifecycleOwner(), r103);
    L8:
        DocViewModel r104 = r210.H0();
        if (r104 == null) goto L13;
        LiveData<String> r105 = r104.getDocName();
        if (r105 == null) goto L13;
        r105.observe(r210.getViewLifecycleOwner(), new j(this));
    L13:
        DocViewModel r106 = r210.H0();
        if (r106 == null) goto L19;
        MutableLiveData<IconInfo> r107 = r106.getShowingIconInfo();
        if (r107 == null) goto L19;
        r107.observe(r210.getViewLifecycleOwner(), new k(this));
    L19:
        if (h18.f.a(getContext()) == false) goto L21;
        String r108 = "#262626";
    L22:
        r211.setBackgroundColor(ColorProtector.parseColor(r108));
        AnonymousClass1 r109 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r109, "listener");
        Intrinsics.checkNotNullParameter(r109, "listener");
        r115.f206820s = r109;
        TitleBar r116 = getTitleBar();
        if ((r116 instanceof BitableAppTitleBarAdapter) == false) goto L25;
        BitableAppTitleBarAdapter r117 = (BitableAppTitleBarAdapter) r116;
    L26:
        if (r117 == null) goto L28;
        r101 = r117.f218653a.getTitleBarLayout();
    L28:
        if (r101 == null) goto L30;
        r101.addOnLayoutChangeListener(new l(this));
    L30:
        p();
        q();
        if (r101 == null) goto L33;
        r101.post(new m(this));
    L33:
        this.f206859u = SetsKt.setOf(new Class[]{BitableCardFragment.class, BitableFullTableFragment.class, ItemViewFragment.class});
        this.f206860v = new LinkedHashMap();
        this.f206861w = new LinkedHashMap();
        return;
    L25:
        r117 = null;
        goto L26
    L21:
        r108 = "#F8F9FA";
        goto L22
    }

    public static void u(BitableAppUIContainer r100, boolean r101, Integer r102, boolean r103, int r104) {
        Integer r105 = null;
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        int r106 = 0;
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        r100.getClass();
        tt5.a.b("BitableAppUIContainer", "setStatusBar: set consume: " + r101 + ", consumeStatusBar:" + r100.f206853o + ", color:" + r102);
        r100.f206854p = r100.f206853o;
        r100.f206853o = r101;
        if (r102 == null) goto L11;
        r106 = r102.intValue();
    L22:
        com.bytedance.ee.bear.bitable.utils.c.a r107 = r100.f206852n;
        if (r107 == null) goto L30;
        boolean r108 = !r100.f206853o;
        int r109 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.status_bar.reset") == true) goto L28;
        r103 = true;
    L28:
        r107.j(r106, r108, r103);
        return;
    L30:
        return;
    L11:
        Integer r110 = r100.f206858t;
        if (r110 != null) goto L21;
        AppTheme r111 = r100.f206849k.f206955d.getValue();
        if (r111 == null) goto L19;
        String r112 = r111.getNavigationBgColor();
        if (r112 == null) goto L19;
        r105 = Integer.valueOf(ColorProtector.parseColor(r112));
    L19:
        if (r105 == null) goto L22;
        r110 = r105;
    L21:
        r106 = r110.intValue();
        goto L22
    }
}
