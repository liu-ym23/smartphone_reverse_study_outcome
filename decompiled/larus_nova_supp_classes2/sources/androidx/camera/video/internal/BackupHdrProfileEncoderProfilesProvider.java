package androidx.camera.video.internal;

import android.util.Rational;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BackupHdrProfileEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "BackupHdrProfileEncoderProfilesProvider";
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mEncoderProfilesProvider;
    private final Function<VideoEncoderConfig, VideoEncoderInfo> mVideoEncoderInfoFinder;

    private static int deriveCodec(int r3) {
        if (r3 != 0) goto L4;
        return 5;
    L4:
        if (r3 != 1) goto L6;
        return 5;
    L6:
        if (r3 != 2) goto L8;
        return 5;
    L8:
        if (r3 != 3) goto L10;
        return 5;
    L10:
        if (r3 != 4) goto L13;
        return 5;
    L13:
        throw new IllegalArgumentException("Unexpected HDR format: " + r3);
    }

    private static String deriveMediaType(int r0) {
        return EncoderProfilesProxy.CC.getVideoCodecMimeType(r0);
    }

    private static int deriveProfile(int r3) {
        if (r3 != 0) goto L5;
        return 1;
    L5:
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L8;
        return 4096;
    L8:
        if (r3 != 3) goto L10;
        return 8192;
    L10:
        if (r3 != 4) goto L14;
        return -1;
    L14:
        throw new IllegalArgumentException("Unexpected HDR format: " + r3);
    L19:
        return 2;
    }

    private EncoderProfilesProxy getProfilesInternal(int r4) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r4)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r4));
    L7:
        if (this.mEncoderProfilesProvider.hasProfile(r4) == false) goto L9;
        EncoderProfilesProxy r0 = appendBackupVideoProfile(this.mEncoderProfilesProvider.getAll(r4), 1, 10);
        this.mEncoderProfilesCache.put(Integer.valueOf(r4), r0);
        return r0;
    L9:
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r1) {
        return getProfilesInternal(r1);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r3) {
        if (this.mEncoderProfilesProvider.hasProfile(r3) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r3) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public BackupHdrProfileEncoderProfilesProvider(EncoderProfilesProvider r2, Function<VideoEncoderConfig, VideoEncoderInfo> r3) {
        this.mEncoderProfilesCache = new HashMap();
        this.mEncoderProfilesProvider = r2;
        this.mVideoEncoderInfoFinder = r3;
    }

    private static EncoderProfilesProxy.VideoProfileProxy modifyBitrate(EncoderProfilesProxy.VideoProfileProxy r10, int r11) {
        return EncoderProfilesProxy.VideoProfileProxy.create(r10.getCodec(), r10.getMediaType(), r11, r10.getFrameRate(), r10.getWidth(), r10.getHeight(), r10.getProfile(), r10.getBitDepth(), r10.getChromaSubsampling(), r10.getHdrFormat());
    }

    public static EncoderProfilesProxy.VideoProfileProxy validateOrAdapt(EncoderProfilesProxy.VideoProfileProxy r4, Function<VideoEncoderConfig, VideoEncoderInfo> r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        VideoEncoderConfig r1 = VideoConfigUtil.toVideoEncoderConfig(r4);
        VideoEncoderInfo r6 = r5.apply(r1);
        if (r6 != null) goto L8;
    L15:
        return null;
    L8:
        if (r6.isSizeSupportedAllowSwapping(r4.getWidth(), r4.getHeight()) == false) goto L15;
        int r0 = r1.getBitrate();
        int r7 = ((Integer) r6.getSupportedBitrateRange().clamp(Integer.valueOf(r0))).intValue();
        if (r7 != r0) goto L14;
        return r4;
    L14:
        return modifyBitrate(r4, r7);
    }

    private EncoderProfilesProxy appendBackupVideoProfile(EncoderProfilesProxy r6, int r7, int r8) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList(r6.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r2 = r6.getVideoProfiles().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        EncoderProfilesProxy.VideoProfileProxy r3 = r2.next();
        if (r3.getHdrFormat() != 0) goto L7;
    L12:
        EncoderProfilesProxy.VideoProfileProxy r9 = validateOrAdapt(generateBackupProfile(r3, r7, r8), this.mVideoEncoderInfoFinder);
        if (r9 == null) goto L16;
        r1.add(r9);
    L16:
        if (r1.isEmpty() == false) goto L19;
        return null;
    L19:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r6.getDefaultDurationSeconds(), r6.getRecommendedFileFormat(), r6.getAudioProfiles(), r1);
    L11:
        r3 = null;
        goto L12
    }

    private static EncoderProfilesProxy.VideoProfileProxy generateBackupProfile(EncoderProfilesProxy.VideoProfileProxy r13, int r14, int r15) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int r0 = r13.getCodec();
        String r1 = r13.getMediaType();
        int r2 = r13.getProfile();
        if (r14 == r13.getHdrFormat()) goto L8;
        r0 = deriveCodec(r14);
        r1 = deriveMediaType(r0);
        r2 = deriveProfile(r14);
    L8:
        int r5 = scaleBitrate(r13.getBitrate(), r15, r13.getBitDepth());
        int r6 = r13.getFrameRate();
        int r7 = r13.getWidth();
        int r8 = r13.getHeight();
        return EncoderProfilesProxy.VideoProfileProxy.create(r0, r1, r5, r6, r7, r8, r2, r15, r13.getChromaSubsampling(), r14);
    }

    private static int scaleBitrate(int r5, int r6, int r7) {
        if (r6 != r7) goto L4;
        return r5;
    L4:
        int r0 = (int) (((double) r5) * new Rational(r6, r7).doubleValue());
        if (Logger.isDebugEnabled(TAG) == false) goto L7;
        Logger.d(TAG, String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r0)}));
    L7:
        return r0;
    }
}
