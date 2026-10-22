package com.larus.im.internal.database.slowtask;

import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.slowtask.DBTableIndexTask", f = "DBTableIndexTask.kt", i = {0}, l = {62}, m = "clearIndex", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
final class DBTableIndexTask$clearIndex$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBTableIndexTask this$0;

    public DBTableIndexTask$clearIndex$1(DBTableIndexTask r100, Continuation<? super DBTableIndexTask$clearIndex$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DBTableIndexTask r101 = this.this$0;
        List<String> r102 = DBTableIndexTask.f348144a;
        return r101.b(null, this);
    }
}
