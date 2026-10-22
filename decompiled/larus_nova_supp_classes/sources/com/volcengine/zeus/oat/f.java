package com.volcengine.zeus.oat;

import android.os.Build;
import com.volcengine.zeus.Zeus;
import dqc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static void a() {
        int r0 = Build.VERSION.SDK_INT;
        boolean r2 = true;
        if (r0 > 25) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L16;
        if (r0 >= 29) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == true) goto L16;
        return;
    L10:
        if (r0 > 30) goto L12;
    L16:
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L18;
        return;
    L18:
        e.b(new a());
        return;
    L5:
        r1 = false;
        goto L6
    }
}
