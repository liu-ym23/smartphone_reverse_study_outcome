package com.bytedance.android.shopping.skubuy.starter;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/starter/SkuBuyPageInfo;", "Lcom/bytedance/android/shopping/abscontainer/arch/core/starter/PageInfo;", "Landroid/os/Parcelable;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBuyPageInfo extends PageInfo {
    public static final Parcelable.Creator<SkuBuyPageInfo> CREATOR = null;
    public final String a;
    public final String b;
    public final ISkuBuySchemaModel c;
    public final boolean d;
    public final boolean e;
    public final String f;

    public static class a implements Parcelable.Creator<SkuBuyPageInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SkuBuyPageInfo createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            String r2 = r9.readString();
            String r3 = r9.readString();
            ISkuBuySchemaModel r4 = r9.readParcelable(SkuBuyPageInfo.class.getClassLoader());
            boolean r6 = false;
            if (r9.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            if (r9.readInt() == 0) goto L9;
            r6 = true;
        L9:
            boolean r5 = r7;
            return new SkuBuyPageInfo(r2, r3, r4, r5, r6, r9.readString());
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final SkuBuyPageInfo[] newArray(int r1) {
            return new SkuBuyPageInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeParcelable(this.c, r3);
        r2.writeInt(this.d ? 1 : 0);
        r2.writeInt(this.e ? 1 : 0);
        r2.writeString(this.f);
    }

    public final String getBizCode() {
        return this.a;
    }

    public final boolean getInSplitScreen() {
        return this.d;
    }

    public final String getSessionID() {
        return this.b;
    }

    public final boolean isSplitScreenOpened() {
        return this.e;
    }

    public SkuBuyPageInfo(String r2, String r3, ISkuBuySchemaModel r4, boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "bizCode");
        Intrinsics.checkNotNullParameter(r3, "sessionID");
        Intrinsics.checkNotNullParameter(r4, "skuBuySchemaModel");
        super(r2, r3, r4, r5, r6);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
