package com.obric.miniapp.alarm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager", f = "AlarmManager.kt", i = {}, l = {356, 357}, m = "clearAll", n = {}, s = {})
public final class AlarmManager$clearAll$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlarmManager this$0;

    public AlarmManager$clearAll$1(AlarmManager r100, Continuation<? super AlarmManager$clearAll$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AlarmManager r101 = this.this$0;
        AlarmManager r102 = AlarmManager.f397387a;
        return r101.d(this);
    }
}
