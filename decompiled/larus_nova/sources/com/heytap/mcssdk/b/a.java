package com.heytap.mcssdk.b;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.heytap.mcssdk.utils.f;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f276297a = "Heytap PUSH";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f276298b = "System Default Channel";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f276299c = 3;

    public a() {
    }

    private boolean a(Context r100, String r101, String r102, int r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        NotificationManager r104 = (NotificationManager) r100.getSystemService("notification");
        if (r104 != null) goto L8;
        return false;
    L8:
        r104.createNotificationChannel(new NotificationChannel(r101, r102, r103));
        return true;
    }

    public static /* synthetic */ boolean a(a r100, Context r101, String r102, String r103, int r104) {
        return r100.a(r101, r102, r103, r104);
    }

    public void a(final Context r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        f.a(new AnonymousClass1(this, r100));
    }
}
