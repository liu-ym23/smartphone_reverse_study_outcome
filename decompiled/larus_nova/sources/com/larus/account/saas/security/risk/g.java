package com.larus.account.saas.security.risk;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f286530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f286531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f286532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f286533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f286534e;

    public static final class a {
    }

    static {
    }

    public g(i r100, h r101) {
        ExecutorService r102 = PThreadExecutorsUtils.newSingleThreadExecutor(new b());
        Handler r103 = com.larus.account.saas.runtime.internal.util.b.f286474a;
        Intrinsics.checkNotNullParameter(r100, "repository");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        Intrinsics.checkNotNullParameter(r102, "executor");
        Intrinsics.checkNotNullParameter(r103, "mainHandler");
        this.f286530a = r100;
        this.f286531b = r101;
        this.f286532c = r102;
        this.f286533d = r103;
        this.f286534e = new AtomicBoolean(false);
    }
}
