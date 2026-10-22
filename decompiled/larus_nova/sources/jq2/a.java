package jq2;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements n97.a, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // n97.a
    public final void g(String r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r103, "category");
        Intrinsics.checkNotNullParameter(r104, "metric");
        Intrinsics.checkNotNullParameter(r105, "extraLog");
        LiveTracingMonitor.g(r100, r101, r102, r103, r104, r105);
    }
}
