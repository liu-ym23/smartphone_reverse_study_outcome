package com.hihonor.mcs.system.diagnosis.core.pressure;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class CpuWatchPoint implements Serializable {
    private static final long serialVersionUID = -2209655015209555149L;
    private CpuStatus cpuStatus;

    public static final enum CpuStatus extends Enum<CpuStatus> {
        private static final /* synthetic */ CpuStatus[] $VALUES = null;
        public static final CpuStatus CPU_STATUS_HIGH = null;
        public static final CpuStatus CPU_STATUS_LOW = null;
        public static final CpuStatus CPU_STATUS_MEDIUM = null;
        public static final CpuStatus CPU_STATUS_NONE = null;

        static {
            CpuStatus r100 = new CpuStatus("CPU_STATUS_NONE", 0);
            CPU_STATUS_NONE = r100;
            CpuStatus r101 = new CpuStatus("CPU_STATUS_LOW", 1);
            CPU_STATUS_LOW = r101;
            CpuStatus r102 = new CpuStatus("CPU_STATUS_MEDIUM", 2);
            CPU_STATUS_MEDIUM = r102;
            CpuStatus r103 = new CpuStatus("CPU_STATUS_HIGH", 3);
            CPU_STATUS_HIGH = r103;
            $VALUES = new CpuStatus[]{r100, r101, r102, r103};
        }

        private CpuStatus(String r100, int r101) {
            super(r100, r101);
        }

        public static CpuStatus valueOf(String r100) {
            return (CpuStatus) a.a(CpuStatus.class, r100);
        }

        public static CpuStatus[] values() {
            return (CpuStatus[]) $VALUES.clone();
        }
    }

    public CpuWatchPoint() {
    }

    public CpuWatchPoint(CpuStatus r100) {
        this.cpuStatus = r100;
    }

    public CpuStatus getCpuStatus() {
        return this.cpuStatus;
    }

    public void setCpuStatus(CpuStatus r100) {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("CpuWatchPoint{cpuStatus=");
        CpuStatus r101 = this.cpuStatus;
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
