package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.ScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public interface WifiChangeListener {
    void onScanInfoChanged(List<ScanResult> r100);

    void onWifiInfoChanged(boolean r100);

    void onWifiStateChanged(int r100);
}
