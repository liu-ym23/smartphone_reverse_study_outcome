package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "instantMessagingType", "", "instantMessagingAccount", "(Ljava/lang/String;Ljava/lang/String;)V", "getInstantMessagingAccount", "()Ljava/lang/String;", "getInstantMessagingType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaInstantMessaging extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String instantMessagingAccount;
    private final String instantMessagingType;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaInstantMessaging> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MetaInstantMessaging(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging[] newArray(int r100) {
            return new MetaInstantMessaging[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaInstantMessaging(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(EntityExtKt.e(r100), EntityExtKt.e(r100));
        readMetaValueExtensionField$capabilitykitcommon_release(r100, 0, r100.readInt());
    }

    public MetaInstantMessaging(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "instantMessagingType");
        Intrinsics.checkNotNullParameter(r101, "instantMessagingAccount");
        super(10018);
        this.instantMessagingType = r100;
        this.instantMessagingAccount = r101;
    }

    public static /* synthetic */ MetaInstantMessaging copy$default(MetaInstantMessaging r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.instantMessagingType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.instantMessagingAccount;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.instantMessagingType;
    }

    public final String component2() {
        return this.instantMessagingAccount;
    }

    public final MetaInstantMessaging copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "instantMessagingType");
        Intrinsics.checkNotNullParameter(r101, "instantMessagingAccount");
        return new MetaInstantMessaging(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MetaInstantMessaging) == true) goto L8;
        return false;
    L8:
        MetaInstantMessaging r101 = (MetaInstantMessaging) r100;
        if (Intrinsics.areEqual(this.instantMessagingType, r101.instantMessagingType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instantMessagingAccount, r101.instantMessagingAccount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getInstantMessagingAccount() {
        return this.instantMessagingAccount;
    }

    public final String getInstantMessagingType() {
        return this.instantMessagingType;
    }

    public int hashCode() {
        return (this.instantMessagingType.hashCode() * 31) + this.instantMessagingAccount.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaInstantMessaging(instantMessagingType=" + this.instantMessagingType + ", instantMessagingAccount=" + this.instantMessagingAccount + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.instantMessagingType);
        r100.writeString(this.instantMessagingAccount);
        r100.writeInt(0);
    }
}
