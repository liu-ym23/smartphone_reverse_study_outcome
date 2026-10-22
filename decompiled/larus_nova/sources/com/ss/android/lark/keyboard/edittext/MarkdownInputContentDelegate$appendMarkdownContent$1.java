package com.ss.android.lark.keyboard.edittext;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.MarkdownInputContentDelegate", f = "MarkdownInputContentDelegate.kt", i = {}, l = {23}, m = "appendMarkdownContent", n = {}, s = {})
final class MarkdownInputContentDelegate$appendMarkdownContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public MarkdownInputContentDelegate$appendMarkdownContent$1(f r100, Continuation<? super MarkdownInputContentDelegate$appendMarkdownContent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
