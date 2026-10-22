package uc8;

import android.app.Application;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f549656a = null;

    static {
        f549656a = new a();
    }

    public a() {
    }

    public static boolean a() {
        Application r100 = AppHost.f326268a.getApplication();
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.POST_NOTIFICATIONS") != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        return NotificationManagerCompat.from(r100).areNotificationsEnabled();
    }
}
