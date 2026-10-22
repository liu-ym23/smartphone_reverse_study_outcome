package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
@MainDex
public class NativeUmaRecorderJni implements NativeUmaRecorder.Natives {
    public static final JniStaticTestMocker<NativeUmaRecorder.Natives> TEST_HOOKS = null;
    private static NativeUmaRecorder.Natives testInstance;

    public NativeUmaRecorderJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static NativeUmaRecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NativeUmaRecorder.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new NativeUmaRecorderJni();
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long createHistogramSnapshotForTesting() {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting();
    }

    public static /* synthetic */ NativeUmaRecorder.Natives access$002(NativeUmaRecorder.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long addActionCallbackForTesting(Callback<String> r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(r100);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void destroyHistogramSnapshotForTesting(long r100) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(r100);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void removeActionCallbackForTesting(long r100) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(r100);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramTotalCountForTesting(String r100, long r101) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public void recordUserAction(String r100, long r101) {
        GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(r100, r101);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public int getHistogramValueCountForTesting(String r100, int r101, long r102) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordBooleanHistogram(String r100, long r101, boolean r102) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordSparseHistogram(String r100, long r101, int r102) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordExponentialHistogram(String r100, long r101, int r102, int r103, int r104, int r105) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.ttnet.org.chromium.base.metrics.NativeUmaRecorder.Natives
    public long recordLinearHistogram(String r100, long r101, int r102, int r103, int r104, int r105) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(r100, r101, r102, r103, r104, r105);
    }
}
