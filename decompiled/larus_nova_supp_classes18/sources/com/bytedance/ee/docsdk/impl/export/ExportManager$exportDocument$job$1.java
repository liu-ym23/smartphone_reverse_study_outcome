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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.export.ExportManager$exportDocument$job$1", f = "ExportManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExportManager$exportDocument$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDownloadResult $callback;
    final /* synthetic */ String $filePath;
    final /* synthetic */ ExportManager.ExportRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    public ExportManager$exportDocument$job$1(ExportManager.ExportRequest r1, IDownloadResult r2, String r3, Continuation<? super ExportManager$exportDocument$job$1> r4) {
        this.$request = r1;
        this.$callback = r2;
        this.$filePath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ExportManager$exportDocument$job$1 r0 = new ExportManager$exportDocument$job$1(this.$request, this.$callback, this.$filePath, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ExportManager r1 = ExportManager.INSTANCE;     // Catch: Exception -> L18
        if (ExportManager.access$validateExportRequest(r1, this.$request, this.$callback) == true) goto L9;
        Log.e("ExportManager", "EXPORT_DOCUMENT_ABORT - invalid");     // Catch: Exception -> L18
        return Unit.INSTANCE;
    L9:
        String r3 = ExportManager.access$buildRequestBody(r1, this.$request);     // Catch: Exception -> L18
        if (r3 != null) goto L16;
        IDownloadResult r2 = this.$callback;     // Catch: Exception -> L18
        Log.e("ExportManager", "EXPORT_DOCUMENT_FAILED - failed to build request body");     // Catch: Exception -> L18
        if (r2 == null) goto L15;
        r2.onFail(-1, "Failed to build request body");     // Catch: Exception -> L18
    L15:
        return Unit.INSTANCE;
    L16:
        Map r4 = ExportManager.access$buildRequestHeaders(r1);     // Catch: Exception -> L18
        Log.d("ExportManager", "Sending export request to URL: https://internal-api-space.feishu.cn/space/api/export/create/");     // Catch: Exception -> L18
        NetService.INSTANCE.httpPost("https://internal-api-space.feishu.cn/space/api/export/create/", r4, r3, ExportManager.access$createExportCallback(r1, this.$filePath, this.$request, this.$callback));     // Catch: Exception -> L18
    L23:
        return Unit.INSTANCE;
    L18:
        e = move-exception;
        Log.e("ExportManager", "Unexpected error during export", e);
        IDownloadResult r0 = this.$callback;
        if (r0 == null) goto L23;
        r0.onFail(-1, e.getMessage());
        goto L23
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
