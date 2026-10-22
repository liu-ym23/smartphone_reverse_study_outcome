package com.bytedance.crash.dumper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.crash.util.s;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.io.Serializable;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleInfo implements Serializable {
    private static final String FILE_NAME = "locale.inf";
    private static final String KEY_LOC_NETWORK_ACCESS = "access";
    private static final String KEY_LOC_TIMEZONE = "timezone";
    private static final String UNKNOWN = "unknown";
    private static final long serialVersionUID = 1;
    public final String mNetworkAccessType;
    public final int mTimeZone;

    public static String getNetworkAccessType() {
        String[] r100 = com.bytedance.crash.util.l.f203414a;
        char r101 = 0;
        Context r102 = com.bytedance.crash.i.getContext();     // Catch: Throwable -> L26
        if (r102 == null) goto L27;
        ConnectivityManager r103 = (ConnectivityManager) r102.getSystemService("connectivity");     // Catch: Throwable -> L26
        if (r103 == null) goto L27;
        NetworkInfo r104 = r103.getActiveNetworkInfo();     // Catch: Throwable -> L26
        if (r104 == null) goto L27;
        if (r104.isAvailable() == false) goto L27;
        int r105 = r104.getType();     // Catch: Throwable -> L26
        char r106 = 1;
        if (1 == r105) goto L29;
        if (r105 != 0) goto L25;
        switch(((TelephonyManager) r102.getSystemService("phone")).getNetworkType()) {
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L23;
            case 7: goto L25;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L23;
            case 11: goto L25;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L23;
            case 15: goto L23;
            case 16: goto L25;
            case 17: goto L25;
            case 18: goto L25;
            case 19: goto L25;
            case 20: goto L21;
            default: goto L25;
        };
    L21:
        r106 = 6;
        goto L29
    L22:
        r106 = 5;
        goto L29
    L23:
        r106 = 4;
        goto L29
    L24:
        r106 = 3;
    L25:
        r106 = 2;
    L29:
        if (r106 >= 7) goto L32;
        r101 = r106;
    L32:
        String r107 = com.bytedance.crash.util.l.f203414a[r101];
        if (TextUtils.isEmpty(r107) == false) goto L38;
        return "unknown";
    L38:
        return r107;
    L27:
        r106 = 0;
        goto L29
    }

    private LocaleInfo() {
        this.mNetworkAccessType = getNetworkAccessType();
        this.mTimeZone = getTimeZone();
    }

    public static int getTimeZone() {
        int r100 = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (r100 >= (-12)) goto L6;
        return -12;
    L6:
        if (r100 <= 12) goto L10;
        return 12;
    L10:
        return r100;
    }

    public static void dump(File r100) {
        s.b(new PolarisFileWrapper(r100, FILE_NAME), new LocaleInfo());
    }

    public static LocaleInfo load(File r100) {
        return (LocaleInfo) s.a(new PolarisFileWrapper(r100, FILE_NAME));
    }

    public static void putTo(JSONObject r100) {
        putTo(r100, null);
    }

    public static void putTo(JSONObject r100, File r101) {
        if (r101 == null) goto L4;
        LocaleInfo r102 = load(r101);
    L5:
        if (r102 == null) goto L11;
        r100.put(KEY_LOC_NETWORK_ACCESS, r102.mNetworkAccessType);     // Catch: JSONException -> L8
        r100.put(KEY_LOC_TIMEZONE, r102.mTimeZone);     // Catch: JSONException -> L8
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r102 = new LocaleInfo();
        goto L5
    }
}
