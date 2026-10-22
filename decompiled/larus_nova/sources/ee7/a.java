package ee7;

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
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f472293c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "x.getGeckoInfo", params = {"accessKey", "channel"}, results = {"needUpdate", "totalSize", "version"})
    public final String f472294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f472295b;

    /* JADX INFO: renamed from: ee7.a$a, reason: collision with other inner class name */
    public static final class C5772a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessKey", required = true)
        String getAccessKey();

        @XBridgeParamField(isGetter = true, keyPath = "channel", required = true)
        String getChannel();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "needUpdate", required = true)
        Boolean getNeedUpdate();

        @XBridgeParamField(isGetter = true, keyPath = "totalSize", required = false)
        Number getTotalSize();

        @XBridgeParamField(isGetter = true, keyPath = "version", required = false)
        String getVersion();

        @XBridgeParamField(isGetter = false, keyPath = "needUpdate", required = true)
        void setNeedUpdate(Boolean r100);

        @XBridgeParamField(isGetter = false, keyPath = "totalSize", required = false)
        void setTotalSize(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "version", required = false)
        void setVersion(String r100);
    }

    static {
        f472293c = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF), TuplesKt.to("UID", "6112433c589a830047ff07b9"), TuplesKt.to("TicketID", "16175")});
    }

    public a() {
        this.f472294a = "x.getGeckoInfo";
        this.f472295b = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f472295b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f472294a;
    }
}
