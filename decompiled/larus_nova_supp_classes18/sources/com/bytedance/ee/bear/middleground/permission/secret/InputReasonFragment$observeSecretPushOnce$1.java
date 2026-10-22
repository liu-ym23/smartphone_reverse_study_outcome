package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment", f = "InputReasonFragment.kt", i = {0}, l = {753}, m = "observeSecretPushOnce", n = {"secretPush"}, s = {"L$0"})
final class InputReasonFragment$observeSecretPushOnce$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputReasonFragment this$0;

    public InputReasonFragment$observeSecretPushOnce$1(InputReasonFragment r1, Continuation<? super InputReasonFragment$observeSecretPushOnce$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return InputReasonFragment.Z90(this.this$0, this);
    }
}
