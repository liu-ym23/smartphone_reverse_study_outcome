package com.obric.assistant.obric_action.handler;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.OpenCreateShortcutHandler", f = "OpenCreateShortcutHandler.kt", i = {0, 0, 0}, l = {57}, m = "execute", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "query", "messageId"}, s = {"L$0", "L$1", "L$2"})
public final class OpenCreateShortcutHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenCreateShortcutHandler this$0;

    public OpenCreateShortcutHandler$execute$1(OpenCreateShortcutHandler r100, Continuation<? super OpenCreateShortcutHandler$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
