package com.obric.cae.libs.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.obric.cae.libs.smartnetwork.CaeSmartNetworkManager;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.statusreport.LinkLayerQuality;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.wifi.basicInfo.BasicInfoManager;
import com.obric.cae.libs.wifi.basicInfo.WifiChangeListener;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class CaeWifiAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeWifiAdapter f395989d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CaeStatusReportManager f395990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CaeSmartNetworkManager f395991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BasicInfoManager f395992c;

    public int getBand() {
        return this.f395992c.getBand();
    }

    public int getBandwidth() {
        return this.f395992c.getBandwidth();
    }

    public String getBssid() {
        return this.f395992c.getBssid();
    }

    public String getCaeVersion() {
        return this.f395990a.getCaeVersion();
    }

    public int getChannel() {
        return this.f395992c.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        return this.f395992c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        return this.f395992c.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        return this.f395992c.getLastScanResults();
    }

    public LinkLayerQuality getLinkLayerQuality() {
        return this.f395990a.getLinkLayerQuality();
    }

    public int getLinkThroughput() {
        return this.f395991b.getLinkThroughput();
    }

    public int getRssi() {
        return this.f395992c.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        return this.f395992c.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        return this.f395992c.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        return this.f395992c.getTxLinkSpeedMbps();
    }

    public int getWifiStandard() {
        return this.f395992c.getWifiStandard();
    }

    public int getWifiState() {
        return this.f395992c.getWifiState();
    }

    public boolean startScan() {
        return this.f395992c.startScan();
    }

    public String getCaelibVersion() {
        return CaelibUtils.getCaelibVersion();
    }

    public CaeWifiAdapter(Context r100) {
        this.f395990a = CaeStatusReportManager.getInstance(r100);
        this.f395991b = CaeSmartNetworkManager.getInstance(r100);
        this.f395992c = BasicInfoManager.getInstance(r100);
    }

    public static CaeWifiAdapter getInstance(Context r100) {
        if (r100 == null) goto L18;
        if (f395989d != null) goto L16;
        monitor-enter(CaeWifiAdapter.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (f395989d != null) goto L10;
        f395989d = new CaeWifiAdapter(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(CaeWifiAdapter.class);     // Catch: Throwable -> L12
    L16:
        return f395989d;
    L18:
        throw new IllegalArgumentException("context cannot be null");
    }

    public void registerLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r100) {
        this.f395990a.registerLinkLayerQualityChangedListener(r100);
    }

    public void registerLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r100) {
        this.f395991b.registerLinkThroughputListener(r100);
    }

    public boolean registerWifiChangeListener(WifiChangeListener r100) {
        return this.f395992c.registerWifiChangeListener(r100);
    }

    public void unregisterLinkLayerQualityChangedListener(CaeStatusReportManager.LinkLayerQualityChangedListener r100) {
        this.f395990a.unregisterLinkLayerQualityChangedListener(r100);
    }

    public void unregisterLinkThroughputListener(CaeSmartNetworkManager.CaeWifiLinkThroughputListener r100) {
        this.f395991b.unregisterLinkThroughputListener(r100);
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r100) {
        return this.f395992c.unregisterWifiChangeListener(r100);
    }
}
