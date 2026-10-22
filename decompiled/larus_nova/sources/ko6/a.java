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
public abstract class a extends v56.c<InterfaceC6582a, b> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504429d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "calculateFmp", params = {"containerInitTime", "page", "autoReport", "extraTrackParams"}, results = {"fmp", "type"})
    public final String f504430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504431c;

    /* JADX INFO: renamed from: ko6.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC6582a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "autoReport", required = false)
        Boolean getAutoReport();

        @XBridgeParamField(isGetter = true, keyPath = "containerInitTime", required = true)
        Number getContainerInitTime();

        @XBridgeParamField(isGetter = true, keyPath = "extraTrackParams", required = false)
        Map<String, Object> getExtraTrackParams();

        @XBridgeParamField(isGetter = true, keyPath = "page", required = false)
        String getPage();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "fmp", required = false)
        Number getFmp();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = false)
        Number getType();

        @XBridgeParamField(isGetter = false, keyPath = "fmp", required = false)
        void setFmp(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "type", required = false)
        void setType(Number r100);
    }

    public static final class c {
    }

    static {
        f504429d = MapsKt.mapOf(TuplesKt.to("TicketID", "31299"));
    }

    public a() {
        this.f504430b = "calculateFmp";
        this.f504431c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504431c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504430b;
    }
}
