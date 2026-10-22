package x37;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static boolean a(Context r100, String r101) {
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationManager r102 = (NotificationManager) r100.getSystemService("notification");     // Catch: Exception -> L15
        if (r102 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        if (r102.getNotificationChannel(r101) == null) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L14:
        return true;
    }
}
