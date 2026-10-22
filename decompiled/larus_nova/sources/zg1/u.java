package zg1;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class u {

    @SerializedName("msg_id")
    private long msgId;

    @SerializedName("reported_comment")
    private String reportedComment;

    @SerializedName("reported_sec_user_id")
    private String reportedSecUserId;

    @SerializedName("reported_user_id")
    private String reportedUserId;

    @SerializedName("reported_webcast_uid")
    private String reportedWebcastUid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMMENT_TYPE)
    private String toCommentType;

    @SerializedName("type")
    private int type;

    public u() {
    }

    public final long a() {
        return this.msgId;
    }

    public final String b() {
        return this.reportedComment;
    }

    public final String c() {
        return this.reportedSecUserId;
    }

    public final String d() {
        return this.reportedUserId;
    }

    public final String e() {
        return this.reportedWebcastUid;
    }

    public final String f() {
        return this.toCommentType;
    }

    public int getType() {
        return this.type;
    }

    public final void g(String r100) {
        this.toCommentType = r100;
    }

    public u(String r100, String r101, long r102, int r103, String r104) {
        this.reportedUserId = r100;
        this.reportedComment = r101;
        this.msgId = r102;
        this.type = r103;
        this.reportedWebcastUid = r104;
        this.reportedSecUserId = r100;
    }
}
