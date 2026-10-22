package tia;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.assistant.spi.audio.WakeupAudioCaptureReadScene;
import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hga.f f546322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<r, Unit> f546323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f546324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f546325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f546326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<e> f546327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Long> f546328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f546329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f546330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f546331j;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (this.f546326e.get() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f546331j.f546285c.get() == false) goto L7;
        return true;
    }

    public final boolean d() {
        final c r100 = this.f546331j;
        boolean r101 = false;
        if (r100.f546285c.compareAndSet(false, true) == true) goto L21;
    L15:
        r101 = true;
    L18:
        if (r101 == false) goto L20;
        a(this.f546322a);
    L20:
        return r101;
    L21:
        IAudioRecorderFactory r102 = (IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class);     // Catch: Throwable -> L16
        if (r102 == null) goto L8;
        final r58.c r103 = r102.a(AudioRecordType.BackTraceRecord, MapsKt.mapOf(new Pair[]{TuplesKt.to(PerfLog.PARAM_KEY_CONTEXT_ID, AppHost.f326268a.getApplication()), TuplesKt.to("bufferSize", -1)}));     // Catch: Throwable -> L16
    L9:
        if (r103 != null) goto L11;
        r100.f546285c.set(false);     // Catch: Throwable -> L16
        goto L18
    L11:
        r100.f546286d = r103;     // Catch: Throwable -> L16
        r103.b(5000, 0);     // Catch: Throwable -> L16
        r103.start();     // Catch: Throwable -> L16
        if (r103.l() == AudioRecordState.STARTED) goto L14;
        FLogger.f375446a.w("WakeupCaptureProducer", "producer start failed: state=" + r103.l());     // Catch: Throwable -> L16
        r100.a();     // Catch: Throwable -> L16
        goto L18
    L14:
        final long r104 = System.currentTimeMillis();     // Catch: Throwable -> L16
        r100.f546288f = r104;     // Catch: Throwable -> L16
        PthreadThreadV2 r105 = new PthreadThreadV2(new b(r100, r103, r104), "wakeup-capture-producer");     // Catch: Throwable -> L16
        ThreadMethodProxy.start(r105);     // Catch: Throwable -> L16
        r100.f546287e = r105;     // Catch: Throwable -> L16
        goto L15
    L8:
        r103 = null;
    L16:
        th = move-exception;
        FLogger.f375446a.e("WakeupCaptureProducer", "producer start failed", th);
        r100.a();
        goto L18
    }

    public final void a(final hga.f r110) {
        Intrinsics.checkNotNullParameter(r110, "trigger");
        int r100 = r110.f485042d;
        long r101 = r110.f485043e;
        if (r100 > 0) goto L5;
    L8:
        WakeupAudioCaptureTriggerType r102 = r110.f485040b;
        WakeupAudioCaptureTriggerType r103 = WakeupAudioCaptureTriggerType.VOICE_WAKEUP;
        if (r102 == r103) goto L12;
        FLogger.f375446a.i("WakeupCaptureSession", "record interaction start only trigger=" + r110);
        return;
    L12:
        Object r104 = this.f546325d;
        monitor-enter(r104);
    L60:
        th = move-exception;
        throw th;
    L15:
        if (this.f546326e.get() == false) goto L18;
        monitor-exit(r104);
        return;
    L18:
        boolean r105 = true;
        this.f546329h++;     // Catch: Throwable -> L60
        int r106 = this.f546330i;     // Catch: Throwable -> L60
        this.f546330i = r106 + 1;     // Catch: Throwable -> L60
        monitor-exit(r104);
        Long r107 = null;
        if (r106 != 0) goto L40;
        Long r108 = Long.valueOf(r110.f485044f);
        if (r108.longValue() <= 0) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == true) goto L29;
        r108 = null;
    L29:
        if (r108 == null) goto L31;
        long r111 = r108.longValue();
    L49:
        final long r112 = r111;
        long r113 = r112 - 4800;
        final long r114 = r112 + 8200;
        FLogger.f375446a.i("WakeupCaptureSession", "add upload window trigger=" + r110 + " windowIndex=" + r106 + " uploadAnchorTimeMs=" + r112 + " uploadStartTimeMs=" + r113 + " uploadEndTimeMs=" + r114);
        if (r110.f485040b == r103) goto L63;
    L58:
        final e r115 = new e(this.f546324c, new hga.e(WakeupAudioCaptureReadScene.UPLOAD, r113, r110.f485040b.name()), new l(this), new m(this));
        ThreadMethodProxy.start(new PthreadThreadV2(new n(this, r110, r115, r114, r112), "wakeup-capture-upload-window"));
        return;
    L63:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L53
        ObricWakeupTruthUploadDelegate.f392845b.b();     // Catch: Throwable -> L53
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L58;
        FLogger.f375446a.e("WakeupCaptureSession", "truth upload start dispatch failed", r118);
    L53:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L31:
        Long r120 = Long.valueOf(this.f546331j.f546288f);
        if (r120.longValue() > 0) goto L35;
        r105 = false;
    L35:
        if (r105 == false) goto L37;
        r107 = r120;
    L37:
        if (r107 == null) goto L39;
        r111 = r107.longValue();
        goto L49
    L39:
        r111 = r110.f485039a;
        goto L49
    L25:
        r109 = false;
        goto L26
    L40:
        Long r121 = Long.valueOf(r110.f485044f);
        if (r121.longValue() > 0) goto L44;
        r105 = false;
    L44:
        if (r105 == false) goto L46;
        r107 = r121;
    L46:
        if (r107 == null) goto L48;
        r111 = r107.longValue();
        goto L49
    L48:
        r111 = r110.f485039a;
        goto L49
    L5:
        if (r101 <= 0) goto L8;
        this.f546328g.put(Integer.valueOf(r100), Long.valueOf(r101));
        goto L8
    }

    public final void e(String r100) {
        Object r101 = this.f546325d;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if ((!this.f546327f.isEmpty()) == false) goto L7;
    L17:
        monitor-exit(r101);
        return;
    L7:
        if (this.f546329h > 0) goto L17;
        if (this.f546326e.compareAndSet(false, true) == true) goto L13;
        monitor-exit(r101);
        return;
    L13:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        FLogger.f375446a.i("WakeupCaptureSession", "release session reason=".concat(r100));
        this.f546331j.a();
        this.f546323b.invoke(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [tia.o] */
    public r(hga.f r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "firstTrigger");
        Intrinsics.checkNotNullParameter(r101, "onSessionReleased");
        this.f546322a = r100;
        this.f546323b = r101;
        f r102 = new f();
        this.f546324c = r102;
        this.f546325d = new Object();
        this.f546326e = new AtomicBoolean(false);
        this.f546327f = new CopyOnWriteArraySet();
        this.f546328g = new ConcurrentHashMap();
        this.f546331j = new c(r102, new o(this));
    }

    public static void c(hga.f r310, byte[] r311, long r312, long r313, long r410) {
        if (r310.f485040b == WakeupAudioCaptureTriggerType.VOICE_WAKEUP) goto L6;
        return;
    L6:
        if (r311.length != 0) goto L8;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L25;
        FLogger.f375446a.i("WakeupCaptureSession", "truth upload dispatch empty audio trigger=" + r310);
    L25:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        ObricWakeupTruthUploadDelegate r102 = ObricWakeupTruthUploadDelegate.f392845b;     // Catch: Throwable -> L18
        String r314 = "WakeupCaptureSession";
        r102.e(new hga.g(r310.f485042d, r310.f485039a, r313, r313 - 4800, r410, r311, tia.a.a(r312), r310.f485049k, r310.f485050l, r310.f485051m, r310.f485052n, r310.f485045g, r310.f485046h, r310.f485047i, r310.f485048j, r310.f485053o, r310.f485054p, r310.f485055q, r310.f485056r, r102.g(r310.f485042d), r310.f485057s, r310.f485058t));     // Catch: Throwable -> L16
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L21:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L29;
        FLogger.f375446a.e(r314, "truth upload dispatch failed", r104);
        return;
    L29:
        return;
    L16:
        th = th;
    L20:
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        th = th;
        r314 = "WakeupCaptureSession";
        goto L20
    L8:
        r100 = false;
        goto L10
    }
}
