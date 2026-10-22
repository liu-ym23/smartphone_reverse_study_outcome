package com.bytedance.dora.link;

import ak4.b;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import bk4.q;
import com.bytedance.dora.device.DoraDevice;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDoraLink {

    /* JADX INFO: renamed from: com.bytedance.dora.link.IDoraLink$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes15.dex */
    public final /* synthetic */ class CC {
        public static void $default$registerHighPriorityDoraLinkCallback(IDoraLink r100, IDoraLinkCallback r101) {
            r100.registerDoraLinkCallback(r101, true);
        }
    }

    int connect(DoraDevice r100, String r101);

    int connect(DoraDevice r100, String r101, b r102);

    DoraDevice convertScanResultToDoraDevice(ScanResult r100);

    DoraDevice convertScanResultToDoraDeviceV2(ScanResult r100);

    int disConnect(DoraDevice r100, int r101);

    int getBtConnectState(DoraDevice r100);

    List<DoraDevice> getDeviceList();

    List<DoraDevice> getDoraBindList();

    long getDoraBondCount();

    DoraDevice getDoraDevice(String r100);

    int getDoraLinkState(DoraDevice r100);

    List<DoraDevice> getDoraList();

    int getDoraState();

    boolean hasAppBound(int r100);

    boolean hasDoraDevice();

    void initDoraSettingsConfig(String r100);

    int isReady();

    void registerDoraLinkCallback(IDoraLinkCallback r100);

    void registerDoraLinkCallback(IDoraLinkCallback r100, boolean r101);

    void registerETPProcessor(q r100);

    void registerHighPriorityDoraLinkCallback(IDoraLinkCallback r100);

    int removeBindDevice(DoraDevice r100);

    int removeBond(DoraDevice r100);

    int removeBond(DoraDevice r100, int r101);

    int scan(List<String> r100);

    int scan(List<String> r100, ScanCallback r101);

    int sendETPPayload(byte[] r100);

    int startScan(List<ScanFilter> r100, ScanSettings r101, ScanCallback r102);

    int stopScan();

    int stopScan(ScanCallback r100);

    int unBond(DoraDevice r100);

    void unregisterDoraLinkCallback(IDoraLinkCallback r100);

    void unregisterETPProcessor(q r100);
}
