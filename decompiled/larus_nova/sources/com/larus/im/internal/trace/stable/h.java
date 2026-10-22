package com.larus.im.internal.trace.stable;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kf9.e f350197a;

    public /* synthetic */ h(kf9.e r100) {
        this.f350197a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        kf9.e r101 = this.f350197a;
        Map r102 = (Map) r100;
        Intrinsics.checkNotNullParameter(r102, "$this$buildCommonParams");
        kf9.g.a(r102, "query_round", Long.valueOf(r101.f503268d.f503219b));
        kf9.g.a(r102, "task_id", r101.f503268d.f503218a);
        kf9.g.a(r102, "is_hit_pre_query", Integer.valueOf(r101.f503268d.f503225h ? 1 : 0));
        kf9.g.a(r102, "query_begin_duration", Long.valueOf(r101.f503268d.f503221d));
        kf9.g.a(r102, "query_receive_first_duration", Long.valueOf(r101.f503268d.f503222e));
        kf9.g.a(r102, "duration", Long.valueOf(r101.f503268d.f503231n));
        kf9.g.a(r102, "audio_full_duration", Long.valueOf(r101.f503268d.f503233p));
        return Unit.INSTANCE;
    }
}
