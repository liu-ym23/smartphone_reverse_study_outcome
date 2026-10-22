package com.ss.android.lark.chatwindow.launcher.transform;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchParamDataBundleTransform", f = "ChatLaunchParamDataBundleTransform.kt", i = {0, 1, 1}, l = {35, 43}, m = "transform-0E7RQCE", n = {"baseBundle", "baseBundle", "chat"}, s = {"L$0", "L$0", "L$1"})
public final class ChatLaunchParamDataBundleTransform$transform$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatLaunchParamDataBundleTransform this$0;

    public ChatLaunchParamDataBundleTransform$transform$1(ChatLaunchParamDataBundleTransform r100, Continuation<? super ChatLaunchParamDataBundleTransform$transform$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
