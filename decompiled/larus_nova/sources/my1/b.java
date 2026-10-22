package my1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lmy1/b;", "", "", "hasAnimation", "Ljava/lang/Boolean;", "Lmy1/c;", "preSendConfirm", "Lmy1/c;", "", "taskPanelSchema", "Ljava/lang/String;", "sendSource", "rewardNum", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("has_animation")
    public Boolean hasAnimation;

    @SerializedName("pre_send_confirm")
    public c preSendConfirm;

    @SerializedName("reward_num")
    public String rewardNum;

    @SerializedName("send_source")
    public String sendSource;

    @SerializedName("task_panel_schema")
    public String taskPanelSchema;

    public b() {
        this.hasAnimation = Boolean.FALSE;
        this.taskPanelSchema = "";
        this.sendSource = "";
        this.rewardNum = "";
    }
}
