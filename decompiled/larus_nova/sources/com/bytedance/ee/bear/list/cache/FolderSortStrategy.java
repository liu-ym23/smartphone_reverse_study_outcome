package com.bytedance.ee.bear.list.cache;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class FolderSortStrategy implements Parcelable {
    public static final Parcelable.Creator<FolderSortStrategy> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f227680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f227681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f227682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f227683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f227684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f227685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f227686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f227687h;

    public class a implements Parcelable.Creator<FolderSortStrategy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderSortStrategy createFromParcel(Parcel r100) {
            return new FolderSortStrategy(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FolderSortStrategy[] newArray(int r100) {
            return new FolderSortStrategy[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f227680a, Integer.valueOf(this.f227681b), this.f227682c, this.f227683d, Integer.valueOf(this.f227684e), Boolean.valueOf(this.f227685f)});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "FolderSortStrategy{, type=" + this.f227681b + ", file_type='" + this.f227682c + "', forbidden_file_type='" + this.f227683d + "', strategy=" + this.f227684e + ", is_asc=" + this.f227685f + ", update_time='" + this.f227686g + "'}";
    }

    public FolderSortStrategy() {
        this.f227681b = FilterType.ALL.getType();
        this.f227684e = -1;
    }

    public int getType() {
        return this.f227681b;
    }

    public FolderSortStrategy(Parcel r100) {
        this.f227680a = r100.readString();
        this.f227681b = r100.readInt();
        this.f227682c = r100.readString();
        this.f227683d = r100.readString();
        this.f227684e = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f227685f = r101;
        this.f227686g = r100.readString();
        this.f227687h = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        FolderSortStrategy r101 = (FolderSortStrategy) r100;
        if (this.f227681b == r101.f227681b) goto L13;
    L23:
        return false;
    L13:
        if (this.f227684e != r101.f227684e) goto L23;
        if (this.f227685f != r101.f227685f) goto L23;
        if (this.f227680a.equals(r101.f227680a) == false) goto L23;
        if (Objects.equals(this.f227682c, r101.f227682c) == false) goto L23;
        if (Objects.equals(this.f227683d, r101.f227683d) == false) goto L23;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f227680a);
        r100.writeInt(this.f227681b);
        r100.writeString(this.f227682c);
        r100.writeString(this.f227683d);
        r100.writeInt(this.f227684e);
        r100.writeByte(this.f227685f ? 1 : 0);
        r100.writeString(this.f227686g);
        r100.writeString(this.f227687h);
    }

    public FolderSortStrategy(String r100, int r101, String r102, String r103, int r104, boolean r105) {
        this.f227680a = r100;
        this.f227681b = r101;
        this.f227682c = r102;
        this.f227683d = r103;
        this.f227684e = r104;
        this.f227685f = r105;
        this.f227686g = String.valueOf(System.currentTimeMillis());
    }
}
