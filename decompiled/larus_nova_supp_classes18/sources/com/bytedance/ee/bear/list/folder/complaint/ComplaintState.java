package com.bytedance.ee.bear.list.folder.complaint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ComplaintState extends Enum<ComplaintState> {
    public static final ComplaintState COMPLAINT_FAIL = null;
    public static final ComplaintState COMPLAINT_SUCCESS = null;
    public static final ComplaintState IN_THE_COMPLAINT = null;
    public static final /* synthetic */ ComplaintState[] a = null;
    int result;

    static {
        ComplaintState r0 = new ComplaintState("IN_THE_COMPLAINT", 0, 0);
        IN_THE_COMPLAINT = r0;
        ComplaintState r1 = new ComplaintState("COMPLAINT_SUCCESS", 1, 1);
        COMPLAINT_SUCCESS = r1;
        ComplaintState r3 = new ComplaintState("COMPLAINT_FAIL", 2, 2);
        COMPLAINT_FAIL = r3;
        a = new ComplaintState[]{r0, r1, r3};
    }

    public static ComplaintState[] values() {
        return (ComplaintState[]) a.clone();
    }

    public int getResult() {
        return this.result;
    }

    public static ComplaintState valueOf(String r1) {
        return (ComplaintState) r27.a.a(ComplaintState.class, r1);
    }

    public ComplaintState(String r1, int r2, int r3) {
        super(r1, r2);
        this.result = r3;
    }
}
