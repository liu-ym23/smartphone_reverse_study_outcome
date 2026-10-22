package o82;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LiveTracingMonitor.EventModule f522357b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f522358a;

    static {
        f522357b = LiveTracingMonitor.EventModule.ACTIVITY;
    }

    public g(boolean r100) {
        this.f522358a = r100;
    }

    public final void a(String r100) {
        long r101 = System.currentTimeMillis();
        LiveMonitor.a r102 = new LiveMonitor.a("ttlive_live_load_interactive_banner", f522357b);
        r102.j(r101 - 0);
        r.i().K();
        r102.l(-1);
        r102.c(String.valueOf(this.f522358a));
        r102.i("url", r100);
        r102.i("msg", "");
        r102.a().report();
    }
}
