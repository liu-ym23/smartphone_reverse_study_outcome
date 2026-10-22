package com.ss.android.lark.keyboard.editor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import mob.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.editor.BaseChatEditor", f = "BaseChatEditor.kt", i = {0, 0}, l = {62}, m = "loadInputState$suspendImpl", n = {"$this", "isInitial"}, s = {"L$0", "Z$0"})
public final class BaseChatEditor$loadInputState$1<T extends mob.a> extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseChatEditor<T> this$0;

    public BaseChatEditor$loadInputState$1(BaseChatEditor<T> r100, Continuation<? super BaseChatEditor$loadInputState$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return BaseChatEditor.c(this.this$0, false, this);
    }
}
