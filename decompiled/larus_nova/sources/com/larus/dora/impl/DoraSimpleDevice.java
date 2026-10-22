package com.larus.dora.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0007J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/DoraSimpleDevice;", "Landroid/os/Parcelable;", "name", "", "mac", "sn", ECPromotion.SKU, "", "type", "serialNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getMac", "getSn", "getSku", "()I", "getType", "getSerialNumber", "toDevice", "Lcom/bytedance/dora/device/DoraDevice;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSimpleDevice implements Parcelable {
    public static final Parcelable.Creator<DoraSimpleDevice> CREATOR = null;

    /* JADX INFO: renamed from: mac, reason: collision with root package name */
    private final String f331959mac;
    private final String name;
    private final String serialNumber;
    private final int sku;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    private final String f331960sn;
    private final int type;

    public static final class a implements Parcelable.Creator<DoraSimpleDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraSimpleDevice createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DoraSimpleDevice(r100.readString(), r100.readString(), r100.readString(), r100.readInt(), r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraSimpleDevice[] newArray(int r100) {
            return new DoraSimpleDevice[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ DoraSimpleDevice copy$default(DoraSimpleDevice r100, String r101, String r102, String r103, int r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f331959mac;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f331960sn;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.sku;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.type;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.serialNumber;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.f331959mac;
    }

    public final String component3() {
        return this.f331960sn;
    }

    public final int component4() {
        return this.sku;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.serialNumber;
    }

    public final DoraSimpleDevice copy(String r100, String r110, String r111, int r112, int r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r110, "mac");
        Intrinsics.checkNotNullParameter(r111, "sn");
        Intrinsics.checkNotNullParameter(r114, "serialNumber");
        return new DoraSimpleDevice(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoraSimpleDevice) == true) goto L8;
        return false;
    L8:
        DoraSimpleDevice r101 = (DoraSimpleDevice) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f331959mac, r101.f331959mac) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f331960sn, r101.f331960sn) == true) goto L18;
        return false;
    L18:
        if (this.sku == r101.sku) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.serialNumber, r101.serialNumber) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.f331959mac.hashCode()) * 31) + this.f331960sn.hashCode()) * 31) + this.sku) * 31) + this.type) * 31) + this.serialNumber.hashCode();
    }

    public String toString() {
        return "DoraSimpleDevice(name=" + this.name + ", mac=" + this.f331959mac + ", sn=" + this.f331960sn + ", sku=" + this.sku + ", type=" + this.type + ", serialNumber=" + this.serialNumber + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.name);
        r100.writeString(this.f331959mac);
        r100.writeString(this.f331960sn);
        r100.writeInt(this.sku);
        r100.writeInt(this.type);
        r100.writeString(this.serialNumber);
    }

    public final DoraDevice toDevice() {
        DoraDevice r100 = new DoraDevice();
        r100.name = this.name;
        r100.f204389mac = this.f331959mac;
        r100.f204390sn = this.f331960sn;
        r100.sku = this.sku;
        r100.type = this.type;
        return r100;
    }

    public final String getMac() {
        return this.f331959mac;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final int getSku() {
        return this.sku;
    }

    public final String getSn() {
        return this.f331960sn;
    }

    public final int getType() {
        return this.type;
    }

    public DoraSimpleDevice(String r100, String r101, String r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "mac");
        Intrinsics.checkNotNullParameter(r102, "sn");
        Intrinsics.checkNotNullParameter(r105, "serialNumber");
        this.name = r100;
        this.f331959mac = r101;
        this.f331960sn = r102;
        this.sku = r103;
        this.type = r104;
        this.serialNumber = r105;
    }
}
