package com.obric.miniapp.intent;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/miniapp/intent/QueryPrivilegedImageOperation$QueryResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.QueryPrivilegedImageOperation$execute$2", f = "QueryPrivilegedImageOperation.kt", i = {}, l = {46, 48}, m = "invokeSuspend", n = {}, s = {})
public final class QueryPrivilegedImageOperation$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QueryPrivilegedImageOperation.a>, Object> {
    final /* synthetic */ boolean $isVideo;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $uri;
    private /* synthetic */ Object L$0;
    int label;

    public QueryPrivilegedImageOperation$execute$2(boolean r100, String r101, String r102, int r103, Continuation<? super QueryPrivilegedImageOperation$execute$2> r104) {
        this.$isVideo = r100;
        this.$packageName = r101;
        this.$uri = r102;
        this.$maxSize = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        QueryPrivilegedImageOperation$execute$2 r102 = new QueryPrivilegedImageOperation$execute$2(this.$isVideo, this.$packageName, this.$uri, this.$maxSize, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super QueryPrivilegedImageOperation.a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super QueryPrivilegedImageOperation.a> r101) {
        return ((QueryPrivilegedImageOperation$execute$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L10;
        if (r102 != 2) goto L9;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L25
    L22:
        String r103 = (String) r100;     // Catch: Throwable -> L25
    L23:
        Object r104 = Result.m9449constructorimpl(new QueryPrivilegedImageOperation.a(true, new JSONObject().put("result", r103), null, null, 12));     // Catch: Throwable -> L25
    L27:
        String r105 = this.$packageName;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L45;
        FLogger.f375446a.w("QueryPrivilegedImage", "query privileged image failed packageName=" + r105, r106);
        QueryPrivilegedImageOperation r107 = QueryPrivilegedImageOperation.f397683a;
        if ((r106 instanceof QueryPrivilegedImageOperation.PrivilegedImageException) == false) goto L33;
        QueryPrivilegedImageOperation.PrivilegedImageException r108 = (QueryPrivilegedImageOperation.PrivilegedImageException) r106;
    L34:
        if (r108 == null) goto L37;
        String r109 = r108.getCode();
        if (r109 == null) goto L37;
    L38:
        String r110 = r106.getMessage();
        if (r110 != null) goto L42;
        r110 = "query privileged image failed";
    L42:
        return QueryPrivilegedImageOperation.e(r109, r110);
    L37:
        r109 = "QUERY_IMAGE_FAILED";
        goto L38
    L33:
        r108 = null;
        goto L34
    L45:
        return r104;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L25
    L18:
        r103 = (String) r100;     // Catch: Throwable -> L25
        goto L23
    L12:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        boolean r112 = this.$isVideo;
        String r113 = this.$packageName;
        String r114 = this.$uri;
        int r115 = this.$maxSize;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L25
        if (r112 == false) goto L19;
        QueryPrivilegedImageOperation r117 = QueryPrivilegedImageOperation.f397683a;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        r100 = QueryPrivilegedImageOperation.b(r117, r113, r114, r115, this);     // Catch: Throwable -> L25
        if (r100 != r101) goto L18;
        return r101;
    L19:
        QueryPrivilegedImageOperation r118 = QueryPrivilegedImageOperation.f397683a;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        r100 = QueryPrivilegedImageOperation.a(r118, r113, r114, r115, this);     // Catch: Throwable -> L25
        if (r100 != r101) goto L22;
        return r101;
    L25:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
