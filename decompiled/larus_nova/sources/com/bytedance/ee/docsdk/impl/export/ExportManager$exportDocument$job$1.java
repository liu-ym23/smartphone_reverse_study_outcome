package com.bytedance.ee.docsdk.impl.export;

import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.NetService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.export.ExportManager$exportDocument$job$1", f = "ExportManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExportManager$exportDocument$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDownloadResult $callback;
    final /* synthetic */ String $filePath;
    final /* synthetic */ ExportManager.ExportRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    public ExportManager$exportDocument$job$1(ExportManager.ExportRequest r100, IDownloadResult r101, String r102, Continuation<? super ExportManager$exportDocument$job$1> r103) {
        this.$request = r100;
        this.$callback = r101;
        this.$filePath = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ExportManager$exportDocument$job$1 r102 = new ExportManager$exportDocument$job$1(this.$request, this.$callback, this.$filePath, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ExportManager$exportDocument$job$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        ExportManager r100 = ExportManager.INSTANCE;     // Catch: Exception -> L18
        if (ExportManager.access$validateExportRequest(r100, this.$request, this.$callback) == true) goto L9;
        Log.e("ExportManager", "EXPORT_DOCUMENT_ABORT - invalid");     // Catch: Exception -> L18
        return Unit.INSTANCE;
    L9:
        String r101 = ExportManager.access$buildRequestBody(r100, this.$request);     // Catch: Exception -> L18
        if (r101 != null) goto L16;
        IDownloadResult r102 = this.$callback;     // Catch: Exception -> L18
        Log.e("ExportManager", "EXPORT_DOCUMENT_FAILED - failed to build request body");     // Catch: Exception -> L18
        if (r102 == null) goto L15;
        r102.onFail(-1, "Failed to build request body");     // Catch: Exception -> L18
    L15:
        return Unit.INSTANCE;
    L16:
        Map<String, String> r103 = ExportManager.access$buildRequestHeaders(r100);     // Catch: Exception -> L18
        Log.d("ExportManager", "Sending export request to URL: https://internal-api-space.feishu.cn/space/api/export/create/");     // Catch: Exception -> L18
        NetService.INSTANCE.httpPost("https://internal-api-space.feishu.cn/space/api/export/create/", r103, r101, ExportManager.access$createExportCallback(r100, this.$filePath, this.$request, this.$callback));     // Catch: Exception -> L18
    L23:
        return Unit.INSTANCE;
    L18:
        e = move-exception;
        Log.e("ExportManager", "Unexpected error during export", e);
        IDownloadResult r104 = this.$callback;
        if (r104 == null) goto L23;
        r104.onFail(-1, e.getMessage());
        goto L23
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
