package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdnavigationsdk.b0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.bdnavigationsdk.network.report.ReportService$reportApi$1", f = "ReportService.kt", i = {0, 0, 0, 0}, l = {89}, m = "invokeSuspend", n = {"isSuccess", "errorMessage", "startReportTime", "endRequestTime"}, s = {"L$0", "L$1", "J$0", "J$1"})
final class ReportService$reportApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ f $param;
    final /* synthetic */ String $relativePath;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ j this$0;

    public ReportService$reportApi$1(j r1, String r2, String r3, f r4, Continuation<? super ReportService$reportApi$1> r5) {
        this.this$0 = r1;
        this.$baseUrl = r2;
        this.$relativePath = r3;
        this.$param = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ReportService$reportApi$1(this.this$0, this.$baseUrl, this.$relativePath, this.$param, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r13 = "";
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r2 = this.J$1;
        long r3 = this.J$0;
        String r4 = (String) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L8
        long r16 = r2;
        Object r6 = r21;
    L63:
        String r7 = (String) r6;     // Catch: Exception -> L36
        if (r7 == null) goto L35;
        int r8 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Exception -> L36
        long r9 = System.currentTimeMillis();     // Catch: Exception -> L36
        r84.a.d(null, "成功上报", 5);     // Catch: Exception -> L33
        j r10 = this.this$0;     // Catch: Exception -> L33
        int r11 = j.e;     // Catch: Exception -> L33
        r10.getClass();     // Catch: Exception -> L33
        g r12 = j.b(r7);     // Catch: Exception -> L30
        r84.a.d(null, "上报响应处理成功, response = " + r12, 5);     // Catch: Exception -> L30
        r5 = "1";
        r84.a.d(null, "成功处理上报响应", 5);     // Catch: Exception -> L33
        j.b r14 = this.this$0.d;     // Catch: Exception -> L33
        if (r14 == null) goto L29;
        r14.a(r12);     // Catch: Exception -> L33
    L29:
        r84.a.d(null, "成功处理上报回调", 5);     // Catch: Exception -> L33
    L56:
        int r15 = com.bytedance.bdnavigationsdk.utils.e.a;
        long r17 = System.currentTimeMillis();
        r84.a.d(null, "结束上报请求", 5);
        b0 r18 = this.this$0.b;
        if (r18 == null) goto L60;
        r18.a(Constants.EventReportApi.getValue(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("navigation_id", this.$param.f), TuplesKt.to("business", this.$param.d), TuplesKt.to("plan_type", this.$param.e), TuplesKt.to("duration", Boxing.boxLong(r17 - r3)), TuplesKt.to("req_duration", Boxing.boxLong(r9 - r3)), TuplesKt.to("callback_duration", Boxing.boxLong(r17 - r9)), TuplesKt.to(LocationMonitorConst.IS_SUCCESS, r5), TuplesKt.to("error_message", r4)}));
    L60:
        return Unit.INSTANCE;
    L30:
        e = move-exception;
        r84.a.b("上报响应处理失败", e, 1);     // Catch: Exception -> L33
        throw e;     // Catch: Exception -> L33
    L33:
        e = e;
    L48:
        r84.a.b("上报异常", e, 1);
        String r19 = e.getMessage();
        if (r19 == null) goto L52;
        r13 = r19;
    L52:
        String r20 = StringsKt.take(r13, 30);
        j r22 = this.this$0;
        int r23 = j.e;
        j.b r24 = r22.d;
        if (r24 == null) goto L55;
        r24.b(e);
    L55:
        r4 = r20;
    L35:
        r2 = r16;
        throw new Exception("HttpClient未初始化");     // Catch: Exception -> L8
    L36:
        e = e;
        long r25 = r3;
        String r110 = r5;
    L47:
        r5 = r110;
        r3 = r25;
        r9 = r16;
    L8:
        e = e;
        r9 = r2;
        goto L48
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r21);
        int r26 = com.bytedance.bdnavigationsdk.utils.e.a;
        long r27 = System.currentTimeMillis();
        r84.a.d(null, "尝试上报", 5);
        long r28 = System.currentTimeMillis();
        r110 = BDLocationException.ERROR_TIMEOUT;
        LinkedHashMap r29 = new LinkedHashMap();     // Catch: Exception -> L44
        r29.put(Constants.ContentType.getValue(), Constants.ContentTypeValue.getValue());     // Catch: Exception -> L44
        Map<String, String> r30 = s84.a.a;     // Catch: Exception -> L44
        r29.putAll(MapsKt.emptyMap());     // Catch: Exception -> L44
        com.bytedance.bdnavigationsdk.c r31 = this.this$0.a;     // Catch: Exception -> L44
        if (r31 == null) goto L40;
        String r32 = this.$baseUrl;     // Catch: Exception -> L44
        String r111 = this.$relativePath;     // Catch: Exception -> L44
        f r112 = this.$param;     // Catch: Exception -> L44
        Map r33 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appid", r112.a), TuplesKt.to("device_platform", r112.b)});     // Catch: Exception -> L44
        String r113 = j.a(this.this$0, this.$param);     // Catch: Exception -> L44
        this.L$0 = BDLocationException.ERROR_TIMEOUT;     // Catch: Exception -> L44
        this.L$1 = "";     // Catch: Exception -> L44
        this.J$0 = r27;     // Catch: Exception -> L44
        this.J$1 = r28;     // Catch: Exception -> L44
        this.label = 1;     // Catch: Exception -> L44
        r16 = r28;
        long r34 = r27;
        r6 = r31.a(r32, r111, r33, r29, r113, this);     // Catch: Exception -> L38
        if (r6 != r0) goto L20;
        return r0;
    L20:
        r3 = r34;
        r4 = "";
        r5 = BDLocationException.ERROR_TIMEOUT;
    L38:
        e = e;
    L46:
        r25 = r34;
        goto L47
    L40:
        r16 = r28;
        r3 = r27;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L44:
        e = e;
        r16 = r28;
        r34 = r27;
        goto L46
    }
}
