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
import com.xiaomi.mipush.sdk.MiPushClient;
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

/* JADX INFO: loaded from: classes16.dex */
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

            public static /* synthetic */ String access$600(EmbedObject r100) {
                return r100.token;
            }

            public static /* synthetic */ int access$700(EmbedObject r100) {
                return r100.type;
            }

            public void setToken(String r100) {
                this.token = r100;
            }

            public void setType(int r100) {
                this.type = r100;
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

        public static /* synthetic */ String access$400(FileEvent r100) {
            return r100.action;
        }

        public static /* synthetic */ List access$500(FileEvent r100) {
            return r100.objs;
        }

        public void setAction(String r100) {
            this.action = r100;
        }

        public void setObjs(List<EmbedObject> r100) {
            this.objs = r100;
        }
    }

    public class a implements i<FileEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficePermissionPluginBase f220893a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficePermissionPluginBase r100) {
            this.f220893a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            FileEvent r102 = (FileEvent) r100;
            tt5.a.h(OfficePermissionPluginBase.TAG, "FileEventHandler:" + r102);
            if (MiPushClient.COMMAND_REGISTER.equals(FileEvent.access$400(r102)) == false) goto L16;
            List r103 = FileEvent.access$500(r102);
            if (hu5.a.d(r103) == true) goto L33;
            ArrayList r104 = new ArrayList();
            Iterator r105 = r103.iterator();
        L9:
            if (r105.hasNext() == false) goto L14;
            FileEvent.EmbedObject r106 = (FileEvent.EmbedObject) r105.next();
            String r107 = FileEvent.EmbedObject.access$600(r106);
            sbb.e r108 = sbb.e.d(FileEvent.EmbedObject.access$700(r106));
            if (r107 == null) goto L12;
            r104.add(new ReadPermission.b(r108, r107));
            goto L9
        L12:
            tt5.a.d(OfficePermissionPluginBase.TAG, "FileEventHandler ... objToken is null: " + r106);
            goto L9
        L14:
            OfficePermissionPluginBase.access$800(this.f220893a).b(r104);
            return;
        L33:
            return;
        L16:
            if (MiPushClient.COMMAND_UNREGISTER.equals(FileEvent.access$400(r102)) == false) goto L32;
            List r109 = FileEvent.access$500(r102);
            if (hu5.a.d(r109) == true) goto L34;
            Iterator r110 = r109.iterator();
        L22:
            if (r110.hasNext() == false) goto L35;
            FileEvent.EmbedObject r111 = (FileEvent.EmbedObject) r110.next();
            String r112 = FileEvent.EmbedObject.access$600(r111);
            OfficePermissionPluginBase.access$800(this.f220893a).d(sbb.e.d(FileEvent.EmbedObject.access$700(r111)), r112);
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
        public final void handle(Object r100, m r101) {
            final String r102 = (String) r100;
            qqb.c.b("JSBHandlerNotifySecurityAlert handle()", new g(r102));
        }
    }

    public class c implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficePermissionPluginBase f220894a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficePermissionPluginBase r100) {
            this.f220894a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            tt5.a.h(OfficePermissionPluginBase.TAG, "PermissionChangeHandler:" + r101);
            if (OfficePermissionPluginBase.access$300(this.f220894a).contains(r101) == true) goto L6;
            OfficePermissionPluginBase.access$300(this.f220894a).add(r101);
            return;
        }
    }

    public static /* synthetic */ void e(OfficePermissionPluginBase r100, String r101, int r102, String r103, Set r104) {
        r100.lambda$initCacRefreshListener$2(r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit f(OfficePermissionPluginBase r100, List r101) {
        return r100.lambda$new$1(r101);
    }

    public static /* synthetic */ void g(OfficePermissionPluginBase r100, ConnectionService.NetworkState r101) {
        r100.lambda$onAttachToHost$0(r101);
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private void destroyCacRefreshListener() {
        RefreshContext r100 = this.refreshContext;
        this.refreshContext = null;
        if (r100 == null) goto L6;
        r100.unregisterObserver();
        tt5.a.h(TAG, "destroyCacRefreshListener");
        return;
    }

    private Map<String, String> getReloadExtraData() {
        HashMap r100 = new HashMap();
        r100.put("extra_reopen_from_permission_change", Boolean.TRUE.toString());
        return r100;
    }

    private void startCacRefreshListener() {
        RefreshContext r100 = this.refreshContext;
        if (r100 == null) goto L6;
        r100.registerObserver();
        tt5.a.h(TAG, "startCacRefreshListener");
        return;
    }

    private void stopCacRefreshListener() {
        RefreshContext r100 = this.refreshContext;
        if (r100 == null) goto L6;
        r100.unregisterObserver();
        tt5.a.h(TAG, "stopCacRefreshListener");
        return;
    }

    public int getViewState() {
        Integer r100 = getDocViewState(this.token);
        if (r100 != null) goto L6;
        return -1;
    L6:
        int r101 = r100.intValue();
        tt5.a.b(TAG, "getViewState " + r101);
        return r101;
    }

    public OfficePermissionPluginBase() {
        this.hasDetached = false;
        this.docViewStateMap = new HashMap();
        this.callbacks = new ArrayList();
        this.readPermission = new ReadPermission("web", new WeakReference(new e(this)));
    }

    private void initCacRefreshListener() {
        ChameleonPluginHost r100 = getHost();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L12;
        tt5.a.h(TAG, "initCacRefreshListener, disabled by FG.");
        return;
    L12:
        y3 r102 = getDocumentMetadata();
        if (r102 != null) goto L16;
        tt5.a.h(TAG, "initCacRefreshListener, docViewModel is null.");
        return;
    L16:
        final String r103 = r102.getToken();
        final int r104 = r102.getDocumentTypeValue();
        if (r103 != null) goto L20;
        tt5.a.h(TAG, "initCacRefreshListener, docToken is null.");
        return;
    L20:
        String r105 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).c(r104);
        tt5.a.h(TAG, "startCacRefreshListener, docToken: " + du5.b.i(r103) + ", docType: " + r104 + ", tokenEntityType: " + r105);
        if (this.refreshContext != null) goto L24;
        this.refreshContext = new RefreshContext(new CCMOnlineFileContent(r103, r105), new d(this, r103, r104));
        return;
    L24:
        return;
    L5:
        if (((dn4.a) r100.getUserComponent().a(dn4.a.class)).a().isEnable("ccm.doc.cac_check_device") == false) goto L7;
        r101 = true;
        goto L9
    }

    public static /* synthetic */ List access$300(OfficePermissionPluginBase r100) {
        return r100.callbacks;
    }

    public static /* synthetic */ ReadPermission access$800(OfficePermissionPluginBase r100) {
        return r100.readPermission;
    }

    private Integer getDocViewState(String r100) {
        return this.docViewStateMap.get(r100);
    }

    private /* synthetic */ Unit lambda$new$1(List r100) {
        tt5.a.b(TAG, "FileEventHandler:" + r100.toString());
        Iterator<m> r101 = this.callbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        m r102 = r101.next();
        if (r102 == null) goto L4;
        JSONObject r103 = new JSONObject();
        r103.put2("objPermissions", JSON.toJSON(r100));
        r102.b(r103);
        goto L4
    L8:
        return null;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(ConnectionService.NetworkState r100) {
        tt5.a.h(TAG, "Network changed:" + r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.a() == false) goto L9;
        updatePermission();
        return;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        super.getBridgeHandlers(r100);
        r100.put("biz.permission.requestNative", new a(this));
        r100.put("biz.permission.addEventListener", new c(this));
        r100.put("biz.util.notifySecurityAlert", new b());
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void handlePermissionData(T r110) {
        OfficePermApplyPlugin r100 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r110.getCode();
        int r102 = r110.getPermissionStatusCode();
        PermissionData.UserPermissionV2 r103 = r110.getUserPermissionsV2();
        int r104 = getViewState();
        StringBuilder r105 = new StringBuilder("handlePermissionData: permissionCode=");
        r105.append(r101);
        r105.append(", permissionStatusCode=");
        r105.append(r102);
        r105.append(", userPermissionsV2.code=");
        if (r103 == null) goto L8;
        int r106 = r103.getCode();
    L9:
        r105.append(r106);
        r105.append(", currentViewState=");
        r105.append(r104);
        r105.append(", isPermissionShow=");
        r105.append(r100.isPermissionShow());
        tt5.a.h(TAG, r105.toString());
        y3 r107 = getDocumentMetadata();
        String r108 = r107.getOriginUrl();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docs.synced_block.permission.authorise") == true) goto L20;
        if (r107.isSyncBlock() == false) goto L20;
        if (r101 != 4) goto L15;
        if (r102 != 0) goto L15;
    L17:
        tt5.a.h(TAG, "is sync block link");
        reloadDocumentFragment(((t45.c) getHost().getUserComponent().a(t45.c.class)).Fd(r108, sbb.e.f541304o.getType(), r107.getToken(), r107.getBearUrl().f222563d), getReloadExtraData());
        return;
    L15:
        if (r101 != 4) goto L20;
        if (r102 == 10016) goto L17;
    L20:
        if (TextUtils.isEmpty(r108) == false) goto L22;
    L24:
        if (r101 != 4) goto L28;
        if (r102 != 0) goto L28;
        r100.showNoPermission(r110);
        updateState(1);
        updateDocumentInfo();
        return;
    L28:
        if (r101 != 4) goto L35;
        if (r102 != 10016) goto L35;
        updateDocumentInfo();
        if (r100.isPermissionShow() == false) goto L33;
        r100.removeAllPermissionView();
        reloadDocumentFragment(r108, getReloadExtraData());
    L33:
        updateState(2);
        return;
    L35:
        boolean r109 = DocsOpenSource.f216966vc.equals(r107.getOpenSource());
        if (r101 != 0) goto L48;
        if (r103 != null) goto L39;
        return;
    L39:
        if (sbb.e.f541302m.f541317b != r110.getType()) goto L42;
        if (r109 == false) goto L42;
        return;
    L42:
        if (r103.getCode() == 0) goto L44;
    L46:
        updateState(0);
        return;
    L44:
        if (r100.isPermissionShow() == false) goto L46;
        r100.removeAllPermissionView();
        reloadDocumentFragment(r108, getReloadExtraData());
        goto L46
    L48:
        return;
    L22:
        if (r107.isEditionDoc() == false) goto L24;
        r108 = z05.i.c(r108);
        goto L24
    L8:
        r106 = -1;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void onAttachToHost(ChameleonPluginHost r100) {
        super.onAttachToHost(r100);
        r100.registerHostAbility(this);
        j.a.f217090a.a().observe(r100.getLifecycleOwner(), new f(this));
        initCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin
    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        r100.unregisterHostAbility(this);
        this.readPermission.c();
        this.callbacks.clear();
        destroyCacRefreshListener();
    }

    public void updateState(int r100) {
        tt5.a.b(TAG, "getViewState " + r100);
        updateDocViewStateMap(this.token, Integer.valueOf(r100));
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.document.plugin.permission.OfficeBasePermissionChangePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    private void updateDocViewStateMap(String r100, Integer r101) {
        this.docViewStateMap.put(r100, r101);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.hasDetached = false;
        tt5.a.b(TAG, "lifecycle permissionPlugin onAttachToUIContainer starts");
        startCacRefreshListener();
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        tt5.a.b(TAG, "lifecycle permissionPlugin onDetachFromUIContainer");
        super.onDetachFromUIContainer(r100, r101);
        this.hasDetached = true;
        stopCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }

    private /* synthetic */ void lambda$initCacRefreshListener$2(String r100, int r101, String r102, Set r103) {
        String r104 = getDocumentMetadata().getToken();
        boolean r105 = isUIContainerAttached();
        tt5.a.h(TAG, "initCacRefreshListener - needRefresh, traceId: " + r102 + ", pointKeys: " + r103 + ", tocToken: " + du5.b.i(r100) + ", docType: " + r101 + ", currentDocToken: " + du5.b.i(r104) + ", is Attached: " + r105);
        if (r105 == true) goto L5;
        return;
    L5:
        if (TextUtils.equals(r100, r104) == false) goto L9;
        ((e4) getHostAbility(e4.class)).getBridge().a(JS_BIZ_PERMISSION_FETCH_USER_PERMISSION, new JSONObject(), null);
        return;
    }
}
