package ko6;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class s extends XCoreIDLBridgeMethod<b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504502c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "openCardOCR", params = {com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "direction", "ban_scan", "ban_camera", "ban_album"}, results = {"result", "status", "from"})
    public final String f504503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504504b;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "ban_album", required = false)
        Boolean getBanAlbum();

        @XBridgeParamField(isGetter = true, keyPath = "ban_camera", required = false)
        Boolean getBanCamera();

        @XBridgeParamField(isGetter = true, keyPath = "ban_scan", required = false)
        Boolean getBanScan();

        @XBridgeParamField(isGetter = true, keyPath = com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, required = true)
        Number getCardType();

        @XBridgeParamField(isGetter = true, keyPath = "direction", required = false)
        Number getDirection();
    }

    static {
        f504502c = MapsKt.mapOf(TuplesKt.to("TicketID", "31891"));
    }

    public s() {
        this.f504503a = "openCardOCR";
        this.f504504b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504504b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f504503a;
    }
}
