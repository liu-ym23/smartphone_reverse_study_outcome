package defpackage;

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

/* JADX INFO: loaded from: classes42.dex */
public abstract class d extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f466139d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localLife.addPageParamMonitor", params = {"pageName", "pageSessionId", "pageParamType", "paramsJsonStr"}, results = {"success"})
    public final String f466140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f466141c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pageName", required = true)
        String getPageName();

        @XBridgeParamField(isGetter = true, keyPath = "pageParamType", required = true)
        String getPageParamType();

        @XBridgeParamField(isGetter = true, keyPath = "pageSessionId", required = true)
        String getPageSessionId();

        @XBridgeParamField(isGetter = true, keyPath = "paramsJsonStr", required = true)
        String getParamsJsonStr();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        Number getSuccess();

        @XBridgeParamField(isGetter = false, keyPath = "success", required = true)
        void setSuccess(Number r100);
    }

    static {
        f466139d = MapsKt.mapOf(TuplesKt.to("TicketID", "40756"));
    }

    public d() {
        this.f466140b = "localLife.addPageParamMonitor";
        this.f466141c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f466141c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f466140b;
    }
}
