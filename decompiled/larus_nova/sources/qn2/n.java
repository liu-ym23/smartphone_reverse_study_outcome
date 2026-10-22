package qn2;

import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f534021a = null;

    static {
        int[] r100 = new int[RoomParamsConsumeStage.values().length];
        f534021a = r100;
        r100[RoomParamsConsumeStage.START_FIRST_ROOM.ordinal()] = 1;
        r100[RoomParamsConsumeStage.POST_DO_CHANGE_PAGE.ordinal()] = 2;
        r100[RoomParamsConsumeStage.CHANGE_PAGE_TO_FIRST.ordinal()] = 3;
        r100[RoomParamsConsumeStage.PRE_DO_CHANGE_PAGE.ordinal()] = 4;
    }
}
