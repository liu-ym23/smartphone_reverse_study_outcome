package qf3;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class c implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f532720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f532721b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return this instanceof com.bytedance.android.shopping.mall.feed.jsb.i;
    }

    public c() {
        this.f532720a = IDLXBridgeMethod.Access.PUBLIC;
        this.f532721b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f532720a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f532721b;
    }

    public static void b(Map r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        r100.put("error_code", -100);
        r100.put(MapMonitorConst.ERROR_INFO, String.valueOf(b0.k(r101)));
    }

    public final void a(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.g(r100, r101, getName());
    }
}
