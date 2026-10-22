package qf3;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class c implements IDLXBridgeMethod {
    public final IDLXBridgeMethod.Access a;
    public final IDLXBridgeMethod.Compatibility b;

    public static final class a {
    }

    static {
    }

    public boolean canRunInBackground() {
        return this instanceof com.bytedance.android.shopping.mall.feed.jsb.i;
    }

    public c() {
        this.a = IDLXBridgeMethod.Access.PUBLIC;
        this.b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.a;
    }

    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.b;
    }

    public static void b(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        r2.put("error_code", -100);
        r2.put("error_info", String.valueOf(b0.k(r3)));
    }

    public final void a(Map<String, ? extends Object> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "result");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.g(r2, r3, getName());
    }
}
