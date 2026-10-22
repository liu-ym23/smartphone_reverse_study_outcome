package com.bytedance.applet.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.view.AppletFragment$floatingSpeakerController$1", f = "AppletFragment.kt", i = {}, l = {922}, m = "clearContext", n = {}, s = {})
public final class AppletFragment$floatingSpeakerController$1$clearContext$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletFragment$floatingSpeakerController$1 this$0;

    public AppletFragment$floatingSpeakerController$1$clearContext$1(AppletFragment$floatingSpeakerController$1 r1, Continuation<? super AppletFragment$floatingSpeakerController$1$clearContext$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
