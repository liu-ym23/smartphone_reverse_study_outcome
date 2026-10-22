package com.bytedance.ruler.utils;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AsyncExecutorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<List<Function0<Unit>>> f267755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Boolean> f267756b = null;

    static {
        f267755a = new ThreadLocal();
        f267756b = new ThreadLocal();
    }

    public static final void b() {
        f267756b.set(Boolean.FALSE);
        ThreadLocal<List<Function0<Unit>>> r100 = f267755a;
        final List<Function0<Unit>> r101 = r100.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 0) goto L9;
        r100.set(new ArrayList());
        Handler r102 = a.f267757a;
        a.a(new AsyncExecutorKt$dispatchBackgroundJobsAndStopCollecting$1$1(r101), 0);
        return;
    }

    public static final void a(Function0<Unit> r100) {
        if (com.bytedance.ruler.d.f267688l == true) goto L5;
        r100.invoke();
        return;
    L5:
        if (Intrinsics.areEqual(f267756b.get(), Boolean.TRUE) == false) goto L14;
        ThreadLocal<List<Function0<Unit>>> r101 = f267755a;
        if (r101.get() != null) goto L9;
        r101.set(new ArrayList());
    L9:
        List<Function0<Unit>> r102 = r101.get();
        if (r102 == null) goto L15;
        r102.add(r100);
        return;
    L15:
        return;
    }
}
