package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes33.dex */
public class ChannelsEnvironment {
    public static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_24_GHZ_LAST_CH_NUM = 14;
    public static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    public static final int BAND_5_GHZ_END_FREQ_MHZ = 5865;
    public static final int BAND_5_GHZ_FIRST_CH_NUM = 32;
    public static final int BAND_5_GHZ_LAST_CH_NUM = 173;
    public static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int BAND_6_GHZ_END_FREQ_MHZ = 7105;
    public static final int BAND_6_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_6_GHZ_LAST_CH_NUM = 233;
    public static final int BAND_6_GHZ_START_FREQ_MHZ = 5945;
    public static final int UNSPECIFIED = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiManager f396003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f396004c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f396005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f396006b;

        public a(int r100) {
            this.f396005a = 1;
            this.f396006b = r100;
        }
    }

    public void update() {
        List<ScanResult> r100 = WifiUtils.getWifiScanResults(this.f396002a, this.f396003b);
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<ScanResult> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L37;
        ScanResult r102 = r101.next();
        if (WifiUtils.is24GHz(r102.frequency) == true) goto L10;
        if (WifiUtils.is6GHz(r102.frequency) == true) goto L7;
        int r103 = r102.channelWidth;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L34;
        if (r103 == 2) goto L34;
        if (r103 == 3) goto L34;
        if (r103 != 4) goto L7;
        b(r102.centerFreq0);
        b(r102.centerFreq1);
        int r104 = r102.centerFreq0 - 80;
    L28:
        if (r104 > (r102.centerFreq0 + 80)) goto L30;
        a(r104);
        r104 = r104 + 10;
        goto L28
    L30:
        int r105 = r102.centerFreq1 - 80;
    L32:
        if (r105 > (r102.centerFreq1 + 80)) goto L7;
        a(r105);
        r105 = r105 + 10;
    L34:
        b(r102.centerFreq0);
        int r106 = r102.centerFreq0;
        int r107 = r106 - 60;
        int r108 = r106 + 60;
    L35:
        if (r107 > r108) goto L7;
        a(r107);
        r107 = r107 + 10;
        goto L35
    L16:
        b(r102.frequency);
        a(r102.frequency - 10);
        a(r102.frequency + 10);
        goto L7
    L10:
        b(r102.frequency);
        a(r102.frequency - 5);
        a(r102.frequency - 10);
        a(r102.frequency + 5);
        a(r102.frequency + 10);
        goto L7
    }

    public final void a(int r100) {
        if (this.f396004c.containsKey(Integer.valueOf(r100)) == false) goto L5;
        this.f396004c.put(Integer.valueOf(r100), new a(0));
        return;
    L5:
        a r101 = this.f396004c.get(Integer.valueOf(r100));
        if (r101 == null) goto L10;
        r101.f396005a++;
        return;
    }

    public final void b(int r100) {
        if (this.f396004c.containsKey(Integer.valueOf(r100)) == true) goto L5;
        this.f396004c.put(Integer.valueOf(r100), new a(1));
        return;
    L5:
        a r101 = this.f396004c.get(Integer.valueOf(r100));
        r101.f396005a++;
        r101.f396006b++;
    }

    public ChannelsEnvironment(Context r100, WifiManager r101) {
        this.f396002a = r100;
        this.f396003b = r101;
        this.f396004c = new HashMap();
        update();
    }

    public int getCenterChannelUsedNum(int r100, int r101) {
        int r102 = WifiUtils.convertChannelToFrequencyMhz(r100, r101);
        a r103 = this.f396004c.get(Integer.valueOf(r102));
        if (r103 != null) goto L5;
        return 0;
    L5:
        return r103.f396006b;
    }

    public int getChannelOverlapNum(int r100, int r101) {
        int r102 = WifiUtils.convertChannelToFrequencyMhz(r100, r101);
        a r103 = this.f396004c.get(Integer.valueOf(r102));
        if (r103 != null) goto L5;
        return 0;
    L5:
        return r103.f396005a;
    }
}
