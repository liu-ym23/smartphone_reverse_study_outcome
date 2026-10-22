package com.bytedance.unitm.api;

/* JADX INFO: loaded from: classes22.dex */
public interface IThermalStatusListener {
    String getDescription();

    void onThermalStatusChanged(int r100);
}
