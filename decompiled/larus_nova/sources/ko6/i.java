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
public abstract class i extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504473d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "get_live_float_window_bottom_margin", params = {""}, results = {"bottomMargin"})
    public final String f504474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504475c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "bottomMargin", required = true)
        Number getBottomMargin();

        @XBridgeParamField(isGetter = false, keyPath = "bottomMargin", required = true)
        void setBottomMargin(Number r100);
    }

    static {
        f504473d = MapsKt.mapOf(TuplesKt.to("TicketID", "28928"));
    }

    public i() {
        this.f504474b = "get_live_float_window_bottom_margin";
        this.f504475c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504475c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504474b;
    }
}
