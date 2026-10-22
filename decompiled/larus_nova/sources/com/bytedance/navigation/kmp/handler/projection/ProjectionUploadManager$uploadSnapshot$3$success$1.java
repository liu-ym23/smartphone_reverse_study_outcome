package com.bytedance.navigation.kmp.handler.projection;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager$uploadSnapshot$3$success$1", f = "ProjectionUploadManager.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class ProjectionUploadManager$uploadSnapshot$3$success$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ Ref.IntRef $attempt;
    final /* synthetic */ List<c> $group;
    final /* synthetic */ String $navId;
    int label;

    public ProjectionUploadManager$uploadSnapshot$3$success$1(Ref.IntRef r100, String r101, List<c> r102, Continuation<? super ProjectionUploadManager$uploadSnapshot$3$success$1> r103) {
        this.$attempt = r100;
        this.$navId = r101;
        this.$group = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ProjectionUploadManager$uploadSnapshot$3$success$1(this.$attempt, this.$navId, this.$group, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((ProjectionUploadManager$uploadSnapshot$3$success$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Ref.IntRef r103 = this.$attempt;
        int r104 = r103.element + 1;
        r103.element = r104;
        if (r104 != 2) goto L11;
        d37.i r105 = d37.i.f466749a;
        e37.c.a.a("Projection upload failed, retry once: navId=" + this.$navId + ", count=" + this.$group.size());
    L11:
        ProjectionUploadApi r106 = ProjectionUploadApi.f265834a;
        String r107 = this.$navId;
        List<c> r108 = this.$group;
        this.label = 1;
        r100 = r106.a(r107, r108, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
