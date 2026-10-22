package com.larus.im.internal.database.slowtask;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.slowtask.DBSizeMonitorTask", f = "DBSizeMonitorTask.kt", i = {}, l = {50, 54}, m = "run", n = {}, s = {})
public final class DBSizeMonitorTask$run$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBSizeMonitorTask this$0;

    public DBSizeMonitorTask$run$1(DBSizeMonitorTask r100, Continuation<? super DBSizeMonitorTask$run$1> r101) {
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
