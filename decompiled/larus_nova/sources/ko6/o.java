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
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class o extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504490d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.preloadGeckoResource", params = {"channel", "accessKey"}, results = {"result", "errorMsg"})
    public final String f504491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504492c;

    public static final class a {
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
        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = false)
        String getErrorMsg();

        @XBridgeParamField(isGetter = true, keyPath = "result", required = true)
        Boolean getResult();

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = false)
        void setErrorMsg(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "result", required = true)
        void setResult(Boolean r100);
    }

    static {
        f504490d = MapsKt.mapOf(TuplesKt.to("TicketID", "37067"));
    }

    public o() {
        this.f504491b = "localLife.preloadGeckoResource";
        this.f504492c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504492c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504491b;
    }
}
