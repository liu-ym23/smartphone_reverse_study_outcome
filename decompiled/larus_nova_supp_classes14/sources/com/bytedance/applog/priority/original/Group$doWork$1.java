package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.Group", f = "Group.kt", i = {0, 0}, l = {295}, m = "doWork", n = {"this", "header"}, s = {"L$0", "L$1"})
final class Group$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Group this$0;

    public Group$doWork$1(Group r1, Continuation<? super Group$doWork$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, 0, this);
    }
}
