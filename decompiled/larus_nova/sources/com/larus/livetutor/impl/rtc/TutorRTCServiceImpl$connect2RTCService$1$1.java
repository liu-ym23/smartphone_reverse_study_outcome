package com.larus.livetutor.impl.rtc;

import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.api.idl.StartCallResponse;
import com.larus.livetutor.api.idl.StatusInfo;
import com.larus.livetutor.impl.repository.LiveTutorApi;
import com.larus.livetutor.impl.rtc.api.RTCErrorCode;
import com.larus.livetutor.impl.rtc.api.RTCException;
import com.larus.livetutor.impl.rtc.api.RpcException;
import com.larus.platform.service.AccountService;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.type.RoomProfile;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.rtc.TutorRTCServiceImpl$connect2RTCService$1$1", f = "TutorRTCServiceImpl.kt", i = {}, l = {168, 193}, m = "invokeSuspend", n = {}, s = {})
final class TutorRTCServiceImpl$connect2RTCService$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<StartCallResponse, Unit> $responseBlock;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ StartCallRequest $startCallRequest;
    int label;
    final /* synthetic */ TutorRTCServiceImpl this$0;

    /* JADX INFO: renamed from: com.larus.livetutor.impl.rtc.TutorRTCServiceImpl$connect2RTCService$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.livetutor.impl.rtc.TutorRTCServiceImpl$connect2RTCService$1$1$1", f = "TutorRTCServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appId;
        final /* synthetic */ StartCallResponse $res;
        final /* synthetic */ String $roomId;
        final /* synthetic */ String $token;
        int label;
        final /* synthetic */ TutorRTCServiceImpl this$0;

        public AnonymousClass1(TutorRTCServiceImpl r100, String r101, StartCallResponse r102, String r103, String r104, Continuation<? super AnonymousClass1> r105) {
            this.this$0 = r100;
            this.$appId = r101;
            this.$res = r102;
            this.$roomId = r103;
            this.$token = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$appId, this.$res, this.$roomId, this.$token, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L15:
            this.this$0.f().getClass();
            Intrinsics.checkNotNullParameter("rtc_core_engine_created", "scene");
            com.larus.livetutor.impl.rtc.handler.m r111 = this.this$0.e();
            String r102 = "加入房间中... roomId = " + this.$roomId;
            int r103 = com.larus.livetutor.impl.rtc.handler.m.f356343c;
            r111.b("TutorRTCServiceImpl", r102, false);
            TutorRTCServiceImpl r112 = this.this$0;
            b r104 = r112.f356250o;
            String r105 = this.$roomId;
            String r106 = this.$token;
            com.larus.livetutor.impl.rtc.handler.z r113 = (com.larus.livetutor.impl.rtc.handler.z) r112.f356242g.getValue();
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "roomId");
            Intrinsics.checkNotNullParameter(r106, "token");
            RTCEngine r107 = r104.f356277a;
            if (r107 == null) goto L37;
            RTCRoom r108 = r107.createRTCRoom(r105);
            if (r108 == null) goto L37;
            r104.f356278b = r108;
            Integer r114 = Integer.valueOf(r108.setRTCRoomEventHandler(r113));
            if (r114 == null) goto L35;
            if (r114.intValue() != 0) goto L35;
            UserInfo r115 = new UserInfo(AccountService.f365697a.getUserId(), "");
            RTCRoom r109 = r104.f356278b;
            if (r109 == null) goto L26;
            Integer r116 = Integer.valueOf(r109.joinRoom(r106, r115, true, new RTCRoomConfig(RoomProfile.CHAT_ROOM, true, false, true, false, false, 0)));
        L27:
            if (r116 == null) goto L33;
            if (r116.intValue() != 0) goto L33;
            return Unit.INSTANCE;
        L33:
            throw new RTCException(RTCErrorCode.JOIN_ROOM, "joinRoom failed, ret = " + r116);
        L26:
            r116 = null;
        L35:
            throw new RTCException(RTCErrorCode.JOIN_ROOM, "setRTCRoomEventHandler failed, ret = " + r114);
        L37:
            throw new RTCException(RTCErrorCode.JOIN_ROOM, "createRTCRoom failed please createRTCEngine first or check room id");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            TutorRTCServiceImpl r117 = this.this$0;
            b r118 = r117.f356250o;
            com.larus.livetutor.impl.rtc.handler.x r119 = (com.larus.livetutor.impl.rtc.handler.x) r117.f356241f.getValue();
            String r120 = this.$appId;
            Boolean r121 = this.$res.isTest();
            if (r121 == null) goto L11;
            boolean r122 = r121.booleanValue();
        L12:
            this.label = 1;
            if (r118.a(r119, r120, r122, this) != r100) goto L15;
            return r100;
        L11:
            r122 = false;
            goto L12
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TutorRTCServiceImpl$connect2RTCService$1$1(TutorRTCServiceImpl r100, CoroutineScope r101, Function1<? super StartCallResponse, Unit> r102, StartCallRequest r103, Continuation<? super TutorRTCServiceImpl$connect2RTCService$1$1> r104) {
        this.this$0 = r100;
        this.$scope = r101;
        this.$responseBlock = r102;
        this.$startCallRequest = r103;
        super(1, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new TutorRTCServiceImpl$connect2RTCService$1$1(this.this$0, this.$scope, this.$responseBlock, this.$startCallRequest, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((TutorRTCServiceImpl$connect2RTCService$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L68:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
    L13:
        StartCallResponse r102 = (StartCallResponse) r110;
        if (CoroutineScopeKt.isActive(this.$scope) == true) goto L17;
        this.this$0.e().a("TutorRTCServiceImpl", "connect2RTCService 协程已取消");
        return Unit.INSTANCE;
    L17:
        this.this$0.A = true;
        StatusInfo r111 = r102.getStatusInfo();
        if (r111 == null) goto L25;
        Integer r112 = r111.getStatusCode();
        if (r112 == null) goto L25;
        if (r112.intValue() != 0) goto L25;
        boolean r113 = true;
    L26:
        String r103 = "";
        if (r113 == true) goto L42;
        StatusInfo r104 = r102.getStatusInfo();
        if (r104 == null) goto L33;
        Integer r105 = r104.getStatusCode();
        if (r105 == null) goto L33;
        int r106 = r105.intValue();
    L34:
        StatusInfo r107 = r102.getStatusInfo();
        if (r107 == null) goto L41;
        String r108 = r107.getStatusMsg();
        if (r108 == null) goto L41;
        r103 = r108;
    L41:
        throw new RpcException(r106, r103);
    L33:
        r106 = -1;
        goto L34
    L42:
        this.this$0.f().getClass();
        Intrinsics.checkNotNullParameter("rtc_core_api_success", "scene");
        this.this$0.e().b("TutorRTCServiceImpl", "接口请求成功 " + r102, true);
        String r114 = r102.getRtcToken();
        if (r114 != null) goto L45;
        String r115 = "";
    L46:
        TutorRTCServiceImpl r116 = this.this$0;
        String r109 = r102.getBotRtcUserId();
        if (r109 != null) goto L49;
        r109 = "";
    L49:
        r116.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r116.f356255t = r109;
        String r117 = r102.getRtcRoomId();
        if (r117 != null) goto L52;
        String r118 = "";
    L53:
        TutorRTCServiceImpl r119 = this.this$0;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r119.f356256u = r118;
        String r120 = r102.getRtcAppId();
        if (r120 != null) goto L56;
        String r121 = "";
    L57:
        TutorRTCServiceImpl r122 = this.this$0;
        r122.f356257v = r121;
        Long r123 = r102.getRtcCallId();
        if (r123 == null) goto L60;
        long r124 = r123.longValue();
    L61:
        r122.f356258w = r124;
        Function1<StartCallResponse, Unit> r125 = this.$responseBlock;
        if (r125 == null) goto L64;
        r125.invoke(r102);
    L64:
        this.this$0.e().b("TutorRTCServiceImpl", "开始创建RTC引擎 appId = " + r121 + " 是否测试环境 " + r102.isTest(), false);
        CoroutineContext r126 = this.this$0.f356253r.getCoroutineContext();
        AnonymousClass1 r127 = new AnonymousClass1(this.this$0, r121, r102, r118, r115, null);
        this.label = 2;
        if (BuildersKt.withContext(r126, r127, this) != r100) goto L68;
        return r100;
    L60:
        r124 = 0;
        goto L61
    L56:
        r121 = r120;
        goto L57
    L52:
        r118 = r117;
        goto L53
    L45:
        r115 = r114;
    L25:
        r113 = false;
        goto L26
    L10:
        ResultKt.throwOnFailure(r110);
        com.larus.livetutor.impl.rtc.handler.m r128 = this.this$0.e();
        int r129 = com.larus.livetutor.impl.rtc.handler.m.f356343c;
        r128.b("TutorRTCServiceImpl", "正式请求/hippo/ai_tutor/v1/realtime_call/start", false);
        LiveTutorApi.Companion r130 = LiveTutorApi.f356187a;
        TutorRTCServiceImpl$connect2RTCService$1$1$res$1 r131 = new TutorRTCServiceImpl$connect2RTCService$1$1$res$1(this.$startCallRequest, null);
        this.label = 1;
        r110 = r130.a(r131, this);
        if (r110 != r100) goto L13;
        return r100;
    }
}
