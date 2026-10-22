package yk6;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f568230a;

    public f() {
        this.f568230a = new Handler(Looper.getMainLooper());
    }

    public final void a(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f568230a.post(new a(r100));
    }
}
