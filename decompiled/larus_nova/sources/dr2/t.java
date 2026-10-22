package dr2;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;

/* JADX INFO: loaded from: classes11.dex */
public final class t implements com.bytedance.android.scope.o, g {
    public t() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // dr2.g
    public final IHostPerformanceMonitor Df() {
        return TTLiveSDK.hostService().hostPerformanceMonitor();
    }
}
