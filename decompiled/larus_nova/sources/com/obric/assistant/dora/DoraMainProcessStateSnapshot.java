package com.obric.assistant.dora;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/dora/DoraMainProcessStateSnapshot;", "Landroid/os/Parcelable;", "connectionState", "", "deviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "<init>", "(ILcom/obric/assistant/dora/DoraDeviceInfo;)V", "getConnectionState", "()I", "getDeviceInfo", "()Lcom/obric/assistant/dora/DoraDeviceInfo;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMainProcessStateSnapshot implements Parcelable {
    public static final Parcelable.Creator<DoraMainProcessStateSnapshot> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f389090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraDeviceInfo f389091b;

    public static final class a implements Parcelable.Creator<DoraMainProcessStateSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessStateSnapshot createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoraMainProcessStateSnapshot(r100.readInt(), DoraDeviceInfo.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final DoraMainProcessStateSnapshot[] newArray(int r100) {
            return new DoraMainProcessStateSnapshot[r100];
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
        if ((r100 instanceof DoraMainProcessStateSnapshot) == true) goto L8;
        return false;
    L8:
        DoraMainProcessStateSnapshot r101 = (DoraMainProcessStateSnapshot) r100;
        if (this.f389090a == r101.f389090a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f389091b, r101.f389091b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f389090a * 31) + this.f389091b.hashCode();
    }

    public final String toString() {
        return "DoraMainProcessStateSnapshot(connectionState=" + this.f389090a + ", deviceInfo=" + this.f389091b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f389090a);
        this.f389091b.writeToParcel(r100, r101);
    }

    public DoraMainProcessStateSnapshot() {
        this(0, new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383));
    }

    public DoraMainProcessStateSnapshot(int r100, DoraDeviceInfo r101) {
        Intrinsics.checkNotNullParameter(r101, "deviceInfo");
        this.f389090a = r100;
        this.f389091b = r101;
    }
}
