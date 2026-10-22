package ko6;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class p extends v56.c<b, c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f504493d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "localServiceOptimizationStrategy", params = {"bizCode", "preCacheList", "preload", "preDownload", "jato"}, results = {"errorMsg"})
    public final String f504494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504495c;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "bizCode", required = false)
        String getBizCode();

        @XBridgeParamField(isGetter = true, keyPath = "jato", nestedClassType = d.class, required = false)
        d getJato();

        @XBridgeParamField(isGetter = true, keyPath = "preCacheList", nestedClassType = e.class, required = false)
        List<e> getPreCacheList();

        @XBridgeParamField(isGetter = true, keyPath = "preDownload", primitiveClassType = String.class, required = false)
        List<String> getPreDownload();

        @XBridgeParamField(isGetter = true, keyPath = "preload", primitiveClassType = String.class, required = false)
        List<String> getPreload();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = false)
        String getErrorMsg();

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = false)
        void setErrorMsg(String r100);
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "duration", required = false)
        Number getDuration();

        @XBridgeParamField(isGetter = true, keyPath = "enableBlockGC", required = false)
        Boolean getEnableBlockGC();

        @XBridgeParamField(isGetter = true, keyPath = "enableCloseClassVerify", required = false)
        Boolean getEnableCloseClassVerify();

        @XBridgeParamField(isGetter = true, keyPath = "enableJato", required = false)
        Boolean getEnableJato();
    }

    public interface e extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "name", required = true)
        String getName();

        @XBridgeParamField(isGetter = true, keyPath = "page", required = true)
        String getPage();

        @XBridgeParamField(isGetter = true, keyPath = BdpAppEventConstant.PARAMS_STRATEGY_NAME, primitiveClassType = String.class, required = true)
        List<String> getStrategy();
    }

    static {
        f504493d = MapsKt.mapOf(TuplesKt.to("TicketID", "28682"));
    }

    public p() {
        this.f504494b = "localServiceOptimizationStrategy";
        this.f504495c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504495c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504494b;
    }
}
