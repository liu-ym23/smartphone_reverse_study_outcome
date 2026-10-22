package com.bytedance.applet.aibridge.baidunavi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.StartBaiduNavigationMethod", f = "StartBaiduNavigationMethod.kt", i = {0, 0}, l = {145}, m = "doHandle", n = {"params", "callback"}, s = {"L$0", "L$1"})
final class StartBaiduNavigationMethod$doHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StartBaiduNavigationMethod this$0;

    public StartBaiduNavigationMethod$doHandle$1(StartBaiduNavigationMethod r1, Continuation<? super StartBaiduNavigationMethod$doHandle$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return StartBaiduNavigationMethod.b(this.this$0, null, null, this);
    }
}
