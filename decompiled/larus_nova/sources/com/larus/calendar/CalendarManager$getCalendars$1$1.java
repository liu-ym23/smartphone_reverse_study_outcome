package com.larus.calendar;

import android.database.Cursor;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/larus/calendar/CalendarManager$Calendar;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.calendar.CalendarManager$getCalendars$1$1", f = "CalendarManager.kt", i = {0}, l = {246}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class CalendarManager$getCalendars$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super CalendarManager.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $it;
    private /* synthetic */ Object L$0;
    int label;

    public CalendarManager$getCalendars$1$1(Cursor r100, Continuation<? super CalendarManager$getCalendars$1$1> r101) {
        this.$it = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CalendarManager$getCalendars$1$1 r102 = new CalendarManager$getCalendars$1$1(this.$it, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super CalendarManager.a> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super CalendarManager.a> r100, Continuation<? super Unit> r101) {
        return ((CalendarManager$getCalendars$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00bc -> B:15:0x00bd). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        int r102 = 1;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        SequenceScope r103 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        CalendarManager$getCalendars$1$1 r104 = this;
    L15:
        r102 = 1;
    L10:
        if (r104.$it.moveToNext() == false) goto L17;
        long r105 = r104.$it.getLong(0);
        String r111 = r104.$it.getString(r102);
        String r112 = r104.$it.getString(2);
        String r113 = r104.$it.getString(3);
        String r114 = r104.$it.getString(4);
        int r115 = r104.$it.getInt(5);
        String r116 = r104.$it.getString(6);
        Object r117 = r100;
        CalendarManager.a r118 = new CalendarManager.a(r105, r111, r112, r114, r113, r115, r116);
        FLogger.f375446a.d("CalendarManager", "------Calendar account:" + r105 + "---" + r111 + "---" + r113 + "----" + r114 + "-----" + r116);
        r104.L$0 = r103;
        r104.label = 1;
        if (r103.yield(r118, r104) != r117) goto L14;
        return r117;
    L14:
        r100 = r117;
        goto L15
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r103 = (SequenceScope) this.L$0;
        r104 = this;
        goto L10
    }
}
