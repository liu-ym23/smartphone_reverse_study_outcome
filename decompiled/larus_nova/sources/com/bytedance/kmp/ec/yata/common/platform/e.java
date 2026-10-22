package com.bytedance.kmp.ec.yata.common.platform;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements com.bytedance.kmp.ec.yata.common.utils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f251509a;

    @Override // com.bytedance.kmp.ec.yata.common.utils.a
    public final void b() {
        this.f251509a.removeCallbacksAndMessages(null);
    }

    public e() {
        this.f251509a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.kmp.ec.yata.common.utils.a
    public final void a(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f251509a.post(new d(r100));
    }
}
