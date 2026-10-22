package mi7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f514094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile g f514095b;

    public g(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("zlink_sdk_sp.prefs") == false) goto L12;
        return;
    L12:
        f514094a = r100.getSharedPreferences("zlink_sdk_sp.prefs", 0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static g a(Context r100) {
        if (f514095b != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f514095b != null) goto L9;
        f514095b = new g(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f514095b;
    }
}
