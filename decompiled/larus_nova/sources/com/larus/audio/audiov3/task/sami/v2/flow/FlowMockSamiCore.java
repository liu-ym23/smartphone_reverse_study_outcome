package com.larus.audio.audiov3.task.sami.v2.flow;

import com.larus.audio.audiov3.config.NetworkStatus;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import m58.k;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowMockSamiCore extends com.larus.audio.audiov3.task.sami.v2.flow.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile MockEventType f288568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f288569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f288570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f288571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f288572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f288573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CoroutineScope f288574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f288575j;

    /* JADX INFO: renamed from: com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore$SAMICoreSetProperty$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore$SAMICoreSetProperty$2", f = "FlowMockSamiCore.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowMockSamiCore this$0;

        public AnonymousClass2(FlowMockSamiCore r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FlowMockSamiCore r103 = this.this$0;
            this.label = 1;
            if (FlowMockSamiCore.j(r103, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f288576a = null;

        static {
            int[] r100 = new int[MockEventType.values().length];
            r100[MockEventType.TASK_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[MockEventType.SESSION_CANCELED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[MockEventType.SESSION_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[MockEventType.WEB_SOCKET_CHANGE_FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[MockEventType.WEB_SOCKET_CONNECTION_FAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[MockEventType.NONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f288576a = r100;
        }
    }

    static {
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreCreateHandleByIdentify(SAMICoreIdentify r100, Object r101) {
        return 0;
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreGetPropertyById(SAMICorePropertyId r100, SAMICoreProperty r101) {
        return 0;
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreProcess(SAMICoreBlock r100, SAMICoreBlock r101) {
        return 0;
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreProcessAsync(SAMICoreBlock r100) {
        return 0;
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final void setEnableSyncInterface(boolean r100) {
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final void setHostCallBackListener(SAMICoreHostCallBackListener r100) {
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreDestroyHandle() {
        this.f288573h = 0;
        Job r100 = this.f288575j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f288575j = null;
        return 0;
    }

    public FlowMockSamiCore() {
        this.f288568c = MockEventType.NONE;
        this.f288569d = 1000;
        this.f288570e = -1;
        this.f288571f = "mock error";
        this.f288572g = "mock error message";
        this.f288573h = 1;
        this.f288574i = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final long getHandle() {
        return this.f288573h;
    }

    public final void k(SAMICoreCallBackEventType r100) {
        SAMICoreServerEvent r101 = new SAMICoreServerEvent();
        r101.statusCode = this.f288570e;
        r101.statusText = this.f288571f;
        r101.textMsg = this.f288572g;
        SAMICoreBlock r102 = new SAMICoreBlock();
        r102.dataType = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r102.numberAudioData = 1;
        r102.audioData = new SAMICoreServerEvent[]{r101};
        Iterator<T> r103 = this.f288579b.f288580a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((SAMICoreCallBackListener) r103.next()).onMessageReceived(r100, r102);
        goto L4
    }

    public final void l(int r100) {
        SAMICoreWebSocketConnectionEvent r101 = new SAMICoreWebSocketConnectionEvent();
        r101.state = r100;
        r101.textMsg = this.f288572g;
        SAMICoreBlock r102 = new SAMICoreBlock();
        r102.dataType = SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event;
        r102.numberAudioData = 1;
        r102.audioData = new SAMICoreWebSocketConnectionEvent[]{r101};
        Iterator<T> r103 = this.f288579b.f288580a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((SAMICoreCallBackListener) r103.next()).onMessageReceived(SAMICoreCallBackEventType.WebSocketStateChanged, r102);
        goto L4
    }

    public static final Object j(FlowMockSamiCore r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FlowMockSamiCore$scheduleMockEvent$1) == false) goto L7;
        FlowMockSamiCore$scheduleMockEvent$1 r102 = (FlowMockSamiCore$scheduleMockEvent$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L24:
        if (r100.f288573h == 0) goto L38;
        MockEventType r107 = r100.f288568c;
        k r108 = c68.a.a("[fireMockEvent]");
        if (r108 == null) goto L29;
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("mock_event_type", String.valueOf(r100.f288568c.getType()));
        r109.put("mock_delay_ms", String.valueOf(r100.f288569d));
        com.larus.audio.utils.b r110 = (com.larus.audio.utils.b) r108;
        r110.c(r109);
        r110.d("FlowMockSamiCore.fireMockEvent");
        k.a.a(r110);
    L29:
        switch(b.f288576a[r107.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L38;
            default: goto L31;
        };
    L32:
        r100.l(NetworkStatus.WEB_SOCKET_CONNECTION_FAIL.getCode());
        goto L38
    L33:
        r100.l(NetworkStatus.WEB_SOCKET_CHANGE_FAIL.getCode());
        goto L38
    L34:
        r100.k(SAMICoreCallBackEventType.SessionFailed);
        goto L38
    L35:
        r100.k(SAMICoreCallBackEventType.SessionCanceled);
        goto L38
    L36:
        r100.k(SAMICoreCallBackEventType.TaskFailed);
        goto L38
    L31:
        throw new NoWhenBranchMatchedException();
    L38:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100.f288568c == MockEventType.NONE) goto L39;
        k r111 = c68.a.a("scheduleMockEvent");
        if (r111 == null) goto L20;
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("mock_event_type", String.valueOf(r100.f288568c.getType()));
        r112.put("mock_delay_ms", String.valueOf(r100.f288569d));
        com.larus.audio.utils.b r113 = (com.larus.audio.utils.b) r111;
        r113.c(r112);
        r113.d("FlowMockSamiCore.scheduleMockEvent");
        k.a.a(r113);
    L20:
        long r114 = r100.f288569d;
        r102.label = 1;
        if (DelayKt.delay(r114, r102) != r105) goto L24;
        return r105;
    L39:
        return Unit.INSTANCE;
    L7:
        r102 = new FlowMockSamiCore$scheduleMockEvent$1(r100, r101);
        goto L8
    }

    @Override // com.mammon.audiosdk.SAMICore
    public final int SAMICoreSetProperty(SAMICorePropertyId r100, SAMICoreProperty r101) {
        if (r100 == SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant) goto L5;
        return 0;
    L5:
        if (r101 == null) goto L7;
        SAMICorePropertyId r102 = r101.f384359id;
    L9:
        if (r102 != SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session) goto L20;
        Job r103 = this.f288575j;
        if (r103 == null) goto L13;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L13:
        this.f288575j = null;
        k r104 = c68.a.a("on startSession event");
        if (r104 == null) goto L16;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("mock_event_type", String.valueOf(this.f288568c.getType()));
        r105.put("mock_delay_ms", String.valueOf(this.f288569d));
        com.larus.audio.utils.b r106 = (com.larus.audio.utils.b) r104;
        r106.c(r105);
        r106.d("FlowMockSamiCore.MockSAMICoreSetProperty");
        k.a.a(r106);
    L16:
        this.f288575j = BuildersKt.launch$default(this.f288574i, null, null, new AnonymousClass2(this, null), 3, null);
        return 0;
    L20:
        return 0;
    L7:
        r102 = null;
        goto L9
    }
}
