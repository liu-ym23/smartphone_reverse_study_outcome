package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/AssistantQuResult;", "Landroid/os/Parcelable;", SlcCommonAction.KEY_ACTIONS, "", "Lcom/obric/memorydata/sdk/entity/search/QuAction;", "<init>", "(Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActions", "()Ljava/util/List;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistantQuResult implements Parcelable {
    public static final a CREATOR = null;
    private final List<QuAction> actions;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<AssistantQuResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AssistantQuResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AssistantQuResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AssistantQuResult[] newArray(int r100) {
            return new AssistantQuResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssistantQuResult copy$default(AssistantQuResult r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.actions;
    L6:
        return r100.copy(r101);
    }

    public final List<QuAction> component1() {
        return this.actions;
    }

    public final AssistantQuResult copy(List<QuAction> r100) {
        return new AssistantQuResult(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AssistantQuResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.actions, ((AssistantQuResult) r100).actions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<QuAction> r100 = this.actions;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "AssistantQuResult(actions=" + this.actions + ')';
    }

    public final List<QuAction> getActions() {
        return this.actions;
    }

    public AssistantQuResult(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this(r100.createTypedArrayList(QuAction.CREATOR));
    }

    public AssistantQuResult(List<QuAction> r100) {
        this.actions = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeTypedList(this.actions);
    }
}
