package com.ss.android.ugc.tools.mob.bus;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HandlerDispatcher f454831a = null;

    static {
        Looper r100 = Looper.getMainLooper();
        Intrinsics.checkNotNullParameter(r100, "$this$asHandler");
        if (Build.VERSION.SDK_INT < 28) goto L14;
        Object r101 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r100});
        if (r101 == null) goto L8;
        Handler r102 = (Handler) r101;
    L12:
        f454831a = HandlerDispatcherKt.from(r102, "fast-main");
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    L14:
        Constructor r103 = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L11
        r102 = (Handler) r103.newInstance(new Object[]{r100, null, Boolean.TRUE});
    L11:
        r102 = new Handler(r100);
        goto L12
    }
}
