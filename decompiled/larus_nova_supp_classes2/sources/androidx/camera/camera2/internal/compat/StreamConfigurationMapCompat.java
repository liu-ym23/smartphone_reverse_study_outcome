package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StreamConfigurationMapCompat {
    private static final String TAG = "StreamConfigurationMapCompat";
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes;
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes;
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;

    public interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int r1);

        int[] getOutputFormats();

        Size[] getOutputSizes(int r1);

        <T> Size[] getOutputSizes(Class<T> r1);

        StreamConfigurationMap unwrap();
    }

    public int[] getOutputFormats() {
        int[] r0 = this.mImpl.getOutputFormats();
        if (r0 != null) goto L6;
        return null;
    L6:
        return (int[]) r0.clone();
    }

    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }

    public Size[] getHighResolutionOutputSizes(int r4) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(r4)) == true) goto L5;
        Size[] r0 = this.mImpl.getHighResolutionOutputSizes(r4);
        if (r0 != null) goto L12;
    L14:
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(r4), r0);
        if (r0 != null) goto L17;
        return null;
    L17:
        return (Size[]) r0.clone();
    L12:
        if (r0.length <= 0) goto L14;
        r0 = this.mOutputSizesCorrector.applyQuirks(r0, r4);
        goto L14
    L5:
        if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(r4)) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(r4)).clone();
    }

    public Size[] getOutputSizes(int r4) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(r4)) == true) goto L5;
        Size[] r0 = this.mImpl.getOutputSizes(r4);
        if (r0 != null) goto L12;
    L16:
        Logger.w(TAG, "Retrieved output sizes array is null or empty for format " + r4);
        return r0;
    L12:
        if (r0.length == 0) goto L16;
        Size[] r1 = this.mOutputSizesCorrector.applyQuirks(r0, r4);
        this.mCachedFormatOutputSizes.put(Integer.valueOf(r4), r1);
        return (Size[]) r1.clone();
    L5:
        if (this.mCachedFormatOutputSizes.get(Integer.valueOf(r4)) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(r4)).clone();
    }

    public <T> Size[] getOutputSizes(Class<T> r4) {
        if (this.mCachedClassOutputSizes.containsKey(r4) == true) goto L5;
        Size[] r0 = this.mImpl.getOutputSizes(r4);
        if (r0 != null) goto L12;
    L16:
        Logger.w(TAG, "Retrieved output sizes array is null or empty for class " + r4);
        return r0;
    L12:
        if (r0.length == 0) goto L16;
        Size[] r1 = this.mOutputSizesCorrector.applyQuirks(r0, r4);
        this.mCachedClassOutputSizes.put(r4, r1);
        return (Size[]) r1.clone();
    L5:
        if (this.mCachedClassOutputSizes.get(r4) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedClassOutputSizes.get(r4).clone();
    }

    private StreamConfigurationMapCompat(StreamConfigurationMap r3, OutputSizesCorrector r4) {
        this.mCachedFormatOutputSizes = new HashMap();
        this.mCachedFormatHighResolutionOutputSizes = new HashMap();
        this.mCachedClassOutputSizes = new HashMap();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(r3);
    L6:
        this.mOutputSizesCorrector = r4;
        return;
    L5:
        this.mImpl = new StreamConfigurationMapCompatBaseImpl(r3);
        goto L6
    }

    public static StreamConfigurationMapCompat toStreamConfigurationMapCompat(StreamConfigurationMap r1, OutputSizesCorrector r2) {
        return new StreamConfigurationMapCompat(r1, r2);
    }
}
