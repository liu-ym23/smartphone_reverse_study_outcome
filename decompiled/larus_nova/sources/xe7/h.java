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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.setUserDomainStorageItem")
public final class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563381d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public h() {
        this.f563381d = "x.setUserDomainStorageItem";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r210, CompletionBlock r211) {
        d.b r100 = (d.b) r210;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Activity r101 = r110.getOwnerActivity();
        Boolean r102 = r100.getEnableAppIdIsolation();
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        String r104 = r100.getKey();
        Object r111 = r100.getData();
        Number r105 = r100.getExpiredTime();
        if (r105 == null) goto L9;
        Long r112 = Long.valueOf(r105.longValue());
    L10:
        ue7.b r106 = (ue7.b) r110.getService(ue7.b.class);
        if (r106 == null) goto L13;
        String r107 = r106.a();
    L14:
        if (r103 == false) goto L23;
        if (r107 != null) goto L17;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
        XBaseModel r108 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r108).setStatus("APPID_IS_EMPTY");
        Unit r109 = Unit.INSTANCE;
        r211.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) r108);
        return;
    L17:
        if (r107.length() == 0) goto L20;
        r113 = false;
    L23:
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r114 = XBaseRuntime.f270103i;
        if (r114 == null) goto L26;
        Object r115 = Boolean.valueOf(r114.hasLogin());
    L28:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == true) goto L33;
        String r116 = this.f563381d;
        StringBuilder r117 = new StringBuilder("key:");
        r117.append(r104);
        r117.append("|data:");
        r117.append(r111);
        r117.append("|isLogin:");
        if (r115 != null) goto L32;
        r115 = "false";
    L32:
        r117.append(r115);
        i.b(r116, r117.toString(), "BridgeParam", r110.getContainerID());
        XBaseModel r118 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r118).setStatus("USER_NOT_LOGIN");
        r211.onSuccess((XBaseResultModel) r118, "The user is not logged in");
        return;
    L33:
        IHostUserDepend r119 = XBaseRuntime.f270103i;
        if (r119 == null) goto L36;
        String r120 = r119.getUserId();
    L37:
        if (r120 != null) goto L39;
    L42:
        boolean r121 = true;
    L43:
        if (r121 == false) goto L45;
        i.b(this.f563381d, "key:" + r104 + "|data:" + r111 + "|isLogin:" + r115 + ", but uid is empty", "BridgeParam", r110.getContainerID());
        XBaseModel r122 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r122).setStatus("UIS_IS_EMPTY");
        Unit r123 = Unit.INSTANCE;
        r211.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) r122);
        return;
    L45:
        String r124 = this.f563381d;
        StringBuilder r125 = new StringBuilder("context:");
        if (r101 != null) goto L48;
        Object r126 = "null";
    L49:
        r125.append(r126);
        r125.append("|key:");
        r125.append(r104);
        i.b(r124, r125.toString(), "BridgeParam", r110.getContainerID());
        if (r101 != null) goto L53;
        XBaseModel r127 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r127).setStatus("CONTEXT_IS_NULL");
        Unit r128 = Unit.INSTANCE;
        r211.onFailure(0, "Context not provided in host", (XBaseResultModel) r127);
        return;
    L53:
        if (r104.length() != 0) goto L55;
        boolean r129 = true;
    L56:
        if (r129 == false) goto L58;
        XBaseModel r130 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r130).setStatus("INVALID_PARAM");
        Unit r131 = Unit.INSTANCE;
        r211.onFailure(-3, "The key should not be empty.", (XBaseResultModel) r130);
        return;
    L58:
        long r132 = System.currentTimeMillis();
        if (r103 == false) goto L61;
        String r133 = r120;
        boolean r134 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r101).d(r120 + "appId_" + r107, r104, r111, r112, this.f563381d, r110.getContainerID());
    L62:
        long r135 = System.currentTimeMillis() - r132;
        String r136 = r110.getBridgeCall().d();
        String r137 = te7.c.b(r111);
        Charset r138 = Charsets.UTF_8;
        if (r137 == null) goto L70;
        long r139 = r137.getBytes(r138).length;
        String r140 = r110.getPlatformType().name();
        i.b(this.f563381d, "success:" + r134, "BridgeResult", r110.getContainerID());
        if (r134 == false) goto L67;
        XBaseModel r141 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r141).setStatus("WRITE_SUCCESS");
        r211.onSuccess((XBaseResultModel) r141, "Write succeed");
        int r142 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r133, r101, r136, r139, this.f563381d, r140, "WRITE_SUCCESS", r135);
        return;
    L67:
        XBaseModel r143 = ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class));
        ((d.c) r143).setStatus("WRITE_FAIL_UNKNOWN_REASON");
        Unit r144 = Unit.INSTANCE;
        r211.onFailure(0, "Write failed for unknown reasons. Check data type First.", (XBaseResultModel) r143);
        int r145 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r133, r101, r136, r139, this.f563381d, r140, "WRITE_FAIL_UNKNOWN_REASON", r135);
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L61:
        r133 = r120;
        Intrinsics.checkNotNull(r133);
        r134 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r101).d(r133, r104, r111, r112, this.f563381d, r110.getContainerID());
        goto L62
    L55:
        r129 = false;
        goto L56
    L48:
        r126 = r101;
        goto L49
    L39:
        if (r120.length() == 0) goto L42;
        r121 = false;
        goto L43
    L36:
        r120 = null;
        goto L37
    L26:
        r115 = null;
        goto L28
    L13:
        r107 = null;
        goto L14
    L9:
        r112 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
