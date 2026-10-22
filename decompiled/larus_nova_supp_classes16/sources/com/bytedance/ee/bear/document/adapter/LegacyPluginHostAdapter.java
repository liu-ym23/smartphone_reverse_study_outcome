package com.bytedance.ee.bear.document.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.p;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0016J\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016J+\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\f\b\u0000\u0010\u0017*\u0006\u0012\u0002\b\u00030\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0015H\u0016¢\u0006\u0002\u0010\u0018J8\u0010\u0019\u001a\u00020\u001a\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u00152\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J%\u0010+\u001a\u0002H,\"\b\b\u0000\u0010,*\u00020)2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u0015H\u0016¢\u0006\u0002\u0010-J)\u0010.\u001a\u0004\u0018\u0001H,\"\n\b\u0000\u0010,*\u0004\u0018\u00010)2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H,0\u0015H\u0016¢\u0006\u0002\u0010-J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001aH\u0014J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\bH\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020FH\u0016J\u0011\u0010G\u001a\n I*\u0004\u0018\u00010H0HH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/document/adapter/LegacyPluginHostAdapter;", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost$Delegate;", "chameleonHost", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "(Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;)V", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "chameleonWebView", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "webAdapter", "Lcom/bytedance/ee/bear/document/adapter/WebAdapter;", "getHostFragment", "Landroidx/fragment/app/Fragment;", "getPluginsReadOnly", "", "Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "findPluginByInterface", "clazz", "Ljava/lang/Class;", "findPlugin", "P", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/plugin/Plugin;", "findPluginToDo", "", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/browser/plugin/PluginFindAction;", "getContext", "Landroid/content/Context;", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "getUIContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getContainer", "Landroid/view/ViewGroup;", "type", "", "registerHostAbility", "ability", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "unregisterHostAbility", "getHostAbility", "T", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "getHostAbilityOrNull", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getUserComponent", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "onDestroy", "isDestroyed", "", "getDocViewModel", "getWebViewFragment", "Lcom/bytedance/ee/bear/browser/WebFragment;", "bridge", "Lcom/bytedance/ee/bear/jsbridge/IBridge;", "getBridge", "()Lcom/bytedance/ee/bear/jsbridge/IBridge;", "getEditPanelsManager", "Lcom/bytedance/ee/bear/document/toolbar/editpanels/EditPanelsManager;", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "getDocumentLoader", "Lcom/bytedance/ee/bear/document/DocumentLoader;", "getContentView", "Landroid/view/View;", "getWeb", "Lcom/bytedance/ee/bear/browser/Web;", "getPluginListProvider", "Lcom/bytedance/ee/bear/browser/plugin/PluginListProvider;", "kotlin.jvm.PlatformType", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LegacyPluginHostAdapter extends DocumentPluginHost implements PluginHost.a {
    public final /* synthetic */ g e;
    public final ChameleonPluginHost f;
    public final DocViewModel g;
    public final WebAdapter h;

    public static final class a implements PluginHost.b {
        public final /* synthetic */ LegacyPluginHostAdapter a;

        public a(LegacyPluginHostAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.b
        public final PluginHost createPluginHost() {
            return this.a;
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        this.e.getClass();
        return g.a.a;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onDestroy() {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost
    public final WebFragment c() {
        Fragment r0 = this.f.getFragment();
        if ((r0 instanceof WebFragment) == true) goto L7;
        return null;
    L7:
        return (WebFragment) r0;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return new com.bytedance.ee.bear.browser.plugin.h(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public FragmentActivity getActivity() {
        return this.f.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, vv4.b
    public final n getBridge() {
        return this.f.getWeb().getBridge();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final View getContentView() {
        return this.f.getWeb().getWebView();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public Context getContext() {
        return this.f.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final x2 getDocumentLoader() {
        return (x2) this.f.getHostAbility(x2.class);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.document.e4
    public final y3 getDocumentMetadata() {
        return ((e4) this.f.getHostAbility(e4.class)).getDocumentMetadata();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final Fragment getHostFragment() {
        return this.f.getHostFragment();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final LifecycleOwner getLifecycleOwner() {
        return this.f.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final t getUIContainer() {
        return this.f.getUIContainer();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final vo5.a getUserComponent() {
        return this.f.getUserComponent();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final boolean isDestroyed() {
        return this.f.isDestroyed();
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
        return this.g;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginHost, com.bytedance.ee.bear.browser.WebPluginHost, com.bytedance.ee.bear.document.g7
    public final k getWeb() {
        return this.h;
    }

    public LegacyPluginHostAdapter(ChameleonPluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "chameleonHost");
        k r0 = r4.getWeb();
        Unit r1 = Unit.INSTANCE;
        super(r0, 0);
        this.e = new g(r4);
        this.f = r4;
        this.g = (DocViewModel) r4.getHostAbility(DocViewModel.class);
        ChameleonWebView r2 = r4.getWeb().getWebView();
        if ((r2 instanceof ChameleonWebView) == false) goto L5;
        ChameleonWebView r3 = r2;
    L6:
        if (r3 == null) goto L14;
        this.h = new WebAdapter(r4, r3, r4.getWeb());
        this.viewModelStore = r4.getViewModelStore();
        p.d().a(new a(this), this);
        LifecycleOwner r5 = r4.getLifecycleOwner();
        if (r5 == null) goto L15;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L16;
        r6.addObserver(new AnonymousClass2(this));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new IllegalStateException("LegacyPluginHostAdapter requires ChameleonWebView".toString());
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> P findPlugin(Class<P> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (P) this.f.findPlugin(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final com.bytedance.ee.bear.browser.plugin.f<?> findPluginByInterface(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return this.f.findPluginByInterface(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final ViewGroup getContainer(int r2) {
        return this.f.getContainer(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <T extends i> T getHostAbility(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) this.f.getHostAbility(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <T extends i> T getHostAbilityOrNull(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (T) this.f.getHostAbilityOrNull(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void registerHostAbility(i r2) {
        this.f.registerHostAbility(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void unregisterHostAbility(i r2) {
        this.f.unregisterHostAbility(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> void findPluginToDo(Class<P> r2, com.bytedance.ee.bear.browser.plugin.g<P> r3) {
        this.f.findPluginToDo(r2, r3);
    }
}
