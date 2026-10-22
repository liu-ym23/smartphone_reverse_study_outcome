package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/VisualSearchLogData;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class VisualSearchLogData implements Parcelable {
    public static final Parcelable.Creator<VisualSearchLogData> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public static class a implements Parcelable.Creator<VisualSearchLogData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchLogData createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "in");
            return new VisualSearchLogData(r5.readString(), r5.readString(), r5.readString(), r5.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final VisualSearchLogData[] newArray(int r1) {
            return new VisualSearchLogData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof VisualSearchLogData) == false) goto L14;
        VisualSearchLogData r4 = (VisualSearchLogData) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VisualSearchLogData(groupId=" + this.a + ", sessionId=" + this.b + ", enterFrom=" + this.c + ", labLuckPigObjString=" + this.d + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
    }

    public VisualSearchLogData() {
        this("", "", "", "");
    }

    public VisualSearchLogData(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        Intrinsics.checkNotNullParameter(r5, "labLuckPigObjString");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
