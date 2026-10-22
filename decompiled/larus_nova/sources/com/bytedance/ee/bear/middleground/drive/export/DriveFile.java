package com.bytedance.ee.bear.middleground.drive.export;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
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
            Status r100 = new Status("PENDING", 0, 0);
            PENDING = r100;
            Status r101 = new Status("INFLIGHT", 1, 1);
            INFLIGHT = r101;
            Status r102 = new Status("FAILED", 2, 2);
            FAILED = r102;
            Status r103 = new Status("SUCCESS", 3, 3);
            SUCCESS = r103;
            Status r104 = new Status("QUEUE", 4, 4);
            QUEUE = r104;
            Status r105 = new Status("READY", 5, 5);
            READY = r105;
            Status r110 = new Status("CANCEL", 6, 6);
            CANCEL = r110;
            Status r111 = new Status("RANGE_FINISH", 7, 7);
            RANGE_FINISH = r111;
            Status r112 = new Status("UNKNOWN", 8, -1);
            UNKNOWN = r112;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public int value() {
            return this.value;
        }

        public static Status from(int r100) {
            switch(r100) {
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

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
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

    public void setBytesTotal(long r100) {
        this.bytesTotal = r100;
    }

    public void setBytesTransferred(long r100) {
        this.bytesTransferred = r100;
    }

    public void setErrorCode(String r100) {
        this.errorCode = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setMountNodePoint(String r100) {
        this.mountNodePoint = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setStatus(Status r100) {
        this.status = r100;
    }
}
