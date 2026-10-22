package com.larus.im.internal.delegate;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f348260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f348261b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final buc.a f348262c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final buc.a f348263d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Job f348264e;

    public u0() {
    }

    static {
        f348260a = LazyKt.lazy(new s0());
        f348261b = LazyKt.lazy(new t0());
        f348262c = buc.b.a(false);
        f348263d = buc.b.a(false);
    }

    public static void a() {
        if (b.f348193b.b() == false) goto L9;
        f348262c.d(true);
        a.f348188b.i("FlowRePullRecentHandler", "rePullIfNeed start");
        Job r100 = f348264e;
        if (r100 == null) goto L7;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L7:
        f348264e = com.larus.im.internal.database.utils.e.c(new FlowRePullRecentHandler$rePullIfNeed$1(null));
        return;
    }
}
