package androidx.camera.video.internal.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.util.LruCache;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.InvalidConfigException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CodecUtil {
    private static final int MAX_CODEC_INFO_CACHE_COUNT = 10;
    private static final LruCache<String, MediaCodecInfo> sCodecInfoCache = null;

    static {
        sCodecInfoCache = new LruCache(10);
    }

    private CodecUtil() {
    }

    private static MediaCodec createCodec(String r1) throws InvalidConfigException {
        return MediaCodec.createEncoderByType(r1);
    L6:
        e = move-exception;
        throw new InvalidConfigException(e);
    }

    public static MediaCodecInfo findCodecAndGetCodecInfo(EncoderConfig r3) throws InvalidConfigException {
        String r4 = r3.getMimeType();
        LruCache<String, MediaCodecInfo> r0 = sCodecInfoCache;
        monitor-enter(r0);
        MediaCodecInfo r1 = r0.get(r4);     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        if (r1 == null) goto L32;
        return r1;
    L32:
        MediaCodec r2 = createCodec(r4);     // Catch: Throwable -> L20
        MediaCodecInfo r5 = r2.getCodecInfo();     // Catch: Throwable -> L18
        monitor-enter(r0);     // Catch: Throwable -> L18
        r0.put(r4, r5);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        r2.release();
        return r5;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = th;
    L22:
        if (r2 == null) goto L24;
        r2.release();
    L24:
        throw th;
    L20:
        th = th;
        r2 = null;
    L25:
        th = move-exception;
        throw th;
    }

    public static MediaCodec createCodec(EncoderConfig r0) throws InvalidConfigException {
        return createCodec(r0.getMimeType());
    }
}
