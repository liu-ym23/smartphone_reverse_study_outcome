package com.ss.android.downloadlib.applink;

import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes34.dex */
public class MarketOnlineStatusChecker {
    private static final String TAG = null;
    private static int romMarket;

    public @interface RomMarket {
        public static final int HONOR = 16;
        public static final int HUAWEI = 1;
        public static final int OPPO = 2;
        public static final int UNCHECK = 0;
        public static final int UNKNOWN = 15;
        public static final int VIVO = 4;
        public static final int XIAOMI = 8;
    }

    public MarketOnlineStatusChecker() {
    }

    static {
        TAG = "MarketOnlineStatusChecker";
        romMarket = 0;
    }

    public static boolean isApkInMarket(int r100) {
        int r101 = romMarket;
        if (r101 == 0) goto L10;
        if (r101 != 15) goto L7;
        return true;
    L7:
        if ((r100 & r101) != r101) goto L45;
        return true;
    L45:
        return false;
    L10:
        String r102 = RomUtils.getName();
        r102.getClass();
        byte r103 = -1;
        switch(r102.hashCode()) {
            case 2132284: goto L26;
            case 2366768: goto L22;
            case 2634924: goto L18;
            case 1547013345: goto L14;
            default: goto L29;
        };
    L29:
        switch(r103) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            default: goto L31;
        };
    L34:
        romMarket = 16;
    L38:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "isApkInMarket", "当前的应用商店标识为:" + romMarket + ",打包传递的上架标识为:" + r100);
        int r104 = romMarket;
        if (r104 != 15) goto L42;
        return true;
    L42:
        if ((r100 & r104) != r104) goto L46;
        return true;
    L46:
        return false;
    L35:
        romMarket = 4;
        goto L38
    L36:
        romMarket = 8;
        goto L38
    L37:
        romMarket = 1;
        goto L38
    L31:
        if (RomUtils.isOppo() == false) goto L33;
        romMarket = 2;
        goto L38
    L33:
        romMarket = 15;
        goto L38
    L14:
        if (r102.equals(RomUtils.ROM_MAGICUI) == false) goto L29;
        r103 = 3;
        goto L29
    L18:
        if (r102.equals("VIVO") == false) goto L29;
        r103 = 2;
        goto L29
    L22:
        if (r102.equals("MIUI") == false) goto L29;
        r103 = 1;
        goto L29
    L26:
        if (r102.equals("EMUI") == false) goto L29;
        r103 = 0;
        goto L29
    }
}
