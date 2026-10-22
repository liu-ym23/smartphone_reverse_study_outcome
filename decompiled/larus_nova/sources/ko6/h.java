package ko6;

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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class h extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504470d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "getExtraRequestParams", results = {"code", "params_str"})
    public final String f504471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504472c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "params_str", required = true)
        String getParams_str();

        @XBridgeParamField(isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "params_str", required = true)
        void setParams_str(String r100);
    }

    static {
        f504470d = MapsKt.mapOf(new Pair[]{TuplesKt.to("IDLVersion", "1000"), TuplesKt.to("UID", "6188ea0c93aa6600488662b5"), TuplesKt.to("TicketID", "15277")});
    }

    public h() {
        this.f504471b = "getExtraRequestParams";
        this.f504472c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504472c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504471b;
    }
}
