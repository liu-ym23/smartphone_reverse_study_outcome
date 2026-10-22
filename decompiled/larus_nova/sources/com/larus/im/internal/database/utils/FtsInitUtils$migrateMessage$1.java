package com.larus.im.internal.database.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.utils.FtsInitUtils", f = "FtsInitUtils.kt", i = {1}, l = {127, 141}, m = "migrateMessage", n = {"messageDao"}, s = {"L$0"})
public final class FtsInitUtils$migrateMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FtsInitUtils this$0;

    public FtsInitUtils$migrateMessage$1(FtsInitUtils r100, Continuation<? super FtsInitUtils$migrateMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FtsInitUtils r101 = this.this$0;
        FtsInitUtils r102 = FtsInitUtils.f348148a;
        return r101.b(0, 0, this);
    }
}
