package com.bytedance.applet.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment", f = "AppletFragment.kt", i = {}, l = {776, 780}, m = "updateFloatingBotId", n = {}, s = {})
final class AppletFragment$updateFloatingBotId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletFragment this$0;

    public AppletFragment$updateFloatingBotId$1(AppletFragment r1, Continuation<? super AppletFragment$updateFloatingBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AppletFragment.U90(this.this$0, null, this);
    }
}
