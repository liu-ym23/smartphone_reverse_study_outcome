package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.data.SideBarRepo", f = "SideBarRepo.kt", i = {0}, l = {88}, m = "requestSideBarList", n = {"userId"}, s = {"L$0"})
public final class SideBarRepo$requestSideBarList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SideBarRepo this$0;

    public SideBarRepo$requestSideBarList$1(SideBarRepo r100, Continuation<? super SideBarRepo$requestSideBarList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(0, null, this);
    }
}
