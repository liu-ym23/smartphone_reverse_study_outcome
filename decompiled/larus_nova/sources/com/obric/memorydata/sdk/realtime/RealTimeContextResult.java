package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", "Landroid/os/Parcelable;", "code", "", "errorMsg", "", "realTimeContext", "Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "<init>", "(ILjava/lang/String;Lcom/obric/memorydata/sdk/realtime/RealTimeContext;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getRealTimeContext", "()Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeContextResult implements Parcelable {
    public static final Parcelable.Creator<RealTimeContextResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f397199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RealTimeContext f397201c;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements Parcelable.Creator<RealTimeContextResult> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final RealTimeContextResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            RealTimeContext r103 = null;
        L7:
            return new RealTimeContextResult(r101, r102, r103);
        L5:
            r103 = RealTimeContext.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final RealTimeContextResult[] newArray(int r100) {
            return new RealTimeContextResult[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealTimeContextResult) == true) goto L8;
        return false;
    L8:
        RealTimeContextResult r101 = (RealTimeContextResult) r100;
        if (this.f397199a == r101.f397199a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397200b, r101.f397200b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397201c, r101.f397201c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f397199a * 31;
        String r101 = this.f397200b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RealTimeContext r105 = this.f397201c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RealTimeContextResult(code=" + this.f397199a + ", errorMsg=" + this.f397200b + ", realTimeContext=" + this.f397201c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f397199a);
        r100.writeString(this.f397200b);
        RealTimeContext r102 = this.f397201c;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public RealTimeContextResult(int r100, String r101, RealTimeContext r102) {
        this.f397199a = r100;
        this.f397200b = r101;
        this.f397201c = r102;
    }
}
