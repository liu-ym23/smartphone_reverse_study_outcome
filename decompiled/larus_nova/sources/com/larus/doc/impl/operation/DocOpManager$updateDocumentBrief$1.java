package com.larus.doc.impl.operation;

import com.larus.doc.impl.DocumentApi;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$updateDocumentBrief$1", f = "DocOpManager.kt", i = {}, l = {1067}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$updateDocumentBrief$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $artifactType;
    final /* synthetic */ Long $parsedArtifactVersionId;
    final /* synthetic */ String $resourceId;
    int label;

    public DocOpManager$updateDocumentBrief$1(String r100, int r101, Long r102, Continuation<? super DocOpManager$updateDocumentBrief$1> r103) {
        this.$resourceId = r100;
        this.$artifactType = r101;
        this.$parsedArtifactVersionId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocOpManager$updateDocumentBrief$1(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DocOpManager$updateDocumentBrief$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        FLogger.f375446a.i("DocOpManager", "result:" + ((dm9.a) r100));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DocumentApi.a r103 = DocumentApi.f331050a;
        DocOpManager$updateDocumentBrief$1$result$1 r104 = new DocOpManager$updateDocumentBrief$1$result$1(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, null);
        this.label = 1;
        r103.getClass();
        r100 = DocumentApi.a.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
