package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b0 extends v56.c<b, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504438d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "poiOpenPreviewPage", params = {"traceSessionId", "logParams", "defaultIndex", "scene", "data", "uniqueId", "useDefaultBounce"})
    public final String f504439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504440c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "data", required = false)
        Map<String, Object> getData();

        @XBridgeParamField(isGetter = true, keyPath = "defaultIndex", required = false)
        Number getDefaultIndex();

        @XBridgeParamField(isGetter = true, keyPath = "logParams", required = false)
        Map<String, Object> getLogParams();

        @XBridgeParamField(isGetter = true, keyPath = "scene", required = true)
        String getScene();

        @XBridgeParamField(isGetter = true, keyPath = "traceSessionId", required = true)
        String getTraceSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "uniqueId", required = false)
        String getUniqueId();

        @XBridgeParamField(isGetter = true, keyPath = "useDefaultBounce", required = false)
        Boolean getUseDefaultBounce();
    }

    static {
        f504438d = MapsKt.mapOf(TuplesKt.to("TicketID", "32744"));
    }

    public b0() {
        this.f504439b = "poiOpenPreviewPage";
        this.f504440c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504440c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504439b;
    }
}
