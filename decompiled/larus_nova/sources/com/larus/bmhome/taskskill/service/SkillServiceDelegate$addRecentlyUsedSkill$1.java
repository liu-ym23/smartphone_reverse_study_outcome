package com.larus.bmhome.taskskill.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.service.SkillServiceDelegate", f = "ISkillService.kt", i = {}, l = {324}, m = "addRecentlyUsedSkill-yxL6bBk", n = {}, s = {})
public final class SkillServiceDelegate$addRecentlyUsedSkill$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillServiceDelegate this$0;

    public SkillServiceDelegate$addRecentlyUsedSkill$1(SkillServiceDelegate r100, Continuation<? super SkillServiceDelegate$addRecentlyUsedSkill$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.e(null, 0, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
