package com.bytedance.rts.foundation;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f267588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f267589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f267590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f267591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f267592e;

    public s(Function0<Unit> r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "sourceLooper");
        this.f267588a = r100;
        this.f267592e = r101;
        this.f267590c = 0;
        this.f267589b = SystemClock.uptimeMillis();
        this.f267591d = false;
    }

    public s(Function0<Unit> r100, n r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "sourceLooper");
        this.f267588a = r100;
        this.f267592e = r101;
        this.f267590c = r102;
        this.f267589b = SystemClock.uptimeMillis() + r102;
        this.f267591d = r103;
    }
}
