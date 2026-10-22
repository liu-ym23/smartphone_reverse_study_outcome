package com.larus.voicecall.impl;

import com.larus.voicecall.impl.plugins.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class y implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f379665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RealtimeCallService f379666b;

    public /* synthetic */ y(Function2 r100, RealtimeCallService r101) {
        this.f379665a = r100;
        this.f379666b = r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Function2 r102 = this.f379665a;
        RealtimeCallService r103 = this.f379666b;
        r r104 = (r) r100;
        com.larus.audio.call.arch.d r105 = (com.larus.audio.call.arch.d) r101;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "registry");
        if (r102 == null) goto L5;
        r102.invoke(r104, r105);
    L5:
        r105.a(new RealtimeCallService.a(r103, r104));
        return Unit.INSTANCE;
    }
}
