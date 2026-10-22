package wk4;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.SystemClock;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f560105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f560106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f560107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiDirectOwnerProxy f560108d;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("WifiDirectOwnerProxy@8321b42", "fallbackCreateGroup exec success");
        cl4.b.c(true, this.f560105a, 5745, SystemClock.elapsedRealtime() - this.f560106b, true, this.f560107c, 0);
        WifiDirectOwnerProxy r100 = this.f560108d;
        r100.f204670a.requestGroupInfo(r100.f204672c, new e(this));
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r110) {
        pk4.j.b("WifiDirectOwnerProxy@8321b42", "fallbackCreateGroup exec failed: " + r110);
        cl4.b.c(false, this.f560105a, 5745, SystemClock.elapsedRealtime() - this.f560106b, true, this.f560107c, r110);
    }

    public f(WifiDirectOwnerProxy r100, int r101, long r102, int r103) {
        this.f560108d = r100;
        this.f560105a = r101;
        this.f560106b = r102;
        this.f560107c = r103;
    }
}
