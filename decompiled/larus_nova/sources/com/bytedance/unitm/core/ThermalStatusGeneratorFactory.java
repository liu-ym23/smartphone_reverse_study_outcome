package com.bytedance.unitm.core;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.bytedance.unitm.adapter.AOSPThermalStatusAdapter;
import com.bytedance.unitm.adapter.CommonThermalStatusAdapter;
import com.bytedance.unitm.adapter.OemThermalStatusAdapter;
import com.bytedance.unitm.util.RomUtil;

/* JADX INFO: loaded from: classes22.dex */
public class ThermalStatusGeneratorFactory {
    private static Looper SLooper;

    public ThermalStatusGeneratorFactory() {
    }

    public static void setLooper(Looper r100) {
        SLooper = r100;
    }

    public static BaseThermalStatusGenerator create(int r100, Context r101) {
        if (r100 != 0) goto L6;
        return new CommonThermalStatusAdapter(r101, SLooper);
    L6:
        if (r100 != 1) goto L13;
        if (Build.VERSION.SDK_INT >= 29) goto L10;
        return null;
    L10:
        return new AOSPThermalStatusAdapter(r101, SLooper);
    L13:
        if (r100 != 2) goto L22;
        int r102 = RomUtil.getRomType();
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L21;
        return null;
    L21:
        return new OemThermalStatusAdapter(r101, SLooper);
    L22:
        return null;
    }
}
