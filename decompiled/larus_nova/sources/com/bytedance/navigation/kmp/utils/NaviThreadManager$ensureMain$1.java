package com.bytedance.navigation.kmp.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.utils.NaviThreadManager", f = "NaviThreadManager.kt", i = {0}, l = {54, 55, 57}, m = "ensureMain", n = {"block"}, s = {"L$0"})
public final class NaviThreadManager$ensureMain$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NaviThreadManager this$0;

    public NaviThreadManager$ensureMain$1(NaviThreadManager r100, Continuation<? super NaviThreadManager$ensureMain$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
