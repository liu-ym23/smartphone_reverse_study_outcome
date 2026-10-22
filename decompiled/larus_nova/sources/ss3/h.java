package ss3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f543392a;

    public h(i r100) {
        this.f543392a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.f543392a.f543396d = r101.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0) / 10.0f;
        this.f543392a.f543397e = r101.getIntExtra("status", 1);
        i r102 = this.f543392a;
        r101.getIntExtra("plugged", -1);
        r102.getClass();
    }
}
