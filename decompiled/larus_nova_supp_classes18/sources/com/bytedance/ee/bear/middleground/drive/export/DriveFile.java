package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DriveFile implements Serializable {
    public long bytesTotal;
    public long bytesTransferred;
    public String errorCode;
    public String fileName;
    public String key;
    public String mountNodePoint;
    public String path;
    public Status status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IntValue {
        public static final int CANCEL = 6;
        public static final int FAILED = 2;
        public static final int INFLIGHT = 1;
        public static final int PENDING = 0;
        public static final int QUEUE = 4;
        public static final int RANGE_FINISH = 7;
        public static final int READY = 5;
        public static final int SUCCESS = 3;
        public static final int UNKNOWN = -1;
    }

    public static final enum Status extends Enum<Status> implements Serializable {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CANCEL = null;
        public static final Status FAILED = null;
        public static final Status INFLIGHT = null;
        public static final Status PENDING = null;
        public static final Status QUEUE = null;
        public static final Status RANGE_FINISH = null;
        public static final Status READY = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r0 = new Status("PENDING", 0, 0);
            PENDING = r0;
            Status r1 = new Status("INFLIGHT", 1, 1);
            INFLIGHT = r1;
            Status r3 = new Status("FAILED", 2, 2);
            FAILED = r3;
            Status r5 = new Status("SUCCESS", 3, 3);
            SUCCESS = r5;
            Status r7 = new Status("QUEUE", 4, 4);
            QUEUE = r7;
            Status r9 = new Status("READY", 5, 5);
            READY = r9;
            Status r11 = new Status("CANCEL", 6, 6);
            CANCEL = r11;
            Status r13 = new Status("RANGE_FINISH", 7, 7);
            RANGE_FINISH = r13;
            Status r15 = new Status("UNKNOWN", 8, -1);
            UNKNOWN = r15;
            $VALUES = new Status[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static Status from(int r0) {
            switch(r0) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return RANGE_FINISH;
        L8:
            return CANCEL;
        L10:
            return READY;
        L12:
            return QUEUE;
        L14:
            return SUCCESS;
        L16:
            return FAILED;
        L18:
            return INFLIGHT;
        L20:
            return PENDING;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public DriveFile() {
    }

    public String toString() {
        return "DriveFile{key='" + this.key + "', fileName='" + this.fileName + "', status=" + this.status + ", bytesTransferred=" + this.bytesTransferred + ", bytesTotal=" + this.bytesTotal + ", path='" + this.path + "', mountNodePoint='" + this.mountNodePoint + "', errorCode='" + this.errorCode + "'}";
    }

    public long getBytesTotal() {
        return this.bytesTotal;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getKey() {
        return this.key;
    }

    public String getMountNodePoint() {
        return this.mountNodePoint;
    }

    public String getPath() {
        return this.path;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setBytesTotal(long r1) {
        this.bytesTotal = r1;
    }

    public void setBytesTransferred(long r1) {
        this.bytesTransferred = r1;
    }

    public void setErrorCode(String r1) {
        this.errorCode = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setMountNodePoint(String r1) {
        this.mountNodePoint = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setStatus(Status r1) {
        this.status = r1;
    }
}
