package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "Landroid/os/Parcelable;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TouchInfo implements Parcelable {
    public static final Parcelable.Creator<TouchInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f397251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f397252b;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements Parcelable.Creator<TouchInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final TouchInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TouchInfo(r100.readFloat(), r100.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final TouchInfo[] newArray(int r100) {
            return new TouchInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TouchInfo) == true) goto L8;
        return false;
    L8:
        TouchInfo r101 = (TouchInfo) r100;
        if (Float.compare(this.f397251a, r101.f397251a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f397252b, r101.f397252b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f397251a) * 31) + Float.floatToIntBits(this.f397252b);
    }

    public final String toString() {
        return "TouchInfo(x=" + this.f397251a + ", y=" + this.f397252b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeFloat(this.f397251a);
        r100.writeFloat(this.f397252b);
    }

    public TouchInfo(float r100, float r101) {
        this.f397251a = r100;
        this.f397252b = r101;
    }
}
