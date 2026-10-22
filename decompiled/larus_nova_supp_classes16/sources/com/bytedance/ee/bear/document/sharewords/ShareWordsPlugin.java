package com.bytedance.ee.bear.document.sharewords;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsData;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.document.sharewords.view.CCMShareWordsEnhancedView;
import com.bytedance.ee.bear.document.sharewords.view.ShareWordsForwardComponent$getFileForwardExecutor$1;
import com.bytedance.ee.bear.document.sharewords.view.i;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.BasicDialogContent;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitEnableConfig;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.ForwardViewDependency;
import com.ss.android.lark.forwardv2.dto.template.config.BotConfig;
import com.ss.android.lark.forwardv2.dto.template.config.Condition;
import com.ss.android.lark.forwardv2.dto.template.config.EntityItem;
import com.ss.android.lark.forwardv2.dto.template.config.GroupChatConfig;
import com.ss.android.lark.forwardv2.dto.template.config.ThreadConfig;
import com.ss.android.lark.forwardv2.dto.template.config.UserConfig;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/ShareWordsPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "<init>", "()V", "component", "Lcom/bytedance/ee/bear/document/sharewords/view/ShareWordsForwardComponent;", "viewModel", "Lcom/bytedance/ee/bear/document/sharewords/ShareWordsViewModel;", "iForwardCommentExcutor", "Lcom/bytedance/ee/bear/document/sharewords/ForwardCommentExcutor;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "shareWords", "data", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsData;", "showOfficeShareWordsDialog", "title", "token", "type", "", "Companion", "ShareWordsHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsPlugin extends DocumentPluginV2 {
    public static final a Companion = null;
    private static final String TAG = "ShareWordsPlugin";
    private final i component;
    private com.bytedance.ee.bear.document.sharewords.a iForwardCommentExcutor;
    private final ShareWordsViewModel viewModel;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<ShareWordsData> {
        public final /* synthetic */ ShareWordsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(ShareWordsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            ShareWordsData r4 = (ShareWordsData) r2;
            StringBuilder r5 = new StringBuilder("handle : ");
            if (r4 == null) goto L5;
            String r0 = r4.toString();
        L6:
            r5.append(du5.b.k(r0));
            tt5.a.h(ShareWordsPlugin.TAG, r5.toString());
            ShareWordsPlugin.access$getViewModel$p(this.a).updateShareWordsData(r4);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ShareWordsPlugin a;

        public c(ShareWordsPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ShareWordsData r3 = (ShareWordsData) r2;
            if (r3 == null) goto L6;
            ShareWordsPlugin.access$shareWords(this.a, r3);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ShareWordsPlugin() {
        this.component = new i();
        this.viewModel = new ShareWordsViewModel();
        this.iForwardCommentExcutor = new com.bytedance.ee.bear.document.sharewords.a(ShareWordsPlugin$iForwardCommentExcutor$1.INSTANCE);
    }

    public static final /* synthetic */ ShareWordsViewModel access$getViewModel$p(ShareWordsPlugin r0) {
        return r0.viewModel;
    }

    private final void shareWords(ShareWordsData r17) {
        if (com.bytedance.ee.util.ui.b.a(getActivity()) == true) goto L5;
        return;
    L5:
        if (isUIContainerAttached() == false) goto L39;
        DocViewModel r1 = getDocViewModel();
        if (r1 == null) goto L40;
        String r2 = r17.getSrcObjToken();
        if (r2 != null) goto L11;
        r2 = r1.getToken();
    L11:
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r4 = r2;
        Integer r3 = r17.getSrcObjType();
        if (r3 == null) goto L16;
        int r5 = r3.intValue();
    L17:
        int r6 = r5;
        t r7 = (t) org.koin.java.a.c(t.class, null, null, 6);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L20;
    L23:
        boolean r8 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile.highlight_share_comment");
        String r9 = r17.getUrl();
        boolean r10 = r17.getCommentable();
        if (r17.getShowCommentEntry() == false) goto L27;
        if (r8 == false) goto L27;
        boolean r11 = true;
    L28:
        final ShareWordsThumbnailRequest r12 = new ShareWordsThumbnailRequest(r4, r6, r9, r10, r11);
        BaseUnspecifiedOrientationPlugin r13 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r13 != null) goto L31;
    L33:
        d r14 = g.a;
        long r16 = r17.getStartTimeStamp();
        Intrinsics.checkNotNullParameter(r12, "request");
        g.g.b("IMAGE_START", r16, 0);
        g.b = r12;
        g.f = r16;
        if (g.e == true) goto L36;
        g.a.a(false);
    L36:
        final i r18 = this.component;
        final FragmentActivity r19 = getActivity();
        final com.bytedance.ee.bear.document.sharewords.a r20 = this.iForwardCommentExcutor;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r12, "request");
        Intrinsics.checkNotNullParameter(r20, "commentExcutor");
        t r21 = i.b();
        ForwardTemplate.b r22 = new ForwardTemplate.b();
        ArrayList r23 = new ArrayList();
        EntityItem.b r24 = new EntityItem.b();
        Condition.TenantCondition r26 = Condition.TenantCondition.ALL_TENANT;
        Condition.GroupChatTypeCondition r27 = Condition.GroupChatTypeCondition.ALL_CHAT;
        Condition.PublicTypeCondition r110 = Condition.PublicTypeCondition.ALL_STATUS;
        Condition.ShieldTypeCondition r111 = Condition.ShieldTypeCondition.ALL;
        Condition.TenantCondition r112 = Condition.TenantCondition.ALL_TENANT;
        GroupChatConfig r113 = new GroupChatConfig();
        r113.setGroupChatTypeCondition(r27);
        r113.setTenantCondition(r112);
        GroupChatConfig.access$000(r113, r110);
        GroupChatConfig.access$100(r113, r111);
        r24.b(r113);
        r23.add(r24.a());
        EntityItem.b r28 = new EntityItem.b();
        Condition.UserTypeCondition r29 = Condition.UserTypeCondition.ALL_USER;
        UserConfig r114 = new UserConfig();
        UserConfig.access$000(r114, r111);
        r114.setTenantCondition(r112);
        r114.setUserTypeCondition(r29);
        r28.d(r114);
        r23.add(r28.a());
        EntityItem.b r30 = new EntityItem.b();
        Condition.ThreadTypeCondition r31 = Condition.ThreadTypeCondition.ALL_THREAD;
        ThreadConfig r115 = new ThreadConfig();
        ThreadConfig.access$000(r115, r110);
        ThreadConfig.access$100(r115, r112);
        r115.setThreadTypeCondition(r31);
        r30.c(r115);
        r23.add(r30.a());
        EntityItem.b r32 = new EntityItem.b();
        r32.c = new BotConfig();
        r32.b = null;
        r32.a = null;
        r32.d = null;
        r32.e = null;
        r23.add(r32.a());
        new ArrayList();
        BusinessRecentVisitIncludeConfig r33 = new BusinessRecentVisitIncludeConfig();
        r33.a = r23;
        r22.a = r33;
        ArrayList r34 = new ArrayList();
        new ArrayList();
        BusinessRecentVisitEnableConfig r36 = new BusinessRecentVisitEnableConfig();
        r36.c = r34;
        r22.b = r36;
        ArrayList r37 = new ArrayList();
        ForwardFeature r38 = new ForwardFeature();
        r38.a = r37;
        r38.b = true;
        r38.c = true;
        r38.d = true;
        r38.e = 10;
        r38.f = true;
        r38.j = true;
        r38.g = true;
        r38.h = true;
        r38.i = false;
        r38.k = false;
        r38.m = null;
        r38.n = null;
        r38.l = false;
        r22.c = r38;
        String r39 = r19.getString(2131889080);
        BasicDialogContent r40 = new BasicDialogContent();
        r40.a = null;
        r40.b = null;
        r40.c = null;
        r40.d = null;
        r40.e = 0;
        r40.g = null;
        r40.f = null;
        r40.h = null;
        r40.i = 0;
        r40.j = false;
        r40.k = false;
        CCMShareWordsEnhancedView r41 = new CCMShareWordsEnhancedView(r12);
        ForwardViewDependency r116 = new ForwardViewDependency();
        r116.i = true;
        r116.d = r39;
        r116.e = r40;
        r116.a = true;
        r116.b = r39;
        r116.c = null;
        r116.f = r41;
        r116.g = null;
        r116.h = null;
        r116.j = false;
        r22.e = r116;
        Bundle r42 = new Bundle();
        r42.putString("share_url", r12.c);
        r22.h = r42;
        r21.n3(r19, r22.a(new ShareWordsForwardComponent$getFileForwardExecutor$1(r19, r12, r18, r20)));
        return;
    L31:
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L33;
        r13.forcePortrait();
    L27:
        r11 = false;
        goto L28
    L20:
        if (r7.Qc() == true) goto L23;
        tt5.a.h(TAG, "shareWords, OfficeSDK show share panel.");
        showOfficeShareWordsDialog(r17, r1.getDocTitle(), r4, r6);
        return;
    L16:
        r5 = r1.getDocumentTypeValue();
        goto L17
    L40:
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.selection.shareWords", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(final PluginHost r5) {
        super.onAttachToHost(r5);
        t35.a r0 = new t35.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        i r1 = this.component;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "shareWordsAnalytic");
        r1.a = r0;
        this.iForwardCommentExcutor = new com.bytedance.ee.bear.document.sharewords.a(new AnonymousClass1(r5));
    }

    public static final /* synthetic */ void access$shareWords(ShareWordsPlugin r0, ShareWordsData r1) {
        r0.shareWords(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        this.viewModel.getShareWordsData().observe(getLifecycleOwner(), new c(this));
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_sharewords_ShareWordsPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(OfficeShareWordsDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        OfficeShareWordsDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final void showOfficeShareWordsDialog(ShareWordsData r6, String r7, String r8, int r9) {
        if (StringsKt.isBlank(r6.getUrl()) == false) goto L6;
        tt5.a.k(TAG, "showOfficeShareWordsDialog, share url is blank.");
        return;
    L6:
        FragmentManager r0 = getFragmentManager();
        if (r0 != null) goto L10;
        tt5.a.k(TAG, "showOfficeShareWordsDialog, fragmentManager is null.");
        return;
    L10:
        String r2 = OfficeShareWordsDialogFragment.class.getName();
        if (r0.isStateSaved() == false) goto L13;
    L17:
        tt5.a.k(TAG, "showOfficeShareWordsDialog, skip show. isStateSaved=" + r0.isStateSaved());
        return;
    L13:
        if (r0.findFragmentByTag(r2) != null) goto L17;
        int r1 = OfficeShareWordsDialogFragment.w;
        String r10 = r6.getUrl();
        Intrinsics.checkNotNullParameter(r10, "shareUrl");
        Intrinsics.checkNotNullParameter(r7, "shareTitle");
        OfficeShareWordsDialogFragment r3 = new OfficeShareWordsDialogFragment();
        Bundle r4 = new Bundle();
        r4.putString("arg_share_url", r10);
        r4.putString("arg_share_title", r7);
        r4.putString("arg_doc_token", r8);
        r4.putInt("arg_doc_type", r9);
        r3.setArguments(r4);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_sharewords_ShareWordsPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r3, r0, r2);
    }
}
