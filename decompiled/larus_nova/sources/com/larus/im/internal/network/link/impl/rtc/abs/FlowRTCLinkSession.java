package com.larus.im.internal.network.link.impl.rtc.abs;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import android.widget.Toast;
import androidx.collection.SieveCacheKt;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.im.internal.audio.proto.RTCToken;
import com.larus.im.internal.audio.r;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.w;
import com.larus.im.internal.network.link.impl.rtc.RTCConnectRetryAction;
import com.larus.im.internal.network.link.impl.rtc.RTCConnectRetryReason;
import com.larus.im.internal.network.link.impl.rtc.RTCConnectionType;
import com.larus.im.internal.rtcsdk.MessageSendErrorCode;
import com.larus.im.internal.rtcsdk.MessageSendType;
import com.larus.im.internal.rtcsdk.impl.p1;
import com.larus.im.internal.rtcsdk.impl.v;
import com.larus.im.internal.rtcsdk.service.AudioEncodeType;
import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.t;
import com.ss.bytertc.engine.data.AudioRenderType;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.data.MultiLinkEnhancementState;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.tencent.open.SocialConstants;
import ff9.q;
import ff9.s;
import ff9.u;
import ff9.x;
import ff9.y;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import ouc.d0;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowRTCLinkSession implements ue9.i, ff9.o, ue9.h {
    public static final AtomicLong K = null;
    public volatile boolean A;
    public byte[] B;
    public boolean C;
    public volatile AtomicBoolean D;
    public Job E;
    public volatile ue9.b F;
    public final CopyOnWriteArraySet<ue9.d> G;
    public final CopyOnWriteArraySet<ue9.a> H;
    public final e I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ReentrantLock f349236J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.im.internal.network.link.impl.rtc.p f349237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f349239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f349240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.im.internal.network.link.impl.rtc.e f349241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f349242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f349243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f349244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile com.larus.im.internal.network.link.impl.rtc.g f349245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Job f349246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Job f349247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Job f349248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f349249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile com.larus.im.internal.network.link.impl.rtc.h f349250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile com.larus.im.internal.network.link.impl.rtc.h f349251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile f f349252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f349253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f349254r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f349255s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile com.larus.im.internal.network.link.impl.rtc.abs.b f349256t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f349257u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f349258v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile s f349259w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f349260x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.larus.im.internal.network.link.impl.rtc.o f349261y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap<cf9.d, Object> f349262z;

    public static final class a {
    }

    public final class b extends ff9.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowRTCLinkSession f349263a;

        public b(FlowRTCLinkSession r100) {
            this.f349263a = r100;
        }

        @Override // ff9.l
        public void onEvent(ff9.i r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            fe9.a r100 = fe9.a.f476620a;
            r100.e("FlowRTCLinkSession", "[onEvent] event:" + r110);
            this.f349263a.f349261y.d(r110);
            if (Intrinsics.areEqual(r110, ff9.i.j.f476723a) == false) goto L5;
            ue9.b.c r111 = new ue9.b.c(ue9.c.i.f549853c, null, null, 6);
            this.f349263a.X(AVCommonError.Disconnected);
            this.f349263a.m(r111.f549839a);
            this.f349263a.J(r111);
            return;
        L5:
            boolean r101 = true;
            if (Intrinsics.areEqual(r110, ff9.i.s.f476747a) == false) goto L13;
            FlowRTCLinkSession r112 = this.f349263a;
            r112.getClass();
            r100.e("FlowRTCLinkSession", "[handleSelfVideoCaptureStarted]");
            if ((r112.F instanceof ue9.b.a) == true) goto L10;
            r100.e("FlowRTCLinkSession", "[handleSelfVideoCaptureStarted] not connected, wait for connected.");
            r112.f349256t = new com.larus.im.internal.network.link.impl.rtc.abs.b(r112);
            return;
        L10:
            s r113 = r112.f349259w;
            if (r113 == null) goto L211;
            r113.d(true);
            return;
        L211:
            return;
        L13:
            int r102 = 0;
            if ((r110 instanceof ff9.i.t) == false) goto L20;
            FlowRTCLinkSession r103 = this.f349263a;
            ff9.i.t r114 = (ff9.i.t) r110;
            r103.getClass();
            r100.e("FlowRTCLinkSession", "[handleSelfVideoCaptureStopped]");
            JSONObject r104 = new JSONObject();
            r104.put("device_state", r114.f476748a);
            r104.put("device_error", r114.f476749b);
            s r115 = r103.f349259w;
            if (r115 == null) goto L18;
            r115.d(false);
        L18:
            r103.L("OTHER_EVENT_RTC_VIDEO_STOPPED", r104.toString());
            return;
        L20:
            if ((r110 instanceof ff9.i.y) == false) goto L23;
            FlowRTCLinkSession.q(this.f349263a, ((ff9.i.y) r110).f476760a);
            return;
        L23:
            if ((r110 instanceof ff9.i.v) == false) goto L33;
            ff9.i.v r116 = (ff9.i.v) r110;
            if (r116.f476752a == false) goto L215;
            FlowRTCLinkSession.r(this.f349263a);
            ByteBuffer r117 = r116.f476753b;
            if (this.f349263a.D.compareAndSet(true, false) == false) goto L29;
            r100.e("FlowRTCLinkSession", "connect success, pseudo period end");
        L30:
            if (r117 == null) goto L216;
            FlowRTCLinkSession.q(this.f349263a, r117);
            return;
        L216:
            return;
        L29:
            r100.f("FlowRTCLinkSession", "connect success, pseudo period not start");
            goto L30
        L215:
            return;
        L33:
            if ((r110 instanceof ff9.i.u) == false) goto L43;
            ff9.i.u r118 = (ff9.i.u) r110;
            Object r105 = this.f349263a.f349262z.remove(r118.f476750a);
            if (r105 != null) goto L37;
            return;
        L37:
            if (Intrinsics.areEqual(r105, this.f349263a) == false) goto L219;
            Iterator<ue9.d> r106 = this.f349263a.G.iterator();
        L40:
            if (r106.hasNext() == false) goto L242;
            r106.next().c(r118);
            goto L40
        L242:
            return;
        L219:
            return;
        L43:
            if ((r110 instanceof ff9.i.z) == false) goto L45;
            return;
        L45:
            if ((r110 instanceof ff9.i.a0) == false) goto L47;
            return;
        L47:
            if ((r110 instanceof ff9.i.e) == false) goto L49;
            return;
        L49:
            if ((r110 instanceof ff9.i.f) == false) goto L71;
            FlowRTCLinkSession r107 = this.f349263a;
            Integer r119 = Integer.valueOf(((ff9.i.f) r110).f476714a);
            r107.getClass();
            if (r119 != null) goto L54;
        L55:
            if (r119 != null) goto L58;
        L59:
            if (r119 != null) goto L62;
        L64:
            RTCConnectRetryReason r120 = RTCConnectRetryReason.START_SESSION_FAILED;
        L67:
            if (r107.W(r120) == false) goto L69;
            return;
        L69:
            ue9.b.c r121 = new ue9.b.c(ue9.c.g.f549851c, null, null, 6);
            this.f349263a.X(AVCommonError.Disconnected);
            this.f349263a.m(r121.f549839a);
            this.f349263a.J(r121);
            return;
        L62:
            if (r119.intValue() != (-1010)) goto L64;
        L65:
            r120 = RTCConnectRetryReason.INVALID_TOKEN;
            goto L67
        L58:
            if (r119.intValue() == (-1009)) goto L65;
        L54:
            if (r119.intValue() == (-1000)) goto L65;
        L71:
            if ((r110 instanceof ff9.i.p) == false) goto L74;
            ue9.b.c r122 = new ue9.b.c(ue9.c.f.f549850c, null, null, 6);
            this.f349263a.X(AVCommonError.Engine_Occupied);
            this.f349263a.m(r122.f549839a);
            this.f349263a.J(r122);
            return;
        L74:
            if ((r110 instanceof ff9.i.q) == false) goto L93;
            s r123 = this.f349263a.f349259w;
            if (r123 == null) goto L78;
            r123.g(true);
        L78:
            this.f349263a.F().a().a();
            com.larus.im.internal.delegate.c r124 = com.larus.im.internal.delegate.c.f348197a;
            if (r124.isDebug() == false) goto L81;
            Toast.makeText(r124.getApplication(), "start screen share publish!", 0).show();
        L81:
            r100.e("FlowRTCLinkSession", "startScreenCapture: RTCListener-> SelfScreenShareStarted");
            this.f349263a.getClass();
            fe9.j r125 = fe9.i.f476629a;
            fe9.j r126 = fe9.i.f476629a;
            FlowRTCLinkSession r108 = this.f349263a;
            List<String> r109 = CollectionsKt.listOfNotNull(new String[]{r108.f349238b, r108.E()});
            Pair[] r127 = new Pair[3];
            String r128 = this.f349263a.E();
            if (r128 != null) goto L84;
            r128 = "";
        L84:
            r127[0] = TuplesKt.to("roomId", r128);
            r127[1] = TuplesKt.to("listeners", Integer.valueOf(this.f349263a.G.size()));
            if (this.f349263a.f349259w == null) goto L88;
            r101 = false;
        L88:
            r127[2] = TuplesKt.to("rtcRoomServiceNull", Boolean.valueOf(r101));
            r126.a("ScreenShareStartResult", "FlowRTCLinkSession.DefaultRTCEventListener.onEvent", r109, MapsKt.mapOf(r127));
            Iterator<ue9.d> r129 = this.f349263a.G.iterator();
        L90:
            if (r129.hasNext() == false) goto L243;
            ue9.d r130 = r129.next();
            Intrinsics.checkNotNull(r130);
            r.b(r130, "OTHER_EVENT_RTC_START_SCREEN_SHARE", null);
            goto L90
        L243:
            return;
        L93:
            if ((r110 instanceof ff9.i.r) == false) goto L105;
            s r131 = this.f349263a.f349259w;
            if (r131 == null) goto L97;
            r131.g(false);
        L97:
            r100.e("FlowRTCLinkSession", "startScreenCapture: RTCListener-> SelfScreenShareStop，trigger OTHER_EVENT_RTC_END_SCREEN_SHARE");
            JSONObject r132 = new JSONObject();
            ff9.i.r r133 = (ff9.i.r) r110;
            r132.put("device_state", r133.f476745a);
            r132.put("device_error", r133.f476746b);
            this.f349263a.getClass();
            fe9.j r134 = fe9.i.f476629a;
            fe9.j r135 = fe9.i.f476629a;
            FlowRTCLinkSession r136 = this.f349263a;
            List<String> r137 = CollectionsKt.listOfNotNull(new String[]{r136.f349238b, r136.E()});
            Pair[] r138 = new Pair[4];
            String r139 = this.f349263a.E();
            if (r139 != null) goto L100;
            r139 = "";
        L100:
            r138[0] = TuplesKt.to("roomId", r139);
            r138[1] = TuplesKt.to("device_state", Integer.valueOf(r133.f476745a));
            r138[2] = TuplesKt.to("device_error", Integer.valueOf(r133.f476746b));
            r138[3] = TuplesKt.to("listeners", Integer.valueOf(this.f349263a.G.size()));
            r135.a("ScreenShareStop", "FlowRTCLinkSession.DefaultRTCEventListener.onEvent", r137, MapsKt.mapOf(r138));
            Iterator<ue9.d> r140 = this.f349263a.G.iterator();
        L102:
            if (r140.hasNext() == false) goto L244;
            ue9.d r141 = r140.next();
            Intrinsics.checkNotNull(r141);
            r.b(r141, "OTHER_EVENT_RTC_END_SCREEN_SHARE", r132.toString());
            goto L102
        L244:
            return;
        L105:
            if ((r110 instanceof ff9.i.d) == false) goto L108;
            this.f349263a.L("OTHER_EVENT_RTC_FIRST_LOCAL_VIDEO_FRAME_CAPTURED", null);
            return;
        L108:
            if ((r110 instanceof ff9.i.C5894i) == false) goto L113;
            if (((ff9.i.C5894i) r110).f476721a == false) goto L226;
            this.f349263a.L("OTHER_EVENT_RTS_LOGIN_SUCCESS", null);
            return;
        L226:
            return;
        L113:
            if ((r110 instanceof ff9.i.m) == false) goto L131;
            if (w.h() == false) goto L120;
            qd9.a r142 = qd9.a.f532581a;
            Integer r143 = ((ff9.i.m) r110).f476732a;
            if (r143 == null) goto L119;
            r102 = r143.intValue();
        L119:
            qd9.a.f532585e.d(r102);
        L120:
            FlowRTCLinkSession r144 = this.f349263a;
            ff9.i.m r145 = (ff9.i.m) r110;
            Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L123
            LinkedHashMap r147 = new LinkedHashMap();     // Catch: Throwable -> L123
            ouc.i r148 = sf9.a.e(r145.f476732a);     // Catch: Throwable -> L123
            Intrinsics.checkNotNullParameter("upQuality", "key");     // Catch: Throwable -> L123
            Intrinsics.checkNotNullParameter(r148, "element");     // Catch: Throwable -> L123
            ouc.i r149 = (ouc.i) r147.put("upQuality", r148);     // Catch: Throwable -> L123
            ouc.i r150 = sf9.a.e(r145.f476733b);     // Catch: Throwable -> L123
            Intrinsics.checkNotNullParameter("downQuality", "key");     // Catch: Throwable -> L123
            Intrinsics.checkNotNullParameter(r150, "element");     // Catch: Throwable -> L123
            ouc.i r151 = (ouc.i) r147.put("downQuality", r150);     // Catch: Throwable -> L123
            String r152 = new d0(r147).toString();     // Catch: Throwable -> L123
        L127:
            r144.L("OTHER_EVENT_RTC_NETWORK_QUALITY_CHANGE", r152);
            return;
        L123:
            th = move-exception;
            Result.Companion r153 = Result.Companion;
            Throwable r154 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            if (r154 == null) goto L129;
            fe9.a.f476620a.b("OnNetworkQuality", "toJson err. msg=" + r154);
            r152 = SliceInitService.DEFAULT_SWITCH;
            goto L127
        L129:
            throw new KotlinNothingValueException();
        L131:
            if ((r110 instanceof ff9.i.c) == false) goto L134;
            JSONObject r155 = new JSONObject();
            ff9.i.c r156 = (ff9.i.c) r110;
            r155.putOpt("device_type", r156.f476706a);
            r155.put("device_state", r156.f476707b);
            r155.put("device_error", r156.f476708c);
            r155.put("is_audio", r156.f476709d);
            r155.put("is_video", r156.f476710e);
            this.f349263a.L("OTHER_EVENT_RTC_AUDIO_DEVICE_RENDER_ERROR", r155.toString());
            return;
        L134:
            if ((r110 instanceof ff9.i.a) == false) goto L137;
            JSONObject r157 = new JSONObject();
            ff9.i.a r158 = (ff9.i.a) r110;
            r157.put("error_code", r158.f476700a);
            r157.putOpt("error_msg", r158.f476701b);
            this.f349263a.L("OTHER_EVENT_RTC_AUDIO_PUBLISH_FAILED", r157.toString());
            return;
        L137:
            if ((r110 instanceof ff9.i.o) == false) goto L148;
            if (w.h() == false) goto L231;
            qd9.a r159 = qd9.a.f532581a;
            ff9.i.o r160 = (ff9.i.o) r110;
            int r161 = r160.f476735a;
            int r162 = r160.f476736b;
            int r163 = r160.f476737c;
            int r164 = r160.f476738d;
            double r165 = r160.f476739e;
            double r166 = r160.f476740f;
            int r167 = r160.f476741g;
            int r168 = r160.f476742h;
            qd9.a.f532603w.d(r161);
            qd9.a.f532602v.d(r163);
            if (r163 > 0) goto L145;
            if (r164 > 0) goto L145;
            int r169 = 0;
        L146:
            r100.e("SmartNetwork", "roomStatsMonitor, wifiTxKBitRate: " + r161 + ", wifiRxKBitRate: " + r162 + ", txCellularBytes: " + r102 + ", rxCellularBytes: " + r169 + ", txLostRate: " + r165 + ", rxLostRate: " + r166 + ", txJitter: " + r167 + ", rxJitter: " + r168 + ", mTotalCellularBytes: " + qd9.a.f532601u.c());
            return;
        L145:
            r102 = ((r163 * 1024) / 8) * 2;
            r169 = ((r164 * 1024) / 8) * 2;
            qd9.a.f532601u.a(r102 + r169);
            goto L146
        L231:
            return;
        L148:
            if ((r110 instanceof ff9.i.k) == false) goto L178;
            if (w.h() == false) goto L233;
            com.larus.im.internal.network.link.impl.rtc.smartnetwork.c r170 = com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349349a;
            ff9.i.k r171 = (ff9.i.k) r110;
            int r172 = r171.f476724a;
            int r173 = r171.f476725b;
            int r174 = r171.f476726c;
            int r175 = r171.f476727d;
            int r176 = r171.f476728e;
            int r177 = r171.f476729f;
            monitor-enter(r170);
        L174:
            th = move-exception;
            throw th;
        L154:
            if (com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.R.get() == true) goto L158;
            r100.e("SmartNetwork", "rtcRttMonitor, EvaluateThread not running");     // Catch: Throwable -> L174
            monitor-exit(r170);
            return;
        L158:
            if (r172 == 0) goto L172;
            if (r173 == 0) goto L172;
            if (r174 == 0) goto L172;
            if (com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349370k0.get() == true) goto L167;
            r100.e("SmartNetwork", "main link type is cell");     // Catch: Throwable -> L174
            monitor-exit(r170);
            return;
        L167:
            com.larus.im.internal.network.link.impl.rtc.smartnetwork.e r178 = com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349360f0;     // Catch: Throwable -> L174
            if (r178 == null) goto L170;
            r178.b(r172, r173, r174, r175, r176, r177);     // Catch: Throwable -> L174
        L170:
            monitor-exit(r170);
            return;
        L172:
            monitor-exit(r170);
            return;
        L233:
            return;
        L178:
            if ((r110 instanceof ff9.i.l) == false) goto L188;
            if (w.h() == false) goto L234;
            ff9.i.l r179 = (ff9.i.l) r110;
            com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349349a.o(r179.f476730a, r179.f476731b);
            if (r179.f476730a != MultiLinkEnhancementState.MULTI_LINK_ENHANCEMENT_STATE_CONNECTED.value()) goto L235;
            Iterator<ue9.d> r180 = this.f349263a.G.iterator();
        L185:
            if (r180.hasNext() == false) goto L245;
            ue9.d r181 = r180.next();
            Intrinsics.checkNotNull(r181);
            r.b(r181, "OTHER_EVENT_RTC_MULTIPATH_WORK", Integer.valueOf(r179.f476731b));
            goto L185
        L245:
            return;
        L235:
            return;
        L234:
            return;
        L188:
            if ((r110 instanceof ff9.i.n) == true) goto L190;
            return;
        L190:
            if (w.h() == false) goto L192;
            com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349349a.p(((ff9.i.n) r110).f476734a);
        L192:
            Iterator<ue9.d> r182 = this.f349263a.G.iterator();
        L194:
            if (r182.hasNext() == false) goto L196;
            ue9.d r183 = r182.next();
            Intrinsics.checkNotNull(r183);
            r.b(r183, "OTHER_EVENT_RTC_NETWORK_CHANGE", Integer.valueOf(((ff9.i.n) r110).f476734a));
            goto L194
        L196:
            ff9.i.n r184 = (ff9.i.n) r110;
            if (r184.f476734a <= 0) goto L199;
            this.f349263a.N("rtc_network_type_" + r184.f476734a);
            return;
        L199:
            FlowRTCLinkSession.s(this.f349263a, "rtc_network_type_" + r184.f476734a);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Job f349264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Job f349265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f349266c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f349264a, r101.f349264a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f349265b, r101.f349265b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f349266c, r101.f349266c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Job r100 = this.f349264a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Job r104 = this.f349265b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            ConnectivityManager.NetworkCallback r107 = this.f349266c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "NetworkRecoveryResources(retryJob=" + this.f349264a + ", deadlineJob=" + this.f349265b + ", callback=" + this.f349266c + ')';
        }

        public c(Job r100, Job r101, ConnectivityManager.NetworkCallback r102) {
            this.f349264a = r100;
            this.f349265b = r101;
            this.f349266c = r102;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f349267a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f349268b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f349269c = null;

        static {
            int[] r100 = new int[RTCConnectRetryReason.values().length];
            r100[RTCConnectRetryReason.NETWORK_RECOVERY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L4:
            f349267a = r100;
            int[] r101 = new int[RTCConnectRetryAction.values().length];
            r101[RTCConnectRetryAction.RESEND_START_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L22:
            r101[RTCConnectRetryAction.FULL_RECONNECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L8:
            f349268b = r101;
            int[] r102 = new int[MessageSendType.values().length];
            r102[MessageSendType.Control.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L30:
            r102[MessageSendType.Engine.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L20:
            r102[MessageSendType.P2P.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f349269c = r102;
        }
    }

    public static final class e implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowRTCLinkSession f349270a;

        public e(FlowRTCLinkSession r100) {
            this.f349270a = r100;
        }

        @Override // ff9.q
        public final void a(p1 r110) {
            Intrinsics.checkNotNullParameter(r110, "frame");
            Iterator<ue9.a> r100 = this.f349270a.H.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ue9.a r101 = r100.next();
            com.larus.im.service.audio.l r102 = r110.f349975a;
            byte[] r103 = r102.f350772a;
            ue9.g r104 = r102.getType();
            com.larus.im.service.audio.l r105 = r110.f349975a;
            String r106 = r105.f350773b;
            r101.a(new ue9.f(r103, r104, null, null, r105.f350775d, r106, 8));
            goto L4
        }
    }

    public static final class f extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowRTCLinkSession f349271a;

        public f(FlowRTCLinkSession r100) {
            this.f349271a = r100;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            this.f349271a.N("system_network_available");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r100) {
            Intrinsics.checkNotNullParameter(r100, "network");
            FlowRTCLinkSession.s(this.f349271a, "system_network_lost");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            Intrinsics.checkNotNullParameter(r100, "network");
            Intrinsics.checkNotNullParameter(r101, "networkCapabilities");
            if (r101.hasCapability(12) == false) goto L5;
            this.f349271a.N("system_network_capabilities");
            return;
        L5:
            FlowRTCLinkSession.s(this.f349271a, "system_network_capabilities");
        }
    }

    public final void w() {
        c r100 = V(null, null);
        if (r100 == null) goto L6;
        y(r100, null);
        return;
    }

    static {
        K = new AtomicLong(-1);
    }

    public static ConnectivityManager x() {
        Object r100 = com.larus.im.internal.delegate.c.f348197a.getApplication().getApplicationContext().getSystemService("connectivity");
        if ((r100 instanceof ConnectivityManager) == true) goto L7;
        return null;
    L7:
        return (ConnectivityManager) r100;
    }

    public final com.larus.im.internal.network.link.impl.rtc.abs.a D() {
        return (com.larus.im.internal.network.link.impl.rtc.abs.a) this.f349258v.getValue();
    }

    public final u F() {
        return (u) this.f349254r.getValue();
    }

    public final void T() {
        RTCConnectRetryReason r100 = RTCConnectRetryReason.SESSION_STARTED_TIMEOUT;
        if (G(r100) == true) goto L5;
        return;
    L5:
        long r101 = SystemClock.elapsedRealtime();
        com.larus.im.internal.network.link.impl.rtc.g r102 = this.f349245i;
        if (r102 == null) goto L8;
        long r103 = r102.d(r101);
    L10:
        if (r103 != 0) goto L13;
        I(r100, ue9.c.m.f549857c);
        return;
    L13:
        w.b r104 = w.j().f348359d;
        if (r104 == null) goto L16;
        int r105 = r104.f348317f;
    L17:
        Job r106 = BuildersKt.launch$default(this.f349244h, null, CoroutineStart.LAZY, new FlowRTCLinkSession$scheduleSessionStartedTimeout$timeoutJob$1(Math.min(RangesKt.coerceAtLeast(r105, 0), r103), this, null), 1, null);
        Object r107 = this.f349243g;
        monitor-enter(r107);
    L45:
        th = move-exception;
        throw th;
    L20:
        if (this.f349249m == false) goto L22;
    L26:
        Job r108 = null;
    L27:
        monitor-exit(r107);
        if (r108 == null) goto L31;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L31:
        Object r109 = this.f349243g;
        monitor-enter(r109);
        if (this.f349247k != r106) goto L36;
        boolean r110 = true;
    L37:
        monitor-exit(r109);
        if (r110 == false) goto L40;
        r106.start();
        return;
    L40:
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
        return;
    L36:
        r110 = false;
    L42:
        th = move-exception;
        throw th;
    L22:
        if (this.f349255s.get() == true) goto L26;
        r108 = this.f349247k;     // Catch: Throwable -> L45
        this.f349247k = r106;     // Catch: Throwable -> L45
        goto L27
    L16:
        r105 = 5000;
        goto L17
    L8:
        r103 = Long.MAX_VALUE;
        goto L10
    }

    @Override // ue9.i
    public final void disconnect() {
        ReentrantLock r100 = this.f349236J;
        r100.lock();
    L30:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (this.f349255s.compareAndSet(false, true) == false) goto L24;
        Object r101 = this.f349243g;     // Catch: Throwable -> L30
        monitor-enter(r101);     // Catch: Throwable -> L30
        com.larus.im.internal.network.link.impl.rtc.g r102 = this.f349245i;     // Catch: Throwable -> L27
        if (r102 == null) goto L11;
        r102.b();     // Catch: Throwable -> L27
    L11:
        List r103 = CollectionsKt.listOfNotNull(new Job[]{this.f349246j, this.f349247k, this.f349248l});     // Catch: Throwable -> L27
        this.f349246j = null;     // Catch: Throwable -> L27
        this.f349247k = null;     // Catch: Throwable -> L27
        this.f349248l = null;     // Catch: Throwable -> L27
        monitor-exit(r101);     // Catch: Throwable -> L30
        w();     // Catch: Throwable -> L30
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L30
    L15:
        if (r104.hasNext() == false) goto L17;
        Job.DefaultImpls.cancel$default((Job) r104.next(), null, 1, null);     // Catch: Throwable -> L30
        goto L15
    L17:
        CoroutineScopeKt.cancel$default(this.f349244h, null, 1, null);     // Catch: Throwable -> L30
        final long r105 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L30
        C(RTCEstablishReportScene.USER_LEAVE, r105, new n(this, r105));     // Catch: Throwable -> L30
        com.larus.im.internal.network.link.impl.rtc.o r106 = this.f349261y;     // Catch: Throwable -> L30
        r106.getClass();     // Catch: Throwable -> L30
        fe9.a.f476620a.e(r106.f349229b, "[onDisconnect]");     // Catch: Throwable -> L30
        r106.f(false);     // Catch: Throwable -> L30
        F().g(null, this.f349257u);     // Catch: Throwable -> L30
        F().g(E(), this.f349257u);     // Catch: Throwable -> L30
        s r107 = this.f349259w;     // Catch: Throwable -> L30
        if (r107 == null) goto L20;
        r107.leaveRoom();     // Catch: Throwable -> L30
    L20:
        F().v().d();     // Catch: Throwable -> L30
        F().e().release();     // Catch: Throwable -> L30
        if (w.h() == false) goto L23;
        com.larus.im.internal.network.link.impl.rtc.smartnetwork.c.f349349a.v();     // Catch: Throwable -> L30
    L23:
        F().destroy();     // Catch: Throwable -> L30
        this.G.clear();     // Catch: Throwable -> L30
        this.H.clear();     // Catch: Throwable -> L30
        D().d();     // Catch: Throwable -> L30
        goto L24
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r100.unlock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.im.internal.network.link.impl.rtc.abs.j] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.im.internal.network.link.impl.rtc.abs.k] */
    @Override // ue9.i
    public final void e() {
        ReentrantLock r100 = this.f349236J;
        r100.lock();
        final com.larus.im.internal.network.link.impl.rtc.h r101 = this.f349250n;     // Catch: Throwable -> L17
        if (U(r101) == false) goto L7;
    L14:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r100.unlock();
        return;
    L7:
        if (this.A == true) goto L9;
        boolean r110 = true;
    L10:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectOpt][connect] enableConnectFinishGate: " + this.f349242f + ", traceId: " + this.f349238b + ", fromPreCreate: " + r110);     // Catch: Throwable -> L17
        final long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        z(r103);     // Catch: Throwable -> L17
        final boolean r104 = r110;
        boolean r105 = D().b(new i(this), new j(this, r101, r104, r103), new k(this, r101));     // Catch: Throwable -> L17
        if (r110 == false) goto L14;
        if (r105 == false) goto L14;
        this.f349239c = true;     // Catch: Throwable -> L17
        goto L14
    L9:
        r110 = false;
    L17:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // ue9.i
    public final JSONObject o() {
        JSONObject r100 = new JSONObject();
        r100.put("roomId", E());
        RTCToken r101 = D().c();
        if (r101 == null) goto L5;
        String r102 = r101.getToken();
    L6:
        r100.put("token", r102);
        boolean r103 = true;
        r100.put("burst", true);
        r100.put("connType", this.f349237a.f349332c.getType());
        String r104 = w.i().f348375c;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        if (r104.length() > 0) goto L13;
        r103 = false;
    L13:
        r100.put("customIp", r103);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final void t() {
        if (this.f349242f == true) goto L5;
        return;
    L5:
        ReentrantReadWriteLock r100 = if9.c.f489641a;
        if9.b r101 = if9.c.c(this.f349238b);
        if (r101 != null) goto L9;
        fe9.a.f476620a.f("FlowRTCLinkSession", "[ConnectOpt][attachFinishGateToTrace] trace data not found, traceId: " + this.f349238b);
        return;
    L9:
        com.larus.im.internal.network.link.impl.rtc.e r102 = this.f349241e;
        Intrinsics.checkNotNullParameter(r102, "gate");
        ReentrantReadWriteLock r103 = r101.f489635a;
        ReentrantReadWriteLock.ReadLock r104 = r103.readLock();
        int r105 = 0;
        if (r103.getWriteHoldCount() != 0) goto L12;
        int r106 = r103.getReadHoldCount();
    L13:
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L16;
        r104.unlock();
        r107 = r107 + 1;
        goto L14
    L16:
        ReentrantReadWriteLock.WriteLock r108 = r103.writeLock();
        r108.lock();
        r101.f489639e = r102;     // Catch: Throwable -> L22
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L18:
        if (r105 >= r106) goto L20;
        r104.lock();
        r105 = r105 + 1;
        goto L18
    L20:
        r108.unlock();
        return;
    L22:
        th = move-exception;
    L23:
        if (r105 >= r106) goto L25;
        r104.lock();
        r105 = r105 + 1;
        goto L23
    L25:
        r108.unlock();
        throw th;
    L12:
        r106 = 0;
        goto L13
    }

    public static boolean H() {
        ConnectivityManager r100 = x();
        if (r100 != null) goto L5;
        return false;
    L5:
        NetworkInfo r101 = r100.getActiveNetworkInfo();
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        return false;
    L14:
        if (Build.VERSION.SDK_INT >= 23) goto L16;
        return true;
    L16:
        NetworkCapabilities r103 = r100.getNetworkCapabilities(r100.getActiveNetwork());
        if (r103 != null) goto L19;
        return true;
    L19:
        return r103.hasCapability(12);
    L8:
        if (r101.isConnected() != true) goto L10;
        r102 = true;
        goto L11
    }

    public final String E() {
        RTCToken r100 = D().c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRoomId();
    }

    public final void P() {
        ConnectivityManager r100 = x();
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = new f(this);
        Object r102 = this.f349243g;
        monitor-enter(r102);
    L36:
        th = move-exception;
        throw th;
    L8:
        if (this.f349251o != null) goto L10;
    L14:
        boolean r103 = false;
    L15:
        monitor-exit(r102);
        if (r103 == true) goto L43;
        return;
    L43:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        r100.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), r101);     // Catch: Throwable -> L20
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L35;
        Object r107 = this.f349243g;
        monitor-enter(r107);
    L32:
        th = move-exception;
        throw th;
    L27:
        if (this.f349252p != r101) goto L29;
        this.f349252p = null;     // Catch: Throwable -> L32
    L29:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r107);
        fe9.a.f476620a.c("FlowRTCLinkSession", "[ConnectRetry] register network recovery callback failed, traceId: " + this.f349238b, r106);
        return;
    L35:
        return;
    L20:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L10:
        if (this.f349252p != null) goto L14;
        this.f349252p = r101;     // Catch: Throwable -> L36
        r103 = true;
        goto L15
    }

    @Override // ff9.o
    public final y a() {
        return ((com.larus.im.internal.rtcsdk.impl.s) d()).a();
    }

    @Override // ff9.o
    public final ff9.r d() {
        return F().v();
    }

    @Override // ff9.o
    public final x k() {
        return ((com.larus.im.internal.rtcsdk.impl.s) d()).c();
    }

    @Override // ue9.i
    public final ue9.b getCurrentState() {
        return this.F;
    }

    @Override // ue9.i
    public final String getTraceId() {
        return this.f349238b;
    }

    public FlowRTCLinkSession(com.larus.im.internal.network.link.impl.rtc.p r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f349237a = r100;
        StringBuilder r101 = new StringBuilder();
        r101.append(UUID.randomUUID());
        r101.append('-');
        r101.append(K.addAndGet(1));
        this.f349238b = r101.toString();
        this.f349240d = SystemClock.elapsedRealtime();
        this.f349241e = new com.larus.im.internal.network.link.impl.rtc.e();
        this.f349242f = sf9.a.a((d0) w.f348282r.getValue(), "enable_token_preload_optimize", false);
        this.f349243g = new Object();
        this.f349244h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f349253q = new AtomicBoolean(false);
        this.f349254r = LazyKt.lazy(new o(this));
        this.f349255s = new AtomicBoolean(false);
        b r102 = new b(this);
        F().b(null, r102);
        this.f349257u = r102;
        this.f349258v = LazyKt.lazy(new p(this));
        Lazy r103 = LazyKt.lazy(new com.larus.im.internal.network.link.impl.rtc.abs.c(this));
        this.f349260x = r103;
        this.f349261y = new com.larus.im.internal.network.link.impl.rtc.o((com.larus.im.internal.network.link.impl.rtc.d) r103.getValue());
        this.f349262z = new ConcurrentHashMap();
        this.D = new AtomicBoolean(false);
        this.F = ue9.b.d.f549842a;
        this.G = new CopyOnWriteArraySet();
        this.H = new CopyOnWriteArraySet();
        this.I = new e(this);
        this.f349236J = new ReentrantLock();
    }

    public static final void r(FlowRTCLinkSession r100) {
        Object r101 = r100.f349243g;
        monitor-enter(r101);
        r100.f349249m = true;     // Catch: Throwable -> L15
        com.larus.im.internal.network.link.impl.rtc.g r102 = r100.f349245i;     // Catch: Throwable -> L15
        if (r102 == null) goto L8;
        r102.a();     // Catch: Throwable -> L15
    L8:
        List r103 = CollectionsKt.listOfNotNull(new Job[]{r100.f349246j, r100.f349247k, r100.f349248l});     // Catch: Throwable -> L15
        r100.f349246j = null;     // Catch: Throwable -> L15
        r100.f349247k = null;     // Catch: Throwable -> L15
        r100.f349248l = null;     // Catch: Throwable -> L15
        monitor-exit(r101);
        r100.w();
        Iterator r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        Job.DefaultImpls.cancel$default((Job) r104.next(), null, 1, null);
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void A(com.larus.im.internal.network.link.impl.rtc.h r100) {
        c r101 = V(r100, null);
        if (r101 != null) goto L5;
        return;
    L5:
        y(r101, null);
        I(RTCConnectRetryReason.NETWORK_RECOVERY, ue9.c.e.f549849c);
    }

    @Override // ue9.h
    public final void B(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        F().B(r100);
    }

    public final boolean G(RTCConnectRetryReason r100) {
        if (this.f349255s.get() == false) goto L5;
        return false;
    L5:
        if (this.f349237a.f349332c == RTCConnectionType.TokenPoolWithRTCMerge) goto L8;
        return false;
    L8:
        if (d.f349267a[r100.ordinal()] != 1) goto L12;
        w.b r101 = w.j().f348359d;
        if (r101 != null) goto L18;
        return false;
    L18:
        return r101.f348319h;
    L12:
        w.b r102 = w.j().f348359d;
        if (r102 != null) goto L15;
        return false;
    L15:
        return r102.f348318g;
    }

    public final void J(ue9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if ((this.F instanceof ue9.b.c) == false) goto L5;
        fe9.a.f476620a.b("FlowRTCLinkSession", "[currentState] disconnect, disable update");
    L7:
        if ((r100 instanceof ue9.b.a) == false) goto L11;
        com.larus.im.internal.network.link.impl.rtc.abs.b r101 = this.f349256t;
        if (r101 == null) goto L11;
        r101.invoke();
    L11:
        Iterator<ue9.d> r102 = this.G.iterator();
    L13:
        if (r102.hasNext() == false) goto L15;
        r102.next().a(r100);
        goto L13
    L15:
        return;
    L5:
        this.F = r100;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[currentState] update: " + r100);
        goto L7
    }

    public final void M(l r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        com.larus.im.internal.network.link.impl.rtc.o r101 = this.f349261y;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "action");     // Catch: Throwable -> L10
        fe9.a.f476620a.e(r101.f349229b, "[onClientReady] client ready: " + r101.f349232e);     // Catch: Throwable -> L10
        if (r101.f349232e == false) goto L7;
        r100.run();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
        return;
    L7:
        r101.f349231d.add(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlinx.coroutines.Job] */
    public final void N(String r110) {
        Object r100 = this.f349243g;
        monitor-enter(r100);
        com.larus.im.internal.network.link.impl.rtc.h r101 = this.f349251o;     // Catch: Throwable -> L70
        boolean r102 = false;
        Job r103 = null;
        if (r101 == null) goto L14;
        Job r104 = this.f349246j;     // Catch: Throwable -> L70
        if (r104 == null) goto L12;
        if (r104.isActive() != true) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L14;
    L15:
        monitor-exit(r100);
        if (r101 != null) goto L19;
        return;
    L19:
        if (this.f349255s.get() == false) goto L21;
    L68:
        w();
        return;
    L21:
        if (this.f349249m == true) goto L68;
        if (H() == true) goto L28;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] network recovery ignored, network unavailable, source: " + r110 + ", traceId: " + this.f349238b);
        return;
    L28:
        if (SystemClock.elapsedRealtime() >= r101.f349321g) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == true) goto L34;
        A(r101);
        return;
    L34:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] network recovered, debounce reconnect, source: " + r110 + ", delayMs: 800, traceId: " + this.f349238b);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = BuildersKt.launch$default(this.f349244h, null, CoroutineStart.LAZY, new FlowRTCLinkSession$onConnectNetworkRecovered$1(this, r101, r111, null), 1, null);
        Object r107 = this.f349243g;
        monitor-enter(r107);
    L65:
        th = move-exception;
        throw th;
    L37:
        if (this.f349251o != r101) goto L52;
        Job r108 = this.f349246j;     // Catch: Throwable -> L65
        if (r108 != null) goto L41;
    L43:
        boolean r109 = false;
    L44:
        if (r109 == true) goto L52;
        T r112 = r111.element;     // Catch: Throwable -> L65
        if (r112 != 0) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("recoveryJob");     // Catch: Throwable -> L65
        Job r113 = null;
    L50:
        this.f349246j = r113;     // Catch: Throwable -> L65
        r102 = true;
        goto L52
    L49:
        r113 = (Job) r112;     // Catch: Throwable -> L65
        goto L50
    L41:
        if (r108.isActive() != true) goto L43;
        r109 = true;
    L52:
        monitor-exit(r107);
        if (r102 == false) goto L59;
        T r114 = r111.element;
        if (r114 != 0) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("recoveryJob");
    L58:
        r103.start();
        return;
    L57:
        r103 = (Job) r114;
        goto L58
    L59:
        T r115 = r111.element;
        if (r115 != 0) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("recoveryJob");
        Job r116 = null;
    L63:
        Job.DefaultImpls.cancel$default(r116, null, 1, null);
        return;
    L62:
        r116 = (Job) r115;
        goto L63
    L30:
        r106 = false;
    L12:
        r105 = false;
    L14:
        r101 = null;
    L70:
        th = move-exception;
        throw th;
    }

    public final void O(com.larus.im.internal.network.link.impl.rtc.h r100) {
        fe9.a r101 = fe9.a.f476620a;
        r101.e("FlowRTCLinkSession", "[ConnectRetry] full reconnect, reason: " + r100.f349315a.getValue() + ", clearTokenCache: " + r100.f349319e + ", recoverEngine: " + r100.f349320f + ", traceId: " + this.f349238b);
        Object r102 = this.f349243g;
        monitor-enter(r102);
        Job r103 = this.f349247k;     // Catch: Throwable -> L22
        this.f349247k = null;     // Catch: Throwable -> L22
        monitor-exit(r102);
        if (r103 == null) goto L8;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L8:
        boolean r104 = r100.f349320f;
        F().g(E(), this.f349257u);
        s r105 = this.f349259w;
        if (r105 == null) goto L11;
        r105.leaveRoom();
    L11:
        this.f349259w = null;
        if (r104 == false) goto L14;
        F().c();
    L14:
        com.larus.im.internal.network.link.impl.rtc.o r106 = this.f349261y;
        r106.getClass();
        r101.e(r106.f349229b, "[resetForRetry]");
        r106.e("");
        r106.i(false);
        r106.f(false);
        D().d();
        if (r100.f349319e == false) goto L18;
        D().a();
    L18:
        if (U(r100) == false) goto L20;
        return;
    L20:
        e();
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final void S(com.larus.im.internal.network.link.impl.rtc.h r100) {
        Job r101 = BuildersKt.launch$default(this.f349244h, null, CoroutineStart.LAZY, new FlowRTCLinkSession$scheduleConnectRetryExecution$retryJob$1(r100, this, null), 1, null);
        Object r102 = this.f349243g;
        monitor-enter(r102);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (this.f349250n == r100) goto L7;
    L13:
        Job r103 = null;
    L14:
        monitor-exit(r102);
        if (r103 == null) goto L18;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L18:
        Object r104 = this.f349243g;
        monitor-enter(r104);
        if (this.f349246j != r101) goto L23;
        boolean r105 = true;
    L24:
        monitor-exit(r104);
        if (r105 == false) goto L27;
        r101.start();
        return;
    L27:
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        return;
    L23:
        r105 = false;
    L29:
        th = move-exception;
        throw th;
    L7:
        if (this.f349249m == true) goto L13;
        if (this.f349255s.get() == true) goto L13;
        r103 = this.f349246j;     // Catch: Throwable -> L32
        this.f349246j = r101;     // Catch: Throwable -> L32
        goto L14
    }

    public final boolean U(com.larus.im.internal.network.link.impl.rtc.h r100) {
        if (this.f349253q.get() == false) goto L6;
        return true;
    L6:
        if (r100 == null) goto L20;
        Object r101 = this.f349243g;
        monitor-enter(r101);
        if (this.f349250n == r100) goto L12;
        boolean r102 = true;
    L13:
        monitor-exit(r101);
        if (r102 == false) goto L20;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] ignore stale retry callback, traceId: " + this.f349238b);
        return true;
    L12:
        r102 = false;
    L17:
        th = move-exception;
        throw th;
    L20:
        com.larus.im.internal.network.link.impl.rtc.h r103 = this.f349250n;
        if (r103 != null) goto L24;
    L28:
        return false;
    L24:
        if (SystemClock.elapsedRealtime() >= r103.f349321g) goto L26;
        boolean r104 = true;
    L27:
        if (r104 == true) goto L28;
        RTCConnectRetryReason r105 = r103.f349315a;
        if (r105 != RTCConnectRetryReason.START_SESSION_FAILED) goto L32;
    L35:
        ue9.c r106 = ue9.c.m.f549857c;
    L36:
        I(r105, r106);
        return true;
    L32:
        if (r105 == RTCConnectRetryReason.SESSION_STARTED_TIMEOUT) goto L35;
        r106 = ue9.c.e.f549849c;
        goto L36
    L26:
        r104 = false;
        goto L27
    }

    public final boolean W(RTCConnectRetryReason r110) {
        if (G(r110) == true) goto L6;
        return false;
    L6:
        if (this.f349253q.get() == false) goto L8;
        return true;
    L8:
        long r100 = SystemClock.elapsedRealtime();
        Object r101 = this.f349243g;
        monitor-enter(r101);
    L78:
        th = move-exception;
        throw th;
    L11:
        if (this.f349255s.get() == false) goto L13;
    L36:
        Job r102 = null;
        com.larus.im.internal.network.link.impl.rtc.h r111 = null;
        Job r112 = null;
    L37:
        boolean r103 = false;
    L38:
        boolean r113 = false;
    L39:
        monitor-exit(r101);
        if (r113 == false) goto L43;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] network recovery already pending, traceId: " + this.f349238b);
        return true;
    L43:
        if (r111 != null) goto L56;
        if (r103 == true) goto L46;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] no retry plan, reason: " + r110.getValue() + ", traceId: " + this.f349238b);
        return false;
    L46:
        if (r110 != RTCConnectRetryReason.START_SESSION_FAILED) goto L48;
    L51:
        ue9.c r104 = ue9.c.m.f549857c;
    L52:
        I(r110, r104);
        return true;
    L48:
        if (r110 == RTCConnectRetryReason.SESSION_STARTED_TIMEOUT) goto L51;
        r104 = ue9.c.e.f549849c;
        goto L52
    L56:
        if (r102 == null) goto L58;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L58:
        if (r112 == null) goto L60;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L60:
        this.f349241e.b(r110.getValue(), r100 - this.f349240d);
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] schedule retry, reason: " + r110.getValue() + ", attempt: " + r111.f349316b + ", delayMs: " + r111.f349317c + ", action: " + r111.f349318d + ", remainingDeadlineMs: " + RangesKt.coerceAtLeast(r111.f349321g - r100, 0) + ", traceId: " + this.f349238b);
        if (this.f349255s.get() == false) goto L63;
    L77:
        return true;
    L63:
        if (this.f349249m == true) goto L77;
        RTCConnectRetryReason r105 = RTCConnectRetryReason.NETWORK_RECOVERY;
        if (r110 != r105) goto L69;
        L("OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST", null);
    L69:
        if (r110 != r105) goto L71;
        String r106 = "Network reconnecting";
    L72:
        J(new ue9.b.C7871b(r106));
        if (r110 != r105) goto L76;
        Y(r111);
        return true;
    L76:
        S(r111);
        goto L77
    L71:
        r106 = "Retrying " + r110.getValue();
        goto L72
    L13:
        if (this.f349249m == true) goto L36;
        RTCConnectRetryReason r107 = RTCConnectRetryReason.NETWORK_RECOVERY;     // Catch: Throwable -> L78
        if (r110 == r107) goto L18;
    L20:
        com.larus.im.internal.network.link.impl.rtc.g r108 = this.f349245i;     // Catch: Throwable -> L78
        if (r108 != null) goto L23;
        r108 = z(r100);     // Catch: Throwable -> L78
    L23:
        r111 = r108.c(r110, r100);     // Catch: Throwable -> L78
        if (r111 == null) goto L26;
        r102 = this.f349246j;     // Catch: Throwable -> L78
        this.f349246j = null;     // Catch: Throwable -> L78
        r112 = this.f349247k;     // Catch: Throwable -> L78
        this.f349247k = null;     // Catch: Throwable -> L78
        this.f349250n = r111;     // Catch: Throwable -> L78
        if (r110 != r107) goto L37;
        this.f349251o = r111;     // Catch: Throwable -> L78
        goto L37
    L26:
        if (this.f349250n != null) goto L28;
    L30:
        r103 = false;
    L31:
        r102 = null;
        r111 = null;
        r112 = null;
        goto L38
    L28:
        if (r108.d(r100) != 0) goto L30;
        r103 = true;
        goto L31
    L18:
        if (this.f349251o == null) goto L20;
        r102 = null;
        r111 = null;
        r112 = null;
        r103 = false;
        r113 = true;
        goto L39
    }

    public final void X(AVCommonError r100) {
        ReentrantReadWriteLock r101 = if9.c.f489641a;
        if9.b r102 = if9.c.c(this.f349238b);
        if (r102 == null) goto L7;
        if9.a r103 = r102.f489636b;
        if (r103 == null) goto L7;
        if9.a r104 = r103.m();
    L8:
        if (r104 == null) goto L10;
        r104.f489629d = r100.getCode();
    L10:
        if (r104 == null) goto L12;
        r104.f489630e = r100.getMsg();
    L12:
        if (r104 == null) goto L14;
        r104.f489631f = r100.getSubCode();
    L14:
        if (r104 == null) goto L17;
        r104.f489632g = r100.getSubMsg();
        return;
    L17:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void Y(com.larus.im.internal.network.link.impl.rtc.h r110) {
        P();
        long r100 = RangesKt.coerceAtLeast(r110.f349321g - SystemClock.elapsedRealtime(), 0);
        if (r100 != 0) goto L6;
        A(r110);
        return;
    L6:
        Job r101 = BuildersKt.launch$default(this.f349244h, null, CoroutineStart.LAZY, new FlowRTCLinkSession$waitNetworkRecoveryForRetry$deadlineJob$1(r100, this, r110, null), 1, null);
        Object r102 = this.f349243g;
        monitor-enter(r102);
    L33:
        th = move-exception;
        throw th;
    L9:
        if (this.f349251o == r110) goto L11;
        Job r111 = null;
    L12:
        monitor-exit(r102);
        if (r111 == null) goto L16;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
    L16:
        Object r112 = this.f349243g;
        monitor-enter(r112);
        if (this.f349248l != r101) goto L21;
        boolean r103 = true;
    L22:
        monitor-exit(r112);
        if (r103 == false) goto L25;
        r101.start();
    L27:
        if (H() == false) goto L40;
        N("network_available");
        return;
    L40:
        return;
    L25:
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        goto L27
    L21:
        r103 = false;
    L30:
        th = move-exception;
        throw th;
    L11:
        r111 = this.f349248l;     // Catch: Throwable -> L33
        this.f349248l = r101;     // Catch: Throwable -> L33
        goto L12
    }

    @Override // ue9.i
    public final void b(ue9.a r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.H.add(r100);
    }

    @Override // ue9.i
    public final void c(ue9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.G.remove(r100);
    }

    @Override // ue9.j
    public final int f(ue9.f r110) {
        Intrinsics.checkNotNullParameter(r110, "frame");
        com.larus.im.internal.network.link.impl.rtc.o r100 = this.f349261y;
        monitor-enter(r100);
        boolean r101 = r100.f349232e;     // Catch: Throwable -> L27
        monitor-exit(r100);
        if (r101 == true) goto L9;
    L26:
        return -100;
    L9:
        if (this.f349255s.get() == true) goto L26;
        ue9.g r102 = r110.getType();
        byte[] r103 = r110.f549867a;
        byte[] r104 = r110.f549869c;
        if ((r102 instanceof ue9.g.a) == false) goto L15;
        ue9.g.a r105 = (ue9.g.a) r102;
        return F().v().g(new ff9.g(r103, r105.f549875c, r105.f549874b, r104));
    L15:
        if ((r102 instanceof ue9.g.c) == false) goto L18;
        ue9.g.c r106 = (ue9.g.c) r102;
        return F().v().h(new ff9.h(r103, r106.f549880c, r106.f549879b, r104, r110.f549870d, r106.f549881d));
    L18:
        if ((r102 instanceof ue9.g.d) == false) goto L25;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L23;
        return -100;
    L23:
        throw new UnsupportedOperationException("VAD stream not supported.");
    L25:
        throw new IllegalStateException("not support type");
    L27:
        th = move-exception;
        throw th;
    }

    @Override // ue9.i
    public final void h(ue9.a r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        this.H.remove(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // ue9.i
    public final cf9.d i(cf9.c r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        ue9.b r100 = this.F;
        MessageSendType r101 = r110.getType();
        int[] r102 = d.f349269c;
        byte[] r103 = null;
        cf9.d r104 = null;
        r104 = null;
        r104 = null;
        boolean r105 = false;
        if (r102[r101.ordinal()] != 3) goto L11;
        s r106 = this.f349259w;
        if (r106 != null) goto L7;
    L75:
        fe9.a r107 = fe9.a.f476620a;
        StringBuilder r108 = new StringBuilder("[SendMessage] room service is null == ");
        if (this.f349259w != null) goto L78;
        r105 = true;
    L78:
        r108.append(r105);
        r108.append(",connection state = ");
        r108.append(r100);
        r108.append(", client ready: ");
        com.larus.im.internal.network.link.impl.rtc.o r109 = this.f349261y;
        monitor-enter(r109);
        boolean r111 = r109.f349232e;     // Catch: Throwable -> L97
        monitor-exit(r109);
        r108.append(r111);
        r108.append(", destroy = ");
        r108.append(this.f349255s.get());
        r108.append(",ticket: ");
        r108.append(r104);
        r108.append('.');
        r107.e("FlowRTCLinkSession", r108.toString());
        if (r104 != null) goto L85;
    L87:
        if (r104 != null) goto L105;
        int r112 = cf9.b.f23547a;
        if ((this.F instanceof ue9.b.a) == true) goto L92;
        MessageSendErrorCode r113 = MessageSendErrorCode.CONNECTION_NOT_READY;
    L96:
        return cf9.b.a(r113, r110.getType());
    L92:
        if (this.f349255s.get() == false) goto L94;
        r113 = MessageSendErrorCode.SESSION_DESTROYED;
        goto L96
    L94:
        r113 = MessageSendErrorCode.RTC_SERVICE_NOT_READY;
        goto L96
    L105:
        return r104;
    L85:
        if (cf9.e.a(r104) == false) goto L87;
        this.f349262z.put(r104, this);
    L97:
        th = move-exception;
        throw th;
    L7:
        if ((r100 instanceof ue9.b.a) == false) goto L75;
        if (this.f349255s.get() == true) goto L75;
        r104 = r106.b(this.f349261y.f349230c, r110.f23548a);
        goto L75
    L11:
        byte[] r114 = r110.f23548a;
        MessageSendType r115 = r110.getType();
        if (r115 != MessageSendType.Engine) goto L14;
    L101:
        cf9.a r116 = v.f350031a.d();     // Catch: Throwable -> L71
        if (r116 == null) goto L24;
        String r117 = r116.f23542a;     // Catch: Throwable -> L71
    L25:
        com.larus.im.internal.network.link.impl.rtc.s r118 = new com.larus.im.internal.network.link.impl.rtc.s(r117, this.f349237a.f349330a, E(), 8);     // Catch: Throwable -> L71
        com.larus.im.internal.network.link.impl.rtc.b r119 = u(this, false, 2);     // Catch: Throwable -> L71
        String r120 = Base64.encodeToString(r114, 0);     // Catch: Throwable -> L71
        if (r120 != null) goto L28;
    L33:
        List r121 = null;
    L34:
        com.larus.im.internal.network.link.impl.rtc.i r122 = new com.larus.im.internal.network.link.impl.rtc.i(r118, r119, r121, true);     // Catch: Throwable -> L71
        zd9.h.f571481a.getClass();     // Catch: Throwable -> L71
        String r123 = zd9.h.c(r122);     // Catch: Throwable -> L71
        if (r123 == null) goto L37;
        r103 = r123.getBytes(Charset.defaultCharset());     // Catch: Throwable -> L71
    L37:
        if (r103 != null) goto L39;
    L45:
        boolean r124 = true;
    L46:
        if (r124 == false) goto L48;
        int r125 = cf9.b.f23547a;
        cf9.d r126 = cf9.b.a(MessageSendErrorCode.EMPTY_MESSAGE, r115);
    L18:
        r104 = r126;
        goto L75
    L48:
        int r127 = r102[r115.ordinal()];
        if (r127 == 1) goto L58;
        if (r127 != 2) goto L52;
        r126 = F().f(r103);
        goto L18
    L52:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L55;
        int r128 = cf9.b.f23547a;
        r126 = cf9.b.a(MessageSendErrorCode.UNSUPPORTED_MESSAGE_TYPE, r115);
        goto L18
    L55:
        throw new IllegalArgumentException("Unknown message type(" + r115.getDesc() + ") pass checker.");
    L58:
        if (this.f349261y.b() == true) goto L60;
    L66:
        int r129 = cf9.b.f23547a;
        if (this.f349261y.b() == true) goto L69;
        MessageSendErrorCode r130 = MessageSendErrorCode.CLIENT_NOT_READY;
    L70:
        r126 = cf9.b.a(r130, r115);
        goto L18
    L69:
        r130 = MessageSendErrorCode.SESSION_DESTROYED;
        goto L70
    L60:
        if (this.f349255s.get() == true) goto L66;
        s r131 = this.f349259w;
        if (r131 == null) goto L65;
        r126 = r131.f(r103);
        if (r126 != null) goto L18;
    L65:
        int r132 = cf9.b.f23547a;
        r126 = cf9.b.a(MessageSendErrorCode.RTC_SERVICE_NOT_READY, r115);
        goto L18
    L39:
        if (r103.length != 0) goto L41;
        boolean r133 = true;
    L42:
        if (r133 == true) goto L45;
        r124 = false;
        goto L46
    L41:
        r133 = false;
        goto L42
    L28:
        if ((!StringsKt.isBlank(r120)) == true) goto L31;
        r120 = null;
    L31:
        if (r120 == null) goto L33;
        r121 = CollectionsKt.listOf(r120);     // Catch: Throwable -> L71
        goto L34
    L24:
        r117 = null;
    L71:
        th = move-exception;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L100;
        fe9.a.f476620a.c("FlowRTCLinkSession", th.getMessage(), th);
        int r134 = cf9.b.f23547a;
        r126 = cf9.b.a(MessageSendErrorCode.SERIALIZATION_FAILED, r115);
        goto L18
    L100:
        throw th;
    L14:
        if (r115 == MessageSendType.Control) goto L101;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L20;
        int r135 = cf9.b.f23547a;
        r126 = cf9.b.a(MessageSendErrorCode.UNSUPPORTED_MESSAGE_TYPE, r115);
        goto L18
    L20:
        throw new UnsupportedOperationException("Cannot send message which type is " + r115.getDesc() + " by specified tunnel");
    }

    @Override // ue9.i
    public final void l(ue9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        r100.a(this.F);
        if (this.f349261y.f349235h == false) goto L5;
        r.b(r100, "OTHER_EVENT_CALL_DISCONNECTED_WITH_RETRY_TOAST", null);
    L5:
        this.G.add(r100);
    }

    @Override // ue9.i
    public final void m(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if ((r100 instanceof ue9.c) == true) goto L5;
        return;
    L5:
        gf9.a.f481074a.d(this.f349238b);
    }

    @Override // ff9.o
    public final void setBluetoothForceToMedia(boolean r100) {
        ((com.larus.im.internal.rtcsdk.impl.s) d()).i(r100);
    }

    public final ff9.k v(boolean r100) {
        if (this.f349237a.f349332c == RTCConnectionType.TokenPoolWithRTCMerge) goto L5;
        return null;
    L5:
        byte[] r101 = this.B;
        if (r101 == null) goto L35;
        zd9.h r102 = zd9.h.f571481a;
        boolean r103 = true;
        com.larus.im.internal.network.link.impl.rtc.b r104 = u(this, r100, 1);
        String r105 = Base64.encodeToString(r101, 0);
        if (r105 != null) goto L10;
    L15:
        List r106 = null;
    L16:
        com.larus.im.internal.network.link.impl.rtc.j r107 = new com.larus.im.internal.network.link.impl.rtc.j(r104, r106, true);
        r102.getClass();
        String r108 = zd9.h.c(r107);
        if (r108 != null) goto L19;
    L22:
        if (r103 == false) goto L24;
        return null;
    L24:
        w.b r109 = w.j().f348359d;
        if (r109 == null) goto L27;
        int r110 = r109.f348316e;
    L28:
        long r111 = RangesKt.coerceAtLeast(r110, 0);
        com.larus.im.internal.network.link.impl.rtc.g r112 = this.f349245i;
        if (r112 == null) goto L31;
        long r113 = r112.d(SystemClock.elapsedRealtime());
    L33:
        return new ff9.k(r108, (int) RangesKt.coerceAtMost(Math.min(r111, r113), SieveCacheKt.NodeLinkMask));
    L31:
        r113 = r111;
        goto L33
    L27:
        r110 = 72000;
        goto L28
    L19:
        if (r108.length() == 0) goto L22;
        r103 = false;
        goto L22
    L10:
        if ((!StringsKt.isBlank(r105)) == true) goto L13;
        r105 = null;
    L13:
        if (r105 == null) goto L15;
        r106 = CollectionsKt.listOf(r105);
        goto L16
    L35:
        throw new IllegalStateException("start session message is null");
    }

    public final com.larus.im.internal.network.link.impl.rtc.g z(long r100) {
        Object r101 = this.f349243g;
        monitor-enter(r101);
        com.larus.im.internal.network.link.impl.rtc.g r102 = this.f349245i;     // Catch: Throwable -> L17
        if (r102 == null) goto L7;
    L15:
        monitor-exit(r101);
        return r102;
    L7:
        if (this.f349237a.f349332c != RTCConnectionType.TokenPoolWithRTCMerge) goto L9;
        boolean r103 = true;
    L10:
        w.b r104 = w.j().f348359d;     // Catch: Throwable -> L17
        if (r104 == null) goto L13;
        int r105 = r104.f348316e;     // Catch: Throwable -> L17
    L14:
        r102 = new com.larus.im.internal.network.link.impl.rtc.g(r103, r100, r105);     // Catch: Throwable -> L17
        this.f349245i = r102;     // Catch: Throwable -> L17
        goto L15
    L13:
        r105 = 72000;
        goto L14
    L9:
        r103 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public static void R(String r100, Object r101) {
        if (Result.m9456isSuccessimpl(r101) == true) goto L5;
    L15:
        JSONObject r102 = new JSONObject();
        r102.put("room_id", r100);
        if (Result.m9455isFailureimpl(r101) == false) goto L18;
        r101 = null;
    L18:
        com.larus.im.internal.utils.v.a r103 = (com.larus.im.internal.utils.v.a) r101;
        if (r103 != null) goto L21;
        r102.put("status", 0);
        r102.put("fallback_level", "none");
    L22:
        d1.f348206b.a("flow_av_fallback_get_did_status", com.flow.kmp.common.util.e.b(r102));
        return;
    L21:
        r102.put("status", 1);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_DID, r103.f350561b);
        r102.put("fallback_level", r103.f350560a);
        goto L22
    L5:
        if (Result.m9455isFailureimpl(r101) == false) goto L7;
        Object r104 = null;
    L8:
        com.larus.im.internal.utils.v.a r105 = (com.larus.im.internal.utils.v.a) r104;
        if (r105 == null) goto L11;
        String r106 = r105.f350560a;
    L13:
        if (Intrinsics.areEqual(r106, "nothing") == false) goto L15;
        return;
    L11:
        r106 = null;
        goto L13
    L7:
        r104 = r101;
        goto L8
    }

    public static final void p(FlowRTCLinkSession r100, com.larus.im.internal.network.link.impl.rtc.h r101) {
        if (r100.f349255s.get() == false) goto L5;
    L51:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] skip executed retry, destroyed: " + r100.f349255s.get() + ", state: " + r100.F);
        return;
    L5:
        if (r100.f349249m == true) goto L51;
        Object r102 = r100.f349243g;
        monitor-enter(r102);
        boolean r103 = false;
        if (r100.f349250n == r101) goto L13;
        boolean r104 = true;
    L14:
        monitor-exit(r102);
        if (r104 == false) goto L18;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] skip stale retry, reason: " + r101.f349315a.getValue() + ", traceId: " + r100.f349238b);
        return;
    L18:
        if (SystemClock.elapsedRealtime() >= r101.f349321g) goto L20;
        r103 = true;
    L20:
        if (r103 == true) goto L29;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] skip expired retry, reason: " + r101.f349315a.getValue() + ", traceId: " + r100.f349238b);
        RTCConnectRetryReason r105 = r101.f349315a;
        if (r105 != RTCConnectRetryReason.START_SESSION_FAILED) goto L24;
    L27:
        ue9.c r106 = ue9.c.m.f549857c;
    L28:
        r100.I(r105, r106);
        return;
    L24:
        if (r105 == RTCConnectRetryReason.SESSION_STARTED_TIMEOUT) goto L27;
        r106 = ue9.c.e.f549849c;
        goto L28
    L29:
        int r107 = d.f349268b[r101.f349318d.ordinal()];
        if (r107 != 1) goto L32;
        s r108 = r100.f349259w;
        if (r108 == null) goto L39;
        int r109 = r108.i();
    L40:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] resend startSession result: " + r109 + ", reason: " + r101.f349315a.getValue() + ", traceId: " + r100.f349238b);
        if (r100.U(r101) == true) goto L61;
        if (r109 < 0) goto L45;
        r100.T();
        return;
    L45:
        RTCConnectRetryReason r110 = RTCConnectRetryReason.START_SESSION_FAILED;
        if (r100.W(r110) == true) goto L59;
        r100.I(r110, ue9.c.m.f549857c);
        return;
    L59:
        return;
    L61:
        return;
    L39:
        r109 = -1;
        goto L40
    L32:
        if (r107 != 2) goto L35;
        r100.O(r101);
        return;
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        r104 = false;
    L48:
        th = move-exception;
        throw th;
    }

    public static final void q(FlowRTCLinkSession r100, ByteBuffer r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.isDirect() == true) goto L6;
        ByteBuffer r102 = ByteBuffer.allocateDirect(r101.capacity());
        r102.put(r101);
        r101 = r102;
    L6:
        Iterator<ue9.d> r103 = r100.G.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().b(r101);
        goto L8
    }

    public static final void s(FlowRTCLinkSession r100, String r101) {
        r100.getClass();
        if (H() == false) goto L5;
        r100.N(r101 + "_active_network_available");
        return;
    L5:
        Object r102 = r100.f349243g;
        monitor-enter(r102);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (r100.f349251o != null) goto L10;
        Job r103 = null;
    L11:
        monitor-exit(r102);
        if (r103 == null) goto L14;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L14:
        if (r103 == null) goto L23;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectRetry] network lost during debounce, source: " + r101 + ", traceId: " + r100.f349238b);
        return;
    L23:
        return;
    L10:
        r103 = r100.f349246j;     // Catch: Throwable -> L17
        r100.f349246j = null;     // Catch: Throwable -> L17
        goto L11
    }

    public final void I(RTCConnectRetryReason r100, ue9.c r101) {
        if (this.f349253q.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Object r102 = this.f349243g;
        monitor-enter(r102);
        com.larus.im.internal.network.link.impl.rtc.g r103 = this.f349245i;     // Catch: Throwable -> L18
        if (r103 == null) goto L10;
        r103.b();     // Catch: Throwable -> L18
    L10:
        List r104 = CollectionsKt.listOfNotNull(new Job[]{this.f349246j, this.f349247k, this.f349248l});     // Catch: Throwable -> L18
        this.f349246j = null;     // Catch: Throwable -> L18
        this.f349247k = null;     // Catch: Throwable -> L18
        this.f349248l = null;     // Catch: Throwable -> L18
        monitor-exit(r102);
        w();
        Iterator r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        Job.DefaultImpls.cancel$default((Job) r105.next(), null, 1, null);
        goto L14
    L16:
        fe9.a.f476620a.b("FlowRTCLinkSession", "[ConnectRetry] retry exhausted, reason: " + r100.getValue() + ", error: " + r101 + ", traceId: " + this.f349238b);
        C(RTCEstablishReportScene.NORMAL, SystemClock.elapsedRealtime(), new h(this));
        m(r101);
        J(new ue9.b.c(r101, null, null, 6));
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void L(String r100, Object r101) {
        Iterator<ue9.d> r102 = this.G.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ue9.d r103 = r102.next();
        Intrinsics.checkNotNull(r103);
        r.b(r103, r100, r101);
        goto L4
    }

    public final boolean Q(s r100, String r101) {
        if (this.f349255s.get() == true) goto L6;
        return false;
    L6:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[connect] session destroyed before join room, release created room: ".concat(r101));
        F().g(r101, this.f349257u);
        r100.leaveRoom();
        if (this.f349259w != r100) goto L11;
        this.f349259w = null;
        return true;
    L11:
        return true;
    }

    public final c V(com.larus.im.internal.network.link.impl.rtc.h r100, Job r101) {
        Object r102 = this.f349243g;
        monitor-enter(r102);
        c r103 = null;
        if (r100 != null) goto L27;
    L9:
        if (r101 == null) goto L14;
        if (this.f349246j == r101) goto L14;
    L22:
        monitor-exit(r102);
        return r103;
    L14:
        if (this.f349251o == null) goto L16;
    L20:
        c r104 = new c(this.f349246j, this.f349248l, this.f349252p);     // Catch: Throwable -> L24
        this.f349251o = null;     // Catch: Throwable -> L24
        this.f349246j = null;     // Catch: Throwable -> L24
        this.f349248l = null;     // Catch: Throwable -> L24
        this.f349252p = null;     // Catch: Throwable -> L24
        r103 = r104;
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.f349248l != null) goto L20;
        if (this.f349252p != null) goto L20;
    L27:
        if (this.f349251o == r100) goto L9;
        goto L9
    }

    public final void y(c r100, Job r101) {
        Job r102 = r100.f349264a;
        Unit r103 = null;
        if (r102 == r101) goto L6;
        if (r102 == null) goto L6;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L6:
        Job r104 = r100.f349265b;
        if (r104 == r101) goto L10;
        if (r104 == null) goto L10;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L10:
        ConnectivityManager.NetworkCallback r105 = r100.f349266c;
        if (r105 == null) goto L25;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        ConnectivityManager r107 = x();     // Catch: Throwable -> L17
        if (r107 == null) goto L15;
        r107.unregisterNetworkCallback(r105);     // Catch: Throwable -> L17
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
    L19:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        fe9.a.f476620a.c("FlowRTCLinkSession", "[ConnectRetry] unregister network recovery callback failed, traceId: " + this.f349238b, r109);
        return;
    L26:
        return;
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static com.larus.im.internal.network.link.impl.rtc.b u(FlowRTCLinkSession r210, boolean r211, int r212) {
        boolean r100 = false;
        if ((r212 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if (r210.f349237a.a() == true) goto L18;
        w.l r103 = w.j().f348356a;
        if (r103 == null) goto L15;
        boolean r104 = r103.f348408e;
    L16:
        if (r104 == false) goto L18;
        String r105 = "pcm";
    L19:
        w.l r106 = w.j().f348356a;
        Map r107 = null;
        if (r106 == null) goto L24;
        String r108 = r106.f348416m;
        if (r108 == null) goto L24;
        String r109 = StringsKt.trim(r108).toString();
    L25:
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        if (r210.f349237a.a() == false) goto L30;
    L35:
        boolean r110 = false;
    L36:
        if (r110 == true) goto L40;
        r109 = null;
    L40:
        if (r210.f349237a.a() == true) goto L47;
        w.l r111 = w.j().f348356a;
        if (r111 == null) goto L44;
        boolean r112 = r111.f348408e;
    L45:
        if (r112 == false) goto L47;
    L51:
        boolean r113 = true;
    L53:
        if (r210.f349237a.a() == true) goto L62;
        w.l r114 = w.j().f348356a;
        if (r114 != null) goto L57;
    L59:
        boolean r115 = false;
    L60:
        if (r115 == false) goto L62;
        boolean r116 = true;
    L63:
        String r117 = r210.f349237a.f349331b;
        Boolean r118 = Boolean.TRUE;
        Boolean r119 = Boolean.valueOf(r210.f349239c);
        if (r109 != null) goto L66;
        String r120 = r105;
    L68:
        if (r101 == true) goto L71;
    L84:
        Map r121 = r107;
        String r122 = r210.f349237a.f349335f;
        if (r116 == true) goto L89;
        if (r113 == true) goto L89;
    L91:
        return new com.larus.im.internal.network.link.impl.rtc.b(r117, r118, r119, r118, 1, r120, "", r121, r122, Boolean.valueOf(r100));
    L89:
        r100 = true;
        goto L91
    L71:
        if (r210.f349237a.a() == false) goto L73;
    L85:
        r107 = (Map) w.f348285u.getValue();
        goto L84
    L73:
        if (r210.f349237a.a() == true) goto L79;
        w.l r123 = w.j().f348356a;
        if (r123 == null) goto L77;
        boolean r124 = r123.f348408e;
    L78:
        if (r124 == true) goto L85;
    L77:
        r124 = false;
    L79:
        if (r102 == true) goto L85;
        if (r116 == true) goto L85;
        if (Intrinsics.areEqual(r210.f349237a.f349337h, r118) == false) goto L84;
    L66:
        r120 = r109;
        goto L68
    L57:
        if (r114.f348415l != true) goto L59;
        r115 = true;
    L62:
        r116 = false;
        goto L63
    L44:
        r112 = false;
    L47:
        if (Intrinsics.areEqual(r210.f349237a.f349337h, Boolean.TRUE) == true) goto L51;
        if (r102 == true) goto L51;
        r113 = false;
        goto L53
    L30:
        if (r109.length() <= 0) goto L32;
        boolean r125 = true;
    L33:
        if (r125 == false) goto L35;
        r110 = true;
        goto L36
    L32:
        r125 = false;
    L24:
        r109 = null;
        goto L25
    L15:
        r104 = false;
    L18:
        r105 = "opus";
        goto L19
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public final void C(RTCEstablishReportScene r100, long r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (this.f349242f == true) goto L10;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectOpt][finishRTCConnectOnce] gate disabled, report directly, traceId: " + this.f349238b + ", scene: " + r100);
        if (r102 == null) goto L7;
        r102.invoke();
    L7:
        gf9.a.f481074a.b(this.f349238b, r100, r101);
        return;
    L10:
        if (this.f349241e.f349305a.compareAndSet(false, true) == true) goto L13;
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectOpt][finishRTCConnectOnce] already finalized, traceId: " + this.f349238b + ", scene: " + r100);
        return;
    L13:
        fe9.a.f476620a.e("FlowRTCLinkSession", "[ConnectOpt][finishRTCConnectOnce] finalized, traceId: " + this.f349238b + ", scene: " + r100);
        if (r102 == null) goto L16;
        r102.invoke();
    L16:
        gf9.a.f481074a.b(this.f349238b, r100, r101);
    }

    public final void K(final jf9.f r100, final AVCommonError r101, ue9.c r102) {
        fe9.a.f476620a.b("FlowRTCLinkSession", "[ConnectOpt][notifyError] traceId: " + this.f349238b + ", errorCode: " + r101.getCode() + ", subErrorCode: " + r101.getSubCode() + ", bizError: " + r102);
        C(RTCEstablishReportScene.NORMAL, SystemClock.elapsedRealtime(), new m(r100, r101));
        m(r102);
        J(new ue9.b.c(r102, null, null, 6));
    }

    @Override // ff9.o
    public final void g(int r100, int r101, he9.a r102) {
        ff9.c r103 = new ff9.c(AudioRenderType.AUDIO_RENDER_TYPE_INTERNAL, r100, r101, r102);
        ((com.larus.im.internal.rtcsdk.impl.s) d()).k(r103);
    }

    @Override // ff9.o
    public final void n(int r110, int r111, AudioEncodeType r112) {
        Intrinsics.checkNotNullParameter(r112, "encodeType");
        ff9.b r100 = new ff9.b(AudioSourceType.AUDIO_SOURCE_TYPE_EXTERNAL, r110, r111, null, r112, null, null, null, null, null, null, DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE);
        ((com.larus.im.internal.rtcsdk.impl.s) d()).j(r100);
    }

    @Override // ff9.o
    public final void j(int r110, int r111, int r112, he9.a r113, t r114, AvAecType r210, String r211, AvAecOutputType r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "aecType");
        Intrinsics.checkNotNullParameter(r211, "speechAecModelPath");
        Intrinsics.checkNotNullParameter(r212, "speechAecOutputType");
        Intrinsics.checkNotNullParameter(r213, "speechAecDumpPath");
        ff9.b r100 = new ff9.b(AudioSourceType.AUDIO_SOURCE_TYPE_INTERNAL, r110, r111, Integer.valueOf(r112), null, r113, r114, r210, r211, r212, r213, 16);
        ((com.larus.im.internal.rtcsdk.impl.s) d()).j(r100);
    }
}
