package q38;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/account/base/model/BindConflictUserInfoData;", "", "profileInfo", "Lcom/larus/account/base/model/ProfileInfo;", "ticketInfo", "Lcom/larus/account/base/model/TicketInfo;", "userInfo", "Lcom/larus/account/base/model/UserInfo;", "<init>", "(Lcom/larus/account/base/model/ProfileInfo;Lcom/larus/account/base/model/TicketInfo;Lcom/larus/account/base/model/UserInfo;)V", "getProfileInfo", "()Lcom/larus/account/base/model/ProfileInfo;", "getTicketInfo", "()Lcom/larus/account/base/model/TicketInfo;", "getUserInfo", "()Lcom/larus/account/base/model/UserInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("profile_info")
    private final m profileInfo;

    @SerializedName("ticket_info")
    private final o ticketInfo;

    @SerializedName("user_info")
    private final p userInfo;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.profileInfo, r101.profileInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ticketInfo, r101.ticketInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        m r100 = this.profileInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.ticketInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        p r107 = this.userInfo;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BindConflictUserInfoData(profileInfo=" + this.profileInfo + ", ticketInfo=" + this.ticketInfo + ", userInfo=" + this.userInfo + ')';
    }

    public final m a() {
        return this.profileInfo;
    }

    public final o b() {
        return this.ticketInfo;
    }

    public final p c() {
        return this.userInfo;
    }

    public h(int r100) {
        this.profileInfo = null;
        this.ticketInfo = null;
        this.userInfo = null;
    }
}
