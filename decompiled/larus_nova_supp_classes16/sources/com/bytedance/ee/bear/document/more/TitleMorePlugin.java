package com.bytedance.ee.bear.document.more;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.ability.IDocMorePanelPlugin;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.event.IEventPlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.edit.component.toolbar2.DocToolbarV2Compat;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.pageview2.PageViewModel;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TitleMorePlugin extends DocumentPlugin implements sa5.a, IDocMorePanelPlugin<DocumentPluginHost> {
    private static final String CCM_MOBILE_ENABLE_MORE_PANEL_DOCUMENT_INFO_REFRESH = "ccm.mobile.enable_more_panel_document_info_refresh";
    private static final String TAG = "TitleMorePlugin";
    private final IEventPlugin.a mOnDeleteListener;
    private final com.bytedance.ee.bear.more.protocol3.panel.u morePanelAbility;

    public class a implements IEventPlugin.a {
        public a() {
        }

        @Override // com.bytedance.ee.bear.document.event.IEventPlugin.a
        public final void a(String r1) {
            com.bytedance.ee.util.ui.j.c(new n1());
        }
    }

    public class b implements x2.b {
        public final /* synthetic */ DocumentPluginHost a;
        public final /* synthetic */ TitleMorePlugin b;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            if (TextUtils.isEmpty(TitleMorePlugin.access$100(this.b).getToken()) == true) goto L6;
            ViewModelProviders.of(TitleMorePlugin.access$200(this.b)).get(PageViewModel.class).getPageView(TitleMorePlugin.access$300(this.b).getDocumentTypeValue(), TitleMorePlugin.access$400(this.b).getToken());
            this.a.getDocumentLoader().S(this);
            return;
        }

        public b(TitleMorePlugin r1, DocumentPluginHost r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            this.a.getDocumentLoader().S(this);
        }
    }

    public class c implements tb5.i<MoreModel> {
        public final /* synthetic */ TitleMorePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(TitleMorePlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v39, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
        @Override // tb5.i, tb5.o
        public final void handle(Object r64, tb5.m r66) {
            MoreModel r1 = (MoreModel) r64;
            tt5.a.h(TitleMorePlugin.TAG, "show more， invisibles is " + Arrays.toString(r1.getInvisibles()) + ", disables is " + Arrays.toString(r1.getDisables()) + ", badges is " + Arrays.toString(r1.getBadges()) + ", Enables is " + r1.getEnables() + ", switchOn is " + Arrays.toString(r1.getSwitchOn()));
            TitleMorePlugin.access$500(this.a);
            DocumentPluginHost r2 = (DocumentPluginHost) this.a.getHost();
            int r4 = g1.a;
            Intrinsics.checkNotNullParameter(r2, "pluginHost");
            Intrinsics.checkNotNullParameter(r1, "moreModel");
            DocViewModel r3 = r2.a();
            DocumentInfo r5 = r3.getDocumentInfoData();
            String r17 = r3.getEditionId();
            StringBuilder r6 = new StringBuilder("getMoreInfo, documentInfo?=");
            if (r5 != null) goto L5;
            boolean r7 = true;
        L6:
            r6.append(r7);
            tt5.a.h("MoreInfoUtil", r6.toString());
            if (r5 != null) goto L9;
            BearUrl r8 = r3.getBearUrl();
            DocMetaInfo r9 = new DocMetaInfo(r3.getDocTitle(), false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -2, 63, null);
            DocPermission r10 = new DocPermission(null, 3);
            DocVersion r11 = new DocVersion(0, 1, null);
            r11.setNil(true);
            Unit r12 = Unit.INSTANCE;
            r5 = new DocumentInfo(r9, r10, r11, r8.e, r8.b, sbb.e.g(r8.a), null, 64, null);
        L9:
            sbb.e r13 = sbb.e.n;
            if (r3.isType(r13) == false) goto L15;
            int r14 = r5.getType();
            Intrinsics.checkNotNull(r3);
            String r16 = r5.getUrl();
            if (TextUtils.isEmpty(r3.getDocFeedId()) == true) goto L14;
            r16 = r16 + "&docId=" + r3.getDocFeedId() + "&sourceType=" + r3.getSourceType();
        L14:
            oj5.a r18 = new oj5.f(r14, r16, r5.getObjToken(), r3.getOriginBearUrl().b, r17, 3064);
            oj5.d r19 = new oj5.d(0);
            r19.h(r5.getSpaceId());
            r18.H = r19;
            oj5.a r110 = r18;
        L16:
            int r111 = r3.getDocumentTypeValue();
            BenefitStore r112 = r3.getBenefitStore();
            r110.S(((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).H(r111, r3.isType(r13), false, r112, ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1()));
            DocMetaInfo r20 = r5.getDocMetaInfo();
            Intrinsics.checkNotNullParameter(r20, "docMetaInfo");
            r110.g = r20;
            DocObjInfo r21 = r5.getDocObjInfo();
            Intrinsics.checkNotNullParameter(r21, "docObjInfo");
            r110.h = r21;
            r110.r(r5.getDocPermission());
            DocVersion r22 = r5.getVersion();
            Intrinsics.checkNotNullParameter(r22, "docVersion");
            r110.j = r22;
            Map<String, String> r23 = r1.getDisableReasons();
            if (com.bytedance.ee.bear.more.protocol3.panel.y.a() == false) goto L70;
            String[] r24 = r1.getDisables();
            if (r24 != null) goto L21;
        L27:
            boolean r113 = true;
        L28:
            if (r113 == false) goto L37;
            if (r23 != null) goto L31;
        L34:
            boolean r114 = true;
        L35:
            if (r114 == false) goto L37;
        L69:
            r110.v = r24;
            r110.w = r23;
        L71:
            r110.x = r1.getInvisibles();
            r110.y = r1.getSwitchOn();
            r110.z = r1.getBadges();
            r110.A = r1.getBitable().isPro();
            ArrayList<BlockSimpleInfo> r26 = r1.getBitable().getTables();
            Intrinsics.checkNotNullParameter(r26, "tables");
            r110.B = r26;
            ArrayList<BlockSimpleInfo> r27 = r1.getBitable().getBlocks();
            Intrinsics.checkNotNullParameter(r27, "blocks");
            r110.C = r27;
            r110.L = r1.getMinutes().getHasAudio();
            r110.M = r1.getMinutes().isAudioMinutes();
            r110.N = r1.getMinutes().getToken();
            DocsOpenSource r28 = r3.getOpenSource();
            DocsOpenSource r29 = DocsOpenSource.vc;
            if (r28 != r29) goto L74;
            boolean r115 = true;
        L75:
            r110.k = r115;
            if (r3.getOpenSource() != DocsOpenSource.doc_component) goto L78;
            boolean r116 = true;
        L79:
            r110.l = r116;
            r110.D = r3.getContainerType();
            r110.I = r5.getDocMetaInfo().getEditTime();
            MoreModel.Enables r30 = r1.getEnables();
            if (r30 == null) goto L87;
            MoreModel.AiSummary r31 = r30.getAiSummary();
            if (r31 == null) goto L87;
            MoreModel.TagInfo r32 = r31.getTagInfo();
            if (r32 == null) goto L87;
            String r33 = r32.getText();
            if (r33 == null) goto L87;
        L88:
            r110.K = r33;
            String r34 = r110.b;
            String r36 = TitleMorePlugin.access$600(this.a).getOriginUrl();
            boolean r37 = TitleMorePlugin.access$700(this.a).isEditionDoc();
            if (TitleMorePlugin.access$800(this.a).getOpenSource() != r29) goto L91;
            boolean r117 = true;
        L92:
            if (r37 == false) goto L99;
            if (r117 == true) goto L99;
            BearUrl r38 = TitleMorePlugin.access$900(this.a).getBearUrl();
            if (TitleMorePlugin.access$1000(this.a).isType(sbb.e.n) == false) goto L97;
            r38.m = TitleMorePlugin.access$1100(this.a).getOriginUrl();
        L97:
            com.bytedance.ee.bear.more.protocol3.extension.v r39 = new EditionDocMoreProvider((DocumentPluginHost) this.a.getHost(), new wj5.a(r38, r110));
        L114:
            com.bytedance.ee.bear.more.protocol3.extension.v r118 = r39;
            r118.j(new o1(this), new p1());
            if (TitleMorePlugin.access$1600(this.a) == false) goto L118;
            TitleMorePlugin.access$1700(this.a, r118, r110);
        L118:
            if (((DocumentPluginHost) this.a.getHost()).getUIContainer() != null) goto L120;
        L122:
            View r119 = null;
        L124:
            if (ForsetiHelper.o() == false) goto L126;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).C(((DocumentPluginHost) this.a.getHost()).getActivity(), r118, ((DocumentPluginHost) this.a.getHost()).c(), r119, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.b(((DocumentPluginHost) this.a.getHost()).getActivity(), r119));
        L127:
            DocToolbarV2Compat.of(TitleMorePlugin.access$1800(this.a)).forceClearToolbar();
            return;
        L126:
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).e(((DocumentPluginHost) this.a.getHost()).getActivity(), r118, ((DocumentPluginHost) this.a.getHost()).c(), com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.b(((DocumentPluginHost) this.a.getHost()).getActivity(), r119));
            goto L127
        L120:
            if (((DocumentPluginHost) this.a.getHost()).getUIContainer().getTitleBar() == null) goto L122;
            r119 = ((DocumentPluginHost) this.a.getHost()).getUIContainer().getTitleBar().a();
        L99:
            if (((bn4.a) org.koin.java.a.a(bn4.a.class)).a(this.a.getHost()) == true) goto L101;
        L105:
            com.bytedance.ee.bear.more.protocol3.extension.a r40 = new com.bytedance.ee.bear.more.protocol3.extension.a(r34, r36, r110);
            boolean r41 = TitleMorePlugin.access$1200(this.a);
            tt5.a.h(TitleMorePlugin.TAG, "show more, useOfficeMore=" + r41 + ", config=" + TitleMorePlugin.access$1300(this.a).a());
            if (r41 == true) goto L108;
            r39 = new DocMoreProvider((DocumentPluginHost) this.a.getHost(), r40);
            goto L114
        L108:
            if (TitleMorePlugin.access$1300(this.a).a() == null) goto L110;
        L112:
            r39 = new OfficeMoreProvider((DocumentPluginHost) this.a.getHost(), r40, TitleMorePlugin.access$1300(this.a));
            goto L114
        L110:
            if (LarkAppContext.inst().buildConfig().isLarkApp() == false) goto L112;
            final boolean r42 = TitleMorePlugin.access$1500(this.a).isType(sbb.e.n);
            d1 r43 = d1.a;
            com.bytedance.ee.bear.more.protocol3.panel.u r44 = TitleMorePlugin.access$1300(this.a);
            r43.getClass();
            Intrinsics.checkNotNullParameter(r44, "ability");
            r44.registerMoreConfig(new LarkDocBaselineConfig$apply$1(r42));
            tt5.a.h(TitleMorePlugin.TAG, "register inner config, isWiki=" + r42);
            goto L112
        L101:
            if (TitleMorePlugin.access$1200(this.a) == true) goto L103;
        L104:
            r39 = new BitableAppMoreProvider((DocumentPluginHost) this.a.getHost(), new wj5.a(TitleMorePlugin.access$1400(this.a).getBearUrl(), r110));
            goto L114
        L103:
            if (TitleMorePlugin.access$1300(this.a).a() != null) goto L105;
        L91:
            r117 = false;
        L87:
            r33 = "";
            goto L88
        L78:
            r116 = false;
            goto L79
        L74:
            r115 = false;
            goto L75
        L31:
            if (r23.isEmpty() == true) goto L34;
            r114 = false;
        L37:
            LinkedHashSet r46 = new LinkedHashSet();
            if (r24 == null) goto L48;
            int r47 = r24.length;
            int r120 = 0;
        L40:
            if (r120 >= r47) goto L48;
            String r121 = r24[r120];
            if (r121.length() <= 0) goto L44;
            boolean r122 = true;
        L45:
            if (r122 == false) goto L47;
            r46.add(r121);
        L47:
            r120 = r120 + 1;
            goto L40
        L44:
            r122 = false;
        L48:
            if (r23 == null) goto L60;
            Set<String> r48 = r23.keySet();
            if (r48 == null) goto L60;
            Iterator<T> r49 = r48.iterator();
        L53:
            if (r49.hasNext() == false) goto L60;
            Object r123 = r49.next();
            if (((String) r123).length() <= 0) goto L57;
            boolean r124 = true;
        L58:
            if (r124 == false) goto L53;
            r46.add(r123);
            goto L53
        L57:
            r124 = false;
        L60:
            String[] r50 = (String[]) r46.toArray(new String[0]);
            StringBuilder r125 = new StringBuilder("mergeDisableItems, disables=");
            if (r24 == null) goto L63;
            String r126 = Arrays.toString(r24);
        L64:
            r125.append(r126);
            r125.append(", newDisableIds=");
            if (r23 == null) goto L67;
            Set<String> r127 = r23.keySet();
        L68:
            r125.append(r127);
            r125.append(", merged=");
            r125.append(Arrays.toString(r50));
            tt5.a.h("MoreInfoUtil", r125.toString());
            r24 = r50;
            goto L69
        L67:
            r127 = null;
            goto L68
        L63:
            r126 = null;
            goto L64
        L21:
            if (r24.length != 0) goto L23;
            boolean r128 = true;
        L24:
            if (r128 == true) goto L27;
            r113 = false;
            goto L28
        L23:
            r128 = false;
            goto L24
        L70:
            com.bytedance.ee.bear.more.protocol3.panel.y.c("MoreInfoUtil", "frontend_disable");
            r110.v = r1.getDisables();
            r110.w = null;
            goto L71
        L15:
            r110 = new oj5.a(r5.getType(), r5.getUrl(), r5.getObjToken(), null, false, false, null, null, null, null, false, r17, 8184);
            goto L16
        L5:
            r7 = false;
            goto L6
        }
    }

    public static /* synthetic */ void c(oj5.a r0, BaseMoreProvider r1, DocumentInfo r2) {
        lambda$bindDocumentInfoRefresh$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(TitleMorePlugin r0, Observer r1) {
        return r0.lambda$bindDocumentInfoRefresh$1(r1);
    }

    public static /* synthetic */ Unit e(TitleMorePlugin r0, Observer r1) {
        return r0.lambda$bindDocumentInfoRefresh$2(r1);
    }

    @Override // sa5.a
    public void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean enableDocumentInfoRefresh() {
        dn4.a r2 = (dn4.a) ((DocumentPluginHost) getHost()).getUserComponent().a(dn4.a.class);     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        tt5.a.k(TAG, "enableDocumentInfoRefresh: userAppSetting or fgService is null");     // Catch: Throwable -> L9
        return false;
    L7:
        r2.a();     // Catch: Throwable -> L9
        return r2.a().isEnable(CCM_MOBILE_ENABLE_MORE_PANEL_DOCUMENT_INFO_REFRESH);
    L9:
        th = move-exception;
        tt5.a.e(TAG, "enableDocumentInfoRefresh error", th, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.document.ability.IDocMorePanelPlugin
    public void unregisterMoreConfig() {
        this.morePanelAbility.unregisterMoreConfig();
    }

    public TitleMorePlugin() {
        this.morePanelAbility = new com.bytedance.ee.bear.more.protocol3.panel.f();
        this.mOnDeleteListener = new a();
    }

    private void notifyFrontedToCompute() {
        if (getDocViewModel().isType(sbb.e.g) == false) goto L5;
    L8:
        execJS("javascript:lark.biz.content.requestFileInfo", new JSONObject());
        return;
    L5:
        if (getDocViewModel().isType(sbb.e.o) == true) goto L8;
        if (getDocViewModel().isType(sbb.e.n) == true) goto L8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void requestEditionPermission() {
        if (getDocViewModel().isEditionDoc() == false) goto L6;
        int r0 = getDocViewModel().getDocumentTypeValue();
        String r1 = getDocViewModel().getEditionToken();
        ((w05.b) ((DocumentPluginHost) getHost()).getHostAbility(w05.b.class)).getDocumentInfoProvider().e(r1, r0);
        return;
    }

    private boolean shouldUseOfficeMore() {
        if (CCMOfficeSDKAssembleFG.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.more.protocol3.panel.y.a == false) goto L7;
        return true;
    }

    public static /* synthetic */ DocViewModel access$100(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$1000(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$1100(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ boolean access$1200(TitleMorePlugin r0) {
        return r0.shouldUseOfficeMore();
    }

    public static /* synthetic */ com.bytedance.ee.bear.more.protocol3.panel.u access$1300(TitleMorePlugin r0) {
        return r0.morePanelAbility;
    }

    public static /* synthetic */ DocViewModel access$1400(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$1500(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ boolean access$1600(TitleMorePlugin r0) {
        return r0.enableDocumentInfoRefresh();
    }

    public static /* synthetic */ FragmentActivity access$1800(TitleMorePlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ void access$1900(TitleMorePlugin r0) {
        r0.notifyFrontedToCompute();
    }

    public static /* synthetic */ FragmentActivity access$200(TitleMorePlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ DocViewModel access$300(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$400(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ void access$500(TitleMorePlugin r0) {
        r0.requestEditionPermission();
    }

    public static /* synthetic */ DocViewModel access$600(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$700(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$800(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ DocViewModel access$900(TitleMorePlugin r0) {
        return r0.getDocViewModel();
    }

    private /* synthetic */ Unit lambda$bindDocumentInfoRefresh$1(Observer r3) {
        if (getDocViewModel().liveDocumentInfoData() == null) goto L5;
        tt5.a.h(TAG, "bindDocumentInfoRefresh, observeForever");
        getDocViewModel().liveDocumentInfoData().observeForever(r3);
    L7:
        return Unit.INSTANCE;
    L5:
        tt5.a.k(TAG, "bindDocumentInfoRefresh, liveDocumentInfoData=null");
        goto L7
    }

    private /* synthetic */ Unit lambda$bindDocumentInfoRefresh$2(Observer r3) {
        if (getDocViewModel().liveDocumentInfoData() == null) goto L5;
        tt5.a.h(TAG, "bindDocumentInfoRefresh, removeObserver");
        getDocViewModel().liveDocumentInfoData().removeObserver(r3);
    L7:
        return Unit.INSTANCE;
    L5:
        tt5.a.k(TAG, "bindDocumentInfoRefresh, liveDocumentInfoData=null onRelease");
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.more", new c(this));
    }

    @Override // com.bytedance.ee.bear.document.ability.IDocMorePanelPlugin
    public void registerMoreConfig(Function1<? super com.bytedance.ee.bear.more.protocol3.panel.l, Unit> r2) {
        this.morePanelAbility.registerMoreConfig(r2);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.document.more.k1] */
    private void bindDocumentInfoRefresh(final BaseMoreProvider r4, final oj5.a r5) {
        if (getDocViewModel().getDocumentInfoData() != null) goto L5;
        boolean r0 = true;
    L6:
        tt5.a.h(TAG, "bindDocumentInfoRefresh, shouldObserve=" + r0);
        if (r0 == true) goto L9;
        return;
    L9:
        final ?? r1 = new k1(r5, r4);
        r4.j(new l1(this, r1), new m1(this, r1));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        IEventPlugin r4 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r4 == null) goto L6;
        r4.addDeleteListener(this.mOnDeleteListener);
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile.update_time_on_more") == false) goto L9;
        r2.getDocumentLoader().S3(new b(this, r2));
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        IEventPlugin r3 = (IEventPlugin) findPlugin(IEventPlugin.class);
        if (r3 == null) goto L6;
        r3.removeDeleteListener(this.mOnDeleteListener);
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

    public static /* synthetic */ void access$1700(TitleMorePlugin r0, BaseMoreProvider r1, oj5.a r2) {
        r0.bindDocumentInfoRefresh(r1, r2);
    }

    private static void lambda$bindDocumentInfoRefresh$0(oj5.a r5, BaseMoreProvider r6, DocumentInfo r7) {
        if (r7 != null) goto L6;
        tt5.a.h(TAG, "bindDocumentInfoRefresh, onChanged documentInfo=null");
        return;
    L6:
        boolean r1 = r5 instanceof oj5.f;
        boolean r2 = !TextUtils.isEmpty(r7.getSpaceId());
        tt5.a.h(TAG, "bindDocumentInfoRefresh, onChanged. isWiki=" + r1 + ", hasSpaceId=" + r2);
        DocMetaInfo r3 = r7.getDocMetaInfo();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "docMetaInfo");
        r5.g = r3;
        DocObjInfo r4 = r7.getDocObjInfo();
        Intrinsics.checkNotNullParameter(r4, "docObjInfo");
        r5.h = r4;
        r5.r(r7.getDocPermission());
        DocVersion r8 = r7.getVersion();
        Intrinsics.checkNotNullParameter(r8, "docVersion");
        r5.j = r8;
        r5.I = r7.getDocMetaInfo().getEditTime();
        if (r1 == false) goto L13;
        if (r2 == false) goto L13;
        oj5.d r9 = r5.H;
        if (r9 != null) goto L12;
        r9 = new oj5.d();
        r5.H = r9;
    L12:
        r9.h(r7.getSpaceId());
        tt5.a.h(TAG, "bindDocumentInfoRefresh, set wikiSpaceId");
    L13:
        tt5.a.h(TAG, "bindDocumentInfoRefresh, invalidate by documentInfo");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "moreInfo");
        ((com.bytedance.ee.bear.more.protocol3.h) r6).d = r5;
        r6.g();
    }
}
