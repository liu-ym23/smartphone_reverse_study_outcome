package xk7;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.settings.h;
import com.flow.performance.thermal.SystemBatteryRecoder;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564243a = 0;

    static {
    }

    public static int a(ILuckyDogCommonSettingsService.Channel r100, String r101) {
        boolean r102 = false;
        switch(r101.hashCode()) {
            case -1049376625: goto L42;
            case -412512784: goto L39;
            case -408413369: goto L15;
            case -397904957: goto L12;
            case 3452698: goto L9;
            case 964892555: goto L6;
            default: goto L44;
        };
    L44:
        return 0;
    L6:
        if (r101.equals("domain_change") == false) goto L44;
        return 6;
    L9:
        if (r101.equals("push") == false) goto L44;
        return 2;
    L12:
        if (r101.equals(SystemBatteryRecoder.BatteryRecordReason.POLLING) == false) goto L44;
        return 4;
    L15:
        if (r101.equals("cold_start") == false) goto L44;
        int r103 = f.f564242a[r100.ordinal()];
        if (r103 == 1) goto L27;
        if (r103 == 2) goto L24;
        if (r103 != 3) goto L30;
        LuckyDogLocalSettings r104 = h.a();
        if (r104 == null) goto L30;
        String r105 = r104.getPollSettings();
    L31:
        if (r105 != null) goto L33;
    L34:
        r102 = true;
    L35:
        if (r102 == false) goto L37;
        return 1;
    L37:
        return 3;
    L33:
        if (r105.length() != 0) goto L35;
    L30:
        r105 = null;
        goto L31
    L24:
        LuckyDogLocalSettings r106 = h.a();
        if (r106 == null) goto L30;
        r105 = r106.getDynamicSettings();
        goto L31
    L27:
        LuckyDogLocalSettings r107 = h.a();
        if (r107 == null) goto L30;
        r105 = r107.getStaticSettings();
        goto L31
    L39:
        if (r101.equals("hot_start") == false) goto L44;
        return 5;
    L42:
        if (r101.equals("needle") == false) goto L44;
        return 2;
    }
}
