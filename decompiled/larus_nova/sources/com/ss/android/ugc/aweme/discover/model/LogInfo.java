package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LogInfo;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "followStatus", "getFollowStatus", "setFollowStatus", "isFromKolWindow", "", "()Ljava/lang/Integer;", "setFromKolWindow", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LogInfo implements Serializable {

    @SerializedName("author_id")
    private String authorId;

    @SerializedName("follow_status")
    private String followStatus;

    @SerializedName("is_from_kol_window")
    private Integer isFromKolWindow;

    public LogInfo() {
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final Integer isFromKolWindow() {
        return this.isFromKolWindow;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setFollowStatus(String r100) {
        this.followStatus = r100;
    }

    public final void setFromKolWindow(Integer r100) {
        this.isFromKolWindow = r100;
    }
}
