package com.ss.android.lark.audio.recorder;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class LarkAudioRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<p> f409075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<c> f409076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f409077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f409078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.audio.recorder.c f409079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f409080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile k f409081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f409082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f409083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f409084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f409085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Semaphore f409086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ewa.a f409087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Unit> f409088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<Integer, Unit> f409089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.ss.android.lark.audio.recorder.e f409090p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Unit> f409091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f409092r;

    public static final class a {
    }

    public final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkAudioRecorder f409093a;

        public final String toString() {
            return "DestroyRecordCommand";
        }

        public b(LarkAudioRecorder r100) {
            this.f409093a = r100;
        }

        @Override // com.ss.android.lark.audio.recorder.LarkAudioRecorder.c
        public final void a(p r100) {
            p r101 = this.f409093a.b();
            if (r101 == null) goto L5;
            r101.j();
        L5:
            this.f409093a.f409087m.d();
            this.f409093a.f409083i.set(false);
            ((LinkedBlockingQueue) this.f409093a.f409075a).clear();
            ((LinkedBlockingQueue) this.f409093a.f409076b).clear();
            this.f409093a.f409081g = null;
            this.f409093a.d(null);
            Handler r102 = this.f409093a.f409084j;
            if (r102 == null) goto L8;
            Looper r103 = r102.getLooper();
            ThreadMethodProxy.quit(r103);
            ThreadMethodProxy.getLooperThread(r103).interrupt();
        L8:
            Handler r104 = this.f409093a.f409085k;
            if (r104 == null) goto L11;
            Looper r105 = r104.getLooper();
            ThreadMethodProxy.quit(r105);
            ThreadMethodProxy.getLooperThread(r105).interrupt();
        L11:
            LarkAudioRecorder r106 = this.f409093a;
            r106.f409084j = null;
            r106.f409085k = null;
        }
    }

    public interface c {
        void a(p r100);
    }

    public final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkAudioRecorder f409094a;

        public final String toString() {
            return "StartRecordCommand";
        }

        public d(LarkAudioRecorder r100) {
            this.f409094a = r100;
        }

        @Override // com.ss.android.lark.audio.recorder.LarkAudioRecorder.c
        public final void a(p r100) {
            ((LinkedBlockingQueue) this.f409094a.f409075a).put(r100);
            Log.i("LarkAudioRecorder", "[StartRecordCommand]waitStartRecord");
            if (r100 == null) goto L5;
            com.ss.android.lark.audio.recorder.f.a(r100.f409150p);
        L5:
            Log.i("LarkAudioRecorder", "[StartRecordCommand]after waitStartRecord");
        }
    }

    public final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkAudioRecorder f409095a;

        public final String toString() {
            return "StopRecordCommand";
        }

        public e(LarkAudioRecorder r100) {
            this.f409095a = r100;
        }

        @Override // com.ss.android.lark.audio.recorder.LarkAudioRecorder.c
        public final void a(p r100) {
            p r101 = this.f409095a.b();
            if (r101 == null) goto L5;
            r101.j();
        L5:
            ((LinkedBlockingQueue) this.f409095a.f409075a).clear();
            this.f409095a.f409086l.release();
            LarkAudioRecorder r102 = this.f409095a;
            Handler r103 = r102.f409084j;
            if (r103 == null) goto L9;
            r103.removeCallbacks(new g(r102.f409088n));
            return;
        }
    }

    public static final class f implements ewa.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LarkAudioRecorder f409096a;

        public f(LarkAudioRecorder r100) {
            this.f409096a = r100;
        }

        @Override // ewa.b
        public final void a(boolean r100) {
            Log.i("LarkAudioRecorder", "[onPhoneCallStateChange]isCalling:" + r100);
            if (r100 == false) goto L15;
            com.ss.android.lark.audio.recorder.c r101 = this.f409096a.f409079e;
            if (r101 == null) goto L13;
            if (r101 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mRecorderConfig");
            r101 = null;
        L9:
            if (r101.f409119k == false) goto L13;
            k r102 = this.f409096a.f409081g;
            if (r102 == null) goto L16;
            r102.i(ErrorInfo.ERR_INTERRUPT_BY_PHONE);
            return;
        L16:
            return;
        L13:
            LarkAudioRecorder r103 = this.f409096a;
            r103.g(ErrorInfo.ERR_INTERRUPT_BY_PHONE, r103.f409077c);
            this.f409096a.f();
            return;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f409097a;

        public g(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f409097a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f409097a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        Log.i("LarkAudioRecorder", "destroy hashCode:" + hashCode());
        ((LinkedBlockingQueue) this.f409076b).put(new b(this));
    }

    public final p b() {
        Object r100 = this.f409082h;
        monitor-enter(r100);
        p r101 = this.f409077c;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        Log.i("LarkAudioRecorder", "stopRecord hashCode:" + hashCode() + " getCurrentRecordTask:" + b());
        com.ss.android.lark.audio.recorder.e r100 = this.f409090p;
        String r101 = "";
        if (Build.VERSION.SDK_INT < 26) goto L10;
        AudioFocusRequest r102 = r100.f409122c;
        if (r102 == null) goto L9;
        AudioManager r103 = r100.f409121b;
        if (r103 == null) goto L13;
        int r104 = r103.abandonAudioFocusRequest(r102);
    L14:
        if (r104 != 0) goto L17;
        Log.e("AudioRecordFocusHelper", "Abandon Focus Failed: ".concat(r101));
    L17:
        if (b() == null) goto L19;
        ((LinkedBlockingQueue) this.f409076b).put(new e(this));
    L19:
        this.f409087m.d();
        return;
    L13:
        r104 = 0;
        goto L14
    L9:
        r101 = "focusRequest is null";
        goto L13
    L10:
        AudioManager r105 = r100.f409121b;
        if (r105 == null) goto L13;
        r104 = r105.abandonAudioFocus(r100.f409123d);
        goto L14
    }

    public LarkAudioRecorder() {
        this.f409075a = new LinkedBlockingQueue();
        this.f409076b = new LinkedBlockingQueue();
        this.f409078d = new AtomicInteger();
        this.f409082h = new Object();
        this.f409083i = new AtomicBoolean(true);
        this.f409086l = new Semaphore(0);
        this.f409087m = new ewa.a(com.ss.android.lark.a.f408535a.getContext());
        this.f409088n = new LarkAudioRecorder$mTaskHandlerCodeBlock$1(this);
        LarkAudioRecorder$mFocusChangeCallback$1 r100 = LarkAudioRecorder$mFocusChangeCallback$1.INSTANCE;
        this.f409089o = r100;
        this.f409090p = new com.ss.android.lark.audio.recorder.e(com.ss.android.lark.a.f408535a.getContext(), r100);
        this.f409091q = new LarkAudioRecorder$mCommandHandlerCodeBlock$1(this);
        this.f409092r = new f(this);
    }

    public final void c(com.ss.android.lark.audio.recorder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "recorderConfig");
        Log.i("LarkAudioRecorder", "init hashCode:" + hashCode());
        if (this.f409084j != null) goto L8;
        Handler r101 = CoreThreadPool.newThreadHandler("audio_" + r100.f409109a + "_recorder");
        this.f409084j = r101;
        if (r101 == null) goto L8;
        r101.post(new g(this.f409088n));
    L8:
        if (this.f409085k != null) goto L10;
        Handler r102 = CoreThreadPool.newThreadHandler("audio_" + r100.f409109a + "_command");
        r102.post(new g(this.f409091q));
        this.f409085k = r102;
    L10:
        this.f409079e = r100;
        this.f409080f = r100.f409114f;
    }

    public final void d(p r100) {
        Object r101 = this.f409082h;
        monitor-enter(r101);
        this.f409077c = r100;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean e(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "audioFilePath");
        Intrinsics.checkNotNullParameter(r101, "audioRecordListener");
        Log.i("LarkAudioRecorder", "startRecord filePath:" + r100 + " hashCode:" + hashCode());
        this.f409081g = r101;
        this.f409078d.getAndIncrement();
        this.f409083i.set(true);
        f();
        com.ss.android.lark.audio.recorder.e r102 = this.f409090p;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r102.getClass();
        AudioFocusRequest r103 = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build()).setOnAudioFocusChangeListener(r102.f409123d).setAcceptsDelayedFocusGain(true).build();
        r102.f409122c = r103;
        AudioManager r104 = r102.f409121b;
        if (r104 == null) goto L10;
        int r105 = r104.requestAudioFocus(r103);
    L11:
        if (r105 != 0) goto L13;
        Log.e("AudioRecordFocusHelper", "Request AudioFocus Failed");
        boolean r106 = false;
    L14:
        if (r106 == true) goto L17;
        Log.e("LarkAudioRecorder", "[startRecord]can't get system audio focus");
        return false;
    L17:
        this.f409087m.b(this.f409092r);
        com.ss.android.lark.audio.opus.e.d().m(true);
        d(new p(r100, new AtomicInteger(this.f409078d.get())));
        ((LinkedBlockingQueue) this.f409076b).put(new d(this));     // Catch: Exception -> L20
        return true;
    L20:
        e = move-exception;
        Log.e("LarkAudioRecorder", "[startRecord]when put task into queue occur exception:" + e);
        return false;
    L13:
        r106 = true;
    L10:
        r105 = 0;
        goto L11
    L7:
        AudioManager r107 = r102.f409121b;
        if (r107 == null) goto L10;
        r105 = r107.requestAudioFocus(r102.f409123d, 3, 2);
        goto L11
    }

    public final void g(ErrorInfo r100, p r101) {
        if (r101 == null) goto L11;
        Object r102 = r101.f409147m;
        monitor-enter(r102);
        m r103 = r101.f409146l;     // Catch: Throwable -> L8
        monitor-exit(r102);
        r103.b(r101);
    L8:
        th = move-exception;
        throw th;
    L11:
        k r104 = this.f409081g;
        if (r104 == null) goto L17;
        r104.i(r100);
        return;
    }
}
