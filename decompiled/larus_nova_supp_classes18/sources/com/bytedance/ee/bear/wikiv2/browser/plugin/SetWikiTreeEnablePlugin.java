package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SetWikiTreeEnablePlugin extends BasePluginV2 {
    private static final String TAG = "SetWikiTreeEnablePlugin";
    private boolean hasObserve;

    public static class WikiTreeItemEnableInfo implements NonProguard {
        public boolean enable;

        public WikiTreeItemEnableInfo() {
        }

        public String toString() {
            return "WikiTreeItemEnableInfo{enable=" + this.enable + '}';
        }
    }

    public class a extends x2.c {
        public final /* synthetic */ SetWikiTreeEnablePlugin a;

        public final void onLoadStart() {
            this.a.getHost().findPluginToDo(WikiTreeMenuPlugin.class, new i());
        }

        public final void onLoadSuccess() {
            this.a.getHost().findPluginToDo(WikiTreeMenuPlugin.class, new h());
        }

        public a(SetWikiTreeEnablePlugin r1) {
            this.a = r1;
        }

        public final void onLoadFail(final int r3, Throwable r4) {
            this.a.getHost().findPluginToDo(WikiTreeMenuPlugin.class, new j(r3));
        }
    }

    public class b implements tb5.i<WikiTreeItemEnableInfo> {
        public final /* synthetic */ SetWikiTreeEnablePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SetWikiTreeEnablePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, tb5.m r4) {
            final WikiTreeItemEnableInfo r5 = (WikiTreeItemEnableInfo) r3;
            tt5.a.h(SetWikiTreeEnablePlugin.TAG, "SetWikiTreeEnable:" + r5);
            if (r5 == null) goto L6;
            this.a.getHost().findPluginToDo(WikiTreeMenuPlugin.class, new k(r5));
            return;
        }
    }

    public static /* synthetic */ void a(Boolean r0, WikiTreeMenuPlugin r1) {
        lambda$observerShowingHistory$4(r0, r1);
    }

    public static /* synthetic */ void c(SetWikiTreeEnablePlugin r0, Boolean r1) {
        r0.lambda$observerShowingHistory$5(r1);
    }

    public static /* synthetic */ void d(SetWikiTreeEnablePlugin r0, r4.a r1) {
        r0.lambda$observeFileTreeMenuEnable$2(r1);
    }

    public static /* synthetic */ void e(DocumentPluginHost r0, WikiTreeMenuPlugin r1) {
        lambda$observeDocumentTreeMenuEnable$3(r0, r1);
    }

    public static /* synthetic */ void f(WikiTreeMenuPlugin r0) {
        lambda$observeFileTreeMenuEnable$0(r0);
    }

    public static /* synthetic */ void g(int r0, WikiTreeMenuPlugin r1) {
        lambda$observeFileTreeMenuEnable$1(r0, r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void observeFileTreeMenuEnable() {
        r4 r0 = getHostAbilityOrNull(r4.class);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getLoadState().observe(getLifecycleOwner(), new f(this));
    }

    public SetWikiTreeEnablePlugin() {
        this.hasObserve = false;
    }

    private static /* synthetic */ void lambda$observeFileTreeMenuEnable$0(WikiTreeMenuPlugin r1) {
        r1.setLoadState(0);
    }

    private void lambda$observeFileTreeMenuEnable$2(r4.a r4) {
        if ((r4 instanceof r4.a.c) == false) goto L6;
        getHost().findPluginToDo(WikiTreeMenuPlugin.class, new c());
        return;
    L6:
        if ((r4 instanceof r4.a.a) == false) goto L10;
        final int r5 = ((r4.a.a) r4).a;
        getHost().findPluginToDo(WikiTreeMenuPlugin.class, new d(r5));
        return;
    }

    private /* synthetic */ void lambda$observerShowingHistory$5(final Boolean r4) {
        getHost().findPluginToDo(WikiTreeMenuPlugin.class, new g(r4));
    }

    private void observeDocumentTreeMenuEnable(final DocumentPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        tt5.a.h(TAG, "onAttachToHost. ");
        observerTreeMenuEnable(r4);
        observerShowingHistory(r4);
        getHost().findPluginToDo(WikiTreeMenuPlugin.class, new com.bytedance.ee.bear.wikiv2.browser.plugin.b(r4));
        r4.getWeb().h("biz.wiki.setWikiTreeEnable", new b(this));
    }

    private void observerShowingHistory(DocumentPluginHost r3) {
        r3.a().isShowingHistory().observe(getLifecycleOwner(), new e(this));
    }

    private void observerTreeMenuEnable(DocumentPluginHost r2) {
        r2.getDocumentLoader().S3(new a(this));
    }

    public void onAttachToHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if ((r2 instanceof DocumentPluginHost) == false) goto L6;
        observeDocumentTreeMenuEnable((DocumentPluginHost) r2);
        this.hasObserve = true;
        return;
    }

    private static /* synthetic */ void lambda$observeDocumentTreeMenuEnable$3(DocumentPluginHost r0, WikiTreeMenuPlugin r1) {
        r1.setDocComponent(DocComponentConfig.isDocComponent(r0.a().getBearUrl()));
    }

    private static /* synthetic */ void lambda$observeFileTreeMenuEnable$1(int r0, WikiTreeMenuPlugin r1) {
        r1.setLoadState(r0);
    }

    private static /* synthetic */ void lambda$observerShowingHistory$4(Boolean r0, WikiTreeMenuPlugin r1) {
        r1.setShowingHistory(r0.booleanValue());
    }

    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        if (this.hasObserve == true) goto L6;
        observeFileTreeMenuEnable();
        return;
    }
}
