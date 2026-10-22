package yn6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends f {
    private IBDXBridgeContext bridgeContextRef;
    private e callbackRef;
    private AtomicInteger cnt;
    private String domain;
    private String key;

    public final void d() {
        this.callbackRef = null;
        this.bridgeContextRef = null;
    }

    public final String toString() {
        return "XBridgeLifeStorageUpdateCallbackProvider(cnt=" + this.cnt + ", domain=" + this.domain + ", key=" + this.key + ", callbackRef=" + this.callbackRef + ", bridgeContextRef=" + this.bridgeContextRef + ')';
    }

    public final AtomicInteger e() {
        return this.cnt;
    }

    public g(so6.d.a.C7634a r100, IBDXBridgeContext r101) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        super(new WeakReference(r100));
        this.cnt = new AtomicInteger(0);
        this.callbackRef = r100;
        this.bridgeContextRef = r101;
    }
}
