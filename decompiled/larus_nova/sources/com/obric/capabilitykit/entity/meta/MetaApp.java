package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J'\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0010¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0018H\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaApp;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appName", "", "packageName", "installed", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getAppName", "()Ljava/lang/String;", "getInstalled", "()Z", "getPackageName", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaApp extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String appName;
    private final boolean installed;
    private final String packageName;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaApp$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaApp;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaApp;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaApp> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaApp createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new MetaApp(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaApp createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaApp[] newArray(int r100) {
            return new MetaApp[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaApp[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaApp(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(EntityExtKt.e(r100), EntityExtKt.e(r100), r100.readBoolean());
        readMetaValueExtensionField$capabilitykitcommon_release(r100, 0, r100.readInt());
    }

    public MetaApp(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "appName");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        super(10003);
        this.appName = r100;
        this.packageName = r101;
        this.installed = r102;
    }

    public /* synthetic */ MetaApp(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }

    public static /* synthetic */ MetaApp copy$default(MetaApp r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.appName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.packageName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.installed;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final boolean component3() {
        return this.installed;
    }

    public final MetaApp copy(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "appName");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        return new MetaApp(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MetaApp) == true) goto L8;
        return false;
    L8:
        MetaApp r101 = (MetaApp) r100;
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (this.installed == r101.installed) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r100 = ((this.appName.hashCode() * 31) + this.packageName.hashCode()) * 31;
        boolean r101 = this.installed;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaApp(appName=" + this.appName + ", packageName=" + this.packageName + ", installed=" + this.installed + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.appName);
        r100.writeString(this.packageName);
        r100.writeBoolean(this.installed);
        r100.writeInt(0);
    }
}
