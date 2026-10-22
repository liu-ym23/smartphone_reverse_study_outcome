package u16;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
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

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f548295c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.predefineMonitor", params = {"group", "timeCull", "feDuration", "schemaPkgs", "schemaPkgNum", "predefinePkgs", "predefinePkgNum", "predefineState", "extra"}, results = {"code"})
    public final String f548296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f548297b;

    /* JADX INFO: renamed from: u16.a$a, reason: collision with other inner class name */
    public static final class C7820a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "extra", required = false)
        String getExtra();

        @XBridgeParamField(isGetter = true, keyPath = "feDuration", required = true)
        Number getFeDuration();

        @XBridgeParamField(isGetter = true, keyPath = "group", required = true)
        String getGroup();

        @XBridgeParamField(isGetter = true, keyPath = "predefinePkgNum", required = true)
        Number getPredefinePkgNum();

        @XBridgeParamField(isGetter = true, keyPath = "predefinePkgs", required = true)
        String getPredefinePkgs();

        @XBridgeParamField(isGetter = true, keyPath = "predefineState", required = true)
        String getPredefineState();

        @XBridgeParamField(isGetter = true, keyPath = "schemaPkgNum", required = true)
        Number getSchemaPkgNum();

        @XBridgeParamField(isGetter = true, keyPath = "schemaPkgs", required = true)
        String getSchemaPkgs();

        @XBridgeParamField(isGetter = true, keyPath = "timeCull", required = true)
        String getTimeCull();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number r100);
    }

    static {
        f548295c = MapsKt.mapOf(TuplesKt.to("TicketID", "34174"));
    }

    public a() {
        this.f548296a = "x.predefineMonitor";
        this.f548297b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f548297b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f548296a;
    }
}
