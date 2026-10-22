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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public /* bridge */ /* synthetic */ void registerPerfMonitor(py4.d.b r1) {
        }

        @Override // com.bytedance.ee.bear.doc.follow.impl.WebRNFollowImpl
        public /* bridge */ /* synthetic */ void unregisterPerfMonitor(py4.d.b r1) {
        }

        public void injectJS(String r2) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
            ExternalLinkFollowPlugin.access$300(this.this$0, r2);
        }

        public ExternalLinkWebFollowImpl(ExternalLinkFollowPlugin r1, Fragment r2, k r3, String r4) {
            this.this$0 = r1;
            super(r2, r3, r4, 0);
        }
    }

    public class a extends c {
        public final /* synthetic */ ExternalLinkFollowPlugin b;

        @Override // sy4.c
        public final View c() {
            TitleBar r0 = ExternalLinkFollowPlugin.access$000(this.b);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getTitleBarLayout();
        }

        public a(ExternalLinkFollowPlugin r1) {
            this.b = r1;
        }
    }

    public class b implements ExternalLinkFragment.d {
        public final /* synthetic */ ExternalLinkFollowPlugin a;

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadFail() {
            if (ExternalLinkFollowPlugin.access$200(this.a) == true) goto L5;
            tt5.a.k(ExternalLinkFollowPlugin.TAG, "Duplicate load result:fail");
            return;
        L5:
            ExternalLinkFollowPlugin.access$202(this.a, false);
            ExternalLinkFollowPlugin.access$100(this.a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadFail));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadStart() {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load start.");
            ExternalLinkFollowPlugin.access$202(this.a, true);
            ExternalLinkFollowPlugin.access$100(this.a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.Loading));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void onLoadSuccess() {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load success.");
            if (ExternalLinkFollowPlugin.access$200(this.a) == true) goto L5;
            tt5.a.k(ExternalLinkFollowPlugin.TAG, "Duplicate load result:success");
            return;
        L5:
            ExternalLinkFollowPlugin.access$202(this.a, false);
            ExternalLinkFollowPlugin.access$100(this.a, new LoadStateChangedEvent(LoadStateChangedEvent.LoadState.LoadSuccess));
        }

        public b(ExternalLinkFollowPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final boolean a(String r4) {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load url : " + du5.b.g(r4));
            return ExternalLinkFollowPlugin.access$100(this.a, new OpenLinkEvent("", r4));
        }

        @Override // com.bytedance.ee.bear.externallink.ExternalLinkFragment.d
        public final void b(String r3) {
            tt5.a.h(ExternalLinkFollowPlugin.TAG, "Load title : " + du5.b.g(r3));
            ExternalLinkFollowPlugin.access$100(this.a, new TitleChangedEvent(r3));
        }
    }

    public static /* synthetic */ void c(ExternalLinkFollowPlugin r0, String r1, m r2) {
        r0.lambda$onAttachToHost$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void bindLoad() {
        this.loadingCallback = new b(this);
        ExternalLinkFragment r0 = getHost().e;
        ExternalLinkFragment.d r1 = this.loadingCallback;
        if (((ArrayList) r0.r).contains(r1) == true) goto L6;
        ((ArrayList) r0.r).add(r1);
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

    public static /* synthetic */ TitleBar access$000(ExternalLinkFollowPlugin r0) {
        return r0.getTitleBar();
    }

    public static /* synthetic */ boolean access$200(ExternalLinkFollowPlugin r0) {
        return r0.loading;
    }

    private void innerInjectJS(String r4) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
        if (this.loading == true) goto L10;
        ExternalLinkFragment r0 = getHost().e;
        if (r0.m == false) goto L7;
        tt5.a.h("ExternalLinkFragment", "Js will be injected dynamically.");
        r0.Z90(r4);
        return;
    L7:
        tt5.a.d("ExternalLinkFragment", "Dynamically injecting js is disabled!");
        return;
    L10:
        throw new ExternalLinkFollowApi$InjectBeforeLoadFinishException();
    }

    private boolean processEvent(ContentEvent r3) {
        tt5.a.b(TAG, "Process event.");
        return this.externalLinkFollow.processContentEvent(r3);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.externallink.b] */
    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        String r5 = getHost().e.k;
        this.externalLinkFollow = new ExternalLinkWebFollowImpl(this, getHost().e, getWeb(), r5);
        bindLoad();
        e r6 = (e) org.koin.java.a.a(e.class);
        bindBridgeHandler("biz.rn.sendMessage", r6.b());
        bindBridgeHandler("biz.rn.handleMessage", r6.a(new com.bytedance.ee.bear.externallink.b(this)));
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        ExternalLinkFragment r3 = getHost().e;
        ExternalLinkFragment.d r0 = this.loadingCallback;
        ((ArrayList) r3.r).remove(r0);
        if (this.callBack == null) goto L6;
        ((j) org.koin.java.a.a(j.class)).p(this.callBack);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$100(ExternalLinkFollowPlugin r0, ContentEvent r1) {
        return r0.processEvent(r1);
    }

    public static /* synthetic */ boolean access$202(ExternalLinkFollowPlugin r0, boolean r1) {
        r0.loading = r1;
        return r1;
    }

    public static /* synthetic */ void access$300(ExternalLinkFollowPlugin r0, String r1) throws ExternalLinkFollowApi$InjectBeforeLoadFinishException {
        r0.innerInjectJS(r1);
    }

    private /* synthetic */ void lambda$onAttachToHost$0(String r2, m r3) {
        tt5.a.b(TAG, "handle handleMessage callback:" + r3);
        if (r3 == null) goto L6;
        this.callBack = r3;
        ((j) org.koin.java.a.a(j.class)).j(r3);
        return;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
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

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.externalLinkFollow.unregisterDocFollowStateObserver(this.docFollowStateObserver);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
