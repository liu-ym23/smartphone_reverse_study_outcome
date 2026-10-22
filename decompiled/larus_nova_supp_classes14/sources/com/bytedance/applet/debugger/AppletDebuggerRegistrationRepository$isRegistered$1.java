package com.bytedance.applet.debugger;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerRegistrationRepository", f = "AppletDebuggerRegistrationRepository.kt", i = {}, l = {TextExtraStruct.TYPE_GROUP_CHAT}, m = "isRegistered", n = {}, s = {})
public final class AppletDebuggerRegistrationRepository$isRegistered$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDebuggerRegistrationRepository this$0;

    public AppletDebuggerRegistrationRepository$isRegistered$1(AppletDebuggerRegistrationRepository r1, Continuation<? super AppletDebuggerRegistrationRepository$isRegistered$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
