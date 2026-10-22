package op1;

import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f524694a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        char[] r101 = r100.toCharArray();
        StringBuffer r102 = new StringBuffer();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        String r105 = Integer.toHexString(r101[r104]);
        r102.append("\\u");
        if (r105.length() >= 4) goto L10;
        r102.append(AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON.substring(r105.length(), 4));
    L10:
        r102.append(r105);
        r104 = r104 + 1;
        goto L6
    L12:
        return r102.toString();
    }
}
