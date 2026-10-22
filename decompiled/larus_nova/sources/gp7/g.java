package gp7;

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
public abstract class g extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f482119c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "upc.getSystemAuthorityStatus", params = {"authorityList"}, results = {"authorityResultList"})
    public final String f482120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f482121b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityList", nestedClassType = d.class, required = true)
        List<d> getAuthorityList();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityResultList", nestedClassType = e.class, required = true)
        List<e> getAuthorityResultList();

        @XBridgeParamField(isGetter = false, keyPath = "authorityResultList", nestedClassType = e.class, required = true)
        void setAuthorityResultList(List<? extends e> r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "type", required = true)
        String getType();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "authorityType", required = false)
        String getAuthorityType();

        @XBridgeParamField(isGetter = true, keyPath = "privacyType", required = false)
        String getPrivacyType();

        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();

        @XBridgeParamField(isGetter = true, keyPath = "status", required = true)
        Number getStatus();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = true)
        String getType();

        @XBridgeParamField(isGetter = false, keyPath = "authorityType", required = false)
        void setAuthorityType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "privacyType", required = false)
        void setPrivacyType(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "schema", required = true)
        void setSchema(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "status", required = true)
        void setStatus(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "type", required = true)
        void setType(String r100);
    }

    static {
        f482119c = MapsKt.mapOf(TuplesKt.to("TicketID", "21578"));
    }

    public g() {
        this.f482120a = "upc.getSystemAuthorityStatus";
        this.f482121b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f482121b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f482120a;
    }
}
