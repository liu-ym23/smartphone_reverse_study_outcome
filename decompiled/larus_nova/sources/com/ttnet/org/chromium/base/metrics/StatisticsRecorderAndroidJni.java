package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class StatisticsRecorderAndroidJni implements StatisticsRecorderAndroid.Natives {
    public static final JniStaticTestMocker<StatisticsRecorderAndroid.Natives> TEST_HOOKS = null;
    private static StatisticsRecorderAndroid.Natives testInstance;

    public StatisticsRecorderAndroidJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static StatisticsRecorderAndroid.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        StatisticsRecorderAndroid.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.metrics.StatisticsRecorderAndroid.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new StatisticsRecorderAndroidJni();
    }

    public static /* synthetic */ StatisticsRecorderAndroid.Natives access$002(StatisticsRecorderAndroid.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.base.metrics.StatisticsRecorderAndroid.Natives
    public String toJson(int r100) {
        return GEN_JNI.com_ttnet_org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(r100);
    }
}
