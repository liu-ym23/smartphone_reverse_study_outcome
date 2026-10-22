package vk4;

import android.os.SystemClock;
import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.model.DoraWifiType;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f555472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DoraWifiScene f555473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoraWifiLinkStrategy f555474c;

    public /* synthetic */ b(e r100, DoraWifiScene r101, DoraWifiLinkStrategy r102) {
        this.f555472a = r100;
        this.f555473b = r101;
        this.f555474c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f555472a;
        DoraWifiScene r101 = this.f555473b;
        DoraWifiLinkStrategy r102 = this.f555474c;
        int r103 = r100.f555486e;
        if (r103 != 2) goto L6;
        pk4.j.f("DoraWifiLinkManager", "connect: return, already connected");
        ((CopyOnWriteArraySet) r100.f555482a).add(r101);
        pk4.j.d("DoraWifiLinkManager", "connect: add scene " + r101 + ", now " + r100.f555482a);
        return;
    L6:
        if (r103 != 1) goto L8;
        pk4.j.f("DoraWifiLinkManager", "connect: return, now is connecting");
        ((CopyOnWriteArraySet) r100.f555483b).add(r101);
        pk4.j.d("DoraWifiLinkManager", "connect: add pendingScene " + r101 + ", now " + r100.f555483b);
        return;
    L8:
        r100.f555485d = r102;
        pk4.j.d("DoraWifiLinkManager", "connect: strategy=" + r100.f555485d);
        DoraWifiType r104 = r100.f555485d.getPrimaryWifiType();
        String r105 = UUID.randomUUID().toString();
        r100.f555488g.c();
        r100.f555488g.f564203o = r104.name();
        xk4.a r106 = r100.f555488g;
        r106.f564202n = r101;
        r106.f564192d = r105;
        r106.f564204p = SystemClock.elapsedRealtime();
        r100.f555488g.a("Start");
        r100.f(1, DoraWifiEventReason.START);
        g r107 = r100.g(r104);
        if (r107 == null) goto L14;
        r107.b(r105, r101);
        return;
    }
}
