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
public abstract class d0 extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504449d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "sendPoiLog", params = {"eventName", "params", "btm", "enter_new_page", "add_btm_chain", "chain_length"})
    public final String f504450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504451c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "add_btm_chain", required = false)
        Boolean getAddBtmChain();

        @XBridgeParamField(isGetter = true, keyPath = "btm", required = false)
        String getBtm();

        @XBridgeParamField(isGetter = true, keyPath = "chain_length", required = false)
        Number getChainLength();

        @XBridgeParamField(isGetter = true, keyPath = "enter_new_page", required = false)
        Boolean getEnterNewPage();

        @XBridgeParamField(isGetter = true, keyPath = "eventName", required = true)
        String getEventName();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = true)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
        f504449d = MapsKt.mapOf(TuplesKt.to("TicketID", "20151"));
    }

    public d0() {
        this.f504450b = "sendPoiLog";
        this.f504451c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504451c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504450b;
    }
}
