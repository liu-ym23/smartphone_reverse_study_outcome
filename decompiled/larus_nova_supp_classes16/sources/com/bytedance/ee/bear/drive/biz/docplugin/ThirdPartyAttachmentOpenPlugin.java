package com.bytedance.ee.bear.drive.biz.docplugin;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.drive.module.nativepreview.DriveSameRenderLifecyclePlugin;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.util.ui.h;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.ArrayList;
import java.util.Map;
import jg5.e;
import pw4.g;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ThirdPartyAttachmentOpenPlugin extends DocumentPluginV2 implements g {
    private static final String BIZ_UTIL_ATTACH_FILE_CLICK = "biz.util.attachFileClick";
    private static final String BIZ_UTIL_EXIT_ATTACH_FILE = "biz.util.exitAttachFile";
    private static final String BIZ_UTIL_ON_EXIT_ATTACH_FILE = "biz.util.onAttachFileExit";
    private static final String FILE_TOKEN = "file_token";
    private static final String FORM_MODULE = "from_module";
    private static final String TAG = "ThirdPartyAttachmentOpenPlugin";
    private com.bytedance.ee.bear.drive.biz.docplugin.c mAttachmentFollowManager;
    private String mLastOpenEntityKey;
    private m mOnAttachFileExitCallback;
    private boolean mSyncedBlockEnable;

    public class a extends com.bytedance.ee.bear.drive.biz.docplugin.d {
        public final /* synthetic */ ThirdPartyAttachmentOpenPlugin a;

        public a(ThirdPartyAttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.biz.docplugin.d
        public final void b(com.bytedance.ee.bear.drive.biz.docplugin.d.a r3) {
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "DriveMainFragment onCallback, result = " + r3.toString());
            ThirdPartyAttachmentOpenPlugin.access$502(this.a, "");
            if (r3.a != 100) goto L6;
            BaseOpenEntity r4 = r3.b;
            ThirdPartyAttachmentOpenPlugin.access$600(this.a);
            ThirdPartyAttachmentOpenPlugin.access$700(this.a, r4);
            return;
        }
    }

    public class b implements i<AttachmentFileModel> {
        public final boolean a;
        public final /* synthetic */ ThirdPartyAttachmentOpenPlugin b;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(ThirdPartyAttachmentOpenPlugin r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, m r11) {
            AttachmentFileModel r12 = (AttachmentFileModel) r10;
            if (r12 != null) goto L5;
            tt5.a.d(ThirdPartyAttachmentOpenPlugin.TAG, "AttachFileClickHandler()... data must not be null");
            return;
        L5:
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "AttachFileClickHandler()... enableFollow = " + this.a + ", Open attachment:" + r12);
            if ("bitable_attach".equalsIgnoreCase(r12.getBussinessId()) == false) goto L8;
            String r0 = "26";
        L9:
            SpaceThirdPartyOpenEntity r1 = new SpaceThirdPartyOpenEntity(r0, r12.getFileToken(), r12.getFileName());
            if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L12;
            r1.setBizScene(DriveBizScene.DriveBizScene_CCM);
            r1.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_ATTACHMENT_DOWNLOAD);
        L12:
            r1.setApiExtra(r12.getExtra());
            r1.setMountPoint(r12.getMountPoint());
            r1.setMountNodeToken(r12.getMountNodeToken());
            String r2 = r12.getMountNodeToken();
            int r3 = this.b.getDocumentMetadata().getDocumentTypeValue();
            if (TextUtils.isEmpty(r12.getSrcObjToken()) == true) goto L15;
            r2 = r12.getSrcObjToken();
            r3 = r12.getSrcObjType();
        L15:
            r1.setDocToken(r2);
            r1.setHostType(r3);
            r1.setPreviewFrom(r12.getBussinessId());
            r1.setBusinessId(r12.getBussinessId());
            r1.setDownloadFrom("from_docs_attachment_preview_download");
            r1.setInVc(ThirdPartyAttachmentOpenPlugin.access$200(this.b));
            if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L18;
            r1.setUseLarkPreview(true);
        L18:
            ArrayList<BaseMoreMenuAction> r4 = new ArrayList();
            HostDocumentInfo r5 = ThirdPartyAttachmentOpenPlugin.access$300(this.b);     // Catch: Exception -> L26
            if (r5 != null) goto L22;
        L24:
            r1.setHostDocumentInfo(r5);     // Catch: Exception -> L26
        L27:
            SaveToLocalMenuV2 r6 = new SaveToLocalMenuV2();
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            if (e.a.a.g() == false) goto L30;
            boolean r7 = s55.a.a.g(r1.getMountPoint(), r1.getFileId(), "", "").getAllow();
        L31:
            r6.i = r7;
            r4.add(r6);
            r1.setMoreMenuActions(r4);
            if (ThirdPartyAttachmentOpenPlugin.access$400(this.b) == true) goto L34;
        L38:
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "setEncryptId old logic");
            vz4.d r13 = (vz4.d) this.b.getHostAbilityOrNull(vz4.d.class);
            if (r13 == null) goto L42;
            r1.setEncryptId(r13.getDocEncryptId());
        L42:
            if (this.a == false) goto L44;
            this.b.openAttachmentFragmentUnderFollow(r1, true);
            return;
        L44:
            if (h.a(800) == true) goto L54;
            tt5.a.k(ThirdPartyAttachmentOpenPlugin.TAG, "is not ValidClick");
            return;
        L54:
            ((com.bytedance.ee.bear.i) org.koin.java.a.a(com.bytedance.ee.bear.i.class)).c(((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity(), r1);     // Catch: Exception -> L48
            return;
        L48:
            e = move-exception;
            tt5.a.f(ThirdPartyAttachmentOpenPlugin.TAG, e, false);
            return;
        L34:
            if (TextUtils.isEmpty(r12.getSrcObjToken()) == true) goto L38;
            if (TextUtils.isEmpty(r12.getEncryptId()) == true) goto L38;
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "setEncryptId synced block new logic");
            r1.setInBlock(true);
            r1.setEncryptId(r12.getEncryptId());
            goto L42
        L30:
            r7 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g(pw4.b.c(r1.getMountPoint()), pw4.b.d(r1.getMountPoint()), sbb.e.l.b, r1.getFileId()).a;
            goto L31
        L22:
            if (r5.getType().intValue() != 44) goto L24;
            r5.setType(Integer.valueOf(this.b.getDocumentMetadata().getDocumentTypeValue()));     // Catch: Exception -> L26
            r5.setObjToken(this.b.getDocumentMetadata().getToken());     // Catch: Exception -> L26
        L26:
            tt5.a.d(ThirdPartyAttachmentOpenPlugin.TAG, "AttachFileClickHandler get DocumentInfo error");
            goto L27
        L8:
            r0 = "44";
            goto L9
        }
    }

    public class c implements i<String> {
        public final /* synthetic */ ThirdPartyAttachmentOpenPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(ThirdPartyAttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "ExitAttachFileHandler()...");
            ThirdPartyAttachmentOpenPlugin.access$600(this.a);
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ ThirdPartyAttachmentOpenPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(ThirdPartyAttachmentOpenPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            tt5.a.h(ThirdPartyAttachmentOpenPlugin.TAG, "OnAttachFileExitHandler()...");
            ThirdPartyAttachmentOpenPlugin.access$802(this.a, r3);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void exitAttachFileFragmentIfNeed() {
        this.mLastOpenEntityKey = "";
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L9;
        DriveSameRenderLifecyclePlugin r0 = (DriveSameRenderLifecyclePlugin) findPlugin(DriveSameRenderLifecyclePlugin.class);
        if (r0 == null) goto L9;
        if (r0.exitAttachFileFragmentIfNeed() == false) goto L9;
        tt5.a.b(TAG, "exitAttachFileFragmentIfNeed close file block success");
    L9:
        t r1 = getUIContainer();
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.l(this) == null) goto L16;
        r1.d(this);
        return;
    }

    public ThirdPartyAttachmentOpenPlugin() {
        this.mSyncedBlockEnable = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docs.all.synced_block_enable");
    }

    private HostDocumentInfo getHostDocumentInfo() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "getHostDocumentInfo: DocViewModel is null");
        return null;
    L6:
        w05.i r1 = r0.getDocumentInfoProvider();
        if (r1 != null) goto L11;
        tt5.a.d(TAG, "getHostDocumentInfo: DocumentInfoProvider is null");
        return null;
    L11:
        if (r1.g() != null) goto L14;
        tt5.a.d(TAG, "getHostDocumentInfo: DocumentInfoDta is null");
        return null;
    L14:
        DocumentInfo r2 = (DocumentInfo) r1.g().getValue();
        if (r2 != null) goto L17;
        return null;
    L17:
        return r2.convertToHostDocumentInfo();
    }

    private boolean isInVC() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L7;
        return false;
    L7:
        return DocsOpenSource.vc.equals(r0.getOpenSource());
    }

    public static /* synthetic */ boolean access$200(ThirdPartyAttachmentOpenPlugin r0) {
        return r0.isInVC();
    }

    public static /* synthetic */ HostDocumentInfo access$300(ThirdPartyAttachmentOpenPlugin r0) {
        return r0.getHostDocumentInfo();
    }

    public static /* synthetic */ boolean access$400(ThirdPartyAttachmentOpenPlugin r0) {
        return r0.mSyncedBlockEnable;
    }

    public static /* synthetic */ void access$600(ThirdPartyAttachmentOpenPlugin r0) {
        r0.exitAttachFileFragmentIfNeed();
    }

    private String generateEntityKey(SpaceThirdPartyOpenEntity r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        return r3.getMountNodeToken() + OfflineDoc.DASH_DELIMITER + r3.getFileId();
    }

    private void notifyJsAttachFileExited(BaseOpenEntity r4) {
        String r0 = "";
        if (r4 == null) goto L5;
        String r1 = r4.getFileId();
    L6:
        if (r4 == null) goto L8;
        r0 = r4.getFromModule();
    L8:
        JSONObject r5 = new JSONObject();
        r5.put(FILE_TOKEN, r1);
        r5.put(FORM_MODULE, r0);
        if (((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("ccm.drive.mobile.enable_thirdparty_exit_info") == true) goto L12;
        r5 = new JSONObject();
    L12:
        m r2 = this.mOnAttachFileExitCallback;
        if (r2 == null) goto L15;
        r2.b(r5);
        tt5.a.h(TAG, "execute mOnAttachFileExitCallback#onCallback");
        return;
    L15:
        dispatchBridgeMsg("window.lark.biz.util.onAttachFileExit", r5);
        tt5.a.h(TAG, "call js onAttachFileExit");
        return;
    L5:
        r1 = "";
        goto L6
    }

    @Override // pw4.g
    public void closeAttachFile(SpaceThirdPartyOpenEntity r2) {
        this.mLastOpenEntityKey = "";
        notifyJsAttachFileExited(r2);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r0 = true;
    L6:
        r3.put(BIZ_UTIL_ATTACH_FILE_CLICK, new b(this, r0));
        r3.put(BIZ_UTIL_EXIT_ATTACH_FILE, new c(this));
        r3.put(BIZ_UTIL_ON_EXIT_ATTACH_FILE, new d(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r1) {
        super.onAttachToHost(r1);
        r1.registerHostAbility(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        r1.unregisterHostAbility(this);
        com.bytedance.ee.bear.drive.biz.docplugin.c r2 = this.mAttachmentFollowManager;
        if (r2 == null) goto L6;
        r2.d();
        return;
    }

    public static /* synthetic */ String access$502(ThirdPartyAttachmentOpenPlugin r0, String r1) {
        r0.mLastOpenEntityKey = r1;
        return r1;
    }

    public static /* synthetic */ void access$700(ThirdPartyAttachmentOpenPlugin r0, BaseOpenEntity r1) {
        r0.notifyJsAttachFileExited(r1);
    }

    public static /* synthetic */ m access$802(ThirdPartyAttachmentOpenPlugin r0, m r1) {
        r0.mOnAttachFileExitCallback = r1;
        return r1;
    }

    private void openAttachmentFragmentByAdd(ArrayList<SpaceThirdPartyOpenEntity> r5, int r6) {
        com.bytedance.ee.bear.drive.biz.docplugin.c r0 = new com.bytedance.ee.bear.drive.biz.docplugin.c(this, getActivity(), getLifecycleOwner(), new a(this));
        this.mAttachmentFollowManager = r0;
        UserContainerDriveMainFragment r7 = r0.b(r5, r6, null, null);
        s r8 = new s();
        r8.e = true;
        getUIContainer().e(this, r7, r8);
    }

    public void openAttachmentFragmentUnderFollow(SpaceThirdPartyOpenEntity r4, boolean r5) {
        String r0 = generateEntityKey(r4);
        if (TextUtils.equals(this.mLastOpenEntityKey, r0) == false) goto L6;
        tt5.a.h(TAG, "openAttachmentFragmentUnderFollow open same entity key");
        return;
    L6:
        this.mLastOpenEntityKey = r0;
        t r1 = getUIContainer();
        if (r1 == null) goto L12;
        if (r1.l(this) == null) goto L12;
        r1.d(this);
    L12:
        if (r5 == false) goto L18;
        DriveSameRenderLifecyclePlugin r6 = (DriveSameRenderLifecyclePlugin) findPlugin(DriveSameRenderLifecyclePlugin.class);
        if (r6 == null) goto L18;
        if (r6.openBlockFileAndFullScreen(r4) == false) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        tt5.a.h(TAG, "openAttachmentFragmentUnderFollow open file block fail");
        ArrayList<SpaceThirdPartyOpenEntity> r8 = new ArrayList();
        r8.add(r4);
        openAttachmentFragmentByAdd(r8, 0);
        return;
    L22:
        return;
    L18:
        r7 = false;
        goto L19
    }

    @Override // pw4.g
    public void openAttachFile(SpaceThirdPartyOpenEntity r3, ArrayList<SpaceThirdPartyOpenEntity> r4, int r5) {
        if (r3 != null) goto L4;
    L6:
        openAttachmentFragmentByAdd(r4, r5);
        return;
    L4:
        if (r4.size() != 1) goto L6;
        openAttachmentFragmentUnderFollow(r3, false);
    }
}
