package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC3776b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270174c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.allowCaptureScreen", params = {"allow"}, results = {""})
    public final String f270175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f270176b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.system.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC3776b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "allow", required = true)
        boolean getAllow();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f270174c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1000"), TuplesKt.to("UID", "61c0628ff4c2890049781f3a"), TuplesKt.to("TicketID", "16552")});
    }

    public b() {
        this.f270175a = "x.allowCaptureScreen";
        this.f270176b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270176b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270175a;
    }
}
