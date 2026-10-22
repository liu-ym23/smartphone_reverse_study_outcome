package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User", "", "", "component1", "component2", "avatar", "nickname", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "getNickname", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$User {
    private final String avatar;
    private final String nickname;

    public static /* synthetic */ CommonModel$User copy$default(CommonModel$User r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.avatar;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.nickname;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickname;
    }

    public final CommonModel$User copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "avatar");
        Intrinsics.checkNotNullParameter(r3, "nickname");
        return new CommonModel$User(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$User) == false) goto L10;
        CommonModel$User r4 = (CommonModel$User) r3;
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nickname, r4.nickname) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.avatar;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.nickname;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "User(avatar=" + this.avatar + ", nickname=" + this.nickname + ")";
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public CommonModel$User(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "avatar");
        Intrinsics.checkNotNullParameter(r3, "nickname");
        this.avatar = r2;
        this.nickname = r3;
    }
}
