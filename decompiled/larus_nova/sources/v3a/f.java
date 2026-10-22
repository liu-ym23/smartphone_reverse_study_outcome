package v3a;

import android.os.Handler;
import android.os.Looper;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AbsAudioPlayManager;
import com.larus.audio.call.play.h;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends com.larus.audio.call.play.c {
    public Handler A;
    public volatile boolean B;
    public final ReentrantLock C;
    public volatile ByteBuffer D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f552974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f552975y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f552976z;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.play.c
    public final int p() {
        return 4;
    }

    @Override // com.larus.audio.call.play.c
    public final int r() {
        return 4800;
    }

    public final void C() {
        if (this.f552974x == true) goto L5;
        return;
    L5:
        ReentrantLock r100 = this.C;
        r100.lock();
        this.D = ByteBuffer.allocateDirect(4800);     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r100.unlock();
        return;
    L9:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void b() {
        Handler r100 = this.A;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        w(AbsAudioPlayManager.Wait.INVALID);
        super.b();
    }

    @Override // com.larus.audio.call.play.c, u68.c
    public final void init() {
        if (this.B == false) goto L5;
    L7:
        Handler r100 = null;
        if (ThreadMethodProxy.isAlive(this.f552976z) == false) goto L10;
        PthreadHandlerThreadV2 r101 = this.f552976z;
    L11:
        if (r101 == null) goto L13;
        r100 = new Handler(r101.getLooper());
    L13:
        this.A = r100;
        super.init();
        return;
    L10:
        r101 = null;
        goto L11
    L5:
        if (ThreadMethodProxy.isAlive(this.f552976z) == true) goto L7;
        ThreadMethodProxy.start(this.f552976z);
        goto L7
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final boolean isPlaying() {
        return this.f289309o;
    }

    @Override // com.larus.audio.call.play.c
    public final String t() {
        return this.f552975y;
    }

    public final void D(Runnable r100) {
        Thread r101 = null;
        if (ThreadMethodProxy.isAlive(this.f552976z) == false) goto L5;
        PthreadHandlerThreadV2 r102 = this.f552976z;
    L6:
        Handler r103 = this.A;
        if (r103 != null) goto L13;
        if (r102 == null) goto L12;
        Looper r104 = r102.getLooper();
        if (r104 == null) goto L12;
        r103 = new Handler(r104);
    L12:
        r103 = null;
    L13:
        if (r103 != null) goto L15;
    L25:
        r100.run();
        return;
    L15:
        if (this.B == true) goto L25;
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r102 == null) goto L22;
        Looper r106 = r102.getLooper();
        if (r106 == null) goto L22;
        r101 = ThreadMethodProxy.getLooperThread(r106);
    L22:
        if (Intrinsics.areEqual(r105, r101) == true) goto L25;
        r103.post(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.audio.call.play.c, u68.b
    public final void g(final h r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        D(new e(this, r100));
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void pause(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        D(new c(this, r100));
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void release(boolean r100) {
        Handler r101 = this.A;
        if (r101 == null) goto L5;
        r101.removeCallbacksAndMessages(null);
    L5:
        if (r100 == false) goto L7;
        this.A = null;
        this.B = true;
        this.f552976z.quit();
    L7:
        super.release(r100);
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void resume(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        D(new v3a.a(this, r100));
    }

    @Override // com.larus.audio.call.play.c
    public final byte[] s(byte[] r110) {
        if (this.f552974x == false) goto L46;
        ReentrantLock r100 = this.C;
        r100.lock();
        ByteBuffer r101 = this.D;     // Catch: Throwable -> L42
        if (r101 != null) goto L8;
        r100.unlock();
        goto L46
    L8:
        int r102 = r101.remaining();     // Catch: Throwable -> L42
        boolean r103 = false;
        if (r110 == null) goto L11;
        int r104 = r110.length;     // Catch: Throwable -> L42
    L13:
        if (r101.isReadOnly() == true) goto L26;
        if (r102 <= r104) goto L26;
        if (r110 != null) goto L18;
    L24:
        r100.unlock();
    L25:
        r110 = null;
        goto L46
    L18:
        if (r110.length != 0) goto L20;
        r103 = true;
    L20:
        if (r103 == true) goto L24;
        r101.put(r110);     // Catch: Throwable -> L42
        r100.unlock();
    L26:
        r101.flip();     // Catch: Throwable -> L42
        ByteBuffer r105 = ByteBuffer.allocate(r101.limit() + r104);     // Catch: Throwable -> L42
        r105.put(r101);     // Catch: Throwable -> L42
        if (r110 != null) goto L29;
    L34:
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Throwable -> L42
        r105.rewind();     // Catch: Throwable -> L42
        int r111 = r105.remaining();     // Catch: Throwable -> L42
        byte[] r106 = new byte[r111];     // Catch: Throwable -> L42
        r105.get(r106);     // Catch: Throwable -> L42
        if (r101.isReadOnly() == false) goto L40;
        FLogger.f375446a.w(this.f552975y, "[buffer] Buffer is read only, will relocate buffer region, input length: " + r104 + ",buffer remaining: " + r102 + ",result length: " + r111 + '.');     // Catch: Throwable -> L42
        C();     // Catch: Throwable -> L42
    L41:
        r100.unlock();
        r110 = r106;
        goto L46
    L40:
        FLogger.f375446a.w(this.f552975y, "[buffer] The input data content will exceed the free buffer space, input length: " + r104 + ", buffer remaining: " + r102 + ",result length: " + r111 + '.');     // Catch: Throwable -> L42
        r101.clear();     // Catch: Throwable -> L42
        goto L41
    L29:
        if (r110.length != 0) goto L32;
        r103 = true;
    L32:
        if ((!r103) == false) goto L34;
        r105.put(r110);     // Catch: Throwable -> L42
        goto L34
    L11:
        r104 = 0;
    L42:
        th = move-exception;
        r100.unlock();
        throw th;
    L46:
        return super.s(r110);
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void setVolume(final float r100) {
        D(new b(this, r100));
    }

    public static void A(f r100, float r101) {
        super.setVolume(r101);
    }

    public static void B(f r100, String r101) {
        super.pause(r101);
    }

    public static void x(f r100, h r101) {
        super.g(r101);
    }

    public static void y(f r100, String r101) {
        super.resume(r101);
    }

    public f(RealtimeCallParam r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "param");
        super(r100, r101, r102);
        this.f552974x = false;
        this.f552975y = "AsyncAudioPlayManager" + hashCode();
        this.f552976z = new PthreadHandlerThreadV2("audio_play_manager_operator_thread");
        this.C = new ReentrantLock();
        i(new g(this));
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void d(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "endType");
        Handler r103 = this.A;
        if (r103 == null) goto L5;
        r103.removeCallbacksAndMessages(null);
    L5:
        w(AbsAudioPlayManager.Wait.INVALID);
        super.d(r100, r101, r102);
        if (this.f552974x == false) goto L13;
        ReentrantLock r104 = this.C;
        r104.lock();
        FLogger.f375446a.w(this.f552975y, "[Stop] immediate: " + r100 + ", releaseTrack: " + r101 + ", remove buffer region.");     // Catch: Throwable -> L10
        this.D = null;     // Catch: Throwable -> L10
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r104.unlock();
        return;
    L10:
        th = move-exception;
        r104.unlock();
        throw th;
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void k(final boolean r100, final boolean r101, final String r102) {
        Intrinsics.checkNotNullParameter(r102, "caller");
        D(new d(this, r100, r101, r102));
    }

    public static void z(f r100, boolean r101, boolean r102, String r103) {
        super.k(r101, r102, r103);
    }
}
