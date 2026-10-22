package com.bytedance.ee.bear.bitable.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.r;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.widgets.NoConsumeInsetsFrameLayout;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001b\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010\u001d\u001a\u00020 H\u0016J\u0014\u0010!\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0016J\u001c\u0010%\u001a\u00020 2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010&\u001a\u00020'H\u0016J&\u0010%\u001a\u00020 2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0014\u0010*\u001a\u00020 2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0016J\u0006\u0010+\u001a\u00020 J\u0014\u0010,\u001a\u00020 2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u001c\u0010-\u001a\u00020\"2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010.\u001a\u00020\"H\u0002J\u0014\u0010/\u001a\u00020\u00172\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u00062\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0016H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0017H\u0002J\"\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0017H\u0002J\u0014\u00108\u001a\u00020\u00162\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0014J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/OfficeBitableUIContainer;", "Lcom/bytedance/ee/bear/browser/plugin/SimpleUIContainer;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "appContext", "Landroid/content/Context;", "contentView", "Landroid/view/View;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "titleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "hostLifecycle", "Landroidx/lifecycle/Lifecycle;", "immersiveOverlayAbilityProvider", "Lkotlin/Function0;", "Lcom/bytedance/ee/bear/bitable/core/BitableImmersiveOverlayAbility;", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroidx/fragment/app/FragmentManager;Lcom/bytedance/ee/bear/browser/plugin/TitleBar;Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;)V", "statusBarHeight", "", "pluginImmersiveMap", "", "", "", "immersiveTracker", "Lcom/bytedance/ee/bear/bitable/core/BitableImmersiveFragmentTracker;", "fragmentLifecycleCallbacks", "com/bytedance/ee/bear/bitable/core/OfficeBitableUIContainer$fragmentLifecycleCallbacks$1", "Lcom/bytedance/ee/bear/bitable/core/OfficeBitableUIContainer$fragmentLifecycleCallbacks$1;", "hideStatusBar", "isImmersive", "showStatusBar", "", "getPluginContainer", "Landroid/view/ViewGroup;", CloudControlInf.PLUGIN, "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "addOrReplaceFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "params", "Lcom/bytedance/ee/bear/browser/plugin/TransactionParams;", "removeFragment", "updateImmersive", "ensurePluginContainerPrepared", "ensureDedicatedPluginContainer", "rawContainer", "resolvePluginImmersive", "findDirectPluginContainer", "parent", "tag", "getContentViewTopOffset", "contentViewImmersive", "ensureViewTopOffset", "view", "requestLayout", "pluginContainerTag", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "Landroidx/lifecycle/LifecycleOwner;", "notifyNativeOverlayActive", "active", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBitableUIContainer extends r implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f210096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lifecycle f210097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<c> f210098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f210099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Boolean> f210100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f210101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OfficeBitableUIContainer$fragmentLifecycleCallbacks$1 f210102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f210103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f210104r;

    public static final class a {
    }

    static {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    public final void o() {
        t.a r100 = this.f216641g;
        if (r100 == null) goto L31;
        ViewGroup r101 = ((com.bytedance.ee.bear.browser.plugin.c) r100).f216617d;
        if (r101 == null) goto L33;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L24;
        View r104 = r101.getChildAt(r103);
        Object r105 = r104.getTag(R.id.pluginUIContainer);
        if ((r105 instanceof String) == false) goto L12;
        String r106 = (String) r105;
    L13:
        if (r106 == null) goto L23;
        boolean r107 = Intrinsics.areEqual(((LinkedHashMap) this.f210100n).get(r106), Boolean.TRUE);
        if (this.f210104r == true) goto L18;
    L21:
        int r108 = 0;
    L22:
        m.u(r104, r108, false);
        goto L23
    L18:
        if (this.f210103q == true) goto L21;
        if (r107 == true) goto L21;
        r108 = this.f210099m;
    L23:
        r103 = r103 + 1;
        goto L8
    L12:
        r106 = null;
        goto L13
    L24:
        View r109 = this.f216637c;
        if (r109 == null) goto L32;
        r109.requestLayout();
        return;
    L32:
        return;
    L33:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void a() {
        super.a();
        this.f210103q = false;
        o();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void hideStatusBar() {
        super.hideStatusBar();
        this.f210103q = true;
        o();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final ViewGroup c(com.bytedance.ee.bear.browser.plugin.f<?> r110) {
        Intrinsics.checkNotNullParameter(r110, CloudControlInf.PLUGIN);
        ViewGroup r100 = super.c(r110);
        t.a r101 = this.f216641g;
        View r102 = null;
        if (r101 == null) goto L5;
        ViewGroup r103 = ((com.bytedance.ee.bear.browser.plugin.c) r101).f216617d;
    L6:
        int r104 = 0;
        ViewGroup r105 = r100;
        if (r100 != r103) goto L23;
        String r106 = n(r110);
        int r107 = r100.getChildCount();
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L17;
        View r109 = r100.getChildAt(r108);
        if (Intrinsics.areEqual(r109.getTag(R.id.pluginUIContainer), r106) == true) goto L14;
        r108 = r108 + 1;
        goto L11
    L14:
        r102 = r109;
    L17:
        if ((r102 instanceof ViewGroup) == false) goto L21;
        ViewGroup r111 = (ViewGroup) r102;
        boolean r112 = Intrinsics.areEqual(r111.getTag(R.id.pluginUIContainer), r106);
        ViewGroup r113 = r111;
        if (r112 == false) goto L21;
    L22:
        r105 = r113;
    L21:
        NoConsumeInsetsFrameLayout r114 = new NoConsumeInsetsFrameLayout(this.f210096j);
        r114.setTag(r106);
        r114.setTag(R.id.pluginUIContainer, r106);
        r114.setId(View.generateViewId());
        r100.addView(r114, new FrameLayout.LayoutParams(-1, -1));
        r113 = r114;
    L23:
        String r115 = n(r110);
        this.f210100n.put(r115, Boolean.valueOf(r110.isViewImmersive()));
        boolean r116 = Intrinsics.areEqual(((LinkedHashMap) this.f210100n).get(r115), Boolean.TRUE);
        if (r105 != null) goto L27;
    L33:
        return r105;
    L27:
        if (this.f210104r == true) goto L29;
    L32:
        m.u(r105, r104, true);
        goto L33
    L29:
        if (this.f210103q == true) goto L32;
        if (r116 == true) goto L32;
        r104 = this.f210099m;
        goto L32
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void d(com.bytedance.ee.bear.browser.plugin.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        super.d(r100);
        o();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r
    public final String n(com.bytedance.ee.bear.browser.plugin.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        if ((r100 instanceof com.bytedance.ee.bear.browser.plugin.e) == false) goto L5;
        String r101 = ((com.bytedance.ee.bear.browser.plugin.e) r100).getLegacyPlugin().getClass().getName();
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        String r102 = r100.getClass().getName();
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f216638d.unregisterFragmentLifecycleCallbacks(this.f210102p);
        Lifecycle r101 = this.f210097k;
        if (r101 == null) goto L5;
        r101.removeObserver(this);
    L5:
        b r102 = this.f210101o;
        if (r102 == null) goto L9;
        r102.f210109b.clear();
        r102.f210110c.clear();
        r102.a();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void i(com.bytedance.ee.bear.browser.plugin.f<?> r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        b r102 = this.f210101o;
        if (r102 == null) goto L5;
        boolean r103 = r100.isViewImmersive();
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Boolean r104 = Boolean.valueOf(r103);
        r102.f210109b.put(r101, r104);
    L5:
        c(r100);
        e(r100, r101, null);
        o();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.r, com.bytedance.ee.bear.browser.plugin.t
    public final void e(com.bytedance.ee.bear.browser.plugin.f<?> r100, Fragment r101, s r102) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        b r103 = this.f210101o;
        if (r103 == null) goto L5;
        boolean r104 = r100.isViewImmersive();
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Boolean r105 = Boolean.valueOf(r104);
        r103.f210109b.put(r101, r105);
    L5:
        c(r100);
        super.e(r100, r101, r102);
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.bytedance.ee.bear.bitable.core.OfficeBitableUIContainer$fragmentLifecycleCallbacks$1] */
    public OfficeBitableUIContainer(Context r100, View r101, FragmentManager r102, TitleBar r103, Lifecycle r104, Function0<? extends c> r105) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        Intrinsics.checkNotNullParameter(r101, "contentView");
        Intrinsics.checkNotNullParameter(r102, "childFragmentManager");
        super(r100, r101, r102, r103);
        this.f210096j = r100;
        this.f210097k = r104;
        this.f210098l = r105;
        this.f210099m = k.e(r100);
        this.f210100n = new LinkedHashMap();
        if (r105 == 0) goto L5;
        b r106 = new b(new OfficeBitableUIContainer$immersiveTracker$1$1(this));
    L6:
        this.f210101o = r106;
        ?? r107 = new OfficeBitableUIContainer$fragmentLifecycleCallbacks$1(this);
        this.f210102p = r107;
        boolean r108 = true;
        this.f210104r = true;
        if (r104 != null) goto L9;
        boolean r109 = true;
    L10:
        if (r105 != 0) goto L12;
        boolean r110 = true;
    L13:
        if (r109 == r110) goto L16;
        r108 = false;
    L16:
        if (r108 == false) goto L25;
        if (r106 == null) goto L23;
        r102.registerFragmentLifecycleCallbacks(r107, false);
        if (r104 == null) goto L22;
        r104.addObserver(this);
        return;
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    L23:
        return;
    L25:
        throw new IllegalArgumentException("hostLifecycle and immersiveOverlayAbilityProvider must be configured together".toString());
    L12:
        r110 = false;
        goto L13
    L9:
        r109 = false;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
