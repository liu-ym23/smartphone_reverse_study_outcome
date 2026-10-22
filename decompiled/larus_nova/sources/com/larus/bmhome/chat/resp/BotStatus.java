package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/resp/BotStatus;", "Landroid/os/Parcelable;", "heatScore", "", "displayHeatScore", "", "<init>", "(JLjava/lang/String;)V", "getHeatScore", "()J", "getDisplayHeatScore", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotStatus implements Parcelable {
    public static final Parcelable.Creator<BotStatus> CREATOR = null;

    @SerializedName("display_heat_score")
    private final String displayHeatScore;

    @SerializedName("heat_score")
    private final long heatScore;

    public static final class a implements Parcelable.Creator<BotStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotStatus createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new BotStatus(r100.readLong(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BotStatus[] newArray(int r100) {
            return new BotStatus[r100];
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
        if ((r100 instanceof BotStatus) == true) goto L8;
        return false;
    L8:
        BotStatus r101 = (BotStatus) r100;
        if (this.heatScore == r101.heatScore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayHeatScore, r101.displayHeatScore) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.heatScore;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.displayHeatScore;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "BotStatus(heatScore=" + this.heatScore + ", displayHeatScore=" + this.displayHeatScore + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.heatScore);
        r100.writeString(this.displayHeatScore);
    }

    public BotStatus() {
        this(0, "");
    }

    public BotStatus(long r100, String r101) {
        this.heatScore = r100;
        this.displayHeatScore = r101;
    }
}
