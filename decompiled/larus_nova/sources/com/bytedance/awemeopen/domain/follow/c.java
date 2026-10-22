package com.bytedance.awemeopen.domain.follow;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/domain/follow/c;", "Ln14/a;", "", "followStatus", "I", "f", "()I", "setFollowStatus", "(I)V", "", "logId", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class c extends n14.a {

    @SerializedName("is_follow")
    private int followStatus;

    @SerializedName("log_id")
    private String logId;

    public final boolean e() {
        int r100 = this.followStatus;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 4) goto L13;
        return false;
    L13:
        return true;
    }

    public final boolean h() {
        if (this.followStatus != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "FollowResult{followStatus=" + this.followStatus + ", err_no=" + a() + ", err_tips='" + b() + "'}";
    }

    public c() {
        this.followStatus = -1;
        this.logId = "";
    }

    public final int f() {
        return this.followStatus;
    }

    public final String g() {
        return this.logId;
    }
}
