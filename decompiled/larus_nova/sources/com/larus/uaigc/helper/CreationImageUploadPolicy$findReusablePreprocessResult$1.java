package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageUploadPolicy", f = "CreationImageUploadPolicy.kt", i = {}, l = {261}, m = "findReusablePreprocessResult", n = {}, s = {})
public final class CreationImageUploadPolicy$findReusablePreprocessResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageUploadPolicy this$0;

    public CreationImageUploadPolicy$findReusablePreprocessResult$1(CreationImageUploadPolicy r100, Continuation<? super CreationImageUploadPolicy$findReusablePreprocessResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CreationImageUploadPolicy r101 = this.this$0;
        CreationImageUploadPolicy r102 = CreationImageUploadPolicy.f372948a;
        return r101.c(null, null, this);
    }
}
