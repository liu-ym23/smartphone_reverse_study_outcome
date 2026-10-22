package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.lark.OfficeSdkHumanFeedController", f = "OfficeSdkHumanFeedController.kt", i = {}, l = {35}, m = "refresh", n = {}, s = {})
public final class OfficeSdkHumanFeedController$refresh$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeSdkHumanFeedController this$0;

    public OfficeSdkHumanFeedController$refresh$1(OfficeSdkHumanFeedController r100, Continuation<? super OfficeSdkHumanFeedController$refresh$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0, this);
    }
}
