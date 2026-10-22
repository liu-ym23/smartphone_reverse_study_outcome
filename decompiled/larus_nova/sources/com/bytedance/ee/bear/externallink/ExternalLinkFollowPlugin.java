package com.bytedance.ee.bear.externallink;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.follow.event.ContentEvent;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.event.OpenLinkEvent;
import com.bytedance.ee.bear.doc.follow.event.TitleChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.rn.j;
import java.util.ArrayList;
import sy4.c;
import sy4.d;
import tb5.m;
import tl5.e;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public class ExternalLinkFollowPlugin extends DocumentPlugin {
    private static final String TAG = "ExternalLinkFollowPlugin";
    private m callBack;
    private d docFollowStateObserver;
    private WebRNFollowImpl externalLinkFollow;
    private boolean loading;
    private ExternalLinkFragment.d loadingCallback;

    public class ExternalLinkWebFollowImpl extends WebRNFollowImpl {
        final /* synthetic */ ExternalLinkFollowPlugin this$0;

        @Override // com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl
        public /* bridge */ /* synthetic */ void registerPerfMonitor(py4.d.b r100) {
        }

        @Override // com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl
        public /* bridge */ /* synthetic */ void unregisterPerfMonitor(py4.d.b r100) {
        }

        public void injectJS(String r100) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
            ExternalLinkFollowPlugin.access$300(this.this$0, r100);
        }

        public ExternalLinkWebFollowImpl(ExternalLinkFollowPlugin r100, Fragment r101, k r102, String r103) {
            this.this$0 = r100;
            super(r101, r102, r103, 0);
        }
    }

    public class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFollowPlugin f226366b;

        @Override // sy4.c
        public final View c() {
            TitleBar r100 = ExternalLinkFollowPlugin.access$000(this.f226366b);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getTitleBarLayout();
        }

        public a(ExternalLinkFollowPlugin r100) {
            this.f226366b = r100;
        }
    }

    public class b implements ExternalLinkFragment.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFollowPlugin f226367a;

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadFail() {
            if (ExternalLinkFollowPlugin.access$200(this.f226367a) == true) goto L5;
            tt5.a.k(ExternalLinkFollowPlugin.TAG, "Duplicate load result:fail");
            return;
        L5:
            ExternalLinkFollowPlugin.access$202(this.f226367a, false);
            ExternalLinkFollowPlugin.access$100(this.f226367a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadFail));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadStart() {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load start.");
            ExternalLinkFollowPlugin.access$202(this.f226367a, true);
            ExternalLinkFollowPlugin.access$100(this.f226367a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.Loading));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadSuccess() {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load success.");
            if (ExternalLinkFollowPlugin.access$200(this.f226367a) == true) goto L5;
            tt5.a.k(ExternalLinkFollowPlugin.TAG, "Duplicate load result:success");
            return;
        L5:
            ExternalLinkFollowPlugin.access$202(this.f226367a, false);
            ExternalLinkFollowPlugin.access$100(this.f226367a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadSuccess));
        }

        public b(ExternalLinkFollowPlugin r100) {
            this.f226367a = r100;
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final boolean a(String r100) {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load url : " + du5.b.g(r100));
            return ExternalLinkFollowPlugin.access$100(this.f226367a, new OpenLinkEvent("", r100));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void b(String r100) {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load title : " + du5.b.g(r100));
            ExternalLinkFollowPlugin.access$100(this.f226367a, new TitleChangedEvent(r100));
        }
    }

    public static /* synthetic */ void c(ExternalLinkFollowPlugin r100, String r101, m r102) {
        r100.lambda$onAttachToHost$0(r101, r102);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private void bindLoad() {
        this.loadingCallback = new b(this);
        ExternalLinkFragment r100 = getHost().f226385e;
        ExternalLinkFragment.d r101 = this.loadingCallback;
        if (((ArrayList) r100.f226376r).contains(r101) == true) goto L6;
        ((ArrayList) r100.f226376r).add(r101);
        return;
    }

    public ExternalLinkFollowPlugin() {
        this.docFollowStateObserver = new a(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public ExternalLinkPluginHost getHost() {
        return (ExternalLinkPluginHost) super.getHost();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ PluginHost getHost() {
        return getHost();
    }

    public static /* synthetic */ TitleBar access$000(ExternalLinkFollowPlugin r100) {
        return r100.getTitleBar();
    }

    public static /* synthetic */ boolean access$200(ExternalLinkFollowPlugin r100) {
        return r100.loading;
    }

    private void innerInjectJS(String r100) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
        if (this.loading == true) goto L10;
        ExternalLinkFragment r101 = getHost().f226385e;
        if (r101.f226371m == false) goto L7;
        tt5.a.h("ExternalLinkFragment", "Js will be injected dynamically.");
        r101.Z90(r100);
        return;
    L7:
        tt5.a.d("ExternalLinkFragment", "Dynamically injecting js is disabled!");
        return;
    L10:
        throw new ExternalLinkFollowApi$InjectBeforeLoadFinishException();
    }

    private boolean processEvent(ContentEvent r100) {
        tt5.a.b(TAG, "Process event.");
        return this.externalLinkFollow.processContentEvent(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.externallink.b] */
    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        String r101 = getHost().f226385e.f226369k;
        this.externalLinkFollow = new ExternalLinkWebFollowImpl(this, getHost().f226385e, getWeb(), r101);
        bindLoad();
        e r102 = (e) org.koin.java.a.a(e.class);
        bindBridgeHandler("biz.rn.sendMessage", r102.b());
        bindBridgeHandler("biz.rn.handleMessage", r102.a(new com.bytedance.ee.bear.externallink.b(this)));
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        ExternalLinkFragment r101 = getHost().f226385e;
        ExternalLinkFragment.d r102 = this.loadingCallback;
        ((ArrayList) r101.f226376r).remove(r102);
        if (this.callBack == null) goto L6;
        ((j) org.koin.java.a.a(j.class)).p(this.callBack);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public static /* synthetic */ boolean access$100(ExternalLinkFollowPlugin r100, ContentEvent r101) {
        return r100.processEvent(r101);
    }

    public static /* synthetic */ boolean access$202(ExternalLinkFollowPlugin r100, boolean r101) {
        r100.loading = r101;
        return r101;
    }

    public static /* synthetic */ void access$300(ExternalLinkFollowPlugin r100, String r101) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
        r100.innerInjectJS(r101);
    }

    private /* synthetic */ void lambda$onAttachToHost$0(String r100, m r101) {
        tt5.a.b(TAG, "handle handleMessage callback:" + r101);
        if (r101 == null) goto L6;
        this.callBack = r101;
        ((j) org.koin.java.a.a(j.class)).j(r101);
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        if (getActivity() != null) goto L5;
    L7:
        getTitleBar().hide(false);
        this.externalLinkFollow.registerDocFollowStateObserver(this.docFollowStateObserver);
        return;
    L5:
        if (getResources().getConfiguration().orientation == 1) goto L7;
        getActivity().setRequestedOrientation(1);
        goto L7
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.externalLinkFollow.unregisterDocFollowStateObserver(this.docFollowStateObserver);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }
}
