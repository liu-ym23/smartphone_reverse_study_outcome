package com.bytedance.android.shopping.store.utils.screenAdapt;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/DisplayMetricsInfo;", "Landroid/os/Parcelable;", "CREATOR", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DisplayMetricsInfo implements Parcelable {
    public static final a CREATOR = null;
    public final float a;
    public final int b;
    public final float c;
    public final float d;
    public final int e;
    public final int f;

    public static final class a implements Parcelable.Creator<DisplayMetricsInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayMetricsInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new DisplayMetricsInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DisplayMetricsInfo[] newArray(int r1) {
            return new DisplayMetricsInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "DisplayMetricsInfo{density=" + this.a + ",densityDpi=" + this.b + ",scaledDensity=" + this.c + ",xdpi=" + this.d + ",screenWidthDp=" + this.e + ",screenHeightDp=" + this.f;
    }

    public DisplayMetricsInfo(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this.a = r2.readFloat();
        this.b = r2.readInt();
        this.c = r2.readFloat();
        this.d = r2.readFloat();
        this.e = r2.readInt();
        this.f = r2.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeFloat(this.a);
        r1.writeInt(this.b);
        r1.writeFloat(this.c);
        r1.writeFloat(this.d);
        r1.writeInt(this.e);
        r1.writeInt(this.f);
    }

    public DisplayMetricsInfo(float r1, int r2, float r3, float r4, int r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
