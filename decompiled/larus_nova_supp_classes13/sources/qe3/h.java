package qe3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lqe3/h;", "", "", "activityId", "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "", "InvolveStatus", "Ljava/lang/Integer;", "getInvolveStatus", "()Ljava/lang/Integer;", "", "involveNum", "Ljava/lang/Long;", "getInvolveNum", "()Ljava/lang/Long;", "", "Lqe3/b;", "progresses", "Ljava/util/List;", "getProgresses", "()Ljava/util/List;", "buttonTip", "getButtonTip", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("draw_involve_status")
    private final Integer InvolveStatus;

    @SerializedName("draw_activity_id")
    private final String activityId;

    @SerializedName("draw_button_tip_desc")
    private final String buttonTip;

    @SerializedName("draw_involve_num")
    private final Long involveNum;

    @SerializedName("draw_progresses")
    private final List<b> progresses;

    public h() {
    }
}
