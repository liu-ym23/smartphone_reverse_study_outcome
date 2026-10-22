package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessRegisterRequest;", "Landroid/os/Parcelable;", "subscriptionId", "", PickerReporterConstants.KEY.TARGET, "Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "condition", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;)V", "getSubscriptionId", "()Ljava/lang/String;", "getTarget", "()Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "getCondition", "()Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentAwarenessRegisterRequest implements Parcelable {
    public static final Parcelable.Creator<PersistentAwarenessRegisterRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AwarenessTarget f397101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AwarenessConditionConfig f397102c;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PersistentAwarenessRegisterRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessRegisterRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PersistentAwarenessRegisterRequest(r100.readString(), AwarenessTarget.CREATOR.createFromParcel(r100), AwarenessConditionConfig.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessRegisterRequest[] newArray(int r100) {
            return new PersistentAwarenessRegisterRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PersistentAwarenessRegisterRequest) == true) goto L8;
        return false;
    L8:
        PersistentAwarenessRegisterRequest r101 = (PersistentAwarenessRegisterRequest) r100;
        if (Intrinsics.areEqual(this.f397100a, r101.f397100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397101b, r101.f397101b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397102c, r101.f397102c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f397100a.hashCode() * 31) + this.f397101b.hashCode()) * 31) + this.f397102c.hashCode();
    }

    public final String toString() {
        return "PersistentAwarenessRegisterRequest(subscriptionId=" + this.f397100a + ", target=" + this.f397101b + ", condition=" + this.f397102c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397100a);
        this.f397101b.writeToParcel(r100, r101);
        this.f397102c.writeToParcel(r100, r101);
    }

    public PersistentAwarenessRegisterRequest(String r100, AwarenessTarget r101, AwarenessConditionConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "subscriptionId");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "condition");
        this.f397100a = r100;
        this.f397101b = r101;
        this.f397102c = r102;
    }
}
