package com.bytedance.kmp.performance.platform;

import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import android.view.Window;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f252802a = null;

    static {
        f252802a = new f();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.kmp.performance.platform.b] */
    public static b a(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        final f r101 = f252802a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ArrayList) r101.f252781d).add(r100);
        if (r101.f252782e.b(true) == true) goto L18;
        Context r102 = com.bytedance.kmp.performance.b.f252707a.getContext();
        if (r102 == null) goto L7;
        Window r103 = a.a(r102);
    L8:
        if (r103 == null) goto L15;
        c r104 = r101.f252784g;
        if (r104 == null) goto L15;
        if (Build.VERSION.SDK_INT < 24) goto L15;
        Intrinsics.checkNotNull(r104);
        r103.addOnFrameMetricsAvailableListener(r104, r101.f252778a);
    L15:
        if (r101.f252783f == null) goto L18;
        Choreographer.getInstance().postFrameCallback(r101.f252783f);
        goto L18
    L7:
        r103 = null;
    L18:
        return new b(r101, r100);
    }
}
