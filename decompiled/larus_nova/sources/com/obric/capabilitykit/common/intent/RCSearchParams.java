package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RCSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "featureParam", "", "(Ljava/lang/String;)V", "getFeatureParam", "()Ljava/lang/String;", "setFeatureParam", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RCSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<RCSearchParams> CREATOR = null;
    private String featureParam;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<RCSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RCSearchParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            RCSearchParams r102 = new RCSearchParams(r100.readString());
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
        public final RCSearchParams[] newArray(int r100) {
            return new RCSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RCSearchParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RCSearchParams copy$default(RCSearchParams r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.featureParam;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.featureParam;
    }

    public final RCSearchParams copy(String r100) {
        return new RCSearchParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RCSearchParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.featureParam, ((RCSearchParams) r100).featureParam) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.featureParam;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "RCSearchParams(featureParam=" + this.featureParam + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.featureParam);
    }

    public String getSubActionValue() {
        String r100 = this.featureParam;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100;
    }

    public boolean isParamsCompleted() {
        if (this.featureParam == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getFeatureParam() {
        return this.featureParam;
    }

    public RCSearchParams(String r100) {
        this.featureParam = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof RCSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.featureParam;
        if (r101 != null) goto L9;
        r101 = ((RCSearchParams) r100).featureParam;
    L9:
        return new RCSearchParams(r101);
    }

    public final void setFeatureParam(String r100) {
        this.featureParam = r100;
    }

    public /* synthetic */ RCSearchParams(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
