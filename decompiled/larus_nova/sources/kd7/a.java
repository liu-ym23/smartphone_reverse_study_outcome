package kd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f502850c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.checkAppsInfo", params = {"pkg_list"}, results = {"apps_info"})
    public final String f502851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f502852b;

    /* JADX INFO: renamed from: kd7.a$a, reason: collision with other inner class name */
    public static final class C6540a {
    }

    public interface b extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "version_code", required = true)
        String getVersion_code();

        @XBridgeParamField(isGetter = true, keyPath = "version_name", required = true)
        String getVersion_name();

        @XBridgeParamField(isGetter = true, keyPath = "is_install", required = true)
        Number is_install();

        @XBridgeParamField(isGetter = false, keyPath = "version_code", required = true)
        void setVersion_code(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "version_name", required = true)
        void setVersion_name(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "is_install", required = true)
        void set_install(Number r100);
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pkg_list", primitiveClassType = String.class, required = true)
        List<String> getPkg_list();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "apps_info", nestedClassType = b.class, required = true)
        Map<String, b> getApps_info();

        @XBridgeParamField(isGetter = false, keyPath = "apps_info", nestedClassType = b.class, required = true)
        void setApps_info(Map<String, ? extends b> r100);
    }

    static {
        f502850c = MapsKt.mapOf(TuplesKt.to("TicketID", "19346"));
    }

    public a() {
        this.f502851a = "x.checkAppsInfo";
        this.f502852b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f502852b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f502851a;
    }
}
