package com.bytedance.bdp.appbase.meta.impl.meta;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public class AppInfoRequestResult implements Parcelable {
    public static final Parcelable.Creator<AppInfoRequestResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f200825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f200826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f200827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f200828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f200829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<RequestMetaRecord> f200830i;

    public static class RequestMetaRecord implements Parcelable {
        public static final Parcelable.Creator<RequestMetaRecord> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f200831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f200832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f200833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f200834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f200835e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f200836f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f200837g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f200838h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f200839i;

        public class a implements Parcelable.Creator<RequestMetaRecord> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final RequestMetaRecord createFromParcel(Parcel r100) {
                return new RequestMetaRecord(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final RequestMetaRecord[] newArray(int r100) {
                return new RequestMetaRecord[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public RequestMetaRecord() {
        }

        public RequestMetaRecord(Parcel r100) {
            this.f200831a = r100.readString();
            this.f200832b = r100.readLong();
            this.f200833c = r100.readLong();
            this.f200834d = r100.readLong();
            this.f200835e = r100.readLong();
            this.f200836f = r100.readInt();
            this.f200837g = r100.readString();
            this.f200838h = r100.readString();
            this.f200839i = r100.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f200831a);
            r100.writeLong(this.f200832b);
            r100.writeLong(this.f200833c);
            r100.writeLong(this.f200834d);
            r100.writeLong(this.f200835e);
            r100.writeInt(this.f200836f);
            r100.writeString(this.f200837g);
            r100.writeString(this.f200838h);
            r100.writeString(this.f200839i);
        }
    }

    public class a implements Parcelable.Creator<AppInfoRequestResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppInfoRequestResult createFromParcel(Parcel r100) {
            return new AppInfoRequestResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AppInfoRequestResult[] newArray(int r100) {
            return new AppInfoRequestResult[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AppInfoRequestResult() {
        this.f200830i = new ArrayList();
    }

    public AppInfoRequestResult(Parcel r100) {
        this.f200830i = new ArrayList();
        this.f200822a = r100.readString();
        this.f200823b = r100.readString();
        this.f200824c = r100.readString();
        this.f200825d = r100.readLong();
        this.f200826e = r100.readLong();
        this.f200827f = r100.readLong();
        this.f200828g = r100.readLong();
        this.f200829h = r100.readString();
        this.f200830i = r100.createTypedArrayList(RequestMetaRecord.CREATOR);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f200822a);
        r100.writeString(this.f200823b);
        r100.writeString(this.f200824c);
        r100.writeLong(this.f200825d);
        r100.writeLong(this.f200826e);
        r100.writeLong(this.f200827f);
        r100.writeLong(this.f200828g);
        r100.writeString(this.f200829h);
        r100.writeTypedList(this.f200830i);
    }
}
