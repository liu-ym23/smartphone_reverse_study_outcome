package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.CommonButtonV2VMDependencyImpl", f = "CommonButtonVMDependencyImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {108, 120, 121}, m = "sendCreationMsg", n = {"vmData", "callback", "isHiddenMsg", "vmData", "callback", "conversation", "cvsId", "relyInfo", "isHiddenMsg", "vmData", "callback", "conversation", "cvsId", "relyInfo", "relyPromptMsg", "isHiddenMsg"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
public final class CommonButtonV2VMDependencyImpl$sendCreationMsg$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonButtonV2VMDependencyImpl this$0;

    public CommonButtonV2VMDependencyImpl$sendCreationMsg$1(CommonButtonV2VMDependencyImpl r100, Continuation<? super CommonButtonV2VMDependencyImpl$sendCreationMsg$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CommonButtonV2VMDependencyImpl r101 = this.this$0;
        int r102 = CommonButtonV2VMDependencyImpl.f309003b;
        return r101.d(null, false, null, this);
    }
}
