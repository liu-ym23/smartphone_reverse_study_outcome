package com.bytedance.ee.bear.bitable.pro.applypro;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.pro.BitableProPlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.bitable.BitableProMoreItem;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.document.plugin.permapply.OfficePermApplyPlugin;
import com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.templates.g;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import javax.annotation.Nullable;
import jg5.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/OfficeBitablePermissionPlugin;", "Lcom/bytedance/ee/bear/document/plugin/permission/OfficePermissionPluginBase;", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlePermissionData", "data", "reloadAfterPasswordVerified", "removeOfficePermissionView", "hideLoading", "showBitablePro", "Lcom/bytedance/ee/bear/bitable/pro/applypro/OfficeBitablePermissionPlugin$BitableProData;", "documentInfo", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "canManagePermissionMeta", "", "matchesPerceiveControl", "showBitableApplyPro", "ShowBitableProHandler", "BitableProData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBitablePermissionPlugin extends OfficePermissionPluginBase<BitablePermissionData> {
    public static final a Companion = null;
    private static final String SHOW_BITABLE_PRO = "biz.util.showProModal";
    private static final String TAG = "OfficeBitablePermissionPlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/OfficeBitablePermissionPlugin$BitableProData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "proInfo", "Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;", "getProInfo", "()Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;", "setProInfo", "(Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;)V", "openDefaultRole", "", "getOpenDefaultRole", "()Ljava/lang/Boolean;", "setOpenDefaultRole", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BitableProData implements NonProguard {
        private Boolean openDefaultRole;
        private MoreModel.Bitable proInfo;

        public BitableProData() {
        }

        public final Boolean getOpenDefaultRole() {
            return this.openDefaultRole;
        }

        public final MoreModel.Bitable getProInfo() {
            return this.proInfo;
        }

        public final void setOpenDefaultRole(Boolean r1) {
            this.openDefaultRole = r1;
        }

        public final void setProInfo(MoreModel.Bitable r1) {
            this.proInfo = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<BitableProData> {
        public final /* synthetic */ OfficeBitablePermissionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeBitablePermissionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            final BitableProData r6 = (BitableProData) r4;
            Intrinsics.checkNotNullParameter(r5, "callback");
            if (r6 == null) goto L14;
            DocViewModel r7 = this.a.getDocViewModel();
            if (r7 == null) goto L8;
            DocumentInfo r8 = r7.getDocumentInfoData();
        L9:
            if (r8 == null) goto L11;
            OfficeBitablePermissionPlugin.access$showBitablePro(this.a, r6, r8);
            return;
        L11:
            final MutableLiveData<DocumentInfo> r9 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider().g();
            LifecycleOwner r0 = OfficeBitablePermissionPlugin.access$getLifecycleOwner(this.a);
            final OfficeBitablePermissionPlugin r2 = this.a;
            r9.observe(r0, new OfficeBitablePermissionPlugin$ShowBitableProHandler$handle$1(r9, r2, r6));
            return;
        L8:
            r8 = null;
            goto L9
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BitablePermissionHandling.values().length];
            r0[BitablePermissionHandling.SHOW_ADVANCED_PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[BitablePermissionHandling.SHOW_COMMON_NO_PERMISSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[BitablePermissionHandling.SHOW_PASSWORD_PERMISSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[BitablePermissionHandling.DELEGATE_COMMON_PRESERVING_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ OfficeBitablePermissionPlugin a;

        public d(OfficeBitablePermissionPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeBitablePermissionPlugin.access$reloadAfterPasswordVerified(this.a);     // Catch: Throwable -> L4
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
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeOfficePermissionView() {
        OfficePermApplyPlugin r0 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r0 == null) goto L6;
        r0.removeAllPermissionView();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void hideLoading() {
        e4 r0 = (e4) getHost().getHostAbilityOrNull(e4.class);
        DocumentLoaderV3 r1 = null;
        if (r0 == null) goto L5;
        x2 r2 = r0.getDocumentLoader();
    L7:
        if ((r2 instanceof DocumentLoaderV3) == false) goto L9;
        r1 = (DocumentLoaderV3) r2;
    L9:
        com.bytedance.ee.bear.document.container.a r3 = (com.bytedance.ee.bear.document.container.a) getHost().getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r1 == null) goto L12;
        r1.k();
    L12:
        if (r3 == null) goto L15;
        r3.hideLoading();
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void reloadAfterPasswordVerified() {
        if (isUIContainerAttached() == true) goto L6;
        tt5.a.k(TAG, "reloadAfterPasswordVerified: UI container detached");
        return;
    L6:
        removeOfficePermissionView();
        reloadDocumentFragment(getDocumentMetadata().getOriginUrl(), MapsKt.mapOf(TuplesKt.to("extra_reopen_from_permission_change", "true")));
    }

    public OfficeBitablePermissionPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(OfficeBitablePermissionPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ void access$reloadAfterPasswordVerified(OfficeBitablePermissionPlugin r0) {
        r0.reloadAfterPasswordVerified();
    }

    private final boolean canManagePermissionMeta(DocumentInfo r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L6;
        return com.bytedance.ee.bear.bitable.utils.a.a(r4, "MANAGE_PERMISSION_META");
    L6:
        return r4.getDocPermission().a.canManagePermissionMeta();
    }

    private final boolean matchesPerceiveControl(DocumentInfo r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L6;
        return com.bytedance.ee.bear.bitable.utils.a.a(r4, "PERCEIVE_CONTROL");
    L6:
        return r4.getDocPermission().a.matchPerceiveControl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showBitableApplyPro(BitablePermissionData r6) {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        String r2 = "";
        if (r6.getOwner() == null) goto L9;
        String r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r6.getOwner().getDisplay_name(), r6.getOwner().getName(), r6.getOwner().getEn_name());
        String r7 = r6.getOwner().getId();
    L23:
        OfficePermApplyPlugin r1 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r1 == null) goto L32;
        if (r0 != null) goto L27;
        r0 = "";
    L27:
        if (r7 == null) goto L30;
        r2 = r7;
    L30:
        r1.showBitableProPermission(r0, r2);
        return;
    L32:
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.advanced_permission.apply_owner_info") == false) goto L17;
        BitablePermissionData.BitableProInfoData r8 = r6.getBitableProInfo();
        if (r8 == null) goto L22;
        BitablePermissionData.Extra r9 = r8.getExtra();
        if (r9 == null) goto L22;
        BitablePermissionData.OwnerInfo r10 = r9.getOwnerInfo();
        if (r10 == null) goto L22;
        r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r10.getI18nName(), r10.getName(), r10.getEnName());
        r7 = r10.getUserID();
    L22:
        r7 = "";
        r0 = r7;
        goto L23
    L17:
        BitablePermissionData.BitableProInfoData r11 = r6.getBitableProInfo();
        if (r11 == null) goto L22;
        BitablePermissionData.Owner r12 = r11.getOwner();
        if (r12 == null) goto L22;
        r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r12.getDisplayName(), r12.getName(), r12.getEnName());
        r7 = r12.getId();
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(SHOW_BITABLE_PRO, new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handlePermissionData(BitablePermissionData r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        OfficePermApplyPlugin r0 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r0 == null) goto L5;
        r0.setImmersiveMode(true);
    L5:
        BitablePermissionData.BitableProInfoData r1 = r9.getBitableProInfo();
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r9.getCode() != 4) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r4 == true) goto L22;
    L24:
        boolean r6 = false;
    L25:
        if (r5 == true) goto L27;
    L29:
        if (r6 == false) goto L31;
        BitablePermissionHandling r7 = BitablePermissionHandling.SHOW_PASSWORD_PERMISSION;
    L38:
        tt5.a.h(TAG, "handlePermissionData: code=" + r9.getCode() + ", status=" + r9.getPermissionStatusCode() + ", needApplyPro=" + r3 + ", handling=" + r7);
        int r8 = c.a[r7.ordinal()];
        if (r8 != 1) goto L41;
        if (r5 == false) goto L59;
        updateDocumentInfo();
    L59:
        removeOfficePermissionView();
        showBitableApplyPro(r9);
        if (r4 == true) goto L66;
        hideLoading();
        return;
    L66:
        return;
    L41:
        if (r8 != 2) goto L43;
        removeOfficePermissionView();
        super.handlePermissionData(r9);
        return;
    L43:
        if (r8 == 3) goto L48;
        if (r8 != 4) goto L47;
        super.handlePermissionData(r9);
        return;
    L47:
        throw new NoWhenBranchMatchedException();
    L48:
        updateDocumentInfo();
        updateState(2);
        OfficePermApplyPlugin r10 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r10 != null) goto L52;
        return;
    L52:
        if (r10.isPasswordPermissionShow() == false) goto L55;
        tt5.a.h(TAG, "handlePermissionData: native password page already shown");
        return;
    L55:
        removeOfficePermissionView();
        r10.showPasswordPermission(new d(this));
        return;
    L31:
        if (r3 == false) goto L35;
        if (r5 == false) goto L34;
        if (r2 == true) goto L35;
    L34:
        r7 = BitablePermissionHandling.SHOW_ADVANCED_PERMISSION;
    L35:
        if (r5 == false) goto L37;
        r7 = BitablePermissionHandling.SHOW_COMMON_NO_PERMISSION;
        goto L38
    L37:
        r7 = BitablePermissionHandling.DELEGATE_COMMON_PRESERVING_PAGE;
        goto L38
    L27:
        if (r9.disableApplyPerm() == false) goto L29;
        r2 = true;
        goto L29
    L22:
        if (r9.getPermissionStatusCode() != 10016) goto L24;
        r6 = true;
        goto L25
    L17:
        if (r9.getPermissionStatusCode() != 0) goto L19;
        r5 = true;
        goto L20
    L14:
        r4 = false;
        goto L15
    L8:
        if (r1.needApplyPro() != true) goto L10;
        r3 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficePermissionPluginBase, com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public /* bridge */ /* synthetic */ void handlePermissionData(PermissionData r1) {
        handlePermissionData((BitablePermissionData) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showBitablePro(BitableProData r13, DocumentInfo r14) {
        MoreModel.Bitable r0 = r13.getProInfo();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "bitable proInfo is null");
        return;
    L6:
        DocViewModel r1 = getDocViewModel();
        if (r1 != null) goto L9;
        return;
    L9:
        BitableProMoreItem.a r2 = BitableProMoreItem.Companion;
        int r3 = r14.getDocMetaInfo().getTemplate_type();
        r2.getClass();
        boolean r4 = g.a(r3);
        boolean r5 = r14.isOwner();
        boolean r11 = canManagePermissionMeta(r14);
        if (BitableProMoreItem.a.a(r4, matchesPerceiveControl(r14), r0.isPro(), r5, r11, r1.isType(sbb.e.n), r1.isDocumentType(sbb.e.i)) == true) goto L12;
        return;
    L12:
        BitableProPlugin r6 = (BitableProPlugin) findPlugin(BitableProPlugin.class);
        if (r6 == null) goto L20;
        String r7 = r14.getObjToken();
        String r8 = r14.getOwnerUid();
        Boolean r16 = r13.getOpenDefaultRole();
        if (r16 == null) goto L17;
        boolean r9 = r16.booleanValue();
    L18:
        r6.showBitableProFragment(r7, r8, r9, new com.bytedance.ee.bear.document.bitable.c(r4, r0.isPro(), r14.getCreatorTenantId()), r0.getTables(), r0.getBlocks());
        return;
    L17:
        r9 = false;
        goto L18
    }

    public static final /* synthetic */ void access$showBitablePro(OfficeBitablePermissionPlugin r0, BitableProData r1, DocumentInfo r2) {
        r0.showBitablePro(r1, r2);
    }
}
