package com.larus.im.internal.database.mock;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.mock.MockMessageDaoSource", f = "MockMessageDaoSource.kt", i = {}, l = {29}, m = "mainCvsId", n = {}, s = {})
public final class MockMessageDaoSource$mainCvsId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MockMessageDaoSource this$0;

    public MockMessageDaoSource$mainCvsId$1(MockMessageDaoSource r100, Continuation<? super MockMessageDaoSource$mainCvsId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MockMessageDaoSource r101 = this.this$0;
        MockMessageDaoSource r102 = MockMessageDaoSource.f348123a;
        return r101.e(this);
    }
}
