package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.imagepipeline.memory.PoolStatsTracker;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ChameleonContainerConst;
import com.ss.android.lark.chameleon.ChameleonContainerLifecycleListener;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.widgetv2.titlebar.CmlCommonTitleBar;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonSafeReuseWeb;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.ChameleonLoaderImpl;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ChameleonDebugUtils;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import vv4.n;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0014J&\u00104\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u00102\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u000209H\u0016J\b\u0010?\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020;H\u0016J\b\u0010A\u001a\u00020;H\u0016J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020;H\u0016J\b\u0010E\u001a\u00020;H\u0016J\b\u0010F\u001a\u00020;H\u0016J\u0010\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0004\u0018\u00010\u00102\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020PH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010R\u001a\u00020;H\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020-H\u0002J\u0018\u0010V\u001a\u00020;2\u0006\u0010U\u001a\u00020-2\u0006\u0010W\u001a\u00020TH\u0002J\u0014\u0010X\u001a\b\u0012\u0002\b\u0003\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006]"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonFragmentV2;", "Lcom/bytedance/ee/bear/browser/WebFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "userComponent", "Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;", "getUserComponent", "()Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;", "setUserComponent", "(Lcom/ss/android/lark/chameleonv2/usercomponent/IUserComponent;)V", "webView", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "documentWeb", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ChameleonSafeReuseWeb;", "webViewContainer", "Landroid/view/ViewGroup;", "leftContainer", "rightContainer", "bottomContainer", "topContainer", "titleBarContainer", "rootContainer", "contentContainer", "businessOverlayContainer", "pluginUIContainer", "lifecycleListener", "Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "getLifecycleListener", "()Lcom/ss/android/lark/chameleon/ChameleonContainerLifecycleListener;", "lifecycleListener$delegate", "Lkotlin/Lazy;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getPluginUserComponent", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "getContext", "Landroid/content/Context;", "getPluginListProvider", "Lcom/bytedance/ee/bear/browser/plugin/PluginListProvider;", "createCommonTitleBar", "Lcom/ss/android/lark/chameleon/widgetv2/titlebar/CmlCommonTitleBar;", "onCreateTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "getPluginHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onCreatePluginHost", "Lcom/bytedance/ee/bear/browser/WebPluginHost;", "onCreateUIContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "contentView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onSaveInstanceState", "outState", WidgetCostModule.TYPE_ON_START, "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "getchameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "onResume", "onPause", "onStop", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getContainer", "type", "", "getWebTag", "", "isWebViewAttached", "", "addOverlay", "cleanContainer", "setPluginMounter", "Lcom/bytedance/ee/bear/browser/plugin/lazy/LazyPluginMounter;", "pluginHost", "bindDefaultLoadCallbacks", "lazyMounter", "getFragmentWebHandler", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlerName", "", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonFragmentV2 extends Hilt_ChameleonFragmentV2 implements d0c.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f411299x = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Inject
    public v1b.a f411300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ChameleonWebView f411301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChameleonSafeReuseWeb f411302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f411303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f411304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f411305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f411306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f411307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewGroup f411308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f411309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f411310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f411311w;

    public static final class a {
        @JvmStatic
        public static Fragment a(Context r100, String r101, String r102, Bundle r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r103 == null) goto L10;
            Object r104 = r103.clone();
            if ((r104 instanceof Bundle) == false) goto L7;
            Bundle r105 = (Bundle) r104;
        L8:
            if (r105 != null) goto L11;
            r105 = new Bundle();
        L11:
            if (r101 != null) goto L13;
            r101 = "";
        L13:
            r105.putString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, r101);
            if (r102 == null) goto L16;
            r105.putString("session_id", r102);
        L16:
            int r106 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
            PassportcConvention.f(r105, com.ss.android.lark.officesdk.utils.di.d.a.a());
            Fragment r107 = Fragment.instantiate(r100, ChameleonFragmentV2.class.getName(), r105);
            r107.setArguments(r105);
            return r107;
        L7:
            r105 = null;
            goto L8
        L10:
            r105 = new Bundle();
            goto L11
        }
    }

    public static final class b implements com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonFragmentV2 f411312a;

        public final CmlCommonTitleBar a() {
            ChameleonFragmentV2 r100 = this.f411312a;
            int r101 = ChameleonFragmentV2.f411299x;
            r100.getClass();
            CmlCommonTitleBar r102 = new CmlCommonTitleBar(r100.requireContext());
            FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -1);
            r103.gravity = 17;
            r102.setLayoutParams(r103);
            r102.setBackgroundResource(R.color.transparent);
            return r102;
        }

        public final Boolean b() {
            ChameleonFragmentV2 r100 = this.f411312a;
            int r101 = ChameleonFragmentV2.f411299x;
            OpenConfig r102 = r100.ca0().getOpenConfig();
            boolean r103 = false;
            if (r102 == null) goto L10;
            TitlebarConfig r104 = r102.getTitlebarConfig();
            if (r104 == null) goto L10;
            if (r104.getShowTitlebar() == true) goto L10;
            r103 = true;
        L10:
            return Boolean.valueOf(!r103);
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b.a
        public FragmentActivity getActivity() {
            FragmentActivity r100 = this.f411312a.getActivity();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalStateException("activity is null");
        }

        public b(ChameleonFragmentV2 r100) {
            this.f411312a = r100;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final ChameleonContainerLifecycleListener aa0() {
        return (ChameleonContainerLifecycleListener) this.f411311w.getValue();
    }

    public final ChameleonPluginHost ba0() {
        WebPluginHost r100 = this.f216602e;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost");
        return (ChameleonPluginHost) r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        return new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.a();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onDestroy:  " + getWebTag());
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentDestroy(ba0());
    L5:
        super.onDestroy();
        ChameleonSafeReuseWeb r101 = this.f411302n;
        String r102 = null;
        if (r101 == null) goto L11;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonSafeReuseWeb", "onOwnerDestroy");
        r101.f411125d = false;
        r101.f411126e = null;
        if (r101.K() == null) goto L11;
        xwb.a r103 = r101.K().getBridge();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "interceptor");
        r103.f565290d.remove(r101);
        ChameleonWebView r104 = r101.K();
        ((CopyOnWriteArrayList) r104.f411317g2.f411166e).remove(r101.f411127f);
        ChameleonWebView r105 = r101.K();
        ((CopyOnWriteArrayList) r105.f411319h2.f411164d).remove(r101.f411128g);
        r101.K().removeOnAttachStateChangeListener(r101.f411132k);
    L11:
        Bundle r106 = getArguments();
        String r107 = "";
        if (r106 == null) goto L14;
        r102 = r106.getString("session_id", "");
    L14:
        if (r102 == null) goto L17;
        r107 = r102;
    L17:
        Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> r108 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.f411292a;
        Intrinsics.checkNotNullParameter(r107, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        com.ss.android.lark.chameleonv2.container.webcontainer.util.b.f411292a.remove(r107);
        Map<String, u1b.a.C7822a> r109 = u1b.a.f548359a;
        Intrinsics.checkNotNullParameter(r107, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        u1b.a.f548359a.remove(r107);
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onDestroyView:  " + getWebTag());
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentDestroyView(ba0());
    L5:
        super.onDestroyView();
        ChameleonWebView r101 = this.f411301m;
        if (r101 == null) goto L10;
        n r102 = r101.getWebServiceManager();
        if (r102 == null) goto L10;
        r102.d();
    L10:
        ChameleonWebView r103 = this.f411301m;
        if (r103 == null) goto L23;
        r103.setDownloadListener(null);
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L15;
        ViewGroup r105 = (ViewGroup) r104;
    L16:
        if (r105 == null) goto L18;
        r105.removeView(r103);
    L18:
        v1b.a r106 = this.f411300l;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("userComponent");
        r106 = null;
    L22:
        r106.F2().g(ca0(), r103, getWebTag());
        goto L23
    L15:
        r105 = null;
    L23:
        this.f411304p = null;
        this.f411305q = null;
        this.f411307s = null;
        this.f411306r = null;
        this.f411308t = null;
        this.f411309u = null;
        this.f411310v = null;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onPause:  " + getWebTag());
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentPause(ba0());
    L5:
        super.onPause();
        ChameleonWebView r101 = this.f411301m;
        if (r101 == null) goto L8;
        r101.onPause();
    L8:
        ChameleonWebView r102 = this.f411301m;
        if (r102 == null) goto L12;
        r102.setIsVisible(false);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentResume(ba0());
    L5:
        super.onResume();
        ChameleonWebView r101 = this.f411301m;
        if (r101 == null) goto L8;
        r101.onResume();
    L8:
        ChameleonWebView r102 = this.f411301m;
        boolean r103 = true;
        if (r102 == null) goto L27;
        r102.setIsVisible(true);
    L27:
        ViewGroup r104 = this.f411303o;     // Catch: Exception -> L19
        if (r104 == null) goto L16;
        View r105 = r104.getChildAt(0);     // Catch: Exception -> L19
    L17:
        if (r105 != null) goto L21;
    L20:
        r103 = false;
    L21:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "onResume:  " + getWebTag() + ",   isAttached:  " + r103);
        if (r103 == true) goto L29;
        ChameleonSafeReuseWeb r106 = this.f411302n;
        if (r106 == null) goto L30;
        r106.o(ba0());
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r105 = null;
    L19:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "isWebViewAttached exception");
        goto L20
    }

    public ChameleonFragmentV2() {
        this.f411311w = LazyKt.lazy(new ChameleonFragmentV2$lifecycleListener$2(this));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2$onCreatePluginHost$2] */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2$onCreatePluginHost$pluginMounterBinder$1] */
    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final WebPluginHost W90() {
        Bundle r100 = getArguments();
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, "");
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        ChameleonConfig r103 = ca0();
        v1b.a r104 = this.f411300l;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userComponent");
        r104 = null;
    L12:
        ChameleonWebView r110 = r104.F2().f(r103, getWebTag());
        Bundle r105 = getArguments();
        if (r105 == null) goto L15;
        String r106 = r105.getString("session_id", "");
    L16:
        if (r106 != null) goto L18;
        String r111 = "";
    L19:
        r110.V1 = r111;
        u1b.a.C7822a r107 = u1b.a.a(r111);
        if (r107 == null) goto L23;
        String r108 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.d(r102);
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r108, "value");
        r107.f548365e.put("url", r108);
    L23:
        if (r110.getPreloader().c() != PreloadStatus.INIT) goto L25;
        r110.z();
    L25:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonFragmentV2", "js_perf_tag webCreateTime=" + System.currentTimeMillis() + ",   chameleonConfig=" + r103);
        this.f411301m = r110;
        ChameleonSafeReuseWeb r109 = new ChameleonSafeReuseWeb(r110);
        this.f411302n = r109;
        r109.s(true, Integer.valueOf(hashCode()));
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = ChameleonFragmentV2$onCreatePluginHost$pluginMounterBinder$1.INSTANCE;
        ChameleonSafeReuseWeb r113 = this.f411302n;
        Bundle r114 = getArguments();
        if (r114 == null) goto L28;
        r101 = r114.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL);
    L28:
        if (r101 != null) goto L30;
        String r115 = "";
    L31:
        final ChameleonPluginHost r116 = new ChameleonPluginHost(r113, r115, r103, r111, r110.getWebServiceManager(), new ChameleonFragmentV2$onCreatePluginHost$pluginHost$1(this, r112));
        r116.setFragment(this);
        ChameleonLoaderImpl r117 = new ChameleonLoaderImpl(r110);
        r116.setLoader(r117);
        com.ss.android.lark.chameleonv2.container.webcontainer.i r118 = r110.f411317g2;
        if (((CopyOnWriteArrayList) r118.f411166e).contains(r117) == true) goto L34;
        ((CopyOnWriteArrayList) r118.f411166e).add(r117);
    L34:
        final yv4.e r119 = new yv4.e(r116);
        r116.setPluginMounter(r119);
        ChameleonSafeReuseWeb r120 = this.f411302n;
        if (r120 == null) goto L37;
        r120.f411131j = new c(r119);
    L37:
        r112.element = new ChameleonFragmentV2$onCreatePluginHost$2(this, r116, r119);
        u1b.a.C7822a r121 = u1b.a.a(r111);
        if (r121 == null) goto L40;
        r121.f548363c = r116;
    L40:
        return r116;
    L30:
        r115 = r101;
        goto L31
    L18:
        r111 = r106;
        goto L19
    L15:
        r106 = null;
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final TitleBar X90() {
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L6;
        r100.onPreCreateTitleBar(ba0());
    L6:
        return new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.b(new b(this));
    }

    public final ChameleonConfig ca0() {
        Bundle r100 = getArguments();
        String r101 = "";
        if (r100 == null) goto L5;
        String r102 = r100.getString("session_id", "");
    L6:
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        return com.ss.android.lark.chameleonv2.container.webcontainer.util.b.b(r101);
    L5:
        r102 = null;
        goto L6
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return com.bytedance.ee.bear.browser.plugin.m.a(this);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.Hilt_ChameleonFragmentV2, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return swb.h.a(r100);
    }

    public final Object getWebTag() {
        return Integer.toHexString(hashCode());
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentStart(ba0());
    L5:
        super.onStart();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        ChameleonContainerLifecycleListener r100 = aa0();
        if (r100 == null) goto L5;
        r100.onPreFragmentStop(ba0());
    L5:
        super.onStop();
        ChameleonWebView r101 = this.f411301m;
        if (r101 == null) goto L70;
        com.ss.android.lark.officesdk.utils.di.j.e(LarkWebView.TAG, "lark webview onStop, biz = " + r101.f437432n);
        oxb.n r102 = r101.getServiceManager();
        if (r102 == null) goto L12;
        jxb.a r103 = (jxb.a) r102.a(jxb.a.class);
        if (r103 == null) goto L12;
        r103.stop();
    L12:
        com.ss.android.lark.officesdk.utils.di.j.e(r101.P0, "onStop");
        if (ixb.a.a() == false) goto L60;
        long r104 = (System.currentTimeMillis() - r101.f411320k1) / 1000;
        int r105 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        v1b.a r106 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r106 == null) goto L21;
        ChameleonWebViewManager r107 = r106.F2();
        if (r107 == null) goto L21;
        List r108 = CollectionsKt.toList(r107.f411139c);
        if (r108 == null) goto L21;
    L22:
        List r109 = r108;
        if ((!r109.isEmpty()) == false) goto L28;
        Iterator r110 = r108.iterator();
    L26:
        if (r110.hasNext() == false) goto L28;
        String r111 = (String) r110.next();
        com.ss.android.lark.officesdk.utils.di.j.e(r101.P0, "unfinished biz=" + r111);
    L28:
        String r112 = r101.V0.getBizName();
        String r113 = "";
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        HangDetectStrategy r114 = r101.Q1;
        if (r114 == null) goto L34;
        int r115 = r114.getType();
    L35:
        Integer r116 = Integer.valueOf(r115);
        r101.getWebView().getUrl();
        Integer r117 = Integer.valueOf(r101.getUsedCount());
        Long r118 = Long.valueOf(r104);
        Boolean r119 = Boolean.valueOf(r101.P1);
        if ((!r109.isEmpty()) == false) goto L38;
        r113 = (String) ListProtector.get(r108, 0);
    L38:
        JSONObject r120 = new JSONObject();
        r120.put("app_name", r112);
        r120.put("from", r116);
        r120.put(PoolStatsTracker.USED_COUNT, r117);
        r120.put("used_time", r118);
        r120.put(ChameleonOpenTracker.ParamKey.COST, 0L);
        r120.put("anr", r119);
        r120.put("unfinished", r113);
        Fragment r121 = r101.getFragment();
        if ((r121 instanceof ChameleonFragmentV2) == false) goto L41;
        ChameleonFragmentV2 r122 = (ChameleonFragmentV2) r121;
    L42:
        if (r122 == null) goto L59;
        ChameleonPluginHost r123 = r122.ba0();
        if (r123 == null) goto L59;
        IDependency r124 = r101.getChameleonConfig().getDependency();
        if (r124 == null) goto L59;
        IMonitorDependency r125 = r124.getMonitorDependency();
        if (r125 == null) goto L59;
        Map<String, Object> r126 = r125.getBizParams(r123);
        if (r126 == null) goto L59;
        Iterator<Map.Entry<String, Object>> r127 = r126.entrySet().iterator();
    L53:
        if (r127.hasNext() == false) goto L59;
        Map.Entry<String, Object> r128 = r127.next();
        String r129 = r128.getKey();
        Object r130 = r128.getValue();
        if (r120.has(r129) == true) goto L53;
        r120.put(r129, r130);     // Catch: Exception -> L58
    L58:
        com.ss.android.lark.officesdk.utils.di.j.f(r101.P0, "skip invalid biz param: " + r129);
    L59:
        u1b.b.b("webapp_webview_responsive_state_dev", r120);
        goto L60
    L41:
        r122 = null;
        goto L42
    L34:
        r115 = 0;
    L21:
        r108 = CollectionsKt.emptyList();
    L60:
        r101.P1 = false;
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final t Y90(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        OpenConfig r101 = ca0().getOpenConfig();
        if (r101 == null) goto L8;
        Function4<ChameleonPluginHost, View, FragmentManager, TitleBar, t> r102 = r101.getOnCreateUIContainer();
        if (r102 == null) goto L8;
        t r103 = r102.invoke(ba0(), r100, getChildFragmentManager(), U90());
        if (r103 == null) goto L8;
    L9:
        ChameleonContainerLifecycleListener r104 = aa0();
        if (r104 == null) goto L12;
        ChameleonPluginHost r105 = ba0();
        Intrinsics.checkNotNull(r103);
        r104.onPreCreateUIContainer(r105, r103);
    L12:
        Intrinsics.checkNotNull(r103);
        return r103;
    L8:
        r103 = super.Y90(r100);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final ViewGroup getContainer(int r100) {
        View r101 = getView();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 != ContainerType.Left.getValue()) goto L14;
        ViewGroup r102 = this.f411304p;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_left_container);
        if (r102 == null) goto L67;
        this.f411304p = r102;
        r102.setVisibility(0);
        goto L75
    L67:
        return null;
    L75:
        return r102;
    L14:
        if (r100 != ContainerType.Right.getValue()) goto L21;
        r102 = this.f411305q;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_right_container);
        if (r102 == null) goto L76;
        this.f411305q = r102;
        r102.setVisibility(0);
        goto L75
    L76:
        return null;
    L21:
        if (r100 != ContainerType.Top.getValue()) goto L28;
        r102 = this.f411307s;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_top_container);
        if (r102 == null) goto L77;
        this.f411307s = r102;
        r102.setVisibility(0);
        goto L75
    L77:
        return null;
    L28:
        if (r100 != ContainerType.Bottom.getValue()) goto L35;
        r102 = this.f411306r;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_bottom_container);
        if (r102 == null) goto L78;
        this.f411306r = r102;
        r102.setVisibility(0);
        goto L75
    L78:
        return null;
    L35:
        if (r100 != ContainerType.Web.getValue()) goto L42;
        r102 = this.f411303o;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_webview_container);
        if (r102 == null) goto L79;
        this.f411303o = r102;
        goto L75
    L79:
        return null;
    L42:
        if (r100 != ContainerType.Title.getValue()) goto L47;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_title_layout);
        if (r102 == null) goto L80;
        r102.setVisibility(0);
        goto L75
    L80:
        return null;
    L47:
        if (r100 != ContainerType.Root.getValue()) goto L54;
        r102 = this.f411308t;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_root);
        if (r102 == null) goto L81;
        this.f411308t = r102;
        goto L75
    L81:
        return null;
    L54:
        if (r100 != ContainerType.Content.getValue()) goto L61;
        r102 = this.f411309u;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.content_container);
        if (r102 == null) goto L82;
        this.f411309u = r102;
        goto L75
    L82:
        return null;
    L61:
        if (r100 != ContainerType.BusinessOverlay.getValue()) goto L68;
        r102 = this.f411310v;
        if (r102 != null) goto L75;
        r102 = (ViewGroup) r101.findViewById(com.larus.nova.R.id.cml_business_overlay_container);
        if (r102 == null) goto L83;
        this.f411310v = r102;
        r102.setVisibility(0);
        goto L75
    L83:
        return null;
    L68:
        View r103 = getView();
        if (r103 == null) goto L84;
        ViewGroup r104 = (ViewGroup) r103.findViewById(com.larus.nova.R.id.pluginUIContainer);
        if (r104 == null) goto L85;
        FrameLayout r105 = new FrameLayout(requireContext());
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r104.addView(r105);
        return r105;
    L85:
        return null;
    L84:
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        ChameleonContainerLifecycleListener r101 = aa0();
        if (r101 == null) goto L5;
        r101.onPreConfigurationChanged(ba0(), r100);
    L5:
        super.onConfigurationChanged(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        r100.putAll(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        ViewGroup r100 = (ViewGroup) r210.findViewById(com.larus.nova.R.id.cml_webview_container);
        this.f411303o = r100;
        if (r100 == null) goto L5;
        r100.addView(this.f411301m, -1, -1);
    L5:
        ChameleonWebView r101 = this.f411301m;
        if (r101 == null) goto L10;
        n r102 = r101.getWebServiceManager();
        if (r102 == null) goto L10;
        r102.e();
    L10:
        ChameleonContainerLifecycleListener r103 = aa0();
        if (r103 == null) goto L13;
        r103.onPreFragmentViewCreated(ba0());
    L13:
        super.onViewCreated(r210, r211);
        Bundle r104 = getArguments();
        String r105 = null;
        String r106 = "";
        if (r104 == null) goto L16;
        String r107 = r104.getString(ChameleonContainerConst.CHAMELEON_EXTRA_URL, "");
    L17:
        if (r107 == null) goto L20;
        r106 = r107;
    L20:
        ba0().getLoader().load(r106);
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == false) goto L106;
        ViewGroup r108 = getContainer(ContainerType.Full.getValue());
        if (r108 == null) goto L107;
        com.ss.android.lark.storage.a r109 = ChameleonDebugUtils.f411281a;
        ChameleonConfig r110 = ca0();
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r108, "viewGroup");
        Context r111 = r108.getContext();
        if (r111 != null) goto L28;
    L101:
        Intrinsics.checkNotNullParameter(r108, "viewGroup");
        Context r112 = r108.getContext();
        if (r112 == null) goto L108;
        View r113 = new com.ss.android.lark.chameleonv2.container.webcontainer.util.c(r112, 1000, 5);
        r113.setBackgroundColor(0);
        r113.setClickable(false);
        r108.addView(r113, -1, -1);
        return;
    L108:
        return;
    L28:
        if (((TextView) r108.findViewWithTag("chameleon_debug_view")) == null) goto L30;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonDebugUtils", "Debug view already exists.");
        goto L101
    L30:
        KVRepo r114 = ChameleonDebugUtils.b();
        int r115 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        DependencyContainer r116 = DependencyContainer.f433166a;
        ntb.f r117 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
        if (r117 == null) goto L33;
        r117.e0();
        boolean r118 = true;
    L35:
        if (r114.getBoolean("chameleon_disable_debug_view", !r118) == true) goto L91;
        ArrayList r119 = new ArrayList();
        r119.add("业务：" + r110.getBizName() + '\n');
        boolean r120 = ChameleonDebugUtils.b().getBoolean("chameleon_disable_ip_proxy", false);
        String r121 = ChameleonDebugUtils.a();
        String r122 = ChameleonDebugUtils.b().getString("chameleon_ip_proxy_url", null);
        if (Intrinsics.areEqual(r121, r110.getBizName()) == false) goto L47;
        if (r122 != null) goto L41;
    L44:
        boolean r123 = true;
    L45:
        if (r123 == true) goto L47;
        boolean r124 = true;
    L48:
        String r125 = "禁用";
        if (r124 == false) goto L52;
        if (r120 == true) goto L52;
        String r126 = "生效中";
    L56:
        r119.add("前端代理配置：".concat(r126));
        if (r124 == false) goto L60;
        if (r120 == true) goto L60;
        r119.add("前端代理地址:\n" + r122);
    L60:
        boolean r127 = ChameleonDebugUtils.b().getBoolean("chameleon_disable_offline_res", false);
        String r128 = ChameleonDebugUtils.b().getString("chameleon_specific_bizname", null);
        String r129 = ChameleonDebugUtils.b().getString("chameleon_specific_version", null);
        if (Intrinsics.areEqual(r128, r110.getBizName()) == false) goto L70;
        if (r129 != null) goto L64;
    L67:
        boolean r130 = true;
    L68:
        if (r130 == true) goto L70;
        boolean r131 = true;
    L71:
        if (r131 == false) goto L74;
        if (r127 == true) goto L74;
        r125 = "生效中";
    L78:
        r119.add("\n离线资源配置：".concat(r125));
        if (r131 == false) goto L83;
        if (r127 == true) goto L83;
        r119.add("离线资源版本:" + r129);
    L90:
        r105 = CollectionsKt.joinToString$default(r119, "\n", null, null, 0, null, null, 62, null);
    L83:
        if (Intrinsics.areEqual(r110.getBizName(), "document") == false) goto L90;
        int r132 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        Application r133 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.f411274a.getClass();
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.b r134 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.a.b(r110, r133);
        if (r134 == null) goto L87;
        r105 = r134.f411277b;
    L87:
        if (r105 == null) goto L89;
        r119.add("使用本地资源 (版本:" + r134.f411277b + ')');
        goto L90
    L89:
        r119.add("请求网络资源");
    L74:
        if (r131 == false) goto L77;
        if (r127 == true) goto L78;
    L77:
        r125 = "未手动配置";
        goto L78
    L64:
        if (r129.length() == 0) goto L67;
        r130 = false;
    L70:
        r131 = false;
    L52:
        if (r124 == false) goto L55;
        if (r120 == false) goto L55;
        r126 = "禁用";
    L55:
        r126 = "未配置";
        goto L56
    L41:
        if (r122.length() == 0) goto L44;
        r123 = false;
    L47:
        r124 = false;
    L91:
        if (r105 == null) goto L101;
        TextView r135 = new TextView(r111);
        r135.setText(r105);
        r135.setTag("chameleon_debug_view");
        r135.setTextColor(-1);
        r135.setBackgroundColor(ColorProtector.parseColor("#80000000"));
        r135.setTextSize(12.0f);
        if ((r108 instanceof FrameLayout) == false) goto L97;
        FrameLayout.LayoutParams r136 = new FrameLayout.LayoutParams(-2, -2);
        r136.gravity = 8388661;
        ViewGroup.MarginLayoutParams r137 = r136;
    L100:
        r137.setMargins(40, 100, 40, 100);
        r135.setLayoutParams(r137);
        r108.addView(r135);
        goto L101
    L97:
        if ((r108 instanceof ConstraintLayout) == false) goto L99;
        ConstraintLayout.LayoutParams r138 = new ConstraintLayout.LayoutParams(-2, -2);
        r138.endToEnd = 0;
        r138.bottomToBottom = 0;
        r137 = r138;
        goto L100
    L99:
        r137 = new ViewGroup.MarginLayoutParams(-2, -2);
        goto L100
    L33:
        r118 = false;
        goto L35
    L107:
        return;
    L106:
        return;
    L16:
        r107 = null;
        goto L17
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(com.larus.nova.R.layout.chameleon_fragment_v2, r101, false);
    }
}
