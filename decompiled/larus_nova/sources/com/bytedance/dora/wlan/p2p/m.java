package com.bytedance.dora.wlan.p2p;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.SystemClock;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.larus.dora.api.model.FlowDoraConnectReason;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f204729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f204730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f204731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DoraWifiP2p f204732d;

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("DoraWifiP2p", "fallbackCreateGroup exec success");
        this.f204732d.f204691i.sendEmptyMessageDelayed(1000, 5000);
        o r100 = this.f204729a;
        r100.f204748q = SystemClock.elapsedRealtime();
        this.f204729a.a("P2pFallbackCreateGroupSuccess");
        cl4.b.c(true, this.f204730b, 5745, SystemClock.elapsedRealtime() - this.f204731c, true, cl4.b.a(this.f204729a.f204736e), 0);
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r110) {
        pk4.j.b("DoraWifiP2p", "fallbackCreateGroup exec failed: " + r110);
        cl4.b.c(false, this.f204730b, 5745, SystemClock.elapsedRealtime() - this.f204731c, true, cl4.b.a(this.f204729a.f204736e), r110);
        this.f204729a.a("P2pFallbackCreateGroupFailed-" + r110);
        this.f204729a.f204748q = SystemClock.elapsedRealtime();
        this.f204729a.f204739h = FlowDoraConnectReason.P2P_CREATE_GROUP_FAILED;
        this.f204732d.f204688f.c(4, DoraWifiEventReason.P2P_GO_CREATE_FAILED);
    }

    public m(DoraWifiP2p r100, o r101, int r102, long r103) {
        this.f204732d = r100;
        this.f204729a = r101;
        this.f204730b = r102;
        this.f204731c = r103;
    }
}
