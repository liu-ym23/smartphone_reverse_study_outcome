package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ,\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", IFlowAppIntentIDL.PARAM_APPLET_ID, "", ComplianceResult.JsonKey.PERMISSIONS, "", "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemCheckPermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemCheckPermissionsParams> CREATOR = null;
    private String appletId;
    private Permission[] permissions;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemCheckPermissionsParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Permission[] r103 = null;
        L9:
            SystemCheckPermissionsParams r104 = new SystemCheckPermissionsParams(r102, r103);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L10:
            if (r107 > r105) goto L12;
            r107 = r107 + 1;
        L12:
            if (r107 > r101) goto L14;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L12
        L14:
            return r104;
        L5:
            int r108 = r100.readInt();
            Permission[] r109 = new Permission[r108];
            int r110 = 0;
        L6:
            if (r110 == r108) goto L8;
            r109[r110] = Permission.CREATOR.createFromParcel(r100);
            r110 = r110 + 1;
            goto L6
        L8:
            r103 = r109;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SystemCheckPermissionsParams[] newArray(int r100) {
            return new SystemCheckPermissionsParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemCheckPermissionsParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemCheckPermissionsParams copy$default(SystemCheckPermissionsParams r100, String r101, Permission[] r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appletId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.permissions;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.appletId;
    }

    public final Permission[] component2() {
        return this.permissions;
    }

    public final SystemCheckPermissionsParams copy(String r100, Permission[] r101) {
        return new SystemCheckPermissionsParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemCheckPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemCheckPermissionsParams r101 = (SystemCheckPermissionsParams) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permissions, r101.permissions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Permission[] r104 = this.permissions;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemCheckPermissionsParams(appletId=" + this.appletId + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.appletId);
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

    public final String getAppletId() {
        return this.appletId;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemCheckPermissionsParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.appletId;
        if (r101 != null) goto L8;
        r101 = ((SystemCheckPermissionsParams) r100).appletId;
    L8:
        Permission[] r102 = this.permissions;
        if (r102 != null) goto L12;
        r102 = ((SystemCheckPermissionsParams) r100).permissions;
    L12:
        return new SystemCheckPermissionsParams(r101, r102);
    }

    public final void setAppletId(String r100) {
        this.appletId = r100;
    }

    public final void setPermissions(Permission[] r100) {
        this.permissions = r100;
    }

    public SystemCheckPermissionsParams(String r100, Permission[] r101) {
        this.appletId = r100;
        this.permissions = r101;
    }

    public /* synthetic */ SystemCheckPermissionsParams(String r100, Permission[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
