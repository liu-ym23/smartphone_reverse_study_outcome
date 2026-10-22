package com.bytedance.applet.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment", f = "AppletFragment.kt", i = {}, l = {670}, m = "setupEventListener", n = {}, s = {})
public final class AppletFragment$setupEventListener$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletFragment this$0;

    public AppletFragment$setupEventListener$1(AppletFragment r1, Continuation<? super AppletFragment$setupEventListener$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AppletFragment r3 = this.this$0;
        int r0 = AppletFragment.J;
        return r3.Z90(this);
    }
}
