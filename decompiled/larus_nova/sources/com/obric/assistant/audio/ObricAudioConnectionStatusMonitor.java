package com.obric.assistant.audio;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricAudioConnectionStatusMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f385617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f385618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f385619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f385620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f385621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CoroutineScope f385622f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f385623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MutexImpl f385624h = null;

    public ObricAudioConnectionStatusMonitor() {
    }

    static {
        f385617a = LazyKt.lazy(new h());
        f385618b = LazyKt.lazy(new i());
        f385619c = true;
        f385620d = true;
        f385622f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f385624h = kotlinx.coroutines.sync.b.a();
    }

    public static final boolean a() {
        IFlowTtsClientService.f288300a.getClass();
        PlayStateEnum r100 = IFlowTtsClientService.a.a().m();
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L7;
        DeviceService r102 = r101.device();
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.J());
    L9:
        if (f385619c == true) goto L11;
    L27:
        boolean r104 = false;
    L28:
        FLogger.f375446a.i("ObricAudioConnectionStatusMonitor", "canDisconnectForObric = " + r104 + " obricAssistantDeactive = " + f385619c + " playerState = " + r100 + " isAppBackground = " + AppHost.f326268a.a().isAppBackground() + " doraConnectStatus=" + r103 + " mode = " + hm9.j.f485966h.f485995y + ", screenOff = " + f385621e + " exitRealtimeCallMode = " + f385620d + ' ');
        return r104;
    L11:
        if (r100 == PlayStateEnum.PLAY_STATE_PLAYING) goto L27;
        if (r100 == PlayStateEnum.PLAY_STATE_PREPARE) goto L27;
        if (AppHost.f326268a.a().isAppBackground() == false) goto L27;
        if (hm9.j.f485966h.f485995y == 2) goto L21;
        if (f385621e == false) goto L27;
    L21:
        if (Intrinsics.areEqual(r103, Boolean.FALSE) == false) goto L27;
        if (f385620d == false) goto L27;
        if (t1.f393353a.isCloseAudioConnAppBackGroundOnlyForObric() == false) goto L27;
        r104 = true;
    L7:
        r103 = null;
        goto L9
    }

    public static final boolean b() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.a().isAppBackground() == true) goto L5;
    L12:
        boolean r101 = true;
    L13:
        FLogger.f375446a.i("ObricAudioConnectionStatusMonitor", "canReconnectForObric = " + r101 + " obricAssistantDeactive = " + f385619c + " isAppBackground = " + r100.a().isAppBackground() + " mode = " + hm9.j.f485966h.f485995y + ", screenOff = " + f385621e + ' ');
        return r101;
    L5:
        if (f385619c == false) goto L12;
        if (hm9.j.f485966h.f485995y != 2) goto L9;
    L11:
        r101 = false;
        goto L13
    L9:
        if (f385621e == true) goto L11;
        goto L11
    }

    public static void c(String r100) {
        BuildersKt.launch$default(f385622f, null, null, new ObricAudioConnectionStatusMonitor$tryDisconnect$1(r100, null), 3, null);
    }

    public static void d(String r100) {
        BuildersKt.launch$default(f385622f, null, null, new ObricAudioConnectionStatusMonitor$tryReconnect$1(r100, null), 3, null);
    }
}
