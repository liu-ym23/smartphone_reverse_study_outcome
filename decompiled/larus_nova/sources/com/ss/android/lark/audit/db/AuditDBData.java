package com.ss.android.lark.audit.db;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.pb.security_event.Event;
import gwa.c;

/* JADX INFO: loaded from: classes34.dex */
public class AuditDBData implements Parcelable {
    public static final Parcelable.Creator<AuditDBData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f409449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Event f409451c;

    public class a implements Parcelable.Creator<AuditDBData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AuditDBData createFromParcel(Parcel r100) {
            return new AuditDBData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AuditDBData[] newArray(int r100) {
            return new AuditDBData[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AuditDBData(Parcel r100) {
        this.f409449a = r100.readLong();
        String r101 = r100.readString();
        this.f409450b = r101;
        this.f409451c = c.a(r101);
    }

    public AuditDBData(long r100, String r101) {
        this.f409449a = r100;
        this.f409450b = r101;
        this.f409451c = c.a(r101);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f409449a);
        r100.writeString(this.f409450b);
    }
}
