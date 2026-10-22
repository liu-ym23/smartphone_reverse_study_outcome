package com.larus.im.internal.database.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.utils.FtsInitUtils", f = "FtsInitUtils.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {83}, m = "startMigrateMessage", n = {"uid", "key", "offset", "totalCount", "startMigrateTime", "oldTimeFlag", "tmpMigrateTime"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0", "J$1", "J$2"})
final class FtsInitUtils$startMigrateMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FtsInitUtils this$0;

    public FtsInitUtils$startMigrateMessage$1(FtsInitUtils r100, Continuation<? super FtsInitUtils$startMigrateMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FtsInitUtils.a(this.this$0, null, this);
    }
}
