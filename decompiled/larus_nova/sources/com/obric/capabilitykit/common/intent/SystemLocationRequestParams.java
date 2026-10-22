package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "needHighPrecision", "", "timeout", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getNeedHighPrecision", "()Ljava/lang/Boolean;", "setNeedHighPrecision", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTimeout", "()Ljava/lang/Long;", "setTimeout", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemLocationRequestParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemLocationRequestParams> CREATOR = null;
    private Boolean needHighPrecision;
    private Long timeout;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<SystemLocationRequestParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SystemLocationRequestParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r102 = 1;
            Long r103 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r104 = null;
        L11:
            if (r100.readInt() == 0) goto L14;
            r103 = Long.valueOf(r100.readLong());
        L14:
            SystemLocationRequestParams r105 = new SystemLocationRequestParams(r104, r103);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
        L15:
            if (r102 > r106) goto L17;
            r102 = r102 + 1;
        L17:
            if (r102 > r101) goto L19;
            joa.a.d(r100, r107);
            r102 = r102 + 1;
            goto L17
        L19:
            return r105;
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r108 = true;
        L9:
            r104 = Boolean.valueOf(r108);
            goto L11
        L8:
            r108 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final SystemLocationRequestParams[] newArray(int r100) {
            return new SystemLocationRequestParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemLocationRequestParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemLocationRequestParams copy$default(SystemLocationRequestParams r100, Boolean r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.needHighPrecision;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.timeout;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.needHighPrecision;
    }

    public final Long component2() {
        return this.timeout;
    }

    public final SystemLocationRequestParams copy(Boolean r100, Long r101) {
        return new SystemLocationRequestParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SystemLocationRequestParams) == true) goto L8;
        return false;
    L8:
        SystemLocationRequestParams r101 = (SystemLocationRequestParams) r100;
        if (Intrinsics.areEqual(this.needHighPrecision, r101.needHighPrecision) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeout, r101.timeout) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Boolean r100 = this.needHighPrecision;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.timeout;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemLocationRequestParams(needHighPrecision=" + this.needHighPrecision + ", timeout=" + this.timeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Boolean r102 = this.needHighPrecision;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.timeout;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public final Boolean getNeedHighPrecision() {
        return this.needHighPrecision;
    }

    public final Long getTimeout() {
        return this.timeout;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof SystemLocationRequestParams) == true) goto L5;
        return this;
    L5:
        Boolean r101 = this.needHighPrecision;
        if (r101 != null) goto L8;
        r101 = ((SystemLocationRequestParams) r100).needHighPrecision;
    L8:
        Long r102 = this.timeout;
        if (r102 != null) goto L12;
        r102 = ((SystemLocationRequestParams) r100).timeout;
    L12:
        return new SystemLocationRequestParams(r101, r102);
    }

    public final void setNeedHighPrecision(Boolean r100) {
        this.needHighPrecision = r100;
    }

    public final void setTimeout(Long r100) {
        this.timeout = r100;
    }

    public SystemLocationRequestParams(Boolean r100, Long r101) {
        this.needHighPrecision = r100;
        this.timeout = r101;
    }

    public /* synthetic */ SystemLocationRequestParams(Boolean r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
