package com.larus.audio.call.record;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.record.AudioRecordType;
import com.larus.audio.record.factory.IAudioRecorderFactory;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class f extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile r58.c f289573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f289574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f289575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile b f289576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f289577i;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ f f289578v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ Function2<r58.d, byte[], Unit> f289579w;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();     // Catch: Throwable -> L6
            r58.c r100 = this.f289578v.f289573e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.k(this.f289579w);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(f r100, Function2<? super r58.d, ? super byte[], Unit> r101) {
            this.f289578v = r100;
            this.f289579w = r101;
            super("flow-audio-recorder");
        }
    }

    static {
    }

    @Override // v68.a
    public void release() {
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i("AudioRecorderWrapper", "release");
        stopRecord();
        b r101 = this.f289576h;
        if (r101 == null) goto L5;
        r101.interrupt();
    L5:
        StringBuilder r102 = new StringBuilder("audioRecordThread name is >>>");
        b r103 = this.f289576h;
        if (r103 == null) goto L8;
        String r104 = r103.getName();
    L9:
        r102.append(r104);
        r102.append(", id is >>>");
        b r105 = this.f289576h;
        if (r105 == null) goto L12;
        Long r106 = Long.valueOf(r105.getId());
    L13:
        r102.append(r106);
        r102.append(", interrupted status is >>>");
        b r107 = this.f289576h;
        if (r107 == null) goto L16;
        Boolean r108 = Boolean.valueOf(r107.isInterrupted());
    L17:
        r102.append(r108);
        r100.i("AudioRecorderWrapper", r102.toString());
        r58.c r109 = this.f289573e;
        if (r109 == null) goto L20;
        r109.release();
    L20:
        this.f289573e = null;
        this.f289577i = false;
        this.f289567d.a();
        return;
    L16:
        r108 = null;
        goto L17
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    @Override // v68.a
    public void stopRecord() {
        com.larus.audio.call.util.e.f289645a.i("AudioRecorderWrapper", "stop record");
        this.f289564a = false;
        r58.c r100 = this.f289573e;     // Catch: Exception -> L7
        if (r100 == null) goto L12;
        r100.stop();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e("AudioRecorderWrapper", "audioRecord stop failed.", e);
    }

    @Override // v68.a
    public final void e(Function0<Unit> r100) {
        r58.c r101 = this.f289573e;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    @Override // v68.a
    public boolean start(Function1<? super Exception, Unit> r100) {
        com.larus.audio.call.util.e.f289645a.i("AudioRecorderWrapper", "start record " + this.f289564a);
        boolean r101 = true;
        if (this.f289564a == false) goto L5;
        return true;
    L5:
        this.f289564a = true;
        r58.c r102 = this.f289573e;     // Catch: Exception -> L10
        if (r102 == null) goto L18;
        r102.start();     // Catch: Exception -> L10
    L18:
        return r101;
    L10:
        stopRecord();     // Catch: Exception -> L14
        r58.c r103 = this.f289573e;     // Catch: Exception -> L14
        if (r103 == null) goto L18;
        r103.start();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e("AudioRecorderWrapper", "audioRecord start failed.", e);
        r101 = false;
        this.f289564a = false;
        if (r100 == null) goto L18;
        r100.invoke(e);
        goto L18
    }

    @Override // v68.a
    public void d(v58.a r110, Function2<? super r58.d, ? super byte[], Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "onAudioDataReceived");
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i("AudioRecorderWrapper", "init() audioRecorderConfig: " + r110);
        if (this.f289577i == true) goto L38;
        boolean r101 = true;
        this.f289577i = true;
        if (this.f289573e != null) goto L12;
        this.f289573e = ((IAudioRecorderFactory) ServiceManager.get().getService(IAudioRecorderFactory.class)).a(AudioRecordType.AudioRecord, MapsKt.mapOf(new Pair[]{TuplesKt.to(PerfLog.PARAM_KEY_CONTEXT_ID, AppHost.f326268a.getApplication()), TuplesKt.to("bufferSize", Integer.valueOf(this.f289574f))}));
        if (r110 != null) goto L9;
        com.larus.audio.call.g r112 = com.larus.audio.call.f.f289121a;
        r110 = com.larus.audio.call.f.b(this.f289575g);
    L9:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f289565b = r110;
        r58.c r113 = this.f289573e;
        if (r113 == null) goto L12;
        r113.h(this.f289565b);
    L12:
        b r114 = this.f289576h;
        if (r114 != null) goto L15;
    L17:
        r101 = false;
    L18:
        if (r101 == false) goto L23;
        r100.w("AudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it start");
        b r115 = this.f289576h;
        if (r115 == null) goto L22;
        r115.interrupt();
    L22:
        r100.w("AudioRecorderWrapper", "AudioRecorder thread is alive, interrupt it end");
    L23:
        this.f289576h = new b(this, r111);
    L33:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e("AudioRecorderWrapper", "AudioRecorder start thread failed.", e);
        return;
    L25:
        if (com.larus.audio.call.f.d().f289135k == false) goto L29;
        b r116 = this.f289576h;     // Catch: Exception -> L33
        if (r116 == null) goto L29;
        ThreadMethodProxy.setPriority(r116, 10);     // Catch: Exception -> L33
    L29:
        b r117 = this.f289576h;     // Catch: Exception -> L33
        if (r117 == null) goto L39;
        ThreadMethodProxy.start(r117);     // Catch: Exception -> L33
        return;
    L39:
        return;
    L15:
        if (ThreadMethodProxy.isAlive(r114) != true) goto L17;
    }

    public f(r58.c r100, int r101, boolean r102) {
        super(r102);
        this.f289573e = r100;
        this.f289574f = r101;
        this.f289575g = r102;
    }

    public /* synthetic */ f(r58.c r100, int r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = -1;
    L8:
        this(r100, r101, r102);
    }
}
