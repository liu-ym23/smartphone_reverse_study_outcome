package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessCallback;", "Landroid/os/Parcelable;", "subscriptionId", "", PickerReporterConstants.KEY.TARGET, "Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", WsConstants.KEY_PAYLOAD, "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;Landroid/os/Bundle;)V", "getSubscriptionId", "()Ljava/lang/String;", "getTarget", "()Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "getPayload", "()Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentAwarenessCallback implements Parcelable {
    public static final Parcelable.Creator<PersistentAwarenessCallback> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AwarenessTarget f397098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f397099c;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PersistentAwarenessCallback> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessCallback createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PersistentAwarenessCallback(r100.readString(), AwarenessTarget.CREATOR.createFromParcel(r100), r100.readBundle(PersistentAwarenessCallback.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final PersistentAwarenessCallback[] newArray(int r100) {
            return new PersistentAwarenessCallback[r100];
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
        if ((r100 instanceof PersistentAwarenessCallback) == true) goto L8;
        return false;
    L8:
        PersistentAwarenessCallback r101 = (PersistentAwarenessCallback) r100;
        if (Intrinsics.areEqual(this.f397097a, r101.f397097a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397098b, r101.f397098b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397099c, r101.f397099c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f397097a.hashCode() * 31) + this.f397098b.hashCode()) * 31) + this.f397099c.hashCode();
    }

    public final String toString() {
        return "PersistentAwarenessCallback(subscriptionId=" + this.f397097a + ", target=" + this.f397098b + ", payload=" + this.f397099c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397097a);
        this.f397098b.writeToParcel(r100, r101);
        r100.writeBundle(this.f397099c);
    }

    public PersistentAwarenessCallback(String r100, AwarenessTarget r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "subscriptionId");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        this.f397097a = r100;
        this.f397098b = r101;
        this.f397099c = r102;
    }
}
