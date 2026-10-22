package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.ClipData;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.system.s;

/* JADX INFO: loaded from: classes22.dex */
public interface g {
    boolean a(Context r100, IBDXBridgeContext r101, String r102);

    ClipData b(Context r100, IBDXBridgeContext r101, String r102);

    Sensor c(SensorManager r100, IBDXBridgeContext r101, String r102);

    void d(Context r100, s.a r101);

    void e(Context r100, IBDXBridgeContext r101, String r102, ClipData r103);
}
