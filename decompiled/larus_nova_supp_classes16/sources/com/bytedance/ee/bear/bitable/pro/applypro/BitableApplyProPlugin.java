package com.bytedance.ee.bear.bitable.pro.applypro;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.BitableProPlugin;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.BasePermissionChangePlugin;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.bitable.BitableProMoreItem;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.more.MoreModel;
import com.bytedance.ee.bear.document.permapply.PermApplyPlugin;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.templates.g;
import com.bytedance.ee.util.io.NonProguard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import sbb.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProPlugin;", "Lcom/bytedance/ee/bear/document/BasePermissionChangePlugin;", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitablePermissionData;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlePermissionData", "data", "removeAllPermissionView", "permApplyPlugin", "Lcom/bytedance/ee/bear/document/permapply/PermApplyPlugin;", "reloadAndRemoveAllPermissionView", "reloadDocumentFragment", "isFa", "", "documentInfo", "Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "isMatchPerceive", "showBitablePro", "bitableInfoData", "Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProPlugin$BitableProData;", "showBitableApplyPro", "removeBitableApplyPro", "Companion", "ShowBitableProHandler", "BitableProData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableApplyProPlugin extends BasePermissionChangePlugin<BitablePermissionData> {
    public static final a Companion = null;
    private static final String SHOW_BITABLE_PRO = "biz.util.showProModal";
    private static final String TAG = "BitableApplyProPlugin";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/applypro/BitableApplyProPlugin$BitableProData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "proInfo", "Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;", "getProInfo", "()Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;", "setProInfo", "(Lcom/bytedance/ee/bear/document/more/MoreModel$Bitable;)V", "openDefaultRole", "", "getOpenDefaultRole", "()Ljava/lang/Boolean;", "setOpenDefaultRole", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ BitableApplyProPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BitableApplyProPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            final BitableProData r6 = (BitableProData) r4;
            Intrinsics.checkNotNullParameter(r5, "callback");
            if (r6 == null) goto L15;
            DocViewModel r7 = BitableApplyProPlugin.access$getDocViewModel(this.a);
            if (r7 != null) goto L7;
        L9:
            StringBuilder r0 = new StringBuilder("show bitable pro data docViewModel ");
            if (r7 != null) goto L12;
            boolean r8 = true;
        L13:
            r0.append(r8);
            tt5.a.h(BitableApplyProPlugin.TAG, r0.toString());
            final MutableLiveData<DocumentInfo> r9 = ((w05.b) this.a.getHostAbility(w05.b.class)).getDocumentInfoProvider().g();
            LifecycleOwner r1 = BitableApplyProPlugin.access$getLifecycleOwner(this.a);
            final BitableApplyProPlugin r2 = this.a;
            r9.observe(r1, new BitableApplyProPlugin$ShowBitableProHandler$handle$1(r9, r2, r6));
            return;
        L12:
            r8 = false;
            goto L13
        L7:
            if (r7.getDocumentInfoData() == null) goto L9;
            BitableApplyProPlugin.access$showBitablePro(this.a, r6, r7.getDocumentInfoData());
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void reloadDocumentFragment() {
        PluginHost r0 = getHost();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof DocumentPluginHost) == false) goto L49;
        DocumentPluginHost r1 = (DocumentPluginHost) r0;
        WebFragment r2 = r1.c();
        DocViewModel r3 = getDocViewModel();
        String r4 = null;
        if (r3 == null) goto L10;
        String r5 = r3.getOriginUrl();
    L12:
        if (r2 != null) goto L14;
    L43:
        tt5.a.k(TAG, "the documentFragment or its origin url is null");
        return;
    L14:
        if (TextUtils.isEmpty(r5) == true) goto L43;
        BearUrl r6 = p.a().Z(p.a().v8(r5));
        int r7 = c.a;
        int r8 = n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.wiki_permission_sync_fix_enable") == true) goto L19;
    L34:
        tt5.a.h(TAG, "reloadDocumentFragment() new baseUrl type instance");
        BaseFragment r9 = DocumentFragment.ka0(r5, r2.getArguments());
    L35:
        FragmentManager r10 = r2.getFragmentManager();
        if (r10 == null) goto L45;
        FragmentTransaction r11 = r10.beginTransaction();
        if (r11 == null) goto L46;
        FragmentTransaction r12 = INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_pro_applypro_BitableApplyProPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r11, r2.getId(), r9);
        if (r12 == null) goto L47;
        r12.commitAllowingStateLoss();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L19:
        if (fx4.a.g(r6) == false) goto L34;
        DocViewModel r13 = getDocViewModel();
        if (r13 == null) goto L23;
        String r14 = r13.getDocumentType();
    L25:
        if (TextUtils.equals(r14, e.i.getType()) == false) goto L34;
        DocViewModel r16 = getDocViewModel();
        if (r16 == null) goto L31;
        WikiInfo r17 = r16.getWikiInfo();
        if (r17 == null) goto L31;
        r4 = r17.getObjTypeString();
    L31:
        if (r4 != null) goto L33;
        r4 = r6.a;
    L33:
        tt5.a.h(TAG, "reloadDocumentFragment() type: " + r4);
        r9 = DocumentFragment.la0(r4, r5, r2.getArguments(), r1.getUserComponent().b());
        goto L35
    L23:
        r14 = null;
        goto L25
    L10:
        r5 = null;
        goto L12
    }

    private final void removeBitableApplyPro() {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if (getUIContainer().l(this) != null) goto L8;
        return;
    L8:
        getUIContainer().d(this);
    }

    public BitableApplyProPlugin() {
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(BitableApplyProPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(BitableApplyProPlugin r0) {
        return r0.getLifecycleOwner();
    }

    private final boolean isFa(DocumentInfo r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == true) goto L7;
        return r4.getDocPermission().a.canManagePermissionMeta();
    L7:
        return com.bytedance.ee.bear.bitable.utils.a.a(r4, "MANAGE_PERMISSION_META");
    }

    private final boolean isMatchPerceive(DocumentInfo r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == true) goto L7;
        return r4.getDocPermission().a.matchPerceiveControl();
    L7:
        return com.bytedance.ee.bear.bitable.utils.a.a(r4, "PERCEIVE_CONTROL");
    }

    private final void reloadAndRemoveAllPermissionView(PermApplyPlugin r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        r4.removeAllPermissionView();
        reloadDocumentFragment();
        return;
    L10:
        return;
    L5:
        if (r4.isPermissionShow() != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void removeAllPermissionView(PermApplyPlugin r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        r4.removeAllPermissionView();
        return;
    L10:
        return;
    L5:
        if (r4.isPermissionShow() != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void showBitableApplyPro(BitablePermissionData r5) {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if (r5.getOwner() == null) goto L9;
        String r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r5.getOwner().getDisplay_name(), r5.getOwner().getName(), r5.getOwner().getEn_name());
        String r6 = r5.getOwner().getId();
    L23:
        int r1 = BitableApplyProFragment.u;
        String r2 = getDocumentMetadata().getToken();
        Bundle r3 = new Bundle();
        r3.putString("owner_name", r0);
        r3.putString("owner_id", r6);
        r3.putString("token", r2);
        getUIContainer().i(this, instantiateFragment(BitableApplyProFragment.class, r3));
        return;
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.advanced_permission.apply_owner_info") == false) goto L17;
        BitablePermissionData.BitableProInfoData r7 = r5.getBitableProInfo();
        if (r7 == null) goto L22;
        BitablePermissionData.Extra r8 = r7.getExtra();
        if (r8 == null) goto L22;
        BitablePermissionData.OwnerInfo r9 = r8.getOwnerInfo();
        if (r9 == null) goto L22;
        r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r9.getI18nName(), r9.getName(), r9.getEnName());
        r6 = r9.getUserID();
    L22:
        r0 = "";
        r6 = "";
        goto L23
    L17:
        BitablePermissionData.BitableProInfoData r10 = r5.getBitableProInfo();
        if (r10 == null) goto L22;
        BitablePermissionData.Owner r11 = r10.getOwner();
        if (r11 == null) goto L22;
        r0 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r11.getDisplayName(), r11.getName(), r11.getEnName());
        r6 = r11.getId();
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(SHOW_BITABLE_PRO, new b(this));
    }

    public void handlePermissionData(BitablePermissionData r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        BitablePermissionData.BitableProInfoData r0 = r9.getBitableProInfo();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.needApplyPro();
    L6:
        PermApplyPlugin r3 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        int r4 = r9.getCode();
        int r5 = r9.getPermissionStatusCode();
        PermissionData.UserPermissionV2 r6 = r9.getUserPermissionsV2();
        if (r2 == true) goto L9;
    L10:
        r1 = true;
    L11:
        StringBuilder r7 = new StringBuilder("handlePermissionData: permissionCode=");
        r7.append(r4);
        r7.append(", permissionStatusCode=");
        r7.append(r5);
        r7.append(", noNeedApplyProOrDisable=");
        r7.append(r1);
        r7.append(", isPermissionShow=");
        if (r3 == null) goto L14;
        Boolean r8 = Boolean.valueOf(r3.isPermissionShow());
    L15:
        r7.append(r8);
        tt5.a.h(TAG, r7.toString());
        if (r4 != 4) goto L21;
        updateDocumentInfo();
        if (r5 != 0) goto L20;
        if (r1 == true) goto L21;
    L20:
        removeBitableApplyPro();
    L21:
        if (r4 != 4) goto L28;
        if (r5 != 0) goto L28;
        if (r1 == false) goto L26;
        if (r3 == null) goto L42;
        r3.showNoPermission(r9);
        return;
    L42:
        return;
    L26:
        removeAllPermissionView(r3);
        showBitableApplyPro(r9);
        return;
    L28:
        if (r4 == 4) goto L30;
    L33:
        if (r2 == false) goto L36;
        removeAllPermissionView(r3);
        showBitableApplyPro(r9);
        return;
    L36:
        if (r4 != 0) goto L44;
        if (r6 != null) goto L39;
        return;
    L39:
        if (r6.getCode() != 0) goto L46;
        reloadAndRemoveAllPermissionView(r3);
        removeBitableApplyPro();
        return;
    L46:
        return;
    L44:
        return;
    L30:
        if (r5 != 10016) goto L33;
        updateDocumentInfo();
        reloadAndRemoveAllPermissionView(r3);
        return;
    L14:
        r8 = null;
        goto L15
    L9:
        if (r9.disableApplyPerm() == false) goto L11;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin
    public /* bridge */ /* synthetic */ void handlePermissionData(PermissionData r1) {
        handlePermissionData((BitablePermissionData) r1);
    }

    private final void showBitablePro(BitableProData r14, DocumentInfo r16) {
        MoreModel.Bitable r0 = r14.getProInfo();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "bitable proInfo is null");
        return;
    L6:
        Boolean r17 = r14.getOpenDefaultRole();
        if (r17 == null) goto L9;
        boolean r4 = r17.booleanValue();
    L10:
        DocViewModel r18 = getDocViewModel();
        if (r18 != null) goto L13;
        return;
    L13:
        int r1 = r16.getDocMetaInfo().getTemplate_type();
        BitableProMoreItem.Companion.getClass();
        boolean r2 = g.a(r1);
        boolean r3 = r16.isOwner();
        boolean r5 = isFa(r16);
        boolean r6 = isMatchPerceive(r16);
        boolean r12 = r0.isPro();
        if (BitableProMoreItem.a.a(r2, r6, r12, r3, r5, r18.isType(e.n), r18.isDocumentType(e.i)) == false) goto L19;
        String r19 = r16.getObjToken();
        String r7 = r16.getOwnerUid();
        String r110 = r16.getCreatorTenantId();
        ArrayList<BlockSimpleInfo> r8 = r0.getTables();
        ArrayList<BlockSimpleInfo> r9 = r0.getBlocks();
        com.bytedance.ee.bear.document.bitable.c r10 = new com.bytedance.ee.bear.document.bitable.c(r2, r12, r110);
        BitableProPlugin r11 = (BitableProPlugin) findPlugin(BitableProPlugin.class);
        if (r11 == null) goto L20;
        r11.showBitableProFragment(r19, r7, r4, r10, r8, r9);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r4 = false;
        goto L10
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_bitable_pro_applypro_BitableApplyProPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }

    public static final /* synthetic */ void access$showBitablePro(BitableApplyProPlugin r0, BitableProData r1, DocumentInfo r2) {
        r0.showBitablePro(r1, r2);
    }
}
