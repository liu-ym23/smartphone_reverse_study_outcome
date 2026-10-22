package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\u0012\u0010)\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010'H\u0016J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "title", "", "content", "options", "", "Lcom/obric/capabilitykit/common/intent/Options;", ComplianceResult.JsonKey.PERMISSIONS, "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getOptions", "()[Lcom/obric/capabilitykit/common/intent/Options;", "setOptions", "([Lcom/obric/capabilitykit/common/intent/Options;)V", "[Lcom/obric/capabilitykit/common/intent/Options;", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "getTitle", d.f25925o, "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Options;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemRequestPermissionsParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemRequestPermissionsParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemRequestPermissionsParams> CREATOR = null;
    private String content;
    private Options[] options;
    private Permission[] permissions;
    private String title;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemRequestPermissionsParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            Permission[] r103 = null;
            if (r110.readInt() != 0) goto L5;
            Options[] r104 = null;
        L9:
            if (r110.readInt() == 0) goto L14;
            int r105 = r110.readInt();
            r103 = new Permission[r105];
            int r106 = 0;
        L12:
            if (r106 == r105) goto L14;
            r103[r106] = Permission.CREATOR.createFromParcel(r110);
            r106 = r106 + 1;
        L14:
            SystemRequestPermissionsParams r107 = new SystemRequestPermissionsParams(r101, r102, r104, r103);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r111 = 1;
        L15:
            if (r111 > r108) goto L17;
            r111 = r111 + 1;
        L17:
            if (r111 > r100) goto L19;
            joa.a.d(r110, r109);
            r111 = r111 + 1;
            goto L17
        L19:
            return r107;
        L5:
            int r112 = r110.readInt();
            r104 = new Options[r112];
            int r113 = 0;
        L6:
            if (r113 == r112) goto L9;
            r104[r113] = Options.CREATOR.createFromParcel(r110);
            r113 = r113 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SystemRequestPermissionsParams[] newArray(int r100) {
            return new SystemRequestPermissionsParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemRequestPermissionsParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SystemRequestPermissionsParams copy$default(SystemRequestPermissionsParams r100, String r101, String r102, Options[] r103, Permission[] r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.options;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.permissions;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final Options[] component3() {
        return this.options;
    }

    public final Permission[] component4() {
        return this.permissions;
    }

    public final SystemRequestPermissionsParams copy(String r100, String r101, Options[] r102, Permission[] r103) {
        return new SystemRequestPermissionsParams(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemRequestPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemRequestPermissionsParams r101 = (SystemRequestPermissionsParams) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.options, r101.options) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.permissions, r101.permissions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Options[] r107 = this.options;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Permission[] r110 = this.permissions;
        if (r110 == null) goto L19;
        r101 = Arrays.hashCode(r110);
    L19:
        return r109 + r101;
    L13:
        r108 = Arrays.hashCode(r107);
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemRequestPermissionsParams(title=" + this.title + ", content=" + this.content + ", options=" + Arrays.toString(this.options) + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.title);
        r100.writeString(this.content);
        Options[] r103 = this.options;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L8:
        Permission[] r104 = this.permissions;
        if (r104 != null) goto L11;
        r100.writeInt(0);
        return;
    L11:
        r100.writeInt(1);
        int r105 = r104.length;
        r100.writeInt(r105);
    L12:
        if (r102 == r105) goto L17;
        r104[r102].writeToParcel(r100, r101);
        r102 = r102 + 1;
        goto L12
    L17:
        return;
    L5:
        r100.writeInt(1);
        int r106 = r103.length;
        r100.writeInt(r106);
        int r107 = 0;
    L6:
        if (r107 == r106) goto L8;
        r103[r107].writeToParcel(r100, r101);
        r107 = r107 + 1;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final Options[] getOptions() {
        return this.options;
    }

    public final Permission[] getPermissions() {
        return this.permissions;
    }

    public final String getTitle() {
        return this.title;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemRequestPermissionsParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.title;
        if (r101 != null) goto L8;
        r101 = ((SystemRequestPermissionsParams) r100).title;
    L8:
        String r102 = this.content;
        if (r102 != null) goto L11;
        r102 = ((SystemRequestPermissionsParams) r100).content;
    L11:
        Options[] r103 = this.options;
        if (r103 != null) goto L14;
        r103 = ((SystemRequestPermissionsParams) r100).options;
    L14:
        Permission[] r104 = this.permissions;
        if (r104 != null) goto L18;
        r104 = ((SystemRequestPermissionsParams) r100).permissions;
    L18:
        return new SystemRequestPermissionsParams(r101, r102, r103, r104);
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setOptions(Options[] r100) {
        this.options = r100;
    }

    public final void setPermissions(Permission[] r100) {
        this.permissions = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public SystemRequestPermissionsParams(String r100, String r101, Options[] r102, Permission[] r103) {
        this.title = r100;
        this.content = r101;
        this.options = r102;
        this.permissions = r103;
    }

    public /* synthetic */ SystemRequestPermissionsParams(String r100, String r101, Options[] r102, Permission[] r103, int r104, DefaultConstructorMarker r105) {
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
