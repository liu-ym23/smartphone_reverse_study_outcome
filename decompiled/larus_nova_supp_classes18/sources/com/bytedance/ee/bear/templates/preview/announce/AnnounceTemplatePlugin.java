package com.bytedance.ee.bear.templates.preview.announce;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0004 !\"#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0014J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplatePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "templateViewModel", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "panelDelegate", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplatePlugin$TemplatePanelDelegate;", "mCallback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "hideTemplateView", "initData", "ensureFragment", "removeFragment", "handleData", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/templates/preview/announce/TemplateData;", "onBackPressed", "", "Companion", "TemplatePanelHandler", "PanelStatusChangeHandler", "TemplatePanelDelegate", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplatePlugin extends DocumentPlugin implements sa5.d {
    private static final String BIZ_ANNOUNCEMENT_SET_TEMPLATE = "biz.announcement.setTemplate";
    private static final String BIZ_ANNOUNCE_ON_TEMPLATE_VISIBLE_CHANGE = "biz.announcement.onTemplateHidden";
    private static final a Companion = null;
    private static final String TAG = "AnnounceTemplatePlugin";
    private m mCallback;
    private final c panelDelegate;
    private AnnounceTemplateViewModel templateViewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<Void> {
        public final /* synthetic */ AnnounceTemplatePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(AnnounceTemplatePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            AnnounceTemplatePlugin.access$setMCallback$p(this.a, r2);
        }
    }

    public final class c implements AnnounceTemplateViewModel.b {
        public final /* synthetic */ AnnounceTemplatePlugin a;

        @Override // com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel.b
        public final void a() {
            m r0 = AnnounceTemplatePlugin.access$getMCallback$p(this.a);
            if (r0 == null) goto L6;
            r0.b(new JSONObject());
            return;
        }

        @Override // com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel.b
        public final void b() {
            AnnounceTemplateViewModel r0 = AnnounceTemplatePlugin.access$getTemplateViewModel$p(this.a);
            if (r0 == null) goto L8;
            String r1 = r0.getAnnounceUrl();
            if (r1 == null) goto L9;
            AnnounceTemplatePlugin.access$getWeb(this.a).getWebView().loadUrl(r1);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel.b
        public final void c() {
            this.a.removeFragment();
        }

        public c(AnnounceTemplatePlugin r1) {
            this.a = r1;
        }
    }

    public final class d implements tb5.i<TemplateData> {
        public final /* synthetic */ AnnounceTemplatePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public d(AnnounceTemplatePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            TemplateData r3 = (TemplateData) r1;
            if (r3 == null) goto L5;
            this.a.handleData(r3);
            return;
        L5:
            tt5.a.d(AnnounceTemplatePlugin.TAG, "handle: TemplatePanelHandler data null!");
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void initData() {
        AnnounceTemplateViewModel r0 = this.templateViewModel;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getAnnounceToken();
    L6:
        if (r2 != null) goto L10;
        AnnounceTemplateViewModel r3 = this.templateViewModel;
        if (r3 == null) goto L10;
        r3.setAnnounceToken(getDocViewModel().getBearUrl().b);
    L10:
        AnnounceTemplateViewModel r4 = this.templateViewModel;
        if (r4 == null) goto L13;
        r1 = r4.getAnnounceUrl();
    L13:
        if (r1 != null) goto L17;
        AnnounceTemplateViewModel r5 = this.templateViewModel;
        if (r5 == null) goto L17;
        r5.setAnnounceUrl(getDocViewModel().getUrl());
    L17:
        AnnounceTemplateViewModel r6 = this.templateViewModel;
        if (r6 == null) goto L21;
        r6.setTitleBarHeight(getTitleBar().getTitleBarLayout().getLayoutParams().height);
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public AnnounceTemplatePlugin() {
        this.panelDelegate = new c(this);
    }

    private final void ensureFragment() {
        if (getUIContainer().l(this) != null) goto L5;
        getUIContainer().i(this, instantiateFragment(TemplateCardPanelFragment.class));
    L5:
        JSONObject r0 = AnnounceTemplateAnalytic.b;
        r0.put("source", "from_im_chat_announcement");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.a.getValue()).n("ccm_groupchat_template_center_show", r0);
    }

    private final void hideTemplateView() {
        ViewGroup r0 = (ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content);
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131377419);
        View r2 = r0.findViewById(2131391146);
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        if (r2 == null) goto L8;
        r2.setVisibility(8);
        return;
    }

    public boolean onBackPressed() {
        getActivity().finish();
        return true;
    }

    public void removeFragment() {
        if (getUIContainer() != null) goto L5;
        return;
    L5:
        if (getUIContainer().l(this) == null) goto L9;
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.removeFragment();
        Lazy r0 = AnnounceTemplateAnalytic.a;
        Intrinsics.checkNotNullParameter("hidden_template", "action");
        JSONObject r2 = AnnounceTemplateAnalytic.b;
        r2.put("action", "hidden_template");
        r2.put("source", "from_im_chat_announcement");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.a.getValue()).n("docs_toggle_attribute", r2);
        return;
    }

    public static final /* synthetic */ m access$getMCallback$p(AnnounceTemplatePlugin r0) {
        return r0.mCallback;
    }

    public static final /* synthetic */ AnnounceTemplateViewModel access$getTemplateViewModel$p(AnnounceTemplatePlugin r0) {
        return r0.templateViewModel;
    }

    public static final /* synthetic */ k access$getWeb(AnnounceTemplatePlugin r0) {
        return r0.getWeb();
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        bindBridgeHandler(BIZ_ANNOUNCEMENT_SET_TEMPLATE, new d(this));
        bindBridgeHandler(BIZ_ANNOUNCE_ON_TEMPLATE_VISIBLE_CHANGE, new b(this));
    }

    public final void handleData(TemplateData r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        AnnounceTemplateViewModel r0 = this.templateViewModel;
        if (r0 == null) goto L5;
        r0.setTemplateData(r2);
    L5:
        Boolean r3 = r2.getVisible();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r1) == false) goto L11;
        AnnounceTemplateViewModel r4 = this.templateViewModel;
        if (r4 == null) goto L10;
        r4.loadCardData();
    L10:
        ensureFragment();
        return;
    L11:
        AnnounceTemplateViewModel r5 = this.templateViewModel;
        if (r5 == null) goto L16;
        TemplateData r6 = r5.getTemplateData();
        if (r6 == null) goto L16;
        boolean r7 = Intrinsics.areEqual(r6.getNeedAnimation(), r1);
    L17:
        if (r7 == false) goto L23;
        AnnounceTemplateViewModel r8 = this.templateViewModel;
        if (r8 == null) goto L30;
        AnnounceTemplateViewModel.c r9 = r8.getViewDelegate();
        if (r9 == null) goto L31;
        r9.a();
        return;
    L31:
        return;
    L30:
        return;
    L23:
        removeFragment();
        AnnounceTemplateViewModel r10 = this.templateViewModel;
        if (r10 == null) goto L33;
        MutableLiveData<Boolean> r11 = r10.m569getPanelActive();
        if (r11 == null) goto L34;
        r11.setValue(Boolean.FALSE);
        return;
    L34:
        return;
    L33:
        return;
    L16:
        r7 = false;
        goto L17
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        AnnounceTemplateViewModel r3 = (AnnounceTemplateViewModel) new ViewModelProvider(getActivity()).get(AnnounceTemplateViewModel.class);
        this.templateViewModel = r3;
        if (r3 == null) goto L6;
        r3.setPanelDelegate(this.panelDelegate);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setMCallback$p(AnnounceTemplatePlugin r0, m r1) {
        r0.mCallback = r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        hideTemplateView();
        initData();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
