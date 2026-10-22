package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import com.larus.uaigc.service.IUgcAIGCService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$preprocessAlbumImg$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1426}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$preprocessAlbumImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    public GenImagePlannerComponent$preprocessAlbumImg$2(Uri r100, Continuation<? super GenImagePlannerComponent$preprocessAlbumImg$2> r101) {
        this.$uri = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GenImagePlannerComponent$preprocessAlbumImg$2(this.$uri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return ((GenImagePlannerComponent$preprocessAlbumImg$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return (ic8.n0) r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.larus.uaigc.utils.a r103 = IUgcAIGCService.f373945a.t();
        if (r103 == null) goto L14;
        Uri r104 = this.$uri;
        this.label = 1;
        r100 = r103.a(r104, "ai_beautify", "canvas", this);
        if (r100 != r101) goto L16;
        return r101;
    L14:
        return null;
    }
}
