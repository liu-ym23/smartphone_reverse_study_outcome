package com.bytedance.bdnavigationsdk.network.config;

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
@DebugMetadata(c = "com.bytedance.bdnavigationsdk.network.config.ConfigureService$configureApi$1", f = "ConfigureService.kt", i = {0, 0, 0, 0}, l = {84}, m = "invokeSuspend", n = {"isSuccess", "errorMessage", "startConfigureTime", "endRequestTime"}, s = {"L$0", "L$1", "J$0", "J$1"})
final class ConfigureService$configureApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ d $param;
    final /* synthetic */ String $relativePath;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ g this$0;

    public ConfigureService$configureApi$1(g r1, String r2, String r3, d r4, Continuation<? super ConfigureService$configureApi$1> r5) {
        this.this$0 = r1;
        this.$baseUrl = r2;
        this.$relativePath = r3;
        this.$param = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ConfigureService$configureApi$1(this.this$0, this.$baseUrl, this.$relativePath, this.$param, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r10 = "";
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r2 = this.J$1;
        long r3 = this.J$0;
        String r4 = (String) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L8
        long r14 = r2;
        Object r6 = r17;
    L73:
        String r7 = (String) r6;     // Catch: Exception -> L41
        if (r7 == null) goto L40;
        int r8 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Exception -> L41
        r14 = System.currentTimeMillis();     // Catch: Exception -> L41
        r84.a.d(null, "成功获取配置", 5);     // Catch: Exception -> L37
        g r9 = this.this$0;     // Catch: Exception -> L37
        int r11 = g.e;     // Catch: Exception -> L37
        r9.getClass();     // Catch: Exception -> L37
        e r12 = g.b(r7);     // Catch: Exception -> L34
        r84.a.d(null, "获取配置响应处理成功，response = " + r12, 5);     // Catch: Exception -> L34
        String r13 = "1";
        r84.a.d(null, "成功处理获取配置响应", 5);     // Catch: Exception -> L32
        g.b r15 = this.this$0.d;     // Catch: Exception -> L32
        if (r15 == null) goto L30;
        r15.b(r12);     // Catch: Exception -> L32
    L30:
        r84.a.d(null, "成功处理获取配置回调", 5);     // Catch: Exception -> L32
    L61:
        int r16 = com.bytedance.bdnavigationsdk.utils.e.a;
        long r18 = System.currentTimeMillis();
        r84.a.d(null, "结束获取配置请求", 5);
        b0 r19 = this.this$0.b;
        if (r19 == null) goto L65;
        r19.a(Constants.EventConfigureApi.getValue(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", Boxing.boxLong(r18 - r3)), TuplesKt.to("req_duration", Boxing.boxLong(r14 - r3)), TuplesKt.to("callback_duration", Boxing.boxLong(r18 - r14)), TuplesKt.to(LocationMonitorConst.IS_SUCCESS, r13), TuplesKt.to("error_message", r4)}));
    L65:
        return Unit.INSTANCE;
    L32:
        e = e;
        String r20 = "1";
    L39:
        long r110 = r3;
    L53:
        r84.a.b("获取配置异常", e, 1);
        String r21 = e.getMessage();
        if (r21 == null) goto L57;
        r10 = r21;
    L57:
        String r22 = StringsKt.take(r10, 30);
        g r23 = this.this$0;
        int r24 = g.e;
        g.b r25 = r23.d;
        if (r25 == null) goto L60;
        r25.a(e);
    L60:
        r4 = r22;
        r13 = r20;
        r3 = r110;
        goto L61
    L34:
        e = move-exception;
        r84.a.b("获取配置响应处理失败", e, 1);     // Catch: Exception -> L37
        throw e;     // Catch: Exception -> L37
    L37:
        e = e;
        r20 = r5;
    L40:
        r2 = r14;
        throw new Exception("HttpClient未初始化");     // Catch: Exception -> L8
    L41:
        e = e;
    L49:
        r110 = r3;
        r20 = r5;
    L8:
        e = e;
        r14 = r2;
        goto L49
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);
        int r26 = com.bytedance.bdnavigationsdk.utils.e.a;
        r110 = System.currentTimeMillis();
        r84.a.d(null, "尝试获取配置", 5);
        r14 = System.currentTimeMillis();
        LinkedHashMap r27 = new LinkedHashMap();     // Catch: Exception -> L50
        Map<String, String> r28 = s84.a.a;     // Catch: Exception -> L50
        r27.putAll(MapsKt.emptyMap());     // Catch: Exception -> L50
        g r29 = this.this$0;     // Catch: Exception -> L50
        com.bytedance.bdnavigationsdk.c r30 = r29.a;     // Catch: Exception -> L50
        if (r30 == null) goto L45;
        String r31 = this.$baseUrl;     // Catch: Exception -> L50
        String r32 = this.$relativePath;     // Catch: Exception -> L50
        Map r33 = g.a(r29, this.$param);     // Catch: Exception -> L50
        this.L$0 = BDLocationException.ERROR_TIMEOUT;     // Catch: Exception -> L50
        this.L$1 = "";     // Catch: Exception -> L50
        this.J$0 = r110;     // Catch: Exception -> L50
        this.J$1 = r14;     // Catch: Exception -> L50
        this.label = 1;     // Catch: Exception -> L50
        String r34 = BDLocationException.ERROR_TIMEOUT;
        r6 = r30.b(r31, r32, r33, r27, this);     // Catch: Exception -> L43
        if (r6 != r0) goto L20;
        return r0;
    L20:
        r5 = r34;
        r4 = "";
        r3 = r110;
    L43:
        e = e;
    L52:
        r20 = r34;
        goto L53
    L45:
        r5 = BDLocationException.ERROR_TIMEOUT;
        r3 = r110;
    L50:
        e = e;
        r34 = BDLocationException.ERROR_TIMEOUT;
        goto L52
    }
}
