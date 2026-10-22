package com.bytedance.salamander.adapter;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements j {
    public final Handler a;

    public g() {
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean b(u r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        return this.a.post(r2);
    }

    @Override // com.bytedance.salamander.adapter.j
    public final boolean a(u r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        return this.a.postDelayed(r2, r3);
    }
}
