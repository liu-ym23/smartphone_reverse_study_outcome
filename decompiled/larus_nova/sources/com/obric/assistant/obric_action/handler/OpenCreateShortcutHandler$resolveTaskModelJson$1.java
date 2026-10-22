package com.obric.assistant.obric_action.handler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.OpenCreateShortcutHandler", f = "OpenCreateShortcutHandler.kt", i = {0, 1}, l = {118, 123}, m = "resolveTaskModelJson", n = {"$this$resolveTaskModelJson_u24lambda_u247", "$this$resolveTaskModelJson_u24lambda_u247"}, s = {"L$0", "L$0"})
public final class OpenCreateShortcutHandler$resolveTaskModelJson$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenCreateShortcutHandler this$0;

    public OpenCreateShortcutHandler$resolveTaskModelJson$1(OpenCreateShortcutHandler r100, Continuation<? super OpenCreateShortcutHandler$resolveTaskModelJson$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OpenCreateShortcutHandler r101 = this.this$0;
        int r102 = OpenCreateShortcutHandler.f390447b;
        return r101.f(null, this);
    }
}
