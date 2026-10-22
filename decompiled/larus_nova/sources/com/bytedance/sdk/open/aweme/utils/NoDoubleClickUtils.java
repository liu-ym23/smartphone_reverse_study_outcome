package com.bytedance.sdk.open.aweme.utils;

import android.view.View;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes22.dex */
public class NoDoubleClickUtils {
    private static final int DEFAULT_SPACE_TIME = 1200;
    private static final WeakHashMap<View, Long> lastClickTimeMap = null;

    static {
        lastClickTimeMap = new WeakHashMap();
    }

    public NoDoubleClickUtils() {
    }

    public static void clear() {
        lastClickTimeMap.clear();
    }

    public static boolean isDoubleClick(View r100) {
        return isDoubleClick(r100, AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    }

    public static boolean isDoubleClick(View r100, long r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        WeakHashMap<View, Long> r103 = lastClickTimeMap;
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
