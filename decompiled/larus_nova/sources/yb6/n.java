package yb6;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f567101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f567102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f567103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f567104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f567105e;

    public static final class a {
    }

    static {
    }

    public n() {
    }

    public final String toString() {
        return "initializing:" + this.f567102b + ", initialized:" + this.f567101a + " , isEngineOn:" + this.f567105e + ", isEngineStarting:" + this.f567103c + ",isEngineStopping:" + this.f567104d;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        b(false, r100);
        this.f567104d = false;
        this.f567103c = false;
    }

    public final void b(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        this.f567105e = r100;
        LinkMonitor.a("RtcClientState", "setIsEngineOn", "isEngineOn " + r100 + " source " + r110, null, null, false, 120);
    }
}
