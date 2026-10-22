package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/Reviewer;", "Ljava/io/Serializable;", "userId", "", "userName", "userAvatarTosUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getUserName", "getUserAvatarTosUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Reviewer implements Serializable {

    @SerializedName("user_avatar_tos_url")
    private final String userAvatarTosUrl;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public Reviewer() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Reviewer copy$default(Reviewer r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.userName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.userAvatarTosUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.userAvatarTosUrl;
    }

    public final Reviewer copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "userAvatarTosUrl");
        return new Reviewer(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Reviewer) == true) goto L8;
        return false;
    L8:
        Reviewer r101 = (Reviewer) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userAvatarTosUrl, r101.userAvatarTosUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.userAvatarTosUrl.hashCode();
    }

    public String toString() {
        return "Reviewer(userId=" + this.userId + ", userName=" + this.userName + ", userAvatarTosUrl=" + this.userAvatarTosUrl + ')';
    }

    public final String getUserAvatarTosUrl() {
        return this.userAvatarTosUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public Reviewer(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "userAvatarTosUrl");
        this.userId = r100;
        this.userName = r101;
        this.userAvatarTosUrl = r102;
    }

    public /* synthetic */ Reviewer(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
