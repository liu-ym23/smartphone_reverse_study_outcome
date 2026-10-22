package com.bytedance.dux.window.controller;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.dux.common.live_data.NextLiveData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hm4.d;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, d> f205936a = null;

    static {
        f205936a = new ConcurrentHashMap();
        new ConcurrentHashMap();
        new CopyOnWriteArraySet();
    }

    public static d b() {
        em4.d.b("DuxViewConfigStore", "getGlobalBreakPointUpdate：view is null");
        d r100 = f205936a.get(0);
        Resources r101 = Resources.getSystem();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        float r103 = r102.widthPixels;
        float r104 = r102.density;
        hm4.a r105 = new hm4.a(r103 / r104, r102.heightPixels / r104);
        List<hm4.b> r106 = hm4.c.f485930c;
        ListIterator<hm4.b> r107 = r106.listIterator(r106.size());
    L3:
        hm4.b r108 = null;
        if (r107.hasPrevious() == false) goto L11;
        hm4.b r109 = r107.previous();
        if (r105.f485914a < r109.f485928a) goto L8;
        boolean r110 = true;
    L9:
        if (r110 == false) goto L3;
    L12:
        hm4.b r111 = r109;
        if (r111 != null) goto L15;
        r111 = hm4.b.f485918c;
    L15:
        List<hm4.b> r112 = hm4.c.f485930c;
        ListIterator<hm4.b> r113 = r112.listIterator(r112.size());
    L17:
        if (r113.hasPrevious() == false) goto L24;
        hm4.b r114 = r113.previous();
        if (r105.f485915b < r114.f485928a) goto L21;
        boolean r115 = true;
    L22:
        if (r115 == false) goto L17;
        r108 = r114;
        goto L24
    L21:
        r115 = false;
    L24:
        hm4.b r116 = r108;
        if (r116 != null) goto L27;
        r116 = hm4.b.f485918c;
    L27:
        d r117 = new d(r111, r116, r105);
        f205936a.put(0, r117);
        return r117;
    L8:
        r110 = false;
        goto L9
    L11:
        r109 = null;
        goto L12
    }

    public static CopyOnWriteArraySet a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = c(r100).get(Integer.valueOf(R.id.dux_window_break_point_store));
        if ((r101 instanceof CopyOnWriteArraySet) == true) goto L7;
        return null;
    L7:
        return (CopyOnWriteArraySet) r101;
    }

    public static ConcurrentHashMap c(View r100) {
        Object r101 = r100.getTag(R.id.dux_window_view_tag);
        ConcurrentHashMap r102 = null;
        if ((r101 instanceof ConcurrentHashMap) == false) goto L5;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r101;
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        monitor-enter(r100);
        Object r104 = r100.getTag(R.id.dux_window_view_tag);     // Catch: Throwable -> L16
        if ((r104 instanceof ConcurrentHashMap) == false) goto L12;
        r102 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L16
    L12:
        if (r102 != null) goto L14;
        r102 = new ConcurrentHashMap(2);     // Catch: Throwable -> L16
        r100.setTag(R.id.dux_window_view_tag, r102);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);
        return r102;
    L16:
        th = move-exception;
        throw th;
    L5:
        r103 = null;
        goto L6
    }

    public static void d(View r100, NextLiveData r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Integer r102 = Integer.valueOf(R.id.dux_window_view_break_point_live_data);
        if (r101 != null) goto L5;
        c(r100).remove(r102);
        return;
    L5:
        c(r100).put(r102, r101);
    }

    public static void e(View r100, NextLiveData r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Integer r102 = Integer.valueOf(R.id.dux_window_view_window_size_live_data);
        if (r101 != null) goto L5;
        c(r100).remove(r102);
        return;
    L5:
        c(r100).put(r102, r101);
    }
}
