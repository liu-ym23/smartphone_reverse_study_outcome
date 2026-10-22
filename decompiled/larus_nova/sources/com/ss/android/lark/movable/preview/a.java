package com.ss.android.lark.movable.preview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f432702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f432703b = null;

    static {
        f432702a = new ConcurrentHashMap();
        f432703b = new AtomicInteger(0);
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L3:
        if (r100 == null) goto L15;
        if ((r100 instanceof MovablePreviewActivity) == true) goto L6;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        ContextWrapper r101 = (ContextWrapper) r100;
    L12:
        if (r101 != null) goto L13;
        r100 = null;
        goto L3
    L13:
        r100 = r101.getBaseContext();
        goto L3
    L11:
        r101 = null;
        goto L12
    L6:
        return true;
    L15:
        return false;
    }

    public static void b(Context r100, int r101, String r102, int r103) {
        Intent r104 = new Intent(r100, MovablePreviewActivity.class);
        if ((r100 instanceof Activity) == true) goto L5;
        r104.addFlags(268435456);
    L5:
        r104.putExtra("key:movable:preview:type", r101);
        String r105 = "movable_md_" + f432703b.incrementAndGet();
        f432702a.put(r105, r102);
        r104.putExtra("key:movable:preview:markdown:key", r105);
        r104.putExtra("key:movable:source:instance:id", r103);
        r100.startActivity(r104);
    }
}
