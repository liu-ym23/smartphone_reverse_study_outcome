package v51;

import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements o {
    public c() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        jy0.b.c("StreamInteractScopeTestService", WidgetCostModule.TYPE_ON_START, null, 4);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        jy0.b.c("StreamInteractScopeTestService", "onEnd", null, 4);
    }
}
