package com.ss.android.lark.widget.photo.preview.authorization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.widget.photo.preview.authorization.DownloadAuthorizationInterceptor", f = "DownloadAuthorizationInterceptor.kt", i = {0, 0}, l = {31, 34}, m = "intercept", n = {"chain", "request"}, s = {"L$0", "L$1"})
final class DownloadAuthorizationInterceptor$intercept$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DownloadAuthorizationInterceptor$intercept$1(a r100, Continuation<? super DownloadAuthorizationInterceptor$intercept$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
