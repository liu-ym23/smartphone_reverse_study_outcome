package com.bytedance.android.shopping.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/model/BoughtParam;", "Landroid/os/Parcelable;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class BoughtParam implements Parcelable {
    public static final Parcelable.Creator<BoughtParam> CREATOR = null;
    public final String a;

    public static class a implements Parcelable.Creator<BoughtParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BoughtParam createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "in");
            return new BoughtParam(r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BoughtParam[] newArray(int r1) {
            return new BoughtParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof BoughtParam) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((BoughtParam) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "BoughtParam(id=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
    }

    public BoughtParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a = r2;
    }
}
