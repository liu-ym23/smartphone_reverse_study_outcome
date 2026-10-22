package com.larus.extension.account_auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015¨\u0006-"}, d2 = {"Lcom/larus/extension/account_auth/api/model/PlatformSilentAuthOpenInfo;", "Landroid/os/Parcelable;", "openId", "", "accessToken", "userId", "secUserId", "expiredTime", "", "isDoubaoBind", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getOpenId", "()Ljava/lang/String;", "getAccessToken", "getUserId", "getSecUserId", "getExpiredTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isValid", "isExpired", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/extension/account_auth/api/model/PlatformSilentAuthOpenInfo;", "describeContents", "", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformSilentAuthOpenInfo implements Parcelable {
    public static final Parcelable.Creator<PlatformSilentAuthOpenInfo> CREATOR = null;

    @SerializedName("access_token")
    private final String accessToken;

    @SerializedName("expire_time")
    private final Long expiredTime;

    @SerializedName("is_bind")
    private final Boolean isDoubaoBind;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private final String openId;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final String userId;

    public static final class a implements Parcelable.Creator<PlatformSilentAuthOpenInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSilentAuthOpenInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Long r104 = null;
        L7:
            if (r110.readInt() != 0) goto L10;
            Boolean r111 = null;
        L15:
            return new PlatformSilentAuthOpenInfo(r100, r101, r102, r103, r104, r111);
        L10:
            if (r110.readInt() == 0) goto L12;
            boolean r112 = true;
        L13:
            r111 = Boolean.valueOf(r112);
            goto L15
        L12:
            r112 = false;
            goto L13
        L5:
            r104 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PlatformSilentAuthOpenInfo[] newArray(int r100) {
            return new PlatformSilentAuthOpenInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PlatformSilentAuthOpenInfo() {
        this(null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PlatformSilentAuthOpenInfo) == true) goto L8;
        return false;
    L8:
        PlatformSilentAuthOpenInfo r101 = (PlatformSilentAuthOpenInfo) r100;
        if (Intrinsics.areEqual(this.openId, r101.openId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.accessToken, r101.accessToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isDoubaoBind, r101.isDoubaoBind) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.openId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.accessToken;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.userId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secUserId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.expiredTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isDoubaoBind;
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.openId);
        r100.writeString(this.accessToken);
        r100.writeString(this.userId);
        r100.writeString(this.secUserId);
        Long r102 = this.expiredTime;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.isDoubaoBind;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final String toString() {
        return "openId:" + d99.a.a(String.valueOf(this.openId)) + ";accessToken:" + d99.a.a(String.valueOf(this.accessToken)) + ";userId:" + this.userId + ";secUserId:" + this.secUserId + ";expiredTime:" + this.expiredTime + ";isDoubaoBind:" + this.isDoubaoBind;
    }

    public PlatformSilentAuthOpenInfo(String r100, String r101, String r102, String r103, Long r104, Boolean r105) {
        this.openId = r100;
        this.accessToken = r101;
        this.userId = r102;
        this.secUserId = r103;
        this.expiredTime = r104;
        this.isDoubaoBind = r105;
    }
}
