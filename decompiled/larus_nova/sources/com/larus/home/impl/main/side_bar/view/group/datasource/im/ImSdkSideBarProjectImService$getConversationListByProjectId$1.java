package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.im.ImSdkSideBarProjectImService", f = "ImProjectSource.kt", i = {0, 0, 0, 0, 0}, l = {1135}, m = "getConversationListByProjectId", n = {"projectId", "cursorId", "sortType", "maxTime", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT}, s = {"L$0", "L$1", "L$2", "J$0", "I$0"})
public final class ImSdkSideBarProjectImService$getConversationListByProjectId$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImSdkSideBarProjectImService this$0;

    public ImSdkSideBarProjectImService$getConversationListByProjectId$1(ImSdkSideBarProjectImService r100, Continuation<? super ImSdkSideBarProjectImService$getConversationListByProjectId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, 0, null, this);
    }
}
