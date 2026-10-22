package com.bytedance.ee.docsdk.impl.export;

import com.ss.android.lark.chameleon.idependency.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.ee.docsdk.impl.export.ExportManager$pollExportResult$job$1", f = "ExportManager.kt", i = {0, 1, 2, 3}, l = {173, 184, 193, 201}, m = "invokeSuspend", n = {"accumulatedTime", "accumulatedTime", "accumulatedTime", "accumulatedTime"}, s = {"I$0", "I$0", "I$0", "I$0"})
public final class ExportManager$pollExportResult$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IDownloadResult $callback;
    final /* synthetic */ String $filePath;
    final /* synthetic */ int $jobTimeout;
    final /* synthetic */ String $ticket;
    final /* synthetic */ String $token;
    int I$0;
    int label;

    public ExportManager$pollExportResult$job$1(int r1, IDownloadResult r2, String r3, String r4, String r5, Continuation<? super ExportManager$pollExportResult$job$1> r6) {
        this.$jobTimeout = r1;
        this.$callback = r2;
        this.$ticket = r3;
        this.$token = r4;
        this.$filePath = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ExportManager$pollExportResult$job$1(this.$jobTimeout, this.$callback, this.$ticket, this.$token, this.$filePath, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00cf -> B:66:0x0061). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        int r0 = this.I$0;
    L12:
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L20
        ExportManager$pollExportResult$job$1 r16 = this;
    L66:
        int r3 = r16.$jobTimeout;     // Catch: Exception -> L58
        if (r0 < r3) goto L32;
        ExportManager.access$handlePollingTimeout(ExportManager.INSTANCE, r3, r16.$callback);     // Catch: Exception -> L58
        r16 = Unit.INSTANCE;     // Catch: Exception -> L58
        return r16;
    L32:
        ExportManager r4 = ExportManager.INSTANCE;     // Catch: Exception -> L58
        String r5 = r16.$ticket;     // Catch: Exception -> L58
        String r8 = r16.$token;     // Catch: Exception -> L58
        r16.I$0 = r0;     // Catch: Exception -> L58
        r16.label = 2;     // Catch: Exception -> L58
        Object r6 = ExportManager.access$fetchPollingResult(r4, r5, r8, r16);     // Catch: Exception -> L58
        if (r6 != r1) goto L35;
        return r1;
    L35:
        int r13 = r0;
        ExportManager$pollExportResult$job$1 r7 = r16;
        r15 = r6;
        Object r9 = r1;
        int r10 = r13;
    L68:
        String r17 = (String) r15;     // Catch: Exception -> L56
        if (r17 == null) goto L53;
        Log.d("ExportManager", "POLLING_RESPONSE - response: " + r17);     // Catch: Exception -> L56
        ExportManager.PollingStatus r18 = ExportManager.access$processPollingResponse(ExportManager.INSTANCE, r17, r7.$filePath, r7.$callback, r7.$token);     // Catch: Exception -> L56
        if ((r18 instanceof ExportManager.PollingStatus.Completed) == false) goto L43;
        return Unit.INSTANCE;
    L43:
        if ((r18 instanceof ExportManager.PollingStatus.Continue) == false) goto L49;
        int r19 = r10 + 3;     // Catch: Exception -> L56
        r7.I$0 = r19;     // Catch: Exception -> L56
        r7.label = 3;     // Catch: Exception -> L56
        if (DelayKt.delay(3000, r7) != r9) goto L47;
        return r9;
    L47:
        r1 = r9;
        ExportManager$pollExportResult$job$1 r14 = r7;
        r0 = r19;
        r16 = r14;
        goto L66
    L49:
        if ((r18 instanceof ExportManager.PollingStatus.Failed) == true) goto L51;
        r16 = r7;
        r0 = r10;
        r1 = r9;
        goto L66
    L51:
        return Unit.INSTANCE;
    L53:
        Log.i("ExportManager", "POLLING_REQUEST_FAILE, will retry , accumulatedTime:" + r10);     // Catch: Exception -> L56
        int r110 = r10 + 3;     // Catch: Exception -> L56
        r7.I$0 = r110;     // Catch: Exception -> L56
        r7.label = 4;     // Catch: Exception -> L56
        if (DelayKt.delay(3000, r7) != r9) goto L47;
        return r9;
    L69:
        r1 = r9;
        ExportManager$pollExportResult$job$1 r111 = r7;
        r0 = r110;
        r16 = r111;
    L56:
        e = e;
    L60:
        Log.e("ExportManager", "Error during polling", e);
        IDownloadResult r11 = r7.$callback;
        if (r11 == null) goto L64;
        r11.onFail(-1, e.getMessage());
    L64:
        return Unit.INSTANCE;
    L58:
        e = move-exception;
        r7 = r16;
        e = e;
        goto L60
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r0 = this.I$0;
        goto L12
    L14:
        int r12 = this.I$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L20
        r9 = r1;
        r10 = r12;
        r7 = this;
        goto L68
    L17:
        int r20 = this.I$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L20
    L26:
        Log.d("ExportManager", "Start polling for export result, jobTimeout: " + this.$jobTimeout);     // Catch: Exception -> L20
        r16 = this;
        r0 = r20;
        goto L66
    L22:
        ResultKt.throwOnFailure(r15);
        r20 = 0;
        this.I$0 = 0;     // Catch: Exception -> L20
        this.label = 1;     // Catch: Exception -> L20
        if (DelayKt.delay(1000, this) != r1) goto L26;
        return r1;
    L20:
        e = e;
        r7 = this;
        goto L60
    }
}
