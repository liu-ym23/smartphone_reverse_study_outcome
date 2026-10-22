package com.ss.android.ugc.aweme.search.common.utils;

import android.view.View;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/NoDoubleClickUtils;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class NoDoubleClickUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoDoubleClickUtils f452261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<View, Long> f452262b = null;

    private NoDoubleClickUtils() {
    }

    static {
        f452261a = new NoDoubleClickUtils();
        f452262b = new WeakHashMap();
    }

    public static boolean a(View r100) {
        long r101 = 1200;
        boolean r102 = false;
        if (r100 == null) goto L13;
        WeakHashMap<View, Long> r103 = f452262b;
        Long r104 = r103.get(r100);
        long r105 = System.nanoTime() / ((long) 1000000);
        if (r104 != null) goto L9;
        r103.put(r100, Long.valueOf(r105));
        goto L13
    L9:
        if ((r105 - r104.longValue()) > r101) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L13;
        r103.put(r100, Long.valueOf(r105));
    L13:
        return r102;
    }
}
