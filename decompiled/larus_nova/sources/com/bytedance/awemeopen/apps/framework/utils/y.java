package com.bytedance.awemeopen.apps.framework.utils;

import android.view.View;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, Long> f197749a = null;

    static {
        f197749a = new WeakHashMap();
    }

    public static boolean a(View r100) {
        return b(r100, AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    }

    public static boolean b(View r100, long r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        WeakHashMap<View, Long> r103 = f197749a;
        Long r104 = r103.get(r100);
        long r105 = System.nanoTime() / 1000000;
        if (r104 != null) goto L10;
        r103.put(r100, Long.valueOf(r105));
        return false;
    L10:
        if ((r105 - r104.longValue()) > r101) goto L12;
        r102 = true;
    L12:
        if (r102 == true) goto L14;
        r103.put(r100, Long.valueOf(r105));
    L14:
        return r102;
    }
}
