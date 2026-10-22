package com.ss.android.lark.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/api/bean/ForsetiNodeSize;", "Landroid/os/Parcelable;", "width", "Lcom/ss/android/lark/api/bean/ForsetiWidth;", "<init>", "(Lcom/ss/android/lark/api/bean/ForsetiWidth;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getWidth", "()Lcom/ss/android/lark/api/bean/ForsetiWidth;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNodeSize implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForsetiWidth f408650a;

    public static final class a implements Parcelable.Creator<ForsetiNodeSize> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiNodeSize createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForsetiWidth r101 = (ForsetiWidth) r100.readParcelable(ForsetiWidth.class.getClassLoader());
            if (r101 != null) goto L6;
            r101 = ForsetiWidth.AVERAGE_LEVEL;
        L6:
            return new ForsetiNodeSize(r101);
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiNodeSize[] newArray(int r100) {
            return new ForsetiNodeSize[r100];
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
        if ((r100 instanceof ForsetiNodeSize) == true) goto L9;
        return false;
    L9:
        if (this.f408650a == ((ForsetiNodeSize) r100).f408650a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f408650a.hashCode();
    }

    public final String toString() {
        return "ForsetiNodeSize(width=" + this.f408650a + ')';
    }

    public ForsetiNodeSize() {
        this(ForsetiWidth.AVERAGE_LEVEL);
    }

    public ForsetiNodeSize(ForsetiWidth r100) {
        Intrinsics.checkNotNullParameter(r100, "width");
        this.f408650a = r100;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.f408650a, r101);
    }
}
