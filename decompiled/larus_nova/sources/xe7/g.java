package xe7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.i;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.removeUserDomainStorageItem")
public final class g extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563380d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public g() {
        this.f563380d = "x.removeUserDomainStorageItem";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        c.b r100 = (c.b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        Boolean r101 = r100.getEnableAppIdIsolation();
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        ue7.b r103 = (ue7.b) r210.getService(ue7.b.class);
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.a();
    L11:
        if (r102 == false) goto L20;
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        XBaseModel r107 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r107).setStatus("APPID_IS_EMPTY");
        Unit r108 = Unit.INSTANCE;
        r212.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) r107);
        return;
    L14:
        if (r105.length() == 0) goto L17;
        r106 = false;
    L20:
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r109 = XBaseRuntime.f270103i;
        if (r109 == null) goto L23;
        Object r110 = Boolean.valueOf(r109.hasLogin());
    L25:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == true) goto L30;
        String r111 = this.f563380d;
        StringBuilder r112 = new StringBuilder("isLogin:");
        if (r110 != null) goto L29;
        r110 = "false";
    L29:
        r112.append(r110);
        i.b(r111, r112.toString(), "BridgeParam", r210.getContainerID());
        XBaseModel r113 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r113).setStatus("USER_NOT_LOGIN");
        r212.onSuccess((XBaseResultModel) r113, "The user is not logged in");
        return;
    L30:
        IHostUserDepend r114 = XBaseRuntime.f270103i;
        if (r114 == null) goto L33;
        r104 = r114.getUserId();
    L33:
        String r115 = r104;
        if (r115 != null) goto L36;
    L39:
        boolean r116 = true;
    L40:
        if (r116 == false) goto L45;
        String r117 = this.f563380d;
        StringBuilder r118 = new StringBuilder("|isLogin:");
        if (r110 != null) goto L44;
        r110 = "false";
    L44:
        r118.append(r110);
        r118.append(",uid is empty");
        i.b(r117, r118.toString(), "BridgeParam", r210.getContainerID());
        XBaseModel r119 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r119).setStatus("UIS_IS_EMPTY");
        Unit r120 = Unit.INSTANCE;
        r212.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) r119);
        return;
    L45:
        Activity r121 = r210.getOwnerActivity();
        if (r121 != null) goto L48;
        XBaseModel r122 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r122).setStatus("CONTEXT_IS_NULL");
        Unit r123 = Unit.INSTANCE;
        r212.onFailure(0, "Context not provided in host", (XBaseResultModel) r122);
        return;
    L48:
        String r124 = r100.getKey();
        if (r124 != null) goto L51;
    L54:
        boolean r125 = true;
    L55:
        if (r125 == false) goto L57;
        i.b(this.f563380d, "key is exmpty,remove fail", "BridgeParam", r210.getContainerID());
        XBaseModel r126 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r126).setStatus("INVALID_PARAM");
        Unit r127 = Unit.INSTANCE;
        r212.onFailure(-3, "The key should not be empty", (XBaseResultModel) r126);
        return;
    L57:
        long r128 = System.currentTimeMillis();
        if (r102 == false) goto L60;
        Pair<Boolean, Boolean> r129 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r121).b(r115 + "appId_" + r105, r124);
    L61:
        boolean r130 = r129.component1().booleanValue();
        boolean r131 = r129.component2().booleanValue();
        long r213 = System.currentTimeMillis() - r128;
        String r132 = r210.getBridgeCall().d();
        String r133 = r210.getPlatformType().name();
        if (r130 == true) goto L65;
        i.b(this.f563380d, "Key is not exist,remove fail", "BridgeParam", r210.getContainerID());
        XBaseModel r134 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r134).setStatus("DATA_NOT_EXIST");
        r212.onSuccess((XBaseResultModel) r134, "Key is not exist,remove fail");
        int r135 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r115, r121, r132, 0, this.f563380d, r133, "DATA_NOT_EXIST", r213);
        return;
    L65:
        if (r131 != true) goto L67;
        i.b(this.f563380d, "key " + r124 + ",removed succeed.", "BridgeParam", r210.getContainerID());
        XBaseModel r136 = ne7.e.b(c.InterfaceC8224c.class);
        ((c.InterfaceC8224c) r136).setStatus("REMOVE_SUCCESS");
        r212.onSuccess((XBaseResultModel) r136, "Remove succeed");
        int r137 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r115, r121, r132, 0, this.f563380d, r133, "REMOVE_SUCCESS", r213);
        return;
    L67:
        i.b(this.f563380d, "key " + r124 + ",removed failed,unknown reason.", "BridgeParam", r210.getContainerID());
        XBaseModel r138 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8224c.class));
        ((c.InterfaceC8224c) r138).setStatus("REMOVE_FAIL_UNKNOWN_REASON");
        Unit r139 = Unit.INSTANCE;
        r212.onFailure(0, "Remove fail, unknown reason", (XBaseResultModel) r138);
        int r140 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r115, r121, r132, 0, this.f563380d, r133, "REMOVE_FAIL_UNKNOWN_REASON", r213);
        return;
    L60:
        com.bytedance.sdk.xbridge.cn.storage.utils.c r141 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r121);
        Intrinsics.checkNotNull(r115);
        r129 = r141.b(r115, r124);
        goto L61
    L51:
        if (r124.length() == 0) goto L54;
        r125 = false;
        goto L55
    L36:
        if (r115.length() == 0) goto L39;
        r116 = false;
        goto L40
    L23:
        r110 = null;
        goto L25
    L9:
        r105 = null;
        goto L11
    L5:
        r102 = false;
        goto L6
    }
}
