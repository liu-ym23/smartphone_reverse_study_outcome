package qo6;

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

/* JADX INFO: loaded from: classes21.dex */
public abstract class e extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534194c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "getTopTabChannelsInfo", params = {"pageType", "popupType"}, results = {"isNearbyTabShow", "channelsInfo", "isNearbyDual", "nearbyTabName", "currentSceneL1", "isInSearch", "isGrouponTabVisible", "isGrouponSinglePageVisible", "popUpCanShow"})
    public final String f534195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534196b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pageType", required = false)
        Number getPageType();

        @XBridgeParamField(isGetter = true, keyPath = "popupType", required = false)
        Number getPopupType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "channelsInfo", nestedClassType = d.class, required = true)
        List<d> getChannelsInfo();

        @XBridgeParamField(isGetter = true, keyPath = "currentSceneL1", required = true)
        String getCurrentSceneL1();

        @XBridgeParamField(isGetter = true, keyPath = "nearbyTabName", required = true)
        String getNearbyTabName();

        @XBridgeParamField(isGetter = true, keyPath = "popUpCanShow", required = false)
        Boolean getPopUpCanShow();

        @XBridgeParamField(isGetter = true, keyPath = "isGrouponSinglePageVisible", required = false)
        Boolean isGrouponSinglePageVisible();

        @XBridgeParamField(isGetter = true, keyPath = "isGrouponTabVisible", required = false)
        Boolean isGrouponTabVisible();

        @XBridgeParamField(isGetter = true, keyPath = "isInSearch", required = true)
        Boolean isInSearch();

        @XBridgeParamField(isGetter = true, keyPath = "isNearbyDual", required = true)
        Boolean isNearbyDual();

        @XBridgeParamField(isGetter = true, keyPath = "isNearbyTabShow", required = true)
        Boolean isNearbyTabShow();

        @XBridgeParamField(isGetter = false, keyPath = "channelsInfo", nestedClassType = d.class, required = true)
        void setChannelsInfo(List<? extends d> r100);

        @XBridgeParamField(isGetter = false, keyPath = "currentSceneL1", required = true)
        void setCurrentSceneL1(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "isGrouponSinglePageVisible", required = false)
        void setGrouponSinglePageVisible(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "isGrouponTabVisible", required = false)
        void setGrouponTabVisible(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "isInSearch", required = true)
        void setInSearch(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "isNearbyDual", required = true)
        void setNearbyDual(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "nearbyTabName", required = true)
        void setNearbyTabName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "isNearbyTabShow", required = true)
        void setNearbyTabShow(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "popUpCanShow", required = false)
        void setPopUpCanShow(Boolean r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "id", required = true)
        String getId();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = true)
        String getTitle();

        @XBridgeParamField(isGetter = false, keyPath = "id", required = true)
        void setId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "title", required = true)
        void setTitle(String r100);
    }

    static {
        f534194c = MapsKt.mapOf(TuplesKt.to("TicketID", "32244"));
    }

    public e() {
        this.f534195a = "getTopTabChannelsInfo";
        this.f534196b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534196b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534195a;
    }
}
