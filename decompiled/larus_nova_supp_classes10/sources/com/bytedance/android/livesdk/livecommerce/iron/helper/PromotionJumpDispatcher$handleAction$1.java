package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import vi2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher$handleAction$1", f = "PromotionJumpDispatcher.kt", i = {}, l = {670}, m = "invokeSuspend", n = {}, s = {})
public final class PromotionJumpDispatcher$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deferTime;
    final /* synthetic */ LiveRoomParams $liveRoomParams;
    final /* synthetic */ Map $reqParam;
    final /* synthetic */ String $route;
    int label;
    final /* synthetic */ PromotionJumpDispatcher this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PromotionJumpDispatcher$handleAction$1 a;

        public a(PromotionJumpDispatcher$handleAction$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.ec.model.response.r r3 = (com.bytedance.android.ec.model.response.r) r2;
            Lazy r0 = EnterRequestHandler.a;
            LiveRoomParams r1 = this.a.$liveRoomParams;
            if (r1 == null) goto L5;
            Map r4 = r1.getReportParams();
        L6:
            if (r4 != null) goto L8;
            r4 = MapsKt.emptyMap();
        L8:
            EnterRequestHandler.j(r3, r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public PromotionJumpDispatcher$handleAction$1(PromotionJumpDispatcher r1, long r2, Map r4, String r5, LiveRoomParams r6, Continuation r7) {
        this.this$0 = r1;
        this.$deferTime = r2;
        this.$reqParam = r4;
        this.$route = r5;
        this.$liveRoomParams = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new PromotionJumpDispatcher$handleAction$1(this.this$0, this.$deferTime, this.$reqParam, this.$route, this.$liveRoomParams, r10);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r23);
    L13:
        Map r1 = this.$reqParam;
        String r3 = null;
        if (r1 != null) goto L71;
        JSONObject r6 = null;
    L24:
        Lazy r4 = EnterRequestHandler.a;
        JSONObject r5 = EnterRequestHandler.h();
        String r13 = this.$route;
        LiveRoomParams r7 = this.$liveRoomParams;
        if (r7 == null) goto L27;
        String r14 = r7.getRoomId();
    L28:
        LiveRoomParams r8 = this.$liveRoomParams;
        if (r8 == null) goto L31;
        String r15 = r8.getRoomUniqueKey();
    L32:
        LiveRoomParams r9 = this.$liveRoomParams;
        if (r9 == null) goto L35;
        String r10 = r9.getAuthorId();
    L36:
        ECEventUtilsV2 r11 = ECEventUtilsV2.b;
        LiveRoomParams r12 = this.$liveRoomParams;
        if (r12 == null) goto L41;
        JSONObject r16 = r12.getEntranceInfo();
        if (r16 == null) goto L41;
        Map r17 = z1.j(r16);
    L42:
        LiveRoomParams r18 = this.$liveRoomParams;
        if (r18 == null) goto L45;
        Map r19 = r18.getEcomLiveParamsEventParams();
    L46:
        if (r19 != null) goto L48;
        r19 = MapsKt.emptyMap();
    L48:
        Map r110 = r19;
        LiveRoomParams r20 = this.$liveRoomParams;
        if (r20 == null) goto L51;
        String r21 = r20.getEcomSceneId();
    L52:
        r11.getClass();
        String r111 = ECEventUtilsV2.b(null, r17, r110, null, null, r21);
        if (r5 == null) goto L55;
        r3 = r5.toString();
    L55:
        if (r3 != null) goto L57;
        String r112 = "";
    L58:
        LiveRoomParams r22 = this.$liveRoomParams;
        if (r22 != null) goto L61;
    L63:
        boolean r113 = false;
    L64:
        Observable r24 = vi2.h.e(r14, r15, r13, new m0(r13, r6, r14, r15, r10, r111, r112, r113));
        if (r24 == null) goto L70;
        Disposable r25 = r24.subscribe(new a(this), b.a);
        if (r25 == null) goto L70;
        bk2.c.a(r25, this.this$0.f);
    L70:
        return Unit.INSTANCE;
    L61:
        if (r22.isShowCart() != 1) goto L63;
        r113 = true;
        goto L64
    L57:
        r112 = r3;
        goto L58
    L51:
        r21 = null;
        goto L52
    L45:
        r19 = null;
    L41:
        r17 = null;
        goto L42
    L35:
        r10 = null;
        goto L36
    L31:
        r15 = null;
        goto L32
    L27:
        r14 = null;
        goto L28
    L71:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L17
        Object r27 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r27) == false) goto L22;
        r27 = null;
    L22:
        r6 = (JSONObject) r27;
    L17:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        long r29 = this.$deferTime;
        if (r29 <= 0) goto L13;
        this.label = 1;
        if (DelayKt.delay(r29 * ((long) 1000), this) != r0) goto L13;
        return r0;
    }
}
