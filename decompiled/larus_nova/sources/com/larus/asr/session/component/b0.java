package com.larus.asr.session.component;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f287682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f287683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f287684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f287685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f287686e;

    public final f0 getContext() {
        return this.f287682a;
    }

    public b0(f0 r100, com.larus.asr.session.l r101, com.larus.asr.session.m r102, Function0 r103, com.larus.asr.session.h r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callbacks");
        Intrinsics.checkNotNullParameter(r102, "engineExtensions");
        Intrinsics.checkNotNullParameter(r103, "beforeEngineStart");
        Intrinsics.checkNotNullParameter(r104, "isActive");
        this.f287682a = r100;
        this.f287683b = r101;
        this.f287684c = r102;
        this.f287685d = r103;
        this.f287686e = r104;
    }
}
