package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "Landroid/os/Parcelable;", "outputWidth", "", "outputHeight", "qp", "downScalePreference", "<init>", "(IIII)V", "getOutputWidth", "()I", "getOutputHeight", "getQp", "getDownScalePreference", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeifOutputOption implements Parcelable {
    public static final Parcelable.Creator<HeifOutputOption> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f397269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f397270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f397271d;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<HeifOutputOption> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HeifOutputOption createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new HeifOutputOption(r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final HeifOutputOption[] newArray(int r100) {
            return new HeifOutputOption[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public HeifOutputOption() {
        this(0, 0, 35, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeifOutputOption) == true) goto L8;
        return false;
    L8:
        HeifOutputOption r101 = (HeifOutputOption) r100;
        if (this.f397268a == r101.f397268a) goto L12;
        return false;
    L12:
        if (this.f397269b == r101.f397269b) goto L15;
        return false;
    L15:
        if (this.f397270c == r101.f397270c) goto L18;
        return false;
    L18:
        if (this.f397271d == r101.f397271d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f397268a * 31) + this.f397269b) * 31) + this.f397270c) * 31) + this.f397271d;
    }

    public final String toString() {
        return "HeifOutputOption(outputWidth=" + this.f397268a + ", outputHeight=" + this.f397269b + ", qp=" + this.f397270c + ", downScalePreference=" + this.f397271d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f397268a);
        r100.writeInt(this.f397269b);
        r100.writeInt(this.f397270c);
        r100.writeInt(this.f397271d);
    }

    public HeifOutputOption(int r100, int r101, int r102, int r103) {
        this.f397268a = r100;
        this.f397269b = r101;
        this.f397270c = r102;
        this.f397271d = r103;
    }
}
