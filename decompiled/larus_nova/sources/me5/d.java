package me5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import ie5.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f513484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513485b;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f513486a;

        public b(d r100) {
            this.f513486a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            e r102 = new e();
            r102.f513487a = Boolean.valueOf(r101.a());
            r102.f513488b = Integer.valueOf(r101.getType());
            XBridgeMethod.b r103 = (XBridgeMethod.b) this.f513486a.provideContext(XBridgeMethod.b.class);
            if (r103 == null) goto L6;
            Map r104 = e.a.a(r102);
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            r103.sendJsEvent("ccm.netStateChangedEvent", new f66.d(new JSONObject(r104)));
            return;
        }
    }

    static {
    }

    public d() {
        b r100 = new b(this);
        this.f513484a = r100;
        int r101 = k.f489487a;
        ((ConnectionService) k.a.a(ConnectionService.class)).a().observeForever(r100);
        this.f513485b = "ccm.getNetStatus";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        super.release();
        j.a.f217090a.a().observeForever(this.f513484a);
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f513485b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        ConnectionService.NetworkState r103 = j.a.f217090a.getNetworkState();
        e r104 = new e();
        r104.f513487a = Boolean.valueOf(r103.a());
        r104.f513488b = Integer.valueOf(r103.getType());
        XCoreBridgeMethod.onSuccess$default(this, r101, e.a.a(r104), null, 4, null);
    }
}
