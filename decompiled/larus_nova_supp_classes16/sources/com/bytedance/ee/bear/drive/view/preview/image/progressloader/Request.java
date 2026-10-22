package com.bytedance.ee.bear.drive.view.preview.image.progressloader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface Request {

    public static final enum Status extends Enum<Status> {
        public static final Status CANCELLED = null;
        public static final Status COMPLETE = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status WAITING_FOR_SIZE = null;
        public static final /* synthetic */ Status[] a = null;

        static {
            Status r0 = new Status("PENDING", 0);
            PENDING = r0;
            Status r1 = new Status("RUNNING", 1);
            RUNNING = r1;
            Status r3 = new Status("WAITING_FOR_SIZE", 2);
            WAITING_FOR_SIZE = r3;
            Status r5 = new Status("COMPLETE", 3);
            COMPLETE = r5;
            Status r7 = new Status("FAILED", 4);
            FAILED = r7;
            Status r9 = new Status("CANCELLED", 5);
            CANCELLED = r9;
            a = new Status[]{r0, r1, r3, r5, r7, r9};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    void cancel();
}
