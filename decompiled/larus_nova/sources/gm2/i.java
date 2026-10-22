package gm2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class i {

    @SerializedName("priority")
    public int priority;

    @SerializedName("send_uid")
    public String senderInteractId;

    @SerializedName("send_uid_str")
    public String senderInteractIdStr;

    @SerializedName("send_id")
    public String senderUserId;

    @SerializedName("target_uid")
    public String targetInteractId;

    @SerializedName("target_uid_str")
    public String targetInteractIdStr;

    @SerializedName("target_id")
    public String targetUserId;

    @SerializedName("type")
    public int type;

    @SerializedName("ver")
    public String version;

    public i() {
        this.version = "1";
        this.priority = 1;
    }
}
