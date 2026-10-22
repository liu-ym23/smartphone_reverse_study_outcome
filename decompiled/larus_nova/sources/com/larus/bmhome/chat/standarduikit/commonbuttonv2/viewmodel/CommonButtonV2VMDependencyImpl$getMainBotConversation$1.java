package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.CommonButtonV2VMDependencyImpl", f = "CommonButtonVMDependencyImpl.kt", i = {}, l = {178}, m = "getMainBotConversation", n = {}, s = {})
public final class CommonButtonV2VMDependencyImpl$getMainBotConversation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonButtonV2VMDependencyImpl this$0;

    public CommonButtonV2VMDependencyImpl$getMainBotConversation$1(CommonButtonV2VMDependencyImpl r100, Continuation<? super CommonButtonV2VMDependencyImpl$getMainBotConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CommonButtonV2VMDependencyImpl r101 = this.this$0;
        int r102 = CommonButtonV2VMDependencyImpl.f309003b;
        return r101.c(this);
    }
}
