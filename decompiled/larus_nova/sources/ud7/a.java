package ud7;

import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f549738c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.batchEvents", params = {ReportConstant.COMMON_ACTION_TYPE, ActionList.ELEM_NAME})
    public final String f549739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f549740b;

    /* JADX INFO: renamed from: ud7.a$a, reason: collision with other inner class name */
    public static final class C7864a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = ActionList.ELEM_NAME, nestedClassType = d.class, required = true)
        List<d> getActionList();

        @XBridgeStringEnum(option = {PTYSocketStateCallback.CLOSED})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = ReportConstant.COMMON_ACTION_TYPE, required = true)
        String getActionType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "methodName", required = true)
        String getMethodName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = true)
        Map<String, Object> getParams();
    }

    static {
        f549738c = MapsKt.mapOf(TuplesKt.to("TicketID", "16578"));
    }

    public a() {
        this.f549739a = "x.batchEvents";
        this.f549740b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f549740b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f549739a;
    }
}
