package com.larus.avlink.activeSummary;

import android.os.SystemClock;
import com.larus.applog.api.IApplog;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.model.ProactiveSummaryScene;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.platform.service.AccountService;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class ProactiveSummaryModel {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f291421g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f291422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f291423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f291424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f291425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f291426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReentrantLock f291427f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f291428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f291429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FailReason f291430c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f291428a == r101.f291428a) goto L12;
            return false;
        L12:
            if (this.f291429b == r101.f291429b) goto L15;
            return false;
        L15:
            if (this.f291430c == r101.f291430c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f291428a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f291429b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f291430c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "SystemNotifyValidationResult(canBroadcast=" + this.f291428a + ", shouldDelay=" + this.f291429b + ", failReason=" + this.f291430c + ')';
        }

        public /* synthetic */ b() {
            this(true, false, FailReason.UNKNOWN);
        }

        public b(boolean r100, boolean r101, FailReason r102) {
            Intrinsics.checkNotNullParameter(r102, "failReason");
            this.f291428a = r100;
            this.f291429b = r101;
            this.f291430c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f291431a = null;

        static {
            int[] r100 = new int[ProactiveSummarySource.values().length];
            r100[ProactiveSummarySource.PUSH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ProactiveSummarySource.SSE_FRONTIER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ProactiveSummarySource.IM_FRONTIER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f291431a = r100;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProactiveSummaryModel f291432a;

        public d(CoroutineExceptionHandler.Key r100, ProactiveSummaryModel r101) {
            this.f291432a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            this.f291432a.f291423b = false;
            n1.b("ProactiveSummaryRecords", "[NotificationTracer] CoroutineExceptionHandler throwable: " + r101);
        }
    }

    static {
    }

    public ProactiveSummaryModel() {
        this.f291426e = new d(CoroutineExceptionHandler.Key, this);
        this.f291427f = new ReentrantLock();
    }

    public static String c(ProactiveSummarySource r100) {
        int r101 = c.f291431a[r100.ordinal()];
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L14;
        return ProactiveSummarySource.UNKNOWN.getValue();
    L14:
        return ProactiveSummarySource.IM_FRONTIER_CACHE.getValue();
    L15:
        return ProactiveSummarySource.SSE_FRONTIER_CACHE.getValue();
    L12:
        return ProactiveSummarySource.PUSH_CACHE.getValue();
    }

    public static Unit g(f r210, ProactiveSummarySource r211) {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        Integer r101 = null;
        if (r100 == null) goto L5;
        DeviceService r102 = r100.device();
    L6:
        boolean r103 = true;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r102 == null) goto L16;
        Integer r105 = r102.r();
        if (r105 == null) goto L16;
        int r106 = r105.intValue();
    L18:
        if (r102 == null) goto L22;
        Integer r107 = r102.q();
        if (r107 == null) goto L22;
        int r108 = r107.intValue();
    L24:
        if ((r106 & 2) == 0) goto L26;
        boolean r109 = true;
    L27:
        IDoraService r110 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r110 == null) goto L34;
        SessionService r111 = r110.d();
        if (r111 == null) goto L34;
        if (r111.f337983a != true) goto L34;
        boolean r112 = true;
    L35:
        if (r112 == false) goto L37;
    L40:
        boolean r113 = true;
    L41:
        com.larus.avlink.activeSummary.b r114 = r210.f291462d;
        if (r114 == null) goto L44;
        int r115 = r114.f291449a;
    L45:
        if (r115 <= 0) goto L47;
        boolean r116 = true;
    L49:
        if (r104 == false) goto L100;
        if (r109 == true) goto L100;
        if (r113 == true) goto L100;
        if ((r106 & 1) == 0) goto L56;
        boolean r117 = true;
    L57:
        if (r117 == true) goto L59;
        b r118 = new b();
    L113:
        if (r118.f291428a == false) goto L116;
        return null;
    L116:
        if (r118.f291429b == false) goto L122;
        StringBuilder r119 = new StringBuilder("Delay system notify summary due to client state. summaryId=");
        r119.append(r210.f291459a);
        r119.append(", scene=");
        r119.append(r210.f291460b);
        r119.append(", subScene=");
        r119.append(r210.f291461c);
        r119.append(", source=");
        r119.append(r211);
        r119.append(", avoidTimestamp=");
        com.larus.avlink.activeSummary.b r120 = r210.f291462d;
        if (r120 == null) goto L120;
        r101 = Integer.valueOf(r120.f291449a);
    L120:
        r119.append(r101);
        r119.append(", reason=");
        r119.append(r118.f291430c.getValue());
        n1.d("ProactiveSummaryRecords", r119.toString());
        k<f> r121 = n.f291489a;
        n.a(c(r211), r210);
        return Unit.INSTANCE;
    L122:
        k<f> r122 = n.f291489a;
        n.h(r210.f291459a, String.valueOf(r210.f291460b), r210.f291461c, r211.getValue(), ProactiveSummaryStartVuiStatus.FAIL, r118.f291430c, r210.b());
        n1.d("ProactiveSummaryRecords", "Abandon system notify summary due to client state. summaryId=" + r210.f291459a + ", scene=" + r210.f291460b + ", subScene=" + r210.f291461c + ", source=" + r211 + ", reason=" + r118.f291430c.getValue());
        return Unit.INSTANCE;
    L59:
        String r123 = r210.f291467i;
        if (r123 != null) goto L65;
        Map<String, String> r124 = r210.f291468j;
        if (r124 == null) goto L64;
        r123 = r124.get("priority_broadcast_switch");
        goto L65
    L64:
        r123 = null;
    L65:
        if (r123 == null) goto L67;
        Boolean r125 = Boolean.valueOf(Intrinsics.areEqual(r123, "1"));
    L68:
        if (r125 != null) goto L75;
        IDoraService r126 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r126 == null) goto L73;
        r125 = Boolean.valueOf(r126.Q(AccountService.f365697a.getUserId()));
    L74:
        if (r125 != null) goto L75;
        boolean r127 = true;
    L77:
        if (r108 == (-1)) goto L79;
        boolean r128 = true;
    L81:
        if ((r108 & 1) != 0) goto L84;
        r103 = false;
    L84:
        if (r127 == true) goto L86;
        FailReason r129 = FailReason.PRIORITY_SWITCH_OFF;
    L92:
        if (r129 != FailReason.PRIORITY_SWITCH_OFF) goto L94;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=" + r210.f291461c + " [a2dp:" + r117 + "] [pbs:" + r127 + ']');
        b r130 = new b(false, r116, r129);
    L111:
        r118 = r130;
        goto L113
    L94:
        if (r128 == true) goto L96;
        r118 = new b();
        goto L113
    L96:
        boolean r131 = !r103;
        if (r129 != FailReason.PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED) goto L99;
        n1.d("ProactiveSummaryRecords", "[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=" + r210.f291461c + " [a2dp:" + r117 + "] [pbs:" + r127 + "] [curr device a2dp:" + r103 + "] [other a2dp:" + r131 + ']');
        r130 = new b(false, r116, r129);
        goto L111
    L99:
        r118 = new b();
        goto L113
    L86:
        if (r128 == false) goto L90;
        if (r103 == true) goto L90;
        r129 = FailReason.PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED;
    L90:
        r129 = null;
        goto L92
    L79:
        r128 = false;
        goto L81
    L73:
        r125 = null;
    L75:
        r127 = r125.booleanValue();
        goto L77
    L67:
        r125 = null;
        goto L68
    L56:
        r117 = false;
    L100:
        StringBuilder r132 = new StringBuilder("[NotificationTracer][SystemNotify] dora curr-status not meet. subScene=");
        r132.append(r210.f291461c);
        r132.append(" [cs:");
        r132.append(r104);
        r132.append("] [a2dp:");
        if ((r106 & 1) != 0) goto L104;
        r103 = false;
    L104:
        r132.append(r103);
        r132.append("] [hfp:");
        r132.append(r109);
        r132.append("] [mo:");
        r132.append(r113);
        r132.append(']');
        n1.d("ProactiveSummaryRecords", r132.toString());
        if (r109 == false) goto L107;
        FailReason r133 = FailReason.HFP_OCCUPIED;
    L110:
        r130 = new b(false, r116, r133);
        goto L111
    L107:
        if (r113 == false) goto L109;
        r133 = FailReason.VUI_DISABLED;
        goto L110
    L109:
        r133 = FailReason.AUDIO_CONFLICTS;
        goto L110
    L47:
        r116 = false;
        goto L49
    L44:
        r115 = 0;
        goto L45
    L37:
        if (AudioServiceDelegate.f288288a.P().isRecording() == true) goto L40;
        r113 = false;
    L34:
        r112 = false;
        goto L35
    L26:
        r109 = false;
    L22:
        r108 = -1;
    L16:
        r106 = 0;
        goto L18
    L9:
        if (r102.J() != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void d(String r100, ProactiveSummarySource r110) {
        Intrinsics.checkNotNullParameter(r100, "summaryId");
        Intrinsics.checkNotNullParameter(r110, "source");
        n1.d("ProactiveSummaryRecords", "receive proactive summary from " + r110.getValue() + ", summaryId is " + r100);
        if (c98.c.a() == false) goto L6;
        n1.d("ProactiveSummaryRecords", "Abandon this fetch because of isDoraCallDegrade");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ProactiveSummaryModel$fetchInfoFromId$1(r100, r110, this, null), 2, null);
    }

    public final void e(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r110, "content");
        n1.d("ProactiveSummaryRecords", "receive DouBao push title is " + r100 + ", content is " + r110);
        if (c98.c.a() == false) goto L6;
        n1.d("ProactiveSummaryRecords", "Abandon this fetch because of isDoraCallDegrade");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ProactiveSummaryModel$fetchInfoFromPush$1(r100, r110, this, null), 2, null);
    }

    public final void h(String r100, boolean r110) {
        if (SystemClock.elapsedRealtime() < this.f291424c) goto L7;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r100 + ": exceed sseCloseTimestamp, return....");
        return;
    L7:
        if (this.f291423b == false) goto L12;
        if (r110 == true) goto L10;
        this.f291425d = true;
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r100 + ": isSSEConnecting, mark reconnect after done....");
        return;
    L10:
        n1.a("ProactiveSummaryRecords", "[NotificationTracer] receiveStreamForNotificationSummary trigger:" + r100 + ": isSSEConnecting, return....");
        return;
    L12:
        this.f291423b = true;
        if (r110 == true) goto L15;
        this.f291422a = 0;
    L15:
        JSONObject r111 = new JSONObject();
        IApplog.Companion r101 = IApplog.f287053a;
        r111.put("device_id", r101.getDeviceId());
        r111.put("user_id", r101.getUserID());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO().plus(this.f291426e), null, new ProactiveSummaryModel$receiveStreamForProactiveNotificationSummary$1(r100, r111, this, null), 2, null);
    }

    public static final void a(ProactiveSummaryModel r210, f r310, ProactiveSummarySource r311) {
        ReentrantLock r100 = r210.f291427f;
        r100.lock();
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L231
        if (r101 == null) goto L10;
        SessionService r102 = r101.d();     // Catch: Throwable -> L231
        if (r102 == null) goto L10;
        if (r102.f337983a != true) goto L10;
        boolean r103 = true;
    L11:
        IDoraService r110 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L231
        if (r110 == null) goto L19;
        DeviceService r111 = r110.device();     // Catch: Throwable -> L231
        if (r111 == null) goto L19;
        Integer r112 = r111.r();     // Catch: Throwable -> L231
        if (r112 == null) goto L19;
        int r113 = r112.intValue();     // Catch: Throwable -> L231
    L20:
        IFlowTtsClientService.f288300a.getClass();     // Catch: Throwable -> L231
        boolean r114 = IFlowTtsClientService.a.a().a();     // Catch: Throwable -> L231
        IDoraAVLinkService r115 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L231
        if (r115 != null) goto L23;
    L25:
        boolean r116 = false;
    L26:
        Integer r117 = r310.f291460b;     // Catch: Throwable -> L231
        int r104 = ProactiveSummaryScene.Remind.getValue();     // Catch: Throwable -> L231
        ReentrantLock r211 = r100;
        Object r212 = null;
        if (r117 != null) goto L235;
    L75:
        int r105 = ProactiveSummaryScene.News.getValue();     // Catch: Throwable -> L54
        if (r117 != null) goto L80;
    L124:
        Integer r106 = r310.f291460b;     // Catch: Throwable -> L54
        int r107 = ProactiveSummaryScene.SystemNotify.getValue();     // Catch: Throwable -> L54
        if (r106 != null) goto L128;
    L147:
        Integer r108 = r310.f291460b;     // Catch: Throwable -> L54
        int r109 = ProactiveSummaryScene.Music.getValue();     // Catch: Throwable -> L54
        if (r108 != null) goto L151;
    L152:
        Integer r118 = r310.f291460b;     // Catch: Throwable -> L54
        int r119 = ProactiveSummaryScene.ProactiveMsg.getValue();     // Catch: Throwable -> L54
        if (r118 != null) goto L156;
    L177:
        if (r310.f() == true) goto L183;
        if (r310.g() == true) goto L183;
        if (r310.e() == true) goto L183;
    L185:
        if (r103 == false) goto L187;
    L194:
        k<f> r120 = n.f291489a;     // Catch: Throwable -> L54
        n.h(r310.f291459a, String.valueOf(r310.f291460b), r310.f291461c, r311.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.AUDIO_CONFLICTS, r310.b());     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", "Abandon this push because in handleAudioConflicts due to switch status: isRealTimeCall: " + r103 + ", isTtsPlayer: " + r114 + ", isDoraCall: " + r116 + ", idleState is " + r113 + " summaryId is " + r310.f291459a + ", scene is " + r310.f291460b + ", source is " + r311);     // Catch: Throwable -> L54
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L195:
        r211.unlock();
        return;
    L187:
        if (r113 == 2) goto L194;
        if (r114 == true) goto L194;
        if (r116 == true) goto L194;
        if (AudioServiceDelegate.f288288a.P().isRecording() == true) goto L194;
        k<f> r122 = n.f291489a;     // Catch: Throwable -> L54
        n.d(r310.f291459a, String.valueOf(r310.f291460b), r310.f291461c, r311.getValue(), r310.f291464f, false, r310.b(), r310.d(), r310.a());     // Catch: Throwable -> L54
    L183:
        if (g(r310, r311) == null) goto L185;
        r211.unlock();
        return;
    L156:
        if (r118.intValue() != r119) goto L177;
    L157:
        IDoraService r123 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r123 != null) goto L160;
    L164:
        boolean r124 = false;
    L165:
        if (r124 == false) goto L196;
        IDoraService r125 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r125 == null) goto L173;
        DeviceService r126 = r125.device();     // Catch: Throwable -> L54
        if (r126 == null) goto L173;
        if (r126.D() != true) goto L173;
        boolean r127 = true;
    L174:
        if (r127 == true) goto L177;
    L173:
        r127 = false;
    L196:
        k<f> r128 = n.f291489a;     // Catch: Throwable -> L54
        n.h(r310.f291459a, r310.f291460b.toString(), r310.f291461c, r311.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.EXPERIMENT_OR_SWITCH_OFF, r310.b());     // Catch: Throwable -> L54
        StringBuilder r129 = new StringBuilder("Abandon this push because in handleAudioConflicts due to switch status: isNLFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r130 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r130 != null) goto L199;
    L203:
        boolean r131 = false;
    L204:
        r129.append(r131);     // Catch: Throwable -> L54
        r129.append(", isNLFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r132 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r132 != null) goto L207;
    L211:
        boolean r133 = false;
    L212:
        r129.append(r133);     // Catch: Throwable -> L54
        r129.append(", isAIPushFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r134 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r134 != null) goto L215;
    L219:
        boolean r135 = false;
    L220:
        r129.append(r135);     // Catch: Throwable -> L54
        r129.append(", isAIPushFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r136 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r136 == null) goto L227;
        DeviceService r137 = r136.device();     // Catch: Throwable -> L54
        if (r137 == null) goto L227;
        if (r137.D() != true) goto L227;
        boolean r138 = true;
    L228:
        r129.append(r138);     // Catch: Throwable -> L54
        r129.append(", summaryId is ");     // Catch: Throwable -> L54
        r129.append(r310.f291459a);     // Catch: Throwable -> L54
        r129.append(", scene is ");     // Catch: Throwable -> L54
        r129.append(r310.f291460b);     // Catch: Throwable -> L54
        r129.append(", source is ");     // Catch: Throwable -> L54
        r129.append(r311);     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r129.toString());     // Catch: Throwable -> L54
        r211.unlock();
        return;
    L227:
        r138 = false;
        goto L228
    L215:
        if (r134.device() == null) goto L219;
        if (com.larus.dora.impl.nl.n.a() != true) goto L219;
        r135 = true;
        goto L220
    L207:
        if (r132.device() == null) goto L211;
        if (com.larus.dora.impl.nl.n.c() != true) goto L211;
        r133 = true;
        goto L212
    L199:
        if (r130.device() == null) goto L203;
        if (com.larus.dora.impl.nl.n.b() != true) goto L203;
        r131 = true;
        goto L204
    L160:
        if (r123.device() == null) goto L164;
        if (com.larus.dora.impl.nl.n.a() != true) goto L164;
        r124 = true;
        goto L165
    L151:
        if (r108.intValue() == r109) goto L157;
    L128:
        if (r106.intValue() != r107) goto L147;
        IDoraService r139 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r139 != null) goto L132;
    L136:
        boolean r140 = false;
    L137:
        if (r140 == false) goto L196;
        IDoraService r141 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r141 != null) goto L141;
    L145:
        boolean r142 = false;
    L146:
        if (r142 == false) goto L196;
    L141:
        if (r141.device() == null) goto L145;
        if (com.larus.dora.impl.nl.n.c() != true) goto L145;
        r142 = true;
        goto L146
    L132:
        if (r139.device() == null) goto L136;
        if (com.larus.dora.impl.nl.n.b() != true) goto L136;
        r140 = true;
        goto L137
    L80:
        if (r117.intValue() != r105) goto L124;
        IDoraService r143 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r143 == null) goto L88;
        DeviceService r144 = r143.device();     // Catch: Throwable -> L54
        if (r144 == null) goto L88;
        if (r144.D() != true) goto L88;
        boolean r145 = true;
    L89:
        if (r145 == false) goto L111;
        IDoraService r146 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r146 != null) goto L93;
    L97:
        boolean r147 = false;
    L98:
        if (r147 == false) goto L111;
        if (r103 == false) goto L102;
    L107:
        StringBuilder r148 = new StringBuilder("currently not available for playback, temporarily cached. summaryId is ");     // Catch: Throwable -> L54
        r148.append(r310.f291459a);     // Catch: Throwable -> L54
        r148.append(", scene is ");     // Catch: Throwable -> L54
        r148.append(r310.f291460b);     // Catch: Throwable -> L54
        r148.append(", avoidTimestamp is ");     // Catch: Throwable -> L54
        com.larus.avlink.activeSummary.b r149 = r310.f291462d;     // Catch: Throwable -> L54
        if (r149 == null) goto L110;
        r212 = Integer.valueOf(r149.f291449a);     // Catch: Throwable -> L54
    L110:
        r148.append(r212);     // Catch: Throwable -> L54
        r148.append(", isRealTimeCall is ");     // Catch: Throwable -> L54
        r148.append(r103);     // Catch: Throwable -> L54
        r148.append(", isDoraCall is ");     // Catch: Throwable -> L54
        r148.append(r116);     // Catch: Throwable -> L54
        r148.append(", isTtsPlayer is ");     // Catch: Throwable -> L54
        r148.append(r114);     // Catch: Throwable -> L54
        r148.append(" idleState is ");     // Catch: Throwable -> L54
        r148.append(r113);     // Catch: Throwable -> L54
        r148.append(", source is ");     // Catch: Throwable -> L54
        r148.append(r311);     // Catch: Throwable -> L54
        r148.append(' ');     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r148.toString());     // Catch: Throwable -> L54
        k<f> r150 = n.f291489a;     // Catch: Throwable -> L54
        n.a(c(r311), r310);     // Catch: Throwable -> L54
        Unit r151 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L102:
        if (r113 == 2) goto L107;
        if (r114 == true) goto L107;
        if (r116 == true) goto L107;
        k<f> r152 = n.f291489a;     // Catch: Throwable -> L54
        n.d(r310.f291459a, r310.f291460b.toString(), r310.f291461c, r311.getValue(), r310.f291464f, false, r310.b(), r310.d(), r310.a());     // Catch: Throwable -> L54
        goto L195
    L93:
        if (r146.device() == null) goto L97;
        if (com.larus.dora.impl.nl.n.a() != true) goto L97;
        r147 = true;
    L111:
        k<f> r153 = n.f291489a;     // Catch: Throwable -> L54
        n.h(r310.f291459a, r310.f291460b.toString(), r310.f291461c, r311.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.EXPERIMENT_OR_SWITCH_OFF, r310.b());     // Catch: Throwable -> L54
        StringBuilder r154 = new StringBuilder("Abandon this push because in handleAudioConflicts due to switch status: isAIPushFeatureUserOpened: ");     // Catch: Throwable -> L54
        IDoraService r155 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r155 == null) goto L116;
        DeviceService r156 = r155.device();     // Catch: Throwable -> L54
        if (r156 == null) goto L116;
        Boolean r157 = Boolean.valueOf(r156.D());     // Catch: Throwable -> L54
    L117:
        r154.append(r157);     // Catch: Throwable -> L54
        r154.append(", isAIPushFeatureEnabled: ");     // Catch: Throwable -> L54
        IDoraService r158 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r158 != null) goto L120;
    L122:
        r154.append(r212);     // Catch: Throwable -> L54
        r154.append(", summaryId is ");     // Catch: Throwable -> L54
        r154.append(r310.f291459a);     // Catch: Throwable -> L54
        r154.append(", scene is ");     // Catch: Throwable -> L54
        r154.append(r310.f291460b);     // Catch: Throwable -> L54
        r154.append(", source is ");     // Catch: Throwable -> L54
        r154.append(r311);     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r154.toString());     // Catch: Throwable -> L54
        r211.unlock();
        return;
    L120:
        if (r158.device() == null) goto L122;
        r212 = Boolean.valueOf(com.larus.dora.impl.nl.n.a());     // Catch: Throwable -> L54
    L116:
        r157 = null;
    L88:
        r145 = false;
        goto L89
    L235:
    L54:
        th = th;
    L233:
        r211.unlock();
        throw th;
    L32:
        if (r117.intValue() != r104) goto L75;
        IDoraService r159 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r159 == null) goto L40;
        DeviceService r160 = r159.device();     // Catch: Throwable -> L54
        if (r160 == null) goto L40;
        if (r160.a() != true) goto L40;
        boolean r161 = true;
    L41:
        if (r161 == false) goto L64;
        if (r116 == false) goto L49;
        IDoraAVLinkService r162 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L54
        if (r162 == null) goto L46;
        Integer r163 = r162.c();     // Catch: Throwable -> L54
    L48:
        if (v88.a.f(r163) == false) goto L49;
    L56:
        StringBuilder r164 = new StringBuilder("Lite: currently not available for playback, temporarily cached. summaryId is ");     // Catch: Throwable -> L54
        r164.append(r310.f291459a);     // Catch: Throwable -> L54
        r164.append(", scene is ");     // Catch: Throwable -> L54
        r164.append(r310.f291460b);     // Catch: Throwable -> L54
        r164.append(", isDora is ");     // Catch: Throwable -> L54
        r164.append(r116);     // Catch: Throwable -> L54
        r164.append(", doraMode is ");     // Catch: Throwable -> L54
        IDoraAVLinkService r165 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);     // Catch: Throwable -> L54
        if (r165 == null) goto L59;
        Integer r166 = r165.c();     // Catch: Throwable -> L54
    L60:
        r164.append(r166);     // Catch: Throwable -> L54
        r164.append("avoidTimestamp is ");     // Catch: Throwable -> L54
        com.larus.avlink.activeSummary.b r167 = r310.f291462d;     // Catch: Throwable -> L54
        if (r167 == null) goto L63;
        r212 = Integer.valueOf(r167.f291449a);     // Catch: Throwable -> L54
    L63:
        r164.append(r212);     // Catch: Throwable -> L54
        r164.append(", isRealTimeCall is ");     // Catch: Throwable -> L54
        r164.append(r103);     // Catch: Throwable -> L54
        r164.append(", idleState is ");     // Catch: Throwable -> L54
        r164.append(r113);     // Catch: Throwable -> L54
        r164.append(", source is ");     // Catch: Throwable -> L54
        r164.append(r311);     // Catch: Throwable -> L54
        r164.append(' ');     // Catch: Throwable -> L54
        n1.d("ProactiveSummaryRecords", r164.toString());     // Catch: Throwable -> L54
        k<f> r168 = n.f291489a;     // Catch: Throwable -> L54
        n.a(c(r311), r310);     // Catch: Throwable -> L54
        Unit r169 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L59:
        r166 = null;
        goto L60
    L46:
        r163 = null;
    L49:
        if (r103 == true) goto L56;
        if (r113 == 2) goto L56;
        k<f> r170 = n.f291489a;     // Catch: Throwable -> L54
        n.d(r310.f291459a, r310.f291460b.toString(), r310.f291461c, r311.getValue(), r310.f291464f, false, r310.b(), r310.d(), r310.a());     // Catch: Throwable -> L54
        goto L195
    L64:
        IDoraService r171 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L54
        if (r171 == null) goto L71;
        DeviceService r172 = r171.device();     // Catch: Throwable -> L54
        if (r172 == null) goto L71;
        if (r172.M() != true) goto L71;
        boolean r173 = true;
    L72:
        if (r173 == false) goto L74;
        f(r103, r113, r114, r116, r310, r311);     // Catch: Throwable -> L54
        Unit r174 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L195
    L74:
        n1.d("ProactiveSummaryRecords", "No Proactive Remind in other device");     // Catch: Throwable -> L54
        Unit r175 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L71:
        r173 = false;
    L40:
        r161 = false;
        goto L41
    L23:
        if (r115.L() != true) goto L25;
        r116 = true;
    L19:
        n1.d("ProactiveSummaryRecords", "Exceptional case , DoraAdapter.getInstance().current() is null, so result is false.");     // Catch: Throwable -> L231
        r113 = 0;
    L10:
        r103 = false;
    L231:
        th = th;
        r211 = r100;
        goto L233
    }

    public static final boolean b(ProactiveSummaryModel r100, f r101, ProactiveSummarySource r102) {
        r100.getClass();
        Integer r103 = r101.f291460b;
        int r104 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r103 != null) goto L6;
    L13:
        return false;
    L6:
        if (r103.intValue() != r104) goto L13;
        if (r101.a() != null) goto L11;
        n1.d("ProactiveSummaryRecords", "Skip unlock drop for system notify because original_system_notification_list is empty. summaryId=" + r101.f291459a + ", subScene=" + r101.f291461c + ", source=" + r102.getValue());
        goto L13
    L11:
        com.larus.avlink.notification.a r105 = com.larus.avlink.notification.a.f293461a;
        Long r106 = r101.a();
        r105.getClass();
        if (com.larus.avlink.notification.a.b(r106) == false) goto L13;
        n1.d("ProactiveSummaryRecords", "Discard system notify summary after device unlock. summaryId=" + r101.f291459a + ", subScene=" + r101.f291461c + ", earliestClientReceiveTimestampMs=" + r101.a() + ", source=" + r102.getValue());
        k<f> r107 = n.f291489a;
        n.h(r101.f291459a, r101.f291460b.toString(), r101.f291461c, r102.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.DEVICE_UNLOCKED, r101.b());
        return true;
    }

    public static void f(boolean r210, int r211, boolean r212, boolean r213, f r214, ProactiveSummarySource r215) {
        IDoraAVLinkService r100 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r100 == null) goto L5;
        Integer r101 = r100.c();
    L6:
        boolean r102 = false;
        if (r101 == null) goto L9;
        int r103 = r101.intValue();
    L10:
        boolean r104 = ia8.e.a().isRecording();
        if (v88.a.b(Integer.valueOf(r103)) == false) goto L15;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.G == true) goto L15;
        boolean r110 = true;
    L16:
        if (r210 == true) goto L18;
        if (r213 == true) goto L18;
    L20:
        boolean r105 = false;
    L21:
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L28;
        DeviceService r107 = r106.device();
        if (r107 == null) goto L28;
        if (r107.r0() != true) goto L28;
        boolean r108 = true;
    L29:
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L36;
        DeviceService r112 = r111.device();
        if (r112 == null) goto L36;
        if (r112.W() != true) goto L36;
        boolean r113 = true;
    L37:
        IDoraService r114 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r114 == null) goto L40;
        int r115 = r114.d0();
    L41:
        if (r105 == true) goto L48;
        if (r108 == true) goto L48;
        if (r113 == true) goto L48;
        if (r115 == 0) goto L48;
        if (r211 == 2) goto L48;
        if (r104 == true) goto L48;
    L49:
        if (r102 == false) goto L51;
        k<f> r109 = n.f291489a;
        n.i(r214.f291459a, String.valueOf(r214.f291460b), r214.f291461c, r215.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.AUDIO_CONFLICTS, null, 64);
        n1.d("ProactiveSummaryRecords", "G:Abandon this remind because in handleAudioConflicts due to switch status: isRealTimeCall: " + r210 + ",  isTtsPlayer: " + r212 + ", isRecording: " + r104 + ", isDoraCall: " + r213 + ",  doraMode is " + r101 + ",  idleState is " + r211 + ", headphoneMode: " + r113 + ",  videoRecord: " + r108 + ",  wearCount: " + r115 + ", envObserveNonConversation: " + r110 + ",idleState is " + r211 + ", summaryId is " + r214.f291459a + ", scene is " + r214.f291460b + ", source is " + r215);
        return;
    L51:
        k<f> r116 = n.f291489a;
        n.d(r214.f291459a, String.valueOf(r214.f291460b), r214.f291461c, r215.getValue(), r214.f291464f, r110, null, null, null);
        return;
    L48:
        r102 = true;
        goto L49
    L40:
        r115 = 0;
    L36:
        r113 = false;
    L28:
        r108 = false;
    L18:
        if (r110 == true) goto L20;
        r105 = true;
    L15:
        r110 = false;
        goto L16
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
