package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class AttachmentInfo implements Parcelable {
    public static final Parcelable.Creator<AttachmentInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f225992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f225993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f225994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f225995d;

    public class a implements Parcelable.Creator<AttachmentInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentInfo createFromParcel(Parcel r100) {
            return new AttachmentInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentInfo[] newArray(int r100) {
            return new AttachmentInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AttachmentInfo() {
    }

    public String getType() {
        return this.f225994c;
    }

    public AttachmentInfo(Parcel r100) {
        this.f225992a = r100.readString();
        this.f225993b = r100.readString();
        this.f225994c = r100.readString();
        this.f225995d = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f225992a);
        r100.writeString(this.f225993b);
        r100.writeString(this.f225994c);
        r100.writeString(this.f225995d);
    }
}
