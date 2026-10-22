package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class JankMetricUMARecorder {

    public interface Natives {
        void recordJankMetrics(String r100, long[] r101, long[] r102, long[] r103, int r104);
    }

    public JankMetricUMARecorder() {
    }

    public static String scenarioToString(int r100) {
        switch(r100) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "StartSurfaceTabSwitcher";
    L7:
        return "StartSurfaceHomepage";
    L9:
        return "OpenLinkInNewTab";
    L11:
        return "TabSwitcher";
    L13:
        return "Startup";
    L15:
        return "NewTabPage";
    L17:
        return "OmniboxFocus";
    L19:
        return "Total";
    L4:
        throw new IllegalArgumentException("Invalid scenario value");
    }

    public static void recordJankMetricsToUMA(JankMetrics r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        JankMetricUMARecorderJni.get().recordJankMetrics(scenarioToString(r101), r100.timestampsNs, r100.durationsNs, r100.jankBurstsNs, r100.skippedFrames);
    }
}
