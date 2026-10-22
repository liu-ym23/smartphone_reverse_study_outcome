package lq2;

import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends BasePerformanceStrategyTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f510287a;

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final boolean onTriggerEnhance(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        Intrinsics.checkNotNullParameter(r101, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        return false;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f510287a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final void onTriggerOrigin(Map<String, String> r100, IPerformanceStrategyMonitor r101) {
        Intrinsics.checkNotNullParameter(r100, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        b r102 = this.f510287a;
        Map r103 = MapsKt.toMap(r100);
        Intrinsics.checkNotNullParameter(r101, "$this$toRevType");
        r102.b(r103, new c(r101));
    }

    @Override // com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask
    public final boolean onTriggerDegrade(int r100, Map<String, String> r101, IPerformanceStrategyMonitor r102) {
        Intrinsics.checkNotNullParameter(r101, "basePerformanceInfo");
        Intrinsics.checkNotNullParameter(r102, "monitor");
        if (r100 != 1) goto L5;
    L12:
        b r103 = this.f510287a;
        Map r104 = MapsKt.toMap(r101);
        Intrinsics.checkNotNullParameter(r102, "$this$toRevType");
        return r103.a(r100, r104, new c(r102));
    L5:
        if (r100 == 2) goto L12;
        if (r100 == 11) goto L12;
        if (r100 == 12) goto L12;
        return false;
    }
}
