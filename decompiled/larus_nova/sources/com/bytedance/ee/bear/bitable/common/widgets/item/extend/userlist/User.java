package com.bytedance.ee.bear.bitable.common.widgets.item.extend.userlist;

import androidx.autofill.HintConstants;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/extend/userlist/User;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "userid", "getUserid", HintConstants.AUTOFILL_HINT_USERNAME, "getUsername", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class User implements NonProguard {

    @SerializedName("avatar_url")
    @JSONField(name = "avatar_url")
    private final String avatarUrl;
    private final String userid;
    private final String username;

    public int hashCode() {
        return (((this.avatarUrl.hashCode() * 31) + this.userid.hashCode()) * 31) + this.username.hashCode();
    }

    public User() {
        this.avatarUrl = "";
        this.userid = "";
        this.username = "";
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getUserid() {
        return this.userid;
    }

    public final String getUsername() {
        return this.username;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(User.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.widgets.item.extend.userlist.User");
        User r102 = (User) r100;
        if (Intrinsics.areEqual(this.avatarUrl, r102.avatarUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.userid, r102.userid) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.username, r102.username) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
