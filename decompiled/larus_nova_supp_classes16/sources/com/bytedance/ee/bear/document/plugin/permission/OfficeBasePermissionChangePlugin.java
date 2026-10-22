package com.bytedance.ee.bear.document.plugin.permission;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.document.plugin.permapply.OfficePermApplyPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.drive.PerceivePermissionVM;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.o;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import jg5.j;
import kotlin.Unit;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class OfficeBasePermissionChangePlugin<T extends PermissionData> extends DocumentPluginV3 implements i<T>, o {
    private static final int DOC_DELETE_CODE = 1002;
    private static final String TAG = "BasePermissionChangePlugin";
    private static final long UPDATE_LIMIT_TIME = 600;
    private ConcurrentHashMap<String, com.ss.android.lark.security.compliance.api.model.filepolicy.c> dlpContext;
    private ConcurrentHashMap<String, a> dlpUpdateMap;
    private boolean isDlpMigrate;
    private long lastUpdateTime;
    private int mLastViewAuthReason;
    private UDDialog mLeaderAuthTipsDialog;
    private List<b> mPermissionChangeCallbacks;
    private final List<o.a> permissionChangeListeners;
    private ConcurrentHashMap<String, IDocUserPermission> referMap;

    public static class a {
        public Boolean a;
        public String b;
        public int c;

        public a() {
            this.a = Boolean.FALSE;
            this.b = "";
            this.c = -1;
        }
    }

    public interface b {
        void a();
    }

    public static /* synthetic */ void a(OfficeBasePermissionChangePlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void c(OfficeBasePermissionChangePlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ Unit d(OfficeBasePermissionChangePlugin r0) {
        return r0.lambda$handleDlpUpdate$2();
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public abstract void handlePermissionData(T r1);

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateDocumentInfo() {
        w05.i r0 = ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider();
        DocumentInfo r1 = (DocumentInfo) r0.g().getValue();
        if (r1 == null) goto L6;
        tt5.a.h(TAG, "canRead to can'tRead update perm to init type");
        r1.updateDocPermission(new DocPermission());
        r0.j().postValue(r1);
        return;
    }

    public OfficeBasePermissionChangePlugin() {
        this.lastUpdateTime = 0;
        this.mPermissionChangeCallbacks = new CopyOnWriteArrayList();
        this.permissionChangeListeners = new CopyOnWriteArrayList();
        this.referMap = new ConcurrentHashMap();
        this.dlpUpdateMap = new ConcurrentHashMap();
        this.dlpContext = new ConcurrentHashMap();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        this.isDlpMigrate = jg5.e.a.a.g();
    }

    private boolean isOfficeSDKAssembleEnabled() {
        return CCMOfficeSDKAssembleFG.a();
    }

    private /* synthetic */ Unit lambda$handleDlpUpdate$2() {
        notifyPermUpdate();
        return null;
    }

    private void notifyPermUpdate() {
        if (getDocViewModel() == null) goto L6;
        getDocViewModel().setPermissionUpdate(Boolean.TRUE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void tryUpdateDocumentInfoPerm() {
        if (isOfficeSDKAssembleEnabled() == true) goto L5;
        return;
    L5:
        w05.i r0 = ((w05.b) getHost().getHostAbility(w05.b.class)).getDocumentInfoProvider();
        DocumentInfo r1 = (DocumentInfo) r0.g().getValue();
        if (r1 == null) goto L8;
        traverseUpdate(r1);
    L9:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.f() == false) goto L13;
        traverseUpdate((DocumentInfo) r0.k().getValue());
        return;
    L13:
        return;
    L8:
        tt5.a.k(TAG, "tryUpdateDocumentInfoPerm empty documentInfo");
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updatePermission() {
        y3 r0 = getDocumentMetadata();
        w05.i r1 = ((w05.b) getHost().getHostAbility(w05.b.class)).getDocumentInfoProvider();
        String r2 = r0.getToken();
        if (r0.isSyncBlock() == false) goto L5;
        r2 = r0.getOriginBearUrl().b;
    L5:
        String r6 = r2;
        String r3 = r0.getUrl();
        String r4 = r0.getOriginUrl();
        String r5 = r0.getSpaceId();
        if (r0.getOpenSource() != DocsOpenSource.vc) goto L8;
        boolean r7 = true;
    L9:
        r1.d(r3, r4, r5, r6, r7, r0.isType(sbb.e.n), true);
        if (r0.isEditionDoc() == true) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(getDocViewModel().getEditionToken()) == true) goto L16;
        int r8 = r0.getDocumentTypeValue();
        r1.e(getDocViewModel().getEditionToken(), r8);
        return;
    L16:
        return;
    L8:
        r7 = false;
        goto L9
    }

    private void dispatchPermissionChange(PermissionData r6) {
        Iterator<o.a> r0 = this.permissionChangeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().a(r6);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.e(TAG, "dispatchPermissionChange failed", th, false);
        goto L4
    }

    private IDocUserPermission getDocUserPermission(PermissionData r13) {
        if (r13 != null) goto L5;
    L16:
        StringBuilder r2 = new StringBuilder("empty perm ");
        if (r13 != null) goto L19;
        boolean r14 = true;
    L20:
        r2.append(r14);
        tt5.a.d(TAG, r2.toString());
        return null;
    L19:
        r14 = false;
        goto L20
    L5:
        if (r13.getUserPermissionsV2() == null) goto L16;
        PermissionData.UserData r3 = r13.getUserPermissionsV2().getData();
        if (r3 != null) goto L11;
        tt5.a.d(TAG, "empty user data");
        return null;
    L11:
        AuthReason r0 = new AuthReason();
        if (r3.getAuthReasons() == null) goto L14;
        r0 = r3.getAuthReasons();
    L14:
        boolean r4 = r3.isIs_owner();
        int r5 = r3.getPermission_status_code();
        PermissionData.UserActions r6 = r3.getActions();
        OwnerInfo r7 = r13.getOwner();
        return new DocUserPermissionV2(r4, r5, r6, r7, r0, r3.toString(), 0, com.bytedance.ee.bear.middleground.permission.b.l());
    }

    private void handleDlpUpdate(DocumentInfo r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.getBlockInfos() != null) goto L6;
        return;
    L6:
        if (r7.getBlockInfos().size() <= 0) goto L53;
        Iterator<Map.Entry<String, BlockInfo>> r8 = r7.getBlockInfos().entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L21;
        BlockInfo r0 = r8.next().getValue();
        if (r0 == null) goto L10;
        if (TextUtils.isEmpty(r0.getToken()) == true) goto L10;
        if (r0.getType() == null) goto L10;
        if (this.dlpUpdateMap.containsKey(r0.getToken()) == true) goto L10;
        a r1 = new a();
        r1.b = r0.getToken();
        r1.a = Boolean.FALSE;
        r1.c = r0.getType().intValue();
        this.dlpUpdateMap.put(r0.getToken(), r1);
        goto L10
    L21:
        if (this.dlpUpdateMap.size() > 0) goto L23;
        return;
    L23:
        Iterator<Map.Entry<String, a>> r9 = this.dlpUpdateMap.entrySet().iterator();
    L25:
        if (r9.hasNext() == false) goto L54;
        Map.Entry<String, a> r2 = r9.next();
        a r3 = r2.getValue();
        if (r3.a.booleanValue() == true) goto L25;
        r3.a = Boolean.TRUE;
        this.dlpUpdateMap.put(r2.getKey(), r3);
        if (this.isDlpMigrate == true) goto L30;
        ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).c(r3.b, r3.c);
        goto L25
    L30:
        String r4 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).c(r3.c);
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r5 = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(r3.b, r4, r3.c, new c(this));
        r5.a(FileBizDomain.FileBizDomainCCM, null, null);
        this.dlpContext.put(r3.b, r5);
        goto L25
    L54:
        return;
    }

    private boolean isReferBlock(String r7) {
        y3 r0 = getDocumentMetadata();
        String r1 = r0.getToken();
        DocViewModel r2 = getDocViewModel();
        if (r2 != null) goto L5;
    L7:
        String r3 = "";
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == false) goto L21;
        if (r0.isSyncBlock() == false) goto L21;
        String r4 = r0.getOriginBearUrl().b;
        if (TextUtils.isEmpty(r7) == false) goto L15;
        return false;
    L15:
        if (TextUtils.isEmpty(r4) == false) goto L17;
        return false;
    L17:
        if (TextUtils.equals(r7, r4) == true) goto L32;
        return true;
    L32:
        return false;
    L21:
        if (TextUtils.isEmpty(r1) == false) goto L23;
    L29:
        return false;
    L23:
        if (TextUtils.isEmpty(r7) == true) goto L29;
        if (TextUtils.equals(r1, r7) == true) goto L29;
        if (TextUtils.equals(r7, r3) == true) goto L29;
        return true;
    L5:
        if (isOfficeSDKAssembleEnabled() == false) goto L7;
        r3 = ((k) org.koin.java.a.a(k.class)).s(r1, r2.getEditionId());
        goto L9
    }

    private /* synthetic */ void lambda$onAttachToHost$0(DocumentInfo r2) {
        if (r2 == null) goto L5;
        tryUpdateDocumentInfoPerm();
    L5:
        if (getDocViewModel() == null) goto L8;
        getDocViewModel().setPermissionUpdate(Boolean.TRUE);
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r1) {
        if (getDocViewModel() != null) goto L5;
        return;
    L5:
        if (getDocViewModel().getDocumentInfoData() == null) goto L9;
        handleDlpUpdate(getDocViewModel().getDocumentInfoData());
        return;
    }

    private void traverseUpdate(DocumentInfo r4) {
        if (r4 != null) goto L5;
        tt5.a.d(TAG, "traverseUpdate");
        return;
    L5:
        Iterator<Map.Entry<String, IDocUserPermission>> r0 = this.referMap.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, IDocUserPermission> r1 = r0.next();
        r4.updatePermHashMap(r1.getKey(), r1.getValue());
        goto L7
    }

    public void addPermissionChangeListener(o.a r2) {
        if (this.permissionChangeListeners.contains(r2) == false) goto L5;
        return;
    L5:
        this.permissionChangeListeners.add(r2);
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        r2.put("biz.util.notifyPermissionChange", this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r4 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        return;
    L5:
        if (isOfficeSDKAssembleEnabled() == true) goto L7;
        return;
    L7:
        if (getDocViewModel() != null) goto L9;
        return;
    L9:
        if (getDocViewModel().liveDocumentInfoData() == null) goto L19;
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.plugin.permission.a(this));
        if (getDocViewModel().getBlockInfoUpdate() == null) goto L18;
        getDocViewModel().getBlockInfoUpdate().observe(getLifecycleOwner(), new com.bytedance.ee.bear.document.plugin.permission.b(this));
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        ConcurrentHashMap<String, com.ss.android.lark.security.compliance.api.model.filepolicy.c> r3 = this.dlpContext;
        if (r3 != null) goto L5;
    L10:
        this.permissionChangeListeners.clear();
        return;
    L5:
        if (r3.size() <= 0) goto L10;
        Iterator<Map.Entry<String, com.ss.android.lark.security.compliance.api.model.filepolicy.c>> r4 = this.dlpContext.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r4.next().getValue().c();
        goto L8
    }

    public void registerPermissionChangeCallback(b r2) {
        if (this.mPermissionChangeCallbacks.contains(r2) == true) goto L6;
        this.mPermissionChangeCallbacks.add(r2);
        return;
    }

    public void removePermissionChangeListener(o.a r2) {
        this.permissionChangeListeners.remove(r2);
    }

    public void unRegisterPermissionChangeCallback(b r2) {
        if (this.mPermissionChangeCallbacks.contains(r2) == false) goto L6;
        this.mPermissionChangeCallbacks.remove(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    private void insertEditionPerm(String r2, PermissionData r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        updatePerm(r2, r3);
        if (getDocViewModel() == null) goto L9;
        getDocViewModel().setPermissionUpdate(Boolean.TRUE);
        return;
    }

    private void tryInsertReferUserPermission(String r3, PermissionData r4) {
        tt5.a.h(TAG, "handle(): tryInsertReferUserPermission permission = " + r4);
        if (isReferBlock(r3) == false) goto L7;
        if (r3 == null) goto L8;
        updatePerm(r3, r4);
        updateDeleteMap(r3, r4);
        return;
    L8:
        return;
    }

    private void updateDeleteMap(String r3, PermissionData r4) {
        if (isOfficeSDKAssembleEnabled() == true) goto L5;
        return;
    L5:
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L14;
        if (r4 != null) goto L9;
        return;
    L9:
        if (1002 != r4.getCode()) goto L11;
        boolean r5 = true;
    L12:
        r0.getDeleteCacheMap().put(r3, Boolean.valueOf(r5));
        return;
    L11:
        r5 = false;
        goto L12
    }

    private void updatePerm(String r3, PermissionData r4) {
        IDocUserPermission r5 = getDocUserPermission(r4);     // Catch: Throwable -> L11
        if (r5 != null) goto L7;
        tt5.a.k(TAG, "empty permission");     // Catch: Throwable -> L11
        return;
    L7:
        this.referMap.put(r3, r5);     // Catch: Throwable -> L11
        tryUpdateDocumentInfoPerm();     // Catch: Throwable -> L11
        if (com.bytedance.ee.bear.middleground.permission.b.a() == false) goto L15;
        j r1 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa();     // Catch: Throwable -> L11
        Boolean r6 = Boolean.valueOf(r5.isCopyAuthByKp());     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        ((HashMap) j.g).put(r3, r6);     // Catch: Throwable -> L11
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().i(r3);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L11:
        th = move-exception;
        tt5.a.d(TAG, "tryInsertReferUserPermission exception " + th.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(T r10, m r11) {
        String r12 = getDocumentMetadata().getToken();
        DocViewModel r0 = getDocViewModel();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r1 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == false) goto L11;
        if (r10 == null) goto L11;
        if (isReferBlock(r10.getToken()) == false) goto L11;
        tryInsertReferUserPermission(r10.getToken(), r10);
        if (r0 == null) goto L55;
        r0.setPermissionUpdate(Boolean.TRUE);
        return;
    L55:
        return;
    L11:
        if (r0 == null) goto L18;
        if (TextUtils.isEmpty(r0.getEditionId()) == true) goto L18;
        if (isOfficeSDKAssembleEnabled() == false) goto L18;
        r12 = ((k) org.koin.java.a.a(k.class)).s(r12, r0.getEditionId());
        insertEditionPerm(r12, r10);
    L18:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == false) goto L23;
        if (getDocumentMetadata().isSyncBlock() == false) goto L23;
        r12 = getDocumentMetadata().getOriginBearUrl().b;
    L23:
        if (r10 != null) goto L25;
    L52:
        tt5.a.d(TAG, "PermissionWebService handle(): data " + r10);
        return;
    L25:
        if (TextUtils.equals(r10.getToken(), r12) == false) goto L52;
        tt5.a.h(TAG, "handle(): receive permission = " + r10);
        long r2 = System.currentTimeMillis();
        if ((r2 - this.lastUpdateTime) <= UPDATE_LIMIT_TIME) goto L33;
        tt5.a.h(TAG, "updatePermission");
        updatePermission();
        dispatchPermissionChange(r10);
        Iterator<b> r3 = this.mPermissionChangeCallbacks.iterator();
    L30:
        if (r3.hasNext() == false) goto L32;
        r3.next().a();
        goto L30
    L32:
        this.lastUpdateTime = r2;
    L34:
        updatePerm(r10.getToken(), r10);
        r0.setPermissionUpdate(Boolean.TRUE);
        ((PerceivePermissionVM) ViewModelProviders.of(getActivity()).get(PerceivePermissionVM.class)).getCanPerceive().postValue(Boolean.valueOf(r10.isPerceiveControl()));
        if (r10.isConditionAccessControl() == false) goto L42;
        OfficePermApplyPlugin r13 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r13 != null) goto L39;
        return;
    L39:
        r13.showNoPermission(r10);
        return;
    L42:
        if (r10.isPerceiveControl() == false) goto L49;
        OfficePermApplyPlugin r14 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r14 != null) goto L46;
        return;
    L46:
        r14.showNoPermission(r10);
        return;
    L49:
        if (r10.isAuthViewByAuthLeaderFa() == false) goto L51;
        showLeaderAutoAuthDialog(r10, r12);
    L51:
        handlePermissionData(r10);
        return;
    L33:
        tt5.a.h(TAG, "updatePermission limit");
        goto L34
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showLeaderAutoAuthDialog(PermissionData r4, String r5) {
        if (this.mLastViewAuthReason != 100003) goto L6;
        tt5.a.h(TAG, "showLeaderAutoAuthDialog()...mLastViewAuthReason is the same.");
        return;
    L6:
        UDDialog r0 = this.mLeaderAuthTipsDialog;
        if (r0 != null) goto L9;
    L12:
        this.mLeaderAuthTipsDialog = ((cj5.c) org.koin.java.a.a(cj5.c.class)).nc(getContext(), r5);
        if (r4.getUserPermissionsV2() != null) goto L15;
        return;
    L15:
        if (r4.getUserPermissionsV2().getData() != null) goto L17;
        return;
    L17:
        if (r4.getUserPermissionsV2().getData().getAuthReasons() == null) goto L22;
        this.mLastViewAuthReason = r4.getUserPermissionsV2().getData().getAuthReasons().getView();
        return;
    L22:
        return;
    L9:
        if (r0.isShowing() == false) goto L12;
        tt5.a.h(TAG, "showLeaderAutoAuthDialog()...already showing.");
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((PermissionData) r1, r2);
    }
}
