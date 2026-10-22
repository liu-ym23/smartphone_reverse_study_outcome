package com.bytedance.bpea.entry.api.device.info;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202188a = 0;

    public static final class a {
        public static Sensor a(final SensorManager r100, final int r101, TokenCert r102) {
            BaseAuthEntry.Companion r103 = BaseAuthEntry.f202194a;
            int r104 = com.bytedance.bpea.entry.api.device.info.a.f202184a;
            return (Sensor) r103.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r102, "deviceInfo_sensorManager_getDefaultSensor", 100703), new SensorEntry$Companion$getDefaultSensorUnsafe$1(r100, r101));
        }
    }

    static {
    }
}
