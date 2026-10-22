package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017JJ\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\u0012\u0010-\u001a\u00020\u00012\b\u0010.\u001a\u0004\u0018\u00010+H\u0016J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0013\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R(\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "isSystemApp", "", "proceed", "operateType", "", "updateRange", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setSystemApp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOperateType$annotations", "()V", "getOperateType", "()Ljava/lang/Integer;", "setOperateType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProceed$annotations", "getProceed", "setProceed", "getUpdateRange$annotations", "getUpdateRange", "setUpdateRange", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/SystemDownloadAppParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemDownloadAppParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemDownloadAppParams> CREATOR = null;
    private String appName;
    private Boolean isSystemApp;
    Integer operateType;
    Boolean proceed;
    Integer updateRange;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemDownloadAppParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L7;
            Boolean r102 = null;
        L11:
            SystemDownloadAppParams r103 = new SystemDownloadAppParams(r101, r102, null, null, null, 28, null);
            int r104 = Math.min(r100, 3);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L12:
            if (r106 > r104) goto L27;
            if (r106 != 1) goto L18;
            Object r107 = joa.a.c(r110, r105);
            if (r107 == null) goto L26;
            r103.proceed = (Boolean) r107;
        L26:
            r106 = r106 + 1;
            goto L12
        L18:
            if (r106 != 2) goto L22;
            Object r108 = joa.a.c(r110, r105);
            if (r108 == null) goto L26;
            r103.operateType = (Integer) r108;
            goto L26
        L22:
            if (r106 != 3) goto L26;
            Object r109 = joa.a.c(r110, r105);
            if (r109 == null) goto L26;
            r103.updateRange = (Integer) r109;
        L27:
            if (r106 > r100) goto L29;
            joa.a.d(r110, r105);
            r106 = r106 + 1;
            goto L27
        L29:
            return r103;
        L7:
            if (r110.readInt() == 0) goto L9;
            boolean r111 = true;
        L10:
            r102 = Boolean.valueOf(r111);
            goto L11
        L9:
            r111 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final SystemDownloadAppParams[] newArray(int r100) {
            return new SystemDownloadAppParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemDownloadAppParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SystemDownloadAppParams copy$default(SystemDownloadAppParams r100, String r101, Boolean r102, Boolean r103, Integer r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.appName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.isSystemApp;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.proceed;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.operateType;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.updateRange;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public static /* synthetic */ void getOperateType$annotations() {
    }

    public static /* synthetic */ void getProceed$annotations() {
    }

    public static /* synthetic */ void getUpdateRange$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final Boolean component2() {
        return this.isSystemApp;
    }

    public final Boolean component3() {
        return this.proceed;
    }

    public final Integer component4() {
        return this.operateType;
    }

    public final Integer component5() {
        return this.updateRange;
    }

    public final SystemDownloadAppParams copy(String r100, Boolean r101, Boolean r110, Integer r111, Integer r112) {
        return new SystemDownloadAppParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemDownloadAppParams) == true) goto L8;
        return false;
    L8:
        SystemDownloadAppParams r101 = (SystemDownloadAppParams) r100;
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSystemApp, r101.isSystemApp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.proceed, r101.proceed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.operateType, r101.operateType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateRange, r101.updateRange) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.appName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isSystemApp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.proceed;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.operateType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.updateRange;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemDownloadAppParams(appName=" + this.appName + ", isSystemApp=" + this.isSystemApp + ", proceed=" + this.proceed + ", operateType=" + this.operateType + ", updateRange=" + this.updateRange + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(3);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.appName);
        Boolean r102 = this.isSystemApp;
        if (r102 != null) goto L6;
        ?? r103 = 0;
    L5:
        r100.writeInt(r103);
        r100.writeValue(this.proceed);
        r100.writeValue(this.operateType);
        r100.writeValue(this.updateRange);
        return;
    L6:
        r100.writeInt(1);
        r103 = r102.booleanValue();
        goto L5
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Integer getOperateType() {
        return this.operateType;
    }

    public final Boolean getProceed() {
        return this.proceed;
    }

    public final Integer getUpdateRange() {
        return this.updateRange;
    }

    public final Boolean isSystemApp() {
        return this.isSystemApp;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemDownloadAppParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.appName;
        if (r101 != null) goto L8;
        r101 = ((SystemDownloadAppParams) r100).appName;
    L8:
        String r102 = r101;
        Boolean r103 = this.isSystemApp;
        if (r103 != null) goto L11;
        r103 = ((SystemDownloadAppParams) r100).isSystemApp;
    L11:
        Boolean r104 = r103;
        Boolean r105 = this.proceed;
        if (r105 != null) goto L14;
        r105 = ((SystemDownloadAppParams) r100).proceed;
    L14:
        Boolean r106 = r105;
        Integer r107 = this.operateType;
        if (r107 != null) goto L17;
        r107 = ((SystemDownloadAppParams) r100).operateType;
    L17:
        Integer r108 = r107;
        Integer r109 = this.updateRange;
        if (r109 != null) goto L20;
        Integer r110 = ((SystemDownloadAppParams) r100).updateRange;
    L22:
        return new SystemDownloadAppParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setOperateType(Integer r100) {
        this.operateType = r100;
    }

    public final void setProceed(Boolean r100) {
        this.proceed = r100;
    }

    public final void setSystemApp(Boolean r100) {
        this.isSystemApp = r100;
    }

    public final void setUpdateRange(Integer r100) {
        this.updateRange = r100;
    }

    public SystemDownloadAppParams(String r100, Boolean r101, Boolean r102, Integer r103, Integer r104) {
        this.appName = r100;
        this.isSystemApp = r101;
        this.proceed = r102;
        this.operateType = r103;
        this.updateRange = r104;
    }

    public /* synthetic */ SystemDownloadAppParams(String r100, Boolean r101, Boolean r102, Integer r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Boolean r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
