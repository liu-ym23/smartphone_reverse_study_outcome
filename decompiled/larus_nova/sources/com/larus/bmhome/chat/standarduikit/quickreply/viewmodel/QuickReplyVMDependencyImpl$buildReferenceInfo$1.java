package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.QuickReplyVMDependencyImpl", f = "QuickReplyVMDependencyImpl.kt", i = {0, 1}, l = {110, 113}, m = "buildReferenceInfo", n = {"referenceMessageId", "referenceMessageId"}, s = {"L$0", "L$0"})
public final class QuickReplyVMDependencyImpl$buildReferenceInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickReplyVMDependencyImpl this$0;

    public QuickReplyVMDependencyImpl$buildReferenceInfo$1(QuickReplyVMDependencyImpl r100, Continuation<? super QuickReplyVMDependencyImpl$buildReferenceInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        QuickReplyVMDependencyImpl r101 = this.this$0;
        LruCache<String, String> r102 = QuickReplyVMDependencyImpl.f309560b;
        return r101.e(null, this);
    }
}
