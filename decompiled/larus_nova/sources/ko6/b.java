package ko6;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
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
public abstract class b extends v56.c<InterfaceC6583b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504435d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "enOrDecryptPoiContent", params = {"srcStr", LBSLightLocationTraceLogger.ENCRYPT}, results = {"result"})
    public final String f504436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504437c;

    public static final class a {
    }

    /* JADX INFO: renamed from: ko6.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC6583b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = LBSLightLocationTraceLogger.ENCRYPT, required = true)
        boolean getEncrypt();

        @XBridgeParamField(isGetter = true, keyPath = "srcStr", required = true)
        String getSrcStr();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "result", required = true)
        String getResult();

        @XBridgeParamField(isGetter = false, keyPath = "result", required = true)
        void setResult(String r100);
    }

    static {
        f504435d = MapsKt.mapOf(TuplesKt.to("TicketID", "25452"));
    }

    public b() {
        this.f504436b = "enOrDecryptPoiContent";
        this.f504437c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504437c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504436b;
    }
}
