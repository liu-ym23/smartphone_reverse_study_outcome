package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "Landroid/os/Parcelable;", "name", "", "address", "batteryLevel", "", "deviceClass", "majorDeviceClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;II)V", "getName", "()Ljava/lang/String;", "getAddress", "getBatteryLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeviceClass", "()I", "getMajorDeviceClass", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;II)Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BluetoothDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<BluetoothDeviceInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f397134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f397135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f397136e;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<BluetoothDeviceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            return new BluetoothDeviceInfo(r101, r102, r103, r100.readInt(), r100.readInt());
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo[] newArray(int r100) {
            return new BluetoothDeviceInfo[r100];
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
        if ((r100 instanceof BluetoothDeviceInfo) == true) goto L8;
        return false;
    L8:
        BluetoothDeviceInfo r101 = (BluetoothDeviceInfo) r100;
        if (Intrinsics.areEqual(this.f397132a, r101.f397132a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397133b, r101.f397133b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397134c, r101.f397134c) == true) goto L18;
        return false;
    L18:
        if (this.f397135d == r101.f397135d) goto L21;
        return false;
    L21:
        if (this.f397136e == r101.f397136e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f397132a.hashCode() * 31) + this.f397133b.hashCode()) * 31;
        Integer r101 = this.f397134c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f397135d) * 31) + this.f397136e;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BluetoothDeviceInfo(name=" + this.f397132a + ", address=" + this.f397133b + ", batteryLevel=" + this.f397134c + ", deviceClass=" + this.f397135d + ", majorDeviceClass=" + this.f397136e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397132a);
        r100.writeString(this.f397133b);
        Integer r102 = this.f397134c;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        r100.writeInt(this.f397135d);
        r100.writeInt(this.f397136e);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public BluetoothDeviceInfo(String r100, String r101, Integer r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "address");
        this.f397132a = r100;
        this.f397133b = r101;
        this.f397134c = r102;
        this.f397135d = r103;
        this.f397136e = r104;
    }
}
