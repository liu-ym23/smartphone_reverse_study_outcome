package com.ss.android.lark.audio.opus;

import com.bytedance.lark.oggopus_rust_android.OggOpusCodecError;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoder;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.ttvecamera.TECameraUtils;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class OpusEncoder implements com.ss.android.lark.audio.recorder.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f408996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OggOpusEncoder f408997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f408998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OggOpusEncoderInputInfo f408999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f409000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f409001f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.recorder.j
    public final void c() {
    }

    public OpusEncoder() {
        this.f408996a = ByteBuffer.allocateDirect(TECameraUtils.CAPTURE_NORMAL);
        this.f408998c = ByteBuffer.allocateDirect(16384);
        this.f408999d = new OggOpusEncoderInputInfo(16000, 1);
        this.f409000e = LazyKt.lazy(OpusEncoder$maxMsPerPage$2.INSTANCE);
    }

    @Override // com.ss.android.lark.audio.recorder.j
    public final byte[] a(boolean r100) {
        if (r100 == true) goto L21;
        byte[] r101 = new byte[this.f408998c.flip().limit()];
        this.f408998c.get(r101).compact();
        return r101;
    L21:
        OggOpusEncoder r102 = this.f408997b;     // Catch: OggOpusCodecError -> L9
        if (r102 == null) goto L11;
        byte[] r103 = r102.finish();     // Catch: OggOpusCodecError -> L9
    L12:
        int r104 = this.f408998c.flip().remaining();
        byte[] r105 = new byte[r104];
        this.f408998c.get(r105).clear();
        if (r103 == null) goto L15;
        int r106 = r103.length;
    L16:
        byte[] r107 = new byte[r104 + r106];
        System.arraycopy(r105, 0, r107, 0, r104);
        if (r103 == null) goto L19;
        System.arraycopy(r103, 0, r107, r104, r106);
    L19:
        Log.i("OpusEncoder", "encodedDataLength:" + (this.f409001f + ((long) r106)));
        this.f409001f = 0;
        return r107;
    L15:
        r106 = 0;
    L11:
        r103 = null;
    L9:
        e = move-exception;
        Log.e("OpusEncoder", "readEncodedData failed: error code: " + e.getCode() + ", message: " + e.getMessage());
        goto L11
    }

    @Override // com.ss.android.lark.audio.recorder.j
    public final int d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "encodeFilePath");
        this.f408997b = OggOpusEncoder.Companion.m8457new(this.f408999d, ((Number) this.f409000e.getValue()).longValue(), r100, null);     // Catch: OggOpusCodecError -> L5
        int r101 = 1;
    L7:
        this.f408998c.clear();
        return r101;
    L5:
        e = move-exception;
        Log.e("OpusEncoder", "startEncoder failed: error code: " + e.getCode() + ", message: " + e.getMessage());
        r101 = -1;
        goto L7
    }

    @Override // com.ss.android.lark.audio.recorder.j
    public final long b(ByteBuffer r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "buffer");
        if (r111 >= r110.remaining()) goto L6;
        Log.e("OpusEncoder", " detect writeEncodedData buffer will overflow, returned. buffer.remaining:" + r110.remaining() + ", size: " + r111);
        return 0;
    L6:
        ByteBuffer r112 = ByteBuffer.allocateDirect(r111);
        r112.put(r110);
        r112.rewind();
    L8:
        if (r112.hasRemaining() == false) goto L35;
        if (r112.remaining() <= this.f408996a.remaining()) goto L12;
        int r113 = r112.limit();
        r112.limit(this.f408996a.remaining() + r112.position());
    L13:
        this.f408996a.put(r112);
        if (this.f408996a.position() != this.f408996a.limit()) goto L32;
        byte[] r100 = new byte[this.f408996a.flip().remaining()];
        this.f408996a.get(r100).rewind();
        byte[] r101 = null;
        OggOpusEncoder r102 = this.f408997b;     // Catch: OggOpusCodecError -> L20
        if (r102 == null) goto L22;
        r101 = r102.write(r100);     // Catch: OggOpusCodecError -> L20
    L22:
        if (r101 == null) goto L24;
        long r103 = r101.length;
    L25:
        if (r101 != null) goto L27;
    L29:
        long r104 = this.f409001f + r103;
        this.f409001f = r104;
        if (r104 == 0) goto L32;
        this.f408996a.rewind();
        goto L32
    L27:
        if (r101.length > this.f408998c.remaining()) goto L29;
        this.f408998c.put(r101);
        goto L29
    L24:
        r103 = 0;
    L20:
        e = move-exception;
        Log.e("OpusEncoder", "writeEncodedData failed: error code: " + e.getCode() + ", message: " + e.getMessage());
    L32:
        if (r113 == (-1)) goto L8;
        r112.limit(r113);
        goto L8
    L12:
        r113 = -1;
        goto L13
    L35:
        return this.f409001f;
    }
}
