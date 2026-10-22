package com.ss.android.lark.audio.opus;

import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.SensorConfigHelper;
import com.ss.android.lark.audio.config.AudioSensorConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile e f409006s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d f409007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f409008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue<b> f409009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioManager f409010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f409011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f409012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f409013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.android.lark.audio.e f409014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PowerManager.WakeLock f409015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f409016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f409017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AudioFocusRequest f409018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.android.lark.audio.opus.a f409019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ExecutorService f409020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f409021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.ss.android.lark.audio.c f409022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f409023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AudioPlayerFocusHelper f409024r;

    public interface a {
        void a();

        void b(float r100);

        void pause();

        void resume();

        void start();

        void stop();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f409025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f409026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f409027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile float f409028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f409029e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f409030f;

        public class a implements l.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f409031a;

            public a(b r100) {
                this.f409031a = r100;
            }

            public final void a(float r100) {
                this.f409031a.f409028d = r100;
                a r101 = this.f409031a.f409027c;
                if (r101 == null) goto L6;
                r101.b(r100);
                return;
            }
        }

        public final void a() {
            l r100 = this.f409025a;
            if (r100 != null) goto L5;
        L7:
            a r101 = this.f409027c;
            if (r101 == null) goto L44;
            r101.start();
        L44:
        L36:
            e = move-exception;
            Log.e("AudioPlayer", "play task err", e);
            a r102 = this.f409027c;
            if (r102 == null) goto L48;
            r102.a();
            return;
        L48:
            return;
        L11:
            if (this.f409028d > 0.0f) goto L13;
        L15:
            this.f409025a.k();     // Catch: Exception -> L36
            a r103 = this.f409027c;
            if (r103 == null) goto L19;
            r103.stop();
        L19:
            e r104 = this.f409030f;
            monitor-enter(r104);
            r104.f409010d.setMode(r104.f409011e);     // Catch: Throwable -> L23 SecurityException -> L25
            r104.f409010d.setSpeakerphoneOn(r104.f409012f);     // Catch: Throwable -> L23 SecurityException -> L25
        L27:
            monitor-exit(r104);
            if (this.f409030f.f409023q.get() == false) goto L31;
            return;
        L31:
            if (CollectionUtils.isEmpty(this.f409030f.f409009c) == false) goto L47;
            Log.i("AudioPlayer", "abandonAudioFocus called by OpusPlayTask.mAudioPlayer");
            AudioPlayerFocusHelper r105 = this.f409030f.f409024r;
            BuildersKt.launch$default(r105.f408992b, null, null, new AudioPlayerFocusHelper$abandonAudioFocusAndCooldown$1(r105, null), 3, null);
            return;
        L47:
            return;
        L23:
            th = move-exception;
            throw th;
        L25:
            e = move-exception;
            Log.e("AudioPlayer", "recoverySystemPlayMode: " + e);     // Catch: Throwable -> L23
            goto L27
        L13:
            if (this.f409028d > 1.0f) goto L15;
            this.f409025a.i(this.f409028d);     // Catch: Exception -> L36
            goto L15
        L5:
            if (r100.f409062a != 2) goto L7;
            this.f409030f.a();
            goto L7
        }

        public final boolean b() {
            if (TextUtils.isEmpty(this.f409026b) == false) goto L5;
            return false;
        L5:
            String r100 = this.f409026b;
            if (TextUtils.isEmpty(r100) == false) goto L8;
            boolean r101 = false;
        L10:
            if (r101 == false) goto L12;
            Log.d("MarcusTest", "run: AudioPlayer");
            this.f409025a = new j(this.f409030f.f409010d, this.f409029e);
        L14:
            if (this.f409025a.b(this.f409026b, this.f409030f.f409017k) == true) goto L16;
            return false;
        L16:
            l r102 = this.f409025a;
            r102.f409065d = new a(this);
            return true;
        L12:
            Log.d("MarcusTest", "run: PcmPlayer");
            this.f409025a = new k(this.f409030f.f409010d);
            goto L14
        L8:
            r101 = Oggopus_rustKt.isOggOpusFile(r100);
            goto L10
        }

        public final void c() {
            l r100 = this.f409025a;
            if (r100 == null) goto L6;
            r100.m();
            return;
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

        public b(String r100, int r101, e r102, a r103, float r104) {
            this.f409028d = -1.0f;
            this.f409029e = r101;
            this.f409027c = r103;
            this.f409026b = r100;
            this.f409030f = r102;
            this.f409028d = r104;
        }
    }

    public final synchronized b c() {
        monitor-enter(this);
        b r100 = this.f409008b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static e d() {
        if (f409006s != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f409006s != null) goto L9;
        f409006s = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f409006s;
    }

    public final void a() {
        PowerManager.WakeLock r100 = this.f409015i;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isHeld() == false) goto L9;
        Log.i("AudioPlayer", "Proximity wake lock already acquired");
        return;
    L9:
        Log.i("AudioPlayer", "Acquiring proximity wake lock");
        if (fna.g.d() == true) goto L12;
        r100.acquire();
        return;
    L12:
        r100.acquire();
        com.obric.performance.power.monitor.cpu.d.a(r100);
    }

    public final void g() {
        Log.i("AudioPlayer", "abandonAudioFocus called by pause()");
        AudioPlayerFocusHelper r100 = this.f409024r;
        BuildersKt.launch$default(r100.f408992b, null, null, new AudioPlayerFocusHelper$abandonAudioFocusAndCooldown$1(r100, null), 3, null);
        b r101 = c();
        Log.d("AudioPlayer", "pause: " + r101);
        if (r101 != null) goto L5;
        return;
    L5:
        l r102 = r101.f409025a;
        if (r102 != null) goto L8;
    L11:
        l r103 = r101.f409025a;
        if (r103 == null) goto L14;
        r103.g();
    L14:
        a r104 = r101.f409027c;
        if (r104 == null) goto L18;
        r104.pause();
        return;
    L18:
        return;
    L8:
        if (r102.c() == false) goto L11;
        Log.i("AudioPlayer", "Already paused");
    }

    public final void h() {
        PowerManager.WakeLock r100 = this.f409015i;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isHeld() == true) goto L9;
        Log.i("AudioPlayer", "Proximity wake lock already released");
        return;
    L9:
        Log.i("AudioPlayer", "Releasing proximity wake lock");
        if (fna.g.d() == true) goto L12;
        r100.release();
        return;
    L12:
        r100.release();
        com.obric.performance.power.monitor.cpu.d.b(r100);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.audio.opus.a] */
    public e() {
        boolean r100 = true;
        this.f409013g = true;
        this.f409016j = 1;
        this.f409017k = 1;
        this.f409019m = new com.ss.android.lark.audio.opus.a(this);
        this.f409020n = CoreThreadPool.getDefault().getSingleScheduledThreadPool("audio_player");
        this.f409021o = new AtomicLong(0);
        this.f409023q = new AtomicBoolean(false);
        this.f409009c = new LinkedBlockingQueue();
        Context r101 = com.ss.android.lark.a.f408535a.getContext();
        this.f409010d = (AudioManager) r101.getSystemService("audio");
        SensorConfigHelper r102 = new SensorConfigHelper();
        Boolean r103 = ((AudioSensorConfig) r102.f408965a.getValue()).a();
        if (r103 == null) goto L5;
        boolean r104 = r103.booleanValue();
    L7:
        if (r104 == false) goto L9;
        Log.i("AudioPlayer", "enable proximity sensor");
        this.f409014h = new com.ss.android.lark.audio.e(r101.getApplicationContext());
    L10:
        Boolean r105 = ((AudioSensorConfig) r102.f408965a.getValue()).b();
        if (r105 == null) goto L13;
        r100 = r105.booleanValue();
    L13:
        if (r100 == false) goto L22;
        PowerManager r106 = (PowerManager) r101.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    L20:
        e = move-exception;
        Log.e("AudioPlayer", e);
    L24:
        if (this.f409007a != null) goto L26;
    L27:
        this.f409007a = new d(this);
        ThreadMethodProxy.start(this.f409007a);
    L28:
        this.f409024r = new AudioPlayerFocusHelper(this);
        return;
    L26:
        if (ThreadMethodProxy.isAlive(this.f409007a) == true) goto L28;
    L16:
        if (r106.isWakeLockLevelSupported(32) == false) goto L18;
        PowerManager.WakeLock r107 = r106.newWakeLock(32, r101.getPackageName() + ":AudioPlayer");     // Catch: Exception -> L20
        this.f409015i = r107;     // Catch: Exception -> L20
        r107.setReferenceCounted(false);     // Catch: Exception -> L20
        Log.i("AudioPlayer", "wakelock created");     // Catch: Exception -> L20
    L30:
        goto L24
    L18:
        Log.w("AudioPlayer", "wakelock unsupported");     // Catch: Exception -> L20
        goto L30
    L22:
        Log.i("AudioPlayer", "disable screen off wake lock");
        goto L24
    L9:
        Log.i("AudioPlayer", "disable proximity sensor");
        goto L10
    L5:
        r104 = true;
        goto L7
    }

    public final void i() {
        b r100 = c();
        Log.d("AudioPlayer", "pause: " + r100);
        if (r100 == null) goto L11;
        AudioPlayerFocusHelper r101 = this.f409024r;
        BuildersKt.launch$default(r101.f408992b, null, null, new AudioPlayerFocusHelper$requestAudioFocusAndCooldown$1(r101, null), 3, null);
        l r102 = r100.f409025a;
        if (r102 == null) goto L7;
        r102.h();
    L7:
        a r103 = r100.f409027c;
        if (r103 == null) goto L12;
        r103.resume();
        return;
    L12:
        return;
    }

    public final void o() {
        long r100 = SystemClock.elapsedRealtime();
        com.ss.android.lark.audio.e r101 = this.f409014h;
        if (r101 == null) goto L16;
        SensorManager r102 = r101.f408972a;
        if (r102 == null) goto L16;
        com.ss.android.lark.audio.e.a r103 = r101.f408974c;
        if (fna.g.d() == true) goto L10;
        r102.unregisterListener(r103);
    L15:
        r101.f408973b = null;
        goto L16
    L10:
        r102.unregisterListener(r103);
        if (r103 == null) goto L13;
        int r104 = r103.hashCode();
    L14:
        ona.b.c(new ona.a(r104, null));
        goto L15
    L13:
        r104 = 0;
    L16:
        h();
        Log.i("AudioPlayer", "unregisterProximitySensor:" + (SystemClock.elapsedRealtime() - r100));
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.ss.android.lark.audio.opus.b] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.ss.android.lark.audio.opus.c] */
    public final f b(int r100) {
        long r101 = this.f409021o.incrementAndGet();
        AudioManager r102 = this.f409010d;
        if (r100 != 2) goto L5;
        boolean r103 = true;
    L6:
        final AtomicLong r104 = this.f409021o;
        Objects.requireNonNull(r104);
        return new f(r102, r103, r101, new com.ss.android.lark.audio.opus.b(r104), new c(this));
    L5:
        r103 = false;
        goto L6
    }

    public final boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        b r101 = c();
        if (r101 != null) goto L8;
    L15:
        return false;
    L8:
        if (r101.f409025a == null) goto L15;
        if (r100.equals(r101.f409026b) == false) goto L15;
        if (r101.f409025a.d() == false) goto L15;
        return true;
    }

    public final boolean f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        b r101 = c();
        if (r101 != null) goto L8;
    L11:
        return false;
    L8:
        if (r100.equals(r101.f409026b) == false) goto L11;
        return true;
    }

    public final void j(float r100) {
        b r101 = c();
        Log.d("AudioPlayer", "seekProgress: " + r101);
        if (r101 == null) goto L8;
        l r102 = r101.f409025a;
        if (r102 == null) goto L9;
        r102.i(r100);
        return;
    L9:
        return;
    }

    public final synchronized void k(b r100) {
        monitor-enter(this);
        this.f409008b = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void l(List<b> r100) {
        monitor-enter(this);
        this.f409011e = this.f409010d.getMode();     // Catch: Throwable -> L19
        this.f409012f = this.f409010d.isSpeakerphoneOn();     // Catch: Throwable -> L19
        monitor-exit(this);
        AudioPlayerFocusHelper r101 = this.f409024r;
        BuildersKt.launch$default(r101.f408992b, null, null, new AudioPlayerFocusHelper$requestAudioFocusAndCooldown$1(r101, null), 3, null);
        if (this.f409007a != null) goto L8;
    L9:
        this.f409007a = new d(this);
        ThreadMethodProxy.start(this.f409007a);
    L10:
        Iterator<b> r102 = r100.iterator();
    L12:
        if (r102.hasNext() == false) goto L18;
        b r103 = r102.next();
        ((LinkedBlockingQueue) this.f409009c).put(r103);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        Log.e("AudioPlayer", "start err", e);
        goto L12
    L18:
        return;
    L8:
        if (ThreadMethodProxy.isAlive(this.f409007a) == true) goto L10;
    L19:
        th = move-exception;
        throw th;
    }

    public final void m(boolean r100) {
        Log.i("AudioPlayer", "abandonAudioFocus called by stop()");
        AudioPlayerFocusHelper r101 = this.f409024r;
        BuildersKt.launch$default(r101.f408992b, null, null, new AudioPlayerFocusHelper$abandonAudioFocusAndCooldown$1(r101, null), 3, null);
        if (r100 == false) goto L6;
        o();
    L6:
        if (this.f409009c.isEmpty() == true) goto L17;
        b r102 = (b) ((LinkedBlockingQueue) this.f409009c).take();     // Catch: InterruptedException -> L15
        if (r102 == null) goto L6;
        l r103 = r102.f409025a;     // Catch: InterruptedException -> L15
        if (r103 == null) goto L6;
        if (r103.e() == false) goto L6;
        r102.f409025a.l();     // Catch: InterruptedException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L6
    L17:
        b r104 = c();
        Log.d("MarcusTest", "stop: " + r104);
        if (r104 == null) goto L24;
        l r105 = r104.f409025a;
        if (r105 == null) goto L24;
        if (r105.e() == false) goto L24;
        r104.f409025a.l();
    L24:
        k(null);
    }

    public final void n(com.ss.android.lark.audio.a r110, a r111) {
        if (TextUtils.isEmpty(r110.f408970e) == false) goto L5;
        return;
    L5:
        b r100 = c();
        if (r100 != null) goto L8;
    L11:
        this.f409023q.set(true);
        b r101 = new b(r110.f408970e, r110.f408968c, this, r111, r110.f408969d / 100.0f);     // Catch: Throwable -> L15
        m(false);     // Catch: Throwable -> L15
        Log.d("AudioPlayer", "toggle: play");     // Catch: Throwable -> L15
        l(Collections.singletonList(r101));     // Catch: Throwable -> L15
        this.f409023q.set(false);
        return;
    L15:
        th = move-exception;
        this.f409023q.set(false);
        throw th;
    L8:
        if (Objects.equals(r110.f408970e, r100.f409026b) == false) goto L11;
        m(true);
        Log.i("AudioPlayer", "toggle: stop");
    }
}
