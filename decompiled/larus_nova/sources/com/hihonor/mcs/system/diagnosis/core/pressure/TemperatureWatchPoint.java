package com.hihonor.mcs.system.diagnosis.core.pressure;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class TemperatureWatchPoint implements Serializable {
    private static final long serialVersionUID = 6248896927332289762L;
    private TemperatureStatus temperatureStatus;

    public static final enum TemperatureStatus extends Enum<TemperatureStatus> {
        private static final /* synthetic */ TemperatureStatus[] $VALUES = null;
        public static final TemperatureStatus THERMAL_STATUS_CRITICAL = null;
        public static final TemperatureStatus THERMAL_STATUS_LIGHT = null;
        public static final TemperatureStatus THERMAL_STATUS_MODERATE = null;
        public static final TemperatureStatus THERMAL_STATUS_NONE = null;
        public static final TemperatureStatus THERMAL_STATUS_SEVERE = null;

        static {
            TemperatureStatus r100 = new TemperatureStatus("THERMAL_STATUS_NONE", 0);
            THERMAL_STATUS_NONE = r100;
            TemperatureStatus r101 = new TemperatureStatus("THERMAL_STATUS_LIGHT", 1);
            THERMAL_STATUS_LIGHT = r101;
            TemperatureStatus r102 = new TemperatureStatus("THERMAL_STATUS_MODERATE", 2);
            THERMAL_STATUS_MODERATE = r102;
            TemperatureStatus r103 = new TemperatureStatus("THERMAL_STATUS_SEVERE", 3);
            THERMAL_STATUS_SEVERE = r103;
            TemperatureStatus r104 = new TemperatureStatus("THERMAL_STATUS_CRITICAL", 4);
            THERMAL_STATUS_CRITICAL = r104;
            $VALUES = new TemperatureStatus[]{r100, r101, r102, r103, r104};
        }

        private TemperatureStatus(String r100, int r101) {
            super(r100, r101);
        }

        public static TemperatureStatus valueOf(String r100) {
            return (TemperatureStatus) a.a(TemperatureStatus.class, r100);
        }

        public static TemperatureStatus[] values() {
            return (TemperatureStatus[]) $VALUES.clone();
        }
    }

    public TemperatureWatchPoint() {
    }

    public TemperatureWatchPoint(TemperatureStatus r100) {
        this.temperatureStatus = r100;
    }

    public TemperatureStatus getTemperatureStatus() {
        return this.temperatureStatus;
    }

    public void setTemperatureStatus(TemperatureStatus r100) {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("TemperatureWatchPoint{temperatureStatus=");
        TemperatureStatus r101 = this.temperatureStatus;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }
}
