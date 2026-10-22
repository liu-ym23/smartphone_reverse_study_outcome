package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class UserGroup implements Parcelable {
    public static final Parcelable.Creator<UserGroup> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f233642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f233643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f233644c;

    public class a implements Parcelable.Creator<UserGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserGroup createFromParcel(Parcel r100) {
            return new UserGroup(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UserGroup[] newArray(int r100) {
            return new UserGroup[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f233642a});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "UserGroup{groupId='" + this.f233642a + "', name='" + this.f233643b + "'}";
    }

    public UserGroup() {
        this.f233644c = -1;
    }

    public UserGroup(Parcel r100) {
        this.f233644c = -1;
        this.f233642a = r100.readString();
        this.f233643b = r100.readString();
        this.f233644c = r100.readInt();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f233642a.equals(((UserGroup) r100).f233642a);
    }

    public UserGroup(String r100, String r101) {
        this.f233644c = -1;
        this.f233642a = r100;
        this.f233643b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f233642a);
        r100.writeString(this.f233643b);
        r100.writeInt(this.f233644c);
    }
}
