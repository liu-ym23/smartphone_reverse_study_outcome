package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRtcWrapper {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f434374n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.f f434376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f434377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f434378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f434379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f434380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f434381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f434382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f434383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f434384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f434385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f434386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f434387m;

    public static final class a {
    }

    static {
    }

    public MmRtcWrapper() {
        throw null;
    }

    public final void d() {
        c(this, new MmRtcWrapper$destroyRtc$1(this));
    }

    public final boolean e() {
        return ((Boolean) this.f434387m.getValue()).booleanValue();
    }

    public final void h() {
        c(this, new MmRtcWrapper$leaveChannel$1(this));
    }

    public final void j() {
        c(this, new MmRtcWrapper$release$1(this));
    }

    public final void p() {
        c(this, new MmRtcWrapper$stopAudioCapture$1(this));
    }

    public final void g(final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r100) {
        final boolean r101 = true;
        c(this, new MmRtcWrapper$joinRoom$1(r101, r100, this));
    }

    public final void i(final sub.a r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        c(this, new MmRtcWrapper$pushExternalEncodedAudioFrame$1(r100, this));
    }

    public final void k(final boolean r100) {
        c(this, new MmRtcWrapper$setEncodedExternalAudioDevice$1(r100));
    }

    public final void l(final boolean r100) {
        c(this, new MmRtcWrapper$setExternalAudioDevice$1(r100));
    }

    public final void m(final boolean r100) {
        c(this, new MmRtcWrapper$setPlaybackDigitalMute$1(r100));
    }

    public final void n(final int r100) {
        c(this, new MmRtcWrapper$setPlaybackVolume$1(r100));
    }

    public final void o(final Function1<? super Throwable, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onFailure");
        b(r100, new MmRtcWrapper$startAudioCapture$2(this, r100));
    }

    public MmRtcWrapper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.f r101) {
        AnonymousClass1 r102 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "userComponentContext");
        Intrinsics.checkNotNullParameter(r101, "audioFormat");
        Intrinsics.checkNotNullParameter(r102, "isLarkAppProvider");
        this.f434375a = r100;
        this.f434376b = r101;
        this.f434377c = r102;
        this.f434378d = UUID.randomUUID().toString();
        this.f434379e = LazyKt.lazy(new MmRtcWrapper$rtcScope$2(this));
        this.f434380f = true;
        this.f434381g = 2;
        this.f434382h = true;
        MmChannelProfileType.VC.getValue();
        if (r102.invoke().booleanValue() == false) goto L5;
        String r103 = ThumbGlideUrl.SOURCE_VC;
    L6:
        this.f434383i = r103;
        this.f434384j = new h(0);
        this.f434386l = LazyKt.lazy(new MmRtcWrapper$audioSettingsConfig$2(this));
        this.f434387m = LazyKt.lazy(new MmRtcWrapper$enableMMAudioMode$2(this));
        return;
    L5:
        r103 = "doubao_vc";
        goto L6
    }

    public static final String a(MmRtcWrapper r100, String r101) {
        if (r101 == null) goto L9;
        r100.getClass();
        if ((!StringsKt.isBlank(r101)) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L9;
        return r101;
    L9:
        if (r100.e() == false) goto L11;
        return "byteview_minutes_meeting";
    L11:
        return "";
    }

    public static /* synthetic */ void c(MmRtcWrapper r100, Function1 r101) {
        r100.b(MmRtcWrapper$checkAndRunInScop$1.INSTANCE, r101);
    }

    public final void b(Function1<? super Throwable, Unit> r100, Function1<? super nub.b, Unit> r110) {
        nub.b r101 = (nub.b) this.f434375a.u(nub.b.class);
        if (r101 != null) goto L6;
        lvb.a.b("MmRtcWrapper", "[checkRtcService] rtcService is null");
        return;
    L6:
        BuildersKt.launch$default((CoroutineScope) this.f434379e.getValue(), null, null, new MmRtcWrapper$checkAndRunInScop$2(r110, r101, r100, null), 3, null);
    }

    public final Object f(final MmRecordingAudioService.c r100, final MmRtcInitInfo r110, final String r111, Continuation r112) {
        final j r101 = new j(IntrinsicsKt.intercepted(r112), 1);
        r101.C();
        c(this, new MmRtcWrapper$initRtc$2$1(this, r100, r110, r111, r101));
        Object r102 = r101.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L5:
        return r102;
    }
}
