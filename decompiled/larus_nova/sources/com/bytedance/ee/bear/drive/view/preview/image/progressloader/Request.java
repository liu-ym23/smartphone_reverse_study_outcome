package com.bytedance.ee.bear.drive.view.preview.image.progressloader;

/* JADX INFO: loaded from: classes16.dex */
public interface Request {

    public static final enum Status extends Enum<Status> {
        public static final Status CANCELLED = null;
        public static final Status COMPLETE = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status WAITING_FOR_SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f224921a = null;

        static {
            Status r100 = new Status("PENDING", 0);
            PENDING = r100;
            Status r101 = new Status("RUNNING", 1);
            RUNNING = r101;
            Status r102 = new Status("WAITING_FOR_SIZE", 2);
            WAITING_FOR_SIZE = r102;
            Status r103 = new Status("COMPLETE", 3);
            COMPLETE = r103;
            Status r104 = new Status("FAILED", 4);
            FAILED = r104;
            Status r105 = new Status("CANCELLED", 5);
            CANCELLED = r105;
            f224921a = new Status[]{r100, r101, r102, r103, r104, r105};
        }

        public static Status[] values() {
            return (Status[]) f224921a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    void cancel();
}
