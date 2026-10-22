package com.bytedance.android.shopping.buynow.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowOrderSchema;", "Landroid/os/Parcelable;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowOrderSchema implements Parcelable {
    public static final Parcelable.Creator<BuyNowOrderSchema> CREATOR = null;
    public final String a;
    public final EntranceInfoScene b;

    public static class a implements Parcelable.Creator<BuyNowOrderSchema> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowOrderSchema createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "in");
            return new BuyNowOrderSchema(r4.readString(), r4.readParcelable(BuyNowOrderSchema.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowOrderSchema[] newArray(int r1) {
            return new BuyNowOrderSchema[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.a);
        r2.writeParcelable(this.b, r3);
    }

    public BuyNowOrderSchema(String r2, EntranceInfoScene r3) {
        Intrinsics.checkNotNullParameter(r2, "finalUrl");
        Intrinsics.checkNotNullParameter(r3, "entranceInfoScene");
        this.a = r2;
        this.b = r3;
    }
}
