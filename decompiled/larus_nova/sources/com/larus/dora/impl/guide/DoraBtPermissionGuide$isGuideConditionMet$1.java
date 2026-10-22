package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBtPermissionGuide", f = "DoraBtPermissionGuide.kt", i = {}, l = {99, 115, 127, 143}, m = "isGuideConditionMet", n = {}, s = {})
public final class DoraBtPermissionGuide$isGuideConditionMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBtPermissionGuide this$0;

    public DoraBtPermissionGuide$isGuideConditionMet$1(DoraBtPermissionGuide r100, Continuation<? super DoraBtPermissionGuide$isGuideConditionMet$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
