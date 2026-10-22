package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.larus.apm.impl.protector.RunnableProtector;
import fna.g;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f380799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RunnableC4550b f380800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f380801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioTrack f380802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f380803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f380804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaExtractor f380805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaCodec f380806h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaFormat f380807i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f380809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f380810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f380812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f380813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f380814p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f380815q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f380816r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f380817s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f380818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f380819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f380820c;

        public a(int r100, String r101) {
            this.f380818a = r100;
            this.f380819b = 0;
            this.f380820c = r101;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.soundpool.b$b, reason: collision with other inner class name */
    public final class RunnableC4550b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f380821a;

        public final void a() {
            if (this.f380821a.f380802d != null) goto L5;
            return;
        L5:
            if (this.f380821a.f380810l <= 0) goto L48;
            c5a.c.c("SoundSample", "PlayRunnable#run:playCount:" + this.f380821a.f380810l);
            if (this.f380821a.f380816r == true) goto L8;
            AudioTrack r100 = this.f380821a.f380802d;
            if (g.d() == true) goto L12;
            r100.play();
        L13:
            b r101 = this.f380821a;
            if (r101.f380803e == null) goto L21;
            if (r101.f380808j == false) goto L18;
        L19:
            int r102 = this.f380821a.f380812n;
            this.f380821a.f380812n = 0;
            b r103 = this.f380821a;
            r103.f380802d.write(r103.f380803e, r102, r103.f380804f);
            goto L21
        L18:
            if (r101.f380812n == 0) goto L19;
        L21:
            if (this.f380821a.f380816r == true) goto L47;
            if (this.f380821a.f380802d.getPlayState() != 3) goto L59;
            Object r104 = this.f380821a.f380801c;
            monitor-enter(r104);
            b r105 = this.f380821a;     // Catch: Throwable -> L44
            if (r105.f380808j == false) goto L30;
            boolean r106 = false;
        L34:
            monitor-exit(r104);     // Catch: Throwable -> L44
            if (r106 == false) goto L38;
            r105.b(false);
        L38:
            if (this.f380821a.f380816r == true) goto L43;
            if (this.f380821a.f380802d.getPlayState() != 3) goto L58;
            this.f380821a.f380810l--;
            goto L5
        L58:
            return;
        L43:
            return;
        L30:
            if (r105.f380809k == true) goto L32;
            r105.f380803e = null;     // Catch: Throwable -> L44
        L32:
            r106 = true;
        L44:
            th = move-exception;
            throw th;
        L59:
            return;
        L47:
            return;
        L12:
            r100.play();
            gna.a.c(r100.hashCode());
            goto L13
        L8:
            return;
        L48:
            this.f380821a.j();
            this.f380821a.f380812n = 0;
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

        public RunnableC4550b(b r100) {
            this.f380821a = r100;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f380816r = true;
        Object r100 = this.f380801c;
        monitor-enter(r100);
        AudioTrack r101 = this.f380802d;     // Catch: Throwable -> L13
        if (r101 != null) goto L7;
    L10:
        e();     // Catch: Throwable -> L13
        this.f380803e = null;     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L7:
        if (r101.getPlayState() == 1) goto L9;
        h();     // Catch: Throwable -> L13
    L9:
        this.f380802d.release();     // Catch: Throwable -> L13
        this.f380802d = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void c() {
        c5a.c.c("SoundSample", "pause");
        AudioTrack r100 = this.f380802d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getPlayState() != 3) goto L24;
        Object r101 = this.f380801c;
        monitor-enter(r101);
        d();     // Catch: Throwable -> L18
        int r102 = this.f380802d.getPlaybackHeadPosition();     // Catch: Throwable -> L18
        if (r102 <= 0) goto L12;
        int r103 = r102 * this.f380811m;     // Catch: Throwable -> L18
    L13:
        this.f380812n = r103;     // Catch: Throwable -> L18
        if (this.f380803e == null) goto L16;
        this.f380802d.flush();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L12:
        r103 = 0;
    L18:
        th = move-exception;
        throw th;
    }

    public final void d() {
        c5a.c.c("SoundSample", "pauseTrackSafely");
        AudioTrack r100 = this.f380802d;     // Catch: IllegalStateException -> L10
        if (r100 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        r100.pause();     // Catch: IllegalStateException -> L10
        goto L13
    L8:
        r100.pause();     // Catch: IllegalStateException -> L10
        gna.a.a(r100.hashCode());     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public final void e() {
        c5a.c.c("SoundSample", "releaseCodec");
        c5a.c.c("SoundSample", "stopCodec");
        MediaCodec r100 = this.f380806h;
        if (r100 != null) goto L5;
    L9:
        MediaCodec r101 = this.f380806h;
        if (r101 == null) goto L12;
        r101.release();
        this.f380806h = null;
        this.f380817s = 3;
    L12:
        MediaExtractor r102 = this.f380805g;
        if (r102 == null) goto L15;
        r102.release();
        this.f380805g = null;
    L15:
        this.f380807i = null;
        return;
    L5:
        if (this.f380817s != 2) goto L9;
        r100.stop();     // Catch: IllegalStateException -> L8
        this.f380817s = 0;     // Catch: IllegalStateException -> L8
    L8:
        this.f380817s = -1;
        goto L9
    }

    public final boolean g() {
        if (this.f380806h != null) goto L5;
        return false;
    L5:
        int r100 = this.f380817s;
        if (r100 != (-1)) goto L8;
        c5a.c.c("SoundSample", "codecState:ERROR");
        this.f380806h.reset();
        this.f380817s = 0;
        return g();
    L8:
        if (r100 != 0) goto L10;
        c5a.c.c("SoundSample", "codecState:UNINITIALIZED");
        this.f380806h.configure(this.f380807i, null, null, 0);     // Catch: IllegalStateException -> L24
        this.f380817s = 1;     // Catch: IllegalStateException -> L24
    L26:
        return g();
    L24:
        this.f380817s = -1;
        goto L26
    L10:
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        return false;
    L13:
        c5a.c.c("SoundSample", "codecState:EXECUTING");
        return true;
    L15:
        c5a.c.c("SoundSample", "codecState:CONFIGURED");
        this.f380806h.start();     // Catch: IllegalStateException -> L18
        this.f380817s = 2;     // Catch: IllegalStateException -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        this.f380817s = -1;
        return false;
    }

    public final void h() {
        c5a.c.c("SoundSample", "stop");
        AudioTrack r100 = this.f380802d;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getPlayState();
        if (r101 != 1) goto L8;
        return;
    L8:
        if (r101 != 3) goto L11;
        d();
    L13:
        Object r102 = this.f380801c;
        monitor-enter(r102);
        this.f380812n = 0;     // Catch: Throwable -> L19
        this.f380802d.flush();     // Catch: Throwable -> L19
        j();     // Catch: Throwable -> L19
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L11:
        if (r101 != 2) goto L13;
        i();
        goto L13
    }

    public final void i() {
        c5a.c.c("SoundSample", "stopCodecAndSeek0");
        Object r100 = this.f380801c;
        monitor-enter(r100);
        c5a.c.c("SoundSample", "stopCodec");     // Catch: Throwable -> L16
        MediaCodec r101 = this.f380806h;     // Catch: Throwable -> L16
        if (r101 != null) goto L8;
    L13:
        this.f380805g.seekTo(0, 0);     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L8:
        if (this.f380817s != 2) goto L13;
        r101.stop();     // Catch: IllegalStateException -> L11 Throwable -> L16
        this.f380817s = 0;     // Catch: IllegalStateException -> L11 Throwable -> L16
    L12:
        this.f380817s = -1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void j() {
        c5a.c.c("SoundSample", "stopTrackSafely");
        AudioTrack r100 = this.f380802d;     // Catch: IllegalStateException -> L10
        if (r100 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        r100.stop();     // Catch: IllegalStateException -> L10
        goto L13
    L8:
        r100.stop();     // Catch: IllegalStateException -> L10
        gna.a.a(r100.hashCode());     // Catch: IllegalStateException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public b() {
        this.f380800b = new RunnableC4550b(this);
        this.f380801c = new Object();
        this.f380808j = true;
        this.f380810l = 1;
        this.f380813o = -1.0f;
        this.f380814p = -1.0f;
        this.f380815q = -1.0f;
        this.f380816r = true;
        this.f380817s = 0;
        this.f380799a = 4194304;
        this.f380809k = false;
    }

    public final void b(boolean r210) {
        if (g() == true) goto L5;
        return;
    L5:
        ByteBuffer[] r100 = this.f380806h.getOutputBuffers();
        MediaCodec.BufferInfo r101 = new MediaCodec.BufferInfo();
        long r102 = 0;
        boolean r103 = false;
        boolean r104 = false;
    L6:
        if (r103 == true) goto L70;
    L68:
        this.f380817s = -1;
        goto L70
    L8:
        if (this.f380816r == true) goto L9;
        Object r105 = this.f380801c;     // Catch: Exception -> L68
        monitor-enter(r105);     // Catch: Exception -> L68
        if (r104 == false) goto L87;
    L27:
        monitor-exit(r105);     // Catch: Throwable -> L65
        Object r106 = this.f380801c;     // Catch: Exception -> L68
        monitor-enter(r106);     // Catch: Exception -> L68
        int r107 = this.f380806h.dequeueOutputBuffer(r101, 1000);     // Catch: Throwable -> L62
        c5a.c.c("SoundSample", "dequeueOutputBuffer:" + r107);     // Catch: Throwable -> L62
        if (r107 < 0) goto L58;
        ByteBuffer r110 = r100[r107];     // Catch: Throwable -> L62
        if (r210 == false) goto L41;
        int r111 = this.f380804f + r101.size;     // Catch: Throwable -> L62
        byte[] r112 = this.f380803e;     // Catch: Throwable -> L62
        if (r111 <= r112.length) goto L37;
        this.f380803e = Arrays.copyOf(r112, r112.length + (r112.length / 8));     // Catch: Throwable -> L62
    L37:
        r110.get(this.f380803e, this.f380804f, r101.size);     // Catch: Throwable -> L62
        int r113 = this.f380804f + r101.size;     // Catch: Throwable -> L62
        this.f380804f = r113;     // Catch: Throwable -> L62
        if (r113 <= this.f380799a) goto L53;
        this.f380808j = false;     // Catch: Throwable -> L62
    L52:
        r103 = true;
    L53:
        r110.clear();     // Catch: Throwable -> L62
        this.f380806h.releaseOutputBuffer(r107, false);     // Catch: Throwable -> L62
        if ((r101.flags & 4) == 0) goto L56;
        r103 = true;
    L56:
        c5a.c.c("SoundSample", "sawOutputEOS:" + r103);     // Catch: Throwable -> L62
    L60:
        monitor-exit(r106);     // Catch: Throwable -> L62
        goto L6
    L41:
        if (this.f380816r == true) goto L52;
        int r114 = r101.size;     // Catch: Throwable -> L62
        byte[] r115 = new byte[r114];     // Catch: Throwable -> L62
        r110.get(r115);     // Catch: Throwable -> L62
        AudioTrack r116 = this.f380802d;     // Catch: Throwable -> L62
        if (r116 == null) goto L52;
        if (r116.getPlayState() != 3) goto L52;
        this.f380802d.write(r115, 0, r114);     // Catch: Throwable -> L62
        if (this.f380809k == false) goto L53;
        int r117 = this.f380804f + r114;     // Catch: Throwable -> L62
        byte[] r118 = this.f380803e;     // Catch: Throwable -> L62
        if (r117 <= r118.length) goto L51;
        this.f380803e = Arrays.copyOf(r118, r118.length + (r118.length / 8));     // Catch: Throwable -> L62
    L51:
        System.arraycopy(r115, 0, this.f380803e, this.f380804f, r114);     // Catch: Throwable -> L62
        this.f380804f += r114;     // Catch: Throwable -> L62
        goto L53
    L58:
        if (r107 != (-3)) goto L60;
        r100 = this.f380806h.getOutputBuffers();     // Catch: Throwable -> L62
        goto L60
    L62:
        th = move-exception;
        throw th;     // Catch: Exception -> L68
    L87:
        int r119 = this.f380806h.dequeueInputBuffer(1000);     // Catch: Throwable -> L65
        c5a.c.c("SoundSample", "dequeueInputBuffer:" + r119);     // Catch: Throwable -> L65
        if (r119 < 0) goto L27;
        int r108 = this.f380805g.readSampleData(this.f380806h.getInputBuffers()[r119], 0);     // Catch: Throwable -> L65
        if (r108 > 0) goto L19;
        r104 = true;
        int r120 = 0;
    L20:
        MediaCodec r121 = this.f380806h;     // Catch: Throwable -> L65
        if (r104 == false) goto L23;
        int r211 = 4;
    L24:
        r121.queueInputBuffer(r119, 0, r120, r102, r211);     // Catch: Throwable -> L65
        if (r104 == true) goto L27;
        this.f380805g.advance();     // Catch: Throwable -> L65
        goto L27
    L23:
        r211 = 0;
        goto L24
    L19:
        r102 = this.f380805g.getSampleTime();     // Catch: Throwable -> L65
        r120 = r108;
        goto L20
    L65:
        th = move-exception;
        throw th;     // Catch: Exception -> L68
    L9:
        return;
    L70:
        if (this.f380808j == false) goto L72;
        e();
        return;
    L72:
        if (r210 == true) goto L92;
        AudioTrack r109 = this.f380802d;
        if (r109 != null) goto L76;
        return;
    L76:
        if (r109.getPlayState() != 2) goto L78;
        return;
    L78:
        if (this.f380809k == true) goto L80;
        i();
        return;
    L80:
        if (this.f380802d.getPlayState() == 1) goto L95;
        this.f380808j = true;
        e();
        return;
    L95:
        return;
    }

    public final void f(float r100, float r101) {
        AudioTrack r102 = this.f380802d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f380813o == r100) goto L7;
    L8:
        this.f380813o = r100;
        this.f380814p = r101;
        r102.setStereoVolume(r100, r101);
        return;
    L7:
        if (this.f380814p != r101) goto L8;
    }

    public final boolean a(FileDescriptor r210, long r211, long r212) {
        this.f380816r = false;
        Object r110 = this.f380801c;
        monitor-enter(r110);
    L82:
        th = move-exception;
        throw th;
    L5:
        if (this.f380809k == true) goto L7;
    L9:
        boolean r100 = false;
    L10:
        this.f380809k = r100;     // Catch: Throwable -> L82
        int r111 = 12;
        if (r100 == false) goto L13;
        byte[] r101 = new byte[((int) r212) * 12];     // Catch: Throwable -> L82
    L14:
        this.f380803e = r101;     // Catch: Throwable -> L82
        MediaExtractor r102 = new MediaExtractor();     // Catch: Throwable -> L82
        this.f380805g = r102;     // Catch: Throwable -> L82
        r102.setDataSource(r210, r211, r212);     // Catch: IOException -> L18 Throwable -> L82
    L21:
        this.f380807i = null;     // Catch: Throwable -> L82
        int r103 = 44100;
        MediaFormat r104 = this.f380805g.getTrackFormat(0);     // Catch: Exception -> L31 Throwable -> L82
        this.f380807i = r104;     // Catch: Exception -> L31 Throwable -> L82
        if (r104 == null) goto L30;
        r104.setInteger("max-input-size", 0);     // Catch: Exception -> L31 Throwable -> L82
        String r105 = this.f380807i.getString("mime");     // Catch: Exception -> L31 Throwable -> L82
        r103 = this.f380807i.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Exception -> L28 Throwable -> L82
        int r106 = this.f380807i.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Exception -> L28 Throwable -> L82
        String r107 = r105;
        int r108 = r103;
    L36:
        if (this.f380807i == null) goto L79;
        if (r107 == null) goto L79;
        if (r107.startsWith("audio/") == false) goto L79;
        this.f380806h = MediaCodec.createDecoderByType(r107);     // Catch: Exception -> L43 Throwable -> L82
    L46:
        if (this.f380806h != null) goto L48;
    L76:
        close();     // Catch: Throwable -> L82
        monitor-exit(r110);     // Catch: Throwable -> L82
        return false;
    L48:
        if (this.f380807i == null) goto L76;
        this.f380817s = 0;     // Catch: Throwable -> L82
        this.f380805g.selectTrack(0);     // Catch: Throwable -> L82
        b(true);     // Catch: Throwable -> L82
        if (this.f380816r == false) goto L54;
        monitor-exit(r110);     // Catch: Throwable -> L82
        return false;
    L54:
        if (r106 != 1) goto L56;
        r111 = 4;
    L56:
        int r109 = AudioTrack.getMinBufferSize(r108, r111, 2);     // Catch: Throwable -> L82
        if (this.f380808j == true) goto L59;
    L61:
        r109 = r109 * 2;     // Catch: Throwable -> L82
    L62:
        this.f380802d = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(r108).setEncoding(2).setChannelMask(r111).build(), r109, 1, 0);     // Catch: Throwable -> L82
        this.f380811m = r106 * 2;     // Catch: Throwable -> L82
        StringBuilder r112 = new StringBuilder(" fileSize(Kb): ");     // Catch: Throwable -> L82
        r112.append(r212 / 1024);     // Catch: Throwable -> L82
        r112.append(", loadedSize(Kb): ");     // Catch: Throwable -> L82
        if (this.f380803e != null) goto L65;
        Object r113 = "0";
    L66:
        r112.append(r113);     // Catch: Throwable -> L82
        r112.append(", writeBuffSize(Bytes): ");     // Catch: Throwable -> L82
        r112.append(r109);     // Catch: Throwable -> L82
        r112.append(", mIsFullyLoaded: ");     // Catch: Throwable -> L82
        r112.append(this.f380808j);     // Catch: Throwable -> L82
        r112.append(", isStatic: ");     // Catch: Throwable -> L82
        r112.append(this.f380809k);     // Catch: Throwable -> L82
        c5a.c.c("SoundSample", r112.toString());     // Catch: Throwable -> L82
        monitor-exit(r110);     // Catch: Throwable -> L82
        AudioTrack r114 = this.f380802d;
        if (r114 != null) goto L71;
    L74:
        close();
        return false;
    L71:
        if (r114.getState() == 0) goto L74;
        return true;
    L65:
        r113 = Integer.valueOf(this.f380804f / 1024);     // Catch: Throwable -> L82
        goto L66
    L59:
        if (r212 >= 20480) goto L61;
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
        this.f380806h = null;     // Catch: Throwable -> L82
    L79:
        close();     // Catch: Throwable -> L82
        monitor-exit(r110);     // Catch: Throwable -> L82
        return false;
    L28:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L82
    L34:
        r107 = r105;
        r108 = r103;
        r106 = 1;
        goto L36
    L30:
        r105 = null;
    L31:
        e = e;
        r105 = null;
        goto L33
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
        goto L21
    L13:
        r101 = new byte[this.f380799a * 14];     // Catch: Throwable -> L82
        goto L14
    L7:
        if (r212 >= 204800) goto L9;
        r100 = true;
        goto L10
    }
}
