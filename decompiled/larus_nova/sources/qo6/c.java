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
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC7375c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f534188c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "getLifeTransParentParams", params = {"pageType"}, results = {"diamondTrackParams", "feedTrackParams", "commonTransInfo"})
    public final String f534189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f534190b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pageType", required = true)
        Number getPageType();
    }

    /* JADX INFO: renamed from: qo6.c$c, reason: collision with other inner class name */
    @XBridgeResultModel
    public interface InterfaceC7375c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "commonTransInfo", required = false)
        String getCommonTransInfo();

        @XBridgeParamField(isGetter = true, keyPath = "diamondTrackParams", required = false)
        String getDiamondTrackParams();

        @XBridgeParamField(isGetter = true, keyPath = "feedTrackParams", required = false)
        String getFeedTrackParams();

        @XBridgeParamField(isGetter = false, keyPath = "commonTransInfo", required = false)
        void setCommonTransInfo(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "diamondTrackParams", required = false)
        void setDiamondTrackParams(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "feedTrackParams", required = false)
        void setFeedTrackParams(String r100);
    }

    static {
        f534188c = MapsKt.mapOf(TuplesKt.to("TicketID", "34140"));
    }

    public c() {
        this.f534189a = "getLifeTransParentParams";
        this.f534190b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f534190b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f534189a;
    }
}
