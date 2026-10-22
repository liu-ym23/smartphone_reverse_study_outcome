package me5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import ie5.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends XCoreBridgeMethod {
    public final b a;
    public final String b;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ConnectionService.NetworkState r6 = (ConnectionService.NetworkState) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            e r0 = new e();
            r0.a = Boolean.valueOf(r6.a());
            r0.b = Integer.valueOf(r6.getType());
            XBridgeMethod.b r7 = (XBridgeMethod.b) this.a.provideContext(XBridgeMethod.b.class);
            if (r7 == null) goto L6;
            Map r1 = e.a.a(r0);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            r7.sendJsEvent("ccm.netStateChangedEvent", new f66.d(new JSONObject(r1)));
            return;
        }
    }

    static {
    }

    public d() {
        b r0 = new b(this);
        this.a = r0;
        int r1 = k.a;
        ((ConnectionService) k.a.a(ConnectionService.class)).a().observeForever(r0);
        this.b = "ccm.getNetStatus";
    }

    public final void release() {
        super.release();
        j.a.a.a().observeForever(this.a);
    }

    public final String getName() {
        return this.b;
    }

    public final void handle(XReadableMap r7, XBridgeMethod.Callback r8, XBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TYPE);
        ConnectionService.NetworkState r10 = j.a.a.getNetworkState();
        e r11 = new e();
        r11.a = Boolean.valueOf(r10.a());
        r11.b = Integer.valueOf(r10.getType());
        XCoreBridgeMethod.onSuccess$default(this, r8, e.a.a(r11), null, 4, null);
    }
}
