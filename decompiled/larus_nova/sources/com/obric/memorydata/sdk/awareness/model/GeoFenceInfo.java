package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/GeoFenceInfo;", "Landroid/os/Parcelable;", "fenceId", "", "<init>", "(Ljava/lang/String;)V", "getFenceId", "()Ljava/lang/String;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeoFenceInfo implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("fence_id")
    private final String fenceId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<GeoFenceInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GeoFenceInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            int r102 = 0;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            GeoFenceInfo r104 = null;
            Object r105 = null;
            if (r103 == false) goto L31;
        L28:
            if (r104 == null) goto L30;
            return r104;
        L30:
            return new GeoFenceInfo(r102);
        L31:
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
            GeoFenceInfo r107 = (GeoFenceInfo) qka.a.f533688a.fromJson(r101, GeoFenceInfo.class);     // Catch: Throwable -> L21
            if (r107 != null) goto L15;
            GeoFenceInfo r108 = null;
        L19:
            Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L21
        L24:
            if (Result.m9455isFailureimpl(r109) == true) goto L27;
            r105 = r109;
        L27:
            r104 = (GeoFenceInfo) r105;
            goto L28
        L15:
            String r110 = r107.a();     // Catch: Throwable -> L21
            if (r110 != null) goto L18;
            r110 = "";
        L18:
            r108 = new GeoFenceInfo(r110);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L24
        L5:
            if (StringsKt.isBlank(r101) == true) goto L8;
            r103 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final GeoFenceInfo[] newArray(int r100) {
            return new GeoFenceInfo[r100];
        }
    }

    public GeoFenceInfo() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GeoFenceInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fenceId, ((GeoFenceInfo) r100).fenceId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.fenceId.hashCode();
    }

    public final String toString() {
        return "GeoFenceInfo(fenceId=" + this.fenceId + ')';
    }

    static {
        CREATOR = new a();
    }

    public final String a() {
        return this.fenceId;
    }

    public GeoFenceInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fenceId");
        this.fenceId = r100;
    }

    public /* synthetic */ GeoFenceInfo(int r100) {
        this("");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(qka.a.f533688a, this));
    }
}
