package com.ss.android.lark.contact.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes35.dex */
public class EmailContact implements Parcelable {
    public static final Parcelable.Creator<EmailContact> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f419449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f419450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f419451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f419452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f419453e;

    public class a implements Parcelable.Creator<EmailContact> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EmailContact createFromParcel(Parcel r100) {
            return new EmailContact(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final EmailContact[] newArray(int r100) {
            return new EmailContact[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int getType() {
        return this.f419453e;
    }

    public EmailContact(Parcel r100) {
        this.f419449a = r100.readString();
        this.f419450b = r100.readString();
        this.f419451c = r100.readString();
        this.f419452d = r100.readString();
        this.f419453e = r100.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f419449a);
        r100.writeString(this.f419450b);
        r100.writeString(this.f419451c);
        r100.writeString(this.f419452d);
        r100.writeInt(this.f419453e);
    }
}
