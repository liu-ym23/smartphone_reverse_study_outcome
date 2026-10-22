package yu6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeModelExtension;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f569229d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "openLiveLifeGrouponPage", params = {"page_source", "page_type", "params"})
    public final String f569230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f569231c;

    /* JADX INFO: renamed from: yu6.a$a, reason: collision with other inner class name */
    public static final class C8389a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "page_source", required = true)
        String getPageSource();

        @XBridgeParamField(isGetter = true, keyPath = "page_type", required = true)
        Number getPageType();

        @XBridgeParamField(isGetter = true, keyPath = "params", nestedClassType = d.class, required = false)
        d getParams();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "coupon_ids", required = false)
        String getCouponIds();

        @XBridgeParamField(isGetter = true, keyPath = "extra_request_params", required = false)
        String getExtraRequestParams();

        @XBridgeParamField(isGetter = true, keyPath = "from_position", required = false)
        String getFromPosition();
    }

    static {
        f569229d = MapsKt.mapOf(TuplesKt.to("TicketID", "20863"));
    }

    public a() {
        this.f569230b = "openLiveLifeGrouponPage";
        this.f569231c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f569231c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f569230b;
    }
}
