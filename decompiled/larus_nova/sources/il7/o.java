package il7;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: classes22.dex */
public final class o {
    public static void a(Context r100, String r101) {
        new Handler(Looper.getMainLooper()).post(new n(r100, r101));
    }

    public static void b(Context r100, int r101, View r102) {
    L10:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ToastUtil", "showToastSafely meet throwable");
        return;
    L3:
        if (Build.VERSION.SDK_INT == 25) goto L5;
    L7:
        Toast r103 = new Toast(r100);     // Catch: Throwable -> L10
    L8:
        r103.setGravity(17, 0, 0);     // Catch: Throwable -> L10
        r103.setDuration(r101);     // Catch: Throwable -> L10
        r103.setView(r102);     // Catch: Throwable -> L10
        r103.show();     // Catch: Throwable -> L10
        return;
    L5:
        if (to7.c.b() == null) goto L7;
        r103 = new Toast(to7.c.b());     // Catch: Throwable -> L10
        goto L8
    }
}
