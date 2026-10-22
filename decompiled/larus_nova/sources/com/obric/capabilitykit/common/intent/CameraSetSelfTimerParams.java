package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", UploadTypeInf.TIMER, "", "(Ljava/lang/Integer;)V", "getTimer", "()Ljava/lang/Integer;", "setTimer", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CameraSetSelfTimerParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetSelfTimerParams> CREATOR = null;
    private Integer timer;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CameraSetSelfTimerParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetSelfTimerParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L6:
            CameraSetSelfTimerParams r103 = new CameraSetSelfTimerParams(r102);
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
        public final CameraSetSelfTimerParams[] newArray(int r100) {
            return new CameraSetSelfTimerParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetSelfTimerParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetSelfTimerParams copy$default(CameraSetSelfTimerParams r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.timer;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.timer;
    }

    public final CameraSetSelfTimerParams copy(Integer r100) {
        return new CameraSetSelfTimerParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraSetSelfTimerParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.timer, ((CameraSetSelfTimerParams) r100).timer) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r100 = this.timer;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "CameraSetSelfTimerParams(timer=" + this.timer + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r103 = this.timer;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
    }

    public final Integer getTimer() {
        return this.timer;
    }

    public CameraSetSelfTimerParams(Integer r100) {
        this.timer = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof CameraSetSelfTimerParams) == true) goto L5;
        return this;
    L5:
        Integer r101 = this.timer;
        if (r101 != null) goto L9;
        r101 = ((CameraSetSelfTimerParams) r100).timer;
    L9:
        return new CameraSetSelfTimerParams(r101);
    }

    public final void setTimer(Integer r100) {
        this.timer = r100;
    }

    public /* synthetic */ CameraSetSelfTimerParams(Integer r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
