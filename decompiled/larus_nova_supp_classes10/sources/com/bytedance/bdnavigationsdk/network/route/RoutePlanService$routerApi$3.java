package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.android.livesdk.link.model.bridge.z0;
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
@DebugMetadata(c = "com.bytedance.bdnavigationsdk.network.route.RoutePlanService$routerApi$3", f = "RoutePlanService.kt", i = {0, 0, 0, 0}, l = {z0.TYPE_APPLY}, m = "invokeSuspend", n = {"isSuccess", "errorMessage", "startRoutePlanTime", "endRequestTime"}, s = {"L$0", "L$1", "J$0", "J$1"})
final class RoutePlanService$routerApi$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ Function2<String, Exception, Unit> $onFailure;
    final /* synthetic */ Function2<String, p, Unit> $onSuccess;
    final /* synthetic */ j $param;
    final /* synthetic */ String $relativePath;
    final /* synthetic */ String $routeUpdateId;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ o this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public RoutePlanService$routerApi$3(o r1, String r2, String r3, j r4, Function2<? super String, ? super p, Unit> r5, String r6, Function2<? super String, ? super Exception, Unit> r7, Continuation<? super RoutePlanService$routerApi$3> r8) {
        this.this$0 = r1;
        this.$baseUrl = r2;
        this.$relativePath = r3;
        this.$param = r4;
        this.$onSuccess = r5;
        this.$routeUpdateId = r6;
        this.$onFailure = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RoutePlanService$routerApi$3(this.this$0, this.$baseUrl, this.$relativePath, this.$param, this.$onSuccess, this.$routeUpdateId, this.$onFailure, r11);
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
        Object r11 = "";
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r2 = this.J$1;
        long r3 = this.J$0;
        String r4 = (String) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L8
        long r14 = r2;
        Object r6 = r17;
    L69:
        String r7 = (String) r6;     // Catch: Exception -> L33
        if (r7 == null) goto L32;
        int r8 = com.bytedance.bdnavigationsdk.utils.e.a;     // Catch: Exception -> L33
        r14 = System.currentTimeMillis();     // Catch: Exception -> L33
        r84.a.d(null, "成功路径规划", 5);     // Catch: Exception -> L29
        p r9 = o.b(this.this$0, this.$param, r7);     // Catch: Exception -> L29
        String r10 = "1";
        r84.a.d(null, "成功处理路径规划响应", 5);     // Catch: Exception -> L27
        this.$onSuccess.invoke(this.$routeUpdateId, r9);     // Catch: Exception -> L27
        r84.a.d(null, "成功处理路径规划回调", 5);     // Catch: Exception -> L27
    L49:
        int r12 = com.bytedance.bdnavigationsdk.utils.e.a;
        long r13 = System.currentTimeMillis();
        r84.a.d(null, "结束路径规划请求", 5);
        b0 r15 = this.this$0.b;
        if (r15 == null) goto L60;
        String r16 = Constants.EventRoutePlanApi.getValue();
        Pair[] r18 = new Pair[10];
        r18[0] = TuplesKt.to("navigation_id", this.$param.a);
        r18[1] = TuplesKt.to("business", this.$param.b);
        r18[2] = TuplesKt.to("plan_type", this.$param.c);
        PoiType r19 = this.$param.i;
        if (r19 == null) goto L54;
        Object r20 = Boxing.boxInt(r19.getCode());
    L55:
        r18[3] = TuplesKt.to("origin_id_type", r20);
        PoiType r21 = this.$param.j;
        if (r21 == null) goto L58;
        r11 = Boxing.boxInt(r21.getCode());
    L58:
        r18[4] = TuplesKt.to("destination_id_type", r11);
        r18[5] = TuplesKt.to("duration", Boxing.boxLong(r13 - r3));
        r18[6] = TuplesKt.to("req_duration", Boxing.boxLong(r14 - r3));
        r18[7] = TuplesKt.to("callback_duration", Boxing.boxLong(r13 - r14));
        r18[8] = TuplesKt.to(LocationMonitorConst.IS_SUCCESS, r10);
        r18[9] = TuplesKt.to("error_message", r4);
        r15.a(r16, MapsKt.mutableMapOf(r18));
        goto L60
    L54:
        r20 = "";
    L60:
        return Unit.INSTANCE;
    L27:
        e = e;
        String r22 = "1";
    L31:
        long r110 = r3;
    L45:
        r84.a.b("路径规划异常", e, 1);
        String r23 = e.getMessage();
        if (r23 != null) goto L48;
        r23 = "";
    L48:
        String r24 = StringsKt.take(r23, 30);
        this.$onFailure.invoke(this.$routeUpdateId, e);
        r4 = r24;
        r10 = r22;
        r3 = r110;
    L29:
        e = e;
        r22 = r5;
    L32:
        r2 = r14;
        throw new Exception("HttpClient未初始化");     // Catch: Exception -> L8
    L33:
        e = e;
    L41:
        r110 = r3;
        r22 = r5;
    L8:
        e = e;
        r14 = r2;
        goto L41
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);
        int r25 = com.bytedance.bdnavigationsdk.utils.e.a;
        r110 = System.currentTimeMillis();
        r84.a.d(null, "尝试路径规划", 5);
        r14 = System.currentTimeMillis();
        LinkedHashMap r26 = new LinkedHashMap();     // Catch: Exception -> L42
        Map<String, String> r27 = s84.a.a;     // Catch: Exception -> L42
        r26.putAll(MapsKt.emptyMap());     // Catch: Exception -> L42
        o r28 = this.this$0;     // Catch: Exception -> L42
        com.bytedance.bdnavigationsdk.c r29 = r28.a;     // Catch: Exception -> L42
        if (r29 == null) goto L37;
        String r30 = this.$baseUrl;     // Catch: Exception -> L42
        String r31 = this.$relativePath;     // Catch: Exception -> L42
        Map r32 = o.a(r28, this.$param);     // Catch: Exception -> L42
        this.L$0 = BDLocationException.ERROR_TIMEOUT;     // Catch: Exception -> L42
        this.L$1 = "";     // Catch: Exception -> L42
        this.J$0 = r110;     // Catch: Exception -> L42
        this.J$1 = r14;     // Catch: Exception -> L42
        this.label = 1;     // Catch: Exception -> L42
        String r33 = BDLocationException.ERROR_TIMEOUT;
        r6 = r29.b(r30, r31, r32, r26, this);     // Catch: Exception -> L35
        if (r6 != r0) goto L20;
        return r0;
    L20:
        r5 = r33;
        r4 = "";
        r3 = r110;
    L35:
        e = e;
    L44:
        r22 = r33;
        goto L45
    L37:
        r5 = BDLocationException.ERROR_TIMEOUT;
        r3 = r110;
    L42:
        e = e;
        r33 = BDLocationException.ERROR_TIMEOUT;
        goto L44
    }
}
