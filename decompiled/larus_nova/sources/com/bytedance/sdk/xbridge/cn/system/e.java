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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class e extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270183c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getLocation", params = {""}, results = {"enable", "latitude", "longitude"})
    public final String f270184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.SECURE)
    public final IDLXBridgeMethod.Access f270185b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "enable", required = true)
        Boolean getEnable();

        @XBridgeParamField(isGetter = true, keyPath = "latitude", required = false)
        Number getLatitude();

        @XBridgeParamField(isGetter = true, keyPath = "longitude", required = false)
        Number getLongitude();

        @XBridgeParamField(isGetter = false, keyPath = "enable", required = true)
        void setEnable(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "latitude", required = false)
        void setLatitude(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "longitude", required = false)
        void setLongitude(Number r100);
    }

    static {
        f270183c = MapsKt.mapOf(TuplesKt.to("TicketID", "24348"));
    }

    public e() {
        this.f270184a = "x.getLocation";
        this.f270185b = IDLXBridgeMethod.Access.SECURE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270185b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270184a;
    }
}
