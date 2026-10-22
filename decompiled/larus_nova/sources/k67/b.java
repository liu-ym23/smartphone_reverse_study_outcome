package k67;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c67.b f501968a;

    public static String d(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        String r102 = "Unknown";
    L12:
        String r103 = "PrivacySDK-1.2.8-" + r102;
        if (Build.VERSION.SDK_INT < 26) goto L15;
    L33:
        return r103;
    L15:
        if (r103.length() <= 23) goto L33;
        String r104 = "1.2.8".replace("-SNAPSHOT", ExifInterface.LATITUDE_SOUTH).replaceAll("[^0-9A-Za-z.]", "");
        if (r104.isEmpty() == false) goto L20;
        r104 = "unknown";
    L20:
        String r105 = "PSDK-".concat(r104);
        if (r105.length() >= 23) goto L23;
        int r106 = (23 - r105.length()) - 1;
        if (r106 > 0) goto L28;
        return r105;
    L28:
        if (r102.length() <= r106) goto L32;
        r102 = r102.substring(r102.length() - r106);
    L32:
        return r105 + "-" + r102;
    L23:
        return r105.substring(0, 23);
    L11:
        r102 = r100.trim();
        goto L12
    L5:
        if (r100.trim().isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static void a(String r100, String r101) {
        String r102 = d(r100);
        c67.b r103 = f501968a;
        if (r103 == null) goto L6;
        r103.i(r102, r101);
        return;
    }

    public static void b(String r100, String r101) {
        String r102 = d(r100);
        c67.b r103 = f501968a;
        if (r103 == null) goto L6;
        r103.e(r102, r101);
        return;
    }

    public static void c(String r100, String r101) {
        String r102 = d(r100);
        c67.b r103 = f501968a;
        if (r103 == null) goto L6;
        r103.e(r102, r101);
        return;
    }

    public static void e(String r100, String r101) {
        String r102 = d(r100);
        c67.b r103 = f501968a;
        if (r103 == null) goto L6;
        r103.i(r102, r101);
        return;
    }
}
