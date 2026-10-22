package jk4;

import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import pk4.j;
import vk4.h;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vk4.e f499486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, nj4.c> f499487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f499488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f499489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f499490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f499491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f499492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f499493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f499494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f499495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f499496k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InterfaceC6450d f499497l;

    public class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f499498a;

        public a(d r100) {
            this.f499498a = r100;
        }

        @Override // vk4.h
        public final void a(int r100, int r101, String r102) {
            d r103 = this.f499498a;
            monitor-enter(r103);
            j.d("DoraP2PRTCManager", "handleWifiLinkStateChanged: " + r100 + " -> " + r101 + ", reason=" + r102);     // Catch: Throwable -> L37
            if (r101 != 2) goto L15;
            r103.f499492g = false;     // Catch: Throwable -> L37
            if (r103.f499486a.e() == false) goto L11;
            j.b("DoraP2PRTCManager", "ignore connected callback: current Wi-Fi link is SoftAP, P2P RTC requires P2P link");     // Catch: Throwable -> L37
            r103.b("current Wi-Fi link is SoftAP");     // Catch: Throwable -> L37
            monitor-exit(r103);
            return;
        L11:
            vk4.e r104 = r103.f499486a;     // Catch: Throwable -> L37
            DoraWifiScene r105 = DoraWifiScene.RTC_P2P;     // Catch: Throwable -> L37
            if (r104.d(r105) == true) goto L14;
            r103.f499486a.a(r105);     // Catch: Throwable -> L37
        L14:
            r103.r();     // Catch: Throwable -> L37
            j.d("DoraP2PRTCManager", "handleWifiLinkStateChanged: RTC_P2P connected");     // Catch: Throwable -> L37
        L35:
            monitor-exit(r103);
            return;
        L15:
            if (r101 != 0) goto L35;
            if (r103.f499497l != null) goto L19;
        L24:
            boolean r106 = false;
        L25:
            if (r106 == false) goto L29;
            j.f("DoraP2PRTCManager", "ignore transient disconnected callback while preparing P2P RTC, reason=" + r102);     // Catch: Throwable -> L37
            monitor-exit(r103);
            return;
        L29:
            r103.f499492g = false;     // Catch: Throwable -> L37
            if (r102 != null) goto L32;
        L33:
            r102 = "RTC_P2P disconnected before prepare finished";
        L34:
            r103.b(r102);     // Catch: Throwable -> L37
            goto L35
        L32:
            if (r102.isEmpty() == false) goto L34;
        L19:
            if (r103.f499487b.isEmpty() == true) goto L24;
            if (r102 != null) goto L22;
        L23:
            r106 = true;
            goto L25
        L22:
            if (r102.isEmpty() == false) goto L24;
        L37:
            th = move-exception;
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f499499a = null;

        static {
            f499499a = new d();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f499500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f499501b;

        public c(byte r100, int r101) {
            this.f499500a = r100;
            this.f499501b = r101;
        }
    }

    /* JADX INFO: renamed from: jk4.d$d, reason: collision with other inner class name */
    public interface InterfaceC6450d {
        void a(boolean r100, String r101);
    }

    public final synchronized boolean e() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f499487b.isEmpty() == false) goto L6;
    L10:
        boolean r100 = false;
    L11:
        monitor-exit(this);
        return r100;
    L6:
        if (this.f499486a.d(DoraWifiScene.RTC_P2P) == false) goto L10;
        if (this.f499486a.e() == true) goto L10;
        r100 = true;
        goto L11
    }

    public final int o() {
        monitor-enter(this);
        c r100 = m();     // Catch: Throwable -> L7
        monitor-exit(this);
        return q(r100);
    L7:
        th = move-exception;
        throw th;
    }

    public final void j() {
        if (this.f499487b.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.f499491f == false) goto L9;
        this.f499486a.j(this.f499490e);
        this.f499491f = false;
        return;
    }

    public final c m() {
        nj4.c r100 = (nj4.c) ((LinkedHashMap) this.f499487b).get(0);
        if (r100 == null) goto L5;
    L7:
        if (r100 == null) goto L13;
        int r101 = r100.f519442c;
        if (r101 > 0) goto L12;
        return null;
    L12:
        return new c((byte) 1, r101);
    L13:
        return null;
    L5:
        if (this.f499487b.isEmpty() == true) goto L7;
        r100 = (nj4.c) ((LinkedHashMap) this.f499487b).values().iterator().next();
        goto L7
    }

    public final void n() {
        j.d("DoraP2PRTCManager", "stop");
        monitor-enter(this);
        boolean r100 = this.f499493h;     // Catch: Throwable -> L11
        ((LinkedHashMap) this.f499487b).clear();     // Catch: Throwable -> L11
        this.f499494i++;     // Catch: Throwable -> L11
        this.f499495j++;     // Catch: Throwable -> L11
        g("P2P RTC stopped before prepare finished");     // Catch: Throwable -> L11
        if (this.f499491f == false) goto L7;
        this.f499486a.j(this.f499490e);     // Catch: Throwable -> L11
        this.f499491f = false;     // Catch: Throwable -> L11
    L7:
        this.f499492g = false;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        p(r100, "stop");
        this.f499486a.b(DoraWifiScene.RTC_P2P);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f499486a = vk4.e.d.f555490a;
        this.f499487b = new LinkedHashMap();
        this.f499488c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("DoraP2PRTCManager"));
        this.f499489d = new Object();
        this.f499490e = new a(this);
        this.f499496k = -1;
    }

    public final void r() {
        final c r100 = m();
        if (this.f499497l != null) goto L5;
        final int r101 = -1;
    L6:
        final int r102 = this.f499494i;
        if (r100 != null) goto L11;
        if (r101 == (-1)) goto L13;
        b("no valid RTC channel port");
        return;
    L13:
        return;
    L11:
        this.f499488c.execute(new jk4.c(this, r102, r100, r101));
        return;
    L5:
        r101 = this.f499496k;
        goto L6
    }

    public final void b(final String r100) {
        boolean r101 = this.f499493h;
        ((LinkedHashMap) this.f499487b).clear();
        this.f499494i++;
        this.f499495j++;
        g(r100);
        j();
        if (r101 == false) goto L6;
        this.f499488c.execute(new jk4.a(this, r100));
    L6:
        this.f499486a.b(DoraWifiScene.RTC_P2P);
    }

    public final synchronized boolean c(int r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (r100 == this.f499494i) goto L6;
    L12:
        boolean r101 = false;
    L13:
        monitor-exit(this);
        return r101;
    L6:
        if (this.f499487b.isEmpty() == true) goto L12;
        if (this.f499486a.d(DoraWifiScene.RTC_P2P) == false) goto L12;
        if (this.f499486a.e() == true) goto L12;
        r101 = true;
        goto L13
    }

    public final synchronized boolean d(int r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.f499495j) goto L8;
        if (this.f499487b.isEmpty() == true) goto L8;
        boolean r101 = true;
    L9:
        monitor-exit(this);
        return r101;
    L8:
        r101 = false;
        goto L9
    }

    public final void g(String r100) {
        f(this.f499496k, false, r100);
    }

    public final void i(List r110) {
        monitor-enter(this);
        ArrayList r111 = (ArrayList) r110;     // Catch: Throwable -> L8
        if (r111.isEmpty() == false) goto L10;
        j.f("DoraP2PRTCManager", "registerRTCChannel failed: config list is null or empty");     // Catch: Throwable -> L8
        g("config list is null or empty");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        vk4.e r100 = this.f499486a;     // Catch: Throwable -> L8
        int r101 = r100.f555486e;     // Catch: Throwable -> L8
        if (r101 == 2) goto L13;
    L17:
        boolean r102 = true;
        if (r101 != 1) goto L34;
        if (this.f499492g == true) goto L34;
        vk4.e r103 = this.f499486a;     // Catch: Throwable -> L8
        DoraWifiScene r104 = DoraWifiScene.ALBUM_SILENT;     // Catch: Throwable -> L8
        if (r103.f555486e == 1) goto L24;
    L28:
        boolean r105 = false;
    L29:
        if (r105 == true) goto L34;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: Wi-Fi link is connecting by other scene");     // Catch: Throwable -> L8
        g("Wi-Fi link is connecting by other scene");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L24:
        if (r103.f555488g.f564202n != r104) goto L28;
        if (r103.f555485d != DoraWifiLinkStrategy.P2P_ONLY) goto L28;
        r105 = true;
    L34:
        if (r101 != 3) goto L38;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: Wi-Fi link is disconnecting");     // Catch: Throwable -> L8
        g("Wi-Fi link is disconnecting");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L38:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L8
        Iterator r112 = r111.iterator();     // Catch: Throwable -> L8
        boolean r107 = false;
        boolean r108 = true;
    L40:
        if (r112.hasNext() == false) goto L49;
        nj4.c r109 = (nj4.c) r112.next();     // Catch: Throwable -> L8
        if (r109 == null) goto L43;
        if (this.f499487b.containsKey(Integer.valueOf(r109.f519440a)) == false) goto L47;
        this.f499487b.put(Integer.valueOf(r109.f519440a), r109);     // Catch: Throwable -> L8
        j.d("DoraP2PRTCManager", "registerRTCChannel: channel updated, channelId=" + r109.f519440a + ", targetPort=" + r109.f519442c);     // Catch: Throwable -> L8
    L48:
        r107 = true;
        goto L40
    L47:
        this.f499487b.put(Integer.valueOf(r109.f519440a), r109);     // Catch: Throwable -> L8
        r106.add(Integer.valueOf(r109.f519440a));     // Catch: Throwable -> L8
        goto L48
    L43:
        j.f("DoraP2PRTCManager", "registerRTCChannel: ignore null config");     // Catch: Throwable -> L8
        r108 = false;
        goto L40
    L49:
        if (r107 == false) goto L52;
        this.f499494i++;     // Catch: Throwable -> L8
    L52:
        if (this.f499487b.isEmpty() == false) goto L57;
        g("no accepted RTC channel config");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L57:
        if (this.f499491f == true) goto L59;
        vk4.e r113 = this.f499486a;     // Catch: Throwable -> L8
        ((CopyOnWriteArraySet) r113.f555484c).add(this.f499490e);     // Catch: Throwable -> L8
        this.f499491f = true;     // Catch: Throwable -> L8
    L59:
        vk4.e r114 = this.f499486a;     // Catch: Throwable -> L8
        int r115 = r114.f555486e;     // Catch: Throwable -> L8
        if (r115 == 2) goto L62;
        if (r115 == 1) goto L88;
        if (r115 != 3) goto L111;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: Wi-Fi link switched to disconnecting");     // Catch: Throwable -> L8
        k(r106);     // Catch: Throwable -> L8
        j();     // Catch: Throwable -> L8
        g("Wi-Fi link switched to disconnecting");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L111:
        j.d("DoraP2PRTCManager", "registerRTCChannel: P2P is not connected, connect RTC_P2P scene");     // Catch: Throwable -> L8
        this.f499492g = true;     // Catch: Throwable -> L8
        vk4.e r116 = this.f499486a;     // Catch: Throwable -> L8
        DoraWifiScene r117 = DoraWifiScene.RTC_P2P;     // Catch: Throwable -> L8
        DoraWifiLinkStrategy r118 = DoraWifiLinkStrategy.P2P_ONLY;     // Catch: Throwable -> L8
        r116.getClass();     // Catch: Throwable -> L8
        dl4.a.a(new vk4.b(r116, r117, r118));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L88:
        if (this.f499492g == true) goto L104;
        final DoraWifiScene r119 = DoraWifiScene.ALBUM_SILENT;     // Catch: Throwable -> L8
        if (r115 == 1) goto L92;
    L96:
        r102 = false;
    L97:
        if (r102 == true) goto L101;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: Wi-Fi link switched to connecting by other scene");     // Catch: Throwable -> L8
        k(r106);     // Catch: Throwable -> L8
        j();     // Catch: Throwable -> L8
        g("Wi-Fi link switched to connecting by other scene");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L101:
        j.d("DoraP2PRTCManager", "registerRTCChannel: wait current ALBUM_SILENT P2P connection, append RTC_P2P scene");     // Catch: Throwable -> L8
        int r120 = this.f499495j;     // Catch: Throwable -> L8
        final vk4.e r121 = this.f499486a;     // Catch: Throwable -> L8
        final DoraWifiScene r122 = DoraWifiScene.RTC_P2P;     // Catch: Throwable -> L8
        final jk4.b r123 = new jk4.b(this, r120);     // Catch: Throwable -> L8
        final e r124 = new e(this, r120);     // Catch: Throwable -> L8
        r121.getClass();     // Catch: Throwable -> L8
        dl4.a.a(new vk4.d(r121, r123, r122, r119, r124));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L92:
        if (r114.f555488g.f564202n != r119) goto L96;
        if (r114.f555485d != DoraWifiLinkStrategy.P2P_ONLY) goto L96;
    L104:
        j.d("DoraP2PRTCManager", "registerRTCChannel: P2P RTC is connecting, append channels only");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L62:
        if (r114.e() == false) goto L66;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: Wi-Fi link switched to SoftAP");     // Catch: Throwable -> L8
        k(r106);     // Catch: Throwable -> L8
        j();     // Catch: Throwable -> L8
        g("current Wi-Fi link switched to SoftAP");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L66:
        vk4.e r125 = this.f499486a;     // Catch: Throwable -> L8
        DoraWifiScene r126 = DoraWifiScene.RTC_P2P;     // Catch: Throwable -> L8
        if (r125.d(r126) == true) goto L69;
        this.f499486a.a(r126);     // Catch: Throwable -> L8
    L69:
        int r127 = this.f499496k;     // Catch: Throwable -> L8
        int r128 = this.f499494i;     // Catch: Throwable -> L8
        c r129 = m();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r129 != null) goto L74;
        a(r128, "no valid RTC channel port", false);
        f(r127, false, "no valid RTC channel port");
        return;
    L74:
        int r130 = s(r128, r129);
        j.d("DoraP2PRTCManager", "registerRTCChannel: RTC_P2P already connected, syncRet=" + r130);
        if (r130 == 0) goto L77;
        a(r128, "syncP2PRTCConfig failed, ret=" + r130, true);
    L77:
        if (r108 == false) goto L80;
        if (r130 != 0) goto L80;
    L81:
        if (r130 != 0) goto L83;
        String r131 = null;
    L84:
        f(r127, r102, r131);
        return;
    L83:
        r131 = "syncP2PRTCConfig failed, ret=" + r130;
    L80:
        r102 = false;
        goto L81
    L13:
        if (r100.e() == false) goto L17;
        j.b("DoraP2PRTCManager", "registerRTCChannel failed: current Wi-Fi link is SoftAP, P2P RTC requires P2P link");     // Catch: Throwable -> L8
        g("current Wi-Fi link is SoftAP");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void k(List<Integer> r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        this.f499487b.remove((Integer) r101.next());
        goto L4
    L6:
        this.f499494i++;
        if (this.f499487b.isEmpty() == false) goto L11;
        this.f499495j++;
        return;
    }

    public final synchronized boolean l(int r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (r100 != this.f499494i) goto L6;
    L12:
        boolean r101 = false;
    L13:
        monitor-exit(this);
        return r101;
    L6:
        if (this.f499487b.isEmpty() == false) goto L8;
    L11:
        r101 = true;
        goto L13
    L8:
        if (this.f499486a.d(DoraWifiScene.RTC_P2P) == false) goto L11;
        if (this.f499486a.e() == false) goto L12;
        goto L11
    }

    public final int q(c r100) {
        Object r101 = this.f499489d;
        monitor-enter(r101);
        if (r100 != null) goto L9;
        j.b("DoraP2PRTCManager", "syncP2PRTCConfig failed: config is null");     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L27
        return -1;
    L9:
        boolean r102 = false;
        if (r100.f499500a != 1) goto L12;
        int r103 = r100.f499501b;     // Catch: Throwable -> L27
    L13:
        int r104 = ak4.a.d().f(r100.f499500a, r103);     // Catch: Throwable -> L27
        j.d("DoraP2PRTCManager", "syncP2PRTCConfig ret=" + r104 + ", useP2P=" + r100.f499500a + ", port=" + r103);     // Catch: Throwable -> L27
        if (r104 != 0) goto L25;
        monitor-enter(this);     // Catch: Throwable -> L27
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L17:
        if (r100.f499500a != 1) goto L19;
        r102 = true;
    L19:
        this.f499493h = r102;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L25:
        monitor-exit(r101);     // Catch: Throwable -> L27
        return r104;
    L12:
        r103 = 0;
    L27:
        th = move-exception;
        throw th;
    }

    public final void t(List<nj4.c> r100) {
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == false) goto L6;
        n();
        return;
    L6:
        monitor-enter(this);
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L19
    L9:
        if (r102.hasNext() == false) goto L14;
        nj4.c r103 = (nj4.c) r102.next();     // Catch: Throwable -> L19
        if (r103 == null) goto L9;
        this.f499487b.remove(Integer.valueOf(r103.f519440a));     // Catch: Throwable -> L19
        goto L9
    L14:
        this.f499494i++;     // Catch: Throwable -> L19
        boolean r104 = this.f499487b.isEmpty();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        if (r104 == false) goto L30;
        n();
        return;
    L30:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void h(List r100, AbilityService.i r101) {
        monitor-enter(this);
        this.f499496k++;     // Catch: Throwable -> L7
        this.f499497l = r101;     // Catch: Throwable -> L7
        this.f499494i++;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        i(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void p(boolean r100, String r101) {
        if (r100 == true) goto L4;
        return;
    L4:
        int r102 = q(new c((byte) 0, 0));
        if (r102 == 0) goto L8;
        j.b("DoraP2PRTCManager", "sync disable P2P RTC config failed: reason=" + r101 + ", ret=" + r102);
        return;
    }

    public final int s(int r100, c r101) {
        Object r102 = this.f499489d;
        monitor-enter(r102);
        int r103 = -1;
        if (c(r100) == true) goto L9;
        j.f("DoraP2PRTCManager", "skip expired P2P RTC config sync");     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return -1;
    L9:
        int r104 = q(r101);     // Catch: Throwable -> L21
        if (r104 != 0) goto L17;
        if (l(r100) == false) goto L17;
        j.f("DoraP2PRTCManager", "rollback expired P2P RTC config sync");     // Catch: Throwable -> L21
        q(new c((byte) 0, 0));     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return -1;
    L17:
        if (c(r100) == false) goto L19;
        r103 = r104;
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L21
        return r103;
    L21:
        th = move-exception;
        throw th;
    }

    public final void a(int r100, String r101, boolean r102) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (r100 == this.f499494i) goto L9;
        j.f("DoraP2PRTCManager", "skip clearing expired RTC_P2P sync failure state: " + r101);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L9:
        j.b("DoraP2PRTCManager", "clear RTC_P2P state after sync failure: " + r101);     // Catch: Throwable -> L23
        if (r102 == false) goto L12;
    L15:
        boolean r103 = true;
    L16:
        ((LinkedHashMap) this.f499487b).clear();     // Catch: Throwable -> L23
        this.f499494i++;     // Catch: Throwable -> L23
        this.f499495j++;     // Catch: Throwable -> L23
        if (this.f499491f == false) goto L19;
        this.f499486a.j(this.f499490e);     // Catch: Throwable -> L23
        this.f499491f = false;     // Catch: Throwable -> L23
    L19:
        this.f499492g = false;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        p(r103, r101);
        this.f499486a.b(DoraWifiScene.RTC_P2P);
        return;
    L12:
        if (this.f499493h == true) goto L15;
        r103 = false;
        goto L16
    }

    public final void f(int r100, boolean r101, String r102) {
        monitor-enter(this);
        InterfaceC6450d r103 = this.f499497l;     // Catch: Throwable -> L17
        if (r103 != null) goto L6;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L6:
        if (this.f499496k != r100) goto L15;
        this.f499497l = null;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        r103.a(r101, r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        j.c("DoraP2PRTCManager", "notifyPrepareResult callback failed", th);
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
