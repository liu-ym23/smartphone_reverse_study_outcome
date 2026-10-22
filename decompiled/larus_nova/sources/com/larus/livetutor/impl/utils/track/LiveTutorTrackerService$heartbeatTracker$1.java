package com.larus.livetutor.impl.utils.track;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LiveTutorTrackerService$heartbeatTracker$1 extends AdaptedFunctionReference implements Function2<Long, Continuation<? super Unit>, Object>, SuspendFunction {
    public LiveTutorTrackerService$heartbeatTracker$1(Object r100) {
        super(2, r100, LiveTutorTrackerService.class, "trackerStayPage", "trackerStayPage(J)V", 4);
    }

    public final Object invoke(long r100, Continuation<? super Unit> r101) {
        LiveTutorTrackerService r102 = (LiveTutorTrackerService) this.receiver;
        r102.getClass();
        JSONObject r103 = new JSONObject();
        r103.put("stay_duration", r100);
        Unit r104 = Unit.INSTANCE;
        LiveTutorTrackerService.b(r102, "live_tutor_stay_page", r103, 4);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long r100, Continuation<? super Unit> r101) {
        return invoke(r100.longValue(), r101);
    }
}
