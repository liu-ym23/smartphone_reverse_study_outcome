package com.larus.bmhome.chat.bubble.floating.runtime;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f297539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Runnable> f297540b = null;

    static {
        f297539a = new Handler(Looper.getMainLooper());
        f297540b = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promptId");
        Runnable r101 = f297540b.remove(r100);
        if (r101 == null) goto L6;
        f297539a.removeCallbacks(r101);
        return;
    }

    public static void b(final pc8.e r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.RETAIN_PROMPT);
        a(r100.f528576a);
        if (r100.f528577b.f528573f.f528594c > 0) goto L5;
        long r101 = -1;
    L16:
        if (r101 != (-1)) goto L19;
        return;
    L19:
        if (r101 > 0) goto L22;
        j r102 = j.f297547a;
        String r103 = r100.f528576a;
        BubbleBannerDismissReason r104 = BubbleBannerDismissReason.AUTO_DISMISS;
        r102.getClass();
        j.c(r103, r104);
        return;
    L22:
        Runnable r105 = new a(r100);
        f297540b.put(r100.f528576a, r105);
        f297539a.postDelayed(r105, r101);
        return;
    L5:
        Long r106 = Long.valueOf(r100.f528580e);
        if (r106.longValue() <= 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L12;
        r106 = null;
    L12:
        if (r106 == null) goto L14;
        r101 = r106.longValue() - System.currentTimeMillis();
        goto L16
    L14:
        r101 = r100.f528577b.f528573f.f528594c * 1000;
        goto L16
    L8:
        r107 = false;
        goto L9
    }
}
