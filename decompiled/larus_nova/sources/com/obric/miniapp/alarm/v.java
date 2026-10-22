package com.obric.miniapp.alarm;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.d1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService;
import com.obric.audio.tts.IObricChainTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
public final class v implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f397486c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f397487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f397488b;

    public static final class a {
    }

    static {
    }

    public v() {
        this.f397487a = AudioServiceDelegate.f288288a.i0();
        this.f397488b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.obric.miniapp.alarm.r
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter("obric_alarm_tts", "messageId");
        Intrinsics.checkNotNullParameter(r110, "content");
        FLogger r100 = FLogger.f375446a;
        r100.i("DefaultAlarmTtsPlayer", "play: messageId=obric_alarm_tts, contentLen=" + r110);
        if (com.obric.assistant.utils.j.c(AppHost.f326268a.getApplication()) == true) goto L6;
        r100.i("DefaultAlarmTtsPlayer", "play: exit, cause current app is not an assitant role");
        return;
    L6:
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r102 = true;
        boolean r103 = false;
        if (r101 == null) goto L13;
        com.larus.home.impl.sdk.s r104 = r101.s0();
        if (r104 == null) goto L13;
        if (r104.c() != true) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L26;
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L22;
        DeviceService r107 = r106.device();
        if (r107 == null) goto L22;
        if (r107.S() != true) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == false) goto L26;
        r100.i("DefaultAlarmTtsPlayer", "play: exit, cause dora call is active, skip to avoid audio overlap");
        return;
    L22:
        r108 = false;
    L26:
        IObricAlarmTtsStateProducerService r109 = (IObricAlarmTtsStateProducerService) ServiceManager.get().getService(IObricAlarmTtsStateProducerService.class);
        if (r109 == null) goto L29;
        r109.a(null);
    L29:
        z2 r111 = z2.f365865a;
        if (r111.enableObricIndependentTts() == false) goto L32;
        IObricChainTtsService.f395811a.getClass();
        IObricChainTtsService r112 = IObricChainTtsService.a.a();
    L33:
        if (r112 == null) goto L37;
        r100.i("DefaultAlarmTtsPlayer", "play: use ObricTtsClient (independent tts pipeline), msgId=obric_alarm_tts");
        r112.a(r110, null, "obric_alarm_tts", false);
        return;
    L37:
        if (r111.enableObricIndependentTts() == false) goto L39;
        r100.i("DefaultAlarmTtsPlayer", "play: IObricChainTtsService not available, fallback to IM tts pipeline");
    L39:
        IFlowTtsClientService.f288300a.getClass();
        PlayStateEnum r113 = IFlowTtsClientService.a.a().m();
        if (r113 != PlayStateEnum.PLAY_STATE_STOPPED) goto L43;
        r102 = false;
    L43:
        if (r102 == false) goto L45;
        r100.i("DefaultAlarmTtsPlayer", "play: already has active tts(state=" + r113 + "), so interrupt current tts and play new alarm");
        IFlowTtsClientService.a.a().f("Alarm tts notification, interrupt current tts and play new alarm");
    L45:
        IObricChatService.f386556a.getClass();
        IObricChatService r114 = IObricChatService.a.a();
        if (r114 == null) goto L48;
        r103 = r114.j();
    L48:
        if (r102 == true) goto L52;
        if (r103 == true) goto L52;
        r100.i("DefaultAlarmTtsPlayer", "play: start tts directly");
        b("obric_alarm_tts", r110);
        return;
    L52:
        BuildersKt.launch$default(this.f397488b, null, null, new DefaultAlarmTtsPlayer$play$1(this, "obric_alarm_tts", r110, null), 3, null);
        return;
    L32:
        r112 = null;
    L13:
        r105 = false;
        goto L14
    }

    public final void b(String r110, String r111) {
        d1.a.a(this.f397487a, "calendar" + System.currentTimeMillis(), null, r111, true, null, r110, null, false, true, null, null, null, null, 3792);
    }
}
