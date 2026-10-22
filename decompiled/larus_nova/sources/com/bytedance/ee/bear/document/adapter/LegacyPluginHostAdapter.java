package com.bytedance.ee.bear.document.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.p;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.n;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0016J\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016J+\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\f\b\u0000\u0010\u0017*\u0006\u0012\u0002\b\u00030\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0015H\u0016¢\u0006\u0002\u0010\u0018J8\u0010\u0019\u001a\u00020\u001a\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u00152\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J%\u0010+\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020)2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u0015H\u0016¢\u0006\u0002\u0010-J)\u0010.\u001a\u0004\u0018\u0001H,\"\n\b\u0000\u0010,*\u0004\u0018\u00010)2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u0015H\u0016¢\u0006\u0002\u0010-J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001aH\u0014J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\bH\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020FH\u0016J\u0011\u0010G\u001a\n I*\u0004\u0018\u00010H0HH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/document/adapter/LegacyPluginHostAdapter;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost$Delegate;", "chameleonHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "(Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;)V", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "chameleonWebView", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "webAdapter", "Lcom/bytedance/ee/bear/document/adapter/WebAdapter;", "getHostFragment", "Landroidx/fragment/app/Fragment;", "getPluginsReadOnly", "", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "findPluginByInterface", "clazz", "Ljava/lang/Class;", "findPlugin", "P", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "findPluginToDo", "", "action", "Lcom/bytedance/ee/bear/browser/plugin/PluginFindAction;", "getContext", "Landroid/content/Context;", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "getUIContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getContainer", "Landroid/view/ViewGroup;", "type", "", "registerHostAbility", "ability", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "unregisterHostAbility", "getHostAbility", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "getHostAbilityOrNull", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getUserComponent", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", LiveCommonConstants.REASON_ON_DEDTROY, "isDestroyed", "", "getDocViewModel", "getWebViewFragment", "Lcom/bytedance/ee/bear/browser/WebFragment;", "bridge", "Lcom/bytedance/ee/bear/jsbridge/IBridge;", "getBridge", "()Lcom/bytedance/ee/bear/jsbridge/IBridge;", "getEditPanelsManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "getDocumentLoader", "Lcom/bytedance/ee/bear/document/DocumentLoader;", "getContentView", "Landroid/view/View;", "getWeb", "Lcom/bytedance/ee/bear/browser/Web;", "getPluginListProvider", "Lcom/bytedance/ee/bear/browser/plugin/PluginListProvider;", "kotlin.jvm.PlatformType", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LegacyPluginHostAdapter extends DocumentPluginHost implements PluginHost.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f218683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChameleonPluginHost f218684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DocViewModel f218685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WebAdapter f218686h;

    public static final class a implements PluginHost.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegacyPluginHostAdapter f218689a;

        public a(LegacyPluginHostAdapter r100) {
            this.f218689a = r100;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.b
        public final PluginHost createPluginHost() {
            return this.f218689a;
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        this.f218683e.getClass();
        return g.a.f218718a;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onDestroy() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost
    public final WebFragment c() {
        Fragment r100 = this.f218684f.getFragment();
        if ((r100 instanceof WebFragment) == true) goto L7;
        return null;
    L7:
        return (WebFragment) r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return new com.bytedance.ee.bear.browser.plugin.h(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public FragmentActivity getActivity() {
        return this.f218684f.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, vv4.b
    public final n getBridge() {
        return this.f218684f.getWeb().getBridge();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final View getContentView() {
        return this.f218684f.getWeb().getWebView();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public Context getContext() {
        return this.f218684f.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final x2 getDocumentLoader() {
        return (x2) this.f218684f.getHostAbility(x2.class);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final y3 getDocumentMetadata() {
        return ((e4) this.f218684f.getHostAbility(e4.class)).getDocumentMetadata();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final Fragment getHostFragment() {
        return this.f218684f.getHostFragment();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final LifecycleOwner getLifecycleOwner() {
        return this.f218684f.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final t getUIContainer() {
        return this.f218684f.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final vo5.a getUserComponent() {
        return this.f218684f.getUserComponent();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final boolean isDestroyed() {
        return this.f218684f.isDestroyed();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost
    public final EditPanelsManager b() {
        return (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final List<com.bytedance.ee.bear.browser.plugin.f<PluginHost>> getPluginsReadOnly() {
        return super.getPluginsReadOnly();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost
    public final DocViewModel a() {
        return this.f218685g;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.browser.WebPluginHost, com.bytedance.ee.bear.document.g7
    public final k getWeb() {
        return this.f218686h;
    }

    public LegacyPluginHostAdapter(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "chameleonHost");
        k r101 = r100.getWeb();
        Unit r102 = Unit.INSTANCE;
        super(r101, 0);
        this.f218683e = new g(r100);
        this.f218684f = r100;
        this.f218685g = (DocViewModel) r100.getHostAbility(DocViewModel.class);
        WebView r103 = r100.getWeb().getWebView();
        if ((r103 instanceof ChameleonWebView) == false) goto L5;
        ChameleonWebView r104 = (ChameleonWebView) r103;
    L6:
        if (r104 == null) goto L14;
        this.f218686h = new WebAdapter(r100, r104, r100.getWeb());
        this.viewModelStore = r100.getViewModelStore();
        p.d().a(new a(this), this);
        LifecycleOwner r105 = r100.getLifecycleOwner();
        if (r105 == null) goto L15;
        Lifecycle r106 = r105.getLifecycle();
        if (r106 == null) goto L16;
        r106.addObserver(new AnonymousClass2(this));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new IllegalStateException("LegacyPluginHostAdapter requires ChameleonWebView".toString());
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> P findPlugin(Class<P> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (P) this.f218684f.findPlugin(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final com.bytedance.ee.bear.browser.plugin.f<?> findPluginByInterface(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return this.f218684f.findPluginByInterface(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final ViewGroup getContainer(int r100) {
        return this.f218684f.getContainer(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <T extends i> T getHostAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f218684f.getHostAbility(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <T extends i> T getHostAbilityOrNull(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f218684f.getHostAbilityOrNull(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void registerHostAbility(i r100) {
        this.f218684f.registerHostAbility(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void unregisterHostAbility(i r100) {
        this.f218684f.unregisterHostAbility(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> void findPluginToDo(Class<P> r100, com.bytedance.ee.bear.browser.plugin.g<P> r101) {
        this.f218684f.findPluginToDo(r100, r101);
    }
}
