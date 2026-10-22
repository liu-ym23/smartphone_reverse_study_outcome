package com.bytedance.locallife.common.utils;

import android.view.View;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, Long> f257146a = null;

    static {
        f257146a = new WeakHashMap();
    }

    public static boolean a(View r100) {
        boolean r101 = false;
        if (r100 == null) goto L13;
        WeakHashMap<View, Long> r102 = f257146a;
        Long r103 = r102.get(r100);
        long r104 = System.nanoTime() / 1000000;
        if (r103 != null) goto L9;
        r102.put(r100, Long.valueOf(r104));
        goto L13
    L9:
        if ((r104 - r103.longValue()) > AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME) goto L11;
        r101 = true;
    L11:
        if (r101 == true) goto L13;
        r102.put(r100, Long.valueOf(r104));
    L13:
        return r101;
    }
}
