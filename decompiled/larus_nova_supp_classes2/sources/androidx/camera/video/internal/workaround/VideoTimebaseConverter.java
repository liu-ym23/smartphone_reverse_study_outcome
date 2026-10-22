package androidx.camera.video.internal.workaround;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.encoder.TimeProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VideoTimebaseConverter {
    private static final String TAG = "VideoTimebaseConverter";
    private static final long UPTIME_REALTIME_DIFF_THRESHOLD_US = 3000000;
    private final CameraUseInconsistentTimebaseQuirk mCameraUseInconsistentTimebaseQuirk;
    private final Timebase mInputTimebase;
    private Timebase mResolvedInputTimebase;
    private final TimeProvider mTimeProvider;
    private long mUptimeToRealtimeOffsetUs;

    /* JADX INFO: renamed from: androidx.camera.video.internal.workaround.VideoTimebaseConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$Timebase = null;

        static {
            int[] r0 = new int[Timebase.values().length];
            $SwitchMap$androidx$camera$core$impl$Timebase = r0;
            r0[Timebase.REALTIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$camera$core$impl$Timebase[Timebase.UPTIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private long calculateUptimeToRealtimeOffsetUs() {
        long r1 = Long.MAX_VALUE;
        int r5 = 0;
        long r6 = 0;
    L4:
        if (r5 >= 3) goto L12;
        long r8 = this.mTimeProvider.uptimeUs();
        long r10 = this.mTimeProvider.realtimeUs();
        long r12 = this.mTimeProvider.uptimeUs();
        long r14 = r12 - r8;
        if (r5 != 0) goto L8;
    L9:
        r6 = r10 - ((r8 + r12) >> 1);
        r1 = r14;
    L10:
        r5 = r5 + 1;
        goto L4
    L8:
        if (r14 >= r1) goto L10;
    L12:
        return Math.max(0, r6);
    }

    private boolean exceedUptimeRealtimeDiffThreshold() {
        long r0 = this.mTimeProvider.uptimeUs();
        if ((this.mTimeProvider.realtimeUs() - r0) <= UPTIME_REALTIME_DIFF_THRESHOLD_US) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isCloseToRealtime(long r5) {
        long r0 = this.mTimeProvider.uptimeUs();
        if (Math.abs(r5 - this.mTimeProvider.realtimeUs()) >= Math.abs(r5 - r0)) goto L5;
        return true;
    L5:
        return false;
    }

    private Timebase resolveInputTimebase(long r7) {
        if (this.mCameraUseInconsistentTimebaseQuirk == null) goto L6;
        Logger.w(TAG, "CameraUseInconsistentTimebaseQuirk is enabled");
        boolean r0 = false;
    L9:
        if (isCloseToRealtime(r7) == false) goto L11;
        Timebase r8 = Timebase.REALTIME;
    L12:
        if (r0 == true) goto L14;
    L20:
        Logger.d(TAG, "Detect input timebase = " + r8);
    L21:
        return r8;
    L14:
        if (r8 == this.mInputTimebase) goto L20;
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 31) goto L18;
        String r1 = ", SOC: " + Build.SOC_MODEL;
    L19:
        Logger.e(TAG, String.format("Detected camera timebase inconsistent. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, Hardware: %s, API Level: %d%s].\nCamera timebase is inconsistent. The timebase reported by the camera is %s, but the actual timebase contained in the frame is detected as %s.", new Object[]{Build.MANUFACTURER, Build.MODEL, Build.HARDWARE, Integer.valueOf(r9), r1, this.mInputTimebase, r8}));
        goto L21
    L18:
        r1 = "";
        goto L19
    L11:
        r8 = Timebase.UPTIME;
        goto L12
    L6:
        if (exceedUptimeRealtimeDiffThreshold() == false) goto L23;
        r0 = true;
        goto L9
    L23:
        return this.mInputTimebase;
    }

    public long convertToUptimeUs(long r6) {
        if (this.mResolvedInputTimebase != null) goto L5;
        this.mResolvedInputTimebase = resolveInputTimebase(r6);
    L5:
        int r0 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$Timebase[this.mResolvedInputTimebase.ordinal()];
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L11;
        return r6;
    L11:
        throw new AssertionError("Unknown timebase: " + this.mResolvedInputTimebase);
    L13:
        if (this.mUptimeToRealtimeOffsetUs != (-1)) goto L16;
        this.mUptimeToRealtimeOffsetUs = calculateUptimeToRealtimeOffsetUs();
        Logger.d(TAG, "mUptimeToRealtimeOffsetUs = " + this.mUptimeToRealtimeOffsetUs);
    L16:
        return r6 - this.mUptimeToRealtimeOffsetUs;
    }

    public VideoTimebaseConverter(TimeProvider r3, Timebase r4, CameraUseInconsistentTimebaseQuirk r5) {
        this.mUptimeToRealtimeOffsetUs = -1;
        this.mTimeProvider = r3;
        this.mInputTimebase = r4;
        this.mCameraUseInconsistentTimebaseQuirk = r5;
    }
}
