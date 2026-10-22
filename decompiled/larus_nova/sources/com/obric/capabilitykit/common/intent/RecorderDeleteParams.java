package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0019HÖ\u0001J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "deleteAll", "", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)V", "getDeleteAll", "()Ljava/lang/Boolean;", "setDeleteAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;)V", "[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "describeContents", "", "equals", "other", "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecorderDeleteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<RecorderDeleteParams> CREATOR = null;
    private Boolean deleteAll;
    private RecordingEntity[] targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<RecorderDeleteParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            RecordingEntity[] r103 = null;
        L8:
            int r104 = 1;
            if (r100.readInt() != 0) goto L12;
        L16:
            RecorderDeleteParams r105 = new RecorderDeleteParams(r103, r102);
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
            r103 = new RecordingEntity[r109];
            int r110 = 0;
        L6:
            if (r110 == r109) goto L8;
            r103[r110] = (RecordingEntity) r100.readParcelable(RecorderDeleteParams.class.getClassLoader());
            r110 = r110 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final RecorderDeleteParams[] newArray(int r100) {
            return new RecorderDeleteParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecorderDeleteParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecorderDeleteParams copy$default(RecorderDeleteParams r100, RecordingEntity[] r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.deleteAll;
    L9:
        return r100.copy(r101, r102);
    }

    public final RecordingEntity[] component1() {
        return this.targets;
    }

    public final Boolean component2() {
        return this.deleteAll;
    }

    public final RecorderDeleteParams copy(RecordingEntity[] r100, Boolean r101) {
        return new RecorderDeleteParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecorderDeleteParams) == true) goto L8;
        return false;
    L8:
        RecorderDeleteParams r101 = (RecorderDeleteParams) r100;
        if (Intrinsics.areEqual(this.targets, r101.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deleteAll, r101.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        RecordingEntity[] r100 = this.targets;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.deleteAll;
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
        return "RecorderDeleteParams(targets=" + Arrays.toString(this.targets) + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        RecordingEntity[] r102 = this.targets;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L8:
        Boolean r103 = this.deleteAll;
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

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }

    public final Boolean getDeleteAll() {
        return this.deleteAll;
    }

    public final RecordingEntity[] getTargets() {
        return this.targets;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof RecorderDeleteParams) == true) goto L5;
        return this;
    L5:
        RecordingEntity[] r101 = this.targets;
        if (r101 != null) goto L8;
        r101 = ((RecorderDeleteParams) r100).targets;
    L8:
        Boolean r102 = this.deleteAll;
        if (r102 != null) goto L12;
        r102 = ((RecorderDeleteParams) r100).deleteAll;
    L12:
        return new RecorderDeleteParams(r101, r102);
    }

    public final void setDeleteAll(Boolean r100) {
        this.deleteAll = r100;
    }

    public final void setTargets(RecordingEntity[] r100) {
        this.targets = r100;
    }

    public RecorderDeleteParams(RecordingEntity[] r100, Boolean r101) {
        this.targets = r100;
        this.deleteAll = r101;
    }

    public /* synthetic */ RecorderDeleteParams(RecordingEntity[] r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
