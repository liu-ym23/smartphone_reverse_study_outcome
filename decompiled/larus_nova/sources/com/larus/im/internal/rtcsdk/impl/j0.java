package com.larus.im.internal.rtcsdk.impl;

import com.bytedance.crash.dumper.Scraps;
import com.larus.im.internal.network.link.impl.rtc.abs.FlowRTCLinkSession;
import com.larus.im.internal.rtcsdk.MessageSendErrorCode;
import com.larus.im.internal.rtcsdk.MessageSendType;
import com.larus.im.internal.utils.TimerUtils;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.data.LinkIndex;
import com.ss.bytertc.engine.data.MultiLinkEnhancementMode;
import com.ss.bytertc.engine.data.MultiLinkEnhancementState;
import com.ss.bytertc.engine.data.MultiLinkStats;
import com.ss.bytertc.engine.data.RemoteAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.type.AudioDeviceType;
import com.ss.bytertc.engine.type.FirstFrameSendState;
import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;
import com.ss.bytertc.engine.type.PublicStreamErrorCode;
import com.ss.bytertc.engine.type.RtcUser;
import com.ss.bytertc.engine.type.VideoDeviceType;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class j0 implements ff9.u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicInteger f349903m = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f349905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f349906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d1 f349907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f349908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f349909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f349910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f349911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c1 f349912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReentrantLock f349913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArraySet<ff9.l>> f349914l;

    public static final class a {
    }

    public final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f349915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j0 f349916c;

        public b(final j0 r100) {
            this.f349916c = r100;
            this.f349915b = LazyKt.lazy(new s0(r100));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onError(final int r100) {
            super.onError(r100);
            Lazy r101 = com.larus.im.internal.delegate.w.f348265a;
            if (((List) com.larus.im.internal.delegate.w.f348279o.getValue()).contains(Integer.valueOf(r100)) == false) goto L6;
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onError] ignore err=" + r100 + '(' + ff9.m.a(r100) + ')');
            return;
        L6:
            fe9.h.f476628a.b(this.f349916c.f349905c, "[onError] err=" + r100 + '(' + ff9.m.a(r100) + ')');
            this.f349916c.l(new n0(r100));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onFirstRemoteAudioFrame(RemoteStreamKey r100) {
            super.onFirstRemoteAudioFrame(r100);
            fe9.h r101 = fe9.h.f476628a;
            String r102 = this.f349916c.f349905c;
            StringBuilder r103 = new StringBuilder("[onFirstRemoteAudioFrame] roomId=");
            String r104 = null;
            if (r100 == null) goto L5;
            String r105 = r100.roomId;
        L6:
            r103.append(r105);
            r103.append(", uid=");
            if (r100 == null) goto L9;
            String r106 = r100.userId;
        L10:
            r103.append(r106);
            r101.e(r102, r103.toString());
            j0 r107 = this.f349916c;
            if (r100 == null) goto L14;
            r104 = r100.roomId;
        L14:
            if (r100 == null) goto L17;
            String r108 = r100.userId;
            if (r108 == null) goto L17;
        L18:
            j0.j(r107, r104, new ff9.i.e(r108));
            return;
        L17:
            r108 = "";
            goto L18
        L9:
            r106 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onMultiLinkEnhancementStats(MultiLinkStats[] r110) {
            super.onMultiLinkEnhancementStats(r110);
            fe9.a r100 = fe9.a.f476620a;
            String r101 = this.f349916c.f349905c;
            StringBuilder r102 = new StringBuilder("call onMultiLinkStats ");
            if (r110 == null) goto L5;
            Integer r103 = Integer.valueOf(r110.length);
        L6:
            r102.append(r103);
            r100.b(r101, r102.toString());
            if (r110 != null) goto L9;
        L32:
            r100.b(this.f349916c.f349905c, "stats is null");
            return;
        L9:
            if (r110.length != 0) goto L11;
            boolean r104 = true;
        L12:
            if (r104 == true) goto L32;
            final Ref.IntRef r105 = new Ref.IntRef();
            final Ref.IntRef r106 = new Ref.IntRef();
            final Ref.IntRef r107 = new Ref.IntRef();
            final Ref.IntRef r108 = new Ref.IntRef();
            final Ref.IntRef r109 = new Ref.IntRef();
            final Ref.IntRef r111 = new Ref.IntRef();
            Iterator r112 = ArrayIteratorKt.iterator(r110);
        L16:
            if (r112.hasNext() == false) goto L30;
            MultiLinkStats r113 = (MultiLinkStats) r112.next();
            if (r113 == null) goto L20;
            LinkIndex r114 = r113.linkIndex;
        L22:
            if (r114 == LinkIndex.LINK_INDEX_MAIN) goto L23;
            if (r113 == null) goto L26;
            LinkIndex r115 = r113.linkIndex;
        L28:
            if (r115 != LinkIndex.LINK_INDEX_STANDBY) goto L16;
            r108.element = r113.rttMin;
            r109.element = r113.rttMax;
            r111.element = r113.rttAvg;
            goto L16
        L26:
            r115 = null;
            goto L28
        L23:
            r105.element = r113.rttMin;
            r106.element = r113.rttMax;
            r107.element = r113.rttAvg;
            goto L16
        L20:
            r114 = null;
            goto L22
        L30:
            this.f349916c.l(new l0(r105, r106, r107, r108, r109, r111));
            return;
        L11:
            r104 = false;
            goto L12
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onNetworkTypeChanged(final int r100) {
            super.onNetworkTypeChanged(r100);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onNetworkTypeChanged] type=" + r100);
            this.f349916c.l(new t0(r100));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onServerParamsSetResult(int r100) {
            super.onServerParamsSetResult(r100);
            fe9.h r101 = fe9.h.f476628a;
            r101.e(this.f349916c.f349905c, "[onServerParamsSetResult] error:" + r100);
            if (r100 != 200) goto L5;
            boolean r102 = true;
        L6:
            final ff9.i.C5894i r103 = new ff9.i.C5894i(r102, r100);
            if (r102 == false) goto L9;
            this.f349916c.getClass();
        L9:
            this.f349916c.l(new o0(r103));
            r101.e(this.f349916c.f349905c, "[onServerParamsSetResult] error:" + r100);
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onConnectionStateChanged(int r100, int r101) {
            super.onConnectionStateChanged(r100, r101);
            fe9.h r102 = fe9.h.f476628a;
            r102.e(this.f349916c.f349905c, "[onConnectionStateChanged] state=" + r100 + ", reason=" + r101);
            final cf9.g r103 = (cf9.g) this.f349915b.getValue();
            final ff9.i.b r104 = new ff9.i.b(r100, r101);
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "event");
            if (r100 == 6) goto L39;
            r102.e("RTCConnectionDispatcher", "[dispatch] " + r104);
            if (r100 != 1) goto L17;
            if (r103.f23555b.get() != null) goto L38;
            Lazy r105 = TimerUtils.f350521a;
            long r106 = sf9.a.b((ouc.d0) com.larus.im.internal.delegate.w.f348282r.getValue(), "reconnect_timeout", 60);
            TimeUnit r107 = TimeUnit.SECONDS;
            Runnable r108 = new cf9.f(r104, r103);
            Intrinsics.checkNotNullParameter(r107, Scraps.INNER_UNIT);
            Intrinsics.checkNotNullParameter(r108, "task");
            ScheduledFuture<?> r109 = ((ScheduledExecutorService) TimerUtils.f350521a.getValue()).schedule(r108, r106, r107);
            AtomicReference<Future<?>> r110 = r103.f23555b;
        L11:
            if (r110.compareAndSet(null, r109) == true) goto L40;
            if (r110.get() == null) goto L11;
            return;
        L40:
            return;
        L38:
            return;
        L17:
            if (r100 != 3) goto L19;
        L22:
            Future<?> r111 = r103.f23555b.get();
            if (r111 == null) goto L30;
            r111.cancel(true);
            AtomicReference<Future<?>> r112 = r103.f23555b;
        L26:
            if (r112.compareAndSet(r111, null) == true) goto L30;
            if (r112.get() == r111) goto L26;
        L30:
            r103.f23554a.invoke(r104);
            return;
        L19:
            if (r100 == 5) goto L22;
            if (r100 != 7) goto L30;
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onFirstLocalVideoFrameCaptured(StreamIndex r100, final VideoFrameInfo r101) {
            super.onFirstLocalVideoFrameCaptured(r100, r101);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onFirstLocalVideoFrameCaptured] streamIndex = " + r100 + ", frameInfo = " + r101);
            this.f349916c.l(new z0(r101));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onMultiLinkEnhancementStateChanged(final MultiLinkEnhancementState r100, final MultiLinkEnhancementMode r101) {
            Intrinsics.checkNotNullParameter(r100, "state");
            Intrinsics.checkNotNullParameter(r101, "mode");
            super.onMultiLinkEnhancementStateChanged(r100, r101);
            fe9.a.f476620a.b(this.f349916c.f349905c, "call onMultiLinkStatusChanged state: " + r100 + " mode: " + r101);
            this.f349916c.l(new m0(r100, r101));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] r100, int r101) {
            super.onRemoteAudioPropertiesReport(r100, r101);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onUserStartAudioCapture(String r100, String r101) {
            super.onUserStartAudioCapture(r100, r101);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onUserStartAudioCapture] roomId=" + r100);
            j0 r102 = this.f349916c;
            if (r100 != null) goto L5;
            String r103 = "";
        L6:
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            j0.j(r102, r100, new ff9.i.z(r103, r101));
            return;
        L5:
            r103 = r100;
            goto L6
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onUserStartVideoCapture(String r100, String r101) {
            super.onUserStartVideoCapture(r100, r101);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onUserStartVideoCapture] roomId=" + r100);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onUserStopAudioCapture(String r100, String r101) {
            super.onUserStopAudioCapture(r100, r101);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onUserStopAudioCapture] roomId=" + r100);
            j0 r102 = this.f349916c;
            if (r100 != null) goto L5;
            String r103 = "";
        L6:
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            j0.j(r102, r100, new ff9.i.a0(r103, r101));
            return;
        L5:
            r103 = r100;
            goto L6
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onUserStopVideoCapture(String r100, String r101) {
            super.onUserStopVideoCapture(r100, r101);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onUserStopVideoCapture] roomId=" + r100);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onLoginResult(String r100, final int r101, int r102) {
            super.onLoginResult(r100, r101, r102);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onLoginResult] error:" + r101);
            if (r101 == 0) goto L6;
            this.f349916c.l(new k0(r101));
            return;
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onPushPublicStreamResult(String r100, String r101, PublicStreamErrorCode r102) {
            super.onPushPublicStreamResult(r100, r101, r102);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onPushPublicStreamResult] roomId = " + r100 + ", publicStreamId = " + r101 + ", error = " + r102);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onServerMessageSendResult(final long r100, final int r101, ByteBuffer r102) {
            super.onServerMessageSendResult(r100, r101, r102);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onServerMessageSendResult] msgid=" + r100 + ", error:" + r101);
            this.f349916c.l(new a1(r100, r101));
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onVideoFrameSendStateChanged(String r100, RtcUser r101, FirstFrameSendState r102) {
            super.onVideoFrameSendStateChanged(r100, r101, r102);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onVideoFrameSendStateChanged] roomId = " + r100 + ", user = " + r101 + ", state = " + r102);
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onAudioDeviceStateChanged(String r100, final AudioDeviceType r101, final int r102, final int r103) {
            super.onAudioDeviceStateChanged(r100, r101, r102, r103);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onAudioDeviceStateChanged] deviceID = " + r100 + ", deviceType = " + r101 + ", deviceState = " + r102 + ", deviceError = " + r103);
            if (r103 == 0) goto L6;
            this.f349916c.l(new u0(r101, r102, r103));
            return;
        }

        @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
        public final void onVideoDeviceStateChanged(String r100, final VideoDeviceType r101, final int r102, final int r103) {
            super.onVideoDeviceStateChanged(r100, r101, r102, r103);
            fe9.h.f476628a.e(this.f349916c.f349905c, "[onVideoDeviceStateChanged] deviceID = " + r100 + ", deviceType = " + r101 + ", deviceState = " + r102 + ", deviceError = " + r103);
            if (r101 != VideoDeviceType.VIDEO_DEVICE_TYPE_CAPTURE_DEVICE) goto L10;
            if (r102 == 1) goto L8;
            if (r102 != 2) goto L10;
            this.f349916c.l(new w0(r102, r103));
            goto L10
        L8:
            this.f349916c.l(new v0());
        L10:
            if (r101 != VideoDeviceType.VIDEO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE) goto L18;
            if (r102 == 1) goto L17;
            if (r102 != 2) goto L14;
        L16:
            this.f349916c.l(new y0(r102, r103));
            goto L18
        L14:
            if (r102 == 3) goto L16;
        L17:
            this.f349916c.l(new x0());
        L18:
            if (r103 == 0) goto L21;
            this.f349916c.l(new q0(r101, r102, r103));
            return;
        }
    }

    static {
        f349903m = new AtomicInteger();
    }

    @Override // ff9.u
    public final ff9.t a() {
        return (ff9.t) this.f349911i.getValue();
    }

    @Override // ff9.u
    public final void c() {
        this.f349909g.set(true);
        s r100 = (s) this.f349908f.getValue();
        df9.f r101 = r100.f349987d;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        r100.f349987d = null;
        df9.a r102 = r100.f349988e;
        if (r102 == null) goto L8;
        r102.a();
    L8:
        r100.f349988e = null;
        v r103 = v.f350031a;
        c1 r104 = this.f349912j;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        v.f350035e.remove(r104);
        v.k((i) this.f349906d.getValue());
        String r105 = UUID.randomUUID().toString();
        Object r106 = v.f350032b;
        monitor-enter(r106);
        fe9.h.f476628a.e("FlowRTCEngineManager", "[resetForRetry] start, trace: " + r105);     // Catch: Throwable -> L13
        v.j("connect_retry");     // Catch: Throwable -> L13
        v.f350037g = null;     // Catch: Throwable -> L13
        v.f350039i = null;     // Catch: Throwable -> L13
        v.c(r105);     // Catch: Throwable -> L13
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r106);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // ff9.u
    public final void destroy() {
        v r100 = v.f350031a;
        c1 r101 = this.f349912j;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        v.f350035e.remove(r101);
        v.k((i) this.f349906d.getValue());
        if (com.larus.im.internal.delegate.w.f() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L18;
        String r103 = UUID.randomUUID().toString();
        fe9.h r104 = fe9.h.f476628a;
        StringBuilder r105 = new StringBuilder("[destroy] appId:");
        cf9.a r106 = r100.d();
        if (r106 == null) goto L11;
        String r107 = r106.f23542a;
    L12:
        r105.append(r107);
        r105.append(", trace: ");
        r105.append(r103);
        r105.append(", isPendingDestroyEngine:");
        AtomicBoolean r108 = v.f350033c;
        r105.append(r108.get());
        r104.e("FlowRTCEngineManager", r105.toString());
        if (r108.compareAndSet(false, true) == false) goto L15;
        Lazy r109 = TimerUtils.f350521a;
        v.f350037g = TuplesKt.to(TimerUtils.a(new FlowRTCEngineManager$destroyEngine$1(r103, null)), r103);
        return;
    L15:
        r104.e("FlowRTCEngineManager", "[destroy] already pending, trace: " + r103);
        return;
    L11:
        r107 = null;
        goto L12
    L18:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // ff9.u
    public final ff9.v e() {
        return (ff9.v) this.f349910h.getValue();
    }

    @Override // ff9.u
    public final s v() {
        return (s) this.f349908f.getValue();
    }

    public j0(String r100) {
        this.f349904b = r100;
        this.f349905c = "FlowRTCServiceImpl_" + f349903m.incrementAndGet() + '_' + hashCode();
        this.f349906d = LazyKt.lazy(new d0(this));
        this.f349907e = new d1(this);
        this.f349908f = LazyKt.lazy(new e0(this));
        this.f349909g = new AtomicBoolean(false);
        this.f349910h = LazyKt.lazy(new f0(this));
        this.f349911i = LazyKt.lazy(new g0(this));
        this.f349912j = new c1(this);
        this.f349913k = new ReentrantLock();
        this.f349914l = new ConcurrentHashMap();
    }

    @Override // ff9.u
    public final void B(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        RTCEngine r101 = this.f349907e.a(true);
        if (r101 != null) goto L6;
        fe9.h.f476628a.b(this.f349905c, "[setRuntimeParameters] engine is null");
        return;
    L6:
        int r102 = r101.setRuntimeParameters(r100);
        if (r102 == 0) goto L9;
        fe9.h.f476628a.b(this.f349905c, "[setRuntimeParameters] setRuntimeParameters failed, result: " + r102);
        return;
    L9:
        fe9.h.f476628a.e(this.f349905c, "[setRuntimeParameters] params=" + r100);
    }

    @Override // ff9.u
    public final void d(cf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        v r101 = v.f350031a;
        c1 r102 = this.f349912j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        v.f350035e.add(r102);
        i r103 = (i) this.f349906d.getValue();
        Intrinsics.checkNotNullParameter(r103, "eventHandler");
        Intrinsics.checkNotNullParameter(r100, "config");
        v.f();
        Object r104 = v.f350032b;
        monitor-enter(r104);
        v.j("create_engine");     // Catch: Throwable -> L27
        RTCEngine r105 = v.f350041k;     // Catch: Throwable -> L27
        if (r103.f349898a == true) goto L7;
        fe9.a.f476620a.f("FlowRTCEngineManager", "create engine, eventHandler is not active");     // Catch: Throwable -> L27
    L7:
        r103.f349898a = true;     // Catch: Throwable -> L27
        r1 r106 = v.f350044n;     // Catch: Throwable -> L27
        r106.a(r103);     // Catch: Throwable -> L27
        if (r105 != null) goto L11;
        v.f350039i = r100;     // Catch: Throwable -> L27
        v.b(r100.f23542a, r106);     // Catch: Throwable -> L27
    L14:
        monitor-exit(r104);
        if (this.f349909g.compareAndSet(true, false) == false) goto L31;
        s r107 = (s) this.f349908f.getValue();
        ff9.c r108 = r107.f349989f;
        if (r108 == null) goto L20;
        r107.k(r108);
    L20:
        ff9.b r109 = r107.f349990g;
        if (r109 == null) goto L24;
        r107.j(r109);
    L24:
        if (r107.f349991h == false) goto L32;
        r107.K();
        return;
    L32:
        return;
    L31:
        return;
    L11:
        if (Intrinsics.areEqual(r100, r101.d()) == true) goto L13;
        r105.setBusinessId(r100.f23543b);     // Catch: Throwable -> L27
    L13:
        v.f350039i = r100;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    @Override // ff9.u
    @Deprecated(message = "sendServerMessage is not support")
    public final cf9.d f(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L7;
        int r101 = cf9.b.f23547a;
        return cf9.b.a(MessageSendErrorCode.CONNECTION_NOT_READY, MessageSendType.Engine);
    L7:
        throw new IllegalArgumentException("sendServerMessage is not support");
    }

    @Override // ff9.u
    public final void h(MediaTypeEnhancementConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        RTCEngine r101 = this.f349907e.a(true);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.setCellularEnhancement(r100));
    L6:
        fe9.a.f476620a.e(this.f349905c, " SmartNetwork multiPath config, ret = " + r102 + ", MediaTypeEnhancementConfig = {" + r100.enhanceSignaling + ", " + r100.enhanceAudio + ", " + r100.enhanceVideo + ", " + r100.enhanceScreenAudio + ", " + r100.enhanceScreenVideo + ", " + r100.adaptiveEnhance + '}');
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ff9.u
    public final FlowRTCRoomServiceImpl i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        fe9.h r101 = fe9.h.f476628a;
        r101.e(this.f349905c, "[createRoom] roomId:".concat(r100));
        com.larus.im.internal.delegate.w.c r102 = com.larus.im.internal.delegate.w.j().f348360e;
        boolean r103 = false;
        if (r102 == null) goto L5;
        boolean r104 = r102.f348340l;
    L7:
        if (r104 == false) goto L10;
    L22:
        r103 = true;
    L23:
        RTCEngine r105 = this.f349907e.a(true);
        FlowRTCRoomServiceImpl r106 = null;
        if (r105 == null) goto L31;
        RTCRoom r107 = r105.createRTCRoom(r100);
        if (r107 == null) goto L28;
        r106 = new FlowRTCRoomServiceImpl(r107, r103, new FlowRTCServiceImpl$createRoom$service$1$1(this));
    L28:
        JSONObject r108 = new JSONObject();
        r108.put("rtc.aigc_callback_with_code", !r103);
        int r109 = r105.setRuntimeParameters(r108);
        if (r109 == 0) goto L31;
        r101.b(this.f349905c, "[createRoom] setRuntimeParameters failed, result: " + r109);
    L31:
        return r106;
    L10:
        if (com.larus.im.internal.delegate.w.c() == true) goto L23;
        Map r110 = com.larus.im.internal.delegate.w.d();
        if (r110 == null) goto L23;
        if (r110.containsKey("disable_rtc_aigc_callback_with_code") == false) goto L23;
        com.larus.im.internal.delegate.a0.a().e("FlowAudioSettingsDelegate", "return realtime disableRtcAigcCallbackWithCode: " + ((String) r110.get("disable_rtc_aigc_callback_with_code")));
        String r111 = (String) r110.get("disable_rtc_aigc_callback_with_code");
        if (r111 == null) goto L20;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L20;
        int r113 = r112.intValue();
    L21:
        if (r113 != 1) goto L23;
    L20:
        r113 = 1;
        goto L21
    L5:
        r104 = false;
        goto L7
    }

    public final CopyOnWriteArraySet<ff9.l> k(String r100) {
        ReentrantLock r101 = this.f349913k;
        r101.lock();
        ConcurrentHashMap<String, CopyOnWriteArraySet<ff9.l>> r102 = this.f349914l;     // Catch: Throwable -> L16
        if (r100 != null) goto L7;
        String r103 = "";
    L8:
        CopyOnWriteArraySet<ff9.l> r104 = r102.get(r103);     // Catch: Throwable -> L16
        if (r104 != null) goto L14;
        r104 = new CopyOnWriteArraySet();     // Catch: Throwable -> L16
        ConcurrentHashMap<String, CopyOnWriteArraySet<ff9.l>> r105 = this.f349914l;     // Catch: Throwable -> L16
        if (r100 != null) goto L13;
        r100 = "";
    L13:
        r105.put(r100, r104);     // Catch: Throwable -> L16
    L14:
        r101.unlock();
        return r104;
    L7:
        r103 = r100;
    L16:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void l(Function0<? extends ff9.i> r100) {
        ff9.i r101 = r100.invoke();
        LinkedHashSet r102 = new LinkedHashSet();
        ReentrantLock r103 = this.f349913k;
        r103.lock();
    L25:
        th = move-exception;
        r103.unlock();
        throw th;
    L4:
        if (this.f349914l.isEmpty() == false) goto L6;
        fe9.a.f476620a.b(this.f349905c, "notify: listeners is empty, event: " + r101);     // Catch: Throwable -> L25
    L6:
        Iterator<Map.Entry<String, CopyOnWriteArraySet<ff9.l>>> r104 = this.f349914l.entrySet().iterator();     // Catch: Throwable -> L25
    L8:
        if (r104.hasNext() == false) goto L15;
        CopyOnWriteArraySet<ff9.l> r105 = r104.next().getValue();     // Catch: Throwable -> L25
        if (r105 == null) goto L8;
        if (r105.isEmpty() == true) goto L8;
        r102.addAll(r105);     // Catch: Throwable -> L25
        goto L8
    L15:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r103.unlock();
        if (r102.isEmpty() == false) goto L20;
        fe9.a.f476620a.b(this.f349905c, "notify: observers is empty, event: " + r101);
        return;
    L20:
        Iterator r107 = r102.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        ((ff9.l) r107.next()).onEvent(r101);
        goto L22
    }

    @Override // ff9.u
    public final void b(String r100, FlowRTCLinkSession.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        fe9.h r102 = fe9.h.f476628a;
        r102.e(this.f349905c, "[addListener] listeners size:" + this.f349914l.size() + ", listener:" + r101.hashCode());
        ReentrantLock r103 = this.f349913k;
        r103.lock();
        CopyOnWriteArraySet<ff9.l> r104 = k(r100);     // Catch: Throwable -> L6
        r104.add(r101);     // Catch: Throwable -> L6
        r102.e(this.f349905c, "[addListener] listeners size:" + r104.size() + ", listener:" + r104.hashCode() + ", roomId:" + r100);     // Catch: Throwable -> L6
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r103.unlock();
        return;
    L6:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    @Override // ff9.u
    public final void g(String r100, FlowRTCLinkSession.b r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        fe9.h r102 = fe9.h.f476628a;
        r102.e(this.f349905c, "[removeListener] listeners size:" + this.f349914l.size() + ", listener:" + r101.hashCode());
        ReentrantLock r103 = this.f349913k;
        r103.lock();
        CopyOnWriteArraySet<ff9.l> r104 = k(r100);     // Catch: Throwable -> L6
        r104.remove(r101);     // Catch: Throwable -> L6
        r102.e(this.f349905c, "[removeListener] listeners size:" + r104.size() + ", listener:" + r104.hashCode());     // Catch: Throwable -> L6
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r103.unlock();
        return;
    L6:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    public static final void j(j0 r100, String r101, ff9.i r102) {
        if (r100.f349914l.isEmpty() == false) goto L5;
        fe9.a.f476620a.b(r100.f349905c, "notify: listeners is empty, event: " + r102);
    L5:
        Iterator<ff9.l> r103 = r100.k(r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().onEvent(r102);
        goto L7
    }
}
