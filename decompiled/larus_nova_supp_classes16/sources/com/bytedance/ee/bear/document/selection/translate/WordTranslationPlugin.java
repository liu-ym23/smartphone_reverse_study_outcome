package com.bytedance.ee.bear.document.selection.translate;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.ai.translate.service.ITranslateService;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002)*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020\nJ\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/document/selection/translate/WordTranslationPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "panel", "Lcom/bytedance/ee/bear/document/selection/translate/WordTranslationPanel;", "syncToken", "", "translateDialogShowing", "", "antiScreenshotsDelegate", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/delegate/DialogAntiScreenshotsDelegate;", "feedbackAntiScreenshotsDelegate", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getCallback", "Lcom/ss/android/lark/ai/hypertranslate/TranslateCopyConfig$ActionModeCallback;", "permissionCheck", "handleUI", "cacAndDlpPermissionCheckNew", "cacAndDlpPermissionCheckOld", "shouldDisableLandscape", "getTranslateDialogEventListener", "Lcom/ss/android/lark/ai/hypertranslate/TranslateCopyConfig$DialogEventListener;", "processScreenOrientationChanged", "dismiss", "isPadOrUnfoldedDisplay", "getTranslateFeedbackDialogEventListener", "canCopy", "canCopyWithCheck", "isSingleDocProtect", "Companion", "WordTranslationHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WordTranslationPlugin extends DocumentPluginV2 implements p {
    public static final a Companion = null;
    private static final String TAG = "WordTranslationPlugin";
    private tv4.c antiScreenshotsDelegate;
    private tv4.c feedbackAntiScreenshotsDelegate;
    private com.bytedance.ee.bear.document.selection.translate.a panel;
    private String syncToken;
    private boolean translateDialogShowing;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<TranslationData> {
        public final /* synthetic */ WordTranslationPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(WordTranslationPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            TranslationData r12 = (TranslationData) r10;
            tt5.a.h(WordTranslationPlugin.TAG, "WordTranslationHandler data: " + r12);
            if (r12 == null) goto L14;
            WordTranslationPlugin r13 = this.a;
            String r1 = r12.getToken();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            WordTranslationPlugin.access$setSyncToken$p(r13, r1);
            ITranslateService r2 = (ITranslateService) ApiUtils.getApi(ITranslateService.class);
            boolean r3 = r13.canCopyWithCheck();
            WordTranslationPlugin.access$isPadOrUnfoldedDisplay(r13);
            oua.b r8 = new oua.b(r3, r13.isSingleDocProtect(), r13.getCallback(), r13.getTranslateDialogEventListener(), r13.getTranslateFeedbackDialogEventListener());
            if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).s() == false) goto L10;
            ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).t(WordTranslationPlugin$WordTranslationHandler$handle$1$1.INSTANCE);
        L10:
            tt5.a.h(WordTranslationPlugin.TAG, "WordTranslationHandler copyConfig: " + r8);
            if (r2 == null) goto L15;
            r2.showHyperTranslateDialog(WordTranslationPlugin.access$getActivity(r13), r12.getOriginText(), ITranslateService.HyperTranslateScene.DOC_FEED, r8);
            return;
        L15:
            return;
        }
    }

    public static final class c implements oua.b.a {
        public c(WordTranslationPlugin r2) {
            DocViewModel r0 = WordTranslationPlugin.access$getDocViewModel(r2);
            if (r0 == null) goto L10;
            DocumentInfo r1 = r0.getDocumentInfoData();
            if (r1 == null) goto L11;
            BlockInfo r3 = r1.getBlockInfo(WordTranslationPlugin.access$getSyncToken$p(r2));
            if (r3 == null) goto L12;
            r3.getEncryptId();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d implements oua.b.b {
        public d() {
        }
    }

    public static final class e implements oua.b.b {
        public e() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean canCopyWithCheck() {
        return permissionCheck(false);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public final oua.b.a getCallback() {
        return new c(this);
    }

    public final oua.b.b getTranslateDialogEventListener() {
        return new d();
    }

    public final oua.b.b getTranslateFeedbackDialogEventListener() {
        return new e();
    }

    public WordTranslationPlugin() {
        this.syncToken = "";
    }

    private final boolean isPadOrUnfoldedDisplay() {
        if (ku5.c.k(getActivity()) == false) goto L5;
    L10:
        return true;
    L5:
        if (com.ss.android.lark.base.embedded.b.g() == true) goto L7;
    L9:
        return false;
    L7:
        if (com.ss.android.lark.base.embedded.b.b(getActivity()) == false) goto L9;
        goto L9
    }

    public final boolean canCopy() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.canCopy() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSingleDocProtect() {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L9;
        DocumentInfo r1 = r0.getDocumentInfoData();
        if (r1 == null) goto L9;
        BlockInfo r2 = r1.getBlockInfo(this.syncToken);
        if (r2 == null) goto L9;
        String r3 = r2.getEncryptId();
    L11:
        return !TextUtils.isEmpty(r3);
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return this.translateDialogShowing;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(WordTranslationPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ tv4.c access$getAntiScreenshotsDelegate$p(WordTranslationPlugin r0) {
        r0.getClass();
        return null;
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(WordTranslationPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ tv4.c access$getFeedbackAntiScreenshotsDelegate$p(WordTranslationPlugin r0) {
        r0.getClass();
        return null;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.document.selection.translate.a access$getPanel$p(WordTranslationPlugin r0) {
        return r0.panel;
    }

    public static final /* synthetic */ String access$getSyncToken$p(WordTranslationPlugin r0) {
        return r0.syncToken;
    }

    public static final /* synthetic */ boolean access$isPadOrUnfoldedDisplay(WordTranslationPlugin r0) {
        return r0.isPadOrUnfoldedDisplay();
    }

    private final boolean cacAndDlpPermissionCheckNew(boolean r11) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L35;
        DocumentInfo r2 = r0.getDocumentInfoData();
        if (r2 == null) goto L7;
        IDocUserPermission r3 = r2.getDocPermissionByToken(this.syncToken);
    L8:
        int r4 = f35.b.a;
        String r5 = this.syncToken;
        sbb.e r6 = sbb.e.e(r0.getDocumentType());
        DocumentInfo r7 = r0.getDocumentInfoData();
        if (r7 == null) goto L12;
        String r8 = r7.getCreatorTenantId();
        if (r8 == null) goto L12;
    L13:
        BizDomain r9 = BizDomain.FileBizDomainCCM;
        DocumentInfo r1 = r0.getDocumentInfoData();
        if (r1 == null) goto L16;
        String r10 = r1.getOwnerUid();
    L17:
        PermissionResponse r12 = f35.b.d(r5, r6, r8, r9, r3, r10);
        if (r11 == false) goto L22;
        r12.getCallback().a(getContext(), r12);
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r12) == false) goto L22;
        return false;
    L22:
        if (r3 == null) goto L24;
        boolean r13 = r3.canCopy();
    L25:
        if (r13 == true) goto L34;
        if (isSingleDocProtect() == false) goto L30;
        return true;
    L30:
        if (r11 == false) goto L32;
        UDToast.show(getContext(), getContext().getResources().getString(2131889333));
    L32:
        return false;
    L34:
        return r12.getAllow();
    L24:
        r13 = false;
        goto L25
    L16:
        r10 = null;
    L12:
        r8 = "";
        goto L13
    L7:
        r3 = null;
        goto L8
    L35:
        return false;
    }

    private final boolean cacAndDlpPermissionCheckOld(boolean r9) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L5;
        int r3 = r0.getDocumentTypeValue();
    L6:
        gj5.b r1 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r4 = FileBizDomain.FileBizDomainCCM;
        gj5.c r2 = r1.g("CCM_CONTENT_COPY", r4, r3, this.syncToken);
        if (r2.a == true) goto L17;
        if (r9 == false) goto L16;
        FileAuthResultFrom r10 = r2.b;
        if (r10 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L13;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CONTENT_COPY", r4, r3, this.syncToken);
        goto L16
    L13:
        if (r10 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L15;
        Toast.showFailureText(getActivity(), 2131887246);
        goto L16
    L15:
        tt5.a.d(TAG, "CellViewHolder not allow copy/cut from unknown source");
    L16:
        return false;
    L17:
        DocViewModel r5 = getDocViewModel();
        if (r5 == null) goto L24;
        DocumentInfo r6 = r5.getDocumentInfoData();
        if (r6 == null) goto L24;
        BlockInfo r7 = r6.getBlockInfo(this.syncToken);
        if (r7 == null) goto L24;
        String r8 = r7.getCreatorTenantId();
    L25:
        String r11 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).a(this.syncToken, r3, "CCM_CONTENT_COPY", "", r8);
        if (TextUtils.isEmpty(r11) == true) goto L30;
        if (r9 == false) goto L29;
        Toast.showFailureText(getActivity(), r11);
    L29:
        return false;
    L30:
        DocViewModel r12 = getDocViewModel();
        if (r12 == null) goto L37;
        DocumentInfo r13 = r12.getDocumentInfoData();
        if (r13 == null) goto L37;
        IDocUserPermission r14 = r13.getDocPermissionByToken(this.syncToken);
        if (r14 == null) goto L37;
        boolean r16 = r14.canCopy();
    L39:
        if (r16 == false) goto L41;
        return true;
    L41:
        if (isSingleDocProtect() == false) goto L43;
        return true;
    L43:
        if (r9 == false) goto L45;
        UDToast.show(getContext(), getContext().getResources().getString(2131889333));
    L45:
        return false;
    L37:
        r16 = false;
    L24:
        r8 = null;
        goto L25
    L5:
        r3 = -1;
        goto L6
    }

    private final boolean permissionCheck(boolean r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L8;
        if (cacAndDlpPermissionCheckNew(r4) == true) goto L10;
        return false;
    L10:
        return true;
    L8:
        if (cacAndDlpPermissionCheckOld(r4) == true) goto L12;
        return false;
    L12:
        return true;
    }

    private final void processScreenOrientationChanged(boolean r2) {
        if (isPadOrUnfoldedDisplay() == false) goto L5;
        return;
    L5:
        if (r2 == false) goto L9;
        BaseUnspecifiedOrientationPlugin r3 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r3 == null) goto L13;
        r3.onOrientationSupportPanelDismiss(this);
        return;
    L13:
        return;
    L9:
        BaseUnspecifiedOrientationPlugin r4 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r4 == null) goto L15;
        r4.onOrientationSupportPanelShowing(this);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.selection.triggerTranslate", new b(this));
    }

    public static final /* synthetic */ boolean access$permissionCheck(WordTranslationPlugin r0, boolean r1) {
        return r0.permissionCheck(r1);
    }

    public static final /* synthetic */ void access$processScreenOrientationChanged(WordTranslationPlugin r0, boolean r1) {
        r0.processScreenOrientationChanged(r1);
    }

    public static final /* synthetic */ void access$setAntiScreenshotsDelegate$p(WordTranslationPlugin r0, tv4.c r1) {
        r0.getClass();
    }

    public static final /* synthetic */ void access$setFeedbackAntiScreenshotsDelegate$p(WordTranslationPlugin r0, tv4.c r1) {
        r0.getClass();
    }

    public static final /* synthetic */ void access$setSyncToken$p(WordTranslationPlugin r0, String r1) {
        r0.syncToken = r1;
    }

    public static final /* synthetic */ void access$setTranslateDialogShowing$p(WordTranslationPlugin r0, boolean r1) {
        r0.translateDialogShowing = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        DocViewModel r4 = getDocViewModel();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getOpenSource() != DocsOpenSource.vc) goto L16;
        com.bytedance.ee.bear.document.selection.translate.a r5 = new com.bytedance.ee.bear.document.selection.translate.a();
        this.panel = r5;
        if ((r2 instanceof DocumentPluginHost) == false) goto L9;
        DocumentPluginHost r6 = (DocumentPluginHost) r2;
    L10:
        if (r6 == null) goto L17;
        EditPanelsManager r0 = r6.b();
        if (r0 == null) goto L18;
        r0.registerEditPanel(r6.getLifecycleOwner(), r5);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        com.bytedance.ee.bear.document.selection.translate.a r4 = this.panel;
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof DocumentPluginHost) == false) goto L7;
        DocumentPluginHost r5 = (DocumentPluginHost) r2;
    L8:
        if (r5 == null) goto L14;
        EditPanelsManager r0 = r5.b();
        if (r0 == null) goto L15;
        r0.registerEditPanel(r5.getLifecycleOwner(), r4);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
