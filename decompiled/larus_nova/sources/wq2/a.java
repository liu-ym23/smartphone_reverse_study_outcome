package wq2;

import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileClickPos;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileReportType;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f560687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f560688b = null;

    static {
        int[] r100 = new int[UserProfileClickPos.values().length];
        f560687a = r100;
        r100[UserProfileClickPos.POSITION_LINKED_ANCHOR_MANAGE_SETTING.ordinal()] = 1;
        r100[UserProfileClickPos.POSITION_LINKED_ANCHOR.ordinal()] = 2;
        r100[UserProfileClickPos.POSITION_PK_HISTORY_RECORD.ordinal()] = 3;
        r100[UserProfileClickPos.POSITION_PK_LINKED_ANCHOR.ordinal()] = 4;
        int[] r101 = new int[UserProfileReportType.values().length];
        f560688b = r101;
        r101[UserProfileReportType.DATA_TYPE_CARD_LINKED_ANCHOR.ordinal()] = 1;
        r101[UserProfileReportType.DATA_TYPE_CARD_PK_ANCHOR.ordinal()] = 2;
    }
}
