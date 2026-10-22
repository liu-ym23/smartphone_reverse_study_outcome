package com.larus.im.internal.audio;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import com.larus.im.internal.trace.stable.FlowAVTraceTimer;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.c1;
import com.larus.im.service.audio.x0;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f347501c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f347502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<x0, id9.d> f347503b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347504a = null;

        static {
            int[] r100 = new int[AudioSessionType.values().length];
            r100[AudioSessionType.SAMI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AudioSessionType.RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AudioSessionType.QUIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AudioSessionType.MMT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f347504a = r100;
        }
    }

    static {
        f347501c = new u();
    }

    public static qf9.b a() {
        if (com.larus.im.internal.d.f347915c == true) goto L10;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L10;
        throw new IllegalStateException("av sdk not init");
    L10:
        return com.larus.im.internal.d.f347914b;
    }

    public u() {
        this.f347502a = new ReentrantReadWriteLock();
        this.f347503b = new LinkedHashMap();
    }

    public final id9.d b(final x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return c(r100, new s(this, r100));
    }

    public final id9.d e(final x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100.f350806a)) == false) goto L44;
        AudioSessionType r102 = r100.f350807b;
        AudioSessionType r103 = AudioSessionType.RTC;
        if (r102 != r103) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L42;
        if (r102 == r103) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L40;
        c1 r106 = r100.f350820o;
        if (r106 == null) goto L38;
        if ((!StringsKt.isBlank(r106.f350705a)) == true) goto L24;
    L32:
        r101 = false;
    L33:
        if (r101 == true) goto L38;
        throw new IllegalArgumentException("rtcConfig appId, engineBizId, roomId, userId and token must not be blank".toString());
    L24:
        if ((!StringsKt.isBlank(r106.f350706b)) == false) goto L32;
        if ((!StringsKt.isBlank(r106.f350707c)) == false) goto L32;
        if ((!StringsKt.isBlank(r106.f350709e)) == false) goto L32;
        if ((!StringsKt.isBlank(r106.f350708d)) == false) goto L32;
    L38:
        return c(r100, new t(r100, this));
    L40:
        throw new IllegalArgumentException("rtcConfig is required for RTC realtime session".toString());
    L14:
        if (r100.f350820o != null) goto L17;
        r105 = false;
        goto L18
    L42:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        if (r102 == AudioSessionType.MMT) goto L10;
        r104 = false;
        goto L11
    L44:
        throw new IllegalArgumentException("bizId is required for realtime session".toString());
    }

    public static id9.d d(x0 r100, String r101) {
        qf9.b r102 = a();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        if (r100.f350821p != null) goto L5;
        r100 = x0.a(r100, null, r102.f532753f, 98303);
    L5:
        qf9.g r103 = r102.f532751d;
        if (r103 == null) goto L9;
        id9.d r104 = r103.a(r100);
        if (r104 == null) goto L9;
    L10:
        if (r104 == null) goto L12;
        return r104;
    L12:
        g(r101, "flow-av-omni");
        throw null;
    L9:
        r102.f532748a.getClass();
        Intrinsics.checkNotNullParameter(r100, "config");
        r104 = null;
        goto L10
    }

    public static void g(String r100, String r101) {
        fe9.c.f476624a.b("MediaService", "create media session failed, no " + r100 + " provider.");
        throw new IllegalStateException("No flow av " + r100 + " media session provider. Please add " + r101 + " dependency.");
    }

    public final id9.d c(x0 r110, Function0<? extends id9.d> r111) {
        fe9.c.f476624a.e("MediaService", "create new audio session and stop all old sessions, config " + r110 + ", hashCode=" + r110.hashCode());
        ReentrantReadWriteLock.WriteLock r112 = this.f347502a.writeLock();
        r112.lock();
        Iterator r113 = ((LinkedHashMap) this.f347503b).entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r113.hasNext() == false) goto L13;
        Map.Entry r114 = (Map.Entry) r113.next();     // Catch: Throwable -> L9
        id9.d r115 = (id9.d) r114.getValue();     // Catch: Throwable -> L9
        h(this, (x0) r114.getKey(), r115, "force_release", r110.f350806a, null, null, 48);     // Catch: Throwable -> L9
        fe9.c r100 = fe9.c.f476624a;     // Catch: Throwable -> L9
        r100.e("MediaService", "audio session(" + r114.getKey() + ") release resource because new session is created.");     // Catch: Throwable -> L9
        SessionReleaseReason r101 = SessionReleaseReason.ForceRelease;     // Catch: Throwable -> L9
        if ((r115 instanceof qf9.c) == false) goto L11;
        ((qf9.c) r115).l(r101);     // Catch: Throwable -> L9
    L12:
        r113.remove();     // Catch: Throwable -> L9
        goto L5
    L11:
        r100.b("MediaService", "unknown session type, need handle");     // Catch: Throwable -> L9
        goto L12
    L13:
        fe9.c.f476624a.e("MediaService", "create new audio session, config " + r110 + ", hashCode=" + r110.hashCode());     // Catch: Throwable -> L9
        id9.d r102 = r111.invoke();     // Catch: Throwable -> L9
        this.f347503b.put(r110, r102);     // Catch: Throwable -> L9
        id9.d r103 = r102;     // Catch: Throwable -> L9
        r112.unlock();
        return r103;
    L9:
        th = move-exception;
        r112.unlock();
        throw th;
    }

    public final void f(id9.d r110, SessionReleaseReason r111) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r111, "reason");
        fe9.c r112 = fe9.c.f476624a;
        r112.e("MediaService", "before withLock audio session(" + r110.getSessionConfig() + ") release resource.");
        ReentrantReadWriteLock.WriteLock r113 = this.f347502a.writeLock();
        r113.lock();
        com.larus.im.internal.delegate.w.c r100 = com.larus.im.internal.delegate.w.j().f348360e;     // Catch: Throwable -> L27
        boolean r114 = true;
        if (r100 == null) goto L6;
        boolean r101 = r100.f348337i;     // Catch: Throwable -> L27
    L8:
        if (r101 == true) goto L10;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L17;
        r112.f("MediaService", "defer unstarted audio session(" + r110.getSessionConfig() + ") release resource, reason=" + r111 + '.');     // Catch: Throwable -> L27
        h(this, r110.getSessionConfig(), r110, "defer_destroy", null, r111, jd9.c.f.f498762c, 8);     // Catch: Throwable -> L27
    L24:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r113.unlock();
        r112.e("MediaService", "after withLock audio session(" + com.larus.im.internal.delegate.c.f348197a.c(r110.getSessionConfig().toString(), false, false) + " release resource.releaseDeferred=" + r114 + '.');
        return;
    L17:
        if (Intrinsics.areEqual((id9.d) ((LinkedHashMap) this.f347503b).get(r110.getSessionConfig()), r110) == false) goto L20;
        r112.e("MediaService", "remove cached audio session, config " + com.larus.im.internal.delegate.c.f348197a.c(r110.getSessionConfig().toString(), false, false));     // Catch: Throwable -> L27
        this.f347503b.remove(r110.getSessionConfig());     // Catch: Throwable -> L27
    L20:
        if ((r110 instanceof qf9.c) == false) goto L22;
        ((qf9.c) r110).l(r111);     // Catch: Throwable -> L27
    L23:
        r114 = false;
        goto L24
    L22:
        r112.b("MediaService", "unknown session type, need handle");     // Catch: Throwable -> L27
        goto L23
    L10:
        if (Intrinsics.areEqual(r110.state(), jd9.c.f.f498762c) == false) goto L12;
        r102 = true;
        goto L14
    L6:
        r101 = true;
    L27:
        th = move-exception;
        r113.unlock();
        throw th;
    }

    public static void h(u r100, x0 r101, id9.d r102, String r103, String r104, SessionReleaseReason r105, jd9.c.f r106, int r110) {
        String r107 = "";
        if ((r110 & 8) == 0) goto L6;
        r104 = null;
    L6:
        if ((r110 & 16) == 0) goto L8;
        r105 = null;
    L8:
        Object r108 = r106;
        if ((r110 & 32) == 0) goto L11;
        r108 = r102.state();
    L11:
        r100.getClass();
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L27
        d0 r111 = r102.state().f498753b;     // Catch: Throwable -> L27
        if (r111 == null) goto L35;
        String r112 = sf9.a.c(r111, "roomId", "");     // Catch: Throwable -> L27
        if (r112 != null) goto L18;
    L21:
        boolean r113 = true;
    L22:
        if (r113 == true) goto L24;
        r107 = r112;
        goto L35
    L24:
        String r114 = sf9.a.c(r111, DBDefinition.TASK_ID, "");     // Catch: Throwable -> L27
        if (r114 == null) goto L35;
    L34:
        r107 = r114;
        goto L35
    L18:
        if (r112.length() == 0) goto L21;
        r113 = false;
    L35:
        e0 r115 = new e0();
        ouc.j.b(r115, "session_type", Integer.valueOf(r101.f350807b.getType()));
        ouc.j.c(r115, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r101.f350806a);
        ouc.j.c(r115, BindCardPayConfirmConstants.Key.TRACE_ID, r107);
        if (r104 == null) goto L38;
        ouc.j.c(r115, "new_biz_id", r104);
    L38:
        ouc.j.c(r115, "type", r103);
        if (r105 == null) goto L41;
        ouc.j.c(r115, "release_reason", r105.getReasonName());
    L41:
        ouc.j.c(r115, "session_state", r108.toString());
        d0 r116 = r115.a();
        CoroutineScope r117 = FlowAVTraceTimer.f350182a;
        FlowAVTraceTimer.a(new MediaService$traceSessionAbnormal$1(r116, null));
        return;
    L27:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Object r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r119) == false) goto L31;
        r119 = null;
    L31:
        r114 = (String) r119;
        if (r114 != null) goto L34;
        goto L34
    }
}
