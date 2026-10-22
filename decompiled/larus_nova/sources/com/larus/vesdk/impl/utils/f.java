package com.larus.vesdk.impl.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.lens.VELumaDetectParams;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VERecorder f375622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f375623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f375624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f375625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f375626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<pq9.c> f375627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f375628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f375629h;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f375630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f375631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f375632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f375633d;

        public static final class a implements VERecorder.VERecorderLensCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f375634a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f375635b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f f375636c;

            @Override // com.ss.android.vesdk.VERecorder.VERecorderLensCallback
            public final void onInfo(int r100, int r101, int r102, String r103) {
            }

            public a(b r100, long r101, f r102) {
                this.f375634a = r100;
                this.f375635b = r101;
                this.f375636c = r102;
            }

            @Override // com.ss.android.vesdk.VERecorder.VERecorderLensCallback
            public final void onError(int r100, int r101, String r102) {
                b r103 = this.f375634a;
                if (r103.f375632c == false) goto L5;
                return;
            L5:
                r103.f375632c = true;
                FLogger.f375446a.e("VeLumaDetector", "onError, msg:" + r102);
                this.f375636c.f375629h.onResult(false);
                this.f375634a.b();
            }

            @Override // com.ss.android.vesdk.VERecorder.VERecorderLensCallback
            public final void onSuccess(int r100, float r101, int r102) {
                final b r103 = this.f375634a;
                if (r103.f375632c == false) goto L5;
                return;
            L5:
                final long r104 = this.f375635b;
                final f r105 = this.f375636c;
                Function1 r106 = new g(r103, r104, r105);
                r103.f375630a++;
                if (Math.abs(((double) r101) - 1.0d) <= 1.0E-5d) goto L8;
                boolean r107 = true;
            L9:
                if (r107 == false) goto L14;
                int r108 = r103.f375631b + 1;
                r103.f375631b = r108;
                if (r108 < 5) goto L14;
                r106.invoke(Boolean.TRUE);
                return;
            L14:
                if (r103.f375630a < 10) goto L18;
                r106.invoke(Boolean.FALSE);
                return;
            L18:
                return;
            L8:
                r107 = false;
                goto L9
            }
        }

        public final void a() {
            if (this.f375633d.f375623b.invoke().booleanValue() == true) goto L6;
            FLogger.f375446a.i("VeLumaDetector", "camera is not previewing, no support detect");
            this.f375633d.f375629h.onResult(false);
            b();
            return;
        L6:
            long r100 = System.currentTimeMillis();
            VELumaDetectParams r101 = new VELumaDetectParams();
            r101.algorithmFlag = 27;
            r101.detectFrames = 10;
            f r102 = this.f375633d;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
            r102.f375622a.setLensParams(r101, new a(this, r100, r102));     // Catch: Throwable -> L9
            Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            f r105 = this.f375633d;
            Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
            if (r106 != null) goto L14;
            return;
        L14:
            if (this.f375632c == false) goto L16;
            return;
        L16:
            this.f375632c = true;
            FLogger.f375446a.e("VeLumaDetector", "setLensParams failed", r106);
            r105.f375629h.onResult(false);
            b();
            return;
        L9:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public final void b() {
            this.f375633d.f375625d.removeCallbacksAndMessages(null);
            if ((!this.f375633d.f375627f.isEmpty()) == true) goto L5;
        L7:
            this.f375633d.b();
            return;
        L5:
            if (this.f375633d.f375623b.invoke().booleanValue() == false) goto L7;
            f r100 = this.f375633d;
            r100.f375625d.postDelayed(new b(r100), 1000);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(f r100) {
            this.f375633d = r100;
        }
    }

    static {
    }

    public final void b() {
        this.f375626e = null;
        this.f375627f.clear();
        this.f375624c.set(false);
        this.f375625d.removeCallbacksAndMessages(null);
        FLogger.f375446a.i("VeLumaDetector", "release detect");
    }

    public final void a(pq9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f375627f.add(r100);
        if (this.f375624c.getAndSet(true) == true) goto L6;
        this.f375625d.post(new b(this));
        FLogger.f375446a.i("VeLumaDetector", "start detect");
        return;
    }

    public f(VERecorder r100, com.larus.vesdk.impl.camera.j r101) {
        Intrinsics.checkNotNullParameter(r100, SpeechEngineDefines.RECORDER_ENGINE);
        Intrinsics.checkNotNullParameter(r101, "isPreviewing");
        this.f375622a = r100;
        this.f375623b = r101;
        this.f375624c = new AtomicBoolean(false);
        this.f375625d = new Handler(Looper.getMainLooper());
        this.f375627f = new CopyOnWriteArrayList();
        this.f375628g = z2.f365865a.enableCameraLumaDetectOpt();
        this.f375629h = new i(this);
    }
}
