package he7;

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
import com.flow.performance.perftag.LocationPermissionStateTagValue;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f484886c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.requestPermission", params = {"permission", "showAlert", "accessLevel"}, results = {"status", "location_status"})
    public final String f484887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f484888b;

    /* JADX INFO: renamed from: he7.a$a, reason: collision with other inner class name */
    public static final class C6133a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeStringEnum(option = {"readOnly", "readWrite", "writeOnly"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "accessLevel", required = false)
        String getAccessLevel();

        @XBridgeStringEnum(option = {"calendar", "camera", "contacts", "fine_location", "location", "microphone", "notification", "photoAlbum", "read_calendar", "vibrate", "write_calendar"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "permission", required = true)
        String getPermission();

        @XBridgeParamField(isGetter = true, keyPath = "showAlert", required = false)
        Boolean getShowAlert();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeStringEnum(option = {LocationPermissionStateTagValue.COARSE, "failed", LocationPermissionStateTagValue.FINE, "unknown"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "location_status", required = true)
        String getLocationStatus();

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "status", required = true)
        String getStatus();

        @XBridgeStringEnum(option = {LocationPermissionStateTagValue.COARSE, "failed", LocationPermissionStateTagValue.FINE, "unknown"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "location_status", required = true)
        void setLocationStatus(String r100);

        @XBridgeStringEnum(option = {"denied", "permitted", "restricted", "undetermined"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "status", required = true)
        void setStatus(String r100);
    }

    static {
        f484886c = MapsKt.mapOf(TuplesKt.to("TicketID", "34627"));
    }

    public a() {
        this.f484887a = "x.requestPermission";
        this.f484888b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f484888b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f484887a;
    }
}
