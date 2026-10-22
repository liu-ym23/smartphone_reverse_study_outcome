package qo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
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

/* JADX INFO: loaded from: classes21.dex */
public abstract class a extends XCoreIDLBridgeMethod<InterfaceC7373a, b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534182c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "atomicTask.changeUIComponentState", params = {"ui_component_id", "ui_component_type", "action", "page_type", "cold_limit", "nearbyPageType", "checkInGrouponTab", "waitToMeetCondition", "maxTryTimes", "extraParam"}, results = {"action_code", "isInGrouponTab", "hasRetry"})
    public final String f534183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534184b;

    /* JADX INFO: renamed from: qo6.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7373a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "action", required = true)
        String getAction();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "false", type = DefaultType.STRING), isGetter = true, keyPath = "checkInGrouponTab", required = false)
        boolean getCheckInGrouponTab();

        @XBridgeParamField(isGetter = true, keyPath = "cold_limit", required = false)
        Boolean getColdLimit();

        @XBridgeParamField(isGetter = true, keyPath = "extraParam", required = false)
        Object getExtraParam();

        @XBridgeParamField(isGetter = true, keyPath = "maxTryTimes", required = false)
        Number getMaxTryTimes();

        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(intValue = 1, type = DefaultType.INT), isGetter = true, keyPath = "nearbyPageType", required = false)
        Number getNearbyPageType();

        @XBridgeParamField(isGetter = true, keyPath = "page_type", required = true)
        String getPageType();

        @XBridgeParamField(isGetter = true, keyPath = "ui_component_id", required = true)
        String getUiComponentId();

        @XBridgeParamField(isGetter = true, keyPath = "ui_component_type", required = true)
        String getUiComponentType();

        @XBridgeParamField(isGetter = true, keyPath = "waitToMeetCondition", required = false)
        Boolean getWaitToMeetCondition();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "action_code", required = false)
        Number getActionCode();

        @XBridgeParamField(isGetter = true, keyPath = "hasRetry", required = false)
        Boolean getHasRetry();

        @XBridgeParamField(isGetter = true, keyPath = "isInGrouponTab", required = false)
        Boolean isInGrouponTab();

        @XBridgeParamField(isGetter = false, keyPath = "action_code", required = false)
        void setActionCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "hasRetry", required = false)
        void setHasRetry(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "isInGrouponTab", required = false)
        void setInGrouponTab(Boolean r100);
    }

    public static final class c {
    }

    static {
        f534182c = MapsKt.mapOf(TuplesKt.to("TicketID", "41154"));
    }

    public a() {
        this.f534183a = "atomicTask.changeUIComponentState";
        this.f534184b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534184b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534183a;
    }
}
