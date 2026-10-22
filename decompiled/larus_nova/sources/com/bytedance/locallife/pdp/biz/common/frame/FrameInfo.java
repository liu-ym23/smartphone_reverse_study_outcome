package com.bytedance.locallife.pdp.biz.common.frame;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/pdp/biz/common/frame/FrameInfo;", "Landroid/os/Parcelable;", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class FrameInfo implements Parcelable {
    public static final Parcelable.Creator<FrameInfo> CREATOR = null;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("width")
    private final Integer width;

    public static final class a implements Parcelable.Creator<FrameInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FrameInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = Integer.valueOf(r100.readInt());
        L11:
            return new FrameInfo(r102, r101);
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FrameInfo[] newArray(int r100) {
            return new FrameInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FrameInfo) == true) goto L8;
        return false;
    L8:
        FrameInfo r101 = (FrameInfo) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.width;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.height;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FrameInfo(width=" + this.width + ", height=" + this.height + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r102 = this.width;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.height;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final Integer a() {
        return this.height;
    }

    public FrameInfo(Integer r100, Integer r101) {
        this.width = r100;
        this.height = r101;
    }
}
