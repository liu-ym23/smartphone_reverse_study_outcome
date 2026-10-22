package com.larus.login.impl.loginfragment;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.impl.loginfragment.EnterpriseLoginEntryResolver", f = "EnterpriseLoginEntryResolver.kt", i = {}, l = {52}, m = JSEventListener.ACTION_RESOLVE, n = {}, s = {})
public final class EnterpriseLoginEntryResolver$resolve$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterpriseLoginEntryResolver this$0;

    public EnterpriseLoginEntryResolver$resolve$1(EnterpriseLoginEntryResolver r100, Continuation<? super EnterpriseLoginEntryResolver$resolve$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
