package fs9;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J^\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001e¨\u0006-"}, d2 = {"Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "profileBotInfo", "Lcom/larus/profile/api/bean/ProfileBotInfo;", "blocklistInfo", "Lcom/larus/profile/api/bean/BlockListInfo;", "relationInfo", "Lcom/larus/profile/api/bean/RelationInfo;", "profileStatus", "", "isFromCache", "", "isDowngraded", "<init>", "(Lcom/larus/account/base/model/profile/UserInfo;Lcom/larus/profile/api/bean/ProfileBotInfo;Lcom/larus/profile/api/bean/BlockListInfo;Lcom/larus/profile/api/bean/RelationInfo;Ljava/lang/Integer;ZZ)V", "getUserInfo", "()Lcom/larus/account/base/model/profile/UserInfo;", "getProfileBotInfo", "()Lcom/larus/profile/api/bean/ProfileBotInfo;", "setProfileBotInfo", "(Lcom/larus/profile/api/bean/ProfileBotInfo;)V", "getBlocklistInfo", "()Lcom/larus/profile/api/bean/BlockListInfo;", "getRelationInfo", "()Lcom/larus/profile/api/bean/RelationInfo;", "getProfileStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/account/base/model/profile/UserInfo;Lcom/larus/profile/api/bean/ProfileBotInfo;Lcom/larus/profile/api/bean/BlockListInfo;Lcom/larus/profile/api/bean/RelationInfo;Ljava/lang/Integer;ZZ)Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient boolean f478682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient boolean f478683b;

    @SerializedName("blocklist_info")
    private final b blocklistInfo;

    @Expose(deserialize = false, serialize = false)
    private o profileBotInfo;

    @SerializedName("profile_status")
    private final Integer profileStatus;

    @SerializedName("relation_info")
    private final w relationInfo;

    @SerializedName("profile_brief")
    private final r38.b userInfo;

    public u() {
        this(null, null, false, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profileBotInfo, r101.profileBotInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.blocklistInfo, r101.blocklistInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.relationInfo, r101.relationInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.profileStatus, r101.profileStatus) == true) goto L24;
        return false;
    L24:
        if (this.f478682a == r101.f478682a) goto L27;
        return false;
    L27:
        if (this.f478683b == r101.f478683b) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        r38.b r100 = this.userInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.profileBotInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.blocklistInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        w r110 = this.relationInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.profileStatus;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        int r115 = 1231;
        if (this.f478682a == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r114 + r116) * 31;
        if (this.f478683b == true) goto L31;
        r115 = 1237;
    L31:
        return r117 + r115;
    L25:
        r116 = 1237;
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProfileOverviewResponse(userInfo=" + this.userInfo + ", profileBotInfo=" + this.profileBotInfo + ", blocklistInfo=" + this.blocklistInfo + ", relationInfo=" + this.relationInfo + ", profileStatus=" + this.profileStatus + ", isFromCache=" + this.f478682a + ", isDowngraded=" + this.f478683b + ')';
    }

    public final b b() {
        return this.blocklistInfo;
    }

    public final o c() {
        return this.profileBotInfo;
    }

    public final Integer d() {
        return this.profileStatus;
    }

    public final w e() {
        return this.relationInfo;
    }

    public final r38.b f() {
        return this.userInfo;
    }

    public static u a(u r100) {
        r38.b r101 = r100.userInfo;
        o r102 = r100.profileBotInfo;
        b r103 = r100.blocklistInfo;
        w r104 = r100.relationInfo;
        Integer r105 = r100.profileStatus;
        boolean r106 = r100.f478683b;
        r100.getClass();
        return new u(r101, r102, r103, r104, r105, true, r106);
    }

    public final void g(o r100) {
        this.profileBotInfo = r100;
    }

    public /* synthetic */ u(r38.b r110, o r111, boolean r112, boolean r113, int r114) {
        Integer r100 = null;
        if ((r114 & 1) == 0) goto L5;
        r38.b r101 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        o r102 = null;
    L11:
        if ((r114 & 16) == 0) goto L13;
        r100 = 0;
    L13:
        Integer r103 = r100;
        if ((r114 & 32) == 0) goto L16;
        boolean r104 = false;
    L18:
        if ((r114 & 64) == 0) goto L20;
        boolean r105 = false;
    L21:
        this(r101, r102, null, null, r103, r104, r105);
        return;
    L20:
        r105 = r113;
        goto L21
    L16:
        r104 = r112;
        goto L18
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public u(r38.b r100, o r101, b r102, w r103, Integer r104, boolean r105, boolean r106) {
        this.userInfo = r100;
        this.profileBotInfo = r101;
        this.blocklistInfo = r102;
        this.relationInfo = r103;
        this.profileStatus = r104;
        this.f478682a = r105;
        this.f478683b = r106;
    }
}
