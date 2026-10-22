package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
public class JankMetricUMARecorderJni implements JankMetricUMARecorder.Natives {
    public static final JniStaticTestMocker<JankMetricUMARecorder.Natives> TEST_HOOKS = null;
    private static JankMetricUMARecorder.Natives testInstance;

    public JankMetricUMARecorderJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static JankMetricUMARecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JankMetricUMARecorder.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new JankMetricUMARecorderJni();
    }

    public static /* synthetic */ JankMetricUMARecorder.Natives access$002(JankMetricUMARecorder.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives
    public void recordJankMetrics(String r100, long[] r101, long[] r102, long[] r103, int r104) {
        GEN_JNI.com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(r100, r101, r102, r103, r104);
    }
}
