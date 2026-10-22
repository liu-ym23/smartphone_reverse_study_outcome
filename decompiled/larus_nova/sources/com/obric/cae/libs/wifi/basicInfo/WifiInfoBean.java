package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes33.dex */
public class WifiInfoBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f396018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f396019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f396020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f396021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f396022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f396023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f396024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f396025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f396026i;

    public int getWifiStandard() {
        return this.f396024g.intValue();
    }

    public boolean is24GHz() {
        return WifiUtils.is24GHz(this.f396021d);
    }

    public boolean is5GHz() {
        return WifiUtils.is5GHz(this.f396021d);
    }

    public boolean is6GHz() {
        return WifiUtils.is6GHz(this.f396021d);
    }

    public String toString() {
        return "mBssid=" + WifiUtils.maskMacAddress(this.f396019b) + ", mSsid=" + WifiUtils.ssidHide(WifiUtils.removeDoubleQuotes(this.f396020c)) + ", mFrequency=" + this.f396021d + ", mRssi=" + this.f396022e + ", mChannel=" + this.f396023f + ", mRxLinkSpeed=" + this.f396025h + ", mTxLinkSpeed=" + this.f396026i;
    }

    public WifiInfoBean update() {
        WifiInfo r100 = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiManager_getConnectionInfo(this.f396018a);
        LogUtil.d("WifiInfoBean", "get WifiInfo:" + r100);
        this.f396019b = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getBSSID(r100);
        this.f396020c = com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getSSID(r100);
        this.f396021d = r100.getFrequency();
        this.f396022e = r100.getRssi();
        this.f396023f = WifiUtils.convertFrequencyMhzToChannel(this.f396021d);
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L5;
        this.f396025h = r100.getRxLinkSpeedMbps();
        this.f396026i = r100.getTxLinkSpeedMbps();
    L7:
        if (r101 < 30) goto L9;
        this.f396025h = r100.getRxLinkSpeedMbps();
        this.f396026i = r100.getTxLinkSpeedMbps();
        this.f396024g = Integer.valueOf(r100.getWifiStandard());
    L10:
        return this;
    L9:
        this.f396026i = r100.getLinkSpeed();
        this.f396025h = 0;
        this.f396024g = 0;
        goto L10
    L5:
        this.f396025h = 0;
        this.f396026i = 0;
        goto L7
    }

    public int getRssi() {
        update();
        return this.f396022e;
    }

    public String getBssid() {
        return this.f396019b;
    }

    public int getChannel() {
        return this.f396023f;
    }

    public int getFrequency() {
        return this.f396021d;
    }

    public int getRxLinkSpeedMbps() {
        return this.f396025h;
    }

    public String getSsid() {
        return this.f396020c;
    }

    public int getTxLinkSpeedMbps() {
        return this.f396026i;
    }

    public WifiInfoBean(WifiManager r100) {
        this.f396018a = r100;
        update();
    }

    private static String com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getBSSID(WifiInfo r110) {
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

    private static String com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiInfo_getSSID(WifiInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(101000);
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
        d r106 = r105.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getSSID();
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

    private static WifiInfo com_obric_cae_libs_wifi_basicInfo_WifiInfoBean_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
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

    public boolean equals(WifiInfoBean r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = this.f396019b;
        if (r101 != null) goto L8;
    L32:
        return false;
    L8:
        if (r101.equals(r100.f396019b) == true) goto L32;
        String r102 = this.f396020c;
        if (r102 == null) goto L32;
        if (r102.equals(r100.f396020c) == true) goto L32;
        if (this.f396021d == r100.f396021d) goto L19;
        return false;
    L19:
        if (this.f396022e == r100.f396022e) goto L22;
        return false;
    L22:
        if (this.f396023f == r100.f396023f) goto L25;
        return false;
    L25:
        if (this.f396025h == r100.f396025h) goto L28;
        return false;
    L28:
        if (this.f396026i == r100.f396026i) goto L30;
        return false;
    L30:
        return true;
    }
}
