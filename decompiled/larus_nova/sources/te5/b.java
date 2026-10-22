package te5;

import android.webkit.ValueCallback;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.bear.lynx.api.g;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545574a;

    public static final class a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f545575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f545576b;

        public a(b r100, XBridgeMethod.Callback r101) {
            this.f545575a = r100;
            this.f545576b = r101;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            XCoreBridgeMethod.onSuccess$default(this.f545575a, this.f545576b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data", (String) r100)}), null, 4, null);
        }
    }

    public b() {
        this.f545574a = "ccm.callJSMethod";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f545574a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        g r103 = (g) provideContext(g.class);
        if (r103 == null) goto L6;
        r103.b(r100.getString(e.f25671s), r100.getString("params"), new a(this, r101));
        return;
    }
}
