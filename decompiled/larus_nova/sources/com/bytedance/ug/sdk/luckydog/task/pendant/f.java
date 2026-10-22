package com.bytedance.ug.sdk.luckydog.task.pendant;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f272223a = null;

    static {
        f272223a = new Handler(Looper.getMainLooper());
    }

    public static final void a(Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogUIExt", "ensureMainThread not int main thread");
        f272223a.post(new e(r100));
    }
}
