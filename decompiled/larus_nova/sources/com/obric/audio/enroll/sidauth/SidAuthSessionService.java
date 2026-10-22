package com.obric.audio.enroll.sidauth;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.mammon.audiosdk.SidAuthService;
import com.mammon.audiosdk.structures.SAMICoreSidAuthCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRegisterResult;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRequest;
import com.mammon.audiosdk.structures.SAMICoreSidAuthResult;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.t1;
import com.obric.audio.continuous_talk.s0;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
public final class SidAuthSessionService implements r68.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SidAuthSessionService f395530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f395531b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f395532c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f395533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f395534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f395535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f395536g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ByteArrayOutputStream f395537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Job f395538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f395539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float[] f395540k;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f395541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SAMICoreSidAuthResult f395542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f395543c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f395541a == r101.f395541a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f395542b, r101.f395542b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f395543c, r101.f395543c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f395541a * 31;
            SAMICoreSidAuthResult r101 = this.f395542b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f395543c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "AuthCallResult(ret=" + this.f395541a + ", result=" + this.f395542b + ", failReason=" + this.f395543c + ')';
        }

        public a(int r100, SAMICoreSidAuthResult r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this.f395541a = r100;
            this.f395542b = r101;
            this.f395543c = r102;
        }
    }

    public SidAuthSessionService() {
    }

    static {
        f395530a = new SidAuthSessionService();
        f395531b = LazyKt.lazy(new n());
        f395532c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f395536g = new Object();
    }

    public static SAMICoreSidAuthCreateParameter h() {
        SAMICoreSidAuthCreateParameter r100 = new SAMICoreSidAuthCreateParameter();
        nia.a.f519383a.getClass();
        r100.modelPath = nia.a.l().f519397a;
        r100.dbPath = nia.a.f519389g;
        r100.uid = nia.a.g() + '-' + obricDeviceManagerDelegate.f389029b.getUuid();
        r100.sidModelMd5 = nia.a.l().f519399c;
        r100.appId = String.valueOf(AppHost.f326268a.getAppId());
        r100.sidAuthEncKeyInfo = nia.a.e(nia.a.l().f519398b);
        return r100;
    }

    @Override // r68.a
    public final void b() {
        if (f395535f == false) goto L5;
        return;
    L5:
        Object r100 = f395536g;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (f395534e == true) goto L12;
        monitor-exit(r100);
        return;
    L12:
        if (f395539j == true) goto L14;
        f395537h = new ByteArrayOutputStream();     // Catch: Throwable -> L18
    L14:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
        FLogger.f375446a.i("SidAuthSessionService", "resetCacheForNextQuery currentWkrId=" + f395533d);
    }

    public static long e(String r100) {
        ByteArrayOutputStream r101 = f395537h;
        if (r101 == null) goto L9;
        int r102 = r101.size();
        if (r102 >= 1920000) goto L7;
        return 0;
    L7:
        long r103 = f395533d;
        FLogger.f375446a.i("SidAuthSessionService", "abort auth cache reason=" + r100 + " wkrId=" + r103 + " cachedBytes=" + r102 + " maxBytes=1920000 maxDurationMs=60000");
        i(true);
        return r103;
    L9:
        return 0;
    }

    public static byte[] g(ByteArrayOutputStream r310) {
        float[] r100 = f395540k;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        if (r310 == null) goto L69;
        int r102 = r310.size();
        if (r102 > 0) goto L15;
        return null;
    L15:
        byte[] r103 = r310.toByteArray();
        long r104 = -1;
        long r105 = -1;
        int r110 = 0;
    L17:
        if (r110 >= r100.length) goto L59;
        byte[] r311 = r103;
        long r106 = RangesKt.coerceAtLeast((long) r100[r110], 0);
        Float r111 = ArraysKt.getOrNull(r100, r110 + 1);
        if (r111 == null) goto L21;
        Long r107 = Long.valueOf((long) r111.floatValue());
    L22:
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        long r112 = 32;
        long r210 = r106 * r112;
        if ((r210 % 2) == 0) goto L32;
        r210 = r210 - 1;
    L32:
        int r113 = r110;
        long r114 = r210;
        if (r108 == false) goto L35;
        int r109 = r102;
        long r115 = 0 + ((long) r109);
    L40:
        long r116 = r114 - 0;
        long r117 = r115 - 0;
        long r211 = r117 - r116;
        long r118 = (r211 * 1000) / ((long) 32000);
        if (r116 >= 0) goto L43;
    L55:
        long r212 = r116;
    L56:
        FLogger.f375446a.i("SidAuthSessionService", "skip continuous vad segment startMs=" + r106 + " rawEndMs=" + r107 + " isOpenEnded=" + r108 + " cacheStartBytes=0 startInCache=" + r212 + " endInCache=" + r117 + " bufferSize=" + r109 + " durationMs=" + r118);
    L57:
        r104 = r104;
    L58:
        r110 = r113 + 2;
        r103 = r311;
        r102 = r109;
        r100 = r100;
        goto L17
    L43:
        if (r117 <= r116) goto L55;
        r212 = r116;
        if (r117 > r109) goto L56;
        if (r118 < 1000) goto L56;
        if (r105 >= 0) goto L51;
    L54:
        r104 = r117;
        r105 = r212;
        goto L58
    L51:
        if (r211 <= (r104 - r105)) goto L57;
    L35:
        r109 = r102;
        long r213 = r107.longValue() * r112;
        if ((r213 % 2) == 0) goto L39;
        r213 = r213 - 1;
    L39:
        r115 = RangesKt.coerceAtLeast(r213, r114);
        goto L40
    L24:
        if (r107.longValue() <= 0) goto L27;
        r108 = false;
        goto L28
    L21:
        r107 = null;
        goto L22
    L59:
        float[] r214 = r100;
        byte[] r312 = r103;
        long r215 = r104;
        if (r105 >= 0) goto L62;
    L66:
        FLogger.f375446a.i("SidAuthSessionService", "buildContinuousCandidate no valid segment featureValuesMs=" + Arrays.toString(r214));
        return null;
    L62:
        if (r215 <= r105) goto L66;
        Intrinsics.checkNotNull(r312);
        byte[] r119 = ArraysKt.copyOfRange(r312, (int) r105, (int) r215);
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("buildContinuousCandidate success startMs=");
        long r122 = 32000;
        r121.append((r105 * 1000) / r122);
        r121.append(" endMs=");
        r121.append((r215 * 1000) / r122);
        r121.append(" durationMs=");
        r121.append((((long) r119.length) * 1000) / r122);
        r121.append(" cacheStartBytes=0 candidateSize=");
        r121.append(r119.length);
        r121.append(" featureValuesMs=");
        r121.append(Arrays.toString(r214));
        r120.i("SidAuthSessionService", r121.toString());
        return r119;
    L69:
        return null;
    L8:
        r101 = false;
        goto L9
    }

    public static void i(boolean r100) {
        if (r100 == false) goto L7;
        Job r101 = f395538i;
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        f395538i = null;
        f395534e = false;
        f395537h = null;
        f395533d = 0;
        f395535f = false;
        f395539j = false;
        f395540k = null;
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.i("SidAuthSessionService", "destroyForAccountChange reason=" + r100);
        Object r101 = f395536g;
        monitor-enter(r101);
        f395530a.getClass();     // Catch: Throwable -> L21
        i(true);     // Catch: Throwable -> L21
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r101);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        g.f395552a.getClass();     // Catch: Throwable -> L8
        g.a();     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L24;
        FLogger.f375446a.e("SidAuthSessionService", "destroyForAccountChange pending clearAll failed: " + r105.getMessage());
    L24:
        m.f395563a.getClass();     // Catch: Throwable -> L15
        m.a();     // Catch: Throwable -> L15
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L30;
        FLogger.f375446a.e("SidAuthSessionService", "destroyForAccountChange register clear failed: " + r107.getMessage());
        return;
    L30:
        return;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    public static int p(SidAuthService r100) {
        SAMICoreSidAuthRegisterResult r101 = new SAMICoreSidAuthRegisterResult();
        int r102 = r100.register(r101);     // Catch: Throwable -> L12
        if (r102 != 0) goto L10;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("SidAuth register auth model success sidId=");
        r104.append(r101.sidId);
        r104.append(" voiceFingerId=");
        r104.append(r101.voiceFingerId);
        r104.append(" embedJsonLen=");
        String r105 = r101.embedJson;
        if (r105 == null) goto L8;
        int r106 = r105.length();
    L9:
        r104.append(r106);
        r103.i("SidAuthSessionService", r104.toString());
    L11:
        return r102;
    L8:
        r106 = 0;
        goto L9
    L10:
        FLogger.f375446a.e("SidAuthSessionService", "SidAuth register auth model failed ret=" + r102);
    L12:
        th = move-exception;
        FLogger.f375446a.e("SidAuthSessionService", "SidAuth register auth model exception: " + th.getMessage());
        return Integer.MIN_VALUE;
    }

    @Override // r68.a
    public final void a(String r110) {
        if (f395535f == false) goto L15;
        Ref.LongRef r100 = new Ref.LongRef();
        Object r101 = f395536g;
        monitor-enter(r101);
        r100.element = f395533d;     // Catch: Throwable -> L12
        f395530a.getClass();     // Catch: Throwable -> L12
        i(true);     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        FLogger.f375446a.i("SidAuthSessionService", "onSessionEnd bypass adaptive sid, wkrId=" + r100.element);
        if (r100.element == 0) goto L130;
        BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$onSessionEnd$2(r100, null), 3, null);
        return;
    L130:
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        Ref.LongRef r103 = new Ref.LongRef();
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        Object r105 = f395536g;
        monitor-enter(r105);
    L118:
        th = move-exception;
        throw th;
    L18:
        if (f395534e == true) goto L22;
        monitor-exit(r105);
        return;
    L22:
        f395534e = false;     // Catch: Throwable -> L118
        r103.element = f395533d;     // Catch: Throwable -> L118
        ByteArrayOutputStream r106 = f395537h;     // Catch: Throwable -> L118
        if (r106 == null) goto L26;
        byte[] r107 = r106.toByteArray();     // Catch: Throwable -> L118
        if (r107 == null) goto L26;
    L27:
        byte[] r111 = r107;
        boolean r108 = f395539j;     // Catch: Throwable -> L118
        r104.element = r108;     // Catch: Throwable -> L118
        if (r108 == false) goto L30;
        SidAuthSessionService r109 = f395530a;     // Catch: Throwable -> L118
        ByteArrayOutputStream r112 = f395537h;     // Catch: Throwable -> L118
        r109.getClass();     // Catch: Throwable -> L118
        byte[] r113 = g(r112);     // Catch: Throwable -> L118
    L31:
        f395530a.getClass();     // Catch: Throwable -> L118
        i(true);     // Catch: Throwable -> L118
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L118
        monitor-exit(r105);
        if (r113 == null) goto L35;
        int r115 = r113.length;
    L36:
        long r116 = 32000;
        long r117 = (((long) r115) * 1000) / r116;
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("onSessionEnd wkrId=");
        r119.append(r103.element);
        r119.append(" pcmSize=");
        r119.append(r111.length);
        r119.append(" candidateSize=");
        if (r113 == null) goto L39;
        int r120 = r113.length;
    L40:
        r119.append(r120);
        r119.append(" durationMs=");
        r119.append(r117);
        r119.append(" asrTextLen=");
        if (r110 == null) goto L43;
        int r121 = r110.length();
    L44:
        r119.append(r121);
        r119.append(" isContinuousTalk=");
        r119.append(r104.element);
        r118.i("SidAuthSessionService", r119.toString());
        if (r103.element != 0) goto L49;
        r118.i("SidAuthSessionService", "onSessionEnd skip: no wkrId");
        return;
    L49:
        if (r104.element == false) goto L54;
        if (r113 != null) goto L54;
        r118.i("SidAuthSessionService", "onSessionEnd dispatch fail: no continuous vad candidate, wkrId=" + r103.element);
        BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$onSessionEnd$4(r103, null), 3, null);
        return;
    L54:
        if (r111.length != 0) goto L56;
        boolean r122 = true;
    L57:
        if (r122 == false) goto L62;
        if (r113 != null) goto L62;
        r118.i("SidAuthSessionService", "onSessionEnd skip: empty audio");
        return;
    L62:
        if (p.a(r110, "SidAuthSessionService") == true) goto L77;
        StringBuilder r123 = new StringBuilder("onSessionEnd skip auth: asr text too short, wkrId=");
        r123.append(r103.element);
        r123.append(" asrTextLen=");
        if (r110 == null) goto L66;
        int r124 = r110.length();
    L67:
        r123.append(r124);
        r123.append(" hasAsrText=");
        if (r110 != null) goto L70;
    L73:
        boolean r125 = true;
    L74:
        r123.append(!r125);
        r118.i("SidAuthSessionService", r123.toString());
        BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$onSessionEnd$5(r103, null), 3, null);
        return;
    L70:
        if (r110.length() == 0) goto L73;
        r125 = false;
        goto L74
    L66:
        r124 = 0;
        goto L67
    L77:
        if (r104.element == false) goto L81;
        if (r113 == null) goto L80;
        r118.i("SidAuthSessionService", "sliceVoicePcm by continuous vad candidate pcmSize=" + r111.length + " vadPcmSize=" + r113.length + " vadDurationMs=" + ((((long) r113.length) * 1000) / r116));
        byte[] r126 = r113;
        Ref.LongRef r127 = r103;
        Ref.BooleanRef r128 = r104;
    L109:
        long r129 = (((long) r126.length) * 1000) / r116;
        if (r110 == null) goto L112;
        int r130 = r110.length();
    L113:
        BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$onSessionEnd$6(r127, r126, r129, r128, r130, null), 3, null);
        return;
    L112:
        r130 = 0;
        goto L113
    L80:
        r118.i("SidAuthSessionService", "sliceVoicePcm continuous vad candidate unavailable, fallback to full pcm");
        r127 = r103;
        r128 = r104;
    L108:
        r126 = r111;
        goto L109
    L81:
        int r131 = q.f395567a;
        Intrinsics.checkNotNullParameter(r111, "pcm");
        if (r111.length != 0) goto L84;
        boolean r132 = true;
    L85:
        if (r132 == false) goto L87;
        r127 = r103;
        r128 = r104;
        r126 = null;
    L105:
        if (r126 == null) goto L107;
        FLogger.f375446a.i("SidAuthSessionService", "sliceVoicePcm by local vad pcmSize=" + r111.length + " vadPcmSize=" + r126.length + " vadDurationMs=" + ((((long) r126.length) * 1000) / r116));
        goto L109
    L107:
        FLogger.f375446a.i("SidAuthSessionService", "sliceVoicePcm local vad unavailable, fallback to full pcm");
        goto L108
    L87:
        s0 r133 = new s0(800);
    L100:
        th = th;
        r127 = r103;
        r128 = r104;
    L128:
        FLogger.f375446a.e("SidAuthVadAudioSlicer", "sliceLongestVoiceSegment failed: " + th.getMessage());     // Catch: Throwable -> L115
    L103:
        r126 = null;
    L104:
        r133.d();
    L115:
        th = move-exception;
        r133.d();
        throw th;
    L89:
        if (r133.c() == true) goto L91;
        r118.w("SidAuthVadAudioSlicer", "sliceLongestVoiceSegment preload failed, pcmSize=" + r111.length);     // Catch: Throwable -> L100
    L93:
        r127 = r103;
        r128 = r104;
        goto L103
    L91:
        q.a r134 = q.b(r133, r111);     // Catch: Throwable -> L100
        if (r134 == null) goto L93;
        StringBuilder r135 = new StringBuilder("sliceLongestVoiceSegment success startMs=");     // Catch: Throwable -> L100
        r127 = r103;
        r128 = r104;
        r135.append(q.a(r134.f395568a));     // Catch: Throwable -> L98
        r135.append(" endMs=");     // Catch: Throwable -> L98
        r135.append(q.a(r134.f395569b));     // Catch: Throwable -> L98
        r135.append(" durationMs=");     // Catch: Throwable -> L98
        r135.append(q.a(r134.f395571d));     // Catch: Throwable -> L98
        r135.append(" pcmDurationMs=");     // Catch: Throwable -> L98
        r135.append(q.a(r111.length));     // Catch: Throwable -> L98
        r118.i("SidAuthVadAudioSlicer", r135.toString());     // Catch: Throwable -> L98
        r126 = ArraysKt.copyOfRange(r111, r134.f395568a, r134.f395569b);     // Catch: Throwable -> L98
    L98:
        th = th;
        goto L128
    L84:
        r132 = false;
        goto L85
    L56:
        r122 = false;
        goto L57
    L43:
        r121 = 0;
        goto L44
    L39:
        r120 = 0;
        goto L40
    L35:
        r115 = r111.length;
        goto L36
    L30:
        r113 = null;
    L26:
        r107 = new byte[0];     // Catch: Throwable -> L118
        goto L27
    }

    @Override // r68.a
    public final void d(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pcm");
        if (f395535f == false) goto L6;
        return;
    L6:
        if (f395534e == true) goto L8;
        return;
    L8:
        if (r100.length != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L39;
        Object r102 = f395536g;
        monitor-enter(r102);
    L32:
        th = move-exception;
        throw th;
    L16:
        if (f395534e == true) goto L18;
    L30:
        monitor-exit(r102);
        return;
    L18:
        if (f395539j == true) goto L30;
        ByteArrayOutputStream r103 = f395537h;     // Catch: Throwable -> L32
        if (r103 != null) goto L24;
        monitor-exit(r102);
        return;
    L24:
        r103.write(r100, 0, r100.length);     // Catch: Throwable -> L32
        f395530a.getClass();     // Catch: Throwable -> L32
        long r104 = e("feedAecPcm");     // Catch: Throwable -> L32
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r102);
        if (r104 == 0) goto L38;
        l(r104, "cache duration exceeds 60000ms");
        return;
    L38:
        return;
    L39:
        return;
    L10:
        r101 = false;
        goto L11
    }

    public static ContentProviderClient j(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void l(long r100, String r101) {
        BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$dispatchCacheTimeout$1(r100, r101, null), 3, null);
    }

    public static void m(long r100, String r101) {
        FLogger.f375446a.i("SidAuthSessionService", "dispatchFail wkrId=" + r100 + " reason=" + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        o(r100, 0);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.e("SidAuthSessionService", "dispatchFail send failed: " + r104.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.StringBuilder] */
    public static void o(long r110, int r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(ObricEnrollInteropDelegate.f392835b.b()));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        FLogger r103 = FLogger.f375446a;
        ContentProviderClient r104 = new StringBuilder("isVoiceWakeupEnabled failed: ");
        r104.append(r102.getMessage());
        r103.e("SidAuthSessionService", r104.toString());
    L10:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L14;
        r101 = r105;
    L14:
        if (((Boolean) r101).booleanValue() == true) goto L17;
        FLogger.f375446a.i("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding skip: wakeup disabled wkrId=" + r110 + " save=" + r111);
        return;
    L17:
        Unit r106 = null;
        ContentProviderClient r107 = j(AppHost.f326268a.getApplication().getContentResolver(), com.obric.assistant.voice.k.f394380a);     // Catch: Throwable -> L39 Exception -> L41
        if (r107 != null) goto L26;
        FLogger.f375446a.e("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding failed: provider client null");     // Catch: Exception -> L37 Throwable -> L56
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L26:
        Bundle r108 = new Bundle();     // Catch: Exception -> L37 Throwable -> L56
        r108.putLong("wkrId", r110);     // Catch: Exception -> L37 Throwable -> L56
        r108.putInt(SVGRenderEngine.SAVE, r111);     // Catch: Exception -> L37 Throwable -> L56
        Bundle r109 = r107.call("sid-auth-save-adaptive-embedding", null, r108);     // Catch: Exception -> L37 Throwable -> L56
        FLogger r113 = FLogger.f375446a;     // Catch: Exception -> L37 Throwable -> L56
        StringBuilder r114 = new StringBuilder("dispatchSaveAdaptiveEmbedding wkrId=");     // Catch: Exception -> L37 Throwable -> L56
        r114.append(r110);     // Catch: Exception -> L37 Throwable -> L56
        r114.append(" save=");     // Catch: Exception -> L37 Throwable -> L56
        r114.append(r111);     // Catch: Exception -> L37 Throwable -> L56
        r114.append(" providerRet=");     // Catch: Exception -> L37 Throwable -> L56
        if (r109 == null) goto L29;
        Integer r115 = Integer.valueOf(r109.getInt("ret", Integer.MIN_VALUE));     // Catch: Exception -> L37 Throwable -> L56
    L30:
        r114.append(r115);     // Catch: Exception -> L37 Throwable -> L56
        r113.i("SidAuthSessionService", r114.toString());     // Catch: Exception -> L37 Throwable -> L56
        if (Build.VERSION.SDK_INT < 24) goto L34;
        r107.close();     // Catch: Throwable -> L53
    L35:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
        return;
    L34:
        r107.release();     // Catch: Throwable -> L53
        goto L35
    L29:
        r115 = null;
    L37:
        e = e;
    L43:
        FLogger.f375446a.e("SidAuthSessionService", "dispatchSaveAdaptiveEmbedding exception: " + e.getMessage());     // Catch: Throwable -> L56
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L53
        if (r107 != null) goto L47;
    L51:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L53
        return;
    L47:
        if (Build.VERSION.SDK_INT < 24) goto L49;
        r107.close();     // Catch: Throwable -> L53
    L50:
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L53
        goto L51
    L49:
        r107.release();     // Catch: Throwable -> L53
        goto L50
    L53:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L41:
        e = e;
        r107 = null;
    L39:
        th = th;
        r104 = 0;
    L70:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L66
        if (r104 != 0) goto L60;
    L64:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L66
    L68:
        throw th;
    L60:
        if (Build.VERSION.SDK_INT < 24) goto L62;
        r104.close();     // Catch: Throwable -> L66
    L63:
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L66
        goto L64
    L62:
        r104.release();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L56:
        th = th;
    L5:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // r68.a
    public final boolean c(long r110, boolean r111) {
        boolean r100 = false;
        if (r110 != 0) goto L63;
        return false;
    L63:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(ObricEnrollInteropDelegate.f392835b.d()));     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("SidAuthSessionService", "isCurrentSessionFromBreathWakeup failed: " + r103.getMessage());
    L12:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = r104;
    L16:
        if (((Boolean) r102).booleanValue() == false) goto L61;
        FLogger.f375446a.i("SidAuthSessionService", "onSessionStart skip: breath wakeup wkrId=" + r110);
        return false;
    L61:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(t1.f393353a.isBypassAdaptiveSid()));     // Catch: Throwable -> L21
    L23:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L26;
        FLogger.f375446a.e("SidAuthSessionService", "isBypassAdaptiveSid failed: " + r106.getMessage());
    L26:
        Boolean r107 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r105) == false) goto L29;
        r105 = r107;
    L29:
        boolean r108 = ((Boolean) r105).booleanValue();
        nia.a.f519383a.getClass();     // Catch: Throwable -> L32
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(nia.a.l().f519402f));     // Catch: Throwable -> L32
    L34:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L37;
        FLogger.f375446a.e("SidAuthSessionService", "isAuthReady failed: " + r112.getMessage());
    L37:
        Boolean r113 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r109) == false) goto L40;
        r109 = r113;
    L40:
        boolean r114 = ((Boolean) r109).booleanValue();
        if (r108 == true) goto L43;
        if (r114 == false) goto L43;
    L44:
        Object r115 = f395536g;
        monitor-enter(r115);
        f395530a.getClass();     // Catch: Throwable -> L55
        i(true);     // Catch: Throwable -> L55
        f395533d = r110;     // Catch: Throwable -> L55
        f395535f = r100;     // Catch: Throwable -> L55
        if (r100 == false) goto L51;
        FLogger.f375446a.i("SidAuthSessionService", "onSessionStart bypass adaptive sid, wkrId=" + r110 + " isContinuousTalk=" + r111 + " bypass=" + r108 + " authReady=" + r114);     // Catch: Throwable -> L55
        monitor-exit(r115);
        return true;
    L51:
        f395537h = new ByteArrayOutputStream();     // Catch: Throwable -> L55
        f395534e = true;     // Catch: Throwable -> L55
        f395539j = r111;     // Catch: Throwable -> L55
        f395540k = null;     // Catch: Throwable -> L55
        f395538i = BuildersKt.launch$default(f395532c, null, null, new SidAuthSessionService$startCacheTimeoutJob$1(r110, null), 3, null);     // Catch: Throwable -> L55
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r115);
        FLogger.f375446a.i("SidAuthSessionService", "onSessionStart wkrId=" + r110 + " isContinuousTalk=" + r111);
        return true;
    L55:
        th = move-exception;
        throw th;
    L43:
        r100 = true;
    L32:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static a f(SidAuthService r100, byte[] r101, String r102) {
        SAMICoreSidAuthRequest r103 = new SAMICoreSidAuthRequest();
        r103.testAudio = r101;
        r103.threshold = 2.0d;
        SAMICoreSidAuthResult r104 = new SAMICoreSidAuthResult();
        int r105 = r100.auth(r103, r104);     // Catch: Throwable -> L9
        if (r105 == 0) goto L8;
        FLogger.f375446a.e("SidAuthSessionService", "SidAuth auth failed attempt=" + r102 + " ret=" + r105);
        return new a(r105, null, "auth ret=" + r105 + " attempt=" + r102, 2);
    L8:
        return new a(r105, r104, null, 4);
    L9:
        th = move-exception;
        FLogger.f375446a.e("SidAuthSessionService", "SidAuth auth exception attempt=" + r102 + ": " + th.getMessage());
        return new a(Integer.MIN_VALUE, null, "auth exception attempt=".concat(r102), 2);
    }

    public static void n(long r100, String r101, int r102) {
        String r103 = c.a(r101, r102);
        if (r102 != 220014) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        m.f395563a.getClass();
        m.a();
        FLogger.f375446a.i("SidAuthSessionService", "SidAuth register audio unavailable, dispatch save=0 wkrId=" + r100 + " reason=" + r103);
    L8:
        m(r100, r103);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
