package com.ss.android.lark.passportc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passportc/entity/UserSession;", "Landroid/os/Parcelable;", "sessionKey", "", "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSessionKey", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "container-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSession implements Parcelable {
    public static final Parcelable.Creator<UserSession> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f438137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f438138b;

    public static final class a implements Parcelable.Creator<UserSession> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserSession createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UserSession(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UserSession[] newArray(int r100) {
            return new UserSession[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserSession) == true) goto L8;
        return false;
    L8:
        UserSession r101 = (UserSession) r100;
        if (Intrinsics.areEqual(this.f438137a, r101.f438137a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f438138b, r101.f438138b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f438137a.hashCode() * 31) + this.f438138b.hashCode();
    }

    public final String toString() {
        return "UserSession(sessionKey=" + this.f438137a + ", userId=" + this.f438138b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f438137a);
        r100.writeString(this.f438138b);
    }

    public UserSession(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionKey");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.f438137a = r100;
        this.f438138b = r101;
    }
}
