package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes41.dex */
public interface UmaRecorder {
    void addUserActionCallbackForTesting(Callback<String> r100);

    int getHistogramTotalCountForTesting(String r100);

    int getHistogramValueCountForTesting(String r100, int r101);

    void recordBooleanHistogram(String r100, boolean r101);

    void recordExponentialHistogram(String r100, int r101, int r102, int r103, int r104);

    void recordLinearHistogram(String r100, int r101, int r102, int r103, int r104);

    void recordSparseHistogram(String r100, int r101);

    void recordUserAction(String r100, long r101);

    void removeUserActionCallbackForTesting(Callback<String> r100);
}
