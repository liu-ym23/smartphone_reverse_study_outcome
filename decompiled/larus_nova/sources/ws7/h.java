package ws7;

import android.content.SharedPreferences;
import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f561075a;

    public static String a(String r100, String r101) {
        SharedPreferences r102 = f561075a;
        if (r102 != null) goto L11;
        return r101;
    L11:
        byte[] r103 = Base64.decode(r102.getString(r100, r101), 2);     // Catch: Throwable -> L7
    L8:
        if (r103 != null) goto L10;
        return r101;
    L10:
        return new String(r103);
    L7:
        r103 = null;
        goto L8
    }

    public static void b(String r100, boolean r101) {
        SharedPreferences r102 = f561075a;
        if (r102 == null) goto L8;
        if (r100 == null) goto L9;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putBoolean(r100, r101);
        r103.apply();
        return;
    L9:
        return;
    }

    public static void c(String r100, String r101) {
        SharedPreferences r102 = f561075a;
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r101 != null) goto L7;
        r103.remove(r100);
    L8:
        r103.apply();
        return;
    L7:
        r103.putString(r100, i.a(r101));
        goto L8
    }
}
