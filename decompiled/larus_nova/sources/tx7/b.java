package tx7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback;
import com.ivy.ivykit.api.bridge.inject.HostPermissionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements IHostLocationPermissionDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hx7.e f547825a;

    public static final class a implements hx7.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnPermissionGrantCallback f547826a;

        public a(OnPermissionGrantCallback r100) {
            this.f547826a = r100;
        }

        @Override // hx7.i
        public final void onResult(boolean r100, Map<String, ? extends HostPermissionState> r101) {
            Intrinsics.checkNotNullParameter(r101, "result");
            if (r100 == false) goto L5;
            this.f547826a.onAllGranted();
            return;
        L5:
            this.f547826a.onNotGranted();
        }
    }

    public b() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        this.f547825a = (hx7.e) com.ivy.ivykit.api.bridge.b.a(hx7.e.class);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend
    public final void requestPermission(Activity r100, IBDXBridgeContext r101, String r102, OnPermissionGrantCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "callback");
        hx7.e r104 = this.f547825a;
        if (r104 == null) goto L6;
        r104.a(r100, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a(r103));
        return;
    }
}
