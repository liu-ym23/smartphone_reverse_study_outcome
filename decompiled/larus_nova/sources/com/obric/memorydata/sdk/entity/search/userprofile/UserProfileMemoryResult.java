package com.obric.memorydata.sdk.entity.search.userprofile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemoryResult;", "Landroid/os/Parcelable;", "errorCode", "", "errorMsg", "", "profileValue", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getProfileValue", "isSuccess", "", "describeContents", "writeToParcel", "", "flags", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileMemoryResult implements Parcelable {
    public static final a CREATOR = null;
    private final int errorCode;
    private final String errorMsg;
    private final String profileValue;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<UserProfileMemoryResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserProfileMemoryResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UserProfileMemoryResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UserProfileMemoryResult[] newArray(int r100) {
            return new UserProfileMemoryResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean isSuccess() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getProfileValue() {
        return this.profileValue;
    }

    public UserProfileMemoryResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.readInt(), r100.readString(), r100.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.errorCode);
        r100.writeString(this.errorMsg);
        r100.writeString(this.profileValue);
    }

    public UserProfileMemoryResult(int r100, String r101, String r102) {
        this.errorCode = r100;
        this.errorMsg = r101;
        this.profileValue = r102;
    }
}
