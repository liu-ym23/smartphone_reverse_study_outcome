package mt6;

import com.bytedance.locallife.hybrid.bridge.a0;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;

/* JADX INFO: loaded from: classes21.dex */
public abstract class c implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f515648a;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return this instanceof a0;
    }

    public c() {
        this.f515648a = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f515648a;
    }
}
