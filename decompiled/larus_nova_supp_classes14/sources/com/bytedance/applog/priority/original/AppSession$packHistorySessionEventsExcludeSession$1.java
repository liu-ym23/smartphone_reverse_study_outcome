package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.AppSession", f = "AppSession.kt", i = {0, 0, 1, 1, 2}, l = {293, 301, 310}, m = "packHistorySessionEventsExcludeSession", n = {"this", "sessionId", "this", "sessionId", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
public final class AppSession$packHistorySessionEventsExcludeSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSession this$0;

    public AppSession$packHistorySessionEventsExcludeSession$1(AppSession r1, Continuation<? super AppSession$packHistorySessionEventsExcludeSession$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
