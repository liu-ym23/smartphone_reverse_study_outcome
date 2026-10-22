package com.larus.im.internal.database.slowtask;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.slowtask.DBTableIndexTask", f = "DBTableIndexTask.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {85}, m = "operateIndex", n = {OnekeyLoginConstants.CU_KEY_OPERATOR, "deleteCount", "createCount", "$this$operateIndex_u24lambda_u243", "list", DyPayConstant.KEY_START_TIME, "index$iv$iv", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "I$1"})
final class DBTableIndexTask$operateIndex$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DBTableIndexTask this$0;

    public DBTableIndexTask$operateIndex$1(DBTableIndexTask r100, Continuation<? super DBTableIndexTask$operateIndex$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DBTableIndexTask r101 = this.this$0;
        List<String> r102 = DBTableIndexTask.f348144a;
        return r101.c(null, this);
    }
}
