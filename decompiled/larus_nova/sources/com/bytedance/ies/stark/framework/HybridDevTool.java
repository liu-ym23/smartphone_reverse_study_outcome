package com.bytedance.ies.stark.framework;

import android.app.Activity;
import android.content.Intent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class HybridDevTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f248625a = null;

    static {
        f248625a = LazyKt.lazy(HybridDevTool$hdtService$2.INSTANCE);
    }

    @JvmStatic
    public static final void startActivity(Activity r100, Intent r101, Function2<? super Integer, ? super Intent, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "listener");
        s46.a r103 = (s46.a) f248625a.getValue();
        if (r103 == null) goto L6;
        r103.startActivity(r100, r101, r102);
        return;
    }
}
