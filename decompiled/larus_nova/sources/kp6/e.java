package kp6;

import android.app.Application;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public static Locale a() {
        com.bytedance.locallife.cube.c.c();
        Application r100 = com.bytedance.locallife.biz.base.cube.d.f256534a.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        return r100.getResources().getConfiguration().getLocales().get(0);
    L10:
        return r100.getResources().getConfiguration().locale;
    }
}
