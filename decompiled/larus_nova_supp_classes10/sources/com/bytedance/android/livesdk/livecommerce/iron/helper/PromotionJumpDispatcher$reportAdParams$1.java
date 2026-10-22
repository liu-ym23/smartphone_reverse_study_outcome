package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher$reportAdParams$1", f = "PromotionJumpDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromotionJumpDispatcher$reportAdParams$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schema;
    int label;

    public PromotionJumpDispatcher$reportAdParams$1(String r1, Continuation r2) {
        this.$schema = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new PromotionJumpDispatcher$reportAdParams$1(this.$schema, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r15);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L37
        Map r17 = new UrlBuilderV2(this.$schema).getMMap();     // Catch: Throwable -> L37
        String r0 = (String) r17.get("v3_events_additions");     // Catch: Throwable -> L37
        String r1 = null;
        if (r0 == null) goto L8;
        JSONObject r2 = z1.g(r0);     // Catch: Throwable -> L37
    L9:
        if (r2 == null) goto L13;
        String r3 = r2.optString("transmissible_json");     // Catch: Throwable -> L37
        if (r3 == null) goto L13;
        JSONObject r4 = z1.g(r3);     // Catch: Throwable -> L37
    L14:
        String r5 = (String) r17.get("meta_params");     // Catch: Throwable -> L37
        if (r5 == null) goto L17;
        JSONObject r6 = z1.g(r5);     // Catch: Throwable -> L37
    L18:
        int r7 = ECSdk.a;     // Catch: Throwable -> L37
        IECAPTService r8 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Throwable -> L37
        if (r8 == null) goto L35;
        String r9 = (String) r17.get("log_extra");     // Catch: Throwable -> L37
        String r18 = (String) r17.get("ad_extra_data");     // Catch: Throwable -> L37
        if (r18 == null) goto L23;
        JSONObject r10 = z1.g(r18);     // Catch: Throwable -> L37
    L24:
        if (r6 == null) goto L28;
        String r19 = r6.optString("entrance_info");     // Catch: Throwable -> L37
        if (r19 == null) goto L28;
        JSONObject r11 = z1.g(r19);     // Catch: Throwable -> L37
    L29:
        if (r2 == null) goto L31;
        String r12 = r2.optString("creative_id");     // Catch: Throwable -> L37
    L32:
        if (r4 == null) goto L34;
        r1 = r4.optString("room_id");     // Catch: Throwable -> L37
    L34:
        r8.record(new lg.l(new lg.e(r9, r10, r11, r12, r1, 480)));     // Catch: Throwable -> L37
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L37
        goto L35
    L31:
        r12 = null;
    L28:
        r11 = null;
        goto L29
    L23:
        r10 = null;
    L35:
        Object r110 = Result.constructor-impl(r1);     // Catch: Throwable -> L37
    L39:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L43;
        ECExceptionMonitor.e(r111);
    L43:
        return Unit.INSTANCE;
    L17:
        r6 = null;
    L13:
        r4 = null;
        goto L14
    L8:
        r2 = null;
    L37:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
