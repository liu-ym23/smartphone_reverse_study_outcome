package com.ss.android.lark.todo.impl.rustadapter.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.rustadapter.service.TodoCommentService", f = "TodoCommentService.kt", i = {}, l = {73}, m = "createComment", n = {}, s = {})
public final class TodoCommentService$createComment$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TodoCommentService this$0;

    public TodoCommentService$createComment$1(TodoCommentService r100, Continuation<? super TodoCommentService$createComment$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, this);
    }
}
