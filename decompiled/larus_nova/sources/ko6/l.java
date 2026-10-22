package ko6;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeMethodName;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.annotation.XBridgePermission;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;

/* JADX INFO: loaded from: classes21.dex */
public abstract class l extends v56.c<a, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgeMethodName(name = "lightnavi.initNavigation", params = {""})
    public final String f504482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f504483c;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    public l() {
        this.f504482b = "lightnavi.initNavigation";
        this.f504483c = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f504483c;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return this.f504482b;
    }
}
