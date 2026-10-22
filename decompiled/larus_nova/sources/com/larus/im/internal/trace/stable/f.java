package com.larus.im.internal.trace.stable;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kf9.e f350195a;

    public /* synthetic */ f(kf9.e r100) {
        this.f350195a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        kf9.e r101 = this.f350195a;
        Map r102 = (Map) r100;
        Intrinsics.checkNotNullParameter(r102, "$this$buildCommonParams");
        kf9.g.a(r102, "query_round", Long.valueOf(r101.f503268d.f503219b));
        kf9.g.a(r102, "task_id", r101.f503268d.f503218a);
        kf9.g.a(r102, "intention", r101.f503269e.f503239a);
        kf9.g.a(r102, "query_begin_duration", Long.valueOf(r101.f503268d.f503221d));
        kf9.g.a(r102, "query_receive_first_duration", Long.valueOf(r101.f503268d.f503222e));
        kf9.g.a(r102, "query_full_duration", Long.valueOf(r101.f503268d.f503233p));
        kf9.g.a(r102, "query_end_duration", Long.valueOf(r101.f503268d.f503231n));
        kf9.g.a(r102, "audio_first_generate_duration", Long.valueOf(r101.f503269e.f503259u));
        kf9.g.a(r102, "audio_first_link_duration", Long.valueOf(r101.f503269e.f503244f));
        kf9.g.a(r102, "audio_reply_first_duration", Long.valueOf(r101.f503269e.f503245g));
        kf9.g.a(r102, "text_first_generate_duration", Long.valueOf(r101.f503269e.f503240b));
        kf9.g.a(r102, "text_first_link_duration", Long.valueOf(r101.f503269e.f503243e));
        kf9.g.a(r102, "text_reply_first_duration", Long.valueOf(r101.f503269e.f503249k));
        kf9.d r103 = r101.f503269e;
        kf9.g.a(r102, "audio_full_played_duration", Long.valueOf(kf9.f.a(r103.D, r103.A, "audio_full_played_duration")));
        kf9.d r104 = r101.f503269e;
        kf9.g.a(r102, "duration", Long.valueOf(kf9.f.a(r104.f503262x, r104.A, "reply_end_duration")));
        kf9.g.a(r102, "audio_na_to_na_duration", Long.valueOf(kf9.f.a(r101.f503268d.f503220c, r101.f503269e.B, "audio_na_to_na_duration")));
        return Unit.INSTANCE;
    }
}
