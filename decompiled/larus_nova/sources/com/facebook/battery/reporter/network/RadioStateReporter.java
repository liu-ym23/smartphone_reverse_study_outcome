package com.facebook.battery.reporter.network;

import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.network.RadioStateMetrics;
import com.facebook.battery.reporter.core.SystemMetricsReporter;

/* JADX INFO: loaded from: classes22.dex */
public class RadioStateReporter implements SystemMetricsReporter<RadioStateMetrics> {
    public static final String MOBILE_HIGH_POWER_ACTIVE_S = "mobile_high_power_active_s";
    public static final String MOBILE_LOW_POWER_ACTIVE_S = "mobile_low_power_active_s";
    public static final String MOBILE_RADIO_WAKEUP_COUNT = "mobile_radio_wakeup_count";
    public static final String WIFI_ACTIVE_S = "wifi_active_s";
    public static final String WIFI_RADIO_WAKEUP_COUNT = "wifi_radio_wakeup_count";

    public RadioStateReporter() {
    }

    public void reportTo(RadioStateMetrics r100, SystemMetricsReporter.Event r101) {
        long r102 = r100.mobileHighPowerActiveS;
        if (r102 == 0) goto L5;
        r101.add(MOBILE_HIGH_POWER_ACTIVE_S, r102);
    L5:
        long r103 = r100.mobileLowPowerActiveS;
        if (r103 == 0) goto L8;
        r101.add(MOBILE_LOW_POWER_ACTIVE_S, r103);
    L8:
        int r104 = r100.mobileRadioWakeupCount;
        if (r104 == 0) goto L11;
        r101.add(MOBILE_RADIO_WAKEUP_COUNT, r104);
    L11:
        long r105 = r100.wifiActiveS;
        if (r105 == 0) goto L14;
        r101.add(WIFI_ACTIVE_S, r105);
    L14:
        int r106 = r100.wifiRadioWakeupCount;
        if (r106 == 0) goto L18;
        r101.add(WIFI_RADIO_WAKEUP_COUNT, r106);
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter
    public /* bridge */ /* synthetic */ void reportTo(SystemMetrics r100, SystemMetricsReporter.Event r101) {
        reportTo((RadioStateMetrics) r100, r101);
    }
}
