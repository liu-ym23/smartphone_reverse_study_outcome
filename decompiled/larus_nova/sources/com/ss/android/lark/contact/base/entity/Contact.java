package com.ss.android.lark.contact.base.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class Contact implements Parcelable, Serializable {
    public static final Parcelable.Creator<Contact> CREATOR = null;
    protected String avatarKey;
    protected String chatterId;
    protected String displayName;

    public class a implements Parcelable.Creator<Contact> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Contact createFromParcel(Parcel r100) {
            return new Contact(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Contact[] newArray(int r100) {
            return new Contact[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getChatterId() {
        return this.chatterId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Contact(Parcel r100) {
        this.chatterId = r100.readString();
        this.avatarKey = r100.readString();
        this.displayName = r100.readString();
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setChatterId(String r100) {
        this.chatterId = r100;
    }

    public void setDisplayName(String r100) {
        this.displayName = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.chatterId);
        r100.writeString(this.avatarKey);
        r100.writeString(this.displayName);
    }

    public Contact(String r100, String r101, String r102) {
        this.chatterId = r100;
        this.avatarKey = r101;
        this.displayName = r102;
    }
}
