package jd7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC6419b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f498648c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.login", params = {PerfLog.PARAM_KEY_CONTEXT_ID, "keepOpen"}, results = {"status", "alreadyLoggedIn"})
    public final String f498649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f498650b;

    public static final class a {
    }

    /* JADX INFO: renamed from: jd7.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC6419b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = false)
        Map<String, Object> getContext();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), isGetter = true, keyPath = "keepOpen", required = false)
        boolean getKeepOpen();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "alreadyLoggedIn", required = false)
        Boolean getAlreadyLoggedIn();

        @XBridgeStringEnum(option = {"cancelled", "loggedIn"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "status", required = true)
        String getStatus();

        @XBridgeParamField(isGetter = false, keyPath = "alreadyLoggedIn", required = false)
        void setAlreadyLoggedIn(Boolean r100);

        @XBridgeStringEnum(option = {"cancelled", "loggedIn"})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "status", required = true)
        void setStatus(String r100);
    }

    static {
        f498648c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1006"), TuplesKt.to("UID", "61093d7037e39f003e7cc38d"), TuplesKt.to("TicketID", "15529")});
    }

    public b() {
        this.f498649a = "x.login";
        this.f498650b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f498650b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f498649a;
    }
}
