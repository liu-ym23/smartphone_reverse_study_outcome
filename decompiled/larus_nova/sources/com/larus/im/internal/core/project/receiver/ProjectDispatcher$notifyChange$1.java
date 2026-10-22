package com.larus.im.internal.core.project.receiver;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.service.c0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.project.receiver.ProjectDispatcher$notifyChange$1", f = "ProjectDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProjectDispatcher$notifyChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OmniProject> $projects;
    int label;

    public ProjectDispatcher$notifyChange$1(List<OmniProject> r100, Continuation<? super ProjectDispatcher$notifyChange$1> r101) {
        this.$projects = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ProjectDispatcher$notifyChange$1(this.$projects, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ProjectDispatcher$notifyChange$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        com.larus.im.internal.delegate.a.f348188b.i("ProjectDispatcher", "notifyChange, projects:" + this.$projects);
        CopyOnWriteArrayList<c0<OmniProject>> r101 = a.f347910b;
        List<OmniProject> r102 = this.$projects;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        ((c0) r103.next()).a(r102);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
