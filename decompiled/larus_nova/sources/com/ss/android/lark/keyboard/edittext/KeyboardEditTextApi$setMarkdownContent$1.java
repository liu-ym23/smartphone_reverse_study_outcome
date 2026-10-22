package com.ss.android.lark.keyboard.edittext;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.KeyboardEditTextApi", f = "KeyboardEditTextApi.kt", i = {}, l = {72}, m = "setMarkdownContent", n = {}, s = {})
final class KeyboardEditTextApi$setMarkdownContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public KeyboardEditTextApi$setMarkdownContent$1(c r100, Continuation<? super KeyboardEditTextApi$setMarkdownContent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        c r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        KeyboardEditTextApi$setMarkdownContent$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        boolean r106 = false;
    L15:
        return Boxing.boxBoolean(r106);
    L9:
        if (r105 != 1) goto L12;
        ResultKt.throwOnFailure(r104);
        r106 = ((Boolean) r104).booleanValue();
        goto L15
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new KeyboardEditTextApi$setMarkdownContent$1(r101, this);
        goto L6
    }
}
