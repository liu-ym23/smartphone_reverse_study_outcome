package yu6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b extends v56.c<InterfaceC8390b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f569232d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "postLiveLifeMsg", params = {"eventName", "extra", "params"}, results = {"data"})
    public final String f569233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f569234c;

    public static final class a {
    }

    /* JADX INFO: renamed from: yu6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8390b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "extra", required = false)
        Map<String, Object> getExtra();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = false)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = false, keyPath = "data", required = false)
        void setData(Map<String, ? extends Object> r100);
    }

    static {
        f569232d = MapsKt.mapOf(TuplesKt.to("TicketID", "28766"));
    }

    public b() {
        this.f569233b = "postLiveLifeMsg";
        this.f569234c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f569234c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f569233b;
    }
}
