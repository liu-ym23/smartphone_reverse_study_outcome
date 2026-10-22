package com.ss.android.lark.chatwindow.launcher.transform;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatterIdBundleTransform", f = "ChatterIdBundleTransform.kt", i = {0, 1, 1}, l = {24, 34}, m = "transform-0E7RQCE", n = {"baseBundle", "baseBundle", "chat"}, s = {"L$0", "L$0", "L$1"})
public final class ChatterIdBundleTransform$transform$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatterIdBundleTransform this$0;

    public ChatterIdBundleTransform$transform$1(ChatterIdBundleTransform r100, Continuation<? super ChatterIdBundleTransform$transform$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.b(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
