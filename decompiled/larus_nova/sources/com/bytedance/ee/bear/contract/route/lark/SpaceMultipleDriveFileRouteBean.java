package com.bytedance.ee.bear.contract.route.lark;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public class SpaceMultipleDriveFileRouteBean extends SpaceRouteBean {
    public static final Parcelable.Creator<SpaceMultipleDriveFileRouteBean> CREATOR = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f217134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<DriveFile> f217135i;

    public static class DriveFile implements Parcelable {
        public static final Parcelable.Creator<DriveFile> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f217136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f217137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f217138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f217139d;

        public class a implements Parcelable.Creator<DriveFile> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final DriveFile createFromParcel(Parcel r100) {
                return new DriveFile(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final DriveFile[] newArray(int r100) {
                return new DriveFile[r100];
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

        public DriveFile(Parcel r100) {
            this.f217136a = r100.readString();
            this.f217137b = r100.readString();
            this.f217138c = r100.readString();
            this.f217139d = r100.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f217136a);
            r100.writeString(this.f217137b);
            r100.writeString(this.f217138c);
            r100.writeString(this.f217139d);
        }
    }

    public class a implements Parcelable.Creator<SpaceMultipleDriveFileRouteBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceMultipleDriveFileRouteBean createFromParcel(Parcel r100) {
            return new SpaceMultipleDriveFileRouteBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceMultipleDriveFileRouteBean[] newArray(int r100) {
            return new SpaceMultipleDriveFileRouteBean[r100];
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
        this.f217140a = e.f541301l.f541317b;
    }

    public SpaceMultipleDriveFileRouteBean(Parcel r100) {
        super(r100);
        this.f217134h = r100.readInt();
        this.f217135i = r100.createTypedArrayList(DriveFile.CREATOR);
    }

    @Override // com.bytedance.ee.bear.contract.route.lark.SpaceRouteBean, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f217134h);
        r100.writeTypedList(this.f217135i);
    }
}
