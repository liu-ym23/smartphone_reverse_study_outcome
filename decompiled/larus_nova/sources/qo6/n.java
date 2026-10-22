package qo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class n extends XCoreIDLBridgeMethod<b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534221c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.lifeGrouponCacheJSB", params = {"action", "schema", "checkParams", "cacheData", "keyExtraParams"}, results = {"cacheData"})
    public final String f534222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534223b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(intValue = 1, type = DefaultType.INT), isGetter = true, keyPath = "action", required = true)
        Number getAction();

        @XBridgeParamField(isGetter = true, keyPath = "cacheData", required = false)
        String getCacheData();

        @XBridgeParamField(isGetter = true, keyPath = "checkParams", primitiveClassType = String.class, required = false)
        List<String> getCheckParams();

        @XBridgeParamField(isGetter = true, keyPath = "keyExtraParams", primitiveClassType = String.class, required = false)
        List<String> getKeyExtraParams();

        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();
    }

    static {
        f534221c = MapsKt.mapOf(TuplesKt.to("TicketID", "38303"));
    }

    public n() {
        this.f534222a = "localLife.lifeGrouponCacheJSB";
        this.f534223b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534223b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534222a;
    }
}
