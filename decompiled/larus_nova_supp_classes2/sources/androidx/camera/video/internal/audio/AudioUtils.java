package androidx.camera.video.internal.audio;

import android.media.AudioTimestamp;
import androidx.core.util.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AudioUtils {
    public static int channelCountToChannelConfig(int r1) {
        if (r1 != 1) goto L5;
        return 16;
    L5:
        return 12;
    }

    public static int channelCountToChannelMask(int r1) {
        if (r1 != 1) goto L5;
        return 16;
    L5:
        return 12;
    }

    private AudioUtils() {
    }

    public static long frameCountToDurationNs(long r4, int r6) {
        long r0 = r6;
        if (r0 <= 0) goto L5;
        boolean r7 = true;
    L6:
        Preconditions.checkArgument(r7, "sampleRate must be greater than 0.");
        return (TimeUnit.SECONDS.toNanos(1) * r4) / r0;
    L5:
        r7 = false;
        goto L6
    }

    public static long frameCountToSize(long r4, int r6) {
        long r0 = r6;
        if (r0 <= 0) goto L5;
        boolean r7 = true;
    L6:
        Preconditions.checkArgument(r7, "bytesPerFrame must be greater than 0.");
        return r4 * r0;
    L5:
        r7 = false;
        goto L6
    }

    public static int getBytesPerFrame(int r3, int r4) {
        if (r4 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Invalid channel count: " + r4);
        if (r3 == 2) goto L23;
        if (r3 != 3) goto L10;
        return r4;
    L10:
        if (r3 == 4) goto L21;
        if (r3 == 21) goto L19;
        if (r3 == 22) goto L21;
        throw new IllegalArgumentException("Invalid audio encoding: " + r3);
    L19:
        return r4 * 3;
    L21:
        return r4 * 4;
    L23:
        return r4 * 2;
    L4:
        r0 = false;
        goto L5
    }

    public static long sizeToFrameCount(long r4, int r6) {
        long r0 = r6;
        if (r0 <= 0) goto L5;
        boolean r7 = true;
    L6:
        Preconditions.checkArgument(r7, "bytesPerFrame must be greater than 0.");
        return r4 / r0;
    L5:
        r7 = false;
        goto L6
    }

    public static long computeInterpolatedTimeNs(int r7, long r8, AudioTimestamp r10) {
        boolean r2 = true;
        if (r7 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "sampleRate must be greater than 0.");
        if (r8 >= 0) goto L10;
        r2 = false;
    L10:
        Preconditions.checkArgument(r2, "framePosition must be no less than 0.");
        long r9 = r10.nanoTime + frameCountToDurationNs(r8 - r10.framePosition, r7);
        if (r9 >= 0) goto L14;
        return 0;
    L14:
        return r9;
    L5:
        r0 = false;
        goto L6
    }
}
