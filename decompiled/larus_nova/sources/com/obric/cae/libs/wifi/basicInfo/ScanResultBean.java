package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class ScanResultBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f396007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ScanResult> f396008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WifiInfo f396009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f396010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f396011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f396012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f396013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f396014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f396015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f396016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f396017k;

    public int getBandwidth() {
        int r100 = this.f396012f;
        if (r100 != 4) goto L5;
    L19:
        double r101 = Math.pow(2.0d, r100 - 1);
    L18:
        return (int) (r101 * 20.0d);
    L5:
        if (r100 == 5) goto L19;
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L16;
        return -1;
    L16:
        r101 = Math.pow(2.0d, r100);
        goto L18
    }

    public int getCurrentChannelUsedCount() {
        if (this.f396011e == false) goto L5;
        int r100 = this.f396015i;
        int r101 = this.f396016j;
        if (r100 >= r101) goto L10;
        return r100;
    L10:
        return r101;
    L5:
        return this.f396015i;
    }

    public boolean startScan() {
        WifiManager r100 = this.f396007a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(r100);
    }

    public void update() {
        this.f396008b = WifiUtils.getWifiScanResults(this.f396017k, this.f396007a);
        WifiInfo r100 = com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_getConnectionInfo(this.f396007a);
        this.f396009c = r100;
        if (this.f396008b == null) goto L31;
        if (r100 == null) goto L42;
        this.f396010d = com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiInfo_getBSSID(r100);
        this.f396013g = this.f396009c.getFrequency();
        Iterator<ScanResult> r101 = this.f396008b.iterator();
    L8:
        if (r101.hasNext() == false) goto L17;
        ScanResult r102 = r101.next();
        if (r102.BSSID.equals(this.f396010d) == false) goto L8;
        this.f396012f = r102.channelWidth;
        if (LogUtil.isLoggable(3) == false) goto L15;
        LogUtil.d("ScanResultBean", "match bssid!, channelWidth:" + this.f396012f);
    L15:
        if (this.f396012f != 4) goto L17;
        this.f396011e = true;
        this.f396013g = r102.centerFreq0;
        this.f396014h = r102.centerFreq1;
    L17:
        this.f396015i = 0;
        if (this.f396011e == false) goto L20;
        this.f396016j = 0;
    L20:
        Iterator<ScanResult> r103 = this.f396008b.iterator();
    L22:
        if (r103.hasNext() == false) goto L43;
        int r104 = r103.next().frequency;
        if (r104 != this.f396013g) goto L27;
        this.f396015i++;
    L27:
        if (this.f396011e == false) goto L22;
        if (r104 != this.f396014h) goto L22;
        this.f396016j++;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public List<ScanResult> getLastScanResults() {
        return this.f396008b;
    }

    private static String com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiInfo_getBSSID(WifiInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(101100);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getBSSID();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static WifiInfo com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102301);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static boolean com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102302);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.startScan();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public ScanResultBean(Context r100, WifiManager r101) {
        this.f396015i = Integer.MIN_VALUE;
        this.f396016j = Integer.MIN_VALUE;
        this.f396017k = r100;
        this.f396007a = r101;
        if (r101.isWifiEnabled() == false) goto L5;
        com_obric_cae_libs_wifi_basicInfo_ScanResultBean_android_net_wifi_WifiManager_startScan(r101);
    L5:
        update();
    }

    public ScanResultBean(List<ScanResult> r100, WifiInfo r101) {
        this.f396015i = Integer.MIN_VALUE;
        this.f396016j = Integer.MIN_VALUE;
        this.f396008b = r100;
        this.f396009c = r101;
    }
}
