package com.larus.camera.impl.edulibs.cameraapi;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0005J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Landroid/os/Parcelable;", "isPass", "", "failReason", "", "detectTime", "", "<init>", "(ZIJ)V", "()Z", "getFailReason", "()I", "getDetectTime", "()J", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentifyDetectionResult implements Parcelable {
    public static final Parcelable.Creator<IdentifyDetectionResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f321696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f321697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f321698c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<IdentifyDetectionResult> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final IdentifyDetectionResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new IdentifyDetectionResult(r101, r100.readInt(), r100.readLong());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final IdentifyDetectionResult[] newArray(int r100) {
            return new IdentifyDetectionResult[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    public IdentifyDetectionResult() {
        this(0, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IdentifyDetectionResult) == true) goto L8;
        return false;
    L8:
        IdentifyDetectionResult r101 = (IdentifyDetectionResult) r100;
        if (this.f321696a == r101.f321696a) goto L12;
        return false;
    L12:
        if (this.f321697b == r101.f321697b) goto L15;
        return false;
    L15:
        if (this.f321698c == r101.f321698c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f321696a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f321697b) * 31;
        long r102 = this.f321698c;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "IdentifyDetectionResult(isPass=" + this.f321696a + ", failReason=" + this.f321697b + ", detectTime=" + this.f321698c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f321696a ? 1 : 0);
        r100.writeInt(this.f321697b);
        r100.writeLong(this.f321698c);
    }

    public /* synthetic */ IdentifyDetectionResult(long r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 4) == 0) goto L9;
        r100 = 0;
    L9:
        this(r102, 0, r100);
        return;
    L5:
        r102 = false;
        goto L7
    }

    public IdentifyDetectionResult(boolean r100, int r101, long r102) {
        this.f321696a = r100;
        this.f321697b = r101;
        this.f321698c = r102;
    }
}
