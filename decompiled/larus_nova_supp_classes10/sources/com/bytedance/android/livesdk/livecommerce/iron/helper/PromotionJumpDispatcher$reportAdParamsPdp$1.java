package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher$reportAdParamsPdp$1", f = "PromotionJumpDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromotionJumpDispatcher$reportAdParamsPdp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schema;
    int label;

    public PromotionJumpDispatcher$reportAdParamsPdp$1(String r1, Continuation r2) {
        this.$schema = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new PromotionJumpDispatcher$reportAdParamsPdp$1(this.$schema, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r11);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L49
        Map r13 = new UrlBuilderV2(this.$schema).getMMap();     // Catch: Throwable -> L49
        String r0 = (String) r13.get("custom_params");     // Catch: Throwable -> L49
        String r1 = null;
        if (r0 == null) goto L8;
        JSONObject r2 = z1.g(r0);     // Catch: Throwable -> L49
    L9:
        if (r2 == null) goto L11;
        JSONObject r3 = r2.optJSONObject("ad_params");     // Catch: Throwable -> L49
    L12:
        String r4 = (String) r13.get("biz_context");     // Catch: Throwable -> L49
        if (r4 == null) goto L15;
        JSONObject r5 = z1.g(r4);     // Catch: Throwable -> L49
    L16:
        String r14 = (String) r13.get("pass_through");     // Catch: Throwable -> L49
        if (r14 == null) goto L19;
        JSONArray r15 = z1.e(r14);     // Catch: Throwable -> L49
    L20:
        final JSONObject r6 = new JSONObject();     // Catch: Throwable -> L49
        boolean r7 = false;
        if (r15 == null) goto L25;
        Function1<String, Unit> r8 = new PromotionJumpDispatcher$reportAdParamsPdp$1$1$1(r6);     // Catch: Throwable -> L49
        Lazy r9 = UtilityKotlinExtentionsKt.a;     // Catch: Throwable -> L49
        Intrinsics.checkNotNullParameter(r15, "$this$forEach");     // Catch: Throwable -> L49
        Intrinsics.checkNotNullParameter(r8, "block");     // Catch: Throwable -> L49
        int r10 = r15.length();     // Catch: Throwable -> L49
        int r16 = 0;
    L23:
        if (r16 >= r10) goto L25;
        r8.invoke(r15.optString(r16));     // Catch: Throwable -> L49
        r16 = r16 + 1;     // Catch: Throwable -> L49
    L25:
        int r17 = ECSdk.a;     // Catch: Throwable -> L49
        IECAPTService r18 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Throwable -> L49
        if (r18 == null) goto L47;
        if (r3 == null) goto L29;
        String r19 = r3.optString("log_extra");     // Catch: Throwable -> L49
    L30:
        if (r3 == null) goto L34;
        String r20 = r3.optString("ad_extra_data");     // Catch: Throwable -> L49
        if (r20 == null) goto L34;
        JSONObject r21 = z1.g(r20);     // Catch: Throwable -> L49
    L36:
        if (r6.length() <= 0) goto L38;
        r7 = true;
    L38:
        if (r7 == true) goto L41;
        r6 = null;
    L41:
        if (r3 == null) goto L43;
        String r22 = r3.optString("creative_id");     // Catch: Throwable -> L49
    L44:
        if (r5 == null) goto L46;
        r1 = r5.optString("live_room_id");     // Catch: Throwable -> L49
    L46:
        r18.record(new lg.l(new lg.e(r19, r21, r6, r22, r1, 480)));     // Catch: Throwable -> L49
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L49
        goto L47
    L43:
        r22 = null;
    L34:
        r21 = null;
        goto L36
    L29:
        r19 = null;
    L47:
        Object r110 = Result.constructor-impl(r1);     // Catch: Throwable -> L49
    L51:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L55;
        ECExceptionMonitor.e(r111);
    L55:
        return Unit.INSTANCE;
    L19:
        r15 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
    L49:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
