package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.data.SideBarRepo", f = "SideBarRepo.kt", i = {}, l = {164}, m = "updateSideBarOrder$impl_mainlandRelease", n = {}, s = {})
public final class SideBarRepo$updateSideBarOrder$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SideBarRepo this$0;

    public SideBarRepo$updateSideBarOrder$1(SideBarRepo r100, Continuation<? super SideBarRepo$updateSideBarOrder$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(null, this);
    }
}
