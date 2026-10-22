package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Ljx6/d;", "", "", "avatar", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "userNick", "c", "comment", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("comment")
    private final String comment;

    @SerializedName("user_nick")
    private final String userNick;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userNick, r101.userNick) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.comment, r101.comment) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.avatar.hashCode() * 31) + this.userNick.hashCode()) * 31) + this.comment.hashCode();
    }

    public final String toString() {
        return "BuyerShowVO(avatar=" + this.avatar + ", userNick=" + this.userNick + ", comment=" + this.comment + ')';
    }

    public final String a() {
        return this.avatar;
    }

    public final String b() {
        return this.comment;
    }

    public final String c() {
        return this.userNick;
    }
}
