package com.bytedance.ies.ezresult;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"Landroidx/fragment/app/FragmentManager;", "fm", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/ies/ezresult/EzResultFragment;", "continuation", "", "getOrInstall"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezresult.EzResultFragment$Companion", f = "EzResultFragment.kt", i = {0}, l = {39}, m = "getOrInstall", n = {"f"}, s = {"L$1"})
public final class EzResultFragment$Companion$getOrInstall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EzResultFragment.Companion this$0;

    public EzResultFragment$Companion$getOrInstall$1(EzResultFragment.Companion r100, Continuation r101) {
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
