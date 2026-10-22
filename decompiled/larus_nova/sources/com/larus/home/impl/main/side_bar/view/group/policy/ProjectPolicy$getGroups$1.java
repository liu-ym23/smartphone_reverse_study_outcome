package com.larus.home.impl.main.side_bar.view.group.policy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.policy.ProjectPolicy", f = "ProjectPolicy.kt", i = {0}, l = {15}, m = "getGroups", n = {"$this$getGroups_u24lambda_u240"}, s = {"L$1"})
public final class ProjectPolicy$getGroups$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProjectPolicy this$0;

    public ProjectPolicy$getGroups$1(ProjectPolicy r100, Continuation<? super ProjectPolicy$getGroups$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
