package com.ss.android.lark.feed.shared.data.utils;

import android.app.Application;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.utils.LarkContext;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f421171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c7c.a f421172b;

    static {
        f421171a = new ConcurrentHashMap();
    }

    public static String a(long r100) {
        if (r100 != 0) goto L5;
        return "";
    L5:
        Application r101 = LarkContext.getApplication();
        Date r102 = new Date(r100);
        if (f421172b != null) goto L22;
        monitor-enter(f.class);
        heb.a.f484903a.getSettingDependency().a();     // Catch: Throwable -> L18
        c7c.a r103 = f421172b;     // Catch: Throwable -> L18
        if (r103 != null) goto L12;
    L15:
        c7c.a r104 = new c7c.a();     // Catch: Throwable -> L18
        r104.b(DisplayPattern.RELATIVE);     // Catch: Throwable -> L18
        r104.c(LengthType.SHORT);     // Catch: Throwable -> L18
        r104.d(TimePreciseness.MINUTE);     // Catch: Throwable -> L18
        r104.f22686j = true;     // Catch: Throwable -> L18
        r104.f22684h = false;     // Catch: Throwable -> L18
        f421172b = r104;     // Catch: Throwable -> L18
        ((ConcurrentHashMap) f421171a).clear();     // Catch: Throwable -> L18
        monitor-exit(f.class);
        goto L22
    L12:
        if (r103.f22684h == true) goto L15;
        monitor-exit(f.class);
    L18:
        th = move-exception;
        throw th;
    L22:
        return c7c.b.c(r101, r102, f421172b);
    }

    public static void b(UIFeedCard r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getId() == null) goto L8;
        Map<String, String> r101 = f421171a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100.getId(), a(r100.getDisplayTime()));
        return;
    }
}
