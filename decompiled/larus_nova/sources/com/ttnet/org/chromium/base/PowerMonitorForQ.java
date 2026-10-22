package com.ttnet.org.chromium.base;

import android.os.PowerManager;

/* JADX INFO: loaded from: classes41.dex */
public final class PowerMonitorForQ {
    private PowerMonitorForQ() {
    }

    public static void addThermalStatusListener(PowerManager r100) {
        r100.addThermalStatusListener(new AnonymousClass1());
    }
}
