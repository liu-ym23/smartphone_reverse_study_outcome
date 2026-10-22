package xe7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.i;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getUserDomainStorageInfo")
public final class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f563378d;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public e() {
        this.f563378d = "x.getUserDomainStorageInfo";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        a.b r113 = (a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        Boolean r114 = r113.getEnableAppIdIsolation();
        if (r114 == null) goto L5;
        boolean r115 = r114.booleanValue();
    L6:
        ue7.b r101 = (ue7.b) r110.getService(ue7.b.class);
        String r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.a();
    L10:
        boolean r104 = true;
        if (r115 == false) goto L20;
        if (r103 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        XBaseModel r116 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        ((a.c) r116).setStatus("APPID_IS_EMPTY");
        Unit r117 = Unit.INSTANCE;
        r112.onFailure(1001, "Use Annie Pro but app_id is empty", (XBaseResultModel) r116);
        return;
    L14:
        if (r103.length() == 0) goto L17;
        r105 = false;
    L20:
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r106 = XBaseRuntime.f270103i;
        if (r106 == null) goto L23;
        Object r107 = Boolean.valueOf(r106.hasLogin());
    L25:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == true) goto L30;
        String r118 = this.f563378d;
        StringBuilder r108 = new StringBuilder("isLogin:");
        if (r107 != null) goto L29;
        r107 = "false";
    L29:
        r108.append(r107);
        i.b(r118, r108.toString(), "BridgeParam", r110.getContainerID());
        XBaseModel r119 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        ((a.c) r119).setStatus("USER_NOT_LOGIN");
        r112.onSuccess((XBaseResultModel) r119, "The user is not logged in");
        return;
    L30:
        IHostUserDepend r109 = XBaseRuntime.f270103i;
        if (r109 == null) goto L33;
        r102 = r109.getUserId();
    L33:
        if (r102 != null) goto L35;
    L38:
        if (r104 == false) goto L43;
        String r120 = this.f563378d;
        StringBuilder r121 = new StringBuilder("|isLogin:");
        if (r107 != null) goto L42;
        r107 = "false";
    L42:
        r121.append(r107);
        r121.append(",uid is empty");
        i.b(r120, r121.toString(), "BridgeParam", r110.getContainerID());
        XBaseModel r122 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        ((a.c) r122).setStatus("UIS_IS_EMPTY");
        Unit r123 = Unit.INSTANCE;
        r112.onFailure(0, "The user ID cannot be empty or null", (XBaseResultModel) r122);
        return;
    L43:
        if (r100 != null) goto L45;
        XBaseModel r124 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        ((a.c) r124).setStatus("CONTEXT_IS_NULL");
        Unit r125 = Unit.INSTANCE;
        r112.onFailure(0, "Context not provided in host", (XBaseResultModel) r124);
        return;
    L45:
        i.b(this.f563378d, "Get all keys", "BridgeParam", r110.getContainerID());
        long r126 = System.currentTimeMillis();
        if (r115 == false) goto L48;
        Set<String> r127 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r100).a(r102 + "appId_" + r103);
    L49:
        long r128 = System.currentTimeMillis() - r126;
        String r129 = r110.getBridgeCall().d();
        long r130 = r127.size();
        String r131 = r110.getPlatformType().name();
        XBaseModel r132 = XBridgeResultModelArguments.INSTANCE.createModel(a.c.class);
        a.c r133 = (a.c) r132;
        r133.setKeys(CollectionsKt.toList(r127));
        r133.setStatus("READ_SUCCEED");
        r112.onSuccess((XBaseResultModel) r132, "Read keys Succeed.");
        int r134 = com.bytedance.sdk.xbridge.cn.storage.utils.f.f270152a;
        com.bytedance.sdk.xbridge.cn.storage.utils.f.b(r102, r100, r129, r130, this.f563378d, r131, "READ_SUCCEED", r128);
        return;
    L48:
        com.bytedance.sdk.xbridge.cn.storage.utils.c r135 = com.bytedance.sdk.xbridge.cn.storage.utils.g.a(r100);
        Intrinsics.checkNotNull(r102);
        r127 = r135.a(r102);
        goto L49
    L35:
        if (r102.length() == 0) goto L38;
        r104 = false;
        goto L38
    L23:
        r107 = null;
        goto L25
    L9:
        r103 = null;
        goto L10
    L5:
        r115 = false;
        goto L6
    }
}
