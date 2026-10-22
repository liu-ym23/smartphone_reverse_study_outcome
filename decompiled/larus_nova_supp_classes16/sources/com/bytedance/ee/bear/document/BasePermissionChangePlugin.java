package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.permapply.PermApplyPlugin;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.drive.PerceivePermissionVM;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BasePermissionChangePlugin<T extends PermissionData> extends DocumentPluginV2 implements tb5.i<T>, com.bytedance.ee.bear.o {
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
    private final List<com.bytedance.ee.bear.o.a> permissionChangeListeners;
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

    public static /* synthetic */ void a(BasePermissionChangePlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ Unit c(BasePermissionChangePlugin r0) {
        return r0.lambda$handleDlpUpdate$2();
    }

    public static /* synthetic */ void d(BasePermissionChangePlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public abstract void handlePermissionData(T r1);

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void updateDocumentInfo() {
        w05.i r0 = ((w05.b) getHostAbility(w05.b.class)).getDocumentInfoProvider();
        DocumentInfo r1 = (DocumentInfo) r0.g().getValue();
        if (r1 == null) goto L6;
        tt5.a.h(TAG, "canRead to can'tRead update perm to init type");
        r1.updateDocPermission(new DocPermission());
        r0.j().postValue(r1);
        return;
    }

    public BasePermissionChangePlugin() {
        this.lastUpdateTime = 0;
        this.mPermissionChangeCallbacks = new CopyOnWriteArrayList();
        this.permissionChangeListeners = new CopyOnWriteArrayList();
        this.referMap = new ConcurrentHashMap();
        this.dlpUpdateMap = new ConcurrentHashMap();
        this.dlpContext = new ConcurrentHashMap();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        this.isDlpMigrate = jg5.e.a.a.g();
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

    private void tryUpdateDocumentInfoPerm() {
        w05.i r0 = ((w05.b) getHost().getHostAbility(w05.b.class)).getDocumentInfoProvider();
        DocumentInfo r1 = (DocumentInfo) r0.g().getValue();
        if (r1 == null) goto L5;
        traverseUpdate(r1);
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.f() == false) goto L10;
        traverseUpdate((DocumentInfo) r0.k().getValue());
        return;
    L10:
        return;
    L5:
        tt5.a.k(TAG, "tryUpdateDocumentInfoPerm empty documentInfo");
        goto L6
    }

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
        if (getDocViewModel() != null) goto L12;
        return;
    L12:
        if (getDocViewModel().isEditionDoc() == true) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(getDocViewModel().getEditionToken()) == true) goto L19;
        int r8 = getDocViewModel().getDocumentTypeValue();
        r1.e(getDocViewModel().getEditionToken(), r8);
        return;
    L19:
        return;
    L8:
        r7 = false;
        goto L9
    }

    private void dispatchPermissionChange(PermissionData r6) {
        Iterator<com.bytedance.ee.bear.o.a> r0 = this.permissionChangeListeners.iterator();
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
        if (r7.getBlockInfos().size() <= 0) goto L57;
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
        if (r9.hasNext() == false) goto L58;
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
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r5 = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(r3.b, r4, r3.c, new g(this));
        if (r3.c != 28) goto L33;
        FileBizDomain r6 = FileBizDomain.FileBizDomainMeetingMinutes;
    L34:
        r5.a(r6, null, null);
        this.dlpContext.put(r3.b, r5);
        goto L25
    L33:
        r6 = FileBizDomain.FileBizDomainCCM;
        goto L34
    L58:
        return;
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

    public void addPermissionChangeListener(com.bytedance.ee.bear.o.a r2) {
        if (this.permissionChangeListeners.contains(r2) == true) goto L6;
        this.permissionChangeListeners.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        r2.put("biz.util.notifyPermissionChange", this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        r3.registerHostAbility(this);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r4 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        return;
    L5:
        if (getDocViewModel() != null) goto L7;
        return;
    L7:
        if (getDocViewModel().liveDocumentInfoData() == null) goto L16;
        getDocViewModel().liveDocumentInfoData().observe(getLifecycleOwner(), new e(this));
        if (getDocViewModel().getBlockInfoUpdate() == null) goto L15;
        getDocViewModel().getBlockInfoUpdate().observe(getLifecycleOwner(), new f(this));
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        r2.unregisterHostAbility(this);
        this.permissionChangeListeners.clear();
        super.onDetachFromHost(r2);
        ConcurrentHashMap<String, com.ss.android.lark.security.compliance.api.model.filepolicy.c> r3 = this.dlpContext;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.size() <= 0) goto L12;
        Iterator<Map.Entry<String, com.ss.android.lark.security.compliance.api.model.filepolicy.c>> r4 = this.dlpContext.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        r4.next().getValue().c();
        goto L8
    L13:
        return;
    }

    public void registerPermissionChangeCallback(b r2) {
        if (this.mPermissionChangeCallbacks.contains(r2) == true) goto L6;
        this.mPermissionChangeCallbacks.add(r2);
        return;
    }

    public void removePermissionChangeListener(com.bytedance.ee.bear.o.a r2) {
        this.permissionChangeListeners.remove(r2);
    }

    public void unRegisterPermissionChangeCallback(b r2) {
        if (this.mPermissionChangeCallbacks.contains(r2) == false) goto L6;
        this.mPermissionChangeCallbacks.remove(r2);
        return;
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

    private boolean isReferBlock(String r6, DocViewModel r7) {
        y3 r0 = getDocumentMetadata();
        String r1 = r0.getToken();
        String r8 = ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).s(r1, r7.getEditionId());
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == false) goto L16;
        if (r0.isSyncBlock() == false) goto L16;
        String r9 = r0.getOriginBearUrl().b;
        if (TextUtils.isEmpty(r6) == false) goto L9;
    L13:
        return false;
    L9:
        if (TextUtils.isEmpty(r9) == true) goto L13;
        if (TextUtils.equals(r6, r9) == true) goto L13;
        return true;
    L16:
        if (TextUtils.isEmpty(r1) == false) goto L18;
    L24:
        return false;
    L18:
        if (TextUtils.isEmpty(r6) == true) goto L24;
        if (TextUtils.equals(r1, r6) == true) goto L24;
        if (TextUtils.equals(r6, r8) == true) goto L24;
        return true;
    }

    private void tryInsertReferUserPermission(String r3, PermissionData r4) {
        tt5.a.h(TAG, "handle(): tryInsertReferUserPermission permission = " + r4);
        if (isReferBlock(r3, getDocViewModel()) == false) goto L7;
        if (r3 == null) goto L8;
        updatePerm(r3, r4);
        updateDeleteMap(r3, r4);
        return;
    L8:
        return;
    }

    private void updateDeleteMap(String r3, PermissionData r4) {
        DocViewModel r0 = getDocViewModel();
        if (r0 == null) goto L11;
        if (r4 != null) goto L6;
        return;
    L6:
        if (1002 != r4.getCode()) goto L8;
        boolean r5 = true;
    L9:
        r0.getDeleteCacheMap().put(r3, Boolean.valueOf(r5));
        return;
    L8:
        r5 = false;
        goto L9
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
        jg5.j r1 = ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa();     // Catch: Throwable -> L11
        Boolean r6 = Boolean.valueOf(r5.isCopyAuthByKp());     // Catch: Throwable -> L11
        r1.getClass();     // Catch: Throwable -> L11
        ((HashMap) jg5.j.g).put(r3, r6);     // Catch: Throwable -> L11
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().i(r3);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L11:
        th = move-exception;
        tt5.a.d(TAG, "tryInsertReferUserPermission exception " + th.getMessage());
    }

    public void handle(T r10, tb5.m r11) {
        String r12 = getDocumentMetadata().getToken();
        DocViewModel r0 = getDocViewModel();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r1 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == false) goto L11;
        if (r10 == null) goto L11;
        if (isReferBlock(r10.getToken(), r0) == false) goto L11;
        tryInsertReferUserPermission(r10.getToken(), r10);
        if (r0 == null) goto L53;
        r0.setPermissionUpdate(Boolean.TRUE);
        return;
    L53:
        return;
    L11:
        if (r0 == null) goto L16;
        if (TextUtils.isEmpty(r0.getEditionId()) == true) goto L16;
        r12 = ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).s(r12, r0.getEditionId());
        insertEditionPerm(r12, r10);
    L16:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authentication") == false) goto L21;
        if (getDocumentMetadata().isSyncBlock() == false) goto L21;
        r12 = getDocumentMetadata().getOriginBearUrl().b;
    L21:
        if (r10 != null) goto L23;
    L50:
        tt5.a.d(TAG, "PermissionWebService handle(): data " + r10);
        return;
    L23:
        if (TextUtils.equals(r10.getToken(), r12) == false) goto L50;
        tt5.a.h(TAG, "handle(): receive permission = " + r10);
        long r2 = System.currentTimeMillis();
        if ((r2 - this.lastUpdateTime) <= UPDATE_LIMIT_TIME) goto L31;
        tt5.a.h(TAG, "updatePermission");
        updatePermission();
        dispatchPermissionChange(r10);
        Iterator<b> r3 = this.mPermissionChangeCallbacks.iterator();
    L28:
        if (r3.hasNext() == false) goto L30;
        r3.next().a();
        goto L28
    L30:
        this.lastUpdateTime = r2;
    L32:
        updatePerm(r10.getToken(), r10);
        r0.setPermissionUpdate(Boolean.TRUE);
        ((PerceivePermissionVM) ViewModelProviders.of(getActivity()).get(PerceivePermissionVM.class)).getCanPerceive().postValue(Boolean.valueOf(r10.isPerceiveControl()));
        if (r10.isConditionAccessControl() == false) goto L40;
        PermApplyPlugin r13 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        if (r13 != null) goto L37;
        return;
    L37:
        r13.showNoPermission(r10);
        return;
    L40:
        if (r10.isPerceiveControl() == false) goto L47;
        PermApplyPlugin r14 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        if (r14 != null) goto L44;
        return;
    L44:
        r14.showNoPermission(r10);
        return;
    L47:
        if (r10.isAuthViewByAuthLeaderFa() == false) goto L49;
        showLeaderAutoAuthDialog(r10, r12);
    L49:
        handlePermissionData(r10);
        return;
    L31:
        tt5.a.h(TAG, "updatePermission limit");
        goto L32
    }

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
    public /* bridge */ /* synthetic */ void handle(Object r1, tb5.m r2) {
        handle((PermissionData) r1, r2);
    }
}
