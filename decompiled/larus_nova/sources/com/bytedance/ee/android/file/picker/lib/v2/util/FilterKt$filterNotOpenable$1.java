package com.bytedance.ee.android.file.picker.lib.v2.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.android.file.picker.lib.v2.util.FilterKt", f = "Filter.kt", i = {0, 0, 0}, l = {23}, m = "filterNotOpenable", n = {"logTag", "count", "start"}, s = {"L$0", "I$0", "J$0"})
public final class FilterKt$filterNotOpenable$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FilterKt$filterNotOpenable$1(Continuation<? super FilterKt$filterNotOpenable$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FilterKt.b(null, null, null, this);
    }
}
