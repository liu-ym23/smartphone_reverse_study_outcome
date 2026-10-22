package com.larus.bmhome.music.save_video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f313091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaMuxer f313092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f313093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f313094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f313095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f313096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f313097g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void release() {
        this.f313092b.stop();
        this.f313092b.release();
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final long d() {
        return this.f313097g;
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final boolean isStarted() {
        return this.f313093c;
    }

    public c(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f313091a = (long) (TimeUnit.SECONDS.toMicros(1) / r101);
        this.f313092b = new MediaMuxer(r100, 0);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void a(ByteBuffer r100, MediaCodec.BufferInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "encodedData");
        Intrinsics.checkNotNullParameter(r101, "audioBufferInfo");
        this.f313092b.writeSampleData(this.f313095e, r100, r101);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void b(ByteBuffer r100, MediaCodec.BufferInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "encodedData");
        Intrinsics.checkNotNullParameter(r101, "bufferInfo");
        long r102 = this.f313091a;
        int r103 = this.f313096f;
        this.f313096f = r103 + 1;
        long r104 = r102 * ((long) r103);
        this.f313097g = r104;
        r101.presentationTimeUs = r104;
        this.f313092b.writeSampleData(this.f313094d, r100, r101);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void c(MediaFormat r100, MediaExtractor r101) {
        Intrinsics.checkNotNullParameter(r100, "videoFormat");
        if (r101 == null) goto L5;
        r101.selectTrack(0);
    L5:
        if (r101 == null) goto L7;
        MediaFormat r102 = r101.getTrackFormat(0);
    L8:
        this.f313094d = this.f313092b.addTrack(r100);
        if (r102 == null) goto L11;
        this.f313095e = this.f313092b.addTrack(r102);
        r102.toString();
    L11:
        r100.toString();
        this.f313092b.start();
        this.f313093c = true;
        return;
    L7:
        r102 = null;
        goto L8
    }
}
