package com.bytedance.dora.wlan.p2p;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f204721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f204722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f204723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DoraWifiP2p f204724d;

    public class a implements WifiP2pManager.ActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f204725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f204726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f204727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f204728d;

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public final void onSuccess() {
            pk4.j.d("DoraWifiP2p", "removeGroup success before fallback");
            if (this.f204725a.compareAndSet(false, true) == false) goto L6;
            this.f204726b.removeCallbacks(this.f204727c);
            l r100 = this.f204728d;
            DoraWifiP2p.d(r100.f204724d, r100.f204721a, r100.f204722b);
            return;
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public final void onFailure(int r100) {
            pk4.j.d("DoraWifiP2p", "removeGroup failed before fallback: " + r100);
            if (this.f204725a.compareAndSet(false, true) == false) goto L6;
            this.f204726b.removeCallbacks(this.f204727c);
            l r101 = this.f204728d;
            DoraWifiP2p.d(r101.f204724d, r101.f204721a, r101.f204722b);
            return;
        }

        public a(l r100, AtomicBoolean r101, Handler r102, k r103) {
            this.f204728d = r100;
            this.f204725a = r101;
            this.f204726b = r102;
            this.f204727c = r103;
        }
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        pk4.j.d("DoraWifiP2p", "createGroup exec success");
        o r100 = this.f204721a;
        r100.f204748q = SystemClock.elapsedRealtime();
        this.f204721a.a("P2pCreateGroupSuccess");
        this.f204724d.f204691i.sendEmptyMessageDelayed(1000, 5000);
        int r101 = this.f204722b;
        int r102 = this.f204723c;
        o r103 = this.f204721a;
        cl4.b.c(true, r101, r102, r103.f204748q - r103.f204747p, false, cl4.b.a(r103.f204736e), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.dora.wlan.p2p.k, java.lang.Runnable] */
    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int r110) {
        pk4.j.b("DoraWifiP2p", "createGroup exec failed: " + r110);
        int r100 = this.f204722b;
        int r101 = this.f204723c;
        long r102 = SystemClock.elapsedRealtime();
        o r103 = this.f204721a;
        cl4.b.c(false, r100, r101, r102 - r103.f204747p, false, cl4.b.a(r103.f204736e), r110);
        this.f204721a.a("P2pCreateGroupFailed-" + r110);
        if (Build.VERSION.SDK_INT < 29) goto L8;
        pk4.j.d("DoraWifiP2p", "createGroup failed on Android 10+, fallback to removeGroup before retry");
        final AtomicBoolean r104 = new AtomicBoolean(false);
        final o r105 = this.f204721a;
        final int r106 = this.f204722b;
        ?? r107 = new k(this, r104, r105, r106);
        Handler r108 = new Handler(Looper.getMainLooper());
        r108.postDelayed(r107, 300);
        if (r110 != 2) goto L7;
        DoraWifiP2p r111 = this.f204724d;
        r111.f204683a.cancelConnect(r111.f204685c, null);
    L7:
        DoraWifiP2p r112 = this.f204724d;
        r112.f204683a.removeGroup(r112.f204685c, new a(this, r104, r108, r107));
        return;
    L8:
        DoraWifiP2p.d(this.f204724d, this.f204721a, this.f204722b);
    }

    public l(DoraWifiP2p r100, o r101, int r102, int r103) {
        this.f204724d = r100;
        this.f204721a = r101;
        this.f204722b = r102;
        this.f204723c = r103;
    }
}
