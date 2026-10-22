package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/VisualSearchParam;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class VisualSearchParam implements Parcelable {
    public static final Parcelable.Creator<VisualSearchParam> CREATOR = null;
    public final String a;
    public final int b;
    public final ECUrlModel c;
    public final VisualSearchLogData d;
    public final long e;

    public static class a implements Parcelable.Creator<VisualSearchParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchParam createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            return new VisualSearchParam(r9.readString(), r9.readInt(), r9.readParcelable(VisualSearchParam.class.getClassLoader()), VisualSearchLogData.CREATOR.createFromParcel(r9), r9.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchParam[] newArray(int r1) {
            return new VisualSearchParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof VisualSearchParam) == false) goto L16;
        VisualSearchParam r6 = (VisualSearchParam) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        ECUrlModel r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        VisualSearchLogData r7 = this.d;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        long r9 = this.e;
        return r8 + ((int) (r9 ^ (r9 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VisualSearchParam(itemId=" + this.a + ", searchType=" + this.b + ", imageUrl=" + this.c + ", logData=" + this.d + ", clickTimestamp=" + this.e + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.a);
        r3.writeInt(this.b);
        r3.writeParcelable(this.c, r4);
        this.d.writeToParcel(r3, 0);
        r3.writeLong(this.e);
    }

    public VisualSearchParam(String r2, int r3, ECUrlModel r4, VisualSearchLogData r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r5, "logData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
