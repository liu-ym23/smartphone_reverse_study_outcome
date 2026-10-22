package com.facebook.battery.metrics.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes22.dex */
public class RadioStateCollector extends SystemMetricsCollector<RadioStateMetrics> {
    private static final int NONE = -1;
    private static final int WAKEUP_INTERVAL_S = 10;
    private final ConnectivityManager mConnectivityManager;
    private final RadioMonitor mMobileRadioMonitor;
    private final RadioMonitor mWifiRadioMonitor;

    public static final class RadioMonitor {
        final AtomicLong mNextIdleTimeActive;
        private final int mWakeUpTimeS;
        final AtomicInteger mWakeupCounter;

        public static long makeIdleValue(long r100, long r101, long r102) {
            return ((r100 << 32) | (r101 << 16)) | r102;
        }

        public static long nextIdle(long r100) {
            return r100 >> 32;
        }

        public static int totalTailS(long r100) {
            return (int) (r100 & 65535);
        }

        public static int totalTxS(long r100) {
            return (int) ((r100 & 4294901760L) >> 16);
        }

        public RadioMonitor(int r100) {
            this.mNextIdleTimeActive = new AtomicLong();
            this.mWakeupCounter = new AtomicInteger();
            this.mWakeUpTimeS = r100;
        }

        public int onRadioActivate(long r110, long r111) {
            TimeUnit r100 = TimeUnit.MILLISECONDS;
            long r112 = r100.toSeconds(r110);
            long r113 = r100.toSeconds(r111);
            boolean r101 = false;
        L3:
            long r102 = this.mNextIdleTimeActive.get();
            long r103 = adjustTotalsAndNextIdle(r112, r113, r102);
            if (nextIdle(r102) >= nextIdle(r103)) goto L7;
            r101 = this.mNextIdleTimeActive.compareAndSet(r102, r103);
            if (r101 == false) goto L3;
        L7:
            if (r101 == true) goto L9;
            return 0;
        L9:
            if (nextIdle(r102) > r112) goto L12;
            this.mWakeupCounter.getAndIncrement();
        L12:
            return totalTxS(r102) + totalTailS(r102);
        }

        private long adjustTotalsAndNextIdle(long r110, long r111, long r210) {
            long r100 = nextIdle(r210);
            long r101 = r100 - ((long) this.mWakeUpTimeS);
            if (r111 <= r101) goto L5;
            long r102 = 1;
        L6:
            long r103 = Math.max(r110, r101);
            long r104 = Math.max(r111, r101);
            long r105 = totalTxS(r210);
            long r112 = totalTailS(r210);
            long r106 = Math.max(r104 - r103, r102);
            if (r103 < r100) goto L9;
            long r107 = this.mWakeUpTimeS;
        L14:
            return makeIdleValue(r104 + ((long) this.mWakeUpTimeS), r105 + r106, r112 + r107);
        L9:
            if (r104 >= r100) goto L11;
            r107 = (((long) this.mWakeUpTimeS) - r106) - (r100 - r104);
            goto L14
        L11:
            r107 = ((long) this.mWakeUpTimeS) - (r100 - r103);
            goto L14
        L5:
            r102 = 0;
            goto L6
        }
    }

    private RadioMonitor getCurrentRadioMonitor() {
        int r100 = getNetworkType(this.mConnectivityManager.getActiveNetworkInfo());
        if (r100 != (-1)) goto L5;
        return null;
    L5:
        if (r100 == 1) goto L9;
        return this.mMobileRadioMonitor;
    L9:
        return this.mWifiRadioMonitor;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public RadioStateMetrics createMetrics() {
        return new RadioStateMetrics();
    }

    public void onRadioActiveNow() {
        RadioMonitor r100 = getCurrentRadioMonitor();
        if (r100 == null) goto L6;
        long r101 = SystemClock.elapsedRealtime();
        r100.onRadioActivate(r101, r101);
        return;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    public RadioStateCollector(Context r100) {
        this.mWifiRadioMonitor = new RadioMonitor(0);
        this.mMobileRadioMonitor = new RadioMonitor(10);
        this.mConnectivityManager = (ConnectivityManager) r100.getSystemService("connectivity");
    }

    private static int getNetworkType(NetworkInfo r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getType();
    }

    public boolean getSnapshot(RadioStateMetrics r100) {
        long r101 = this.mMobileRadioMonitor.mNextIdleTimeActive.get();
        r100.mobileHighPowerActiveS = RadioMonitor.totalTxS(r101);
        r100.mobileLowPowerActiveS = RadioMonitor.totalTailS(r101);
        r100.mobileRadioWakeupCount = this.mMobileRadioMonitor.mWakeupCounter.get();
        long r102 = this.mWifiRadioMonitor.mNextIdleTimeActive.get();
        r100.wifiActiveS = RadioMonitor.totalTxS(r102) + RadioMonitor.totalTailS(r102);
        r100.wifiRadioWakeupCount = this.mWifiRadioMonitor.mWakeupCounter.get();
        return true;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((RadioStateMetrics) r100);
    }

    public void onRadioActive(long r100, long r101) {
        RadioMonitor r102 = getCurrentRadioMonitor();
        if (r102 == null) goto L6;
        r102.onRadioActivate(r100, r101);
        return;
    }
}
