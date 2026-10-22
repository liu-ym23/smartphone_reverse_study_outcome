package com.larus.dora.impl.device.settings.camera.timeoptions;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0005J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionModel;", "Landroid/os/Parcelable;", "title", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeOptionModel implements Parcelable {
    public static final Parcelable.Creator<TimeOptionModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f334292b;

    public static final class a implements Parcelable.Creator<TimeOptionModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimeOptionModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TimeOptionModel(r100.readString(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeOptionModel[] newArray(int r100) {
            return new TimeOptionModel[r100];
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
        if ((r100 instanceof TimeOptionModel) == true) goto L8;
        return false;
    L8:
        TimeOptionModel r101 = (TimeOptionModel) r100;
        if (Intrinsics.areEqual(this.f334291a, r101.f334291a) == true) goto L12;
        return false;
    L12:
        if (this.f334292b == r101.f334292b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f334291a.hashCode() * 31) + this.f334292b;
    }

    public final String toString() {
        return "TimeOptionModel(title=" + this.f334291a + ", value=" + this.f334292b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f334291a);
        r100.writeInt(this.f334292b);
    }

    public TimeOptionModel(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f334291a = r100;
        this.f334292b = r101;
    }
}
