package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.media.AudioRecord;
import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import com.ss.ttvideoengine.model.SubInfo;
import fna.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements sub.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioRecord f434358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f434359b;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.a$a, reason: collision with other inner class name */
    public static final class C5168a {
    }

    static {
    }

    public a() {
    }

    @Override // sub.b
    public final void a() {
    }

    @Override // sub.b
    public final void c() {
    }

    @Override // sub.b
    public final void close() {
        lvb.a.e("AudioRecordExtSource", "Closing AudioRecord");
        AudioRecord r100 = this.f434358a;     // Catch: Exception -> L10
        if (r100 != null) goto L6;
    L20:
    L23:
        AudioRecord r101 = this.f434358a;     // Catch: Exception -> L16
        if (r101 == null) goto L18;
        e(r101);     // Catch: Exception -> L16
    L18:
        this.f434358a = null;
        this.f434359b = 0;
        return;
    L16:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error releasing AudioRecord: " + e);
        goto L18
    L6:
        if (g.d() == true) goto L8;
        g(r100);     // Catch: Exception -> L10
        goto L20
    L8:
        g(r100);     // Catch: Exception -> L10
        hna.a.c(r100.hashCode());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error stopping AudioRecord: " + e);
        goto L23
    }

    @Override // sub.b
    public final void pause() {
        lvb.a.e("AudioRecordExtSource", "pause");
        AudioRecord r100 = this.f434358a;     // Catch: Exception -> L10
        if (r100 != null) goto L6;
    L13:
        return;
    L6:
        if (g.d() == true) goto L8;
        g(r100);     // Catch: Exception -> L10
        goto L13
    L8:
        g(r100);     // Catch: Exception -> L10
        hna.a.c(r100.hashCode());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error pausing AudioRecord: " + e);
    }

    @Override // sub.b
    public final sub.b.c startCapture() {
        lvb.a.e("AudioRecordExtSource", "startCapture");
        AudioRecord r100 = this.f434358a;
        if (r100 != null) goto L15;
        lvb.a.b("AudioRecordExtSource", "AudioRecord not initialized");
        return new sub.b.c(false, "AudioRecord not initialized");
    L15:
    L12:
        e = move-exception;
        String r101 = "Failed to start AudioRecord: " + e.getMessage();
        lvb.a.b("AudioRecordExtSource", r101);
        return new sub.b.c(false, r101);
    L7:
        if (g.d() == true) goto L9;
        f(r100);     // Catch: Exception -> L12
    L10:
        lvb.a.e("AudioRecordExtSource", "AudioRecord started recording successfully");     // Catch: Exception -> L12
        return new sub.b.c(true, null);
    L9:
        f(r100);     // Catch: Exception -> L12
        hna.a.b(r100.hashCode());     // Catch: Exception -> L12
        goto L10
    }

    @Override // sub.b
    public final ExternalAudioSourceMode b() {
        return ExternalAudioSourceMode.PCM_PULL;
    }

    public static void e(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    public static void f(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    public static void g(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    @Override // sub.b
    public final sub.b.C7658b d(sub.b.a r110) {
        Intrinsics.checkNotNullParameter(r110, SubInfo.KEY_FORMAT);
        if (this.f434358a == null) goto L6;
        lvb.a.h("AudioRecordExtSource", "AudioRecord already initialized");
        return new sub.b.C7658b(false, 0, "AudioRecord already initialized", 2);
    L6:
        int r100 = r110.f543606b;
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L11;
        int r111 = 12;
    L12:
        int r101 = AudioRecord.getMinBufferSize(r110.f543605a, r111, 2);
        if (r101 != (-2)) goto L15;
    L39:
        lvb.a.b("AudioRecordExtSource", "Invalid buffer size for sampleRate=" + r110.f543605a + ", channelConfig=" + r111);
        return new sub.b.C7658b(false, 0, "Invalid buffer size: " + r101, 2);
    L15:
        if (r101 == (-1)) goto L39;
        this.f434359b = Math.max(r101 * 2, 4096);
        AudioRecord r112 = new AudioRecord(1, r110.f543605a, r111, 2, this.f434359b);     // Catch: Exception -> L33
        this.f434358a = r112;     // Catch: Exception -> L33
        if (r112.getState() != 1) goto L20;
        boolean r102 = true;
    L21:
        if (r102 == true) goto L31;
        StringBuilder r113 = new StringBuilder("AudioRecord initialization failed, state=");     // Catch: Exception -> L33
        AudioRecord r103 = this.f434358a;     // Catch: Exception -> L33
        if (r103 == null) goto L25;
        Integer r104 = Integer.valueOf(r103.getState());     // Catch: Exception -> L33
    L26:
        r113.append(r104);     // Catch: Exception -> L33
        String r114 = r113.toString();     // Catch: Exception -> L33
        lvb.a.b("AudioRecordExtSource", r114);     // Catch: Exception -> L33
        AudioRecord r105 = this.f434358a;     // Catch: Exception -> L33
        if (r105 == null) goto L29;
        e(r105);     // Catch: Exception -> L33
    L29:
        this.f434358a = null;     // Catch: Exception -> L33
        return new sub.b.C7658b(false, 0, r114, 2);
    L25:
        r104 = null;
        goto L26
    L31:
        lvb.a.e("AudioRecordExtSource", "AudioRecord initialized successfully, sampleRate=" + r110.f543605a + ", bufferSize=" + this.f434359b + ", channel=" + r110.f543606b);     // Catch: Exception -> L33
        return new sub.b.C7658b(true, this.f434359b, null, 4);
    L20:
        r102 = false;
    L33:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Failed to initialize AudioRecord: " + e);
        AudioRecord r106 = this.f434358a;
        if (r106 == null) goto L37;
        e(r106);
    L37:
        this.f434358a = null;
        return new sub.b.C7658b(false, 0, "Exception: " + e.getMessage(), 2);
    L11:
        r111 = 16;
        goto L12
    }

    @Override // sub.b
    public final int read(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        AudioRecord r102 = this.f434358a;     // Catch: Exception -> L9
        if (r102 == null) goto L6;
        int r103 = r102.read(r100, 0, r101);     // Catch: Exception -> L9
    L7:
        lvb.a.g("read: " + r103);     // Catch: Exception -> L9
        return r103;
    L6:
        r103 = -1;
    L9:
        e = move-exception;
        lvb.a.b("AudioRecordExtSource", "Error reading audio data: " + e);
        return -1;
    }
}
