package com.larus.im.internal.database.mock;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.mock.MockMessageDaoSource", f = "MockMessageDaoSource.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 4}, l = {160, 161, 164, 166, 168, 168}, m = "deleteOtherMessages", n = {"diff", "mainCvsId", "diff", "mainCvsId", "cvs", "singleDelete", "mainCvsId", "singleDelete", "mainCvsId"}, s = {"J$0", "L$0", "J$0", "L$0", "L$2", "I$0", "L$0", "I$0", "L$0"})
final class MockMessageDaoSource$deleteOtherMessages$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MockMessageDaoSource this$0;

    public MockMessageDaoSource$deleteOtherMessages$1(MockMessageDaoSource r100, Continuation<? super MockMessageDaoSource$deleteOtherMessages$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MockMessageDaoSource.b(this.this$0, 0, this);
    }
}
