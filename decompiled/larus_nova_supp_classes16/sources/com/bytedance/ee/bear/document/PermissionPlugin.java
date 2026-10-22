package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.permapply.PermApplyPlugin;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.ReadPermission;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMOnlineFileContent;
import com.ss.android.lark.security.compliance.api.model.filepolicy.RefreshContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PermissionPlugin extends BasePermissionChangePlugin<PermissionData> implements bu5.a {
    private static final String JS_BIZ_PERMISSION_FETCH_USER_PERMISSION = "window.lark.biz.permission.fetchUserPermission";
    private static final String TAG = "PermissionWebService";
    private static final int WEB_NO_PERRM_WITH_PASSWORD = 10016;
    private final List<tb5.m> callbacks;
    private final ReadPermission readPermission;
    private RefreshContext refreshContext;
    private String token;

    public static class FileEvent implements NonProguard {
        private static final String REGISTER = "register";
        private static final String UNREGISTER = "unregister";
        private String action;
        private List<EmbedObject> objs;

        public static class EmbedObject implements NonProguard {
            private String token;
            private int type;

            private EmbedObject() {
            }

            public String toString() {
                return "EmbedObject{token='" + du5.d.a(this.token) + "', type=" + this.type + '}';
            }

            public String getToken() {
                return this.token;
            }

            public int getType() {
                return this.type;
            }

            public static /* synthetic */ String access$600(EmbedObject r0) {
                return r0.token;
            }

            public static /* synthetic */ int access$700(EmbedObject r0) {
                return r0.type;
            }

            public void setToken(String r1) {
                this.token = r1;
            }

            public void setType(int r1) {
                this.type = r1;
            }
        }

        private FileEvent() {
        }

        public String toString() {
            return "FileEvent{action='" + this.action + "', objs=" + this.objs + '}';
        }

        public String getAction() {
            return this.action;
        }

        public List<EmbedObject> getObjs() {
            return this.objs;
        }

        public static /* synthetic */ String access$400(FileEvent r0) {
            return r0.action;
        }

        public static /* synthetic */ List access$500(FileEvent r0) {
            return r0.objs;
        }

        public void setAction(String r1) {
            this.action = r1;
        }

        public void setObjs(List<EmbedObject> r1) {
            this.objs = r1;
        }
    }

    public class a implements tb5.i<FileEvent> {
        public final /* synthetic */ PermissionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(PermissionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, tb5.m r6) {
            FileEvent r7 = (FileEvent) r5;
            tt5.a.h(PermissionPlugin.TAG, "FileEventHandler:" + r7);
            if ("register".equals(FileEvent.access$400(r7)) == false) goto L18;
            List r8 = FileEvent.access$500(r7);
            if (r8 != null) goto L7;
            return;
        L7:
            if (r8.isEmpty() == true) goto L39;
            ArrayList r9 = new ArrayList();
            Iterator r10 = r8.iterator();
        L11:
            if (r10.hasNext() == false) goto L16;
            FileEvent.EmbedObject r1 = (FileEvent.EmbedObject) r10.next();
            String r2 = FileEvent.EmbedObject.access$600(r1);
            sbb.e r3 = sbb.e.d(FileEvent.EmbedObject.access$700(r1));
            if (r2 == null) goto L14;
            r9.add(new ReadPermission.b(r3, r2));
            goto L11
        L14:
            tt5.a.d(PermissionPlugin.TAG, "FileEventHandler ... objToken is null: " + r1);
            goto L11
        L16:
            PermissionPlugin.access$800(this.a).b(r9);
            return;
        L39:
            return;
        L18:
            if ("unregister".equals(FileEvent.access$400(r7)) == false) goto L37;
            List r11 = FileEvent.access$500(r7);
            if (r11 != null) goto L22;
            return;
        L22:
            if (r11.isEmpty() == true) goto L40;
            Iterator r12 = r11.iterator();
        L26:
            if (r12.hasNext() == false) goto L41;
            FileEvent.EmbedObject r13 = (FileEvent.EmbedObject) r12.next();
            String r0 = FileEvent.EmbedObject.access$600(r13);
            PermissionPlugin.access$800(this.a).d(sbb.e.d(FileEvent.EmbedObject.access$700(r13)), r0);
            goto L26
        L41:
            return;
        L40:
            return;
        }
    }

    public static class b implements tb5.i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            final String r3 = (String) r1;
            qqb.c.b("JSBHandlerNotifySecurityAlert handle()", new x5(r3));
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ PermissionPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(PermissionPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            tt5.a.h(PermissionPlugin.TAG, "PermissionChangeHandler:" + r3);
            if (PermissionPlugin.access$300(this.a).contains(r3) == true) goto L6;
            PermissionPlugin.access$300(this.a).add(r3);
            return;
        }
    }

    public static /* synthetic */ void e(PermissionPlugin r0, String r1, int r2, String r3, Set r4) {
        r0.lambda$initCacRefreshListener$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit f(PermissionPlugin r0, List r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void g(PermissionPlugin r0, ConnectionService.NetworkState r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void destroyCacRefreshListener() {
        RefreshContext r0 = this.refreshContext;
        this.refreshContext = null;
        if (r0 == null) goto L6;
        r0.unregisterObserver();
        tt5.a.h(TAG, "destroyCacRefreshListener");
        return;
    }

    private Map<String, String> getReloadExtraData() {
        HashMap r0 = new HashMap();
        r0.put("extra_reopen_from_permission_change", Boolean.TRUE.toString());
        return r0;
    }

    private void startCacRefreshListener() {
        RefreshContext r0 = this.refreshContext;
        if (r0 == null) goto L6;
        r0.registerObserver();
        tt5.a.h(TAG, "startCacRefreshListener");
        return;
    }

    private void stopCacRefreshListener() {
        RefreshContext r0 = this.refreshContext;
        if (r0 == null) goto L6;
        r0.unregisterObserver();
        tt5.a.h(TAG, "stopCacRefreshListener");
        return;
    }

    public PermissionPlugin() {
        this.callbacks = new ArrayList();
        this.readPermission = new ReadPermission("web", new WeakReference(new w5(this)));
    }

    private void initCacRefreshListener() {
        PluginHost r0 = getHost();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        tt5.a.h(TAG, "initCacRefreshListener, disabled by FG.");
        return;
    L12:
        DocViewModel r2 = getDocViewModel();
        if (r2 != null) goto L16;
        tt5.a.h(TAG, "initCacRefreshListener, docViewModel is null.");
        return;
    L16:
        final String r3 = r2.getToken();
        final int r4 = r2.getDocumentTypeValue();
        if (r3 != null) goto L20;
        tt5.a.h(TAG, "initCacRefreshListener, docToken is null.");
        return;
    L20:
        String r5 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).c(r4);
        tt5.a.h(TAG, "startCacRefreshListener, docToken: " + du5.b.i(r3) + ", docType: " + r4 + ", tokenEntityType: " + r5);
        if (this.refreshContext != null) goto L24;
        this.refreshContext = new RefreshContext(new CCMOnlineFileContent(r3, r5), new v5(this, r3, r4));
        return;
    L24:
        return;
    L5:
        if (((dn4.a) r0.getUserComponent().a(dn4.a.class)).a().isEnable("ccm.doc.cac_check_device") == false) goto L7;
        r1 = true;
        goto L9
    }

    public int getViewState() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return -1;
    L5:
        Integer r1 = r0.getDocViewState(this.token);
        if (r1 != null) goto L8;
        return -1;
    L8:
        int r2 = r1.intValue();
        tt5.a.b(TAG, "getViewState " + r2);
        return r2;
    }

    public static /* synthetic */ List access$300(PermissionPlugin r0) {
        return r0.callbacks;
    }

    public static /* synthetic */ ReadPermission access$800(PermissionPlugin r0) {
        return r0.readPermission;
    }

    private /* synthetic */ Unit lambda$new$1(List r6) {
        tt5.a.b(TAG, "FileEventHandler:" + r6.toString());
        Iterator<tb5.m> r0 = this.callbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        tb5.m r1 = r0.next();
        if (r1 == null) goto L4;
        JSONObject r2 = new JSONObject();
        r2.put("objPermissions", JSON.toJSON(r6));
        r1.b(r2);
        goto L4
    L8:
        return null;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(ConnectionService.NetworkState r3) {
        tt5.a.h(TAG, "Network changed:" + r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.a() == false) goto L9;
        updatePermission();
        return;
    }

    public void didReceivePush(String r2) {
        tt5.a.b(TAG, "didReceivePush");
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        super.getBridgeHandlers(r3);
        r3.put("biz.permission.requestNative", new a(this));
        r3.put("biz.permission.addEventListener", new c(this));
        r3.put("biz.util.notifySecurityAlert", new b());
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin
    public void handlePermissionData(PermissionData r11) {
        PermApplyPlugin r0 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r11.getCode();
        int r2 = r11.getPermissionStatusCode();
        PermissionData.UserPermissionV2 r3 = r11.getUserPermissionsV2();
        int r4 = getViewState();
        StringBuilder r5 = new StringBuilder("handlePermissionData: permissionCode=");
        r5.append(r1);
        r5.append(", permissionStatusCode=");
        r5.append(r2);
        r5.append(", userPermissionsV2.code=");
        if (r3 == null) goto L8;
        int r6 = r3.getCode();
    L9:
        r5.append(r6);
        r5.append(", currentViewState=");
        r5.append(r4);
        r5.append(", isPermissionShow=");
        r5.append(r0.isPermissionShow());
        tt5.a.h(TAG, r5.toString());
        if (getDocViewModel() == null) goto L12;
        String r7 = getDocViewModel().getOriginUrl();
    L13:
        DocViewModel r8 = getDocViewModel();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authorise") == true) goto L25;
        if (r8 == null) goto L25;
        if (r8.isSyncBlock() == false) goto L25;
        if (r1 != 4) goto L20;
        if (r2 != 0) goto L20;
    L22:
        tt5.a.h(TAG, "is sync block link");
        reloadDocumentFragment(((t45.c) getHost().getUserComponent().a(t45.c.class)).Fd(r7, sbb.e.o.getType(), r8.getToken(), r8.getBearUrl().d), getReloadExtraData());
        return;
    L20:
        if (r1 != 4) goto L25;
        if (r2 == WEB_NO_PERRM_WITH_PASSWORD) goto L22;
    L25:
        if (TextUtils.isEmpty(r7) == true) goto L30;
        if (r8 == null) goto L30;
        if (r8.isEditionDoc() == false) goto L30;
        r7 = z05.i.c(r7);
    L30:
        boolean r9 = true;
        if (r1 != 4) goto L35;
        if (r2 != 0) goto L35;
        r0.showNoPermission(r11);
        updateState(1);
        updateDocumentInfo();
        return;
    L35:
        if (r1 != 4) goto L43;
        if (r2 != WEB_NO_PERRM_WITH_PASSWORD) goto L43;
        updateDocumentInfo();
        if (r0.isPermissionShow() == false) goto L40;
        r0.removeAllPermissionView();
        reloadDocumentFragment(r7, getReloadExtraData());
    L40:
        updateState(2);
        return;
    L43:
        if (getDocViewModel() != null) goto L45;
    L47:
        r9 = false;
    L48:
        if (r1 != 0) goto L60;
        if (r3 != null) goto L51;
        return;
    L51:
        if (sbb.e.m.b != r11.getType()) goto L54;
        if (r9 == false) goto L54;
        return;
    L54:
        if (r3.getCode() == 0) goto L56;
    L58:
        updateState(0);
        return;
    L56:
        if (r0.isPermissionShow() == false) goto L58;
        r0.removeAllPermissionView();
        reloadDocumentFragment(r7, getReloadExtraData());
        goto L58
    L60:
        return;
    L45:
        if (DocsOpenSource.vc.equals(getDocViewModel().getOpenSource()) == false) goto L47;
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = -1;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r3.getLifecycleOwner(), new u5(this));
        initCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.document.BasePermissionChangePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        this.readPermission.c();
        this.callbacks.clear();
        destroyCacRefreshListener();
    }

    public void updateState(int r4) {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return;
    L5:
        tt5.a.b(TAG, "getViewState " + r4);
        r0.updateDocViewStateMap(this.token, Integer.valueOf(r4));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        tt5.a.b(TAG, "lifecycle permissionPlugin onAttachToUIContainer starts");
        startCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        tt5.a.b(TAG, "lifecycle permissionPlugin onDetachFromUIContainer");
        super.onDetachFromUIContainer(r3, r4);
        stopCacRefreshListener();
    }

    private /* synthetic */ void lambda$initCacRefreshListener$2(String r5, int r6, String r7, Set r8) {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        String r1 = null;
    L6:
        boolean r2 = isUIContainerAttached();
        tt5.a.h(TAG, "initCacRefreshListener - needRefresh, traceId: " + r7 + ", pointKeys: " + r8 + ", tocToken: " + du5.b.i(r5) + ", docType: " + r6 + ", currentDocToken: " + du5.b.i(r1) + ", is Attached: " + r2);
        if (r2 == true) goto L9;
        return;
    L9:
        if (TextUtils.equals(r5, r1) == false) goto L13;
        dispatchBridgeMsg(JS_BIZ_PERMISSION_FETCH_USER_PERMISSION, new JSONObject());
        return;
    L13:
        return;
    L5:
        r1 = r0.getToken();
        goto L6
    }
}
