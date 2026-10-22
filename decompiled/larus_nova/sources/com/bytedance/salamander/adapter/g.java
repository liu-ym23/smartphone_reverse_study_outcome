package com.bytedance.salamander.adapter;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f267781a;

    public g() {
        this.f267781a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        return this.f267781a.post(r100);
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        return this.f267781a.postDelayed(r100, r101);
    }
}
