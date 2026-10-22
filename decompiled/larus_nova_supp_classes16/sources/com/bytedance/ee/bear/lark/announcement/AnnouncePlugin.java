package com.bytedance.ee.bear.lark.announcement;

import androidx.lifecycle.LiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AnnouncePlugin extends DocumentPlugin {
    private static final String BIZ_ALERT_ANNOUNCEMENT_PUBLISH = "biz.announcement.publishAlert";
    private static final String BIZ_ANNOUNCEMENT_PUBLISH = "biz.announcement.publish";
    static final String MENU_ID_ANNOUNCE = "announce";
    private static final String TAG = "AnnouncePlugin";
    private com.bytedance.ee.bear.lark.announcement.a announceAnalytic;
    private String announceName;
    private boolean isIllegal;
    private LiveData<ConnectionService.NetworkState> mNetworkState;
    private AnnouncementPresenter mPresenter;

    public class a implements tb5.i<String> {
        public final /* synthetic */ AnnouncePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AnnouncePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, tb5.m r9) {
            String r10 = (String) r8;
            final AnnouncementPresenter r11 = AnnouncePlugin.access$400(this.a);
            final TitleBar r12 = AnnouncePlugin.access$300(this.a);
            r11.getClass();
            if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_doc_groupAnnouncement_autoSave") == false) goto L6;
            tt5.a.h("AnnouncementPresenter", "checkPublishTipCondition: had shown");
        L8:
            boolean r0 = false;
        L10:
            if (r0 == false) goto L17;
            AnnouncementPresenter.a r1 = r11.b;
            if (r1 == null) goto L15;
            r11.d.removeCallbacks(r1);
        L15:
            AnnouncementPresenter.a r6 = new AnnouncementPresenter.a(r11, "mobile_doc_groupAnnouncement_autoSave", new g(r12), new k(r11), new h(r11));
            r11.b = r6;
            r11.d.postDelayed(r6, 5000);
            return;
        L17:
            return;
        L6:
            if (r11.a.a().isCanEdit() == true) goto L9;
            tt5.a.h("AnnouncementPresenter", "checkPublishTipCondition: can't edit");
            goto L8
        L9:
            r0 = true;
            goto L10
        }
    }

    public class b implements tb5.i<Void> {
        public final /* synthetic */ AnnouncePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(AnnouncePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            Void r3 = (Void) r1;
            AnnouncePlugin r4 = this.a;
            AnnouncePlugin.access$800(r4, AnnouncePlugin.access$700(r4));
        }
    }

    public class c implements tb5.i<Void> {
        public final /* synthetic */ AnnouncePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AnnouncePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            Void r3 = (Void) r1;
            AnnouncePlugin r4 = this.a;
            AnnouncePlugin.access$900(r4, AnnouncePlugin.access$700(r4));
        }
    }

    public class d implements tb5.i<String> {
        public final /* synthetic */ AnnouncePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(AnnouncePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, tb5.m r6) {
            String r7 = (String) r5;
            tt5.a.h(AnnouncePlugin.TAG, r7);
            JSONObject r8 = JSON.parseObject(r7);     // Catch: Exception -> L11
            boolean r2 = true;
            if (r8.getInteger("type").intValue() != 1) goto L16;
            AnnouncePlugin r1 = this.a;     // Catch: Exception -> L11
            if (r8.getJSONObject("data").getBoolean("verified").booleanValue() == false) goto L9;
            r2 = false;
        L9:
            AnnouncePlugin.access$502(r1, r2);     // Catch: Exception -> L11
            AnnouncePlugin.access$600(this.a);     // Catch: Exception -> L11
            return;
        L16:
            return;
        L11:
            e = move-exception;
            tt5.a.f(AnnouncePlugin.TAG, e, false);
        }
    }

    public static /* synthetic */ void c(AnnouncePlugin r0, DocViewModel r1, ConnectionService.NetworkState r2) {
        r0.lambda$onAttachToHost$2(r1, r2);
    }

    public static /* synthetic */ void d(AnnouncePlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void e(AnnouncePlugin r0, String r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void refreshUI() {
        DocViewModel r0 = getDocViewModel();
        this.mPresenter.getClass();
        if (AnnouncementPresenter.h(r0) == false) goto L5;
        int r1 = 2131887864;
    L6:
        this.announceName = getString(r1);
        r0.setTitle(getString(r1));
        return;
    L5:
        r1 = 2131887861;
        goto L6
    }

    public AnnouncePlugin() {
    }

    public static /* synthetic */ TitleBar access$300(AnnouncePlugin r0) {
        return r0.getTitleBar();
    }

    public static /* synthetic */ AnnouncementPresenter access$400(AnnouncePlugin r0) {
        return r0.mPresenter;
    }

    public static /* synthetic */ void access$600(AnnouncePlugin r0) {
        r0.refreshUI();
    }

    public static /* synthetic */ String access$700(AnnouncePlugin r0) {
        return r0.announceName;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(DocumentInfo r1) {
        refreshUI();
    }

    private /* synthetic */ void lambda$onAttachToHost$1(String r1) {
        refreshUI();
    }

    private void notifyMember(String r2) {
        this.mPresenter.j(r2);
    }

    private void showPublishWindow(String r4) {
        AnnouncementPresenter r0 = this.mPresenter;
        r0.getClass();
        AnnouncementPresenter.AnonymousClass1 r1 = new AnnouncementPresenter.AnonymousClass1(r0, r4);
        DocumentPluginHost r5 = r0.a;
        if (r5 != null) goto L5;
    L7:
        tt5.a.d("AnnouncementPresenter", "call showAnnouncementEventWindow documentPluginHost = null || activity == null");
        return;
    L5:
        if (r5.getActivity() == null) goto L7;
        ((com.bytedance.ee.bear.lark.dependency.c) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.c.class)).a(r0.a.getActivity(), r0.f(), r1);
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        com.bytedance.ee.bear.lark.announcement.a r0 = new com.bytedance.ee.bear.lark.announcement.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        this.announceAnalytic = r0;
        this.mPresenter = new AnnouncementPresenter(r4, r0);
        this.mNetworkState = com.bytedance.ee.bear.contract.j.a.a.a();
        final DocViewModel r5 = getDocViewModel();
        r5.liveDocumentInfoData().observe(getLifecycleOwner(), new com.bytedance.ee.bear.lark.announcement.b(this));
        r5.liveDocObjToken().observe(getLifecycleOwner(), new com.bytedance.ee.bear.lark.announcement.c(this));
        this.mNetworkState.observe(getLifecycleOwner(), new com.bytedance.ee.bear.lark.announcement.d(this, r5));
        bindBridgeHandler("biz.doc.beginEdit", new a(this));
        bindBridgeHandler("biz.util.setStatus", new d(this));
        bindBridgeHandler(BIZ_ANNOUNCEMENT_PUBLISH, new b(this));
        bindBridgeHandler(BIZ_ALERT_ANNOUNCEMENT_PUBLISH, new c(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$502(AnnouncePlugin r0, boolean r1) {
        r0.isIllegal = r1;
        return r1;
    }

    public static /* synthetic */ void access$800(AnnouncePlugin r0, String r1) {
        r0.notifyMember(r1);
    }

    public static /* synthetic */ void access$900(AnnouncePlugin r0, String r1) {
        r0.showPublishWindow(r1);
    }

    private /* synthetic */ void lambda$onAttachToHost$2(DocViewModel r1, ConnectionService.NetworkState r2) {
        r1.requestDocumentInfo(getUrl());
    }

    public void onAttachToUIContainer(DocumentPluginHost r8, com.bytedance.ee.bear.browser.plugin.t r9) {
        super.onAttachToUIContainer(r8, r9);
        com.bytedance.ee.bear.lark.announcement.a r10 = this.announceAnalytic;
        if (r10 == null) goto L7;
        AnnouncementPresenter r11 = this.mPresenter;
        if (r11 == null) goto L7;
        String r12 = r11.f();
        HashMap r0 = new HashMap();
        r0.put("chat_id", r12);
        r0.putAll(r10.a);
        tt5.a.b("AnnounceAnalytic", "reportEventV2: event = im_chat_announcement_page_view, params = " + r0);
        r10.b.n("im_chat_announcement_page_view", r0);
    L7:
        final AnnouncementPresenter r13 = this.mPresenter;
        final TitleBar r14 = getTitleBar();
        r13.getClass();
        if (AnnouncementPresenter.d() == false) goto L14;
        AnnouncementPresenter.a r1 = r13.c;
        if (r1 == null) goto L13;
        r13.d.removeCallbacks(r1);
    L13:
        Objects.requireNonNull(r14);
        AnnouncementPresenter.a r2 = new AnnouncementPresenter.a(r13, "mobile_doc_groupAnnouncement_intro", new j(r14), new k(r13), new l(r13));
        r13.c = r2;
        r13.d.postDelayed(r2, 5000);
    L14:
        refreshUI();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        AnnouncementPresenter r4 = this.mPresenter;
        AnnouncementPresenter.a r5 = r4.c;
        if (r5 == null) goto L5;
        r4.d.removeCallbacks(r5);
    L5:
        AnnouncementPresenter.a r6 = r4.b;
        if (r6 == null) goto L9;
        r4.d.removeCallbacks(r6);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
