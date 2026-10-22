package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UserGroup implements Parcelable {
    public static final Parcelable.Creator<UserGroup> CREATOR = null;
    public String a;
    public String b;
    public int c;

    public class a implements Parcelable.Creator<UserGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserGroup createFromParcel(Parcel r2) {
            return new UserGroup(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UserGroup[] newArray(int r1) {
            return new UserGroup[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "UserGroup{groupId='" + this.a + "', name='" + this.b + "'}";
    }

    public UserGroup() {
        this.c = -1;
    }

    public UserGroup(Parcel r2) {
        this.c = -1;
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readInt();
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return this.a.equals(((UserGroup) r3).a);
    }

    public UserGroup(String r2, String r3) {
        this.c = -1;
        this.a = r2;
        this.b = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeInt(this.c);
    }
}
