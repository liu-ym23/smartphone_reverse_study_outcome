package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "([Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;)V", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "setTargets", "[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "component1", "copy", "([Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;)Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneDeleteParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneDeleteParams> CREATOR = null;
    private CallHistoryEntity[] targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhoneDeleteParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneDeleteParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            CallHistoryEntity[] r102 = null;
        L9:
            PhoneDeleteParams r103 = new PhoneDeleteParams(r102);
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L10:
            if (r106 > r104) goto L12;
            r106 = r106 + 1;
        L12:
            if (r106 > r101) goto L14;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L12
        L14:
            return r103;
        L5:
            int r107 = r100.readInt();
            CallHistoryEntity[] r108 = new CallHistoryEntity[r107];
            int r109 = 0;
        L6:
            if (r109 == r107) goto L8;
            r108[r109] = (CallHistoryEntity) r100.readParcelable(PhoneDeleteParams.class.getClassLoader());
            r109 = r109 + 1;
            goto L6
        L8:
            r102 = r108;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final PhoneDeleteParams[] newArray(int r100) {
            return new PhoneDeleteParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhoneDeleteParams copy$default(PhoneDeleteParams r100, CallHistoryEntity[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        return r100.copy(r101);
    }

    public final CallHistoryEntity[] component1() {
        return this.targets;
    }

    public final PhoneDeleteParams copy(CallHistoryEntity[] r100) {
        return new PhoneDeleteParams(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhoneDeleteParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.targets, ((PhoneDeleteParams) r100).targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        CallHistoryEntity[] r100 = this.targets;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r100);
    }

    public String toString() {
        return "PhoneDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        CallHistoryEntity[] r103 = this.targets;
        if (r103 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L10;
        r100.writeParcelable(r103[r102], r101);
        r102 = r102 + 1;
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final CallHistoryEntity[] getTargets() {
        return this.targets;
    }

    public PhoneDeleteParams(CallHistoryEntity[] r100) {
        this.targets = r100;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhoneDeleteParams) == true) goto L5;
        return this;
    L5:
        CallHistoryEntity[] r101 = this.targets;
        if (r101 != null) goto L9;
        r101 = ((PhoneDeleteParams) r100).targets;
    L9:
        return new PhoneDeleteParams(r101);
    }

    public final void setTargets(CallHistoryEntity[] r100) {
        this.targets = r100;
    }

    public /* synthetic */ PhoneDeleteParams(CallHistoryEntity[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
