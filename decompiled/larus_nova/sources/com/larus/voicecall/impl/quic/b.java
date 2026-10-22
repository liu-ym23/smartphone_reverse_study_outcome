package com.larus.voicecall.impl.quic;

import com.larus.voicecall.impl.plugins.r;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o3a.i;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class b implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f378674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QuicCallService f378675b;

    public /* synthetic */ b(i r100, QuicCallService r101) {
        this.f378674a = r100;
        this.f378675b = r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Function2 r102 = this.f378674a;
        QuicCallService r103 = this.f378675b;
        r r104 = (r) r100;
        com.larus.audio.call.arch.d r105 = (com.larus.audio.call.arch.d) r101;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "registry");
        if (r102 == null) goto L5;
        r102.invoke(r104, r105);
    L5:
        r105.a(new QuicCallService.a(r103, r104));
        return Unit.INSTANCE;
    }
}
