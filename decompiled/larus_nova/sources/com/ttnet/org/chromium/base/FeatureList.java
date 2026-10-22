package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class FeatureList {
    private static boolean sTestCanUseDefaults;
    private static TestValues sTestFeatures;

    public interface Natives {
        boolean isInitialized();
    }

    public static class TestValues {
        private Map<String, Boolean> mFeatureFlags;
        private Map<String, String> mFieldTrialParams;

        public TestValues() {
            this.mFeatureFlags = new HashMap();
            this.mFieldTrialParams = new HashMap();
        }

        public static /* synthetic */ Map access$000(TestValues r100) {
            return r100.mFeatureFlags;
        }

        public Boolean getFeatureFlagOverride(String r100) {
            return this.mFeatureFlags.get(r100);
        }

        public void setFeatureFlagsOverride(Map<String, Boolean> r100) {
            this.mFeatureFlags = r100;
        }

        private static String makeKey(String r100, String r101) {
            return r100 + ":" + r101;
        }

        public void addFeatureFlagOverride(String r100, boolean r101) {
            this.mFeatureFlags.put(r100, Boolean.valueOf(r101));
        }

        public String getFieldTrialParamOverride(String r100, String r101) {
            return this.mFieldTrialParams.get(makeKey(r100, r101));
        }

        public void addFieldTrialParamOverride(String r100, String r101, String r102) {
            this.mFieldTrialParams.put(makeKey(r100, r101), r102);
        }
    }

    private FeatureList() {
    }

    public static void resetTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = false;
    }

    public static void setTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = true;
    }

    public static boolean hasTestFeatures() {
        if (sTestFeatures == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isInitialized() {
        if (hasTestFeatures() == false) goto L5;
    L8:
        return true;
    L5:
        if (isNativeInitialized() == true) goto L8;
        return false;
    }

    public static boolean isNativeInitialized() {
        if (LibraryLoader.getInstance().isInitialized() == true) goto L7;
        return false;
    L7:
        return FeatureListJni.get().isInitialized();
    }

    public static Boolean getTestValueForFeature(String r100) {
        if (hasTestFeatures() == false) goto L12;
        Boolean r101 = sTestFeatures.getFeatureFlagOverride(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        if (sTestCanUseDefaults == false) goto L11;
        return null;
    L11:
        throw new IllegalArgumentException("No test value configured for " + r100 + " and native is not available to provide a default value. Use @EnableFeatures or @DisableFeatures to provide test values for the flag.");
    L12:
        return null;
    }

    public static boolean hasTestFeature(String r100) {
        if (hasTestFeatures() == true) goto L5;
    L7:
        return false;
    L5:
        if (TestValues.access$000(sTestFeatures).containsKey(r100) == false) goto L7;
        return true;
    }

    public static void setTestFeatures(Map<String, Boolean> r100) {
        if (r100 != null) goto L4;
        setTestValues(null);
        return;
    L4:
        TestValues r101 = new TestValues();
        r101.setFeatureFlagsOverride(r100);
        setTestValues(r101);
    }

    public static void setTestValues(TestValues r100) {
        sTestFeatures = r100;
    }

    public static String getTestValueForFieldTrialParam(String r100, String r101) {
        if (hasTestFeatures() == false) goto L7;
        String r102 = sTestFeatures.getFieldTrialParamOverride(r100, r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return null;
    L7:
        return null;
    }
}
