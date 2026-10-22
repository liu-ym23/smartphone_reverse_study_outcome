package com.hihonor.mcs.system.diagnosis.core.pressure;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryWatchPoint implements Serializable {
    private static final long serialVersionUID = -1355030469364415036L;
    private MemoryStatus memoryStatus;

    public static final enum MemoryStatus extends Enum<MemoryStatus> {
        private static final /* synthetic */ MemoryStatus[] $VALUES = null;
        public static final MemoryStatus MEMORY_STATUS_HIGH = null;
        public static final MemoryStatus MEMORY_STATUS_LOW = null;
        public static final MemoryStatus MEMORY_STATUS_MEDIUM = null;
        public static final MemoryStatus MEMORY_STATUS_NONE = null;

        static {
            MemoryStatus r100 = new MemoryStatus("MEMORY_STATUS_NONE", 0);
            MEMORY_STATUS_NONE = r100;
            MemoryStatus r101 = new MemoryStatus("MEMORY_STATUS_LOW", 1);
            MEMORY_STATUS_LOW = r101;
            MemoryStatus r102 = new MemoryStatus("MEMORY_STATUS_MEDIUM", 2);
            MEMORY_STATUS_MEDIUM = r102;
            MemoryStatus r103 = new MemoryStatus("MEMORY_STATUS_HIGH", 3);
            MEMORY_STATUS_HIGH = r103;
            $VALUES = new MemoryStatus[]{r100, r101, r102, r103};
        }

        private MemoryStatus(String r100, int r101) {
            super(r100, r101);
        }

        public static MemoryStatus valueOf(String r100) {
            return (MemoryStatus) a.a(MemoryStatus.class, r100);
        }

        public static MemoryStatus[] values() {
            return (MemoryStatus[]) $VALUES.clone();
        }
    }

    public MemoryWatchPoint() {
    }

    public MemoryWatchPoint(MemoryStatus r100) {
        this.memoryStatus = r100;
    }

    public MemoryStatus getMemoryStatus() {
        return this.memoryStatus;
    }

    public void setMemoryStatus(MemoryStatus r100) {
        this.memoryStatus = r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("MemoryWatchPoint{memoryStatus=");
        MemoryStatus r101 = this.memoryStatus;
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
