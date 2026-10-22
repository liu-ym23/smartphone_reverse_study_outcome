package com.larus.avlink;

import android.os.SystemClock;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
public final class DoraWakeupSoundController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f291405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f291406b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f291407c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f291408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f291409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f291410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f291411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile q1 f291412h;

    public DoraWakeupSoundController() {
    }

    static {
        f291405a = LazyKt.lazy(new h1());
        f291406b = LazyKt.lazy(new i1());
        f291407c = LazyKt.lazy(new j1());
    }

    public static final boolean a() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L16;
        DeviceService r101 = r100.device();
        if (r101 == null) goto L16;
        boolean r102 = r101.p0(null);
        if (r101.M() == false) goto L10;
        boolean r103 = r101.I();
    L11:
        boolean r104 = r101.f0();
        n1.d("DoraWakeupSoundController", "canPlayFuzzyVoice: deviceEnable=" + r102 + ", isNaturalConversationOpen=" + r104 + ", isConvStartEndSoundEnabled = " + r103);
        if (r102 == false) goto L16;
        if (r104 == false) goto L16;
        if (r103 == false) goto L16;
        return true;
    L10:
        r103 = true;
    L16:
        return false;
    }

    public static void d() {
        long r100 = SystemClock.elapsedRealtime();
        f291410f = false;
        BuildersKt.launch$default((CoroutineScope) f291406b.getValue(), null, null, new DoraWakeupSoundController$onWakeReject$1(r100, null), 3, null);
    }

    public static final void b(long r100) {
        if (f291409e > 0) goto L5;
        long r101 = -1;
    L6:
        n1.d("DoraWakeupSoundController", "tryPlayWakeRejectVoice, elapsed=" + r101);
        if (r101 <= 2000) goto L11;
        q1 r102 = new q1("dora_wake_reject_sound_play_duration", r100, -1);
        r102.f294131e = SystemClock.elapsedRealtime();
        f291411g = true;
        f291412h = r102;
        ((SoundPlayManager) f291407c.getValue()).g(AppHost.f326268a.getApplication(), "dora_natural_wake_reject.mp3", "dora_natural_wake_reject.wav", new m1(), r102.f294138l);
        return;
    L11:
        return;
    L5:
        long r103 = f291409e;
        f291409e = 0;
        r101 = SystemClock.elapsedRealtime() - r103;
        goto L6
    }

    public static void c(int r100) {
        long r101 = SystemClock.elapsedRealtime();
        BuildersKt.launch$default((CoroutineScope) f291406b.getValue(), null, null, new DoraWakeupSoundController$onFuzzyWakeup$1(r100, r101, null), 3, null);
    }

    public static void e(int r100) {
        if (r100 == 45) goto L5;
        boolean r101 = true;
    L6:
        f291410f = false;
        BuildersKt.launch$default((CoroutineScope) f291406b.getValue(), null, null, new DoraWakeupSoundController$onWakeupStop$1(r100, r101, null), 3, null);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
