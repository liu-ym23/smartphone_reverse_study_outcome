package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.annotation.XBridgeResultModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;

/* JADX INFO: loaded from: classes21.dex */
public abstract class w extends v56.c<a, b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "openThirdMapDialog", params = {"latitude", "longitude", "travel_method", "address", "latitude_gcj", "longitude_gcj"})
    public final String f504514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PROTECT)
    public final IDLXBridgeMethod.Access f504515c;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "address", required = false)
        String getAddress();

        @XBridgeParamField(isGetter = true, keyPath = "latitude", required = false)
        Number getLatitude();

        @XBridgeParamField(isGetter = true, keyPath = "latitude_gcj", required = false)
        Number getLatitudeGcj();

        @XBridgeParamField(isGetter = true, keyPath = "longitude", required = false)
        Number getLongitude();

        @XBridgeParamField(isGetter = true, keyPath = "longitude_gcj", required = false)
        Number getLongitudeGcj();

        @XBridgeParamField(isGetter = true, keyPath = "travel_method", required = false)
        String getTravelMethod();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public w() {
        this.f504514b = "openThirdMapDialog";
        this.f504515c = IDLXBridgeMethod.Access.PROTECT;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504515c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504514b;
    }
}
