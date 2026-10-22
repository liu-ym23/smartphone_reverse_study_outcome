package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "candidate", "", "", "type", "sourceIntent", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCandidate", "()[Ljava/lang/String;", "setCandidate", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getSourceIntent$annotations", "()V", "getSourceIntent", "()Ljava/lang/String;", "setSourceIntent", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemUserSelectParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemUserSelectParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemUserSelectParams> CREATOR = null;
    private String[] candidate;
    String sourceIntent;
    private String type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemUserSelectParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemUserSelectParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SystemUserSelectParams r102 = new SystemUserSelectParams(r100.createStringArray(), r100.readString(), null, 4, null);
            int r103 = Math.min(r101, 1);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L9;
            if (r105 != 1) goto L8;
            Object r106 = joa.a.c(r100, r104);
            if (r106 == null) goto L8;
            r102.sourceIntent = (String) r106;
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
        public final SystemUserSelectParams[] newArray(int r100) {
            return new SystemUserSelectParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SystemUserSelectParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemUserSelectParams copy$default(SystemUserSelectParams r100, String[] r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.candidate;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.sourceIntent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public static /* synthetic */ void getSourceIntent$annotations() {
    }

    public final String[] component1() {
        return this.candidate;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final SystemUserSelectParams copy(String[] r100, String r101, String r102) {
        return new SystemUserSelectParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemUserSelectParams) == true) goto L8;
        return false;
    L8:
        SystemUserSelectParams r101 = (SystemUserSelectParams) r100;
        if (Intrinsics.areEqual(this.candidate, r101.candidate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceIntent, r101.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String[] r100 = this.candidate;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sourceIntent;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public String toString() {
        return "SystemUserSelectParams(candidate=" + Arrays.toString(this.candidate) + ", type=" + this.type + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(1);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeStringArray(this.candidate);
        r100.writeString(this.type);
        r100.writeValue(this.sourceIntent);
    }

    public boolean isParamsCompleted() {
        if (this.candidate != null) goto L5;
    L9:
        return false;
    L5:
        if (this.type == null) goto L9;
        if (this.sourceIntent == null) goto L9;
        return true;
    }

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    public final String getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemUserSelectParams) == true) goto L5;
        return this;
    L5:
        String[] r101 = this.candidate;
        if (r101 != null) goto L8;
        r101 = ((SystemUserSelectParams) r100).candidate;
    L8:
        String r102 = this.type;
        if (r102 != null) goto L11;
        r102 = ((SystemUserSelectParams) r100).type;
    L11:
        String r103 = this.sourceIntent;
        if (r103 != null) goto L15;
        r103 = ((SystemUserSelectParams) r100).sourceIntent;
    L15:
        return new SystemUserSelectParams(r101, r102, r103);
    }

    public final void setCandidate(String[] r100) {
        this.candidate = r100;
    }

    public final void setSourceIntent(String r100) {
        this.sourceIntent = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public SystemUserSelectParams(String[] r100, String r101, String r102) {
        this.candidate = r100;
        this.type = r101;
        this.sourceIntent = r102;
    }

    public /* synthetic */ SystemUserSelectParams(String[] r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
