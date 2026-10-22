package com.huawei.hms.common.data;

/* JADX INFO: loaded from: classes23.dex */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int r100, int r101);

    void onDataRangeInserted(int r100, int r101);

    void onDataRangeMoved(int r100, int r101, int r102);

    void onDataRangeRemoved(int r100, int r101);
}
