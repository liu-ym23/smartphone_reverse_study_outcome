package com.bytedance.ee.bear.document.associateddocs.plugin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
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
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003'()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\u001a\u0010%\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010&\u001a\u0004\u0018\u00010\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/plugin/AssociatedAppUrlPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/associated/AssociatedAbility;", "<init>", "()V", "associatedAnalytic", "Lcom/bytedance/ee/bear/document/associateddocs/analytic/AssociatedAnalytic;", "associatedDocNetExecutor", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor;", "viewModel", "Lcom/bytedance/ee/bear/document/associateddocs/AssociatedAppUrlListViewModel;", "associateDataChanged", "Lcom/bytedance/ee/bear/document/associated/AssociatedAbility$AssociateDataChanged;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "ensureFragment", "observerAssociateDataChanged", "changed", "disassociateExitingDoc", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "token", "type", "", "appUrl", "reportCcmApplicationDocsPluginClick", "click", "showDisassociateDocSuccess", "showDisassociateDocFailed", "reportCcmDocContentPageClick", "urlMetaId", "Companion", "AssociatedAppUrlsHandler", "ShowAppUrlsListPanelHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssociatedAppUrlPlugin extends DocumentPluginV2 implements e05.a {
    public static final b Companion = null;
    private static final String TAG = "AssociatedAppUrlPlugin";
    private e05.a.InterfaceC0215a associateDataChanged;
    private g05.a associatedAnalytic;
    private final com.bytedance.ee.bear.document.associateddocs.a associatedDocNetExecutor;
    private AssociatedAppUrlListViewModel viewModel;

    public final class a implements i<DocAssociatedAppUrlInfos> {
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            DocAssociatedAppUrlInfos r5 = (DocAssociatedAppUrlInfos) r3;
            tt5.a.h(AssociatedAppUrlPlugin.TAG, "AssociatedAppUrlsHandler info: " + r5);
            if (r5 == null) goto L8;
            AssociatedAppUrlPlugin r6 = this.a;
            AssociatedAppUrlListViewModel r0 = AssociatedAppUrlPlugin.access$getViewModel$p(r6);
            if (r0 == null) goto L9;
            r0.getDocAssociatedAppUrls().setValue(r5);
            r0.defaultAppUrlIcons(AssociatedAppUrlPlugin.access$getContext(r6));
            r0.requestUrlPreview(AssociatedAppUrlPlugin.access$getContext(r6));
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
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            UInt r3 = (UInt) r1;
            AssociatedAppUrlPlugin.access$ensureFragment(this.a);
        }
    }

    public static final class d implements com.bytedance.ee.bear.document.associateddocs.a.e {
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        public d(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.a.e
        public final void a(int r1, String r2) {
            if (r1 != 0) goto L7;
            DocViewModel r3 = AssociatedAppUrlPlugin.access$getDocViewModel(this.a);
            if (r3 == null) goto L6;
            r3.setAssociateAppUrl(null);
        L6:
            AssociatedAppUrlPlugin.access$showDisassociateDocSuccess(this.a);
            AssociatedAppUrlPlugin.access$reportCcmApplicationDocsPluginClick(this.a, "success_unbind_docs");
            return;
        L7:
            AssociatedAppUrlPlugin.access$showDisassociateDocFailed(this.a);
        }
    }

    public static final class e implements AssociatedAppUrlListViewModel.b {
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        public e(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel.b
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "urlMetaId");
            this.a.reportCcmDocContentPageClick("click_docs_relation_application", r3);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        public f(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = AssociatedAppUrlPlugin.access$getContext(this.a).getText(2131888954).toString();     // Catch: Throwable -> L4
            Toast.showFailureText(AssociatedAppUrlPlugin.access$getContext(this.a), r0, 1);     // Catch: Throwable -> L4
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
        public final /* synthetic */ AssociatedAppUrlPlugin a;

        public g(AssociatedAppUrlPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CharSequence r0 = AssociatedAppUrlPlugin.access$getContext(this.a).getText(2131888948);     // Catch: Throwable -> L4
            Toast.showSuccessText(AssociatedAppUrlPlugin.access$getContext(this.a), r0, 1);     // Catch: Throwable -> L4
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
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
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
        AssociatedAppUrlListFragment r0 = instantiateFragment(AssociatedAppUrlListFragment.class, new Bundle());
        if (r0.isResumed() == true) goto L9;
        FragmentActivity r1 = Contexts.requireActivity(getContext());
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_associateddocs_plugin_AssociatedAppUrlPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, r1.getSupportFragmentManager(), TAG);
        return;
    L9:
        return;
    }

    @Override // e05.a
    public void disassociateExitingDoc() {
        NetService r0 = (NetService) getHost().getUserComponent().a(NetService.class);
        DocViewModel r1 = getDocViewModel();
        if (r1 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r1.getAssociateAppUrl()) == true) goto L7;
        disassociateExitingDoc(r0, r1.getToken(), r1.getDocumentTypeValue(), r1.getAssociateAppUrl());
        return;
    L7:
        showDisassociateDocSuccess();
    }

    public static final /* synthetic */ void access$ensureFragment(AssociatedAppUrlPlugin r0) {
        r0.ensureFragment();
    }

    public static final /* synthetic */ Context access$getContext(AssociatedAppUrlPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(AssociatedAppUrlPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ AssociatedAppUrlListViewModel access$getViewModel$p(AssociatedAppUrlPlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$showDisassociateDocFailed(AssociatedAppUrlPlugin r0) {
        r0.showDisassociateDocFailed();
    }

    public static final /* synthetic */ void access$showDisassociateDocSuccess(AssociatedAppUrlPlugin r0) {
        r0.showDisassociateDocSuccess();
    }

    private final void reportCcmApplicationDocsPluginClick(String r7) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L14;
        Pattern r1 = com.larksuite.framework.utils.g.a;
        String r2 = com.larksuite.framework.utils.g.a(r0.getToken());
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        String r3 = r0.getBearUrl().e;
        HashMap r4 = new HashMap();
        r4.put("click", r7);
        r4.put("target", "");
        r4.put("plugin_type", "docs");
        r4.put("show_type", "view_docs");
        r4.put("url_id", r0.getAssociateUrlMetaId());
        Intrinsics.checkNotNull(r3);
        String r8 = f05.b.a(r3);
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r4.put("biz_type", r8);
        r4.put("op_app_id", "");
        r4.put("obj_file_id", com.larksuite.framework.utils.g.a(r2));
        r4.put("obj_file_type", r0.getDocumentType());
        r4.put("obj_file_permission_type", "have_permission");
        g05.a r9 = this.associatedAnalytic;
        if (r9 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "evenParams");
        r9.a("ccm_application_docs_plugin_click", r4);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put("biz.associateapp.urlInfos", new a(this));
        r3.put("biz.associateapp.showUrlListPanel", new c(this));
    }

    @Override // e05.a
    public void observerAssociateDataChanged(e05.a.InterfaceC0215a r2) {
        Intrinsics.checkNotNullParameter(r2, "changed");
        this.associateDataChanged = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r4) {
        super.onAttachToHost(r4);
        if (r4 == null) goto L8;
        r4.registerHostAbility(this);
        AssociatedAppUrlListViewModel r5 = (AssociatedAppUrlListViewModel) q.c(r4, AssociatedAppUrlListViewModel.class, null);
        this.viewModel = r5;
        if (r5 == null) goto L8;
        r5.setItemClickListener(new e(this));
    L8:
        if (this.associatedAnalytic != null) goto L11;
        this.associatedAnalytic = new g05.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        if (r1 == null) goto L6;
        r1.unregisterHostAbility(this);
        return;
    }

    public static final /* synthetic */ void access$reportCcmApplicationDocsPluginClick(AssociatedAppUrlPlugin r0, String r1) {
        r0.reportCcmApplicationDocsPluginClick(r1);
    }

    public final void reportCcmDocContentPageClick(String r3, String r4) {
        HashMap r0 = new HashMap(2);
        r0.put("click", r3);
        r0.put("target", "none");
        r0.put("url_id", r4);
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L8;
        String r6 = r5.getUrl();
        if (r6 == null) goto L8;
        String r7 = f05.b.a(r6);
        if (r7 == null) goto L8;
    L9:
        r0.put("biz_type", r7);
        r0.put("op_app_id", "");
        g05.a r8 = this.associatedAnalytic;
        if (r8 == null) goto L13;
        Intrinsics.checkNotNullParameter(r0, "evenParams");
        r8.a("ccm_doc_content_page_click", r0);
        return;
    L13:
        return;
    L8:
        r7 = "";
        goto L9
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_associateddocs_plugin_AssociatedAppUrlPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(AssociatedAppUrlListFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        AssociatedAppUrlListFragment r0 = r2;
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

    private final void disassociateExitingDoc(NetService r3, String r4, int r5, String r6) {
        ArrayList r0 = new ArrayList();
        r0.add(new Pair(r4, String.valueOf(r5)));
        com.bytedance.ee.bear.document.associateddocs.a r7 = this.associatedDocNetExecutor;
        d r8 = new d(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "netService");
        Intrinsics.checkNotNullParameter(r6, "appUrl");
        Intrinsics.checkNotNullParameter(r0, "docs");
        Intrinsics.checkNotNullParameter(r8, "callback");
        r3.Vc(new com.bytedance.ee.bear.document.associateddocs.a.f()).a(com.bytedance.ee.bear.document.associateddocs.a.a(r6, r0, "/space/api/references/delete/")).observeOn(fo5.d.a()).subscribeOn(fo5.d.d()).subscribe(new h(r8), new com.bytedance.ee.bear.document.associateddocs.i(r8));
    }
}
