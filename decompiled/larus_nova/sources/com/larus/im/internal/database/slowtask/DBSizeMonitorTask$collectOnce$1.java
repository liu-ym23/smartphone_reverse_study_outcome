package com.larus.im.internal.database.slowtask;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.slowtask.DBSizeMonitorTask", f = "DBSizeMonitorTask.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {73, 74, 75, 76, 77, 78}, m = "collectOnce", n = {"dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "cvsCount", "dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "cvsCount", "botCount", "dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "cvsCount", "botCount", "participantCount", "dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "cvsCount", "botCount", "participantCount", "msgCount", "dbName", "key", "$this$collectOnce_u24lambda_u243", DyPayConstant.KEY_START_TIME, "cvsCount", "botCount", "participantCount", "msgCount", "totalBlockCount"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "J$3", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "J$3", "J$4", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "J$3", "J$4", "J$5"})
public final class DBSizeMonitorTask$collectOnce$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    long J$4;
    long J$5;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBSizeMonitorTask this$0;

    public DBSizeMonitorTask$collectOnce$1(DBSizeMonitorTask r100, Continuation<? super DBSizeMonitorTask$collectOnce$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DBSizeMonitorTask r101 = this.this$0;
        Lazy<DBSizeMonitorTask.b> r102 = DBSizeMonitorTask.f348125a;
        return r101.b(null, null, this);
    }
}
