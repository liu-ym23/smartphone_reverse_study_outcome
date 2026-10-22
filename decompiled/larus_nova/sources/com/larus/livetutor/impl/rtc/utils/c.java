package com.larus.livetutor.impl.rtc.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f356416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f356417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f356418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f356419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f356420e;

    public final void a(T r100) {
        if (this.f356419d == true) goto L6;
        this.f356419d = true;
        this.f356418c.removeCallbacks(this.f356420e);
        this.f356416a.invoke(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.livetutor.impl.rtc.utils.b, java.lang.Runnable] */
    public c(Function1<? super T, Unit> r100, long r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f356416a = r100;
        this.f356417b = r102;
        Handler r103 = new Handler(Looper.getMainLooper());
        this.f356418c = r103;
        ?? r104 = new b(this);
        this.f356420e = r104;
        r103.postDelayed(r104, r101);
    }
}
