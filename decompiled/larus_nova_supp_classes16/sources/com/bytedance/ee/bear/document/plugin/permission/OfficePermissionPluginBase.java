package com.bytedance.ee.bear.document.plugin.permission;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.document.plugin.permapply.OfficePermApplyPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.ReadPermission;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
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
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficePermissionPluginBase<T extends PermissionData> extends OfficeBasePermissionChangePlugin<T> {
    private static final String JS_BIZ_PERMISSION_FETCH_USER_PERMISSION = "window.lark.biz.permission.fetchUserPermission";
    private static final String TAG = "PermissionWebService";
    private static final int WEB_NO_PERRM_WITH_PASSWORD = 10016;
    private final List<m> callbacks;
    private HashMap<String, Integer> docViewStateMap;
    private boolean hasDetached;
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

    public class a implements i<FileEvent> {
        public final /* synthetic */ OfficePermissionPluginBase a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficePermissionPluginBase r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, m r6) {
            FileEvent r7 = (FileEvent) r5;
            tt5.a.h(OfficePermissionPluginBase.TAG, "FileEventHandler:" + r7);
            if ("register".equals(FileEvent.access$400(r7)) == false) goto L16;
            List r8 = FileEvent.access$500(r7);
            if (hu5.a.d(r8) == true) goto L33;
            ArrayList r9 = new ArrayList();
            Iterator r10 = r8.iterator();
        L9:
            if (r10.hasNext() == false) goto L14;
            FileEvent.EmbedObject r1 = (FileEvent.EmbedObject) r10.next();
            String r2 = FileEvent.EmbedObject.access$600(r1);
            sbb.e r3 = sbb.e.d(FileEvent.EmbedObject.access$700(r1));
            if (r2 == null) goto L12;
            r9.add(new ReadPermission.b(r3, r2));
            goto L9
        L12:
            tt5.a.d(OfficePermissionPluginBase.TAG, "FileEventHandler ... objToken is null: " + r1);
            goto L9
        L14:
            OfficePermissionPluginBase.access$800(this.a).b(r9);
            return;
        L33:
            return;
        L16:
            if ("unregister".equals(FileEvent.access$400(r7)) == false) goto L32;
            List r11 = FileEvent.access$500(r7);
            if (hu5.a.d(r11) == true) goto L34;
            Iterator r12 = r11.iterator();
        L22:
            if (r12.hasNext() == false) goto L35;
            FileEvent.EmbedObject r13 = (FileEvent.EmbedObject) r12.next();
            String r0 = FileEvent.EmbedObject.access$600(r13);
            OfficePermissionPluginBase.access$800(this.a).d(sbb.e.d(FileEvent.EmbedObject.access$700(r13)), r0);
            goto L22
        L35:
            return;
        L34:
            return;
        }
    }

    public static class b implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            final String r3 = (String) r1;
            qqb.c.b("JSBHandlerNotifySecurityAlert handle()", new g(r3));
        }
    }

    public class c implements i<String> {
        public final /* synthetic */ OfficePermissionPluginBase a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficePermissionPluginBase r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            String r4 = (String) r2;
            tt5.a.h(OfficePermissionPluginBase.TAG, "PermissionChangeHandler:" + r3);
            if (OfficePermissionPluginBase.access$300(this.a).contains(r3) == true) goto L6;
            OfficePermissionPluginBase.access$300(this.a).add(r3);
            return;
        }
    }

    public static /* synthetic */ void e(OfficePermissionPluginBase r0, String r1, int r2, String r3, Set r4) {
        r0.lambda$initCacRefreshListener$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit f(OfficePermissionPluginBase r0, List r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void g(OfficePermissionPluginBase r0, ConnectionService.NetworkState r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
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

    public int getViewState() {
        Integer r0 = getDocViewState(this.token);
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = r0.intValue();
        tt5.a.b(TAG, "getViewState " + r1);
        return r1;
    }

    public OfficePermissionPluginBase() {
        this.hasDetached = false;
        this.docViewStateMap = new HashMap();
        this.callbacks = new ArrayList();
        this.readPermission = new ReadPermission("web", new WeakReference(new e(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        y3 r2 = getDocumentMetadata();
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
        this.refreshContext = new RefreshContext(new CCMOnlineFileContent(r3, r5), new d(this, r3, r4));
        return;
    L24:
        return;
    L5:
        if (((dn4.a) r0.getUserComponent().a(dn4.a.class)).a().isEnable("ccm.doc.cac_check_device") == false) goto L7;
        r1 = true;
        goto L9
    }

    public static /* synthetic */ List access$300(OfficePermissionPluginBase r0) {
        return r0.callbacks;
    }

    public static /* synthetic */ ReadPermission access$800(OfficePermissionPluginBase r0) {
        return r0.readPermission;
    }

    private Integer getDocViewState(String r2) {
        return this.docViewStateMap.get(r2);
    }

    private /* synthetic */ Unit lambda$new$1(List r6) {
        tt5.a.b(TAG, "FileEventHandler:" + r6.toString());
        Iterator<m> r0 = this.callbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        m r1 = r0.next();
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

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        super.getBridgeHandlers(r3);
        r3.put("biz.permission.requestNative", new a(this));
        r3.put("biz.permission.addEventListener", new c(this));
        r3.put("biz.util.notifySecurityAlert", new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void handlePermissionData(T r11) {
        OfficePermApplyPlugin r0 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
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
        y3 r7 = getDocumentMetadata();
        String r8 = r7.getOriginUrl();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authorise") == true) goto L20;
        if (r7.isSyncBlock() == false) goto L20;
        if (r1 != 4) goto L15;
        if (r2 != 0) goto L15;
    L17:
        tt5.a.h(TAG, "is sync block link");
        reloadDocumentFragment(((t45.c) getHost().getUserComponent().a(t45.c.class)).Fd(r8, sbb.e.o.getType(), r7.getToken(), r7.getBearUrl().d), getReloadExtraData());
        return;
    L15:
        if (r1 != 4) goto L20;
        if (r2 == WEB_NO_PERRM_WITH_PASSWORD) goto L17;
    L20:
        if (TextUtils.isEmpty(r8) == false) goto L22;
    L24:
        if (r1 != 4) goto L28;
        if (r2 != 0) goto L28;
        r0.showNoPermission(r11);
        updateState(1);
        updateDocumentInfo();
        return;
    L28:
        if (r1 != 4) goto L35;
        if (r2 != WEB_NO_PERRM_WITH_PASSWORD) goto L35;
        updateDocumentInfo();
        if (r0.isPermissionShow() == false) goto L33;
        r0.removeAllPermissionView();
        reloadDocumentFragment(r8, getReloadExtraData());
    L33:
        updateState(2);
        return;
    L35:
        boolean r9 = DocsOpenSource.vc.equals(r7.getOpenSource());
        if (r1 != 0) goto L48;
        if (r3 != null) goto L39;
        return;
    L39:
        if (sbb.e.m.b != r11.getType()) goto L42;
        if (r9 == false) goto L42;
        return;
    L42:
        if (r3.getCode() == 0) goto L44;
    L46:
        updateState(0);
        return;
    L44:
        if (r0.isPermissionShow() == false) goto L46;
        r0.removeAllPermissionView();
        reloadDocumentFragment(r8, getReloadExtraData());
        goto L46
    L48:
        return;
    L22:
        if (r7.isEditionDoc() == false) goto L24;
        r8 = z05.i.c(r8);
        goto L24
    L8:
        r6 = -1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void onAttachToHost(ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        r3.registerHostAbility(this);
        j.a.a.a().observe(r3.getLifecycleOwner(), new f(this));
        initCacRefreshListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void onDetachFromHost(ChameleonPluginHost r1) {
        super.onDetachFromHost(r1);
        r1.unregisterHostAbility(this);
        this.readPermission.c();
        this.callbacks.clear();
        destroyCacRefreshListener();
    }

    public void updateState(int r3) {
        tt5.a.b(TAG, "getViewState " + r3);
        updateDocViewStateMap(this.token, Integer.valueOf(r3));
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    private void updateDocViewStateMap(String r2, Integer r3) {
        this.docViewStateMap.put(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        this.hasDetached = false;
        tt5.a.b(TAG, "lifecycle permissionPlugin onAttachToUIContainer starts");
        startCacRefreshListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r3, t r4) {
        tt5.a.b(TAG, "lifecycle permissionPlugin onDetachFromUIContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r3, r4);
        this.hasDetached = true;
        stopCacRefreshListener();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$initCacRefreshListener$2(String r5, int r6, String r7, Set r8) {
        String r0 = getDocumentMetadata().getToken();
        boolean r1 = isUIContainerAttached();
        tt5.a.h(TAG, "initCacRefreshListener - needRefresh, traceId: " + r7 + ", pointKeys: " + r8 + ", tocToken: " + du5.b.i(r5) + ", docType: " + r6 + ", currentDocToken: " + du5.b.i(r0) + ", is Attached: " + r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (TextUtils.equals(r5, r0) == false) goto L9;
        ((e4) getHostAbility(e4.class)).getBridge().a(JS_BIZ_PERMISSION_FETCH_USER_PERMISSION, new JSONObject(), null);
        return;
    }
}
