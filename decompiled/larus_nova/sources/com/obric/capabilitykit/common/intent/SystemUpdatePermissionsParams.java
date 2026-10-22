package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUpdatePermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", ComplianceResult.JsonKey.PERMISSIONS, "", "Lcom/obric/capabilitykit/common/intent/Permission;", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "[Lcom/obric/capabilitykit/common/intent/Permission;", "component1", "copy", "([Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemUpdatePermissionsParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUpdatePermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUpdatePermissionsParams> CREATOR = null;
    private Permission[] permissions;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemUpdatePermissionsParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemUpdatePermissionsParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Permission[] r102 = null;
        L9:
            SystemUpdatePermissionsParams r103 = new SystemUpdatePermissionsParams(r102);
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L10:
            if (r106 > r104) goto L12;
            r106 = r106 + 1;
        L12:
            if (r106 > r101) goto L14;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L12
        L14:
            return r103;
        L5:
            int r107 = r100.readInt();
            Permission[] r108 = new Permission[r107];
            int r109 = 0;
        L6:
            if (r109 == r107) goto L8;
            r108[r109] = Permission.CREATOR.createFromParcel(r100);
            r109 = r109 + 1;
            goto L6
        L8:
            r102 = r108;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SystemUpdatePermissionsParams[] newArray(int r100) {
            return new SystemUpdatePermissionsParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUpdatePermissionsParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUpdatePermissionsParams copy$default(SystemUpdatePermissionsParams r100, Permission[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.permissions;
    L6:
        return r100.copy(r101);
    }

    public final Permission[] component1() {
        return this.permissions;
    }

    public final SystemUpdatePermissionsParams copy(Permission[] r100) {
        return new SystemUpdatePermissionsParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemUpdatePermissionsParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.permissions, ((SystemUpdatePermissionsParams) r100).permissions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Permission[] r100 = this.permissions;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r100);
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemUpdatePermissionsParams(permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Permission[] r103 = this.permissions;
        if (r103 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L10;
        r103[r102].writeToParcel(r100, r101);
        r102 = r102 + 1;
        goto L6
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public SystemUpdatePermissionsParams(Permission[] r100) {
        this.permissions = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemUpdatePermissionsParams) == true) goto L5;
        return this;
    L5:
        Permission[] r101 = this.permissions;
        if (r101 != null) goto L9;
        r101 = ((SystemUpdatePermissionsParams) r100).permissions;
    L9:
        return new SystemUpdatePermissionsParams(r101);
    }

    public final void setPermissions(Permission[] r100) {
        this.permissions = r100;
    }

    public /* synthetic */ SystemUpdatePermissionsParams(Permission[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
