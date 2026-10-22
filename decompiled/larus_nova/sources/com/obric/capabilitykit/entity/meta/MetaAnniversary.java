package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "anniversaryName", "", "anniversaryDate", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnniversaryDate", "()Ljava/lang/String;", "getAnniversaryName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaAnniversary extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String anniversaryDate;
    private final String anniversaryName;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaAnniversary$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaAnniversary> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAnniversary createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MetaAnniversary(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAnniversary createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaAnniversary[] newArray(int r100) {
            return new MetaAnniversary[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaAnniversary[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaAnniversary(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(EntityExtKt.e(r100), EntityExtKt.e(r100));
        readMetaValueExtensionField$capabilitykitcommon_release(r100, 0, r100.readInt());
    }

    public MetaAnniversary(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "anniversaryName");
        Intrinsics.checkNotNullParameter(r101, "anniversaryDate");
        super(10002);
        this.anniversaryName = r100;
        this.anniversaryDate = r101;
    }

    public static /* synthetic */ MetaAnniversary copy$default(MetaAnniversary r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.anniversaryName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.anniversaryDate;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.anniversaryName;
    }

    public final String component2() {
        return this.anniversaryDate;
    }

    public final MetaAnniversary copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "anniversaryName");
        Intrinsics.checkNotNullParameter(r101, "anniversaryDate");
        return new MetaAnniversary(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MetaAnniversary) == true) goto L8;
        return false;
    L8:
        MetaAnniversary r101 = (MetaAnniversary) r100;
        if (Intrinsics.areEqual(this.anniversaryName, r101.anniversaryName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anniversaryDate, r101.anniversaryDate) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAnniversaryDate() {
        return this.anniversaryDate;
    }

    public final String getAnniversaryName() {
        return this.anniversaryName;
    }

    public int hashCode() {
        return (this.anniversaryName.hashCode() * 31) + this.anniversaryDate.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaAnniversary(anniversaryName=" + this.anniversaryName + ", anniversaryDate=" + this.anniversaryDate + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.anniversaryName);
        r100.writeString(this.anniversaryDate);
        r100.writeInt(0);
    }
}
