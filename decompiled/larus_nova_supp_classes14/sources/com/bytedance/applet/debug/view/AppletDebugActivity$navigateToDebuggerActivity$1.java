package com.bytedance.applet.debug.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugActivity", f = "AppletDebugActivity.kt", i = {0}, l = {476}, m = "navigateToDebuggerActivity", n = {"packageName"}, s = {"L$0"})
final class AppletDebugActivity$navigateToDebuggerActivity$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDebugActivity this$0;

    public AppletDebugActivity$navigateToDebuggerActivity$1(AppletDebugActivity r1, Continuation<? super AppletDebugActivity$navigateToDebuggerActivity$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AppletDebugActivity.N1(this.this$0, null, null, this);
    }
}
