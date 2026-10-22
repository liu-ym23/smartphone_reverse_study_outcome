package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\bJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/Permission;", "Landroid/os/Parcelable;", "type", "", "granted", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "confirmMode", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getType", "()Ljava/lang/String;", "getGranted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppletId", "getConfirmMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/aiagent/assistant/idl/bean/Permission;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = null;
    private final String appletId;
    private final Integer confirmMode;
    private final Boolean granted;
    private final String type;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<Permission> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Permission createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            Integer r102 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L10:
            String r104 = r100.readString();
            if (r100.readInt() == 0) goto L15;
            r102 = Integer.valueOf(r100.readInt());
        L15:
            return new Permission(r101, r103, r104, r102);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r105 = true;
        L9:
            r103 = Boolean.valueOf(r105);
            goto L10
        L8:
            r105 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final Permission[] newArray(int r100) {
            return new Permission[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public Permission() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Permission copy$default(Permission r100, String r101, Boolean r102, String r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.granted;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.appletId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.confirmMode;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.type;
    }

    public final Boolean component2() {
        return this.granted;
    }

    public final String component3() {
        return this.appletId;
    }

    public final Integer component4() {
        return this.confirmMode;
    }

    public final Permission copy(String r100, Boolean r101, String r102, Integer r103) {
        return new Permission(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Permission) == true) goto L8;
        return false;
    L8:
        Permission r101 = (Permission) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.granted, r101.granted) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmMode, r101.confirmMode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.granted;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.appletId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.confirmMode;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "Permission(type=" + this.type + ", granted=" + this.granted + ", appletId=" + this.appletId + ", confirmMode=" + this.confirmMode + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.type);
        Boolean r102 = this.granted;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.appletId);
        Integer r103 = this.confirmMode;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Integer getConfirmMode() {
        return this.confirmMode;
    }

    public final Boolean getGranted() {
        return this.granted;
    }

    public final String getType() {
        return this.type;
    }

    public Permission(String r100, Boolean r101, String r102, Integer r103) {
        this.type = r100;
        this.granted = r101;
        this.appletId = r102;
        this.confirmMode = r103;
    }

    public /* synthetic */ Permission(String r100, Boolean r101, String r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
