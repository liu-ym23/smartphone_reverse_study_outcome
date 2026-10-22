package iac;

import android.app.NotificationManager;
import android.content.Context;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f488977c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationManager f488978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f488979b;

    public a(Context r100) {
        this.f488979b = new ConcurrentHashMap();
        r100.getApplicationContext();
        this.f488978a = (NotificationManager) r100.getSystemService("notification");
    }

    public static a b(Context r100) {
        if (f488977c != null) goto L13;
        monitor-enter(a.class);
        f488977c = new a(r100);     // Catch: Throwable -> L9
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f488977c;
    }

    public final void a(int r100) {
        Map<Integer, String> r101 = this.f488979b;     // Catch: Exception -> L6
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;     // Catch: Exception -> L6
        if (r102.containsKey(Integer.valueOf(r100)) == false) goto L11;
        this.f488978a.cancel(r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e(e.getMessage(), e);
    }
}
