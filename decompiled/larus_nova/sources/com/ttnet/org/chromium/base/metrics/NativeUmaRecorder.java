package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
final class NativeUmaRecorder implements UmaRecorder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<String, Long> mNativeHints;
    private Map<Callback<String>, Long> mUserActionTestingCallbackNativePtrs;

    public interface Natives {
        long addActionCallbackForTesting(Callback<String> r100);

        long createHistogramSnapshotForTesting();

        void destroyHistogramSnapshotForTesting(long r100);

        int getHistogramTotalCountForTesting(String r100, long r101);

        int getHistogramValueCountForTesting(String r100, int r101, long r102);

        long recordBooleanHistogram(String r100, long r101, boolean r102);

        long recordExponentialHistogram(String r100, long r101, int r102, int r103, int r104, int r105);

        long recordLinearHistogram(String r100, long r101, int r102, int r103, int r104, int r105);

        long recordSparseHistogram(String r100, long r101, int r102);

        void recordUserAction(String r100, long r101);

        void removeActionCallbackForTesting(long r100);
    }

    public NativeUmaRecorder() {
        this.mNativeHints = Collections.synchronizedMap(new HashMap());
    }

    static {
    }

    private long getNativeHint(String r100) {
        Long r101 = this.mNativeHints.get(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        return r101.longValue();
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> r100) {
        long r101 = NativeUmaRecorderJni.get().addActionCallbackForTesting(r100);
        if (this.mUserActionTestingCallbackNativePtrs != null) goto L5;
        this.mUserActionTestingCallbackNativePtrs = Collections.synchronizedMap(new HashMap());
    L5:
        this.mUserActionTestingCallbackNativePtrs.put(r100, Long.valueOf(r101));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String r100) {
        return NativeUmaRecorderJni.get().getHistogramTotalCountForTesting(r100, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> r100) {
        Map<Callback<String>, Long> r101 = this.mUserActionTestingCallbackNativePtrs;
        if (r101 != null) goto L5;
        return;
    L5:
        Long r102 = r101.remove(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        NativeUmaRecorderJni.get().removeActionCallbackForTesting(r102.longValue());
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String r100, int r101) {
        return NativeUmaRecorderJni.get().getHistogramValueCountForTesting(r100, r101, 0);
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r100, boolean r101) {
        long r102 = getNativeHint(r100);
        maybeUpdateNativeHint(r100, r102, NativeUmaRecorderJni.get().recordBooleanHistogram(r100, r102, r101));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r100, int r101) {
        long r102 = getNativeHint(r100);
        maybeUpdateNativeHint(r100, r102, NativeUmaRecorderJni.get().recordSparseHistogram(r100, r102, r101));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r100, long r101) {
        long r102 = TimeUtils.elapsedRealtimeMillis() - r101;
        NativeUmaRecorderJni.get().recordUserAction(r100, r102);
    }

    private void maybeUpdateNativeHint(String r100, long r101, long r102) {
        if (r101 == r102) goto L6;
        this.mNativeHints.put(r100, Long.valueOf(r102));
        return;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r110, int r111, int r112, int r113, int r114) {
        long r100 = getNativeHint(r110);
        maybeUpdateNativeHint(r110, r100, NativeUmaRecorderJni.get().recordExponentialHistogram(r110, r100, r111, r112, r113, r114));
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r110, int r111, int r112, int r113, int r114) {
        long r100 = getNativeHint(r110);
        maybeUpdateNativeHint(r110, r100, NativeUmaRecorderJni.get().recordLinearHistogram(r110, r100, r111, r112, r113, r114));
    }
}
