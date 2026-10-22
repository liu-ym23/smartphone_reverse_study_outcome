package com.bytedance.badger.collect.impl.monitor;

import com.bytedance.badger.collect.impl.monitor.pseudo.MobileGetSignMonitor;
import com.bytedance.badger.collect.impl.monitor.pseudo.MobileGetTokenMonitor;
import com.bytedance.badger.collect.impl.monitor.pseudo.MobileInitMonitor;
import com.bytedance.badger.collect.impl.monitor.pseudo.MobileReportMonitor;
import com.bytedance.badger.collect.impl.monitor.pseudo.MobileWifiSwitchMonitor;

/* JADX INFO: loaded from: classes47.dex */
public class MonitorManager {
    private static volatile MonitorManager instance;
    private final MobileGetSignMonitor mobileGetSignMonitor;
    private final MobileGetTokenMonitor mobileGetTokenMonitor;
    private final MobileInitMonitor mobileInitMonitor;
    private final MobileReportMonitor mobileReportMonitor;
    private final MobileWifiSwitchMonitor mobileWifiSwitchMonitor;

    public static MonitorManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(MonitorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new MonitorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private MonitorManager() {
        this.mobileGetSignMonitor = new MobileGetSignMonitor();
        this.mobileGetTokenMonitor = new MobileGetTokenMonitor();
        this.mobileReportMonitor = new MobileReportMonitor();
        this.mobileWifiSwitchMonitor = new MobileWifiSwitchMonitor();
        this.mobileInitMonitor = new MobileInitMonitor();
    }

    public MobileGetSignMonitor getMobileGetSignMonitor() {
        return this.mobileGetSignMonitor;
    }

    public MobileGetTokenMonitor getMobileGetTokenMonitor() {
        return this.mobileGetTokenMonitor;
    }

    public MobileInitMonitor getMobileInitMonitor() {
        return this.mobileInitMonitor;
    }

    public MobileReportMonitor getMobileReportMonitor() {
        return this.mobileReportMonitor;
    }

    public MobileWifiSwitchMonitor getMobileWifiSwitchMonitor() {
        return this.mobileWifiSwitchMonitor;
    }
}
