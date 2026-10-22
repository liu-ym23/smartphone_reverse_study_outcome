package com.bytedance.live.kmp.core;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final void a() {
        Intrinsics.checkNotNullParameter(KmpEnv.f255139a, "$this$isBuildConfigDebug");
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    public static final void call(Function1<? super kjc.c<Unit>, ? extends kjc.b<Unit>> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Unit r101 = r100.invoke(new kjc.c()).f503729a;
    }
}
