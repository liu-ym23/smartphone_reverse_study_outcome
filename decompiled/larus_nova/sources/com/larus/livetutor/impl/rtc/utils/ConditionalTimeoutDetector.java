package com.larus.livetutor.impl.rtc.utils;

import com.larus.livetutor.impl.rtc.handler.InnerStateListener;
import com.larus.livetutor.impl.rtc.handler.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class ConditionalTimeoutDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f356410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f356411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f356412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f356413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f356414e;

    public final void a() {
        Job r100 = this.f356414e;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f356414e = null;
    }

    public final void b() {
        a();
        this.f356414e = BuildersKt.launch$default(this.f356410a, null, null, new ConditionalTimeoutDetector$start$1(this, null), 3, null);
    }

    public ConditionalTimeoutDetector(CoroutineScope r100, long r101, k r102, InnerStateListener.a r103) {
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        Intrinsics.checkNotNullParameter(r102, "condition");
        Intrinsics.checkNotNullParameter(r103, "timeoutCallback");
        this.f356410a = r100;
        this.f356411b = r101;
        this.f356412c = r102;
        this.f356413d = r103;
    }
}
