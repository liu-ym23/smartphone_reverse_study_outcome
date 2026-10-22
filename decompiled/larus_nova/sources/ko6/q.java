package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
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
public abstract class q extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504496d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.genericPerfAction", params = {"scene", "subScene", "point", "businessParams"}, results = {"code", "msg"})
    public final String f504497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504498c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "businessParams", required = true)
        Map<String, Object> getBusinessParams();

        @XBridgeParamField(isGetter = true, keyPath = "point", required = true)
        String getPoint();

        @XBridgeParamField(isGetter = true, keyPath = "scene", required = true)
        String getScene();

        @XBridgeParamField(isGetter = true, keyPath = "subScene", required = true)
        String getSubScene();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "msg", required = false)
        String getMsg();

        @XBridgeIntEnum(option = {1, 0, -1, -2})
        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        void setCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = false)
        void setMsg(String r100);
    }

    static {
        f504496d = MapsKt.mapOf(TuplesKt.to("TicketID", "39661"));
    }

    public q() {
        this.f504497b = "localLife.genericPerfAction";
        this.f504498c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504498c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504497b;
    }
}
