package com.larus.office.base;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f361042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<r0.b, r0.a, Unit> f361043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f361044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile OfficeSdkLoginType f361045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f361046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f361047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f361048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f361049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f361050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f361051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f361052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f361053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f361054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f361055n;

    public static final class a {
    }

    static {
    }

    public q0(int r100) {
        Function0<Long> r101 = new o0();
        Function2<r0.b, r0.a, Unit> r102 = new p0();
        Intrinsics.checkNotNullParameter(r101, "clock");
        Intrinsics.checkNotNullParameter(r102, "report");
        this.f361042a = r101;
        this.f361043b = r102;
        this.f361044c = "unknown";
        this.f361045d = OfficeSdkLoginType.FAST_LOGIN;
        this.f361054m = "unknown";
        this.f361055n = new AtomicBoolean(false);
    }

    public final void b(OfficeSdkLoginType r100) {
        Intrinsics.checkNotNullParameter(r100, "loginType");
        this.f361045d = r100;
        if (this.f361053l == false) goto L5;
        this.f361047f = 0;
        this.f361048g = 0;
    L5:
        this.f361053l = true;
        this.f361049h = this.f361042a.invoke().longValue();
        this.f361050i = 0;
        this.f361051j = 0;
        this.f361052k = 0;
        this.f361055n.set(false);
    }

    public final void a(long r210, long r211, long r212, long r213, boolean r214) {
        this.f361043b.invoke(new r0.b(this.f361047f, this.f361048g, r210, this.f361052k, r211, r212, r213, r214), new r0.a(this.f361044c, this.f361045d, this.f361054m));
    }
}
