package com.bytedance.ee.bear.contract.route.lark;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SpaceMultipleDriveFileRouteBean extends SpaceRouteBean {
    public static final Parcelable.Creator<SpaceMultipleDriveFileRouteBean> CREATOR = null;
    public final int h;
    public final ArrayList<DriveFile> i;

    public static class DriveFile implements Parcelable {
        public static final Parcelable.Creator<DriveFile> CREATOR = null;
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public class a implements Parcelable.Creator<DriveFile> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DriveFile createFromParcel(Parcel r2) {
                return new DriveFile(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final DriveFile[] newArray(int r1) {
                return new DriveFile[r1];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public DriveFile() {
        }

        public DriveFile(Parcel r2) {
            this.a = r2.readString();
            this.b = r2.readString();
            this.c = r2.readString();
            this.d = r2.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.a);
            r1.writeString(this.b);
            r1.writeString(this.c);
            r1.writeString(this.d);
        }
    }

    public class a implements Parcelable.Creator<SpaceMultipleDriveFileRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceMultipleDriveFileRouteBean createFromParcel(Parcel r2) {
            return new SpaceMultipleDriveFileRouteBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceMultipleDriveFileRouteBean[] newArray(int r1) {
            return new SpaceMultipleDriveFileRouteBean[r1];
        }
    }

    @Override // com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SpaceMultipleDriveFileRouteBean() {
        this.a = e.l.b;
    }

    public SpaceMultipleDriveFileRouteBean(Parcel r2) {
        super(r2);
        this.h = r2.readInt();
        this.i = r2.createTypedArrayList(DriveFile.CREATOR);
    }

    @Override // com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.h);
        r1.writeTypedList(this.i);
    }
}
