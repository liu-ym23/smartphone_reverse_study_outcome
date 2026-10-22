package com.larus.push.impl.reminder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.push.impl.reminder.OpenPushReminder", f = "OpenPushReminder.kt", i = {0, 0}, l = {177}, m = "innerTryRemindOpenPush", n = {"data", "callback"}, s = {"L$0", "L$1"})
final class OpenPushReminder$innerTryRemindOpenPush$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenPushReminder this$0;

    public OpenPushReminder$innerTryRemindOpenPush$1(OpenPushReminder r100, Continuation<? super OpenPushReminder$innerTryRemindOpenPush$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return OpenPushReminder.a(this.this$0, null, null, this);
    }
}
