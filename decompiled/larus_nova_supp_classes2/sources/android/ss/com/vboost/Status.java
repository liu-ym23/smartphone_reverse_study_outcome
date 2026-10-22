package android.ss.com.vboost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status BEGIN = null;
    public static final Status END = null;
    private int status;

    static {
        Status r0 = new Status("BEGIN", 0, 1);
        BEGIN = r0;
        Status r1 = new Status("END", 1, 2);
        END = r1;
        $VALUES = new Status[]{r0, r1};
    }

    private Status(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }

    public static Status valueOf(String r1) {
        return (Status) r27.a.a(Status.class, r1);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public int getStatus() {
        return this.status;
    }
}
