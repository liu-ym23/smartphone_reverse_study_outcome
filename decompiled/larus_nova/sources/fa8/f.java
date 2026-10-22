package fa8;

import android.media.AudioTrack;
import androidx.collection.SieveCacheKt;
import com.larus.audio.call.plugins.v0;
import com.larus.avlink.n1;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f476047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AudioTrack f476048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f476049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fa8.a f476050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fa8.a f476051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PthreadThreadV2 f476052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f476053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReentrantLock f476054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Condition f476055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.audio.call.play.f f476056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f476057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f476058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f476059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f476060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f476061o;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if ((!this.f476057k) == false) goto L6;
        this.f476057k = true;
        this.f476058l = false;
        this.f476059m = false;
        this.f476060n = false;
        n1.d("StereoAudioPlayer", "Begin new play segment. " + b());
        return;
    }

    public final String b() {
        return "running=" + this.f476053g + ", active=" + this.f476057k + ", firstFrameMarkerRegistered=" + this.f476058l + ", playEndMarkerRegistered=" + this.f476059m + ", replyEnd=" + this.f476060n + ", writtenFrames=" + this.f476061o + ", leftSize=" + this.f476050d.f476040b + ", rightSize=" + this.f476051e.f476040b;
    }

    public final void d() {
        AudioTrack r100 = this.f476048b;
        if (r100 != null) goto L5;
    L11:
        this.f476048b = null;
        ReentrantLock r101 = this.f476054h;
        r101.lock();
        n1.d("StereoAudioPlayer", "Release player resources. " + b());     // Catch: Throwable -> L15
        fa8.a r102 = this.f476050d;     // Catch: Throwable -> L15
        r102.f476039a.clear();     // Catch: Throwable -> L15
        r102.f476040b = 0;     // Catch: Throwable -> L15
        fa8.a r103 = this.f476051e;     // Catch: Throwable -> L15
        r103.f476039a.clear();     // Catch: Throwable -> L15
        r103.f476040b = 0;     // Catch: Throwable -> L15
        this.f476057k = false;     // Catch: Throwable -> L15
        this.f476058l = false;     // Catch: Throwable -> L15
        this.f476059m = false;     // Catch: Throwable -> L15
        this.f476060n = false;     // Catch: Throwable -> L15
        this.f476061o = 0;     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r101.unlock();
        return;
    L15:
        th = move-exception;
        r101.unlock();
        throw th;
    L5:
        if (r100.getPlayState() == 3) goto L7;
    L10:
        r100.flush();
        r100.release();
        goto L11
    L7:
        if (fna.g.d() == true) goto L9;
        r100.stop();
        goto L10
    L9:
        r100.stop();
        gna.a.a(r100.hashCode());
        goto L10
    }

    public f(v0 r100) {
        this.f476047a = r100;
        this.f476050d = new fa8.a();
        this.f476051e = new fa8.a();
        ReentrantLock r101 = new ReentrantLock();
        this.f476054h = r101;
        this.f476055i = r101.newCondition();
        this.f476056j = new com.larus.audio.call.play.f();
    }

    public final boolean c(String r100) {
        if (this.f476057k == true) goto L6;
        n1.d("StereoAudioPlayer", "Skip ending segment from " + r100 + " because no active segment. " + b());
        return false;
    L6:
        n1.d("StereoAudioPlayer", "End play segment from " + r100 + ". " + b());
        this.f476057k = false;
        this.f476058l = false;
        this.f476059m = false;
        this.f476060n = false;
        return true;
    }

    public final void e(AudioTrack r100) {
        n1.d("StereoAudioPlayer", "[simultaneous_interpret]:setPositionNotification");
        r100.setNotificationMarkerPosition(r100.getPlaybackHeadPosition() + 1);
        r100.setPlaybackPositionUpdateListener(new g(this));
    }

    public final void f(AudioTrack r100) {
        int r101 = Math.max(r100.getPlaybackHeadPosition() + 1, (int) RangesKt.coerceAtMost(this.f476061o, SieveCacheKt.NodeLinkMask));
        n1.d("StereoAudioPlayer", "[reply end with empty buffers]:setPlayEndPositionNotification marker=" + r101);
        r100.setNotificationMarkerPosition(r101);
        r100.setPlaybackPositionUpdateListener(new h(this));
    }
}
