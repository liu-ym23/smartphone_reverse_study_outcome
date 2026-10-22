package com.larus.project;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl", f = "ProjectListDataSourceImpl.kt", i = {}, l = {307}, m = "refreshLoadedRange", n = {}, s = {})
public final class ProjectListDataSourceImpl$refreshLoadedRange$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$refreshLoadedRange$1(ProjectListDataSourceImpl r100, Continuation<? super ProjectListDataSourceImpl$refreshLoadedRange$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ProjectListDataSourceImpl r101 = this.this$0;
        int r102 = ProjectListDataSourceImpl.f366962j;
        return r101.o(this);
    }
}
