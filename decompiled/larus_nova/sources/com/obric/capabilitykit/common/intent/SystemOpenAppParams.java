package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0019\u001a\u00020\u0013HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemOpenAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "(Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppletId$annotations", "()V", "getAppletId", "setAppletId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemOpenAppParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemOpenAppParams> CREATOR = null;
    private String appName;
    String appletId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemOpenAppParams> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemOpenAppParams r102 = new SystemOpenAppParams(r100.readString(), null, 2, 0 == true ? 1 : 0);
            int r103 = Math.min(r101, 1);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L9;
            if (r105 != 1) goto L8;
            Object r106 = joa.a.c(r100, r104);
            if (r106 == null) goto L8;
            r102.appletId = (String) r106;
        L8:
            r105 = r105 + 1;
        L9:
            if (r105 > r101) goto L11;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L9
        L11:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams[] newArray(int r100) {
            return new SystemOpenAppParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenAppParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemOpenAppParams copy$default(SystemOpenAppParams r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.appletId;
    L9:
        return r100.copy(r101, r102);
    }

    public static /* synthetic */ void getAppletId$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appletId;
    }

    public final SystemOpenAppParams copy(String r100, String r101) {
        return new SystemOpenAppParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemOpenAppParams) == true) goto L8;
        return false;
    L8:
        SystemOpenAppParams r101 = (SystemOpenAppParams) r100;
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.appName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.appletId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemOpenAppParams(appName=" + this.appName + ", appletId=" + this.appletId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.appName);
        r100.writeValue(this.appletId);
    }

    public String getSubActionValue() {
        String r100 = this.appName;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    public boolean isParamsCompleted() {
        if (this.appName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemOpenAppParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.appName;
        if (r101 != null) goto L8;
        r101 = ((SystemOpenAppParams) r100).appName;
    L8:
        String r102 = this.appletId;
        if (r102 != null) goto L12;
        r102 = ((SystemOpenAppParams) r100).appletId;
    L12:
        return new SystemOpenAppParams(r101, r102);
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setAppletId(String r100) {
        this.appletId = r100;
    }

    public SystemOpenAppParams(String r100, String r101) {
        this.appName = r100;
        this.appletId = r101;
    }

    public /* synthetic */ SystemOpenAppParams(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
