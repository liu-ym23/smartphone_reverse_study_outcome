package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "resumeAll", "", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)V", "getResumeAll", "()Ljava/lang/Boolean;", "setResumeAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;)V", "[Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/CountdownEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ClockResumeCountdownParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockResumeCountdownParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ClockResumeCountdownParams> CREATOR = null;
    private Boolean resumeAll;
    private CountdownEntity[] targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ClockResumeCountdownParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClockResumeCountdownParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            CountdownEntity[] r103 = null;
        L8:
            int r104 = 1;
            if (r100.readInt() != 0) goto L12;
        L16:
            ClockResumeCountdownParams r105 = new ClockResumeCountdownParams(r103, r102);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
        L17:
            if (r104 > r106) goto L19;
            r104 = r104 + 1;
        L19:
            if (r104 > r101) goto L21;
            joa.a.d(r100, r107);
            r104 = r104 + 1;
            goto L19
        L21:
            return r105;
        L12:
            if (r100.readInt() == 0) goto L14;
            boolean r108 = true;
        L15:
            r102 = Boolean.valueOf(r108);
            goto L16
        L14:
            r108 = false;
            goto L15
        L5:
            int r109 = r100.readInt();
            r103 = new CountdownEntity[r109];
            int r110 = 0;
        L6:
            if (r110 == r109) goto L8;
            r103[r110] = (CountdownEntity) r100.readParcelable(ClockResumeCountdownParams.class.getClassLoader());
            r110 = r110 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ClockResumeCountdownParams[] newArray(int r100) {
            return new ClockResumeCountdownParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClockResumeCountdownParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClockResumeCountdownParams copy$default(ClockResumeCountdownParams r100, CountdownEntity[] r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.resumeAll;
    L9:
        return r100.copy(r101, r102);
    }

    public final CountdownEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.resumeAll;
    }

    public final ClockResumeCountdownParams copy(CountdownEntity[] r100, Boolean r101) {
        return new ClockResumeCountdownParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClockResumeCountdownParams) == true) goto L8;
        return false;
    L8:
        ClockResumeCountdownParams r101 = (ClockResumeCountdownParams) r100;
        if (Intrinsics.areEqual(this.targets, r101.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resumeAll, r101.resumeAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        CountdownEntity[] r100 = this.targets;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.resumeAll;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "ClockResumeCountdownParams(targets=" + Arrays.toString(this.targets) + ", resumeAll=" + this.resumeAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        CountdownEntity[] r102 = this.targets;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L8:
        Boolean r103 = this.resumeAll;
        if (r103 != null) goto L11;
        r100.writeInt(0);
        return;
    L11:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r102.length;
        r100.writeInt(r104);
        int r105 = 0;
    L6:
        if (r105 == r104) goto L8;
        r100.writeParcelable(r102[r105], r101);
        r105 = r105 + 1;
        goto L6
    }

    public final Boolean getResumeAll() {
        return this.resumeAll;
    }

    public final CountdownEntity[] getTargets() {
        return this.targets;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof ClockResumeCountdownParams) == true) goto L5;
        return this;
    L5:
        CountdownEntity[] r101 = this.targets;
        if (r101 != null) goto L8;
        r101 = ((ClockResumeCountdownParams) r100).targets;
    L8:
        Boolean r102 = this.resumeAll;
        if (r102 != null) goto L12;
        r102 = ((ClockResumeCountdownParams) r100).resumeAll;
    L12:
        return new ClockResumeCountdownParams(r101, r102);
    }

    public final void setResumeAll(Boolean r100) {
        this.resumeAll = r100;
    }

    public final void setTargets(CountdownEntity[] r100) {
        this.targets = r100;
    }

    public ClockResumeCountdownParams(CountdownEntity[] r100, Boolean r101) {
        this.targets = r100;
        this.resumeAll = r101;
    }

    public /* synthetic */ ClockResumeCountdownParams(CountdownEntity[] r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
