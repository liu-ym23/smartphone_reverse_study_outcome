package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

/* JADX INFO: loaded from: classes23.dex */
public class Scope implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<Scope> CREATOR = null;
    private String mScopeUri;

    public class a implements Parcelable.Creator<Scope> {
        public a() {
        }

        public Scope a(Parcel r100) {
            return new Scope(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Scope createFromParcel(Parcel r100) {
            return a(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Scope[] newArray(int r100) {
            return a(r100);
        }

        public Scope[] a(int r100) {
            return new Scope[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final int hashCode() {
        String r100 = this.mScopeUri;
        if (r100 != null) goto L6;
        return super.hashCode();
    L6:
        return r100.hashCode();
    }

    public Scope() {
        this.mScopeUri = null;
    }

    public String getScopeUri() {
        return this.mScopeUri;
    }

    public final String toString() {
        return this.mScopeUri;
    }

    public Scope(Parcel r100) {
        this.mScopeUri = r100.readString();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scope) == true) goto L10;
        return false;
    L10:
        return Objects.equal(this.mScopeUri, ((Scope) r100).mScopeUri);
    }

    public boolean equeals(Object r100) {
        return equals(r100);
    }

    public Scope(String r100) {
        this.mScopeUri = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mScopeUri);
    }
}
