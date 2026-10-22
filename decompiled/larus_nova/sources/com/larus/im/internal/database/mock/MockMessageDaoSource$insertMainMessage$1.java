package com.larus.im.internal.database.mock;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.mock.MockMessageDaoSource", f = "MockMessageDaoSource.kt", i = {0, 1, 1, 1}, l = {112, 122, 124}, m = "insertMainMessage", n = {"diff", "mainCvsId", "diff", RXScreenCaptureService.KEY_INDEX}, s = {"J$0", "L$0", "J$0", "J$1"})
final class MockMessageDaoSource$insertMainMessage$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MockMessageDaoSource this$0;

    public MockMessageDaoSource$insertMainMessage$1(MockMessageDaoSource r100, Continuation<? super MockMessageDaoSource$insertMainMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MockMessageDaoSource.c(this.this$0, 0, this);
    }
}
