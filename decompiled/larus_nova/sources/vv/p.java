package vv;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lvv/p;", "Lvv/b;", "", "userId", "Ljava/lang/Long;", "", InstantPlayContext.NICKNAME, "Ljava/lang/String;", "", "needNotifyToApply", "Ljava/lang/Boolean;", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements b {

    @SerializedName(InstantPlayContext.NEED_NOTIFY_TO_APPLY)
    public Boolean needNotifyToApply;

    @SerializedName(InstantPlayContext.NICKNAME)
    public String nickname;

    @SerializedName("user_id")
    public Long userId;

    public p() {
        this.userId = 0L;
        this.nickname = "";
        this.needNotifyToApply = Boolean.FALSE;
    }
}
