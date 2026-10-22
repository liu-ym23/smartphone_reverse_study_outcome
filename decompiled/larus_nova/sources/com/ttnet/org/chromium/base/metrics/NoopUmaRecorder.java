package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes41.dex */
class NoopUmaRecorder implements UmaRecorder {
    public NoopUmaRecorder() {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void addUserActionCallbackForTesting(Callback<String> r100) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramTotalCountForTesting(String r100) {
        return 0;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public int getHistogramValueCountForTesting(String r100, int r101) {
        return 0;
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordBooleanHistogram(String r100, boolean r101) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordExponentialHistogram(String r100, int r101, int r102, int r103, int r104) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordLinearHistogram(String r100, int r101, int r102, int r103, int r104) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordSparseHistogram(String r100, int r101) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void recordUserAction(String r100, long r101) {
    }

    @Override // com.ttnet.org.chromium.base.metrics.UmaRecorder
    public void removeUserActionCallbackForTesting(Callback<String> r100) {
    }
}
