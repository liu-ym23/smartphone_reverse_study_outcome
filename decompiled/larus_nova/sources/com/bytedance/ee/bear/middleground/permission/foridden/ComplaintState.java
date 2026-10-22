package com.bytedance.ee.bear.middleground.permission.foridden;

/* JADX INFO: loaded from: classes18.dex */
public final enum ComplaintState extends Enum<ComplaintState> {
    public static final ComplaintState COMPLAINT_FAIL = null;
    public static final ComplaintState COMPLAINT_PROGRESS_NEW = null;
    public static final ComplaintState COMPLAINT_SUCCESS = null;
    public static final ComplaintState COMPLAINT_SUCCESS_NEW = null;
    public static final ComplaintState IN_THE_COMPLAINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComplaintState[] f233886a = null;
    int result;

    static {
        ComplaintState r100 = new ComplaintState("IN_THE_COMPLAINT", 0, 0);
        IN_THE_COMPLAINT = r100;
        ComplaintState r101 = new ComplaintState("COMPLAINT_SUCCESS", 1, 1);
        COMPLAINT_SUCCESS = r101;
        ComplaintState r102 = new ComplaintState("COMPLAINT_FAIL", 2, 2);
        COMPLAINT_FAIL = r102;
        ComplaintState r103 = new ComplaintState("COMPLAINT_SUCCESS_NEW", 3, 10000);
        COMPLAINT_SUCCESS_NEW = r103;
        ComplaintState r104 = new ComplaintState("COMPLAINT_PROGRESS_NEW", 4, 10010);
        COMPLAINT_PROGRESS_NEW = r104;
        f233886a = new ComplaintState[]{r100, r101, r102, r103, r104};
    }

    public static ComplaintState[] values() {
        return (ComplaintState[]) f233886a.clone();
    }

    public int getResult() {
        return this.result;
    }

    public static ComplaintState valueOf(String r100) {
        return (ComplaintState) r27.a.a(ComplaintState.class, r100);
    }

    public ComplaintState(String r100, int r101, int r102) {
        super(r100, r101);
        this.result = r102;
    }
}
