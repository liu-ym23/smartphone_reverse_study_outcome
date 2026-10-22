package com.hihonor.mcs.system.diagnosis.core.pressure;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class IoWatchPoint implements Serializable {
    private static final long serialVersionUID = -6350019757070553167L;
    private IoStatus ioStatus;

    public static final enum IoStatus extends Enum<IoStatus> {
        private static final /* synthetic */ IoStatus[] $VALUES = null;
        public static final IoStatus IO_STATUS_HIGH = null;
        public static final IoStatus IO_STATUS_LOW = null;
        public static final IoStatus IO_STATUS_MEDIUM = null;
        public static final IoStatus IO_STATUS_NONE = null;

        static {
            IoStatus r100 = new IoStatus("IO_STATUS_NONE", 0);
            IO_STATUS_NONE = r100;
            IoStatus r101 = new IoStatus("IO_STATUS_LOW", 1);
            IO_STATUS_LOW = r101;
            IoStatus r102 = new IoStatus("IO_STATUS_MEDIUM", 2);
            IO_STATUS_MEDIUM = r102;
            IoStatus r103 = new IoStatus("IO_STATUS_HIGH", 3);
            IO_STATUS_HIGH = r103;
            $VALUES = new IoStatus[]{r100, r101, r102, r103};
        }

        private IoStatus(String r100, int r101) {
            super(r100, r101);
        }

        public static IoStatus valueOf(String r100) {
            return (IoStatus) a.a(IoStatus.class, r100);
        }

        public static IoStatus[] values() {
            return (IoStatus[]) $VALUES.clone();
        }
    }

    public IoWatchPoint() {
    }

    public IoWatchPoint(IoStatus r100) {
        this.ioStatus = r100;
    }

    public IoStatus getIoStatus() {
        return this.ioStatus;
    }

    public void setIoStatus(IoStatus r100) {
        this.ioStatus = r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("IoWatchPoint{ioStatus=");
        IoStatus r101 = this.ioStatus;
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
