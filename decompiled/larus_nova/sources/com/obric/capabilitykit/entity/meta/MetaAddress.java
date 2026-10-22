package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "address", "", "addressType", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAddressType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaAddress extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String address;
    private final String addressType;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaAddress$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaAddress> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAddress createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MetaAddress(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAddress createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAddress[] newArray(int r100) {
            return new MetaAddress[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAddress[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaAddress(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(EntityExtKt.e(r100), r100.readString());
        readMetaValueExtensionField$capabilitykitcommon_release(r100, 0, r100.readInt());
    }

    public MetaAddress(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "address");
        super(10001);
        this.address = r100;
        this.addressType = r101;
    }

    public /* synthetic */ MetaAddress(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public static /* synthetic */ MetaAddress copy$default(MetaAddress r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.address;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.addressType;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.addressType;
    }

    public final MetaAddress copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "address");
        return new MetaAddress(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MetaAddress) == true) goto L8;
        return false;
    L8:
        MetaAddress r101 = (MetaAddress) r100;
        if (Intrinsics.areEqual(this.address, r101.address) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.addressType, r101.addressType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    public int hashCode() {
        int r100 = this.address.hashCode() * 31;
        String r101 = this.addressType;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaAddress(address=" + this.address + ", addressType=" + this.addressType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.address);
        r100.writeString(this.addressType);
        r100.writeInt(0);
    }
}
