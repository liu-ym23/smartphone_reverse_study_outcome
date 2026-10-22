package com.larus.uaigc.spring.lottery;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.spring.lottery.ZLotteryMobHelper$reportPocketMessageCardShowed$1", f = "ZLotteryMobHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ZLotteryMobHelper$reportPocketMessageCardShowed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardType;
    final /* synthetic */ long $createToLynxDuration;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ Boolean $isStream;
    final /* synthetic */ boolean $lynxViewLoadSuccess;
    final /* synthetic */ String $messageId;
    int label;

    public ZLotteryMobHelper$reportPocketMessageCardShowed$1(String r100, boolean r101, long r102, String r103, int r104, String r105, Boolean r106, Continuation<? super ZLotteryMobHelper$reportPocketMessageCardShowed$1> r107) {
        this.$messageId = r100;
        this.$lynxViewLoadSuccess = r101;
        this.$createToLynxDuration = r102;
        this.$cardType = r103;
        this.$errorCode = r104;
        this.$errorMsg = r105;
        this.$isStream = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new ZLotteryMobHelper$reportPocketMessageCardShowed$1(this.$messageId, this.$lynxViewLoadSuccess, this.$createToLynxDuration, this.$cardType, this.$errorCode, this.$errorMsg, this.$isStream, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ZLotteryMobHelper$reportPocketMessageCardShowed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r110);
        int r111 = ZLotteryMobHelper.f374125a;
        JSONObject r112 = new JSONObject();
        String r100 = this.$messageId;
        boolean r101 = this.$lynxViewLoadSuccess;
        long r102 = this.$createToLynxDuration;
        String r103 = this.$cardType;
        int r104 = this.$errorCode;
        String r105 = this.$errorMsg;
        Boolean r106 = this.$isStream;
        r112.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
        r112.put("lynx_view_load_result", de8.d.b(Boxing.boxBoolean(r101)));
        r112.put("create_to_lynx_duration", r102);
        r112.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r103);
        r112.putOpt("error_code", Boxing.boxInt(r104));
        r112.putOpt("error_msg", r105);
        r112.putOpt("is_stream", de8.d.b(r106));
        Unit r107 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("pocket_message_card_showed", "eventName");
        Intrinsics.checkNotNullParameter(r112, "dataJson");
        o.f365780a.reportEvent("pocket_message_card_showed", r112);     // Catch: Exception -> L7
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("pocket_message_card_showed", r112, new JSONObject(), null);     // Catch: Exception -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        FLogger.f375446a.e("ZLotteryMobHelper", "reportEvent error", e);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
