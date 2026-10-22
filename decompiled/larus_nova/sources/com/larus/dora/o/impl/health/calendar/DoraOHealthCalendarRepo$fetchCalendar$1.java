package com.larus.dora.o.impl.health.calendar;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.health.calendar.DoraOHealthCalendarRepo", f = "DoraOHealthCalendarRepo.kt", i = {0}, l = {42}, m = "fetchCalendar", n = {BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH}, s = {"L$0"})
public final class DoraOHealthCalendarRepo$fetchCalendar$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOHealthCalendarRepo this$0;

    public DoraOHealthCalendarRepo$fetchCalendar$1(DoraOHealthCalendarRepo r100, Continuation<? super DoraOHealthCalendarRepo$fetchCalendar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
