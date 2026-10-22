package com.larus.audio.audiov3.task.sami.v2;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.audio.audiov3.config.BusinessTypeEnum;
import com.larus.audio.audiov3.config.ConnectStatusEnum;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.audio.audiov3.task.asr.AsrState;
import com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore;
import com.larus.audio.audiov3.task.sami.v2.flow.MockEventType;
import com.larus.audio.utils.g1;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class x implements h68.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f288647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f288648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f288649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile com.larus.audio.audiov3.task.sami.v2.flow.a f288650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public y58.a f288651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h68.d f288652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f288653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f288654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f288655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AsrState f288656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ReentrantLock f288657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConnectStatusEnum f288658n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile int f288659o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f288660p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f288661q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f288662r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f288663s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f288664t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile String f288665u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile String f288666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile String f288667w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f288668x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f288669y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.larus.audio.report.h f288670z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f288671a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[SAMICoreCallBackEventType.SessionCanceled.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[SAMICoreCallBackEventType.ASRResponse.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[SAMICoreCallBackEventType.ASREnded.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[SAMICoreCallBackEventType.AudioUploadEnded.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f288671a = r100;
        }
    }

    static {
    }

    @Override // h68.e
    public final void cancel() {
        this.f288649e = true;
        String r100 = "";
        String r101 = null;
        if (this.f288656l == AsrState.ASR_STARTED) goto L22;
        m58.k r102 = c68.a.d("cancel AsrTask Failed because it has not been started");
        if (r102 == null) goto L49;
        com.larus.audio.utils.b r103 = (com.larus.audio.utils.b) r102;
        r103.c(i(new p(this)));
        r103.d("AsrTask.cancel");
        y58.a r104 = this.f288651g;
        if (r104 == null) goto L11;
        y58.d r105 = r104.f566267z;
        if (r105 == null) goto L11;
        String r106 = r105.f566280a;
    L12:
        if (r106 == null) goto L15;
        r100 = r106;
    L15:
        r103.b(CollectionsKt.listOf(r100));
        y58.a r107 = this.f288651g;
        if (r107 == null) goto L20;
        y58.d r108 = r107.f566267z;
        if (r108 == null) goto L20;
        r101 = r108.f566281b;
    L20:
        r103.e(r101);
        m58.k.a.a(r103);
        return;
    L11:
        r106 = null;
        goto L12
    L49:
        return;
    L22:
        ReentrantLock r109 = this.f288657m;
        if (r109 == null) goto L25;
        r109.lock();
    L25:
        a0 r110 = a0.f288553a;
        String r111 = this.f288645a;
        com.larus.audio.audiov3.task.sami.v2.flow.a r112 = this.f288650f;
        r110.getClass();
        final int r113 = a0.a(r111, r112);
        m58.k r114 = c68.a.c("cancel AsrTask");
        if (r114 == null) goto L42;
        com.larus.audio.utils.b r115 = (com.larus.audio.utils.b) r114;
        r115.c(i(new q(this, r113)));
        r115.d("AsrTask.cancel");
        y58.a r116 = this.f288651g;
        if (r116 == null) goto L32;
        y58.d r117 = r116.f566267z;
        if (r117 == null) goto L32;
        String r118 = r117.f566280a;
    L33:
        if (r118 == null) goto L36;
        r100 = r118;
    L36:
        r115.b(CollectionsKt.listOf(r100));
        y58.a r119 = this.f288651g;
        if (r119 == null) goto L41;
        y58.d r120 = r119.f566267z;
        if (r120 == null) goto L41;
        r101 = r120.f566281b;
    L41:
        r115.e(r101);
        m58.k.a.a(r115);
    L32:
        r118 = null;
    L42:
        ReentrantLock r121 = this.f288657m;
        if (r121 == null) goto L45;
        r121.unlock();
    L45:
        AsrState r122 = AsrState.ASR_STOP;
        this.f288656l = r122;
        h68.d r123 = this.f288652h;
        if (r123 == null) goto L50;
        r123.e(r122);
        return;
    }

    @Override // h68.e
    public final void release() {
        this.f288654j = false;
        m58.k r100 = c68.a.c("release sami session");
        if (r100 == null) goto L20;
        com.larus.audio.utils.b r101 = (com.larus.audio.utils.b) r100;
        r101.c(i(new com.larus.audio.audiov3.task.sami.v2.a(this)));
        r101.d("AsrTask.startSession");
        y58.a r102 = this.f288651g;
        if (r102 == null) goto L9;
        y58.d r103 = r102.f566267z;
        if (r103 == null) goto L9;
        String r104 = r103.f566280a;
    L10:
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        r101.b(CollectionsKt.listOf(r104));
        y58.a r105 = this.f288651g;
        if (r105 == null) goto L17;
        y58.d r106 = r105.f566267z;
        if (r106 == null) goto L17;
        String r107 = r106.f566281b;
    L18:
        r101.e(r107);
        m58.k.a.a(r101);
    L17:
        r107 = null;
    L9:
        r104 = null;
    L20:
        if (this.f288648d == false) goto L23;
        z.a().e(this.f288650f, this.f288658n);
        return;
    L23:
        final com.larus.audio.audiov3.task.sami.v2.flow.a r108 = this.f288650f;
        this.f288650f = null;
        ((ExecutorService) g1.f290035b.getValue()).submit(new l(this, r108));
    }

    @Override // h68.e
    public final synchronized void stop() {
        monitor-enter(this);
        String r100 = null;
        if (this.f288656l == AsrState.ASR_STARTED) goto L23;
        m58.k r101 = c68.a.d("stop AsrTask Failed because it has not been started");     // Catch: Throwable -> L53
        if (r101 == null) goto L21;
        com.larus.audio.utils.b r102 = (com.larus.audio.utils.b) r101;     // Catch: Throwable -> L53
        r102.c(i(new r(this)));     // Catch: Throwable -> L53
        r102.d("AsrTask.stop");     // Catch: Throwable -> L53
        y58.a r103 = this.f288651g;     // Catch: Throwable -> L53
        if (r103 == null) goto L12;
        y58.d r104 = r103.f566267z;     // Catch: Throwable -> L53
        if (r104 == null) goto L12;
        String r105 = r104.f566280a;     // Catch: Throwable -> L53
    L13:
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r102.b(CollectionsKt.listOf(r105));     // Catch: Throwable -> L53
        y58.a r106 = this.f288651g;     // Catch: Throwable -> L53
        if (r106 == null) goto L20;
        y58.d r107 = r106.f566267z;     // Catch: Throwable -> L53
        if (r107 == null) goto L20;
        r100 = r107.f566281b;     // Catch: Throwable -> L53
    L20:
        r102.e(r100);     // Catch: Throwable -> L53
        m58.k.a.a(r102);     // Catch: Throwable -> L53
    L12:
        r105 = null;
    L21:
        monitor-exit(this);
        return;
    L23:
        ReentrantLock r108 = this.f288657m;     // Catch: Throwable -> L53
        if (r108 == null) goto L26;
        r108.lock();     // Catch: Throwable -> L53
    L26:
        a0 r109 = a0.f288553a;     // Catch: Throwable -> L53
        String r110 = this.f288645a;     // Catch: Throwable -> L53
        com.larus.audio.audiov3.task.sami.v2.flow.a r111 = this.f288650f;     // Catch: Throwable -> L53
        r109.getClass();     // Catch: Throwable -> L53
        final int r112 = a0.b(r110, r111);     // Catch: Throwable -> L53
        m58.k r113 = c68.a.c("stop AsrTask");     // Catch: Throwable -> L53
        if (r113 == null) goto L42;
        com.larus.audio.utils.b r114 = (com.larus.audio.utils.b) r113;     // Catch: Throwable -> L53
        r114.c(i(new s(this, r112)));     // Catch: Throwable -> L53
        r114.d("AsrTask.stop");     // Catch: Throwable -> L53
        y58.a r115 = this.f288651g;     // Catch: Throwable -> L53
        if (r115 == null) goto L33;
        y58.d r116 = r115.f566267z;     // Catch: Throwable -> L53
        if (r116 == null) goto L33;
        String r117 = r116.f566280a;     // Catch: Throwable -> L53
    L34:
        if (r117 != null) goto L36;
        r117 = "";
    L36:
        r114.b(CollectionsKt.listOf(r117));     // Catch: Throwable -> L53
        y58.a r118 = this.f288651g;     // Catch: Throwable -> L53
        if (r118 == null) goto L41;
        y58.d r119 = r118.f566267z;     // Catch: Throwable -> L53
        if (r119 == null) goto L41;
        r100 = r119.f566281b;     // Catch: Throwable -> L53
    L41:
        r114.e(r100);     // Catch: Throwable -> L53
        m58.k.a.a(r114);     // Catch: Throwable -> L53
    L33:
        r117 = null;
    L42:
        m58.u r120 = m58.h.f512141l;     // Catch: Throwable -> L53
        if (r120 == null) goto L45;
        m58.u.a.b(r120, this.f288645a, "asr_touch_up_to_send_end_asr", null, null, null, 28);     // Catch: Throwable -> L53
    L45:
        ReentrantLock r121 = this.f288657m;     // Catch: Throwable -> L53
        if (r121 == null) goto L48;
        r121.unlock();     // Catch: Throwable -> L53
    L48:
        AsrState r122 = AsrState.ASR_STOP;     // Catch: Throwable -> L53
        this.f288656l = r122;     // Catch: Throwable -> L53
        h68.d r123 = this.f288652h;     // Catch: Throwable -> L53
        if (r123 == null) goto L51;
        r123.e(r122);     // Catch: Throwable -> L53
    L51:
        monitor-exit(this);
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public final void l() {
        int r100 = c68.b.f22600a;
        c68.b.b(this.f288646b, h(this + " handleAsrCancel" + b0.a(this.f288650f)));
        String r101 = this.f288655k;
        y58.a r102 = this.f288651g;
        if (r102 == null) goto L7;
        Long r103 = r102.f566251j;
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L8:
        long r105 = r104;
        h68.d r106 = this.f288652h;
        if (r106 == null) goto L18;
        y58.a r107 = this.f288651g;
        if (r107 == null) goto L13;
        String r108 = r107.f566243b;
    L14:
        if (r108 != null) goto L16;
        String r109 = "";
    L17:
        r106.a(new y58.b(r109, null, "asr_cancel", r101, this.f288660p, r105, AsrResultState.SUCCESS, AsrEventEnum.ASR_CANCEL, null, 256));
        goto L18
    L16:
        r109 = r108;
        goto L17
    L13:
        r108 = null;
    L18:
        this.f288655k = "";
        return;
    L7:
        r104 = this.f288662r;
        goto L8
    }

    public final void n() {
        y58.a r100 = this.f288651g;
        if (r100 == null) goto L7;
        Long r101 = r100.f566251j;
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        long r103 = r102;
        h68.d r104 = this.f288652h;
        if (r104 == null) goto L18;
        y58.a r105 = this.f288651g;
        if (r105 == null) goto L13;
        String r106 = r105.f566243b;
    L14:
        if (r106 != null) goto L16;
        String r107 = "";
    L17:
        r104.a(new y58.b(r107, 0, "", this.f288655k, this.f288660p, r103, AsrResultState.SUCCESS, AsrEventEnum.ASR_SUCCESS, new y58.c(this.f288665u, this.f288666v, this.f288667w)));
        String r108 = "";
    L19:
        this.f288660p = r108;
        this.f288655k = r108;
        ReentrantLock r109 = this.f288657m;
        if (r109 == null) goto L22;
        r109.lock();
    L22:
        a0 r110 = a0.f288553a;
        y58.a r111 = this.f288651g;
        if (r111 == null) goto L25;
        String r112 = r111.f566243b;
    L26:
        com.larus.audio.audiov3.task.sami.v2.flow.a r113 = this.f288650f;
        r110.getClass();
        a0.d(r112, r113);
        ReentrantLock r114 = this.f288657m;
        if (r114 == null) goto L30;
        r114.unlock();
        return;
    L30:
        return;
    L25:
        r112 = null;
        goto L26
    L16:
        r107 = r106;
        goto L17
    L13:
        r106 = null;
        goto L14
    L18:
        r108 = "";
    L7:
        r102 = this.f288662r;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.larus.audio.audiov3.task.sami.v2.j] */
    @Override // h68.e
    public final void start() {
        String r100 = "";
        String r101 = null;
        if (this.f288656l != AsrState.ASR_STARTED) goto L22;
        m58.k r102 = c68.a.d("start AsrTask Failed because it has been started");
        if (r102 == null) goto L221;
        com.larus.audio.utils.b r103 = (com.larus.audio.utils.b) r102;
        r103.c(i(new t(this)));
        r103.d("AsrTask.start");
        y58.a r104 = this.f288651g;
        if (r104 == null) goto L11;
        y58.d r105 = r104.f566267z;
        if (r105 == null) goto L11;
        String r106 = r105.f566280a;
    L12:
        if (r106 == null) goto L15;
        r100 = r106;
    L15:
        r103.b(CollectionsKt.listOf(r100));
        y58.a r107 = this.f288651g;
        if (r107 == null) goto L20;
        y58.d r108 = r107.f566267z;
        if (r108 == null) goto L20;
        r101 = r108.f566281b;
    L20:
        r103.e(r101);
        m58.k.a.a(r103);
        return;
    L11:
        r106 = null;
        goto L12
    L221:
        return;
    L22:
        this.f288654j = true;
        this.f288661q = SystemClock.elapsedRealtime();
        this.f288667w = "";
        this.f288663s = false;
        ReentrantLock r109 = this.f288657m;
        if (r109 == null) goto L25;
        r109.lock();
    L25:
        j(ConnectStatusEnum.DISABLE);
        m58.k r110 = c68.a.c("before start sami session");
        if (r110 == null) goto L42;
        com.larus.audio.utils.b r111 = (com.larus.audio.utils.b) r110;
        r111.c(i(new com.larus.audio.audiov3.task.sami.v2.b(this)));
        r111.d("AsrTask.startSession");
        y58.a r112 = this.f288651g;
        if (r112 == null) goto L32;
        y58.d r113 = r112.f566267z;
        if (r113 == null) goto L32;
        String r114 = r113.f566280a;
    L33:
        if (r114 != null) goto L35;
        r114 = "";
    L35:
        r111.b(CollectionsKt.listOf(r114));
        y58.a r115 = this.f288651g;
        if (r115 == null) goto L40;
        y58.d r116 = r115.f566267z;
        if (r116 == null) goto L40;
        String r117 = r116.f566281b;
    L41:
        r111.e(r117);
        m58.k.a.a(r111);
    L40:
        r117 = null;
    L32:
        r114 = null;
    L42:
        y58.a r118 = this.f288651g;
        if (r118 != null) goto L45;
    L47:
        boolean r119 = false;
    L48:
        if (r119 == true) goto L69;
        if (r118 != null) goto L51;
    L53:
        boolean r120 = false;
    L54:
        if (r120 == true) goto L69;
        if (r118 != null) goto L57;
    L59:
        boolean r121 = false;
    L60:
        if (r121 == true) goto L69;
        if (r118 != null) goto L63;
    L65:
        boolean r122 = false;
    L66:
        if (r122 == true) goto L69;
        boolean r123 = false;
    L70:
        if (r123 == false) goto L72;
        com.larus.audio.audiov3.task.sami.v2.flow.a r124 = null;
    L73:
        m58.q r125 = m58.h.f512133d;
        if (r125 == null) goto L78;
        ASRModule r126 = r125.c();
        if (r126 == null) goto L78;
        int r127 = r126.b();
    L79:
        m58.q r128 = m58.h.f512133d;
        if (r128 == null) goto L86;
        ASRModule r129 = r128.c();
        if (r129 == null) goto L86;
        if (r129.m() != true) goto L86;
        boolean r130 = true;
    L87:
        if (r130 == true) goto L89;
    L139:
        if (r124 == null) goto L160;
        this.f288648d = true;
        this.f288658n = z.a().f288540a;
        this.f288650f = r124;
        m58.u r131 = m58.h.f512141l;
        if (r131 == null) goto L143;
        r131.i(this.f288645a, new d(this));
    L143:
        m58.k r132 = c68.a.c("start sami connect use cached SAMICore");
        if (r132 == null) goto L181;
        com.larus.audio.utils.b r133 = (com.larus.audio.utils.b) r132;
        r133.c(i(new e(this)));
        r133.d("AsrTask.startSession");
        y58.a r134 = this.f288651g;
        if (r134 == null) goto L150;
        y58.d r135 = r134.f566267z;
        if (r135 == null) goto L150;
        String r136 = r135.f566280a;
    L151:
        if (r136 != null) goto L153;
        r136 = "";
    L153:
        r133.b(CollectionsKt.listOf(r136));
        y58.a r137 = this.f288651g;
        if (r137 == null) goto L158;
        y58.d r138 = r137.f566267z;
        if (r138 == null) goto L158;
        String r139 = r138.f566281b;
    L159:
        r133.e(r139);
        m58.k.a.a(r133);
    L158:
        r139 = null;
    L150:
        r136 = null;
    L181:
        this.f288653i = new j(this);
        com.larus.audio.audiov3.task.sami.v2.flow.a r140 = this.f288650f;
        if (r140 == null) goto L184;
        r140.setListener(this.f288653i);
    L184:
        m58.u r141 = m58.h.f512141l;
        if (r141 == null) goto L187;
        String r142 = r141.l(this.f288645a);
    L188:
        a0 r143 = a0.f288553a;
        BusinessTypeEnum r144 = BusinessTypeEnum.ASR;
        y58.a r145 = this.f288651g;
        if (r145 == null) goto L191;
        x58.a r146 = r145.C;
    L192:
        final int r147 = a0.l(r143, r144, r146, r145, null, this.f288650f, r142);
        m58.k r148 = c68.a.c("after start sami session");
        if (r148 == null) goto L209;
        com.larus.audio.utils.b r149 = (com.larus.audio.utils.b) r148;
        r149.c(i(new h(this, r147)));
        r149.d("AsrTask.startSession");
        y58.a r150 = this.f288651g;
        if (r150 == null) goto L199;
        y58.d r151 = r150.f566267z;
        if (r151 == null) goto L199;
        String r152 = r151.f566280a;
    L200:
        if (r152 == null) goto L203;
        r100 = r152;
    L203:
        r149.b(CollectionsKt.listOf(r100));
        y58.a r153 = this.f288651g;
        if (r153 == null) goto L208;
        y58.d r154 = r153.f566267z;
        if (r154 == null) goto L208;
        r101 = r154.f566281b;
    L208:
        r149.e(r101);
        m58.k.a.a(r149);
    L199:
        r152 = null;
    L209:
        ReentrantLock r155 = this.f288657m;
        if (r155 == null) goto L212;
        r155.unlock();
    L212:
        AsrState r156 = AsrState.ASR_STARTED;
        this.f288656l = r156;
        h68.d r157 = this.f288652h;
        if (r157 == null) goto L222;
        r157.e(r156);
        return;
    L222:
        return;
    L191:
        r146 = null;
        goto L192
    L187:
        r142 = null;
        goto L188
    L160:
        this.f288648d = false;
        this.f288650f = new com.larus.audio.audiov3.task.sami.v2.flow.a();
        a0 r158 = a0.f288553a;
        y58.a r159 = this.f288651g;
        if (r159 == null) goto L163;
        x58.a r160 = r159.C;
    L164:
        com.larus.audio.audiov3.task.sami.v2.flow.a r161 = this.f288650f;
        Function0 r162 = new f(this);
        r158.getClass();
        final int r163 = a0.f(r160, r161, r162);
        m58.k r164 = c68.a.c("start sami connect use new SAMICore");
        if (r164 == null) goto L181;
        com.larus.audio.utils.b r165 = (com.larus.audio.utils.b) r164;
        r165.c(i(new g(this, r163)));
        r165.d("AsrTask.startSession");
        y58.a r166 = this.f288651g;
        if (r166 == null) goto L171;
        y58.d r167 = r166.f566267z;
        if (r167 == null) goto L171;
        String r168 = r167.f566280a;
    L172:
        if (r168 != null) goto L174;
        r168 = "";
    L174:
        r165.b(CollectionsKt.listOf(r168));
        y58.a r169 = this.f288651g;
        if (r169 == null) goto L179;
        y58.d r170 = r169.f566267z;
        if (r170 == null) goto L179;
        String r171 = r170.f566281b;
    L180:
        r165.e(r171);
        m58.k.a.a(r165);
    L179:
        r171 = null;
    L171:
        r168 = null;
        goto L172
    L163:
        r160 = null;
        goto L164
    L89:
        if (r127 > 0) goto L91;
        if (r127 != (-1)) goto L139;
    L91:
        this.f288648d = false;
        m58.q r172 = m58.h.f512133d;
        if (r172 == null) goto L96;
        ASRModule r173 = r172.c();
        if (r173 == null) goto L96;
        final long r174 = r173.f();
    L97:
        m58.q r175 = m58.h.f512133d;
        if (r175 == null) goto L102;
        ASRModule r176 = r175.c();
        if (r176 == null) goto L102;
        final int r177 = r176.g();
    L103:
        if (r127 == (-1)) goto L109;
        m58.q r178 = m58.h.f512133d;
        if (r178 == null) goto L109;
        ASRModule r179 = r178.c();
        if (r179 == null) goto L109;
        r179.a(r127 - 1);
    L109:
        FlowMockSamiCore r180 = new FlowMockSamiCore();
        r180.f288569d = r174;
        MockEventType.Companion.getClass();
        Iterator<MockEventType> r181 = MockEventType.getEntries().iterator();
    L111:
        if (r181.hasNext() == false) goto L118;
        MockEventType r182 = r181.next();
        if (r182.getType() != r177) goto L115;
        boolean r183 = true;
    L116:
        if (r183 == false) goto L111;
    L119:
        MockEventType r184 = r182;
        if (r184 != null) goto L122;
        r184 = MockEventType.NONE;
    L122:
        r180.f288568c = r184;
        this.f288650f = r180;
        m58.k r185 = c68.a.c("start sami connect use mock sami core");
        if (r185 == null) goto L181;
        com.larus.audio.utils.b r186 = (com.larus.audio.utils.b) r185;
        r186.c(i(new c(this, r174, r177)));
        r186.d("AsrTask.startSession");
        y58.a r187 = this.f288651g;
        if (r187 == null) goto L129;
        y58.d r188 = r187.f566267z;
        if (r188 == null) goto L129;
        String r189 = r188.f566280a;
    L130:
        if (r189 != null) goto L132;
        r189 = "";
    L132:
        r186.b(CollectionsKt.listOf(r189));
        y58.a r190 = this.f288651g;
        if (r190 == null) goto L137;
        y58.d r191 = r190.f566267z;
        if (r191 == null) goto L137;
        String r192 = r191.f566281b;
    L138:
        r186.e(r192);
        m58.k.a.a(r186);
    L137:
        r192 = null;
    L129:
        r189 = null;
        goto L130
    L115:
        r183 = false;
        goto L116
    L118:
        r182 = null;
    L102:
        r177 = 0;
    L96:
        r174 = 0;
    L86:
        r130 = false;
    L78:
        r127 = 0;
        goto L79
    L72:
        r124 = z.a().d();
        goto L73
    L63:
        if (r118.f566261t != true) goto L65;
        r122 = true;
        goto L66
    L57:
        if (r118.f566253l != 4) goto L59;
        r121 = true;
        goto L60
    L51:
        if (r118.f566253l != 3) goto L53;
        r120 = true;
    L69:
        r123 = true;
        goto L70
    L45:
        if (r118.f566253l != 2) goto L47;
        r119 = true;
        goto L48
    }

    @Override // h68.e
    public final long e() {
        long r100 = SystemClock.elapsedRealtime() - this.f288661q;
        this.f288662r = r100;
        return r100;
    }

    @Override // h68.e
    public final boolean b() {
        return this.f288664t;
    }

    @Override // h68.e
    public final AsrState d() {
        return this.f288656l;
    }

    @Override // h68.e
    public final y58.a getConfig() {
        return this.f288651g;
    }

    @Override // h68.e
    public final String getTaskId() {
        return this.f288645a;
    }

    public final String toString() {
        return this.f288669y;
    }

    public x(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f288645a = r100;
        this.f288646b = "AsrTask";
        this.f288647c = new Gson();
        this.f288654j = true;
        this.f288655k = "";
        this.f288656l = AsrState.ASR_IDLE;
        this.f288657m = new ReentrantLock();
        this.f288658n = ConnectStatusEnum.DISABLE;
        this.f288660p = "";
        this.f288662r = -1;
        this.f288665u = "";
        this.f288666v = "";
        this.f288667w = "";
        this.f288669y = "taskId: null";
    }

    @Override // h68.e
    public final void f(h68.d r100) {
        this.f288652h = r100;
    }

    @Override // h68.e
    public final void g(com.larus.audio.report.h r100) {
        this.f288670z = r100;
    }

    public final String h(String r100) {
        String r101 = this.f288667w;
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L11;
        String r102 = r100 + " asr_log_id=" + r101;
        if (r102 != null) goto L10;
        return r100;
    L10:
        return r102;
    L11:
        return r100;
    }

    public final Map<String, String> i(Function1<? super Map<String, String>, Unit> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r100.invoke(r101);
        String r102 = this.f288667w;
        if ((!StringsKt.isBlank(r102)) == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        r101.put("asr_log_id", r102);
    L8:
        return r101;
    }

    public final void j(ConnectStatusEnum r100) {
        this.f288658n = r100;
        if (this.f288650f != null) goto L5;
        return;
    L5:
        int r101 = c68.b.f22600a;
        c68.b.a(this.f288646b, h(this + " connectStatusEnum:" + r100 + b0.a(this.f288650f)));
    }

    public final void k(Object r100) {
        if ((r100 instanceof y58.a) == false) goto L10;
        y58.a r101 = (y58.a) r100;
        this.f288651g = r101;
        if (r101 == null) goto L8;
        String r102 = r101.f566243b;
        if (r102 == null) goto L8;
    L9:
        this.f288669y = "taskId: ".concat(r102);
        return;
    L8:
        r102 = "null";
        goto L9
    L10:
        int r103 = c68.b.f22600a;
        c68.b.b(this.f288646b, h("#config current asrData is invalidate !!!"));
    }

    public final void m(y58.b r100) {
        if (r100.f566268a.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        h68.d r102 = this.f288652h;
        if (r102 == null) goto L12;
        r102.a(r100);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // h68.e
    public final synchronized int a(byte[] r100, int r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "buffer");     // Catch: Throwable -> L91
        ReentrantLock r102 = this.f288657m;     // Catch: Throwable -> L91
        if (r102 == null) goto L6;
        r102.lock();     // Catch: Throwable -> L91
    L6:
        String r103 = null;
        if (this.f288654j == true) goto L9;
    L69:
        ReentrantLock r104 = this.f288657m;     // Catch: Throwable -> L91
        if (r104 == null) goto L72;
        r104.unlock();     // Catch: Throwable -> L91
    L72:
        m58.k r105 = c68.a.d("write AsrTask Failed because it has not been started");     // Catch: Throwable -> L91
        if (r105 == null) goto L88;
        com.larus.audio.utils.b r106 = (com.larus.audio.utils.b) r105;     // Catch: Throwable -> L91
        r106.c(i(new u(this)));     // Catch: Throwable -> L91
        r106.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r107 = this.f288651g;     // Catch: Throwable -> L91
        if (r107 == null) goto L79;
        y58.d r108 = r107.f566267z;     // Catch: Throwable -> L91
        if (r108 == null) goto L79;
        String r109 = r108.f566280a;     // Catch: Throwable -> L91
    L80:
        if (r109 != null) goto L82;
        r109 = "";
    L82:
        r106.b(CollectionsKt.listOf(r109));     // Catch: Throwable -> L91
        y58.a r110 = this.f288651g;     // Catch: Throwable -> L91
        if (r110 == null) goto L87;
        y58.d r111 = r110.f566267z;     // Catch: Throwable -> L91
        if (r111 == null) goto L87;
        r103 = r111.f566281b;     // Catch: Throwable -> L91
    L87:
        r106.e(r103);     // Catch: Throwable -> L91
        m58.k.a.a(r106);     // Catch: Throwable -> L91
    L79:
        r109 = null;
    L88:
        monitor-exit(this);
        return -1;
    L9:
        if (this.f288656l != AsrState.ASR_STARTED) goto L69;
        if (this.f288663s == true) goto L69;
        com.larus.audio.audiov3.task.sami.v2.flow.a r112 = this.f288650f;     // Catch: Throwable -> L91
        if (r112 != null) goto L15;
    L17:
        boolean r113 = false;
    L18:
        if (r113 == true) goto L69;
        if (this.f288663s == false) goto L43;
        m58.k r114 = c68.a.d("write AsrTask Failed because sessionFinished");     // Catch: Throwable -> L91
        if (r114 == null) goto L38;
        com.larus.audio.utils.b r115 = (com.larus.audio.utils.b) r114;     // Catch: Throwable -> L91
        r115.c(i(new v(this)));     // Catch: Throwable -> L91
        r115.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r116 = this.f288651g;     // Catch: Throwable -> L91
        if (r116 == null) goto L29;
        y58.d r117 = r116.f566267z;     // Catch: Throwable -> L91
        if (r117 == null) goto L29;
        String r118 = r117.f566280a;     // Catch: Throwable -> L91
    L30:
        if (r118 != null) goto L32;
        r118 = "";
    L32:
        r115.b(CollectionsKt.listOf(r118));     // Catch: Throwable -> L91
        y58.a r119 = this.f288651g;     // Catch: Throwable -> L91
        if (r119 == null) goto L37;
        y58.d r120 = r119.f566267z;     // Catch: Throwable -> L91
        if (r120 == null) goto L37;
        r103 = r120.f566281b;     // Catch: Throwable -> L91
    L37:
        r115.e(r103);     // Catch: Throwable -> L91
        m58.k.a.a(r115);     // Catch: Throwable -> L91
    L29:
        r118 = null;
    L38:
        ReentrantLock r121 = this.f288657m;     // Catch: Throwable -> L91
        if (r121 == null) goto L41;
        r121.unlock();     // Catch: Throwable -> L91
    L41:
        monitor-exit(this);
        return 0;
    L43:
        a0 r122 = a0.f288553a;     // Catch: Throwable -> L91
        String r123 = this.f288645a;     // Catch: Throwable -> L91
        com.larus.audio.audiov3.task.sami.v2.flow.a r124 = this.f288650f;     // Catch: Throwable -> L91
        r122.getClass();     // Catch: Throwable -> L91
        final int r125 = a0.n(r123, r100, r101, r124);     // Catch: Throwable -> L91
        if (r125 != 0) goto L48;
        com.larus.audio.report.h r126 = this.f288670z;     // Catch: Throwable -> L91
        if (r126 == null) goto L64;
        r126.p(0);     // Catch: Throwable -> L91
    L64:
        ReentrantLock r127 = this.f288657m;     // Catch: Throwable -> L91
        if (r127 == null) goto L67;
        r127.unlock();     // Catch: Throwable -> L91
    L67:
        monitor-exit(this);
        return r125;
    L48:
        m58.k r128 = c68.a.d("write AsrTask Failed");     // Catch: Throwable -> L91
        if (r128 == null) goto L64;
        com.larus.audio.utils.b r129 = (com.larus.audio.utils.b) r128;     // Catch: Throwable -> L91
        r129.c(i(new w(this, r125)));     // Catch: Throwable -> L91
        r129.d("AsrTask.write");     // Catch: Throwable -> L91
        y58.a r130 = this.f288651g;     // Catch: Throwable -> L91
        if (r130 == null) goto L55;
        y58.d r131 = r130.f566267z;     // Catch: Throwable -> L91
        if (r131 == null) goto L55;
        String r132 = r131.f566280a;     // Catch: Throwable -> L91
    L56:
        if (r132 != null) goto L58;
        r132 = "";
    L58:
        r129.b(CollectionsKt.listOf(r132));     // Catch: Throwable -> L91
        y58.a r133 = this.f288651g;     // Catch: Throwable -> L91
        if (r133 == null) goto L63;
        y58.d r134 = r133.f566267z;     // Catch: Throwable -> L91
        if (r134 == null) goto L63;
        r103 = r134.f566281b;     // Catch: Throwable -> L91
    L63:
        r129.e(r103);     // Catch: Throwable -> L91
        m58.k.a.a(r129);     // Catch: Throwable -> L91
    L55:
        r132 = null;
        goto L56
    L15:
        if (r112.getHandle() != 0) goto L17;
        r113 = true;
    L91:
        th = move-exception;
        throw th;
    }

    @Override // h68.e
    public final void c(String r100, Object r101, Object r110, Object r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof SAMICorePropertyId) == true) goto L5;
        return;
    L5:
        if ((r110 instanceof SAMICoreDataType) == true) goto L7;
        return;
    L7:
        if ((r111 instanceof SAMICoreVoiceAssistantPropertyParameter) == false) goto L24;
        a0 r102 = a0.f288553a;
        y58.a r103 = this.f288651g;
        if (r103 == null) goto L11;
        String r104 = r103.f566243b;
    L12:
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        SAMICorePropertyId r105 = (SAMICorePropertyId) r101;
        SAMICoreDataType r112 = (SAMICoreDataType) r110;
        SAMICoreVoiceAssistantPropertyParameter r113 = (SAMICoreVoiceAssistantPropertyParameter) r111;
        com.larus.audio.audiov3.task.sami.v2.flow.a r106 = this.f288650f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r105, "id");
        Intrinsics.checkNotNullParameter(r112, "type");
        Intrinsics.checkNotNullParameter(r113, "param");
        if (r106 != null) goto L17;
    L20:
        int r107 = c68.b.f22600a;
        c68.b.b("TaskGenerator", "updateScreenshotForAsr failed, context: " + r100 + ", samiCore: " + b0.a(r106));
        return;
    L17:
        if (r106.getHandle() == 0) goto L20;
        int r108 = c68.b.f22600a;
        c68.b.a("TaskGenerator", "updateScreenshotForAsr context: ".concat(r100));
        a0.h(r105, r112, r113, r106);
        return;
    L11:
        r104 = null;
        goto L12
    }
}
