package com.larus.im.internal.database.slowtask;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.slowtask.DBSlowTaskManager", f = "DBSlowTaskManager.kt", i = {0, 0}, l = {76}, m = "runTasks", n = {"task", DyPayConstant.KEY_START_TIME}, s = {"L$1", "J$0"})
final class DBSlowTaskManager$runTasks$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBSlowTaskManager this$0;

    public DBSlowTaskManager$runTasks$1(DBSlowTaskManager r100, Continuation<? super DBSlowTaskManager$runTasks$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DBSlowTaskManager.b(this.this$0, this);
    }
}
