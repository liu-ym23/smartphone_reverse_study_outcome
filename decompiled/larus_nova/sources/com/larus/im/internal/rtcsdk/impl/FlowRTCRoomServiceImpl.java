package com.larus.im.internal.rtcsdk.impl;

import com.larus.im.internal.rtcsdk.MessageSendErrorCode;
import com.larus.im.internal.rtcsdk.MessageSendType;
import com.larus.im.internal.utils.TimerUtils;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.aigc.AIGCAdvance;
import com.ss.bytertc.engine.aigc.AIGCSessionConfig;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.RoomProfile;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowRTCRoomServiceImpl implements ff9.s {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f349828i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RTCRoom f349829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, ff9.i, Unit> f349830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f349831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowRTCRoomEventHandler f349832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f349833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f349834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f349835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ff9.n f349836h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.im.internal.rtcsdk.impl.FlowRTCRoomServiceImpl$leaveRoom$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.rtcsdk.impl.FlowRTCRoomServiceImpl$leaveRoom$1", f = "FlowRTCRoomServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowRTCRoomServiceImpl this$0;

        public AnonymousClass1(FlowRTCRoomServiceImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            final FlowRTCRoomServiceImpl r101 = this.this$0;
            Function0 r102 = new b0(r101);
            int r103 = FlowRTCRoomServiceImpl.f349828i;
            r101.m(r102);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // ff9.s
    public final void h() {
        int r100 = this.f349829a.publishStreamAudio(true);
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[publishAudioFrame] result:" + r100);
    }

    @Override // ff9.s
    public final void a() {
        m(new x(this));
    }

    @Override // ff9.s
    public final void e() {
        int r100 = this.f349829a.subscribeAllStreamsAudio(true);
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[subscribeAllStreamsAudio] result:" + r100);
    }

    @Override // ff9.s
    public final int i() {
        return ((Number) m(new y(this))).intValue();
    }

    @Override // ff9.s
    public final void leaveRoom() {
        fe9.h r100 = fe9.h.f476628a;
        StringBuilder r101 = new StringBuilder("[leaveRoom] roomId:");
        RTCRoom r102 = this.f349829a;
        if (r102 == null) goto L5;
        String r103 = r102.getRoomId();
    L6:
        r101.append(r103);
        r100.e("FlowRTCRoomServiceImpl", r101.toString());
        Lazy r104 = TimerUtils.f350521a;
        TimerUtils.a(new AnonymousClass1(this, null));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static JSONObject k(ff9.j r100) {
        if (r100.f476768f == false) goto L10;
        JSONObject r101 = new JSONObject();
        Map r102 = (Map) com.larus.im.internal.delegate.w.f348285u.getValue();
        if (r102 == null) goto L11;
        Iterator r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r103.next();
        r101.put((String) r104.getKey(), r104.getValue());
    L11:
        JSONObject r105 = new JSONObject();
        r105.put("ppe_lane", r100.f476766d);
        r105.put("is_client_pre_join", r100.f476765c);
        r105.put("extra_version", 1);
        r105.put("burst_mode", true);
        r105.put("is_new_conn", r100.f476767e);
        r105.put("fg_config", r101);
        return r105;
    L10:
        r101 = null;
        goto L11
    }

    @Override // ff9.s
    public final void d(boolean r100) {
        int r101 = this.f349829a.publishStreamVideo(r100);
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[publishVideoFrame] result:" + r101);
    }

    @Override // ff9.s
    public final cf9.d f(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        int r102 = cf9.b.f23547a;
        return cf9.b.a(MessageSendErrorCode.EMPTY_MESSAGE, MessageSendType.Control);
    L9:
        cf9.d r103 = new cf9.d(this.f349829a.sendControlBinaryMessage("rtcAgent", "update", r100), MessageSendType.Control);
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[sendControlMessage] " + r103 + '.');
        return r103;
    L5:
        r101 = false;
        goto L6
    }

    @Override // ff9.s
    public final void g(boolean r100) {
        this.f349829a.publishScreenVideo(r100);
    }

    public final int l(ff9.n r110) {
        ff9.j r100 = r110.f476774b;
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100.f476770h == false) goto L5;
        r101.put("audio_encode_stereo", Boolean.TRUE);
    L5:
        String r111 = com.flow.kmp.common.util.k.b(r101);
        fe9.a.f476620a.e("FlowRTCRoomServiceImpl", "[startSession] fgConfig:" + r111);
        RTCRoom r102 = this.f349829a;
        ff9.j r103 = r110.f476774b;
        String r104 = r103.f476764b;
        UserInfo r105 = new UserInfo(r103.f476763a, k(r103).toString());
        ff9.j r106 = r110.f476774b;
        ff9.k r107 = r110.f476775c;
        if (r107 == null) goto L8;
        int r108 = r107.f476772b;
    L9:
        RTCRoomConfig r109 = j(r106, r108);
        ff9.k r112 = r110.f476775c;
        if (r112 == null) goto L12;
        String r113 = r112.f476771a;
    L13:
        JSONObject r114 = com.flow.kmp.common.util.g.b(r113);
        ff9.k r115 = r110.f476775c;
        if (r115 == null) goto L16;
        int r116 = r115.f476772b;
    L18:
        return AIGCAdvance.startSession(r102, new AIGCSessionConfig(r104, r105, r109, "rtcAgent", "update", r114, r116, false, r111));
    L16:
        r116 = 120000;
        goto L18
    L12:
        r113 = null;
        goto L13
    L8:
        r108 = 72000;
        goto L9
    }

    public final <T> T m(Function0<? extends T> r100) {
        com.larus.im.internal.delegate.w.c r101 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r101 == null) goto L5;
        boolean r102 = r101.f348341m;
    L6:
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[withSyncAB] fixRtcJoinLeaveRoomSync: " + r102);
        if (r102 == false) goto L17;
        Object r103 = this.f349835g;
        monitor-enter(r103);
        T r104 = r100.invoke();     // Catch: Throwable -> L13
        monitor-exit(r103);
        return r104;
    L13:
        th = move-exception;
        throw th;
    L17:
        return r100.invoke();
    L5:
        r102 = true;
        goto L6
    }

    public static RTCRoomConfig j(ff9.j r100, int r110) {
        RoomProfile r101 = RoomProfile.CHAT_ROOM;
        boolean r102 = true;
        if (r100.f476768f == false) goto L10;
        com.larus.im.internal.delegate.w.c r103 = com.larus.im.internal.delegate.w.j().f348360e;
        if (r103 == null) goto L7;
        boolean r104 = r103.f348339k;
    L8:
        if (r104 == false) goto L10;
    L14:
        return new RTCRoomConfig(r101, r102, false, false, false, r100.f476769g, r110);
    L7:
        r104 = true;
    L10:
        if (r100.f476769g == true) goto L14;
        r102 = false;
        goto L14
    }

    @Override // ff9.s
    public final cf9.d b(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "receiverId");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r101.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        int r103 = cf9.b.f23547a;
        return cf9.b.a(MessageSendErrorCode.EMPTY_MESSAGE, MessageSendType.P2P);
    L10:
        if (StringsKt.isBlank(r100) == false) goto L13;
        int r104 = cf9.b.f23547a;
        return cf9.b.a(MessageSendErrorCode.CLIENT_NOT_READY, MessageSendType.P2P);
    L13:
        cf9.d r105 = new cf9.d(this.f349829a.sendUserBinaryMessage(r100, r101, MessageConfig.fromId(MessageConfig.RELIABLE_ORDERED.value())), MessageSendType.P2P);
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[sendMessage] " + r105 + '.');
        return r105;
    L5:
        r102 = false;
        goto L6
    }

    @Override // ff9.s
    public final void c(String r100, final ff9.n r101) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "config");
        fe9.h.f476628a.e("FlowRTCRoomServiceImpl", "[joinRoom] roomId:" + this.f349829a.getRoomId() + ", token:" + r101.f476774b.f476764b + ", connectionType:" + r101.f476773a + ", pseudo: " + r101.f476774b.f476769g);
        m(new a0(this, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.im.internal.rtcsdk.impl.z] */
    public FlowRTCRoomServiceImpl(RTCRoom r100, boolean r101, Function2<? super String, ? super ff9.i, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoom");
        Intrinsics.checkNotNullParameter(r102, "transfer");
        this.f349829a = r100;
        this.f349830b = r102;
        this.f349832d = new FlowRTCRoomEventHandler(r100, r101, r102);
        this.f349833e = new w(r100, r101, new z(this));
        this.f349834f = new AtomicBoolean(true);
        this.f349835g = new Object();
    }
}
