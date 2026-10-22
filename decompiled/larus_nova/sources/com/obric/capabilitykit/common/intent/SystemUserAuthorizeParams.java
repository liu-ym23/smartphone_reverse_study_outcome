package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eHÖ\u0001R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserAuthorizeParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "scene", "", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "getScene", "()Ljava/lang/String;", "setScene", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserAuthorizeParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserAuthorizeParams> CREATOR = null;
    String scene;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemUserAuthorizeParams> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemUserAuthorizeParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemUserAuthorizeParams r102 = new SystemUserAuthorizeParams(null, 1, 0 == true ? 1 : 0);
            int r103 = Math.min(r101, 1);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L9;
            if (r105 != 1) goto L8;
            Object r106 = joa.a.c(r100, r104);
            if (r106 == null) goto L8;
            r102.scene = (String) r106;
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
        public final SystemUserAuthorizeParams[] newArray(int r100) {
            return new SystemUserAuthorizeParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserAuthorizeParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserAuthorizeParams copy$default(SystemUserAuthorizeParams r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        return r100.copy(r101);
    }

    public static /* synthetic */ void getScene$annotations() {
    }

    public final String component1() {
        return this.scene;
    }

    public final SystemUserAuthorizeParams copy(String r100) {
        return new SystemUserAuthorizeParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemUserAuthorizeParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.scene, ((SystemUserAuthorizeParams) r100).scene) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.scene;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemUserAuthorizeParams(scene=" + this.scene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeValue(this.scene);
    }

    public String getSubActionValue() {
        String r100 = this.scene;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    public final String getScene() {
        return this.scene;
    }

    public SystemUserAuthorizeParams(String r100) {
        this.scene = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemUserAuthorizeParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.scene;
        if (r101 != null) goto L9;
        r101 = ((SystemUserAuthorizeParams) r100).scene;
    L9:
        return new SystemUserAuthorizeParams(r101);
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public /* synthetic */ SystemUserAuthorizeParams(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
