package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC3777c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270177c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.checkPermissionV2", params = {"permission", "accessLevel"}, results = {"status"})
    public final String f270178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f270179b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeStringEnum(option = {"readOnly", "readWrite", "writeOnly"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "accessLevel", required = false)
        String getAccessLevel();

        @XBridgeStringEnum(option = {"calendar", "camera", "contacts", "fine_location", "location", "microphone", "notification", "photoAlbum", "read_calendar", "vibrate", "write_calendar"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "permission", required = true)
        String getPermission();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.system.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC3777c extends XBaseResultModel {
        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "status", required = true)
        String getStatus();

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "status", required = true)
        void setStatus(String r100);
    }

    static {
        f270177c = MapsKt.mapOf(TuplesKt.to("TicketID", "34690"));
    }

    public c() {
        this.f270178a = "x.checkPermissionV2";
        this.f270179b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270179b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270178a;
    }
}
