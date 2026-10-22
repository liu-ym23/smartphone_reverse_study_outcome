package vk4;

import com.bytedance.dora.protocol.LinkWrapper;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ak4.a f555491c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f555492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<j> f555493b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f555494a = null;

        static {
            f555494a = new f();
        }
    }

    static {
        f555491c = ak4.a.d();
    }

    public f() {
        k r100 = new k();
        this.f555492a = r100;
        this.f555493b = new CopyOnWriteArraySet();
        pk4.i r101 = pk4.i.a.f529628a;
        r100.f555495a = r101.f529627a.getString("wlan_ssid", "");
        r100.f555496b = r101.f529627a.getString("wlan_pass", "");
    }

    public final int b(int r110, String r111, String r112) {
        pk4.j.d("DoraWlanManager@8321b42", "configWlan, mode: " + r110 + ", ssid: " + r111 + ", pass: " + r112);
        k r100 = this.f555492a;
        r100.f555495a = r111;
        r100.f555496b = r112;
        r100.f555498d = 0;
        pk4.i r101 = pk4.i.a.f529628a;
        r101.f529627a.storeString("wlan_ssid", r111);
        r101.f529627a.storeString("wlan_pass", r112);
        pk4.j.d("DoraWlanManager@8321b42", "configWlan, mode: " + r110 + ", ssid: " + r111);
        cl4.j r102 = cl4.j.b.f24104a;
        if (r110 != 2) goto L5;
        r102.f24101a.post(new cl4.g(r102, r111));
    L6:
        int r113 = f555491c.i(1, 12, LinkWrapper.wlanConfigCommand((byte) r110, n.u(r111.getBytes(), new byte[]{0}), n.u(r112.getBytes(), new byte[]{0}), (byte) 1, (byte) 1, 0, null));
        if (r110 != 2) goto L9;
        r102.f24101a.post(new cl4.e(r102, r113));
    L11:
        return r113;
    L9:
        if (r110 != 1) goto L11;
        r102.f24101a.post(new cl4.f(r102));
        goto L11
    L5:
        r102.getClass();
        goto L6
    }

    @Override // vk4.j
    public final void a(int r110, String r111, String r210, final int r211, int r212, int r213, String r214, long r215, String r216) {
        pk4.j.d("DoraWlanManager@8321b42", "onWlanStateChanged: " + r110 + " " + r111 + " " + r210 + " " + r211 + " " + r212 + " " + r213 + " " + r214 + ", " + r216);
        k r100 = this.f555492a;
        r100.f555495a = r111;
        r100.f555500f = r211;
        r100.f555497c = r210;
        r100.f555498d = r213;
        r100.f555499e = r214;
        r100.f555501g = r216;
        Iterator r112 = ((CopyOnWriteArraySet) this.f555493b).iterator();
    L4:
        if (r112.hasNext() == false) goto L7;
        ((j) r112.next()).a(r110, r111, r210, r211, r212, r213, r214, r215, r216);
        goto L4
    L7:
        if (r110 == 5) goto L9;
    L13:
        final cl4.j r101 = cl4.j.b.f24104a;
        if (r110 != 2) goto L16;
        r101.f24101a.post(new cl4.h(r101, r211));
        return;
    L16:
        r101.getClass();
        return;
    L9:
        if (r211 != 3) goto L13;
        int r102 = wk4.a.f560096a;
        int r103 = WifiDirectOwnerProxy.f204669k;
        WifiDirectOwnerProxy r104 = WifiDirectOwnerProxy.a.f204680a;
        if ((r104 instanceof WifiDirectOwnerProxy) == false) goto L13;
        r104.u(0, 1);
        goto L13
    }
}
