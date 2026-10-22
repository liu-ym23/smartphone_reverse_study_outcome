package com.ss.android.lark.appcontext.applifecycle2.api;

import android.app.Activity;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.appcontext.applifecycle2.impl.c;
import com.ss.android.lark.log.Log;
import java.util.LinkedList;
import jva.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f408875a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b() {
        c r100 = AppLifecycle2.f408863a;
        if (r100 == null) goto L15;
        boolean r101 = r100.f408890e.f408871a;
        boolean r102 = r100.f408887b.isForeground();
        if (z.e(r100.f408886a) == false) goto L12;
        if (r101 == r102) goto L12;
        Log.e("AppLifecycle2", "isAppForeground() state not match, need check", new IllegalStateException("appFront=" + r101 + ", processFront=" + r102), true);
        if (r100.f408889d == false) goto L10;
        r101 = z.d(r100.f408886a);
        goto L12
    L10:
        if (r102 == false) goto L12;
        r101 = true;
    L12:
        if (r101 == true) goto L17;
        if (r102 == false) goto L15;
        return true;
    L17:
        return true;
    L15:
        return false;
    }

    @JvmStatic
    public static final Activity a() {
        return AppLifecycle2.a().getTopActivity();
    }

    @JvmStatic
    public static final void c(y r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        c r101 = AppLifecycle2.f408863a;
        AppLifecycle2.d(new AppLifecycle2.a(r100));
    }

    @JvmStatic
    public static final void d(y r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        c r101 = AppLifecycle2.f408863a;
        AppLifecycle2.a r102 = new AppLifecycle2.a(r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        c r103 = AppLifecycle2.f408863a;
        if (r103 == null) goto L5;
        r103.b(r102);
        return;
    L5:
        LinkedList<b> r104 = AppLifecycle2.f408864b;
        monitor-enter(r104);
        r104.remove(r102);     // Catch: Throwable -> L10
        monitor-exit(r104);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
