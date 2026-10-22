package com.hihonor.cloudservice.support.account.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo;
import java.util.HashSet;

/* JADX INFO: loaded from: classes23.dex */
public class SignInAccountInfo extends AbstractSignInAccountInfo {
    public static final Parcelable.Creator<SignInAccountInfo> CREATOR = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f276496k;

    public class a implements Parcelable.Creator<SignInAccountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SignInAccountInfo createFromParcel(Parcel r100) {
            return new SignInAccountInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SignInAccountInfo[] newArray(int r100) {
            return new SignInAccountInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public final int hashCode() {
        return new HashSet(this.f276519g).hashCode();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public final String toString() {
        return "{photoUriString: " + this.f276514b + ",accountFlag" + this.f276496k + '}';
    }

    public SignInAccountInfo() {
        this.f276515c = new HashSet();
        this.f276496k = 0;
    }

    public SignInAccountInfo(Parcel r100) {
        this.f276513a = r100.readString();
        this.f276514b = r100.readString();
        this.f276516d = r100.readString();
        this.f276515c = new HashSet();
        this.f276517e = r100.readString();
        this.f276518f = r100.readString();
        this.f276520h = r100.readString();
        this.f276521i = r100.readLong();
        this.f276522j = r100.readString();
        this.f276496k = r100.readInt();
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo
    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SignInAccountInfo) == true) goto L10;
        return false;
    L10:
        return this.f276515c.equals(((SignInAccountInfo) r100).f276515c);
    }

    @Override // com.hihonor.cloudservice.support.feature.result.AbstractSignInAccountInfo, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f276496k);
    }

    public SignInAccountInfo(String r100, String r101, String r102, String r103) {
        super(r100, r101, r102, r103);
    }
}
