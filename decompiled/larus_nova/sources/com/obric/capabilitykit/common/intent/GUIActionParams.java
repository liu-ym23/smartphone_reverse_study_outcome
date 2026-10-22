package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/GUIActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "step", "", "uniqueId", "ext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getStep", "setStep", "getUniqueId", "setUniqueId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GUIActionParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<GUIActionParams> CREATOR = null;
    private String ext;
    private String step;
    private String uniqueId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GUIActionParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GUIActionParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            GUIActionParams r102 = new GUIActionParams(r100.readString(), r100.readString(), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final GUIActionParams[] newArray(int r100) {
            return new GUIActionParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public GUIActionParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GUIActionParams copy$default(GUIActionParams r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.step;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.uniqueId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ext;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.step;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final String component3() {
        return this.ext;
    }

    public final GUIActionParams copy(String r100, String r101, String r102) {
        return new GUIActionParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GUIActionParams) == true) goto L8;
        return false;
    L8:
        GUIActionParams r101 = (GUIActionParams) r100;
        if (Intrinsics.areEqual(this.step, r101.step) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.step;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uniqueId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ext;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GUIActionParams(step=" + this.step + ", uniqueId=" + this.uniqueId + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.step);
        r100.writeString(this.uniqueId);
        r100.writeString(this.ext);
    }

    public boolean isParamsCompleted() {
        if (this.step == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getStep() {
        return this.step;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof GUIActionParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.step;
        if (r101 != null) goto L8;
        r101 = ((GUIActionParams) r100).step;
    L8:
        String r102 = this.uniqueId;
        if (r102 != null) goto L11;
        r102 = ((GUIActionParams) r100).uniqueId;
    L11:
        String r103 = this.ext;
        if (r103 != null) goto L15;
        r103 = ((GUIActionParams) r100).ext;
    L15:
        return new GUIActionParams(r101, r102, r103);
    }

    public final void setExt(String r100) {
        this.ext = r100;
    }

    public final void setStep(String r100) {
        this.step = r100;
    }

    public final void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public GUIActionParams(String r100, String r101, String r102) {
        this.step = r100;
        this.uniqueId = r101;
        this.ext = r102;
    }

    public /* synthetic */ GUIActionParams(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
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
