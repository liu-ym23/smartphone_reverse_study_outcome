package vk4;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.model.DoraWifiType;
import com.bytedance.dora.wlan.p2p.DoraWifiP2p;
import com.bytedance.dora.wlan.p2p.o;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<DoraWifiScene> f555482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<DoraWifiScene> f555483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<h> f555484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DoraWifiLinkStrategy f555485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f555486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f555487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xk4.a f555488g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f555489a = null;

        static {
            int[] r100 = new int[DoraWifiType.values().length];
            f555489a = r100;
            r100[DoraWifiType.P2P.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f555489a[DoraWifiType.SOFT_AP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f555490a = null;

        static {
            f555490a = new e();
        }
    }

    public final String c() {
        if (this.f555486e == 2) goto L5;
        return null;
    L5:
        return this.f555487f;
    }

    public final boolean e() {
        if (this.f555486e == 2) goto L5;
    L7:
        boolean r100 = false;
    L8:
        pk4.j.d("DoraWifiLinkManager", "isSoftApConnected: " + r100 + ", state=" + this.f555486e + ", type=" + this.f555488g.f564198j);
        return r100;
    L5:
        if (this.f555488g.f564198j != DoraWifiType.SOFT_AP) goto L7;
        r100 = true;
        goto L8
    }

    public e() {
        this.f555482a = new CopyOnWriteArraySet();
        this.f555483b = new CopyOnWriteArraySet();
        this.f555484c = new CopyOnWriteArraySet();
        this.f555485d = DoraWifiLinkStrategy.getDefault();
        this.f555486e = 0;
        this.f555488g = new xk4.a();
    }

    public final void a(DoraWifiScene r100) {
        ((CopyOnWriteArraySet) this.f555482a).add(r100);
        pk4.j.d("DoraWifiLinkManager", "addScene: scene " + r100);
    }

    public final void b(final DoraWifiScene r100) {
        dl4.a.a(new vk4.c(this, r100));
    }

    public final boolean d(DoraWifiScene r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        pk4.j.d("DoraWifiLinkManager", "DoraWifiLinkManager.isSceneConnected.scene == null, return false.");
        return false;
    L6:
        boolean r102 = ((CopyOnWriteArraySet) this.f555482a).contains(r100);
        if (this.f555486e != 2) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        if (r102 == false) goto L13;
        r101 = true;
    L13:
        pk4.j.d("DoraWifiLinkManager", "DoraWifiLinkManager.isSceneConnected, isConnected: " + r103 + ", isSceneSetContainsScene: " + r102 + ", isSceneConnected: " + r101);
        return r101;
    L9:
        r103 = false;
        goto L10
    }

    public final g g(DoraWifiType r100) {
        int r101 = a.f555489a[r100.ordinal()];
        if (r101 != 1) goto L5;
        DoraWifiP2p r102 = DoraWifiP2p.c.f204696a;
        r102.f204690h = this;
        return r102;
    L5:
        if (r101 == 2) goto L7;
        return null;
    L7:
        zk4.k r103 = zk4.f.f572630f;
        zk4.f r104 = zk4.f.b.f572637a;
        r104.f572632b = this;
        return r104;
    }

    public final String i(DoraWifiLinkStrategy r100) {
        g r101 = g(r100.getPrimaryWifiType());
        if (r101 == null) goto L8;
        String r102 = r101.c();
        if (TextUtils.equals(r102, "success") == true) goto L8;
        pk4.j.d("DoraWifiLinkManager", "precheck: strategy=" + r100 + ", reason=" + r102);
        return r102;
    L8:
        DoraWifiType r103 = r100.getSecondWifiType();
        if (r103 == null) goto L14;
        g r104 = g(r103);
        if (r104 == null) goto L14;
        String r105 = r104.c();
        pk4.j.d("DoraWifiLinkManager", "precheck: strategy=" + r100 + ", reason=" + r105);
        return r105;
    L14:
        pk4.j.d("DoraWifiLinkManager", "precheck: strategy=" + r100 + ", reason=success");
        return "success";
    }

    public final void j(h r100) {
        ((CopyOnWriteArraySet) this.f555484c).remove(r100);
    }

    public final void f(int r100, DoraWifiEventReason r110) {
        pk4.j.d("DoraWifiLinkManager", "notifyWifiLinkStateChanged: state=" + r100 + ", where=" + r110);
        int r101 = this.f555486e;
        if (r101 == r100) goto L33;
        this.f555486e = r100;
        DoraWifiScene r102 = this.f555488g.f564202n;
        if (r100 != 2) goto L7;
        ((CopyOnWriteArraySet) this.f555482a).add(r102);
        ((CopyOnWriteArraySet) this.f555482a).addAll(this.f555483b);
        pk4.j.d("DoraWifiLinkManager", "state connected, add scene " + r102 + ", pendingScene " + this.f555483b + ", now " + this.f555482a);
    L10:
        if (r101 != 1) goto L13;
        if (r100 != 2) goto L13;
        pk4.j.d("DoraWifiLinkManager", "reportWifiLinkStateChanged: Connecting -> Connected, reporting connect success");
        this.f555488g.setResult(1);
        this.f555488g.f564205q = SystemClock.elapsedRealtime();
        cl4.d.a(this.f555488g);
    L22:
        if (r100 == 0) goto L26;
        if (r100 == 3) goto L26;
        String r103 = this.f555488g.f564199k;
    L29:
        pk4.j.d("DoraWifiLinkManager", "notifyWifiLinkStateChanged: " + r101 + " -> " + r100 + ", reason=" + r103 + ", where=" + r110);
        Iterator r111 = ((CopyOnWriteArraySet) this.f555484c).iterator();
    L31:
        if (r111.hasNext() == false) goto L35;
        ((h) r111.next()).a(r101, r100, r103);
        goto L31
    L35:
        return;
    L26:
        if (r101 != 1) goto L28;
        r103 = this.f555488g.f564199k;
        goto L29
    L28:
        r103 = this.f555488g.f564200l;
    L13:
        if (r101 != 1) goto L16;
        if (r100 != 0) goto L16;
        pk4.j.d("DoraWifiLinkManager", "reportWifiLinkStateChanged: Connecting -> Disconnected, reporting connect failed and disconnect");
        this.f555488g.setResult(2);
        this.f555488g.f564205q = SystemClock.elapsedRealtime();
        cl4.d.a(this.f555488g);
    L16:
        if (r101 != 2) goto L19;
        if (r100 != 0) goto L19;
        pk4.j.d("DoraWifiLinkManager", "reportWifiLinkStateChanged: Connected -> Disconnected, reporting disconnect");
        this.f555488g.f564206r = SystemClock.elapsedRealtime();
        cl4.d.b(this.f555488g);
    L19:
        if (r101 != 2) goto L22;
        if (r100 != 3) goto L22;
        pk4.j.d("DoraWifiLinkManager", "reportWifiLinkStateChanged: Connected -> Disconnecting, reporting disconnect");
        this.f555488g.f564206r = SystemClock.elapsedRealtime();
        xk4.a r104 = this.f555488g;
        r104.f564200l = "invokeWiFiClose";
        cl4.d.b(r104);
        goto L22
    L7:
        if (r100 != 0) goto L10;
        ((CopyOnWriteArraySet) this.f555482a).clear();
        ((CopyOnWriteArraySet) this.f555483b).clear();
        pk4.j.d("DoraWifiLinkManager", "state disconnected, remove all scene and pendingScene");
        goto L10
    }

    public final void h(DoraWifiType r100, int r101, xk4.b r102) {
        if (r101 != 2) goto L15;
        this.f555487f = r102.f564207a;
        xk4.a r103 = this.f555488g;
        r103.f564198j = r100;
        r103.a("Connected");
        if (r100 != DoraWifiType.P2P) goto L10;
        if ((r102 instanceof o) == false) goto L10;
        o r104 = (o) r102;
        xk4.a r105 = this.f555488g;
        r105.f564193e = (int) r104.f204753v;
        r105.f564194f = r104.f204741j;
        r105.f564196h = r104.f204739h;
        r105.f564195g = 0;
        r105.f564197i = "";
    L14:
        f(2, DoraWifiEventReason.LINK_STATE_CHANGED_CONNECTED);
        return;
    L10:
        if (r100 != DoraWifiType.SOFT_AP) goto L14;
        if ((r102 instanceof zk4.k) == false) goto L14;
        zk4.k r106 = (zk4.k) r102;
        xk4.a r107 = this.f555488g;
        r107.f564195g = r106.f572654o;
        r107.f564197i = r106.f572646g;
        goto L14
    L15:
        if (r101 != 0) goto L52;
        vk4.a.f555471a = null;
        if (this.f555486e != 1) goto L41;
        DoraWifiType r108 = this.f555485d.getPrimaryWifiType();
        DoraWifiType r109 = this.f555485d.getSecondWifiType();
        if (r100 != r108) goto L30;
        if (r109 == null) goto L30;
        this.f555488g.a("ConnectFailed-" + r100 + "-" + r109);
        if ((r102 instanceof o) == false) goto L25;
        o r110 = (o) r102;
        xk4.a r111 = this.f555488g;
        r111.f564193e = r110.f204753v;
        r111.f564194f = r110.f204741j;
        r111.f564196h = r110.f204739h;
    L27:
        g r112 = g(r109);
        if (r112 == null) goto L53;
        pk4.j.d("DoraWifiLinkManager", "onWifiStateChanged: " + r100 + ", connect failed, next " + r109);
        xk4.a r113 = this.f555488g;
        r112.b(r113.f564192d, r113.f564202n);
        return;
    L53:
        return;
    L25:
        if ((r102 instanceof zk4.k) == false) goto L27;
        zk4.k r114 = (zk4.k) r102;
        xk4.a r115 = this.f555488g;
        r115.f564195g = r114.f572654o;
        r115.f564197i = r114.f572646g;
    L30:
        xk4.a r116 = this.f555488g;
        r116.f564198j = r100;
        r116.a("ConnectFailed");
        if (r100 != DoraWifiType.P2P) goto L36;
        if ((r102 instanceof o) == false) goto L36;
        o r117 = (o) r102;
        xk4.a r118 = this.f555488g;
        r118.f564193e = r117.f204753v;
        r118.f564194f = r117.f204741j;
        String r119 = r117.f204739h;
        r118.f564196h = r119;
        r118.f564199k = r119;
    L40:
        this.f555487f = "";
        f(0, DoraWifiEventReason.LINK_STATE_CHANGED_CONNECTING_DISCONNECTED);
        return;
    L36:
        if (r100 != DoraWifiType.SOFT_AP) goto L40;
        if ((r102 instanceof zk4.k) == false) goto L40;
        zk4.k r120 = (zk4.k) r102;
        xk4.a r121 = this.f555488g;
        r121.f564195g = r120.f572654o;
        String r122 = r120.f572646g;
        r121.f564197i = r122;
        r121.f564199k = r122;
        goto L40
    L41:
        this.f555488g.a("Disconnected");
        if ("invokeWiFiClose".equals(this.f555488g.f564200l) == false) goto L44;
    L49:
        this.f555487f = "";
        f(0, DoraWifiEventReason.LINK_STATE_CHANGED_CONNECTED_DISCONNECTED);
        return;
    L44:
        if ((r102 instanceof o) == false) goto L47;
        this.f555488g.f564200l = ((o) r102).f204737f;
        goto L49
    L47:
        if ((r102 instanceof zk4.k) == false) goto L49;
        this.f555488g.f564200l = ((zk4.k) r102).f572643d;
        goto L49
    }
}
