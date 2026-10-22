package com.bytedance.ee.bear.list.folder.complaint;

/* JADX INFO: loaded from: classes18.dex */
public final enum ComplaintState extends Enum<ComplaintState> {
    public static final ComplaintState COMPLAINT_FAIL = null;
    public static final ComplaintState COMPLAINT_SUCCESS = null;
    public static final ComplaintState IN_THE_COMPLAINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComplaintState[] f228057a = null;
    int result;

    static {
        ComplaintState r100 = new ComplaintState("IN_THE_COMPLAINT", 0, 0);
        IN_THE_COMPLAINT = r100;
        ComplaintState r101 = new ComplaintState("COMPLAINT_SUCCESS", 1, 1);
        COMPLAINT_SUCCESS = r101;
        ComplaintState r102 = new ComplaintState("COMPLAINT_FAIL", 2, 2);
        COMPLAINT_FAIL = r102;
        f228057a = new ComplaintState[]{r100, r101, r102};
    }

    public static ComplaintState[] values() {
        return (ComplaintState[]) f228057a.clone();
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
