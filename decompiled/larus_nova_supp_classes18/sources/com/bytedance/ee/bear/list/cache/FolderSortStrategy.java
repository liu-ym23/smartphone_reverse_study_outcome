package com.bytedance.ee.bear.list.cache;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderSortStrategy implements Parcelable {
    public static final Parcelable.Creator<FolderSortStrategy> CREATOR = null;
    public String a;
    public int b;
    public String c;
    public String d;
    public int e;
    public boolean f;
    public String g;
    public String h;

    public class a implements Parcelable.Creator<FolderSortStrategy> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FolderSortStrategy createFromParcel(Parcel r2) {
            return new FolderSortStrategy(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FolderSortStrategy[] newArray(int r1) {
            return new FolderSortStrategy[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, Integer.valueOf(this.b), this.c, this.d, Integer.valueOf(this.e), Boolean.valueOf(this.f)});
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "FolderSortStrategy{, type=" + this.b + ", file_type='" + this.c + "', forbidden_file_type='" + this.d + "', strategy=" + this.e + ", is_asc=" + this.f + ", update_time='" + this.g + "'}";
    }

    public FolderSortStrategy() {
        this.b = FilterType.ALL.getType();
        this.e = -1;
    }

    public int getType() {
        return this.b;
    }

    public FolderSortStrategy(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readInt();
        this.c = r2.readString();
        this.d = r2.readString();
        this.e = r2.readInt();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.f = r0;
        this.g = r2.readString();
        this.h = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        FolderSortStrategy r6 = (FolderSortStrategy) r5;
        if (this.b == r6.b) goto L13;
    L23:
        return false;
    L13:
        if (this.e != r6.e) goto L23;
        if (this.f != r6.f) goto L23;
        if (this.a.equals(r6.a) == false) goto L23;
        if (Objects.equals(this.c, r6.c) == false) goto L23;
        if (Objects.equals(this.d, r6.d) == false) goto L23;
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeInt(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
        r1.writeByte(this.f ? 1 : 0);
        r1.writeString(this.g);
        r1.writeString(this.h);
    }

    public FolderSortStrategy(String r1, int r2, String r3, String r4, int r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = String.valueOf(System.currentTimeMillis());
    }
}
