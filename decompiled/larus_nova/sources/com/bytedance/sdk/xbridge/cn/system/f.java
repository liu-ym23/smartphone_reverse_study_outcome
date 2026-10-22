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
public abstract class f extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f270186c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.openPermissionSettings", params = {"permission", "accessLevel"}, results = {"status"})
    public final String f270187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f270188b;

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

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "status", required = true)
        String getStatus();

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "status", required = true)
        void setStatus(String r100);
    }

    static {
        f270186c = MapsKt.mapOf(TuplesKt.to("TicketID", "34886"));
    }

    public f() {
        this.f270187a = "x.openPermissionSettings";
        this.f270188b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f270188b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f270187a;
    }
}
