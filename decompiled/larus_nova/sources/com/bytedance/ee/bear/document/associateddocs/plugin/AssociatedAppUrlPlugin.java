package com.bytedance.ee.bear.document.associateddocs.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfos;
import com.bytedance.ee.bear.document.associateddocs.h;
import com.bytedance.ee.bear.document.associateddocs.view.AssociatedAppUrlListFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.Contexts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003'()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u001a\u0010%\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/plugin/AssociatedAppUrlPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/associated/AssociatedAbility;", "<init>", "()V", "associatedAnalytic", "Lcom/bytedance/ee/bear/document/associateddocs/analytic/AssociatedAnalytic;", "associatedDocNetExecutor", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor;", "viewModel", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel;", "associateDataChanged", "Lcom/bytedance/ee/bear/document/associated/AssociatedAbility$AssociateDataChanged;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "ensureFragment", "observerAssociateDataChanged", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "disassociateExitingDoc", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "token", "type", "", "appUrl", "reportCcmApplicationDocsPluginClick", "click", "showDisassociateDocSuccess", "showDisassociateDocFailed", "reportCcmDocContentPageClick", "urlMetaId", "Companion", "AssociatedAppUrlsHandler", "ShowAppUrlsListPanelHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlPlugin extends DocumentPluginV2 implements e05.a {
    public static final b Companion = null;
    private static final String TAG = "AssociatedAppUrlPlugin";
    private e05.a.InterfaceC5726a associateDataChanged;
    private g05.a associatedAnalytic;
    private final com.bytedance.ee.bear.document.associateddocs.a associatedDocNetExecutor;
    private AssociatedAppUrlListViewModel viewModel;

    public final class a implements i<DocAssociatedAppUrlInfos> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219000a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AssociatedAppUrlPlugin r100) {
            this.f219000a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            DocAssociatedAppUrlInfos r102 = (DocAssociatedAppUrlInfos) r100;
            tt5.a.h(AssociatedAppUrlPlugin.TAG, "AssociatedAppUrlsHandler info: " + r102);
            if (r102 == null) goto L8;
            AssociatedAppUrlPlugin r103 = this.f219000a;
            AssociatedAppUrlListViewModel r104 = AssociatedAppUrlPlugin.access$getViewModel$p(r103);
            if (r104 == null) goto L9;
            r104.getDocAssociatedAppUrls().setValue(r102);
            r104.defaultAppUrlIcons(AssociatedAppUrlPlugin.access$getContext(r103));
            r104.requestUrlPreview(AssociatedAppUrlPlugin.access$getContext(r103));
            return;
        L9:
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public final class c implements i<UInt> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219001a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AssociatedAppUrlPlugin r100) {
            this.f219001a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            UInt r102 = (UInt) r100;
            AssociatedAppUrlPlugin.access$ensureFragment(this.f219001a);
        }
    }

    public static final class d implements com.bytedance.ee.bear.document.associateddocs.a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219002a;

        public d(AssociatedAppUrlPlugin r100) {
            this.f219002a = r100;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.a.e
        public final void a(int r100, String r101) {
            if (r100 != 0) goto L7;
            DocViewModel r102 = AssociatedAppUrlPlugin.access$getDocViewModel(this.f219002a);
            if (r102 == null) goto L6;
            r102.setAssociateAppUrl(null);
        L6:
            AssociatedAppUrlPlugin.access$showDisassociateDocSuccess(this.f219002a);
            AssociatedAppUrlPlugin.access$reportCcmApplicationDocsPluginClick(this.f219002a, "success_unbind_docs");
            return;
        L7:
            AssociatedAppUrlPlugin.access$showDisassociateDocFailed(this.f219002a);
        }
    }

    public static final class e implements AssociatedAppUrlListViewModel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219003a;

        public e(AssociatedAppUrlPlugin r100) {
            this.f219003a = r100;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "urlMetaId");
            this.f219003a.reportCcmDocContentPageClick("click_docs_relation_application", r100);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219004a;

        public f(AssociatedAppUrlPlugin r100) {
            this.f219004a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = AssociatedAppUrlPlugin.access$getContext(this.f219004a).getText(R.string.LarkCCM_Docs_AppLinkDoc_UnlinkFail_Toast).toString();     // Catch: Throwable -> L4
            Toast.showFailureText(AssociatedAppUrlPlugin.access$getContext(this.f219004a), r100, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssociatedAppUrlPlugin f219005a;

        public g(AssociatedAppUrlPlugin r100) {
            this.f219005a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CharSequence r100 = AssociatedAppUrlPlugin.access$getContext(this.f219005a).getText(R.string.LarkCCM_Docs_AppLinkDoc_DocUnlinked_Toast);     // Catch: Throwable -> L4
            Toast.showSuccessText(AssociatedAppUrlPlugin.access$getContext(this.f219005a), r100, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void showDisassociateDocFailed() {
        j.f(new f(this));
    }

    private final void showDisassociateDocSuccess() {
        j.f(new g(this));
    }

    @Override // e05.a
    public void reportCcmApplicationDocsPluginClick() {
        reportCcmApplicationDocsPluginClick("click_unbind_docs_entrance");
    }

    public AssociatedAppUrlPlugin() {
        this.associatedDocNetExecutor = new com.bytedance.ee.bear.document.associateddocs.a();
    }

    private final void ensureFragment() {
        if ((getContext() instanceof FragmentActivity) == false) goto L8;
        AssociatedAppUrlListFragment r100 = (AssociatedAppUrlListFragment) instantiateFragment(AssociatedAppUrlListFragment.class, new Bundle());
        if (r100.isResumed() == true) goto L9;
        Activity r101 = Contexts.requireActivity(getContext());
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_associateddocs_plugin_AssociatedAppUrlPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r100, ((FragmentActivity) r101).getSupportFragmentManager(), TAG);
        return;
    L9:
        return;
    }

    @Override // e05.a
    public void disassociateExitingDoc() {
        NetService r100 = (NetService) getHost().getUserComponent().a(NetService.class);
        DocViewModel r101 = getDocViewModel();
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getAssociateAppUrl()) == true) goto L7;
        disassociateExitingDoc(r100, r101.getToken(), r101.getDocumentTypeValue(), r101.getAssociateAppUrl());
        return;
    L7:
        showDisassociateDocSuccess();
    }

    public static final /* synthetic */ void access$ensureFragment(AssociatedAppUrlPlugin r100) {
        r100.ensureFragment();
    }

    public static final /* synthetic */ Context access$getContext(AssociatedAppUrlPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(AssociatedAppUrlPlugin r100) {
        return r100.getDocViewModel();
    }

    public static final /* synthetic */ AssociatedAppUrlListViewModel access$getViewModel$p(AssociatedAppUrlPlugin r100) {
        return r100.viewModel;
    }

    public static final /* synthetic */ void access$showDisassociateDocFailed(AssociatedAppUrlPlugin r100) {
        r100.showDisassociateDocFailed();
    }

    public static final /* synthetic */ void access$showDisassociateDocSuccess(AssociatedAppUrlPlugin r100) {
        r100.showDisassociateDocSuccess();
    }

    private final void reportCcmApplicationDocsPluginClick(String r100) {
        DocViewModel r101 = getDocViewModel();
        if (r101 == null) goto L14;
        Pattern r102 = com.larksuite.framework.utils.g.f285989a;
        String r103 = com.larksuite.framework.utils.g.a(r101.getToken());
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r104 = r101.getBearUrl().f222564e;
        HashMap r105 = new HashMap();
        r105.put("click", r100);
        r105.put(PickerReporterConstants.KEY.TARGET, "");
        r105.put("plugin_type", "docs");
        r105.put("show_type", "view_docs");
        r105.put("url_id", r101.getAssociateUrlMetaId());
        Intrinsics.checkNotNull(r104);
        String r106 = f05.b.a(r104);
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r105.put("biz_type", r106);
        r105.put("op_app_id", "");
        r105.put("obj_file_id", com.larksuite.framework.utils.g.a(r103));
        r105.put("obj_file_type", r101.getDocumentType());
        r105.put("obj_file_permission_type", "have_permission");
        g05.a r107 = this.associatedAnalytic;
        if (r107 == null) goto L15;
        Intrinsics.checkNotNullParameter(r105, "evenParams");
        r107.a("ccm_application_docs_plugin_click", r105);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put("biz.associateapp.urlInfos", new a(this));
        r100.put("biz.associateapp.showUrlListPanel", new c(this));
    }

    @Override // e05.a
    public void observerAssociateDataChanged(e05.a.InterfaceC5726a r100) {
        Intrinsics.checkNotNullParameter(r100, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        this.associateDataChanged = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        if (r100 == null) goto L8;
        r100.registerHostAbility(this);
        AssociatedAppUrlListViewModel r101 = (AssociatedAppUrlListViewModel) q.c(r100, AssociatedAppUrlListViewModel.class, null);
        this.viewModel = r101;
        if (r101 == null) goto L8;
        r101.setItemClickListener(new e(this));
    L8:
        if (this.associatedAnalytic != null) goto L11;
        this.associatedAnalytic = new g05.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        super.onDetachFromHost(r100);
        if (r100 == null) goto L6;
        r100.unregisterHostAbility(this);
        return;
    }

    public static final /* synthetic */ void access$reportCcmApplicationDocsPluginClick(AssociatedAppUrlPlugin r100, String r101) {
        r100.reportCcmApplicationDocsPluginClick(r101);
    }

    public final void reportCcmDocContentPageClick(String r100, String r101) {
        HashMap r102 = new HashMap(2);
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        r102.put("url_id", r101);
        DocViewModel r103 = getDocViewModel();
        if (r103 == null) goto L8;
        String r104 = r103.getUrl();
        if (r104 == null) goto L8;
        String r105 = f05.b.a(r104);
        if (r105 == null) goto L8;
    L9:
        r102.put("biz_type", r105);
        r102.put("op_app_id", "");
        g05.a r106 = this.associatedAnalytic;
        if (r106 == null) goto L13;
        Intrinsics.checkNotNullParameter(r102, "evenParams");
        r106.a("ccm_doc_content_page_click", r102);
        return;
    L13:
        return;
    L8:
        r105 = "";
        goto L9
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_associateddocs_plugin_AssociatedAppUrlPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(AssociatedAppUrlListFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        AssociatedAppUrlListFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    private final void disassociateExitingDoc(NetService r100, String r101, int r102, String r103) {
        ArrayList r104 = new ArrayList();
        r104.add(new Pair(r101, String.valueOf(r102)));
        com.bytedance.ee.bear.document.associateddocs.a r105 = this.associatedDocNetExecutor;
        d r106 = new d(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r103, "appUrl");
        Intrinsics.checkNotNullParameter(r104, "docs");
        Intrinsics.checkNotNullParameter(r106, "callback");
        r100.Vc(new com.bytedance.ee.bear.document.associateddocs.a.f()).a(com.bytedance.ee.bear.document.associateddocs.a.a(r103, r104, "/space/api/references/delete/")).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new h(r106), new com.bytedance.ee.bear.document.associateddocs.i(r106));
    }
}
