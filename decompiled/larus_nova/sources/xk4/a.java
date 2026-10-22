package xk4;

import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.model.DoraWifiType;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f564192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f564193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f564194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f564195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f564196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f564197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DoraWifiType f564198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f564199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f564200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f564201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DoraWifiScene f564202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f564203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f564204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f564205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f564206r;

    public final void c() {
        Object r100 = this.f564209c;
        monitor-enter(r100);
        this.f564207a = null;     // Catch: Throwable -> L9
        this.f564208b.clear();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        this.f564192d = null;
        this.f564193e = 0;
        this.f564194f = 0;
        this.f564195g = 0;
        this.f564196h = "";
        this.f564197i = "";
        this.f564198j = null;
        this.f564199k = "";
        this.f564201m = 0;
        this.f564202n = null;
        this.f564203o = "";
        this.f564204p = 0;
        this.f564205q = 0;
        this.f564200l = "";
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return "DoraWifiRecorder{connectionId='" + this.f564192d + "', p2pDuration=" + this.f564193e + ", p2pChannel=" + this.f564194f + ", softapDuration=" + this.f564195g + ", connectCost=0, p2pReason='" + this.f564196h + "', softapReason='" + this.f564197i + "', lastLinkType='" + this.f564198j + "', reason='" + this.f564199k + "', disconnectReason='" + this.f564200l + "', result=" + this.f564201m + ", scene='" + this.f564202n + "', primaryWifiType='" + this.f564203o + "', connectStartTime=" + this.f564204p + '}';
    }

    public a() {
    }

    public void setResult(int r100) {
        this.f564201m = r100;
    }
}
