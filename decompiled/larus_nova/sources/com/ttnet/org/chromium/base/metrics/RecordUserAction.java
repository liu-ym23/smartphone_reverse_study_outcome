package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes41.dex */
public class RecordUserAction {
    public RecordUserAction() {
    }

    public static void record(String r100) {
        UmaRecorderHolder.get().recordUserAction(r100, TimeUtils.elapsedRealtimeMillis());
    }
}
