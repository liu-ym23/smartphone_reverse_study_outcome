package com.bytedance.timonkit.media_observer;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class h {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a() {
        if (d.f270919a.isEmpty() == true) goto L5;
    L10:
        int r100 = th7.a.f545963a;
        Function0<? extends Handler> r101 = TimonMediaObserverManager.f270916a;
        Handler r102 = new Handler(Looper.getMainLooper());
        final Uri r103 = null;
        final Object[] r104 = 0 == true ? 1 : 0;
        r102.post(new g(r103, r104));
        return;
    L5:
        if (d.f270920b.isEmpty() == false) goto L10;
        if (d.f270921c.isEmpty() == false) goto L10;
        Function0<? extends Handler> r105 = TimonMediaObserverManager.f270916a;
    }
}
