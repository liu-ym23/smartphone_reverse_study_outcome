package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemSetBrightnessParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "level", "", "(Ljava/lang/Integer;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/SystemSetBrightnessParams;", "describeContents", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemSetBrightnessParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemSetBrightnessParams> CREATOR = null;
    private Integer level;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemSetBrightnessParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemSetBrightnessParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L6:
            SystemSetBrightnessParams r103 = new SystemSetBrightnessParams(r102);
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L7:
            if (r106 > r104) goto L9;
            r106 = r106 + 1;
        L9:
            if (r106 > r101) goto L11;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L9
        L11:
            return r103;
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SystemSetBrightnessParams[] newArray(int r100) {
            return new SystemSetBrightnessParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemSetBrightnessParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemSetBrightnessParams copy$default(SystemSetBrightnessParams r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.level;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.level;
    }

    public final SystemSetBrightnessParams copy(Integer r100) {
        return new SystemSetBrightnessParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemSetBrightnessParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.level, ((SystemSetBrightnessParams) r100).level) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r100 = this.level;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "SystemSetBrightnessParams(level=" + this.level + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r103 = this.level;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
    }

    public boolean isParamsCompleted() {
        if (this.level == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public SystemSetBrightnessParams(Integer r100) {
        this.level = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemSetBrightnessParams) == true) goto L5;
        return this;
    L5:
        Integer r101 = this.level;
        if (r101 != null) goto L9;
        r101 = ((SystemSetBrightnessParams) r100).level;
    L9:
        return new SystemSetBrightnessParams(r101);
    }

    public final void setLevel(Integer r100) {
        this.level = r100;
    }

    public /* synthetic */ SystemSetBrightnessParams(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
