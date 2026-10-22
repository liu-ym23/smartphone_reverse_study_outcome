package com.larus.bmhome.double_post;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.AwemeDoublePostInnerPushManager", f = "AwemeDoublePostInnerPushManager.kt", i = {0}, l = {53, 57}, m = "getMainBotConversationInfo", n = {"callback"}, s = {"L$0"})
public final class AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwemeDoublePostInnerPushManager this$0;

    public AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1(AwemeDoublePostInnerPushManager r100, Continuation<? super AwemeDoublePostInnerPushManager$getMainBotConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AwemeDoublePostInnerPushManager r101 = this.this$0;
        AwemeDoublePostInnerPushManager r102 = AwemeDoublePostInnerPushManager.f311395a;
        return r101.a(null, this);
    }
}
