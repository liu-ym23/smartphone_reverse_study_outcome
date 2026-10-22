package com.larus.login.impl.lark_discover;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\tJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006*"}, d2 = {"Lcom/larus/login/impl/lark_discover/PhoneLoginAccountCandidate;", "Landroid/os/Parcelable;", "name", "", "avatar", "tenantId", "tenantName", "tenantAvatarUrl", "passportEnterpriseUserType", "", "secUid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getAvatar", "getTenantId", "getTenantName", "getTenantAvatarUrl", "getPassportEnterpriseUserType", "()I", "getSecUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneLoginAccountCandidate implements Parcelable {
    public static final Parcelable.Creator<PhoneLoginAccountCandidate> CREATOR = null;

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("name")
    private final String name;

    @SerializedName("passport_enterprise_user_type")
    private final int passportEnterpriseUserType;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("tenant_avatar_url")
    private final String tenantAvatarUrl;

    @SerializedName("tenant_id")
    private final String tenantId;

    @SerializedName("tenant_name")
    private final String tenantName;

    public static final class a implements Parcelable.Creator<PhoneLoginAccountCandidate> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountCandidate createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new PhoneLoginAccountCandidate(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readInt(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneLoginAccountCandidate[] newArray(int r100) {
            return new PhoneLoginAccountCandidate[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhoneLoginAccountCandidate() {
        this(null, null, null, null, null, 0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneLoginAccountCandidate) == true) goto L8;
        return false;
    L8:
        PhoneLoginAccountCandidate r101 = (PhoneLoginAccountCandidate) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tenantId, r101.tenantId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tenantName, r101.tenantName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tenantAvatarUrl, r101.tenantAvatarUrl) == true) goto L24;
        return false;
    L24:
        if (this.passportEnterpriseUserType == r101.passportEnterpriseUserType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.avatar;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tenantId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tenantName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tenantAvatarUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.passportEnterpriseUserType) * 31;
        String r116 = this.secUid;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "PhoneLoginAccountCandidate(name=" + this.name + ", avatar=" + this.avatar + ", tenantId=" + this.tenantId + ", tenantName=" + this.tenantName + ", tenantAvatarUrl=" + this.tenantAvatarUrl + ", passportEnterpriseUserType=" + this.passportEnterpriseUserType + ", secUid=" + this.secUid + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.name);
        r100.writeString(this.avatar);
        r100.writeString(this.tenantId);
        r100.writeString(this.tenantName);
        r100.writeString(this.tenantAvatarUrl);
        r100.writeInt(this.passportEnterpriseUserType);
        r100.writeString(this.secUid);
    }

    public final String a() {
        return this.avatar;
    }

    public final int b() {
        return this.passportEnterpriseUserType;
    }

    public final String c() {
        return this.secUid;
    }

    public final String d() {
        return this.tenantName;
    }

    public final String getName() {
        return this.name;
    }

    public PhoneLoginAccountCandidate(String r100, String r101, String r102, String r103, String r104, int r105, String r106) {
        this.name = r100;
        this.avatar = r101;
        this.tenantId = r102;
        this.tenantName = r103;
        this.tenantAvatarUrl = r104;
        this.passportEnterpriseUserType = r105;
        this.secUid = r106;
    }
}
