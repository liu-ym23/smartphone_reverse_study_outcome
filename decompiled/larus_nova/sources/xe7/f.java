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
import java.nio.charset.Charset;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getUserDomainStorageItem")
public final class f extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563379d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public f() {
        this.f563379d = "x.getUserDomainStorageItem";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        b.InterfaceC8223b r100 = (b.InterfaceC8223b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        String r101 = r100.getKey();
        Activity r102 = r210.getOwnerActivity();
        Boolean r103 = r100.getEnableAppIdIsolation();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L6:
        ue7.b r105 = (ue7.b) r210.getService(ue7.b.class);
        if (r105 == null) goto L9;
        String r106 = r105.a();
    L10:
        if (r104 == false) goto L19;
        if (r106 != null) goto L13;
    L16:
        boolean r110 = true;
    L17:
        if (r110 == false) goto L19;
        XBaseModel r107 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r107).setStatus("APPID_IS_EMPTY");
        Unit r108 = Unit.INSTANCE;
        r212.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) r107);
        return;
    L13:
        if (r106.length() == 0) goto L16;
        r110 = false;
    L19:
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r111 = XBaseRuntime.f270103i;
        if (r111 == null) goto L22;
        Object r112 = Boolean.valueOf(r111.hasLogin());
    L24:
        if (Intrinsics.areEqual(r112, Boolean.TRUE) == true) goto L29;
        String r109 = this.f563379d;
        StringBuilder r113 = new StringBuilder("key:");
        r113.append(r101);
        r113.append("|isLogin:");
        if (r112 != null) goto L28;
        r112 = "false";
    L28:
        r113.append(r112);
        i.b(r109, r113.toString(), "BridgeParam", r210.getContainerID());
        XBaseModel r114 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r114).setStatus("USER_NOT_LOGIN");
        r212.onSuccess((XBaseResultModel) r114, "The user is not logged in");
        return;
    L29:
        IHostUserDepend r115 = XBaseRuntime.f270103i;
        if (r115 == null) goto L32;
        String r116 = r115.getUserId();
    L33:
        if (r116 != null) goto L35;
    L38:
        boolean r117 = true;
    L39:
        if (r117 == false) goto L44;
        String r118 = this.f563379d;
        StringBuilder r119 = new StringBuilder("key:");
        r119.append(r101);
        r119.append("|isLogin:");
        if (r112 != null) goto L43;
        r112 = "false";
    L43:
        r119.append(r112);
        r119.append(",uid is empty");
        i.b(r118, r119.toString(), "BridgeParam", r210.getContainerID());
        XBaseModel r120 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r120).setStatus("UIS_IS_EMPTY");
        Unit r121 = Unit.INSTANCE;
        r212.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) r120);
        return;
    L44:
        String r122 = this.f563379d;
        StringBuilder r123 = new StringBuilder("context:");
        if (r102 != null) goto L47;
        Object r124 = "null";
    L48:
        r123.append(r124);
        r123.append("|key:");
        r123.append(r101);
        i.b(r122, r123.toString(), "BridgeParam", r210.getContainerID());
        if (r102 != null) goto L52;
        XBaseModel r125 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r125).setStatus("CONTEXT_IS_NULL");
        Unit r126 = Unit.INSTANCE;
        r212.onFailure(0, "Context not provided in host", (XBaseResultModel) r125);
        return;
    L52:
        if (r101.length() != 0) goto L54;
        boolean r127 = true;
    L55:
        if (r127 == false) goto L57;
        XBaseModel r128 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        ((b.c) r128).setStatus("INVALID_PARAM");
        Unit r129 = Unit.INSTANCE;
        r212.onFailure(-3, "The key should not be empty.", (XBaseResultModel) r128);
        return;
    L57:
        long r130 = System.currentTimeMillis();
        if (r104 == false) goto L60;
        Triple<Boolean, Boolean, Object> r131 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r102).c(r116 + "appId_" + r106, r101, this.f563379d, r210.getContainerID());
    L61:
        boolean r132 = r131.component1().booleanValue();
        boolean r133 = r131.component2().booleanValue();
        Object r134 = r131.component3();
        long r135 = System.currentTimeMillis() - r130;
        String r136 = r210.getBridgeCall().d();
        if (r134 == null) goto L68;
        String r137 = te7.c.b(r134);
        Charset r138 = Charsets.UTF_8;
        if (r137 == null) goto L67;
        long r139 = r137.getBytes(r138).length;
    L69:
        String r213 = r210.getPlatformType().name();
        i.b(this.f563379d, "isDataExist:" + r132 + ",isExpired:" + r133 + ",value:" + r134, "BridgeParam", r210.getContainerID());
        if (r132 == true) goto L73;
        i.b(this.f563379d, "context:" + r102 + "|key:" + r101 + " is not exist.", "BridgeParam", r210.getContainerID());
        XBaseModel r140 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r141 = (b.c) r140;
        r141.setStatus("DATA_NOT_EXIST");
        r141.setValue(null);
        r212.onSuccess((XBaseResultModel) r140, "Read Fail. Data does not exist ");
        int r142 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r116, r102, r136, r139, this.f563379d, r213, "DATA_NOT_EXIST", r135);
        return;
    L73:
        if (r133 != true) goto L75;
        XBaseModel r143 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r144 = (b.c) r143;
        r144.setStatus("DATA_IS_EXPIRED");
        r144.setValue(null);
        CompletionBlock.DefaultImpls.onSuccess$default(r212, (XBaseResultModel) r143, null, 2, null);
        int r145 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r116, r102, r136, r139, this.f563379d, r213, "DATA_IS_EXPIRED", r135);
        return;
    L75:
        String r146 = this.f563379d;
        StringBuilder r147 = new StringBuilder("storageValue:");
        if (r134 != null) goto L78;
        Object r148 = "null";
    L79:
        r147.append(r148);
        i.b(r146, r147.toString(), "BridgeResult", r210.getContainerID());
        if (r134 != null) goto L82;
        XBaseModel r149 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r150 = (b.c) r149;
        r150.setStatus("READE_FAIL_UNKNOWN_REASON");
        r150.setValue(null);
        Unit r151 = Unit.INSTANCE;
        r212.onFailure(0, "Read Fail. Unknown reason", (XBaseResultModel) r149);
        int r152 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r116, r102, r136, r139, this.f563379d, r213, "READE_FAIL_UNKNOWN_REASON", r135);
        return;
    L82:
        XBaseModel r153 = ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class));
        b.c r154 = (b.c) r153;
        r154.setStatus("READ_SUCCEED");
        r154.setValue(ne7.e.a(r134));
        r212.onSuccess((XBaseResultModel) r153, "Read Succeed.");
        int r155 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r116, r102, r136, r139, this.f563379d, r213, "READ_SUCCEED", r135);
        return;
    L78:
        r148 = r134;
        goto L79
    L67:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L68:
        r139 = 0;
        goto L69
    L60:
        Intrinsics.checkNotNull(r116);
        r131 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r102).c(r116, r101, this.f563379d, r210.getContainerID());
        goto L61
    L54:
        r127 = false;
        goto L55
    L47:
        r124 = r102;
        goto L48
    L35:
        if (r116.length() == 0) goto L38;
        r117 = false;
        goto L39
    L32:
        r116 = null;
        goto L33
    L22:
        r112 = null;
        goto L24
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }
}
