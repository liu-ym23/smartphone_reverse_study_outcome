package qo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC7374b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534185c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "getGrouponTargetViewPosition", params = {EventConstant.Key.MODULE, "entranceName", "targetView", "cardType", "pageType", "area"}, results = {"top", "left", "width", "height", "feedScrollDy", "feedScrolling", "entranceCovered"})
    public final String f534186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534187b;

    public static final class a {
    }

    /* JADX INFO: renamed from: qo6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC7374b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "area", required = false)
        String getArea();

        @XBridgeParamField(isGetter = true, keyPath = "cardType", required = false)
        Number getCardType();

        @XBridgeParamField(isGetter = true, keyPath = "entranceName", required = true)
        String getEntranceName();

        @XBridgeParamField(isGetter = true, keyPath = EventConstant.Key.MODULE, required = true)
        String getModule();

        @XBridgeParamField(isGetter = true, keyPath = "pageType", required = true)
        Number getPageType();

        @XBridgeParamField(isGetter = true, keyPath = "targetView", required = false)
        String getTargetView();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "entranceCovered", required = false)
        Boolean getEntranceCovered();

        @XBridgeParamField(isGetter = true, keyPath = "feedScrollDy", required = false)
        Number getFeedScrollDy();

        @XBridgeParamField(isGetter = true, keyPath = "feedScrolling", required = false)
        Boolean getFeedScrolling();

        @XBridgeParamField(isGetter = true, keyPath = "height", required = true)
        Number getHeight();

        @XBridgeParamField(isGetter = true, keyPath = "left", required = true)
        Number getLeft();

        @XBridgeParamField(isGetter = true, keyPath = "top", required = true)
        Number getTop();

        @XBridgeParamField(isGetter = true, keyPath = "width", required = true)
        Number getWidth();

        @XBridgeParamField(isGetter = false, keyPath = "entranceCovered", required = false)
        void setEntranceCovered(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "feedScrollDy", required = false)
        void setFeedScrollDy(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "feedScrolling", required = false)
        void setFeedScrolling(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "height", required = true)
        void setHeight(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "left", required = true)
        void setLeft(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "top", required = true)
        void setTop(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "width", required = true)
        void setWidth(Number r100);
    }

    static {
        f534185c = MapsKt.mapOf(TuplesKt.to("TicketID", "37704"));
    }

    public b() {
        this.f534186a = "getGrouponTargetViewPosition";
        this.f534187b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534187b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534186a;
    }
}
