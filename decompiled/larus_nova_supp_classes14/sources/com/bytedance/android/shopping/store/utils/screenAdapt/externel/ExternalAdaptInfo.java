package com.bytedance.android.shopping.store.utils.screenAdapt.externel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/screenAdapt/externel/ExternalAdaptInfo;", "Landroid/os/Parcelable;", "CREATOR", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalAdaptInfo implements Parcelable {
    public static final a CREATOR = null;
    public final boolean a;
    public final float b;

    public static final class a implements Parcelable.Creator<ExternalAdaptInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ExternalAdaptInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ExternalAdaptInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ExternalAdaptInfo[] newArray(int r1) {
            return new ExternalAdaptInfo[r1];
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
        return "ExternalAdaptInfo{isBaseOnWidth=" + this.a + ",sizeInDp=" + this.b + '}';
    }

    public ExternalAdaptInfo(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        boolean r1 = false;
        if (r4.readByte() == ((byte) 0)) goto L5;
        r1 = true;
    L5:
        this.a = r1;
        this.b = r4.readFloat();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        if (this.a == false) goto L5;
        int r3 = 1;
    L6:
        r1.writeByte((byte) r3);
        r1.writeFloat(this.b);
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
