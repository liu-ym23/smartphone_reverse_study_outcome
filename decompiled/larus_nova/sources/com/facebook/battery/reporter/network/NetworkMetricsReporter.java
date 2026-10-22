package com.facebook.battery.reporter.network;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;

/* JADX INFO: loaded from: classes22.dex */
public class NetworkMetricsReporter implements SystemMetricsReporter<NetworkMetrics> {
    public static final String MOBILE_BYTES_RX = "mobile_bytes_rx";
    public static final String MOBILE_BYTES_TX = "mobile_bytes_tx";
    public static final String WIFI_BYTES_RX = "wifi_bytes_rx";
    public static final String WIFI_BYTES_TX = "wifi_bytes_tx";

    public NetworkMetricsReporter() {
    }

    public void reportTo(NetworkMetrics r100, SystemMetricsReporter.Event r101) {
        long r102 = r100.mobileBytesTx;
        if (r102 == 0) goto L5;
        r101.add(MOBILE_BYTES_TX, r102);
    L5:
        long r103 = r100.mobileBytesRx;
        if (r103 == 0) goto L8;
        r101.add(MOBILE_BYTES_RX, r103);
    L8:
        long r104 = r100.wifiBytesTx;
        if (r104 == 0) goto L11;
        r101.add(WIFI_BYTES_TX, r104);
    L11:
        long r105 = r100.wifiBytesRx;
        if (r105 == 0) goto L15;
        r101.add(WIFI_BYTES_RX, r105);
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((NetworkMetrics) r100, r101);
    }
}
